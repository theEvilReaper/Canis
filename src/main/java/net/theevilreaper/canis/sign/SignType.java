package net.theevilreaper.canis.sign;

import net.minestom.server.instance.block.Block;
import org.jetbrains.annotations.NotNull;

/**
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
    WARPED(Block.WARPED_SIGN, Block.WARPED_WALL_SIGN, Block.WARPED_HANGING_SIGN);
    private final Block standingSign;
    private final Block hangingSign;
    private final Block wallSign;

    SignType(@NotNull Block standingSign, @NotNull Block hangingSign, @NotNull Block wallSign) {
        this.standingSign = standingSign;
        this.hangingSign = hangingSign;
        this.wallSign = wallSign;
    }

    public @NotNull Block getHangingSign() {
        return hangingSign;
    }

    public @NotNull Block getStandingSign() {
        return standingSign;
    }

    public @NotNull Block getWallSign() {
        return wallSign;
    }
}
