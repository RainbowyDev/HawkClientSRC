package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import java.util.*;
import net.minecraft.util.*;

public class ModelGhast extends ModelBase
{
    /* synthetic */ ModelRenderer body;
    /* synthetic */ ModelRenderer[] tentacles;
    
    static {
        __OBFID = "CL_00000839";
    }
    
    @Override
    public void render(final Entity llllllllllllllIIIIIIllIIlIlIlIII, final float llllllllllllllIIIIIIllIIlIIllIll, final float llllllllllllllIIIIIIllIIlIIllIlI, final float llllllllllllllIIIIIIllIIlIIllIIl, final float llllllllllllllIIIIIIllIIlIIllIII, final float llllllllllllllIIIIIIllIIlIlIIIll, final float llllllllllllllIIIIIIllIIlIIlIllI) {
        this.setRotationAngles(llllllllllllllIIIIIIllIIlIIllIll, llllllllllllllIIIIIIllIIlIIllIlI, llllllllllllllIIIIIIllIIlIIllIIl, llllllllllllllIIIIIIllIIlIIllIII, llllllllllllllIIIIIIllIIlIlIIIll, llllllllllllllIIIIIIllIIlIIlIllI, llllllllllllllIIIIIIllIIlIlIlIII);
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0f, 0.6f, 0.0f);
        this.body.render(llllllllllllllIIIIIIllIIlIIlIllI);
        for (final ModelRenderer llllllllllllllIIIIIIllIIlIIllllI : this.tentacles) {
            llllllllllllllIIIIIIllIIlIIllllI.render(llllllllllllllIIIIIIllIIlIIlIllI);
        }
        GlStateManager.popMatrix();
    }
    
    public ModelGhast() {
        this.tentacles = new ModelRenderer[9];
        final byte llllllllllllllIIIIIIllIIllIlIIIl = -16;
        this.body = new ModelRenderer(this, 0, 0);
        this.body.addBox(-8.0f, -8.0f, -8.0f, 16, 16, 16);
        final ModelRenderer body = this.body;
        body.rotationPointY += 24 + llllllllllllllIIIIIIllIIllIlIIIl;
        final Random llllllllllllllIIIIIIllIIllIlIIII = new Random(1660L);
        for (int llllllllllllllIIIIIIllIIllIIllll = 0; llllllllllllllIIIIIIllIIllIIllll < this.tentacles.length; ++llllllllllllllIIIIIIllIIllIIllll) {
            this.tentacles[llllllllllllllIIIIIIllIIllIIllll] = new ModelRenderer(this, 0, 0);
            final float llllllllllllllIIIIIIllIIllIIlllI = ((llllllllllllllIIIIIIllIIllIIllll % 3 - llllllllllllllIIIIIIllIIllIIllll / 3 % 2 * 0.5f + 0.25f) / 2.0f * 2.0f - 1.0f) * 5.0f;
            final float llllllllllllllIIIIIIllIIllIIllIl = (llllllllllllllIIIIIIllIIllIIllll / 3 / 2.0f * 2.0f - 1.0f) * 5.0f;
            final int llllllllllllllIIIIIIllIIllIIllII = llllllllllllllIIIIIIllIIllIlIIII.nextInt(7) + 8;
            this.tentacles[llllllllllllllIIIIIIllIIllIIllll].addBox(-1.0f, 0.0f, -1.0f, 2, llllllllllllllIIIIIIllIIllIIllII, 2);
            this.tentacles[llllllllllllllIIIIIIllIIllIIllll].rotationPointX = llllllllllllllIIIIIIllIIllIIlllI;
            this.tentacles[llllllllllllllIIIIIIllIIllIIllll].rotationPointZ = llllllllllllllIIIIIIllIIllIIllIl;
            this.tentacles[llllllllllllllIIIIIIllIIllIIllll].rotationPointY = (float)(31 + llllllllllllllIIIIIIllIIllIlIIIl);
        }
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllllIIIIIIllIIllIIIIII, final float llllllllllllllIIIIIIllIIlIllllll, final float llllllllllllllIIIIIIllIIlIllIlll, final float llllllllllllllIIIIIIllIIlIllllIl, final float llllllllllllllIIIIIIllIIlIllllII, final float llllllllllllllIIIIIIllIIlIlllIll, final Entity llllllllllllllIIIIIIllIIlIlllIlI) {
        for (int llllllllllllllIIIIIIllIIlIlllIIl = 0; llllllllllllllIIIIIIllIIlIlllIIl < this.tentacles.length; ++llllllllllllllIIIIIIllIIlIlllIIl) {
            this.tentacles[llllllllllllllIIIIIIllIIlIlllIIl].rotateAngleX = 0.2f * MathHelper.sin(llllllllllllllIIIIIIllIIlIllIlll * 0.3f + llllllllllllllIIIIIIllIIlIlllIIl) + 0.4f;
        }
    }
}
