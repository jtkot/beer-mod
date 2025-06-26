package pl.wiadro24.beermc.api;

import com.google.common.collect.ImmutableSet;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class ItemTabMapper {
  private static Map<ResourceKey<CreativeModeTab>, ImmutableSet.Builder<Item>> itemsToTabs =
      new HashMap<>();

  public static ImmutableSet.Builder<Item> getBuilder(ResourceKey<CreativeModeTab> tab) {
    return itemsToTabs.getOrDefault(tab, ImmutableSet.builder());
  }

  public static void assign(Item item, ResourceKey<CreativeModeTab> tab) {
    var builder = getBuilder(tab).add(item);
    itemsToTabs.putIfAbsent(tab, builder);
  }
}
