package com.daysportal.fabrictest;

import com.daysportal.fabrictest.blocks.BlockHandler;
import com.daysportal.fabrictest.blocks.CupBlock;
import com.daysportal.fabrictest.blocks.blockentity.CuppppBlockEntity;
import com.daysportal.fabrictest.entity.SitEntity;
import com.daysportal.fabrictest.items.ItemHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypeInfo;

public class Main implements ModInitializer {

    public static final ItemGroup DAYGROUP = FabricItemGroupBuilder.build(
            new Identifier(Main.MODID, "general"),
            () -> new ItemStack(Items.DIAMOND));

    public static final String MODID = "daysmod";
    public static Main INSTANCE;
    public static final EntityType<SitEntity> SIT_ENTITY_TYPE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(MODID, "sit"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, SitEntity::new).dimensions(EntityDimensions.fixed(0.001F, 0.001F)).build()
    );
    public static ItemHandler ih;
    public static BlockHandler bh;

    @Override
    public void onInitialize() {
        this.INSTANCE = this;
        System.out.println("Day's fabric mod has been initialized~!");
        ih = new ItemHandler();
        bh = new BlockHandler();
        CuriosApi.enqueueSlotType(SlotTypeInfo.BuildScheme.REGISTER, new SlotTypeInfo.Builder("ring").build());
    }

}
