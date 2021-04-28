package net.minecraft.client.renderer.entity;

import net.minecraft.entity.item.*;
import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;

public class RenderTNTPrimed extends Render
{
    static {
        __OBFID = "CL_00001030";
    }
    
    public RenderTNTPrimed(final RenderManager lllllllllllllllIllIlIIIlllIlIlIl) {
        super(lllllllllllllllIllIlIIIlllIlIlIl);
        this.shadowSize = 0.5f;
    }
    
    public void doRender(final EntityTNTPrimed lllllllllllllllIllIlIIIlllIIlIIl, final double lllllllllllllllIllIlIIIllIllllIl, final double lllllllllllllllIllIlIIIllIllllII, final double lllllllllllllllIllIlIIIlllIIIllI, final float lllllllllllllllIllIlIIIllIlllIlI, final float lllllllllllllllIllIlIIIlllIIIlII) {
        final BlockRendererDispatcher lllllllllllllllIllIlIIIlllIIIIll = Minecraft.getMinecraft().getBlockRendererDispatcher();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)lllllllllllllllIllIlIIIllIllllIl, (float)lllllllllllllllIllIlIIIllIllllII + 0.5f, (float)lllllllllllllllIllIlIIIlllIIIllI);
        if (lllllllllllllllIllIlIIIlllIIlIIl.fuse - lllllllllllllllIllIlIIIlllIIIlII + 1.0f < 10.0f) {
            float lllllllllllllllIllIlIIIlllIIIIlI = 1.0f - (lllllllllllllllIllIlIIIlllIIlIIl.fuse - lllllllllllllllIllIlIIIlllIIIlII + 1.0f) / 10.0f;
            lllllllllllllllIllIlIIIlllIIIIlI = MathHelper.clamp_float(lllllllllllllllIllIlIIIlllIIIIlI, 0.0f, 1.0f);
            lllllllllllllllIllIlIIIlllIIIIlI *= lllllllllllllllIllIlIIIlllIIIIlI;
            lllllllllllllllIllIlIIIlllIIIIlI *= lllllllllllllllIllIlIIIlllIIIIlI;
            final float lllllllllllllllIllIlIIIlllIIIIII = 1.0f + lllllllllllllllIllIlIIIlllIIIIlI * 0.3f;
            GlStateManager.scale(lllllllllllllllIllIlIIIlllIIIIII, lllllllllllllllIllIlIIIlllIIIIII, lllllllllllllllIllIlIIIlllIIIIII);
        }
        final float lllllllllllllllIllIlIIIlllIIIIIl = (1.0f - (lllllllllllllllIllIlIIIlllIIlIIl.fuse - lllllllllllllllIllIlIIIlllIIIlII + 1.0f) / 100.0f) * 0.8f;
        this.bindEntityTexture(lllllllllllllllIllIlIIIlllIIlIIl);
        GlStateManager.translate(-0.5f, -0.5f, 0.5f);
        lllllllllllllllIllIlIIIlllIIIIll.func_175016_a(Blocks.tnt.getDefaultState(), lllllllllllllllIllIlIIIlllIIlIIl.getBrightness(lllllllllllllllIllIlIIIlllIIIlII));
        GlStateManager.translate(0.0f, 0.0f, 1.0f);
        if (lllllllllllllllIllIlIIIlllIIlIIl.fuse / 5 % 2 == 0) {
            GlStateManager.func_179090_x();
            GlStateManager.disableLighting();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 772);
            GlStateManager.color(1.0f, 1.0f, 1.0f, lllllllllllllllIllIlIIIlllIIIIIl);
            GlStateManager.doPolygonOffset(-3.0f, -3.0f);
            GlStateManager.enablePolygonOffset();
            lllllllllllllllIllIlIIIlllIIIIll.func_175016_a(Blocks.tnt.getDefaultState(), 1.0f);
            GlStateManager.doPolygonOffset(0.0f, 0.0f);
            GlStateManager.disablePolygonOffset();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.disableBlend();
            GlStateManager.enableLighting();
            GlStateManager.func_179098_w();
        }
        GlStateManager.popMatrix();
        super.doRender(lllllllllllllllIllIlIIIlllIIlIIl, lllllllllllllllIllIlIIIllIllllIl, lllllllllllllllIllIlIIIllIllllII, lllllllllllllllIllIlIIIlllIIIllI, lllllllllllllllIllIlIIIllIlllIlI, lllllllllllllllIllIlIIIlllIIIlII);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity lllllllllllllllIllIlIIIllIlIlllI) {
        return this.func_180563_a((EntityTNTPrimed)lllllllllllllllIllIlIIIllIlIlllI);
    }
    
    protected ResourceLocation func_180563_a(final EntityTNTPrimed lllllllllllllllIllIlIIIllIllIlII) {
        return TextureMap.locationBlocksTexture;
    }
    
    @Override
    public void doRender(final Entity lllllllllllllllIllIlIIIllIlIIlIl, final double lllllllllllllllIllIlIIIllIlIIlII, final double lllllllllllllllIllIlIIIllIlIIIll, final double lllllllllllllllIllIlIIIllIIllIll, final float lllllllllllllllIllIlIIIllIIllIlI, final float lllllllllllllllIllIlIIIllIlIIIII) {
        this.doRender((EntityTNTPrimed)lllllllllllllllIllIlIIIllIlIIlIl, lllllllllllllllIllIlIIIllIlIIlII, lllllllllllllllIllIlIIIllIlIIIll, lllllllllllllllIllIlIIIllIIllIll, lllllllllllllllIllIlIIIllIIllIlI, lllllllllllllllIllIlIIIllIlIIIII);
    }
}
