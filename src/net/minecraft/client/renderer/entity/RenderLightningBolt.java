package net.minecraft.client.renderer.entity;

import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.entity.effect.*;
import java.util.*;
import net.minecraft.client.renderer.*;

public class RenderLightningBolt extends Render
{
    public RenderLightningBolt(final RenderManager lllIlIlllllI) {
        super(lllIlIlllllI);
    }
    
    static {
        __OBFID = "CL_00001011";
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity lllIIlIllIll) {
        return this.getEntityTexture((EntityLightningBolt)lllIIlIllIll);
    }
    
    @Override
    public void doRender(final Entity lllIIlIIlIll, final double lllIIlIIlIlI, final double lllIIlIIlIIl, final double lllIIlIIlIII, final float lllIIlIIlllI, final float lllIIlIIIllI) {
        this.doRender((EntityLightningBolt)lllIIlIIlIll, lllIIlIIlIlI, lllIIlIIlIIl, lllIIlIIlIII, lllIIlIIlllI, lllIIlIIIllI);
    }
    
    protected ResourceLocation getEntityTexture(final EntityLightningBolt lllIIllIIIIl) {
        return null;
    }
    
    public void doRender(final EntityLightningBolt lllIIlllllll, final double lllIlIIllllI, final double lllIlIIlllIl, final double lllIIlllllII, final float lllIlIIllIll, final float lllIlIIllIlI) {
        final Tessellator lllIlIIllIIl = Tessellator.getInstance();
        final WorldRenderer lllIlIIllIII = lllIlIIllIIl.getWorldRenderer();
        GlStateManager.func_179090_x();
        GlStateManager.disableLighting();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 1);
        final double[] lllIlIIlIlll = new double[8];
        final double[] lllIlIIlIllI = new double[8];
        double lllIlIIlIlIl = 0.0;
        double lllIlIIlIlII = 0.0;
        final Random lllIlIIlIIll = new Random(lllIIlllllll.boltVertex);
        for (int lllIlIIlIIlI = 7; lllIlIIlIIlI >= 0; --lllIlIIlIIlI) {
            lllIlIIlIlll[lllIlIIlIIlI] = lllIlIIlIlIl;
            lllIlIIlIllI[lllIlIIlIIlI] = lllIlIIlIlII;
            lllIlIIlIlIl += lllIlIIlIIll.nextInt(11) - 5;
            lllIlIIlIlII += lllIlIIlIIll.nextInt(11) - 5;
        }
        for (int lllIlIIlIIIl = 0; lllIlIIlIIIl < 4; ++lllIlIIlIIIl) {
            final Random lllIlIIlIIII = new Random(lllIIlllllll.boltVertex);
            for (int lllIlIIIllll = 0; lllIlIIIllll < 3; ++lllIlIIIllll) {
                int lllIlIIIlllI = 7;
                int lllIlIIIllIl = 0;
                if (lllIlIIIllll > 0) {
                    lllIlIIIlllI = 7 - lllIlIIIllll;
                }
                if (lllIlIIIllll > 0) {
                    lllIlIIIllIl = lllIlIIIlllI - 2;
                }
                double lllIlIIIllII = lllIlIIlIlll[lllIlIIIlllI] - lllIlIIlIlIl;
                double lllIlIIIlIll = lllIlIIlIllI[lllIlIIIlllI] - lllIlIIlIlII;
                for (int lllIlIIIlIlI = lllIlIIIlllI; lllIlIIIlIlI >= lllIlIIIllIl; --lllIlIIIlIlI) {
                    final double lllIlIIIlIIl = lllIlIIIllII;
                    final double lllIlIIIlIII = lllIlIIIlIll;
                    if (lllIlIIIllll == 0) {
                        lllIlIIIllII += lllIlIIlIIII.nextInt(11) - 5;
                        lllIlIIIlIll += lllIlIIlIIII.nextInt(11) - 5;
                    }
                    else {
                        lllIlIIIllII += lllIlIIlIIII.nextInt(31) - 15;
                        lllIlIIIlIll += lllIlIIlIIII.nextInt(31) - 15;
                    }
                    lllIlIIllIII.startDrawing(5);
                    final float lllIlIIIIlll = 0.5f;
                    lllIlIIllIII.func_178960_a(0.9f * lllIlIIIIlll, 0.9f * lllIlIIIIlll, 1.0f * lllIlIIIIlll, 0.3f);
                    double lllIlIIIIllI = 0.1 + lllIlIIlIIIl * 0.2;
                    if (lllIlIIIllll == 0) {
                        lllIlIIIIllI *= lllIlIIIlIlI * 0.1 + 1.0;
                    }
                    double lllIlIIIIlIl = 0.1 + lllIlIIlIIIl * 0.2;
                    if (lllIlIIIllll == 0) {
                        lllIlIIIIlIl *= (lllIlIIIlIlI - 1) * 0.1 + 1.0;
                    }
                    for (int lllIlIIIIlII = 0; lllIlIIIIlII < 5; ++lllIlIIIIlII) {
                        double lllIlIIIIIll = lllIlIIllllI + 0.5 - lllIlIIIIllI;
                        double lllIlIIIIIlI = lllIIlllllII + 0.5 - lllIlIIIIllI;
                        if (lllIlIIIIlII == 1 || lllIlIIIIlII == 2) {
                            lllIlIIIIIll += lllIlIIIIllI * 2.0;
                        }
                        if (lllIlIIIIlII == 2 || lllIlIIIIlII == 3) {
                            lllIlIIIIIlI += lllIlIIIIllI * 2.0;
                        }
                        double lllIlIIIIIIl = lllIlIIllllI + 0.5 - lllIlIIIIlIl;
                        double lllIlIIIIIII = lllIIlllllII + 0.5 - lllIlIIIIlIl;
                        if (lllIlIIIIlII == 1 || lllIlIIIIlII == 2) {
                            lllIlIIIIIIl += lllIlIIIIlIl * 2.0;
                        }
                        if (lllIlIIIIlII == 2 || lllIlIIIIlII == 3) {
                            lllIlIIIIIII += lllIlIIIIlIl * 2.0;
                        }
                        lllIlIIllIII.addVertex(lllIlIIIIIIl + lllIlIIIllII, lllIlIIlllIl + lllIlIIIlIlI * 16, lllIlIIIIIII + lllIlIIIlIll);
                        lllIlIIllIII.addVertex(lllIlIIIIIll + lllIlIIIlIIl, lllIlIIlllIl + (lllIlIIIlIlI + 1) * 16, lllIlIIIIIlI + lllIlIIIlIII);
                    }
                    lllIlIIllIIl.draw();
                }
            }
        }
        GlStateManager.disableBlend();
        GlStateManager.enableLighting();
        GlStateManager.func_179098_w();
    }
}
