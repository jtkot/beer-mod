package pl.wiadro24.beermc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;

public class BeerMod implements ModInitializer {
	public static final String MOD_ID = "beer-mod";
	public static final String NAMESPACE = MOD_ID;
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final void foodAndDrinksRegisterer(FabricItemGroupEntries output) {
		output.accept(Items.FULL_BEER_MUG);
	}

	private static final void functionalBlocksRegisterer(FabricItemGroupEntries output) {
		output.accept(Items.FERMENTOR);
	}

	public static final void initializeClass(Class<?> klass) {
		try {
			Class.forName(klass.getName());
		} catch (ClassNotFoundException e) {
			LOGGER.error(String.format("Couldn't load class: %s", e.getMessage()));
			throw new RuntimeException();
		}
	}

	@Override
	public void onInitialize() {
		initializeClass(Items.class);
		initializeClass(Blocks.class);

		// Assign items to proper cretive mode tabs
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS)
				.register(BeerMod::functionalBlocksRegisterer);
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(BeerMod::foodAndDrinksRegisterer);

		BrewerProfession.registerVillagers();
		LOGGER.debug("Beer Mod initialized");
	}
}
