package pl.wiadro24.beermc;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class Consumables {
  public static Consumable.Builder beer() {
    return Consumable.builder()
        .animation(ItemUseAnimation.DRINK)
        .sound(net.minecraft.sounds.SoundEvents.GENERIC_DRINK)
        .soundAfterConsume(SoundEvents.BEER_BURP)
        .consumeSeconds(5)
        .hasConsumeParticles(false)
        .onConsume(
            new ApplyStatusEffectsConsumeEffect(
                new MobEffectInstance(MobEffects.NAUSEA, 250), 10000.0f));
  }
}
