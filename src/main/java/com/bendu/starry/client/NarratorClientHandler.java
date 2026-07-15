package com.bendu.starry.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;

import net.minecraft.sounds.SoundSource;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = com.bendu.starry.StarryMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class NarratorClientHandler {
    private static NarratorLine pendingLine = null;
    private static int pendingDelay = 0;

    public static void scheduleNarrator(NarratorLine line, int delayTicks) {
        pendingLine = line;
        pendingDelay = Math.max(1, delayTicks);
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        NarratorOverlay.tick();

        if (pendingLine == null) return;

        pendingDelay--;
        if (pendingDelay > 0) return;

        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || mc.level == null) {
            pendingLine = null;
            return;
        }

        net.minecraft.client.resources.sounds.SimpleSoundInstance narratorSound = new SimpleSoundInstance(
            pendingLine.getSoundLocation(),
            SoundSource.VOICE,
            0.7f, 1.0f,
            mc.level.random,
            false, 0,
            SimpleSoundInstance.Attenuation.NONE,
            0, 0, 0,
            true
        );
        mc.getSoundManager().play(narratorSound);

        NarratorOverlay.showNarratorWithSound(
            Component.translatable(pendingLine.getSubtitleKey()),
            narratorSound
        );

        pendingLine = null;
    }

    @SubscribeEvent
    public static void onLogout(ClientPlayerNetworkEvent.LoggingOut event) {
        pendingLine = null;
        pendingDelay = 0;
    }
}