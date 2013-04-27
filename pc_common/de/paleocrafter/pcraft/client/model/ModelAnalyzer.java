package de.paleocrafter.pcraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelAnalyzer extends ModelBase {
    // fields
    ModelRenderer Top;
    ModelRenderer Base;
    ModelRenderer Pillar1;
    ModelRenderer Pillar2;
    ModelRenderer Pillar3;
    ModelRenderer Pillar4;
    ModelRenderer Pane1;
    ModelRenderer Pane2;
    ModelRenderer Pane3;
    ModelRenderer Pane4;
    ModelRenderer Controls;
    ModelRenderer LaserBase;
    ModelRenderer Progress;

    public ModelAnalyzer() {
        textureWidth = 64;
        textureHeight = 64;

        Top = new ModelRenderer(this, 0, 18);
        Top.addBox(-8F, 0F, -8F, 16, 3, 16);
        Top.setRotationPoint(0F, 8F, 0F);
        Top.setTextureSize(64, 64);
        Top.mirror = true;
        setRotation(Top, 0F, 0F, 0F);
        Base = new ModelRenderer(this, 0, 0);
        Base.addBox(-8F, 0F, -8F, 16, 2, 16);
        Base.setRotationPoint(0F, 22F, 0F);
        Base.setTextureSize(64, 64);
        Base.mirror = true;
        setRotation(Base, 0F, 0F, 0F);
        Pillar1 = new ModelRenderer(this, 48, 0);
        Pillar1.addBox(0F, 0F, 0F, 3, 11, 3);
        Pillar1.setRotationPoint(5F, 11F, 5F);
        Pillar1.setTextureSize(64, 64);
        Pillar1.mirror = true;
        setRotation(Pillar1, 0F, 0F, 0F);
        Pillar2 = new ModelRenderer(this, 48, 0);
        Pillar2.addBox(0F, 0F, 0F, 3, 11, 3);
        Pillar2.setRotationPoint(5F, 11F, -8F);
        Pillar2.setTextureSize(64, 64);
        Pillar2.mirror = true;
        setRotation(Pillar2, 0F, 0F, 0F);
        Pillar3 = new ModelRenderer(this, 48, 0);
        Pillar3.addBox(0F, 0F, 0F, 3, 11, 3);
        Pillar3.setRotationPoint(-8F, 11F, -8F);
        Pillar3.setTextureSize(64, 64);
        Pillar3.mirror = true;
        setRotation(Pillar3, 0F, 0F, 0F);
        Pillar4 = new ModelRenderer(this, 48, 0);
        Pillar4.addBox(0F, 0F, 0F, 3, 11, 3);
        Pillar4.setRotationPoint(-8F, 11F, 5F);
        Pillar4.setTextureSize(64, 64);
        Pillar4.mirror = true;
        setRotation(Pillar4, 0F, 0F, 0F);
        Pane1 = new ModelRenderer(this, 48, 18);
        Pane1.addBox(-4F, 0F, 0F, 7, 11, 1);
        Pane1.setRotationPoint(2F, 11F, 6F);
        Pane1.setTextureSize(64, 64);
        Pane1.mirror = true;
        setRotation(Pane1, 0F, 0F, 0F);
        Pane2 = new ModelRenderer(this, 22, 37);
        Pane2.addBox(0F, 0F, -5F, 1, 11, 10);
        Pane2.setRotationPoint(6F, 11F, 0F);
        Pane2.setTextureSize(64, 64);
        Pane2.mirror = true;
        setRotation(Pane2, 0F, 0F, 0F);
        Pane3 = new ModelRenderer(this, 0, 37);
        Pane3.addBox(-6F, 0F, 0F, 10, 11, 1);
        Pane3.setRotationPoint(1F, 11F, -7F);
        Pane3.setTextureSize(64, 64);
        Pane3.mirror = true;
        setRotation(Pane3, 0F, 0F, 0F);
        Pane4 = new ModelRenderer(this, 22, 37);
        Pane4.addBox(0F, 0F, -5F, 1, 11, 10);
        Pane4.setRotationPoint(-7F, 11F, 0F);
        Pane4.setTextureSize(64, 64);
        Pane4.mirror = true;
        setRotation(Pane4, 0F, 0F, 0F);
        Controls = new ModelRenderer(this, 44, 37);
        Controls.addBox(-2F, 0F, 0F, 1, 11, 2);
        Controls.addBox(-1F, 0F, 0F, 1, 11, 1);
        Controls.addBox(-1F, 0F, 0F, 1, 1, 2);
        Controls.addBox(-1F, 10F, 0F, 1, 1, 2);
        Controls.addBox(0F, 0F, 0F, 1, 11, 2);
        Controls.setRotationPoint(-3F, 11F, 5F);
        Controls.setTextureSize(64, 64);
        Controls.mirror = true;
        setRotation(Controls, 0F, 0F, 0F);
        LaserBase = new ModelRenderer(this, -1, 0);
        LaserBase.addBox(-2F, 0F, -2F, 4, 1, 4);
        LaserBase.setRotationPoint(0F, 11F, 0F);
        LaserBase.setTextureSize(64, 64);
        LaserBase.mirror = true;
        setRotation(LaserBase, 0F, 0F, 0F);
        Progress = new ModelRenderer(this, 5, 19);
        Progress.addBox(0F, 0F, 0F, 1, 9, 1);
        Progress.setRotationPoint(-4F, 12F, 6F);
        Progress.setTextureSize(64, 64);
        Progress.mirror = true;
        setRotation(Progress, 0F, 0F, 0F);
        //Controls.addChild(Progress);
    }

    public void renderAll(int progress) {
        Base.render(0.0625F);
        Pillar1.render(0.0625F);
        Pillar2.render(0.0625F);
        Pillar3.render(0.0625F);
        Pillar4.render(0.0625F);
        Top.render(0.0625F);
        Pane1.render(0.0625F);
        Pane2.render(0.0625F);
        Pane3.render(0.0625F);
        Pane4.render(0.0625F);
        refreshProgress(progress);
        Progress.render(0.0625F);
        Controls.render(0.0625F);
        Progress.setTextureOffset(5, 19);
        LaserBase.render(0.0625F);
    }
    
    private void refreshProgress(int progress) {
        if(progress > 6)
            progress = 6;
        else if(progress < 0)
            progress = 0;
        Progress = new ModelRenderer(this, 5 + progress, 19);
        Progress.addBox(0F, 0F, 0F, 1, 9, 1);
        Progress.setRotationPoint(-4F, 12F, 6F);
        Progress.setTextureSize(64, 64);
        Progress.mirror = true;
        setRotation(Progress, 0F, 0F, 0F);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

}
