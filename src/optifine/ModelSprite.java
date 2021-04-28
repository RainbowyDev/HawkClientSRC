package optifine;

import net.minecraft.client.model.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;

public class ModelSprite
{
    private /* synthetic */ float posY;
    private /* synthetic */ int sizeX;
    private /* synthetic */ float maxU;
    private /* synthetic */ float sizeAdd;
    private /* synthetic */ int textureOffsetX;
    private /* synthetic */ int sizeZ;
    private /* synthetic */ ModelRenderer modelRenderer;
    private /* synthetic */ float posZ;
    private /* synthetic */ int sizeY;
    private /* synthetic */ float minV;
    private /* synthetic */ float posX;
    private /* synthetic */ float minU;
    private /* synthetic */ int textureOffsetY;
    private /* synthetic */ float maxV;
    
    public ModelSprite(final ModelRenderer lllllllllllllllllllIlIIIlIIIIlII, final int lllllllllllllllllllIlIIIlIIIlllI, final int lllllllllllllllllllIlIIIlIIIIIlI, final float lllllllllllllllllllIlIIIlIIIIIIl, final float lllllllllllllllllllIlIIIlIIIlIll, final float lllllllllllllllllllIlIIIlIIIlIlI, final int lllllllllllllllllllIlIIIIllllllI, final int lllllllllllllllllllIlIIIlIIIlIII, final int lllllllllllllllllllIlIIIlIIIIlll, final float lllllllllllllllllllIlIIIlIIIIllI) {
        this.modelRenderer = null;
        this.textureOffsetX = 0;
        this.textureOffsetY = 0;
        this.posX = 0.0f;
        this.posY = 0.0f;
        this.posZ = 0.0f;
        this.sizeX = 0;
        this.sizeY = 0;
        this.sizeZ = 0;
        this.sizeAdd = 0.0f;
        this.minU = 0.0f;
        this.minV = 0.0f;
        this.maxU = 0.0f;
        this.maxV = 0.0f;
        this.modelRenderer = lllllllllllllllllllIlIIIlIIIIlII;
        this.textureOffsetX = lllllllllllllllllllIlIIIlIIIlllI;
        this.textureOffsetY = lllllllllllllllllllIlIIIlIIIIIlI;
        this.posX = lllllllllllllllllllIlIIIlIIIIIIl;
        this.posY = lllllllllllllllllllIlIIIlIIIlIll;
        this.posZ = lllllllllllllllllllIlIIIlIIIlIlI;
        this.sizeX = lllllllllllllllllllIlIIIIllllllI;
        this.sizeY = lllllllllllllllllllIlIIIlIIIlIII;
        this.sizeZ = lllllllllllllllllllIlIIIlIIIIlll;
        this.sizeAdd = lllllllllllllllllllIlIIIlIIIIllI;
        this.minU = lllllllllllllllllllIlIIIlIIIlllI / lllllllllllllllllllIlIIIlIIIIlII.textureWidth;
        this.minV = lllllllllllllllllllIlIIIlIIIIIlI / lllllllllllllllllllIlIIIlIIIIlII.textureHeight;
        this.maxU = (lllllllllllllllllllIlIIIlIIIlllI + lllllllllllllllllllIlIIIIllllllI) / lllllllllllllllllllIlIIIlIIIIlII.textureWidth;
        this.maxV = (lllllllllllllllllllIlIIIlIIIIIlI + lllllllllllllllllllIlIIIlIIIlIII) / lllllllllllllllllllIlIIIlIIIIlII.textureHeight;
    }
    
