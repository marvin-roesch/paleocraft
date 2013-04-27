package de.paleocrafter.pcraft.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * PaleoCraft
 *
 * SlotAnalyzerResult
 *
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class SlotAnalyzerResult extends Slot {
    
    public SlotAnalyzerResult(IInventory inventory, int x, int y, int z) {
        super(inventory, x, y, z);
    }

    @Override
    public boolean isItemValid(ItemStack is) {
        return false;
    }
    
}
