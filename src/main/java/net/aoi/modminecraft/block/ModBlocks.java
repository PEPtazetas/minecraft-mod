package net.aoi.modminecraft.block;

import net.aoi.modminecraft.ModMinecraft;
import net.aoi.modminecraft.block.custom.BanjoMusicBlock;
import net.aoi.modminecraft.items.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS= DeferredRegister.create(ForgeRegistries.BLOCKS, ModMinecraft.MOD_ID);

    public static final RegistryObject<Block> ARGENTO_ORE =registerBlock("argento_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> CALENTO_ORE =registerBlock("calento_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> FLORITA_ORE =registerBlock("florita_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE).sound(SoundType.STONE)));

    public static final RegistryObject<Block> BANJO_MUSIC_BLOCK =registerBlock("banjo_music_block",
            () -> new BanjoMusicBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));

    public static final RegistryObject<Block> DEEPSLATE_ARGENTO_ORE = registerBlock("deepslate_argento_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,6), BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)
                    .sound(SoundType.AMETHYST).strength(3f).requiresCorrectToolForDrops()));

    private static <T extends Block> RegistryObject <T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T>toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject <Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
