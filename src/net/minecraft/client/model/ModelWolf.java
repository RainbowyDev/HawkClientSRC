package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;

public class ModelWolf extends ModelBase
{
    public /* synthetic */ ModelRenderer wolfLeg2;
    /* synthetic */ ModelRenderer wolfMane;
    public /* synthetic */ ModelRenderer wolfLeg4;
    public /* synthetic */ ModelRenderer wolfLeg3;
    public /* synthetic */ ModelRenderer wolfLeg1;
    public /* synthetic */ ModelRenderer wolfBody;
    public /* synthetic */ ModelRenderer wolfHeadMain;
    /* synthetic */ ModelRenderer wolfTail;
    
    public ModelWolf() {
        final float llllllllllllllIlIllIlIIIllIllIII = 0.0f;
        final float llllllllllllllIlIllIlIIIllIlIlll = 13.5f;
        this.wolfHeadMain = new ModelRenderer(this, 0, 0);
        this.wolfHeadMain.addBox(-3.0f, -3.0f, -2.0f, 6, 6, 4, llllllllllllllIlIllIlIIIllIllIII);
        this.wolfHeadMain.setRotationPoint(-1.0f, llllllllllllllIlIllIlIIIllIlIlll, -7.0f);
        this.wolfBody = new ModelRenderer(this, 18, 14);
        this.wolfBody.addBox(-4.0f, -2.0f, -3.0f, 6, 9, 6, llllllllllllllIlIllIlIIIllIllIII);
        this.wolfBody.setRotationPoint(0.0f, 14.0f, 2.0f);
        this.wolfMane = new ModelRenderer(this, 21, 0);
        this.wolfMane.addBox(-4.0f, -3.0f, -3.0f, 8, 6, 7, llllllllllllllIlIllIlIIIllIllIII);
        this.wolfMane.setRotationPoint(-1.0f, 14.0f, 2.0f);
        this.wolfLeg1 = new ModelRenderer(this, 0, 18);
        this.wolfLeg1.addBox(-1.0f, 0.0f, -1.0f, 2, 8, 2, llllllllllllllIlIllIlIIIllIllIII);
        this.wolfLeg1.setRotationPoint(-2.5f, 16.0f, 7.0f);
        this.wolfLeg2 = new ModelRenderer(this, 0, 18);
        this.wolfLeg2.addBox(-1.0f, 0.0f, -1.0f, 2, 8, 2, llllllllllllllIlIllIlIIIllIllIII);
        this.wolfLeg2.setRotationPoint(0.5f, 16.0f, 7.0f);
        this.wolfLeg3 = new ModelRenderer(this, 0, 18);
        this.wolfLeg3.addBox(-1.0f, 0.0f, -1.0f, 2, 8, 2, llllllllllllllIlIllIlIIIllIllIII);
        this.wolfLeg3.setRotationPoint(-2.5f, 16.0f, -4.0f);
        this.wolfLeg4 = new ModelRenderer(this, 0, 18);
        this.wolfLeg4.addBox(-1.0f, 0.0f, -1.0f, 2, 8, 2, llllllllllllllIlIllIlIIIllIllIII);
        this.wolfLeg4.setRotationPoint(0.5f, 16.0f, -4.0f);
        this.wolfTail = new ModelRenderer(this, 9, 18);
        this.wolfTail.addBox(-1.0f, 0.0f, -1.0f, 2, 8, 2, llllllllllllllIlIllIlIIIllIllIII);
        this.wolfTail.setRotationPoint(-1.0f, 12.0f, 8.0f);
        this.wolfHeadMain.setTextureOffset(16, 14).addBox(-3.0f, -5.0f, 0.0f, 2, 2, 1, llllllllllllllIlIllIlIIIllIllIII);
        this.wolfHeadMain.setTextureOffset(16, 14).addBox(1.0f, -5.0f, 0.0f, 2, 2, 1, llllllllllllllIlIllIlIIIllIllIII);
        this.wolfHeadMain.setTextureOffset(0, 10).addBox(-1.5f, 0.0f, -5.0f, 3, 3, 4, llllllllllllllIlIllIlIIIllIllIII);
    }
    
