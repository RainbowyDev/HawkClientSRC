package net.minecraft.client.renderer.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;

public class RenderPainting extends Render
{
    private static final /* synthetic */ ResourceLocation field_110807_a;
    
    static {
        __OBFID = "CL_00001018";
        field_110807_a = new ResourceLocation("textures/painting/paintings_kristoffer_zetterstrand.png");
    }
    
    @Override
    public void doRender(final Entity llllllllllllllIllIllIIllIlIIIIlI, final double llllllllllllllIllIllIIllIlIIlIII, final double llllllllllllllIllIllIIllIlIIIIII, final double llllllllllllllIllIllIIllIIllllll, final float llllllllllllllIllIllIIllIIlllllI, final float llllllllllllllIllIllIIllIlIIIlII) {
        this.doRender((EntityPainting)llllllllllllllIllIllIIllIlIIIIlI, llllllllllllllIllIllIIllIlIIlIII, llllllllllllllIllIllIIllIlIIIIII, llllllllllllllIllIllIIllIIllllll, llllllllllllllIllIllIIllIIlllllI, llllllllllllllIllIllIIllIlIIIlII);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllllIllIllIIllIlIlIIlI) {
        return this.func_180562_a((EntityPainting)llllllllllllllIllIllIIllIlIlIIlI);
    }
    
    public void doRender(final EntityPainting llllllllllllllIllIllIIlllllIlllI, final double llllllllllllllIllIllIIlllllIIlII, final double llllllllllllllIllIllIIlllllIllII, final double llllllllllllllIllIllIIlllllIlIll, final float llllllllllllllIllIllIIlllllIlIlI, final float llllllllllllllIllIllIIlllllIIIII) {
        GlStateManager.pushMatrix();
        GlStateManager.translate(llllllllllllllIllIllIIlllllIIlII, llllllllllllllIllIllIIlllllIllII, llllllllllllllIllIllIIlllllIlIll);
        GlStateManager.rotate(180.0f - llllllllllllllIllIllIIlllllIlIlI, 0.0f, 1.0f, 0.0f);
        GlStateManager.enableRescaleNormal();
        this.bindEntityTexture(llllllllllllllIllIllIIlllllIlllI);
        final EntityPainting.EnumArt llllllllllllllIllIllIIlllllIlIII = llllllllllllllIllIllIIlllllIlllI.art;
        final float llllllllllllllIllIllIIlllllIIlll = 0.0625f;
        GlStateManager.scale(llllllllllllllIllIllIIlllllIIlll, llllllllllllllIllIllIIlllllIIlll, llllllllllllllIllIllIIlllllIIlll);
        this.func_77010_a(llllllllllllllIllIllIIlllllIlllI, llllllllllllllIllIllIIlllllIlIII.sizeX, llllllllllllllIllIllIIlllllIlIII.sizeY, llllllllllllllIllIllIIlllllIlIII.offsetX, llllllllllllllIllIllIIlllllIlIII.offsetY);
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(llllllllllllllIllIllIIlllllIlllI, llllllllllllllIllIllIIlllllIIlII, llllllllllllllIllIllIIlllllIllII, llllllllllllllIllIllIIlllllIlIll, llllllllllllllIllIllIIlllllIlIlI, llllllllllllllIllIllIIlllllIIIII);
    }
    
