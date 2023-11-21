package net.theevilreaper.canis.sign;

import net.minestom.server.tag.TagReadable;
import net.theevilreaper.canis.sign.side.SignSide;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * The interface contains all method to describe the basic structure of a sign.
 * @author theEvilReaper
 * @version 1.0.0
 * @since 1.0.0
 **/
public interface Sign extends TagReadable {


    String WATER_LOGGED = "waterlogged";
    String FACING = "facing";

    /**
     * Updates the current rotation from a side with the invoked rotation.
     * NOTE: The method throws an exception when a sign retrieves a invalid rotation.
     * @param rotation the new rotation to set
     */
    void updateRotation(@NotNull SignRotation rotation);

    /**
     * Clears a side from a sign
     * @param side the side to clear
     */
    void clearLines(@NotNull SignSide side);

    /**
     * Get the corresponding {@link SignText} reference from a specific side.
     * It could be null when a side contains no reference
     * @param side the side to get the text
     * @return null or the {@link SignText} reference from the invoked side
     */
    @Nullable SignText getSignText(@NotNull SignSide side);

    /**
     * This method triggers the content update of a sign when some line received an update.
     * Note: The method is not called automatically when a line got changed.
     * @param side the side to update the text
     */
    void updateLines(@NotNull SignSide side);

    /**
     * Returns an indicator if the sign is water logged or not.
     * @return true when the sign is water logged otherwise false
     */
    boolean isWaterLogged();
}
