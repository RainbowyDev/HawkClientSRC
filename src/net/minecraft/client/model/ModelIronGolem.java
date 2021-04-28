package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.entity.monster.*;

public class ModelIronGolem extends ModelBase
{
    public /* synthetic */ ModelRenderer ironGolemRightArm;
    public /* synthetic */ ModelRenderer ironGolemLeftLeg;
    public /* synthetic */ ModelRenderer ironGolemHead;
    public /* synthetic */ ModelRenderer ironGolemBody;
    public /* synthetic */ ModelRenderer ironGolemRightLeg;
    public /* synthetic */ ModelRenderer ironGolemLeftArm;
    
    @Override
    public void setRotationAngles(final float lllllllllllllllllIllIlllIlllllll, final float lllllllllllllllllIllIlllIlllIllI, final float lllllllllllllllllIllIlllIlllllIl, final float lllllllllllllllllIllIlllIlllIlIl, final float lllllllllllllllllIllIlllIlllIlII, final float lllllllllllllllllIllIlllIllllIlI, final Entity lllllllllllllllllIllIlllIllllIIl) {
        this.ironGolemHead.rotateAngleY = lllllllllllllllllIllIlllIlllIlIl / 57.295776f;
        this.ironGolemHead.rotateAngleX = lllllllllllllllllIllIlllIlllIlII / 57.295776f;
        this.ironGolemLeftLeg.rotateAngleX = -1.5f * this.func_78172_a(lllllllllllllllllIllIlllIlllllll, 13.0f) * lllllllllllllllllIllIlllIlllIllI;
        this.ironGolemRightLeg.rotateAngleX = 1.5f * this.func_78172_a(lllllllllllllllllIllIlllIlllllll, 13.0f) * lllllllllllllllllIllIlllIlllIllI;
        this.ironGolemLeftLeg.rotateAngleY = 0.0f;
        this.ironGolemRightLeg.rotateAngleY = 0.0f;
    }
    
    @Override
    public void render(final Entity lllllllllllllllllIllIllllIIIllII, final float lllllllllllllllllIllIllllIIlIIll, final float lllllllllllllllllIllIllllIIIlIlI, final float lllllllllllllllllIllIllllIIIlIIl, final float lllllllllllllllllIllIllllIIlIIII, final float lllllllllllllllllIllIllllIIIIlll, final float lllllllllllllllllIllIllllIIIlllI) {
        this.setRotationAngles(lllllllllllllllllIllIllllIIlIIll, lllllllllllllllllIllIllllIIIlIlI, lllllllllllllllllIllIllllIIIlIIl, lllllllllllllllllIllIllllIIlIIII, lllllllllllllllllIllIllllIIIIlll, lllllllllllllllllIllIllllIIIlllI, lllllllllllllllllIllIllllIIIllII);
        this.ironGolemHead.render(lllllllllllllllllIllIllllIIIlllI);
        this.ironGolemBody.render(lllllllllllllllllIllIllllIIIlllI);
        this.ironGolemLeftLeg.render(lllllllllllllllllIllIllllIIIlllI);
        this.ironGolemRightLeg.render(lllllllllllllllllIllIllllIIIlllI);
        this.ironGolemRightArm.render(lllllllllllllllllIllIllllIIIlllI);
        this.ironGolemLeftArm.render(lllllllllllllllllIllIllllIIIlllI);
    }
    
    static {
        __OBFID = "CL_00000863";
    }
    
