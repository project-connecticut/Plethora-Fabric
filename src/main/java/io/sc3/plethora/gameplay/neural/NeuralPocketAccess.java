package io.sc3.plethora.gameplay.neural;

import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.pocket.IPocketAccess;
import dan200.computercraft.api.pocket.IPocketUpgrade;
import dan200.computercraft.api.upgrades.UpgradeData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;

/**
 * Proxy IPocketAccess for neural interfaces.
 */
public class NeuralPocketAccess implements IPocketAccess {
    private final NeuralComputer neural;

    public NeuralPocketAccess(NeuralComputer neural) {
        this.neural = neural;
    }

  @Override
  public ServerWorld getLevel() {
      //Do I think this works? Nah
    return (ServerWorld) getEntity().getEntityWorld();
  }

  @Override
  public Vec3d getPosition() {
    return getEntity().getPos();
  }

  @Nullable
    @Override
    public Entity getEntity() {
        WeakReference<LivingEntity> ref = neural.getEntity();
        return ref != null ? ref.get() : null;
    }

    @Override
    public int getColour() {
        return -1;
    }

    @Override
    public void setColour(int colour) {}

    @Override
    public int getLight() {
        return -1;
    }

    @Override
    public void setLight(int colour) {}

  @org.jetbrains.annotations.Nullable
  @Override
  public UpgradeData<IPocketUpgrade> getUpgrade() {
    return null;
  }

  @Override
  public void setUpgrade(@org.jetbrains.annotations.Nullable UpgradeData<IPocketUpgrade> upgrade) {

  }

  @Nonnull
    @Override
    public NbtCompound getUpgradeNBTData() {
        return new NbtCompound(); // TODO: Necessary to do anything with this?
    }

    @Override
    public void updateUpgradeNBTData() {

    }

    @Override
    public void invalidatePeripheral() {

    }

    @Override
    @SuppressWarnings({"removal"})
    //TODO: Remove this when IPocketAccess is updated, there's nothing relying on it. Trust me bro.
    public Map<Identifier, IPeripheral> getUpgrades() {
      return Collections.emptyMap();
    }
}
