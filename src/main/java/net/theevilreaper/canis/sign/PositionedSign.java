package net.theevilreaper.canis.sign;

import net.minestom.server.coordinate.Vec;
import net.minestom.server.instance.Instance;
import net.minestom.server.instance.block.Block;
import net.minestom.server.network.packet.server.play.BlockChangePacket;
import net.theevilreaper.canis.sign.side.SignSide;
import org.jetbrains.annotations.NotNull;

/**
 * @author theEvilReaper
 * @version 1.0.0
 * @since 1.0.0
 **/
public class PositionedSign extends SignBlock implements PositionSign {

    private final Instance instance;
    private final Vec position;

    public PositionedSign(@NotNull Block block ,@NotNull Instance instance,@NotNull Vec position) {
        super( block);
        this.instance = instance;
        this.position = position;
        this.instance.setBlock(position, block);
    }

    @Override
    public void updateRotation(@NotNull SignRotation rotation) {
        super.updateRotation(rotation);
        instance.scheduleNextTick(instance1 -> {
            instance.sendGroupedPacket(new BlockChangePacket(position.asPosition(), block));
        });
    }

    @Override
    public void updateLines(@NotNull SignSide side) {
        var linesToUpdate = switch (side) {
            case FRONT -> frontSide;
            case BACK -> backSide;
        };

        if (linesToUpdate == null) return;

        var rootTag = prepareNBTCompound(linesToUpdate, side);

        var updatePacket = createLinePacket(blockEntityId, position.asPosition(), rootTag);
        instance.scheduleNextTick(instance1 -> {
            instance1.sendGroupedPacket(updatePacket);
        });
    }

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
}
