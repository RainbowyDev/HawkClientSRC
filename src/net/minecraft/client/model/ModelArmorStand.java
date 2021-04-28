package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.client.renderer.*;

public class ModelArmorStand extends ModelArmorStandArmor
{
    public /* synthetic */ ModelRenderer standWaist;
    public /* synthetic */ ModelRenderer standBase;
    public /* synthetic */ ModelRenderer standRightSide;
    public /* synthetic */ ModelRenderer standLeftSide;
    
    @Override
    public void setRotationAngles(final float lllllllllllllllIIllIIIllIIllIIlI, final float lllllllllllllllIIllIIIllIIllIIIl, final float lllllllllllllllIIllIIIllIIllIIII, final float lllllllllllllllIIllIIIllIIlIllll, final float lllllllllllllllIIllIIIllIIlIIIlI, final float lllllllllllllllIIllIIIllIIlIIIIl, final Entity lllllllllllllllIIllIIIllIIlIllII) {
        super.setRotationAngles(lllllllllllllllIIllIIIllIIllIIlI, lllllllllllllllIIllIIIllIIllIIIl, lllllllllllllllIIllIIIllIIllIIII, lllllllllllllllIIllIIIllIIlIllll, lllllllllllllllIIllIIIllIIlIIIlI, lllllllllllllllIIllIIIllIIlIIIIl, lllllllllllllllIIllIIIllIIlIllII);
        if (lllllllllllllllIIllIIIllIIlIllII instanceof EntityArmorStand) {
            final EntityArmorStand lllllllllllllllIIllIIIllIIlIlIll = (EntityArmorStand)lllllllllllllllIIllIIIllIIlIllII;
            this.bipedLeftArm.showModel = lllllllllllllllIIllIIIllIIlIlIll.getShowArms();
            this.bipedRightArm.showModel = lllllllllllllllIIllIIIllIIlIlIll.getShowArms();
            this.standBase.showModel = !lllllllllllllllIIllIIIllIIlIlIll.hasNoBasePlate();
            this.bipedLeftLeg.setRotationPoint(1.9f, 12.0f, 0.0f);
            this.bipedRightLeg.setRotationPoint(-1.9f, 12.0f, 0.0f);
            this.standRightSide.rotateAngleX = 0.017453292f * lllllllllllllllIIllIIIllIIlIlIll.getBodyRotation().func_179415_b();
            this.standRightSide.rotateAngleY = 0.017453292f * lllllllllllllllIIllIIIllIIlIlIll.getBodyRotation().func_179416_c();
            this.standRightSide.rotateAngleZ = 0.017453292f * lllllllllllllllIIllIIIllIIlIlIll.getBodyRotation().func_179413_d();
            this.standLeftSide.rotateAngleX = 0.017453292f * lllllllllllllllIIllIIIllIIlIlIll.getBodyRotation().func_179415_b();
            this.standLeftSide.rotateAngleY = 0.017453292f * lllllllllllllllIIllIIIllIIlIlIll.getBodyRotation().func_179416_c();
            this.standLeftSide.rotateAngleZ = 0.017453292f * lllllllllllllllIIllIIIllIIlIlIll.getBodyRotation().func_179413_d();
            this.standWaist.rotateAngleX = 0.017453292f * lllllllllllllllIIllIIIllIIlIlIll.getBodyRotation().func_179415_b();
            this.standWaist.rotateAngleY = 0.017453292f * lllllllllllllllIIllIIIllIIlIlIll.getBodyRotation().func_179416_c();
            this.standWaist.rotateAngleZ = 0.017453292f * lllllllllllllllIIllIIIllIIlIlIll.getBodyRotation().func_179413_d();
            final float lllllllllllllllIIllIIIllIIlIlIlI = (lllllllllllllllIIllIIIllIIlIlIll.getLeftLegRotation().func_179415_b() + lllllllllllllllIIllIIIllIIlIlIll.getRightLegRotation().func_179415_b()) / 2.0f;
            final float lllllllllllllllIIllIIIllIIlIlIIl = (lllllllllllllllIIllIIIllIIlIlIll.getLeftLegRotation().func_179416_c() + lllllllllllllllIIllIIIllIIlIlIll.getRightLegRotation().func_179416_c()) / 2.0f;
            final float lllllllllllllllIIllIIIllIIlIlIII = (lllllllllllllllIIllIIIllIIlIlIll.getLeftLegRotation().func_179413_d() + lllllllllllllllIIllIIIllIIlIlIll.getRightLegRotation().func_179413_d()) / 2.0f;
            this.standBase.rotateAngleX = 0.0f;
            this.standBase.rotateAngleY = 0.017453292f * -lllllllllllllllIIllIIIllIIlIllII.rotationYaw;
            this.standBase.rotateAngleZ = 0.0f;
        }
    }
    
