package de.paleocrafter.pcraft.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import de.paleocrafter.pcraft.lib.Reference;

/**
 * PaleoCraft
 * 
 * BlockPC
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockPC extends BlockContainer {

    public BlockPC(int id, Material mat) {
        super(id, mat);
        this.setHardness(2);
    }

    @Override
    public void registerIcons(IconRegister reg) {
        blockIcon = reg.registerIcon(Reference.MOD_ID.toLowerCase() + ":"
                + this.getUnlocalizedName2());
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return null;
    }

}
