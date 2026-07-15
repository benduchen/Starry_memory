package com.bendu.starry.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = com.bendu.starry.StarryMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class NarratorOverlay {
    private static Component currentMessage = null;
    private static int displayTimer = 0;
    private static int displayTicks = 0;
    private static SimpleSoundInstance activeSound = null;
    private static int graceTicks = 0;
    private static String fullText = "";
    private static int charsRevealed = 0;
    private static int fadeOutTicks = 0;
    private static final int CHARS_PER_TICK = 2;
    private static final int FADE_OUT_DURATION = 15;

    private static final int PAPER_BG = 0x60F2ECD8;
    private static final int TEXT_COLOR = 0xE0000000;
    private static final int BOTTOM_LINE = 0x50A09070;
    private static final int PAD = 10;
    private static final int BOTTOM_MARGIN = 65;

    public static void showNarratorWithSound(Component message, SimpleSoundInstance sound) {
        currentMessage = message;
        activeSound = sound;
        graceTicks = 0;
        displayTicks = 0;
        displayTimer = Integer.MAX_VALUE;
        fullText = message.getString();
        charsRevealed = 0;
    }

    public static void showNarrator(Component message, int durationTicks) {
        currentMessage = message;
        activeSound = null;
        displayTicks = 0;
        displayTimer = Math.max(1, Math.min(durationTicks, 60));
        fullText = message.getString();
        charsRevealed = 0;
    }

    public static void tick() {
        if (currentMessage == null) return;
        displayTicks++;

        if (charsRevealed < fullText.length()) {
            charsRevealed = Math.min(charsRevealed + CHARS_PER_TICK, fullText.length());
        }

        if (activeSound != null) {
            Minecraft mc = Minecraft.getInstance();
            if (mc.getSoundManager() != null && mc.getSoundManager().isActive(activeSound)) {
                graceTicks = 0;
            } else if (fadeOutTicks == 0) {
                graceTicks++;
                if (graceTicks > 20) {
                    fadeOutTicks = FADE_OUT_DURATION;
                }
            }
        } else if (displayTimer > 0 && displayTimer < Integer.MAX_VALUE) {
            displayTimer--;
            if (displayTimer <= 0 && fadeOutTicks == 0) {
                fadeOutTicks = FADE_OUT_DURATION;
            }
        }
        if (fadeOutTicks > 0) {
            fadeOutTicks--;
            if (fadeOutTicks <= 0) {
                currentMessage = null;
                activeSound = null;
                graceTicks = 0;
            }
        }
    }

    private static int alpha(int argb, float factor) {
        int a = (argb >> 24) & 0xFF;
        int newA = Math.min(255, Math.max(0, (int) (a * factor)));
        return (newA << 24) | (argb & 0xFFFFFF);
    }

    private static List<String> wrapText(String text, int maxWidth, Font font) {
        List<String> lines = new ArrayList<>();
        while (!text.isEmpty()) {
            int len = font.plainSubstrByWidth(text, maxWidth, false).length();
            if (len <= 0) break;
            lines.add(text.substring(0, len));
            text = text.substring(len);
        }
        if (lines.isEmpty()) lines.add("");
        return lines;
    }

    @SubscribeEvent
    public static void registerOverlay(RegisterGuiOverlaysEvent event) {
        event.registerAboveAll("narrator", (gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
            if (currentMessage == null) return;

            Minecraft mc = Minecraft.getInstance();
            Font font = mc.font;
            String msg = currentMessage.getString();
            String revealed = fullText.isEmpty() ? msg : fullText.substring(0, Math.min(charsRevealed, fullText.length()));

            float fadeIn = Math.min(1.0F, displayTicks / 10.0F);
            float fadeOut = fadeOutTicks > 0 ? Math.max(0, fadeOutTicks / (float)FADE_OUT_DURATION) : 1.0F;
            float fadeAlpha = fadeIn * fadeOut;
            int textAreaWidth = Math.min(screenWidth - 80, 260);
            int paperW = textAreaWidth + PAD * 2;
            List<String> lines = wrapText(revealed, textAreaWidth, font);
            int lineH = font.lineHeight;
            int innerH = lineH * lines.size();
            int paperH = PAD * 2 + innerH;
            int paperX = (screenWidth - paperW) / 2;
            int paperY = screenHeight - BOTTOM_MARGIN - paperH;

            var pose = guiGraphics.pose();
            pose.pushPose();
            pose.translate(0.0F, 0.0F, 400.0F);

            // Three-layer background
            guiGraphics.fill(paperX, paperY, paperX + paperW, paperY + paperH, alpha(PAPER_BG, fadeAlpha * 0.6F));
            guiGraphics.fill(paperX + 2, paperY + 2, paperX + paperW - 2, paperY + paperH - 2, alpha(PAPER_BG, fadeAlpha * 0.8F));
            guiGraphics.fill(paperX + 4, paperY + 4, paperX + paperW - 4, paperY + paperH - 4, alpha(PAPER_BG, fadeAlpha));

            // Bottom decorative line
            guiGraphics.fill(paperX + 10, paperY + paperH - 6, paperX + paperW - 10, paperY + paperH - 4, alpha(BOTTOM_LINE, fadeAlpha));

            // Centered wrapped text with typewriter effect
            int startY = paperY + PAD;
            for (String line : lines) {
                int tw = font.width(line);
                int tx = paperX + (paperW - tw) / 2;
                guiGraphics.drawString(font, line, tx, startY, alpha(TEXT_COLOR, fadeAlpha), false);
                startY += lineH;
            }

            pose.popPose();
        });
    }
}
