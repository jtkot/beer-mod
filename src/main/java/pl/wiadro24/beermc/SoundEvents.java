package pl.wiadro24.beermc;

import net.minecraft.core.Holder;
import net.minecraft.core.Holder.Reference;
import net.minecraft.sounds.SoundEvent;
import pl.wiadro24.beermc.api.Registerer;

public class SoundEvents {
  public static final Reference<SoundEvent> BEER_BURP = registerForHolder("burp");

  private static Holder.Reference<SoundEvent> registerForHolder(String name) {
    return Registerer.registerSoundEventForHolder(Mod.NAMESPACE.createSoundEventKey(name));
  }
}
