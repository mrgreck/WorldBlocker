package net.dismord.worldblocker.mixin;


import net.dismord.worldblocker.config.ModConfigs;
import net.minecraft.world.dimension.AreaHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AreaHelper.class)
public class NetherBlockerMixin {

    @Inject(at = @At("HEAD"), method = "createPortal", cancellable = true)
    private void HetherBlock (CallbackInfo info) {
        if(!ModConfigs.NETHER){
            info.cancel();
        }

    }

}



