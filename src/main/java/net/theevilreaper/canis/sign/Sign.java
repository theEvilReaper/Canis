package net.theevilreaper.canis.sign;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

/**
 * @author theEvilReaper
 * @version 1.0.0
 * @since
 **/

public interface Sign {

    String WATER_LOGGED = "waterlogged";
    String FACING = "facing";

    int MAX_SIGN_LINES = 4;

    void updateRotation(@NotNull SignRotation rotation);

    void setLine(int index, @NotNull Component component) throws IndexOutOfBoundsException;

    void clearLines();

    @NotNull Component getLine(int index) throws IndexOutOfBoundsException;

    @NotNull Component[] getLines();
}
