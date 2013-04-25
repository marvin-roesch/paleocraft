package de.paleocrafter.pcraft.client.renderer.tileentity;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDinoEggRenderer extends TileEntitySpecialRenderer {

    @Override
    public void renderTileEntityAt(TileEntity tileentity, double x, double y,
            double z, float f) {
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glTranslated(x, y, z);
        
        
        
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }

}
