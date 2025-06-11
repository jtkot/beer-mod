package pl.wiadro24.beermc;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Blocks;

public class BrewerProfession {
  public static final ResourceKey<PoiType> BREWER_POI_KEY = poiKey();
  public static PoiType BREWER_POI = null;
  public static VillagerProfession BREWER = null;

  public static void registerVillagers() {
    BREWER = registerProfession();
    BREWER_POI = registerPoi();
    BeerMod.LOGGER.info("Registering Villagers " + BeerMod.MOD_ID);
  }

  private static VillagerProfession registerProfession() {
    return Registry.register(
        BuiltInRegistries.VILLAGER_PROFESSION,
        ResourceLocation.fromNamespaceAndPath(BeerMod.MOD_ID, "brewer"),
        new VillagerProfession(
            Component.literal("brewer"),
            entry -> entry.is(BrewerProfession.BREWER_POI_KEY),
            entry -> entry.is(BrewerProfession.BREWER_POI_KEY),
            ImmutableSet.of(),
            ImmutableSet.of(),
            SoundEvents.VILLAGER_WORK_SHEPHERD));
  }

  private static PoiType registerPoi() {
    return PointOfInterestHelper.register(
        ResourceLocation.fromNamespaceAndPath(BeerMod.MOD_ID, "brewerpoi"),
        1,
        1,
        Blocks.NOTE_BLOCK);
  }

  private static ResourceKey<PoiType> poiKey() {
    return ResourceKey.create(
        Registries.POINT_OF_INTEREST_TYPE,
        ResourceLocation.fromNamespaceAndPath(BeerMod.MOD_ID, "brewerpoi"));
  }
}
