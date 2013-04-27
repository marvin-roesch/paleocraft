package de.paleocrafter.pcraft.tileentity;

import de.paleocrafter.pcraft.lib.Strings;
import de.paleocrafter.pcraft.network.PacketTypeHandler;
import de.paleocrafter.pcraft.network.packet.PacketTileUpdate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

/**
 * PaleoCraft
 * 
 * TilePC
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TilePC extends TileEntity {
    private ForgeDirection orientation;
    private byte state;
    private String customName;

    public TilePC() {
        orientation = ForgeDirection.SOUTH;
        state = 0;
        customName = "";
    }

    public ForgeDirection getOrientation() {
        return orientation;
    }

    public void setOrientation(ForgeDirection orientation) {
        this.orientation = orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = ForgeDirection.getOrientation(orientation);
    }

    public short getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public boolean hasCustomName() {
        return customName != null && customName.length() > 0;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public boolean isUseableByPlayer(EntityPlayer player) {
        return true;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);
        if (nbtTagCompound.hasKey(Strings.NBT_TE_DIRECTION)) {
            this.setOrientation(ForgeDirection.getOrientation(nbtTagCompound
                    .getByte(Strings.NBT_TE_DIRECTION)));
        }

        if (nbtTagCompound.hasKey(Strings.NBT_TE_STATE)) {
            state = nbtTagCompound.getByte(Strings.NBT_TE_STATE);
        }

        if (nbtTagCompound.hasKey(Strings.NBT_TE_NAME)) {
            customName = nbtTagCompound.getString(Strings.NBT_TE_NAME);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        nbtTagCompound.setByte(Strings.NBT_TE_DIRECTION,
                (byte) orientation.ordinal());
        nbtTagCompound.setByte(Strings.NBT_TE_STATE, state);

        if (this.hasCustomName()) {
            nbtTagCompound.setString(Strings.NBT_TE_NAME, customName);
        }
    }

    @Override
    public Packet getDescriptionPacket() {
        return PacketTypeHandler.populatePacket(new PacketTileUpdate(xCoord,
                yCoord, zCoord, orientation, state, customName));
    }

}
