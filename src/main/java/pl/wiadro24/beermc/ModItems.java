package pl.wiadro24.beermc;

import java.util.function.Function;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey; // RegistryKey
import net.minecraft.resources.ResourceLocation; // Identifier
import net.minecraft.world.item.CreativeModeTabs; // ItemGroups
import net.minecraft.world.item.Item;

public class ModItems {
	public static final Item FULL_BEER_MUG = register("full_beer_mug", Item::new, new Item.Properties());
	public static Item register(String name, Function<Item.Properties, Item> itemFactory, Item.Properties properties) {
		// Create the item key.
		ResourceKey<Item> itemKey = ResourceKey.<Item>create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(BeerMod.MOD_ID, name));

		// Create the item instance.
		Item item = itemFactory.apply(properties.setId(itemKey));

		// Register the item.
		Registry.register(BuiltInRegistries.ITEM, itemKey, item);

		return item;
	}
	public static void initialize() {
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS)
			.register((itemGroup) -> itemGroup.prepend(ModItems.FULL_BEER_MUG));
	}
}
