package net.aoi.modminecraft.items.custom;

import net.aoi.modminecraft.block.ModBlocks;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class MineralSeekerItem extends Item {
    public MineralSeekerItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()){
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();

            boolean foundBlock = false;

            for (int i = 0; i<= positionClicked.getY() + 64; i++) {
                BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));
                
                if (isValuableBlock(state)) {
                    outputValuableCoordinates(positionClicked.below(i), player, state.getBlock());
                    foundBlock = true;
                    break;
                }
            }

            if (!foundBlock) {
                player.sendSystemMessage(Component.literal("No se ha encontrado ningun mineral"));
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), EquipmentSlot.MAINHAND);

        return InteractionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos blockpos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Se encontro " + I18n.get(block.getDescriptionId()) + " at ("
                + blockpos.getX() + ", " + blockpos.getY() + ", " + blockpos.getZ() + ")"));
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(Blocks.IRON_ORE) || state.is(Blocks.COAL_ORE)
                || state.is(Blocks.GOLD_ORE) || state.is(Blocks.DIAMOND_ORE)
                || state.is(Blocks.ANCIENT_DEBRIS) || state.is(ModBlocks.ARGENTO_ORE.getKey())
                || state.is(ModBlocks.CALENTO_ORE.getKey()) || state.is(ModBlocks.FLORITA_ORE.getKey());
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("tooltip.modminecraft.mineral_seeker.tooltip"));
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
