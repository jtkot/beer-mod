package pl.wiadro24.beermc;

import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import pl.wiadro24.beermc.api.Registerer;

public class PoiTypes {
  public static final PoiType BREWER = register("brewer", Blocks.BREWING_VAT, 1, 1);

  private static PoiType register(String name, Block block, int maxTickets, int validRange) {
    return Registerer.registerPoiType(
        Mod.NAMESPACE.createPoiTypeKey(name), block, maxTickets, validRange);
  }
}
