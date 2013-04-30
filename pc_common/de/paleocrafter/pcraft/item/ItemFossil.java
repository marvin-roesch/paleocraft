package de.paleocrafter.pcraft.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.paleocrafter.pcraft.PaleoCraft;
import de.paleocrafter.pcraft.lib.Reference;
import de.paleocrafter.pcraft.lib.Strings;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;

/**
 * PaleoCraft
 * 
 * AmmoniteItem
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemFossil extends Item {
    private String[] subNames = { Strings.FOSSIL_NAME,
            Strings.AMMONITE_ITEM_NAME };

    private Icon fossil, ammonite;

    public ItemFossil(int id) {
        super(id);
        this.setCreativeTab(PaleoCraft.tabsPC);
        this.setMaxStackSize(64);
        this.setNoRepair();
        this.setUnlocalizedName(Strings.GENERAL_ITEM_NAME);
        this.setHasSubtypes(true);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(int par1, CreativeTabs tab, List list) {
        list.add(new ItemStack(this, 1, 0));
        list.add(new ItemStack(this, 1, 1));
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "item." + Strings.GENERAL_ITEM_NAME + "."
                + subNames[stack.getItemDamage()];
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack is, EntityPlayer player, List list,
            boolean advanced) {
        if (is.getItemDamage() == 0) {
            if (is.stackTagCompound == null || !is.stackTagCompound.hasKey("analyzed")
                    || !is.stackTagCompound.getBoolean("analyzed")) {
                list.add("Tip: " + EnumChatFormatting.ITALIC
                        + "Put this fossil into the Analyzer!");
            } else {
                list.add("Analyzed");
            }
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister iconRegister) {
        ammonite = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase()
                + ":ammoniteItem");
        fossil = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase()
                + ":fossilItem");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int par1) {
        switch (par1) {
            case 0:
                return fossil;
            case 1:
                return ammonite;
        }
        return null;
    }

}
