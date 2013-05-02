package de.paleocrafter.pcraft.item;

import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

    public static ItemArmorPaleo armorHelmet;
    public static ItemArmorPaleo armorChest;
    public static ItemArmorPaleo armorLeggings;
    public static ItemArmorPaleo armorBoots;

    public static ItemCrafting craftingItem;

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
        armorHelmet = new ItemArmorPaleo(ItemIds.ARMOR, 3, 0);
        armorChest = new ItemArmorPaleo(ItemIds.ARMOR + 1, 3, 1);
        armorLeggings = new ItemArmorPaleo(ItemIds.ARMOR + 2, 3, 2);
        armorBoots = new ItemArmorPaleo(ItemIds.ARMOR + 3, 3, 3);
        craftingItem = new ItemCrafting(ItemIds.CRAFTING);

        GameRegistry.registerItem(genItem, Strings.GENERAL_ITEM_NAME);
        GameRegistry.registerItem(toolStone, ItemToolPC.getName(3));
        GameRegistry.registerItem(toolGold, ItemToolPC.getName(1));
        GameRegistry.registerItem(toolIron, ItemToolPC.getName(2));
        GameRegistry.registerItem(toolDiamond, ItemToolPC.getName(0));

        GameRegistry
                .registerItem(armorHelmet, armorHelmet.getUnlocalizedName());
        GameRegistry.registerItem(armorChest, armorChest.getUnlocalizedName());
        GameRegistry.registerItem(armorLeggings,
                armorLeggings.getUnlocalizedName());
        GameRegistry.registerItem(armorBoots, armorBoots.getUnlocalizedName());

        GameRegistry.registerItem(craftingItem, Strings.CRAFTING_NAME);

        registerRecipes();
    }

    private static void registerRecipes() {
        // Hammer & Chisel
        GameRegistry.addShapedRecipe(new ItemStack(toolStone, 1),
                new Object[] { "s i", "i s", Character.valueOf('i'),
                        Item.stick, Character.valueOf('s'), Block.stone });
        GameRegistry.addShapedRecipe(new ItemStack(toolIron, 1),
                new Object[] { "s i", "i s", Character.valueOf('i'),
                        Item.stick, Character.valueOf('s'), Item.ingotIron });
        GameRegistry.addShapedRecipe(new ItemStack(toolGold, 1),
                new Object[] { "s i", "i s", Character.valueOf('i'),
                        Item.stick, Character.valueOf('s'), Item.ingotGold });
        GameRegistry.addShapedRecipe(new ItemStack(toolDiamond, 1),
                new Object[] { "s i", "i s", Character.valueOf('i'),
                        Item.stick, Character.valueOf('s'), Item.diamond });

        // Crafting ingredients
        GameRegistry.addShapedRecipe(new ItemStack(craftingItem, 1, 0),
                new Object[] { "iri", "iai", " d ", Character.valueOf('i'),
                        Item.ingotIron, Character.valueOf('r'), Item.redstone,
                        Character.valueOf('a'), new ItemStack(genItem, 1, 1),
                        Character.valueOf('d'), Item.diamond }); // Laser
    }
}
