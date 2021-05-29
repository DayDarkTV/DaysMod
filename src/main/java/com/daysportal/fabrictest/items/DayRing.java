package com.daysportal.fabrictest.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class DayRing extends Item {

    public DayRing(ItemGroup group) {
        super(new FabricItemSettings().group(group).maxCount(1));
    }

}
