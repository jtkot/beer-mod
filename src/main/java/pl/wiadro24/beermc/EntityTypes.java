package pl.wiadro24.beermc;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class EntityTypes<T extends Entity> {
  public static final EntityType<BeerMugProjectile> BEER_MUG =
      register(
          "beer_mug",
          EntityType.Builder.<BeerMugProjectile>of(BeerMugProjectile::new, MobCategory.MISC)
              .noLootTable()
              .sized(0.25F, 0.25F)
              .clientTrackingRange(4)
              .updateInterval(10));

  private static <T extends Entity> EntityType<T> register(
      ResourceKey<EntityType<?>> resourceKey, EntityType.Builder<T> builder) {
    return Registry.register(
        BuiltInRegistries.ENTITY_TYPE, resourceKey, builder.build(resourceKey));
  }

  private static ResourceKey<EntityType<?>> modEntityId(String path) {
    return ResourceKey.create(
        Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(BeerMod.NAMESPACE, path));
  }

  private static <T extends Entity> EntityType<T> register(
      String string, EntityType.Builder<T> builder) {
    return register(modEntityId(string), builder);
  }
}
