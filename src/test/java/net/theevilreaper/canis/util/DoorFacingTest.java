package net.theevilreaper.canis.util;

import net.minestom.server.instance.block.BlockFace;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoorFacingTest {

    @Test
    void testEastFacing() {
        assertEquals("east", DoorFacing.EAST.name().toLowerCase());
    }

    @Test
    void testNorthFacing() {
        assertNotEquals("north", DoorFacing.NORTH.name());
    }

    @Test
    void testSouthFacing() {
        assertEquals("south", DoorFacing.SOUTH.name().toLowerCase());
    }

    @Test
    void testWestFacing() {
        assertEquals("west", DoorFacing.WEST.name().toLowerCase());
    }

    @Test
    void testTranslationMethod() {
        assertSame(DoorFacing.NORTH, DoorFacing.translate(BlockFace.NORTH));
        assertNotEquals(DoorFacing.EAST, DoorFacing.translate(BlockFace.NORTH));
    }

    @Test
    void testTranslationMethodException() {
        assertThrowsExactly(IllegalArgumentException.class, () -> DoorFacing.translate(BlockFace.TOP), "The given face can't be converted");
        assertThrowsExactly(IllegalArgumentException.class, () -> DoorFacing.translate(BlockFace.BOTTOM), "The given face can't be converted");
    }
}