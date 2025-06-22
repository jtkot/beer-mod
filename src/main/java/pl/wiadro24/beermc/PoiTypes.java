package pl.wiadro24.beermc;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.village.poi.PoiType;

public class PoiTypes {
	public final static PoiType BREWER = PointOfInterestHelper.register(modPoiTypeLocation("brewer"), 1, 1, Blocks.FERMENTOR);

	private static ResourceLocation modPoiTypeLocation(String path) {
		return  ResourceLocation.fromNamespaceAndPath(BeerMod.NAMESPACE, path);
	}
}
