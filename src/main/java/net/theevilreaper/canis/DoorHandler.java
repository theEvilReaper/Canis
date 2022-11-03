package net.theevilreaper.canis;

import net.minestom.server.instance.block.BlockHandler;
import net.minestom.server.tag.Tag;
import net.minestom.server.utils.NamespaceID;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

public class DoorHandler implements BlockHandler {

    private static final NamespaceID DOOR_KEY = NamespaceID.from("minecraft:doors");

    private static final List<Tag<?>> BLOCK_TAGS = List.of(
            Tag.String("facing").defaultValue("north"),
            Tag.String("half").defaultValue("lower"),
            Tag.String("hinge").defaultValue("left"),
            Tag.Boolean("open").defaultValue(false),
            Tag.Boolean("powered").defaultValue(false)
    );

    @Override
    public @NotNull Collection<Tag<?>> getBlockEntityTags() {
        return BLOCK_TAGS;
    }

    @Override
    public @NotNull NamespaceID getNamespaceId() {
        return DOOR_KEY;
    }
}
