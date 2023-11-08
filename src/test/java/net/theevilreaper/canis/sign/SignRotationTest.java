package net.theevilreaper.canis.sign;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SignRotationTest {

    private static @NotNull Stream<Arguments> provideRotation() {
        return Stream.of(
                Arguments.of("west", SignRotation.WEST),
                Arguments.of("south_south_west", SignRotation.SOUTH_SOUTH_WEST),
                Arguments.of("north", SignRotation.NORTH),
                Arguments.of("invalidFace", null)
        );
    }

    private static @NotNull Stream<Arguments> rotateArguments() {
        return Stream.of(
                Arguments.of(SignRotation.WEST, SignRotation.WEST_NORTH_WEST),
                Arguments.of(SignRotation.SOUTH, SignRotation.SOUTH_SOUTH_WEST),
                Arguments.of(SignRotation.SOUTH_SOUTH_EAST, SignRotation.SOUTH)
        );
    }

    @ParameterizedTest
    @MethodSource("provideRotation")
    void testGetRotation(@NotNull String face, @NotNull SignRotation expected) {
        assertEquals(expected, SignRotation.getRotation(face));
    }

    @ParameterizedTest
    @MethodSource("rotateArguments")
    void testRotateClockWise(@NotNull SignRotation rotation, @NotNull SignRotation expected) {
        assertEquals(expected, rotation.rotateClockwise());
    }

    @ParameterizedTest
    @MethodSource("rotateArguments")
    void testRotateCounterClockWise(@NotNull SignRotation rotation, @NotNull SignRotation expected) {
        assertEquals(rotation, expected.rotateCounterClockwise());
    }

    @Test
    void testGetRotationOverOrdinal() {
        assertEquals(SignRotation.NORTH, SignRotation.getRotation(8));
        assertEquals(SignRotation.WEST, SignRotation.getRotation(4));
        assertNull(SignRotation.getRotation(16));
    }
}