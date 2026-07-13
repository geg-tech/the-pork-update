
package geg.tech.Effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class FeelinFullEffect extends MobEffect {
    protected FeelinFullEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xffe599);
    } //first entry shows its a buff, second is a color (rgb, 0x(color in rgb))

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    } //check if the effect can be applied every tick

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
        if (entity.getHealth() < entity.getMaxHealth()) {
            entity.heal(1.0F); //heal one hp per tick
        }

        return super.applyEffectTick(level, entity, amplifier);
    }
}

