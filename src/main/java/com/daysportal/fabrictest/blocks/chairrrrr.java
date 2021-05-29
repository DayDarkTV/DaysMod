package com.daysportal.fabrictest.blocks;

import com.daysportal.fabrictest.Main;
import com.daysportal.fabrictest.entity.SitEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class chairrrrr extends HorizontalFacingBlock {

    public static final BooleanProperty OCCUPIED;
    protected chairrrrr(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(OCCUPIED, false));
    }

    public ActionResult onUse(BlockState blockState, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockHitResult blockHitResult) {
        if (!blockState.get(OCCUPIED)) {
            SitEntity sit = Main.SIT_ENTITY_TYPE.create(world);
            Vec3d pos = new Vec3d(blockHitResult.getBlockPos().getX() + 0.5D, blockHitResult.getBlockPos().getY() + 0.45D, blockHitResult.getBlockPos().getZ() + 0.5D);
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
        stateManager.add(Properties.HORIZONTAL_FACING);
        stateManager.add(Properties.OCCUPIED);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        VoxelShape leg1 = VoxelShapes.cuboid(0.1875f, 0f, 0.1875f, 0.25f, 0.5625f, 0.25f);
        VoxelShape leg2 = VoxelShapes.cuboid(0.8125f, 0f, 0.1875f, 0.75f, 0.5625f, 0.25f);
        VoxelShape leg3 = VoxelShapes.cuboid(0.1875f, 0f, 0.8125f, 0.25f, 0.5625f, 0.75f);
        VoxelShape leg4 = VoxelShapes.cuboid(0.8125f, 0f, 0.8125f, 0.75f, 0.5625f, 0.75f);
        VoxelShape legs = VoxelShapes.union(VoxelShapes.union(leg1, leg2), VoxelShapes.union(leg3, leg4));
        VoxelShape seat = VoxelShapes.cuboid(0.1875f, 0.5625f, 0.1875f, 0.8125f, 0.625f, 0.8125f);
        VoxelShape base = VoxelShapes.union(legs, seat);
        VoxelShape back;
        Direction dir = state.get(FACING);
        switch (dir) {
            case NORTH:
                back = VoxelShapes.cuboid(0.1875f, 0.625f, 0.75f, 0.8125f, 1.25f, 0.8125f);
                break;
            case EAST:
                back = VoxelShapes.cuboid(0.1875f, 0.625f, 0.1875f, 0.25f, 1.25f, 0.8125f);//a
                break;
            case SOUTH:
                back = VoxelShapes.cuboid(0.1875f, 0.625f, 0.1875f, 0.8125f, 1.25f, 0.25f);//a
                break;
            case WEST:
                back = VoxelShapes.cuboid(0.75f, 0.625f, 0.1875f, 0.8125f, 1.25f, 0.8125f);
                break;
            default:
                back = VoxelShapes.empty();
                break;
        }
        return VoxelShapes.union(base, back);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    }

    static {
        OCCUPIED = Properties.OCCUPIED;
    }
}
