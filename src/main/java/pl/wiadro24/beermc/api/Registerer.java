package pl.wiadro24.beermc.api;

import com.google.common.collect.ImmutableSet;
import java.util.function.Function;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.jetbrains.annotations.Nullable;
import pl.wiadro24.beermc.api.mixin.EntityTypeMixin;
import pl.wiadro24.beermc.api.mixin.PoiTypesMixin;
import pl.wiadro24.beermc.api.mixin.VillagerProfessionMixin;

public class Registerer {
  public static Block registerBlock(
      ResourceKey<Block> key,
      ResourceKey<CreativeModeTab> tab,
      Function<BlockBehaviour.Properties, Block> constructor,
      BlockBehaviour.Properties properties) {
    var block = Blocks.register(key, constructor, properties);
    block
        .getStateDefinition()
        .getPossibleStates()
        .forEach(
            state -> {
              Block.BLOCK_STATE_REGISTRY.add(state);
              state.initCache();
            });
    ItemTabMapper.assign(Items.registerBlock(block), tab);
    return block;
  }

  public static Item registerItem(
      ResourceKey<Item> key,
      ResourceKey<CreativeModeTab> tab,
      Function<Item.Properties, Item> constructor,
      Item.Properties properties) {
    var item = Items.registerItem(key, constructor, properties);
    ItemTabMapper.assign(item, tab);
    return item;
  }

  public static <T extends Entity> EntityType<T> registerEntityType(
      ResourceKey<EntityType<?>> key, EntityType.Builder<T> builder) {
    return EntityTypeMixin.callRegister(key, builder);
  }

  public static PoiType registerPoiType(
      ResourceKey<PoiType> key, Block block, int maxTickets, int validRange) {
    return PoiTypesMixin.callRegister(
        BuiltInRegistries.POINT_OF_INTEREST_TYPE,
        key,
        PoiTypesMixin.callGetBlockStates(block),
        maxTickets,
        validRange);
  }

  public static VillagerProfession registerVillagerProfession(
      ResourceKey<VillagerProfession> key,
      ResourceKey<PoiType> poiKey,
      ImmutableSet<Item> requestedItems,
      ImmutableSet<Block> secondaryPoi,
      @Nullable SoundEvent workSound) {
    return VillagerProfessionMixin.callRegister(
        BuiltInRegistries.VILLAGER_PROFESSION,
        key,
        holder -> holder.is(poiKey),
        holder -> holder.is(poiKey),
        requestedItems,
        secondaryPoi,
        workSound);
  }

  public static Holder.Reference<SoundEvent> registerSoundEventForHolder(
      ResourceKey<SoundEvent> key) {
    return Registry.registerForHolder(
        BuiltInRegistries.SOUND_EVENT,
        key.location(),
        SoundEvent.createVariableRangeEvent(key.location()));
  }

  public static @Nullable ResourceKey<PoiType> getKeyForPoiType(PoiType poiType) {
    return BuiltInRegistries.POINT_OF_INTEREST_TYPE.getResourceKey(poiType).get();
  }
}
