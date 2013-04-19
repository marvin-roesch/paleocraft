package de.paleocrafter.pcraft;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import de.paleocrafter.pcraft.configuration.ConfigurationHandler;
import de.paleocrafter.pcraft.core.handlers.LocalizationHandler;
import de.paleocrafter.pcraft.core.proxy.CommonProxy;
import de.paleocrafter.pcraft.creativetab.CreativeTabPC;
import de.paleocrafter.pcraft.item.ModItems;
import de.paleocrafter.pcraft.lib.Reference;
import de.paleocrafter.pcraft.network.PacketHandler;
import de.paleocrafter.pcraft.world.OreGenerator;
import de.paleocrafter.pcraft.block.ModBlocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * PaleoCraft
 * 
 * PaleoCraft
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER, dependencies = Reference.DEPENDENCIES, certificateFingerprint = Reference.FINGERPRINT)
@NetworkMod(channels = { Reference.CHANNEL_NAME }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class PaleoCraft {
    @Instance(Reference.MOD_ID)
    public static PaleoCraft instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static CreativeTabs tabsPC = new CreativeTabPC(
            CreativeTabs.getNextID(), Reference.MOD_ID);

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        LocalizationHandler.loadLanguages();
        ConfigurationHandler.init(new File(event.getModConfigurationDirectory()
                .getAbsolutePath()
                + File.separator
                + Reference.CHANNEL_NAME
                + File.separator + Reference.MOD_ID + ".cfg"));
        // Initialize mod blocks
        ModBlocks.init();

        // Initialize mod items
        ModItems.init();
        
        GameRegistry.registerWorldGenerator(new OreGenerator());
    }

    @Init
    public void load(FMLInitializationEvent event) {
        proxy.registerTileEntities();
    }
}
