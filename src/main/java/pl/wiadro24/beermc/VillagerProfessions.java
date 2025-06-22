package pl.wiadro24.beermc;

import java.util.function.Predicate;

import org.jetbrains.annotations.Nullable;

import com.google.common.collect.ImmutableSet;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class VillagerProfessions {
	public static final VillagerProfession BREWER = register(modVillagerProfessionId("brewer"), BuiltInRegistries.POINT_OF_INTEREST_TYPE.getResourceKey(PoiTypes.BREWER).get(), null);

	private static VillagerProfession register(
			Registry<VillagerProfession> registry,
			ResourceKey<VillagerProfession> resourceKey,
			ResourceKey<PoiType> resourceKey2,
			@Nullable SoundEvent soundEvent) {
		return register(registry, resourceKey, holder -> holder.is(resourceKey2), holder -> holder.is(resourceKey2),
				soundEvent);
	}

	private static VillagerProfession register(
			ResourceKey<VillagerProfession> resourceKey,
			ResourceKey<PoiType> resourceKey2,
			@Nullable SoundEvent soundEvent) {
		return register(BuiltInRegistries.VILLAGER_PROFESSION, resourceKey, resourceKey2, soundEvent);
	}

	private static VillagerProfession register(
			Registry<VillagerProfession> registry,
			ResourceKey<VillagerProfession> resourceKey,
			Predicate<Holder<PoiType>> predicate,
			Predicate<Holder<PoiType>> predicate2,
			@Nullable SoundEvent soundEvent) {
		return register(registry, resourceKey, predicate, predicate2, ImmutableSet.of(), ImmutableSet.of(), soundEvent);
	}

	@SuppressWarnings("unused")
	private static VillagerProfession register(
			Registry<VillagerProfession> registry,
			ResourceKey<VillagerProfession> resourceKey,
			ResourceKey<PoiType> resourceKey2,
			ImmutableSet<Item> immutableSet,
			ImmutableSet<Block> immutableSet2,
			@Nullable SoundEvent soundEvent) {
		return register(registry, resourceKey, holder -> holder.is(resourceKey2), holder -> holder.is(resourceKey2),
				immutableSet, immutableSet2, soundEvent);
	}

	private static VillagerProfession register(
			Registry<VillagerProfession> registry,
			ResourceKey<VillagerProfession> resourceKey,
			Predicate<Holder<PoiType>> predicate,
			Predicate<Holder<PoiType>> predicate2,
			ImmutableSet<Item> immutableSet,
			ImmutableSet<Block> immutableSet2,
			@Nullable SoundEvent soundEvent) {
		return Registry.register(
				registry,
				resourceKey,
				new VillagerProfession(
						Component.translatable("entity." + resourceKey.location().getNamespace() + ".villager."
								+ resourceKey.location().getPath()),
						predicate,
						predicate2,
						immutableSet,
						immutableSet2,
						soundEvent));
	}

	private static ResourceKey<VillagerProfession> modVillagerProfessionId(String path) {
		return ResourceKey.create(
				Registries.VILLAGER_PROFESSION, ResourceLocation.fromNamespaceAndPath(BeerMod.NAMESPACE, path));
	}
}
