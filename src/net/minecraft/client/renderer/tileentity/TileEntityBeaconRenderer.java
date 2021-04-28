package net.minecraft.client.renderer.tileentity;

import org.lwjgl.opengl.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import java.util.*;
import net.minecraft.tileentity.*;

public class TileEntityBeaconRenderer extends TileEntitySpecialRenderer
{
    private static final /* synthetic */ ResourceLocation beaconBeam;
    
    static {
        __OBFID = "CL_00000962";
        beaconBeam = new ResourceLocation("textures/entity/beacon_beam.png");
    }
    
    public void func_180536_a(final TileEntityBeacon lllllllllllllllIIIIIIIIllllIlllI, final double lllllllllllllllIIIIIIIlIIIIIllII, final double lllllllllllllllIIIIIIIlIIIIIlIll, final double lllllllllllllllIIIIIIIIllllIlIll, final float lllllllllllllllIIIIIIIIllllIlIlI, final int lllllllllllllllIIIIIIIlIIIIIlIII) {
        final float lllllllllllllllIIIIIIIlIIIIIIlll = lllllllllllllllIIIIIIIIllllIlllI.shouldBeamRender();
        GlStateManager.alphaFunc(516, 0.1f);
        if (lllllllllllllllIIIIIIIlIIIIIIlll > 0.0f) {
            final Tessellator lllllllllllllllIIIIIIIlIIIIIIllI = Tessellator.getInstance();
            final WorldRenderer lllllllllllllllIIIIIIIlIIIIIIlIl = lllllllllllllllIIIIIIIlIIIIIIllI.getWorldRenderer();
            final List lllllllllllllllIIIIIIIlIIIIIIlII = lllllllllllllllIIIIIIIIllllIlllI.func_174907_n();
            int lllllllllllllllIIIIIIIlIIIIIIIll = 0;
            for (int lllllllllllllllIIIIIIIlIIIIIIIlI = 0; lllllllllllllllIIIIIIIlIIIIIIIlI < lllllllllllllllIIIIIIIlIIIIIIlII.size(); ++lllllllllllllllIIIIIIIlIIIIIIIlI) {
                final TileEntityBeacon.BeamSegment lllllllllllllllIIIIIIIlIIIIIIIIl = lllllllllllllllIIIIIIIlIIIIIIlII.get(lllllllllllllllIIIIIIIlIIIIIIIlI);
                final int lllllllllllllllIIIIIIIlIIIIIIIII = lllllllllllllllIIIIIIIlIIIIIIIll + lllllllllllllllIIIIIIIlIIIIIIIIl.func_177264_c();
                this.bindTexture(TileEntityBeaconRenderer.beaconBeam);
                GL11.glTexParameterf(3553, 10242, 10497.0f);
                GL11.glTexParameterf(3553, 10243, 10497.0f);
                GlStateManager.disableLighting();
                GlStateManager.disableCull();
                GlStateManager.disableBlend();
                GlStateManager.depthMask(true);
                GlStateManager.tryBlendFuncSeparate(770, 1, 1, 0);
                final float lllllllllllllllIIIIIIIIlllllllll = lllllllllllllllIIIIIIIIllllIlllI.getWorld().getTotalWorldTime() + lllllllllllllllIIIIIIIIllllIlIlI;
                final float lllllllllllllllIIIIIIIIllllllllI = -lllllllllllllllIIIIIIIIlllllllll * 0.2f - MathHelper.floor_float(-lllllllllllllllIIIIIIIIlllllllll * 0.1f);
                double lllllllllllllllIIIIIIIIlllllllIl = lllllllllllllllIIIIIIIIlllllllll * 0.025 * -1.5;
                lllllllllllllllIIIIIIIlIIIIIIlIl.startDrawingQuads();
                double lllllllllllllllIIIIIIIIlllllllII = 0.2;
                double lllllllllllllllIIIIIIIIllllllIll = 0.5 + Math.cos(lllllllllllllllIIIIIIIIlllllllIl + 2.356194490192345) * lllllllllllllllIIIIIIIIlllllllII;
                double lllllllllllllllIIIIIIIIllllllIlI = 0.5 + Math.sin(lllllllllllllllIIIIIIIIlllllllIl + 2.356194490192345) * lllllllllllllllIIIIIIIIlllllllII;
                double lllllllllllllllIIIIIIIIllllllIIl = 0.5 + Math.cos(lllllllllllllllIIIIIIIIlllllllIl + 0.7853981633974483) * lllllllllllllllIIIIIIIIlllllllII;
                double lllllllllllllllIIIIIIIIllllllIII = 0.5 + Math.sin(lllllllllllllllIIIIIIIIlllllllIl + 0.7853981633974483) * lllllllllllllllIIIIIIIIlllllllII;
                double lllllllllllllllIIIIIIIIlllllIlll = 0.5 + Math.cos(lllllllllllllllIIIIIIIIlllllllIl + 3.9269908169872414) * lllllllllllllllIIIIIIIIlllllllII;
                double lllllllllllllllIIIIIIIIlllllIllI = 0.5 + Math.sin(lllllllllllllllIIIIIIIIlllllllIl + 3.9269908169872414) * lllllllllllllllIIIIIIIIlllllllII;
                double lllllllllllllllIIIIIIIIlllllIlIl = 0.5 + Math.cos(lllllllllllllllIIIIIIIIlllllllIl + 5.497787143782138) * lllllllllllllllIIIIIIIIlllllllII;
                double lllllllllllllllIIIIIIIIlllllIlII = 0.5 + Math.sin(lllllllllllllllIIIIIIIIlllllllIl + 5.497787143782138) * lllllllllllllllIIIIIIIIlllllllII;
                double lllllllllllllllIIIIIIIIlllllIIll = 0.0;
                double lllllllllllllllIIIIIIIIlllllIIlI = 1.0;
                final double lllllllllllllllIIIIIIIIlllllIIIl = -1.0f + lllllllllllllllIIIIIIIIllllllllI;
                final double lllllllllllllllIIIIIIIIlllllIIII = lllllllllllllllIIIIIIIlIIIIIIIIl.func_177264_c() * lllllllllllllllIIIIIIIlIIIIIIlll * (0.5 / lllllllllllllllIIIIIIIIlllllllII) + lllllllllllllllIIIIIIIIlllllIIIl;
                lllllllllllllllIIIIIIIlIIIIIIlIl.func_178960_a(lllllllllllllllIIIIIIIlIIIIIIIIl.func_177263_b()[0], lllllllllllllllIIIIIIIlIIIIIIIIl.func_177263_b()[1], lllllllllllllllIIIIIIIlIIIIIIIIl.func_177263_b()[2], 0.125f);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIllllllIll, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIII, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIllllllIlI, lllllllllllllllIIIIIIIIlllllIIlI, lllllllllllllllIIIIIIIIlllllIIII);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIllllllIll, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIll, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIllllllIlI, lllllllllllllllIIIIIIIIlllllIIlI, lllllllllllllllIIIIIIIIlllllIIIl);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIllllllIIl, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIll, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIllllllIII, lllllllllllllllIIIIIIIIlllllIIll, lllllllllllllllIIIIIIIIlllllIIIl);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIllllllIIl, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIII, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIllllllIII, lllllllllllllllIIIIIIIIlllllIIll, lllllllllllllllIIIIIIIIlllllIIII);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIlllllIlIl, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIII, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIlllllIlII, lllllllllllllllIIIIIIIIlllllIIlI, lllllllllllllllIIIIIIIIlllllIIII);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIlllllIlIl, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIll, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIlllllIlII, lllllllllllllllIIIIIIIIlllllIIlI, lllllllllllllllIIIIIIIIlllllIIIl);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIlllllIlll, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIll, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIlllllIllI, lllllllllllllllIIIIIIIIlllllIIll, lllllllllllllllIIIIIIIIlllllIIIl);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIlllllIlll, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIII, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIlllllIllI, lllllllllllllllIIIIIIIIlllllIIll, lllllllllllllllIIIIIIIIlllllIIII);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIllllllIIl, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIII, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIllllllIII, lllllllllllllllIIIIIIIIlllllIIlI, lllllllllllllllIIIIIIIIlllllIIII);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIllllllIIl, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIll, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIllllllIII, lllllllllllllllIIIIIIIIlllllIIlI, lllllllllllllllIIIIIIIIlllllIIIl);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIlllllIlIl, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIll, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIlllllIlII, lllllllllllllllIIIIIIIIlllllIIll, lllllllllllllllIIIIIIIIlllllIIIl);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIlllllIlIl, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIII, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIlllllIlII, lllllllllllllllIIIIIIIIlllllIIll, lllllllllllllllIIIIIIIIlllllIIII);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIlllllIlll, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIII, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIlllllIllI, lllllllllllllllIIIIIIIIlllllIIlI, lllllllllllllllIIIIIIIIlllllIIII);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIlllllIlll, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIll, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIlllllIllI, lllllllllllllllIIIIIIIIlllllIIlI, lllllllllllllllIIIIIIIIlllllIIIl);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIllllllIll, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIll, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIllllllIlI, lllllllllllllllIIIIIIIIlllllIIll, lllllllllllllllIIIIIIIIlllllIIIl);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIllllllIll, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIII, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIllllllIlI, lllllllllllllllIIIIIIIIlllllIIll, lllllllllllllllIIIIIIIIlllllIIII);
                lllllllllllllllIIIIIIIlIIIIIIllI.draw();
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                GlStateManager.depthMask(false);
                lllllllllllllllIIIIIIIlIIIIIIlIl.startDrawingQuads();
                lllllllllllllllIIIIIIIlIIIIIIlIl.func_178960_a(lllllllllllllllIIIIIIIlIIIIIIIIl.func_177263_b()[0], lllllllllllllllIIIIIIIlIIIIIIIIl.func_177263_b()[1], lllllllllllllllIIIIIIIlIIIIIIIIl.func_177263_b()[2], 0.125f);
                lllllllllllllllIIIIIIIIlllllllIl = 0.2;
                lllllllllllllllIIIIIIIIlllllllII = 0.2;
                lllllllllllllllIIIIIIIIllllllIll = 0.8;
                lllllllllllllllIIIIIIIIllllllIlI = 0.2;
                lllllllllllllllIIIIIIIIllllllIIl = 0.2;
                lllllllllllllllIIIIIIIIllllllIII = 0.8;
                lllllllllllllllIIIIIIIIlllllIlll = 0.8;
                lllllllllllllllIIIIIIIIlllllIllI = 0.8;
                lllllllllllllllIIIIIIIIlllllIlIl = 0.0;
                lllllllllllllllIIIIIIIIlllllIlII = 1.0;
                lllllllllllllllIIIIIIIIlllllIIll = -1.0f + lllllllllllllllIIIIIIIIllllllllI;
                lllllllllllllllIIIIIIIIlllllIIlI = lllllllllllllllIIIIIIIlIIIIIIIIl.func_177264_c() * lllllllllllllllIIIIIIIlIIIIIIlll + lllllllllllllllIIIIIIIIlllllIIll;
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIlllllllIl, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIII, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIlllllllII, lllllllllllllllIIIIIIIIlllllIlII, lllllllllllllllIIIIIIIIlllllIIlI);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIlllllllIl, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIll, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIlllllllII, lllllllllllllllIIIIIIIIlllllIlII, lllllllllllllllIIIIIIIIlllllIIll);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIllllllIll, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIll, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIllllllIlI, lllllllllllllllIIIIIIIIlllllIlIl, lllllllllllllllIIIIIIIIlllllIIll);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIllllllIll, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIII, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIllllllIlI, lllllllllllllllIIIIIIIIlllllIlIl, lllllllllllllllIIIIIIIIlllllIIlI);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIlllllIlll, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIII, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIlllllIllI, lllllllllllllllIIIIIIIIlllllIlII, lllllllllllllllIIIIIIIIlllllIIlI);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIlllllIlll, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIll, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIlllllIllI, lllllllllllllllIIIIIIIIlllllIlII, lllllllllllllllIIIIIIIIlllllIIll);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIllllllIIl, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIll, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIllllllIII, lllllllllllllllIIIIIIIIlllllIlIl, lllllllllllllllIIIIIIIIlllllIIll);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIllllllIIl, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIII, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIllllllIII, lllllllllllllllIIIIIIIIlllllIlIl, lllllllllllllllIIIIIIIIlllllIIlI);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIllllllIll, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIII, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIllllllIlI, lllllllllllllllIIIIIIIIlllllIlII, lllllllllllllllIIIIIIIIlllllIIlI);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIllllllIll, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIll, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIllllllIlI, lllllllllllllllIIIIIIIIlllllIlII, lllllllllllllllIIIIIIIIlllllIIll);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIlllllIlll, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIll, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIlllllIllI, lllllllllllllllIIIIIIIIlllllIlIl, lllllllllllllllIIIIIIIIlllllIIll);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIlllllIlll, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIII, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIlllllIllI, lllllllllllllllIIIIIIIIlllllIlIl, lllllllllllllllIIIIIIIIlllllIIlI);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIllllllIIl, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIII, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIllllllIII, lllllllllllllllIIIIIIIIlllllIlII, lllllllllllllllIIIIIIIIlllllIIlI);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIllllllIIl, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIll, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIllllllIII, lllllllllllllllIIIIIIIIlllllIlII, lllllllllllllllIIIIIIIIlllllIIll);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIlllllllIl, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIll, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIlllllllII, lllllllllllllllIIIIIIIIlllllIlIl, lllllllllllllllIIIIIIIIlllllIIll);
                lllllllllllllllIIIIIIIlIIIIIIlIl.addVertexWithUV(lllllllllllllllIIIIIIIlIIIIIllII + lllllllllllllllIIIIIIIIlllllllIl, lllllllllllllllIIIIIIIlIIIIIlIll + lllllllllllllllIIIIIIIlIIIIIIIII, lllllllllllllllIIIIIIIIllllIlIll + lllllllllllllllIIIIIIIIlllllllII, lllllllllllllllIIIIIIIIlllllIlIl, lllllllllllllllIIIIIIIIlllllIIlI);
                lllllllllllllllIIIIIIIlIIIIIIllI.draw();
                GlStateManager.enableLighting();
                GlStateManager.func_179098_w();
                GlStateManager.depthMask(true);
                lllllllllllllllIIIIIIIlIIIIIIIll = lllllllllllllllIIIIIIIlIIIIIIIII;
            }
        }
    }
    
    @Override
    public void renderTileEntityAt(final TileEntity lllllllllllllllIIIIIIIIlllIIIIlI, final double lllllllllllllllIIIIIIIIlllIIlIII, final double lllllllllllllllIIIIIIIIlllIIIIII, final double lllllllllllllllIIIIIIIIlllIIIllI, final float lllllllllllllllIIIIIIIIllIlllllI, final int lllllllllllllllIIIIIIIIllIllllIl) {
        this.func_180536_a((TileEntityBeacon)lllllllllllllllIIIIIIIIlllIIIIlI, lllllllllllllllIIIIIIIIlllIIlIII, lllllllllllllllIIIIIIIIlllIIIIII, lllllllllllllllIIIIIIIIlllIIIllI, lllllllllllllllIIIIIIIIllIlllllI, lllllllllllllllIIIIIIIIllIllllIl);
    }
}
