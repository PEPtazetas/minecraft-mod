package net.aoi.modminecraft.datagen;

import net.aoi.modminecraft.ModMinecraft;
import net.aoi.modminecraft.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ModMinecraft.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ARGENTO_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ARGENTO_ORE);
        blockWithItem(ModBlocks.CALENTO_ORE);

        blockWithItem(ModBlocks.FLORITA_ORE);

        blockWithItem(ModBlocks.BANJO_MUSIC_BLOCK);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
