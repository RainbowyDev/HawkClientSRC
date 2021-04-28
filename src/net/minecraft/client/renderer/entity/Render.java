package net.minecraft.client.renderer.entity;

import net.minecraft.block.*;
import net.minecraft.client.gui.*;
import net.minecraft.world.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.texture.*;
import optifine.*;
import shadersmod.client.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.client.renderer.culling.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;
import net.minecraft.entity.player.*;

public abstract class Render
{
    protected /* synthetic */ float shadowSize;
    protected final /* synthetic */ RenderManager renderManager;
    protected /* synthetic */ float shadowOpaque;
    private static final /* synthetic */ ResourceLocation shadowTextures;
    
    protected boolean func_177070_b(final Entity lllllllllllllllIlIlllIIllllIllll) {
        return lllllllllllllllIlIlllIIllllIllll.getAlwaysRenderNameTagForRender() && lllllllllllllllIlIlllIIllllIllll.hasCustomName();
    }
    
    private void func_180549_a(final Block lllllllllllllllIlIlllIIlIIIllIlI, final double lllllllllllllllIlIlllIIlIIIllIIl, final double lllllllllllllllIlIlllIIIlllllllI, final double lllllllllllllllIlIlllIIIllllllIl, final BlockPos lllllllllllllllIlIlllIIlIIIlIllI, final float lllllllllllllllIlIlllIIIlllllIll, final float lllllllllllllllIlIlllIIlIIIlIlII, final double lllllllllllllllIlIlllIIIlllllIIl, final double lllllllllllllllIlIlllIIlIIIlIIlI, final double lllllllllllllllIlIlllIIlIIIlIIIl) {
        if (lllllllllllllllIlIlllIIlIIIllIlI.isFullCube()) {
            final Tessellator lllllllllllllllIlIlllIIlIIIlIIII = Tessellator.getInstance();
            final WorldRenderer lllllllllllllllIlIlllIIlIIIIllll = lllllllllllllllIlIlllIIlIIIlIIII.getWorldRenderer();
            double lllllllllllllllIlIlllIIlIIIIlllI = (lllllllllllllllIlIlllIIIlllllIll - (lllllllllllllllIlIlllIIIlllllllI - (lllllllllllllllIlIlllIIlIIIlIllI.getY() + lllllllllllllllIlIlllIIlIIIlIIlI)) / 2.0) * 0.5 * this.getWorldFromRenderManager().getLightBrightness(lllllllllllllllIlIlllIIlIIIlIllI);
            if (lllllllllllllllIlIlllIIlIIIIlllI >= 0.0) {
                if (lllllllllllllllIlIlllIIlIIIIlllI > 1.0) {
                    lllllllllllllllIlIlllIIlIIIIlllI = 1.0;
                }
                lllllllllllllllIlIlllIIlIIIIllll.func_178960_a(1.0f, 1.0f, 1.0f, (float)lllllllllllllllIlIlllIIlIIIIlllI);
                final double lllllllllllllllIlIlllIIlIIIIllIl = lllllllllllllllIlIlllIIlIIIlIllI.getX() + lllllllllllllllIlIlllIIlIIIllIlI.getBlockBoundsMinX() + lllllllllllllllIlIlllIIIlllllIIl;
                final double lllllllllllllllIlIlllIIlIIIIllII = lllllllllllllllIlIlllIIlIIIlIllI.getX() + lllllllllllllllIlIlllIIlIIIllIlI.getBlockBoundsMaxX() + lllllllllllllllIlIlllIIIlllllIIl;
                final double lllllllllllllllIlIlllIIlIIIIlIll = lllllllllllllllIlIlllIIlIIIlIllI.getY() + lllllllllllllllIlIlllIIlIIIllIlI.getBlockBoundsMinY() + lllllllllllllllIlIlllIIlIIIlIIlI + 0.015625;
                final double lllllllllllllllIlIlllIIlIIIIlIlI = lllllllllllllllIlIlllIIlIIIlIllI.getZ() + lllllllllllllllIlIlllIIlIIIllIlI.getBlockBoundsMinZ() + lllllllllllllllIlIlllIIlIIIlIIIl;
                final double lllllllllllllllIlIlllIIlIIIIlIIl = lllllllllllllllIlIlllIIlIIIlIllI.getZ() + lllllllllllllllIlIlllIIlIIIllIlI.getBlockBoundsMaxZ() + lllllllllllllllIlIlllIIlIIIlIIIl;
                final float lllllllllllllllIlIlllIIlIIIIlIII = (float)((lllllllllllllllIlIlllIIlIIIllIIl - lllllllllllllllIlIlllIIlIIIIllIl) / 2.0 / lllllllllllllllIlIlllIIlIIIlIlII + 0.5);
                final float lllllllllllllllIlIlllIIlIIIIIlll = (float)((lllllllllllllllIlIlllIIlIIIllIIl - lllllllllllllllIlIlllIIlIIIIllII) / 2.0 / lllllllllllllllIlIlllIIlIIIlIlII + 0.5);
                final float lllllllllllllllIlIlllIIlIIIIIllI = (float)((lllllllllllllllIlIlllIIIllllllIl - lllllllllllllllIlIlllIIlIIIIlIlI) / 2.0 / lllllllllllllllIlIlllIIlIIIlIlII + 0.5);
                final float lllllllllllllllIlIlllIIlIIIIIlIl = (float)((lllllllllllllllIlIlllIIIllllllIl - lllllllllllllllIlIlllIIlIIIIlIIl) / 2.0 / lllllllllllllllIlIlllIIlIIIlIlII + 0.5);
                lllllllllllllllIlIlllIIlIIIIllll.addVertexWithUV(lllllllllllllllIlIlllIIlIIIIllIl, lllllllllllllllIlIlllIIlIIIIlIll, lllllllllllllllIlIlllIIlIIIIlIlI, lllllllllllllllIlIlllIIlIIIIlIII, lllllllllllllllIlIlllIIlIIIIIllI);
                lllllllllllllllIlIlllIIlIIIIllll.addVertexWithUV(lllllllllllllllIlIlllIIlIIIIllIl, lllllllllllllllIlIlllIIlIIIIlIll, lllllllllllllllIlIlllIIlIIIIlIIl, lllllllllllllllIlIlllIIlIIIIlIII, lllllllllllllllIlIlllIIlIIIIIlIl);
                lllllllllllllllIlIlllIIlIIIIllll.addVertexWithUV(lllllllllllllllIlIlllIIlIIIIllII, lllllllllllllllIlIlllIIlIIIIlIll, lllllllllllllllIlIlllIIlIIIIlIIl, lllllllllllllllIlIlllIIlIIIIIlll, lllllllllllllllIlIlllIIlIIIIIlIl);
                lllllllllllllllIlIlllIIlIIIIllll.addVertexWithUV(lllllllllllllllIlIlllIIlIIIIllII, lllllllllllllllIlIlllIIlIIIIlIll, lllllllllllllllIlIlllIIlIIIIlIlI, lllllllllllllllIlIlllIIlIIIIIlll, lllllllllllllllIlIlllIIlIIIIIllI);
            }
        }
    }
    
