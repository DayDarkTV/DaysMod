package com.daysportal.fabrictest.blocks.blockentity;

import com.daysportal.fabrictest.Main;
import com.daysportal.fabrictest.blocks.CupBlock;
import net.minecraft.block.entity.BlockEntity;

public class CuppppBlockEntity extends BlockEntity {
    private CupBlock.Liquid liquid;
    public CuppppBlockEntity() {
        super(Main.bh.SkullBlockEntityType);
    }
}
