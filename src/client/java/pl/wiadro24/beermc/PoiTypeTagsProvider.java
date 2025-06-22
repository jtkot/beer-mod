package pl.wiadro24.beermc;

import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.PoiTypeTags;
import net.minecraft.world.entity.ai.village.poi.PoiType;

public class PoiTypeTagsProvider extends TagsProvider<PoiType> {
  public PoiTypeTagsProvider(
      PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture) {
    super(packOutput, Registries.POINT_OF_INTEREST_TYPE, completableFuture);
  }

  @Override
  protected void addTags(Provider provider) {
    this.tag(PoiTypeTags.ACQUIRABLE_JOB_SITE)
        .add(BuiltInRegistries.POINT_OF_INTEREST_TYPE.getResourceKey(PoiTypes.BREWER).get());
  }
}
