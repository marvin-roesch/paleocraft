package de.paleocrafter.pcraft.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.paleocrafter.pcraft.PaleoCraft;
import de.paleocrafter.pcraft.lib.Reference;
import de.paleocrafter.pcraft.lib.Strings;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

/**
 * PaleoCraft
 * 
 * ItemCrafting
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemCrafting extends Item {

    private static String[] subNames = { Strings.LASER_NAME };
    private static Icon[] subIcons;

    public ItemCrafting(int id) {
        super(id);
        this.setUnlocalizedName(Strings.CRAFTING_NAME);
        this.setCreativeTab(PaleoCraft.tabsPC);
        this.setHasSubtypes(true);
        subIcons = new Icon[1];
    }

    @Override
    public String getUnlocalizedName(ItemStack is) {
        return "item." + Strings.CRAFTING_NAME + "."
                + subNames[is.getItemDamage()];
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(int unk, CreativeTabs tab, List list) {
        for (int i = 0; i < 1; i++) {
            list.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        for (int i = 0; i < 1; i++) {
            subIcons[i] = iconRegister.registerIcon(Reference.MOD_ID
                    .toLowerCase() + ":" + subNames[i]);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int dmg) {
        return subIcons[dmg];
    }

}
