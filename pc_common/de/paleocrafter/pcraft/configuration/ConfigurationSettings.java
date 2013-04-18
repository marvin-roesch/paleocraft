package de.paleocrafter.pcraft.configuration;

/**
 * PaleoCraft
 *
 * ConfigurationSettings
 *
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ConfigurationSettings {

    /*
     * Audio config settings
     */
    public static String ENABLE_SOUNDS;
    public static final String ENABLE_SOUNDS_CONFIGNAME = "sounds.enabled";
    public static final String ENABLE_SOUNDS_DEFAULT = "all";

    /*
     * Graphic config settings
     */
    // Whether or not PCraft particle fx are enabled
    public static boolean ENABLE_PARTICLE_FX;
    public static final String ENABLE_PARTICLE_FX_CONFIGNAME = "particle_fx.enabled";
    public static final boolean ENABLE_PARTICLE_FX_DEFAULT = true;

    /*
     * Block related config settings
     */
    
    /*
     * Item related config settings
     */

    /*
     * Keybinding related config settings
     */
    // Extra key
    //public static final String KEYBINDING_EXTRA = "key.extra";
    //public static final int KEYBINDING_EXTRA_DEFAULT = 46;
}
