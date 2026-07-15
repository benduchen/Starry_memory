package com.bendu.starry.item;

import com.bendu.starry.StarryMod;
import com.bendu.starry.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab>CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StarryMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> STARRY_MATERIAL =//这是注册创造物品栏
            CREATIVE_MODE_TABS.register("starry_material", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.SHATTERED_STAR_CRYSTAL.get()))//这里是创造物品栏图标，itemstack调用的。
                    .title(Component.translatable("itemGroup.starry_material"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.SHATTERED_STAR_CRYSTAL.get());//添加的物品，名字不能重复
                        pOutput.accept(ModItems.GOLDEN_TEAR_CRYSTAL.get());
                        pOutput.accept(ModItems.ORIGINAL_STAR_INGOT.get());
                        pOutput.accept(ModItems.RAW_ORIGINAL_STAR.get());
                        pOutput.accept(ModItems.CLOUD_LYCHEE.get());
                        pOutput.accept(ModItems.HALF_STAR_SWORD.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> STARRY_BLOCKS =//这是注册创造物品栏
            CREATIVE_MODE_TABS.register("starry_blocks", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.ORIGINAL_STAR_ORE.get()))//这里是创造物品栏图标，itemstack调用的。
                    .title(Component.translatable("itemGroup.starry_blocks"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.ORIGINAL_STAR_ORE.get());//添加的方块，名字不能重复

                    }).build());

    public static final RegistryObject<CreativeModeTab> STARRY_CURIOS =//这是注册创造物品栏
            CREATIVE_MODE_TABS.register("starry_curios", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.MEMORANDUM.get()))//这里是创造物品栏图标，itemstack调用的。
                    .title(Component.translatable("itemGroup.starry_curios"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.MEMORANDUM.get());//添加的饰品，名字不能重复
                        pOutput.accept(ModItems.WAIT.get());
                        pOutput.accept(ModItems.HELP.get());
                        pOutput.accept(ModItems.PERSEVERANCE.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
 }
