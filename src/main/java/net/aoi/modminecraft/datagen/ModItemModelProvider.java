package net.aoi.modminecraft.datagen;

import net.aoi.modminecraft.ModMinecraft;
import net.aoi.modminecraft.block.ModBlocks;
import net.aoi.modminecraft.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ModMinecraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ARGENTO);
        simpleItem(ModItems.CALENTO);
        simpleItem(ModItems.FLORITA);
        simpleItem(ModItems.FLORITA_INGOT);
        simpleItem(ModItems.STRAWBERRY);
        simpleItem(ModItems.SANDWICH);
        simpleItem(ModItems.LEAF);
        simpleItem(ModItems.MINERAL_SEEKER);

        simpleBlockItem(ModBlocks.OXIWOOD_DOOR);

        evenSimpleBlockItem(ModBlocks.OXIWOOD_STAIRS);
        evenSimpleBlockItem(ModBlocks.OXIWOOD_FENCE_GATE);
        evenSimpleBlockItem(ModBlocks.OXIWOOD_SLAB);
        evenSimpleBlockItem(ModBlocks.OXIWOOD_PRESSURE_PLATE);
        trapdoorItem(ModBlocks.OXIWOOD_TRAPDOOR);


        fenceItem(ModBlocks.OXIWOOD_FENCE, ModBlocks.OXIWOOD_PLANKS);
        buttonItem(ModBlocks.OXIWOOD_BUTTON, ModBlocks.OXIWOOD_PLANKS);
        wallItem(ModBlocks.OXIWOOD_WALL, ModBlocks.OXIWOOD_PLANKS);
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ModMinecraft.MOD_ID,"item/" + item.getId().getPath()));
    }
    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> block){
        return withExistingParent(block.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ModMinecraft.MOD_ID,"item/" + block.getId().getPath()));
    }
    public void evenSimpleBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(ModMinecraft.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ModMinecraft.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(ModMinecraft.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(ModMinecraft.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", new ResourceLocation(ModMinecraft.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

}
