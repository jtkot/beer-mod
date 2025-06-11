package pl.wiadro24.beermc;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey; // RegistryKey
import net.minecraft.resources.ResourceLocation; // Identifier
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModItems {
  public static final Logger LOGGER = LoggerFactory.getLogger(BeerMod.MOD_ID);
  public static final SoundEvent BURP = registerSound("burp");
  // public static final EntityType BEER_MUG;
  public static final Item EMPTY_BEER_MUG = registerItem("empty_beer_mug", new Item.Properties());
  public static final Item FULL_BEER_MUG =
      registerItem(
          "full_beer_mug",
          new Item.Properties()
              .food(
                  new FoodProperties(1, 0.6f, true),
                  Consumable.builder()
                      .animation(ItemUseAnimation.DRINK)
                      .soundAfterConsume(Holder.direct(BURP))
                      .sound(SoundEvents.GENERIC_DRINK)
                      .animation(ItemUseAnimation.DRINK)
                      .consumeSeconds(5)
                      .hasConsumeParticles(false)
                      .onConsume(
                          new ApplyStatusEffectsConsumeEffect(
                              new MobEffectInstance(MobEffects.NAUSEA, 250), 10000.0f))
                      .build())
              .usingConvertsTo(EMPTY_BEER_MUG));

  public static Item registerItem(String name, Item.Properties properties) {
    var location = ResourceLocation.fromNamespaceAndPath(BeerMod.MOD_ID, name);
    var itemKey = ResourceKey.create(Registries.ITEM, location);
    Item item = new Item(properties.setId(itemKey));
    Registry.register(BuiltInRegistries.ITEM, itemKey, item);
    return item;
  }

  public static SoundEvent registerSound(String name) {
    var location = ResourceLocation.fromNamespaceAndPath(BeerMod.MOD_ID, name);
    var key = ResourceKey.create(Registries.SOUND_EVENT, location);
    SoundEvent soundEvent = SoundEvent.createVariableRangeEvent(location);
    Registry.register(BuiltInRegistries.SOUND_EVENT, key, soundEvent);
    return soundEvent;
  }

  public static void initialize() {
    ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS)
        .register((itemGroup) -> itemGroup.accept(ModItems.FULL_BEER_MUG));
  }
}
