package pl.wiadro24.beermc;

import java.util.function.Function;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class Blocks {
	public static final Block FERMENTOR = register(
			"beer_fermentor", BlockBehaviour.Properties.of().sound(SoundType.ANVIL).noOcclusion());

	private static Block register(String string, BlockBehaviour.Properties properties) {
		return register(string, Block::new, properties);
	}

	private static ResourceKey<Block> modBlockId(String path) {
		return ResourceKey.create(
				Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(BeerMod.NAMESPACE, path));
	}

	private static Block register(
			String string,
			Function<BlockBehaviour.Properties, Block> function,
			BlockBehaviour.Properties properties) {
		return net.minecraft.world.level.block.Blocks.register(
				modBlockId(string), function, properties);
	}
}
