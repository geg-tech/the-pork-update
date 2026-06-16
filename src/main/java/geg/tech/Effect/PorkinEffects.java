package geg.tech.Effect;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class PorkinEffects implements ModInitializer {
    public static final Holder<MobEffect> FEELFULL;
    public static final Holder<MobEffect> LEGCRAMP;
    public static final Holder<MobEffect> RAPTURE;

    static {
        FEELFULL = Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, ResourceLocation.fromNamespaceAndPath("porkin", "feel_full"), //register effect
                new FeelFullEffect() //add effects to the mob effect (see MobEffects.java for info)
                        .addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath("porkin", "feel_full"), 0.3F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                        .addAttributeModifier(Attributes.MAX_HEALTH, ResourceLocation.fromNamespaceAndPath("porkin", "feel_full"), 6F, AttributeModifier.Operation.ADD_VALUE)
                        .addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath("porkin", "feel_full"), 0.4F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
        );
        LEGCRAMP = Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, ResourceLocation.fromNamespaceAndPath("porkin","leg_cramp"),
                new LegCrampEffect() //slow down the player and apply the class effect in LegCrampEffect.java
                        .addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath("porkin", "leg_cramp"), -10F, AttributeModifier.Operation.ADD_VALUE)
                        .addAttributeModifier(Attributes.ARMOR, ResourceLocation.fromNamespaceAndPath("porkin", "leg_cramp"), -100F,AttributeModifier.Operation.ADD_VALUE)
                        .addAttributeModifier(Attributes.GRAVITY, ResourceLocation.fromNamespaceAndPath("porkin", "leg_cramp"), 100F, AttributeModifier.Operation.ADD_VALUE)
                        .addAttributeModifier(Attributes.JUMP_STRENGTH, ResourceLocation.fromNamespaceAndPath("porkin", "leg_cramp"), 2.5F,AttributeModifier.Operation.ADD_VALUE)
                        .addAttributeModifier(Attributes.FALL_DAMAGE_MULTIPLIER, ResourceLocation.fromNamespaceAndPath("porkin", "leg_cramp"), 100F, AttributeModifier.Operation.ADD_VALUE)
        );
        RAPTURE = Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, ResourceLocation.fromNamespaceAndPath("porkin", "rapture"), //register effect
                new FeelFullEffect()
                        .addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath("porkin", "rapture"), 10F, AttributeModifier.Operation.ADD_VALUE)
                        .addAttributeModifier(Attributes.GRAVITY, ResourceLocation.fromNamespaceAndPath("porkin", "rapture"), -0.5F, AttributeModifier.Operation.ADD_VALUE)
        );
    }

    @Override
    public void onInitialize() {

    }
}

/*

 */