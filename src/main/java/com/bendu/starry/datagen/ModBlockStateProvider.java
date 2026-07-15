package com.bendu.starry.datagen;

import com.bendu.starry.StarryMod;
import com.bendu.starry.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, StarryMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.ORIGINAL_STAR_ORE.get(), cubeAll(ModBlocks.ORIGINAL_STAR_ORE.get()));
    }
}
