package pl.wiadro24.beermc;

import net.minecraft.core.Holder;
import net.minecraft.core.Holder.Reference;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class SoundEvents {
  public static final Reference<SoundEvent> BEER_BURP = registerForHolder("burp");

  @SuppressWarnings("unused")
  private static SoundEvent register(String path) {
    return register(ResourceLocation.fromNamespaceAndPath(BeerMod.NAMESPACE, path));
  }

  private static Holder.Reference<SoundEvent> registerForHolder(String path) {
    return registerForHolder(ResourceLocation.fromNamespaceAndPath(BeerMod.NAMESPACE, path));
  }

  @SuppressWarnings("unused")
  private static Holder<SoundEvent> register(
      ResourceLocation resourceLocation, ResourceLocation resourceLocation2, float f) {
    return Registry.registerForHolder(
        BuiltInRegistries.SOUND_EVENT,
        resourceLocation,
        SoundEvent.createFixedRangeEvent(resourceLocation2, f));
  }

  private static SoundEvent register(ResourceLocation resourceLocation) {
    return register(resourceLocation, resourceLocation);
  }

  private static Holder.Reference<SoundEvent> registerForHolder(ResourceLocation resourceLocation) {
    return registerForHolder(resourceLocation, resourceLocation);
  }

  private static SoundEvent register(
      ResourceLocation resourceLocation, ResourceLocation resourceLocation2) {
    return Registry.register(
        BuiltInRegistries.SOUND_EVENT,
        resourceLocation,
        SoundEvent.createVariableRangeEvent(resourceLocation2));
  }

  private static Holder.Reference<SoundEvent> registerForHolder(
      ResourceLocation resourceLocation, ResourceLocation resourceLocation2) {
    return Registry.registerForHolder(
        BuiltInRegistries.SOUND_EVENT,
        resourceLocation,
        SoundEvent.createVariableRangeEvent(resourceLocation2));
  }
}
