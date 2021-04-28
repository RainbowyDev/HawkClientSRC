package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;

public class ModelBiped extends ModelBase
{
    public /* synthetic */ boolean aimedBow;
    public /* synthetic */ ModelRenderer bipedLeftArm;
    public /* synthetic */ ModelRenderer bipedBody;
    public /* synthetic */ ModelRenderer bipedHeadwear;
    public /* synthetic */ int heldItemRight;
    public /* synthetic */ ModelRenderer bipedRightLeg;
    public /* synthetic */ boolean isSneak;
    public /* synthetic */ ModelRenderer bipedHead;
    public /* synthetic */ int heldItemLeft;
    public /* synthetic */ ModelRenderer bipedRightArm;
    public /* synthetic */ ModelRenderer bipedLeftLeg;
    
    public ModelBiped() {
        this(0.0f);
    }
    
    @Override
    public void setModelAttributes(final ModelBase llllllllllllllIlIlllIIlIIIIIIllI) {
        super.setModelAttributes(llllllllllllllIlIlllIIlIIIIIIllI);
        if (llllllllllllllIlIlllIIlIIIIIIllI instanceof ModelBiped) {
            final ModelBiped llllllllllllllIlIlllIIlIIIIIIlIl = (ModelBiped)llllllllllllllIlIlllIIlIIIIIIllI;
            this.heldItemLeft = llllllllllllllIlIlllIIlIIIIIIlIl.heldItemLeft;
            this.heldItemRight = llllllllllllllIlIlllIIlIIIIIIlIl.heldItemRight;
            this.isSneak = llllllllllllllIlIlllIIlIIIIIIlIl.isSneak;
            this.aimedBow = llllllllllllllIlIlllIIlIIIIIIlIl.aimedBow;
        }
    }
    
