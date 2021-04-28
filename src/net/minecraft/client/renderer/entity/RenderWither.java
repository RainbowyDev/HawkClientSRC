package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;

public class RenderWither extends RenderLiving
{
    private static final /* synthetic */ ResourceLocation invulnerableWitherTextures;
    private static final /* synthetic */ ResourceLocation witherTextures;
    
    @Override
    public void doRender(final Entity llllllllllllllllIllllIllIIIllIlI, final double llllllllllllllllIllllIllIIIllIIl, final double llllllllllllllllIllllIllIIIlIIIl, final double llllllllllllllllIllllIllIIIlIlll, final float llllllllllllllllIllllIllIIIIllll, final float llllllllllllllllIllllIllIIIIlllI) {
        this.func_180591_a((EntityWither)llllllllllllllllIllllIllIIIllIlI, llllllllllllllllIllllIllIIIllIIl, llllllllllllllllIllllIllIIIlIIIl, llllllllllllllllIllllIllIIIlIlll, llllllllllllllllIllllIllIIIIllll, llllllllllllllllIllllIllIIIIlllI);
    }
    
    protected void func_180592_a(final EntityWither llllllllllllllllIllllIllIllIIIll, final float llllllllllllllllIllllIllIlIllllI) {
        float llllllllllllllllIllllIllIllIIIIl = 2.0f;
        final int llllllllllllllllIllllIllIllIIIII = llllllllllllllllIllllIllIllIIIll.getInvulTime();
        if (llllllllllllllllIllllIllIllIIIII > 0) {
            llllllllllllllllIllllIllIllIIIIl -= (llllllllllllllllIllllIllIllIIIII - llllllllllllllllIllllIllIlIllllI) / 220.0f * 0.5f;
        }
        GlStateManager.scale(llllllllllllllllIllllIllIllIIIIl, llllllllllllllllIllllIllIllIIIIl, llllllllllllllllIllllIllIllIIIIl);
    }
    
    static {
        __OBFID = "CL_00001034";
        invulnerableWitherTextures = new ResourceLocation("textures/entity/wither/wither_invulnerable.png");
        witherTextures = new ResourceLocation("textures/entity/wither/wither.png");
    }
    
    public void func_180591_a(final EntityWither llllllllllllllllIllllIllIlllIlIl, final double llllllllllllllllIllllIllIlllIlII, final double llllllllllllllllIllllIllIlllIIll, final double llllllllllllllllIllllIllIlllIIlI, final float llllllllllllllllIllllIllIlllIIIl, final float llllllllllllllllIllllIllIlllIIII) {
        BossStatus.setBossStatus(llllllllllllllllIllllIllIlllIlIl, true);
        super.doRender(llllllllllllllllIllllIllIlllIlIl, llllllllllllllllIllllIllIlllIlII, llllllllllllllllIllllIllIlllIIll, llllllllllllllllIllllIllIlllIIlI, llllllllllllllllIllllIllIlllIIIl, llllllllllllllllIllllIllIlllIIII);
    }
    
    @Override
    protected void preRenderCallback(final EntityLivingBase llllllllllllllllIllllIllIIllllll, final float llllllllllllllllIllllIllIIlllllI) {
        this.func_180592_a((EntityWither)llllllllllllllllIllllIllIIllllll, llllllllllllllllIllllIllIIlllllI);
    }
    
    @Override
    public void doRender(final EntityLiving llllllllllllllllIllllIllIlIlIIll, final double llllllllllllllllIllllIllIlIIlIll, final double llllllllllllllllIllllIllIlIlIIIl, final double llllllllllllllllIllllIllIlIlIIII, final float llllllllllllllllIllllIllIlIIllll, final float llllllllllllllllIllllIllIlIIlllI) {
        this.func_180591_a((EntityWither)llllllllllllllllIllllIllIlIlIIll, llllllllllllllllIllllIllIlIIlIll, llllllllllllllllIllllIllIlIlIIIl, llllllllllllllllIllllIllIlIlIIII, llllllllllllllllIllllIllIlIIllll, llllllllllllllllIllllIllIlIIlllI);
    }
    
    @Override
    public void doRender(final EntityLivingBase llllllllllllllllIllllIllIIlIlllI, final double llllllllllllllllIllllIllIIlIllIl, final double llllllllllllllllIllllIllIIlIllII, final double llllllllllllllllIllllIllIIlIlIll, final float llllllllllllllllIllllIllIIlIlIlI, final float llllllllllllllllIllllIllIIlIlIIl) {
        this.func_180591_a((EntityWither)llllllllllllllllIllllIllIIlIlllI, llllllllllllllllIllllIllIIlIllIl, llllllllllllllllIllllIllIIlIllII, llllllllllllllllIllllIllIIlIlIll, llllllllllllllllIllllIllIIlIlIlI, llllllllllllllllIllllIllIIlIlIIl);
    }
    
    protected ResourceLocation getEntityTexture(final EntityWither llllllllllllllllIllllIllIllIllII) {
        final int llllllllllllllllIllllIllIllIlIll = llllllllllllllllIllllIllIllIllII.getInvulTime();
        return (llllllllllllllllIllllIllIllIlIll > 0 && (llllllllllllllllIllllIllIllIlIll > 80 || llllllllllllllllIllllIllIllIlIll / 5 % 2 != 1)) ? RenderWither.invulnerableWitherTextures : RenderWither.witherTextures;
    }
    
    public RenderWither(final RenderManager llllllllllllllllIllllIlllIIIIlIl) {
        super(llllllllllllllllIllllIlllIIIIlIl, new ModelWither(0.0f), 1.0f);
        this.addLayer(new LayerWitherAura(this));
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllllllIllllIllIIlIIIll) {
        return this.getEntityTexture((EntityWither)llllllllllllllllIllllIllIIlIIIll);
    }
}
