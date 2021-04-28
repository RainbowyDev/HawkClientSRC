package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelBlaze extends ModelBase
{
    private /* synthetic */ ModelRenderer blazeHead;
    private /* synthetic */ ModelRenderer[] blazeSticks;
    
    @Override
    public void setRotationAngles(final float llllllllllllllIIlIIlIIIllIlllIIl, final float llllllllllllllIIlIIlIIIllIlllIII, final float llllllllllllllIIlIIlIIIllIllIlll, final float llllllllllllllIIlIIlIIIllIlIlllI, final float llllllllllllllIIlIIlIIIllIllIlIl, final float llllllllllllllIIlIIlIIIllIllIlII, final Entity llllllllllllllIIlIIlIIIllIllIIll) {
        float llllllllllllllIIlIIlIIIllIllIIlI = llllllllllllllIIlIIlIIIllIllIlll * 3.1415927f * -0.1f;
        for (int llllllllllllllIIlIIlIIIllIllIIIl = 0; llllllllllllllIIlIIlIIIllIllIIIl < 4; ++llllllllllllllIIlIIlIIIllIllIIIl) {
            this.blazeSticks[llllllllllllllIIlIIlIIIllIllIIIl].rotationPointY = -2.0f + MathHelper.cos((llllllllllllllIIlIIlIIIllIllIIIl * 2 + llllllllllllllIIlIIlIIIllIllIlll) * 0.25f);
            this.blazeSticks[llllllllllllllIIlIIlIIIllIllIIIl].rotationPointX = MathHelper.cos(llllllllllllllIIlIIlIIIllIllIIlI) * 9.0f;
            this.blazeSticks[llllllllllllllIIlIIlIIIllIllIIIl].rotationPointZ = MathHelper.sin(llllllllllllllIIlIIlIIIllIllIIlI) * 9.0f;
            ++llllllllllllllIIlIIlIIIllIllIIlI;
        }
        llllllllllllllIIlIIlIIIllIllIIlI = 0.7853982f + llllllllllllllIIlIIlIIIllIllIlll * 3.1415927f * 0.03f;
        for (int llllllllllllllIIlIIlIIIllIllIIIl = 4; llllllllllllllIIlIIlIIIllIllIIIl < 8; ++llllllllllllllIIlIIlIIIllIllIIIl) {
            this.blazeSticks[llllllllllllllIIlIIlIIIllIllIIIl].rotationPointY = 2.0f + MathHelper.cos((llllllllllllllIIlIIlIIIllIllIIIl * 2 + llllllllllllllIIlIIlIIIllIllIlll) * 0.25f);
            this.blazeSticks[llllllllllllllIIlIIlIIIllIllIIIl].rotationPointX = MathHelper.cos(llllllllllllllIIlIIlIIIllIllIIlI) * 7.0f;
            this.blazeSticks[llllllllllllllIIlIIlIIIllIllIIIl].rotationPointZ = MathHelper.sin(llllllllllllllIIlIIlIIIllIllIIlI) * 7.0f;
            ++llllllllllllllIIlIIlIIIllIllIIlI;
        }
        llllllllllllllIIlIIlIIIllIllIIlI = 0.47123894f + llllllllllllllIIlIIlIIIllIllIlll * 3.1415927f * -0.05f;
        for (int llllllllllllllIIlIIlIIIllIllIIIl = 8; llllllllllllllIIlIIlIIIllIllIIIl < 12; ++llllllllllllllIIlIIlIIIllIllIIIl) {
            this.blazeSticks[llllllllllllllIIlIIlIIIllIllIIIl].rotationPointY = 11.0f + MathHelper.cos((llllllllllllllIIlIIlIIIllIllIIIl * 1.5f + llllllllllllllIIlIIlIIIllIllIlll) * 0.5f);
            this.blazeSticks[llllllllllllllIIlIIlIIIllIllIIIl].rotationPointX = MathHelper.cos(llllllllllllllIIlIIlIIIllIllIIlI) * 5.0f;
            this.blazeSticks[llllllllllllllIIlIIlIIIllIllIIIl].rotationPointZ = MathHelper.sin(llllllllllllllIIlIIlIIIllIllIIlI) * 5.0f;
            ++llllllllllllllIIlIIlIIIllIllIIlI;
        }
        this.blazeHead.rotateAngleY = llllllllllllllIIlIIlIIIllIlIlllI / 57.295776f;
        this.blazeHead.rotateAngleX = llllllllllllllIIlIIlIIIllIllIlIl / 57.295776f;
    }
    
    static {
        __OBFID = "CL_00000831";
    }
    
    public ModelBlaze() {
        this.blazeSticks = new ModelRenderer[12];
        for (int llllllllllllllIIlIIlIIIlllIllllI = 0; llllllllllllllIIlIIlIIIlllIllllI < this.blazeSticks.length; ++llllllllllllllIIlIIlIIIlllIllllI) {
            (this.blazeSticks[llllllllllllllIIlIIlIIIlllIllllI] = new ModelRenderer(this, 0, 16)).addBox(0.0f, 0.0f, 0.0f, 2, 8, 2);
        }
        this.blazeHead = new ModelRenderer(this, 0, 0);
        this.blazeHead.addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8);
    }
    
    @Override
    public void render(final Entity llllllllllllllIIlIIlIIIlllIIlIII, final float llllllllllllllIIlIIlIIIlllIlIIII, final float llllllllllllllIIlIIlIIIlllIIIllI, final float llllllllllllllIIlIIlIIIlllIIlllI, final float llllllllllllllIIlIIlIIIlllIIIlII, final float llllllllllllllIIlIIlIIIlllIIIIll, final float llllllllllllllIIlIIlIIIlllIIlIll) {
        this.setRotationAngles(llllllllllllllIIlIIlIIIlllIlIIII, llllllllllllllIIlIIlIIIlllIIIllI, llllllllllllllIIlIIlIIIlllIIlllI, llllllllllllllIIlIIlIIIlllIIIlII, llllllllllllllIIlIIlIIIlllIIIIll, llllllllllllllIIlIIlIIIlllIIlIll, llllllllllllllIIlIIlIIIlllIIlIII);
        this.blazeHead.render(llllllllllllllIIlIIlIIIlllIIlIll);
        for (int llllllllllllllIIlIIlIIIlllIIlIlI = 0; llllllllllllllIIlIIlIIIlllIIlIlI < this.blazeSticks.length; ++llllllllllllllIIlIIlIIIlllIIlIlI) {
            this.blazeSticks[llllllllllllllIIlIIlIIIlllIIlIlI].render(llllllllllllllIIlIIlIIIlllIIlIll);
        }
    }
}
