package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.client.model.*;

public class RenderGhast extends RenderLiving
{
    private static final /* synthetic */ ResourceLocation ghastTextures;
    private static final /* synthetic */ ResourceLocation ghastShootingTextures;
    
    static {
        __OBFID = "CL_00000997";
        ghastTextures = new ResourceLocation("textures/entity/ghast/ghast.png");
        ghastShootingTextures = new ResourceLocation("textures/entity/ghast/ghast_shooting.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllllIIlIIIlIIlIIIIIIIl) {
        return this.func_180576_a((EntityGhast)llllllllllllllIIlIIIlIIlIIIIIIIl);
    }
    
    protected void preRenderCallback(final EntityGhast llllllllllllllIIlIIIlIIlIIIlIlll, final float llllllllllllllIIlIIIlIIlIIIlIllI) {
        final float llllllllllllllIIlIIIlIIlIIIlIlIl = 1.0f;
        final float llllllllllllllIIlIIIlIIlIIIlIlII = (8.0f + llllllllllllllIIlIIIlIIlIIIlIlIl) / 2.0f;
        final float llllllllllllllIIlIIIlIIlIIIlIIll = (8.0f + 1.0f / llllllllllllllIIlIIIlIIlIIIlIlIl) / 2.0f;
        GlStateManager.scale(llllllllllllllIIlIIIlIIlIIIlIIll, llllllllllllllIIlIIIlIIlIIIlIlII, llllllllllllllIIlIIIlIIlIIIlIIll);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    @Override
    protected void preRenderCallback(final EntityLivingBase llllllllllllllIIlIIIlIIlIIIIlIII, final float llllllllllllllIIlIIIlIIlIIIIIlll) {
        this.preRenderCallback((EntityGhast)llllllllllllllIIlIIIlIIlIIIIlIII, llllllllllllllIIlIIIlIIlIIIIIlll);
    }
    
    public RenderGhast(final RenderManager llllllllllllllIIlIIIlIIlIIlIIlIl) {
        super(llllllllllllllIIlIIIlIIlIIlIIlIl, new ModelGhast(), 0.5f);
    }
    
    protected ResourceLocation func_180576_a(final EntityGhast llllllllllllllIIlIIIlIIlIIIlllII) {
        return llllllllllllllIIlIIIlIIlIIIlllII.func_110182_bF() ? RenderGhast.ghastShootingTextures : RenderGhast.ghastTextures;
    }
}
