package net.theevilreaper.canis;

import net.kyori.adventure.key.Key;
import net.minestom.server.instance.block.BlockHandler;
import net.minestom.server.tag.Tag;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

/**
 * Implementation of a {@link BlockHandler} which reads the nbt tags for a skull.
 *
 * @author theEvilReaper
 * @version 1.1.0
 * @since 1.0.0
 **/
public class SkullHandler implements BlockHandler {

    private static final Key SKULL_KEY = Key.key("minecraft:skull");

    private static final List<Tag<?>> TAG_LIST = List.of(
            Tag.String("custom_name"),
            Tag.String("note_block_sound"),
            Tag.NBT("profile")
    );

    /**
     * Returns all tags that are needed for the block.
     *
     * @return the list with the tags
     */
    @Override
    public @NotNull Collection<Tag<?>> getBlockEntityTags() {
        return TAG_LIST;
    }

    @Override
    public @NotNull Key getKey() {
        return SKULL_KEY;
    }
}
