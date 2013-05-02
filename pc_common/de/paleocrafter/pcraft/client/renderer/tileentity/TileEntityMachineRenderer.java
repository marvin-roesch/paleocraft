package de.paleocrafter.pcraft.client.renderer.tileentity;

import java.util.Random;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.client.FMLClientHandler;

import de.paleocrafter.pcraft.client.model.ModelAnalyzer;
import de.paleocrafter.pcraft.client.model.ModelMicroscope;
import de.paleocrafter.pcraft.client.model.ModelFossil;
import de.paleocrafter.pcraft.lib.Textures;
import de.paleocrafter.pcraft.tileentity.TileAnalyzer;
import de.paleocrafter.pcraft.tileentity.TileMicroscope;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

/**
 * PaleoCraft
 * 
 * TileEntityAnalyzerRenderer
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TileEntityMachineRenderer extends TileEntitySpecialRenderer {

    private float delta;

    private ModelAnalyzer modelAnalyzer;
    private ModelMicroscope modelMicroscope;

    public TileEntityMachineRenderer() {
        modelAnalyzer = new ModelAnalyzer();
        modelMicroscope = new ModelMicroscope();
    }

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z,
            float tick) {
        delta = tick;
        if (te instanceof TileAnalyzer) {
            TileAnalyzer teAnalyzer = (TileAnalyzer) te;
            renderAnalyzer(teAnalyzer, x, y, z);
        }
        if (te instanceof TileMicroscope) {
            TileMicroscope teMicroscope = (TileMicroscope) te;
            renderMicroscope(teMicroscope, x, y, z);
        }
    }

    private void renderAnalyzer(TileAnalyzer te, double x, double y, double z) {
        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslatef((float) x, (float) y + 2.0F, (float) z + 1.0F);
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);

        ForgeDirection direction = te.getOrientation();
        short angle = 0;

        if (direction != null) {
            if (direction == ForgeDirection.NORTH) {
                angle = 0;
            } else if (direction == ForgeDirection.SOUTH) {
                angle = 180;
            } else if (direction == ForgeDirection.WEST) {
                angle = -90;
            } else if (direction == ForgeDirection.EAST) {
                angle = 90;
            }
        }

        GL11.glRotatef(angle, 0.0F, 1.0F, 0.0F);

        FMLClientHandler.instance().getClient().renderEngine
                .bindTexture(Textures.MODEL_ANALYZER);
        modelAnalyzer.renderAll((int) Math.ceil(te.getProgress() / 10));
        if (te.getState() == 1) {
            FMLClientHandler.instance().getClient().renderEngine
                    .bindTexture(Textures.MODEL_LASER
                            + ((int) Math.ceil(te.getProgress() / 10)) + ".png");
            ModelRenderer laser = new ModelRenderer(modelAnalyzer, 0, 0);
            laser.addBox(-0.5F, 12.5F, -0.5F, 1, 10, 1);
            laser.setRotationPoint(0F, 0F, 0F);
            if (delta >= 0.9F) {
                Random rand = new Random();
                float val = 1F;
                float rotX = 0;
                float rotZ = 0;
                while (val > 0.07F) {
                    val = rand.nextFloat();
                }
                rotX = val;
                val = 1F;
                while (val > 0.09F) {
                    val = rand.nextFloat();
                }
                rotZ = val;
                switch (rand.nextInt(4)) {
                    case 0:
                        rotZ *= -1;
                        break;
                    case 1:
                        rotX *= -1;
                        break;
                    case 3:
                    case 4:
                        rotX *= -1;
                        rotZ *= -1;
                        break;
                }
                te.setLaserRotX(rotX);
                te.setLaserRotZ(rotZ);
            }
            setRotation(laser, te.getLaserRotX(), 0F, te.getLaserRotZ());
            laser.setTextureSize(64, 32);
            laser.mirror = true;
            if (te.getFuelLevel() >= 2) {
                laser.render(0.0625F);
            }
            FMLClientHandler.instance().getClient().renderEngine
                    .bindTexture(Textures.MODEL_FOSSIL);
            GL11.glTranslatef(-0.475F, 1.42F, 0.165F);
            GL11.glScalef(0.08F, 0.08F, 0.08F);
            GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
            new ModelFossil().render();
        }

        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    private void renderMicroscope(TileMicroscope te, double x, double y,
            double z) {
        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslatef((float) x, (float) y + 2.0F, (float) z + 1.0F);
        GL11.glScalef(0.5F, -0.5F, -0.5F);
        GL11.glTranslatef(1F, 1F, 1F);

        ForgeDirection direction = te.getOrientation();
        short angle = 0;

        if (direction != null) {
            if (direction == ForgeDirection.NORTH) {
                angle = -90;
            } else if (direction == ForgeDirection.SOUTH) {
                angle = 90;
            } else if (direction == ForgeDirection.WEST) {
                angle = 180;
            } else if (direction == ForgeDirection.EAST) {
                angle = 0;
            }
        }

        GL11.glRotatef(angle, 0.0F, 1.0F, 0.0F);

        FMLClientHandler.instance().getClient().renderEngine
                .bindTexture(Textures.MODEL_MICROSCOPE);
        modelMicroscope.renderAll();

        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

}
