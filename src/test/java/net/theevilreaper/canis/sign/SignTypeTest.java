package net.theevilreaper.canis.sign;

import net.minestom.server.instance.block.Block;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SignTypeTest {

    private static final SignType[] VALUES = SignType.values();

    private static @NotNull Stream<Arguments> standingSigns() {
        return Stream.of(
                Arrays.stream(VALUES).map(signType -> Arguments.of(signType.getStandingSign())).toArray(Arguments[]::new));
    }

    private static @NotNull Stream<Arguments> wallSigns() {
        return Stream.of(
                Arrays.stream(VALUES).map(signType -> Arguments.of(signType.getWallSign())).toArray(Arguments[]::new));
    }

    private static @NotNull Stream<Arguments> hangingSigns() {
        return Stream.of(
                Arrays.stream(VALUES).map(signType -> Arguments.of(signType.getHangingSign())).toArray(Arguments[]::new));
    }

    @ParameterizedTest
    @MethodSource("standingSigns")
    void testStandingSigns(@NotNull Block argument) {
        assertTrue(argument.name().endsWith("sign"));
    }

    @ParameterizedTest
    @MethodSource("wallSigns")
    void testWallSigns(@NotNull Block argument) {
        assertTrue(argument.name().endsWith("wall_sign"));
    }

    @ParameterizedTest
    @MethodSource("hangingSigns")
    void testHangingSigns(@NotNull Block argument) {
        assertTrue(argument.name().endsWith("hanging_sign"));
    }
}
