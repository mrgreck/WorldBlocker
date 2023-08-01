package net.dismord.worldblocker.mixin;


import net.dismord.worldblocker.WorldBlocker;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.world.dimension.AreaHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AreaHelper.class)
public class NetherBlockerMixin {

    @Inject(at = @At("HEAD"), method = "createPortal")
    private void HetherBlock (CallbackInfo info) {
        MinecraftClient client = MinecraftClient.getInstance();

        Text text =Text.of("§4Nether is Blocked!!");

        client.inGameHud.setTitle(text);


    }

}
