package de.paleocrafter.pcraft.client.renderer.tileentity;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.client.FMLClientHandler;
import de.paleocrafter.pcraft.client.model.ModelDinoEgg;
import de.paleocrafter.pcraft.lib.Textures;
import de.paleocrafter.pcraft.tileentity.TileDinoEgg;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDinoEggRenderer extends TileEntitySpecialRenderer {

    private ModelDinoEgg modelEgg;

    public TileEntityDinoEggRenderer() {
        modelEgg = new ModelDinoEgg();
    }

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z,
            float tick) {
        if (te instanceof TileDinoEgg) {
            TileDinoEgg teDinoEgg = (TileDinoEgg) te;
            renderDinoEgg(teDinoEgg, x, y, z);
        }
    }

    private void renderDinoEgg(TileDinoEgg te, double x, double y, double z) {
        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslatef((float) x, (float) y + 2.0F, (float) z + 1.0F);
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        GL11.glColor4f(0.9F, 1.0F, 1.0F, 1.0F);

        GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);

        FMLClientHandler.instance().getClient().renderEngine
                .bindTexture(Textures.MODEL_EGG);
        modelEgg.renderAll();

        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

}
