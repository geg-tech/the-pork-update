
package geg.tech.Effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
/*
public class FeelFullEffect extends MobEffect {
    protected FeelFullEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xffe599);
    } //first entry shows its a buff, second is a color (rgb, 0x(color in rgb))

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    } //check if the effect can be applied every tick

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity instanceof Player) {
            /* MobEffectInstance buh = new MobEffectInstance(
                    MobEffects.MOVEMENT_SPEED,
                    5, //duration, defaults to 0
                    amplifier, //amplifier
                    false,//true is the effect can only be given by beacons/conduit
                    true, //shows up in inventory
                    true); //shows up in the screen


            // ((Player) entity).addEffect(cuh);

            */
            //add stuff here later if you wanna
        //}
        //this basically got replaced in PorkinEffects.java, left here as a reference/template for later use

        //return super.applyEffectTick(entity, amplifier);
    //}

//}

