package pl.wiadro24.beermc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import pl.wiadro24.beermc.api.ClassInitializer;
import pl.wiadro24.beermc.api.Namespace;

public class Mod implements ModInitializer {
	public static final String MOD_ID = "beer-mod";
	public static final Namespace NAMESPACE = new Namespace(MOD_ID);
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	private static final ClassInitializer initializer = new ClassInitializer(LOGGER);

	@Override
	public void onInitialize() {
		initializer.initializeClass(Items.class);
		initializer.initializeClass(VillagerProfessions.class);
		LOGGER.debug("Beer Mod initialized");
	}
}
