package pl.wiadro24.beermc;

import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
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
		BrewerProfession.registerVillagers();
		for (Identifier id : Registries.VILLAGER_PROFESSION.getIds()) {
			VillagerProfession profession = Registries.VILLAGER_PROFESSION.get(id);
			System.out.println("Registered profession: " + id);
		}
		for (Identifier id : Registries.POINT_OF_INTEREST_TYPE.getIds()) {
			System.out.println("Registered POI: " + id);
		}
		LOGGER.debug("Beer Mod initialized");
	}
}
