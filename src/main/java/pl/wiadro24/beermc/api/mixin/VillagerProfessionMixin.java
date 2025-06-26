package pl.wiadro24.beermc.api.mixin;

import java.util.Set;
import java.util.function.Predicate;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import com.google.common.collect.ImmutableSet;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

@Mixin(VillagerProfession.class)
public interface VillagerProfessionMixin {
	@Invoker
	public static VillagerProfession callRegister(
		Registry<VillagerProfession> registry,
		ResourceKey<VillagerProfession> key,
		Predicate<Holder<PoiType>> heldJobSite,
		Predicate<Holder<PoiType>> acquirableJobSite,
		ImmutableSet<Item> requestedItems,
		ImmutableSet<Block> secondaryPoi,
		@Nullable SoundEvent workSound) { return null; }
}
