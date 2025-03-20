package net.aoi.modminecraft.items;

import net.aoi.modminecraft.ModMinecraft;
import net.aoi.modminecraft.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab>CREATIVE_MODE_TABS= DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModMinecraft.MOD_ID);


    public static final RegistryObject<CreativeModeTab>MODMINECRAFT_TAB =CREATIVE_MODE_TABS.register("modminecraft_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ARGENTO.get()))
                    .title(Component.translatable("creativetab.modminecraft_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.ARGENTO.get());
                        pOutput.accept(ModItems.CALENTO.get());
                        pOutput.accept(ModItems.FLORITA.get());
                        pOutput.accept(ModItems.FLORITA_INGOT.get());

                        pOutput.accept(ModItems.URIMITA_WAND.get());

                        pOutput.accept(ModItems.ARGENTO_SWORD.get());
                        pOutput.accept(ModItems.ARGENTO_AXE.get());
                        pOutput.accept(ModItems.ARGENTO_PICKAXE.get());
                        pOutput.accept(ModItems.ARGENTO_SHOVEL.get());
                        pOutput.accept(ModItems.ARGENTO_HOE.get());



                        pOutput.accept(ModItems.MINERAL_SEEKER.get());

                        pOutput.accept(ModBlocks.OXIWOOD_PLANKS.get());

                        pOutput.accept(ModBlocks.ARGENTO_ORE.get());
                        pOutput.accept(ModBlocks.CALENTO_ORE.get());
                        pOutput.accept(ModBlocks.FLORITA_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_ARGENTO_ORE.get());

                        pOutput.accept(ModBlocks.OXIWOOD_FENCE.get());
                        pOutput.accept(ModBlocks.OXIWOOD_SLAB.get());
                        pOutput.accept(ModBlocks.OXIWOOD_DOOR.get());
                        pOutput.accept(ModBlocks.OXIWOOD_STAIRS.get());
                        pOutput.accept(ModBlocks.OXIWOOD_BUTTON.get());
                        pOutput.accept(ModBlocks.OXIWOOD_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.OXIWOOD_WALL.get());
                        pOutput.accept(ModBlocks.OXIWOOD_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.OXIWOOD_PRESSURE_PLATE.get());

                        pOutput.accept(ModBlocks.BANJO_MUSIC_BLOCK.get());

                        pOutput.accept(ModItems.SANDWICH.get());
                        pOutput.accept(ModItems.STRAWBERRY.get());

                        pOutput.accept(ModItems.LEAF.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
