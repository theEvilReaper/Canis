package net.theevilreaper.canis.sign;

import net.kyori.adventure.text.Component;
import net.minestom.server.color.DyeColor;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * The SignText class represents all information about the text on a sign.
 * @author theEvilReaper
 * @version 1.0.0
 * @since 1.0.0
 **/
@ApiStatus.Experimental
public final class SignText {

    private static final int MAX_LINE_COUNT = 4;
    private final Component[] messages;
    private final DyeColor dyeColor;
    private boolean glowingText;

    /**
     * Creates a new instance of the {@link SignText} class.
     */
    public SignText() {
        this.messages = new Component[MAX_LINE_COUNT];
        Arrays.fill(messages, Component.empty());
        this.dyeColor = DyeColor.BLACK;
    }

    public SignText(@NotNull Component[] messages, @NotNull DyeColor dyeColor, boolean glowing) {
        this.messages = messages;
        this.dyeColor = dyeColor;
        this.glowingText = glowing;
    }

    public void setMessage(int line, @NotNull Component component) throws ArrayIndexOutOfBoundsException {
        if (line < 0 || line >= MAX_LINE_COUNT) throw new ArrayIndexOutOfBoundsException("The line must be between 0 and " + MAX_LINE_COUNT);
        this.messages[line] = component;
    }

    public void setGlowingText(boolean hasGlowingText) {
        this.glowingText = hasGlowingText;
    }

    public boolean hasGlowingText() {
        return glowingText;
    }

    public @NotNull DyeColor getDyeColor() {
        return dyeColor;
    }

    public @NotNull Component[] getMessages() {
        return messages;
    }
}
