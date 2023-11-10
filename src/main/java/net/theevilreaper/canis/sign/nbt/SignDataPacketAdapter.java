package net.theevilreaper.canis.sign.nbt;

import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.network.packet.server.play.BlockEntityDataPacket;
import net.theevilreaper.canis.sign.SignText;
import net.theevilreaper.canis.sign.side.SignSide;
import org.jetbrains.annotations.NotNull;
import org.jglrxavpok.hephaistos.nbt.NBT;
import org.jglrxavpok.hephaistos.nbt.NBTCompound;
import org.jglrxavpok.hephaistos.nbt.NBTString;
import org.jglrxavpok.hephaistos.nbt.NBTType;

import java.util.Locale;

/**
 * The interface contains some method which are used to construct the nbt structure of a sign.
 * That is very important because otherwise the player can't the text on the sign or the changed color of it.
 * @author theEvilReaper
 * @version 1.0.0
 * @since 1.0.0
 **/
public interface SignDataPacketAdapter {

    String FRONT_TEXT = "front_text";
    String BACK_TEXT = "back_text";

    /**
     * Constructs the {@link NBTCompound} which holds the text information from a sign.
     * @param text the text which should be shown
     * @param side the side where the text should be shown
     * @return the created {@link NBTCompound} instance
     */
    default @NotNull NBTCompound prepareNBTCompound(@NotNull SignText text, @NotNull SignSide side) {
        var size = text.getMessages().length;
        var lineSerializer = GsonComponentSerializer.gson();
        var linesAsNBT = new NBTString[size];
        for (int i = 0; i < size; i++) {
            linesAsNBT[i] = NBT.String(lineSerializer.serialize(text.getMessages()[i]));
        }

        var rawMessages = NBT.List(NBTType.TAG_String, linesAsNBT);

        var sideTag = switch (side) {
            case FRONT -> FRONT_TEXT;
            case BACK -> BACK_TEXT;
        };

        var messageTag = NBT.Compound(writer -> {
            writer.put("has_glowing_text", NBT.Boolean(text.hasGlowingText()));
            writer.put("color", NBT.String(text.getDyeColor().name().toLowerCase(Locale.ROOT)));
            writer.put("messages", rawMessages);
        });

        return NBT.Compound(writer -> {
            writer.put("is_waxed", NBT.Boolean(false));
            writer.put(sideTag, messageTag);
        });
    }

    /**
     * Creates a new {@link BlockEntityDataPacket} reference which holds the updated sign data.
     * @param entityId the id from the block entity
     * @param pos the pos from the block
     * @param compound the nbt compound with the updated data
     * @return the created instance
     */
    default @NotNull BlockEntityDataPacket createLinePacket(int entityId, @NotNull Pos pos, @NotNull NBTCompound compound) {
        return new BlockEntityDataPacket(pos, entityId, compound);
    }
}
