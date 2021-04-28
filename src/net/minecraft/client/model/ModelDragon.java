package net.minecraft.client.model;

import net.minecraft.client.renderer.*;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.*;

public class ModelDragon extends ModelBase
{
    private /* synthetic */ ModelRenderer head;
    private /* synthetic */ ModelRenderer rearFoot;
    private /* synthetic */ ModelRenderer spine;
    private /* synthetic */ ModelRenderer rearLeg;
    private /* synthetic */ ModelRenderer jaw;
    private /* synthetic */ float partialTicks;
    private /* synthetic */ ModelRenderer wing;
    private /* synthetic */ ModelRenderer rearLegTip;
    private /* synthetic */ ModelRenderer frontLegTip;
    private /* synthetic */ ModelRenderer body;
    private /* synthetic */ ModelRenderer wingTip;
    private /* synthetic */ ModelRenderer frontFoot;
    private /* synthetic */ ModelRenderer frontLeg;
    
    private float updateRotations(double lllllllllllllllIIIIIIlIIlIlIlIII) {
        while (lllllllllllllllIIIIIIlIIlIlIlIII >= 180.0) {
            lllllllllllllllIIIIIIlIIlIlIlIII -= 360.0;
        }
        while (lllllllllllllllIIIIIIlIIlIlIlIII < -180.0) {
            lllllllllllllllIIIIIIlIIlIlIlIII += 360.0;
        }
        return (float)lllllllllllllllIIIIIIlIIlIlIlIII;
    }
    
