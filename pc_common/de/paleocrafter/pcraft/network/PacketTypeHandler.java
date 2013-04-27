package de.paleocrafter.pcraft.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import de.paleocrafter.pcraft.lib.Reference;
import de.paleocrafter.pcraft.network.packet.PacketPC;
import de.paleocrafter.pcraft.network.packet.PacketTileUpdate;

import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

/**
 * PaleoCraft
 *
 * PacketTypeHandler
 *
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public enum PacketTypeHandler {
    TILE(PacketTileUpdate.class);

    private Class<? extends PacketPC> clazz;

    PacketTypeHandler(Class<? extends PacketPC> clazz) {
        this.clazz = clazz;
    }

    public static PacketPC buildPacket(byte[] data) {

        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        int selector = bis.read();
        DataInputStream dis = new DataInputStream(bis);

        PacketPC packet = null;

        try {
            packet = values()[selector].clazz.newInstance();
        }
        catch (Exception e) {
            e.printStackTrace(System.err);
        }

        packet.readPopulate(dis);

        return packet;
    }

    public static PacketPC buildPacket(PacketTypeHandler type) {

        PacketPC packet = null;

        try {
            packet = values()[type.ordinal()].clazz.newInstance();
        }
        catch (Exception e) {
            e.printStackTrace(System.err);
        }

        return packet;
    }

    public static Packet populatePacket(PacketPC packetPC) {

        byte[] data = packetPC.populate();

        Packet250CustomPayload packet250 = new Packet250CustomPayload();
        packet250.channel = Reference.CHANNEL_NAME;
        packet250.data = data;
        packet250.length = data.length;
        packet250.isChunkDataPacket = packetPC.isChunkDataPacket;

        return packet250;
    }
}