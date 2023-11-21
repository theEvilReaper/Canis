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

    /**
     * Creates a new instance from the class with the given data values.
     * @param messages the message array which contains the line data
     * @param dyeColor the color to display
     * @param glowing the indicator if the text is glowing or not
     */
    public SignText(@NotNull Component[] messages, @NotNull DyeColor dyeColor, boolean glowing) {
        this.messages = messages;
        this.dyeColor = dyeColor;
        this.glowingText = glowing;
    }

    /**
     * Set a new {@link Component} reference at a specific index.
     * @param line the line which should be updated
     * @param component the text reference to set
     * @throws ArrayIndexOutOfBoundsException when the index is not valid
     */
    public void setMessage(int line, @NotNull Component component) throws ArrayIndexOutOfBoundsException {
        if (line < 0 || line >= MAX_LINE_COUNT) throw new ArrayIndexOutOfBoundsException("The line must be between 0 and " + MAX_LINE_COUNT);
        this.messages[line] = component;
    }

    /**
     * Set if the text should have a glowing effect or not.
     * @param hasGlowingText true for glowing otherwise false
     */
    public void setGlowingText(boolean hasGlowingText) {
        this.glowingText = hasGlowingText;
    }

    /**
     * Returns if the text is glowing or not.
     * @return true when the next is glowing otherwise false
     */
    public boolean hasGlowingText() {
        return glowingText;
    }

    /**
     * Returns the current color for the text as {@link DyeColor}.
     * @return the underlying color value
     */
    public @NotNull DyeColor getDyeColor() {
        return dyeColor;
    }

    /**
     * Returns the array which holds the message references for the side.
     * @return the underlying array reference
     */
    public @NotNull Component[] getMessages() {
        return messages;
    }
}
