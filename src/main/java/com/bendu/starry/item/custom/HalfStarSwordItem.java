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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import java.util.UUID;

public class HalfStarSwordItem extends SwordItem {
    public HalfStarSwordItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    private static final UUID STELLAR_DAMAGE_UUID = UUID.fromString("d4e5f6a7-b8c9-0123-4567-89abcdef0123");
    private static final UUID BASE_ATTACK_DAMAGE_UUID = UUID.fromString("CB3F55D3-645C-4F38-A144-9C13A33C8003");

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(stack, level, entity, slotId, isSelected);
        if (level.isClientSide) return;
        if (!(entity instanceof net.minecraft.world.entity.player.Player player)) return;
        if (player.tickCount % 20 != 0) return;

        int totalValue = CuriosApi.getCuriosInventory(player).map(handler -> {
            var memo = handler.findFirstCurio(ModItems.MEMORANDUM.get());
            if (memo.isEmpty()) return 0;
            return MemorandumItem.getStellarValue(memo.get().stack());
        }).orElse(0);

        int thresholds = totalValue / 20;
        double bonus = thresholds * 0.6;

        double baseDamage = 0;
        for (AttributeModifier mod : getDefaultAttributeModifiers(EquipmentSlot.MAINHAND).get(Attributes.ATTACK_DAMAGE)) {
            if (mod.getId().equals(BASE_ATTACK_DAMAGE_UUID)) {
                baseDamage = mod.getAmount();
                break;
            }
        }

        CompoundTag tag = stack.getOrCreateTag();
        if (tag.contains("AttributeModifiers", 9)) {
            ListTag mods = tag.getList("AttributeModifiers", 10);
            for (int i = mods.size() - 1; i >= 0; i--) {
                CompoundTag ct = (CompoundTag) mods.get(i);
                if (ct.hasUUID("UUID")) {
                    UUID uid = ct.getUUID("UUID");
                    if (uid.equals(STELLAR_DAMAGE_UUID) || uid.equals(BASE_ATTACK_DAMAGE_UUID)) {
                        mods.remove(i);
                    }
                }
            }
        }

        double totalDamage = baseDamage + bonus;
        if (!tag.contains("AttributeModifiers", 9)) {
            tag.put("AttributeModifiers", new ListTag());
        }
        ListTag modList = tag.getList("AttributeModifiers", 10);
        CompoundTag newMod = new CompoundTag();
        newMod.putUUID("UUID", BASE_ATTACK_DAMAGE_UUID);
        newMod.putString("Name", "Weapon modifier");
        newMod.putDouble("Amount", totalDamage);
        newMod.putInt("Operation", 0);
        newMod.putString("Slot", "mainhand");
        newMod.putString("AttributeName", "minecraft:generic.attack_damage");
        modList.add(newMod);
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
