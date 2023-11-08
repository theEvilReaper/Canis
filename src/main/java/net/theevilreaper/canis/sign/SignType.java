package net.theevilreaper.canis.sign;

import net.minestom.server.instance.block.Block;
import org.jetbrains.annotations.NotNull;

/**
 * @author theEvilReaper
 * @version 1.0.0
 * @since 1.0.0
 **/
public enum SignType {
    ;
    private final Block standingSign;
    private final Block hangingSign;
    private final Block wallSign;

    SignType(@NotNull Block standingSign, @NotNull Block hangingSign, @NotNull Block wallSign) {
        this.standingSign = standingSign;
        this.hangingSign = hangingSign;
        this.wallSign = wallSign;
    }

    public @NotNull Block getHangingSign() {
        return hangingSign;
    }

    public @NotNull Block getStandingSign() {
        return standingSign;
    }

    public @NotNull Block getWallSign() {
        return wallSign;
    }
}
