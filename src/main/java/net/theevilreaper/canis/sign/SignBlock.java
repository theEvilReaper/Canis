package net.theevilreaper.canis.sign;

import net.minestom.server.instance.block.Block;
import net.theevilreaper.canis.sign.nbt.SignDataPacketAdapter;
import net.theevilreaper.canis.sign.side.SignSide;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author theEvilReaper
 * @version 1.0.0
 * @since 1.0.0
 **/
public abstract class SignBlock implements Sign, SignDataPacketAdapter {

    protected Block block;
    protected SignText frontSide;
    protected SignText backSide;
    private final boolean isWallSign;
    protected final int blockEntityId;

    SignBlock(@NotNull Block block) {
        this.block = block;
        this.isWallSign = block.name().endsWith("wall_sign");
        this.frontSide = new SignText();
        this.backSide = isWallSign ? null : new SignText();
        this.blockEntityId = block.registry().blockEntityId();
    }

    @Override
    public boolean isWaterLogged() {
        var propertyState = block.getProperty(WATER_LOGGED);
        return "true".equals(propertyState);
    }

    @Override
    public void updateRotation(@NotNull SignRotation rotation) {
        var newState = isWallSign ? rotation.name().toLowerCase() : String.valueOf(rotation.ordinal());
        block = block.withProperty(isWallSign ? FACING : "rotation", newState);
    }

    @Override
    public void clearLines(@NotNull SignSide side) {
        switch (side) {
            case FRONT -> {
                frontSide = new SignText();
            }
            case BACK -> {
                if (!isWallSign) {
                    backSide = new SignText();
                }
            }
        }
        this.updateLines(side);
    }

    @Override
    public @Nullable SignText getSignText(@NotNull SignSide side) {
        return switch (side) {
            case FRONT -> frontSide;
            case BACK -> backSide;
        };
    }
}
