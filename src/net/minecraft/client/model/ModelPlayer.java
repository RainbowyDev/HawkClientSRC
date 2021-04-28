package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;

public class ModelPlayer extends ModelBiped
{
    public /* synthetic */ ModelRenderer field_178732_b;
    public /* synthetic */ ModelRenderer field_178733_c;
    public /* synthetic */ ModelRenderer field_178731_d;
    public /* synthetic */ ModelRenderer field_178734_a;
    private /* synthetic */ boolean field_178735_y;
    private /* synthetic */ ModelRenderer field_178736_x;
    private /* synthetic */ ModelRenderer field_178729_w;
    public /* synthetic */ ModelRenderer field_178730_v;
    
    public void func_178726_b() {
        this.bipedLeftArm.render(0.0625f);
        this.field_178734_a.render(0.0625f);
    }
    
    public void func_178727_b(final float llllllllllllllllllIIlllllIIllIll) {
        ModelBase.func_178685_a(this.bipedHead, this.field_178736_x);
        this.field_178736_x.rotationPointX = 0.0f;
        this.field_178736_x.rotationPointY = 0.0f;
        this.field_178736_x.render(llllllllllllllllllIIlllllIIllIll);
    }
    
    @Override
    public void postRenderHiddenArm(final float llllllllllllllllllIIllllIllIlIll) {
        if (this.field_178735_y) {
            final ModelRenderer bipedRightArm = this.bipedRightArm;
            ++bipedRightArm.rotationPointX;
            this.bipedRightArm.postRender(llllllllllllllllllIIllllIllIlIll);
            final ModelRenderer bipedRightArm2 = this.bipedRightArm;
            --bipedRightArm2.rotationPointX;
        }
        else {
            this.bipedRightArm.postRender(llllllllllllllllllIIllllIllIlIll);
        }
    }
    
    @Override
    public void func_178719_a(final boolean llllllllllllllllllIIllllIlllIIIl) {
        super.func_178719_a(llllllllllllllllllIIllllIlllIIIl);
        this.field_178734_a.showModel = llllllllllllllllllIIllllIlllIIIl;
        this.field_178732_b.showModel = llllllllllllllllllIIllllIlllIIIl;
        this.field_178733_c.showModel = llllllllllllllllllIIllllIlllIIIl;
        this.field_178731_d.showModel = llllllllllllllllllIIllllIlllIIIl;
        this.field_178730_v.showModel = llllllllllllllllllIIllllIlllIIIl;
        this.field_178729_w.showModel = llllllllllllllllllIIllllIlllIIIl;
        this.field_178736_x.showModel = llllllllllllllllllIIllllIlllIIIl;
    }
    
    @Override
    public void render(final Entity llllllllllllllllllIIlllllIlIIllI, final float llllllllllllllllllIIlllllIlIlllI, final float llllllllllllllllllIIlllllIlIIlII, final float llllllllllllllllllIIlllllIlIllII, final float llllllllllllllllllIIlllllIlIlIll, final float llllllllllllllllllIIlllllIlIlIlI, final float llllllllllllllllllIIlllllIlIlIIl) {
        super.render(llllllllllllllllllIIlllllIlIIllI, llllllllllllllllllIIlllllIlIlllI, llllllllllllllllllIIlllllIlIIlII, llllllllllllllllllIIlllllIlIllII, llllllllllllllllllIIlllllIlIlIll, llllllllllllllllllIIlllllIlIlIlI, llllllllllllllllllIIlllllIlIlIIl);
        GlStateManager.pushMatrix();
        if (this.isChild) {
            final float llllllllllllllllllIIlllllIlIlIII = 2.0f;
            GlStateManager.scale(1.0f / llllllllllllllllllIIlllllIlIlIII, 1.0f / llllllllllllllllllIIlllllIlIlIII, 1.0f / llllllllllllllllllIIlllllIlIlIII);
            GlStateManager.translate(0.0f, 24.0f * llllllllllllllllllIIlllllIlIlIIl, 0.0f);
            this.field_178733_c.render(llllllllllllllllllIIlllllIlIlIIl);
            this.field_178731_d.render(llllllllllllllllllIIlllllIlIlIIl);
            this.field_178734_a.render(llllllllllllllllllIIlllllIlIlIIl);
            this.field_178732_b.render(llllllllllllllllllIIlllllIlIlIIl);
            this.field_178730_v.render(llllllllllllllllllIIlllllIlIlIIl);
        }
        else {
            if (llllllllllllllllllIIlllllIlIIllI.isSneaking()) {
                GlStateManager.translate(0.0f, 0.2f, 0.0f);
            }
            this.field_178733_c.render(llllllllllllllllllIIlllllIlIlIIl);
            this.field_178731_d.render(llllllllllllllllllIIlllllIlIlIIl);
            this.field_178734_a.render(llllllllllllllllllIIlllllIlIlIIl);
            this.field_178732_b.render(llllllllllllllllllIIlllllIlIlIIl);
            this.field_178730_v.render(llllllllllllllllllIIlllllIlIlIIl);
        }
        GlStateManager.popMatrix();
    }
    
    public void func_178725_a() {
        this.bipedRightArm.render(0.0625f);
        this.field_178732_b.render(0.0625f);
    }
    
