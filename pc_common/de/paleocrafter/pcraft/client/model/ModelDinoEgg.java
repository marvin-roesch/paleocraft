package de.paleocrafter.pcraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

/**
 * PaleoCraft
 * 
 * ModelDinoEgg
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ModelDinoEgg extends ModelBase {
    // fields
    ModelRenderer Layer0;
    ModelRenderer Layer1;
    ModelRenderer Layer2;
    ModelRenderer Layer3;
    ModelRenderer Layer4;
    ModelRenderer Layer5;
    ModelRenderer Layer6;
    ModelRenderer Layer7;

    public ModelDinoEgg() {
        textureWidth = 32;
        textureHeight = 32;

        Layer0 = new ModelRenderer(this, 0, 0);
        Layer0.addBox(-4F, 0F, -4F, 8, 1, 8);
        Layer0.setRotationPoint(0F, 23F, 0F);
        Layer0.setTextureSize(64, 64);
        Layer0.mirror = true;
        setRotation(Layer0, 0F, 0F, 0F);
        Layer1 = new ModelRenderer(this, 0, 0);
        Layer1.addBox(-6F, 0F, -6F, 12, 2, 12);
        Layer1.setRotationPoint(0F, 21F, 0F);
        Layer1.setTextureSize(64, 64);
        Layer1.mirror = true;
        setRotation(Layer1, 0F, 0F, 0F);
        Layer2 = new ModelRenderer(this, 0, 15);
        Layer2.addBox(-7F, 0F, -7F, 14, 5, 14);
        Layer2.setRotationPoint(0F, 16F, 0F);
        Layer2.setTextureSize(64, 64);
        Layer2.mirror = true;
        setRotation(Layer2, 0F, 0F, 0F);
        Layer3 = new ModelRenderer(this, 0, 33);
        Layer3.addBox(-6F, 0F, -6F, 12, 3, 12);
        Layer3.setRotationPoint(0F, 13F, 0F);
        Layer3.setTextureSize(64, 64);
        Layer3.mirror = true;
        setRotation(Layer3, 0F, 0F, 0F);
        Layer4 = new ModelRenderer(this, 0, 48);
        Layer4.addBox(-5F, 0F, -5F, 10, 2, 10);
        Layer4.setRotationPoint(0F, 11F, 0F);
        Layer4.setTextureSize(64, 64);
        Layer4.mirror = true;
        setRotation(Layer4, 0F, 0F, 0F);
        Layer5 = new ModelRenderer(this, 0, 35);
        Layer5.addBox(-4F, 0F, -4F, 8, 1, 8);
        Layer5.setRotationPoint(0F, 10F, 0F);
        Layer5.setTextureSize(64, 64);
        Layer5.mirror = true;
        setRotation(Layer5, 0F, 0F, 0F);
        Layer6 = new ModelRenderer(this, 0, 0);
        Layer6.addBox(-3F, 0F, -3F, 6, 1, 6);
        Layer6.setRotationPoint(0F, 9F, 0F);
        Layer6.setTextureSize(64, 64);
        Layer6.mirror = true;
        setRotation(Layer6, 0F, 0F, 0F);
        Layer7 = new ModelRenderer(this, 0, 0);
        Layer7.addBox(-2F, 0F, -2F, 4, 1, 4);
        Layer7.setRotationPoint(0F, 8F, 0F);
        Layer7.setTextureSize(64, 64);
        Layer7.mirror = true;
        setRotation(Layer7, 0F, 0F, 0F);
    }

    public void renderAll() {
        Layer0.render(0.0625F);
        Layer1.render(0.0625F);
        Layer2.render(0.0625F);
        Layer3.render(0.0625F);
        Layer4.render(0.0625F);
        Layer5.render(0.0625F);
        Layer6.render(0.0625F);
        Layer7.render(0.0625F);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
