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
    public static ItemAmmonite ammonite;
    
    public static void init() {
        ammonite = new ItemAmmonite(ItemIds.AMMONITE);
        
        GameRegistry.registerItem(ammonite, Strings.AMMONITE_ITEM_NAME);
    }
}
