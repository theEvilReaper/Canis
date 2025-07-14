package net.theevilreaper.canis;

import net.kyori.adventure.key.Key;
import net.minestom.server.instance.block.BlockHandler;
import net.minestom.server.tag.Tag;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

/**
 * Implementation of a {@link BlockHandler} which reads the nbt tags for a beacon.
 *
 * @author theEvilReaper
 * @version 1.1.0
 * @since 1.0.0
 **/
public class BeaconHandler implements BlockHandler {

    private static final Key BEACON_TAG = Key.key("minecraft:beacon");

    private static final List<Tag<?>> BEACON_TAGS = List.of(
            Tag.String("CustomName"),
            Tag.String("Lock"),
            Tag.Integer("Levels"),
            Tag.Integer("Primary"),
            Tag.Integer("Secondary")
    );

    /**
     * Returns all tags that are needed for the block.
     *
     * @return the list with the tags
     */
    @Override
    public @NotNull Collection<Tag<?>> getBlockEntityTags() {
        return BEACON_TAGS;
    }

    @Override
    public @NotNull Key getKey() {
        return BEACON_TAG;
    }
}
