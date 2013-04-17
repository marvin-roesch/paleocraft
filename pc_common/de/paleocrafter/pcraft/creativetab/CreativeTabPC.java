package de.paleocrafter.pcraft.creativetab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;

/**
 * @author PaleoCrafter
 * 
 */
public class CreativeTabPC extends CreativeTabs {
    public CreativeTabPC(int par1, String par2Str) {

        super(par1, par2Str);
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * the itemID for the item to be displayed on the tab
     */
    public int getTabIconItemIndex() {

        return 1;
    }
}