    static {
        __OBFID = "CL_00002626";
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllllllllIIlllllIIIlIIl, final float llllllllllllllllllIIlllllIIIIIII, final float llllllllllllllllllIIlllllIIIIlll, final float llllllllllllllllllIIlllllIIIIllI, final float llllllllllllllllllIIllllIlllllIl, final float llllllllllllllllllIIllllIlllllII, final Entity llllllllllllllllllIIllllIllllIll) {
        super.setRotationAngles(llllllllllllllllllIIlllllIIIlIIl, llllllllllllllllllIIlllllIIIIIII, llllllllllllllllllIIlllllIIIIlll, llllllllllllllllllIIlllllIIIIllI, llllllllllllllllllIIllllIlllllIl, llllllllllllllllllIIllllIlllllII, llllllllllllllllllIIllllIllllIll);
        ModelBase.func_178685_a(this.bipedLeftLeg, this.field_178733_c);
        ModelBase.func_178685_a(this.bipedRightLeg, this.field_178731_d);
        ModelBase.func_178685_a(this.bipedLeftArm, this.field_178734_a);
        ModelBase.func_178685_a(this.bipedRightArm, this.field_178732_b);
        ModelBase.func_178685_a(this.bipedBody, this.field_178730_v);
    }
    
    public ModelPlayer(final float llllllllllllllllllIIlllllIlllIll, final boolean llllllllllllllllllIIlllllIlllIlI) {
        super(llllllllllllllllllIIlllllIlllIll, 0.0f, 64, 64);
        this.field_178735_y = llllllllllllllllllIIlllllIlllIlI;
        this.field_178736_x = new ModelRenderer(this, 24, 0);
        this.field_178736_x.addBox(-3.0f, -6.0f, -1.0f, 6, 6, 1, llllllllllllllllllIIlllllIlllIll);
        this.field_178729_w = new ModelRenderer(this, 0, 0);
        this.field_178729_w.setTextureSize(64, 32);
        this.field_178729_w.addBox(-5.0f, 0.0f, -1.0f, 10, 16, 1, llllllllllllllllllIIlllllIlllIll);
        if (llllllllllllllllllIIlllllIlllIlI) {
            this.bipedLeftArm = new ModelRenderer(this, 32, 48);
            this.bipedLeftArm.addBox(-1.0f, -2.0f, -2.0f, 3, 12, 4, llllllllllllllllllIIlllllIlllIll);
            this.bipedLeftArm.setRotationPoint(5.0f, 2.5f, 0.0f);
            this.bipedRightArm = new ModelRenderer(this, 40, 16);
            this.bipedRightArm.addBox(-2.0f, -2.0f, -2.0f, 3, 12, 4, llllllllllllllllllIIlllllIlllIll);
            this.bipedRightArm.setRotationPoint(-5.0f, 2.5f, 0.0f);
            this.field_178734_a = new ModelRenderer(this, 48, 48);
            this.field_178734_a.addBox(-1.0f, -2.0f, -2.0f, 3, 12, 4, llllllllllllllllllIIlllllIlllIll + 0.25f);
            this.field_178734_a.setRotationPoint(5.0f, 2.5f, 0.0f);
            this.field_178732_b = new ModelRenderer(this, 40, 32);
            this.field_178732_b.addBox(-2.0f, -2.0f, -2.0f, 3, 12, 4, llllllllllllllllllIIlllllIlllIll + 0.25f);
            this.field_178732_b.setRotationPoint(-5.0f, 2.5f, 10.0f);
        }
        else {
            this.bipedLeftArm = new ModelRenderer(this, 32, 48);
            this.bipedLeftArm.addBox(-1.0f, -2.0f, -2.0f, 4, 12, 4, llllllllllllllllllIIlllllIlllIll);
            this.bipedLeftArm.setRotationPoint(5.0f, 2.0f, 0.0f);
            this.field_178734_a = new ModelRenderer(this, 48, 48);
            this.field_178734_a.addBox(-1.0f, -2.0f, -2.0f, 4, 12, 4, llllllllllllllllllIIlllllIlllIll + 0.25f);
            this.field_178734_a.setRotationPoint(5.0f, 2.0f, 0.0f);
            this.field_178732_b = new ModelRenderer(this, 40, 32);
            this.field_178732_b.addBox(-3.0f, -2.0f, -2.0f, 4, 12, 4, llllllllllllllllllIIlllllIlllIll + 0.25f);
            this.field_178732_b.setRotationPoint(-5.0f, 2.0f, 10.0f);
        }
        this.bipedLeftLeg = new ModelRenderer(this, 16, 48);
        this.bipedLeftLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, llllllllllllllllllIIlllllIlllIll);
        this.bipedLeftLeg.setRotationPoint(1.9f, 12.0f, 0.0f);
        this.field_178733_c = new ModelRenderer(this, 0, 48);
        this.field_178733_c.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, llllllllllllllllllIIlllllIlllIll + 0.25f);
        this.field_178733_c.setRotationPoint(1.9f, 12.0f, 0.0f);
        this.field_178731_d = new ModelRenderer(this, 0, 32);
        this.field_178731_d.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, llllllllllllllllllIIlllllIlllIll + 0.25f);
        this.field_178731_d.setRotationPoint(-1.9f, 12.0f, 0.0f);
        this.field_178730_v = new ModelRenderer(this, 16, 32);
        this.field_178730_v.addBox(-4.0f, 0.0f, -2.0f, 8, 12, 4, llllllllllllllllllIIlllllIlllIll + 0.25f);
        this.field_178730_v.setRotationPoint(0.0f, 0.0f, 0.0f);
    }
    
    public void func_178728_c(final float llllllllllllllllllIIlllllIIlIlIl) {
        this.field_178729_w.render(llllllllllllllllllIIlllllIIlIlIl);
    }
}
