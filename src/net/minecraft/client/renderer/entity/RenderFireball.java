package net.minecraft.client.renderer.entity;

import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.client.*;
import net.minecraft.init.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.renderer.*;

public class RenderFireball extends Render
{
    private /* synthetic */ float scale;
    
    static {
        __OBFID = "CL_00000995";
    }
    
    public RenderFireball(final RenderManager llllllllllllllIIIIIIllIllIlIIlll, final float llllllllllllllIIIIIIllIllIlIIllI) {
        super(llllllllllllllIIIIIIllIllIlIIlll);
        this.scale = llllllllllllllIIIIIIllIllIlIIllI;
    }
    
    protected ResourceLocation func_180556_a(final EntityFireball llllllllllllllIIIIIIllIlIllIlllI) {
        return TextureMap.locationBlocksTexture;
    }
    
    public void doRender(final EntityFireball llllllllllllllIIIIIIllIllIIlIIlI, final double llllllllllllllIIIIIIllIlIlllllll, final double llllllllllllllIIIIIIllIllIIlIIII, final double llllllllllllllIIIIIIllIllIIIllll, final float llllllllllllllIIIIIIllIlIlllllII, final float llllllllllllllIIIIIIllIlIllllIll) {
        GlStateManager.pushMatrix();
        this.bindEntityTexture(llllllllllllllIIIIIIllIllIIlIIlI);
        GlStateManager.translate((float)llllllllllllllIIIIIIllIlIlllllll, (float)llllllllllllllIIIIIIllIllIIlIIII, (float)llllllllllllllIIIIIIllIllIIIllll);
        GlStateManager.enableRescaleNormal();
        final float llllllllllllllIIIIIIllIllIIIllII = this.scale;
        GlStateManager.scale(llllllllllllllIIIIIIllIllIIIllII / 1.0f, llllllllllllllIIIIIIllIllIIIllII / 1.0f, llllllllllllllIIIIIIllIllIIIllII / 1.0f);
        final TextureAtlasSprite llllllllllllllIIIIIIllIllIIIlIll = Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getParticleIcon(Items.fire_charge);
        final Tessellator llllllllllllllIIIIIIllIllIIIlIlI = Tessellator.getInstance();
        final WorldRenderer llllllllllllllIIIIIIllIllIIIlIIl = llllllllllllllIIIIIIllIllIIIlIlI.getWorldRenderer();
        final float llllllllllllllIIIIIIllIllIIIlIII = llllllllllllllIIIIIIllIllIIIlIll.getMinU();
        final float llllllllllllllIIIIIIllIllIIIIlll = llllllllllllllIIIIIIllIllIIIlIll.getMaxU();
        final float llllllllllllllIIIIIIllIllIIIIllI = llllllllllllllIIIIIIllIllIIIlIll.getMinV();
        final float llllllllllllllIIIIIIllIllIIIIlIl = llllllllllllllIIIIIIllIllIIIlIll.getMaxV();
        final float llllllllllllllIIIIIIllIllIIIIlII = 1.0f;
        final float llllllllllllllIIIIIIllIllIIIIIll = 0.5f;
        final float llllllllllllllIIIIIIllIllIIIIIlI = 0.25f;
        GlStateManager.rotate(180.0f - this.renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-this.renderManager.playerViewX, 1.0f, 0.0f, 0.0f);
        llllllllllllllIIIIIIllIllIIIlIIl.startDrawingQuads();
        llllllllllllllIIIIIIllIllIIIlIIl.func_178980_d(0.0f, 1.0f, 0.0f);
        llllllllllllllIIIIIIllIllIIIlIIl.addVertexWithUV(0.0f - llllllllllllllIIIIIIllIllIIIIIll, 0.0f - llllllllllllllIIIIIIllIllIIIIIlI, 0.0, llllllllllllllIIIIIIllIllIIIlIII, llllllllllllllIIIIIIllIllIIIIlIl);
        llllllllllllllIIIIIIllIllIIIlIIl.addVertexWithUV(llllllllllllllIIIIIIllIllIIIIlII - llllllllllllllIIIIIIllIllIIIIIll, 0.0f - llllllllllllllIIIIIIllIllIIIIIlI, 0.0, llllllllllllllIIIIIIllIllIIIIlll, llllllllllllllIIIIIIllIllIIIIlIl);
        llllllllllllllIIIIIIllIllIIIlIIl.addVertexWithUV(llllllllllllllIIIIIIllIllIIIIlII - llllllllllllllIIIIIIllIllIIIIIll, 1.0f - llllllllllllllIIIIIIllIllIIIIIlI, 0.0, llllllllllllllIIIIIIllIllIIIIlll, llllllllllllllIIIIIIllIllIIIIllI);
        llllllllllllllIIIIIIllIllIIIlIIl.addVertexWithUV(0.0f - llllllllllllllIIIIIIllIllIIIIIll, 1.0f - llllllllllllllIIIIIIllIllIIIIIlI, 0.0, llllllllllllllIIIIIIllIllIIIlIII, llllllllllllllIIIIIIllIllIIIIllI);
        llllllllllllllIIIIIIllIllIIIlIlI.draw();
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(llllllllllllllIIIIIIllIllIIlIIlI, llllllllllllllIIIIIIllIlIlllllll, llllllllllllllIIIIIIllIllIIlIIII, llllllllllllllIIIIIIllIllIIIllll, llllllllllllllIIIIIIllIlIlllllII, llllllllllllllIIIIIIllIlIllllIll);
    }
    
    @Override
    public void doRender(final Entity llllllllllllllIIIIIIllIlIlIllIII, final double llllllllllllllIIIIIIllIlIlIlIlll, final double llllllllllllllIIIIIIllIlIlIlIllI, final double llllllllllllllIIIIIIllIlIlIlllII, final float llllllllllllllIIIIIIllIlIlIllIll, final float llllllllllllllIIIIIIllIlIlIllIlI) {
        this.doRender((EntityFireball)llllllllllllllIIIIIIllIlIlIllIII, llllllllllllllIIIIIIllIlIlIlIlll, llllllllllllllIIIIIIllIlIlIlIllI, llllllllllllllIIIIIIllIlIlIlllII, llllllllllllllIIIIIIllIlIlIllIll, llllllllllllllIIIIIIllIlIlIllIlI);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllllIIIIIIllIlIllIlIlI) {
        return this.func_180556_a((EntityFireball)llllllllllllllIIIIIIllIlIllIlIlI);
    }
}
