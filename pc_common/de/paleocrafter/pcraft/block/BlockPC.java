package de.paleocrafter.pcraft.block;

import de.paleocrafter.pcraft.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

/**
 * PaleoCraft
 * 
 * BlockPC
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockPC extends Block {

    public BlockPC(int id, Material mat) {
        super(id, mat);
    }

    @Override
    public void registerIcons(IconRegister reg) {
        blockIcon = reg.registerIcon(Reference.MOD_ID.toLowerCase() + ":"
                + this.getUnlocalizedName2());
    }

}
