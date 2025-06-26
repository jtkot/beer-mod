package pl.wiadro24.beermc.api.mixin;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(EntityType.class)
public interface EntityTypeMixin {
  @Invoker
  public static <T extends Entity> EntityType<T> callRegister(
      ResourceKey<EntityType<?>> resourceKey, EntityType.Builder<T> builder) {
    return null;
  }
}
