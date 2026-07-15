package com.bendu.starry.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties cloud_lychee = new FoodProperties.Builder().nutrition(6).saturationMod(1.5F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 2), 1f).build();
}
