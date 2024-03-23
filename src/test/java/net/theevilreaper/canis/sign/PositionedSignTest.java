package net.theevilreaper.canis.sign;

import net.minestom.server.coordinate.Pos;
import net.minestom.server.coordinate.Vec;
import net.minestom.testing.Env;
import net.minestom.testing.EnvTest;
import net.theevilreaper.canis.sign.side.SignSide;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@EnvTest
class PositionedSignTest {

    @Test
    void testPositionedSign(@NotNull Env env) {
        var instance = env.createFlatInstance();

        PositionedSign sign = (PositionedSign) SignFactory.createStandingSign(instance, Vec.ZERO, SignType.BIRCH);

        assertNotNull(sign);

        sign.updateRotation(SignRotation.EAST);
        sign.updateLines(SignSide.FRONT);
        sign.updateLines(SignSide.BACK);
        sign.remove();

        env.destroyInstance(instance);
    }

}