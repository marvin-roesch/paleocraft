package de.paleocrafter.pcraft.inventory.slot;

import de.paleocrafter.pcraft.item.ItemFossil;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * PaleoCraft
 *
 * SlotAnalyzerInput
 *
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class SlotAnalyzerInput extends Slot {
    public SlotAnalyzerInput(IInventory inventory, int x, int y, int z) {
        super(inventory, x, y, z);
    }

    @Override
    public boolean isItemValid(ItemStack is) {
        if(is.getItem() instanceof ItemFossil && is.getItemDamage() == 0)
            return true;
        return false;
    }
}
