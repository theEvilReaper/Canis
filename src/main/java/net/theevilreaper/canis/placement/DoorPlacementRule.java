package net.theevilreaper.canis.placement;

import net.minestom.server.coordinate.Point;
import net.minestom.server.entity.Player;
import net.minestom.server.instance.Instance;
import net.minestom.server.instance.block.Block;
import net.minestom.server.instance.block.BlockFace;
import net.minestom.server.instance.block.rule.BlockPlacementRule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class DoorPlacementRule extends BlockPlacementRule {

    public DoorPlacementRule(@NotNull Block block) {
        super(block);
    }

    @Override
    public @NotNull Block blockUpdate(@NotNull Instance instance, @NotNull Point blockPosition, @NotNull Block currentBlock) {
        return currentBlock;
    }

    @Override
    public @Nullable Block blockPlace(@NotNull Instance instance, @NotNull Block block, @NotNull BlockFace blockFace, @NotNull Point blockPosition, @NotNull Player pl) {
        String facing = "north";
        String half = "lower";
        String hinge = "left";

        return block.withProperties(getProperties(facing, half, hinge));
    }


    /**
     * Builds the map which contains the properties for a block which is a door.
     * The open and powered value are set to false by default.
     * @param facing the facing to set
     * @param half
     * @param hinge
     * @return the created map
     */
    private @NotNull Map<String, String> getProperties(@NotNull String facing, @NotNull String half, @NotNull String hinge) {
        var map = new HashMap<String, String>();

        map.put("facing", facing);
        map.put("half", half);
        map.put("hinge", hinge);
        map.put("open", "false");
        map.put("powered", "false");

        return map;
    }
}
