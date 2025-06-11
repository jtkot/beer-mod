package pl.wiadro24.beermc.datagen;

import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.PoiTypeTags;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import pl.wiadro24.beermc.BeerMod;

public class ModPoiTagProvider extends TagsProvider<PoiType> {
  public ModPoiTagProvider(
      PackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
    super(output, Registries.POINT_OF_INTEREST_TYPE, registryLookupFuture);
  }

  @Override
  protected void addTags(HolderLookup.Provider lookup) {
    this.tag(PoiTypeTags.ACQUIRABLE_JOB_SITE)
        .addOptional(ResourceLocation.fromNamespaceAndPath(BeerMod.MOD_ID, "brewerpoi"));
  }
}
