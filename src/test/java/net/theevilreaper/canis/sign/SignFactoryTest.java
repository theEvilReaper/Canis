package net.theevilreaper.canis.sign;

import net.minestom.server.coordinate.Vec;
import net.minestom.server.tag.Tag;
import net.minestom.testing.Env;
import net.minestom.testing.EnvTest;
import net.theevilreaper.canis.sign.side.SignSide;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@EnvTest
class SignFactoryTest {

    @Test
    void testStandingSignCreation(Env env) {
        var instance = env.createFlatInstance();

        var sign = SignFactory.createStandingSign(instance, Vec.ZERO, SignType.BIRCH);

        assertNotNull(sign);
        assertNotNull(sign.getSignText(SignSide.FRONT));
        assertNotNull(sign.getSignText(SignSide.BACK));
        assertFalse(sign.isWaterLogged());

        env.destroyInstance(instance);
    }

    @Test
    void testWallSignCreation(Env env) {
        var instance = env.createFlatInstance();

        var sign = SignFactory.createWallSign(instance, Vec.ZERO, SignType.BIRCH);

        assertNotNull(sign);
        assertNull(sign.getSignText(SignSide.BACK));
        assertFalse(sign.isWaterLogged());

        env.destroyInstance(instance);
    }

    @Test
    void testHangingSignCreation(Env env) {
        var instance = env.createFlatInstance();

        var sign = SignFactory.createHangingSign(instance, Vec.ZERO, SignType.BIRCH);

        assertNotNull(sign);
        assertFalse(sign.hasTag(Tag.Boolean("test")));

        assertFalse(sign.isWaterLogged());

        env.destroyInstance(instance);
    }

}