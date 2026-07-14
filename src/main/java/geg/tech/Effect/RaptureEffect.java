package geg.tech.Effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class RaptureEffect extends MobEffect {
    protected RaptureEffect() {
        super(MobEffectCategory.HARMFUL, 0xf7ffab);
    } //first entry shows its a buff, second is a color (rgb, 0x(color in rgb))

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    } //check if the effect can be applied every tick

}
