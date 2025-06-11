package pl.wiadro24.beermc;


import com.google.common.collect.ImmutableSet;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class BrewerProfession {
    public static final RegistryKey<PointOfInterestType> BREWER_POI_KEY = poiKey();
    public static PointOfInterestType BREWER_POI = null;
    public static VillagerProfession BREWER = null;

    private static VillagerProfession registerProfession() {

        return Registry.register(
                Registries.VILLAGER_PROFESSION,
                Identifier.of(BeerMod.MOD_ID, "brewer"),
                new VillagerProfession(
                        Text.literal("brewer"),
                        entry -> entry.matchesKey(BrewerProfession.BREWER_POI_KEY),
                        entry -> entry.matchesKey(BrewerProfession.BREWER_POI_KEY),
                        ImmutableSet.of(),
                        ImmutableSet.of(),
                        SoundEvents.ENTITY_VILLAGER_WORK_SHEPHERD
                )
        );
    }

    private static PointOfInterestType registerPoi() {
        return PointOfInterestHelper.register(Identifier.of(BeerMod.MOD_ID, "brewerpoi"), 1, 1, Blocks.NOTE_BLOCK);
    }

    private static RegistryKey<PointOfInterestType> poiKey() {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Identifier.of(BeerMod.MOD_ID, "brewerpoi"));
    }

    public static void registerVillagers() {
        BREWER = registerProfession();
        BREWER_POI = registerPoi();
        BeerMod.LOGGER.info("Registering Villagers " + BeerMod.MOD_ID);
    }
}
