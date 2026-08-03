
package geg.tech.Blocks;
import geg.tech.Items.ModItems;
import geg.tech.porkin;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlocks {
    //make a new block
    public static final Block PORK_BLOCK = register(
            "pork_block", //String name
            Block::new, //blockFactory
            BlockBehaviour.Properties.of() //BlockBehavior, tack on more properties under here
                    .sound(SoundType.SLIME_BLOCK)
                    .friction(0),
            true
    );

    //registering
    public static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
        //registery key fo da bloc
        ResourceKey<Block> blockKey = keyOfBlock(name);
        //instance
        Block block = blockFactory.apply(settings.setId(blockKey));

        //but what if ion wanna register the block
        if (shouldRegisterItem) {
            ResourceKey<Item> itemKey = keyOfItem(name);
            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        }

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block); //register the block
    }

    //related functions to register
    public static ResourceKey<Block> keyOfBlock(String name){
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(porkin.MOD_ID, name));
    }

    public static ResourceKey<Item> keyOfItem(String name){
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(porkin.MOD_ID, name));
    }

    public static void initialize() {
        //its just a dummy initialize method..! dummy... *pouts*

        ItemGroupEvents.modifyEntriesEvent(ModItems.PORK_MOD_GROUP_KEY).register((itemGroup) -> {
            itemGroup.accept(ModBlocks.PORK_BLOCK.asItem());
        });
    }
}
