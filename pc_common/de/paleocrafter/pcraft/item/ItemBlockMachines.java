package de.paleocrafter.pcraft.item;

import de.paleocrafter.pcraft.lib.Strings;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * PaleoCraft
 * 
 * ItemBlockMachines
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemBlockMachines extends ItemBlock {
    private final static String[] subNames = { Strings.ANALYZER_NAME };

    public ItemBlockMachines(int id) {
        super(id);
        this.setUnlocalizedName(Strings.MACHINES_NAME);
    }

    @Override
    public String getUnlocalizedName(ItemStack is) {
        return "block." + Strings.MACHINES_NAME + "." + subNames[is.getItemDamage()];
    }

    @Override
    public int getMetadata(int damageValue) {
        return damageValue;
    }
}
