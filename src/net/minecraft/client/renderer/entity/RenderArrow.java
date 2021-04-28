package net.minecraft.client.renderer.entity;

import net.minecraft.entity.projectile.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;

public class RenderArrow extends Render
{
    private static final /* synthetic */ ResourceLocation arrowTextures;
    
    static {
        __OBFID = "CL_00000978";
        arrowTextures = new ResourceLocation("textures/entity/arrow.png");
    }
    
    protected ResourceLocation getEntityTexture(final EntityArrow llllllllllllllIllllllIlIIlIllIIl) {
        return RenderArrow.arrowTextures;
    }
    
    public void doRender(final EntityArrow llllllllllllllIllllllIlIlIIIIlII, final double llllllllllllllIllllllIlIIllIllIl, final double llllllllllllllIllllllIlIlIIIIIlI, final double llllllllllllllIllllllIlIlIIIIIIl, final float llllllllllllllIllllllIlIIllIlIlI, final float llllllllllllllIllllllIlIIlllllll) {
        this.bindEntityTexture(llllllllllllllIllllllIlIlIIIIlII);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)llllllllllllllIllllllIlIIllIllIl, (float)llllllllllllllIllllllIlIlIIIIIlI, (float)llllllllllllllIllllllIlIlIIIIIIl);
        GlStateManager.rotate(llllllllllllllIllllllIlIlIIIIlII.prevRotationYaw + (llllllllllllllIllllllIlIlIIIIlII.rotationYaw - llllllllllllllIllllllIlIlIIIIlII.prevRotationYaw) * llllllllllllllIllllllIlIIlllllll - 90.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(llllllllllllllIllllllIlIlIIIIlII.prevRotationPitch + (llllllllllllllIllllllIlIlIIIIlII.rotationPitch - llllllllllllllIllllllIlIlIIIIlII.prevRotationPitch) * llllllllllllllIllllllIlIIlllllll, 0.0f, 0.0f, 1.0f);
        final Tessellator llllllllllllllIllllllIlIIllllllI = Tessellator.getInstance();
        final WorldRenderer llllllllllllllIllllllIlIIlllllIl = llllllllllllllIllllllIlIIllllllI.getWorldRenderer();
        final byte llllllllllllllIllllllIlIIlllllII = 0;
        final float llllllllllllllIllllllIlIIllllIll = 0.0f;
        final float llllllllllllllIllllllIlIIllllIlI = 0.5f;
        final float llllllllllllllIllllllIlIIllllIIl = (0 + llllllllllllllIllllllIlIIlllllII * 10) / 32.0f;
        final float llllllllllllllIllllllIlIIllllIII = (5 + llllllllllllllIllllllIlIIlllllII * 10) / 32.0f;
        final float llllllllllllllIllllllIlIIlllIlll = 0.0f;
        final float llllllllllllllIllllllIlIIlllIllI = 0.15625f;
        final float llllllllllllllIllllllIlIIlllIlIl = (5 + llllllllllllllIllllllIlIIlllllII * 10) / 32.0f;
        final float llllllllllllllIllllllIlIIlllIlII = (10 + llllllllllllllIllllllIlIIlllllII * 10) / 32.0f;
        final float llllllllllllllIllllllIlIIlllIIll = 0.05625f;
        GlStateManager.enableRescaleNormal();
        final float llllllllllllllIllllllIlIIlllIIlI = llllllllllllllIllllllIlIlIIIIlII.arrowShake - llllllllllllllIllllllIlIIlllllll;
        if (llllllllllllllIllllllIlIIlllIIlI > 0.0f) {
            final float llllllllllllllIllllllIlIIlllIIIl = -MathHelper.sin(llllllllllllllIllllllIlIIlllIIlI * 3.0f) * llllllllllllllIllllllIlIIlllIIlI;
            GlStateManager.rotate(llllllllllllllIllllllIlIIlllIIIl, 0.0f, 0.0f, 1.0f);
        }
        GlStateManager.rotate(45.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.scale(llllllllllllllIllllllIlIIlllIIll, llllllllllllllIllllllIlIIlllIIll, llllllllllllllIllllllIlIIlllIIll);
        GlStateManager.translate(-4.0f, 0.0f, 0.0f);
        GL11.glNormal3f(llllllllllllllIllllllIlIIlllIIll, 0.0f, 0.0f);
        llllllllllllllIllllllIlIIlllllIl.startDrawingQuads();
        llllllllllllllIllllllIlIIlllllIl.addVertexWithUV(-7.0, -2.0, -2.0, llllllllllllllIllllllIlIIlllIlll, llllllllllllllIllllllIlIIlllIlIl);
        llllllllllllllIllllllIlIIlllllIl.addVertexWithUV(-7.0, -2.0, 2.0, llllllllllllllIllllllIlIIlllIllI, llllllllllllllIllllllIlIIlllIlIl);
        llllllllllllllIllllllIlIIlllllIl.addVertexWithUV(-7.0, 2.0, 2.0, llllllllllllllIllllllIlIIlllIllI, llllllllllllllIllllllIlIIlllIlII);
        llllllllllllllIllllllIlIIlllllIl.addVertexWithUV(-7.0, 2.0, -2.0, llllllllllllllIllllllIlIIlllIlll, llllllllllllllIllllllIlIIlllIlII);
        llllllllllllllIllllllIlIIllllllI.draw();
        GL11.glNormal3f(-llllllllllllllIllllllIlIIlllIIll, 0.0f, 0.0f);
        llllllllllllllIllllllIlIIlllllIl.startDrawingQuads();
        llllllllllllllIllllllIlIIlllllIl.addVertexWithUV(-7.0, 2.0, -2.0, llllllllllllllIllllllIlIIlllIlll, llllllllllllllIllllllIlIIlllIlIl);
        llllllllllllllIllllllIlIIlllllIl.addVertexWithUV(-7.0, 2.0, 2.0, llllllllllllllIllllllIlIIlllIllI, llllllllllllllIllllllIlIIlllIlIl);
        llllllllllllllIllllllIlIIlllllIl.addVertexWithUV(-7.0, -2.0, 2.0, llllllllllllllIllllllIlIIlllIllI, llllllllllllllIllllllIlIIlllIlII);
        llllllllllllllIllllllIlIIlllllIl.addVertexWithUV(-7.0, -2.0, -2.0, llllllllllllllIllllllIlIIlllIlll, llllllllllllllIllllllIlIIlllIlII);
        llllllllllllllIllllllIlIIllllllI.draw();
        for (int llllllllllllllIllllllIlIIlllIIII = 0; llllllllllllllIllllllIlIIlllIIII < 4; ++llllllllllllllIllllllIlIIlllIIII) {
            GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
            GL11.glNormal3f(0.0f, 0.0f, llllllllllllllIllllllIlIIlllIIll);
            llllllllllllllIllllllIlIIlllllIl.startDrawingQuads();
            llllllllllllllIllllllIlIIlllllIl.addVertexWithUV(-8.0, -2.0, 0.0, llllllllllllllIllllllIlIIllllIll, llllllllllllllIllllllIlIIllllIIl);
            llllllllllllllIllllllIlIIlllllIl.addVertexWithUV(8.0, -2.0, 0.0, llllllllllllllIllllllIlIIllllIlI, llllllllllllllIllllllIlIIllllIIl);
            llllllllllllllIllllllIlIIlllllIl.addVertexWithUV(8.0, 2.0, 0.0, llllllllllllllIllllllIlIIllllIlI, llllllllllllllIllllllIlIIllllIII);
            llllllllllllllIllllllIlIIlllllIl.addVertexWithUV(-8.0, 2.0, 0.0, llllllllllllllIllllllIlIIllllIll, llllllllllllllIllllllIlIIllllIII);
            llllllllllllllIllllllIlIIllllllI.draw();
        }
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(llllllllllllllIllllllIlIlIIIIlII, llllllllllllllIllllllIlIIllIllIl, llllllllllllllIllllllIlIlIIIIIlI, llllllllllllllIllllllIlIlIIIIIIl, llllllllllllllIllllllIlIIllIlIlI, llllllllllllllIllllllIlIIlllllll);
    }
    
    public RenderArrow(final RenderManager llllllllllllllIllllllIlIlIIllIll) {
        super(llllllllllllllIllllllIlIlIIllIll);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllllIllllllIlIIlIlIlIl) {
        return this.getEntityTexture((EntityArrow)llllllllllllllIllllllIlIIlIlIlIl);
    }
    
    @Override
    public void doRender(final Entity llllllllllllllIllllllIlIIlIIIIll, final double llllllllllllllIllllllIlIIlIIIIlI, final double llllllllllllllIllllllIlIIlIIIIIl, final double llllllllllllllIllllllIlIIlIIIlll, final float llllllllllllllIllllllIlIIlIIIllI, final float llllllllllllllIllllllIlIIIlllllI) {
        this.doRender((EntityArrow)llllllllllllllIllllllIlIIlIIIIll, llllllllllllllIllllllIlIIlIIIIlI, llllllllllllllIllllllIlIIlIIIIIl, llllllllllllllIllllllIlIIlIIIlll, llllllllllllllIllllllIlIIlIIIllI, llllllllllllllIllllllIlIIIlllllI);
    }
}
