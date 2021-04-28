package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;

public class ModelQuadruped extends ModelBase
{
    protected /* synthetic */ float childYOffset;
    protected /* synthetic */ float childZOffset;
    public /* synthetic */ ModelRenderer leg3;
    public /* synthetic */ ModelRenderer leg4;
    public /* synthetic */ ModelRenderer head;
    public /* synthetic */ ModelRenderer leg1;
    public /* synthetic */ ModelRenderer body;
    public /* synthetic */ ModelRenderer leg2;
    
    public ModelQuadruped(final int llllllllllllllIlIllIIIllIlIllIll, final float llllllllllllllIlIllIIIllIlIllIlI) {
        this.head = new ModelRenderer(this, 0, 0);
        this.childYOffset = 8.0f;
        this.childZOffset = 4.0f;
        this.head.addBox(-4.0f, -4.0f, -8.0f, 8, 8, 8, llllllllllllllIlIllIIIllIlIllIlI);
        this.head.setRotationPoint(0.0f, (float)(18 - llllllllllllllIlIllIIIllIlIllIll), -6.0f);
        this.body = new ModelRenderer(this, 28, 8);
        this.body.addBox(-5.0f, -10.0f, -7.0f, 10, 16, 8, llllllllllllllIlIllIIIllIlIllIlI);
        this.body.setRotationPoint(0.0f, (float)(17 - llllllllllllllIlIllIIIllIlIllIll), 2.0f);
        this.leg1 = new ModelRenderer(this, 0, 16);
        this.leg1.addBox(-2.0f, 0.0f, -2.0f, 4, llllllllllllllIlIllIIIllIlIllIll, 4, llllllllllllllIlIllIIIllIlIllIlI);
        this.leg1.setRotationPoint(-3.0f, (float)(24 - llllllllllllllIlIllIIIllIlIllIll), 7.0f);
        this.leg2 = new ModelRenderer(this, 0, 16);
        this.leg2.addBox(-2.0f, 0.0f, -2.0f, 4, llllllllllllllIlIllIIIllIlIllIll, 4, llllllllllllllIlIllIIIllIlIllIlI);
        this.leg2.setRotationPoint(3.0f, (float)(24 - llllllllllllllIlIllIIIllIlIllIll), 7.0f);
        this.leg3 = new ModelRenderer(this, 0, 16);
        this.leg3.addBox(-2.0f, 0.0f, -2.0f, 4, llllllllllllllIlIllIIIllIlIllIll, 4, llllllllllllllIlIllIIIllIlIllIlI);
        this.leg3.setRotationPoint(-3.0f, (float)(24 - llllllllllllllIlIllIIIllIlIllIll), -5.0f);
        this.leg4 = new ModelRenderer(this, 0, 16);
        this.leg4.addBox(-2.0f, 0.0f, -2.0f, 4, llllllllllllllIlIllIIIllIlIllIll, 4, llllllllllllllIlIllIIIllIlIllIlI);
        this.leg4.setRotationPoint(3.0f, (float)(24 - llllllllllllllIlIllIIIllIlIllIll), -5.0f);
    }
    
    @Override
    public void render(final Entity llllllllllllllIlIllIIIllIlIIIIll, final float llllllllllllllIlIllIIIllIlIIlIll, final float llllllllllllllIlIllIIIllIlIIIIIl, final float llllllllllllllIlIllIIIllIlIIlIIl, final float llllllllllllllIlIllIIIllIlIIlIII, final float llllllllllllllIlIllIIIllIIlllllI, final float llllllllllllllIlIllIIIllIlIIIllI) {
        this.setRotationAngles(llllllllllllllIlIllIIIllIlIIlIll, llllllllllllllIlIllIIIllIlIIIIIl, llllllllllllllIlIllIIIllIlIIlIIl, llllllllllllllIlIllIIIllIlIIlIII, llllllllllllllIlIllIIIllIIlllllI, llllllllllllllIlIllIIIllIlIIIllI, llllllllllllllIlIllIIIllIlIIIIll);
        if (this.isChild) {
            final float llllllllllllllIlIllIIIllIlIIIlIl = 2.0f;
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, this.childYOffset * llllllllllllllIlIllIIIllIlIIIllI, this.childZOffset * llllllllllllllIlIllIIIllIlIIIllI);
            this.head.render(llllllllllllllIlIllIIIllIlIIIllI);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(1.0f / llllllllllllllIlIllIIIllIlIIIlIl, 1.0f / llllllllllllllIlIllIIIllIlIIIlIl, 1.0f / llllllllllllllIlIllIIIllIlIIIlIl);
            GlStateManager.translate(0.0f, 24.0f * llllllllllllllIlIllIIIllIlIIIllI, 0.0f);
            this.body.render(llllllllllllllIlIllIIIllIlIIIllI);
            this.leg1.render(llllllllllllllIlIllIIIllIlIIIllI);
            this.leg2.render(llllllllllllllIlIllIIIllIlIIIllI);
            this.leg3.render(llllllllllllllIlIllIIIllIlIIIllI);
            this.leg4.render(llllllllllllllIlIllIIIllIlIIIllI);
            GlStateManager.popMatrix();
        }
        else {
            this.head.render(llllllllllllllIlIllIIIllIlIIIllI);
            this.body.render(llllllllllllllIlIllIIIllIlIIIllI);
            this.leg1.render(llllllllllllllIlIllIIIllIlIIIllI);
            this.leg2.render(llllllllllllllIlIllIIIllIlIIIllI);
            this.leg3.render(llllllllllllllIlIllIIIllIlIIIllI);
            this.leg4.render(llllllllllllllIlIllIIIllIlIIIllI);
        }
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllllIlIllIIIllIIllIlII, final float llllllllllllllIlIllIIIllIIlIlIlI, final float llllllllllllllIlIllIIIllIIllIIlI, final float llllllllllllllIlIllIIIllIIllIIIl, final float llllllllllllllIlIllIIIllIIllIIII, final float llllllllllllllIlIllIIIllIIlIllll, final Entity llllllllllllllIlIllIIIllIIlIlllI) {
        final float llllllllllllllIlIllIIIllIIlIllIl = 57.295776f;
        this.head.rotateAngleX = llllllllllllllIlIllIIIllIIllIIII / 57.295776f;
        this.head.rotateAngleY = llllllllllllllIlIllIIIllIIllIIIl / 57.295776f;
        this.body.rotateAngleX = 1.5707964f;
        this.leg1.rotateAngleX = MathHelper.cos(llllllllllllllIlIllIIIllIIllIlII * 0.6662f) * 1.4f * llllllllllllllIlIllIIIllIIlIlIlI;
        this.leg2.rotateAngleX = MathHelper.cos(llllllllllllllIlIllIIIllIIllIlII * 0.6662f + 3.1415927f) * 1.4f * llllllllllllllIlIllIIIllIIlIlIlI;
        this.leg3.rotateAngleX = MathHelper.cos(llllllllllllllIlIllIIIllIIllIlII * 0.6662f + 3.1415927f) * 1.4f * llllllllllllllIlIllIIIllIIlIlIlI;
        this.leg4.rotateAngleX = MathHelper.cos(llllllllllllllIlIllIIIllIIllIlII * 0.6662f) * 1.4f * llllllllllllllIlIllIIIllIIlIlIlI;
    }
    
    static {
        __OBFID = "CL_00000851";
    }
}
