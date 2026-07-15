package com.bendu.starry.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.ChatFormatting;
import org.jetbrains.annotations.Nullable;
import net.minecraft.client.gui.screens.Screen;

import java.util.List;

public class ShatteredStarCrystalItem extends Item {
    public ShatteredStarCrystalItem(Properties properties) {
        super(properties);
    }

    private static final int COLOR_DEFAULT = 0xA3A19D;
    private static final int COLOR_STORY = 0x3B6995;

    private void addLine(List<Component> tooltip, String key, int color) {
        tooltip.add(Component.translatable(key)
                .withStyle(style -> style.withColor(TextColor.fromRgb(color))));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            // 故事
            addLine(tooltip, "tooltip.starry_mod.shattered_star_crystal.story.1", COLOR_STORY);
            addLine(tooltip, "tooltip.starry_mod.shattered_star_crystal.story.2", COLOR_STORY);
            addLine(tooltip, "tooltip.starry_mod.shattered_star_crystal.story.3", COLOR_STORY);
            addLine(tooltip, "tooltip.starry_mod.shattered_star_crystal.story.4", COLOR_STORY);
            tooltip.add(Component.literal(""));
            addLine(tooltip, "tooltip.starry_mod.shattered_star_crystal.story.5", COLOR_STORY);
            addLine(tooltip, "tooltip.starry_mod.shattered_star_crystal.story.6", COLOR_STORY);
            addLine(tooltip, "tooltip.starry_mod.shattered_star_crystal.story.7", COLOR_STORY);
            tooltip.add(Component.literal(""));
            addLine(tooltip, "tooltip.starry_mod.shattered_star_crystal.story.8", COLOR_STORY);
            addLine(tooltip, "tooltip.starry_mod.shattered_star_crystal.story.9", COLOR_STORY);
            addLine(tooltip, "tooltip.starry_mod.shattered_star_crystal.story.10", COLOR_STORY);
            addLine(tooltip, "tooltip.starry_mod.shattered_star_crystal.story.11", COLOR_STORY);
            tooltip.add(Component.literal(""));
            addLine(tooltip, "tooltip.starry_mod.shattered_star_crystal.story.12", COLOR_STORY);
            addLine(tooltip, "tooltip.starry_mod.shattered_star_crystal.story.13", COLOR_STORY);
        } else {
// 默认
            addLine(tooltip, "tooltip.starry_mod.shattered_star_crystal.desc.1", COLOR_DEFAULT);
            addLine(tooltip, "tooltip.starry_mod.shattered_star_crystal.desc.2", COLOR_DEFAULT);
            tooltip.add(Component.literal(""));
            tooltip.add(Component.translatable("tooltip.starry_mod.shattered_star_crystal.shift_hint").withStyle(ChatFormatting.GRAY)
                    .append(Component.literal("SHIFT").withStyle(ChatFormatting.YELLOW))
                    .append(Component.translatable("tooltip.starry_mod.shattered_star_crystal.shift_suffix").withStyle(ChatFormatting.GRAY)));
        }
    }
}
