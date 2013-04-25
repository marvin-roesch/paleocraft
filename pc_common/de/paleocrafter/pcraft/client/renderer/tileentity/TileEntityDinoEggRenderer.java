package de.paleocrafter.pcraft.client.renderer.tileentity;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.model.AdvancedModelLoader;

public class TileEntityDinoEggRenderer extends TileEntitySpecialRenderer {

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z,
            float f) {
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glTranslated(x + 1, y, z);
        GL11.glRotatef(180F, 0F, 1F, 0F);
        GL11.glRotatef(-90F, 1F, 0F, 0F);

        FMLClientHandler.instance().getClient().renderEngine
                .bindTexture("/mods/ee3/textures/models/aludel.png");
        AdvancedModelLoader.loadModel("/mods/pcraft/models/aludel.obj")
                .renderPart("base");

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }

}
