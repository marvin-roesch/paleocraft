package de.paleocrafter.pcraft.core.proxy;

import java.util.HashMap;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import de.paleocrafter.pcraft.client.gui.inventory.GuiAnalyzer;
import de.paleocrafter.pcraft.inventory.ContainerAnalyzer;
import de.paleocrafter.pcraft.lib.GuiIds;
import de.paleocrafter.pcraft.tileentity.TileAnalyzer;
import de.paleocrafter.pcraft.tileentity.TileDinoEgg;
import de.paleocrafter.pcraft.tileentity.TileFossil;

public class CommonProxy implements IGuiHandler {

    public void registerKeyBindingHandler() {

    }

    public void registerRenderTickHandler() {

    }

    public void registerDrawBlockHighlightHandler() {

    }

    public void setKeyBinding(String name, int value) {

    }

    public void registerSoundHandler() {

    }

    public void initRenderingAndTextures() {

    }

    public void registerTileEntities() {
        GameRegistry.registerTileEntity(TileDinoEgg.class, "tileDinoEgg");
        GameRegistry.registerTileEntity(TileAnalyzer.class, "tileAnalyzer");
        GameRegistry.registerTileEntity(TileFossil.class, "tileFossil");
    }

    public void sendRequestEventPacket(byte eventType, int originX,
            int originY, int originZ, byte sideHit, byte rangeX, byte rangeY,
            byte rangeZ, String data) {

    }

    public void handleTileEntityPacket(int x, int y, int z,
            ForgeDirection orientation, byte state, String customName,
            HashMap<String, Integer> addIntegers) {

    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z) {
        if (ID == GuiIds.ANALYZER) {
            TileAnalyzer tileAnalyzer = (TileAnalyzer) world
                    .getBlockTileEntity(x, y, z);
            return new ContainerAnalyzer(player.inventory, tileAnalyzer);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z) {
        if (ID == GuiIds.ANALYZER) {
            TileAnalyzer tileAnalyzer = (TileAnalyzer) world
                    .getBlockTileEntity(x, y, z);
            return new GuiAnalyzer(player.inventory, tileAnalyzer);
        }
        return null;
    }

}
