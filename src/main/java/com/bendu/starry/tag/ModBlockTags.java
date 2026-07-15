package com.bendu.starry.tag;

import com.bendu.starry.StarryMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {
    private static TagKey<Block> create(String pName) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(StarryMod.MOD_ID, pName));
    }
}