    public static void renderItemIn2D(final Tessellator lllllllllllllllllllIlIIIIlIlIIII, final float lllllllllllllllllllIlIIIIIllIIll, final float lllllllllllllllllllIlIIIIlIIlllI, final float lllllllllllllllllllIlIIIIlIIllIl, final float lllllllllllllllllllIlIIIIlIIllII, final int lllllllllllllllllllIlIIIIIlIllll, final int lllllllllllllllllllIlIIIIIlIlllI, float lllllllllllllllllllIlIIIIIlIllIl, final float lllllllllllllllllllIlIIIIlIIlIII, final float lllllllllllllllllllIlIIIIlIIIlll) {
        if (lllllllllllllllllllIlIIIIIlIllIl < 6.25E-4f) {
            lllllllllllllllllllIlIIIIIlIllIl = 6.25E-4f;
        }
        final float lllllllllllllllllllIlIIIIlIIIllI = lllllllllllllllllllIlIIIIlIIllIl - lllllllllllllllllllIlIIIIIllIIll;
        final float lllllllllllllllllllIlIIIIlIIIlIl = lllllllllllllllllllIlIIIIlIIllII - lllllllllllllllllllIlIIIIlIIlllI;
        final double lllllllllllllllllllIlIIIIlIIIlII = MathHelper.abs(lllllllllllllllllllIlIIIIlIIIllI) * (lllllllllllllllllllIlIIIIlIIlIII / 16.0f);
        final double lllllllllllllllllllIlIIIIlIIIIll = MathHelper.abs(lllllllllllllllllllIlIIIIlIIIlIl) * (lllllllllllllllllllIlIIIIlIIIlll / 16.0f);
        final WorldRenderer lllllllllllllllllllIlIIIIlIIIIlI = lllllllllllllllllllIlIIIIlIlIIII.getWorldRenderer();
        lllllllllllllllllllIlIIIIlIIIIlI.startDrawingQuads();
        lllllllllllllllllllIlIIIIlIIIIlI.func_178980_d(0.0f, 0.0f, -1.0f);
        lllllllllllllllllllIlIIIIlIIIIlI.addVertexWithUV(0.0, 0.0, 0.0, lllllllllllllllllllIlIIIIIllIIll, lllllllllllllllllllIlIIIIlIIlllI);
        lllllllllllllllllllIlIIIIlIIIIlI.addVertexWithUV(lllllllllllllllllllIlIIIIlIIIlII, 0.0, 0.0, lllllllllllllllllllIlIIIIlIIllIl, lllllllllllllllllllIlIIIIlIIlllI);
        lllllllllllllllllllIlIIIIlIIIIlI.addVertexWithUV(lllllllllllllllllllIlIIIIlIIIlII, lllllllllllllllllllIlIIIIlIIIIll, 0.0, lllllllllllllllllllIlIIIIlIIllIl, lllllllllllllllllllIlIIIIlIIllII);
        lllllllllllllllllllIlIIIIlIIIIlI.addVertexWithUV(0.0, lllllllllllllllllllIlIIIIlIIIIll, 0.0, lllllllllllllllllllIlIIIIIllIIll, lllllllllllllllllllIlIIIIlIIllII);
        lllllllllllllllllllIlIIIIlIlIIII.draw();
        lllllllllllllllllllIlIIIIlIIIIlI.startDrawingQuads();
        lllllllllllllllllllIlIIIIlIIIIlI.func_178980_d(0.0f, 0.0f, 1.0f);
        lllllllllllllllllllIlIIIIlIIIIlI.addVertexWithUV(0.0, lllllllllllllllllllIlIIIIlIIIIll, lllllllllllllllllllIlIIIIIlIllIl, lllllllllllllllllllIlIIIIIllIIll, lllllllllllllllllllIlIIIIlIIllII);
        lllllllllllllllllllIlIIIIlIIIIlI.addVertexWithUV(lllllllllllllllllllIlIIIIlIIIlII, lllllllllllllllllllIlIIIIlIIIIll, lllllllllllllllllllIlIIIIIlIllIl, lllllllllllllllllllIlIIIIlIIllIl, lllllllllllllllllllIlIIIIlIIllII);
        lllllllllllllllllllIlIIIIlIIIIlI.addVertexWithUV(lllllllllllllllllllIlIIIIlIIIlII, 0.0, lllllllllllllllllllIlIIIIIlIllIl, lllllllllllllllllllIlIIIIlIIllIl, lllllllllllllllllllIlIIIIlIIlllI);
        lllllllllllllllllllIlIIIIlIIIIlI.addVertexWithUV(0.0, 0.0, lllllllllllllllllllIlIIIIIlIllIl, lllllllllllllllllllIlIIIIIllIIll, lllllllllllllllllllIlIIIIlIIlllI);
        lllllllllllllllllllIlIIIIlIlIIII.draw();
        final float lllllllllllllllllllIlIIIIlIIIIIl = 0.5f * lllllllllllllllllllIlIIIIlIIIllI / lllllllllllllllllllIlIIIIIlIllll;
        final float lllllllllllllllllllIlIIIIlIIIIII = 0.5f * lllllllllllllllllllIlIIIIlIIIlIl / lllllllllllllllllllIlIIIIIlIlllI;
        lllllllllllllllllllIlIIIIlIIIIlI.startDrawingQuads();
        lllllllllllllllllllIlIIIIlIIIIlI.func_178980_d(-1.0f, 0.0f, 0.0f);
        for (int lllllllllllllllllllIlIIIIIllllll = 0; lllllllllllllllllllIlIIIIIllllll < lllllllllllllllllllIlIIIIIlIllll; ++lllllllllllllllllllIlIIIIIllllll) {
            final float lllllllllllllllllllIlIIIIIlllllI = lllllllllllllllllllIlIIIIIllllll / (float)lllllllllllllllllllIlIIIIIlIllll;
            final float lllllllllllllllllllIlIIIIIlllIlI = lllllllllllllllllllIlIIIIIllIIll + lllllllllllllllllllIlIIIIlIIIllI * lllllllllllllllllllIlIIIIIlllllI + lllllllllllllllllllIlIIIIlIIIIIl;
            lllllllllllllllllllIlIIIIlIIIIlI.addVertexWithUV(lllllllllllllllllllIlIIIIIlllllI * lllllllllllllllllllIlIIIIlIIIlII, 0.0, lllllllllllllllllllIlIIIIIlIllIl, lllllllllllllllllllIlIIIIIlllIlI, lllllllllllllllllllIlIIIIlIIlllI);
            lllllllllllllllllllIlIIIIlIIIIlI.addVertexWithUV(lllllllllllllllllllIlIIIIIlllllI * lllllllllllllllllllIlIIIIlIIIlII, 0.0, 0.0, lllllllllllllllllllIlIIIIIlllIlI, lllllllllllllllllllIlIIIIlIIlllI);
            lllllllllllllllllllIlIIIIlIIIIlI.addVertexWithUV(lllllllllllllllllllIlIIIIIlllllI * lllllllllllllllllllIlIIIIlIIIlII, lllllllllllllllllllIlIIIIlIIIIll, 0.0, lllllllllllllllllllIlIIIIIlllIlI, lllllllllllllllllllIlIIIIlIIllII);
            lllllllllllllllllllIlIIIIlIIIIlI.addVertexWithUV(lllllllllllllllllllIlIIIIIlllllI * lllllllllllllllllllIlIIIIlIIIlII, lllllllllllllllllllIlIIIIlIIIIll, lllllllllllllllllllIlIIIIIlIllIl, lllllllllllllllllllIlIIIIIlllIlI, lllllllllllllllllllIlIIIIlIIllII);
        }
        lllllllllllllllllllIlIIIIlIlIIII.draw();
        lllllllllllllllllllIlIIIIlIIIIlI.startDrawingQuads();
        lllllllllllllllllllIlIIIIlIIIIlI.func_178980_d(1.0f, 0.0f, 0.0f);
        for (int lllllllllllllllllllIlIIIIIllllll = 0; lllllllllllllllllllIlIIIIIllllll < lllllllllllllllllllIlIIIIIlIllll; ++lllllllllllllllllllIlIIIIIllllll) {
            final float lllllllllllllllllllIlIIIIIllllIl = lllllllllllllllllllIlIIIIIllllll / (float)lllllllllllllllllllIlIIIIIlIllll;
            final float lllllllllllllllllllIlIIIIIlllIIl = lllllllllllllllllllIlIIIIIllIIll + lllllllllllllllllllIlIIIIlIIIllI * lllllllllllllllllllIlIIIIIllllIl + lllllllllllllllllllIlIIIIlIIIIIl;
            final float lllllllllllllllllllIlIIIIIllIllI = lllllllllllllllllllIlIIIIIllllIl + 1.0f / lllllllllllllllllllIlIIIIIlIllll;
            lllllllllllllllllllIlIIIIlIIIIlI.addVertexWithUV(lllllllllllllllllllIlIIIIIllIllI * lllllllllllllllllllIlIIIIlIIIlII, lllllllllllllllllllIlIIIIlIIIIll, lllllllllllllllllllIlIIIIIlIllIl, lllllllllllllllllllIlIIIIIlllIIl, lllllllllllllllllllIlIIIIlIIllII);
            lllllllllllllllllllIlIIIIlIIIIlI.addVertexWithUV(lllllllllllllllllllIlIIIIIllIllI * lllllllllllllllllllIlIIIIlIIIlII, lllllllllllllllllllIlIIIIlIIIIll, 0.0, lllllllllllllllllllIlIIIIIlllIIl, lllllllllllllllllllIlIIIIlIIllII);
            lllllllllllllllllllIlIIIIlIIIIlI.addVertexWithUV(lllllllllllllllllllIlIIIIIllIllI * lllllllllllllllllllIlIIIIlIIIlII, 0.0, 0.0, lllllllllllllllllllIlIIIIIlllIIl, lllllllllllllllllllIlIIIIlIIlllI);
            lllllllllllllllllllIlIIIIlIIIIlI.addVertexWithUV(lllllllllllllllllllIlIIIIIllIllI * lllllllllllllllllllIlIIIIlIIIlII, 0.0, lllllllllllllllllllIlIIIIIlIllIl, lllllllllllllllllllIlIIIIIlllIIl, lllllllllllllllllllIlIIIIlIIlllI);
        }
        lllllllllllllllllllIlIIIIlIlIIII.draw();
        lllllllllllllllllllIlIIIIlIIIIlI.startDrawingQuads();
        lllllllllllllllllllIlIIIIlIIIIlI.func_178980_d(0.0f, 1.0f, 0.0f);
        for (int lllllllllllllllllllIlIIIIIllllll = 0; lllllllllllllllllllIlIIIIIllllll < lllllllllllllllllllIlIIIIIlIlllI; ++lllllllllllllllllllIlIIIIIllllll) {
            final float lllllllllllllllllllIlIIIIIllllII = lllllllllllllllllllIlIIIIIllllll / (float)lllllllllllllllllllIlIIIIIlIlllI;
            final float lllllllllllllllllllIlIIIIIlllIII = lllllllllllllllllllIlIIIIlIIlllI + lllllllllllllllllllIlIIIIlIIIlIl * lllllllllllllllllllIlIIIIIllllII + lllllllllllllllllllIlIIIIlIIIIII;
            final float lllllllllllllllllllIlIIIIIllIlIl = lllllllllllllllllllIlIIIIIllllII + 1.0f / lllllllllllllllllllIlIIIIIlIlllI;
            lllllllllllllllllllIlIIIIlIIIIlI.addVertexWithUV(0.0, lllllllllllllllllllIlIIIIIllIlIl * lllllllllllllllllllIlIIIIlIIIIll, 0.0, lllllllllllllllllllIlIIIIIllIIll, lllllllllllllllllllIlIIIIIlllIII);
            lllllllllllllllllllIlIIIIlIIIIlI.addVertexWithUV(lllllllllllllllllllIlIIIIlIIIlII, lllllllllllllllllllIlIIIIIllIlIl * lllllllllllllllllllIlIIIIlIIIIll, 0.0, lllllllllllllllllllIlIIIIlIIllIl, lllllllllllllllllllIlIIIIIlllIII);
            lllllllllllllllllllIlIIIIlIIIIlI.addVertexWithUV(lllllllllllllllllllIlIIIIlIIIlII, lllllllllllllllllllIlIIIIIllIlIl * lllllllllllllllllllIlIIIIlIIIIll, lllllllllllllllllllIlIIIIIlIllIl, lllllllllllllllllllIlIIIIlIIllIl, lllllllllllllllllllIlIIIIIlllIII);
            lllllllllllllllllllIlIIIIlIIIIlI.addVertexWithUV(0.0, lllllllllllllllllllIlIIIIIllIlIl * lllllllllllllllllllIlIIIIlIIIIll, lllllllllllllllllllIlIIIIIlIllIl, lllllllllllllllllllIlIIIIIllIIll, lllllllllllllllllllIlIIIIIlllIII);
        }
        lllllllllllllllllllIlIIIIlIlIIII.draw();
        lllllllllllllllllllIlIIIIlIIIIlI.startDrawingQuads();
        lllllllllllllllllllIlIIIIlIIIIlI.func_178980_d(0.0f, -1.0f, 0.0f);
        for (int lllllllllllllllllllIlIIIIIllllll = 0; lllllllllllllllllllIlIIIIIllllll < lllllllllllllllllllIlIIIIIlIlllI; ++lllllllllllllllllllIlIIIIIllllll) {
            final float lllllllllllllllllllIlIIIIIlllIll = lllllllllllllllllllIlIIIIIllllll / (float)lllllllllllllllllllIlIIIIIlIlllI;
            final float lllllllllllllllllllIlIIIIIllIlll = lllllllllllllllllllIlIIIIlIIlllI + lllllllllllllllllllIlIIIIlIIIlIl * lllllllllllllllllllIlIIIIIlllIll + lllllllllllllllllllIlIIIIlIIIIII;
            lllllllllllllllllllIlIIIIlIIIIlI.addVertexWithUV(lllllllllllllllllllIlIIIIlIIIlII, lllllllllllllllllllIlIIIIIlllIll * lllllllllllllllllllIlIIIIlIIIIll, 0.0, lllllllllllllllllllIlIIIIlIIllIl, lllllllllllllllllllIlIIIIIllIlll);
            lllllllllllllllllllIlIIIIlIIIIlI.addVertexWithUV(0.0, lllllllllllllllllllIlIIIIIlllIll * lllllllllllllllllllIlIIIIlIIIIll, 0.0, lllllllllllllllllllIlIIIIIllIIll, lllllllllllllllllllIlIIIIIllIlll);
            lllllllllllllllllllIlIIIIlIIIIlI.addVertexWithUV(0.0, lllllllllllllllllllIlIIIIIlllIll * lllllllllllllllllllIlIIIIlIIIIll, lllllllllllllllllllIlIIIIIlIllIl, lllllllllllllllllllIlIIIIIllIIll, lllllllllllllllllllIlIIIIIllIlll);
            lllllllllllllllllllIlIIIIlIIIIlI.addVertexWithUV(lllllllllllllllllllIlIIIIlIIIlII, lllllllllllllllllllIlIIIIIlllIll * lllllllllllllllllllIlIIIIlIIIIll, lllllllllllllllllllIlIIIIIlIllIl, lllllllllllllllllllIlIIIIlIIllIl, lllllllllllllllllllIlIIIIIllIlll);
        }
        lllllllllllllllllllIlIIIIlIlIIII.draw();
    }
    
