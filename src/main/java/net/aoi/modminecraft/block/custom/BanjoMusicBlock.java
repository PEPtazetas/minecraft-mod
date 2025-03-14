package net.aoi.modminecraft.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;
import java.util.Random;

public class BanjoMusicBlock extends Block {
    public BanjoMusicBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        Random rand = new Random();
        int n = rand.nextInt(3);
        SoundEvent soundEvent = null;
        if (n == 0){
            soundEvent = SoundEvents.NOTE_BLOCK_GUITAR.get();
        }else if(n == 1){
            soundEvent = SoundEvents.NOTE_BLOCK_BANJO.get();
        }else{
            soundEvent = SoundEvents.NOTE_BLOCK_BASS.get();
        }

        pLevel.playSound(pPlayer, pPos, soundEvent, SoundSource.BLOCKS, 1f, 1f);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pTooltipComponents, List<Component> pList, TooltipFlag pTooltipFlag) {
        pList.add(Component.literal("suena a banjo cuando lo toca"));
        super.appendHoverText(pStack, pTooltipComponents, pList, pTooltipFlag);
    }
}
