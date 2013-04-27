package de.paleocrafter.pcraft.inventory;

import de.paleocrafter.pcraft.tileentity.TileAnalyzer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

/**
 * PaleoCraft
 * 
 * ContainerAnalyzer
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ContainerAnalyzer extends Container {

    public ContainerAnalyzer(InventoryPlayer inventoryPlayer,
            TileAnalyzer analyzer) {

        // Add the analyzer "to be analyzed" slot to the container
        this.addSlotToContainer(new Slot(analyzer, 0, 56, 17));

        // Add the analyzer fuel slot to the container
        this.addSlotToContainer(new SlotAnalyzerFuel(analyzer, 1, 56, 62));

        // Add the analyzer results slot to the container
        this.addSlotToContainer(new SlotAnalyzerResult(analyzer, 2, 116, 35));

        // Add the player's inventory slots to the container
        for (int inventoryRowIndex = 0; inventoryRowIndex < 3; ++inventoryRowIndex) {
            for (int inventoryColumnIndex = 0; inventoryColumnIndex < 9; ++inventoryColumnIndex) {
                this.addSlotToContainer(new Slot(inventoryPlayer,
                        inventoryColumnIndex + inventoryRowIndex * 9 + 9,
                        8 + inventoryColumnIndex * 18,
                        94 + inventoryRowIndex * 18));
            }
        }

        // Add the player's action bar slots to the container
        for (int actionBarSlotIndex = 0; actionBarSlotIndex < 9; ++actionBarSlotIndex) {
            this.addSlotToContainer(new Slot(inventoryPlayer,
                    actionBarSlotIndex, 8 + actionBarSlotIndex * 18, 152));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {

        return true;
    }

    // TODO Write our own version - this is taken from ContainerFurnace
    @Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {

        ItemStack var3 = null;
        Slot var4 = (Slot) inventorySlots.get(par2);

        if (var4 != null && var4.getHasStack()) {
            ItemStack var5 = var4.getStack();
            var3 = var5.copy();

            if (par2 == 2) {
                if (!this.mergeItemStack(var5, 3, 39, true))
                    return null;

                var4.onSlotChange(var5, var3);
            } else if (par2 != 1 && par2 != 0) {
                if (FurnaceRecipes.smelting().getSmeltingResult(var5) != null) {
                    if (!this.mergeItemStack(var5, 0, 1, false))
                        return null;
                } else if (TileEntityFurnace.isItemFuel(var5)) {
                    if (!this.mergeItemStack(var5, 1, 2, false))
                        return null;
                } else if (par2 >= 3 && par2 < 30) {
                    if (!this.mergeItemStack(var5, 30, 39, false))
                        return null;
                } else if (par2 >= 30 && par2 < 39
                        && !this.mergeItemStack(var5, 3, 30, false))
                    return null;
            } else if (!this.mergeItemStack(var5, 3, 39, false))
                return null;

            if (var5.stackSize == 0) {
                var4.putStack((ItemStack) null);
            } else {
                var4.onSlotChanged();
            }

            if (var5.stackSize == var3.stackSize)
                return null;

            var4.onPickupFromSlot(par1EntityPlayer, var5);
        }

        return var3;
    }
}
