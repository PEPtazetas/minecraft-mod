package net.aoi.modminecraft.items;

import net.aoi.modminecraft.ModMinecraft;
import net.aoi.modminecraft.items.custom.FuelItem;
import net.aoi.modminecraft.items.custom.MineralSeekerItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS= DeferredRegister.create(ForgeRegistries.ITEMS, ModMinecraft.MOD_ID);

    public static final RegistryObject<Item> ARGENTO =ITEMS.register("argento",() -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CALENTO =ITEMS.register("calento",() -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FLORITA =ITEMS.register("florita",() -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FLORITA_INGOT =ITEMS.register("florita_ingot",() -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MINERAL_SEEKER =ITEMS.register("mineral_seeker",() ->
            new MineralSeekerItem(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> SANDWICH =ITEMS.register("sandwich", () -> new Item(new Item.Properties().food(ModFoods.SANDWICH)));
    public static final RegistryObject<Item> STRAWBERRY =ITEMS.register("strawberry", () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));

    public static final RegistryObject<Item> URIMITA_WAND =ITEMS.register("urimita_wand", () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> LEAF =ITEMS.register("leaf", () -> new FuelItem(new Item.Properties(), 200));

    public static final RegistryObject<Item> ARGENTO_SWORD = ITEMS.register("argento_sword", () -> new SwordItem(ModToolTiers.ARGENTO, new Item.Properties()
            .attributes(SwordItem.createAttributes(ModToolTiers.ARGENTO, 3, -2.4f))));
    public static final RegistryObject<Item> ARGENTO_AXE = ITEMS.register("argento_axe", () -> new AxeItem(ModToolTiers.ARGENTO, new Item.Properties()
            .attributes(AxeItem.createAttributes(ModToolTiers.ARGENTO, 6, -3.2f))));
    public static final RegistryObject<Item> ARGENTO_PICKAXE = ITEMS.register("argento_pickaxe", () -> new PickaxeItem(ModToolTiers.ARGENTO, new Item.Properties()
            .attributes(PickaxeItem.createAttributes(ModToolTiers.ARGENTO, 1, -2.8f))));
    public static final RegistryObject<Item> ARGENTO_SHOVEL = ITEMS.register("argento_shovel", () -> new ShovelItem(ModToolTiers.ARGENTO, new Item.Properties()
            .attributes(ShovelItem.createAttributes(ModToolTiers.ARGENTO, 1.5f, -3.0f))));
    public static final RegistryObject<Item> ARGENTO_HOE = ITEMS.register("argento_hoe", () -> new HoeItem(ModToolTiers.ARGENTO, new Item.Properties()
            .attributes(HoeItem.createAttributes(ModToolTiers.ARGENTO, 0, -3.0f))));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
