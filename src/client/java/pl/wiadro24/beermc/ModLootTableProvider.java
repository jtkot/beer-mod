package pl.wiadro24.beermc;

import com.google.common.collect.ImmutableSet;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class ModLootTableProvider {
  public static LootTableProvider create(
      PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture) {
    return new LootTableProvider(
        packOutput,
        ImmutableSet.of(),
        List.of(
            new LootTableProvider.SubProviderEntry(ModBlockLoot::new, LootContextParamSets.BLOCK)),
        completableFuture);
  }
}
