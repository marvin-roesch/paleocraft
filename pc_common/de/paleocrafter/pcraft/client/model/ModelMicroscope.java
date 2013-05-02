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
    ModelRenderer Objective1;
    ModelRenderer Objective2;
    ModelRenderer Objective3;

    public ModelMicroscope() {
        int mod = 2;
        textureWidth = 64 * mod;
        textureHeight = 32 * mod;

        Base = new ModelRenderer(this, 0 * mod, 0 * mod);
        Base.addBox(-6F * mod, 0F * mod, -5F * mod, 12 * mod, 3 * mod, 10 * mod);
        Base.setRotationPoint(0F * mod, 21F * mod, 0F * mod);
        Base.setTextureSize(64 * mod, 32 * mod);
        Base.mirror = true;
        setRotation(Base, 0F, 0F, 0F);
        Pillar = new ModelRenderer(this, 0 * mod, 18 * mod);
        Pillar.addBox(0F * mod, 0F * mod, -2F * mod, 2 * mod, 8 * mod, 4 * mod);
        Pillar.setRotationPoint(-5F * mod, 13F * mod, 0F * mod);
        Pillar.setTextureSize(64 * mod, 32 * mod);
        Pillar.mirror = true;
        setRotation(Pillar, 0F, 0F, 0F);
        Diagonal = new ModelRenderer(this, 12 * mod, 22 * mod);
        Diagonal.addBox(0F * mod, 0F * mod, -1F * mod, 2 * mod, 3 * mod, 2 * mod);
        Diagonal.setRotationPoint(-2.9F * mod, 10.8F * mod, 0F * mod);
        Diagonal.setTextureSize(64 * mod, 32 * mod);
        Diagonal.mirror = true;
        setRotation(Diagonal, 0F, 0F, 0.7853982F);
        Bar = new ModelRenderer(this, 12 * mod, 18 * mod);
        Bar.addBox(-1F * mod, 0F * mod, -1F * mod, 6 * mod, 2 * mod, 2 * mod);
        Bar.setRotationPoint(-1.9F * mod, 10.8F * mod, 0F * mod);
        Bar.setTextureSize(64 * mod, 32 * mod);
        Bar.mirror = true;
        setRotation(Bar, 0F, 0F, 0F);
        Bracket = new ModelRenderer(this, 0 * mod, 13 * mod);
        Bracket.addBox(-2F * mod, 0F * mod, -2F * mod, 4 * mod, 1 * mod, 4 * mod);
        Bracket.setRotationPoint(2F * mod, 12.5F * mod, 0F * mod);
        Bracket.setTextureSize(64 * mod, 32 * mod);
        Bracket.mirror = true;
        setRotation(Bracket, 0F, 0F, -0.1236F);
        Ocular = new ModelRenderer(this, 16 * mod, 13 * mod);
        Ocular.addBox(0F * mod, 0F * mod, -0.5F * mod, 1 * mod, 4 * mod, 1 * mod);
        Ocular.setRotationPoint(3F * mod, 8F * mod, 0F * mod);
        Ocular.setTextureSize(64 * mod, 32 * mod);
        Ocular.mirror = true;
        setRotation(Ocular, 0F, 0F, 0.3717861F);
        Objective1 = new ModelRenderer(this, 0 * mod, 0 * mod);
        Objective1.addBox(-0.5F * mod, 0F * mod, -0.5F * mod, 1 * mod, 2 * mod, 1 * mod);
        Objective1.setRotationPoint(-1F * mod, 1F * mod, 0F * mod);
        Objective1.setTextureSize(64 * mod, 32 * mod);
        Objective1.mirror = true;
        setRotation(Objective1, 0F, 0F, 0F);
        Objective2 = new ModelRenderer(this, 0 * mod, 3 * mod);
        Objective2.addBox(-0.5F * mod, 0F * mod, -0.5F * mod, 1 * mod, 2 * mod, 1 * mod);
        Objective2.setRotationPoint(1F * mod, 1F * mod, 1F * mod);
        Objective2.setTextureSize(64 * mod, 32 * mod);
        Objective2.mirror = true;
        setRotation(Objective2, 0F, 0F, 0F);
        Objective3 = new ModelRenderer(this, 0 * mod, 6 * mod);
        Objective3.addBox(-0.5F * mod, 0F * mod, -0.5F * mod, 1 * mod, 2 * mod, 1 * mod);
        Objective3.setRotationPoint(1F * mod, 1F * mod, -1F * mod);
        Objective3.setTextureSize(64 * mod, 32 * mod);
        Objective3.mirror = true;
        setRotation(Objective3, 0F, 0F, 0F);
        
        Bracket.addChild(Objective1);
        Bracket.addChild(Objective2);
        Bracket.addChild(Objective3);
    }

    public void renderAll() {
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
