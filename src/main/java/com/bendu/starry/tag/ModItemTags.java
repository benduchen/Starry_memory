package com.bendu.starry.tag;

import com.bendu.starry.StarryMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {

    public static final TagKey<Item> GLASS_TAG = bind("glass");

    private static TagKey<Item> bind(String pName) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(StarryMod.MOD_ID,pName));
    }
}
