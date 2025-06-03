package pl.wiadro24.beermc.mixin.client;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(MinecraftClient.class)
public class BeerModClientMixin {
	// @Inject(at = @At("HEAD"), method = "run")
	// private void init(CallbackInfo info) {
	// }
}
