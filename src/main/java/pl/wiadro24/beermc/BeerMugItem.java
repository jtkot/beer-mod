package pl.wiadro24.beermc;

import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;

public class BeerMugItem extends Item implements ProjectileItem {
  public static float PROJECTILE_SHOOT_POWER = 1.5F;

  public BeerMugItem(Item.Properties properties) {
    super(properties);
  }

  @Override
  public InteractionResult use(Level level, Player player, InteractionHand interactionHand) {
    ItemStack itemStack = player.getItemInHand(interactionHand);
    level.playSound(
        null,
        player.getX(),
        player.getY(),
        player.getZ(),
        SoundEvents.SPLASH_POTION_BREAK,
        SoundSource.NEUTRAL,
        0.5F,
        0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
    if (level instanceof ServerLevel serverLevel) {
      Projectile.spawnProjectileFromRotation(
          BeerMugProjectile::new,
          serverLevel,
          itemStack,
          player,
          0.0F,
          PROJECTILE_SHOOT_POWER,
          1.0F);
    }

    player.awardStat(Stats.ITEM_USED.get(this));
    itemStack.consume(1, player);
    return InteractionResult.SUCCESS;
  }

  @Override
  public Projectile asProjectile(
      Level level, Position position, ItemStack itemStack, Direction direction) {
    return new BeerMugProjectile(level, position.x(), position.y(), position.z(), itemStack);
  }
}
