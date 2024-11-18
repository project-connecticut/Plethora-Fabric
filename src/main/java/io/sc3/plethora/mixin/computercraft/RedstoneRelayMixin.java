package io.sc3.plethora.mixin.computercraft;

import dan200.computercraft.api.peripheral.AttachedComputerSet;
import dan200.computercraft.shared.peripheral.redstone.RedstoneRelayPeripheral;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(RedstoneRelayPeripheral.class)
public class RedstoneRelayMixin {
  @Shadow(remap = false)
  @Final
  private AttachedComputerSet computers;

  /**
   * @author AlexDevs
   * @reason Add Redstone Relay network name as second parameter in the `redstone` event.
   */
  @Overwrite(remap = false)
  void queueRedstoneEvent() {
    computers.forEach(computer -> {
      computer.queueEvent("redstone", computer.getAttachmentName());
    });
  }

}
