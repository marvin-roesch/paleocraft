package de.paleocrafter.pcraft.block;

import java.util.Random;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.paleocrafter.pcraft.PaleoCraft;
import de.paleocrafter.pcraft.lib.Reference;
import de.paleocrafter.pcraft.lib.Strings;

/**
 * PaleoCraft
 * 
 * BlockFossile
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockFossile extends BlockOrePC {

    @SideOnly(Side.CLIENT)
    private Icon sides, front;

    public BlockFossile(int id) {
        super(id);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setStepSound(soundStoneFootstep);
        this.setCreativeTab(PaleoCraft.tabsPC);
        this.setUnlocalizedName(Strings.FOSSILE_NAME);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this.front = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase()
                + ":fossileFront");
        this.sides = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase()
                + ":fossileSides");
    }
    
    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);
        this.setDefaultDirection(world, x, y, z);
    }

    private void setDefaultDirection(World world, int x, int y, int z) {
        if(!world.isRemote) {
            Random rand = new Random();
            int frontSide = rand.nextInt(5);
            world.setBlockMetadataWithNotify(x, y, z, frontSide, 2);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int i, int j) {
        if(j == 0 && i == 3) {
            return front;
        }
        if(i == j) {
            return front;
        }
        return sides;
    }
}
