package pl.wiadro24.beermc;

import java.util.function.Function;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import pl.wiadro24.beermc.api.Registerer;

public class Blocks {
	public static final Block FERMENTOR = register(
			"beer_fermentor",
			CreativeModeTabs.FUNCTIONAL_BLOCKS,
			BlockBehaviour.Properties.of().sound(SoundType.ANVIL).noOcclusion());

	private static Block register(String name,
			ResourceKey<CreativeModeTab> tab,
			BlockBehaviour.Properties properties) {
		return register(name, tab, Block::new, properties);
	}

	private static Block register(
			String name,
			ResourceKey<CreativeModeTab> tab,
			Function<BlockBehaviour.Properties, Block> constructor,
			BlockBehaviour.Properties properties) {
		return Registerer.registerBlock(Mod.NAMESPACE.createBlockKey(name),
				tab,
				constructor, properties);
	}
}
