package io.sc3.plethora.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.server.network.ServerPlayerInteractionManager;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ServerPlayerInteractionManager.class)
public interface ServerPlayerInteractionManagerInvoker {
  @Invoker
  float invokeContinueMining(BlockState state, BlockPos pos, int failedStartMiningTime);
}
