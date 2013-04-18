package de.paleocrafter.pcraft.block;

import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.paleocrafter.pcraft.PaleoCraft;
import de.paleocrafter.pcraft.lib.Reference;
import de.paleocrafter.pcraft.lib.Strings;

/**
 * PaleoCraft
 * 
 * BlockAmmonite
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockAmmonite extends BlockOrePC {

    public BlockAmmonite(int id) {
        super(id);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setStepSound(soundStoneFootstep);
        this.setCreativeTab(PaleoCraft.tabsPC);
        this.setUnlocalizedName(Strings.AMMONITE_BLOCK_NAME);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase()
                + ":ammoniteFront");
    }
}