    public ModelArmorStand(final float lllllllllllllllIIllIIIllIlIIIIII) {
        super(lllllllllllllllIIllIIIllIlIIIIII, 64, 64);
        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.addBox(-1.0f, -7.0f, -1.0f, 2, 7, 2, lllllllllllllllIIllIIIllIlIIIIII);
        this.bipedHead.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bipedBody = new ModelRenderer(this, 0, 26);
        this.bipedBody.addBox(-6.0f, 0.0f, -1.5f, 12, 3, 3, lllllllllllllllIIllIIIllIlIIIIII);
        this.bipedBody.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bipedRightArm = new ModelRenderer(this, 24, 0);
        this.bipedRightArm.addBox(-2.0f, -2.0f, -1.0f, 2, 12, 2, lllllllllllllllIIllIIIllIlIIIIII);
        this.bipedRightArm.setRotationPoint(-5.0f, 2.0f, 0.0f);
        this.bipedLeftArm = new ModelRenderer(this, 32, 16);
        this.bipedLeftArm.mirror = true;
        this.bipedLeftArm.addBox(0.0f, -2.0f, -1.0f, 2, 12, 2, lllllllllllllllIIllIIIllIlIIIIII);
        this.bipedLeftArm.setRotationPoint(5.0f, 2.0f, 0.0f);
        this.bipedRightLeg = new ModelRenderer(this, 8, 0);
        this.bipedRightLeg.addBox(-1.0f, 0.0f, -1.0f, 2, 11, 2, lllllllllllllllIIllIIIllIlIIIIII);
        this.bipedRightLeg.setRotationPoint(-1.9f, 12.0f, 0.0f);
        this.bipedLeftLeg = new ModelRenderer(this, 40, 16);
        this.bipedLeftLeg.mirror = true;
        this.bipedLeftLeg.addBox(-1.0f, 0.0f, -1.0f, 2, 11, 2, lllllllllllllllIIllIIIllIlIIIIII);
        this.bipedLeftLeg.setRotationPoint(1.9f, 12.0f, 0.0f);
        this.standRightSide = new ModelRenderer(this, 16, 0);
        this.standRightSide.addBox(-3.0f, 3.0f, -1.0f, 2, 7, 2, lllllllllllllllIIllIIIllIlIIIIII);
        this.standRightSide.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.standRightSide.showModel = true;
        this.standLeftSide = new ModelRenderer(this, 48, 16);
        this.standLeftSide.addBox(1.0f, 3.0f, -1.0f, 2, 7, 2, lllllllllllllllIIllIIIllIlIIIIII);
        this.standLeftSide.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.standWaist = new ModelRenderer(this, 0, 48);
        this.standWaist.addBox(-4.0f, 10.0f, -1.0f, 8, 2, 2, lllllllllllllllIIllIIIllIlIIIIII);
        this.standWaist.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.standBase = new ModelRenderer(this, 0, 32);
        this.standBase.addBox(-6.0f, 11.0f, -6.0f, 12, 1, 12, lllllllllllllllIIllIIIllIlIIIIII);
        this.standBase.setRotationPoint(0.0f, 12.0f, 0.0f);
    }
    
    @Override
    public void render(final Entity lllllllllllllllIIllIIIllIIIIlIII, final float lllllllllllllllIIllIIIllIIIlIIII, final float lllllllllllllllIIllIIIllIIIIllll, final float lllllllllllllllIIllIIIllIIIIlllI, final float lllllllllllllllIIllIIIllIIIIIlII, final float lllllllllllllllIIllIIIllIIIIllII, final float lllllllllllllllIIllIIIllIIIIIIlI) {
        super.render(lllllllllllllllIIllIIIllIIIIlIII, lllllllllllllllIIllIIIllIIIlIIII, lllllllllllllllIIllIIIllIIIIllll, lllllllllllllllIIllIIIllIIIIlllI, lllllllllllllllIIllIIIllIIIIIlII, lllllllllllllllIIllIIIllIIIIllII, lllllllllllllllIIllIIIllIIIIIIlI);
        GlStateManager.pushMatrix();
        if (this.isChild) {
            final float lllllllllllllllIIllIIIllIIIIlIlI = 2.0f;
            GlStateManager.scale(1.0f / lllllllllllllllIIllIIIllIIIIlIlI, 1.0f / lllllllllllllllIIllIIIllIIIIlIlI, 1.0f / lllllllllllllllIIllIIIllIIIIlIlI);
            GlStateManager.translate(0.0f, 24.0f * lllllllllllllllIIllIIIllIIIIIIlI, 0.0f);
            this.standRightSide.render(lllllllllllllllIIllIIIllIIIIIIlI);
            this.standLeftSide.render(lllllllllllllllIIllIIIllIIIIIIlI);
            this.standWaist.render(lllllllllllllllIIllIIIllIIIIIIlI);
            this.standBase.render(lllllllllllllllIIllIIIllIIIIIIlI);
        }
        else {
            if (lllllllllllllllIIllIIIllIIIIlIII.isSneaking()) {
                GlStateManager.translate(0.0f, 0.2f, 0.0f);
            }
            this.standRightSide.render(lllllllllllllllIIllIIIllIIIIIIlI);
            this.standLeftSide.render(lllllllllllllllIIllIIIllIIIIIIlI);
            this.standWaist.render(lllllllllllllllIIllIIIllIIIIIIlI);
            this.standBase.render(lllllllllllllllIIllIIIllIIIIIIlI);
        }
        GlStateManager.popMatrix();
    }
    
    @Override
    public void postRenderHiddenArm(final float lllllllllllllllIIllIIIlIlllllIIl) {
        final boolean lllllllllllllllIIllIIIlIlllllIll = this.bipedRightArm.showModel;
        this.bipedRightArm.showModel = true;
        super.postRenderHiddenArm(lllllllllllllllIIllIIIlIlllllIIl);
        this.bipedRightArm.showModel = lllllllllllllllIIllIIIlIlllllIll;
    }
    
    public ModelArmorStand() {
        this(0.0f);
    }
    
    static {
        __OBFID = "CL_00002631";
    }
}
