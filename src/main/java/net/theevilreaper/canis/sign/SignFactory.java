package net.theevilreaper.canis.sign;

import net.minestom.server.coordinate.Vec;
import net.minestom.server.instance.Instance;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * Allows the creation of different sign types.
 * @author theEvilReaper
 * @version 1.0.0
 * @since 1.0.0
 **/
@ApiStatus.Experimental
public abstract class SignFactory {

    private SignFactory() {}

    /**
     * Creates a sign which stands on the ground.
     * @param instance the instance to place to block
     * @param position the position where the sign stands
     * @param type the type to extract the right sign type
     * @return a created {@link Sign} reference
     */
    public static @NotNull Sign createStandingSign(@NotNull Instance instance, @NotNull Vec position, @NotNull SignType type) {
        return new PositionedSign(type.getStandingSign(), instance, position);
    }

    /**
     * Creates a sign which hangs at a specific side of a block.
     * @param instance the instance to place to block
     * @param position the position where the sign stands
     * @param type the type to extract the right sign type
     * @return a created {@link Sign} reference
     */
    public static @NotNull Sign createWallSign(@NotNull Instance instance, @NotNull Vec position, @NotNull SignType type) {
        return new PositionedSign(type.getWallSign(), instance, position);
    }

    /**
     * Creates a hanging sign.
     * @param instance the instance to place to block
     * @param position the position where the sign stands
     * @param type the type to extract the right sign type
     * @return a created {@link Sign} reference
     */
    public static @NotNull Sign createHangingSign(@NotNull Instance instance, @NotNull Vec position, @NotNull SignType type) {
        return new PositionedSign(type.getHangingSign(), instance, position);
    }
}
