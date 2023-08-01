package net.dismord.worldblocker.mixin;

import net.dismord.worldblocker.WorldBlocker;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class WorldBlockerMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		WorldBlocker.LOGGER.info("This line is printed by an example mod mixin!");
	}
}
