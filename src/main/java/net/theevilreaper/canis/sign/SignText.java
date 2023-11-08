package net.theevilreaper.canis.sign;

import net.kyori.adventure.text.Component;
import net.minestom.server.color.DyeColor;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * @author theEvilReaper
 * @version 1.0.0
 * @since
 **/

@ApiStatus.Experimental
public final class SignText {

    private final Component[] messages;
    private DyeColor dyeColor;
    private boolean glowingText;

    public SignText(@NotNull Component[] messages, @NotNull DyeColor dyeColor, boolean glowing) {
        this.messages = messages;
        this.dyeColor = dyeColor;
        this.glowingText = glowing;
    }

    public void setMessage(int line, @NotNull Component component) {
        this.messages[line] = component;
    }

    public void setGlowingText(boolean hasGlowingText) {
        this.glowingText = hasGlowingText;
    }

    public boolean hasGlowingText() {
        return glowingText;
    }
}
