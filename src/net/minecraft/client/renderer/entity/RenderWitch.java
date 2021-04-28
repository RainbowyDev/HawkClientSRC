package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;

public class RenderWitch extends RenderLiving
{
    private static final /* synthetic */ ResourceLocation witchTextures;
    
    @Override
    public void doRender(final Entity llllllllllllllIIIIIIIlllIIIIlIlI, final double llllllllllllllIIIIIIIlllIIIIlIIl, final double llllllllllllllIIIIIIIlllIIIIllll, final double llllllllllllllIIIIIIIlllIIIIlllI, final float llllllllllllllIIIIIIIlllIIIIllIl, final float llllllllllllllIIIIIIIlllIIIIllII) {
        this.func_180590_a((EntityWitch)llllllllllllllIIIIIIIlllIIIIlIlI, llllllllllllllIIIIIIIlllIIIIlIIl, llllllllllllllIIIIIIIlllIIIIllll, llllllllllllllIIIIIIIlllIIIIlllI, llllllllllllllIIIIIIIlllIIIIllIl, llllllllllllllIIIIIIIlllIIIIllII);
    }
    
    public void func_180590_a(final EntityWitch llllllllllllllIIIIIIIlllIllIlIII, final double llllllllllllllIIIIIIIlllIllIIIII, final double llllllllllllllIIIIIIIlllIllIIllI, final double llllllllllllllIIIIIIIlllIllIIlIl, final float llllllllllllllIIIIIIIlllIllIIlII, final float llllllllllllllIIIIIIIlllIlIlllII) {
        ((ModelWitch)this.mainModel).field_82900_g = (llllllllllllllIIIIIIIlllIllIlIII.getHeldItem() != null);
        super.doRender(llllllllllllllIIIIIIIlllIllIlIII, llllllllllllllIIIIIIIlllIllIIIII, llllllllllllllIIIIIIIlllIllIIllI, llllllllllllllIIIIIIIlllIllIIlIl, llllllllllllllIIIIIIIlllIllIIlII, llllllllllllllIIIIIIIlllIlIlllII);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllllIIIIIIIlllIIIlllII) {
        return this.func_180589_a((EntityWitch)llllllllllllllIIIIIIIlllIIIlllII);
    }
    
    @Override
    public void doRender(final EntityLiving llllllllllllllIIIIIIIlllIlIIlIlI, final double llllllllllllllIIIIIIIlllIlIIIIlI, final double llllllllllllllIIIIIIIlllIlIIlIII, final double llllllllllllllIIIIIIIlllIlIIIIII, final float llllllllllllllIIIIIIIlllIlIIIllI, final float llllllllllllllIIIIIIIlllIlIIIlIl) {
        this.func_180590_a((EntityWitch)llllllllllllllIIIIIIIlllIlIIlIlI, llllllllllllllIIIIIIIlllIlIIIIlI, llllllllllllllIIIIIIIlllIlIIlIII, llllllllllllllIIIIIIIlllIlIIIIII, llllllllllllllIIIIIIIlllIlIIIllI, llllllllllllllIIIIIIIlllIlIIIlIl);
    }
    
    static {
        __OBFID = "CL_00001033";
        witchTextures = new ResourceLocation("textures/entity/witch.png");
    }
    
    protected void preRenderCallback(final EntityWitch llllllllllllllIIIIIIIlllIlIlIllI, final float llllllllllllllIIIIIIIlllIlIlIlIl) {
        final float llllllllllllllIIIIIIIlllIlIlIlII = 0.9375f;
        GlStateManager.scale(llllllllllllllIIIIIIIlllIlIlIlII, llllllllllllllIIIIIIIlllIlIlIlII, llllllllllllllIIIIIIIlllIlIlIlII);
    }
    
    @Override
    public void doRender(final EntityLivingBase llllllllllllllIIIIIIIlllIIlIIlIl, final double llllllllllllllIIIIIIIlllIIlIIlII, final double llllllllllllllIIIIIIIlllIIlIIIll, final double llllllllllllllIIIIIIIlllIIlIIIlI, final float llllllllllllllIIIIIIIlllIIlIIIIl, final float llllllllllllllIIIIIIIlllIIlIIIII) {
        this.func_180590_a((EntityWitch)llllllllllllllIIIIIIIlllIIlIIlIl, llllllllllllllIIIIIIIlllIIlIIlII, llllllllllllllIIIIIIIlllIIlIIIll, llllllllllllllIIIIIIIlllIIlIIIlI, llllllllllllllIIIIIIIlllIIlIIIIl, llllllllllllllIIIIIIIlllIIlIIIII);
    }
    
    protected ResourceLocation func_180589_a(final EntityWitch llllllllllllllIIIIIIIlllIlIllIlI) {
        return RenderWitch.witchTextures;
    }
    
    @Override
    public void func_82422_c() {
        GlStateManager.translate(0.0f, 0.1875f, 0.0f);
    }
    
    @Override
    protected void preRenderCallback(final EntityLivingBase llllllllllllllIIIIIIIlllIIlllIIl, final float llllllllllllllIIIIIIIlllIIlllIII) {
        this.preRenderCallback((EntityWitch)llllllllllllllIIIIIIIlllIIlllIIl, llllllllllllllIIIIIIIlllIIlllIII);
    }
    
    public RenderWitch(final RenderManager llllllllllllllIIIIIIIlllIlllIIIl) {
        super(llllllllllllllIIIIIIIlllIlllIIIl, new ModelWitch(0.0f), 0.5f);
        this.addLayer(new LayerHeldItemWitch(this));
    }
}