    public void render(final Tessellator lllllllllllllllllllIlIIIIllIlIll, final float lllllllllllllllllllIlIIIIlllIIIl) {
        GlStateManager.translate(this.posX * lllllllllllllllllllIlIIIIlllIIIl, this.posY * lllllllllllllllllllIlIIIIlllIIIl, this.posZ * lllllllllllllllllllIlIIIIlllIIIl);
        float lllllllllllllllllllIlIIIIlllIIII = this.minU;
        float lllllllllllllllllllIlIIIIllIllll = this.maxU;
        float lllllllllllllllllllIlIIIIllIlllI = this.minV;
        float lllllllllllllllllllIlIIIIllIllIl = this.maxV;
        if (this.modelRenderer.mirror) {
            lllllllllllllllllllIlIIIIlllIIII = this.maxU;
            lllllllllllllllllllIlIIIIllIllll = this.minU;
        }
        if (this.modelRenderer.mirrorV) {
            lllllllllllllllllllIlIIIIllIlllI = this.maxV;
            lllllllllllllllllllIlIIIIllIllIl = this.minV;
        }
        renderItemIn2D(lllllllllllllllllllIlIIIIllIlIll, lllllllllllllllllllIlIIIIlllIIII, lllllllllllllllllllIlIIIIllIlllI, lllllllllllllllllllIlIIIIllIllll, lllllllllllllllllllIlIIIIllIllIl, this.sizeX, this.sizeY, lllllllllllllllllllIlIIIIlllIIIl * this.sizeZ, this.modelRenderer.textureWidth, this.modelRenderer.textureHeight);
        GlStateManager.translate(-this.posX * lllllllllllllllllllIlIIIIlllIIIl, -this.posY * lllllllllllllllllllIlIIIIlllIIIl, -this.posZ * lllllllllllllllllllIlIIIIlllIIIl);
    }
}
