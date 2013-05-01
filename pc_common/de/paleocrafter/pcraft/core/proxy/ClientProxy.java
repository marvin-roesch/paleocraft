package de.paleocrafter.pcraft.core.proxy;

import java.util.HashMap;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.ForgeDirection;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import de.paleocrafter.pcraft.client.renderer.item.ItemDinoEggRenderer;
import de.paleocrafter.pcraft.client.renderer.item.ItemMachineRenderer;
import de.paleocrafter.pcraft.client.renderer.tileentity.TileEntityDinoEggRenderer;
import de.paleocrafter.pcraft.client.renderer.tileentity.TileEntityMachineRenderer;
import de.paleocrafter.pcraft.lib.BlockIds;
import de.paleocrafter.pcraft.lib.RenderIds;
import de.paleocrafter.pcraft.tileentity.TileAnalyzer;
import de.paleocrafter.pcraft.tileentity.TileDinoEgg;
import de.paleocrafter.pcraft.tileentity.TileMicroscope;
import de.paleocrafter.pcraft.tileentity.TilePC;

public class ClientProxy extends CommonProxy {
    @Override
    public void initRenderingAndTextures() {
        RenderIds.dinoEggRenderId = RenderingRegistry
                .getNextAvailableRenderId();
        RenderIds.machineRenderId = RenderingRegistry
                .getNextAvailableRenderId();

        ItemMachineRenderer render = new ItemMachineRenderer();

        MinecraftForgeClient.registerItemRenderer(BlockIds.MACHINES, render);
        MinecraftForgeClient.registerItemRenderer(BlockIds.EGG,
                new ItemDinoEggRenderer());
    }

    @Override
    public void registerTileEntities() {
        super.registerTileEntities();

        TileEntityMachineRenderer machineRender = new TileEntityMachineRenderer();

        ClientRegistry.bindTileEntitySpecialRenderer(TileAnalyzer.class,
                machineRender);
        ClientRegistry.bindTileEntitySpecialRenderer(TileMicroscope.class,
                machineRender);
        ClientRegistry.bindTileEntitySpecialRenderer(TileDinoEgg.class,
                new TileEntityDinoEggRenderer());
    }

    @Override
    public void handleTileEntityPacket(int x, int y, int z,
            ForgeDirection orientation, byte state, String customName,
            HashMap<String, Integer> addIntegers) {

        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld
                .getBlockTileEntity(x, y, z);

        if (tileEntity != null) {
            if (tileEntity instanceof TilePC) {
                ((TilePC) tileEntity).setOrientation(orientation);
                ((TilePC) tileEntity).setState(state);
                ((TilePC) tileEntity).setCustomName(customName);
                ((TilePC) tileEntity).setAddIntegers(addIntegers);
            }
        }
    }
}
