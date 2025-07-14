package net.theevilreaper.canis;

import net.kyori.adventure.key.Key;
import net.minestom.server.instance.block.BlockHandler;
import net.minestom.server.tag.Tag;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

/**
 * Implementation of a {@link BlockHandler} which reads the nbt tags for a sign.
 *
 * @author theEvilReaper
 * @version 1.1.0
 * @since 1.0.0
 **/
public class SignHandler implements BlockHandler {

    private static final Key SIGN_KEY = Key.key("minecraft:sign");

    private static final List<Tag<?>> SIGN_TAGS = List.of(
            Tag.Byte("GlowingText"),
            Tag.String("Color"),
            Tag.String("Text1"),
            Tag.String("Text2"),
            Tag.String("Text3"),
            Tag.String("Text4")
    );

    /**
     * Returns all tags which are needed for the block.
     *
     * @return the list with the tags
     */
    @Override
    public @NotNull Collection<Tag<?>> getBlockEntityTags() {
        return SIGN_TAGS;
    }

    @Override
    public @NotNull Key getKey() {
        return SIGN_KEY;
    }
}
