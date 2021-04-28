package net.minecraft.client.particle;

import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityFireworkOverlayFX extends EntityFX
{
    @Override
    public void func_180434_a(final WorldRenderer llllllllllllllllIllIIIIIlIlIllII, final Entity llllllllllllllllIllIIIIIlIllllII, final float llllllllllllllllIllIIIIIlIlIlIll, final float llllllllllllllllIllIIIIIlIlIlIlI, final float llllllllllllllllIllIIIIIlIlIlIIl, final float llllllllllllllllIllIIIIIlIlIlIII, final float llllllllllllllllIllIIIIIlIlIIlll, final float llllllllllllllllIllIIIIIlIlIIllI) {
        final float llllllllllllllllIllIIIIIlIllIlIl = 0.25f;
        final float llllllllllllllllIllIIIIIlIllIlII = llllllllllllllllIllIIIIIlIllIlIl + 0.25f;
        final float llllllllllllllllIllIIIIIlIllIIll = 0.125f;
        final float llllllllllllllllIllIIIIIlIllIIlI = llllllllllllllllIllIIIIIlIllIIll + 0.25f;
        final float llllllllllllllllIllIIIIIlIllIIIl = 7.1f * MathHelper.sin((this.particleAge + llllllllllllllllIllIIIIIlIlIlIll - 1.0f) * 0.25f * 3.1415927f);
        this.particleAlpha = 0.6f - (this.particleAge + llllllllllllllllIllIIIIIlIlIlIll - 1.0f) * 0.25f * 0.5f;
        final float llllllllllllllllIllIIIIIlIllIIII = (float)(this.prevPosX + (this.posX - this.prevPosX) * llllllllllllllllIllIIIIIlIlIlIll - EntityFireworkOverlayFX.interpPosX);
        final float llllllllllllllllIllIIIIIlIlIllll = (float)(this.prevPosY + (this.posY - this.prevPosY) * llllllllllllllllIllIIIIIlIlIlIll - EntityFireworkOverlayFX.interpPosY);
        final float llllllllllllllllIllIIIIIlIlIlllI = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * llllllllllllllllIllIIIIIlIlIlIll - EntityFireworkOverlayFX.interpPosZ);
        llllllllllllllllIllIIIIIlIlIllII.func_178960_a(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha);
        llllllllllllllllIllIIIIIlIlIllII.addVertexWithUV(llllllllllllllllIllIIIIIlIllIIII - llllllllllllllllIllIIIIIlIlIlIlI * llllllllllllllllIllIIIIIlIllIIIl - llllllllllllllllIllIIIIIlIlIIlll * llllllllllllllllIllIIIIIlIllIIIl, llllllllllllllllIllIIIIIlIlIllll - llllllllllllllllIllIIIIIlIlIlIIl * llllllllllllllllIllIIIIIlIllIIIl, llllllllllllllllIllIIIIIlIlIlllI - llllllllllllllllIllIIIIIlIlIlIII * llllllllllllllllIllIIIIIlIllIIIl - llllllllllllllllIllIIIIIlIlIIllI * llllllllllllllllIllIIIIIlIllIIIl, llllllllllllllllIllIIIIIlIllIlII, llllllllllllllllIllIIIIIlIllIIlI);
        llllllllllllllllIllIIIIIlIlIllII.addVertexWithUV(llllllllllllllllIllIIIIIlIllIIII - llllllllllllllllIllIIIIIlIlIlIlI * llllllllllllllllIllIIIIIlIllIIIl + llllllllllllllllIllIIIIIlIlIIlll * llllllllllllllllIllIIIIIlIllIIIl, llllllllllllllllIllIIIIIlIlIllll + llllllllllllllllIllIIIIIlIlIlIIl * llllllllllllllllIllIIIIIlIllIIIl, llllllllllllllllIllIIIIIlIlIlllI - llllllllllllllllIllIIIIIlIlIlIII * llllllllllllllllIllIIIIIlIllIIIl + llllllllllllllllIllIIIIIlIlIIllI * llllllllllllllllIllIIIIIlIllIIIl, llllllllllllllllIllIIIIIlIllIlII, llllllllllllllllIllIIIIIlIllIIll);
        llllllllllllllllIllIIIIIlIlIllII.addVertexWithUV(llllllllllllllllIllIIIIIlIllIIII + llllllllllllllllIllIIIIIlIlIlIlI * llllllllllllllllIllIIIIIlIllIIIl + llllllllllllllllIllIIIIIlIlIIlll * llllllllllllllllIllIIIIIlIllIIIl, llllllllllllllllIllIIIIIlIlIllll + llllllllllllllllIllIIIIIlIlIlIIl * llllllllllllllllIllIIIIIlIllIIIl, llllllllllllllllIllIIIIIlIlIlllI + llllllllllllllllIllIIIIIlIlIlIII * llllllllllllllllIllIIIIIlIllIIIl + llllllllllllllllIllIIIIIlIlIIllI * llllllllllllllllIllIIIIIlIllIIIl, llllllllllllllllIllIIIIIlIllIlIl, llllllllllllllllIllIIIIIlIllIIll);
        llllllllllllllllIllIIIIIlIlIllII.addVertexWithUV(llllllllllllllllIllIIIIIlIllIIII + llllllllllllllllIllIIIIIlIlIlIlI * llllllllllllllllIllIIIIIlIllIIIl - llllllllllllllllIllIIIIIlIlIIlll * llllllllllllllllIllIIIIIlIllIIIl, llllllllllllllllIllIIIIIlIlIllll - llllllllllllllllIllIIIIIlIlIlIIl * llllllllllllllllIllIIIIIlIllIIIl, llllllllllllllllIllIIIIIlIlIlllI + llllllllllllllllIllIIIIIlIlIlIII * llllllllllllllllIllIIIIIlIllIIIl - llllllllllllllllIllIIIIIlIlIIllI * llllllllllllllllIllIIIIIlIllIIIl, llllllllllllllllIllIIIIIlIllIlIl, llllllllllllllllIllIIIIIlIllIIlI);
    }
    
    protected EntityFireworkOverlayFX(final World llllllllllllllllIllIIIIIllIlIlll, final double llllllllllllllllIllIIIIIllIlIllI, final double llllllllllllllllIllIIIIIllIlIlIl, final double llllllllllllllllIllIIIIIllIIllll) {
        super(llllllllllllllllIllIIIIIllIlIlll, llllllllllllllllIllIIIIIllIlIllI, llllllllllllllllIllIIIIIllIlIlIl, llllllllllllllllIllIIIIIllIIllll);
        this.particleMaxAge = 4;
    }
    
    static {
        __OBFID = "CL_00000904";
    }
}
