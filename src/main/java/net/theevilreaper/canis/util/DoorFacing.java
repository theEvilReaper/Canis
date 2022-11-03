package net.theevilreaper.canis.util;

import net.minestom.server.instance.block.BlockFace;
import org.jetbrains.annotations.NotNull;

/**
 * The enum represents all valid facings which a door can have.
 * @author theEvilReaper
 * @version 1.0.0
 * @since 1.0.0
 */
public enum DoorFacing {

    EAST,
    NORTH,
    SOUTH,
    WEST;

    /**
     * Translates a given {@link BlockFace} to a DoorFacing entry.
     * @param blockFace the face to translate
     * @return
     */
    //TODO: Check what the client does when the BlockFace is top
    public static DoorFacing translate(@NotNull BlockFace blockFace) {
        return switch (blockFace) {
            case EAST -> DoorFacing.EAST;
            case NORTH ->  DoorFacing.NORTH;
            case SOUTH -> DoorFacing.SOUTH;
            case WEST -> DoorFacing.WEST;
            default -> throw new IllegalArgumentException("The given face can't be converted");
        };
    }
}
