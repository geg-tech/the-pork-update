package geg.tech.Items;
import geg.tech.Items.Tool.CleaverMaterial;
import geg.tech.porkin;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.mixin.content.registry.AxeItemAccessor;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;


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
            new Item(new Item.Properties()
                    .food(BUFF_FOOD)),
            "ultrapork"
    );
    //make bacon item
    public static final Item RAW_BACON = register(
            new Item(new Item.Properties()
                    .food(RAWSNACK)),
            "raw_bacon"
    );
    //make cooked bacon
    public static final Item COOKED_BACON = register(
            new Item(new Item.Properties()
                    .food(COOKEDSNACK)),
            "cooked_bacon"
    );
    //make full breakfast
    public static final Item HEARTY_BREAKFAST = register(
            new Item(new Item.Properties()
                    .food(BREAKFAST)
                    .stacksTo(1)
                    .rarity(Rarity.UNCOMMON)), //adding rarity here changes the name color
            "hearty_breakfast"
    );
    //make cleaver
    public static final Item CLEAVER = register(
            new SwordItem(CleaverMaterial.INSTANCE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(CleaverMaterial.INSTANCE, 1, -2f))
                    .craftRemainder(ModItems.CLEAVER) // (head to Items.java for info)
                    .stacksTo(1) //stack to 1 cleaver only
            ), //make custom stats above ^ (dagger like stats, enchantability of a sword)
            "cleaver"
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
        ItemGroupEvents.modifyEntriesEvent((CreativeModeTabs.TOOLS_AND_UTILITIES))
                .register((itemGroup) -> {
                    itemGroup.accept(ModItems.CLEAVER);
                });

    }

}