    static {
        __OBFID = "CL_00000868";
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllllIlIllIlIIIlIIlIlIl, final float llllllllllllllIlIllIlIIIlIIlIlII, final float llllllllllllllIlIllIlIIIlIIllIll, final float llllllllllllllIlIllIlIIIlIIllIlI, final float llllllllllllllIlIllIlIIIlIIlIIIl, final float llllllllllllllIlIllIlIIIlIIlIIII, final Entity llllllllllllllIlIllIlIIIlIIlIlll) {
        super.setRotationAngles(llllllllllllllIlIllIlIIIlIIlIlIl, llllllllllllllIlIllIlIIIlIIlIlII, llllllllllllllIlIllIlIIIlIIllIll, llllllllllllllIlIllIlIIIlIIllIlI, llllllllllllllIlIllIlIIIlIIlIIIl, llllllllllllllIlIllIlIIIlIIlIIII, llllllllllllllIlIllIlIIIlIIlIlll);
        this.wolfHeadMain.rotateAngleX = llllllllllllllIlIllIlIIIlIIlIIIl / 57.295776f;
        this.wolfHeadMain.rotateAngleY = llllllllllllllIlIllIlIIIlIIllIlI / 57.295776f;
        this.wolfTail.rotateAngleX = llllllllllllllIlIllIlIIIlIIllIll;
    }
    
    @Override
    public void setLivingAnimations(final EntityLivingBase llllllllllllllIlIllIlIIIlIlIlIll, final float llllllllllllllIlIllIlIIIlIllIIII, final float llllllllllllllIlIllIlIIIlIlIlIIl, final float llllllllllllllIlIllIlIIIlIlIlIII) {
        final EntityWolf llllllllllllllIlIllIlIIIlIlIllIl = (EntityWolf)llllllllllllllIlIllIlIIIlIlIlIll;
        if (llllllllllllllIlIllIlIIIlIlIllIl.isAngry()) {
            this.wolfTail.rotateAngleY = 0.0f;
        }
        else {
            this.wolfTail.rotateAngleY = MathHelper.cos(llllllllllllllIlIllIlIIIlIllIIII * 0.6662f) * 1.4f * llllllllllllllIlIllIlIIIlIlIlIIl;
        }
        if (llllllllllllllIlIllIlIIIlIlIllIl.isSitting()) {
            this.wolfMane.setRotationPoint(-1.0f, 16.0f, -3.0f);
            this.wolfMane.rotateAngleX = 1.2566371f;
            this.wolfMane.rotateAngleY = 0.0f;
            this.wolfBody.setRotationPoint(0.0f, 18.0f, 0.0f);
            this.wolfBody.rotateAngleX = 0.7853982f;
            this.wolfTail.setRotationPoint(-1.0f, 21.0f, 6.0f);
            this.wolfLeg1.setRotationPoint(-2.5f, 22.0f, 2.0f);
            this.wolfLeg1.rotateAngleX = 4.712389f;
            this.wolfLeg2.setRotationPoint(0.5f, 22.0f, 2.0f);
            this.wolfLeg2.rotateAngleX = 4.712389f;
            this.wolfLeg3.rotateAngleX = 5.811947f;
            this.wolfLeg3.setRotationPoint(-2.49f, 17.0f, -4.0f);
            this.wolfLeg4.rotateAngleX = 5.811947f;
            this.wolfLeg4.setRotationPoint(0.51f, 17.0f, -4.0f);
        }
        else {
            this.wolfBody.setRotationPoint(0.0f, 14.0f, 2.0f);
            this.wolfBody.rotateAngleX = 1.5707964f;
            this.wolfMane.setRotationPoint(-1.0f, 14.0f, -3.0f);
            this.wolfMane.rotateAngleX = this.wolfBody.rotateAngleX;
            this.wolfTail.setRotationPoint(-1.0f, 12.0f, 8.0f);
            this.wolfLeg1.setRotationPoint(-2.5f, 16.0f, 7.0f);
            this.wolfLeg2.setRotationPoint(0.5f, 16.0f, 7.0f);
            this.wolfLeg3.setRotationPoint(-2.5f, 16.0f, -4.0f);
            this.wolfLeg4.setRotationPoint(0.5f, 16.0f, -4.0f);
            this.wolfLeg1.rotateAngleX = MathHelper.cos(llllllllllllllIlIllIlIIIlIllIIII * 0.6662f) * 1.4f * llllllllllllllIlIllIlIIIlIlIlIIl;
            this.wolfLeg2.rotateAngleX = MathHelper.cos(llllllllllllllIlIllIlIIIlIllIIII * 0.6662f + 3.1415927f) * 1.4f * llllllllllllllIlIllIlIIIlIlIlIIl;
            this.wolfLeg3.rotateAngleX = MathHelper.cos(llllllllllllllIlIllIlIIIlIllIIII * 0.6662f + 3.1415927f) * 1.4f * llllllllllllllIlIllIlIIIlIlIlIIl;
            this.wolfLeg4.rotateAngleX = MathHelper.cos(llllllllllllllIlIllIlIIIlIllIIII * 0.6662f) * 1.4f * llllllllllllllIlIllIlIIIlIlIlIIl;
        }
        this.wolfHeadMain.rotateAngleZ = llllllllllllllIlIllIlIIIlIlIllIl.getInterestedAngle(llllllllllllllIlIllIlIIIlIlIlIII) + llllllllllllllIlIllIlIIIlIlIllIl.getShakeAngle(llllllllllllllIlIllIlIIIlIlIlIII, 0.0f);
        this.wolfMane.rotateAngleZ = llllllllllllllIlIllIlIIIlIlIllIl.getShakeAngle(llllllllllllllIlIllIlIIIlIlIlIII, -0.08f);
        this.wolfBody.rotateAngleZ = llllllllllllllIlIllIlIIIlIlIllIl.getShakeAngle(llllllllllllllIlIllIlIIIlIlIlIII, -0.16f);
        this.wolfTail.rotateAngleZ = llllllllllllllIlIllIlIIIlIlIllIl.getShakeAngle(llllllllllllllIlIllIlIIIlIlIlIII, -0.2f);
    }
    
