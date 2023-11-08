package net.theevilreaper.canis.sign;

import net.minestom.server.coordinate.Vec;
import net.minestom.server.instance.Instance;
import net.minestom.server.instance.block.Block;
import org.jetbrains.annotations.NotNull;

/**
 * @author theEvilReaper
 * @version 1.0.0
 * @since
 **/

public class PositionedSign extends SignBlock implements PositionSign {

    private final Instance instance;
    private final Vec position;

    public PositionedSign(@NotNull Block block,@NotNull Instance instance,@NotNull Vec position) {
        super( block);
        this.instance = instance;
        this.position = position;
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
