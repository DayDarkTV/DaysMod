package com.daysportal.fabrictest.mixin.client.gui.hud;

import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(InGameHud.class)
abstract public class InGameHudMixin extends DrawableHelper {
    private static final Identifier BUCKET_BLUR = new Identifier("fabritest", "textures/misc/bucket_blur.png");
}
