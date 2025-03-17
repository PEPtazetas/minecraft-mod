package net.aoi.modminecraft.datagen;

import net.aoi.modminecraft.ModMinecraft;
import net.aoi.modminecraft.block.ModBlocks;
import net.aoi.modminecraft.items.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public static final List<ItemLike> FLORITA_SMELTABLES = List.of(ModItems.FLORITA.get(),
            ModBlocks.FLORITA_ORE.get());

    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }


    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        oreSmelting(recipeOutput,FLORITA_SMELTABLES, RecipeCategory.MISC,ModItems.FLORITA_INGOT.get(), 0.25f, 200, "florita_ingot");
        oreBlasting(recipeOutput,FLORITA_SMELTABLES, RecipeCategory.MISC,ModItems.FLORITA_INGOT.get(), 0.25f, 100, "florita_ingot");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CALENTO.get())
                .pattern("E")
                .pattern("A")
                .define('E', Items.EMERALD)
                .define('A', ModItems.ARGENTO.get())
                .unlockedBy(getHasName(ModItems.ARGENTO.get()), has(ModItems.CALENTO.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.SANDWICH.get())
                .pattern("AE")
                .define('E', Items.COOKED_PORKCHOP)
                .define('A', Items.BREAD)
                .unlockedBy(getHasName(Items.BREAD), has(ModItems.SANDWICH.get()))
                .save(recipeOutput);
    }
    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<T> pSerializer, AbstractCookingRecipe.Factory<T> pRecipeFactory, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        Iterator var10 = pIngredients.iterator();

        while(var10.hasNext()) {
            ItemLike itemlike = (ItemLike)var10.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                    pExperience, pCookingTime, pSerializer, pRecipeFactory)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, ModMinecraft.MOD_ID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }

    }
}
