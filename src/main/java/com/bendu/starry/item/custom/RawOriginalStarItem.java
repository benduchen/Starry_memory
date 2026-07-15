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

public class RawOriginalStarItem extends Item {
    public RawOriginalStarItem(Properties properties) {
        super(properties);
    }

    private static final int COLOR_DEFAULT = 0x0066CC;
    private static final int COLOR_STORY = 0x00FFFF;

    private void addLine(List<Component> tooltip, String key, int color) {
        tooltip.add(Component.translatable(key)
                .withStyle(style -> style.withColor(TextColor.fromRgb(color))));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            addLine(tooltip, "tooltip.starry_mod.raw_original_star.story.1", COLOR_STORY);
        } else {
            addLine(tooltip, "tooltip.starry_mod.raw_original_star.desc.1", COLOR_DEFAULT);
            tooltip.add(Component.literal(""));
            tooltip.add(Component.translatable("tooltip.starry_mod.raw_original_star.shift_hint").withStyle(ChatFormatting.GRAY)
                    .append(Component.literal("SHIFT").withStyle(ChatFormatting.YELLOW))
                    .append(Component.translatable("tooltip.starry_mod.raw_original_star.shift_suffix").withStyle(ChatFormatting.GRAY)));
        }
    }
}
