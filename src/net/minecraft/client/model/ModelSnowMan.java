package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelSnowMan extends ModelBase
{
    public /* synthetic */ ModelRenderer bottomBody;
    public /* synthetic */ ModelRenderer body;
    public /* synthetic */ ModelRenderer leftHand;
    public /* synthetic */ ModelRenderer head;
    public /* synthetic */ ModelRenderer rightHand;
    
    public ModelSnowMan() {
        final float llllllllllllllllIlIllIlIIllIlIIl = 4.0f;
        final float llllllllllllllllIlIllIlIIllIlIII = 0.0f;
        this.head = new ModelRenderer(this, 0, 0).setTextureSize(64, 64);
        this.head.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, llllllllllllllllIlIllIlIIllIlIII - 0.5f);
        this.head.setRotationPoint(0.0f, 0.0f + llllllllllllllllIlIllIlIIllIlIIl, 0.0f);
        this.rightHand = new ModelRenderer(this, 32, 0).setTextureSize(64, 64);
        this.rightHand.addBox(-1.0f, 0.0f, -1.0f, 12, 2, 2, llllllllllllllllIlIllIlIIllIlIII - 0.5f);
        this.rightHand.setRotationPoint(0.0f, 0.0f + llllllllllllllllIlIllIlIIllIlIIl + 9.0f - 7.0f, 0.0f);
        this.leftHand = new ModelRenderer(this, 32, 0).setTextureSize(64, 64);
        this.leftHand.addBox(-1.0f, 0.0f, -1.0f, 12, 2, 2, llllllllllllllllIlIllIlIIllIlIII - 0.5f);
        this.leftHand.setRotationPoint(0.0f, 0.0f + llllllllllllllllIlIllIlIIllIlIIl + 9.0f - 7.0f, 0.0f);
        this.body = new ModelRenderer(this, 0, 16).setTextureSize(64, 64);
        this.body.addBox(-5.0f, -10.0f, -5.0f, 10, 10, 10, llllllllllllllllIlIllIlIIllIlIII - 0.5f);
        this.body.setRotationPoint(0.0f, 0.0f + llllllllllllllllIlIllIlIIllIlIIl + 9.0f, 0.0f);
        this.bottomBody = new ModelRenderer(this, 0, 36).setTextureSize(64, 64);
        this.bottomBody.addBox(-6.0f, -12.0f, -6.0f, 12, 12, 12, llllllllllllllllIlIllIlIIllIlIII - 0.5f);
        this.bottomBody.setRotationPoint(0.0f, 0.0f + llllllllllllllllIlIllIlIIllIlIIl + 20.0f, 0.0f);
    }
    
    @Override
    public void render(final Entity llllllllllllllllIlIllIlIIIllIlIl, final float llllllllllllllllIlIllIlIIIllIlII, final float llllllllllllllllIlIllIlIIIllIIll, final float llllllllllllllllIlIllIlIIIlllIlI, final float llllllllllllllllIlIllIlIIIlllIIl, final float llllllllllllllllIlIllIlIIIllIIII, final float llllllllllllllllIlIllIlIIIlIllll) {
        this.setRotationAngles(llllllllllllllllIlIllIlIIIllIlII, llllllllllllllllIlIllIlIIIllIIll, llllllllllllllllIlIllIlIIIlllIlI, llllllllllllllllIlIllIlIIIlllIIl, llllllllllllllllIlIllIlIIIllIIII, llllllllllllllllIlIllIlIIIlIllll, llllllllllllllllIlIllIlIIIllIlIl);
        this.body.render(llllllllllllllllIlIllIlIIIlIllll);
        this.bottomBody.render(llllllllllllllllIlIllIlIIIlIllll);
        this.head.render(llllllllllllllllIlIllIlIIIlIllll);
        this.rightHand.render(llllllllllllllllIlIllIlIIIlIllll);
        this.leftHand.render(llllllllllllllllIlIllIlIIIlIllll);
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllllllIlIllIlIIlIllIIl, final float llllllllllllllllIlIllIlIIlIIlllI, final float llllllllllllllllIlIllIlIIlIlIlll, final float llllllllllllllllIlIllIlIIlIIllII, final float llllllllllllllllIlIllIlIIlIlIlIl, final float llllllllllllllllIlIllIlIIlIlIlII, final Entity llllllllllllllllIlIllIlIIlIIlIIl) {
        super.setRotationAngles(llllllllllllllllIlIllIlIIlIllIIl, llllllllllllllllIlIllIlIIlIIlllI, llllllllllllllllIlIllIlIIlIlIlll, llllllllllllllllIlIllIlIIlIIllII, llllllllllllllllIlIllIlIIlIlIlIl, llllllllllllllllIlIllIlIIlIlIlII, llllllllllllllllIlIllIlIIlIIlIIl);
        this.head.rotateAngleY = llllllllllllllllIlIllIlIIlIIllII / 57.295776f;
        this.head.rotateAngleX = llllllllllllllllIlIllIlIIlIlIlIl / 57.295776f;
        this.body.rotateAngleY = llllllllllllllllIlIllIlIIlIIllII / 57.295776f * 0.25f;
        final float llllllllllllllllIlIllIlIIlIlIIlI = MathHelper.sin(this.body.rotateAngleY);
        final float llllllllllllllllIlIllIlIIlIlIIIl = MathHelper.cos(this.body.rotateAngleY);
        this.rightHand.rotateAngleZ = 1.0f;
        this.leftHand.rotateAngleZ = -1.0f;
        this.rightHand.rotateAngleY = 0.0f + this.body.rotateAngleY;
        this.leftHand.rotateAngleY = 3.1415927f + this.body.rotateAngleY;
        this.rightHand.rotationPointX = llllllllllllllllIlIllIlIIlIlIIIl * 5.0f;
        this.rightHand.rotationPointZ = -llllllllllllllllIlIllIlIIlIlIIlI * 5.0f;
        this.leftHand.rotationPointX = -llllllllllllllllIlIllIlIIlIlIIIl * 5.0f;
        this.leftHand.rotationPointZ = llllllllllllllllIlIllIlIIlIlIIlI * 5.0f;
    }
    
    static {
        __OBFID = "CL_00000859";
    }
}
