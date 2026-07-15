package com.bendu.starry.item;

import com.bendu.starry.StarryMod;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;

public class ModToolTiers {
    public static final Tier HALF_STAR = new ForgeTier(
            0,      // 挖掘等级（剑用不上）
            2000,   // 耐久
            8.0F,   // 挖掘速度（剑用不上）
            1.0F,   // 基础攻击加成
            15,     // 附魔等级
            null,
            () -> Ingredient.of(ModItems.ORIGINAL_STAR_INGOT.get())
    );
}
