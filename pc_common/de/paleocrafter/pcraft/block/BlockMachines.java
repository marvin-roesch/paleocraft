package de.paleocrafter.pcraft.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.paleocrafter.pcraft.PaleoCraft;
import de.paleocrafter.pcraft.lib.GuiIds;
import de.paleocrafter.pcraft.lib.RenderIds;
import de.paleocrafter.pcraft.lib.Strings;
import de.paleocrafter.pcraft.tileentity.TileAnalyzer;
import de.paleocrafter.pcraft.tileentity.TilePC;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

/**
 * PaleoCraft
 * 
 * BlockAnalyzer
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockMachines extends BlockPC {

    public BlockMachines(int id) {
        super(id, Material.iron);
        this.setCreativeTab(PaleoCraft.tabsPC);
        this.setUnlocalizedName(Strings.MACHINES_NAME);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z,
            EntityPlayer player, int par6, float par7, float par8, float par9) {
        if (player.isSneaking())
            return true;
        else {
            if (!world.isRemote) {
                switch (world.getBlockMetadata(x, y, z)) {
                    case 0:
                        TileAnalyzer te = (TileAnalyzer) world
                                .getBlockTileEntity(x, y, z);
                        if (te != null) {
                            player.openGui(PaleoCraft.instance,
                                    GuiIds.ANALYZER, world, x, y, z);
                        }
                        break;
                }
            }

            return true;
        }
    }

    @Override
    public int getRenderType() {
        return RenderIds.machineRenderId;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int unknown, CreativeTabs tab, List subItems) {
        subItems.add(new ItemStack(this, 1, 0));
    }

    @Override
    public int damageDropped(int metadata) {
        return metadata;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return super.createNewTileEntity(world);
    }

    @Override
    public TileEntity createTileEntity(World world, int meta) {
        switch (meta) {
            case 0:
                return new TileAnalyzer();
        }
        return null;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z,
            EntityLiving entityLiving, ItemStack itemStack) {

        int direction = 0;
        int facing = MathHelper
                .floor_double(entityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;

        if (facing == 0) {
            direction = ForgeDirection.NORTH.ordinal();
        } else if (facing == 1) {
            direction = ForgeDirection.EAST.ordinal();
        } else if (facing == 2) {
            direction = ForgeDirection.SOUTH.ordinal();
        } else if (facing == 3) {
            direction = ForgeDirection.WEST.ordinal();
        }

        if (itemStack.hasDisplayName()) {
            ((TilePC) world.getBlockTileEntity(x, y, z))
                    .setCustomName(itemStack.getDisplayName());
        }

        ((TilePC) world.getBlockTileEntity(x, y, z)).setOrientation(direction);
    }
}