    public ModelDragon(final float lllllllllllllllIIIIIIlIIllllIlll) {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.setTextureOffset("body.body", 0, 0);
        this.setTextureOffset("wing.skin", -56, 88);
        this.setTextureOffset("wingtip.skin", -56, 144);
        this.setTextureOffset("rearleg.main", 0, 0);
        this.setTextureOffset("rearfoot.main", 112, 0);
        this.setTextureOffset("rearlegtip.main", 196, 0);
        this.setTextureOffset("head.upperhead", 112, 30);
        this.setTextureOffset("wing.bone", 112, 88);
        this.setTextureOffset("head.upperlip", 176, 44);
        this.setTextureOffset("jaw.jaw", 176, 65);
        this.setTextureOffset("frontleg.main", 112, 104);
        this.setTextureOffset("wingtip.bone", 112, 136);
        this.setTextureOffset("frontfoot.main", 144, 104);
        this.setTextureOffset("neck.box", 192, 104);
        this.setTextureOffset("frontlegtip.main", 226, 138);
        this.setTextureOffset("body.scale", 220, 53);
        this.setTextureOffset("head.scale", 0, 0);
        this.setTextureOffset("neck.scale", 48, 0);
        this.setTextureOffset("head.nostril", 112, 0);
        final float lllllllllllllllIIIIIIlIIllllIllI = -16.0f;
        this.head = new ModelRenderer(this, "head");
        this.head.addBox("upperlip", -6.0f, -1.0f, -8.0f + lllllllllllllllIIIIIIlIIllllIllI, 12, 5, 16);
        this.head.addBox("upperhead", -8.0f, -8.0f, 6.0f + lllllllllllllllIIIIIIlIIllllIllI, 16, 16, 16);
        this.head.mirror = true;
        this.head.addBox("scale", -5.0f, -12.0f, 12.0f + lllllllllllllllIIIIIIlIIllllIllI, 2, 4, 6);
        this.head.addBox("nostril", -5.0f, -3.0f, -6.0f + lllllllllllllllIIIIIIlIIllllIllI, 2, 2, 4);
        this.head.mirror = false;
        this.head.addBox("scale", 3.0f, -12.0f, 12.0f + lllllllllllllllIIIIIIlIIllllIllI, 2, 4, 6);
        this.head.addBox("nostril", 3.0f, -3.0f, -6.0f + lllllllllllllllIIIIIIlIIllllIllI, 2, 2, 4);
        this.jaw = new ModelRenderer(this, "jaw");
        this.jaw.setRotationPoint(0.0f, 4.0f, 8.0f + lllllllllllllllIIIIIIlIIllllIllI);
        this.jaw.addBox("jaw", -6.0f, 0.0f, -16.0f, 12, 4, 16);
        this.head.addChild(this.jaw);
        this.spine = new ModelRenderer(this, "neck");
        this.spine.addBox("box", -5.0f, -5.0f, -5.0f, 10, 10, 10);
        this.spine.addBox("scale", -1.0f, -9.0f, -3.0f, 2, 4, 6);
        this.body = new ModelRenderer(this, "body");
        this.body.setRotationPoint(0.0f, 4.0f, 8.0f);
        this.body.addBox("body", -12.0f, 0.0f, -16.0f, 24, 24, 64);
        this.body.addBox("scale", -1.0f, -6.0f, -10.0f, 2, 6, 12);
        this.body.addBox("scale", -1.0f, -6.0f, 10.0f, 2, 6, 12);
        this.body.addBox("scale", -1.0f, -6.0f, 30.0f, 2, 6, 12);
        this.wing = new ModelRenderer(this, "wing");
        this.wing.setRotationPoint(-12.0f, 5.0f, 2.0f);
        this.wing.addBox("bone", -56.0f, -4.0f, -4.0f, 56, 8, 8);
        this.wing.addBox("skin", -56.0f, 0.0f, 2.0f, 56, 0, 56);
        this.wingTip = new ModelRenderer(this, "wingtip");
        this.wingTip.setRotationPoint(-56.0f, 0.0f, 0.0f);
        this.wingTip.addBox("bone", -56.0f, -2.0f, -2.0f, 56, 4, 4);
        this.wingTip.addBox("skin", -56.0f, 0.0f, 2.0f, 56, 0, 56);
        this.wing.addChild(this.wingTip);
        this.frontLeg = new ModelRenderer(this, "frontleg");
        this.frontLeg.setRotationPoint(-12.0f, 20.0f, 2.0f);
        this.frontLeg.addBox("main", -4.0f, -4.0f, -4.0f, 8, 24, 8);
        this.frontLegTip = new ModelRenderer(this, "frontlegtip");
        this.frontLegTip.setRotationPoint(0.0f, 20.0f, -1.0f);
        this.frontLegTip.addBox("main", -3.0f, -1.0f, -3.0f, 6, 24, 6);
        this.frontLeg.addChild(this.frontLegTip);
        this.frontFoot = new ModelRenderer(this, "frontfoot");
        this.frontFoot.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.frontFoot.addBox("main", -4.0f, 0.0f, -12.0f, 8, 4, 16);
        this.frontLegTip.addChild(this.frontFoot);
        this.rearLeg = new ModelRenderer(this, "rearleg");
        this.rearLeg.setRotationPoint(-16.0f, 16.0f, 42.0f);
        this.rearLeg.addBox("main", -8.0f, -4.0f, -8.0f, 16, 32, 16);
        this.rearLegTip = new ModelRenderer(this, "rearlegtip");
        this.rearLegTip.setRotationPoint(0.0f, 32.0f, -4.0f);
        this.rearLegTip.addBox("main", -6.0f, -2.0f, 0.0f, 12, 32, 12);
        this.rearLeg.addChild(this.rearLegTip);
        this.rearFoot = new ModelRenderer(this, "rearfoot");
        this.rearFoot.setRotationPoint(0.0f, 31.0f, 4.0f);
        this.rearFoot.addBox("main", -9.0f, 0.0f, -20.0f, 18, 6, 24);
        this.rearLegTip.addChild(this.rearFoot);
    }
    
    static {
        __OBFID = "CL_00000870";
    }
    