    public FontRenderer getFontRendererFromRenderManager() {
        return this.renderManager.getFontRenderer();
    }
    
    private World getWorldFromRenderManager() {
        return this.renderManager.worldObj;
    }
    
    private void renderEntityOnFire(final Entity lllllllllllllllIlIlllIIllIllIIlI, final double lllllllllllllllIlIlllIIllIllIIIl, final double lllllllllllllllIlIlllIIllIIllIII, final double lllllllllllllllIlIlllIIllIIlIlll, final float lllllllllllllllIlIlllIIllIlIlllI) {
        GlStateManager.disableLighting();
        final TextureMap lllllllllllllllIlIlllIIllIlIllIl = Minecraft.getMinecraft().getTextureMapBlocks();
        final TextureAtlasSprite lllllllllllllllIlIlllIIllIlIllII = lllllllllllllllIlIlllIIllIlIllIl.getAtlasSprite("minecraft:blocks/fire_layer_0");
        final TextureAtlasSprite lllllllllllllllIlIlllIIllIlIlIll = lllllllllllllllIlIlllIIllIlIllIl.getAtlasSprite("minecraft:blocks/fire_layer_1");
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)lllllllllllllllIlIlllIIllIllIIIl, (float)lllllllllllllllIlIlllIIllIIllIII, (float)lllllllllllllllIlIlllIIllIIlIlll);
        final float lllllllllllllllIlIlllIIllIlIlIlI = lllllllllllllllIlIlllIIllIllIIlI.width * 1.4f;
        GlStateManager.scale(lllllllllllllllIlIlllIIllIlIlIlI, lllllllllllllllIlIlllIIllIlIlIlI, lllllllllllllllIlIlllIIllIlIlIlI);
        final Tessellator lllllllllllllllIlIlllIIllIlIlIIl = Tessellator.getInstance();
        final WorldRenderer lllllllllllllllIlIlllIIllIlIlIII = lllllllllllllllIlIlllIIllIlIlIIl.getWorldRenderer();
        float lllllllllllllllIlIlllIIllIlIIlll = 0.5f;
        final float lllllllllllllllIlIlllIIllIlIIllI = 0.0f;
        float lllllllllllllllIlIlllIIllIlIIlIl = lllllllllllllllIlIlllIIllIllIIlI.height / lllllllllllllllIlIlllIIllIlIlIlI;
        float lllllllllllllllIlIlllIIllIlIIlII = (float)(lllllllllllllllIlIlllIIllIllIIlI.posY - lllllllllllllllIlIlllIIllIllIIlI.getEntityBoundingBox().minY);
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
        GlStateManager.translate(0.0f, 0.0f, -0.3f + (int)lllllllllllllllIlIlllIIllIlIIlIl * 0.02f);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        float lllllllllllllllIlIlllIIllIlIIIll = 0.0f;
        int lllllllllllllllIlIlllIIllIlIIIlI = 0;
        lllllllllllllllIlIlllIIllIlIlIII.startDrawingQuads();
        while (lllllllllllllllIlIlllIIllIlIIlIl > 0.0f) {
            final TextureAtlasSprite lllllllllllllllIlIlllIIllIlIIIIl = (lllllllllllllllIlIlllIIllIlIIIlI % 2 == 0) ? lllllllllllllllIlIlllIIllIlIllII : lllllllllllllllIlIlllIIllIlIlIll;
            this.bindTexture(TextureMap.locationBlocksTexture);
            float lllllllllllllllIlIlllIIllIlIIIII = lllllllllllllllIlIlllIIllIlIIIIl.getMinU();
            final float lllllllllllllllIlIlllIIllIIlllll = lllllllllllllllIlIlllIIllIlIIIIl.getMinV();
            float lllllllllllllllIlIlllIIllIIllllI = lllllllllllllllIlIlllIIllIlIIIIl.getMaxU();
            final float lllllllllllllllIlIlllIIllIIlllIl = lllllllllllllllIlIlllIIllIlIIIIl.getMaxV();
            if (lllllllllllllllIlIlllIIllIlIIIlI / 2 % 2 == 0) {
                final float lllllllllllllllIlIlllIIllIIlllII = lllllllllllllllIlIlllIIllIIllllI;
                lllllllllllllllIlIlllIIllIIllllI = lllllllllllllllIlIlllIIllIlIIIII;
                lllllllllllllllIlIlllIIllIlIIIII = lllllllllllllllIlIlllIIllIIlllII;
            }
            lllllllllllllllIlIlllIIllIlIlIII.addVertexWithUV(lllllllllllllllIlIlllIIllIlIIlll - lllllllllllllllIlIlllIIllIlIIllI, 0.0f - lllllllllllllllIlIlllIIllIlIIlII, lllllllllllllllIlIlllIIllIlIIIll, lllllllllllllllIlIlllIIllIIllllI, lllllllllllllllIlIlllIIllIIlllIl);
            lllllllllllllllIlIlllIIllIlIlIII.addVertexWithUV(-lllllllllllllllIlIlllIIllIlIIlll - lllllllllllllllIlIlllIIllIlIIllI, 0.0f - lllllllllllllllIlIlllIIllIlIIlII, lllllllllllllllIlIlllIIllIlIIIll, lllllllllllllllIlIlllIIllIlIIIII, lllllllllllllllIlIlllIIllIIlllIl);
            lllllllllllllllIlIlllIIllIlIlIII.addVertexWithUV(-lllllllllllllllIlIlllIIllIlIIlll - lllllllllllllllIlIlllIIllIlIIllI, 1.4f - lllllllllllllllIlIlllIIllIlIIlII, lllllllllllllllIlIlllIIllIlIIIll, lllllllllllllllIlIlllIIllIlIIIII, lllllllllllllllIlIlllIIllIIlllll);
            lllllllllllllllIlIlllIIllIlIlIII.addVertexWithUV(lllllllllllllllIlIlllIIllIlIIlll - lllllllllllllllIlIlllIIllIlIIllI, 1.4f - lllllllllllllllIlIlllIIllIlIIlII, lllllllllllllllIlIlllIIllIlIIIll, lllllllllllllllIlIlllIIllIIllllI, lllllllllllllllIlIlllIIllIIlllll);
            lllllllllllllllIlIlllIIllIlIIlIl -= 0.45f;
            lllllllllllllllIlIlllIIllIlIIlII -= 0.45f;
            lllllllllllllllIlIlllIIllIlIIlll *= 0.9f;
            lllllllllllllllIlIlllIIllIlIIIll += 0.03f;
            ++lllllllllllllllIlIlllIIllIlIIIlI;
        }
        lllllllllllllllIlIlllIIllIlIlIIl.draw();
        GlStateManager.popMatrix();
        GlStateManager.enableLighting();
    }
    
    public void doRender(final Entity lllllllllllllllIlIlllIlIIIIIIlII, final double lllllllllllllllIlIlllIlIIIIIlIlI, final double lllllllllllllllIlIlllIlIIIIIlIIl, final double lllllllllllllllIlIlllIlIIIIIIIIl, final float lllllllllllllllIlIlllIlIIIIIIlll, final float lllllllllllllllIlIlllIlIIIIIIllI) {
        this.func_177067_a(lllllllllllllllIlIlllIlIIIIIIlII, lllllllllllllllIlIlllIlIIIIIlIlI, lllllllllllllllIlIlllIlIIIIIlIIl, lllllllllllllllIlIlllIlIIIIIIIIl);
    }
    
    protected void func_177069_a(final Entity lllllllllllllllIlIlllIIlllIllllI, final double lllllllllllllllIlIlllIIllllIIlIl, final double lllllllllllllllIlIlllIIllllIIlII, final double lllllllllllllllIlIlllIIlllIllIll, final String lllllllllllllllIlIlllIIllllIIIlI, final float lllllllllllllllIlIlllIIllllIIIIl, final double lllllllllllllllIlIlllIIllllIIIII) {
        this.renderLivingLabel(lllllllllllllllIlIlllIIlllIllllI, lllllllllllllllIlIlllIIllllIIIlI, lllllllllllllllIlIlllIIllllIIlIl, lllllllllllllllIlIlllIIllllIIlII, lllllllllllllllIlIlllIIlllIllIll, 64);
    }
    
    public void bindTexture(final ResourceLocation lllllllllllllllIlIlllIIlllIIllIl) {
        this.renderManager.renderEngine.bindTexture(lllllllllllllllIlIlllIIlllIIllIl);
    }
    
    protected abstract ResourceLocation getEntityTexture(final Entity p0);
    
    private void renderShadow(final Entity lllllllllllllllIlIlllIIlIlIIlllI, final double lllllllllllllllIlIlllIIlIllIlIII, final double lllllllllllllllIlIlllIIlIllIIlll, final double lllllllllllllllIlIlllIIlIlIIlIll, final float lllllllllllllllIlIlllIIlIllIIlIl, final float lllllllllllllllIlIlllIIlIllIIlII) {
        if (!Config.isShaders() || !Shaders.shouldSkipDefaultShadow) {
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 771);
            this.renderManager.renderEngine.bindTexture(Render.shadowTextures);
            final World lllllllllllllllIlIlllIIlIllIIIll = this.getWorldFromRenderManager();
            GlStateManager.depthMask(false);
            float lllllllllllllllIlIlllIIlIllIIIlI = this.shadowSize;
            if (lllllllllllllllIlIlllIIlIlIIlllI instanceof EntityLiving) {
                final EntityLiving lllllllllllllllIlIlllIIlIllIIIIl = (EntityLiving)lllllllllllllllIlIlllIIlIlIIlllI;
                lllllllllllllllIlIlllIIlIllIIIlI *= lllllllllllllllIlIlllIIlIllIIIIl.getRenderSizeModifier();
                if (lllllllllllllllIlIlllIIlIllIIIIl.isChild()) {
                    lllllllllllllllIlIlllIIlIllIIIlI *= 0.5f;
                }
            }
            final double lllllllllllllllIlIlllIIlIllIIIII = lllllllllllllllIlIlllIIlIlIIlllI.lastTickPosX + (lllllllllllllllIlIlllIIlIlIIlllI.posX - lllllllllllllllIlIlllIIlIlIIlllI.lastTickPosX) * lllllllllllllllIlIlllIIlIllIIlII;
            final double lllllllllllllllIlIlllIIlIlIlllll = lllllllllllllllIlIlllIIlIlIIlllI.lastTickPosY + (lllllllllllllllIlIlllIIlIlIIlllI.posY - lllllllllllllllIlIlllIIlIlIIlllI.lastTickPosY) * lllllllllllllllIlIlllIIlIllIIlII;
            final double lllllllllllllllIlIlllIIlIlIllllI = lllllllllllllllIlIlllIIlIlIIlllI.lastTickPosZ + (lllllllllllllllIlIlllIIlIlIIlllI.posZ - lllllllllllllllIlIlllIIlIlIIlllI.lastTickPosZ) * lllllllllllllllIlIlllIIlIllIIlII;
            final int lllllllllllllllIlIlllIIlIlIlllIl = MathHelper.floor_double(lllllllllllllllIlIlllIIlIllIIIII - lllllllllllllllIlIlllIIlIllIIIlI);
            final int lllllllllllllllIlIlllIIlIlIlllII = MathHelper.floor_double(lllllllllllllllIlIlllIIlIllIIIII + lllllllllllllllIlIlllIIlIllIIIlI);
            final int lllllllllllllllIlIlllIIlIlIllIll = MathHelper.floor_double(lllllllllllllllIlIlllIIlIlIlllll - lllllllllllllllIlIlllIIlIllIIIlI);
            final int lllllllllllllllIlIlllIIlIlIllIlI = MathHelper.floor_double(lllllllllllllllIlIlllIIlIlIlllll);
            final int lllllllllllllllIlIlllIIlIlIllIIl = MathHelper.floor_double(lllllllllllllllIlIlllIIlIlIllllI - lllllllllllllllIlIlllIIlIllIIIlI);
            final int lllllllllllllllIlIlllIIlIlIllIII = MathHelper.floor_double(lllllllllllllllIlIlllIIlIlIllllI + lllllllllllllllIlIlllIIlIllIIIlI);
            final double lllllllllllllllIlIlllIIlIlIlIlll = lllllllllllllllIlIlllIIlIllIlIII - lllllllllllllllIlIlllIIlIllIIIII;
            final double lllllllllllllllIlIlllIIlIlIlIllI = lllllllllllllllIlIlllIIlIllIIlll - lllllllllllllllIlIlllIIlIlIlllll;
            final double lllllllllllllllIlIlllIIlIlIlIlIl = lllllllllllllllIlIlllIIlIlIIlIll - lllllllllllllllIlIlllIIlIlIllllI;
            final Tessellator lllllllllllllllIlIlllIIlIlIlIlII = Tessellator.getInstance();
            final WorldRenderer lllllllllllllllIlIlllIIlIlIlIIll = lllllllllllllllIlIlllIIlIlIlIlII.getWorldRenderer();
            lllllllllllllllIlIlllIIlIlIlIIll.startDrawingQuads();
            for (final BlockPos lllllllllllllllIlIlllIIlIlIlIIIl : BlockPos.getAllInBox(new BlockPos(lllllllllllllllIlIlllIIlIlIlllIl, lllllllllllllllIlIlllIIlIlIllIll, lllllllllllllllIlIlllIIlIlIllIIl), new BlockPos(lllllllllllllllIlIlllIIlIlIlllII, lllllllllllllllIlIlllIIlIlIllIlI, lllllllllllllllIlIlllIIlIlIllIII))) {
                final Block lllllllllllllllIlIlllIIlIlIlIIII = lllllllllllllllIlIlllIIlIllIIIll.getBlockState(lllllllllllllllIlIlllIIlIlIlIIIl.offsetDown()).getBlock();
                if (lllllllllllllllIlIlllIIlIlIlIIII.getRenderType() != -1 && lllllllllllllllIlIlllIIlIllIIIll.getLightFromNeighbors(lllllllllllllllIlIlllIIlIlIlIIIl) > 3) {
                    this.func_180549_a(lllllllllllllllIlIlllIIlIlIlIIII, lllllllllllllllIlIlllIIlIllIlIII, lllllllllllllllIlIlllIIlIllIIlll, lllllllllllllllIlIlllIIlIlIIlIll, lllllllllllllllIlIlllIIlIlIlIIIl, lllllllllllllllIlIlllIIlIllIIlIl, lllllllllllllllIlIlllIIlIllIIIlI, lllllllllllllllIlIlllIIlIlIlIlll, lllllllllllllllIlIlllIIlIlIlIllI, lllllllllllllllIlIlllIIlIlIlIlIl);
                }
            }
            lllllllllllllllIlIlllIIlIlIlIlII.draw();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.disableBlend();
            GlStateManager.depthMask(true);
        }
    }
    
    public boolean func_177071_a(final Entity lllllllllllllllIlIlllIlIIIIlIllI, final ICamera lllllllllllllllIlIlllIlIIIIlIlIl, final double lllllllllllllllIlIlllIlIIIIlIlII, final double lllllllllllllllIlIlllIlIIIIllIII, final double lllllllllllllllIlIlllIlIIIIlIIlI) {
        return lllllllllllllllIlIlllIlIIIIlIllI.isInRangeToRender3d(lllllllllllllllIlIlllIlIIIIlIlII, lllllllllllllllIlIlllIlIIIIllIII, lllllllllllllllIlIlllIlIIIIlIIlI) && (lllllllllllllllIlIlllIlIIIIlIllI.ignoreFrustumCheck || lllllllllllllllIlIlllIlIIIIlIlIl.isBoundingBoxInFrustum(lllllllllllllllIlIlllIlIIIIlIllI.getEntityBoundingBox()));
    }
    
    protected Render(final RenderManager lllllllllllllllIlIlllIlIIIlIIlII) {
        this.shadowOpaque = 1.0f;
        this.renderManager = lllllllllllllllIlIlllIlIIIlIIlII;
    }
    
    public RenderManager func_177068_d() {
        return this.renderManager;
    }
    
    protected boolean bindEntityTexture(final Entity lllllllllllllllIlIlllIIlllIlIlIl) {
        final ResourceLocation lllllllllllllllIlIlllIIlllIlIlII = this.getEntityTexture(lllllllllllllllIlIlllIIlllIlIlIl);
        if (lllllllllllllllIlIlllIIlllIlIlII == null) {
            return false;
        }
        this.bindTexture(lllllllllllllllIlIlllIIlllIlIlII);
        return true;
    }
    
    static {
        shadowTextures = new ResourceLocation("textures/misc/shadow.png");
    }
    
    public static void renderOffsetAABB(final AxisAlignedBB lllllllllllllllIlIlllIIIlllIIIIl, final double lllllllllllllllIlIlllIIIlllIIIII, final double lllllllllllllllIlIlllIIIlllIIlIl, final double lllllllllllllllIlIlllIIIlllIIlII) {
        GlStateManager.func_179090_x();
        final Tessellator lllllllllllllllIlIlllIIIlllIIIll = Tessellator.getInstance();
        final WorldRenderer lllllllllllllllIlIlllIIIlllIIIlI = lllllllllllllllIlIlllIIIlllIIIll.getWorldRenderer();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        lllllllllllllllIlIlllIIIlllIIIlI.startDrawingQuads();
        lllllllllllllllIlIlllIIIlllIIIlI.setTranslation(lllllllllllllllIlIlllIIIlllIIIII, lllllllllllllllIlIlllIIIlllIIlIl, lllllllllllllllIlIlllIIIlllIIlII);
        lllllllllllllllIlIlllIIIlllIIIlI.func_178980_d(0.0f, 0.0f, -1.0f);
        lllllllllllllllIlIlllIIIlllIIIlI.addVertex(lllllllllllllllIlIlllIIIlllIIIIl.minX, lllllllllllllllIlIlllIIIlllIIIIl.maxY, lllllllllllllllIlIlllIIIlllIIIIl.minZ);
        lllllllllllllllIlIlllIIIlllIIIlI.addVertex(lllllllllllllllIlIlllIIIlllIIIIl.maxX, lllllllllllllllIlIlllIIIlllIIIIl.maxY, lllllllllllllllIlIlllIIIlllIIIIl.minZ);
        lllllllllllllllIlIlllIIIlllIIIlI.addVertex(lllllllllllllllIlIlllIIIlllIIIIl.maxX, lllllllllllllllIlIlllIIIlllIIIIl.minY, lllllllllllllllIlIlllIIIlllIIIIl.minZ);
        lllllllllllllllIlIlllIIIlllIIIlI.addVertex(lllllllllllllllIlIlllIIIlllIIIIl.minX, lllllllllllllllIlIlllIIIlllIIIIl.minY, lllllllllllllllIlIlllIIIlllIIIIl.minZ);
        lllllllllllllllIlIlllIIIlllIIIlI.func_178980_d(0.0f, 0.0f, 1.0f);
        lllllllllllllllIlIlllIIIlllIIIlI.addVertex(lllllllllllllllIlIlllIIIlllIIIIl.minX, lllllllllllllllIlIlllIIIlllIIIIl.minY, lllllllllllllllIlIlllIIIlllIIIIl.maxZ);
        lllllllllllllllIlIlllIIIlllIIIlI.addVertex(lllllllllllllllIlIlllIIIlllIIIIl.maxX, lllllllllllllllIlIlllIIIlllIIIIl.minY, lllllllllllllllIlIlllIIIlllIIIIl.maxZ);
        lllllllllllllllIlIlllIIIlllIIIlI.addVertex(lllllllllllllllIlIlllIIIlllIIIIl.maxX, lllllllllllllllIlIlllIIIlllIIIIl.maxY, lllllllllllllllIlIlllIIIlllIIIIl.maxZ);
        lllllllllllllllIlIlllIIIlllIIIlI.addVertex(lllllllllllllllIlIlllIIIlllIIIIl.minX, lllllllllllllllIlIlllIIIlllIIIIl.maxY, lllllllllllllllIlIlllIIIlllIIIIl.maxZ);
        lllllllllllllllIlIlllIIIlllIIIlI.func_178980_d(0.0f, -1.0f, 0.0f);
        lllllllllllllllIlIlllIIIlllIIIlI.addVertex(lllllllllllllllIlIlllIIIlllIIIIl.minX, lllllllllllllllIlIlllIIIlllIIIIl.minY, lllllllllllllllIlIlllIIIlllIIIIl.minZ);
        lllllllllllllllIlIlllIIIlllIIIlI.addVertex(lllllllllllllllIlIlllIIIlllIIIIl.maxX, lllllllllllllllIlIlllIIIlllIIIIl.minY, lllllllllllllllIlIlllIIIlllIIIIl.minZ);
        lllllllllllllllIlIlllIIIlllIIIlI.addVertex(lllllllllllllllIlIlllIIIlllIIIIl.maxX, lllllllllllllllIlIlllIIIlllIIIIl.minY, lllllllllllllllIlIlllIIIlllIIIIl.maxZ);
        lllllllllllllllIlIlllIIIlllIIIlI.addVertex(lllllllllllllllIlIlllIIIlllIIIIl.minX, lllllllllllllllIlIlllIIIlllIIIIl.minY, lllllllllllllllIlIlllIIIlllIIIIl.maxZ);
        lllllllllllllllIlIlllIIIlllIIIlI.func_178980_d(0.0f, 1.0f, 0.0f);
        lllllllllllllllIlIlllIIIlllIIIlI.addVertex(lllllllllllllllIlIlllIIIlllIIIIl.minX, lllllllllllllllIlIlllIIIlllIIIIl.maxY, lllllllllllllllIlIlllIIIlllIIIIl.maxZ);
        lllllllllllllllIlIlllIIIlllIIIlI.addVertex(lllllllllllllllIlIlllIIIlllIIIIl.maxX, lllllllllllllllIlIlllIIIlllIIIIl.maxY, lllllllllllllllIlIlllIIIlllIIIIl.maxZ);
        lllllllllllllllIlIlllIIIlllIIIlI.addVertex(lllllllllllllllIlIlllIIIlllIIIIl.maxX, lllllllllllllllIlIlllIIIlllIIIIl.maxY, lllllllllllllllIlIlllIIIlllIIIIl.minZ);
        lllllllllllllllIlIlllIIIlllIIIlI.addVertex(lllllllllllllllIlIlllIIIlllIIIIl.minX, lllllllllllllllIlIlllIIIlllIIIIl.maxY, lllllllllllllllIlIlllIIIlllIIIIl.minZ);
        lllllllllllllllIlIlllIIIlllIIIlI.func_178980_d(-1.0f, 0.0f, 0.0f);
        lllllllllllllllIlIlllIIIlllIIIlI.addVertex(lllllllllllllllIlIlllIIIlllIIIIl.minX, lllllllllllllllIlIlllIIIlllIIIIl.minY, lllllllllllllllIlIlllIIIlllIIIIl.maxZ);
        lllllllllllllllIlIlllIIIlllIIIlI.addVertex(lllllllllllllllIlIlllIIIlllIIIIl.minX, lllllllllllllllIlIlllIIIlllIIIIl.maxY, lllllllllllllllIlIlllIIIlllIIIIl.maxZ);
        lllllllllllllllIlIlllIIIlllIIIlI.addVertex(lllllllllllllllIlIlllIIIlllIIIIl.minX, lllllllllllllllIlIlllIIIlllIIIIl.maxY, lllllllllllllllIlIlllIIIlllIIIIl.minZ);
        lllllllllllllllIlIlllIIIlllIIIlI.addVertex(lllllllllllllllIlIlllIIIlllIIIIl.minX, lllllllllllllllIlIlllIIIlllIIIIl.minY, lllllllllllllllIlIlllIIIlllIIIIl.minZ);
        lllllllllllllllIlIlllIIIlllIIIlI.func_178980_d(1.0f, 0.0f, 0.0f);
        lllllllllllllllIlIlllIIIlllIIIlI.addVertex(lllllllllllllllIlIlllIIIlllIIIIl.maxX, lllllllllllllllIlIlllIIIlllIIIIl.minY, lllllllllllllllIlIlllIIIlllIIIIl.minZ);
        lllllllllllllllIlIlllIIIlllIIIlI.addVertex(lllllllllllllllIlIlllIIIlllIIIIl.maxX, lllllllllllllllIlIlllIIIlllIIIIl.maxY, lllllllllllllllIlIlllIIIlllIIIIl.minZ);
        lllllllllllllllIlIlllIIIlllIIIlI.addVertex(lllllllllllllllIlIlllIIIlllIIIIl.maxX, lllllllllllllllIlIlllIIIlllIIIIl.maxY, lllllllllllllllIlIlllIIIlllIIIIl.maxZ);
        lllllllllllllllIlIlllIIIlllIIIlI.addVertex(lllllllllllllllIlIlllIIIlllIIIIl.maxX, lllllllllllllllIlIlllIIIlllIIIIl.minY, lllllllllllllllIlIlllIIIlllIIIIl.maxZ);
        lllllllllllllllIlIlllIIIlllIIIlI.setTranslation(0.0, 0.0, 0.0);
        lllllllllllllllIlIlllIIIlllIIIll.draw();
        GlStateManager.func_179098_w();
    }
    
    protected void renderLivingLabel(final Entity lllllllllllllllIlIlllIIIlIlIIIII, final String lllllllllllllllIlIlllIIIlIIlllll, final double lllllllllllllllIlIlllIIIlIlIllIl, final double lllllllllllllllIlIlllIIIlIIlllIl, final double lllllllllllllllIlIlllIIIlIIlllII, final int lllllllllllllllIlIlllIIIlIIllIll) {
        final double lllllllllllllllIlIlllIIIlIlIlIIl = lllllllllllllllIlIlllIIIlIlIIIII.getDistanceSqToEntity(this.renderManager.livingPlayer);
        if (lllllllllllllllIlIlllIIIlIlIlIIl <= lllllllllllllllIlIlllIIIlIIllIll * lllllllllllllllIlIlllIIIlIIllIll) {
            final FontRenderer lllllllllllllllIlIlllIIIlIlIlIII = this.getFontRendererFromRenderManager();
            final float lllllllllllllllIlIlllIIIlIlIIlll = 1.6f;
            final float lllllllllllllllIlIlllIIIlIlIIllI = 0.016666668f * lllllllllllllllIlIlllIIIlIlIIlll;
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)lllllllllllllllIlIlllIIIlIlIllIl + 0.0f, (float)lllllllllllllllIlIlllIIIlIIlllIl + lllllllllllllllIlIlllIIIlIlIIIII.height + 0.5f, (float)lllllllllllllllIlIlllIIIlIIlllII);
            GL11.glNormal3f(0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(-this.renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(this.renderManager.playerViewX, 1.0f, 0.0f, 0.0f);
            GlStateManager.scale(-lllllllllllllllIlIlllIIIlIlIIllI, -lllllllllllllllIlIlllIIIlIlIIllI, lllllllllllllllIlIlllIIIlIlIIllI);
            GlStateManager.disableLighting();
            GlStateManager.depthMask(false);
            GlStateManager.disableDepth();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            final Tessellator lllllllllllllllIlIlllIIIlIlIIlIl = Tessellator.getInstance();
            final WorldRenderer lllllllllllllllIlIlllIIIlIlIIlII = lllllllllllllllIlIlllIIIlIlIIlIl.getWorldRenderer();
            byte lllllllllllllllIlIlllIIIlIlIIIll = 0;
            if (lllllllllllllllIlIlllIIIlIIlllll.equals("deadmau5")) {
                lllllllllllllllIlIlllIIIlIlIIIll = -10;
            }
            GlStateManager.func_179090_x();
            lllllllllllllllIlIlllIIIlIlIIlII.startDrawingQuads();
            final int lllllllllllllllIlIlllIIIlIlIIIlI = lllllllllllllllIlIlllIIIlIlIlIII.getStringWidth(lllllllllllllllIlIlllIIIlIIlllll) / 2;
            lllllllllllllllIlIlllIIIlIlIIlII.func_178960_a(0.0f, 0.0f, 0.0f, 0.25f);
            lllllllllllllllIlIlllIIIlIlIIlII.addVertex(-lllllllllllllllIlIlllIIIlIlIIIlI - 1, -1 + lllllllllllllllIlIlllIIIlIlIIIll, 0.0);
            lllllllllllllllIlIlllIIIlIlIIlII.addVertex(-lllllllllllllllIlIlllIIIlIlIIIlI - 1, 8 + lllllllllllllllIlIlllIIIlIlIIIll, 0.0);
            lllllllllllllllIlIlllIIIlIlIIlII.addVertex(lllllllllllllllIlIlllIIIlIlIIIlI + 1, 8 + lllllllllllllllIlIlllIIIlIlIIIll, 0.0);
            lllllllllllllllIlIlllIIIlIlIIlII.addVertex(lllllllllllllllIlIlllIIIlIlIIIlI + 1, -1 + lllllllllllllllIlIlllIIIlIlIIIll, 0.0);
            lllllllllllllllIlIlllIIIlIlIIlIl.draw();
            GlStateManager.func_179098_w();
            lllllllllllllllIlIlllIIIlIlIlIII.drawString(lllllllllllllllIlIlllIIIlIIlllll, -lllllllllllllllIlIlllIIIlIlIlIII.getStringWidth(lllllllllllllllIlIlllIIIlIIlllll) / 2, lllllllllllllllIlIlllIIIlIlIIIll, 553648127);
            GlStateManager.enableDepth();
            GlStateManager.depthMask(true);
            lllllllllllllllIlIlllIIIlIlIlIII.drawString(lllllllllllllllIlIlllIIIlIIlllll, -lllllllllllllllIlIlllIIIlIlIlIII.getStringWidth(lllllllllllllllIlIlllIIIlIIlllll) / 2, lllllllllllllllIlIlllIIIlIlIIIll, -1);
            GlStateManager.enableLighting();
            GlStateManager.disableBlend();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.popMatrix();
        }
    }
    
    protected void func_177067_a(final Entity lllllllllllllllIlIlllIIlllllIlIl, final double lllllllllllllllIlIlllIIlllllIlII, final double lllllllllllllllIlIlllIIllllllIII, final double lllllllllllllllIlIlllIIlllllIlll) {
        if (this.func_177070_b(lllllllllllllllIlIlllIIlllllIlIl)) {
            this.renderLivingLabel(lllllllllllllllIlIlllIIlllllIlIl, lllllllllllllllIlIlllIIlllllIlIl.getDisplayName().getFormattedText(), lllllllllllllllIlIlllIIlllllIlII, lllllllllllllllIlIlllIIllllllIII, lllllllllllllllIlIlllIIlllllIlll, 64);
        }
    }
    
    public void doRenderShadowAndFire(final Entity lllllllllllllllIlIlllIIIllIlIIlI, final double lllllllllllllllIlIlllIIIllIIlIII, final double lllllllllllllllIlIlllIIIllIlIIII, final double lllllllllllllllIlIlllIIIllIIllll, final float lllllllllllllllIlIlllIIIllIIlllI, final float lllllllllllllllIlIlllIIIllIIllIl) {
        if (this.renderManager.options != null) {
            if (this.renderManager.options.fancyGraphics && this.shadowSize > 0.0f && !lllllllllllllllIlIlllIIIllIlIIlI.isInvisible() && this.renderManager.func_178627_a()) {
                final double lllllllllllllllIlIlllIIIllIIllII = this.renderManager.getDistanceToCamera(lllllllllllllllIlIlllIIIllIlIIlI.posX, lllllllllllllllIlIlllIIIllIlIIlI.posY, lllllllllllllllIlIlllIIIllIlIIlI.posZ);
                final float lllllllllllllllIlIlllIIIllIIlIll = (float)((1.0 - lllllllllllllllIlIlllIIIllIIllII / 256.0) * this.shadowOpaque);
                if (lllllllllllllllIlIlllIIIllIIlIll > 0.0f) {
                    this.renderShadow(lllllllllllllllIlIlllIIIllIlIIlI, lllllllllllllllIlIlllIIIllIIlIII, lllllllllllllllIlIlllIIIllIlIIII, lllllllllllllllIlIlllIIIllIIllll, lllllllllllllllIlIlllIIIllIIlIll, lllllllllllllllIlIlllIIIllIIllIl);
                }
            }
            if (lllllllllllllllIlIlllIIIllIlIIlI.canRenderOnFire() && (!(lllllllllllllllIlIlllIIIllIlIIlI instanceof EntityPlayer) || !((EntityPlayer)lllllllllllllllIlIlllIIIllIlIIlI).func_175149_v())) {
                this.renderEntityOnFire(lllllllllllllllIlIlllIIIllIlIIlI, lllllllllllllllIlIlllIIIllIIlIII, lllllllllllllllIlIlllIIIllIlIIII, lllllllllllllllIlIlllIIIllIIllll, lllllllllllllllIlIlllIIIllIIllIl);
            }
        }
    }
}
