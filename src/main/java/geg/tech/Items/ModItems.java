package geg.tech.Items;
// import geg.tech.Effect.PorkinEffects;
// import geg.tech.Items.Tool.CleaverMaterial;
import geg.tech.porkin;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.mixin.content.registry.AxeItemAccessor;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
// import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;


public class ModItems {

        //these edibles aint shit
        //1.21.11 made food items a two part process (consumables -> effects and such, foodprop -> food stats)
    //ultrapork food mechanics
    public static final Consumable BUFF_FOOD_CONSUMABLE_COMPONENT = Consumables.defaultFood()
            // apply effects with ts
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 20 * 60, 1), 1.0f))
            .build();
    public static final FoodProperties BUFF_FOOD_COMPONENT = new FoodProperties.Builder()
            .alwaysEdible()
            .nutrition(5)
            .saturationModifier(3)
            .build();
    //raw bacon food mechanics
    public static final Consumable RAW_BACON_CONSUMABLE_COMPONENT = Consumables.defaultFood()
            // apply effects with ts
            .consumeSeconds(0.8f) //the eat time for quick foods like dried kelp is 0.8 seconds
            .build();
    public static final FoodProperties RAW_BACON_COMPONENT = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(1)
            .build();
    //cooked bacon food mechanics
    public static final Consumable COOKED_BACON_CONSUMABLE_COMPONENT = Consumables.defaultFood()
            // apply effects with ts
            .consumeSeconds(0.8f) //copy the same eat time as the raw bacon
            .build();
    public static final FoodProperties COOKED_BACON_COMPONENT = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(4)
            .build();
    //breakfast item food mechanics
    public static final Consumable BREAKFAST_CONSUMABLE_COMPONENT = Consumables.defaultFood()
            // apply effects with ts
            .consumeSeconds(2.0f)
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 20*60, 0), 1.0f))
            // ^ placeholder until i port over custom effects
            .build();
    public static final FoodProperties BREAKFAST_COMPONENT = new FoodProperties.Builder()
            .nutrition(10)
            .saturationModifier(15) //yummy!
            .build();
    //lard bottle mechanics
    public static final Consumable FAT_BOTTLE_CONSUMABLE_COMPONENT = Consumables.defaultDrink() //idk what the difference between drink and food is tbh
            // apply effects with ts
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SLOWNESS, 20*20, 2), 1.0f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.MINING_FATIGUE, 20*20, 2), 1.0f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NAUSEA, 20*20, 2), 1.0f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HUNGER, 20*20, 4), 1.0f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.INSTANT_DAMAGE, 20*20, 4), 1.0f))
            // ^ might make a custom "lethargic" effect, not sure tbh
            // note to self: haste increases both attack speed and mining speed oddly enough
            .consumeSeconds(3.0f)
            .sound(SoundEvents.HONEY_DRINK)
            .animation(ItemUseAnimation.DRINK)
            .soundAfterConsume(SoundEvents.GENERIC_EXPLODE)
            .build();
    public static final FoodProperties FAT_BOTTLE_COMPONENT = new FoodProperties.Builder()
            .nutrition(1)
            .saturationModifier(5) //yuck!
            .alwaysEdible()
            .build();

        //ok start making items
    //make boss drop
    public static final Item ULTRAPORK = register(
            "ultrapork", Item::new,
            new Item.Properties()
                    .food(BUFF_FOOD_COMPONENT,BUFF_FOOD_CONSUMABLE_COMPONENT)
    );
    //make raw bacon
    public static final Item RAW_BACON = register(
            "raw_bacon", Item::new,
            new Item.Properties()
                    .food(RAW_BACON_COMPONENT,RAW_BACON_CONSUMABLE_COMPONENT)
    );
    //make cooked bacon
    public static final Item COOKED_BACON = register(
            "cooked_bacon", Item::new,
            new Item.Properties()
                    .food(COOKED_BACON_COMPONENT,COOKED_BACON_CONSUMABLE_COMPONENT)
    );
    //make breakfast item
    public static final Item HEARTY_BREAKFAST = register(
            "hearty_breakfast", HeartyBreakfast::new,
            new Item.Properties()
                    .food(BREAKFAST_COMPONENT,BREAKFAST_CONSUMABLE_COMPONENT)
                    .stacksTo(1)
                    .rarity(Rarity.UNCOMMON)
                    .usingConvertsTo(Items.BOWL)
    );
    //make bottle of fat item
    public static final Item FAT_BOTTLE = register(
            "fat_bottle", BottleOfFat::new,
            new Item.Properties()
                    .food(FAT_BOTTLE_COMPONENT,FAT_BOTTLE_CONSUMABLE_COMPONENT)
                    .stacksTo(1)
                    .usingConvertsTo(Items.GLASS_BOTTLE)
    );
    //make cleaver item
    public static final Item CLEAVER = register(
      "cleaver", Item::new,
            new Item.Properties()
                    .sword(ToolMaterial.IRON, 1f, -1f)
                    // .food(BREAKFAST_COMPONENT,BREAKFAST_CONSUMABLE_COMPONENT) have your knife and eat it!
                    .craftRemainder(ModItems.CLEAVER)
                    .stacksTo(1)
    );

    //make custom creative tab
    public static final ResourceKey<CreativeModeTab> PORK_MOD_GROUP_KEY =
            ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(porkin.MOD_ID, "item_group"));
    public static final CreativeModeTab PORK_MOD_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.ULTRAPORK))
            .title(Component.translatable("itemGroup.porkin"))
            .build();


    //code to register stuff
    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
        // create da item jey
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(porkin.MOD_ID, name));

        // create da instance
        T item = itemFactory.apply(settings.setId(itemKey));

        // register
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }
    //initialize items and add them to creative tabs
    public static void initialize() {
        //register the custom tab
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, PORK_MOD_GROUP_KEY, PORK_MOD_GROUP);

        ItemGroupEvents.modifyEntriesEvent(PORK_MOD_GROUP_KEY).register((itemGroup) -> {
            itemGroup.accept(ModItems.ULTRAPORK); //slap all em items into the group
            itemGroup.accept(ModItems.RAW_BACON);
            itemGroup.accept(ModItems.COOKED_BACON);
            itemGroup.accept(ModItems.FAT_BOTTLE);
            itemGroup.accept(ModItems.HEARTY_BREAKFAST);
            itemGroup.accept(ModItems.CLEAVER);
        });

    }

}

