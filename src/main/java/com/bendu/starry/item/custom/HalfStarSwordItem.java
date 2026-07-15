package com.bendu.starry.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import java.util.List;
import java.util.Locale;
import com.bendu.starry.item.ModItems;
import com.bendu.starry.item.custom.MemorandumItem;
import top.theillusivec4.curios.api.CuriosApi;

public class HalfStarSwordItem extends SwordItem {
    public HalfStarSwordItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.literal(""));
            addLine(tooltip, "tooltip.starry_mod.half_star_sword.story.1", 0xA99393);
            tooltip.add(Component.literal(""));
        } else {
            tooltip.add(Component.literal(""));
            addLine(tooltip, "tooltip.starry_mod.half_star_sword.desc.1", 0xFFD700);
            tooltip.add(Component.literal(""));
            tooltip.add(Component.translatable("tooltip.starry_mod.half_star_sword.shift_hint").withStyle(ChatFormatting.GRAY)
                    .append(Component.literal("SHIFT").withStyle(ChatFormatting.YELLOW))
                    .append(Component.translatable("tooltip.starry_mod.half_star_sword.shift_suffix").withStyle(ChatFormatting.GRAY)));
        }
        if (level != null && level.isClientSide) {
            var player = net.minecraft.client.Minecraft.getInstance().player;
            if (player != null) {
                int totalValue = CuriosApi.getCuriosInventory(player).map(handler -> {
                    var memo = handler.findFirstCurio(ModItems.MEMORANDUM.get());
                    if (memo.isEmpty()) return 0;
                    return MemorandumItem.getStellarValue(memo.get().stack());
                }).orElse(0);

                if (totalValue > 0) {
                    int thresholds = totalValue / 20;
                    double bonus = thresholds * 0.6;
                    String bonusStr;
                    if (bonus == Math.floor(bonus)) {
                        bonusStr = "+" + (int)bonus;
                    } else {
                        bonusStr = String.format(Locale.US, "+%.1f", bonus);
                    }

                    int color;
                    if (totalValue >= 80) color = 0x55FF55;
                    else if (totalValue >= 40) color = 0xFFAA00;
                    else color = 0xFF5555;

                    tooltip.add(Component.literal(""));
                    tooltip.add(Component.translatable("tooltip.starry_mod.half_star_sword.effect.bonus")
                            .withStyle(style -> style.withColor(net.minecraft.network.chat.TextColor.fromRgb(0x3399FF)))
                            .append(Component.literal(bonusStr)
                                    .withStyle(style -> style.withColor(net.minecraft.network.chat.TextColor.fromRgb(color))))
                            .append(Component.translatable("tooltip.starry_mod.half_star_sword.effect.suffix")
                                    .withStyle(style -> style.withColor(net.minecraft.network.chat.TextColor.fromRgb(0x3399FF)))));
                }
            }
        }
    }

    private void addLine(List<Component> tooltip, String key, int color) {
        tooltip.add(Component.translatable(key)
                .withStyle(style -> style.withColor(TextColor.fromRgb(color))));
    }
}