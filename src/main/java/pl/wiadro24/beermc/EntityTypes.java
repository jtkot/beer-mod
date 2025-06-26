package pl.wiadro24.beermc;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import pl.wiadro24.beermc.api.Registerer;

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
      String name, EntityType.Builder<T> builder) {
    return Registerer.registerEntityType(Mod.NAMESPACE.createEntityTypeKey(name), builder);
  }
}