    @Override
    public void render(final Entity lllllllllllllllIIIIIIlIIllIlIlll, final float lllllllllllllllIIIIIIlIIllIlIllI, final float lllllllllllllllIIIIIIlIIllIlIlIl, final float lllllllllllllllIIIIIIlIIllIlIlII, final float lllllllllllllllIIIIIIlIIllIlIIll, final float lllllllllllllllIIIIIIlIIllIlIIlI, final float lllllllllllllllIIIIIIlIIlIlllIll) {
        GlStateManager.pushMatrix();
        final EntityDragon lllllllllllllllIIIIIIlIIllIlIIII = (EntityDragon)lllllllllllllllIIIIIIlIIllIlIlll;
        final float lllllllllllllllIIIIIIlIIllIIllll = lllllllllllllllIIIIIIlIIllIlIIII.prevAnimTime + (lllllllllllllllIIIIIIlIIllIlIIII.animTime - lllllllllllllllIIIIIIlIIllIlIIII.prevAnimTime) * this.partialTicks;
        this.jaw.rotateAngleX = (float)(Math.sin(lllllllllllllllIIIIIIlIIllIIllll * 3.1415927f * 2.0f) + 1.0) * 0.2f;
        float lllllllllllllllIIIIIIlIIllIIlllI = (float)(Math.sin(lllllllllllllllIIIIIIlIIllIIllll * 3.1415927f * 2.0f - 1.0f) + 1.0);
        lllllllllllllllIIIIIIlIIllIIlllI = (lllllllllllllllIIIIIIlIIllIIlllI * lllllllllllllllIIIIIIlIIllIIlllI * 1.0f + lllllllllllllllIIIIIIlIIllIIlllI * 2.0f) * 0.05f;
        GlStateManager.translate(0.0f, lllllllllllllllIIIIIIlIIllIIlllI - 2.0f, -3.0f);
        GlStateManager.rotate(lllllllllllllllIIIIIIlIIllIIlllI * 2.0f, 1.0f, 0.0f, 0.0f);
        float lllllllllllllllIIIIIIlIIllIIllIl = -30.0f;
        float lllllllllllllllIIIIIIlIIllIIllII = 0.0f;
        final float lllllllllllllllIIIIIIlIIllIIlIll = 1.5f;
        double[] lllllllllllllllIIIIIIlIIllIIlIlI = lllllllllllllllIIIIIIlIIllIlIIII.getMovementOffsets(6, this.partialTicks);
        final float lllllllllllllllIIIIIIlIIllIIlIIl = this.updateRotations(lllllllllllllllIIIIIIlIIllIlIIII.getMovementOffsets(5, this.partialTicks)[0] - lllllllllllllllIIIIIIlIIllIlIIII.getMovementOffsets(10, this.partialTicks)[0]);
        final float lllllllllllllllIIIIIIlIIllIIlIII = this.updateRotations(lllllllllllllllIIIIIIlIIllIlIIII.getMovementOffsets(5, this.partialTicks)[0] + lllllllllllllllIIIIIIlIIllIIlIIl / 2.0f);
        lllllllllllllllIIIIIIlIIllIIllIl += 2.0f;
        float lllllllllllllllIIIIIIlIIllIIIlll = lllllllllllllllIIIIIIlIIllIIllll * 3.1415927f * 2.0f;
        lllllllllllllllIIIIIIlIIllIIllIl = 20.0f;
        float lllllllllllllllIIIIIIlIIllIIIllI = -12.0f;
        for (int lllllllllllllllIIIIIIlIIllIIIIll = 0; lllllllllllllllIIIIIIlIIllIIIIll < 5; ++lllllllllllllllIIIIIIlIIllIIIIll) {
            final double[] lllllllllllllllIIIIIIlIIllIIIIlI = lllllllllllllllIIIIIIlIIllIlIIII.getMovementOffsets(5 - lllllllllllllllIIIIIIlIIllIIIIll, this.partialTicks);
            final float lllllllllllllllIIIIIIlIIllIIIlIl = (float)Math.cos(lllllllllllllllIIIIIIlIIllIIIIll * 0.45f + lllllllllllllllIIIIIIlIIllIIIlll) * 0.15f;
            this.spine.rotateAngleY = this.updateRotations(lllllllllllllllIIIIIIlIIllIIIIlI[0] - lllllllllllllllIIIIIIlIIllIIlIlI[0]) * 3.1415927f / 180.0f * lllllllllllllllIIIIIIlIIllIIlIll;
            this.spine.rotateAngleX = lllllllllllllllIIIIIIlIIllIIIlIl + (float)(lllllllllllllllIIIIIIlIIllIIIIlI[1] - lllllllllllllllIIIIIIlIIllIIlIlI[1]) * 3.1415927f / 180.0f * lllllllllllllllIIIIIIlIIllIIlIll * 5.0f;
            this.spine.rotateAngleZ = -this.updateRotations(lllllllllllllllIIIIIIlIIllIIIIlI[0] - lllllllllllllllIIIIIIlIIllIIlIII) * 3.1415927f / 180.0f * lllllllllllllllIIIIIIlIIllIIlIll;
            this.spine.rotationPointY = lllllllllllllllIIIIIIlIIllIIllIl;
            this.spine.rotationPointZ = lllllllllllllllIIIIIIlIIllIIIllI;
            this.spine.rotationPointX = lllllllllllllllIIIIIIlIIllIIllII;
            lllllllllllllllIIIIIIlIIllIIllIl += (float)(Math.sin(this.spine.rotateAngleX) * 10.0);
            lllllllllllllllIIIIIIlIIllIIIllI -= (float)(Math.cos(this.spine.rotateAngleY) * Math.cos(this.spine.rotateAngleX) * 10.0);
            lllllllllllllllIIIIIIlIIllIIllII -= (float)(Math.sin(this.spine.rotateAngleY) * Math.cos(this.spine.rotateAngleX) * 10.0);
            this.spine.render(lllllllllllllllIIIIIIlIIlIlllIll);
        }
        this.head.rotationPointY = lllllllllllllllIIIIIIlIIllIIllIl;
        this.head.rotationPointZ = lllllllllllllllIIIIIIlIIllIIIllI;
        this.head.rotationPointX = lllllllllllllllIIIIIIlIIllIIllII;
        double[] lllllllllllllllIIIIIIlIIllIIIIIl = lllllllllllllllIIIIIIlIIllIlIIII.getMovementOffsets(0, this.partialTicks);
        this.head.rotateAngleY = this.updateRotations(lllllllllllllllIIIIIIlIIllIIIIIl[0] - lllllllllllllllIIIIIIlIIllIIlIlI[0]) * 3.1415927f / 180.0f * 1.0f;
        this.head.rotateAngleZ = -this.updateRotations(lllllllllllllllIIIIIIlIIllIIIIIl[0] - lllllllllllllllIIIIIIlIIllIIlIII) * 3.1415927f / 180.0f * 1.0f;
        this.head.render(lllllllllllllllIIIIIIlIIlIlllIll);
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-lllllllllllllllIIIIIIlIIllIIlIIl * lllllllllllllllIIIIIIlIIllIIlIll * 1.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.translate(0.0f, -1.0f, 0.0f);
        this.body.rotateAngleZ = 0.0f;
        this.body.render(lllllllllllllllIIIIIIlIIlIlllIll);
        for (int lllllllllllllllIIIIIIlIIllIIIIII = 0; lllllllllllllllIIIIIIlIIllIIIIII < 2; ++lllllllllllllllIIIIIIlIIllIIIIII) {
            GlStateManager.enableCull();
            final float lllllllllllllllIIIIIIlIIllIIIlII = lllllllllllllllIIIIIIlIIllIIllll * 3.1415927f * 2.0f;
            this.wing.rotateAngleX = 0.125f - (float)Math.cos(lllllllllllllllIIIIIIlIIllIIIlII) * 0.2f;
            this.wing.rotateAngleY = 0.25f;
            this.wing.rotateAngleZ = (float)(Math.sin(lllllllllllllllIIIIIIlIIllIIIlII) + 0.125) * 0.8f;
            this.wingTip.rotateAngleZ = -(float)(Math.sin(lllllllllllllllIIIIIIlIIllIIIlII + 2.0f) + 0.5) * 0.75f;
            this.rearLeg.rotateAngleX = 1.0f + lllllllllllllllIIIIIIlIIllIIlllI * 0.1f;
            this.rearLegTip.rotateAngleX = 0.5f + lllllllllllllllIIIIIIlIIllIIlllI * 0.1f;
            this.rearFoot.rotateAngleX = 0.75f + lllllllllllllllIIIIIIlIIllIIlllI * 0.1f;
            this.frontLeg.rotateAngleX = 1.3f + lllllllllllllllIIIIIIlIIllIIlllI * 0.1f;
            this.frontLegTip.rotateAngleX = -0.5f - lllllllllllllllIIIIIIlIIllIIlllI * 0.1f;
            this.frontFoot.rotateAngleX = 0.75f + lllllllllllllllIIIIIIlIIllIIlllI * 0.1f;
            this.wing.render(lllllllllllllllIIIIIIlIIlIlllIll);
            this.frontLeg.render(lllllllllllllllIIIIIIlIIlIlllIll);
            this.rearLeg.render(lllllllllllllllIIIIIIlIIlIlllIll);
            GlStateManager.scale(-1.0f, 1.0f, 1.0f);
            if (lllllllllllllllIIIIIIlIIllIIIIII == 0) {
                GlStateManager.cullFace(1028);
            }
        }
        GlStateManager.popMatrix();
        GlStateManager.cullFace(1029);
        GlStateManager.disableCull();
        float lllllllllllllllIIIIIIlIIlIllllll = -(float)Math.sin(lllllllllllllllIIIIIIlIIllIIllll * 3.1415927f * 2.0f) * 0.0f;
        lllllllllllllllIIIIIIlIIllIIIlll = lllllllllllllllIIIIIIlIIllIIllll * 3.1415927f * 2.0f;
        lllllllllllllllIIIIIIlIIllIIllIl = 10.0f;
        lllllllllllllllIIIIIIlIIllIIIllI = 60.0f;
        lllllllllllllllIIIIIIlIIllIIllII = 0.0f;
        lllllllllllllllIIIIIIlIIllIIlIlI = lllllllllllllllIIIIIIlIIllIlIIII.getMovementOffsets(11, this.partialTicks);
        for (int lllllllllllllllIIIIIIlIIlIlllllI = 0; lllllllllllllllIIIIIIlIIlIlllllI < 12; ++lllllllllllllllIIIIIIlIIlIlllllI) {
            lllllllllllllllIIIIIIlIIllIIIIIl = lllllllllllllllIIIIIIlIIllIlIIII.getMovementOffsets(12 + lllllllllllllllIIIIIIlIIlIlllllI, this.partialTicks);
            lllllllllllllllIIIIIIlIIlIllllll += (float)(Math.sin(lllllllllllllllIIIIIIlIIlIlllllI * 0.45f + lllllllllllllllIIIIIIlIIllIIIlll) * 0.05000000074505806);
            this.spine.rotateAngleY = (this.updateRotations(lllllllllllllllIIIIIIlIIllIIIIIl[0] - lllllllllllllllIIIIIIlIIllIIlIlI[0]) * lllllllllllllllIIIIIIlIIllIIlIll + 180.0f) * 3.1415927f / 180.0f;
            this.spine.rotateAngleX = lllllllllllllllIIIIIIlIIlIllllll + (float)(lllllllllllllllIIIIIIlIIllIIIIIl[1] - lllllllllllllllIIIIIIlIIllIIlIlI[1]) * 3.1415927f / 180.0f * lllllllllllllllIIIIIIlIIllIIlIll * 5.0f;
            this.spine.rotateAngleZ = this.updateRotations(lllllllllllllllIIIIIIlIIllIIIIIl[0] - lllllllllllllllIIIIIIlIIllIIlIII) * 3.1415927f / 180.0f * lllllllllllllllIIIIIIlIIllIIlIll;
            this.spine.rotationPointY = lllllllllllllllIIIIIIlIIllIIllIl;
            this.spine.rotationPointZ = lllllllllllllllIIIIIIlIIllIIIllI;
            this.spine.rotationPointX = lllllllllllllllIIIIIIlIIllIIllII;
            lllllllllllllllIIIIIIlIIllIIllIl += (float)(Math.sin(this.spine.rotateAngleX) * 10.0);
            lllllllllllllllIIIIIIlIIllIIIllI -= (float)(Math.cos(this.spine.rotateAngleY) * Math.cos(this.spine.rotateAngleX) * 10.0);
            lllllllllllllllIIIIIIlIIllIIllII -= (float)(Math.sin(this.spine.rotateAngleY) * Math.cos(this.spine.rotateAngleX) * 10.0);
            this.spine.render(lllllllllllllllIIIIIIlIIlIlllIll);
        }
        GlStateManager.popMatrix();
    }
    
    @Override
    public void setLivingAnimations(final EntityLivingBase lllllllllllllllIIIIIIlIIllllIIII, final float lllllllllllllllIIIIIIlIIlllIllll, final float lllllllllllllllIIIIIIlIIlllIlllI, final float lllllllllllllllIIIIIIlIIlllIllIl) {
        this.partialTicks = lllllllllllllllIIIIIIlIIlllIllIl;
    }
}
