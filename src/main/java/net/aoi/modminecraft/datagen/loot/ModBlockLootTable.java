package net.aoi.modminecraft.datagen.loot;

import net.aoi.modminecraft.block.ModBlocks;
import net.aoi.modminecraft.items.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;


import java.util.Set;

public class ModBlockLootTable extends BlockLootSubProvider {
    public ModBlockLootTable() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        this.dropSelf(ModBlocks.OXIWOOD_PLANKS.get());
        this.dropSelf(ModBlocks.BANJO_MUSIC_BLOCK.get());

        this.dropSelf(ModBlocks.OXIWOOD_FENCE.get());
        this.dropSelf(ModBlocks.OXIWOOD_WALL.get());
        this.dropSelf(ModBlocks.OXIWOOD_TRAPDOOR.get());
        this.dropSelf(ModBlocks.OXIWOOD_FENCE_GATE.get());
        this.dropSelf(ModBlocks.OXIWOOD_BUTTON.get());
        this.dropSelf(ModBlocks.OXIWOOD_STAIRS.get());
        this.dropSelf(ModBlocks.OXIWOOD_PRESSURE_PLATE.get());

        this.add(ModBlocks.OXIWOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.OXIWOOD_SLAB.get()));
        this.add(ModBlocks.OXIWOOD_DOOR.get(),
                block -> createDoorTable(ModBlocks.OXIWOOD_DOOR.get()));

        this.add(ModBlocks.FLORITA_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.FLORITA_ORE.get(), ModItems.FLORITA.get()));
        this.add(ModBlocks.ARGENTO_ORE.get(),
                block -> createIronLikeOreDrops(ModBlocks.ARGENTO_ORE.get(), ModItems.ARGENTO.get()));
        this.add(ModBlocks.CALENTO_ORE.get(),
                block -> createIronLikeOreDrops(ModBlocks.CALENTO_ORE.get(), ModItems.CALENTO.get()));
        this.add(ModBlocks.DEEPSLATE_ARGENTO_ORE.get(),
                block -> createIronLikeOreDrops(ModBlocks.DEEPSLATE_ARGENTO_ORE.get(), ModItems.ARGENTO.get()));
    }

    private LootTable.Builder createCopperLikeOreDrops(Block block, Item item) {
        return createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.FORTUNE))));
    }
    private LootTable.Builder createIronLikeOreDrops(Block block, Item item) {
        return createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F,1.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
