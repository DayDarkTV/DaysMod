package com.daysportal.fabrictest;

import com.daysportal.fabrictest.entity.EntitySpawnPacketThingy;
import com.daysportal.fabrictest.entity.SitEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.util.Identifier;

public class Client implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(Main.SIT_ENTITY_TYPE, (entityRenderDispatcher, context) -> new EmptyRenderer(entityRenderDispatcher));
        registerClientBoundPackets();
    }
    private static class EmptyRenderer extends EntityRenderer<SitEntity> {
        protected EmptyRenderer(EntityRenderDispatcher entityRenderDispatcher)
        {
            super(entityRenderDispatcher);
        }

        @Override
        public boolean shouldRender(SitEntity entity, Frustum frustum, double d, double e, double f)
        {
            return false;
        }

        @Override
        public Identifier getTexture(SitEntity entity)
        {
            return null;
        }
    }
    public static void registerClientBoundPackets() {
        ClientSidePacketRegistry.INSTANCE.register(EntitySpawnPacketThingy.ID, EntitySpawnPacketThingy::onPacket);
    }
}
