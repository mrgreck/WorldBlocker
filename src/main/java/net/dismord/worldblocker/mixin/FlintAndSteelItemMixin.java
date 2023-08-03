package net.dismord.worldblocker.mixin;


import net.dismord.worldblocker.config.ModConfigs;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FlintAndSteelItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FlintAndSteelItem.class)
public class FlintAndSteelItemMixin {

    @Inject(at = @At("HEAD"), method = "useOnBlock")
    private void FlintModifi(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir){
        if(!ModConfigs.NETHER){
            PlayerEntity player = context.getPlayer();
            BlockPos blockPos = context.getBlockPos();
            BlockState blockState = player.world.getBlockState(blockPos = context.getBlockPos());


            if(blockState.isOf(Blocks.OBSIDIAN)){
                player.world.createExplosion(player,blockPos.getX(),blockPos.getY(),blockPos.getZ(),2, Explosion.DestructionType.NONE);
                if (player != null) {
                    context.getStack().damage(666, player, p -> p.sendToolBreakStatus(context.getHand()));
                }
            }
        }


    }
}
