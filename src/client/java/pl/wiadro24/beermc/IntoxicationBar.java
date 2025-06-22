package pl.wiadro24.beermc;
import org.jetbrains.annotations.Nullable;

import net.fabricmc.fabric.api.client.rendering.v1.IdentifiedLayer;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.food.FoodData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;

public class IntoxicationBar implements IdentifiedLayer {
	private final Minecraft minecraft = Minecraft.getInstance();
	private final RandomSource random = RandomSource.create();
	private static final ResourceLocation FOOD_EMPTY_HUNGER_SPRITE = ResourceLocation.withDefaultNamespace("hud/food_empty_hunger");
	private static final ResourceLocation FOOD_HALF_HUNGER_SPRITE = ResourceLocation.withDefaultNamespace("hud/food_half_hunger");
	private static final ResourceLocation FOOD_FULL_HUNGER_SPRITE = ResourceLocation.withDefaultNamespace("hud/food_full_hunger");
	private static final ResourceLocation FOOD_EMPTY_SPRITE = ResourceLocation.withDefaultNamespace("hud/food_empty");
	private static final ResourceLocation FOOD_HALF_SPRITE = ResourceLocation.withDefaultNamespace("hud/food_half");
	private static final ResourceLocation FOOD_FULL_SPRITE = ResourceLocation.withDefaultNamespace("hud/food_full");

	@Nullable
	private Player getCameraPlayer() {
		return this.minecraft.getCameraEntity() instanceof Player player ? player : null;
	}

	private int getGuiTicks() {
		return this.minecraft.gui.getGuiTicks();
	}

	@Override
	public void render(GuiGraphics guiGraphics, DeltaTracker deltaTracker) {
		Player player = getCameraPlayer();
		FoodData foodData = player.getFoodData();
		int k = foodData.getFoodLevel();
		int i = guiGraphics.guiHeight() - 39;
		int j = guiGraphics.guiWidth() / 2 + 91;

		for (int l = 0; l < 10; l++) {
			int m = i;
			ResourceLocation resourceLocation;
			ResourceLocation resourceLocation2;
			ResourceLocation resourceLocation3;
			if (player.hasEffect(MobEffects.HUNGER)) {
				resourceLocation = FOOD_EMPTY_HUNGER_SPRITE;
				resourceLocation2 = FOOD_HALF_HUNGER_SPRITE;
				resourceLocation3 = FOOD_FULL_HUNGER_SPRITE;
			} else {
				resourceLocation = FOOD_EMPTY_SPRITE;
				resourceLocation2 = FOOD_HALF_SPRITE;
				resourceLocation3 = FOOD_FULL_SPRITE;
			}

			if (player.getFoodData().getSaturationLevel() <= 0.0F && this.getGuiTicks() % (k * 3 + 1) == 0) {
				m = i + (this.random.nextInt(3) - 1);
			}

			int n = j - l * 8 - 9;
			guiGraphics.blitSprite(RenderType::guiTextured, resourceLocation, n, m, 9, 9);
			if (l * 2 + 1 < k) {
				guiGraphics.blitSprite(RenderType::guiTextured, resourceLocation3, n, m, 9, 9);
			}

			if (l * 2 + 1 == k) {
				guiGraphics.blitSprite(RenderType::guiTextured, resourceLocation2, n, m, 9, 9);
			}
		}
	}

	@Override
	public ResourceLocation id() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'id'");
	}
}
