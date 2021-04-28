package net.minecraft.client.model;

import net.minecraft.entity.*;

public class ModelEnderman extends ModelBiped
{
    public /* synthetic */ boolean isCarrying;
    public /* synthetic */ boolean isAttacking;
    
    public ModelEnderman(final float lllllllllllllllllIIlIlIIlIllllIl) {
        super(0.0f, -14.0f, 64, 32);
        final float lllllllllllllllllIIlIlIIlIllllII = -14.0f;
        this.bipedHeadwear = new ModelRenderer(this, 0, 16);
        this.bipedHeadwear.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, lllllllllllllllllIIlIlIIlIllllIl - 0.5f);
        this.bipedHeadwear.setRotationPoint(0.0f, 0.0f + lllllllllllllllllIIlIlIIlIllllII, 0.0f);
        this.bipedBody = new ModelRenderer(this, 32, 16);
        this.bipedBody.addBox(-4.0f, 0.0f, -2.0f, 8, 12, 4, lllllllllllllllllIIlIlIIlIllllIl);
        this.bipedBody.setRotationPoint(0.0f, 0.0f + lllllllllllllllllIIlIlIIlIllllII, 0.0f);
        this.bipedRightArm = new ModelRenderer(this, 56, 0);
        this.bipedRightArm.addBox(-1.0f, -2.0f, -1.0f, 2, 30, 2, lllllllllllllllllIIlIlIIlIllllIl);
        this.bipedRightArm.setRotationPoint(-3.0f, 2.0f + lllllllllllllllllIIlIlIIlIllllII, 0.0f);
        this.bipedLeftArm = new ModelRenderer(this, 56, 0);
        this.bipedLeftArm.mirror = true;
        this.bipedLeftArm.addBox(-1.0f, -2.0f, -1.0f, 2, 30, 2, lllllllllllllllllIIlIlIIlIllllIl);
        this.bipedLeftArm.setRotationPoint(5.0f, 2.0f + lllllllllllllllllIIlIlIIlIllllII, 0.0f);
        this.bipedRightLeg = new ModelRenderer(this, 56, 0);
        this.bipedRightLeg.addBox(-1.0f, 0.0f, -1.0f, 2, 30, 2, lllllllllllllllllIIlIlIIlIllllIl);
        this.bipedRightLeg.setRotationPoint(-2.0f, 12.0f + lllllllllllllllllIIlIlIIlIllllII, 0.0f);
        this.bipedLeftLeg = new ModelRenderer(this, 56, 0);
        this.bipedLeftLeg.mirror = true;
        this.bipedLeftLeg.addBox(-1.0f, 0.0f, -1.0f, 2, 30, 2, lllllllllllllllllIIlIlIIlIllllIl);
        this.bipedLeftLeg.setRotationPoint(2.0f, 12.0f + lllllllllllllllllIIlIlIIlIllllII, 0.0f);
    }
    
    static {
        __OBFID = "CL_00000838";
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllllllllIIlIlIIlIlIllII, final float lllllllllllllllllIIlIlIIlIlIIIII, final float lllllllllllllllllIIlIlIIlIIlllll, final float lllllllllllllllllIIlIlIIlIIllllI, final float lllllllllllllllllIIlIlIIlIlIlIII, final float lllllllllllllllllIIlIlIIlIIlllII, final Entity lllllllllllllllllIIlIlIIlIIllIll) {
        super.setRotationAngles(lllllllllllllllllIIlIlIIlIlIllII, lllllllllllllllllIIlIlIIlIlIIIII, lllllllllllllllllIIlIlIIlIIlllll, lllllllllllllllllIIlIlIIlIIllllI, lllllllllllllllllIIlIlIIlIlIlIII, lllllllllllllllllIIlIlIIlIIlllII, lllllllllllllllllIIlIlIIlIIllIll);
        this.bipedHead.showModel = true;
        final float lllllllllllllllllIIlIlIIlIlIIlIl = -14.0f;
        this.bipedBody.rotateAngleX = 0.0f;
        this.bipedBody.rotationPointY = lllllllllllllllllIIlIlIIlIlIIlIl;
        this.bipedBody.rotationPointZ = -0.0f;
        final ModelRenderer bipedRightLeg = this.bipedRightLeg;
        bipedRightLeg.rotateAngleX -= 0.0f;
        final ModelRenderer bipedLeftLeg = this.bipedLeftLeg;
        bipedLeftLeg.rotateAngleX -= 0.0f;
        this.bipedRightArm.rotateAngleX *= 0.5;
        this.bipedLeftArm.rotateAngleX *= 0.5;
        this.bipedRightLeg.rotateAngleX *= 0.5;
        this.bipedLeftLeg.rotateAngleX *= 0.5;
        final float lllllllllllllllllIIlIlIIlIlIIlII = 0.4f;
        if (this.bipedRightArm.rotateAngleX > lllllllllllllllllIIlIlIIlIlIIlII) {
            this.bipedRightArm.rotateAngleX = lllllllllllllllllIIlIlIIlIlIIlII;
        }
        if (this.bipedLeftArm.rotateAngleX > lllllllllllllllllIIlIlIIlIlIIlII) {
            this.bipedLeftArm.rotateAngleX = lllllllllllllllllIIlIlIIlIlIIlII;
        }
        if (this.bipedRightArm.rotateAngleX < -lllllllllllllllllIIlIlIIlIlIIlII) {
            this.bipedRightArm.rotateAngleX = -lllllllllllllllllIIlIlIIlIlIIlII;
        }
        if (this.bipedLeftArm.rotateAngleX < -lllllllllllllllllIIlIlIIlIlIIlII) {
            this.bipedLeftArm.rotateAngleX = -lllllllllllllllllIIlIlIIlIlIIlII;
        }
        if (this.bipedRightLeg.rotateAngleX > lllllllllllllllllIIlIlIIlIlIIlII) {
            this.bipedRightLeg.rotateAngleX = lllllllllllllllllIIlIlIIlIlIIlII;
        }
        if (this.bipedLeftLeg.rotateAngleX > lllllllllllllllllIIlIlIIlIlIIlII) {
            this.bipedLeftLeg.rotateAngleX = lllllllllllllllllIIlIlIIlIlIIlII;
        }
        if (this.bipedRightLeg.rotateAngleX < -lllllllllllllllllIIlIlIIlIlIIlII) {
            this.bipedRightLeg.rotateAngleX = -lllllllllllllllllIIlIlIIlIlIIlII;
        }
        if (this.bipedLeftLeg.rotateAngleX < -lllllllllllllllllIIlIlIIlIlIIlII) {
            this.bipedLeftLeg.rotateAngleX = -lllllllllllllllllIIlIlIIlIlIIlII;
        }
        if (this.isCarrying) {
            this.bipedRightArm.rotateAngleX = -0.5f;
            this.bipedLeftArm.rotateAngleX = -0.5f;
            this.bipedRightArm.rotateAngleZ = 0.05f;
            this.bipedLeftArm.rotateAngleZ = -0.05f;
        }
        this.bipedRightArm.rotationPointZ = 0.0f;
        this.bipedLeftArm.rotationPointZ = 0.0f;
        this.bipedRightLeg.rotationPointZ = 0.0f;
        this.bipedLeftLeg.rotationPointZ = 0.0f;
        this.bipedRightLeg.rotationPointY = 9.0f + lllllllllllllllllIIlIlIIlIlIIlIl;
        this.bipedLeftLeg.rotationPointY = 9.0f + lllllllllllllllllIIlIlIIlIlIIlIl;
        this.bipedHead.rotationPointZ = -0.0f;
        this.bipedHead.rotationPointY = lllllllllllllllllIIlIlIIlIlIIlIl + 1.0f;
        this.bipedHeadwear.rotationPointX = this.bipedHead.rotationPointX;
        this.bipedHeadwear.rotationPointY = this.bipedHead.rotationPointY;
        this.bipedHeadwear.rotationPointZ = this.bipedHead.rotationPointZ;
        this.bipedHeadwear.rotateAngleX = this.bipedHead.rotateAngleX;
        this.bipedHeadwear.rotateAngleY = this.bipedHead.rotateAngleY;
        this.bipedHeadwear.rotateAngleZ = this.bipedHead.rotateAngleZ;
        if (this.isAttacking) {
            final float lllllllllllllllllIIlIlIIlIlIIIll = 1.0f;
            final ModelRenderer bipedHead = this.bipedHead;
            bipedHead.rotationPointY -= lllllllllllllllllIIlIlIIlIlIIIll * 5.0f;
        }
    }
}