    public ModelBiped(final float llllllllllllllIlIlllIIlIIlIIllIl, final float llllllllllllllIlIlllIIlIIlIIllII, final int llllllllllllllIlIlllIIlIIlIIlIll, final int llllllllllllllIlIlllIIlIIlIIlIlI) {
        this.textureWidth = llllllllllllllIlIlllIIlIIlIIlIll;
        this.textureHeight = llllllllllllllIlIlllIIlIIlIIlIlI;
        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, llllllllllllllIlIlllIIlIIlIIllIl);
        this.bipedHead.setRotationPoint(0.0f, 0.0f + llllllllllllllIlIlllIIlIIlIIllII, 0.0f);
        this.bipedHeadwear = new ModelRenderer(this, 32, 0);
        this.bipedHeadwear.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, llllllllllllllIlIlllIIlIIlIIllIl + 0.5f);
        this.bipedHeadwear.setRotationPoint(0.0f, 0.0f + llllllllllllllIlIlllIIlIIlIIllII, 0.0f);
        this.bipedBody = new ModelRenderer(this, 16, 16);
        this.bipedBody.addBox(-4.0f, 0.0f, -2.0f, 8, 12, 4, llllllllllllllIlIlllIIlIIlIIllIl);
        this.bipedBody.setRotationPoint(0.0f, 0.0f + llllllllllllllIlIlllIIlIIlIIllII, 0.0f);
        this.bipedRightArm = new ModelRenderer(this, 40, 16);
        this.bipedRightArm.addBox(-3.0f, -2.0f, -2.0f, 4, 12, 4, llllllllllllllIlIlllIIlIIlIIllIl);
        this.bipedRightArm.setRotationPoint(-5.0f, 2.0f + llllllllllllllIlIlllIIlIIlIIllII, 0.0f);
        this.bipedLeftArm = new ModelRenderer(this, 40, 16);
        this.bipedLeftArm.mirror = true;
        this.bipedLeftArm.addBox(-1.0f, -2.0f, -2.0f, 4, 12, 4, llllllllllllllIlIlllIIlIIlIIllIl);
        this.bipedLeftArm.setRotationPoint(5.0f, 2.0f + llllllllllllllIlIlllIIlIIlIIllII, 0.0f);
        this.bipedRightLeg = new ModelRenderer(this, 0, 16);
        this.bipedRightLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, llllllllllllllIlIlllIIlIIlIIllIl);
        this.bipedRightLeg.setRotationPoint(-1.9f, 12.0f + llllllllllllllIlIlllIIlIIlIIllII, 0.0f);
        this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
        this.bipedLeftLeg.mirror = true;
        this.bipedLeftLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, llllllllllllllIlIlllIIlIIlIIllIl);
        this.bipedLeftLeg.setRotationPoint(1.9f, 12.0f + llllllllllllllIlIlllIIlIIlIIllII, 0.0f);
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllllIlIlllIIlIIIIlllll, final float llllllllllllllIlIlllIIlIIIIlIIIl, final float llllllllllllllIlIlllIIlIIIIlllIl, final float llllllllllllllIlIlllIIlIIIIlllII, final float llllllllllllllIlIlllIIlIIIIllIll, final float llllllllllllllIlIlllIIlIIIIllIlI, final Entity llllllllllllllIlIlllIIlIIIIllIIl) {
        this.bipedHead.rotateAngleY = llllllllllllllIlIlllIIlIIIIlllII / 57.295776f;
        this.bipedHead.rotateAngleX = llllllllllllllIlIlllIIlIIIIllIll / 57.295776f;
        this.bipedRightArm.rotateAngleX = MathHelper.cos(llllllllllllllIlIlllIIlIIIIlllll * 0.6662f + 3.1415927f) * 2.0f * llllllllllllllIlIlllIIlIIIIlIIIl * 0.5f;
        this.bipedLeftArm.rotateAngleX = MathHelper.cos(llllllllllllllIlIlllIIlIIIIlllll * 0.6662f) * 2.0f * llllllllllllllIlIlllIIlIIIIlIIIl * 0.5f;
        this.bipedRightArm.rotateAngleZ = 0.0f;
        this.bipedLeftArm.rotateAngleZ = 0.0f;
        this.bipedRightLeg.rotateAngleX = MathHelper.cos(llllllllllllllIlIlllIIlIIIIlllll * 0.6662f) * 1.4f * llllllllllllllIlIlllIIlIIIIlIIIl;
        this.bipedLeftLeg.rotateAngleX = MathHelper.cos(llllllllllllllIlIlllIIlIIIIlllll * 0.6662f + 3.1415927f) * 1.4f * llllllllllllllIlIlllIIlIIIIlIIIl;
        this.bipedRightLeg.rotateAngleY = 0.0f;
        this.bipedLeftLeg.rotateAngleY = 0.0f;
        if (this.isRiding) {
            final ModelRenderer bipedRightArm = this.bipedRightArm;
            bipedRightArm.rotateAngleX -= 0.62831855f;
            final ModelRenderer bipedLeftArm = this.bipedLeftArm;
            bipedLeftArm.rotateAngleX -= 0.62831855f;
            this.bipedRightLeg.rotateAngleX = -1.2566371f;
            this.bipedLeftLeg.rotateAngleX = -1.2566371f;
            this.bipedRightLeg.rotateAngleY = 0.31415927f;
            this.bipedLeftLeg.rotateAngleY = -0.31415927f;
        }
        if (this.heldItemLeft != 0) {
            this.bipedLeftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX * 0.5f - 0.31415927f * this.heldItemLeft;
        }
        this.bipedRightArm.rotateAngleY = 0.0f;
        this.bipedRightArm.rotateAngleZ = 0.0f;
        switch (this.heldItemRight) {
            case 1: {
                this.bipedRightArm.rotateAngleX = this.bipedRightArm.rotateAngleX * 0.5f - 0.31415927f * this.heldItemRight;
                break;
            }
            case 3: {
                this.bipedRightArm.rotateAngleX = this.bipedRightArm.rotateAngleX * 0.5f - 0.31415927f * this.heldItemRight;
                this.bipedRightArm.rotateAngleY = -0.5235988f;
                break;
            }
        }
        this.bipedLeftArm.rotateAngleY = 0.0f;
        if (this.swingProgress > -9990.0f) {
            float llllllllllllllIlIlllIIlIIIIllIII = this.swingProgress;
            this.bipedBody.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(llllllllllllllIlIlllIIlIIIIllIII) * 3.1415927f * 2.0f) * 0.2f;
            this.bipedRightArm.rotationPointZ = MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0f;
            this.bipedRightArm.rotationPointX = -MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0f;
            this.bipedLeftArm.rotationPointZ = -MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0f;
            this.bipedLeftArm.rotationPointX = MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0f;
            final ModelRenderer bipedRightArm2 = this.bipedRightArm;
            bipedRightArm2.rotateAngleY += this.bipedBody.rotateAngleY;
            final ModelRenderer bipedLeftArm2 = this.bipedLeftArm;
            bipedLeftArm2.rotateAngleY += this.bipedBody.rotateAngleY;
            final ModelRenderer bipedLeftArm3 = this.bipedLeftArm;
            bipedLeftArm3.rotateAngleX += this.bipedBody.rotateAngleY;
            llllllllllllllIlIlllIIlIIIIllIII = 1.0f - this.swingProgress;
            llllllllllllllIlIlllIIlIIIIllIII *= llllllllllllllIlIlllIIlIIIIllIII;
            llllllllllllllIlIlllIIlIIIIllIII *= llllllllllllllIlIlllIIlIIIIllIII;
            llllllllllllllIlIlllIIlIIIIllIII = 1.0f - llllllllllllllIlIlllIIlIIIIllIII;
            final float llllllllllllllIlIlllIIlIIIIlIllI = MathHelper.sin(llllllllllllllIlIlllIIlIIIIllIII * 3.1415927f);
            final float llllllllllllllIlIlllIIlIIIIlIlII = MathHelper.sin(this.swingProgress * 3.1415927f) * -(this.bipedHead.rotateAngleX - 0.7f) * 0.75f;
            this.bipedRightArm.rotateAngleX -= (float)(llllllllllllllIlIlllIIlIIIIlIllI * 1.2 + llllllllllllllIlIlllIIlIIIIlIlII);
            final ModelRenderer bipedRightArm3 = this.bipedRightArm;
            bipedRightArm3.rotateAngleY += this.bipedBody.rotateAngleY * 2.0f;
            final ModelRenderer bipedRightArm4 = this.bipedRightArm;
            bipedRightArm4.rotateAngleZ += MathHelper.sin(this.swingProgress * 3.1415927f) * -0.4f;
        }
        if (this.isSneak) {
            this.bipedBody.rotateAngleX = 0.5f;
            final ModelRenderer bipedRightArm5 = this.bipedRightArm;
            bipedRightArm5.rotateAngleX += 0.4f;
            final ModelRenderer bipedLeftArm4 = this.bipedLeftArm;
            bipedLeftArm4.rotateAngleX += 0.4f;
            this.bipedRightLeg.rotationPointZ = 4.0f;
            this.bipedLeftLeg.rotationPointZ = 4.0f;
            this.bipedRightLeg.rotationPointY = 9.0f;
            this.bipedLeftLeg.rotationPointY = 9.0f;
            this.bipedHead.rotationPointY = 1.0f;
        }
        else {
            this.bipedBody.rotateAngleX = 0.0f;
            this.bipedRightLeg.rotationPointZ = 0.1f;
            this.bipedLeftLeg.rotationPointZ = 0.1f;
            this.bipedRightLeg.rotationPointY = 12.0f;
            this.bipedLeftLeg.rotationPointY = 12.0f;
            this.bipedHead.rotationPointY = 0.0f;
        }
        final ModelRenderer bipedRightArm6 = this.bipedRightArm;
        bipedRightArm6.rotateAngleZ += MathHelper.cos(llllllllllllllIlIlllIIlIIIIlllIl * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer bipedLeftArm5 = this.bipedLeftArm;
        bipedLeftArm5.rotateAngleZ -= MathHelper.cos(llllllllllllllIlIlllIIlIIIIlllIl * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer bipedRightArm7 = this.bipedRightArm;
        bipedRightArm7.rotateAngleX += MathHelper.sin(llllllllllllllIlIlllIIlIIIIlllIl * 0.067f) * 0.05f;
        final ModelRenderer bipedLeftArm6 = this.bipedLeftArm;
        bipedLeftArm6.rotateAngleX -= MathHelper.sin(llllllllllllllIlIlllIIlIIIIlllIl * 0.067f) * 0.05f;
        if (this.aimedBow) {
            final float llllllllllllllIlIlllIIlIIIIlIlll = 0.0f;
            final float llllllllllllllIlIlllIIlIIIIlIlIl = 0.0f;
            this.bipedRightArm.rotateAngleZ = 0.0f;
            this.bipedLeftArm.rotateAngleZ = 0.0f;
            this.bipedRightArm.rotateAngleY = -(0.1f - llllllllllllllIlIlllIIlIIIIlIlll * 0.6f) + this.bipedHead.rotateAngleY;
            this.bipedLeftArm.rotateAngleY = 0.1f - llllllllllllllIlIlllIIlIIIIlIlll * 0.6f + this.bipedHead.rotateAngleY + 0.4f;
            this.bipedRightArm.rotateAngleX = -1.5707964f + this.bipedHead.rotateAngleX;
            this.bipedLeftArm.rotateAngleX = -1.5707964f + this.bipedHead.rotateAngleX;
            final ModelRenderer bipedRightArm8 = this.bipedRightArm;
            bipedRightArm8.rotateAngleX -= llllllllllllllIlIlllIIlIIIIlIlll * 1.2f - llllllllllllllIlIlllIIlIIIIlIlIl * 0.4f;
            final ModelRenderer bipedLeftArm7 = this.bipedLeftArm;
            bipedLeftArm7.rotateAngleX -= llllllllllllllIlIlllIIlIIIIlIlll * 1.2f - llllllllllllllIlIlllIIlIIIIlIlIl * 0.4f;
            final ModelRenderer bipedRightArm9 = this.bipedRightArm;
            bipedRightArm9.rotateAngleZ += MathHelper.cos(llllllllllllllIlIlllIIlIIIIlllIl * 0.09f) * 0.05f + 0.05f;
            final ModelRenderer bipedLeftArm8 = this.bipedLeftArm;
            bipedLeftArm8.rotateAngleZ -= MathHelper.cos(llllllllllllllIlIlllIIlIIIIlllIl * 0.09f) * 0.05f + 0.05f;
            final ModelRenderer bipedRightArm10 = this.bipedRightArm;
            bipedRightArm10.rotateAngleX += MathHelper.sin(llllllllllllllIlIlllIIlIIIIlllIl * 0.067f) * 0.05f;
            final ModelRenderer bipedLeftArm9 = this.bipedLeftArm;
            bipedLeftArm9.rotateAngleX -= MathHelper.sin(llllllllllllllIlIlllIIlIIIIlllIl * 0.067f) * 0.05f;
        }
        ModelBase.func_178685_a(this.bipedHead, this.bipedHeadwear);
    }
    
    @Override
    public void render(final Entity llllllllllllllIlIlllIIlIIIlllIlI, final float llllllllllllllIlIlllIIlIIIlllIIl, final float llllllllllllllIlIlllIIlIIIlIllll, final float llllllllllllllIlIlllIIlIIIllIlll, final float llllllllllllllIlIlllIIlIIIlIllIl, final float llllllllllllllIlIlllIIlIIIllIlIl, final float llllllllllllllIlIlllIIlIIIllIlII) {
        this.setRotationAngles(llllllllllllllIlIlllIIlIIIlllIIl, llllllllllllllIlIlllIIlIIIlIllll, llllllllllllllIlIlllIIlIIIllIlll, llllllllllllllIlIlllIIlIIIlIllIl, llllllllllllllIlIlllIIlIIIllIlIl, llllllllllllllIlIlllIIlIIIllIlII, llllllllllllllIlIlllIIlIIIlllIlI);
        GlStateManager.pushMatrix();
        if (this.isChild) {
            final float llllllllllllllIlIlllIIlIIIllIIll = 2.0f;
            GlStateManager.scale(1.5f / llllllllllllllIlIlllIIlIIIllIIll, 1.5f / llllllllllllllIlIlllIIlIIIllIIll, 1.5f / llllllllllllllIlIlllIIlIIIllIIll);
            GlStateManager.translate(0.0f, 16.0f * llllllllllllllIlIlllIIlIIIllIlII, 0.0f);
            this.bipedHead.render(llllllllllllllIlIlllIIlIIIllIlII);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(1.0f / llllllllllllllIlIlllIIlIIIllIIll, 1.0f / llllllllllllllIlIlllIIlIIIllIIll, 1.0f / llllllllllllllIlIlllIIlIIIllIIll);
            GlStateManager.translate(0.0f, 24.0f * llllllllllllllIlIlllIIlIIIllIlII, 0.0f);
            this.bipedBody.render(llllllllllllllIlIlllIIlIIIllIlII);
            this.bipedRightArm.render(llllllllllllllIlIlllIIlIIIllIlII);
            this.bipedLeftArm.render(llllllllllllllIlIlllIIlIIIllIlII);
            this.bipedRightLeg.render(llllllllllllllIlIlllIIlIIIllIlII);
            this.bipedLeftLeg.render(llllllllllllllIlIlllIIlIIIllIlII);
            this.bipedHeadwear.render(llllllllllllllIlIlllIIlIIIllIlII);
        }
        else {
            if (llllllllllllllIlIlllIIlIIIlllIlI.isSneaking()) {
                GlStateManager.translate(0.0f, 0.2f, 0.0f);
            }
            this.bipedHead.render(llllllllllllllIlIlllIIlIIIllIlII);
            this.bipedBody.render(llllllllllllllIlIlllIIlIIIllIlII);
            this.bipedRightArm.render(llllllllllllllIlIlllIIlIIIllIlII);
            this.bipedLeftArm.render(llllllllllllllIlIlllIIlIIIllIlII);
            this.bipedRightLeg.render(llllllllllllllIlIlllIIlIIIllIlII);
            this.bipedLeftLeg.render(llllllllllllllIlIlllIIlIIIllIlII);
            this.bipedHeadwear.render(llllllllllllllIlIlllIIlIIIllIlII);
        }
        GlStateManager.popMatrix();
    }
    
    public void postRenderHiddenArm(final float llllllllllllllIlIlllIIIllllllIII) {
        this.bipedRightArm.postRender(llllllllllllllIlIlllIIIllllllIII);
    }
    
    static {
        __OBFID = "CL_00000840";
    }
    
    public void func_178719_a(final boolean llllllllllllllIlIlllIIIlllllllII) {
        this.bipedHead.showModel = llllllllllllllIlIlllIIIlllllllII;
        this.bipedHeadwear.showModel = llllllllllllllIlIlllIIIlllllllII;
        this.bipedBody.showModel = llllllllllllllIlIlllIIIlllllllII;
        this.bipedRightArm.showModel = llllllllllllllIlIlllIIIlllllllII;
        this.bipedLeftArm.showModel = llllllllllllllIlIlllIIIlllllllII;
        this.bipedRightLeg.showModel = llllllllllllllIlIlllIIIlllllllII;
        this.bipedLeftLeg.showModel = llllllllllllllIlIlllIIIlllllllII;
    }
    
    public ModelBiped(final float llllllllllllllIlIlllIIlIIlIlIlII) {
        this(llllllllllllllIlIlllIIlIIlIlIlII, 0.0f, 64, 32);
    }
}
