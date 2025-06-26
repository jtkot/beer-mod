package pl.wiadro24.beermc;

import java.util.function.Function;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import pl.wiadro24.beermc.api.Registerer;

public class Items {
	public static final Item FERMENTOR_ITEM = Blocks.FERMENTOR.asItem();
	public static final Item EMPTY_BEER_MUG = register("empty_beer_mug",
			CreativeModeTabs.TOOLS_AND_UTILITIES,
			BeerMugItem::new);
	public static final Item FULL_BEER_MUG = register(
			"full_beer_mug",
			CreativeModeTabs.FOOD_AND_DRINKS,
			new Item.Properties()
					.food(new FoodProperties(1, 0.6f, true), Consumables.beer().build())
					.usingConvertsTo(EMPTY_BEER_MUG));

	private static Item register(String name,
			ResourceKey<CreativeModeTab> tab,
			Function<Item.Properties, Item> constructor,
			Item.Properties properties) {
		return Registerer.registerItem(
				Mod.NAMESPACE.createItemKey(name), tab, constructor, properties);
	}

	private static Item register(String name,
			ResourceKey<CreativeModeTab> tab,
			Item.Properties properties) {
		return register(name, tab, Item::new, properties);
	}

	private static Item register(String name,
			ResourceKey<CreativeModeTab> tab,
			Function<Item.Properties, Item> constructor) {
		return register(name, tab, constructor, new Item.Properties());
	}
}
