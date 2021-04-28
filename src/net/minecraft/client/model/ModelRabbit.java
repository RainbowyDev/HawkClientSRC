package net.minecraft.client.model;

import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.util.*;

public class ModelRabbit extends ModelBase
{
    /* synthetic */ ModelRenderer rabbitLeftFoot;
    /* synthetic */ ModelRenderer rabbitLeftThigh;
    /* synthetic */ ModelRenderer rabbitHead;
    /* synthetic */ ModelRenderer rabbitRightEar;
    private /* synthetic */ float field_178701_m;
    /* synthetic */ ModelRenderer rabbitNose;
    /* synthetic */ ModelRenderer rabbitBody;
    /* synthetic */ ModelRenderer rabbitRightArm;
    /* synthetic */ ModelRenderer rabbitLeftArm;
    private /* synthetic */ float field_178699_n;
    /* synthetic */ ModelRenderer rabbitTail;
    /* synthetic */ ModelRenderer rabbitLeftEar;
    /* synthetic */ ModelRenderer rabbitRightThigh;
    /* synthetic */ ModelRenderer rabbitRightFoot;
    
    static {
        __OBFID = "CL_00002625";
    }
    
    @Override
    public void render(final Entity llllllllllllllIIlllIIlllIlIIIlII, final float llllllllllllllIIlllIIlllIlIIllII, final float llllllllllllllIIlllIIlllIlIIlIll, final float llllllllllllllIIlllIIlllIlIIlIlI, final float llllllllllllllIIlllIIlllIlIIIIII, final float llllllllllllllIIlllIIlllIlIIlIII, final float llllllllllllllIIlllIIlllIlIIIlll) {
        this.setRotationAngles(llllllllllllllIIlllIIlllIlIIllII, llllllllllllllIIlllIIlllIlIIlIll, llllllllllllllIIlllIIlllIlIIlIlI, llllllllllllllIIlllIIlllIlIIIIII, llllllllllllllIIlllIIlllIlIIlIII, llllllllllllllIIlllIIlllIlIIIlll, llllllllllllllIIlllIIlllIlIIIlII);
        if (this.isChild) {
            final float llllllllllllllIIlllIIlllIlIIIllI = 2.0f;
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, 5.0f * llllllllllllllIIlllIIlllIlIIIlll, 2.0f * llllllllllllllIIlllIIlllIlIIIlll);
            this.rabbitHead.render(llllllllllllllIIlllIIlllIlIIIlll);
            this.rabbitLeftEar.render(llllllllllllllIIlllIIlllIlIIIlll);
            this.rabbitRightEar.render(llllllllllllllIIlllIIlllIlIIIlll);
            this.rabbitNose.render(llllllllllllllIIlllIIlllIlIIIlll);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(1.0f / llllllllllllllIIlllIIlllIlIIIllI, 1.0f / llllllllllllllIIlllIIlllIlIIIllI, 1.0f / llllllllllllllIIlllIIlllIlIIIllI);
            GlStateManager.translate(0.0f, 24.0f * llllllllllllllIIlllIIlllIlIIIlll, 0.0f);
            this.rabbitLeftFoot.render(llllllllllllllIIlllIIlllIlIIIlll);
            this.rabbitRightFoot.render(llllllllllllllIIlllIIlllIlIIIlll);
            this.rabbitLeftThigh.render(llllllllllllllIIlllIIlllIlIIIlll);
            this.rabbitRightThigh.render(llllllllllllllIIlllIIlllIlIIIlll);
            this.rabbitBody.render(llllllllllllllIIlllIIlllIlIIIlll);
            this.rabbitLeftArm.render(llllllllllllllIIlllIIlllIlIIIlll);
            this.rabbitRightArm.render(llllllllllllllIIlllIIlllIlIIIlll);
            this.rabbitTail.render(llllllllllllllIIlllIIlllIlIIIlll);
            GlStateManager.popMatrix();
        }
        else {
            this.rabbitLeftFoot.render(llllllllllllllIIlllIIlllIlIIIlll);
            this.rabbitRightFoot.render(llllllllllllllIIlllIIlllIlIIIlll);
            this.rabbitLeftThigh.render(llllllllllllllIIlllIIlllIlIIIlll);
            this.rabbitRightThigh.render(llllllllllllllIIlllIIlllIlIIIlll);
            this.rabbitBody.render(llllllllllllllIIlllIIlllIlIIIlll);
            this.rabbitLeftArm.render(llllllllllllllIIlllIIlllIlIIIlll);
            this.rabbitRightArm.render(llllllllllllllIIlllIIlllIlIIIlll);
            this.rabbitHead.render(llllllllllllllIIlllIIlllIlIIIlll);
            this.rabbitRightEar.render(llllllllllllllIIlllIIlllIlIIIlll);
            this.rabbitLeftEar.render(llllllllllllllIIlllIIlllIlIIIlll);
            this.rabbitTail.render(llllllllllllllIIlllIIlllIlIIIlll);
            this.rabbitNose.render(llllllllllllllIIlllIIlllIlIIIlll);
        }
    }
    
    @Override
    public void setLivingAnimations(final EntityLivingBase llllllllllllllIIlllIIlllIIlIIIll, final float llllllllllllllIIlllIIlllIIlIIIlI, final float llllllllllllllIIlllIIlllIIlIIIIl, final float llllllllllllllIIlllIIlllIIlIIIII) {
    }
    
    public ModelRabbit() {
        this.field_178701_m = 0.0f;
        this.field_178699_n = 0.0f;
        this.setTextureOffset("head.main", 0, 0);
        this.setTextureOffset("head.nose", 0, 24);
        this.setTextureOffset("head.ear1", 0, 10);
        this.setTextureOffset("head.ear2", 6, 10);
        this.rabbitLeftFoot = new ModelRenderer(this, 26, 24);
        this.rabbitLeftFoot.addBox(-1.0f, 5.5f, -3.7f, 2, 1, 7);
        this.rabbitLeftFoot.setRotationPoint(3.0f, 17.5f, 3.7f);
        this.rabbitLeftFoot.mirror = true;
        this.setRotationOffset(this.rabbitLeftFoot, 0.0f, 0.0f, 0.0f);
        this.rabbitRightFoot = new ModelRenderer(this, 8, 24);
        this.rabbitRightFoot.addBox(-1.0f, 5.5f, -3.7f, 2, 1, 7);
        this.rabbitRightFoot.setRotationPoint(-3.0f, 17.5f, 3.7f);
        this.rabbitRightFoot.mirror = true;
        this.setRotationOffset(this.rabbitRightFoot, 0.0f, 0.0f, 0.0f);
        this.rabbitLeftThigh = new ModelRenderer(this, 30, 15);
        this.rabbitLeftThigh.addBox(-1.0f, 0.0f, 0.0f, 2, 4, 5);
        this.rabbitLeftThigh.setRotationPoint(3.0f, 17.5f, 3.7f);
        this.rabbitLeftThigh.mirror = true;
        this.setRotationOffset(this.rabbitLeftThigh, -0.34906584f, 0.0f, 0.0f);
        this.rabbitRightThigh = new ModelRenderer(this, 16, 15);
        this.rabbitRightThigh.addBox(-1.0f, 0.0f, 0.0f, 2, 4, 5);
        this.rabbitRightThigh.setRotationPoint(-3.0f, 17.5f, 3.7f);
        this.rabbitRightThigh.mirror = true;
        this.setRotationOffset(this.rabbitRightThigh, -0.34906584f, 0.0f, 0.0f);
        this.rabbitBody = new ModelRenderer(this, 0, 0);
        this.rabbitBody.addBox(-3.0f, -2.0f, -10.0f, 6, 5, 10);
        this.rabbitBody.setRotationPoint(0.0f, 19.0f, 8.0f);
        this.rabbitBody.mirror = true;
        this.setRotationOffset(this.rabbitBody, -0.34906584f, 0.0f, 0.0f);
        this.rabbitLeftArm = new ModelRenderer(this, 8, 15);
        this.rabbitLeftArm.addBox(-1.0f, 0.0f, -1.0f, 2, 7, 2);
        this.rabbitLeftArm.setRotationPoint(3.0f, 17.0f, -1.0f);
        this.rabbitLeftArm.mirror = true;
        this.setRotationOffset(this.rabbitLeftArm, -0.17453292f, 0.0f, 0.0f);
        this.rabbitRightArm = new ModelRenderer(this, 0, 15);
        this.rabbitRightArm.addBox(-1.0f, 0.0f, -1.0f, 2, 7, 2);
        this.rabbitRightArm.setRotationPoint(-3.0f, 17.0f, -1.0f);
        this.rabbitRightArm.mirror = true;
        this.setRotationOffset(this.rabbitRightArm, -0.17453292f, 0.0f, 0.0f);
        this.rabbitHead = new ModelRenderer(this, 32, 0);
        this.rabbitHead.addBox(-2.5f, -4.0f, -5.0f, 5, 4, 5);
        this.rabbitHead.setRotationPoint(0.0f, 16.0f, -1.0f);
        this.rabbitHead.mirror = true;
        this.setRotationOffset(this.rabbitHead, 0.0f, 0.0f, 0.0f);
        this.rabbitRightEar = new ModelRenderer(this, 52, 0);
        this.rabbitRightEar.addBox(-2.5f, -9.0f, -1.0f, 2, 5, 1);
        this.rabbitRightEar.setRotationPoint(0.0f, 16.0f, -1.0f);
        this.rabbitRightEar.mirror = true;
        this.setRotationOffset(this.rabbitRightEar, 0.0f, -0.2617994f, 0.0f);
        this.rabbitLeftEar = new ModelRenderer(this, 58, 0);
        this.rabbitLeftEar.addBox(0.5f, -9.0f, -1.0f, 2, 5, 1);
        this.rabbitLeftEar.setRotationPoint(0.0f, 16.0f, -1.0f);
        this.rabbitLeftEar.mirror = true;
        this.setRotationOffset(this.rabbitLeftEar, 0.0f, 0.2617994f, 0.0f);
        this.rabbitTail = new ModelRenderer(this, 52, 6);
        this.rabbitTail.addBox(-1.5f, -1.5f, 0.0f, 3, 3, 2);
        this.rabbitTail.setRotationPoint(0.0f, 20.0f, 7.0f);
        this.rabbitTail.mirror = true;
        this.setRotationOffset(this.rabbitTail, -0.3490659f, 0.0f, 0.0f);
        this.rabbitNose = new ModelRenderer(this, 32, 9);
        this.rabbitNose.addBox(-0.5f, -2.5f, -5.5f, 1, 1, 1);
        this.rabbitNose.setRotationPoint(0.0f, 16.0f, -1.0f);
        this.rabbitNose.mirror = true;
        this.setRotationOffset(this.rabbitNose, 0.0f, 0.0f, 0.0f);
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllllIIlllIIlllIIllIlII, final float llllllllllllllIIlllIIlllIIllIIll, final float llllllllllllllIIlllIIlllIIlIlIlI, final float llllllllllllllIIlllIIlllIIllIIIl, final float llllllllllllllIIlllIIlllIIllIIII, final float llllllllllllllIIlllIIlllIIlIllll, final Entity llllllllllllllIIlllIIlllIIlIIlll) {
        final float llllllllllllllIIlllIIlllIIlIllIl = llllllllllllllIIlllIIlllIIlIlIlI - llllllllllllllIIlllIIlllIIlIIlll.ticksExisted;
        final EntityRabbit llllllllllllllIIlllIIlllIIlIllII = (EntityRabbit)llllllllllllllIIlllIIlllIIlIIlll;
        final ModelRenderer rabbitNose = this.rabbitNose;
        final ModelRenderer rabbitHead = this.rabbitHead;
        final ModelRenderer rabbitRightEar = this.rabbitRightEar;
        final ModelRenderer rabbitLeftEar = this.rabbitLeftEar;
        final float n = llllllllllllllIIlllIIlllIIllIIII * 0.017453292f;
        rabbitLeftEar.rotateAngleX = n;
        rabbitRightEar.rotateAngleX = n;
        rabbitHead.rotateAngleX = n;
        rabbitNose.rotateAngleX = n;
        final ModelRenderer rabbitNose2 = this.rabbitNose;
        final ModelRenderer rabbitHead2 = this.rabbitHead;
        final float n2 = llllllllllllllIIlllIIlllIIllIIIl * 0.017453292f;
        rabbitHead2.rotateAngleY = n2;
        rabbitNose2.rotateAngleY = n2;
        this.rabbitRightEar.rotateAngleY = this.rabbitNose.rotateAngleY - 0.2617994f;
        this.rabbitLeftEar.rotateAngleY = this.rabbitNose.rotateAngleY + 0.2617994f;
        this.field_178701_m = MathHelper.sin(llllllllllllllIIlllIIlllIIlIllII.func_175521_o(llllllllllllllIIlllIIlllIIlIllIl) * 3.1415927f);
        final ModelRenderer rabbitLeftThigh = this.rabbitLeftThigh;
        final ModelRenderer rabbitRightThigh = this.rabbitRightThigh;
        final float n3 = (this.field_178701_m * 50.0f - 21.0f) * 0.017453292f;
        rabbitRightThigh.rotateAngleX = n3;
        rabbitLeftThigh.rotateAngleX = n3;
        final ModelRenderer rabbitLeftFoot = this.rabbitLeftFoot;
        final ModelRenderer rabbitRightFoot = this.rabbitRightFoot;
        final float n4 = this.field_178701_m * 50.0f * 0.017453292f;
        rabbitRightFoot.rotateAngleX = n4;
        rabbitLeftFoot.rotateAngleX = n4;
        final ModelRenderer rabbitLeftArm = this.rabbitLeftArm;
        final ModelRenderer rabbitRightArm = this.rabbitRightArm;
        final float n5 = (this.field_178701_m * -40.0f - 11.0f) * 0.017453292f;
        rabbitRightArm.rotateAngleX = n5;
        rabbitLeftArm.rotateAngleX = n5;
    }
    
    private void setRotationOffset(final ModelRenderer llllllllllllllIIlllIIlllIlIllIll, final float llllllllllllllIIlllIIlllIlIllllI, final float llllllllllllllIIlllIIlllIlIllIIl, final float llllllllllllllIIlllIIlllIlIlllII) {
        llllllllllllllIIlllIIlllIlIllIll.rotateAngleX = llllllllllllllIIlllIIlllIlIllllI;
        llllllllllllllIIlllIIlllIlIllIll.rotateAngleY = llllllllllllllIIlllIIlllIlIllIIl;
        llllllllllllllIIlllIIlllIlIllIll.rotateAngleZ = llllllllllllllIIlllIIlllIlIlllII;
    }
}
