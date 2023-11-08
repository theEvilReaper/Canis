package net.theevilreaper.canis.sign;

import net.kyori.adventure.text.Component;
import net.minestom.server.instance.block.Block;
import org.jetbrains.annotations.NotNull;

/**
 * @author theEvilReaper
 * @version 1.0.0
 * @since 1.0.0
 **/
public class SignBlock implements Sign {

    protected Block block;

    SignBlock(@NotNull Block block) {
        this.block = block;
    }

    public boolean isWaterlogged() {
        var propertyState = block.getProperty(WATER_LOGGED);
        return "true".equals(propertyState);
    }

    @Override
    public void updateRotation(@NotNull SignRotation rotation) {
        block = block.withProperty(FACING, String.valueOf(rotation.ordinal()));
    }

    @Override
    public void setLine(int index, @NotNull Component component) {
        if (index < 0 || index >= MAX_SIGN_LINES) {
            throw new IndexOutOfBoundsException("Please provide a line index between 0 and " + MAX_SIGN_LINES);
        }
    }

    @Override
    public void clearLines() {
    }

    @Override
    public @NotNull Component getLine(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= MAX_SIGN_LINES) {
            throw new IndexOutOfBoundsException("Please provide a line index between 0 and " + MAX_SIGN_LINES);
        }
        return null;
    }

    @Override
    public @NotNull Component[] getLines() {
        return new Component[0];
    }
}
