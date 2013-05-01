package de.paleocrafter.pcraft.item;

import net.minecraft.item.EnumToolMaterial;
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
    public static ItemToolPC toolStone;
    public static ItemToolPC toolGold;
    public static ItemToolPC toolIron;
    public static ItemToolPC toolDiamond;

    public static void init() {
        genItem = new ItemFossil(ItemIds.GENERAL);
        toolStone = new ItemToolPC(ItemIds.TOOL, EnumToolMaterial.STONE,
                ItemToolPC.getName(3), "hcStone");
        toolGold = new ItemToolPC(ItemIds.TOOL + 2, EnumToolMaterial.GOLD,
                ItemToolPC.getName(1), "hcGold");
        toolIron = new ItemToolPC(ItemIds.TOOL + 1, EnumToolMaterial.IRON,
                ItemToolPC.getName(2), "hcIron");
        toolDiamond = new ItemToolPC(ItemIds.TOOL + 3,
                EnumToolMaterial.EMERALD, ItemToolPC.getName(0), "hcDiamond");

        GameRegistry.registerItem(genItem, Strings.GENERAL_ITEM_NAME);
        GameRegistry.registerItem(toolStone, ItemToolPC.getName(3));
        GameRegistry.registerItem(toolGold, ItemToolPC.getName(1));
        GameRegistry.registerItem(toolIron, ItemToolPC.getName(2));
        GameRegistry.registerItem(toolDiamond, ItemToolPC.getName(0));
    }
}
