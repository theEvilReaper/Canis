package net.theevilreaper.canis.sign;

import net.theevilreaper.canis.sign.side.SignSide;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author theEvilReaper
 * @version 1.0.0
 * @since 1.0.0
 **/
public interface Sign {

    String WATER_LOGGED = "waterlogged";
    String FACING = "facing";

    void updateRotation(@NotNull SignRotation rotation);

    void clearLines(@NotNull SignSide side);

    @Nullable SignText getSignText(@NotNull SignSide side);

    void updateLines(@NotNull SignSide side);

    boolean isWaterLogged();
}
