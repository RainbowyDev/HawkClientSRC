package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.entity.*;

public class RenderSlime extends RenderLiving
{
    private static final /* synthetic */ ResourceLocation slimeTextures;
    
    protected void preRenderCallback(final EntitySlime lllllllllllllllIIIIlIlllIlIIllll, final float lllllllllllllllIIIIlIlllIlIIlllI) {
        final float lllllllllllllllIIIIlIlllIlIIllIl = (float)lllllllllllllllIIIIlIlllIlIIllll.getSlimeSize();
        final float lllllllllllllllIIIIlIlllIlIIllII = (lllllllllllllllIIIIlIlllIlIIllll.prevSquishFactor + (lllllllllllllllIIIIlIlllIlIIllll.squishFactor - lllllllllllllllIIIIlIlllIlIIllll.prevSquishFactor) * lllllllllllllllIIIIlIlllIlIIlllI) / (lllllllllllllllIIIIlIlllIlIIllIl * 0.5f + 1.0f);
        final float lllllllllllllllIIIIlIlllIlIIlIll = 1.0f / (lllllllllllllllIIIIlIlllIlIIllII + 1.0f);
        GlStateManager.scale(lllllllllllllllIIIIlIlllIlIIlIll * lllllllllllllllIIIIlIlllIlIIllIl, 1.0f / lllllllllllllllIIIIlIlllIlIIlIll * lllllllllllllllIIIIlIlllIlIIllIl, lllllllllllllllIIIIlIlllIlIIlIll * lllllllllllllllIIIIlIlllIlIIllIl);
    }
    
    protected ResourceLocation getEntityTexture(final EntitySlime lllllllllllllllIIIIlIlllIlIIIlII) {
        return RenderSlime.slimeTextures;
    }
    
    @Override
    public void doRender(final EntityLiving lllllllllllllllIIIIlIlllIIlllIll, final double lllllllllllllllIIIIlIlllIIllIIll, final double lllllllllllllllIIIIlIlllIIllIIlI, final double lllllllllllllllIIIIlIlllIIlllIII, final float lllllllllllllllIIIIlIlllIIllIlll, final float lllllllllllllllIIIIlIlllIIlIllll) {
        this.doRender((EntitySlime)lllllllllllllllIIIIlIlllIIlllIll, lllllllllllllllIIIIlIlllIIllIIll, lllllllllllllllIIIIlIlllIIllIIlI, lllllllllllllllIIIIlIlllIIlllIII, lllllllllllllllIIIIlIlllIIllIlll, lllllllllllllllIIIIlIlllIIlIllll);
    }
    
    @Override
    public void doRender(final Entity lllllllllllllllIIIIlIllIlllllIll, final double lllllllllllllllIIIIlIlllIIIIIIIl, final double lllllllllllllllIIIIlIlllIIIIIIII, final double lllllllllllllllIIIIlIllIllllllll, final float lllllllllllllllIIIIlIllIlllllllI, final float lllllllllllllllIIIIlIllIllllIllI) {
        this.doRender((EntitySlime)lllllllllllllllIIIIlIllIlllllIll, lllllllllllllllIIIIlIlllIIIIIIIl, lllllllllllllllIIIIlIlllIIIIIIII, lllllllllllllllIIIIlIllIllllllll, lllllllllllllllIIIIlIllIlllllllI, lllllllllllllllIIIIlIllIllllIllI);
    }
    
    public RenderSlime(final RenderManager lllllllllllllllIIIIlIlllIlllIIIl, final ModelBase lllllllllllllllIIIIlIlllIllIllII, final float lllllllllllllllIIIIlIlllIllIlIll) {
        super(lllllllllllllllIIIIlIlllIlllIIIl, lllllllllllllllIIIIlIlllIllIllII, lllllllllllllllIIIIlIlllIllIlIll);
        this.addLayer(new LayerSlimeGel(this));
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity lllllllllllllllIIIIlIlllIIIIlIll) {
        return this.getEntityTexture((EntitySlime)lllllllllllllllIIIIlIlllIIIIlIll);
    }
    
    public void doRender(final EntitySlime lllllllllllllllIIIIlIlllIlIllIll, final double lllllllllllllllIIIIlIlllIllIIIIl, final double lllllllllllllllIIIIlIlllIllIIIII, final double lllllllllllllllIIIIlIlllIlIlllll, final float lllllllllllllllIIIIlIlllIlIllllI, final float lllllllllllllllIIIIlIlllIlIlllIl) {
        this.shadowSize = 0.25f * lllllllllllllllIIIIlIlllIlIllIll.getSlimeSize();
        super.doRender(lllllllllllllllIIIIlIlllIlIllIll, lllllllllllllllIIIIlIlllIllIIIIl, lllllllllllllllIIIIlIlllIllIIIII, lllllllllllllllIIIIlIlllIlIlllll, lllllllllllllllIIIIlIlllIlIllllI, lllllllllllllllIIIIlIlllIlIlllIl);
    }
    
    static {
        __OBFID = "CL_00001024";
        slimeTextures = new ResourceLocation("textures/entity/slime/slime.png");
    }
    
    @Override
    protected void preRenderCallback(final EntityLivingBase lllllllllllllllIIIIlIlllIIlIlIlI, final float lllllllllllllllIIIIlIlllIIlIIllI) {
        this.preRenderCallback((EntitySlime)lllllllllllllllIIIIlIlllIIlIlIlI, lllllllllllllllIIIIlIlllIIlIIllI);
    }
    
    @Override
    public void doRender(final EntityLivingBase lllllllllllllllIIIIlIlllIIIlllIl, final double lllllllllllllllIIIIlIlllIIIlIlIl, final double lllllllllllllllIIIIlIlllIIIlIlII, final double lllllllllllllllIIIIlIlllIIIlIIll, final float lllllllllllllllIIIIlIlllIIIlIIlI, final float lllllllllllllllIIIIlIlllIIIllIII) {
        this.doRender((EntitySlime)lllllllllllllllIIIIlIlllIIIlllIl, lllllllllllllllIIIIlIlllIIIlIlIl, lllllllllllllllIIIIlIlllIIIlIlII, lllllllllllllllIIIIlIlllIIIlIIll, lllllllllllllllIIIIlIlllIIIlIIlI, lllllllllllllllIIIIlIlllIIIllIII);
    }
}
