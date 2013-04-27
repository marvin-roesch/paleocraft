package de.paleocrafter.pcraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.paleocrafter.pcraft.PaleoCraft;
import de.paleocrafter.pcraft.lib.Reference;
import de.paleocrafter.pcraft.lib.Strings;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

/**
 * PaleoCraft
 * 
 * AmmoniteItem
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemAmmonite extends Item {

    public ItemAmmonite(int id) {
        super(id);
        this.setCreativeTab(PaleoCraft.tabsPC);
        this.setMaxStackSize(64);
        this.setNoRepair();
        this.setUnlocalizedName(Strings.AMMONITE_ITEM_NAME);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase()
                + ":ammoniteItem");
    }

}
