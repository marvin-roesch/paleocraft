package de.paleocrafter.pcraft.item;

import cpw.mods.fml.common.registry.GameRegistry;
import de.paleocrafter.pcraft.lib.ItemIds;
import de.paleocrafter.pcraft.lib.Strings;

/**
 * PaleoCraft
 *
 * ModItems
 *
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ModItems {
    /* Mod item instances */
    public static ItemFossil genItem;
    
    public static void init() {
        genItem = new ItemFossil(ItemIds.GENERAL);
        
        GameRegistry.registerItem(genItem, Strings.GENERAL_ITEM_NAME);
    }
}
