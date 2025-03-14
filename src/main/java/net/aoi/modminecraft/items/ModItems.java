package net.aoi.modminecraft.items;

import net.aoi.modminecraft.ModMinecraft;
import net.aoi.modminecraft.items.custom.FuelItem;
import net.aoi.modminecraft.items.custom.MineralSeekerItem;
import net.minecraft.world.item.Item;
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

    public static final RegistryObject<Item> LEAF =ITEMS.register("leaf", () -> new FuelItem(new Item.Properties(), 200));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
