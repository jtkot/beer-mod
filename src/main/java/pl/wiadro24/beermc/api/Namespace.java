package pl.wiadro24.beermc.api;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class Namespace {
	private String name;

	public Namespace(String name) {
		this.name = name;
	}

	public ResourceKey<Block> createBlockKey(String path) {
		return ResourceKey.create(
				Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(name, path));
	}

	public ResourceKey<Item> createItemKey(String path) {
		return ResourceKey.create(
				Registries.ITEM, ResourceLocation.fromNamespaceAndPath(name, path));
	}

	public ResourceKey<VillagerProfession> createVillagerProfessionKey(String path) {
		return ResourceKey.create(
				Registries.VILLAGER_PROFESSION, ResourceLocation.fromNamespaceAndPath(name, path));
	}

	public ResourceKey<PoiType> createPoiTypeKey(String path) {
		return ResourceKey.create(
				Registries.POINT_OF_INTEREST_TYPE, ResourceLocation.fromNamespaceAndPath(name, path));
	}

	public ResourceKey<EntityType<?>> createEntityTypeKey(String path) {
		return ResourceKey.create(
				Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(name, path));
	}

	public ResourceKey<SoundEvent> createSoundEventKey(String path) {
		return ResourceKey.create(
				Registries.SOUND_EVENT, ResourceLocation.fromNamespaceAndPath(name, path));
	}
}
