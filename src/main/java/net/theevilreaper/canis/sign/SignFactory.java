package net.theevilreaper.canis.sign;

import net.minestom.server.coordinate.Vec;
import net.minestom.server.instance.Instance;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * @author theEvilReaper
 * @version 1.0.0
 * @since
 **/

@ApiStatus.Experimental
public abstract class SignFactory {

    private SignFactory() {}

    public static @NotNull Sign createStandingSign(@NotNull Instance instance, @NotNull Vec position, @NotNull SignType type) {
        return new PositionedSign(type.getStandingSign(), instance, position);
    }

    public static @NotNull Sign createWallSign(@NotNull Instance instance, @NotNull Vec position, @NotNull SignType type) {
        return new PositionedSign(type.getWallSign(), instance, position);
    }

    public static @NotNull Sign createHangingSign(@NotNull Instance instance, @NotNull Vec position, @NotNull SignType type) {
        return new PositionedSign(type.getHangingSign(), instance, position);
    }
}
