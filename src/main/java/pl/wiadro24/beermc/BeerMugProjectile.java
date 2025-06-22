package pl.wiadro24.beermc;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class BeerMugProjectile extends ThrowableItemProjectile {
  public BeerMugProjectile(EntityType<? extends BeerMugProjectile> entityType, Level level) {
    super(entityType, level);
  }

  public BeerMugProjectile(Level level, LivingEntity livingEntity, ItemStack itemStack) {
    super(EntityTypes.BEER_MUG, livingEntity, level, itemStack);
  }

  public BeerMugProjectile(Level level, double d, double e, double f, ItemStack itemStack) {
    super(EntityTypes.BEER_MUG, d, e, f, level, itemStack);
  }

  @Override
  protected Item getDefaultItem() {
    return Items.EMPTY_BEER_MUG;
  }

  @Override
  public void handleEntityEvent(byte b) {
    if (b == 3) {}
  }

  @Override
  protected void onHit(HitResult hitResult) {
    super.onHit(hitResult);
    if (!this.level().isClientSide) {
      this.level().broadcastEntityEvent(this, (byte) 3);
      this.discard();
    }
  }
}
