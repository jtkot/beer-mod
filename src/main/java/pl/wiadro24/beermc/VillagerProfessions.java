package pl.wiadro24.beermc;

import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;
import pl.wiadro24.beermc.api.Registerer;

public class VillagerProfessions {
  public static final VillagerProfession BREWER = register("brewer", PoiTypes.BREWER);

  private static VillagerProfession register(String name, PoiType poiType) {
    return register(name, poiType, ImmutableSet.of(), ImmutableSet.of(), null);
  }

  private static VillagerProfession register(
      String name,
      PoiType poiType,
      ImmutableSet<Item> requestedItems,
      ImmutableSet<Block> secondaryPoi,
      @Nullable SoundEvent workSound) {
    return Registerer.registerVillagerProfession(
        Mod.NAMESPACE.createVillagerProfessionKey(name),
        Registerer.getKeyForPoiType(poiType),
        requestedItems,
        secondaryPoi,
        workSound);
  }
}
