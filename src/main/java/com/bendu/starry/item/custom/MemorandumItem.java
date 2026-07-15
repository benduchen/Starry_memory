package com.bendu.starry.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.ChatFormatting;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.List;

public class MemorandumItem extends Item {
    private static final String TAG_STELLAR_VALUE = "stellar_value";
    private static final int DEFAULT_MAX = 100;
    private static final int TICK_INTERVAL = 20;

    public MemorandumItem(Properties properties) {
        super(properties);
    }

    public static int getStellarValue(ItemStack stack) {
        CompoundTag tag = stack.getTag();
        if (tag != null && tag.contains(TAG_STELLAR_VALUE)) {
            return tag.getInt(TAG_STELLAR_VALUE);
        }
        return 0;
    }

    public static void setStellarValue(ItemStack stack, int value) {
        stack.getOrCreateTag().putInt(TAG_STELLAR_VALUE, Math.min(value, DEFAULT_MAX));
    }

@Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        int value = getStellarValue(stack);
        tooltip.add(Component.translatable("tooltip.starry_mod.memorandum.stellar_value").withStyle(ChatFormatting.GRAY)
                .append(Component.literal(String.valueOf(value)).withStyle(style -> {
                    int c;
                    if (value >= 80) c = 0x55FF55;
                    else if (value >= 40) c = 0xFFAA00;
                    else c = 0xFF5555;
                    return style.withColor(TextColor.fromRgb(c));
                })));

        if (net.minecraft.client.gui.screens.Screen.hasShiftDown()) {
            addLine(tooltip, "tooltip.starry_mod.memorandum.story.1", 0x7A8B8B);
            addLine(tooltip, "tooltip.starry_mod.memorandum.story.2", 0x7A8B8B);
            addLine(tooltip, "tooltip.starry_mod.memorandum.story.3", 0x7A8B8B);
            addLine(tooltip, "tooltip.starry_mod.memorandum.story.4", 0x7A8B8B);
            addLine(tooltip, "tooltip.starry_mod.memorandum.story.5", 0x7A8B8B);
        } else {
            addLine(tooltip, "tooltip.starry_mod.memorandum.desc.1", 0x8B7E74);
            addLine(tooltip, "tooltip.starry_mod.memorandum.desc.2", 0x8B7E74);
            addLine(tooltip, "tooltip.starry_mod.memorandum.desc.3", 0x8B7E74);
            tooltip.add(Component.literal(""));
            tooltip.add(Component.translatable("tooltip.starry_mod.memorandum.shift_hint").withStyle(ChatFormatting.GRAY)
                    .append(Component.literal("SHIFT").withStyle(ChatFormatting.YELLOW))
                    .append(Component.translatable("tooltip.starry_mod.memorandum.shift_suffix").withStyle(ChatFormatting.GRAY)));
        }

        tooltip.add(Component.literal(""));
        addLine(tooltip, "tooltip.starry_mod.memorandum.info.share", 0x555555);
        addLine(tooltip, "tooltip.starry_mod.memorandum.info.max_value", 0x555577);
            tooltip.add(Component.literal(""));
            addLine(tooltip, "tooltip.starry_mod.memorandum.info.fragment_slots", 0xD4A030);
            tooltip.add(Component.literal(""));
    }

    private void addLine(List<Component> tooltip, String key, int color) {
        tooltip.add(Component.translatable(key)
                .withStyle(style -> style.withColor(TextColor.fromRgb(color))));
    }
}
