package com.daysportal.fabrictest.entity;

import com.daysportal.fabrictest.blocks.chairrrrr;
import com.daysportal.fabrictest.blocks.tablee;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Packet;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class SitEntity extends Entity {
    public SitEntity(EntityType<?> type, World world) {
        super(type, world);
        noClip = true;
    }

    @Override
    public Packet<?> createSpawnPacket() {
        return EntitySpawnPacketThingy.createPacket(this);
    }

    @Override
    protected void initDataTracker() {

    }

    @Override
    public void tick()
    {
        super.tick();

        if(!hasPassengers()||world.getBlockState(getBlockPos()).isAir())
        {
            Block block = world.getBlockState(getBlockPos()).getBlock();

            if (block instanceof chairrrrr) {
                chairrrrr cb = (chairrrrr) block;
                Direction facing = world.getBlockState(getBlockPos()).get(chairrrrr.FACING);
                world.setBlockState(getBlockPos(), cb.getDefaultState().with(chairrrrr.OCCUPIED, false).with(chairrrrr.FACING, facing));
            } else if (block instanceof tablee) {
                tablee tb = (tablee) block;
                world.setBlockState(getBlockPos(), tb.getDefaultState().with(tablee.OCCUPIED, false));
            }


            remove();
        }
    }

    @Override
    protected void readCustomDataFromTag(CompoundTag tag) {

    }

    @Override
    protected void writeCustomDataToTag(CompoundTag tag) {

    }

    @Override
    protected void removePassenger(Entity passenger) {
        BlockPos pos = this.getBlockPos();
        BlockState state = this.world.getBlockState(pos);
        if(state.getBlock() instanceof chairrrrr) {
            Direction d = state.get(chairrrrr.FACING);
            passenger.updatePosition(pos.getX() + d.getOffsetX() + 0.5D, pos.getY() + d.getOffsetY(), pos.getZ() + d.getOffsetZ() + 0.5D);
        } else if (state.getBlock() instanceof tablee) {
            passenger.updatePosition(pos.getX() + + 0.5D, pos.getY() + 1.5D, pos.getZ() + + 0.5D);
        }
        super.removePassenger(passenger);
    }

    @Override
    protected void addPassenger(Entity passenger) {
        BlockPos pos = this.getBlockPos();
        BlockState state = this.world.getBlockState(pos);
        if(state.getBlock() instanceof chairrrrr) {
            Direction d = state.get(chairrrrr.FACING);
            passenger.setYaw(d.getHorizontal() * 90F);
        } else if (state.getBlock() instanceof tablee) {
        }
        super.addPassenger(passenger);
    }
}
