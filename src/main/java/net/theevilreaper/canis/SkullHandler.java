package net.theevilreaper.canis;

import net.kyori.adventure.key.Key;
import net.minestom.server.instance.block.BlockHandler;
import net.minestom.server.tag.Tag;
import net.minestom.server.utils.NamespaceID;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Implementation of a {@link BlockHandler} which reads the nbt tags for a skull.
 * @author theEvilReaper
 * @version 1.0.0
 * @since 1.0.0
 **/
public class SkullHandler implements BlockHandler {

    private static final NamespaceID namespaceID = NamespaceID.from(Key.key("minecraft:skull"));

    private static final List<Tag<?>> TAG_LIST;

    static {
        TAG_LIST = new ArrayList<>();
        TAG_LIST.add(Tag.String("ExtraType"));
        TAG_LIST.add(Tag.NBT("SkullOwner"));
    }

    /**
     * Returns all tags which are needed for the block.
     * @return the list with the tags
     */
    @Override
    public @NotNull Collection<Tag<?>> getBlockEntityTags() {
       return TAG_LIST;
    }

    /**
     * Returns the {@link NamespaceID} for the block.
     * @return the given namespace
     */
    @Override
    public @NotNull NamespaceID getNamespaceId() {
        return namespaceID;
    }
}
