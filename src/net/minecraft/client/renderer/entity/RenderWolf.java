package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.entity.passive.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class RenderWolf extends RenderLiving
{
    private static final /* synthetic */ ResourceLocation wolfTextures;
    private static final /* synthetic */ ResourceLocation tamedWolfTextures;
    private static final /* synthetic */ ResourceLocation anrgyWolfTextures;
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllllIIllIIIIllIIIIIlIl) {
        return this.getEntityTexture((EntityWolf)llllllllllllllIIllIIIIllIIIIIlIl);
    }
    
    @Override
    protected float handleRotationFloat(final EntityLivingBase llllllllllllllIIllIIIIllIIlIIIIl, final float llllllllllllllIIllIIIIllIIlIIIll) {
        return this.func_180593_a((EntityWolf)llllllllllllllIIllIIIIllIIlIIIIl, llllllllllllllIIllIIIIllIIlIIIll);
    }
    
    protected float func_180593_a(final EntityWolf llllllllllllllIIllIIIIllIlIlllII, final float llllllllllllllIIllIIIIllIlIllIll) {
        return llllllllllllllIIllIIIIllIlIlllII.getTailRotation();
    }
    
    @Override
    public void doRender(final EntityLivingBase llllllllllllllIIllIIIIllIIIlIlll, final double llllllllllllllIIllIIIIllIIIIllll, final double llllllllllllllIIllIIIIllIIIIlllI, final double llllllllllllllIIllIIIIllIIIIllIl, final float llllllllllllllIIllIIIIllIIIIllII, final float llllllllllllllIIllIIIIllIIIlIIlI) {
        this.func_177135_a((EntityWolf)llllllllllllllIIllIIIIllIIIlIlll, llllllllllllllIIllIIIIllIIIIllll, llllllllllllllIIllIIIIllIIIIlllI, llllllllllllllIIllIIIIllIIIIllIl, llllllllllllllIIllIIIIllIIIIllII, llllllllllllllIIllIIIIllIIIlIIlI);
    }
    
    protected ResourceLocation getEntityTexture(final EntityWolf llllllllllllllIIllIIIIllIIllllll) {
        return llllllllllllllIIllIIIIllIIllllll.isTamed() ? RenderWolf.tamedWolfTextures : (llllllllllllllIIllIIIIllIIllllll.isAngry() ? RenderWolf.anrgyWolfTextures : RenderWolf.wolfTextures);
    }
    
    public RenderWolf(final RenderManager llllllllllllllIIllIIIIllIllIIIIl, final ModelBase llllllllllllllIIllIIIIllIllIIlII, final float llllllllllllllIIllIIIIllIllIIIll) {
        super(llllllllllllllIIllIIIIllIllIIIIl, llllllllllllllIIllIIIIllIllIIlII, llllllllllllllIIllIIIIllIllIIIll);
        this.addLayer(new LayerWolfCollar(this));
    }
    
    static {
        __OBFID = "CL_00001036";
        wolfTextures = new ResourceLocation("textures/entity/wolf/wolf.png");
        tamedWolfTextures = new ResourceLocation("textures/entity/wolf/wolf_tame.png");
        anrgyWolfTextures = new ResourceLocation("textures/entity/wolf/wolf_angry.png");
    }
    
    @Override
    public void doRender(final Entity llllllllllllllIIllIIIIlIllllIlIl, final double llllllllllllllIIllIIIIlIllllIlII, final double llllllllllllllIIllIIIIlIllllIIll, final double llllllllllllllIIllIIIIlIllllIIlI, final float llllllllllllllIIllIIIIlIllllIIIl, final float llllllllllllllIIllIIIIlIllllIlll) {
        this.func_177135_a((EntityWolf)llllllllllllllIIllIIIIlIllllIlIl, llllllllllllllIIllIIIIlIllllIlII, llllllllllllllIIllIIIIlIllllIIll, llllllllllllllIIllIIIIlIllllIIlI, llllllllllllllIIllIIIIlIllllIIIl, llllllllllllllIIllIIIIlIllllIlll);
    }
    
    public void func_177135_a(final EntityWolf llllllllllllllIIllIIIIllIlIIlIII, final double llllllllllllllIIllIIIIllIlIIIlll, final double llllllllllllllIIllIIIIllIlIIIllI, final double llllllllllllllIIllIIIIllIlIIllIl, final float llllllllllllllIIllIIIIllIlIIllII, final float llllllllllllllIIllIIIIllIlIIlIll) {
        if (llllllllllllllIIllIIIIllIlIIlIII.isWolfWet()) {
            final float llllllllllllllIIllIIIIllIlIIlIlI = llllllllllllllIIllIIIIllIlIIlIII.getBrightness(llllllllllllllIIllIIIIllIlIIlIll) * llllllllllllllIIllIIIIllIlIIlIII.getShadingWhileWet(llllllllllllllIIllIIIIllIlIIlIll);
            GlStateManager.color(llllllllllllllIIllIIIIllIlIIlIlI, llllllllllllllIIllIIIIllIlIIlIlI, llllllllllllllIIllIIIIllIlIIlIlI);
        }
        super.doRender(llllllllllllllIIllIIIIllIlIIlIII, llllllllllllllIIllIIIIllIlIIIlll, llllllllllllllIIllIIIIllIlIIIllI, llllllllllllllIIllIIIIllIlIIllIl, llllllllllllllIIllIIIIllIlIIllII, llllllllllllllIIllIIIIllIlIIlIll);
    }
    
    @Override
    public void doRender(final EntityLiving llllllllllllllIIllIIIIllIIllIlIl, final double llllllllllllllIIllIIIIllIIllIlII, final double llllllllllllllIIllIIIIllIIlIllII, final double llllllllllllllIIllIIIIllIIlIlIll, final float llllllllllllllIIllIIIIllIIllIIIl, final float llllllllllllllIIllIIIIllIIllIIII) {
        this.func_177135_a((EntityWolf)llllllllllllllIIllIIIIllIIllIlIl, llllllllllllllIIllIIIIllIIllIlII, llllllllllllllIIllIIIIllIIlIllII, llllllllllllllIIllIIIIllIIlIlIll, llllllllllllllIIllIIIIllIIllIIIl, llllllllllllllIIllIIIIllIIllIIII);
    }
}
