package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelBook extends ModelBase
{
    public /* synthetic */ ModelRenderer flippingPageRight;
    public /* synthetic */ ModelRenderer bookSpine;
    public /* synthetic */ ModelRenderer flippingPageLeft;
    public /* synthetic */ ModelRenderer pagesLeft;
    public /* synthetic */ ModelRenderer coverLeft;
    public /* synthetic */ ModelRenderer pagesRight;
    public /* synthetic */ ModelRenderer coverRight;
    
    @Override
    public void setRotationAngles(final float lllllllllllllllIIllIlIllIllIlIII, final float lllllllllllllllIIllIlIllIllIIlll, final float lllllllllllllllIIllIlIllIllIllll, final float lllllllllllllllIIllIlIllIllIlllI, final float lllllllllllllllIIllIlIllIllIllIl, final float lllllllllllllllIIllIlIllIllIllII, final Entity lllllllllllllllIIllIlIllIllIlIll) {
        final float lllllllllllllllIIllIlIllIllIlIlI = (MathHelper.sin(lllllllllllllllIIllIlIllIllIlIII * 0.02f) * 0.1f + 1.25f) * lllllllllllllllIIllIlIllIllIlllI;
        this.coverRight.rotateAngleY = 3.1415927f + lllllllllllllllIIllIlIllIllIlIlI;
        this.coverLeft.rotateAngleY = -lllllllllllllllIIllIlIllIllIlIlI;
        this.pagesRight.rotateAngleY = lllllllllllllllIIllIlIllIllIlIlI;
        this.pagesLeft.rotateAngleY = -lllllllllllllllIIllIlIllIllIlIlI;
        this.flippingPageRight.rotateAngleY = lllllllllllllllIIllIlIllIllIlIlI - lllllllllllllllIIllIlIllIllIlIlI * 2.0f * lllllllllllllllIIllIlIllIllIIlll;
        this.flippingPageLeft.rotateAngleY = lllllllllllllllIIllIlIllIllIlIlI - lllllllllllllllIIllIlIllIllIlIlI * 2.0f * lllllllllllllllIIllIlIllIllIllll;
        this.pagesRight.rotationPointX = MathHelper.sin(lllllllllllllllIIllIlIllIllIlIlI);
        this.pagesLeft.rotationPointX = MathHelper.sin(lllllllllllllllIIllIlIllIllIlIlI);
        this.flippingPageRight.rotationPointX = MathHelper.sin(lllllllllllllllIIllIlIllIllIlIlI);
        this.flippingPageLeft.rotationPointX = MathHelper.sin(lllllllllllllllIIllIlIllIllIlIlI);
    }
    
    public ModelBook() {
        this.coverRight = new ModelRenderer(this).setTextureOffset(0, 0).addBox(-6.0f, -5.0f, 0.0f, 6, 10, 0);
        this.coverLeft = new ModelRenderer(this).setTextureOffset(16, 0).addBox(0.0f, -5.0f, 0.0f, 6, 10, 0);
        this.pagesRight = new ModelRenderer(this).setTextureOffset(0, 10).addBox(0.0f, -4.0f, -0.99f, 5, 8, 1);
        this.pagesLeft = new ModelRenderer(this).setTextureOffset(12, 10).addBox(0.0f, -4.0f, -0.01f, 5, 8, 1);
        this.flippingPageRight = new ModelRenderer(this).setTextureOffset(24, 10).addBox(0.0f, -4.0f, 0.0f, 5, 8, 0);
        this.flippingPageLeft = new ModelRenderer(this).setTextureOffset(24, 10).addBox(0.0f, -4.0f, 0.0f, 5, 8, 0);
        this.bookSpine = new ModelRenderer(this).setTextureOffset(12, 0).addBox(-1.0f, -5.0f, 0.0f, 2, 10, 0);
        this.coverRight.setRotationPoint(0.0f, 0.0f, -1.0f);
        this.coverLeft.setRotationPoint(0.0f, 0.0f, 1.0f);
        this.bookSpine.rotateAngleY = 1.5707964f;
    }
    
    @Override
    public void render(final Entity lllllllllllllllIIllIlIlllIIIIlll, final float lllllllllllllllIIllIlIllIllllllI, final float lllllllllllllllIIllIlIlllIIIIlIl, final float lllllllllllllllIIllIlIllIlllllII, final float lllllllllllllllIIllIlIllIllllIll, final float lllllllllllllllIIllIlIlllIIIIIlI, final float lllllllllllllllIIllIlIllIllllIIl) {
        this.setRotationAngles(lllllllllllllllIIllIlIllIllllllI, lllllllllllllllIIllIlIlllIIIIlIl, lllllllllllllllIIllIlIllIlllllII, lllllllllllllllIIllIlIllIllllIll, lllllllllllllllIIllIlIlllIIIIIlI, lllllllllllllllIIllIlIllIllllIIl, lllllllllllllllIIllIlIlllIIIIlll);
        this.coverRight.render(lllllllllllllllIIllIlIllIllllIIl);
        this.coverLeft.render(lllllllllllllllIIllIlIllIllllIIl);
        this.bookSpine.render(lllllllllllllllIIllIlIllIllllIIl);
        this.pagesRight.render(lllllllllllllllIIllIlIllIllllIIl);
        this.pagesLeft.render(lllllllllllllllIIllIlIllIllllIIl);
        this.flippingPageRight.render(lllllllllllllllIIllIlIllIllllIIl);
        this.flippingPageLeft.render(lllllllllllllllIIllIlIllIllllIIl);
    }
    
    static {
        __OBFID = "CL_00000833";
    }
}
