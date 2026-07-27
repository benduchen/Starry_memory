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
import top.theillusivec4.curios.api.type.capability.ICurio;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraft.nbt.CompoundTag;

import java.util.List;

public class PerseveranceItem extends Item {
    public PerseveranceItem(Properties properties) {
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
        tooltip.add(Component.translatable("tooltip.starry_mod.perseverance.shared_value_prefix").withStyle(ChatFormatting.DARK_GRAY)
                .append(Component.literal(String.valueOf(value))));

        if (net.minecraft.client.gui.screens.Screen.hasShiftDown()) {
            tooltip.add(Component.literal(""));
            addLine(tooltip, "tooltip.starry_mod.perseverance.story.1", 0x8BA0C0);
            tooltip.add(Component.literal(""));
            tooltip.add(Component.literal(""));
            addLine(tooltip, "tooltip.starry_mod.perseverance.story.2", 0xFFFFFF);
        } else {
            addLine(tooltip, "tooltip.starry_mod.perseverance.desc.1", 0xC0A080);
            tooltip.add(Component.translatable("tooltip.starry_mod.perseverance.separator"));
            addLine(tooltip, "tooltip.starry_mod.perseverance.desc.2", 0x5D6B7D);
            tooltip.add(Component.literal(""));
            tooltip.add(Component.translatable("tooltip.starry_mod.perseverance.shift_hint").withStyle(ChatFormatting.GRAY)
                    .append(Component.literal("SHIFT").withStyle(ChatFormatting.YELLOW))
                    .append(Component.translatable("tooltip.starry_mod.perseverance.shift_suffix").withStyle(ChatFormatting.GRAY)));
        }

        final int displayValue = value;
        if (value > 0) {
            tooltip.add(Component.literal(""));
            int lowPct = 100 - Math.min(displayValue, 100);
            int highPct = Math.max(displayValue - 100, 0);
            String lowStr = String.valueOf(lowPct);
            String highStr = String.valueOf(highPct);
            int lowColor = 0x55FF55;
            int highColor = 0x55FF55;
            boolean lowActive = displayValue < 100;
            boolean highActive = displayValue > 100;
            tooltip.add(Component.translatable("tooltip.starry_mod.perseverance.effect.low_prefix").withStyle(style -> style.withColor(net.minecraft.network.chat.TextColor.fromRgb(0x3399FF)))
                    .append(Component.literal(lowStr).withStyle(style -> style.withColor(net.minecraft.network.chat.TextColor.fromRgb(lowColor))))
                    .append(Component.translatable("tooltip.starry_mod.perseverance.effect.suffix").withStyle(style -> style.withColor(net.minecraft.network.chat.TextColor.fromRgb(0x3399FF))))
                    .append(Component.literal("  "))
                    .append(Component.translatable(lowActive ? "tooltip.starry_mod.perseverance.effect.active" : "tooltip.starry_mod.perseverance.effect.inactive")
                            .withStyle(style -> style.withColor(net.minecraft.network.chat.TextColor.fromRgb(lowActive ? 0x55FF55 : 0x666666)))));
            int atkPct = Math.max(highPct, 0) / 10;
            tooltip.add(Component.translatable("tooltip.starry_mod.perseverance.effect.high_prefix").withStyle(style -> style.withColor(net.minecraft.network.chat.TextColor.fromRgb(0x3399FF)))
                    .append(Component.literal(highStr).withStyle(style -> style.withColor(net.minecraft.network.chat.TextColor.fromRgb(highColor))))
                    .append(Component.translatable("tooltip.starry_mod.perseverance.effect.suffix").withStyle(style -> style.withColor(net.minecraft.network.chat.TextColor.fromRgb(0x3399FF))))
                    .append(Component.literal("\uff0c").withStyle(style -> style.withColor(net.minecraft.network.chat.TextColor.fromRgb(0x3399FF))))
                    .append(Component.translatable("tooltip.starry_mod.perseverance.effect.attack_prefix").withStyle(style -> style.withColor(net.minecraft.network.chat.TextColor.fromRgb(0x3399FF))))
                    .append(Component.literal(String.valueOf(atkPct)).withStyle(style -> style.withColor(net.minecraft.network.chat.TextColor.fromRgb(highColor))))
                    .append(Component.translatable("tooltip.starry_mod.perseverance.effect.attack_suffix").withStyle(style -> style.withColor(net.minecraft.network.chat.TextColor.fromRgb(0x3399FF))))
                    .append(Component.literal("  "))
                    .append(Component.translatable(highActive ? "tooltip.starry_mod.perseverance.effect.active" : "tooltip.starry_mod.perseverance.effect.inactive")
                            .withStyle(style -> style.withColor(net.minecraft.network.chat.TextColor.fromRgb(highActive ? 0x55FF55 : 0x666666)))));
            }
    }

    private void addLine(List<Component> tooltip, String key, int color) {
        tooltip.add(Component.translatable(key)
                .withStyle(style -> style.withColor(TextColor.fromRgb(color))));
    }
}
