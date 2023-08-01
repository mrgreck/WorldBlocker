package net.dismord.worldblocker.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.EndPortalFrameBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.item.EnderEyeItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.state.StateManager;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnderEyeItem.class)
public class EndBlockerMixin {


    @Inject(at = @At("HEAD"), method = "useOnBlock", cancellable = true)
    private void EndBlock (ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
        BlockPos blockPos;
        World world = context.getWorld();
        BlockState blockState = world.getBlockState(blockPos = context.getBlockPos());
        if (blockState.isOf(Blocks.END_PORTAL_FRAME)) {
            MinecraftClient client = MinecraftClient.getInstance();

            Text text =Text.of("§EEnd is Blocked!!");

            client.inGameHud.setTitle(text);
            cir.setReturnValue(ActionResult.PASS);
        }
        if (world.isClient) {

            cir.setReturnValue(ActionResult.SUCCESS);
        }

    }
}
