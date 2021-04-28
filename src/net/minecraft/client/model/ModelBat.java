package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.util.*;

public class ModelBat extends ModelBase
{
    private /* synthetic */ ModelRenderer batLeftWing;
    private /* synthetic */ ModelRenderer batRightWing;
    private /* synthetic */ ModelRenderer batHead;
    private /* synthetic */ ModelRenderer batBody;
    private /* synthetic */ ModelRenderer batOuterLeftWing;
    private /* synthetic */ ModelRenderer batOuterRightWing;
    
    @Override
    public void setRotationAngles(final float lllllllllllllllIllIIlIllllllllll, final float lllllllllllllllIllIIlIlllllllllI, final float lllllllllllllllIllIIlIllllllIlIl, final float lllllllllllllllIllIIlIllllllIlII, final float lllllllllllllllIllIIlIlllllllIll, final float lllllllllllllllIllIIlIlllllllIlI, final Entity lllllllllllllllIllIIlIlllllllIIl) {
        if (((EntityBat)lllllllllllllllIllIIlIlllllllIIl).getIsBatHanging()) {
            final float lllllllllllllllIllIIlIlllllllIII = 57.295776f;
            this.batHead.rotateAngleX = lllllllllllllllIllIIlIlllllllIll / 57.295776f;
            this.batHead.rotateAngleY = 3.1415927f - lllllllllllllllIllIIlIllllllIlII / 57.295776f;
            this.batHead.rotateAngleZ = 3.1415927f;
            this.batHead.setRotationPoint(0.0f, -2.0f, 0.0f);
            this.batRightWing.setRotationPoint(-3.0f, 0.0f, 3.0f);
            this.batLeftWing.setRotationPoint(3.0f, 0.0f, 3.0f);
            this.batBody.rotateAngleX = 3.1415927f;
            this.batRightWing.rotateAngleX = -0.15707964f;
            this.batRightWing.rotateAngleY = -1.2566371f;
            this.batOuterRightWing.rotateAngleY = -1.7278761f;
            this.batLeftWing.rotateAngleX = this.batRightWing.rotateAngleX;
            this.batLeftWing.rotateAngleY = -this.batRightWing.rotateAngleY;
            this.batOuterLeftWing.rotateAngleY = -this.batOuterRightWing.rotateAngleY;
        }
        else {
            final float lllllllllllllllIllIIlIllllllIlll = 57.295776f;
            this.batHead.rotateAngleX = lllllllllllllllIllIIlIlllllllIll / 57.295776f;
            this.batHead.rotateAngleY = lllllllllllllllIllIIlIllllllIlII / 57.295776f;
            this.batHead.rotateAngleZ = 0.0f;
            this.batHead.setRotationPoint(0.0f, 0.0f, 0.0f);
            this.batRightWing.setRotationPoint(0.0f, 0.0f, 0.0f);
            this.batLeftWing.setRotationPoint(0.0f, 0.0f, 0.0f);
            this.batBody.rotateAngleX = 0.7853982f + MathHelper.cos(lllllllllllllllIllIIlIllllllIlIl * 0.1f) * 0.15f;
            this.batBody.rotateAngleY = 0.0f;
            this.batRightWing.rotateAngleY = MathHelper.cos(lllllllllllllllIllIIlIllllllIlIl * 1.3f) * 3.1415927f * 0.25f;
            this.batLeftWing.rotateAngleY = -this.batRightWing.rotateAngleY;
            this.batOuterRightWing.rotateAngleY = this.batRightWing.rotateAngleY * 0.5f;
            this.batOuterLeftWing.rotateAngleY = -this.batRightWing.rotateAngleY * 0.5f;
        }
    }
    
    public ModelBat() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.batHead = new ModelRenderer(this, 0, 0);
        this.batHead.addBox(-3.0f, -3.0f, -3.0f, 6, 6, 6);
        final ModelRenderer lllllllllllllllIllIIllIIIIlIIIll = new ModelRenderer(this, 24, 0);
        lllllllllllllllIllIIllIIIIlIIIll.addBox(-4.0f, -6.0f, -2.0f, 3, 4, 1);
        this.batHead.addChild(lllllllllllllllIllIIllIIIIlIIIll);
        final ModelRenderer lllllllllllllllIllIIllIIIIlIIIlI = new ModelRenderer(this, 24, 0);
        lllllllllllllllIllIIllIIIIlIIIlI.mirror = true;
        lllllllllllllllIllIIllIIIIlIIIlI.addBox(1.0f, -6.0f, -2.0f, 3, 4, 1);
        this.batHead.addChild(lllllllllllllllIllIIllIIIIlIIIlI);
        this.batBody = new ModelRenderer(this, 0, 16);
        this.batBody.addBox(-3.0f, 4.0f, -3.0f, 6, 12, 6);
        this.batBody.setTextureOffset(0, 34).addBox(-5.0f, 16.0f, 0.0f, 10, 6, 1);
        this.batRightWing = new ModelRenderer(this, 42, 0);
        this.batRightWing.addBox(-12.0f, 1.0f, 1.5f, 10, 16, 1);
        this.batOuterRightWing = new ModelRenderer(this, 24, 16);
        this.batOuterRightWing.setRotationPoint(-12.0f, 1.0f, 1.5f);
        this.batOuterRightWing.addBox(-8.0f, 1.0f, 0.0f, 8, 12, 1);
        this.batLeftWing = new ModelRenderer(this, 42, 0);
        this.batLeftWing.mirror = true;
        this.batLeftWing.addBox(2.0f, 1.0f, 1.5f, 10, 16, 1);
        this.batOuterLeftWing = new ModelRenderer(this, 24, 16);
        this.batOuterLeftWing.mirror = true;
        this.batOuterLeftWing.setRotationPoint(12.0f, 1.0f, 1.5f);
        this.batOuterLeftWing.addBox(0.0f, 1.0f, 0.0f, 8, 12, 1);
        this.batBody.addChild(this.batRightWing);
        this.batBody.addChild(this.batLeftWing);
        this.batRightWing.addChild(this.batOuterRightWing);
        this.batLeftWing.addChild(this.batOuterLeftWing);
    }
    
    static {
        __OBFID = "CL_00000830";
    }
    
    @Override
    public void render(final Entity lllllllllllllllIllIIllIIIIIlIlIl, final float lllllllllllllllIllIIllIIIIIlIlII, final float lllllllllllllllIllIIllIIIIIIlIll, final float lllllllllllllllIllIIllIIIIIIlIlI, final float lllllllllllllllIllIIllIIIIIIlIIl, final float lllllllllllllllIllIIllIIIIIIlIII, final float lllllllllllllllIllIIllIIIIIIllll) {
        this.setRotationAngles(lllllllllllllllIllIIllIIIIIlIlII, lllllllllllllllIllIIllIIIIIIlIll, lllllllllllllllIllIIllIIIIIIlIlI, lllllllllllllllIllIIllIIIIIIlIIl, lllllllllllllllIllIIllIIIIIIlIII, lllllllllllllllIllIIllIIIIIIllll, lllllllllllllllIllIIllIIIIIlIlIl);
        this.batHead.render(lllllllllllllllIllIIllIIIIIIllll);
        this.batBody.render(lllllllllllllllIllIIllIIIIIIllll);
    }
}
