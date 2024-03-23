package net.theevilreaper.canis.sign;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import net.minestom.server.color.DyeColor;
import net.minestom.server.entity.Player;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SignTextTest {

    @Test
    void testSignTextCreationWithoutParameters() {
        var signText = new SignText();
        for (Component message : signText.getMessages()) {
            assertEquals(Component.empty(), message);
        }
        assertEquals(DyeColor.BLACK, signText.getDyeColor());
        assertFalse(signText.hasGlowingText());
    }

    @Test
    void testSignTextCreationWithParameters() {
        var messages = new Component[4];
        Arrays.fill(messages, Component.empty());
        var signText = new SignText(messages, DyeColor.BLUE, true);
        for (Component message : signText.getMessages()) {
            assertEquals(Component.empty(), message);
        }
        assertNotEquals(DyeColor.BLACK, signText.getDyeColor());
        assertTrue(signText.hasGlowingText());
    }

    @Test
    void testLineSetOutsideTheValidIndex() {
        var signText = new SignText();
        var exception = assertThrowsExactly(
                ArrayIndexOutOfBoundsException.class,
                () -> signText.setMessage(12, Component.empty()),
                "The line must be between 0 and 4"
        );
    }

    @Test
    void testValidSignUsage() {
        var signText = new SignText();
        signText.setMessage(1, Component.text("Hello"));
        assertEquals("Hello", PlainTextComponentSerializer.plainText().serialize(signText.getMessages()[1]));
        signText.setGlowingText(true);
        assertTrue(signText.hasGlowingText());

    }
}