package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelSpider extends ModelBase
{
    public /* synthetic */ ModelRenderer spiderHead;
    public /* synthetic */ ModelRenderer spiderLeg2;
    public /* synthetic */ ModelRenderer spiderBody;
    public /* synthetic */ ModelRenderer spiderLeg5;
    public /* synthetic */ ModelRenderer spiderLeg6;
    public /* synthetic */ ModelRenderer spiderLeg1;
    public /* synthetic */ ModelRenderer spiderLeg7;
    public /* synthetic */ ModelRenderer spiderLeg8;
    public /* synthetic */ ModelRenderer spiderNeck;
    public /* synthetic */ ModelRenderer spiderLeg4;
    public /* synthetic */ ModelRenderer spiderLeg3;
    
    static {
        __OBFID = "CL_00000860";
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllllllIIIlllllIlIIIlIlI, final float lllllllllllllllIIIlllllIIlllIllI, final float lllllllllllllllIIIlllllIlIIIlIII, final float lllllllllllllllIIIlllllIIlllIlIl, final float lllllllllllllllIIIlllllIIlllIlII, final float lllllllllllllllIIIlllllIlIIIIlIl, final Entity lllllllllllllllIIIlllllIlIIIIlII) {
        this.spiderHead.rotateAngleY = lllllllllllllllIIIlllllIIlllIlIl / 57.295776f;
        this.spiderHead.rotateAngleX = lllllllllllllllIIIlllllIIlllIlII / 57.295776f;
        final float lllllllllllllllIIIlllllIlIIIIIll = 0.7853982f;
        this.spiderLeg1.rotateAngleZ = -lllllllllllllllIIIlllllIlIIIIIll;
        this.spiderLeg2.rotateAngleZ = lllllllllllllllIIIlllllIlIIIIIll;
        this.spiderLeg3.rotateAngleZ = -lllllllllllllllIIIlllllIlIIIIIll * 0.74f;
        this.spiderLeg4.rotateAngleZ = lllllllllllllllIIIlllllIlIIIIIll * 0.74f;
        this.spiderLeg5.rotateAngleZ = -lllllllllllllllIIIlllllIlIIIIIll * 0.74f;
        this.spiderLeg6.rotateAngleZ = lllllllllllllllIIIlllllIlIIIIIll * 0.74f;
        this.spiderLeg7.rotateAngleZ = -lllllllllllllllIIIlllllIlIIIIIll;
        this.spiderLeg8.rotateAngleZ = lllllllllllllllIIIlllllIlIIIIIll;
        final float lllllllllllllllIIIlllllIlIIIIIlI = -0.0f;
        final float lllllllllllllllIIIlllllIlIIIIIIl = 0.3926991f;
        this.spiderLeg1.rotateAngleY = lllllllllllllllIIIlllllIlIIIIIIl * 2.0f + lllllllllllllllIIIlllllIlIIIIIlI;
        this.spiderLeg2.rotateAngleY = -lllllllllllllllIIIlllllIlIIIIIIl * 2.0f - lllllllllllllllIIIlllllIlIIIIIlI;
        this.spiderLeg3.rotateAngleY = lllllllllllllllIIIlllllIlIIIIIIl * 1.0f + lllllllllllllllIIIlllllIlIIIIIlI;
        this.spiderLeg4.rotateAngleY = -lllllllllllllllIIIlllllIlIIIIIIl * 1.0f - lllllllllllllllIIIlllllIlIIIIIlI;
        this.spiderLeg5.rotateAngleY = -lllllllllllllllIIIlllllIlIIIIIIl * 1.0f + lllllllllllllllIIIlllllIlIIIIIlI;
        this.spiderLeg6.rotateAngleY = lllllllllllllllIIIlllllIlIIIIIIl * 1.0f - lllllllllllllllIIIlllllIlIIIIIlI;
        this.spiderLeg7.rotateAngleY = -lllllllllllllllIIIlllllIlIIIIIIl * 2.0f + lllllllllllllllIIIlllllIlIIIIIlI;
        this.spiderLeg8.rotateAngleY = lllllllllllllllIIIlllllIlIIIIIIl * 2.0f - lllllllllllllllIIIlllllIlIIIIIlI;
        final float lllllllllllllllIIIlllllIlIIIIIII = -(MathHelper.cos(lllllllllllllllIIIlllllIlIIIlIlI * 0.6662f * 2.0f + 0.0f) * 0.4f) * lllllllllllllllIIIlllllIIlllIllI;
        final float lllllllllllllllIIIlllllIIlllllll = -(MathHelper.cos(lllllllllllllllIIIlllllIlIIIlIlI * 0.6662f * 2.0f + 3.1415927f) * 0.4f) * lllllllllllllllIIIlllllIIlllIllI;
        final float lllllllllllllllIIIlllllIIllllllI = -(MathHelper.cos(lllllllllllllllIIIlllllIlIIIlIlI * 0.6662f * 2.0f + 1.5707964f) * 0.4f) * lllllllllllllllIIIlllllIIlllIllI;
        final float lllllllllllllllIIIlllllIIlllllIl = -(MathHelper.cos(lllllllllllllllIIIlllllIlIIIlIlI * 0.6662f * 2.0f + 4.712389f) * 0.4f) * lllllllllllllllIIIlllllIIlllIllI;
        final float lllllllllllllllIIIlllllIIlllllII = Math.abs(MathHelper.sin(lllllllllllllllIIIlllllIlIIIlIlI * 0.6662f + 0.0f) * 0.4f) * lllllllllllllllIIIlllllIIlllIllI;
        final float lllllllllllllllIIIlllllIIllllIll = Math.abs(MathHelper.sin(lllllllllllllllIIIlllllIlIIIlIlI * 0.6662f + 3.1415927f) * 0.4f) * lllllllllllllllIIIlllllIIlllIllI;
        final float lllllllllllllllIIIlllllIIllllIlI = Math.abs(MathHelper.sin(lllllllllllllllIIIlllllIlIIIlIlI * 0.6662f + 1.5707964f) * 0.4f) * lllllllllllllllIIIlllllIIlllIllI;
        final float lllllllllllllllIIIlllllIIllllIIl = Math.abs(MathHelper.sin(lllllllllllllllIIIlllllIlIIIlIlI * 0.6662f + 4.712389f) * 0.4f) * lllllllllllllllIIIlllllIIlllIllI;
        final ModelRenderer spiderLeg1 = this.spiderLeg1;
        spiderLeg1.rotateAngleY += lllllllllllllllIIIlllllIlIIIIIII;
        final ModelRenderer spiderLeg2 = this.spiderLeg2;
        spiderLeg2.rotateAngleY += -lllllllllllllllIIIlllllIlIIIIIII;
        final ModelRenderer spiderLeg3 = this.spiderLeg3;
        spiderLeg3.rotateAngleY += lllllllllllllllIIIlllllIIlllllll;
        final ModelRenderer spiderLeg4 = this.spiderLeg4;
        spiderLeg4.rotateAngleY += -lllllllllllllllIIIlllllIIlllllll;
        final ModelRenderer spiderLeg5 = this.spiderLeg5;
        spiderLeg5.rotateAngleY += lllllllllllllllIIIlllllIIllllllI;
        final ModelRenderer spiderLeg6 = this.spiderLeg6;
        spiderLeg6.rotateAngleY += -lllllllllllllllIIIlllllIIllllllI;
        final ModelRenderer spiderLeg7 = this.spiderLeg7;
        spiderLeg7.rotateAngleY += lllllllllllllllIIIlllllIIlllllIl;
        final ModelRenderer spiderLeg8 = this.spiderLeg8;
        spiderLeg8.rotateAngleY += -lllllllllllllllIIIlllllIIlllllIl;
        final ModelRenderer spiderLeg9 = this.spiderLeg1;
        spiderLeg9.rotateAngleZ += lllllllllllllllIIIlllllIIlllllII;
        final ModelRenderer spiderLeg10 = this.spiderLeg2;
        spiderLeg10.rotateAngleZ += -lllllllllllllllIIIlllllIIlllllII;
        final ModelRenderer spiderLeg11 = this.spiderLeg3;
        spiderLeg11.rotateAngleZ += lllllllllllllllIIIlllllIIllllIll;
        final ModelRenderer spiderLeg12 = this.spiderLeg4;
        spiderLeg12.rotateAngleZ += -lllllllllllllllIIIlllllIIllllIll;
        final ModelRenderer spiderLeg13 = this.spiderLeg5;
        spiderLeg13.rotateAngleZ += lllllllllllllllIIIlllllIIllllIlI;
        final ModelRenderer spiderLeg14 = this.spiderLeg6;
        spiderLeg14.rotateAngleZ += -lllllllllllllllIIIlllllIIllllIlI;
        final ModelRenderer spiderLeg15 = this.spiderLeg7;
        spiderLeg15.rotateAngleZ += lllllllllllllllIIIlllllIIllllIIl;
        final ModelRenderer spiderLeg16 = this.spiderLeg8;
        spiderLeg16.rotateAngleZ += -lllllllllllllllIIIlllllIIllllIIl;
    }
    
    @Override
    public void render(final Entity lllllllllllllllIIIlllllIlIlIIIlI, final float lllllllllllllllIIIlllllIlIlIlIIl, final float lllllllllllllllIIIlllllIlIlIlIII, final float lllllllllllllllIIIlllllIlIIlllll, final float lllllllllllllllIIIlllllIlIlIIllI, final float lllllllllllllllIIIlllllIlIlIIlIl, final float lllllllllllllllIIIlllllIlIlIIlII) {
        this.setRotationAngles(lllllllllllllllIIIlllllIlIlIlIIl, lllllllllllllllIIIlllllIlIlIlIII, lllllllllllllllIIIlllllIlIIlllll, lllllllllllllllIIIlllllIlIlIIllI, lllllllllllllllIIIlllllIlIlIIlIl, lllllllllllllllIIIlllllIlIlIIlII, lllllllllllllllIIIlllllIlIlIIIlI);
        this.spiderHead.render(lllllllllllllllIIIlllllIlIlIIlII);
        this.spiderNeck.render(lllllllllllllllIIIlllllIlIlIIlII);
        this.spiderBody.render(lllllllllllllllIIIlllllIlIlIIlII);
        this.spiderLeg1.render(lllllllllllllllIIIlllllIlIlIIlII);
        this.spiderLeg2.render(lllllllllllllllIIIlllllIlIlIIlII);
        this.spiderLeg3.render(lllllllllllllllIIIlllllIlIlIIlII);
        this.spiderLeg4.render(lllllllllllllllIIIlllllIlIlIIlII);
        this.spiderLeg5.render(lllllllllllllllIIIlllllIlIlIIlII);
        this.spiderLeg6.render(lllllllllllllllIIIlllllIlIlIIlII);
        this.spiderLeg7.render(lllllllllllllllIIIlllllIlIlIIlII);
        this.spiderLeg8.render(lllllllllllllllIIIlllllIlIlIIlII);
    }
    
    public ModelSpider() {
        final float lllllllllllllllIIIlllllIlIlllIII = 0.0f;
        final byte lllllllllllllllIIIlllllIlIllIlll = 15;
        this.spiderHead = new ModelRenderer(this, 32, 4);
        this.spiderHead.addBox(-4.0f, -4.0f, -8.0f, 8, 8, 8, lllllllllllllllIIIlllllIlIlllIII);
        this.spiderHead.setRotationPoint(0.0f, lllllllllllllllIIIlllllIlIllIlll, -3.0f);
        this.spiderNeck = new ModelRenderer(this, 0, 0);
        this.spiderNeck.addBox(-3.0f, -3.0f, -3.0f, 6, 6, 6, lllllllllllllllIIIlllllIlIlllIII);
        this.spiderNeck.setRotationPoint(0.0f, lllllllllllllllIIIlllllIlIllIlll, 0.0f);
        this.spiderBody = new ModelRenderer(this, 0, 12);
        this.spiderBody.addBox(-5.0f, -4.0f, -6.0f, 10, 8, 12, lllllllllllllllIIIlllllIlIlllIII);
        this.spiderBody.setRotationPoint(0.0f, lllllllllllllllIIIlllllIlIllIlll, 9.0f);
        this.spiderLeg1 = new ModelRenderer(this, 18, 0);
        this.spiderLeg1.addBox(-15.0f, -1.0f, -1.0f, 16, 2, 2, lllllllllllllllIIIlllllIlIlllIII);
        this.spiderLeg1.setRotationPoint(-4.0f, lllllllllllllllIIIlllllIlIllIlll, 2.0f);
        this.spiderLeg2 = new ModelRenderer(this, 18, 0);
        this.spiderLeg2.addBox(-1.0f, -1.0f, -1.0f, 16, 2, 2, lllllllllllllllIIIlllllIlIlllIII);
        this.spiderLeg2.setRotationPoint(4.0f, lllllllllllllllIIIlllllIlIllIlll, 2.0f);
        this.spiderLeg3 = new ModelRenderer(this, 18, 0);
        this.spiderLeg3.addBox(-15.0f, -1.0f, -1.0f, 16, 2, 2, lllllllllllllllIIIlllllIlIlllIII);
        this.spiderLeg3.setRotationPoint(-4.0f, lllllllllllllllIIIlllllIlIllIlll, 1.0f);
        this.spiderLeg4 = new ModelRenderer(this, 18, 0);
        this.spiderLeg4.addBox(-1.0f, -1.0f, -1.0f, 16, 2, 2, lllllllllllllllIIIlllllIlIlllIII);
        this.spiderLeg4.setRotationPoint(4.0f, lllllllllllllllIIIlllllIlIllIlll, 1.0f);
        this.spiderLeg5 = new ModelRenderer(this, 18, 0);
        this.spiderLeg5.addBox(-15.0f, -1.0f, -1.0f, 16, 2, 2, lllllllllllllllIIIlllllIlIlllIII);
        this.spiderLeg5.setRotationPoint(-4.0f, lllllllllllllllIIIlllllIlIllIlll, 0.0f);
        this.spiderLeg6 = new ModelRenderer(this, 18, 0);
        this.spiderLeg6.addBox(-1.0f, -1.0f, -1.0f, 16, 2, 2, lllllllllllllllIIIlllllIlIlllIII);
        this.spiderLeg6.setRotationPoint(4.0f, lllllllllllllllIIIlllllIlIllIlll, 0.0f);
        this.spiderLeg7 = new ModelRenderer(this, 18, 0);
        this.spiderLeg7.addBox(-15.0f, -1.0f, -1.0f, 16, 2, 2, lllllllllllllllIIIlllllIlIlllIII);
        this.spiderLeg7.setRotationPoint(-4.0f, lllllllllllllllIIIlllllIlIllIlll, -1.0f);
        this.spiderLeg8 = new ModelRenderer(this, 18, 0);
        this.spiderLeg8.addBox(-1.0f, -1.0f, -1.0f, 16, 2, 2, lllllllllllllllIIIlllllIlIlllIII);
        this.spiderLeg8.setRotationPoint(4.0f, lllllllllllllllIIIlllllIlIllIlll, -1.0f);
    }
}
