package noobanidus.mods.erebusfix.mixins;

import erebus.tileentity.TileEntityPreservedBlock;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TileEntityPreservedBlock.class)
public class MixinTileEntityPreservedBlock {
  @SuppressWarnings("ConstantConditions")
  @Inject(method = "Lerebus/tileentity/TileEntityPreservedBlock;markForUpdate()V", at = @At(value = "HEAD"), cancellable = true, remap = false)
  private void markForUpdate(CallbackInfo info) {
    World world = ((TileEntityPreservedBlock) (Object) this).getWorld();
    if (world != null && !world.isRemote) {
      BlockPos pos = ((TileEntityPreservedBlock) (Object) this).getPos();
      ((TileEntityPreservedBlock) (Object) this).markDirty();
      final IBlockState state = world.getBlockState(pos);
      world.notifyBlockUpdate(pos, state, state, 8);
    }
    info.cancel();
  }
}
