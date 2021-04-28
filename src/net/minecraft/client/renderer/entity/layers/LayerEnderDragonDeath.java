package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.boss.*;
import java.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class LayerEnderDragonDeath implements LayerRenderer
{
    public void func_177213_a(final EntityDragon lllllllllllllllIIIIIIIlIIlllIllI, final float lllllllllllllllIIIIIIIlIIlllIlIl, final float lllllllllllllllIIIIIIIlIIlllIlII, final float lllllllllllllllIIIIIIIlIIllIIlII, final float lllllllllllllllIIIIIIIlIIlllIIlI, final float lllllllllllllllIIIIIIIlIIlllIIIl, final float lllllllllllllllIIIIIIIlIIlllIIII, final float lllllllllllllllIIIIIIIlIIllIllll) {
        if (lllllllllllllllIIIIIIIlIIlllIllI.deathTicks > 0) {
            final Tessellator lllllllllllllllIIIIIIIlIIllIlllI = Tessellator.getInstance();
            final WorldRenderer lllllllllllllllIIIIIIIlIIllIllIl = lllllllllllllllIIIIIIIlIIllIlllI.getWorldRenderer();
            RenderHelper.disableStandardItemLighting();
            final float lllllllllllllllIIIIIIIlIIllIllII = (lllllllllllllllIIIIIIIlIIlllIllI.deathTicks + lllllllllllllllIIIIIIIlIIllIIlII) / 200.0f;
            float lllllllllllllllIIIIIIIlIIllIlIll = 0.0f;
            if (lllllllllllllllIIIIIIIlIIllIllII > 0.8f) {
                lllllllllllllllIIIIIIIlIIllIlIll = (lllllllllllllllIIIIIIIlIIllIllII - 0.8f) / 0.2f;
            }
            final Random lllllllllllllllIIIIIIIlIIllIlIlI = new Random(432L);
            GlStateManager.func_179090_x();
            GlStateManager.shadeModel(7425);
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 1);
            GlStateManager.disableAlpha();
            GlStateManager.enableCull();
            GlStateManager.depthMask(false);
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, -1.0f, -2.0f);
            for (int lllllllllllllllIIIIIIIlIIllIlIIl = 0; lllllllllllllllIIIIIIIlIIllIlIIl < (lllllllllllllllIIIIIIIlIIllIllII + lllllllllllllllIIIIIIIlIIllIllII * lllllllllllllllIIIIIIIlIIllIllII) / 2.0f * 60.0f; ++lllllllllllllllIIIIIIIlIIllIlIIl) {
                GlStateManager.rotate(lllllllllllllllIIIIIIIlIIllIlIlI.nextFloat() * 360.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(lllllllllllllllIIIIIIIlIIllIlIlI.nextFloat() * 360.0f, 0.0f, 1.0f, 0.0f);
                GlStateManager.rotate(lllllllllllllllIIIIIIIlIIllIlIlI.nextFloat() * 360.0f, 0.0f, 0.0f, 1.0f);
                GlStateManager.rotate(lllllllllllllllIIIIIIIlIIllIlIlI.nextFloat() * 360.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(lllllllllllllllIIIIIIIlIIllIlIlI.nextFloat() * 360.0f, 0.0f, 1.0f, 0.0f);
                GlStateManager.rotate(lllllllllllllllIIIIIIIlIIllIlIlI.nextFloat() * 360.0f + lllllllllllllllIIIIIIIlIIllIllII * 90.0f, 0.0f, 0.0f, 1.0f);
                lllllllllllllllIIIIIIIlIIllIllIl.startDrawing(6);
                final float lllllllllllllllIIIIIIIlIIllIlIII = lllllllllllllllIIIIIIIlIIllIlIlI.nextFloat() * 20.0f + 5.0f + lllllllllllllllIIIIIIIlIIllIlIll * 10.0f;
                final float lllllllllllllllIIIIIIIlIIllIIlll = lllllllllllllllIIIIIIIlIIllIlIlI.nextFloat() * 2.0f + 1.0f + lllllllllllllllIIIIIIIlIIllIlIll * 2.0f;
                lllllllllllllllIIIIIIIlIIllIllIl.func_178974_a(16777215, (int)(255.0f * (1.0f - lllllllllllllllIIIIIIIlIIllIlIll)));
                lllllllllllllllIIIIIIIlIIllIllIl.addVertex(0.0, 0.0, 0.0);
                lllllllllllllllIIIIIIIlIIllIllIl.func_178974_a(16711935, 0);
                lllllllllllllllIIIIIIIlIIllIllIl.addVertex(-0.866 * lllllllllllllllIIIIIIIlIIllIIlll, lllllllllllllllIIIIIIIlIIllIlIII, -0.5f * lllllllllllllllIIIIIIIlIIllIIlll);
                lllllllllllllllIIIIIIIlIIllIllIl.addVertex(0.866 * lllllllllllllllIIIIIIIlIIllIIlll, lllllllllllllllIIIIIIIlIIllIlIII, -0.5f * lllllllllllllllIIIIIIIlIIllIIlll);
                lllllllllllllllIIIIIIIlIIllIllIl.addVertex(0.0, lllllllllllllllIIIIIIIlIIllIlIII, 1.0f * lllllllllllllllIIIIIIIlIIllIIlll);
                lllllllllllllllIIIIIIIlIIllIllIl.addVertex(-0.866 * lllllllllllllllIIIIIIIlIIllIIlll, lllllllllllllllIIIIIIIlIIllIlIII, -0.5f * lllllllllllllllIIIIIIIlIIllIIlll);
                lllllllllllllllIIIIIIIlIIllIlllI.draw();
            }
            GlStateManager.popMatrix();
            GlStateManager.depthMask(true);
            GlStateManager.disableCull();
            GlStateManager.disableBlend();
            GlStateManager.shadeModel(7424);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.func_179098_w();
            GlStateManager.enableAlpha();
            RenderHelper.enableStandardItemLighting();
        }
    }
    
    static {
        __OBFID = "CL_00002420";
    }
    
    @Override
    public void doRenderLayer(final EntityLivingBase lllllllllllllllIIIIIIIlIIlIIlIII, final float lllllllllllllllIIIIIIIlIIlIIIlll, final float lllllllllllllllIIIIIIIlIIlIIIllI, final float lllllllllllllllIIIIIIIlIIlIIIlIl, final float lllllllllllllllIIIIIIIlIIlIIllIl, final float lllllllllllllllIIIIIIIlIIlIIIIll, final float lllllllllllllllIIIIIIIlIIlIIIIlI, final float lllllllllllllllIIIIIIIlIIlIIIIIl) {
        this.func_177213_a((EntityDragon)lllllllllllllllIIIIIIIlIIlIIlIII, lllllllllllllllIIIIIIIlIIlIIIlll, lllllllllllllllIIIIIIIlIIlIIIllI, lllllllllllllllIIIIIIIlIIlIIIlIl, lllllllllllllllIIIIIIIlIIlIIllIl, lllllllllllllllIIIIIIIlIIlIIIIll, lllllllllllllllIIIIIIIlIIlIIIIlI, lllllllllllllllIIIIIIIlIIlIIIIIl);
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
