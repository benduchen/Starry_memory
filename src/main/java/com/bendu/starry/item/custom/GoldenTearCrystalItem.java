package com.bendu.starry.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import java.util.List;

public class GoldenTearCrystalItem extends Item {
    public GoldenTearCrystalItem(Properties properties) {
        super(properties);
    }

    private static final int COLOR_DEFAULT = 0xD4A057;
    private static final int COLOR_STORY = 0x8B7D6B;

    private void addLine(List<Component> tooltip, String key, int color) {
        tooltip.add(Component.translatable(key)
                .withStyle(style -> style.withColor(TextColor.fromRgb(color))));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            // story
            tooltip.add(Component.literal(""));
            addLine(tooltip, "tooltip.starry_mod.golden_tear_crystal.story.1", COLOR_STORY);
            tooltip.add(Component.literal(""));
            addLine(tooltip, "tooltip.starry_mod.golden_tear_crystal.story.2", COLOR_STORY);
        } else {
            // default
            tooltip.add(Component.literal(""));
            addLine(tooltip, "tooltip.starry_mod.golden_tear_crystal.desc.1", COLOR_DEFAULT);
            tooltip.add(Component.literal(""));
            tooltip.add(Component.literal(""));
            tooltip.add(Component.translatable("tooltip.starry_mod.golden_tear_crystal.shift_hint").withStyle(ChatFormatting.GRAY)
                    .append(Component.literal("SHIFT").withStyle(ChatFormatting.YELLOW))
                    .append(Component.translatable("tooltip.starry_mod.golden_tear_crystal.shift_suffix").withStyle(ChatFormatting.GRAY)));
        }
    }
}
