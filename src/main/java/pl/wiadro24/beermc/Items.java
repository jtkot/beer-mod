package pl.wiadro24.beermc;

import java.util.function.Function;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import static net.minecraft.world.item.Items.registerBlock;

public class Items {
	public static final Item EMPTY_BEER_MUG = registerItem("empty_beer_mug");
	public static final Item FERMENTOR = registerBlock(Blocks.FERMENTOR);
	public static final Item FULL_BEER_MUG = registerItem(
			"full_beer_mug",
			new Item.Properties()
					.food(new FoodProperties(1, 0.6f, true), Consumables.beer().build())
					.usingConvertsTo(EMPTY_BEER_MUG));

	@SuppressWarnings("unused")
	private static Item registerItem(String string, Function<Item.Properties, Item> function) {
		return net.minecraft.world.item.Items.registerItem(
				modItemId(string), function, new Item.Properties());
	}

	@SuppressWarnings("unused")
	private static Item registerItem(
			String string, Function<Item.Properties, Item> function, Item.Properties properties) {
		return net.minecraft.world.item.Items.registerItem(modItemId(string), function, properties);
	}

	private static Item registerItem(String string, Item.Properties properties) {
		return net.minecraft.world.item.Items.registerItem(modItemId(string), Item::new, properties);
	}

	private static Item registerItem(String string) {
		return net.minecraft.world.item.Items.registerItem(
				modItemId(string), Item::new, new Item.Properties());
	}

	private static ResourceKey<Item> modItemId(String path) {
		return ResourceKey.create(
				Registries.ITEM, ResourceLocation.fromNamespaceAndPath(BeerMod.NAMESPACE, path));
	}
}
