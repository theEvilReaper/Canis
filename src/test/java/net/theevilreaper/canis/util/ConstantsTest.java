package net.theevilreaper.canis.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstantsTest {

    @Test
    void testMaxBlockHeight() {
        assertEquals(255, Constants.MAX_BUILD_HEIGHT);
    }

}