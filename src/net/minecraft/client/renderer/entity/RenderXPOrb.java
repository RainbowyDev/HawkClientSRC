package net.minecraft.client.renderer.entity;

import net.minecraft.entity.item.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import optifine.*;
import net.minecraft.client.renderer.*;

public class RenderXPOrb extends Render
{
    private static final /* synthetic */ ResourceLocation experienceOrbTextures;
    
    public void doRender(final EntityXPOrb llllllllllllllIIllIIIIlIIIllIlIl, final double llllllllllllllIIllIIIIlIIIllIlII, final double llllllllllllllIIllIIIIlIIIllIIll, final double llllllllllllllIIllIIIIlIIIllIIlI, final float llllllllllllllIIllIIIIlIIIIlIllI, final float llllllllllllllIIllIIIIlIIIllIIII) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)llllllllllllllIIllIIIIlIIIllIlII, (float)llllllllllllllIIllIIIIlIIIllIIll, (float)llllllllllllllIIllIIIIlIIIllIIlI);
        this.bindEntityTexture(llllllllllllllIIllIIIIlIIIllIlIl);
        final int llllllllllllllIIllIIIIlIIIlIllll = llllllllllllllIIllIIIIlIIIllIlIl.getTextureByXP();
        final float llllllllllllllIIllIIIIlIIIlIlllI = (llllllllllllllIIllIIIIlIIIlIllll % 4 * 16 + 0) / 64.0f;
        final float llllllllllllllIIllIIIIlIIIlIllIl = (llllllllllllllIIllIIIIlIIIlIllll % 4 * 16 + 16) / 64.0f;
        final float llllllllllllllIIllIIIIlIIIlIllII = (llllllllllllllIIllIIIIlIIIlIllll / 4 * 16 + 0) / 64.0f;
        final float llllllllllllllIIllIIIIlIIIlIlIll = (llllllllllllllIIllIIIIlIIIlIllll / 4 * 16 + 16) / 64.0f;
        final float llllllllllllllIIllIIIIlIIIlIlIlI = 1.0f;
        final float llllllllllllllIIllIIIIlIIIlIlIIl = 0.5f;
        final float llllllllllllllIIllIIIIlIIIlIlIII = 0.25f;
        final int llllllllllllllIIllIIIIlIIIlIIlll = llllllllllllllIIllIIIIlIIIllIlIl.getBrightnessForRender(llllllllllllllIIllIIIIlIIIllIIII);
        final int llllllllllllllIIllIIIIlIIIlIIllI = llllllllllllllIIllIIIIlIIIlIIlll % 65536;
        int llllllllllllllIIllIIIIlIIIlIIlIl = llllllllllllllIIllIIIIlIIIlIIlll / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, llllllllllllllIIllIIIIlIIIlIIllI / 1.0f, llllllllllllllIIllIIIIlIIIlIIlIl / 1.0f);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        final float llllllllllllllIIllIIIIlIIIlIIlII = 255.0f;
        final float llllllllllllllIIllIIIIlIIIlIIIll = (llllllllllllllIIllIIIIlIIIllIlIl.xpColor + llllllllllllllIIllIIIIlIIIllIIII) / 2.0f;
        llllllllllllllIIllIIIIlIIIlIIlIl = (int)((MathHelper.sin(llllllllllllllIIllIIIIlIIIlIIIll + 0.0f) + 1.0f) * 0.5f * llllllllllllllIIllIIIIlIIIlIIlII);
        final int llllllllllllllIIllIIIIlIIIlIIIlI = (int)llllllllllllllIIllIIIIlIIIlIIlII;
        final int llllllllllllllIIllIIIIlIIIlIIIIl = (int)((MathHelper.sin(llllllllllllllIIllIIIIlIIIlIIIll + 4.1887903f) + 1.0f) * 0.1f * llllllllllllllIIllIIIIlIIIlIIlII);
        int llllllllllllllIIllIIIIlIIIlIIIII = llllllllllllllIIllIIIIlIIIlIIlIl << 16 | llllllllllllllIIllIIIIlIIIlIIIlI << 8 | llllllllllllllIIllIIIIlIIIlIIIIl;
        GlStateManager.rotate(180.0f - this.renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-this.renderManager.playerViewX, 1.0f, 0.0f, 0.0f);
        final float llllllllllllllIIllIIIIlIIIIlllll = 0.3f;
        GlStateManager.scale(llllllllllllllIIllIIIIlIIIIlllll, llllllllllllllIIllIIIIlIIIIlllll, llllllllllllllIIllIIIIlIIIIlllll);
        final Tessellator llllllllllllllIIllIIIIlIIIIllllI = Tessellator.getInstance();
        final WorldRenderer llllllllllllllIIllIIIIlIIIIlllIl = llllllllllllllIIllIIIIlIIIIllllI.getWorldRenderer();
        llllllllllllllIIllIIIIlIIIIlllIl.startDrawingQuads();
        if (Config.isCustomColors()) {
            final int llllllllllllllIIllIIIIlIIIIlllII = CustomColors.getXpOrbColor(llllllllllllllIIllIIIIlIIIlIIlII);
            if (llllllllllllllIIllIIIIlIIIIlllII >= 0) {
                llllllllllllllIIllIIIIlIIIlIIIII = llllllllllllllIIllIIIIlIIIIlllII;
            }
        }
        llllllllllllllIIllIIIIlIIIIlllIl.func_178974_a(llllllllllllllIIllIIIIlIIIlIIIII, 128);
        llllllllllllllIIllIIIIlIIIIlllIl.func_178980_d(0.0f, 1.0f, 0.0f);
        llllllllllllllIIllIIIIlIIIIlllIl.addVertexWithUV(0.0f - llllllllllllllIIllIIIIlIIIlIlIIl, 0.0f - llllllllllllllIIllIIIIlIIIlIlIII, 0.0, llllllllllllllIIllIIIIlIIIlIlllI, llllllllllllllIIllIIIIlIIIlIlIll);
        llllllllllllllIIllIIIIlIIIIlllIl.addVertexWithUV(llllllllllllllIIllIIIIlIIIlIlIlI - llllllllllllllIIllIIIIlIIIlIlIIl, 0.0f - llllllllllllllIIllIIIIlIIIlIlIII, 0.0, llllllllllllllIIllIIIIlIIIlIllIl, llllllllllllllIIllIIIIlIIIlIlIll);
        llllllllllllllIIllIIIIlIIIIlllIl.addVertexWithUV(llllllllllllllIIllIIIIlIIIlIlIlI - llllllllllllllIIllIIIIlIIIlIlIIl, 1.0f - llllllllllllllIIllIIIIlIIIlIlIII, 0.0, llllllllllllllIIllIIIIlIIIlIllIl, llllllllllllllIIllIIIIlIIIlIllII);
        llllllllllllllIIllIIIIlIIIIlllIl.addVertexWithUV(0.0f - llllllllllllllIIllIIIIlIIIlIlIIl, 1.0f - llllllllllllllIIllIIIIlIIIlIlIII, 0.0, llllllllllllllIIllIIIIlIIIlIlllI, llllllllllllllIIllIIIIlIIIlIllII);
        llllllllllllllIIllIIIIlIIIIllllI.draw();
        GlStateManager.disableBlend();
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(llllllllllllllIIllIIIIlIIIllIlIl, llllllllllllllIIllIIIIlIIIllIlII, llllllllllllllIIllIIIIlIIIllIIll, llllllllllllllIIllIIIIlIIIllIIlI, llllllllllllllIIllIIIIlIIIIlIllI, llllllllllllllIIllIIIIlIIIllIIII);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllllIIllIIIIIllllllIll) {
        return this.getTexture((EntityXPOrb)llllllllllllllIIllIIIIIllllllIll);
    }
    
    static {
        __OBFID = "CL_00000993";
        experienceOrbTextures = new ResourceLocation("textures/entity/experience_orb.png");
    }
    
    protected ResourceLocation getTexture(final EntityXPOrb llllllllllllllIIllIIIIIlllllllll) {
        return RenderXPOrb.experienceOrbTextures;
    }
    
    @Override
    public void doRender(final Entity llllllllllllllIIllIIIIIllllIlIIl, final double llllllllllllllIIllIIIIIllllIlIII, final double llllllllllllllIIllIIIIIllllIlllI, final double llllllllllllllIIllIIIIIllllIIllI, final float llllllllllllllIIllIIIIIllllIllII, final float llllllllllllllIIllIIIIIllllIlIll) {
        this.doRender((EntityXPOrb)llllllllllllllIIllIIIIIllllIlIIl, llllllllllllllIIllIIIIIllllIlIII, llllllllllllllIIllIIIIIllllIlllI, llllllllllllllIIllIIIIIllllIIllI, llllllllllllllIIllIIIIIllllIllII, llllllllllllllIIllIIIIIllllIlIll);
    }
    
    public RenderXPOrb(final RenderManager llllllllllllllIIllIIIIlIIlIlIIlI) {
        super(llllllllllllllIIllIIIIlIIlIlIIlI);
        this.shadowSize = 0.15f;
        this.shadowOpaque = 0.75f;
    }
}
