package de.paleocrafter.pcraft.item;

import de.paleocrafter.pcraft.lib.Strings;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

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
