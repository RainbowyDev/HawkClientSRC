package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class RenderLeashKnot extends Render
{
    private /* synthetic */ ModelLeashKnot leashKnotModel;
    private static final /* synthetic */ ResourceLocation leashKnotTextures;
    
    public void func_180559_a(final EntityLeashKnot llIIlIIIIIl, final double llIIlIIIIII, final double llIIlIIIlll, final double llIIlIIIllI, final float llIIIllllIl, final float llIIIllllII) {
        GlStateManager.pushMatrix();
        GlStateManager.disableCull();
        GlStateManager.translate((float)llIIlIIIIII, (float)llIIlIIIlll, (float)llIIlIIIllI);
        final float llIIlIIIIll = 0.0625f;
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(-1.0f, -1.0f, 1.0f);
        GlStateManager.enableAlpha();
        this.bindEntityTexture(llIIlIIIIIl);
        this.leashKnotModel.render(llIIlIIIIIl, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, llIIlIIIIll);
        GlStateManager.popMatrix();
        super.doRender(llIIlIIIIIl, llIIlIIIIII, llIIlIIIlll, llIIlIIIllI, llIIIllllIl, llIIIllllII);
    }
    
    @Override
    public void doRender(final Entity llIIIlIlIlI, final double llIIIlIIIlI, final double llIIIlIlIII, final double llIIIlIIIII, final float llIIIIlllll, final float llIIIlIIlIl) {
        this.func_180559_a((EntityLeashKnot)llIIIlIlIlI, llIIIlIIIlI, llIIIlIlIII, llIIIlIIIII, llIIIIlllll, llIIIlIIlIl);
    }
    
    public RenderLeashKnot(final RenderManager llIIlIlIlIl) {
        super(llIIlIlIlIl);
        this.leashKnotModel = new ModelLeashKnot();
    }
    
    protected ResourceLocation getEntityTexture(final EntityLeashKnot llIIIlllIIl) {
        return RenderLeashKnot.leashKnotTextures;
    }
    
    static {
        __OBFID = "CL_00001010";
        leashKnotTextures = new ResourceLocation("textures/entity/lead_knot.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llIIIllIlIl) {
        return this.getEntityTexture((EntityLeashKnot)llIIIllIlIl);
    }
}
