package com.daysportal.fabrictest.blocks;

import com.daysportal.fabrictest.Main;
import com.daysportal.fabrictest.blocks.blockentity.CuppppBlockEntity;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;

public class BlockHandler {

    private static final ArrayList<String> WOODS = new ArrayList<>();

    public static final Block CUPPPP = new Block(FabricBlockSettings.of(Material.GLASS).strength(1.0f));
    public static final BlockEntityType SkullBlockEntityType = Registry.register(Registry.BLOCK_ENTITY_TYPE, Main.MODID.toLowerCase() + ":skull_block_entity", BlockEntityType.Builder.create(CuppppBlockEntity::new, CUPPPP).build(null));
    public static final Block EXAMPLE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f));
    public static final Block CHAIRRRRR = new chairrrrr(FabricBlockSettings.of(Material.WOOL).strength(0.8f));
    public static final Block OAK_CHAIRRRRR = new chairrrrr(FabricBlockSettings.of(Material.WOOD).strength(1.0f));
    public static final Block SPRUCE_CHAIRRRRR = new chairrrrr(FabricBlockSettings.of(Material.WOOD).strength(1.0f));
    public static final Block BIRCH_CHAIRRRRR = new chairrrrr(FabricBlockSettings.of(Material.WOOD).strength(1.0f));
    public static final Block JUNGLE_CHAIRRRRR = new chairrrrr(FabricBlockSettings.of(Material.WOOD).strength(1.0f));
    public static final Block ACACIA_CHAIRRRRR = new chairrrrr(FabricBlockSettings.of(Material.WOOD).strength(1.0f));
    public static final Block DARK_OAK_CHAIRRRRR = new chairrrrr(FabricBlockSettings.of(Material.WOOD).strength(1.0f));
    public static final Block WARPED_CHAIRRRRR = new chairrrrr(FabricBlockSettings.of(Material.WOOD).strength(1.0f));
    public static final Block CRIMSON_CHAIRRRRR = new chairrrrr(FabricBlockSettings.of(Material.WOOD).strength(1.0f));
    public static final Block TABLEE = new tablee(FabricBlockSettings.of(Material.WOOL).strength(0.8f));

    public BlockHandler() {
        registerWoods();
        registerBlocks();
        registerBlockItems();
        registerWoodBlocks();
    }
    private void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(Main.MODID, "example_block"), EXAMPLE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Main.MODID, "chairrrrr"), CHAIRRRRR);
        Registry.register(Registry.BLOCK, new Identifier(Main.MODID, "oak_chairrrrr"), OAK_CHAIRRRRR);
        Registry.register(Registry.BLOCK, new Identifier(Main.MODID, "spruce_chairrrrr"), SPRUCE_CHAIRRRRR);
        Registry.register(Registry.BLOCK, new Identifier(Main.MODID, "birch_chairrrrr"), BIRCH_CHAIRRRRR);
        Registry.register(Registry.BLOCK, new Identifier(Main.MODID, "jungle_chairrrrr"), JUNGLE_CHAIRRRRR);
        Registry.register(Registry.BLOCK, new Identifier(Main.MODID, "acacia_chairrrrr"), ACACIA_CHAIRRRRR);
        Registry.register(Registry.BLOCK, new Identifier(Main.MODID, "dark_oak_chairrrrr"), DARK_OAK_CHAIRRRRR);
        Registry.register(Registry.BLOCK, new Identifier(Main.MODID, "warped_chairrrrr"), WARPED_CHAIRRRRR);
        Registry.register(Registry.BLOCK, new Identifier(Main.MODID, "crimson_chairrrrr"), CRIMSON_CHAIRRRRR);
        Registry.register(Registry.BLOCK, new Identifier(Main.MODID, "tablee"), TABLEE);
        Registry.register(Registry.BLOCK, new Identifier(Main.MODID, "cupppp"), CUPPPP);
    }
    private void registerBlockItems() {
        Registry.register(Registry.ITEM, new Identifier(Main.MODID, "example_block"), new BlockItem(EXAMPLE_BLOCK, new FabricItemSettings().group(Main.DAYGROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MODID, "chairrrrr"), new BlockItem(CHAIRRRRR, new FabricItemSettings().group(Main.DAYGROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MODID, "oak_chairrrrr"), new BlockItem(OAK_CHAIRRRRR, new FabricItemSettings().group(Main.DAYGROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MODID, "spruce_chairrrrr"), new BlockItem(SPRUCE_CHAIRRRRR, new FabricItemSettings().group(Main.DAYGROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MODID, "birch_chairrrrr"), new BlockItem(BIRCH_CHAIRRRRR, new FabricItemSettings().group(Main.DAYGROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MODID, "jungle_chairrrrr"), new BlockItem(JUNGLE_CHAIRRRRR, new FabricItemSettings().group(Main.DAYGROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MODID, "acacia_chairrrrr"), new BlockItem(ACACIA_CHAIRRRRR, new FabricItemSettings().group(Main.DAYGROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MODID, "dark_oak_chairrrrr"), new BlockItem(DARK_OAK_CHAIRRRRR, new FabricItemSettings().group(Main.DAYGROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MODID, "warped_chairrrrr"), new BlockItem(WARPED_CHAIRRRRR, new FabricItemSettings().group(Main.DAYGROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MODID, "crimson_chairrrrr"), new BlockItem(CRIMSON_CHAIRRRRR, new FabricItemSettings().group(Main.DAYGROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MODID, "tablee"), new BlockItem(TABLEE, new FabricItemSettings().group(Main.DAYGROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MODID, "cupppp"), new BlockItem(CUPPPP, new FabricItemSettings().group(Main.DAYGROUP)));
    }
    private void registerWoodBlocks() {
        for (String wood : WOODS) {
            tablee table = new tablee(FabricBlockSettings.of(Material.WOOD).strength(1.0f));
            Registry.register(Registry.BLOCK, new Identifier(Main.MODID, wood.toLowerCase() + "_tablee"), table);
            Registry.register(Registry.ITEM, new Identifier(Main.MODID, wood.toLowerCase() + "_tablee"), new BlockItem(table, new FabricItemSettings().group(Main.DAYGROUP)));
        }
    }
    private void registerWoods() {
        WOODS.add("OAK");
        WOODS.add("SPRUCE");
        WOODS.add("BIRCH");
        WOODS.add("JUNGLE");
        WOODS.add("ACACIA");
        WOODS.add("DARK_OAK");
        WOODS.add("WARPED");
        WOODS.add("CRIMSON");
    }
}
