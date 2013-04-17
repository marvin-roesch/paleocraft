package de.paleocrafter.pcraft;

import net.minecraft.creativetab.CreativeTabs;
import de.paleocrafter.pcraft.core.handlers.LocalizationHandler;
import de.paleocrafter.pcraft.core.proxy.CommonProxy;
import de.paleocrafter.pcraft.creativetab.CreativeTabPC;
import de.paleocrafter.pcraft.lib.Reference;
import de.paleocrafter.pcraft.network.PacketHandler;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

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

    @Init
    public void load(FMLInitializationEvent event) {
        LocalizationHandler.loadLanguages();
    }
}
