package net.aoi.modminecraft.datagen;

import net.aoi.modminecraft.ModMinecraft;
import net.aoi.modminecraft.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
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
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ModMinecraft.MOD_ID,"item/" + item.getId().getPath()));
    }
}
