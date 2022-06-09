package net.theevilreaper.canis;

import net.kyori.adventure.key.Key;
import net.minestom.server.instance.block.BlockHandler;
import net.minestom.server.tag.Tag;
import net.minestom.server.tag.TagReadable;
import net.minestom.server.tag.TagSerializer;
import net.minestom.server.tag.TagWritable;
import net.minestom.server.utils.NamespaceID;
import net.theevilreaper.canis.banner.BannerPattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;

/**
 * Implementation of a {@link BlockHandler} which reads the nbt tags for a banner.
 * @author theEvilReaper
 * @version 1.0.0
 * @since 1.0.0
 **/
public class BannerHandler implements BlockHandler {

    private static final NamespaceID namespaceID = NamespaceID.from(Key.key("minecraft:banner"));

    /**
     * Custom implementation of a {@link TagSerializer} which reads the Patterns tag from a banner.
     */
    private static final Tag<List<BannerPattern>> PATTERN_TAG = Tag.Structure("Patterns", new TagSerializer<BannerPattern>() {
        @Override
        public @Nullable BannerPattern read(@NotNull TagReadable reader) {
            final int color = reader.getTag(Tag.Integer("Color"));
            final String pattern = reader.getTag(Tag.String("Pattern"));
            return new BannerPattern(color, pattern);
        }

        @Override
        public void write(@NotNull TagWritable writer, @NotNull BannerPattern value) {
            writer.setTag(Tag.Integer("Color"), value.color());
            writer.setTag(Tag.String("Pattern"), value.pattern());
        }
    }).list().defaultValue(List.of());

    private static final List<Tag<?>> TAG_LIST = List.of(
            Tag.String("CustomName"),
            PATTERN_TAG
    );

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
