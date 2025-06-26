package pl.wiadro24.beermc.api.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import pl.wiadro24.beermc.api.ItemTabMapper;

@Mixin(CreativeModeTabs.class)
public abstract class CreativeModeTabsMixin {

	// @Inject(method =
	// "*(Lnet/minecraft/world/item/CreativeModeTab/ItemDisplayParameters;Lnet/minecraft/world/item/CreativeModeTab/Output;)V",
	// at = @At("TAIL"), locals = LocalCapture.PRINT)

	private static void appendAll(ResourceKey<CreativeModeTab> tab, CreativeModeTab.Output output) {
		for (Item item : ItemTabMapper.getBuilder(tab).build()) {
			output.accept(item);
		}
	}

	@Inject(method = "method_51338", at = @At("TAIL"))
	private static void onDisplayBuildingBlocks(CreativeModeTab.ItemDisplayParameters parameters,
			CreativeModeTab.Output output, CallbackInfo ci) {
		appendAll(CreativeModeTabs.BUILDING_BLOCKS, output);
	}

	@Inject(method = "method_51336", at = @At(value = "TAIL"))
	private static void onDisplayColoredBlocks(CreativeModeTab.ItemDisplayParameters parameters,
			CreativeModeTab.Output output, CallbackInfo ci) {
		appendAll(CreativeModeTabs.COLORED_BLOCKS, output);
	}

	@Inject(method = "method_51334", at = @At("TAIL"))
	private static void onDisplayNaturalBlocks(CreativeModeTab.ItemDisplayParameters parameters,
			CreativeModeTab.Output output, CallbackInfo ci) {
		appendAll(CreativeModeTabs.NATURAL_BLOCKS, output);
	}

	@Inject(method = "method_51332", at = @At("TAIL"))
	private static void onDisplayFunctionalBlocks(CreativeModeTab.ItemDisplayParameters params,
			CreativeModeTab.Output output,
			CallbackInfo ci) {
		appendAll(CreativeModeTabs.FUNCTIONAL_BLOCKS, output);
	}

	@Inject(method = "method_51330", at = @At("TAIL"))
	private static void onDisplayRedstoneBlocks(CreativeModeTab.ItemDisplayParameters parameters,
			CreativeModeTab.Output output, CallbackInfo ci) {
		appendAll(CreativeModeTabs.REDSTONE_BLOCKS, output);
	}

	@Inject(method = "method_51328", at = @At("TAIL"))
	private static void onDisplayToolsAndUtilities(CreativeModeTab.ItemDisplayParameters parameters,
			CreativeModeTab.Output output,
			CallbackInfo ci) {
		appendAll(CreativeModeTabs.TOOLS_AND_UTILITIES, output);
	}

	@Inject(method = "method_51325", at = @At("TAIL"))
	private static void onDisplayCombat(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output,
			CallbackInfo ci) {
		appendAll(CreativeModeTabs.COMBAT, output);
	}

	@Inject(method = "method_51323", at = @At("TAIL"))
	private static void onDisplayFoodAndDrinks(CreativeModeTab.ItemDisplayParameters params,
			CreativeModeTab.Output output,
			CallbackInfo ci) {
		appendAll(CreativeModeTabs.FOOD_AND_DRINKS, output);
	}

	@Inject(method = "method_51321", at = @At("TAIL"))
	private static void onDisplayIngredients(CreativeModeTab.ItemDisplayParameters parameters,
			CreativeModeTab.Output output, CallbackInfo ci) {
		appendAll(CreativeModeTabs.INGREDIENTS, output);
	}

	@Inject(method = "method_51318", at = @At("TAIL"))
	private static void onDisplaySpawnEggs(CreativeModeTab.ItemDisplayParameters parameters,
			CreativeModeTab.Output output, CallbackInfo ci) {
		appendAll(CreativeModeTabs.SPAWN_EGGS, output);
	}

	@Inject(method = "method_51311", at = @At(value = "TAIL"))
	private static void onDisplayOperatorUtilities(CreativeModeTab.ItemDisplayParameters parameters,
			CreativeModeTab.Output output, CallbackInfo ci) {
		appendAll(CreativeModeTabs.OP_BLOCKS, output);
	}
}
