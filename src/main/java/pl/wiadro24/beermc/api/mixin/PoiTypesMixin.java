package pl.wiadro24.beermc.api.mixin;

import java.util.Set;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(PoiTypes.class)
public interface PoiTypesMixin {
	@Invoker
	public static PoiType callRegister(Registry<PoiType> registry, ResourceKey<PoiType> resourceKey,
			Set<BlockState> matchingStates, int maxTickets, int validRange) {
		return null;
	}

	@Invoker
	public static Set<BlockState> callGetBlockStates(Block block) {
		return null;
	}
}
