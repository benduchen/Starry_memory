package com.bendu.starry.datagen;

import com.bendu.starry.StarryMod;
import com.bendu.starry.block.ModBlocks;
import com.bendu.starry.item.ModItems;
import com.bendu.starry.tag.ModItemTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipesProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipesProvider(PackOutput pOutput) {
        super(pOutput);
    }

    public static final List<ItemLike> original_star_ingot = List.of(ModItems.RAW_ORIGINAL_STAR.get(), ModBlocks.ORIGINAL_STAR_ORE.get());

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        //oreSmelting(熔炉方法);
        oreBlasting(pWriter,original_star_ingot, RecipeCategory.MISC, ModItems.ORIGINAL_STAR_INGOT.get(), 1F, 200, "original_star_ingot");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GOLDEN_TEAR_CRYSTAL.get())
                .pattern(" # ")
                .pattern("&$%")
                .pattern(" @ ")
                .define('#', Items.CHAIN.asItem())
                .define('$', Items.GHAST_TEAR.asItem())
                .define('&', Items.GOLD_INGOT.asItem())
                .define('%', ModItems.ORIGINAL_STAR_INGOT.get())
                .define('@', Items.GLASS.asItem())
                .unlockedBy(getHasName(ModItems.ORIGINAL_STAR_INGOT.get()), has(ModItems.ORIGINAL_STAR_INGOT.get()))
                .save(pWriter);

        //ShapelessRecipeBuilder.shapeless(无序合成)

        //半星剑
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HALF_STAR_SWORD.get())
                .pattern(" @ ")
                .pattern(" # ")
                .pattern(" %&")
                .define('@', ModItems.ORIGINAL_STAR_INGOT.get())
                .define('#', Items.DIAMOND)
                .define('%', Items.BLAZE_ROD)
                .define('&', Items.YELLOW_DYE)
                .unlockedBy(getHasName(ModItems.ORIGINAL_STAR_INGOT.get()), has(ModItems.ORIGINAL_STAR_INGOT.get()))
                .save(pWriter);

    }
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime,
                    pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, StarryMod.MOD_ID+ ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}

