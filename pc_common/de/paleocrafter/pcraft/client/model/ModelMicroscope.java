package de.paleocrafter.pcraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

/**
 * PaleoCraft
 * 
 * ModelMicroscope
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ModelMicroscope extends ModelBase {
    // fields
    ModelRenderer Base;
    ModelRenderer Pillar;
    ModelRenderer Diagonal;
    ModelRenderer Bar;
    ModelRenderer Bracket;
    ModelRenderer Ocular;

    public ModelMicroscope() {
        textureWidth = 64;
        textureHeight = 32;

        Base = new ModelRenderer(this, 0, 0);
        Base.addBox(-6F, 0F, -5F, 12, 3, 10);
        Base.setRotationPoint(0F, 21F, 0F);
        Base.setTextureSize(64, 32);
        Base.mirror = true;
        setRotation(Base, 0F, 0F, 0F);
        Pillar = new ModelRenderer(this, 0, 18);
        Pillar.addBox(0F, 0F, -2F, 2, 8, 4);
        Pillar.setRotationPoint(-5F, 13F, 0F);
        Pillar.setTextureSize(64, 32);
        Pillar.mirror = true;
        setRotation(Pillar, 0F, 0F, 0F);
        Diagonal = new ModelRenderer(this, 12, 22);
        Diagonal.addBox(0F, 0F, -1F, 2, 3, 2);
        Diagonal.setRotationPoint(-2.9F, 10.8F, 0F);
        Diagonal.setTextureSize(64, 32);
        Diagonal.mirror = true;
        setRotation(Diagonal, 0F, 0F, 0.7853982F);
        Bar = new ModelRenderer(this, 12, 18);
        Bar.addBox(-1F, 0F, -1F, 6, 2, 2);
        Bar.setRotationPoint(-1.9F, 10.8F, 0F);
        Bar.setTextureSize(64, 32);
        Bar.mirror = true;
        setRotation(Bar, 0F, 0F, 0F);
        Bracket = new ModelRenderer(this, 0, 13);
        Bracket.addBox(-2F, 0F, -2F, 4, 1, 4);
        Bracket.setRotationPoint(2F, 12.8F, 0F);
        Bracket.setTextureSize(64, 32);
        Bracket.mirror = true;
        setRotation(Bracket, 0F, 0F, 0F);
        Ocular = new ModelRenderer(this, 16, 13);
        Ocular.addBox(0F, 0F, -0.5F, 1, 4, 1);
        Ocular.setRotationPoint(3F, 8F, 0F);
        Ocular.setTextureSize(64, 32);
        Ocular.mirror = true;
        setRotation(Ocular, 0F, 0F, 0.3717861F);
    }

    public void renderAll() {
        ;
        Base.render(0.0625F);
        Pillar.render(0.0625F);
        Diagonal.render(0.0625F);
        Bar.render(0.0625F);
        Bracket.render(0.0625F);
        Ocular.render(0.0625F);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

}
