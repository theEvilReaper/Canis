package net.theevilreaper.canis.sign;

import net.minestom.server.utils.validate.Check;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * The protocol from the game defines each possible rotation state which a sign can be potentially have.
 * But the game has three different types of signs which can have all possible rotations or only a few.
 * Depends on the type of the sign some methods should be used carefully to prevent errors during the runtime.
 * <ul>
 *     <li>STANDING_SIGN has all rotation states from the enum</li>
 *     <li>WALL_SIGN has only the rotation states from the enum which are not diagonal</li>
 *     <li>HANGING_SIGN has all rotation states from the enum</li>
 * </ul>
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

    // Stores only the facing types which are not diagonal
    private static final SignRotation[] BLOCK_FACING = new SignRotation[]{
            SOUTH,
            WEST,
            NORTH,
            EAST
    };

    /**
     * Tries to parse a given rotation string to a {@link SignRotation} reference.
     * @param facing the face to parse
     * @return null when no face matches with the provided string otherwise the determined {@link SignRotation}
     */
    public static @Nullable SignRotation getRotation(@NotNull String facing) {
        Check.argCondition(facing.trim().isEmpty(), "The facing can't be empty");
        boolean hasUnderScore = facing.contains("_");
        var upperCasedFace = facing.toUpperCase();
        return hasUnderScore ? findFace(upperCasedFace, VALUES) : findFace(upperCasedFace, BLOCK_FACING);
    }

    /**
     * Parses an index to it's corresponding rotation entries.
     * @param index the index (ordinal id) to parse
     * @return null when the index is not valid otherwise the {@link SignRotation} which matches with the given index
     */
    public static @Nullable SignRotation getRotation(int index) {
        return index < 0 || index >= VALUES.length ? null : VALUES[index];
    }

    /**
     * Returns the opposite {@link SignRotation} from an entry.
     * @return the opposite rotation
     */
    public @NotNull SignRotation opposite() {
        return VALUES[(ordinal() + VALUES.length / 2) % VALUES.length];
    }

    /**
     * Returns the opposite {@link SignRotation} from a block face rotation
     * @return the opposite direction
     */
    public @NotNull SignRotation oppositeBlockFacing() {
        Check.argCondition(ordinal() % BLOCK_FACING.length != 0, "Cannot get the opposite block facing of a diagonal facing");
        return VALUES[(ordinal() + BLOCK_FACING.length * 2) % VALUES.length];
    }

    /**
     * Returns the next {@link SignRotation} which is the next clockwise entry
     * @return the determined entry.
     */
    public @NotNull SignRotation rotateClockwise() {
        return VALUES[(ordinal() + 1) % VALUES.length];
    }

    /**
     * Returns the next {@link SignRotation} which is the next counter clockwise entry
     * @return the determined entry.
     */
    public @NotNull SignRotation rotateCounterClockwise() {
        var newIndex = ordinal() == 0 ? VALUES.length - 1 : ordinal() - 1;
        return VALUES[newIndex];
    }

    /**
     * Returns the {@link SignRotation} entry which matches with the given string input.
     * @param face the face as string
     * @param values the array to check if an entry matches with the face
     * @return null when no face matches otherwise the {@link SignRotation}
     */
    private static @Nullable SignRotation findFace(@NotNull String face, @NotNull SignRotation... values) {
        SignRotation result = null;
        for (int i = 0; i < values.length && result == null; i++) {
            if (!values[i].name().equals(face)) continue;
            result = values[i];
        }
        return result;
    }
}
