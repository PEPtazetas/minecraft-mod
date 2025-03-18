package net.aoi.modminecraft.datagen;

import net.aoi.modminecraft.ModMinecraft;
import net.aoi.modminecraft.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
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

        blockWithItem(ModBlocks.OXIWOOD_PLANKS);

        blockWithItem(ModBlocks.FLORITA_ORE);

        blockWithItem(ModBlocks.BANJO_MUSIC_BLOCK);

        stairsBlock(((StairBlock)ModBlocks.OXIWOOD_STAIRS.get()), blockTexture(ModBlocks.OXIWOOD_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.OXIWOOD_SLAB.get()), blockTexture(ModBlocks.OXIWOOD_PLANKS.get()), blockTexture(ModBlocks.OXIWOOD_PLANKS.get()));

        buttonBlock(((ButtonBlock) ModBlocks.OXIWOOD_BUTTON.get()), blockTexture(ModBlocks.OXIWOOD_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.OXIWOOD_PRESSURE_PLATE.get()), blockTexture(ModBlocks.OXIWOOD_PLANKS.get()));

        fenceBlock(((FenceBlock) ModBlocks.OXIWOOD_FENCE.get()), blockTexture(ModBlocks.OXIWOOD_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.OXIWOOD_FENCE_GATE.get()), blockTexture(ModBlocks.OXIWOOD_PLANKS.get()));
        wallBlock(((WallBlock) ModBlocks.OXIWOOD_WALL.get()), blockTexture(ModBlocks.OXIWOOD_PLANKS.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.OXIWOOD_DOOR.get()), modLoc("block/oxiwood_door_bottom"), modLoc("block/oxiwood_door_top"),"cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.OXIWOOD_TRAPDOOR.get()), modLoc("block/oxiwood_trapdoor"), true, "cutout");

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
