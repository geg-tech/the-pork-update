package geg.tech.Items;
import geg.tech.porkin;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;


public class ModItems {

    //these edibles aint shit
    public static final FoodProperties BUFF_FOOD = new FoodProperties.Builder() //ultrapork
            .alwaysEdible()
            // The duration is in ticks, 20 ticks = 1 second
            .effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 60 * 20, 4), 1.0f)
            .build(); //i controls duration (60 s times 20 ticks, j controls level (0 = level 1)
    public static final FoodProperties BREAKFAST = new FoodProperties.Builder()
            .nutrition(10)
            .saturationModifier(15)//full breakfast
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 60 * 20, 4), 1.0f) //placeholder, make custom effect here
            .usingConvertsTo(Items.BOWL)
            .build();
    public static final FoodProperties RAWSNACK = new FoodProperties.Builder() //bacon
            .fast()
            .nutrition(2)
            .saturationModifier(1)
            .build();
    public static final FoodProperties COOKEDSNACK = new FoodProperties.Builder() //bacon
            .fast()
            .nutrition(3)
            .saturationModifier(3)
            .build();

    //make ultrapork item (boss drop)
    public static final Item ULTRAPORK = register(
            new Item(new Item.Properties().food(BUFF_FOOD)),
            "ultrapork"
    );
    //make bacon item
    public static final Item RAW_BACON = register(
            new Item(new Item.Properties().food(RAWSNACK)),
            "raw_bacon"
    );
    //make cooked bacon
    public static final Item COOKED_BACON = register(
            new Item(new Item.Properties().food(COOKEDSNACK)),
            "cooked_bacon"
    );
    //make full breakfast
    public static final Item HEARTY_BREAKFAST = register(
            new Item(new Item.Properties().food(BREAKFAST).rarity(Rarity.UNCOMMON)), //adding rarity here changes the name color
            "hearty_breakfast"
    );

    //code to register stuff
    public static Item register(Item item, String id) {
        //This Shit Sucks Ass Bruh.
        ResourceLocation itemID = ResourceLocation.fromNamespaceAndPath(porkin.MOD_ID, id);

        Item registeredItem = Registry.register(BuiltInRegistries.ITEM, itemID, item);

        return registeredItem;
    }
    //initialize items and add them to creative tabs
    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                .register((itemGroup) -> {
                    itemGroup.accept(ModItems.ULTRAPORK);
                    itemGroup.accept(ModItems.COOKED_BACON);
                    itemGroup.accept(ModItems.RAW_BACON);
                    itemGroup.accept(ModItems.HEARTY_BREAKFAST);
                });

    }

}

