package net.theevilreaper.canis.sign;

import net.minestom.server.instance.block.Block;
import org.jetbrains.annotations.NotNull;

/**
 * The enum contains all available sign combination from the game.
 * To reduce the entries each entry contains his standing, hanging and wall variant.
 * @author theEvilReaper
 * @version 1.0.0
 * @since 1.0.0
 **/
@SuppressWarnings("java:S3252")
public enum SignType {
    OAK(Block.OAK_SIGN, Block.OAK_WALL_SIGN, Block.OAK_HANGING_SIGN),
    SPRUCE(Block.SPRUCE_SIGN, Block.SPRUCE_WALL_SIGN, Block.SPRUCE_HANGING_SIGN),
    BIRCH(Block.BIRCH_SIGN, Block.BIRCH_WALL_SIGN, Block.BIRCH_HANGING_SIGN),
    JUNGLE(Block.JUNGLE_SIGN, Block.JUNGLE_WALL_SIGN, Block.JUNGLE_HANGING_SIGN),
    ACACIA(Block.ACACIA_SIGN, Block.ACACIA_WALL_SIGN, Block.ACACIA_HANGING_SIGN),
    DARK_OAK(Block.DARK_OAK_SIGN, Block.DARK_OAK_WALL_SIGN, Block.DARK_OAK_HANGING_SIGN),
    CHERRY(Block.CHERRY_SIGN, Block.CHERRY_WALL_SIGN, Block.CHERRY_HANGING_SIGN),
    BAMBOO(Block.BAMBOO_SIGN, Block.BAMBOO_WALL_SIGN, Block.BAMBOO_HANGING_SIGN),
    CRIMSON(Block.CRIMSON_SIGN, Block.CRIMSON_WALL_SIGN, Block.CRIMSON_HANGING_SIGN),
    WARPED(Block.WARPED_SIGN, Block.WARPED_WALL_SIGN, Block.WARPED_HANGING_SIGN),
    MANGROVE(Block.MANGROVE_SIGN, Block.MANGROVE_WALL_SIGN, Block.MANGROVE_HANGING_SIGN);

    private final Block standingSign;
    private final Block wallSign;
    private final Block hangingSign;

    /**
     * Creates a new {@link SignType} entry with the given block values.
     * @param standingSign the standing sign block
     * @param wallSign the wall sign block
     * @param hangingSign the hanging sign block
     */
    SignType(@NotNull Block standingSign, @NotNull Block wallSign, @NotNull Block hangingSign) {
        this.standingSign = standingSign;
        this.hangingSign = hangingSign;
        this.wallSign = wallSign;
    }

    /**
     * Returns the block which represents the standing variant of a sign.
     * @return the wall sign block
     */
    public @NotNull Block getStandingSign() {
        return standingSign;
    }

    /**
     * Returns the block which represents the wall variant of a sign.
     * @return the wall sign block
     */
    public @NotNull Block getWallSign() {
        return wallSign;
    }

    /**
     * Returns the block which represents the hanging variant of a sign.
     * @return the hanging sign block
     */
    public @NotNull Block getHangingSign() {
        return hangingSign;
    }
}
