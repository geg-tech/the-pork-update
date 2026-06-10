package geg.tech.Items;
import geg.tech.Porkin;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;


public class ModItems {

    public static final Item ULTRAPORK = register(
            new Item(new Item.Properties()),
            "ultrapork"
    );

    public static Item register(Item item, String id) {
        //This Shit Sucks Ass Bruh.
        ResourceLocation itemID = ResourceLocation.fromNamespaceAndPath(Porkin.MOD_ID, id);

        Item registeredItem = Registry.register(BuiltInRegistries.ITEM, itemID, item);

        return registeredItem;
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS)
                .register((itemGroup) -> itemGroup.accept(ModItems.ULTRAPORK));

    }

}

