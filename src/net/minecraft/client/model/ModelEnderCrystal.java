package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;

public class ModelEnderCrystal extends ModelBase
{
    private /* synthetic */ ModelRenderer base;
    private /* synthetic */ ModelRenderer glass;
    private /* synthetic */ ModelRenderer cube;
    
    @Override
    public void render(final Entity lllllllllllllllllIlIIlllIllIIlIl, final float lllllllllllllllllIlIIlllIllIIIll, final float lllllllllllllllllIlIIlllIllIIIIl, final float lllllllllllllllllIlIIlllIlIllIII, final float lllllllllllllllllIlIIlllIlIllllI, final float lllllllllllllllllIlIIlllIlIlllIl, final float lllllllllllllllllIlIIlllIlIlllII) {
        GlStateManager.pushMatrix();
        GlStateManager.scale(2.0f, 2.0f, 2.0f);
        GlStateManager.translate(0.0f, -0.5f, 0.0f);
        if (this.base != null) {
            this.base.render(lllllllllllllllllIlIIlllIlIlllII);
        }
        GlStateManager.rotate(lllllllllllllllllIlIIlllIllIIIIl, 0.0f, 1.0f, 0.0f);
        GlStateManager.translate(0.0f, 0.8f + lllllllllllllllllIlIIlllIlIllIII, 0.0f);
        GlStateManager.rotate(60.0f, 0.7071f, 0.0f, 0.7071f);
        this.glass.render(lllllllllllllllllIlIIlllIlIlllII);
        final float lllllllllllllllllIlIIlllIlIllIll = 0.875f;
        GlStateManager.scale(lllllllllllllllllIlIIlllIlIllIll, lllllllllllllllllIlIIlllIlIllIll, lllllllllllllllllIlIIlllIlIllIll);
        GlStateManager.rotate(60.0f, 0.7071f, 0.0f, 0.7071f);
        GlStateManager.rotate(lllllllllllllllllIlIIlllIllIIIIl, 0.0f, 1.0f, 0.0f);
        this.glass.render(lllllllllllllllllIlIIlllIlIlllII);
        GlStateManager.scale(lllllllllllllllllIlIIlllIlIllIll, lllllllllllllllllIlIIlllIlIllIll, lllllllllllllllllIlIIlllIlIllIll);
        GlStateManager.rotate(60.0f, 0.7071f, 0.0f, 0.7071f);
        GlStateManager.rotate(lllllllllllllllllIlIIlllIllIIIIl, 0.0f, 1.0f, 0.0f);
        this.cube.render(lllllllllllllllllIlIIlllIlIlllII);
        GlStateManager.popMatrix();
    }
    
    public ModelEnderCrystal(final float lllllllllllllllllIlIIlllIlllllII, final boolean lllllllllllllllllIlIIlllIllllIlI) {
        this.glass = new ModelRenderer(this, "glass");
        this.glass.setTextureOffset(0, 0).addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8);
        this.cube = new ModelRenderer(this, "cube");
        this.cube.setTextureOffset(32, 0).addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8);
        if (lllllllllllllllllIlIIlllIllllIlI) {
            this.base = new ModelRenderer(this, "base");
            this.base.setTextureOffset(0, 16).addBox(-6.0f, 0.0f, -6.0f, 12, 4, 12);
        }
    }
    
    static {
        __OBFID = "CL_00000871";
    }
}
