package de.paleocrafter.pcraft.core.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import de.paleocrafter.pcraft.client.renderer.tileentity.TileEntityDinoEggRenderer;
import de.paleocrafter.pcraft.lib.RenderIds;
import de.paleocrafter.pcraft.tileentity.TileDinoEgg;

public class ClientProxy extends CommonProxy {
    @Override
    public void initRenderingAndTextures() {
        RenderIds.dinoEggRenderId = RenderingRegistry
                .getNextAvailableRenderId();
    }

    @Override
    public void registerTileEntities() {
        super.registerTileEntities();
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileDinoEgg.class,
                new TileEntityDinoEggRenderer());
    }
}
