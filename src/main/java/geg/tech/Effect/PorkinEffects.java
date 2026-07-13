
package geg.tech.Effect;

import geg.tech.porkin;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class PorkinEffects implements ModInitializer {
    //make feelin full effect (buff from breakfast item)
    public static final Holder<MobEffect> FEELIN_FULL =
            Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, Identifier.fromNamespaceAndPath(porkin.MOD_ID, "feelin_full"),
                    new FeelinFullEffect() //add stat effects below, this effect gives defense/healing n what not but makes you FAT.
                            .addAttributeModifier(Attributes.MOVEMENT_SPEED, Identifier.withDefaultNamespace("slow"),-0.02, AttributeModifier.Operation.ADD_VALUE)
                            .addAttributeModifier(Attributes.ARMOR, Identifier.withDefaultNamespace("stronk"), 5.0, AttributeModifier.Operation.ADD_VALUE)
                            .addAttributeModifier(Attributes.ARMOR_TOUGHNESS, Identifier.withDefaultNamespace("stronk2"), 7.0, AttributeModifier.Operation.ADD_VALUE)
                            .addAttributeModifier(Attributes.MAX_ABSORPTION, Identifier.withDefaultNamespace("hunk"), 10.0, AttributeModifier.Operation.ADD_VALUE)
            );
    //make leg cramp effect (debuff from slop bowl/pork licker)
    //make this later once i get wifi so hackatime can track
    public static final Holder<MobEffect> LEG_CRAMP =
            Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, Identifier.fromNamespaceAndPath(porkin.MOD_ID, "leg_cramp"),
                    new LegCrampEffect()
                            .addAttributeModifier(Attributes.MOVEMENT_SPEED, Identifier.withDefaultNamespace("slowing"), -0.05, AttributeModifier.Operation.ADD_VALUE)
                            .addAttributeModifier(Attributes.GRAVITY, Identifier.withDefaultNamespace("heavy"), 0.50, AttributeModifier.Operation.ADD_VALUE)
                            .addAttributeModifier(Attributes.FALL_DAMAGE_MULTIPLIER, Identifier.withDefaultNamespace("ouchielegs"), 500.0, AttributeModifier.Operation.ADD_VALUE)
                            .addAttributeModifier(Attributes.SAFE_FALL_DISTANCE, Identifier.withDefaultNamespace("mylegs"), -50.0, AttributeModifier.Operation.ADD_VALUE)
                            .addAttributeModifier(Attributes.JUMP_STRENGTH, Identifier.withDefaultNamespace("comediceffect"), 1.0, AttributeModifier.Operation.ADD_VALUE)
            );

    @Override
    public void onInitialize() {

    }
}



