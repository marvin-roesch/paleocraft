package de.paleocrafter.pcraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.paleocrafter.pcraft.PaleoCraft;
import de.paleocrafter.pcraft.block.BlockOrePC;
import de.paleocrafter.pcraft.block.ModBlocks;
import de.paleocrafter.pcraft.lib.Reference;
import de.paleocrafter.pcraft.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

/**
 * PaleoCraft
 * 
 * ItemTool
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemToolPC extends ItemTool {
    private static String[] subNames = { Strings.DIAMOND_NAME,
            Strings.GOLD_NAME, Strings.IRON_NAME, Strings.STONE_NAME };
    private String name;
    private String textureFile;

    public ItemToolPC(int id, EnumToolMaterial mat, String name,
            String textureFile) {
        super(id, 2, mat, new Block[] { ModBlocks.pcOre });
        this.name = name;
        this.setCreativeTab(PaleoCraft.tabsPC);
        this.textureFile = textureFile;
    }

    @Override
    public boolean canHarvestBlock(Block block) {
        if (block instanceof BlockOrePC) {
            return true;
        }
        return false;
    }

    @Override
    public float getStrVsBlock(ItemStack stack, Block block) {
        if (block instanceof BlockOrePC) {
            return 12;
        }
        return 1;
    }

    @Override
    public boolean isItemTool(ItemStack stack) {
        return true;
    }
    
    @Override
    public int getMaxDamage() {
        switch (EnumToolMaterial.valueOf(this.getToolMaterialName())) {
            case STONE:
                return 10;
            case GOLD:
                return 5;
            case IRON:
                return 25;
            case EMERALD:
                return 50;
            default:
                return 0;
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack is) {
        return name;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase()
                + ":" + textureFile);
    }

    public static String getName(int id) {
        return "item." + Strings.TOOL_NAME + "." + subNames[id];
    }

}
