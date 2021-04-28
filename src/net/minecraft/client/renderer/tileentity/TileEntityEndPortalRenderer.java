package net.minecraft.client.renderer.tileentity;

import java.nio.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.tileentity.*;
import net.minecraft.client.renderer.*;

public class TileEntityEndPortalRenderer extends TileEntitySpecialRenderer
{
    /* synthetic */ FloatBuffer field_147528_b;
    private static final /* synthetic */ Random field_147527_e;
    private static final /* synthetic */ ResourceLocation field_147526_d;
    private static final /* synthetic */ ResourceLocation field_147529_c;
    
    public void func_180544_a(final TileEntityEndPortal llllllllllllllllIlIIlIIIIIlIlIII, final double llllllllllllllllIlIIlIIIIIlIIllI, final double llllllllllllllllIlIIlIIIIIlIIlII, final double llllllllllllllllIlIIlIIIIIlIIIlI, final float llllllllllllllllIlIIlIIIIIlIIIII, final int llllllllllllllllIlIIlIIIIIIllllI) {
        final float llllllllllllllllIlIIlIIIIIIlllII = (float)this.rendererDispatcher.field_147560_j;
        final float llllllllllllllllIlIIlIIIIIIllIlI = (float)this.rendererDispatcher.field_147561_k;
        final float llllllllllllllllIlIIlIIIIIIllIII = (float)this.rendererDispatcher.field_147558_l;
        GlStateManager.disableLighting();
        TileEntityEndPortalRenderer.field_147527_e.setSeed(31100L);
        final float llllllllllllllllIlIIlIIIIIIlIllI = 0.75f;
        for (int llllllllllllllllIlIIlIIIIIIlIlII = 0; llllllllllllllllIlIIlIIIIIIlIlII < 16; ++llllllllllllllllIlIIlIIIIIIlIlII) {
            GlStateManager.pushMatrix();
            float llllllllllllllllIlIIlIIIIIIlIIlI = (float)(16 - llllllllllllllllIlIIlIIIIIIlIlII);
            float llllllllllllllllIlIIlIIIIIIlIIII = 0.0625f;
            float llllllllllllllllIlIIlIIIIIIIllll = 1.0f / (llllllllllllllllIlIIlIIIIIIlIIlI + 1.0f);
            if (llllllllllllllllIlIIlIIIIIIlIlII == 0) {
                this.bindTexture(TileEntityEndPortalRenderer.field_147529_c);
                llllllllllllllllIlIIlIIIIIIIllll = 0.1f;
                llllllllllllllllIlIIlIIIIIIlIIlI = 65.0f;
                llllllllllllllllIlIIlIIIIIIlIIII = 0.125f;
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(770, 771);
            }
            if (llllllllllllllllIlIIlIIIIIIlIlII >= 1) {
                this.bindTexture(TileEntityEndPortalRenderer.field_147526_d);
            }
            if (llllllllllllllllIlIIlIIIIIIlIlII == 1) {
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(1, 1);
                llllllllllllllllIlIIlIIIIIIlIIII = 0.5f;
            }
            final float llllllllllllllllIlIIlIIIIIIIlllI = (float)(-(llllllllllllllllIlIIlIIIIIlIIlII + llllllllllllllllIlIIlIIIIIIlIllI));
            float llllllllllllllllIlIIlIIIIIIIllIl = llllllllllllllllIlIIlIIIIIIIlllI + (float)ActiveRenderInfo.func_178804_a().yCoord;
            final float llllllllllllllllIlIIlIIIIIIIllII = llllllllllllllllIlIIlIIIIIIIlllI + llllllllllllllllIlIIlIIIIIIlIIlI + (float)ActiveRenderInfo.func_178804_a().yCoord;
            float llllllllllllllllIlIIlIIIIIIIlIll = llllllllllllllllIlIIlIIIIIIIllIl / llllllllllllllllIlIIlIIIIIIIllII;
            llllllllllllllllIlIIlIIIIIIIlIll += (float)(llllllllllllllllIlIIlIIIIIlIIlII + llllllllllllllllIlIIlIIIIIIlIllI);
            GlStateManager.translate(llllllllllllllllIlIIlIIIIIIlllII, llllllllllllllllIlIIlIIIIIIIlIll, llllllllllllllllIlIIlIIIIIIllIII);
            GlStateManager.texGen(GlStateManager.TexGen.S, 9217);
            GlStateManager.texGen(GlStateManager.TexGen.T, 9217);
            GlStateManager.texGen(GlStateManager.TexGen.R, 9217);
            GlStateManager.texGen(GlStateManager.TexGen.Q, 9216);
            GlStateManager.func_179105_a(GlStateManager.TexGen.S, 9473, this.func_147525_a(1.0f, 0.0f, 0.0f, 0.0f));
            GlStateManager.func_179105_a(GlStateManager.TexGen.T, 9473, this.func_147525_a(0.0f, 0.0f, 1.0f, 0.0f));
            GlStateManager.func_179105_a(GlStateManager.TexGen.R, 9473, this.func_147525_a(0.0f, 0.0f, 0.0f, 1.0f));
            GlStateManager.func_179105_a(GlStateManager.TexGen.Q, 9474, this.func_147525_a(0.0f, 1.0f, 0.0f, 0.0f));
            GlStateManager.enableTexGenCoord(GlStateManager.TexGen.S);
            GlStateManager.enableTexGenCoord(GlStateManager.TexGen.T);
            GlStateManager.enableTexGenCoord(GlStateManager.TexGen.R);
            GlStateManager.enableTexGenCoord(GlStateManager.TexGen.Q);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.loadIdentity();
            GlStateManager.translate(0.0f, Minecraft.getSystemTime() % 700000L / 700000.0f, 0.0f);
            GlStateManager.scale(llllllllllllllllIlIIlIIIIIIlIIII, llllllllllllllllIlIIlIIIIIIlIIII, llllllllllllllllIlIIlIIIIIIlIIII);
            GlStateManager.translate(0.5f, 0.5f, 0.0f);
            GlStateManager.rotate((llllllllllllllllIlIIlIIIIIIlIlII * llllllllllllllllIlIIlIIIIIIlIlII * 4321 + llllllllllllllllIlIIlIIIIIIlIlII * 9) * 2.0f, 0.0f, 0.0f, 1.0f);
            GlStateManager.translate(-0.5f, -0.5f, 0.0f);
            GlStateManager.translate(-llllllllllllllllIlIIlIIIIIIlllII, -llllllllllllllllIlIIlIIIIIIllIII, -llllllllllllllllIlIIlIIIIIIllIlI);
            llllllllllllllllIlIIlIIIIIIIllIl = llllllllllllllllIlIIlIIIIIIIlllI + (float)ActiveRenderInfo.func_178804_a().yCoord;
            GlStateManager.translate((float)ActiveRenderInfo.func_178804_a().xCoord * llllllllllllllllIlIIlIIIIIIlIIlI / llllllllllllllllIlIIlIIIIIIIllIl, (float)ActiveRenderInfo.func_178804_a().zCoord * llllllllllllllllIlIIlIIIIIIlIIlI / llllllllllllllllIlIIlIIIIIIIllIl, -llllllllllllllllIlIIlIIIIIIllIlI);
            final Tessellator llllllllllllllllIlIIlIIIIIIIlIlI = Tessellator.getInstance();
            final WorldRenderer llllllllllllllllIlIIlIIIIIIIlIIl = llllllllllllllllIlIIlIIIIIIIlIlI.getWorldRenderer();
            llllllllllllllllIlIIlIIIIIIIlIIl.startDrawingQuads();
            float llllllllllllllllIlIIlIIIIIIIlIII = TileEntityEndPortalRenderer.field_147527_e.nextFloat() * 0.5f + 0.1f;
            float llllllllllllllllIlIIlIIIIIIIIlll = TileEntityEndPortalRenderer.field_147527_e.nextFloat() * 0.5f + 0.4f;
            float llllllllllllllllIlIIlIIIIIIIIlIl = TileEntityEndPortalRenderer.field_147527_e.nextFloat() * 0.5f + 0.5f;
            if (llllllllllllllllIlIIlIIIIIIlIlII == 0) {
                llllllllllllllllIlIIlIIIIIIIIlIl = 1.0f;
                llllllllllllllllIlIIlIIIIIIIIlll = 1.0f;
                llllllllllllllllIlIIlIIIIIIIlIII = 1.0f;
            }
            llllllllllllllllIlIIlIIIIIIIlIIl.func_178960_a(llllllllllllllllIlIIlIIIIIIIlIII * llllllllllllllllIlIIlIIIIIIIllll, llllllllllllllllIlIIlIIIIIIIIlll * llllllllllllllllIlIIlIIIIIIIllll, llllllllllllllllIlIIlIIIIIIIIlIl * llllllllllllllllIlIIlIIIIIIIllll, 1.0f);
            llllllllllllllllIlIIlIIIIIIIlIIl.addVertex(llllllllllllllllIlIIlIIIIIlIIllI, llllllllllllllllIlIIlIIIIIlIIlII + llllllllllllllllIlIIlIIIIIIlIllI, llllllllllllllllIlIIlIIIIIlIIIlI);
            llllllllllllllllIlIIlIIIIIIIlIIl.addVertex(llllllllllllllllIlIIlIIIIIlIIllI, llllllllllllllllIlIIlIIIIIlIIlII + llllllllllllllllIlIIlIIIIIIlIllI, llllllllllllllllIlIIlIIIIIlIIIlI + 1.0);
            llllllllllllllllIlIIlIIIIIIIlIIl.addVertex(llllllllllllllllIlIIlIIIIIlIIllI + 1.0, llllllllllllllllIlIIlIIIIIlIIlII + llllllllllllllllIlIIlIIIIIIlIllI, llllllllllllllllIlIIlIIIIIlIIIlI + 1.0);
            llllllllllllllllIlIIlIIIIIIIlIIl.addVertex(llllllllllllllllIlIIlIIIIIlIIllI + 1.0, llllllllllllllllIlIIlIIIIIlIIlII + llllllllllllllllIlIIlIIIIIIlIllI, llllllllllllllllIlIIlIIIIIlIIIlI);
            llllllllllllllllIlIIlIIIIIIIlIlI.draw();
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
        GlStateManager.disableBlend();
        GlStateManager.disableTexGenCoord(GlStateManager.TexGen.S);
        GlStateManager.disableTexGenCoord(GlStateManager.TexGen.T);
        GlStateManager.disableTexGenCoord(GlStateManager.TexGen.R);
        GlStateManager.disableTexGenCoord(GlStateManager.TexGen.Q);
        GlStateManager.enableLighting();
    }
    
    @Override
    public void renderTileEntityAt(final TileEntity llllllllllllllllIlIIIllllIlllIll, final double llllllllllllllllIlIIIllllIlllIlI, final double llllllllllllllllIlIIIllllIlllIIl, final double llllllllllllllllIlIIIllllIllllll, final float llllllllllllllllIlIIIllllIllIlll, final int llllllllllllllllIlIIIllllIllIllI) {
        this.func_180544_a((TileEntityEndPortal)llllllllllllllllIlIIIllllIlllIll, llllllllllllllllIlIIIllllIlllIlI, llllllllllllllllIlIIIllllIlllIIl, llllllllllllllllIlIIIllllIllllll, llllllllllllllllIlIIIllllIllIlll, llllllllllllllllIlIIIllllIllIllI);
    }
    
    static {
        __OBFID = "CL_00002467";
        field_147529_c = new ResourceLocation("textures/environment/end_sky.png");
        field_147526_d = new ResourceLocation("textures/entity/end_portal.png");
        field_147527_e = new Random(31100L);
    }
    
    public TileEntityEndPortalRenderer() {
        this.field_147528_b = GLAllocation.createDirectFloatBuffer(16);
    }
    
    private FloatBuffer func_147525_a(final float llllllllllllllllIlIIIlllllIIlllI, final float llllllllllllllllIlIIIlllllIIllIl, final float llllllllllllllllIlIIIlllllIIllII, final float llllllllllllllllIlIIIlllllIIlIll) {
        this.field_147528_b.clear();
        this.field_147528_b.put(llllllllllllllllIlIIIlllllIIlllI).put(llllllllllllllllIlIIIlllllIIllIl).put(llllllllllllllllIlIIIlllllIIllII).put(llllllllllllllllIlIIIlllllIIlIll);
        this.field_147528_b.flip();
        return this.field_147528_b;
    }
}
