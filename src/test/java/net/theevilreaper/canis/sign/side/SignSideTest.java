package net.theevilreaper.canis.sign.side;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignSideTest {

    @Test
    void testSignSideArray() {
        assertEquals(2, SignSide.values().length);
    }
}
