package net.minecraft.client.model;

import net.minecraft.entity.*;

public class ModelSquid extends ModelBase
{
    /* synthetic */ ModelRenderer squidBody;
    /* synthetic */ ModelRenderer[] squidTentacles;
    
    public ModelSquid() {
        this.squidTentacles = new ModelRenderer[8];
        final byte llllllllllllllIlIIlIlIllIlllIlII = -16;
        this.squidBody = new ModelRenderer(this, 0, 0);
        this.squidBody.addBox(-6.0f, -8.0f, -6.0f, 12, 16, 12);
        final ModelRenderer squidBody = this.squidBody;
        squidBody.rotationPointY += 24 + llllllllllllllIlIIlIlIllIlllIlII;
        for (int llllllllllllllIlIIlIlIllIlllIIll = 0; llllllllllllllIlIIlIlIllIlllIIll < this.squidTentacles.length; ++llllllllllllllIlIIlIlIllIlllIIll) {
            this.squidTentacles[llllllllllllllIlIIlIlIllIlllIIll] = new ModelRenderer(this, 48, 0);
            double llllllllllllllIlIIlIlIllIlllIIlI = llllllllllllllIlIIlIlIllIlllIIll * 3.141592653589793 * 2.0 / this.squidTentacles.length;
            final float llllllllllllllIlIIlIlIllIlllIIIl = (float)Math.cos(llllllllllllllIlIIlIlIllIlllIIlI) * 5.0f;
            final float llllllllllllllIlIIlIlIllIlllIIII = (float)Math.sin(llllllllllllllIlIIlIlIllIlllIIlI) * 5.0f;
            this.squidTentacles[llllllllllllllIlIIlIlIllIlllIIll].addBox(-1.0f, 0.0f, -1.0f, 2, 18, 2);
            this.squidTentacles[llllllllllllllIlIIlIlIllIlllIIll].rotationPointX = llllllllllllllIlIIlIlIllIlllIIIl;
            this.squidTentacles[llllllllllllllIlIIlIlIllIlllIIll].rotationPointZ = llllllllllllllIlIIlIlIllIlllIIII;
            this.squidTentacles[llllllllllllllIlIIlIlIllIlllIIll].rotationPointY = (float)(31 + llllllllllllllIlIIlIlIllIlllIlII);
            llllllllllllllIlIIlIlIllIlllIIlI = llllllllllllllIlIIlIlIllIlllIIll * 3.141592653589793 * -2.0 / this.squidTentacles.length + 1.5707963267948966;
            this.squidTentacles[llllllllllllllIlIIlIlIllIlllIIll].rotateAngleY = (float)llllllllllllllIlIIlIlIllIlllIIlI;
        }
    }
    
    @Override
    public void render(final Entity llllllllllllllIlIIlIlIllIIlllllI, final float llllllllllllllIlIIlIlIllIIllllIl, final float llllllllllllllIlIIlIlIllIlIIIlIl, final float llllllllllllllIlIIlIlIllIlIIIlII, final float llllllllllllllIlIIlIlIllIIlllIlI, final float llllllllllllllIlIIlIlIllIlIIIIlI, final float llllllllllllllIlIIlIlIllIlIIIIIl) {
        this.setRotationAngles(llllllllllllllIlIIlIlIllIIllllIl, llllllllllllllIlIIlIlIllIlIIIlIl, llllllllllllllIlIIlIlIllIlIIIlII, llllllllllllllIlIIlIlIllIIlllIlI, llllllllllllllIlIIlIlIllIlIIIIlI, llllllllllllllIlIIlIlIllIlIIIIIl, llllllllllllllIlIIlIlIllIIlllllI);
        this.squidBody.render(llllllllllllllIlIIlIlIllIlIIIIIl);
        for (int llllllllllllllIlIIlIlIllIlIIIIII = 0; llllllllllllllIlIIlIlIllIlIIIIII < this.squidTentacles.length; ++llllllllllllllIlIIlIlIllIlIIIIII) {
            this.squidTentacles[llllllllllllllIlIIlIlIllIlIIIIII].render(llllllllllllllIlIIlIlIllIlIIIIIl);
        }
    }
    
    static {
        __OBFID = "CL_00000861";
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllllIlIIlIlIllIllIIIlI, final float llllllllllllllIlIIlIlIllIllIIIIl, final float llllllllllllllIlIIlIlIllIlIlIllI, final float llllllllllllllIlIIlIlIllIlIlllll, final float llllllllllllllIlIIlIlIllIlIllllI, final float llllllllllllllIlIIlIlIllIlIlllIl, final Entity llllllllllllllIlIIlIlIllIlIlllII) {
        for (final ModelRenderer llllllllllllllIlIIlIlIllIlIllIII : this.squidTentacles) {
            llllllllllllllIlIIlIlIllIlIllIII.rotateAngleX = llllllllllllllIlIIlIlIllIlIlIllI;
        }
    }
}
