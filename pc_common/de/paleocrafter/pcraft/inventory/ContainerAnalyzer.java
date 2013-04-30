package de.paleocrafter.pcraft.inventory;

import de.paleocrafter.pcraft.inventory.slot.SlotAnalyzerFuel;
import de.paleocrafter.pcraft.inventory.slot.SlotAnalyzerInput;
import de.paleocrafter.pcraft.inventory.slot.SlotAnalyzerResult;
import de.paleocrafter.pcraft.item.ItemFossil;
import de.paleocrafter.pcraft.tileentity.TileAnalyzer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * PaleoCraft
 * 
 * ContainerAnalyzer
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ContainerAnalyzer extends Container {

    TileAnalyzer te;

    public ContainerAnalyzer(InventoryPlayer inventoryPlayer,
            TileAnalyzer analyzer) {

        // Add the analyzer "to be analyzed" slot to the container
        this.addSlotToContainer(new SlotAnalyzerInput(analyzer, 0, 48, 18));

        // Add the analyzer fuel slot to the container
        this.addSlotToContainer(new SlotAnalyzerFuel(analyzer, 1, 11, 18));

        // Add the analyzer results slot to the container
        this.addSlotToContainer(new SlotAnalyzerResult(analyzer, 2, 48, 94));

        // Add the player's inventory slots to the container
        for (int inventoryRowIndex = 0; inventoryRowIndex < 3; ++inventoryRowIndex) {
            for (int inventoryColumnIndex = 0; inventoryColumnIndex < 9; ++inventoryColumnIndex) {
                this.addSlotToContainer(new Slot(inventoryPlayer,
                        inventoryColumnIndex + inventoryRowIndex * 9 + 9,
                        8 + inventoryColumnIndex * 18,
                        134 + inventoryRowIndex * 18));
            }
        }

        // Add the player's action bar slots to the container
        for (int actionBarSlotIndex = 0; actionBarSlotIndex < 9; ++actionBarSlotIndex) {
            this.addSlotToContainer(new Slot(inventoryPlayer,
                    actionBarSlotIndex, 8 + actionBarSlotIndex * 18, 192));
        }

        this.te = analyzer;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int slotId) {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(slotId);

        if (slot != null && slot.getHasStack()) {
            ItemStack is1 = slot.getStack();
            itemstack = is1.copy();

            if (slotId == 2) {
                if (!this.mergeItemStack(is1, 3, 39, true)) {
                    return null;
                }

                slot.onSlotChange(is1, itemstack);
            } else if (slotId != 1 && slotId != 0) {
                if (is1.getItem() instanceof ItemFossil
                        && is1.getItemDamage() == 0) {
                    if (!this.mergeItemStack(is1, 0, 1, false)) {
                        return null;
                    }
                } else if (is1.getItem() instanceof ItemFossil) {
                    if (!this.mergeItemStack(is1, 1, 2, false)) {
                        return null;
                    }
                } else if (slotId >= 3 && slotId < 30) {
                    if (!this.mergeItemStack(is1, 30, 39, false)) {
                        return null;
                    }
                } else if (slotId >= 30 && slotId < 39
                        && !this.mergeItemStack(is1, 3, 30, false)) {
                    return null;
                }
            } else if (!this.mergeItemStack(is1, 3, 39, false)) {
                return null;
            }

            if (is1.stackSize == 0) {
                slot.putStack((ItemStack) null);
            } else {
                slot.onSlotChanged();
            }

            if (is1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(player, is1);
        }

        return itemstack;
    }
}
