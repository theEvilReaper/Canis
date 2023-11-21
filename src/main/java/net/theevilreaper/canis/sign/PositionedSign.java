package net.theevilreaper.canis.sign;

import net.minestom.server.coordinate.Vec;
import net.minestom.server.instance.Instance;
import net.minestom.server.instance.block.Block;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.play.BlockChangePacket;
import net.theevilreaper.canis.sign.side.SignSide;
import org.jetbrains.annotations.NotNull;

/**
 * The class is the implementation of a {@link PositionedSign} which represents a sign which is placed
 * into a {@link net.minestom.server.instance.InstanceContainer}.
 * @author theEvilReaper
 * @version 1.0.0
 * @since 1.0.0
 **/
public class PositionedSign extends SignBlock implements PositionSign {

    private final Instance instance;
    private final Vec position;

    /**
     * Creates a new reference from this class with the given values
     * @param block the block for the sign
     * @param instance the instance to place the block
     * @param position the position for the sign stands
     */
    public PositionedSign(@NotNull Block block ,@NotNull Instance instance,@NotNull Vec position) {
        super( block);
        this.instance = instance;
        this.position = position;
        this.instance.setBlock(position, block);
    }

    /**
     * Updates the rotation of a sign and sends {@link BlockChangePacket} when the rotation retrieves an update.
     * @param rotation the new rotation to set
     */
    @Override
    public void updateRotation(@NotNull SignRotation rotation) {
        super.updateRotation(rotation);
        this.callUpdatePacket(instance, new BlockChangePacket(position.asPosition(), block));
    }

    /**
     * Updates the lines from a given side.
     * The update includes the nbt data preparation and the sending of the data
     * @param side the side to update the text
     */
    @Override
    public void updateLines(@NotNull SignSide side) {
        var linesToUpdate = switch (side) {
            case FRONT -> frontSide;
            case BACK -> backSide;
        };

        if (linesToUpdate == null) return;

        var rootTag = prepareNBTCompound(linesToUpdate, side);

        var updatePacket = createLinePacket(blockEntityId, position.asPosition(), rootTag);
        callUpdatePacket(instance, updatePacket);
    }

    /**
     * Removes the sign block from the given {@link net.minestom.server.instance.InstanceContainer}.
     */
    @Override
    public void remove() {
        if (block == null) return;
        var blockAtPosition = instance.getBlock(position);
        if (blockAtPosition.isAir() || blockAtPosition == Block.AIR) return;
        if (blockAtPosition.id() == block.id() && blockAtPosition.stateId() == block.stateId()) {
            instance.setBlock(position, Block.AIR);
        }
        this.block = null;
    }

    /**
     * Sends a {@link ServerPacket} instance to a {@link Instance}.
     * @param instance the instance to broadcast a packet
     * @param serverPacket the packet to send
     */
    private void callUpdatePacket(@NotNull Instance instance, @NotNull ServerPacket serverPacket) {
        instance.scheduleNextTick(instance1 -> instance1.sendGroupedPacket(serverPacket));
    }
}
