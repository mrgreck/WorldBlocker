package net.dismord.worldblocker.mixin;


import net.dismord.worldblocker.config.ModConfigs;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.EnderEyeItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnderEyeItem.class)
public class EndBlockerMixin {


    @Inject(at = @At("HEAD"), method = "useOnBlock", cancellable = true)
    private void EndBlock (ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
        if(!ModConfigs.END){
            BlockPos blockPos;
            World world = context.getWorld();
            BlockState blockState = world.getBlockState(blockPos = context.getBlockPos());
            if (blockState.isOf(Blocks.END_PORTAL_FRAME)) {
                PlayerEntity player = context.getPlayer();

                world.createExplosion(player,blockPos.getX(),blockPos.getY(),blockPos.getZ(),2, Explosion.DestructionType.NONE);
                context.getStack().decrement(1);

                cir.setReturnValue(ActionResult.CONSUME);

            }
            if (world.isClient) {

                cir.setReturnValue(ActionResult.SUCCESS);
            }
        }


    }
}
