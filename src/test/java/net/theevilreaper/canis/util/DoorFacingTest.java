package net.theevilreaper.canis.util;

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

}