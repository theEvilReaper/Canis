package net.theevilreaper.canis.sign;

/**
 * This interface is an extension for the given {@link Sign} interface.
 * It should be used when a sign should be placed into a given world.
 * @author theEvilReaper
 * @version 1.0.0
 * @since 1.0.0
 **/
public interface PositionSign extends Sign {

    /**
     * Handles the logic what should happen when the sign gets removed.
     */
    void remove();
}
