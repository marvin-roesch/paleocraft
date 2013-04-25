package de.paleocrafter.pcraft.block;

import cpw.mods.fml.common.registry.GameRegistry;
import de.paleocrafter.pcraft.item.OreItemBlock;
import de.paleocrafter.pcraft.lib.BlockIds;
import de.paleocrafter.pcraft.lib.Strings;
import net.minecraft.block.Block;

/**
 * PaleoCraft
 *
 * ModBlocks
 *
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ModBlocks {
    /* Mod block instances */
    public static Block pcOre;
    public static Block egg;
    
    public static void init() {
        pcOre = new BlockOrePC(BlockIds.ORE);
        egg = new BlockDinoEgg(BlockIds.EGG);
        
        GameRegistry.registerBlock(egg, Strings.EGG_NAME);
        GameRegistry.registerBlock(pcOre, OreItemBlock.class, Strings.ORE_NAME);
    }
}
