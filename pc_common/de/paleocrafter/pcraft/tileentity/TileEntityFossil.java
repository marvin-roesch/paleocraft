package de.paleocrafter.pcraft.tileentity;

import java.util.Random;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;

public class TileEntityFossil extends TileEntityPC {
    private int frontSide;

    public TileEntityFossil() {
        super();
        frontSide = new Random().nextInt(5);
    }

    public int getFrontSide() {
        return frontSide;
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);
        loadInfoFromNBT(tagCompound);
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);
        addInfoToNBT(tagCompound);
    }
    
    public void loadInfoFromNBT(NBTTagCompound tagCompound) {
        frontSide = tagCompound.getInteger("fossileFrontSide");
    }

    public void addInfoToNBT(NBTTagCompound tagCompound) {
        tagCompound.setInteger("fossileFrontSide", frontSide);
    }
    
    @Override
    public Packet getDescriptionPacket() {
        Packet132TileEntityData packet = (Packet132TileEntityData) super.getDescriptionPacket();
        NBTTagCompound tag = packet != null ? packet.customParam1 : new NBTTagCompound();

        addInfoToNBT(tag);

        return new Packet132TileEntityData(xCoord, yCoord, zCoord, 1, tag);
    }

    @Override
    public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt) {
        super.onDataPacket(net, pkt);
        NBTTagCompound tag = pkt.customParam1;
        loadInfoFromNBT(tag);
    }
}