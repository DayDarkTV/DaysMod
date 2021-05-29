package com.daysportal.fabrictest.items;

import com.daysportal.fabrictest.Main;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemHandler {
    public static final ItemGroup DAYGROUP = Main.DAYGROUP;

    public static final Item RING = new DayRing(DAYGROUP);
    public static final Item RING2 = new DayRing(DAYGROUP);
    public static final Item RING3 = new DayRing(DAYGROUP);
    public static final Item RING4 = new DayRing(DAYGROUP);

    public ItemHandler() {
        registerItems();
    }

    private void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(Main.MODID, "ring"), RING);
        Registry.register(Registry.ITEM, new Identifier(Main.MODID, "ring2"), RING2);
        Registry.register(Registry.ITEM, new Identifier(Main.MODID, "ring3"), RING3);
        Registry.register(Registry.ITEM, new Identifier(Main.MODID, "ring4"), RING4);
    }
}
