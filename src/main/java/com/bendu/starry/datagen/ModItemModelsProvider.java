package com.bendu.starry.datagen;

import com.bendu.starry.StarryMod;
import com.bendu.starry.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItemModelsProvider extends ItemModelProvider {
    public ModItemModelsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, StarryMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //饰品
        basicSubfolderItem(ModItems.MEMORANDUM.get());
        basicSubfolderItem(ModItems.WAIT.get());
        basicSubfolderItem(ModItems.HELP.get());
        basicSubfolderItem(ModItems.PERSEVERANCE.get());
        basicSubfolderItem(ModItems.CHOICE.get());
        //物品
        basicSubfolderItem(ModItems.GOLDEN_TEAR_CRYSTAL.get());
        basicSubfolderItem(ModItems.ORIGINAL_STAR_INGOT.get());
        basicSubfolderItem(ModItems.RAW_ORIGINAL_STAR.get());
        basicSubfolderItem(ModItems.SHATTERED_STAR_CRYSTAL.get());
        //食物
        basicSubfolderItem(ModItems.CLOUD_LYCHEE.get());
        //工具
        handheldSubfolderItem(ModItems.HALF_STAR_SWORD.get());
    }

    private void basicSubfolderItem(Item item) {
        ResourceLocation id = ForgeRegistries.ITEMS.getKey(item);
        String modelPath = "item/" + id.getPath();
        withExistingParent(modelPath, mcLoc("item/generated"))
                .texture("layer0", modLoc(modelPath));
    }

    private void handheldSubfolderItem(Item item) {
        ResourceLocation id = ForgeRegistries.ITEMS.getKey(item);
        String modelPath = "item/" + id.getPath();
        withExistingParent(modelPath, mcLoc("item/handheld"))
                .texture("layer0", modLoc(modelPath));
    }

}

