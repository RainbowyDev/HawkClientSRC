package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.model.*;

public class RenderMagmaCube extends RenderLiving
{
    private static final /* synthetic */ ResourceLocation magmaCubeTextures;
    
    @Override
    protected void preRenderCallback(final EntityLivingBase llllllllllllllllIIIIlllIllIIlIll, final float llllllllllllllllIIIIlllIllIIlIlI) {
        this.preRenderCallback((EntityMagmaCube)llllllllllllllllIIIIlllIllIIlIll, llllllllllllllllIIIIlllIllIIlIlI);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllllllIIIIlllIllIIIIll) {
        return this.getEntityTexture((EntityMagmaCube)llllllllllllllllIIIIlllIllIIIIll);
    }
    
    protected void preRenderCallback(final EntityMagmaCube llllllllllllllllIIIIlllIllIllIll, final float llllllllllllllllIIIIlllIllIlIlII) {
        final int llllllllllllllllIIIIlllIllIllIIl = llllllllllllllllIIIIlllIllIllIll.getSlimeSize();
        final float llllllllllllllllIIIIlllIllIllIII = (llllllllllllllllIIIIlllIllIllIll.prevSquishFactor + (llllllllllllllllIIIIlllIllIllIll.squishFactor - llllllllllllllllIIIIlllIllIllIll.prevSquishFactor) * llllllllllllllllIIIIlllIllIlIlII) / (llllllllllllllllIIIIlllIllIllIIl * 0.5f + 1.0f);
        final float llllllllllllllllIIIIlllIllIlIlll = 1.0f / (llllllllllllllllIIIIlllIllIllIII + 1.0f);
        final float llllllllllllllllIIIIlllIllIlIllI = (float)llllllllllllllllIIIIlllIllIllIIl;
        GlStateManager.scale(llllllllllllllllIIIIlllIllIlIlll * llllllllllllllllIIIIlllIllIlIllI, 1.0f / llllllllllllllllIIIIlllIllIlIlll * llllllllllllllllIIIIlllIllIlIllI, llllllllllllllllIIIIlllIllIlIlll * llllllllllllllllIIIIlllIllIlIllI);
    }
    
    static {
        __OBFID = "CL_00001009";
        magmaCubeTextures = new ResourceLocation("textures/entity/slime/magmacube.png");
    }
    
    public RenderMagmaCube(final RenderManager llllllllllllllllIIIIlllIlllIIlll) {
        super(llllllllllllllllIIIIlllIlllIIlll, new ModelMagmaCube(), 0.25f);
    }
    
    protected ResourceLocation getEntityTexture(final EntityMagmaCube llllllllllllllllIIIIlllIlllIIIll) {
        return RenderMagmaCube.magmaCubeTextures;
    }
}
