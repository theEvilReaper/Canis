package net.theevilreaper.canis.util;

import net.minestom.server.instance.block.BlockFace;

public enum DoorFacing {

    EAST,
    NORTH,
    SOUTH,
    WEST;

    public DoorFacing translate(BlockFace blockFace) {
        return switch (blockFace) {
            case EAST -> DoorFacing.EAST;
            case SOUTH -> DoorFacing.SOUTH;
            case WEST -> DoorFacing.WEST;
            default -> DoorFacing.NORTH;
        };
    }
}
