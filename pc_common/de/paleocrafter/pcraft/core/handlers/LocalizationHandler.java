package de.paleocrafter.pcraft.core.handlers;

import de.paleocrafter.pcraft.core.helpers.LocalizationHelper;
import de.paleocrafter.pcraft.lib.Localizations;

import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * PaleoCraft
 * 
 * LocalizationHandler
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class LocalizationHandler {

    /***
     * Loads in all the localization files from the Localizations library class
     */
    public static void loadLanguages() {

        // For every file specified in the Localization library class, load them into the Language Registry
        for (String localizationFile : Localizations.localeFiles) {
            LanguageRegistry.instance().loadLocalization(localizationFile, LocalizationHelper.getLocaleFromFileName(localizationFile), LocalizationHelper.isXMLLanguageFile(localizationFile));
        }
    }

}
