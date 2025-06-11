package pl.wiadro24.beermc;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeerMod implements ModInitializer {
  public static final String MOD_ID = "beer-mod";

  // This logger is used to write text to the console and the log file.
  // It is considered best practice to use your mod id as the logger's name.
  // That way, it's clear which mod wrote info, warnings, and errors.
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

  @Override
  public void onInitialize() {
    ModItems.initialize();
    ModBlocks.initialize();
    LOGGER.debug("Beer Mod initialized");
    BrewerProfession.registerVillagers();
    for (ResourceLocation id : BuiltInRegistries.VILLAGER_PROFESSION.keySet()) {
      System.out.println("Registered profession: " + id);
    }
    for (ResourceLocation id : BuiltInRegistries.POINT_OF_INTEREST_TYPE.keySet()) {
      System.out.println("Registered POI: " + id);
    }
  }
}
