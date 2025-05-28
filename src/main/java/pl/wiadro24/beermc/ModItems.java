package pl.wiadro24.beermc;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey; // RegistryKey
import net.minecraft.resources.ResourceLocation; // Identifier
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs; // ItemGroups
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Consumables;

public class ModItems {
	public static final Item FULL_BEER_MUG = register("full_beer_mug", new Item.Properties());

	public static Item register(String name, Item.Properties properties) {
		ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM,
				ResourceLocation.fromNamespaceAndPath(BeerMod.MOD_ID, name));
		Item item = new Item(properties.setId(itemKey).
			food(
				new FoodProperties(1, 0.6f, true), Consumables.MILK_BUCKET));
		Registry.register(BuiltInRegistries.ITEM, itemKey, item);

		return item;
	}

	public static void initialize() {
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS)
				.register((itemGroup) -> itemGroup.prepend(ModItems.FULL_BEER_MUG));
	}
}
