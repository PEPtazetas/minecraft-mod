package net.aoi.modminecraft.items;

import net.aoi.modminecraft.util.ModTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier ARGENTO = new ForgeTier(
            2000, // Durability
            9.0F, // Speed
            4.0F, // Damage
            22, // Enchantablitiy
            ModTags.Blocks.NEEDS_ARGENTO_TOOL, // Tag for blocks that the tier can mine
            () -> Ingredient.of(ModItems.ARGENTO.get()), // Repair material
            ModTags.Blocks.INCORRECT_FOR_ARGENTO_TOOL // Tag for incorrect blocks (i.e., blocks this tier can't mine)
    );
}
