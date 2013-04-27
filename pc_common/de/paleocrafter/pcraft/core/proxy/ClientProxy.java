package de.paleocrafter.pcraft.core.proxy;

import net.minecraftforge.client.MinecraftForgeClient;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import de.paleocrafter.pcraft.client.renderer.item.ItemMachineRenderer;
import de.paleocrafter.pcraft.client.renderer.tileentity.TileEntityDinoEggRenderer;
import de.paleocrafter.pcraft.client.renderer.tileentity.TileEntityMachineRenderer;
import de.paleocrafter.pcraft.lib.BlockIds;
import de.paleocrafter.pcraft.lib.RenderIds;
import de.paleocrafter.pcraft.tileentity.TileAnalyzer;
import de.paleocrafter.pcraft.tileentity.TileDinoEgg;

public class ClientProxy extends CommonProxy {
    @Override
    public void initRenderingAndTextures() {
        RenderIds.dinoEggRenderId = RenderingRegistry
                .getNextAvailableRenderId();
        RenderIds.machineRenderId = RenderingRegistry
                .getNextAvailableRenderId();

        ItemMachineRenderer render = new ItemMachineRenderer();

        MinecraftForgeClient.registerItemRenderer(BlockIds.MACHINES, render);
    }

    @Override
    public void registerTileEntities() {
        super.registerTileEntities();

        TileEntityMachineRenderer machineRender = new TileEntityMachineRenderer();

        ClientRegistry.bindTileEntitySpecialRenderer(TileAnalyzer.class,
                machineRender);
        ClientRegistry.bindTileEntitySpecialRenderer(TileDinoEgg.class,
                new TileEntityDinoEggRenderer());
    }
}
