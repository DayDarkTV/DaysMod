package com.daysportal.fabrictest.blocks;

import com.daysportal.fabrictest.blocks.blockentity.CuppppBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class AbstractCuppppBlock extends BlockWithEntity {
    private final CupBlock.Liquid type;

    protected AbstractCuppppBlock(Settings settings, CupBlock.Liquid type) {
        super(settings);
        this.type = type;
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new CuppppBlockEntity();
    }

    @Environment(EnvType.CLIENT)
    public CupBlock.Liquid getLiquid() {
        return this.type;
    }

    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
}
