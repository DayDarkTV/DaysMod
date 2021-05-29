package com.daysportal.fabrictest.blocks;

import com.daysportal.fabrictest.Main;
import com.daysportal.fabrictest.entity.SitEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class tablee extends Block {
    public static final BooleanProperty OCCUPIED;
    public tablee(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(OCCUPIED, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        VoxelShape top = VoxelShapes.cuboid(0f, 0.9375f, 0f, 1f, 1f, 1f);
        VoxelShape leg1 = VoxelShapes.cuboid(0.125f,0f,0.125f,0.1875f,0.9375f,0.1875f);
        VoxelShape leg2 = VoxelShapes.cuboid(0.8125f,0f,0.8125f,0.875f,0.9375f,0.875f);
        VoxelShape leg3 = VoxelShapes.cuboid(0.8125f,0f,0.125f,0.875f,0.9375f,0.1875f);
        VoxelShape leg4 = VoxelShapes.cuboid(0.125f,0f,0.8125f,0.1875f,0.9375f,0.875f);
        VoxelShape beam1 = VoxelShapes.cuboid(0.1875f, 0.625f, 0.125f, 0.8125f, 0.6875f, 0.1875f);
        VoxelShape beam2 = VoxelShapes.cuboid(0.125f, 0.625f, 0.1875f, 0.1875f, 0.6875f, 0.8125f);
        VoxelShape beam3 = VoxelShapes.cuboid(0.1875f, 0.625f, 0.8125f, 0.8125f, 0.6875f, 0.875f);
        VoxelShape beam4 = VoxelShapes.cuboid(0.8125f, 0.625f, 0.1875f, 0.875f, 0.6875f, 0.8125f);
        VoxelShape legs = VoxelShapes.union(VoxelShapes.union(leg1, leg2), VoxelShapes.union(leg3, leg4));
        VoxelShape beams = VoxelShapes.union(VoxelShapes.union(beam1, beam2), VoxelShapes.union(beam3, beam4));
        VoxelShape base = VoxelShapes.union(legs, beams);
        return VoxelShapes.union(top, base);
    }

    public ActionResult onUse(BlockState blockState, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockHitResult blockHitResult) {
        if (!blockState.get(OCCUPIED)) {
            SitEntity sit = Main.SIT_ENTITY_TYPE.create(world);
            Vec3d pos = new Vec3d(blockHitResult.getBlockPos().getX() + 0.5D, blockHitResult.getBlockPos().getY() + 0.9D, blockHitResult.getBlockPos().getZ() + 0.5D);
            world.setBlockState(blockPos, blockState.with(OCCUPIED, true));
            sit.updatePosition(pos.getX(), pos.getY(), pos.getZ());
            world.spawnEntity(sit);
            playerEntity.startRiding(sit);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.OCCUPIED);
    }

    static {
        OCCUPIED = Properties.OCCUPIED;
    }
}
