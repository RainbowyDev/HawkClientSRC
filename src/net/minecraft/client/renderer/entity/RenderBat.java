package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;

public class RenderBat extends RenderLiving
{
    private static final /* synthetic */ ResourceLocation batTextures;
    
    public RenderBat(final RenderManager llllllllllllllllllIlllIlIlllIIII) {
        super(llllllllllllllllllIlllIlIlllIIII, new ModelBat(), 0.25f);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllllllllIlllIlIIlllllI) {
        return this.func_180566_a((EntityBat)llllllllllllllllllIlllIlIIlllllI);
    }
    
    @Override
    protected void preRenderCallback(final EntityLivingBase llllllllllllllllllIlllIlIlIlIIlI, final float llllllllllllllllllIlllIlIlIlIIIl) {
        this.func_180567_a((EntityBat)llllllllllllllllllIlllIlIlIlIIlI, llllllllllllllllllIlllIlIlIlIIIl);
    }
    
    protected void rotateCorpse(final EntityBat llllllllllllllllllIlllIlIlIlllIl, final float llllllllllllllllllIlllIlIllIIIIl, final float llllllllllllllllllIlllIlIlIllIll, final float llllllllllllllllllIlllIlIlIllIlI) {
        if (!llllllllllllllllllIlllIlIlIlllIl.getIsBatHanging()) {
            GlStateManager.translate(0.0f, MathHelper.cos(llllllllllllllllllIlllIlIllIIIIl * 0.3f) * 0.1f, 0.0f);
        }
        else {
            GlStateManager.translate(0.0f, -0.1f, 0.0f);
        }
        super.rotateCorpse(llllllllllllllllllIlllIlIlIlllIl, llllllllllllllllllIlllIlIllIIIIl, llllllllllllllllllIlllIlIlIllIll, llllllllllllllllllIlllIlIlIllIlI);
    }
    
    protected ResourceLocation func_180566_a(final EntityBat llllllllllllllllllIlllIlIllIllII) {
        return RenderBat.batTextures;
    }
    
    protected void func_180567_a(final EntityBat llllllllllllllllllIlllIlIllIlIlI, final float llllllllllllllllllIlllIlIllIlIIl) {
        GlStateManager.scale(0.35f, 0.35f, 0.35f);
    }
    
    static {
        __OBFID = "CL_00000979";
        batTextures = new ResourceLocation("textures/entity/bat.png");
    }
    
    @Override
    protected void rotateCorpse(final EntityLivingBase llllllllllllllllllIlllIlIlIIIlIl, final float llllllllllllllllllIlllIlIlIIIlII, final float llllllllllllllllllIlllIlIlIIIIll, final float llllllllllllllllllIlllIlIlIIIlll) {
        this.rotateCorpse((EntityBat)llllllllllllllllllIlllIlIlIIIlIl, llllllllllllllllllIlllIlIlIIIlII, llllllllllllllllllIlllIlIlIIIIll, llllllllllllllllllIlllIlIlIIIlll);
    }
}
