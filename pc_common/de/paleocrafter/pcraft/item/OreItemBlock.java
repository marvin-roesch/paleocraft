package de.paleocrafter.pcraft.item;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.paleocrafter.pcraft.block.BlockOrePC;
import de.paleocrafter.pcraft.block.ModBlocks;
import de.paleocrafter.pcraft.core.helpers.LocalizationHelper;
import de.paleocrafter.pcraft.lib.Reference;
import de.paleocrafter.pcraft.lib.Strings;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

/**
 * PaleoCraft
 *
 * OreItemBlock
 *
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class OreItemBlock extends ItemBlock {
    
    private final static String[] subNames = {
        Strings.FOSSIL_NAME, Strings.AMMONITE_BLOCK_NAME
    };
    
    public OreItemBlock(int id) {
        super(id);
        this.setUnlocalizedName(Strings.ORE_NAME);
    }
    
    @Override
    public String getUnlocalizedName(ItemStack is) {
        return "block." + Strings.ORE_NAME + "." + subNames[is.getItemDamage()];
    }
    
    @Override
    public int getMetadata (int damageValue) {
        return damageValue;
    }
}
