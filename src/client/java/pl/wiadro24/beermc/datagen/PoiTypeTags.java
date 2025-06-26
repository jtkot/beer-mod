package pl.wiadro24.beermc.datagen;

import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import pl.wiadro24.beermc.PoiTypes;
import pl.wiadro24.beermc.api.Registerer;

public class PoiTypeTags extends TagsProvider<PoiType> {
  public PoiTypeTags(
      PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture) {
    super(packOutput, Registries.POINT_OF_INTEREST_TYPE, completableFuture);
  }

  @Override
  protected void addTags(Provider provider) {
    this.tag(net.minecraft.tags.PoiTypeTags.ACQUIRABLE_JOB_SITE)
        .add(Registerer.getKeyForPoiType(PoiTypes.BREWER));
  }
}
