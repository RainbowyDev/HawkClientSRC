package net.minecraft.client.model;

import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;

public class ModelMagmaCube extends ModelBase
{
    /* synthetic */ ModelRenderer[] segments;
    /* synthetic */ ModelRenderer core;
    
    public ModelMagmaCube() {
        this.segments = new ModelRenderer[8];
        for (int llllllllllllllIlIlIIIllIIIllIlll = 0; llllllllllllllIlIlIIIllIIIllIlll < this.segments.length; ++llllllllllllllIlIlIIIllIIIllIlll) {
            byte llllllllllllllIlIlIIIllIIIllIllI = 0;
            int llllllllllllllIlIlIIIllIIIllIlIl;
            if ((llllllllllllllIlIlIIIllIIIllIlIl = llllllllllllllIlIlIIIllIIIllIlll) == 2) {
                llllllllllllllIlIlIIIllIIIllIllI = 24;
                llllllllllllllIlIlIIIllIIIllIlIl = 10;
            }
            else if (llllllllllllllIlIlIIIllIIIllIlll == 3) {
                llllllllllllllIlIlIIIllIIIllIllI = 24;
                llllllllllllllIlIlIIIllIIIllIlIl = 19;
            }
            (this.segments[llllllllllllllIlIlIIIllIIIllIlll] = new ModelRenderer(this, llllllllllllllIlIlIIIllIIIllIllI, llllllllllllllIlIlIIIllIIIllIlIl)).addBox(-4.0f, (float)(16 + llllllllllllllIlIlIIIllIIIllIlll), -4.0f, 8, 1, 8);
        }
        this.core = new ModelRenderer(this, 0, 16);
        this.core.addBox(-2.0f, 18.0f, -2.0f, 4, 4, 4);
    }
    
    @Override
    public void setLivingAnimations(final EntityLivingBase llllllllllllllIlIlIIIllIIIlIIIIl, final float llllllllllllllIlIlIIIllIIIlIlIII, final float llllllllllllllIlIlIIIllIIIlIIlll, final float llllllllllllllIlIlIIIllIIIlIIllI) {
        final EntityMagmaCube llllllllllllllIlIlIIIllIIIlIIlIl = (EntityMagmaCube)llllllllllllllIlIlIIIllIIIlIIIIl;
        float llllllllllllllIlIlIIIllIIIlIIlII = llllllllllllllIlIlIIIllIIIlIIlIl.prevSquishFactor + (llllllllllllllIlIlIIIllIIIlIIlIl.squishFactor - llllllllllllllIlIlIIIllIIIlIIlIl.prevSquishFactor) * llllllllllllllIlIlIIIllIIIlIIllI;
        if (llllllllllllllIlIlIIIllIIIlIIlII < 0.0f) {
            llllllllllllllIlIlIIIllIIIlIIlII = 0.0f;
        }
        for (int llllllllllllllIlIlIIIllIIIlIIIll = 0; llllllllllllllIlIlIIIllIIIlIIIll < this.segments.length; ++llllllllllllllIlIlIIIllIIIlIIIll) {
            this.segments[llllllllllllllIlIlIIIllIIIlIIIll].rotationPointY = -(4 - llllllllllllllIlIlIIIllIIIlIIIll) * llllllllllllllIlIlIIIllIIIlIIlII * 1.7f;
        }
    }
    
    @Override
    public void render(final Entity llllllllllllllIlIlIIIllIIIIIlIIl, final float llllllllllllllIlIlIIIllIIIIIlIII, final float llllllllllllllIlIlIIIllIIIIlIIII, final float llllllllllllllIlIlIIIllIIIIIllll, final float llllllllllllllIlIlIIIllIIIIIlllI, final float llllllllllllllIlIlIIIllIIIIIllIl, final float llllllllllllllIlIlIIIllIIIIIIIll) {
        this.setRotationAngles(llllllllllllllIlIlIIIllIIIIIlIII, llllllllllllllIlIlIIIllIIIIlIIII, llllllllllllllIlIlIIIllIIIIIllll, llllllllllllllIlIlIIIllIIIIIlllI, llllllllllllllIlIlIIIllIIIIIllIl, llllllllllllllIlIlIIIllIIIIIIIll, llllllllllllllIlIlIIIllIIIIIlIIl);
        this.core.render(llllllllllllllIlIlIIIllIIIIIIIll);
        for (int llllllllllllllIlIlIIIllIIIIIlIll = 0; llllllllllllllIlIlIIIllIIIIIlIll < this.segments.length; ++llllllllllllllIlIlIIIllIIIIIlIll) {
            this.segments[llllllllllllllIlIlIIIllIIIIIlIll].render(llllllllllllllIlIlIIIllIIIIIIIll);
        }
    }
    
    static {
        __OBFID = "CL_00000842";
    }
}
