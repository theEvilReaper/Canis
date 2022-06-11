package net.theevilreaper.canis;

import net.minestom.server.instance.block.BlockHandler;
import net.minestom.server.tag.Tag;
import net.minestom.server.utils.NamespaceID;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

/**
 * Implementation of a {@link BlockHandler} which reads the nbt tags for a candle.
 * See <a href="https://minecraft.fandom.com/wiki/Candle">...</a>
 * @author theEvilReaper
 * @version 1.0.0
 * @since 1.0.0
 **/
public class CandleHandler implements BlockHandler {

    private static final NamespaceID CANDLE_KEY = NamespaceID.from("minecraft:candle");

    private static final List<Tag<?>> KEYS = List.of(
            Tag.Integer("candles").defaultValue(1),
            Tag.Boolean("lit").defaultValue(false),
            Tag.Boolean("waterlogged").defaultValue(false)
    );

    /**
     * Returns all tags which are needed for the block.
     * @return the list with the tags
     */
    @Override
    public @NotNull Collection<Tag<?>> getBlockEntityTags() {
        return KEYS;
    }

    /**
     * Returns the {@link NamespaceID} for the block.
     * @return the given namespace
     */
    @Override
    public @NotNull NamespaceID getNamespaceId() {
        return CANDLE_KEY;
    }
}
