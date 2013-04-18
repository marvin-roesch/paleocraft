package de.paleocrafter.pcraft.block;

import cpw.mods.fml.common.registry.GameRegistry;
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
    public static Block fossile;
    public static Block ammonite;
    
    public static void init() {
        fossile = new BlockFossile(BlockIds.FOSSILE);
        ammonite = new BlockAmmonite(BlockIds.AMMONITE);
        
        GameRegistry.registerBlock(fossile, Strings.FOSSILE_NAME);
        GameRegistry.registerBlock(fossile, Strings.AMMONITE_BLOCK_NAME);
    }
}
