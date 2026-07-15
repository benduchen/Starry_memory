package com.bendu.starry.item;

import com.bendu.starry.StarryMod;
import com.bendu.starry.item.custom.ShatteredStarCrystalItem;
import com.bendu.starry.item.custom.MemorandumItem;
import com.bendu.starry.item.custom.WaitItem;
import com.bendu.starry.item.custom.HelpItem;
import com.bendu.starry.item.custom.HalfStarSwordItem;
import com.bendu.starry.item.custom.CloudLycheeItem;
import com.bendu.starry.item.custom.PerseveranceItem;
import com.bendu.starry.item.custom.RawOriginalStarItem;
import com.bendu.starry.item.custom.OriginalStarIngotItem;
import com.bendu.starry.item.custom.GoldenTearCrystalItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, StarryMod.MOD_ID);
//上面是延时注册器，下面是注册添加的物品。注册只能用a-z0-9/._这些。
    public static final RegistryObject<Item> SHATTERED_STAR_CRYSTAL =
            ITEMS.register("material/shattered_star_crystal", () -> new ShatteredStarCrystalItem(new Item.Properties()));
    public static final RegistryObject<Item> GOLDEN_TEAR_CRYSTAL =
            ITEMS.register("material/golden_tear_crystal", () -> new GoldenTearCrystalItem(new Item.Properties()));
    public static final RegistryObject<Item> ORIGINAL_STAR_INGOT =
            ITEMS.register("material/original_star_ingot", () -> new OriginalStarIngotItem(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ORIGINAL_STAR =
            ITEMS.register("material/raw_original_star", () -> new RawOriginalStarItem(new Item.Properties()));
    public static final  RegistryObject<Item> CLOUD_LYCHEE =
            ITEMS.register("material/cloud_lychee", () -> new CloudLycheeItem(new Item.Properties().food(ModFoods.cloud_lychee)));


    //工具
    public static final RegistryObject<Item> HALF_STAR_SWORD =
            ITEMS.register("tool/half_star_sword", () -> new HalfStarSwordItem(ModToolTiers.HALF_STAR, 3, -2.4F, new Item.Properties()));


    public static final RegistryObject<Item> MEMORANDUM =
            ITEMS.register("curios/memorandum", () -> new MemorandumItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> WAIT =
            ITEMS.register("curios/wait", () -> new WaitItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> PERSEVERANCE =
            ITEMS.register("curios/perseverance", () -> new PerseveranceItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> HELP =
            ITEMS.register("curios/help", () -> new HelpItem(new Item.Properties().stacksTo(1)));





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
