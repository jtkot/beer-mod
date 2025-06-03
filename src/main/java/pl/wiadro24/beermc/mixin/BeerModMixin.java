package pl.wiadro24.beermc.mixin;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(MinecraftServer.class)
public class BeerModMixin {
	// @Inject(at = @At("HEAD"), method = "loadWorld")
	// private void init(CallbackInfo info) {
	// }
}
