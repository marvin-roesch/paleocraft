package de.paleocrafter.pcraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.paleocrafter.pcraft.PaleoCraft;
import de.paleocrafter.pcraft.lib.RenderIds;
import de.paleocrafter.pcraft.lib.Strings;
import de.paleocrafter.pcraft.tileentity.TileDinoEgg;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
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

    @SideOnly(Side.CLIENT)
    public int getBlockColor() {
        return 0xFF0000;
    }

    @SideOnly(Side.CLIENT)
    /**
     * Returns the color this block should be rendered. Used by leaves.
     */
    public int getRenderColor(int par1) {
        return 0xFF0000;
    }

    @SideOnly(Side.CLIENT)
    /**
     * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
     * when first determining what to render.
     */
    public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2,
            int par3, int par4) {
        return 0xFF0000;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    public TileEntity createNewTileEntity(World world) {
        return new TileDinoEgg();
    }

    @Override
    public int getRenderType() {
        return RenderIds.dinoEggRenderId;
    }
}
