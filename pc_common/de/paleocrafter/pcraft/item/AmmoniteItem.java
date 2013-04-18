package de.paleocrafter.pcraft.item;

import de.paleocrafter.pcraft.PaleoCraft;
import de.paleocrafter.pcraft.lib.Strings;
import net.minecraft.item.Item;

/**
 * PaleoCraft
 *
 * AmmoniteItem
 *
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AmmoniteItem extends Item {

    public AmmoniteItem(int id) {
        super(id);
        this.setCreativeTab(PaleoCraft.tabsPC);
        this.setMaxStackSize(64);
        this.setNoRepair();
        this.setUnlocalizedName(Strings.AMMONITE_ITEM_NAME);
    }

}