    @Override
    public void render(final Entity llllllllllllllIlIllIlIIIllIIlIIl, final float llllllllllllllIlIllIlIIIllIIlIII, final float llllllllllllllIlIllIlIIIllIIIlll, final float llllllllllllllIlIllIlIIIllIIIllI, final float llllllllllllllIlIllIlIIIllIIIlIl, final float llllllllllllllIlIllIlIIIlIlllIll, final float llllllllllllllIlIllIlIIIlIlllIlI) {
        super.render(llllllllllllllIlIllIlIIIllIIlIIl, llllllllllllllIlIllIlIIIllIIlIII, llllllllllllllIlIllIlIIIllIIIlll, llllllllllllllIlIllIlIIIllIIIllI, llllllllllllllIlIllIlIIIllIIIlIl, llllllllllllllIlIllIlIIIlIlllIll, llllllllllllllIlIllIlIIIlIlllIlI);
        this.setRotationAngles(llllllllllllllIlIllIlIIIllIIlIII, llllllllllllllIlIllIlIIIllIIIlll, llllllllllllllIlIllIlIIIllIIIllI, llllllllllllllIlIllIlIIIllIIIlIl, llllllllllllllIlIllIlIIIlIlllIll, llllllllllllllIlIllIlIIIlIlllIlI, llllllllllllllIlIllIlIIIllIIlIIl);
        if (this.isChild) {
            final float llllllllllllllIlIllIlIIIllIIIIlI = 2.0f;
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, 5.0f * llllllllllllllIlIllIlIIIlIlllIlI, 2.0f * llllllllllllllIlIllIlIIIlIlllIlI);
            this.wolfHeadMain.renderWithRotation(llllllllllllllIlIllIlIIIlIlllIlI);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(1.0f / llllllllllllllIlIllIlIIIllIIIIlI, 1.0f / llllllllllllllIlIllIlIIIllIIIIlI, 1.0f / llllllllllllllIlIllIlIIIllIIIIlI);
            GlStateManager.translate(0.0f, 24.0f * llllllllllllllIlIllIlIIIlIlllIlI, 0.0f);
            this.wolfBody.render(llllllllllllllIlIllIlIIIlIlllIlI);
            this.wolfLeg1.render(llllllllllllllIlIllIlIIIlIlllIlI);
            this.wolfLeg2.render(llllllllllllllIlIllIlIIIlIlllIlI);
            this.wolfLeg3.render(llllllllllllllIlIllIlIIIlIlllIlI);
            this.wolfLeg4.render(llllllllllllllIlIllIlIIIlIlllIlI);
            this.wolfTail.renderWithRotation(llllllllllllllIlIllIlIIIlIlllIlI);
            this.wolfMane.render(llllllllllllllIlIllIlIIIlIlllIlI);
            GlStateManager.popMatrix();
        }
        else {
            this.wolfHeadMain.renderWithRotation(llllllllllllllIlIllIlIIIlIlllIlI);
            this.wolfBody.render(llllllllllllllIlIllIlIIIlIlllIlI);
            this.wolfLeg1.render(llllllllllllllIlIllIlIIIlIlllIlI);
            this.wolfLeg2.render(llllllllllllllIlIllIlIIIlIlllIlI);
            this.wolfLeg3.render(llllllllllllllIlIllIlIIIlIlllIlI);
            this.wolfLeg4.render(llllllllllllllIlIllIlIIIlIlllIlI);
            this.wolfTail.renderWithRotation(llllllllllllllIlIllIlIIIlIlllIlI);
            this.wolfMane.render(llllllllllllllIlIllIlIIIlIlllIlI);
        }
    }
}
