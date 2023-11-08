package net.theevilreaper.canis.sign;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author theEvilReaper
 * @version 1.0.0
 * @since 1.0.0
 **/
public enum SignRotation {

    SOUTH,
    SOUTH_SOUTH_WEST,
    SOUTH_WEST,
    WEST_SOUTH_WEST,
    WEST,
    WEST_NORTH_WEST,
    NORTH_WEST,
    NORTH_NORTH_WEST,
    NORTH,
    NORTH_NORTH_EAST,
    NORTH_EAST,
    EAST_NORTH_EAST,
    EAST,
    EAST_SOUTH_EAST,
    SOUTH_EAST,
    SOUTH_SOUTH_EAST;

    private static final SignRotation[] VALUES = values();
    private static final SignRotation[] BLOCK_FACING = new SignRotation[]{
            SOUTH,
            WEST,
            NORTH,
            EAST
    };

    public static @Nullable SignRotation getRotation(@NotNull String facing) {
        boolean hasUnderScore = facing.contains("_");
        var upperCasedFace = facing.toUpperCase();
        return hasUnderScore ? findFace(upperCasedFace, VALUES) : findFace(upperCasedFace, BLOCK_FACING);
    }

    private static @Nullable SignRotation findFace(@NotNull String face, @NotNull SignRotation... values) {
        SignRotation result = null;
        for (int i = 0; i < values.length && result == null; i++) {
            if (!values[i].name().equals(face)) continue;
            result = values[i];
        }
        return result;
    }

    public static @Nullable SignRotation getRotation(int index) {
        return index < 0 || index >= VALUES.length ? null : VALUES[index];
    }

    public @NotNull SignRotation opposite() {
        return VALUES[(ordinal() + VALUES.length / 2) % VALUES.length];
    }

    public @NotNull SignRotation oppositeBlockFacing() {
        return BLOCK_FACING[(ordinal() + BLOCK_FACING.length) % BLOCK_FACING.length];
    }

    public @NotNull SignRotation rotateClockwise() {
        return VALUES[(ordinal() + 1) % VALUES.length];
    }

    public @NotNull SignRotation rotateCounterClockwise() {
        var newIndex = ordinal() == 0 ? VALUES.length - 1 : ordinal() - 1;
        return VALUES[newIndex];
    }
}
