package de.paleocrafter.pcraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.paleocrafter.pcraft.lib.Reference;
import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IconRegister;

/**
 * PaleoCraft
 * 
 * BlockPC
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockOrePC extends BlockOre {

    public BlockOrePC(int id) {
        super(id);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":"
                + this.getUnlocalizedName2());
    }

}
