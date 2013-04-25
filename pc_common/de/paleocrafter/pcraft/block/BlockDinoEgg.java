package de.paleocrafter.pcraft.block;

import de.paleocrafter.pcraft.PaleoCraft;
import de.paleocrafter.pcraft.lib.RenderIds;
import de.paleocrafter.pcraft.lib.Strings;
import de.paleocrafter.pcraft.tileentity.TileDinoEgg;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * PaleoCraft
 * 
 * BlockDinoEgg
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockDinoEgg extends BlockPC {

    public BlockDinoEgg(int id) {
        super(id, Material.dragonEgg);
        this.setUnlocalizedName(Strings.EGG_NAME);
        this.setCreativeTab(PaleoCraft.tabsPC);
        this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 1.0F, 0.9375F);
    }
    
    @Override
    public boolean renderAsNormalBlock() {

        return false;
    }

    @Override
    public boolean isOpaqueCube() {

        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileDinoEgg();
    }

    @Override
    public int getRenderType() {
        return RenderIds.dinoEggRenderId;
    }
}
