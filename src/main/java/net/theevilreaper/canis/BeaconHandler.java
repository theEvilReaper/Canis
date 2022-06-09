package net.theevilreaper.canis;

import net.minestom.server.instance.block.BlockHandler;
import net.minestom.server.tag.Tag;
import net.minestom.server.utils.NamespaceID;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

/**
 * Implementation of a {@link BlockHandler} which reads the nbt tags for a beacon.
 * @author theEvilReaper
 * @version 1.0.0
 * @since 1.0.0
 **/
public class BeaconHandler implements BlockHandler {

    private static final NamespaceID BEACON_TAG = NamespaceID.from("minecraft:beacon");

    private static final List<Tag<?>> BEACON_TAGS = List.of(
            Tag.String("CustomName"),
            Tag.String("Lock"),
            Tag.Integer("Levels"),
            Tag.Integer("Primary"),
            Tag.Integer("Secondary")
    );

    /**
     * Returns all tags which are needed for the block.
     * @return the list with the tags
     */
    @Override
    public @NotNull Collection<Tag<?>> getBlockEntityTags() {
        return BEACON_TAGS;
    }

    /**
     * Returns the {@link NamespaceID} for the block.
     * @return the given namespace
     */
    @Override
    public @NotNull NamespaceID getNamespaceId() {
        return BEACON_TAG;
    }
}