    public ModelIronGolem(final float lllllllllllllllllIllIllllIlIIIIl, final float lllllllllllllllllIllIllllIlIIlIl) {
        final short lllllllllllllllllIllIllllIlIIlII = 128;
        final short lllllllllllllllllIllIllllIlIIIll = 128;
        this.ironGolemHead = new ModelRenderer(this).setTextureSize(lllllllllllllllllIllIllllIlIIlII, lllllllllllllllllIllIllllIlIIIll);
        this.ironGolemHead.setRotationPoint(0.0f, 0.0f + lllllllllllllllllIllIllllIlIIlIl, -2.0f);
        this.ironGolemHead.setTextureOffset(0, 0).addBox(-4.0f, -12.0f, -5.5f, 8, 10, 8, lllllllllllllllllIllIllllIlIIIIl);
        this.ironGolemHead.setTextureOffset(24, 0).addBox(-1.0f, -5.0f, -7.5f, 2, 4, 2, lllllllllllllllllIllIllllIlIIIIl);
        this.ironGolemBody = new ModelRenderer(this).setTextureSize(lllllllllllllllllIllIllllIlIIlII, lllllllllllllllllIllIllllIlIIIll);
        this.ironGolemBody.setRotationPoint(0.0f, 0.0f + lllllllllllllllllIllIllllIlIIlIl, 0.0f);
        this.ironGolemBody.setTextureOffset(0, 40).addBox(-9.0f, -2.0f, -6.0f, 18, 12, 11, lllllllllllllllllIllIllllIlIIIIl);
        this.ironGolemBody.setTextureOffset(0, 70).addBox(-4.5f, 10.0f, -3.0f, 9, 5, 6, lllllllllllllllllIllIllllIlIIIIl + 0.5f);
        this.ironGolemRightArm = new ModelRenderer(this).setTextureSize(lllllllllllllllllIllIllllIlIIlII, lllllllllllllllllIllIllllIlIIIll);
        this.ironGolemRightArm.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.ironGolemRightArm.setTextureOffset(60, 21).addBox(-13.0f, -2.5f, -3.0f, 4, 30, 6, lllllllllllllllllIllIllllIlIIIIl);
        this.ironGolemLeftArm = new ModelRenderer(this).setTextureSize(lllllllllllllllllIllIllllIlIIlII, lllllllllllllllllIllIllllIlIIIll);
        this.ironGolemLeftArm.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.ironGolemLeftArm.setTextureOffset(60, 58).addBox(9.0f, -2.5f, -3.0f, 4, 30, 6, lllllllllllllllllIllIllllIlIIIIl);
        this.ironGolemLeftLeg = new ModelRenderer(this, 0, 22).setTextureSize(lllllllllllllllllIllIllllIlIIlII, lllllllllllllllllIllIllllIlIIIll);
        this.ironGolemLeftLeg.setRotationPoint(-4.0f, 18.0f + lllllllllllllllllIllIllllIlIIlIl, 0.0f);
        this.ironGolemLeftLeg.setTextureOffset(37, 0).addBox(-3.5f, -3.0f, -3.0f, 6, 16, 5, lllllllllllllllllIllIllllIlIIIIl);
        this.ironGolemRightLeg = new ModelRenderer(this, 0, 22).setTextureSize(lllllllllllllllllIllIllllIlIIlII, lllllllllllllllllIllIllllIlIIIll);
        this.ironGolemRightLeg.mirror = true;
        this.ironGolemRightLeg.setTextureOffset(60, 0).setRotationPoint(5.0f, 18.0f + lllllllllllllllllIllIllllIlIIlIl, 0.0f);
        this.ironGolemRightLeg.addBox(-3.5f, -3.0f, -3.0f, 6, 16, 5, lllllllllllllllllIllIllllIlIIIIl);
    }
    
    private float func_78172_a(final float lllllllllllllllllIllIlllIlIllIII, final float lllllllllllllllllIllIlllIlIlIlll) {
        return (Math.abs(lllllllllllllllllIllIlllIlIllIII % lllllllllllllllllIllIlllIlIlIlll - lllllllllllllllllIllIlllIlIlIlll * 0.5f) - lllllllllllllllllIllIlllIlIlIlll * 0.25f) / (lllllllllllllllllIllIlllIlIlIlll * 0.25f);
    }
    
    public ModelIronGolem(final float lllllllllllllllllIllIllllIlIllll) {
        this(lllllllllllllllllIllIllllIlIllll, -7.0f);
    }
    
    @Override
    public void setLivingAnimations(final EntityLivingBase lllllllllllllllllIllIlllIllIlIlI, final float lllllllllllllllllIllIlllIllIIIIl, final float lllllllllllllllllIllIlllIllIlIII, final float lllllllllllllllllIllIlllIlIlllll) {
        final EntityIronGolem lllllllllllllllllIllIlllIllIIllI = (EntityIronGolem)lllllllllllllllllIllIlllIllIlIlI;
        final int lllllllllllllllllIllIlllIllIIlIl = lllllllllllllllllIllIlllIllIIllI.getAttackTimer();
        if (lllllllllllllllllIllIlllIllIIlIl > 0) {
            this.ironGolemRightArm.rotateAngleX = -2.0f + 1.5f * this.func_78172_a(lllllllllllllllllIllIlllIllIIlIl - lllllllllllllllllIllIlllIlIlllll, 10.0f);
            this.ironGolemLeftArm.rotateAngleX = -2.0f + 1.5f * this.func_78172_a(lllllllllllllllllIllIlllIllIIlIl - lllllllllllllllllIllIlllIlIlllll, 10.0f);
        }
        else {
            final int lllllllllllllllllIllIlllIllIIlII = lllllllllllllllllIllIlllIllIIllI.getHoldRoseTick();
            if (lllllllllllllllllIllIlllIllIIlII > 0) {
                this.ironGolemRightArm.rotateAngleX = -0.8f + 0.025f * this.func_78172_a((float)lllllllllllllllllIllIlllIllIIlII, 70.0f);
                this.ironGolemLeftArm.rotateAngleX = 0.0f;
            }
            else {
                this.ironGolemRightArm.rotateAngleX = (-0.2f + 1.5f * this.func_78172_a(lllllllllllllllllIllIlllIllIIIIl, 13.0f)) * lllllllllllllllllIllIlllIllIlIII;
                this.ironGolemLeftArm.rotateAngleX = (-0.2f - 1.5f * this.func_78172_a(lllllllllllllllllIllIlllIllIIIIl, 13.0f)) * lllllllllllllllllIllIlllIllIlIII;
            }
        }
    }
    
    public ModelIronGolem() {
        this(0.0f);
    }
}
