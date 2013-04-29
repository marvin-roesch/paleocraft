package de.paleocrafter.pcraft.tileentity;

import de.paleocrafter.pcraft.item.ModItems;
import de.paleocrafter.pcraft.lib.Strings;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

/**
 * PaleoCraft
 * 
 * TileAnalyzer
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TileAnalyzer extends TilePC implements IInventory {
    private float laserRotX;
    private float laserRotZ;

    private ItemStack[] inventory;

    private final int INVENTORY_SIZE = 3;

    public static final int INPUT_INVENTORY_INDEX = 0;
    public static final int OUTPUT_INVENTORY_INDEX = 1;

    public TileAnalyzer() {
        super();
        inventory = new ItemStack[INVENTORY_SIZE];
        setProgress(0);
        setFuelLevel(0);
    }

    /**
     * @return the progess
     */
    public int getProgress() {
        return this.getInt("progress");
    }

    /**
     * @param progess
     *            the progess to set
     */
    public void setProgress(int progress) {
        this.setInt("progress", progress);
    }

    /**
     * @return the fuelLevel
     */
    public int getFuelLevel() {
        return this.getInt("fuelLevel");
    }

    /**
     * @param fuelLevel
     *            the fuelLevel to set
     */
    public void setFuelLevel(int fuelLevel) {
        this.setInt("fuelLevel", fuelLevel);
    }

    public int incrFuelLevel(int ammonites) {
        int incr = 0;
        int f10 = getFuelLevel() / 10;
        if (f10 == 5) {
            return 0;
        } else if (f10 < 5) {
            incr = 5 - f10;
            if (ammonites < 5) {
                if (incr > ammonites) {
                    incr = ammonites;
                }
            }
        }
        setFuelLevel(getFuelLevel() + incr * 10);
        return incr;
    }

    @Override
    public void updateEntity() {
        if (inventory[1] != null) {
            int sizeBefore = getStackInSlot(1).stackSize;
            int loss = incrFuelLevel(getStackInSlot(1).stackSize);
            if (sizeBefore <= loss) {
                setInventorySlotContents(1, null);
            } else {
                setInventorySlotContents(1, new ItemStack(ModItems.ammonite,
                        sizeBefore - loss));
            }
        }

        if (inventory[0] != null) {
            this.setState((byte) 1);
        } else {
            this.setState((byte) 0);
        }
    }

    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        ItemStack itemStack = getStackInSlot(slot);

        if (itemStack != null) {
            if (itemStack.stackSize <= amount) {
                setInventorySlotContents(slot, null);
            } else {
                itemStack = itemStack.splitStack(amount);
                if (itemStack.stackSize == 0) {
                    setInventorySlotContents(slot, null);
                }
            }
        }

        return itemStack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        ItemStack itemStack = getStackInSlot(slot);
        if (itemStack != null) {
            setInventorySlotContents(slot, null);
        }
        return itemStack;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack) {
        inventory[slot] = itemStack;
        if (itemStack != null && itemStack.stackSize > getInventoryStackLimit()) {
            itemStack.stackSize = getInventoryStackLimit();
        }
    }

    @Override
    public String getInvName() {
        return this.hasCustomName() ? this.getCustomName()
                : Strings.INV_ANALYZER_NAME;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public void openChest() {
    }

    @Override
    public void closeChest() {
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);

        // Read in the ItemStacks in the inventory from NBT
        NBTTagList tagList = nbtTagCompound.getTagList("Items");
        inventory = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < tagList.tagCount(); ++i) {
            NBTTagCompound tagCompound = (NBTTagCompound) tagList.tagAt(i);
            byte slot = tagCompound.getByte("Slot");
            if (slot >= 0 && slot < inventory.length) {
                inventory[slot] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {

        super.writeToNBT(nbtTagCompound);

        // Write the ItemStacks in the inventory to NBT
        NBTTagList tagList = new NBTTagList();
        for (int currentIndex = 0; currentIndex < inventory.length; ++currentIndex) {
            if (inventory[currentIndex] != null) {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) currentIndex);
                inventory[currentIndex].writeToNBT(tagCompound);
                tagList.appendTag(tagCompound);
            }
        }
        nbtTagCompound.setTag("Items", tagList);
    }

    @Override
    public boolean isInvNameLocalized() {
        return this.hasCustomName();
    }

    @Override
    public boolean isStackValidForSlot(int i, ItemStack itemstack) {
        return true;
    }

    /**
     * @return the laserRotX
     */
    public float getLaserRotX() {
        return laserRotX;
    }

    /**
     * @param laserRotX
     *            the laserRotX to set
     */
    public void setLaserRotX(float laserRotX) {
        this.laserRotX = laserRotX;
    }

    /**
     * @return the laserRotZ
     */
    public float getLaserRotZ() {
        return laserRotZ;
    }

    /**
     * @param laserRotZ
     *            the laserRotZ to set
     */
    public void setLaserRotZ(float laserRotZ) {
        this.laserRotZ = laserRotZ;
    }

}
