package de.paleocrafter.pcraft.inventory;

import de.paleocrafter.pcraft.tileentity.TileAnalyzer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

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
        this.addSlotToContainer(new Slot(analyzer, 0, 48, 18));

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
}
