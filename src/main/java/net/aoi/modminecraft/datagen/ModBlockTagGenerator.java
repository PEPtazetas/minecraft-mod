package net.aoi.modminecraft.datagen;

import net.aoi.modminecraft.ModMinecraft;
import net.aoi.modminecraft.block.ModBlocks;
import net.aoi.modminecraft.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator  extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ModMinecraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.MINERAL_SEEKER_VALUABLES)
                .add(ModBlocks.ARGENTO_ORE.get(),
                        ModBlocks.DEEPSLATE_ARGENTO_ORE.get(),
                        ModBlocks.FLORITA_ORE.get(),
                        ModBlocks.CALENTO_ORE.get()
                ).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.OXIWOOD_PLANKS.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ARGENTO_ORE.get(),
                    ModBlocks.DEEPSLATE_ARGENTO_ORE.get(),
                    ModBlocks.FLORITA_ORE.get(),
                    ModBlocks.CALENTO_ORE.get()
                );

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(
                        ModBlocks.ARGENTO_ORE.get(),
                        ModBlocks.DEEPSLATE_ARGENTO_ORE.get(),
                        ModBlocks.CALENTO_ORE.get()
                );
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(
                        ModBlocks.FLORITA_ORE.get()
                );
        this.tag(Tags.Blocks.NEEDS_WOOD_TOOL)
                .add(ModBlocks.OXIWOOD_PLANKS.get());
        //this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(ModBlocks.ARGENTO_ORE.get());
        //this.tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.ARGENTO_ORE.get());
    }
}
