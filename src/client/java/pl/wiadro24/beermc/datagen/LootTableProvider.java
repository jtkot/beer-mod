package pl.wiadro24.beermc.datagen;

import com.google.common.collect.ImmutableSet;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class LootTableProvider {
  public static net.minecraft.data.loot.LootTableProvider create(
      PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture) {
    return new net.minecraft.data.loot.LootTableProvider(
        packOutput,
        ImmutableSet.of(),
        List.of(
            new net.minecraft.data.loot.LootTableProvider.SubProviderEntry(
                BlockLootProvider::new, LootContextParamSets.BLOCK)),
        completableFuture);
  }
}
