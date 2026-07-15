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

public class HelpItem extends Item {
    public HelpItem(Properties properties) {
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
        tooltip.add(Component.translatable("tooltip.starry_mod.help.shared_value_prefix").withStyle(ChatFormatting.DARK_GRAY)
                .append(Component.literal(String.valueOf(value))));

        if (net.minecraft.client.gui.screens.Screen.hasShiftDown()) {
            // [4] story
            tooltip.add(Component.literal(""));
            addLine(tooltip, "tooltip.starry_mod.help.story.1", 0xB87333);
            tooltip.add(Component.literal(""));
            addLine(tooltip, "tooltip.starry_mod.help.story.2", 0xB87333);
            tooltip.add(Component.literal(""));
            addLine(tooltip, "tooltip.starry_mod.help.story.3", 0xB87333);
        } else {
            // [1] 默认
            addLine(tooltip, "tooltip.starry_mod.help.desc.1", 0xC8A951);
            tooltip.add(Component.translatable("tooltip.starry_mod.help.separator"));
            addLine(tooltip, "tooltip.starry_mod.help.desc.2", 0x7EC8E3);
            tooltip.add(Component.literal(""));
            tooltip.add(Component.translatable("tooltip.starry_mod.help.shift_hint").withStyle(ChatFormatting.GRAY)
                    .append(Component.literal("SHIFT").withStyle(ChatFormatting.YELLOW))
                    .append(Component.translatable("tooltip.starry_mod.help.shift_suffix").withStyle(ChatFormatting.GRAY)));
        }

        final int displayValue = value;
        if (value > 0) {
            int pct = (int)(0.4 * value);
            tooltip.add(Component.literal(""));
            tooltip.add(Component.translatable("tooltip.starry_mod.help.effect.desc_prefix").withStyle(style -> style.withColor(net.minecraft.network.chat.TextColor.fromRgb(0x3399FF)))
                    .append(Component.translatable("tooltip.starry_mod.help.effect.absorption")
                            .append(Component.literal(" +" + pct + "%"))
                            .withStyle(style -> style.withColor(net.minecraft.network.chat.TextColor.fromRgb(displayValue >= 80 ? 0x55FF55 : displayValue >= 40 ? 0xFFAA00 : 0xFF5555))))
                    .append(Component.translatable("tooltip.starry_mod.help.effect.desc_suffix").withStyle(style -> style.withColor(net.minecraft.network.chat.TextColor.fromRgb(0x3399FF)))));
            tooltip.add(Component.translatable("tooltip.starry_mod.help.effect.cooldown").withStyle(style -> style.withColor(net.minecraft.network.chat.TextColor.fromRgb(0x3399FF))));
        }
    }

    private void addLine(List<Component> tooltip, String key, int color) {
        tooltip.add(Component.translatable(key)
                .withStyle(style -> style.withColor(TextColor.fromRgb(color))));
    }

}
