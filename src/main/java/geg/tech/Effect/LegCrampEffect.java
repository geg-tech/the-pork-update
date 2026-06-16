package geg.tech.Effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class LegCrampEffect extends MobEffect {

    protected LegCrampEffect() {
        super(MobEffectCategory.HARMFUL, 0x3d331c);
    } //first entry shows its a debuff, second is a color (rgb, 0x(color in rgb))

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    } //check if the effect can be applied every tick

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {

        if (entity instanceof Player) {
            ((Player) entity).hurt(entity.damageSources().dragonBreath(), 4.0F); // hurt the player a ton
            // ^ replace later with custom damage source
        }

        return super.applyEffectTick(entity, amplifier);
    }

}
