package de.paleocrafter.pcraft.item;

import de.paleocrafter.pcraft.PaleoCraft;
import de.paleocrafter.pcraft.lib.Strings;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;

/**
 * PaleoCraft
 * 
 * ItemArmorPaleo
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemArmorPaleo extends ItemArmor {
    public static String[] subNames = { Strings.ARMOR_HELMET_NAME,
            Strings.ARMOR_CHEST_NAME, Strings.ARMOR_LEGGINGS_NAME,
            Strings.ARMOR_BOOTS_NAME };
    public static EnumArmorMaterial material = EnumHelper.addArmorMaterial(
            Strings.ARMOR_NAME, 500, new int[] { 10, 20, 30, 40 }, 1);

    public ItemArmorPaleo(int id, int renderId, int type) {
        super(id, material, renderId, type);
        this.setCreativeTab(PaleoCraft.tabsPC);
        this.setUnlocalizedName(getName(type));
    }

    @Override
    public String getUnlocalizedName(ItemStack is) {
        return "item." + Strings.ARMOR_NAME + "." + subNames[armorType];
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot,
            int layer) {
        switch (slot) {
            case 0:
            case 1:
                return "/mods/pcraft/textures/armor/jones1.png";
            default:
                return "/mods/pcraft/textures/armor/jones2.png";
        }
    }

    public static String getName(int id) {
        return "item." + Strings.ARMOR_NAME + "." + subNames[id];
    }
}
