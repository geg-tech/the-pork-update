package geg.tech.Blocks;
import geg.tech.Items.ModItems;
import geg.tech.porkin;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModBlocks {
    //make a new block
    public static final Block PORK_BLOCK = register(
            new Block(
                    BlockBehaviour.Properties.of().sound(SoundType.SLIME_BLOCK)
            ),
            "pork_block",
            true
    );

    //registering
    public static Block register(Block block, String name, boolean shouldRegisterItem) {
        // register da bloc
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(porkin.MOD_ID, name);

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:air` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Properties());
            Registry.register(BuiltInRegistries.ITEM, id, blockItem);
        }

        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    public static void initialize() {
        //its just a dummy initialize method..! dummy... *pouts*

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register((itemGroup) -> {
            itemGroup.accept(ModBlocks.PORK_BLOCK.asItem());
        });
    }
}
