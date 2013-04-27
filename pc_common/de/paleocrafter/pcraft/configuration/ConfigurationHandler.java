package de.paleocrafter.pcraft.configuration;

//import static net.minecraftforge.common.Configuration.CATEGORY_GENERAL;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;

import cpw.mods.fml.common.FMLLog;
import de.paleocrafter.pcraft.lib.BlockIds;
import de.paleocrafter.pcraft.lib.ItemIds;
import de.paleocrafter.pcraft.lib.Reference;
import de.paleocrafter.pcraft.lib.Strings;

/**
 * PaleoCraft
 * 
 * ConfigurationHandler
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ConfigurationHandler {
    public static Configuration configuration;

    public static final String CATEGORY_KEYBIND = "keybindings";
    public static final String CATEGORY_GRAPHICS = "graphics";
    public static final String CATEGORY_AUDIO = "audio";

    public static void init(File configFile) {

        configuration = new Configuration(configFile);

        try {
            configuration.load();

            /* Graphic configs */
            ConfigurationSettings.ENABLE_PARTICLE_FX = configuration.get(
                    CATEGORY_GRAPHICS,
                    ConfigurationSettings.ENABLE_PARTICLE_FX_CONFIGNAME,
                    ConfigurationSettings.ENABLE_PARTICLE_FX_DEFAULT)
                    .getBoolean(
                            ConfigurationSettings.ENABLE_PARTICLE_FX_DEFAULT);

            /* Audio configs */
            ConfigurationSettings.ENABLE_SOUNDS = configuration.get(
                    CATEGORY_AUDIO,
                    ConfigurationSettings.ENABLE_SOUNDS_CONFIGNAME,
                    ConfigurationSettings.ENABLE_SOUNDS_DEFAULT).getString();

            /* Block configs */
            BlockIds.ORE = configuration.getBlock("ore",
                    BlockIds.ORE_DEFAULT).getInt(BlockIds.ORE_DEFAULT);
            BlockIds.EGG = configuration.getBlock("egg",
                    BlockIds.EGG_DEFAULT).getInt(BlockIds.EGG_DEFAULT);
            BlockIds.MACHINES = configuration.getBlock("machines",
                    BlockIds.MACHINES_DEFAULT).getInt(BlockIds.MACHINES_DEFAULT);
            /* Block property configs */

            /* Item configs */
            ItemIds.AMMONITE = configuration.getItem(Strings.AMMONITE_ITEM_NAME,
                    ItemIds.AMMONITE_DEFAULT).getInt(
                    ItemIds.AMMONITE_DEFAULT);
        } catch (Exception e) {
            FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME
                    + " has had a problem loading its configuration");
        } finally {
            configuration.save();
        }
    }

    public static void set(String categoryName, String propertyName,
            String newValue) {

        configuration.load();
        if (configuration.getCategoryNames().contains(categoryName)) {
            if (configuration.getCategory(categoryName).containsKey(
                    propertyName)) {
                configuration.getCategory(categoryName).get(propertyName)
                        .set(newValue);
            }
        }
        configuration.save();
    }
}
