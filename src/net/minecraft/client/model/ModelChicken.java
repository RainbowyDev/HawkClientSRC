package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;

public class ModelChicken extends ModelBase
{
    public /* synthetic */ ModelRenderer leftLeg;
    public /* synthetic */ ModelRenderer head;
    public /* synthetic */ ModelRenderer body;
    public /* synthetic */ ModelRenderer rightWing;
    public /* synthetic */ ModelRenderer rightLeg;
    public /* synthetic */ ModelRenderer leftWing;
    public /* synthetic */ ModelRenderer chin;
    public /* synthetic */ ModelRenderer bill;
    
    public ModelChicken() {
        final byte llllllllllllllIIIIlIIIIIIIIIIllI = 16;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-2.0f, -6.0f, -2.0f, 4, 6, 3, 0.0f);
        this.head.setRotationPoint(0.0f, (float)(-1 + llllllllllllllIIIIlIIIIIIIIIIllI), -4.0f);
        this.bill = new ModelRenderer(this, 14, 0);
        this.bill.addBox(-2.0f, -4.0f, -4.0f, 4, 2, 2, 0.0f);
        this.bill.setRotationPoint(0.0f, (float)(-1 + llllllllllllllIIIIlIIIIIIIIIIllI), -4.0f);
        this.chin = new ModelRenderer(this, 14, 4);
        this.chin.addBox(-1.0f, -2.0f, -3.0f, 2, 2, 2, 0.0f);
        this.chin.setRotationPoint(0.0f, (float)(-1 + llllllllllllllIIIIlIIIIIIIIIIllI), -4.0f);
        this.body = new ModelRenderer(this, 0, 9);
        this.body.addBox(-3.0f, -4.0f, -3.0f, 6, 8, 6, 0.0f);
        this.body.setRotationPoint(0.0f, llllllllllllllIIIIlIIIIIIIIIIllI, 0.0f);
        this.rightLeg = new ModelRenderer(this, 26, 0);
        this.rightLeg.addBox(-1.0f, 0.0f, -3.0f, 3, 5, 3);
        this.rightLeg.setRotationPoint(-2.0f, (float)(3 + llllllllllllllIIIIlIIIIIIIIIIllI), 1.0f);
        this.leftLeg = new ModelRenderer(this, 26, 0);
        this.leftLeg.addBox(-1.0f, 0.0f, -3.0f, 3, 5, 3);
        this.leftLeg.setRotationPoint(1.0f, (float)(3 + llllllllllllllIIIIlIIIIIIIIIIllI), 1.0f);
        this.rightWing = new ModelRenderer(this, 24, 13);
        this.rightWing.addBox(0.0f, 0.0f, -3.0f, 1, 4, 6);
        this.rightWing.setRotationPoint(-4.0f, (float)(-3 + llllllllllllllIIIIlIIIIIIIIIIllI), 0.0f);
        this.leftWing = new ModelRenderer(this, 24, 13);
        this.leftWing.addBox(-1.0f, 0.0f, -3.0f, 1, 4, 6);
        this.leftWing.setRotationPoint(4.0f, (float)(-3 + llllllllllllllIIIIlIIIIIIIIIIllI), 0.0f);
    }
    
    static {
        __OBFID = "CL_00000835";
    }
    
    @Override
    public void render(final Entity llllllllllllllIIIIIlllllllllIIII, final float llllllllllllllIIIIIllllllllIllll, final float llllllllllllllIIIIIllllllllIlllI, final float llllllllllllllIIIIIllllllllIllIl, final float llllllllllllllIIIIIlllllllllIlIl, final float llllllllllllllIIIIIlllllllllIlII, final float llllllllllllllIIIIIllllllllIlIlI) {
        this.setRotationAngles(llllllllllllllIIIIIllllllllIllll, llllllllllllllIIIIIllllllllIlllI, llllllllllllllIIIIIllllllllIllIl, llllllllllllllIIIIIlllllllllIlIl, llllllllllllllIIIIIlllllllllIlII, llllllllllllllIIIIIllllllllIlIlI, llllllllllllllIIIIIlllllllllIIII);
        if (this.isChild) {
            final float llllllllllllllIIIIIlllllllllIIlI = 2.0f;
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, 5.0f * llllllllllllllIIIIIllllllllIlIlI, 2.0f * llllllllllllllIIIIIllllllllIlIlI);
            this.head.render(llllllllllllllIIIIIllllllllIlIlI);
            this.bill.render(llllllllllllllIIIIIllllllllIlIlI);
            this.chin.render(llllllllllllllIIIIIllllllllIlIlI);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(1.0f / llllllllllllllIIIIIlllllllllIIlI, 1.0f / llllllllllllllIIIIIlllllllllIIlI, 1.0f / llllllllllllllIIIIIlllllllllIIlI);
            GlStateManager.translate(0.0f, 24.0f * llllllllllllllIIIIIllllllllIlIlI, 0.0f);
            this.body.render(llllllllllllllIIIIIllllllllIlIlI);
            this.rightLeg.render(llllllllllllllIIIIIllllllllIlIlI);
            this.leftLeg.render(llllllllllllllIIIIIllllllllIlIlI);
            this.rightWing.render(llllllllllllllIIIIIllllllllIlIlI);
            this.leftWing.render(llllllllllllllIIIIIllllllllIlIlI);
            GlStateManager.popMatrix();
        }
        else {
            this.head.render(llllllllllllllIIIIIllllllllIlIlI);
            this.bill.render(llllllllllllllIIIIIllllllllIlIlI);
            this.chin.render(llllllllllllllIIIIIllllllllIlIlI);
            this.body.render(llllllllllllllIIIIIllllllllIlIlI);
            this.rightLeg.render(llllllllllllllIIIIIllllllllIlIlI);
            this.leftLeg.render(llllllllllllllIIIIIllllllllIlIlI);
            this.rightWing.render(llllllllllllllIIIIIllllllllIlIlI);
            this.leftWing.render(llllllllllllllIIIIIllllllllIlIlI);
        }
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllllIIIIIllllllllIIIIl, final float llllllllllllllIIIIIllllllllIIIII, final float llllllllllllllIIIIIlllllllIlllll, final float llllllllllllllIIIIIlllllllIlIllI, final float llllllllllllllIIIIIlllllllIlllIl, final float llllllllllllllIIIIIlllllllIlllII, final Entity llllllllllllllIIIIIlllllllIllIll) {
        this.head.rotateAngleX = llllllllllllllIIIIIlllllllIlllIl / 57.295776f;
        this.head.rotateAngleY = llllllllllllllIIIIIlllllllIlIllI / 57.295776f;
        this.bill.rotateAngleX = this.head.rotateAngleX;
        this.bill.rotateAngleY = this.head.rotateAngleY;
        this.chin.rotateAngleX = this.head.rotateAngleX;
        this.chin.rotateAngleY = this.head.rotateAngleY;
        this.body.rotateAngleX = 1.5707964f;
        this.rightLeg.rotateAngleX = MathHelper.cos(llllllllllllllIIIIIllllllllIIIIl * 0.6662f) * 1.4f * llllllllllllllIIIIIllllllllIIIII;
        this.leftLeg.rotateAngleX = MathHelper.cos(llllllllllllllIIIIIllllllllIIIIl * 0.6662f + 3.1415927f) * 1.4f * llllllllllllllIIIIIllllllllIIIII;
        this.rightWing.rotateAngleZ = llllllllllllllIIIIIlllllllIlllll;
        this.leftWing.rotateAngleZ = -llllllllllllllIIIIIlllllllIlllll;
    }
}
