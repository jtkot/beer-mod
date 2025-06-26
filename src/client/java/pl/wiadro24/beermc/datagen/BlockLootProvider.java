package pl.wiadro24.beermc.datagen;

import com.google.common.collect.ImmutableSet;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.function.BiConsumer;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import pl.wiadro24.beermc.Blocks;

public class BlockLootProvider extends BlockLootSubProvider {
  private static final ImmutableSet<Block> modBlocks = ImmutableSet.of(Blocks.BREWING_VAT);
  private static final Set<Item> EXPLOSION_RESISTANT = ImmutableSet.of();

  public BlockLootProvider(HolderLookup.Provider provider) {
    super(EXPLOSION_RESISTANT, FeatureFlags.REGISTRY.allFlags(), provider);
  }

  @Override
  public void generate() {
    this.dropSelf(Blocks.BREWING_VAT);
  }

  @Override
  public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer) {
    this.generate();
    Set<ResourceKey<LootTable>> set = new HashSet<>();
    for (Block block : modBlocks) {
      if (block.isEnabled(this.enabledFeatures)) {
        block
            .getLootTable()
            .ifPresent(
                resourceKey -> {
                  if (set.add(resourceKey)) {
                    LootTable.Builder builder = (LootTable.Builder) this.map.remove(resourceKey);
                    if (builder == null) {
                      throw new IllegalStateException(
                          String.format(
                              Locale.ROOT,
                              "Missing loottable '%s' for '%s'",
                              resourceKey.location(),
                              BuiltInRegistries.BLOCK.getKey(block)));
                    }

                    biConsumer.accept(resourceKey, builder);
                  }
                });
      }
    }
  }
}
