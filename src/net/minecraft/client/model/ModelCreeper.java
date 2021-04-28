package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelCreeper extends ModelBase
{
    public /* synthetic */ ModelRenderer leg2;
    public /* synthetic */ ModelRenderer head;
    public /* synthetic */ ModelRenderer creeperArmor;
    public /* synthetic */ ModelRenderer body;
    public /* synthetic */ ModelRenderer leg4;
    public /* synthetic */ ModelRenderer leg3;
    public /* synthetic */ ModelRenderer leg1;
    
    @Override
    public void render(final Entity llllllllllllllIIIIlIllIIIlIlIlll, final float llllllllllllllIIIIlIllIIIlIIlllI, final float llllllllllllllIIIIlIllIIIlIIllIl, final float llllllllllllllIIIIlIllIIIlIIllII, final float llllllllllllllIIIIlIllIIIlIIlIll, final float llllllllllllllIIIIlIllIIIlIIlIlI, final float llllllllllllllIIIIlIllIIIlIlIIIl) {
        this.setRotationAngles(llllllllllllllIIIIlIllIIIlIIlllI, llllllllllllllIIIIlIllIIIlIIllIl, llllllllllllllIIIIlIllIIIlIIllII, llllllllllllllIIIIlIllIIIlIIlIll, llllllllllllllIIIIlIllIIIlIIlIlI, llllllllllllllIIIIlIllIIIlIlIIIl, llllllllllllllIIIIlIllIIIlIlIlll);
        this.head.render(llllllllllllllIIIIlIllIIIlIlIIIl);
        this.body.render(llllllllllllllIIIIlIllIIIlIlIIIl);
        this.leg1.render(llllllllllllllIIIIlIllIIIlIlIIIl);
        this.leg2.render(llllllllllllllIIIIlIllIIIlIlIIIl);
        this.leg3.render(llllllllllllllIIIIlIllIIIlIlIIIl);
        this.leg4.render(llllllllllllllIIIIlIllIIIlIlIIIl);
    }
    
    public ModelCreeper() {
        this(0.0f);
    }
    
    static {
        __OBFID = "CL_00000837";
    }
    
    public ModelCreeper(final float llllllllllllllIIIIlIllIIIllIIIlI) {
        final byte llllllllllllllIIIIlIllIIIllIIlII = 6;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, llllllllllllllIIIIlIllIIIllIIIlI);
        this.head.setRotationPoint(0.0f, llllllllllllllIIIIlIllIIIllIIlII, 0.0f);
        this.creeperArmor = new ModelRenderer(this, 32, 0);
        this.creeperArmor.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, llllllllllllllIIIIlIllIIIllIIIlI + 0.5f);
        this.creeperArmor.setRotationPoint(0.0f, llllllllllllllIIIIlIllIIIllIIlII, 0.0f);
        this.body = new ModelRenderer(this, 16, 16);
        this.body.addBox(-4.0f, 0.0f, -2.0f, 8, 12, 4, llllllllllllllIIIIlIllIIIllIIIlI);
        this.body.setRotationPoint(0.0f, llllllllllllllIIIIlIllIIIllIIlII, 0.0f);
        this.leg1 = new ModelRenderer(this, 0, 16);
        this.leg1.addBox(-2.0f, 0.0f, -2.0f, 4, 6, 4, llllllllllllllIIIIlIllIIIllIIIlI);
        this.leg1.setRotationPoint(-2.0f, (float)(12 + llllllllllllllIIIIlIllIIIllIIlII), 4.0f);
        this.leg2 = new ModelRenderer(this, 0, 16);
        this.leg2.addBox(-2.0f, 0.0f, -2.0f, 4, 6, 4, llllllllllllllIIIIlIllIIIllIIIlI);
        this.leg2.setRotationPoint(2.0f, (float)(12 + llllllllllllllIIIIlIllIIIllIIlII), 4.0f);
        this.leg3 = new ModelRenderer(this, 0, 16);
        this.leg3.addBox(-2.0f, 0.0f, -2.0f, 4, 6, 4, llllllllllllllIIIIlIllIIIllIIIlI);
        this.leg3.setRotationPoint(-2.0f, (float)(12 + llllllllllllllIIIIlIllIIIllIIlII), -4.0f);
        this.leg4 = new ModelRenderer(this, 0, 16);
        this.leg4.addBox(-2.0f, 0.0f, -2.0f, 4, 6, 4, llllllllllllllIIIIlIllIIIllIIIlI);
        this.leg4.setRotationPoint(2.0f, (float)(12 + llllllllllllllIIIIlIllIIIllIIlII), -4.0f);
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllllIIIIlIllIIIlIIIIlI, final float llllllllllllllIIIIlIllIIIIlllIIl, final float llllllllllllllIIIIlIllIIIlIIIIII, final float llllllllllllllIIIIlIllIIIIllllll, final float llllllllllllllIIIIlIllIIIIllIlll, final float llllllllllllllIIIIlIllIIIIllllIl, final Entity llllllllllllllIIIIlIllIIIIllllII) {
        this.head.rotateAngleY = llllllllllllllIIIIlIllIIIIllllll / 57.295776f;
        this.head.rotateAngleX = llllllllllllllIIIIlIllIIIIllIlll / 57.295776f;
        this.leg1.rotateAngleX = MathHelper.cos(llllllllllllllIIIIlIllIIIlIIIIlI * 0.6662f) * 1.4f * llllllllllllllIIIIlIllIIIIlllIIl;
        this.leg2.rotateAngleX = MathHelper.cos(llllllllllllllIIIIlIllIIIlIIIIlI * 0.6662f + 3.1415927f) * 1.4f * llllllllllllllIIIIlIllIIIIlllIIl;
        this.leg3.rotateAngleX = MathHelper.cos(llllllllllllllIIIIlIllIIIlIIIIlI * 0.6662f + 3.1415927f) * 1.4f * llllllllllllllIIIIlIllIIIIlllIIl;
        this.leg4.rotateAngleX = MathHelper.cos(llllllllllllllIIIIlIllIIIlIIIIlI * 0.6662f) * 1.4f * llllllllllllllIIIIlIllIIIIlllIIl;
    }
}
