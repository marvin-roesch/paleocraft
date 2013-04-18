package de.paleocrafter.pcraft.block.tileentity;

import java.util.Random;

import net.minecraft.nbt.NBTTagCompound;

public class TileEntityFossile extends TileEntityPC {
    private int frontSide;

    public TileEntityFossile() {
        frontSide = new Random().nextInt(5);
    }

    public int getFrontSide() {
        return frontSide;
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);
        frontSide = tagCompound.getInteger("fossileFrontSide");
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);
        tagCompound.setInteger("fossileFrontSide", frontSide);
    }
}
