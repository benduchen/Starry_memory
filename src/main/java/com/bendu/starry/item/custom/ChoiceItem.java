package com.bendu.starry.item.custom;

import com.bendu.starry.item.ModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.ChatFormatting;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.List;

public class ChoiceItem extends Item {
    public ChoiceItem(Properties properties) {
        super(properties);
    }

    public static int getSharedValue(LivingEntity entity) {
        return CuriosApi.getCuriosInventory(entity).map(handler -> {
            var memo = handler.findFirstCurio(ModItems.MEMORANDUM.get());
            if (memo.isEmpty()) return 0;
            int total = MemorandumItem.getStellarValue(memo.get().stack());
            if (total <= 0) return 0;
            int count = 0;
            if (handler.findFirstCurio(ModItems.WAIT.get()).isPresent()) count++;
            if (handler.findFirstCurio(ModItems.HELP.get()).isPresent()) count++;
            if (handler.findFirstCurio(ModItems.PERSEVERANCE.get()).isPresent()) count++;
            if (handler.findFirstCurio(ModItems.CHOICE.get()).isPresent()) count++;
            if (count == 0) return total;
            return total / count;
        }).orElse(0);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        int value = 0;
        if (level != null && level.isClientSide) {
            var player = net.minecraft.client.Minecraft.getInstance().player;
            if (player != null) {
                value = getSharedValue(player);
            }
        }
        tooltip.add(Component.translatable("tooltip.starry_mod.choice.shared_value_prefix").withStyle(ChatFormatting.DARK_GRAY)
                .append(Component.literal(String.valueOf(value))));

        if (net.minecraft.client.gui.screens.Screen.hasShiftDown()) {
            tooltip.add(Component.literal(""));
            addLine(tooltip, "tooltip.starry_mod.choice.story.1", 0x8BA0C0);
        } else {
            addLine(tooltip, "tooltip.starry_mod.choice.desc.1", 0xAAAAAA);
            tooltip.add(Component.translatable("tooltip.starry_mod.choice.separator"));
            addLine(tooltip, "tooltip.starry_mod.choice.desc.2", 0xFFFFFF);
            tooltip.add(Component.literal(""));
            tooltip.add(Component.translatable("tooltip.starry_mod.choice.shift_hint").withStyle(ChatFormatting.GRAY)
                    .append(Component.literal("SHIFT").withStyle(ChatFormatting.YELLOW))
                    .append(Component.translatable("tooltip.starry_mod.choice.shift_suffix").withStyle(ChatFormatting.GRAY)));
        }

        final int displayValue = value;
        if (value > 0) {
            tooltip.add(Component.literal(""));
            boolean lowActive = displayValue < 100;
            boolean highActive = displayValue > 100;

            // Line 1: low effect
            double lowPercent = 20 + Math.min(displayValue, 99) * 0.2;
            String lowStr;
            if (lowPercent == Math.floor(lowPercent)) {
                lowStr = String.valueOf((int)lowPercent);
            } else {
                lowStr = String.format(java.util.Locale.US, "%.1f", lowPercent);
            }
            tooltip.add(Component.translatable("tooltip.starry_mod.choice.effect.low_prefix").withStyle(style -> style.withColor(net.minecraft.network.chat.TextColor.fromRgb(0x3399FF)))
                    .append(Component.literal(lowStr).withStyle(style -> style.withColor(net.minecraft.network.chat.TextColor.fromRgb(0x55FF55))))
                    .append(Component.translatable("tooltip.starry_mod.choice.effect.low_suffix").withStyle(style -> style.withColor(net.minecraft.network.chat.TextColor.fromRgb(0x3399FF))))
                    .append(Component.literal("  "))
                    .append(Component.translatable(lowActive ? "tooltip.starry_mod.choice.effect.active" : "tooltip.starry_mod.choice.effect.inactive")
                            .withStyle(style -> style.withColor(net.minecraft.network.chat.TextColor.fromRgb(lowActive ? 0x55FF55 : 0x666666)))));

            // Line 2: high effect
            tooltip.add(Component.translatable("tooltip.starry_mod.choice.effect.high_line").withStyle(style -> style.withColor(net.minecraft.network.chat.TextColor.fromRgb(0x3399FF)))
                    .append(Component.literal("  "))
                    .append(Component.translatable(highActive ? "tooltip.starry_mod.choice.effect.active" : "tooltip.starry_mod.choice.effect.inactive")
                            .withStyle(style -> style.withColor(net.minecraft.network.chat.TextColor.fromRgb(highActive ? 0x55FF55 : 0x666666)))));
        }
    }

    private void addLine(List<Component> tooltip, String key, int color) {
        tooltip.add(Component.translatable(key)
                .withStyle(style -> style.withColor(TextColor.fromRgb(color))));
    }
}