    private void func_77008_a(final EntityPainting llllllllllllllIllIllIIllIllIllII, final float llllllllllllllIllIllIIllIllIIIII, final float llllllllllllllIllIllIIllIlIlllll) {
        int llllllllllllllIllIllIIllIllIlIIl = MathHelper.floor_double(llllllllllllllIllIllIIllIllIllII.posX);
        final int llllllllllllllIllIllIIllIllIlIII = MathHelper.floor_double(llllllllllllllIllIllIIllIllIllII.posY + llllllllllllllIllIllIIllIlIlllll / 16.0f);
        int llllllllllllllIllIllIIllIllIIlll = MathHelper.floor_double(llllllllllllllIllIllIIllIllIllII.posZ);
        final EnumFacing llllllllllllllIllIllIIllIllIIllI = llllllllllllllIllIllIIllIllIllII.field_174860_b;
        if (llllllllllllllIllIllIIllIllIIllI == EnumFacing.NORTH) {
            llllllllllllllIllIllIIllIllIlIIl = MathHelper.floor_double(llllllllllllllIllIllIIllIllIllII.posX + llllllllllllllIllIllIIllIllIIIII / 16.0f);
        }
        if (llllllllllllllIllIllIIllIllIIllI == EnumFacing.WEST) {
            llllllllllllllIllIllIIllIllIIlll = MathHelper.floor_double(llllllllllllllIllIllIIllIllIllII.posZ - llllllllllllllIllIllIIllIllIIIII / 16.0f);
        }
        if (llllllllllllllIllIllIIllIllIIllI == EnumFacing.SOUTH) {
            llllllllllllllIllIllIIllIllIlIIl = MathHelper.floor_double(llllllllllllllIllIllIIllIllIllII.posX - llllllllllllllIllIllIIllIllIIIII / 16.0f);
        }
        if (llllllllllllllIllIllIIllIllIIllI == EnumFacing.EAST) {
            llllllllllllllIllIllIIllIllIIlll = MathHelper.floor_double(llllllllllllllIllIllIIllIllIllII.posZ + llllllllllllllIllIllIIllIllIIIII / 16.0f);
        }
        final int llllllllllllllIllIllIIllIllIIlIl = this.renderManager.worldObj.getCombinedLight(new BlockPos(llllllllllllllIllIllIIllIllIlIIl, llllllllllllllIllIllIIllIllIlIII, llllllllllllllIllIllIIllIllIIlll), 0);
        final int llllllllllllllIllIllIIllIllIIlII = llllllllllllllIllIllIIllIllIIlIl % 65536;
        final int llllllllllllllIllIllIIllIllIIIll = llllllllllllllIllIllIIllIllIIlIl / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)llllllllllllllIllIllIIllIllIIlII, (float)llllllllllllllIllIllIIllIllIIIll);
        GlStateManager.color(1.0f, 1.0f, 1.0f);
    }
    
    protected ResourceLocation func_180562_a(final EntityPainting llllllllllllllIllIllIIllllIlllII) {
        return RenderPainting.field_110807_a;
    }
    
    public RenderPainting(final RenderManager llllllllllllllIllIllIIlllllllIll) {
        super(llllllllllllllIllIllIIlllllllIll);
    }
    
    private void func_77010_a(final EntityPainting llllllllllllllIllIllIIlllIIllIII, final int llllllllllllllIllIllIIlllIlllIII, final int llllllllllllllIllIllIIlllIIlIllI, final int llllllllllllllIllIllIIlllIllIllI, final int llllllllllllllIllIllIIlllIllIlIl) {
        final float llllllllllllllIllIllIIlllIllIlII = -llllllllllllllIllIllIIlllIlllIII / 2.0f;
        final float llllllllllllllIllIllIIlllIllIIll = -llllllllllllllIllIllIIlllIIlIllI / 2.0f;
        final float llllllllllllllIllIllIIlllIllIIlI = 0.5f;
        final float llllllllllllllIllIllIIlllIllIIIl = 0.75f;
        final float llllllllllllllIllIllIIlllIllIIII = 0.8125f;
        final float llllllllllllllIllIllIIlllIlIllll = 0.0f;
        final float llllllllllllllIllIllIIlllIlIlllI = 0.0625f;
        final float llllllllllllllIllIllIIlllIlIllIl = 0.75f;
        final float llllllllllllllIllIllIIlllIlIllII = 0.8125f;
        final float llllllllllllllIllIllIIlllIlIlIll = 0.001953125f;
        final float llllllllllllllIllIllIIlllIlIlIlI = 0.001953125f;
        final float llllllllllllllIllIllIIlllIlIlIIl = 0.7519531f;
        final float llllllllllllllIllIllIIlllIlIlIII = 0.7519531f;
        final float llllllllllllllIllIllIIlllIlIIlll = 0.0f;
        final float llllllllllllllIllIllIIlllIlIIllI = 0.0625f;
        for (int llllllllllllllIllIllIIlllIlIIlIl = 0; llllllllllllllIllIllIIlllIlIIlIl < llllllllllllllIllIllIIlllIlllIII / 16; ++llllllllllllllIllIllIIlllIlIIlIl) {
            for (int llllllllllllllIllIllIIlllIlIIlII = 0; llllllllllllllIllIllIIlllIlIIlII < llllllllllllllIllIllIIlllIIlIllI / 16; ++llllllllllllllIllIllIIlllIlIIlII) {
                final float llllllllllllllIllIllIIlllIlIIIll = llllllllllllllIllIllIIlllIllIlII + (llllllllllllllIllIllIIlllIlIIlIl + 1) * 16;
                final float llllllllllllllIllIllIIlllIlIIIlI = llllllllllllllIllIllIIlllIllIlII + llllllllllllllIllIllIIlllIlIIlIl * 16;
                final float llllllllllllllIllIllIIlllIlIIIIl = llllllllllllllIllIllIIlllIllIIll + (llllllllllllllIllIllIIlllIlIIlII + 1) * 16;
                final float llllllllllllllIllIllIIlllIlIIIII = llllllllllllllIllIllIIlllIllIIll + llllllllllllllIllIllIIlllIlIIlII * 16;
                this.func_77008_a(llllllllllllllIllIllIIlllIIllIII, (llllllllllllllIllIllIIlllIlIIIll + llllllllllllllIllIllIIlllIlIIIlI) / 2.0f, (llllllllllllllIllIllIIlllIlIIIIl + llllllllllllllIllIllIIlllIlIIIII) / 2.0f);
                final float llllllllllllllIllIllIIlllIIlllll = (llllllllllllllIllIllIIlllIllIllI + llllllllllllllIllIllIIlllIlllIII - llllllllllllllIllIllIIlllIlIIlIl * 16) / 256.0f;
                final float llllllllllllllIllIllIIlllIIllllI = (llllllllllllllIllIllIIlllIllIllI + llllllllllllllIllIllIIlllIlllIII - (llllllllllllllIllIllIIlllIlIIlIl + 1) * 16) / 256.0f;
                final float llllllllllllllIllIllIIlllIIlllIl = (llllllllllllllIllIllIIlllIllIlIl + llllllllllllllIllIllIIlllIIlIllI - llllllllllllllIllIllIIlllIlIIlII * 16) / 256.0f;
                final float llllllllllllllIllIllIIlllIIlllII = (llllllllllllllIllIllIIlllIllIlIl + llllllllllllllIllIllIIlllIIlIllI - (llllllllllllllIllIllIIlllIlIIlII + 1) * 16) / 256.0f;
                final Tessellator llllllllllllllIllIllIIlllIIllIll = Tessellator.getInstance();
                final WorldRenderer llllllllllllllIllIllIIlllIIllIlI = llllllllllllllIllIllIIlllIIllIll.getWorldRenderer();
                llllllllllllllIllIllIIlllIIllIlI.startDrawingQuads();
                llllllllllllllIllIllIIlllIIllIlI.func_178980_d(0.0f, 0.0f, -1.0f);
                llllllllllllllIllIllIIlllIIllIlI.addVertexWithUV(llllllllllllllIllIllIIlllIlIIIll, llllllllllllllIllIllIIlllIlIIIII, -llllllllllllllIllIllIIlllIllIIlI, llllllllllllllIllIllIIlllIIllllI, llllllllllllllIllIllIIlllIIlllIl);
                llllllllllllllIllIllIIlllIIllIlI.addVertexWithUV(llllllllllllllIllIllIIlllIlIIIlI, llllllllllllllIllIllIIlllIlIIIII, -llllllllllllllIllIllIIlllIllIIlI, llllllllllllllIllIllIIlllIIlllll, llllllllllllllIllIllIIlllIIlllIl);
                llllllllllllllIllIllIIlllIIllIlI.addVertexWithUV(llllllllllllllIllIllIIlllIlIIIlI, llllllllllllllIllIllIIlllIlIIIIl, -llllllllllllllIllIllIIlllIllIIlI, llllllllllllllIllIllIIlllIIlllll, llllllllllllllIllIllIIlllIIlllII);
                llllllllllllllIllIllIIlllIIllIlI.addVertexWithUV(llllllllllllllIllIllIIlllIlIIIll, llllllllllllllIllIllIIlllIlIIIIl, -llllllllllllllIllIllIIlllIllIIlI, llllllllllllllIllIllIIlllIIllllI, llllllllllllllIllIllIIlllIIlllII);
                llllllllllllllIllIllIIlllIIllIlI.func_178980_d(0.0f, 0.0f, 1.0f);
                llllllllllllllIllIllIIlllIIllIlI.addVertexWithUV(llllllllllllllIllIllIIlllIlIIIll, llllllllllllllIllIllIIlllIlIIIIl, llllllllllllllIllIllIIlllIllIIlI, llllllllllllllIllIllIIlllIllIIIl, llllllllllllllIllIllIIlllIlIllll);
                llllllllllllllIllIllIIlllIIllIlI.addVertexWithUV(llllllllllllllIllIllIIlllIlIIIlI, llllllllllllllIllIllIIlllIlIIIIl, llllllllllllllIllIllIIlllIllIIlI, llllllllllllllIllIllIIlllIllIIII, llllllllllllllIllIllIIlllIlIllll);
                llllllllllllllIllIllIIlllIIllIlI.addVertexWithUV(llllllllllllllIllIllIIlllIlIIIlI, llllllllllllllIllIllIIlllIlIIIII, llllllllllllllIllIllIIlllIllIIlI, llllllllllllllIllIllIIlllIllIIII, llllllllllllllIllIllIIlllIlIlllI);
                llllllllllllllIllIllIIlllIIllIlI.addVertexWithUV(llllllllllllllIllIllIIlllIlIIIll, llllllllllllllIllIllIIlllIlIIIII, llllllllllllllIllIllIIlllIllIIlI, llllllllllllllIllIllIIlllIllIIIl, llllllllllllllIllIllIIlllIlIlllI);
                llllllllllllllIllIllIIlllIIllIlI.func_178980_d(0.0f, 1.0f, 0.0f);
                llllllllllllllIllIllIIlllIIllIlI.addVertexWithUV(llllllllllllllIllIllIIlllIlIIIll, llllllllllllllIllIllIIlllIlIIIIl, -llllllllllllllIllIllIIlllIllIIlI, llllllllllllllIllIllIIlllIlIllIl, llllllllllllllIllIllIIlllIlIlIll);
                llllllllllllllIllIllIIlllIIllIlI.addVertexWithUV(llllllllllllllIllIllIIlllIlIIIlI, llllllllllllllIllIllIIlllIlIIIIl, -llllllllllllllIllIllIIlllIllIIlI, llllllllllllllIllIllIIlllIlIllII, llllllllllllllIllIllIIlllIlIlIll);
                llllllllllllllIllIllIIlllIIllIlI.addVertexWithUV(llllllllllllllIllIllIIlllIlIIIlI, llllllllllllllIllIllIIlllIlIIIIl, llllllllllllllIllIllIIlllIllIIlI, llllllllllllllIllIllIIlllIlIllII, llllllllllllllIllIllIIlllIlIlIlI);
                llllllllllllllIllIllIIlllIIllIlI.addVertexWithUV(llllllllllllllIllIllIIlllIlIIIll, llllllllllllllIllIllIIlllIlIIIIl, llllllllllllllIllIllIIlllIllIIlI, llllllllllllllIllIllIIlllIlIllIl, llllllllllllllIllIllIIlllIlIlIlI);
                llllllllllllllIllIllIIlllIIllIlI.func_178980_d(0.0f, -1.0f, 0.0f);
                llllllllllllllIllIllIIlllIIllIlI.addVertexWithUV(llllllllllllllIllIllIIlllIlIIIll, llllllllllllllIllIllIIlllIlIIIII, llllllllllllllIllIllIIlllIllIIlI, llllllllllllllIllIllIIlllIlIllIl, llllllllllllllIllIllIIlllIlIlIll);
                llllllllllllllIllIllIIlllIIllIlI.addVertexWithUV(llllllllllllllIllIllIIlllIlIIIlI, llllllllllllllIllIllIIlllIlIIIII, llllllllllllllIllIllIIlllIllIIlI, llllllllllllllIllIllIIlllIlIllII, llllllllllllllIllIllIIlllIlIlIll);
                llllllllllllllIllIllIIlllIIllIlI.addVertexWithUV(llllllllllllllIllIllIIlllIlIIIlI, llllllllllllllIllIllIIlllIlIIIII, -llllllllllllllIllIllIIlllIllIIlI, llllllllllllllIllIllIIlllIlIllII, llllllllllllllIllIllIIlllIlIlIlI);
                llllllllllllllIllIllIIlllIIllIlI.addVertexWithUV(llllllllllllllIllIllIIlllIlIIIll, llllllllllllllIllIllIIlllIlIIIII, -llllllllllllllIllIllIIlllIllIIlI, llllllllllllllIllIllIIlllIlIllIl, llllllllllllllIllIllIIlllIlIlIlI);
                llllllllllllllIllIllIIlllIIllIlI.func_178980_d(-1.0f, 0.0f, 0.0f);
                llllllllllllllIllIllIIlllIIllIlI.addVertexWithUV(llllllllllllllIllIllIIlllIlIIIll, llllllllllllllIllIllIIlllIlIIIIl, llllllllllllllIllIllIIlllIllIIlI, llllllllllllllIllIllIIlllIlIlIII, llllllllllllllIllIllIIlllIlIIlll);
                llllllllllllllIllIllIIlllIIllIlI.addVertexWithUV(llllllllllllllIllIllIIlllIlIIIll, llllllllllllllIllIllIIlllIlIIIII, llllllllllllllIllIllIIlllIllIIlI, llllllllllllllIllIllIIlllIlIlIII, llllllllllllllIllIllIIlllIlIIllI);
                llllllllllllllIllIllIIlllIIllIlI.addVertexWithUV(llllllllllllllIllIllIIlllIlIIIll, llllllllllllllIllIllIIlllIlIIIII, -llllllllllllllIllIllIIlllIllIIlI, llllllllllllllIllIllIIlllIlIlIIl, llllllllllllllIllIllIIlllIlIIllI);
                llllllllllllllIllIllIIlllIIllIlI.addVertexWithUV(llllllllllllllIllIllIIlllIlIIIll, llllllllllllllIllIllIIlllIlIIIIl, -llllllllllllllIllIllIIlllIllIIlI, llllllllllllllIllIllIIlllIlIlIIl, llllllllllllllIllIllIIlllIlIIlll);
                llllllllllllllIllIllIIlllIIllIlI.func_178980_d(1.0f, 0.0f, 0.0f);
                llllllllllllllIllIllIIlllIIllIlI.addVertexWithUV(llllllllllllllIllIllIIlllIlIIIlI, llllllllllllllIllIllIIlllIlIIIIl, -llllllllllllllIllIllIIlllIllIIlI, llllllllllllllIllIllIIlllIlIlIII, llllllllllllllIllIllIIlllIlIIlll);
                llllllllllllllIllIllIIlllIIllIlI.addVertexWithUV(llllllllllllllIllIllIIlllIlIIIlI, llllllllllllllIllIllIIlllIlIIIII, -llllllllllllllIllIllIIlllIllIIlI, llllllllllllllIllIllIIlllIlIlIII, llllllllllllllIllIllIIlllIlIIllI);
                llllllllllllllIllIllIIlllIIllIlI.addVertexWithUV(llllllllllllllIllIllIIlllIlIIIlI, llllllllllllllIllIllIIlllIlIIIII, llllllllllllllIllIllIIlllIllIIlI, llllllllllllllIllIllIIlllIlIlIIl, llllllllllllllIllIllIIlllIlIIllI);
                llllllllllllllIllIllIIlllIIllIlI.addVertexWithUV(llllllllllllllIllIllIIlllIlIIIlI, llllllllllllllIllIllIIlllIlIIIIl, llllllllllllllIllIllIIlllIllIIlI, llllllllllllllIllIllIIlllIlIlIIl, llllllllllllllIllIllIIlllIlIIlll);
                llllllllllllllIllIllIIlllIIllIll.draw();
            }
        }
    }
}
