package net.minecraft.client.renderer;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import net.minecraft.block.state.*;
import org.lwjgl.opengl.*;
import net.minecraft.world.*;
import java.util.concurrent.*;
import net.minecraft.crash.*;
import com.google.common.collect.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.shader.*;
import java.io.*;
import com.google.gson.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.audio.*;
import net.minecraft.item.*;
import net.minecraft.client.particle.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.renderer.chunk.*;
import net.minecraft.world.chunk.*;
import shadersmod.client.*;
import org.lwjgl.input.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.world.border.*;
import optifine.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.tileentity.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.entity.*;
import org.apache.logging.log4j.*;
import net.minecraft.client.renderer.culling.*;
import javax.vecmath.*;
import java.util.*;

public class RenderGlobal implements IWorldAccess, IResourceManagerReloadListener
{
    public /* synthetic */ boolean displayListEntitiesDirty;
    private final /* synthetic */ Vector4f[] field_175004_V;
    private /* synthetic */ double field_174987_D;
    private static final /* synthetic */ ResourceLocation locationMoonPhasesPng;
    private /* synthetic */ int countEntitiesHidden;
    private /* synthetic */ double prevRenderSortX;
    private final /* synthetic */ RenderManager field_175010_j;
    private /* synthetic */ VertexFormat field_175014_r;
    private static final /* synthetic */ ResourceLocation locationEndSkyPng;
    private /* synthetic */ int starGLCallList;
    private /* synthetic */ double prevRenderSortZ;
    private /* synthetic */ Set field_175009_l;
    private final /* synthetic */ ChunkRenderDispatcher field_174995_M;
    private /* synthetic */ Framebuffer field_175015_z;
    private /* synthetic */ int renderDistance;
    private final /* synthetic */ Vector3d field_175003_W;
    private /* synthetic */ ChunkRenderContainer field_174996_N;
    private /* synthetic */ ClippingHelper field_175001_U;
    private /* synthetic */ CloudRenderer cloudRenderer;
    private /* synthetic */ boolean field_175005_X;
    private /* synthetic */ int renderEntitiesStartupCounter;
    public final /* synthetic */ Map damagedBlocks;
    /* synthetic */ IRenderChunkFactory field_175007_a;
    private /* synthetic */ boolean field_175002_T;
    private /* synthetic */ int renderDistanceSq;
    public final /* synthetic */ Minecraft mc;
    private /* synthetic */ int field_174988_E;
    private /* synthetic */ int cloudTickCounter;
    private /* synthetic */ List renderInfosTileEntities;
    private /* synthetic */ int countEntitiesTotal;
    private /* synthetic */ List renderInfosShadow;
    private /* synthetic */ int glSkyList;
    private /* synthetic */ double field_175000_K;
    private /* synthetic */ double field_174992_B;
    private /* synthetic */ Deque visibilityDeque;
    private /* synthetic */ int field_174990_G;
    private /* synthetic */ List renderInfosEntitiesNormal;
    private /* synthetic */ double field_174993_C;
    private final /* synthetic */ TextureManager renderEngine;
    private /* synthetic */ int renderDistanceChunks;
    private /* synthetic */ int countEntitiesRendered;
    private /* synthetic */ WorldClient theWorld;
    private /* synthetic */ double field_174994_L;
    private static final /* synthetic */ Logger logger;
    private /* synthetic */ List renderInfosTileEntitiesNormal;
    private static final /* synthetic */ ResourceLocation locationSunPng;
    private static final /* synthetic */ ResourceLocation field_175006_g;
    private /* synthetic */ ViewFrustum field_175008_n;
    private /* synthetic */ double field_174997_H;
    public /* synthetic */ Set chunksToResortTransparency;
    private /* synthetic */ VertexBuffer field_175013_s;
    private /* synthetic */ double field_174999_J;
    private /* synthetic */ VertexBuffer field_175012_t;
    private /* synthetic */ double prevRenderSortY;
    private /* synthetic */ int glSkyList2;
    private static final /* synthetic */ Set SET_ALL_FACINGS;
    private /* synthetic */ int field_174989_F;
    public /* synthetic */ Set chunksToUpdateForced;
    public /* synthetic */ Entity renderedEntity;
    private final /* synthetic */ TextureAtlasSprite[] destroyBlockIcons;
    private /* synthetic */ VertexBuffer field_175011_u;
    private /* synthetic */ int countTileEntitiesRendered;
    private /* synthetic */ ShaderGroup field_174991_A;
    private /* synthetic */ List renderInfosTileEntitiesShadow;
    private /* synthetic */ List glRenderLists;
    private /* synthetic */ List renderInfosEntitiesShadow;
    private /* synthetic */ List renderInfosEntities;
    private /* synthetic */ List renderInfosNormal;
    private final /* synthetic */ Map mapSoundPositions;
    private /* synthetic */ double field_174998_I;
    private static final /* synthetic */ ResourceLocation locationCloudsPng;
    
    public WorldClient getWorld() {
        return this.theWorld;
    }
    
    public void func_174981_a(final Tessellator llllllllllllllIllIIlllllIllIIlll, final WorldRenderer llllllllllllllIllIIlllllIllIIllI, final Entity llllllllllllllIllIIlllllIllIIlIl, final float llllllllllllllIllIIlllllIllIIlII) {
        final double llllllllllllllIllIIlllllIllIIIll = llllllllllllllIllIIlllllIllIIlIl.lastTickPosX + (llllllllllllllIllIIlllllIllIIlIl.posX - llllllllllllllIllIIlllllIllIIlIl.lastTickPosX) * llllllllllllllIllIIlllllIllIIlII;
        final double llllllllllllllIllIIlllllIllIIIlI = llllllllllllllIllIIlllllIllIIlIl.lastTickPosY + (llllllllllllllIllIIlllllIllIIlIl.posY - llllllllllllllIllIIlllllIllIIlIl.lastTickPosY) * llllllllllllllIllIIlllllIllIIlII;
        final double llllllllllllllIllIIlllllIllIIIIl = llllllllllllllIllIIlllllIllIIlIl.lastTickPosZ + (llllllllllllllIllIIlllllIllIIlIl.posZ - llllllllllllllIllIIlllllIllIIlIl.lastTickPosZ) * llllllllllllllIllIIlllllIllIIlII;
        if (!this.damagedBlocks.isEmpty()) {
            this.renderEngine.bindTexture(TextureMap.locationBlocksTexture);
            this.func_180443_s();
            llllllllllllllIllIIlllllIllIIllI.startDrawingQuads();
            llllllllllllllIllIIlllllIllIIllI.setVertexFormat(DefaultVertexFormats.field_176600_a);
            llllllllllllllIllIIlllllIllIIllI.setTranslation(-llllllllllllllIllIIlllllIllIIIll, -llllllllllllllIllIIlllllIllIIIlI, -llllllllllllllIllIIlllllIllIIIIl);
            llllllllllllllIllIIlllllIllIIllI.markDirty();
            final Iterator llllllllllllllIllIIlllllIllIIIII = this.damagedBlocks.values().iterator();
            while (llllllllllllllIllIIlllllIllIIIII.hasNext()) {
                final DestroyBlockProgress llllllllllllllIllIIlllllIlIlllll = llllllllllllllIllIIlllllIllIIIII.next();
                final BlockPos llllllllllllllIllIIlllllIlIllllI = llllllllllllllIllIIlllllIlIlllll.func_180246_b();
                final double llllllllllllllIllIIlllllIlIlllIl = llllllllllllllIllIIlllllIlIllllI.getX() - llllllllllllllIllIIlllllIllIIIll;
                final double llllllllllllllIllIIlllllIlIlllII = llllllllllllllIllIIlllllIlIllllI.getY() - llllllllllllllIllIIlllllIllIIIlI;
                final double llllllllllllllIllIIlllllIlIllIll = llllllllllllllIllIIlllllIlIllllI.getZ() - llllllllllllllIllIIlllllIllIIIIl;
                final Block llllllllllllllIllIIlllllIlIllIlI = this.theWorld.getBlockState(llllllllllllllIllIIlllllIlIllllI).getBlock();
                boolean llllllllllllllIllIIlllllIlIllIII = false;
                if (Reflector.ForgeTileEntity_canRenderBreaking.exists()) {
                    boolean llllllllllllllIllIIlllllIlIlIlll = llllllllllllllIllIIlllllIlIllIlI instanceof BlockChest || llllllllllllllIllIIlllllIlIllIlI instanceof BlockEnderChest || llllllllllllllIllIIlllllIlIllIlI instanceof BlockSign || llllllllllllllIllIIlllllIlIllIlI instanceof BlockSkull;
                    if (!llllllllllllllIllIIlllllIlIlIlll) {
                        final TileEntity llllllllllllllIllIIlllllIlIlIllI = this.theWorld.getTileEntity(llllllllllllllIllIIlllllIlIllllI);
                        if (llllllllllllllIllIIlllllIlIlIllI != null) {
                            llllllllllllllIllIIlllllIlIlIlll = Reflector.callBoolean(llllllllllllllIllIIlllllIlIlIllI, Reflector.ForgeTileEntity_canRenderBreaking, new Object[0]);
                        }
                    }
                    final boolean llllllllllllllIllIIlllllIlIllIIl = !llllllllllllllIllIIlllllIlIlIlll;
                }
                else {
                    llllllllllllllIllIIlllllIlIllIII = (!(llllllllllllllIllIIlllllIlIllIlI instanceof BlockChest) && !(llllllllllllllIllIIlllllIlIllIlI instanceof BlockEnderChest) && !(llllllllllllllIllIIlllllIlIllIlI instanceof BlockSign) && !(llllllllllllllIllIIlllllIlIllIlI instanceof BlockSkull));
                }
                if (llllllllllllllIllIIlllllIlIllIII) {
                    if (llllllllllllllIllIIlllllIlIlllIl * llllllllllllllIllIIlllllIlIlllIl + llllllllllllllIllIIlllllIlIlllII * llllllllllllllIllIIlllllIlIlllII + llllllllllllllIllIIlllllIlIllIll * llllllllllllllIllIIlllllIlIllIll > 1024.0) {
                        llllllllllllllIllIIlllllIllIIIII.remove();
                    }
                    else {
                        final IBlockState llllllllllllllIllIIlllllIlIlIlIl = this.theWorld.getBlockState(llllllllllllllIllIIlllllIlIllllI);
                        if (llllllllllllllIllIIlllllIlIlIlIl.getBlock().getMaterial() == Material.air) {
                            continue;
                        }
                        final int llllllllllllllIllIIlllllIlIlIlII = llllllllllllllIllIIlllllIlIlllll.getPartialBlockDamage();
                        final TextureAtlasSprite llllllllllllllIllIIlllllIlIlIIll = this.destroyBlockIcons[llllllllllllllIllIIlllllIlIlIlII];
                        final BlockRendererDispatcher llllllllllllllIllIIlllllIlIlIIlI = this.mc.getBlockRendererDispatcher();
                        llllllllllllllIllIIlllllIlIlIIlI.func_175020_a(llllllllllllllIllIIlllllIlIlIlIl, llllllllllllllIllIIlllllIlIllllI, llllllllllllllIllIIlllllIlIlIIll, this.theWorld);
                    }
                }
            }
            llllllllllllllIllIIlllllIllIIlll.draw();
            llllllllllllllIllIIlllllIllIIllI.setTranslation(0.0, 0.0, 0.0);
            this.func_174969_t();
        }
    }
    
    protected boolean func_174985_d() {
        return !Config.isFastRender() && !Config.isShaders() && !Config.isAntialiasing() && (this.field_175015_z != null && this.field_174991_A != null && this.mc.thePlayer != null && this.mc.thePlayer.func_175149_v() && this.mc.gameSettings.field_178883_an.getIsKeyPressed());
    }
    
    public void func_180447_b(float llllllllllllllIllIlIIIIIIlllIlll, final int llllllllllllllIllIlIIIIIIlllIllI) {
        if (!Config.isCloudsOff()) {
            if (Reflector.ForgeWorldProvider_getCloudRenderer.exists()) {
                final WorldProvider llllllllllllllIllIlIIIIIlIIlIIIl = this.mc.theWorld.provider;
                final Object llllllllllllllIllIlIIIIIlIIlIIII = Reflector.call(llllllllllllllIllIlIIIIIlIIlIIIl, Reflector.ForgeWorldProvider_getCloudRenderer, new Object[0]);
                if (llllllllllllllIllIlIIIIIlIIlIIII != null) {
                    Reflector.callVoid(llllllllllllllIllIlIIIIIlIIlIIII, Reflector.IRenderHandler_render, llllllllllllllIllIlIIIIIIlllIlll, this.theWorld, this.mc);
                    return;
                }
            }
            if (this.mc.theWorld.provider.isSurfaceWorld()) {
                if (Config.isShaders()) {
                    Shaders.beginClouds();
                }
                if (Config.isCloudsFancy()) {
                    this.func_180445_c(llllllllllllllIllIlIIIIIIlllIlll, llllllllllllllIllIlIIIIIIlllIllI);
                }
                else {
                    this.cloudRenderer.prepareToRender(false, this.cloudTickCounter, llllllllllllllIllIlIIIIIIlllIlll);
                    llllllllllllllIllIlIIIIIIlllIlll = 0.0f;
                    GlStateManager.disableCull();
                    final float llllllllllllllIllIlIIIIIlIIIllll = (float)(this.mc.func_175606_aa().lastTickPosY + (this.mc.func_175606_aa().posY - this.mc.func_175606_aa().lastTickPosY) * llllllllllllllIllIlIIIIIIlllIlll);
                    final boolean llllllllllllllIllIlIIIIIlIIIlllI = true;
                    final boolean llllllllllllllIllIlIIIIIlIIIllIl = true;
                    final Tessellator llllllllllllllIllIlIIIIIlIIIllII = Tessellator.getInstance();
                    final WorldRenderer llllllllllllllIllIlIIIIIlIIIlIll = llllllllllllllIllIlIIIIIlIIIllII.getWorldRenderer();
                    this.renderEngine.bindTexture(RenderGlobal.locationCloudsPng);
                    GlStateManager.enableBlend();
                    GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                    if (this.cloudRenderer.shouldUpdateGlList()) {
                        this.cloudRenderer.startUpdateGlList();
                        final Vec3 llllllllllllllIllIlIIIIIlIIIlIlI = this.theWorld.getCloudColour(llllllllllllllIllIlIIIIIIlllIlll);
                        float llllllllllllllIllIlIIIIIlIIIlIIl = (float)llllllllllllllIllIlIIIIIlIIIlIlI.xCoord;
                        float llllllllllllllIllIlIIIIIlIIIlIII = (float)llllllllllllllIllIlIIIIIlIIIlIlI.yCoord;
                        float llllllllllllllIllIlIIIIIlIIIIlll = (float)llllllllllllllIllIlIIIIIlIIIlIlI.zCoord;
                        if (llllllllllllllIllIlIIIIIIlllIllI != 2) {
                            final float llllllllllllllIllIlIIIIIlIIIIllI = (llllllllllllllIllIlIIIIIlIIIlIIl * 30.0f + llllllllllllllIllIlIIIIIlIIIlIII * 59.0f + llllllllllllllIllIlIIIIIlIIIIlll * 11.0f) / 100.0f;
                            final float llllllllllllllIllIlIIIIIlIIIIlII = (llllllllllllllIllIlIIIIIlIIIlIIl * 30.0f + llllllllllllllIllIlIIIIIlIIIlIII * 70.0f) / 100.0f;
                            final float llllllllllllllIllIlIIIIIlIIIIIll = (llllllllllllllIllIlIIIIIlIIIlIIl * 30.0f + llllllllllllllIllIlIIIIIlIIIIlll * 70.0f) / 100.0f;
                            llllllllllllllIllIlIIIIIlIIIlIIl = llllllllllllllIllIlIIIIIlIIIIllI;
                            llllllllllllllIllIlIIIIIlIIIlIII = llllllllllllllIllIlIIIIIlIIIIlII;
                            llllllllllllllIllIlIIIIIlIIIIlll = llllllllllllllIllIlIIIIIlIIIIIll;
                        }
                        final float llllllllllllllIllIlIIIIIlIIIIlIl = 4.8828125E-4f;
                        final double llllllllllllllIllIlIIIIIlIIIIIlI = this.cloudTickCounter + llllllllllllllIllIlIIIIIIlllIlll;
                        double llllllllllllllIllIlIIIIIlIIIIIIl = this.mc.func_175606_aa().prevPosX + (this.mc.func_175606_aa().posX - this.mc.func_175606_aa().prevPosX) * llllllllllllllIllIlIIIIIIlllIlll + llllllllllllllIllIlIIIIIlIIIIIlI * 0.029999999329447746;
                        double llllllllllllllIllIlIIIIIlIIIIIII = this.mc.func_175606_aa().prevPosZ + (this.mc.func_175606_aa().posZ - this.mc.func_175606_aa().prevPosZ) * llllllllllllllIllIlIIIIIIlllIlll;
                        final int llllllllllllllIllIlIIIIIIlllllll = MathHelper.floor_double(llllllllllllllIllIlIIIIIlIIIIIIl / 2048.0);
                        final int llllllllllllllIllIlIIIIIIllllllI = MathHelper.floor_double(llllllllllllllIllIlIIIIIlIIIIIII / 2048.0);
                        llllllllllllllIllIlIIIIIlIIIIIIl -= llllllllllllllIllIlIIIIIIlllllll * 2048;
                        llllllllllllllIllIlIIIIIlIIIIIII -= llllllllllllllIllIlIIIIIIllllllI * 2048;
                        float llllllllllllllIllIlIIIIIIlllllIl = this.theWorld.provider.getCloudHeight() - llllllllllllllIllIlIIIIIlIIIllll + 0.33f;
                        llllllllllllllIllIlIIIIIIlllllIl += this.mc.gameSettings.ofCloudsHeight * 128.0f;
                        final float llllllllllllllIllIlIIIIIIlllllII = (float)(llllllllllllllIllIlIIIIIlIIIIIIl * 4.8828125E-4);
                        final float llllllllllllllIllIlIIIIIIllllIll = (float)(llllllllllllllIllIlIIIIIlIIIIIII * 4.8828125E-4);
                        llllllllllllllIllIlIIIIIlIIIlIll.startDrawingQuads();
                        llllllllllllllIllIlIIIIIlIIIlIll.func_178960_a(llllllllllllllIllIlIIIIIlIIIlIIl, llllllllllllllIllIlIIIIIlIIIlIII, llllllllllllllIllIlIIIIIlIIIIlll, 0.8f);
                        for (int llllllllllllllIllIlIIIIIIllllIlI = -256; llllllllllllllIllIlIIIIIIllllIlI < 256; llllllllllllllIllIlIIIIIIllllIlI += 32) {
                            for (int llllllllllllllIllIlIIIIIIllllIIl = -256; llllllllllllllIllIlIIIIIIllllIIl < 256; llllllllllllllIllIlIIIIIIllllIIl += 32) {
                                llllllllllllllIllIlIIIIIlIIIlIll.addVertexWithUV(llllllllllllllIllIlIIIIIIllllIlI + 0, llllllllllllllIllIlIIIIIIlllllIl, llllllllllllllIllIlIIIIIIllllIIl + 32, (llllllllllllllIllIlIIIIIIllllIlI + 0) * 4.8828125E-4f + llllllllllllllIllIlIIIIIIlllllII, (llllllllllllllIllIlIIIIIIllllIIl + 32) * 4.8828125E-4f + llllllllllllllIllIlIIIIIIllllIll);
                                llllllllllllllIllIlIIIIIlIIIlIll.addVertexWithUV(llllllllllllllIllIlIIIIIIllllIlI + 32, llllllllllllllIllIlIIIIIIlllllIl, llllllllllllllIllIlIIIIIIllllIIl + 32, (llllllllllllllIllIlIIIIIIllllIlI + 32) * 4.8828125E-4f + llllllllllllllIllIlIIIIIIlllllII, (llllllllllllllIllIlIIIIIIllllIIl + 32) * 4.8828125E-4f + llllllllllllllIllIlIIIIIIllllIll);
                                llllllllllllllIllIlIIIIIlIIIlIll.addVertexWithUV(llllllllllllllIllIlIIIIIIllllIlI + 32, llllllllllllllIllIlIIIIIIlllllIl, llllllllllllllIllIlIIIIIIllllIIl + 0, (llllllllllllllIllIlIIIIIIllllIlI + 32) * 4.8828125E-4f + llllllllllllllIllIlIIIIIIlllllII, (llllllllllllllIllIlIIIIIIllllIIl + 0) * 4.8828125E-4f + llllllllllllllIllIlIIIIIIllllIll);
                                llllllllllllllIllIlIIIIIlIIIlIll.addVertexWithUV(llllllllllllllIllIlIIIIIIllllIlI + 0, llllllllllllllIllIlIIIIIIlllllIl, llllllllllllllIllIlIIIIIIllllIIl + 0, (llllllllllllllIllIlIIIIIIllllIlI + 0) * 4.8828125E-4f + llllllllllllllIllIlIIIIIIlllllII, (llllllllllllllIllIlIIIIIIllllIIl + 0) * 4.8828125E-4f + llllllllllllllIllIlIIIIIIllllIll);
                            }
                        }
                        llllllllllllllIllIlIIIIIlIIIllII.draw();
                        this.cloudRenderer.endUpdateGlList();
                    }
                    this.cloudRenderer.renderGlList();
                    GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                    GlStateManager.disableBlend();
                    GlStateManager.enableCull();
                }
                if (Config.isShaders()) {
                    Shaders.endClouds();
                }
            }
        }
    }
    
    private void func_174980_p() {
        final Tessellator llllllllllllllIllIlIIIllIlIIlIll = Tessellator.getInstance();
        final WorldRenderer llllllllllllllIllIlIIIllIlIIlIlI = llllllllllllllIllIlIIIllIlIIlIll.getWorldRenderer();
        if (this.field_175012_t != null) {
            this.field_175012_t.func_177362_c();
        }
        if (this.glSkyList >= 0) {
            GLAllocation.deleteDisplayLists(this.glSkyList);
            this.glSkyList = -1;
        }
        if (this.field_175005_X) {
            this.field_175012_t = new VertexBuffer(this.field_175014_r);
            this.func_174968_a(llllllllllllllIllIlIIIllIlIIlIlI, 16.0f, false);
            llllllllllllllIllIlIIIllIlIIlIlI.draw();
            llllllllllllllIllIlIIIllIlIIlIlI.reset();
            this.field_175012_t.func_177360_a(llllllllllllllIllIlIIIllIlIIlIlI.func_178966_f(), llllllllllllllIllIlIIIllIlIIlIlI.func_178976_e());
        }
        else {
            this.glSkyList = GLAllocation.generateDisplayLists(1);
            GL11.glNewList(this.glSkyList, 4864);
            this.func_174968_a(llllllllllllllIllIlIIIllIlIIlIlI, 16.0f, false);
            llllllllllllllIllIlIIIllIlIIlIll.draw();
            GL11.glEndList();
        }
    }
    
    private void func_180444_a(final WorldRenderer llllllllllllllIllIlIIIlIlllIIIlI) {
        final Random llllllllllllllIllIlIIIllIIIIIIII = new Random(10842L);
        llllllllllllllIllIlIIIlIlllIIIlI.startDrawingQuads();
        for (int llllllllllllllIllIlIIIlIllllllll = 0; llllllllllllllIllIlIIIlIllllllll < 1500; ++llllllllllllllIllIlIIIlIllllllll) {
            double llllllllllllllIllIlIIIlIlllllllI = llllllllllllllIllIlIIIllIIIIIIII.nextFloat() * 2.0f - 1.0f;
            double llllllllllllllIllIlIIIlIllllllIl = llllllllllllllIllIlIIIllIIIIIIII.nextFloat() * 2.0f - 1.0f;
            double llllllllllllllIllIlIIIlIllllllII = llllllllllllllIllIlIIIllIIIIIIII.nextFloat() * 2.0f - 1.0f;
            final double llllllllllllllIllIlIIIlIlllllIll = 0.15f + llllllllllllllIllIlIIIllIIIIIIII.nextFloat() * 0.1f;
            double llllllllllllllIllIlIIIlIlllllIlI = llllllllllllllIllIlIIIlIlllllllI * llllllllllllllIllIlIIIlIlllllllI + llllllllllllllIllIlIIIlIllllllIl * llllllllllllllIllIlIIIlIllllllIl + llllllllllllllIllIlIIIlIllllllII * llllllllllllllIllIlIIIlIllllllII;
            if (llllllllllllllIllIlIIIlIlllllIlI < 1.0 && llllllllllllllIllIlIIIlIlllllIlI > 0.01) {
                llllllllllllllIllIlIIIlIlllllIlI = 1.0 / Math.sqrt(llllllllllllllIllIlIIIlIlllllIlI);
                llllllllllllllIllIlIIIlIlllllllI *= llllllllllllllIllIlIIIlIlllllIlI;
                llllllllllllllIllIlIIIlIllllllIl *= llllllllllllllIllIlIIIlIlllllIlI;
                llllllllllllllIllIlIIIlIllllllII *= llllllllllllllIllIlIIIlIlllllIlI;
                final double llllllllllllllIllIlIIIlIlllllIIl = llllllllllllllIllIlIIIlIlllllllI * 100.0;
                final double llllllllllllllIllIlIIIlIlllllIII = llllllllllllllIllIlIIIlIllllllIl * 100.0;
                final double llllllllllllllIllIlIIIlIllllIlll = llllllllllllllIllIlIIIlIllllllII * 100.0;
                final double llllllllllllllIllIlIIIlIllllIllI = Math.atan2(llllllllllllllIllIlIIIlIlllllllI, llllllllllllllIllIlIIIlIllllllII);
                final double llllllllllllllIllIlIIIlIllllIlIl = Math.sin(llllllllllllllIllIlIIIlIllllIllI);
                final double llllllllllllllIllIlIIIlIllllIlII = Math.cos(llllllllllllllIllIlIIIlIllllIllI);
                final double llllllllllllllIllIlIIIlIllllIIll = Math.atan2(Math.sqrt(llllllllllllllIllIlIIIlIlllllllI * llllllllllllllIllIlIIIlIlllllllI + llllllllllllllIllIlIIIlIllllllII * llllllllllllllIllIlIIIlIllllllII), llllllllllllllIllIlIIIlIllllllIl);
                final double llllllllllllllIllIlIIIlIllllIIlI = Math.sin(llllllllllllllIllIlIIIlIllllIIll);
                final double llllllllllllllIllIlIIIlIllllIIIl = Math.cos(llllllllllllllIllIlIIIlIllllIIll);
                final double llllllllllllllIllIlIIIlIllllIIII = llllllllllllllIllIlIIIllIIIIIIII.nextDouble() * 3.141592653589793 * 2.0;
                final double llllllllllllllIllIlIIIlIlllIllll = Math.sin(llllllllllllllIllIlIIIlIllllIIII);
                final double llllllllllllllIllIlIIIlIlllIlllI = Math.cos(llllllllllllllIllIlIIIlIllllIIII);
                for (int llllllllllllllIllIlIIIlIlllIllIl = 0; llllllllllllllIllIlIIIlIlllIllIl < 4; ++llllllllllllllIllIlIIIlIlllIllIl) {
                    final double llllllllllllllIllIlIIIlIlllIllII = 0.0;
                    final double llllllllllllllIllIlIIIlIlllIlIll = ((llllllllllllllIllIlIIIlIlllIllIl & 0x2) - 1) * llllllllllllllIllIlIIIlIlllllIll;
                    final double llllllllllllllIllIlIIIlIlllIlIlI = ((llllllllllllllIllIlIIIlIlllIllIl + 1 & 0x2) - 1) * llllllllllllllIllIlIIIlIlllllIll;
                    final double llllllllllllllIllIlIIIlIlllIlIIl = 0.0;
                    final double llllllllllllllIllIlIIIlIlllIlIII = llllllllllllllIllIlIIIlIlllIlIll * llllllllllllllIllIlIIIlIlllIlllI - llllllllllllllIllIlIIIlIlllIlIlI * llllllllllllllIllIlIIIlIlllIllll;
                    final double llllllllllllllIllIlIIIlIlllIIlll = llllllllllllllIllIlIIIlIlllIlIlI * llllllllllllllIllIlIIIlIlllIlllI + llllllllllllllIllIlIIIlIlllIlIll * llllllllllllllIllIlIIIlIlllIllll;
                    final double llllllllllllllIllIlIIIlIlllIIllI = llllllllllllllIllIlIIIlIlllIlIII * llllllllllllllIllIlIIIlIllllIIlI + 0.0 * llllllllllllllIllIlIIIlIllllIIIl;
                    final double llllllllllllllIllIlIIIlIlllIIlIl = 0.0 * llllllllllllllIllIlIIIlIllllIIlI - llllllllllllllIllIlIIIlIlllIlIII * llllllllllllllIllIlIIIlIllllIIIl;
                    final double llllllllllllllIllIlIIIlIlllIIlII = llllllllllllllIllIlIIIlIlllIIlIl * llllllllllllllIllIlIIIlIllllIlIl - llllllllllllllIllIlIIIlIlllIIlll * llllllllllllllIllIlIIIlIllllIlII;
                    final double llllllllllllllIllIlIIIlIlllIIIll = llllllllllllllIllIlIIIlIlllIIlll * llllllllllllllIllIlIIIlIllllIlIl + llllllllllllllIllIlIIIlIlllIIlIl * llllllllllllllIllIlIIIlIllllIlII;
                    llllllllllllllIllIlIIIlIlllIIIlI.addVertex(llllllllllllllIllIlIIIlIlllllIIl + llllllllllllllIllIlIIIlIlllIIlII, llllllllllllllIllIlIIIlIlllllIII + llllllllllllllIllIlIIIlIlllIIllI, llllllllllllllIllIlIIIlIllllIlll + llllllllllllllIllIlIIIlIlllIIIll);
                }
            }
        }
    }
    
    public int getCountRenderers() {
        return this.field_175008_n.field_178164_f.length;
    }
    
    public void func_174976_a(final float llllllllllllllIllIlIIIIIllIIIIll, final int llllllllllllllIllIlIIIIIllIIIIlI) {
        if (Reflector.ForgeWorldProvider_getSkyRenderer.exists()) {
            final WorldProvider llllllllllllllIllIlIIIIIlllIlIll = this.mc.theWorld.provider;
            final Object llllllllllllllIllIlIIIIIlllIlIlI = Reflector.call(llllllllllllllIllIlIIIIIlllIlIll, Reflector.ForgeWorldProvider_getSkyRenderer, new Object[0]);
            if (llllllllllllllIllIlIIIIIlllIlIlI != null) {
                Reflector.callVoid(llllllllllllllIllIlIIIIIlllIlIlI, Reflector.IRenderHandler_render, llllllllllllllIllIlIIIIIllIIIIll, this.theWorld, this.mc);
                return;
            }
        }
        if (this.mc.theWorld.provider.getDimensionId() == 1) {
            this.func_180448_r();
        }
        else if (this.mc.theWorld.provider.isSurfaceWorld()) {
            GlStateManager.func_179090_x();
            final boolean llllllllllllllIllIlIIIIIlllIlIIl = Config.isShaders();
            if (llllllllllllllIllIlIIIIIlllIlIIl) {
                Shaders.disableTexture2D();
            }
            Vec3 llllllllllllllIllIlIIIIIlllIlIII = this.theWorld.getSkyColor(this.mc.func_175606_aa(), llllllllllllllIllIlIIIIIllIIIIll);
            llllllllllllllIllIlIIIIIlllIlIII = CustomColors.getSkyColor(llllllllllllllIllIlIIIIIlllIlIII, this.mc.theWorld, this.mc.func_175606_aa().posX, this.mc.func_175606_aa().posY + 1.0, this.mc.func_175606_aa().posZ);
            if (llllllllllllllIllIlIIIIIlllIlIIl) {
                Shaders.setSkyColor(llllllllllllllIllIlIIIIIlllIlIII);
            }
            float llllllllllllllIllIlIIIIIlllIIlll = (float)llllllllllllllIllIlIIIIIlllIlIII.xCoord;
            float llllllllllllllIllIlIIIIIlllIIllI = (float)llllllllllllllIllIlIIIIIlllIlIII.yCoord;
            float llllllllllllllIllIlIIIIIlllIIlIl = (float)llllllllllllllIllIlIIIIIlllIlIII.zCoord;
            if (llllllllllllllIllIlIIIIIllIIIIlI != 2) {
                final float llllllllllllllIllIlIIIIIlllIIlII = (llllllllllllllIllIlIIIIIlllIIlll * 30.0f + llllllllllllllIllIlIIIIIlllIIllI * 59.0f + llllllllllllllIllIlIIIIIlllIIlIl * 11.0f) / 100.0f;
                final float llllllllllllllIllIlIIIIIlllIIIll = (llllllllllllllIllIlIIIIIlllIIlll * 30.0f + llllllllllllllIllIlIIIIIlllIIllI * 70.0f) / 100.0f;
                final float llllllllllllllIllIlIIIIIlllIIIlI = (llllllllllllllIllIlIIIIIlllIIlll * 30.0f + llllllllllllllIllIlIIIIIlllIIlIl * 70.0f) / 100.0f;
                llllllllllllllIllIlIIIIIlllIIlll = llllllllllllllIllIlIIIIIlllIIlII;
                llllllllllllllIllIlIIIIIlllIIllI = llllllllllllllIllIlIIIIIlllIIIll;
                llllllllllllllIllIlIIIIIlllIIlIl = llllllllllllllIllIlIIIIIlllIIIlI;
            }
            GlStateManager.color(llllllllllllllIllIlIIIIIlllIIlll, llllllllllllllIllIlIIIIIlllIIllI, llllllllllllllIllIlIIIIIlllIIlIl);
            final Tessellator llllllllllllllIllIlIIIIIlllIIIIl = Tessellator.getInstance();
            final WorldRenderer llllllllllllllIllIlIIIIIlllIIIII = llllllllllllllIllIlIIIIIlllIIIIl.getWorldRenderer();
            GlStateManager.depthMask(false);
            GlStateManager.enableFog();
            if (llllllllllllllIllIlIIIIIlllIlIIl) {
                Shaders.enableFog();
            }
            GlStateManager.color(llllllllllllllIllIlIIIIIlllIIlll, llllllllllllllIllIlIIIIIlllIIllI, llllllllllllllIllIlIIIIIlllIIlIl);
            if (llllllllllllllIllIlIIIIIlllIlIIl) {
                Shaders.preSkyList();
            }
            if (Config.isSkyEnabled()) {
                if (this.field_175005_X) {
                    this.field_175012_t.func_177359_a();
                    GL11.glEnableClientState(32884);
                    GL11.glVertexPointer(3, 5126, 12, 0L);
                    this.field_175012_t.func_177358_a(7);
                    this.field_175012_t.func_177361_b();
                    GL11.glDisableClientState(32884);
                }
                else {
                    GlStateManager.callList(this.glSkyList);
                }
            }
            GlStateManager.disableFog();
            if (llllllllllllllIllIlIIIIIlllIlIIl) {
                Shaders.disableFog();
            }
            GlStateManager.disableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            RenderHelper.disableStandardItemLighting();
            final float[] llllllllllllllIllIlIIIIIllIlllll = this.theWorld.provider.calcSunriseSunsetColors(this.theWorld.getCelestialAngle(llllllllllllllIllIlIIIIIllIIIIll), llllllllllllllIllIlIIIIIllIIIIll);
            if (llllllllllllllIllIlIIIIIllIlllll != null && Config.isSunMoonEnabled()) {
                GlStateManager.func_179090_x();
                if (llllllllllllllIllIlIIIIIlllIlIIl) {
                    Shaders.disableTexture2D();
                }
                GlStateManager.shadeModel(7425);
                GlStateManager.pushMatrix();
                GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate((MathHelper.sin(this.theWorld.getCelestialAngleRadians(llllllllllllllIllIlIIIIIllIIIIll)) < 0.0f) ? 180.0f : 0.0f, 0.0f, 0.0f, 1.0f);
                GlStateManager.rotate(90.0f, 0.0f, 0.0f, 1.0f);
                float llllllllllllllIllIlIIIIIllIllllI = llllllllllllllIllIlIIIIIllIlllll[0];
                float llllllllllllllIllIlIIIIIllIlllII = llllllllllllllIllIlIIIIIllIlllll[1];
                float llllllllllllllIllIlIIIIIllIllIlI = llllllllllllllIllIlIIIIIllIlllll[2];
                if (llllllllllllllIllIlIIIIIllIIIIlI != 2) {
                    final float llllllllllllllIllIlIIIIIllIllIII = (llllllllllllllIllIlIIIIIllIllllI * 30.0f + llllllllllllllIllIlIIIIIllIlllII * 59.0f + llllllllllllllIllIlIIIIIllIllIlI * 11.0f) / 100.0f;
                    final float llllllllllllllIllIlIIIIIllIlIllI = (llllllllllllllIllIlIIIIIllIllllI * 30.0f + llllllllllllllIllIlIIIIIllIlllII * 70.0f) / 100.0f;
                    final float llllllllllllllIllIlIIIIIllIlIIll = (llllllllllllllIllIlIIIIIllIllllI * 30.0f + llllllllllllllIllIlIIIIIllIllIlI * 70.0f) / 100.0f;
                    llllllllllllllIllIlIIIIIllIllllI = llllllllllllllIllIlIIIIIllIllIII;
                    llllllllllllllIllIlIIIIIllIlllII = llllllllllllllIllIlIIIIIllIlIllI;
                    llllllllllllllIllIlIIIIIllIllIlI = llllllllllllllIllIlIIIIIllIlIIll;
                }
                llllllllllllllIllIlIIIIIlllIIIII.startDrawing(6);
                llllllllllllllIllIlIIIIIlllIIIII.func_178960_a(llllllllllllllIllIlIIIIIllIllllI, llllllllllllllIllIlIIIIIllIlllII, llllllllllllllIllIlIIIIIllIllIlI, llllllllllllllIllIlIIIIIllIlllll[3]);
                llllllllllllllIllIlIIIIIlllIIIII.addVertex(0.0, 100.0, 0.0);
                final boolean llllllllllllllIllIlIIIIIllIIlIlI = true;
                llllllllllllllIllIlIIIIIlllIIIII.func_178960_a(llllllllllllllIllIlIIIIIllIlllll[0], llllllllllllllIllIlIIIIIllIlllll[1], llllllllllllllIllIlIIIIIllIlllll[2], 0.0f);
                for (int llllllllllllllIllIlIIIIIllIlIIII = 0; llllllllllllllIllIlIIIIIllIlIIII <= 16; ++llllllllllllllIllIlIIIIIllIlIIII) {
                    final float llllllllllllllIllIlIIIIIllIlIIlI = llllllllllllllIllIlIIIIIllIlIIII * 3.1415927f * 2.0f / 16.0f;
                    final float llllllllllllllIllIlIIIIIllIIlllI = MathHelper.sin(llllllllllllllIllIlIIIIIllIlIIlI);
                    final float llllllllllllllIllIlIIIIIllIIllII = MathHelper.cos(llllllllllllllIllIlIIIIIllIlIIlI);
                    llllllllllllllIllIlIIIIIlllIIIII.addVertex(llllllllllllllIllIlIIIIIllIIlllI * 120.0f, llllllllllllllIllIlIIIIIllIIllII * 120.0f, -llllllllllllllIllIlIIIIIllIIllII * 40.0f * llllllllllllllIllIlIIIIIllIlllll[3]);
                }
                llllllllllllllIllIlIIIIIlllIIIIl.draw();
                GlStateManager.popMatrix();
                GlStateManager.shadeModel(7424);
            }
            GlStateManager.func_179098_w();
            if (llllllllllllllIllIlIIIIIlllIlIIl) {
                Shaders.enableTexture2D();
            }
            GlStateManager.tryBlendFuncSeparate(770, 1, 1, 0);
            GlStateManager.pushMatrix();
            final float llllllllllllllIllIlIIIIIllIlllIl = 1.0f - this.theWorld.getRainStrength(llllllllllllllIllIlIIIIIllIIIIll);
            final float llllllllllllllIllIlIIIIIllIllIll = 0.0f;
            float llllllllllllllIllIlIIIIIllIllIIl = 0.0f;
            float llllllllllllllIllIlIIIIIllIlIlll = 0.0f;
            GlStateManager.color(1.0f, 1.0f, 1.0f, llllllllllllllIllIlIIIIIllIlllIl);
            GlStateManager.translate(0.0f, 0.0f, 0.0f);
            GlStateManager.rotate(-90.0f, 0.0f, 1.0f, 0.0f);
            CustomSky.renderSky(this.theWorld, this.renderEngine, this.theWorld.getCelestialAngle(llllllllllllllIllIlIIIIIllIIIIll), llllllllllllllIllIlIIIIIllIlllIl);
            if (llllllllllllllIllIlIIIIIlllIlIIl) {
                Shaders.preCelestialRotate();
            }
            GlStateManager.rotate(this.theWorld.getCelestialAngle(llllllllllllllIllIlIIIIIllIIIIll) * 360.0f, 1.0f, 0.0f, 0.0f);
            if (llllllllllllllIllIlIIIIIlllIlIIl) {
                Shaders.postCelestialRotate();
            }
            if (Config.isSunMoonEnabled()) {
                float llllllllllllllIllIlIIIIIllIlIlIl = 30.0f;
                this.renderEngine.bindTexture(RenderGlobal.locationSunPng);
                llllllllllllllIllIlIIIIIlllIIIII.startDrawingQuads();
                llllllllllllllIllIlIIIIIlllIIIII.addVertexWithUV(-llllllllllllllIllIlIIIIIllIlIlIl, 100.0, -llllllllllllllIllIlIIIIIllIlIlIl, 0.0, 0.0);
                llllllllllllllIllIlIIIIIlllIIIII.addVertexWithUV(llllllllllllllIllIlIIIIIllIlIlIl, 100.0, -llllllllllllllIllIlIIIIIllIlIlIl, 1.0, 0.0);
                llllllllllllllIllIlIIIIIlllIIIII.addVertexWithUV(llllllllllllllIllIlIIIIIllIlIlIl, 100.0, llllllllllllllIllIlIIIIIllIlIlIl, 1.0, 1.0);
                llllllllllllllIllIlIIIIIlllIIIII.addVertexWithUV(-llllllllllllllIllIlIIIIIllIlIlIl, 100.0, llllllllllllllIllIlIIIIIllIlIlIl, 0.0, 1.0);
                llllllllllllllIllIlIIIIIlllIIIIl.draw();
                llllllllllllllIllIlIIIIIllIlIlIl = 20.0f;
                this.renderEngine.bindTexture(RenderGlobal.locationMoonPhasesPng);
                final int llllllllllllllIllIlIIIIIllIIlIIl = this.theWorld.getMoonPhase();
                final int llllllllllllllIllIlIIIIIllIIlIII = llllllllllllllIllIlIIIIIllIIlIIl % 4;
                final int llllllllllllllIllIlIIIIIllIIllll = llllllllllllllIllIlIIIIIllIIlIIl / 4 % 2;
                final float llllllllllllllIllIlIIIIIllIIllIl = (llllllllllllllIllIlIIIIIllIIlIII + 0) / 4.0f;
                final float llllllllllllllIllIlIIIIIllIIlIll = (llllllllllllllIllIlIIIIIllIIllll + 0) / 2.0f;
                final float llllllllllllllIllIlIIIIIllIIIlll = (llllllllllllllIllIlIIIIIllIIlIII + 1) / 4.0f;
                final float llllllllllllllIllIlIIIIIllIIIllI = (llllllllllllllIllIlIIIIIllIIllll + 1) / 2.0f;
                llllllllllllllIllIlIIIIIlllIIIII.startDrawingQuads();
                llllllllllllllIllIlIIIIIlllIIIII.addVertexWithUV(-llllllllllllllIllIlIIIIIllIlIlIl, -100.0, llllllllllllllIllIlIIIIIllIlIlIl, llllllllllllllIllIlIIIIIllIIIlll, llllllllllllllIllIlIIIIIllIIIllI);
                llllllllllllllIllIlIIIIIlllIIIII.addVertexWithUV(llllllllllllllIllIlIIIIIllIlIlIl, -100.0, llllllllllllllIllIlIIIIIllIlIlIl, llllllllllllllIllIlIIIIIllIIllIl, llllllllllllllIllIlIIIIIllIIIllI);
                llllllllllllllIllIlIIIIIlllIIIII.addVertexWithUV(llllllllllllllIllIlIIIIIllIlIlIl, -100.0, -llllllllllllllIllIlIIIIIllIlIlIl, llllllllllllllIllIlIIIIIllIIllIl, llllllllllllllIllIlIIIIIllIIlIll);
                llllllllllllllIllIlIIIIIlllIIIII.addVertexWithUV(-llllllllllllllIllIlIIIIIllIlIlIl, -100.0, -llllllllllllllIllIlIIIIIllIlIlIl, llllllllllllllIllIlIIIIIllIIIlll, llllllllllllllIllIlIIIIIllIIlIll);
                llllllllllllllIllIlIIIIIlllIIIIl.draw();
            }
            GlStateManager.func_179090_x();
            if (llllllllllllllIllIlIIIIIlllIlIIl) {
                Shaders.disableTexture2D();
            }
            final float llllllllllllllIllIlIIIIIllIlIIIl = this.theWorld.getStarBrightness(llllllllllllllIllIlIIIIIllIIIIll) * llllllllllllllIllIlIIIIIllIlllIl;
            if (llllllllllllllIllIlIIIIIllIlIIIl > 0.0f && Config.isStarsEnabled() && !CustomSky.hasSkyLayers(this.theWorld)) {
                GlStateManager.color(llllllllllllllIllIlIIIIIllIlIIIl, llllllllllllllIllIlIIIIIllIlIIIl, llllllllllllllIllIlIIIIIllIlIIIl, llllllllllllllIllIlIIIIIllIlIIIl);
                if (this.field_175005_X) {
                    this.field_175013_s.func_177359_a();
                    GL11.glEnableClientState(32884);
                    GL11.glVertexPointer(3, 5126, 12, 0L);
                    this.field_175013_s.func_177358_a(7);
                    this.field_175013_s.func_177361_b();
                    GL11.glDisableClientState(32884);
                }
                else {
                    GlStateManager.callList(this.starGLCallList);
                }
            }
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.disableBlend();
            GlStateManager.enableAlpha();
            GlStateManager.enableFog();
            if (llllllllllllllIllIlIIIIIlllIlIIl) {
                Shaders.enableFog();
            }
            GlStateManager.popMatrix();
            GlStateManager.func_179090_x();
            if (llllllllllllllIllIlIIIIIlllIlIIl) {
                Shaders.disableTexture2D();
            }
            GlStateManager.color(0.0f, 0.0f, 0.0f);
            final double llllllllllllllIllIlIIIIIllIIIlIl = this.mc.thePlayer.func_174824_e(llllllllllllllIllIlIIIIIllIIIIll).yCoord - this.theWorld.getHorizon();
            if (llllllllllllllIllIlIIIIIllIIIlIl < 0.0) {
                GlStateManager.pushMatrix();
                GlStateManager.translate(0.0f, 12.0f, 0.0f);
                if (this.field_175005_X) {
                    this.field_175011_u.func_177359_a();
                    GL11.glEnableClientState(32884);
                    GL11.glVertexPointer(3, 5126, 12, 0L);
                    this.field_175011_u.func_177358_a(7);
                    this.field_175011_u.func_177361_b();
                    GL11.glDisableClientState(32884);
                }
                else {
                    GlStateManager.callList(this.glSkyList2);
                }
                GlStateManager.popMatrix();
                llllllllllllllIllIlIIIIIllIllIIl = 1.0f;
                llllllllllllllIllIlIIIIIllIlIlll = -(float)(llllllllllllllIllIlIIIIIllIIIlIl + 65.0);
                final float llllllllllllllIllIlIIIIIllIlIlII = -1.0f;
                llllllllllllllIllIlIIIIIlllIIIII.startDrawingQuads();
                llllllllllllllIllIlIIIIIlllIIIII.func_178974_a(0, 255);
                llllllllllllllIllIlIIIIIlllIIIII.addVertex(-1.0, llllllllllllllIllIlIIIIIllIlIlll, 1.0);
                llllllllllllllIllIlIIIIIlllIIIII.addVertex(1.0, llllllllllllllIllIlIIIIIllIlIlll, 1.0);
                llllllllllllllIllIlIIIIIlllIIIII.addVertex(1.0, -1.0, 1.0);
                llllllllllllllIllIlIIIIIlllIIIII.addVertex(-1.0, -1.0, 1.0);
                llllllllllllllIllIlIIIIIlllIIIII.addVertex(-1.0, -1.0, -1.0);
                llllllllllllllIllIlIIIIIlllIIIII.addVertex(1.0, -1.0, -1.0);
                llllllllllllllIllIlIIIIIlllIIIII.addVertex(1.0, llllllllllllllIllIlIIIIIllIlIlll, -1.0);
                llllllllllllllIllIlIIIIIlllIIIII.addVertex(-1.0, llllllllllllllIllIlIIIIIllIlIlll, -1.0);
                llllllllllllllIllIlIIIIIlllIIIII.addVertex(1.0, -1.0, -1.0);
                llllllllllllllIllIlIIIIIlllIIIII.addVertex(1.0, -1.0, 1.0);
                llllllllllllllIllIlIIIIIlllIIIII.addVertex(1.0, llllllllllllllIllIlIIIIIllIlIlll, 1.0);
                llllllllllllllIllIlIIIIIlllIIIII.addVertex(1.0, llllllllllllllIllIlIIIIIllIlIlll, -1.0);
                llllllllllllllIllIlIIIIIlllIIIII.addVertex(-1.0, llllllllllllllIllIlIIIIIllIlIlll, -1.0);
                llllllllllllllIllIlIIIIIlllIIIII.addVertex(-1.0, llllllllllllllIllIlIIIIIllIlIlll, 1.0);
                llllllllllllllIllIlIIIIIlllIIIII.addVertex(-1.0, -1.0, 1.0);
                llllllllllllllIllIlIIIIIlllIIIII.addVertex(-1.0, -1.0, -1.0);
                llllllllllllllIllIlIIIIIlllIIIII.addVertex(-1.0, -1.0, -1.0);
                llllllllllllllIllIlIIIIIlllIIIII.addVertex(-1.0, -1.0, 1.0);
                llllllllllllllIllIlIIIIIlllIIIII.addVertex(1.0, -1.0, 1.0);
                llllllllllllllIllIlIIIIIlllIIIII.addVertex(1.0, -1.0, -1.0);
                llllllllllllllIllIlIIIIIlllIIIIl.draw();
            }
            if (this.theWorld.provider.isSkyColored()) {
                GlStateManager.color(llllllllllllllIllIlIIIIIlllIIlll * 0.2f + 0.04f, llllllllllllllIllIlIIIIIlllIIllI * 0.2f + 0.04f, llllllllllllllIllIlIIIIIlllIIlIl * 0.6f + 0.1f);
            }
            else {
                GlStateManager.color(llllllllllllllIllIlIIIIIlllIIlll, llllllllllllllIllIlIIIIIlllIIllI, llllllllllllllIllIlIIIIIlllIIlIl);
            }
            if (this.mc.gameSettings.renderDistanceChunks <= 4) {
                GlStateManager.color(this.mc.entityRenderer.field_175080_Q, this.mc.entityRenderer.field_175082_R, this.mc.entityRenderer.field_175081_S);
            }
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, -(float)(llllllllllllllIllIlIIIIIllIIIlIl - 16.0), 0.0f);
            if (Config.isSkyEnabled()) {
                GlStateManager.callList(this.glSkyList2);
            }
            GlStateManager.popMatrix();
            GlStateManager.func_179098_w();
            if (llllllllllllllIllIlIIIIIlllIlIIl) {
                Shaders.enableTexture2D();
            }
            GlStateManager.depthMask(true);
        }
    }
    
    @Override
    public void notifyLightSet(final BlockPos llllllllllllllIllIIllllIlllIIllI) {
        final int llllllllllllllIllIIllllIlllIIlIl = llllllllllllllIllIIllllIlllIIllI.getX();
        final int llllllllllllllIllIIllllIlllIIlII = llllllllllllllIllIIllllIlllIIllI.getY();
        final int llllllllllllllIllIIllllIlllIIIll = llllllllllllllIllIIllllIlllIIllI.getZ();
        this.markBlocksForUpdate(llllllllllllllIllIIllllIlllIIlIl - 1, llllllllllllllIllIIllllIlllIIlII - 1, llllllllllllllIllIIllllIlllIIIll - 1, llllllllllllllIllIIllllIlllIIlIl + 1, llllllllllllllIllIIllllIlllIIlII + 1, llllllllllllllIllIIllllIlllIIIll + 1);
    }
    
    public void resetClouds() {
        this.cloudRenderer.reset();
    }
    
    protected Vector3f func_174962_a(final Entity llllllllllllllIllIlIIIIlIllIlIII, final double llllllllllllllIllIlIIIIlIllIIlll) {
        float llllllllllllllIllIlIIIIlIllIlllI = (float)(llllllllllllllIllIlIIIIlIllIlIII.prevRotationPitch + (llllllllllllllIllIlIIIIlIllIlIII.rotationPitch - llllllllllllllIllIlIIIIlIllIlIII.prevRotationPitch) * llllllllllllllIllIlIIIIlIllIIlll);
        final float llllllllllllllIllIlIIIIlIllIllIl = (float)(llllllllllllllIllIlIIIIlIllIlIII.prevRotationYaw + (llllllllllllllIllIlIIIIlIllIlIII.rotationYaw - llllllllllllllIllIlIIIIlIllIlIII.prevRotationYaw) * llllllllllllllIllIlIIIIlIllIIlll);
        if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 2) {
            llllllllllllllIllIlIIIIlIllIlllI += 180.0f;
        }
        final float llllllllllllllIllIlIIIIlIllIllII = MathHelper.cos(-llllllllllllllIllIlIIIIlIllIllIl * 0.017453292f - 3.1415927f);
        final float llllllllllllllIllIlIIIIlIllIlIll = MathHelper.sin(-llllllllllllllIllIlIIIIlIllIllIl * 0.017453292f - 3.1415927f);
        final float llllllllllllllIllIlIIIIlIllIlIlI = -MathHelper.cos(-llllllllllllllIllIlIIIIlIllIlllI * 0.017453292f);
        final float llllllllllllllIllIlIIIIlIllIlIIl = MathHelper.sin(-llllllllllllllIllIlIIIIlIllIlllI * 0.017453292f);
        return new Vector3f(llllllllllllllIllIlIIIIlIllIlIll * llllllllllllllIllIlIIIIlIllIlIlI, llllllllllllllIllIlIIIIlIllIlIIl, llllllllllllllIllIlIIIIlIllIllII * llllllllllllllIllIlIIIIlIllIlIlI);
    }
    
    @Override
    public void func_180442_a(final int llllllllllllllIllIIllllIlIIIlIIl, final boolean llllllllllllllIllIIllllIlIIIlIII, final double llllllllllllllIllIIllllIlIIlIlII, final double llllllllllllllIllIIllllIlIIlIIll, final double llllllllllllllIllIIllllIlIIIIlIl, final double llllllllllllllIllIIllllIlIIlIIIl, final double llllllllllllllIllIIllllIlIIlIIII, final double llllllllllllllIllIIllllIlIIIIIlI, final int... llllllllllllllIllIIllllIlIIIlllI) {
        try {
            this.func_174974_b(llllllllllllllIllIIllllIlIIIlIIl, llllllllllllllIllIIllllIlIIIlIII, llllllllllllllIllIIllllIlIIlIlII, llllllllllllllIllIIllllIlIIlIIll, llllllllllllllIllIIllllIlIIIIlIl, llllllllllllllIllIIllllIlIIlIIIl, llllllllllllllIllIIllllIlIIlIIII, llllllllllllllIllIIllllIlIIIIIlI, llllllllllllllIllIIllllIlIIIlllI);
        }
        catch (Throwable llllllllllllllIllIIllllIlIIIllIl) {
            final CrashReport llllllllllllllIllIIllllIlIIIllII = CrashReport.makeCrashReport(llllllllllllllIllIIllllIlIIIllIl, "Exception while adding particle");
            final CrashReportCategory llllllllllllllIllIIllllIlIIIlIll = llllllllllllllIllIIllllIlIIIllII.makeCategory("Particle being added");
            llllllllllllllIllIIllllIlIIIlIll.addCrashSection("ID", llllllllllllllIllIIllllIlIIIlIIl);
            if (llllllllllllllIllIIllllIlIIIlllI != null) {
                llllllllllllllIllIIllllIlIIIlIll.addCrashSection("Parameters", llllllllllllllIllIIllllIlIIIlllI);
            }
            llllllllllllllIllIIllllIlIIIlIll.addCrashSectionCallable("Position", new Callable() {
                @Override
                public String call() {
                    return CrashReportCategory.getCoordinateInfo(llllllllllllllIllIIllllIlIIlIlII, llllllllllllllIllIIllllIlIIlIIll, llllllllllllllIllIIllllIlIIIIlIl);
                }
            });
            throw new ReportedException(llllllllllllllIllIIllllIlIIIllII);
        }
    }
    
    private void func_180448_r() {
        if (Config.isSkyEnabled()) {
            GlStateManager.disableFog();
            GlStateManager.disableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            RenderHelper.disableStandardItemLighting();
            GlStateManager.depthMask(false);
            this.renderEngine.bindTexture(RenderGlobal.locationEndSkyPng);
            final Tessellator llllllllllllllIllIlIIIIlIIIIllIl = Tessellator.getInstance();
            final WorldRenderer llllllllllllllIllIlIIIIlIIIIllII = llllllllllllllIllIlIIIIlIIIIllIl.getWorldRenderer();
            for (int llllllllllllllIllIlIIIIlIIIIlIll = 0; llllllllllllllIllIlIIIIlIIIIlIll < 6; ++llllllllllllllIllIlIIIIlIIIIlIll) {
                GlStateManager.pushMatrix();
                if (llllllllllllllIllIlIIIIlIIIIlIll == 1) {
                    GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                }
                if (llllllllllllllIllIlIIIIlIIIIlIll == 2) {
                    GlStateManager.rotate(-90.0f, 1.0f, 0.0f, 0.0f);
                }
                if (llllllllllllllIllIlIIIIlIIIIlIll == 3) {
                    GlStateManager.rotate(180.0f, 1.0f, 0.0f, 0.0f);
                }
                if (llllllllllllllIllIlIIIIlIIIIlIll == 4) {
                    GlStateManager.rotate(90.0f, 0.0f, 0.0f, 1.0f);
                }
                if (llllllllllllllIllIlIIIIlIIIIlIll == 5) {
                    GlStateManager.rotate(-90.0f, 0.0f, 0.0f, 1.0f);
                }
                llllllllllllllIllIlIIIIlIIIIllII.startDrawingQuads();
                llllllllllllllIllIlIIIIlIIIIllII.func_178991_c(2631720);
                llllllllllllllIllIlIIIIlIIIIllII.addVertexWithUV(-100.0, -100.0, -100.0, 0.0, 0.0);
                llllllllllllllIllIlIIIIlIIIIllII.addVertexWithUV(-100.0, -100.0, 100.0, 0.0, 16.0);
                llllllllllllllIllIlIIIIlIIIIllII.addVertexWithUV(100.0, -100.0, 100.0, 16.0, 16.0);
                llllllllllllllIllIlIIIIlIIIIllII.addVertexWithUV(100.0, -100.0, -100.0, 16.0, 0.0);
                llllllllllllllIllIlIIIIlIIIIllIl.draw();
                GlStateManager.popMatrix();
            }
            GlStateManager.depthMask(true);
            GlStateManager.func_179098_w();
            GlStateManager.enableAlpha();
        }
    }
    
    public int getCountTileEntitiesRendered() {
        return this.countTileEntitiesRendered;
    }
    
    public String getDebugInfoRenders() {
        final int llllllllllllllIllIlIIIlIIIllllII = this.field_175008_n.field_178164_f.length;
        int llllllllllllllIllIlIIIlIIIlllIll = 0;
        for (final ContainerLocalRenderInformation llllllllllllllIllIlIIIlIIIlllIIl : this.glRenderLists) {
            final CompiledChunk llllllllllllllIllIlIIIlIIIlllIII = llllllllllllllIllIlIIIlIIIlllIIl.field_178036_a.field_178590_b;
            if (llllllllllllllIllIlIIIlIIIlllIII != CompiledChunk.field_178502_a && !llllllllllllllIllIlIIIlIIIlllIII.func_178489_a()) {
                ++llllllllllllllIllIlIIIlIIIlllIll;
            }
        }
        return String.format("C: %d/%d %sD: %d, %s", llllllllllllllIllIlIIIlIIIlllIll, llllllllllllllIllIlIIIlIIIllllII, this.mc.field_175612_E ? "(s) " : "", this.renderDistanceChunks, this.field_174995_M.func_178504_a());
    }
    
    public RenderGlobal(final Minecraft llllllllllllllIllIlIIIllIlllIllI) {
        this.field_175009_l = Sets.newLinkedHashSet();
        this.glRenderLists = Lists.newArrayListWithCapacity(69696);
        this.starGLCallList = -1;
        this.glSkyList = -1;
        this.glSkyList2 = -1;
        this.damagedBlocks = Maps.newHashMap();
        this.mapSoundPositions = Maps.newHashMap();
        this.destroyBlockIcons = new TextureAtlasSprite[10];
        this.field_174992_B = Double.MIN_VALUE;
        this.field_174993_C = Double.MIN_VALUE;
        this.field_174987_D = Double.MIN_VALUE;
        this.field_174988_E = Integer.MIN_VALUE;
        this.field_174989_F = Integer.MIN_VALUE;
        this.field_174990_G = Integer.MIN_VALUE;
        this.field_174997_H = Double.MIN_VALUE;
        this.field_174998_I = Double.MIN_VALUE;
        this.field_174999_J = Double.MIN_VALUE;
        this.field_175000_K = Double.MIN_VALUE;
        this.field_174994_L = Double.MIN_VALUE;
        this.field_174995_M = new ChunkRenderDispatcher();
        this.renderDistanceChunks = -1;
        this.renderEntitiesStartupCounter = 2;
        this.field_175002_T = false;
        this.field_175004_V = new Vector4f[8];
        this.field_175003_W = new Vector3d();
        this.field_175005_X = false;
        this.displayListEntitiesDirty = true;
        this.chunksToResortTransparency = new LinkedHashSet();
        this.chunksToUpdateForced = new LinkedHashSet();
        this.visibilityDeque = new ArrayDeque();
        this.renderInfosEntities = new ArrayList(1024);
        this.renderInfosTileEntities = new ArrayList(1024);
        this.renderInfosNormal = new ArrayList(1024);
        this.renderInfosEntitiesNormal = new ArrayList(1024);
        this.renderInfosTileEntitiesNormal = new ArrayList(1024);
        this.renderInfosShadow = new ArrayList(1024);
        this.renderInfosEntitiesShadow = new ArrayList(1024);
        this.renderInfosTileEntitiesShadow = new ArrayList(1024);
        this.renderDistance = 0;
        this.renderDistanceSq = 0;
        this.cloudRenderer = new CloudRenderer(llllllllllllllIllIlIIIllIlllIllI);
        this.mc = llllllllllllllIllIlIIIllIlllIllI;
        this.field_175010_j = llllllllllllllIllIlIIIllIlllIllI.getRenderManager();
        this.renderEngine = llllllllllllllIllIlIIIllIlllIllI.getTextureManager();
        this.renderEngine.bindTexture(RenderGlobal.field_175006_g);
        GL11.glTexParameteri(3553, 10242, 10497);
        GL11.glTexParameteri(3553, 10243, 10497);
        GlStateManager.func_179144_i(0);
        this.func_174971_n();
        this.field_175005_X = OpenGlHelper.func_176075_f();
        if (this.field_175005_X) {
            this.field_174996_N = new VboRenderList();
            this.field_175007_a = new VboChunkFactory();
        }
        else {
            this.field_174996_N = new RenderList();
            this.field_175007_a = new ListChunkFactory();
        }
        this.field_175014_r = new VertexFormat();
        this.field_175014_r.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUseage.POSITION, 3));
        this.func_174963_q();
        this.func_174980_p();
        this.func_174964_o();
    }
    
    public void func_174966_b() {
        if (OpenGlHelper.shadersSupported) {
            if (ShaderLinkHelper.getStaticShaderLinkHelper() == null) {
                ShaderLinkHelper.setNewStaticShaderLinkHelper();
            }
            final ResourceLocation llllllllllllllIllIlIIIllIllIIlII = new ResourceLocation("shaders/post/entity_outline.json");
            try {
                this.field_174991_A = new ShaderGroup(this.mc.getTextureManager(), this.mc.getResourceManager(), this.mc.getFramebuffer(), llllllllllllllIllIlIIIllIllIIlII);
                this.field_174991_A.createBindFramebuffers(this.mc.displayWidth, this.mc.displayHeight);
                this.field_175015_z = this.field_174991_A.func_177066_a("final");
            }
            catch (IOException llllllllllllllIllIlIIIllIllIIIll) {
                RenderGlobal.logger.warn(String.valueOf(new StringBuilder("Failed to load shader: ").append(llllllllllllllIllIlIIIllIllIIlII)), (Throwable)llllllllllllllIllIlIIIllIllIIIll);
                this.field_174991_A = null;
                this.field_175015_z = null;
            }
            catch (JsonSyntaxException llllllllllllllIllIlIIIllIllIIIlI) {
                RenderGlobal.logger.warn(String.valueOf(new StringBuilder("Failed to load shader: ").append(llllllllllllllIllIlIIIllIllIIlII)), (Throwable)llllllllllllllIllIlIIIllIllIIIlI);
                this.field_174991_A = null;
                this.field_175015_z = null;
            }
        }
        else {
            this.field_174991_A = null;
            this.field_175015_z = null;
        }
    }
    
    public RenderChunk getRenderChunk(final RenderChunk llllllllllllllIllIIlllIlIlllIIII, final EnumFacing llllllllllllllIllIIlllIlIllIllll) {
        if (llllllllllllllIllIIlllIlIlllIIII == null) {
            return null;
        }
        final BlockPos llllllllllllllIllIIlllIlIlllIIlI = llllllllllllllIllIIlllIlIlllIIII.getPositionOffset16(llllllllllllllIllIIlllIlIllIllll);
        return this.field_175008_n.func_178161_a(llllllllllllllIllIIlllIlIlllIIlI);
    }
    
    private void markBlocksForUpdate(final int llllllllllllllIllIIlllllIIIIlIII, final int llllllllllllllIllIIlllllIIIIIIII, final int llllllllllllllIllIIlllllIIIIIllI, final int llllllllllllllIllIIlllllIIIIIlIl, final int llllllllllllllIllIIllllIllllllIl, final int llllllllllllllIllIIllllIllllllII) {
        this.field_175008_n.func_178162_a(llllllllllllllIllIIlllllIIIIlIII, llllllllllllllIllIIlllllIIIIIIII, llllllllllllllIllIIlllllIIIIIllI, llllllllllllllIllIIlllllIIIIIlIl, llllllllllllllIllIIllllIllllllIl, llllllllllllllIllIIllllIllllllII);
    }
    
    @Override
    public void func_180439_a(final EntityPlayer llllllllllllllIllIIlllIllllIIlll, final int llllllllllllllIllIIlllIllllIIllI, final BlockPos llllllllllllllIllIIlllIllllIIlIl, final int llllllllllllllIllIIlllIllIlllIII) {
        final Random llllllllllllllIllIIlllIllllIIIll = this.theWorld.rand;
        switch (llllllllllllllIllIIlllIllllIIllI) {
            case 1000: {
                this.theWorld.func_175731_a(llllllllllllllIllIIlllIllllIIlIl, "random.click", 1.0f, 1.0f, false);
                break;
            }
            case 1001: {
                this.theWorld.func_175731_a(llllllllllllllIllIIlllIllllIIlIl, "random.click", 1.0f, 1.2f, false);
                break;
            }
            case 1002: {
                this.theWorld.func_175731_a(llllllllllllllIllIIlllIllllIIlIl, "random.bow", 1.0f, 1.2f, false);
                break;
            }
            case 1003: {
                this.theWorld.func_175731_a(llllllllllllllIllIIlllIllllIIlIl, "random.door_open", 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1004: {
                this.theWorld.func_175731_a(llllllllllllllIllIIlllIllllIIlIl, "random.fizz", 0.5f, 2.6f + (llllllllllllllIllIIlllIllllIIIll.nextFloat() - llllllllllllllIllIIlllIllllIIIll.nextFloat()) * 0.8f, false);
                break;
            }
            case 1005: {
                if (Item.getItemById(llllllllllllllIllIIlllIllIlllIII) instanceof ItemRecord) {
                    this.theWorld.func_175717_a(llllllllllllllIllIIlllIllllIIlIl, String.valueOf(new StringBuilder("records.").append(((ItemRecord)Item.getItemById(llllllllllllllIllIIlllIllIlllIII)).recordName)));
                    break;
                }
                this.theWorld.func_175717_a(llllllllllllllIllIIlllIllllIIlIl, null);
                break;
            }
            case 1006: {
                this.theWorld.func_175731_a(llllllllllllllIllIIlllIllllIIlIl, "random.door_close", 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1007: {
                this.theWorld.func_175731_a(llllllllllllllIllIIlllIllllIIlIl, "mob.ghast.charge", 10.0f, (llllllllllllllIllIIlllIllllIIIll.nextFloat() - llllllllllllllIllIIlllIllllIIIll.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1008: {
                this.theWorld.func_175731_a(llllllllllllllIllIIlllIllllIIlIl, "mob.ghast.fireball", 10.0f, (llllllllllllllIllIIlllIllllIIIll.nextFloat() - llllllllllllllIllIIlllIllllIIIll.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1009: {
                this.theWorld.func_175731_a(llllllllllllllIllIIlllIllllIIlIl, "mob.ghast.fireball", 2.0f, (llllllllllllllIllIIlllIllllIIIll.nextFloat() - llllllllllllllIllIIlllIllllIIIll.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1010: {
                this.theWorld.func_175731_a(llllllllllllllIllIIlllIllllIIlIl, "mob.zombie.wood", 2.0f, (llllllllllllllIllIIlllIllllIIIll.nextFloat() - llllllllllllllIllIIlllIllllIIIll.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1011: {
                this.theWorld.func_175731_a(llllllllllllllIllIIlllIllllIIlIl, "mob.zombie.metal", 2.0f, (llllllllllllllIllIIlllIllllIIIll.nextFloat() - llllllllllllllIllIIlllIllllIIIll.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1012: {
                this.theWorld.func_175731_a(llllllllllllllIllIIlllIllllIIlIl, "mob.zombie.woodbreak", 2.0f, (llllllllllllllIllIIlllIllllIIIll.nextFloat() - llllllllllllllIllIIlllIllllIIIll.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1014: {
                this.theWorld.func_175731_a(llllllllllllllIllIIlllIllllIIlIl, "mob.wither.shoot", 2.0f, (llllllllllllllIllIIlllIllllIIIll.nextFloat() - llllllllllllllIllIIlllIllllIIIll.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1015: {
                this.theWorld.func_175731_a(llllllllllllllIllIIlllIllllIIlIl, "mob.bat.takeoff", 0.05f, (llllllllllllllIllIIlllIllllIIIll.nextFloat() - llllllllllllllIllIIlllIllllIIIll.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1016: {
                this.theWorld.func_175731_a(llllllllllllllIllIIlllIllllIIlIl, "mob.zombie.infect", 2.0f, (llllllllllllllIllIIlllIllllIIIll.nextFloat() - llllllllllllllIllIIlllIllllIIIll.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1017: {
                this.theWorld.func_175731_a(llllllllllllllIllIIlllIllllIIlIl, "mob.zombie.unfect", 2.0f, (llllllllllllllIllIIlllIllllIIIll.nextFloat() - llllllllllllllIllIIlllIllllIIIll.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1020: {
                this.theWorld.func_175731_a(llllllllllllllIllIIlllIllllIIlIl, "random.anvil_break", 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1021: {
                this.theWorld.func_175731_a(llllllllllllllIllIIlllIllllIIlIl, "random.anvil_use", 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1022: {
                this.theWorld.func_175731_a(llllllllllllllIllIIlllIllllIIlIl, "random.anvil_land", 0.3f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 2000: {
                final int llllllllllllllIllIIlllIlllIIlIlI = llllllllllllllIllIIlllIllIlllIII % 3 - 1;
                final int llllllllllllllIllIIlllIlllIIlIIl = llllllllllllllIllIIlllIllIlllIII / 3 % 3 - 1;
                final double llllllllllllllIllIIlllIllllIIIII = llllllllllllllIllIIlllIllllIIlIl.getX() + llllllllllllllIllIIlllIlllIIlIlI * 0.6 + 0.5;
                final double llllllllllllllIllIIlllIlllIlllIl = llllllllllllllIllIIlllIllllIIlIl.getY() + 0.5;
                final double llllllllllllllIllIIlllIlllIlIIII = llllllllllllllIllIIlllIllllIIlIl.getZ() + llllllllllllllIllIIlllIlllIIlIIl * 0.6 + 0.5;
                for (int llllllllllllllIllIIlllIlllIIlIII = 0; llllllllllllllIllIIlllIlllIIlIII < 10; ++llllllllllllllIllIIlllIlllIIlIII) {
                    final double llllllllllllllIllIIlllIlllIIIlll = llllllllllllllIllIIlllIllllIIIll.nextDouble() * 0.2 + 0.01;
                    final double llllllllllllllIllIIlllIlllIIIllI = llllllllllllllIllIIlllIllllIIIII + llllllllllllllIllIIlllIlllIIlIlI * 0.01 + (llllllllllllllIllIIlllIllllIIIll.nextDouble() - 0.5) * llllllllllllllIllIIlllIlllIIlIIl * 0.5;
                    final double llllllllllllllIllIIlllIlllIIlllI = llllllllllllllIllIIlllIlllIlllIl + (llllllllllllllIllIIlllIllllIIIll.nextDouble() - 0.5) * 0.5;
                    final double llllllllllllllIllIIlllIlllIIllII = llllllllllllllIllIIlllIlllIlIIII + llllllllllllllIllIIlllIlllIIlIIl * 0.01 + (llllllllllllllIllIIlllIllllIIIll.nextDouble() - 0.5) * llllllllllllllIllIIlllIlllIIlIlI * 0.5;
                    final double llllllllllllllIllIIlllIlllIIIlIl = llllllllllllllIllIIlllIlllIIlIlI * llllllllllllllIllIIlllIlllIIIlll + llllllllllllllIllIIlllIllllIIIll.nextGaussian() * 0.01;
                    final double llllllllllllllIllIIlllIlllIIIlII = -0.03 + llllllllllllllIllIIlllIllllIIIll.nextGaussian() * 0.01;
                    final double llllllllllllllIllIIlllIlllIIIIll = llllllllllllllIllIIlllIlllIIlIIl * llllllllllllllIllIIlllIlllIIIlll + llllllllllllllIllIIlllIllllIIIll.nextGaussian() * 0.01;
                    this.func_174972_a(EnumParticleTypes.SMOKE_NORMAL, llllllllllllllIllIIlllIlllIIIllI, llllllllllllllIllIIlllIlllIIlllI, llllllllllllllIllIIlllIlllIIllII, llllllllllllllIllIIlllIlllIIIlIl, llllllllllllllIllIIlllIlllIIIlII, llllllllllllllIllIIlllIlllIIIIll, new int[0]);
                }
            }
            case 2001: {
                final Block llllllllllllllIllIIlllIlllIIIIlI = Block.getBlockById(llllllllllllllIllIIlllIllIlllIII & 0xFFF);
                if (llllllllllllllIllIIlllIlllIIIIlI.getMaterial() != Material.air) {
                    this.mc.getSoundHandler().playSound(new PositionedSoundRecord(new ResourceLocation(llllllllllllllIllIIlllIlllIIIIlI.stepSound.getBreakSound()), (llllllllllllllIllIIlllIlllIIIIlI.stepSound.getVolume() + 1.0f) / 2.0f, llllllllllllllIllIIlllIlllIIIIlI.stepSound.getFrequency() * 0.8f, llllllllllllllIllIIlllIllllIIlIl.getX() + 0.5f, llllllllllllllIllIIlllIllllIIlIl.getY() + 0.5f, llllllllllllllIllIIlllIllllIIlIl.getZ() + 0.5f));
                }
                this.mc.effectRenderer.func_180533_a(llllllllllllllIllIIlllIllllIIlIl, llllllllllllllIllIIlllIlllIIIIlI.getStateFromMeta(llllllllllllllIllIIlllIllIlllIII >> 12 & 0xFF));
                break;
            }
            case 2002: {
                final double llllllllllllllIllIIlllIllllIIIlI = llllllllllllllIllIIlllIllllIIlIl.getX();
                final double llllllllllllllIllIIlllIlllIlllll = llllllllllllllIllIIlllIllllIIlIl.getY();
                final double llllllllllllllIllIIlllIlllIlllII = llllllllllllllIllIIlllIllllIIlIl.getZ();
                for (int llllllllllllllIllIIlllIlllIllIlI = 0; llllllllllllllIllIIlllIlllIllIlI < 8; ++llllllllllllllIllIIlllIlllIllIlI) {
                    this.func_174972_a(EnumParticleTypes.ITEM_CRACK, llllllllllllllIllIIlllIllllIIIlI, llllllllllllllIllIIlllIlllIlllll, llllllllllllllIllIIlllIlllIlllII, llllllllllllllIllIIlllIllllIIIll.nextGaussian() * 0.15, llllllllllllllIllIIlllIllllIIIll.nextDouble() * 0.2, llllllllllllllIllIIlllIllllIIIll.nextGaussian() * 0.15, Item.getIdFromItem(Items.potionitem), llllllllllllllIllIIlllIllIlllIII);
                }
                int llllllllllllllIllIIlllIlllIllIlI = Items.potionitem.getColorFromDamage(llllllllllllllIllIIlllIllIlllIII);
                final float llllllllllllllIllIIlllIlllIIIIIl = (llllllllllllllIllIIlllIlllIllIlI >> 16 & 0xFF) / 255.0f;
                final float llllllllllllllIllIIlllIlllIIIIII = (llllllllllllllIllIIlllIlllIllIlI >> 8 & 0xFF) / 255.0f;
                final float llllllllllllllIllIIlllIllIllllll = (llllllllllllllIllIIlllIlllIllIlI >> 0 & 0xFF) / 255.0f;
                EnumParticleTypes llllllllllllllIllIIlllIllIlllllI = EnumParticleTypes.SPELL;
                if (Items.potionitem.isEffectInstant(llllllllllllllIllIIlllIllIlllIII)) {
                    llllllllllllllIllIIlllIllIlllllI = EnumParticleTypes.SPELL_INSTANT;
                }
                for (int llllllllllllllIllIIlllIlllIllIII = 0; llllllllllllllIllIIlllIlllIllIII < 100; ++llllllllllllllIllIIlllIlllIllIII) {
                    final double llllllllllllllIllIIlllIlllIlIllI = llllllllllllllIllIIlllIllllIIIll.nextDouble() * 4.0;
                    final double llllllllllllllIllIIlllIlllIlIlII = llllllllllllllIllIIlllIllllIIIll.nextDouble() * 3.141592653589793 * 2.0;
                    final double llllllllllllllIllIIlllIlllIlIIlI = Math.cos(llllllllllllllIllIIlllIlllIlIlII) * llllllllllllllIllIIlllIlllIlIllI;
                    final double llllllllllllllIllIIlllIlllIIllIl = 0.01 + llllllllllllllIllIIlllIllllIIIll.nextDouble() * 0.5;
                    final double llllllllllllllIllIIlllIlllIIlIll = Math.sin(llllllllllllllIllIIlllIlllIlIlII) * llllllllllllllIllIIlllIlllIlIllI;
                    final EntityFX llllllllllllllIllIIlllIllIllllIl = this.func_174974_b(llllllllllllllIllIIlllIllIlllllI.func_179348_c(), llllllllllllllIllIIlllIllIlllllI.func_179344_e(), llllllllllllllIllIIlllIllllIIIlI + llllllllllllllIllIIlllIlllIlIIlI * 0.1, llllllllllllllIllIIlllIlllIlllll + 0.3, llllllllllllllIllIIlllIlllIlllII + llllllllllllllIllIIlllIlllIIlIll * 0.1, llllllllllllllIllIIlllIlllIlIIlI, llllllllllllllIllIIlllIlllIIllIl, llllllllllllllIllIIlllIlllIIlIll, new int[0]);
                    if (llllllllllllllIllIIlllIllIllllIl != null) {
                        final float llllllllllllllIllIIlllIllIllllII = 0.75f + llllllllllllllIllIIlllIllllIIIll.nextFloat() * 0.25f;
                        llllllllllllllIllIIlllIllIllllIl.setRBGColorF(llllllllllllllIllIIlllIlllIIIIIl * llllllllllllllIllIIlllIllIllllII, llllllllllllllIllIIlllIlllIIIIII * llllllllllllllIllIIlllIllIllllII, llllllllllllllIllIIlllIllIllllll * llllllllllllllIllIIlllIllIllllII);
                        llllllllllllllIllIIlllIllIllllIl.multiplyVelocity((float)llllllllllllllIllIIlllIlllIlIllI);
                    }
                }
                this.theWorld.func_175731_a(llllllllllllllIllIIlllIllllIIlIl, "game.potion.smash", 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 2003: {
                final double llllllllllllllIllIIlllIllllIIIIl = llllllllllllllIllIIlllIllllIIlIl.getX() + 0.5;
                final double llllllllllllllIllIIlllIlllIllllI = llllllllllllllIllIIlllIllllIIlIl.getY();
                final double llllllllllllllIllIIlllIlllIllIll = llllllllllllllIllIIlllIllllIIlIl.getZ() + 0.5;
                for (int llllllllllllllIllIIlllIlllIllIIl = 0; llllllllllllllIllIIlllIlllIllIIl < 8; ++llllllllllllllIllIIlllIlllIllIIl) {
                    this.func_174972_a(EnumParticleTypes.ITEM_CRACK, llllllllllllllIllIIlllIllllIIIIl, llllllllllllllIllIIlllIlllIllllI, llllllllllllllIllIIlllIlllIllIll, llllllllllllllIllIIlllIllllIIIll.nextGaussian() * 0.15, llllllllllllllIllIIlllIllllIIIll.nextDouble() * 0.2, llllllllllllllIllIIlllIllllIIIll.nextGaussian() * 0.15, Item.getIdFromItem(Items.ender_eye));
                }
                for (double llllllllllllllIllIIlllIlllIIllll = 0.0; llllllllllllllIllIIlllIlllIIllll < 6.283185307179586; llllllllllllllIllIIlllIlllIIllll += 0.15707963267948966) {
                    this.func_174972_a(EnumParticleTypes.PORTAL, llllllllllllllIllIIlllIllllIIIIl + Math.cos(llllllllllllllIllIIlllIlllIIllll) * 5.0, llllllllllllllIllIIlllIlllIllllI - 0.4, llllllllllllllIllIIlllIlllIllIll + Math.sin(llllllllllllllIllIIlllIlllIIllll) * 5.0, Math.cos(llllllllllllllIllIIlllIlllIIllll) * -5.0, 0.0, Math.sin(llllllllllllllIllIIlllIlllIIllll) * -5.0, new int[0]);
                    this.func_174972_a(EnumParticleTypes.PORTAL, llllllllllllllIllIIlllIllllIIIIl + Math.cos(llllllllllllllIllIIlllIlllIIllll) * 5.0, llllllllllllllIllIIlllIlllIllllI - 0.4, llllllllllllllIllIIlllIlllIllIll + Math.sin(llllllllllllllIllIIlllIlllIIllll) * 5.0, Math.cos(llllllllllllllIllIIlllIlllIIllll) * -7.0, 0.0, Math.sin(llllllllllllllIllIIlllIlllIIllll) * -7.0, new int[0]);
                }
            }
            case 2004: {
                for (int llllllllllllllIllIIlllIlllIlIlll = 0; llllllllllllllIllIIlllIlllIlIlll < 20; ++llllllllllllllIllIIlllIlllIlIlll) {
                    final double llllllllllllllIllIIlllIlllIlIlIl = llllllllllllllIllIIlllIllllIIlIl.getX() + 0.5 + (this.theWorld.rand.nextFloat() - 0.5) * 2.0;
                    final double llllllllllllllIllIIlllIlllIlIIll = llllllllllllllIllIIlllIllllIIlIl.getY() + 0.5 + (this.theWorld.rand.nextFloat() - 0.5) * 2.0;
                    final double llllllllllllllIllIIlllIlllIlIIIl = llllllllllllllIllIIlllIllllIIlIl.getZ() + 0.5 + (this.theWorld.rand.nextFloat() - 0.5) * 2.0;
                    this.theWorld.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, llllllllllllllIllIIlllIlllIlIlIl, llllllllllllllIllIIlllIlllIlIIll, llllllllllllllIllIIlllIlllIlIIIl, 0.0, 0.0, 0.0, new int[0]);
                    this.theWorld.spawnParticle(EnumParticleTypes.FLAME, llllllllllllllIllIIlllIlllIlIlIl, llllllllllllllIllIIlllIlllIlIIll, llllllllllllllIllIIlllIlllIlIIIl, 0.0, 0.0, 0.0, new int[0]);
                }
            }
            case 2005: {
                ItemDye.func_180617_a(this.theWorld, llllllllllllllIllIIlllIllllIIlIl, llllllllllllllIllIIlllIllIlllIII);
                break;
            }
        }
    }
    
    @Override
    public void onResourceManagerReload(final IResourceManager llllllllllllllIllIlIIIllIlllIIll) {
        this.func_174971_n();
    }
    
    public void setWorldAndLoadRenderers(final WorldClient llllllllllllllIllIlIIIlIlIlllllI) {
        if (this.theWorld != null) {
            this.theWorld.removeWorldAccess(this);
        }
        this.field_174992_B = Double.MIN_VALUE;
        this.field_174993_C = Double.MIN_VALUE;
        this.field_174987_D = Double.MIN_VALUE;
        this.field_174988_E = Integer.MIN_VALUE;
        this.field_174989_F = Integer.MIN_VALUE;
        this.field_174990_G = Integer.MIN_VALUE;
        this.field_175010_j.set(llllllllllllllIllIlIIIlIlIlllllI);
        this.theWorld = llllllllllllllIllIlIIIlIlIlllllI;
        if (Config.isDynamicLights()) {
            DynamicLights.clear();
        }
        if (llllllllllllllIllIlIIIlIlIlllllI != null) {
            llllllllllllllIllIlIIIlIlIlllllI.addWorldAccess(this);
            this.loadRenderers();
        }
    }
    
    private void func_174968_a(final WorldRenderer llllllllllllllIllIlIIIllIIllIIll, final float llllllllllllllIllIlIIIllIIllIIlI, final boolean llllllllllllllIllIlIIIllIIlllIlI) {
        final boolean llllllllllllllIllIlIIIllIIlllIIl = true;
        final boolean llllllllllllllIllIlIIIllIIlllIII = true;
        llllllllllllllIllIlIIIllIIllIIll.startDrawingQuads();
        for (int llllllllllllllIllIlIIIllIIllIlll = -384; llllllllllllllIllIlIIIllIIllIlll <= 384; llllllllllllllIllIlIIIllIIllIlll += 64) {
            for (int llllllllllllllIllIlIIIllIIllIllI = -384; llllllllllllllIllIlIIIllIIllIllI <= 384; llllllllllllllIllIlIIIllIIllIllI += 64) {
                float llllllllllllllIllIlIIIllIIllIlIl = (float)llllllllllllllIllIlIIIllIIllIlll;
                float llllllllllllllIllIlIIIllIIllIlII = (float)(llllllllllllllIllIlIIIllIIllIlll + 64);
                if (llllllllllllllIllIlIIIllIIlllIlI) {
                    llllllllllllllIllIlIIIllIIllIlII = (float)llllllllllllllIllIlIIIllIIllIlll;
                    llllllllllllllIllIlIIIllIIllIlIl = (float)(llllllllllllllIllIlIIIllIIllIlll + 64);
                }
                llllllllllllllIllIlIIIllIIllIIll.addVertex(llllllllllllllIllIlIIIllIIllIlIl, llllllllllllllIllIlIIIllIIllIIlI, llllllllllllllIllIlIIIllIIllIllI);
                llllllllllllllIllIlIIIllIIllIIll.addVertex(llllllllllllllIllIlIIIllIIllIlII, llllllllllllllIllIlIIIllIIllIIlI, llllllllllllllIllIlIIIllIIllIllI);
                llllllllllllllIllIlIIIllIIllIIll.addVertex(llllllllllllllIllIlIIIllIIllIlII, llllllllllllllIllIlIIIllIIllIIlI, llllllllllllllIllIlIIIllIIllIllI + 64);
                llllllllllllllIllIlIIIllIIllIIll.addVertex(llllllllllllllIllIlIIIllIIllIlIl, llllllllllllllIllIlIIIllIIllIIlI, llllllllllllllIllIlIIIllIIllIllI + 64);
            }
        }
    }
    
    public boolean hasCloudFog(final double llllllllllllllIllIlIIIIIIlIlllll, final double llllllllllllllIllIlIIIIIIlIllllI, final double llllllllllllllIllIlIIIIIIlIlllIl, final float llllllllllllllIllIlIIIIIIlIlllII) {
        return false;
    }
    
    private boolean func_174983_a(final BlockPos llllllllllllllIllIlIIIIlllIIIlII, final RenderChunk llllllllllllllIllIlIIIIlllIIIIll) {
        final BlockPos llllllllllllllIllIlIIIIlllIIIIlI = llllllllllllllIllIlIIIIlllIIIIll.func_178568_j();
        return MathHelper.abs_int(llllllllllllllIllIlIIIIlllIIIlII.getX() - llllllllllllllIllIlIIIIlllIIIIlI.getX()) <= 16 && MathHelper.abs_int(llllllllllllllIllIlIIIIlllIIIlII.getY() - llllllllllllllIllIlIIIIlllIIIIlI.getY()) <= 16 && MathHelper.abs_int(llllllllllllllIllIlIIIIlllIIIlII.getZ() - llllllllllllllIllIlIIIIlllIIIIlI.getZ()) <= 16;
    }
    
    private void func_174963_q() {
        final Tessellator llllllllllllllIllIlIIIllIIlIIllI = Tessellator.getInstance();
        final WorldRenderer llllllllllllllIllIlIIIllIIlIIlIl = llllllllllllllIllIlIIIllIIlIIllI.getWorldRenderer();
        if (this.field_175013_s != null) {
            this.field_175013_s.func_177362_c();
        }
        if (this.starGLCallList >= 0) {
            GLAllocation.deleteDisplayLists(this.starGLCallList);
            this.starGLCallList = -1;
        }
        if (this.field_175005_X) {
            this.field_175013_s = new VertexBuffer(this.field_175014_r);
            this.func_180444_a(llllllllllllllIllIlIIIllIIlIIlIl);
            llllllllllllllIllIlIIIllIIlIIlIl.draw();
            llllllllllllllIllIlIIIllIIlIIlIl.reset();
            this.field_175013_s.func_177360_a(llllllllllllllIllIlIIIllIIlIIlIl.func_178966_f(), llllllllllllllIllIlIIIllIIlIIlIl.func_178976_e());
        }
        else {
            this.starGLCallList = GLAllocation.generateDisplayLists(1);
            GlStateManager.pushMatrix();
            GL11.glNewList(this.starGLCallList, 4864);
            this.func_180444_a(llllllllllllllIllIlIIIllIIlIIlIl);
            llllllllllllllIllIlIIIllIIlIIllI.draw();
            GL11.glEndList();
            GlStateManager.popMatrix();
        }
    }
    
    private void func_174965_a(final Iterator llllllllllllllIllIlIIIIlIIIllIII) {
        while (llllllllllllllIllIlIIIIlIIIllIII.hasNext()) {
            final DestroyBlockProgress llllllllllllllIllIlIIIIlIIIllIll = llllllllllllllIllIlIIIIlIIIllIII.next();
            final int llllllllllllllIllIlIIIIlIIIllIlI = llllllllllllllIllIlIIIIlIIIllIll.getCreationCloudUpdateTick();
            if (this.cloudTickCounter - llllllllllllllIllIlIIIIlIIIllIlI > 400) {
                llllllllllllllIllIlIIIIlIIIllIII.remove();
            }
        }
    }
    
    private RenderChunk getRenderChunkOffset(final BlockPos llllllllllllllIllIlIIIIllIlIIIII, final RenderChunk llllllllllllllIllIlIIIIllIIlllll, final EnumFacing llllllllllllllIllIlIIIIllIIllllI) {
        final BlockPos llllllllllllllIllIlIIIIllIIlllIl = llllllllllllllIllIlIIIIllIIlllll.getPositionOffset16(llllllllllllllIllIlIIIIllIIllllI);
        if (llllllllllllllIllIlIIIIllIIlllIl.getY() >= 0 && llllllllllllllIllIlIIIIllIIlllIl.getY() < 256) {
            final int llllllllllllllIllIlIIIIllIIlllII = MathHelper.abs_int(llllllllllllllIllIlIIIIllIlIIIII.getX() - llllllllllllllIllIlIIIIllIIlllIl.getX());
            final int llllllllllllllIllIlIIIIllIIllIll = MathHelper.abs_int(llllllllllllllIllIlIIIIllIlIIIII.getZ() - llllllllllllllIllIlIIIIllIIlllIl.getZ());
            if (Config.isFogOff()) {
                if (llllllllllllllIllIlIIIIllIIlllII > this.renderDistance || llllllllllllllIllIlIIIIllIIllIll > this.renderDistance) {
                    return null;
                }
            }
            else {
                final int llllllllllllllIllIlIIIIllIIllIlI = llllllllllllllIllIlIIIIllIIlllII * llllllllllllllIllIlIIIIllIIlllII + llllllllllllllIllIlIIIIllIIllIll * llllllllllllllIllIlIIIIllIIllIll;
                if (llllllllllllllIllIlIIIIllIIllIlI > this.renderDistanceSq) {
                    return null;
                }
            }
            return this.field_175008_n.func_178161_a(llllllllllllllIllIlIIIIllIIlllIl);
        }
        return null;
    }
    
    public int getCountActiveRenderers() {
        return this.glRenderLists.size();
    }
    
    public void func_174975_c() {
        if (this.func_174985_d()) {
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 0, 1);
            this.field_175015_z.func_178038_a(this.mc.displayWidth, this.mc.displayHeight, false);
            GlStateManager.disableBlend();
        }
    }
    
    public int getCountEntitiesRendered() {
        return this.countEntitiesRendered;
    }
    
    @Override
    public void playSoundToNearExcept(final EntityPlayer llllllllllllllIllIIllllIlIlIlIll, final String llllllllllllllIllIIllllIlIlIlIlI, final double llllllllllllllIllIIllllIlIlIlIIl, final double llllllllllllllIllIIllllIlIlIlIII, final double llllllllllllllIllIIllllIlIlIIlll, final float llllllllllllllIllIIllllIlIlIIllI, final float llllllllllllllIllIIllllIlIlIIlIl) {
    }
    
    private Set func_174978_c(final BlockPos llllllllllllllIllIlIIIIllIllIllI) {
        final VisGraph llllllllllllllIllIlIIIIllIllIlIl = new VisGraph();
        final BlockPos llllllllllllllIllIlIIIIllIllIlII = new BlockPos(llllllllllllllIllIlIIIIllIllIllI.getX() >> 4 << 4, llllllllllllllIllIlIIIIllIllIllI.getY() >> 4 << 4, llllllllllllllIllIlIIIIllIllIllI.getZ() >> 4 << 4);
        final Chunk llllllllllllllIllIlIIIIllIllIIll = this.theWorld.getChunkFromBlockCoords(llllllllllllllIllIlIIIIllIllIlII);
        for (final BlockPos.MutableBlockPos llllllllllllllIllIlIIIIllIllIIIl : BlockPos.getAllInBoxMutable(llllllllllllllIllIlIIIIllIllIlII, llllllllllllllIllIlIIIIllIllIlII.add(15, 15, 15))) {
            if (llllllllllllllIllIlIIIIllIllIIll.getBlock(llllllllllllllIllIlIIIIllIllIIIl).isOpaqueCube()) {
                llllllllllllllIllIlIIIIllIllIlIl.func_178606_a(llllllllllllllIllIlIIIIllIllIIIl);
            }
        }
        return llllllllllllllIllIlIIIIllIllIlIl.func_178609_b(llllllllllllllIllIlIIIIllIllIllI);
    }
    
    private void func_180443_s() {
        GlStateManager.tryBlendFuncSeparate(774, 768, 1, 0);
        GlStateManager.enableBlend();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 0.5f);
        GlStateManager.doPolygonOffset(-3.0f, -3.0f);
        GlStateManager.enablePolygonOffset();
        GlStateManager.alphaFunc(516, 0.1f);
        GlStateManager.enableAlpha();
        GlStateManager.pushMatrix();
        if (Config.isShaders()) {
            ShadersRender.beginBlockDamage();
        }
    }
    
    @Override
    public void playSound(final String llllllllllllllIllIIllllIlIllIIlI, final double llllllllllllllIllIIllllIlIllIIIl, final double llllllllllllllIllIIllllIlIllIIII, final double llllllllllllllIllIIllllIlIlIllll, final float llllllllllllllIllIIllllIlIlIlllI, final float llllllllllllllIllIIllllIlIlIllIl) {
    }
    
    public void updateClouds() {
        if (Config.isShaders() && Keyboard.isKeyDown(61) && Keyboard.isKeyDown(19)) {
            Shaders.uninit();
        }
        ++this.cloudTickCounter;
        if (this.cloudTickCounter % 20 == 0) {
            this.func_174965_a(this.damagedBlocks.values().iterator());
        }
    }
    
    public void loadRenderers() {
        if (this.theWorld != null) {
            this.displayListEntitiesDirty = true;
            Blocks.leaves.setGraphicsLevel(Config.isTreesFancy());
            Blocks.leaves2.setGraphicsLevel(Config.isTreesFancy());
            BlockModelRenderer.updateAoLightValue();
            if (Config.isDynamicLights()) {
                DynamicLights.clear();
            }
            this.renderDistanceChunks = this.mc.gameSettings.renderDistanceChunks;
            this.renderDistance = this.renderDistanceChunks * 16;
            this.renderDistanceSq = this.renderDistance * this.renderDistance;
            final boolean llllllllllllllIllIlIIIlIlIlllIIl = this.field_175005_X;
            this.field_175005_X = OpenGlHelper.func_176075_f();
            if (llllllllllllllIllIlIIIlIlIlllIIl && !this.field_175005_X) {
                this.field_174996_N = new RenderList();
                this.field_175007_a = new ListChunkFactory();
            }
            else if (!llllllllllllllIllIlIIIlIlIlllIIl && this.field_175005_X) {
                this.field_174996_N = new VboRenderList();
                this.field_175007_a = new VboChunkFactory();
            }
            if (llllllllllllllIllIlIIIlIlIlllIIl != this.field_175005_X) {
                this.func_174963_q();
                this.func_174980_p();
                this.func_174964_o();
            }
            if (this.field_175008_n != null) {
                this.field_175008_n.func_178160_a();
            }
            this.func_174986_e();
            this.field_175008_n = new ViewFrustum(this.theWorld, this.mc.gameSettings.renderDistanceChunks, this, this.field_175007_a);
            if (this.theWorld != null) {
                final Entity llllllllllllllIllIlIIIlIlIlllIII = this.mc.func_175606_aa();
                if (llllllllllllllIllIlIIIlIlIlllIII != null) {
                    this.field_175008_n.func_178163_a(llllllllllllllIllIlIIIlIlIlllIII.posX, llllllllllllllIllIlIIIlIlIlllIII.posZ);
                }
            }
            this.renderEntitiesStartupCounter = 2;
        }
    }
    
    private void func_180445_c(float llllllllllllllIllIlIIIIIIIlllIIl, final int llllllllllllllIllIlIIIIIIIlllIII) {
        this.cloudRenderer.prepareToRender(true, this.cloudTickCounter, llllllllllllllIllIlIIIIIIIlllIIl);
        llllllllllllllIllIlIIIIIIIlllIIl = 0.0f;
        GlStateManager.disableCull();
        final float llllllllllllllIllIlIIIIIIIllIlll = (float)(this.mc.func_175606_aa().lastTickPosY + (this.mc.func_175606_aa().posY - this.mc.func_175606_aa().lastTickPosY) * llllllllllllllIllIlIIIIIIIlllIIl);
        final Tessellator llllllllllllllIllIlIIIIIIIllIllI = Tessellator.getInstance();
        final WorldRenderer llllllllllllllIllIlIIIIIIIllIlIl = llllllllllllllIllIlIIIIIIIllIllI.getWorldRenderer();
        final float llllllllllllllIllIlIIIIIIIllIlII = 12.0f;
        final float llllllllllllllIllIlIIIIIIIllIIll = 4.0f;
        final double llllllllllllllIllIlIIIIIIIllIIlI = this.cloudTickCounter + llllllllllllllIllIlIIIIIIIlllIIl;
        double llllllllllllllIllIlIIIIIIIllIIIl = (this.mc.func_175606_aa().prevPosX + (this.mc.func_175606_aa().posX - this.mc.func_175606_aa().prevPosX) * llllllllllllllIllIlIIIIIIIlllIIl + llllllllllllllIllIlIIIIIIIllIIlI * 0.029999999329447746) / 12.0;
        double llllllllllllllIllIlIIIIIIIllIIII = (this.mc.func_175606_aa().prevPosZ + (this.mc.func_175606_aa().posZ - this.mc.func_175606_aa().prevPosZ) * llllllllllllllIllIlIIIIIIIlllIIl) / 12.0 + 0.33000001311302185;
        float llllllllllllllIllIlIIIIIIIlIllll = this.theWorld.provider.getCloudHeight() - llllllllllllllIllIlIIIIIIIllIlll + 0.33f;
        llllllllllllllIllIlIIIIIIIlIllll += this.mc.gameSettings.ofCloudsHeight * 128.0f;
        final int llllllllllllllIllIlIIIIIIIlIlllI = MathHelper.floor_double(llllllllllllllIllIlIIIIIIIllIIIl / 2048.0);
        final int llllllllllllllIllIlIIIIIIIlIllIl = MathHelper.floor_double(llllllllllllllIllIlIIIIIIIllIIII / 2048.0);
        llllllllllllllIllIlIIIIIIIllIIIl -= llllllllllllllIllIlIIIIIIIlIlllI * 2048;
        llllllllllllllIllIlIIIIIIIllIIII -= llllllllllllllIllIlIIIIIIIlIllIl * 2048;
        this.renderEngine.bindTexture(RenderGlobal.locationCloudsPng);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        final Vec3 llllllllllllllIllIlIIIIIIIlIllII = this.theWorld.getCloudColour(llllllllllllllIllIlIIIIIIIlllIIl);
        float llllllllllllllIllIlIIIIIIIlIlIll = (float)llllllllllllllIllIlIIIIIIIlIllII.xCoord;
        float llllllllllllllIllIlIIIIIIIlIlIlI = (float)llllllllllllllIllIlIIIIIIIlIllII.yCoord;
        float llllllllllllllIllIlIIIIIIIlIlIIl = (float)llllllllllllllIllIlIIIIIIIlIllII.zCoord;
        if (llllllllllllllIllIlIIIIIIIlllIII != 2) {
            final float llllllllllllllIllIlIIIIIIIlIlIII = (llllllllllllllIllIlIIIIIIIlIlIll * 30.0f + llllllllllllllIllIlIIIIIIIlIlIlI * 59.0f + llllllllllllllIllIlIIIIIIIlIlIIl * 11.0f) / 100.0f;
            final float llllllllllllllIllIlIIIIIIIlIIllI = (llllllllllllllIllIlIIIIIIIlIlIll * 30.0f + llllllllllllllIllIlIIIIIIIlIlIlI * 70.0f) / 100.0f;
            final float llllllllllllllIllIlIIIIIIIlIIlII = (llllllllllllllIllIlIIIIIIIlIlIll * 30.0f + llllllllllllllIllIlIIIIIIIlIlIIl * 70.0f) / 100.0f;
            llllllllllllllIllIlIIIIIIIlIlIll = llllllllllllllIllIlIIIIIIIlIlIII;
            llllllllllllllIllIlIIIIIIIlIlIlI = llllllllllllllIllIlIIIIIIIlIIllI;
            llllllllllllllIllIlIIIIIIIlIlIIl = llllllllllllllIllIlIIIIIIIlIIlII;
        }
        final float llllllllllllllIllIlIIIIIIIlIIlll = 0.00390625f;
        final float llllllllllllllIllIlIIIIIIIlIIlIl = MathHelper.floor_double(llllllllllllllIllIlIIIIIIIllIIIl) * 0.00390625f;
        final float llllllllllllllIllIlIIIIIIIlIIIll = MathHelper.floor_double(llllllllllllllIllIlIIIIIIIllIIII) * 0.00390625f;
        final float llllllllllllllIllIlIIIIIIIlIIIlI = (float)(llllllllllllllIllIlIIIIIIIllIIIl - MathHelper.floor_double(llllllllllllllIllIlIIIIIIIllIIIl));
        final float llllllllllllllIllIlIIIIIIIlIIIIl = (float)(llllllllllllllIllIlIIIIIIIllIIII - MathHelper.floor_double(llllllllllllllIllIlIIIIIIIllIIII));
        final boolean llllllllllllllIllIlIIIIIIIlIIIII = true;
        final boolean llllllllllllllIllIlIIIIIIIIlllll = true;
        final float llllllllllllllIllIlIIIIIIIIllllI = 9.765625E-4f;
        GlStateManager.scale(12.0f, 1.0f, 12.0f);
        for (int llllllllllllllIllIlIIIIIIIIlllIl = 0; llllllllllllllIllIlIIIIIIIIlllIl < 2; ++llllllllllllllIllIlIIIIIIIIlllIl) {
            if (llllllllllllllIllIlIIIIIIIIlllIl == 0) {
                GlStateManager.colorMask(false, false, false, false);
            }
            else {
                switch (llllllllllllllIllIlIIIIIIIlllIII) {
                    case 0: {
                        GlStateManager.colorMask(false, true, true, true);
                        break;
                    }
                    case 1: {
                        GlStateManager.colorMask(true, false, false, true);
                        break;
                    }
                    case 2: {
                        GlStateManager.colorMask(true, true, true, true);
                        break;
                    }
                }
            }
            this.cloudRenderer.renderGlList();
        }
        if (this.cloudRenderer.shouldUpdateGlList()) {
            this.cloudRenderer.startUpdateGlList();
            for (int llllllllllllllIllIlIIIIIIIIlllIl = -3; llllllllllllllIllIlIIIIIIIIlllIl <= 4; ++llllllllllllllIllIlIIIIIIIIlllIl) {
                for (int llllllllllllllIllIlIIIIIIIIlllII = -3; llllllllllllllIllIlIIIIIIIIlllII <= 4; ++llllllllllllllIllIlIIIIIIIIlllII) {
                    llllllllllllllIllIlIIIIIIIllIlIl.startDrawingQuads();
                    final float llllllllllllllIllIlIIIIIIIIllIll = (float)(llllllllllllllIllIlIIIIIIIIlllIl * 8);
                    final float llllllllllllllIllIlIIIIIIIIllIlI = (float)(llllllllllllllIllIlIIIIIIIIlllII * 8);
                    final float llllllllllllllIllIlIIIIIIIIllIIl = llllllllllllllIllIlIIIIIIIIllIll - llllllllllllllIllIlIIIIIIIlIIIlI;
                    final float llllllllllllllIllIlIIIIIIIIllIII = llllllllllllllIllIlIIIIIIIIllIlI - llllllllllllllIllIlIIIIIIIlIIIIl;
                    if (llllllllllllllIllIlIIIIIIIlIllll > -5.0f) {
                        llllllllllllllIllIlIIIIIIIllIlIl.func_178960_a(llllllllllllllIllIlIIIIIIIlIlIll * 0.7f, llllllllllllllIllIlIIIIIIIlIlIlI * 0.7f, llllllllllllllIllIlIIIIIIIlIlIIl * 0.7f, 0.8f);
                        llllllllllllllIllIlIIIIIIIllIlIl.func_178980_d(0.0f, -1.0f, 0.0f);
                        llllllllllllllIllIlIIIIIIIllIlIl.addVertexWithUV(llllllllllllllIllIlIIIIIIIIllIIl + 0.0f, llllllllllllllIllIlIIIIIIIlIllll + 0.0f, llllllllllllllIllIlIIIIIIIIllIII + 8.0f, (llllllllllllllIllIlIIIIIIIIllIll + 0.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIlIl, (llllllllllllllIllIlIIIIIIIIllIlI + 8.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIIll);
                        llllllllllllllIllIlIIIIIIIllIlIl.addVertexWithUV(llllllllllllllIllIlIIIIIIIIllIIl + 8.0f, llllllllllllllIllIlIIIIIIIlIllll + 0.0f, llllllllllllllIllIlIIIIIIIIllIII + 8.0f, (llllllllllllllIllIlIIIIIIIIllIll + 8.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIlIl, (llllllllllllllIllIlIIIIIIIIllIlI + 8.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIIll);
                        llllllllllllllIllIlIIIIIIIllIlIl.addVertexWithUV(llllllllllllllIllIlIIIIIIIIllIIl + 8.0f, llllllllllllllIllIlIIIIIIIlIllll + 0.0f, llllllllllllllIllIlIIIIIIIIllIII + 0.0f, (llllllllllllllIllIlIIIIIIIIllIll + 8.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIlIl, (llllllllllllllIllIlIIIIIIIIllIlI + 0.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIIll);
                        llllllllllllllIllIlIIIIIIIllIlIl.addVertexWithUV(llllllllllllllIllIlIIIIIIIIllIIl + 0.0f, llllllllllllllIllIlIIIIIIIlIllll + 0.0f, llllllllllllllIllIlIIIIIIIIllIII + 0.0f, (llllllllllllllIllIlIIIIIIIIllIll + 0.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIlIl, (llllllllllllllIllIlIIIIIIIIllIlI + 0.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIIll);
                    }
                    if (llllllllllllllIllIlIIIIIIIlIllll <= 5.0f) {
                        llllllllllllllIllIlIIIIIIIllIlIl.func_178960_a(llllllllllllllIllIlIIIIIIIlIlIll, llllllllllllllIllIlIIIIIIIlIlIlI, llllllllllllllIllIlIIIIIIIlIlIIl, 0.8f);
                        llllllllllllllIllIlIIIIIIIllIlIl.func_178980_d(0.0f, 1.0f, 0.0f);
                        llllllllllllllIllIlIIIIIIIllIlIl.addVertexWithUV(llllllllllllllIllIlIIIIIIIIllIIl + 0.0f, llllllllllllllIllIlIIIIIIIlIllll + 4.0f - 9.765625E-4f, llllllllllllllIllIlIIIIIIIIllIII + 8.0f, (llllllllllllllIllIlIIIIIIIIllIll + 0.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIlIl, (llllllllllllllIllIlIIIIIIIIllIlI + 8.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIIll);
                        llllllllllllllIllIlIIIIIIIllIlIl.addVertexWithUV(llllllllllllllIllIlIIIIIIIIllIIl + 8.0f, llllllllllllllIllIlIIIIIIIlIllll + 4.0f - 9.765625E-4f, llllllllllllllIllIlIIIIIIIIllIII + 8.0f, (llllllllllllllIllIlIIIIIIIIllIll + 8.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIlIl, (llllllllllllllIllIlIIIIIIIIllIlI + 8.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIIll);
                        llllllllllllllIllIlIIIIIIIllIlIl.addVertexWithUV(llllllllllllllIllIlIIIIIIIIllIIl + 8.0f, llllllllllllllIllIlIIIIIIIlIllll + 4.0f - 9.765625E-4f, llllllllllllllIllIlIIIIIIIIllIII + 0.0f, (llllllllllllllIllIlIIIIIIIIllIll + 8.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIlIl, (llllllllllllllIllIlIIIIIIIIllIlI + 0.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIIll);
                        llllllllllllllIllIlIIIIIIIllIlIl.addVertexWithUV(llllllllllllllIllIlIIIIIIIIllIIl + 0.0f, llllllllllllllIllIlIIIIIIIlIllll + 4.0f - 9.765625E-4f, llllllllllllllIllIlIIIIIIIIllIII + 0.0f, (llllllllllllllIllIlIIIIIIIIllIll + 0.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIlIl, (llllllllllllllIllIlIIIIIIIIllIlI + 0.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIIll);
                    }
                    llllllllllllllIllIlIIIIIIIllIlIl.func_178960_a(llllllllllllllIllIlIIIIIIIlIlIll * 0.9f, llllllllllllllIllIlIIIIIIIlIlIlI * 0.9f, llllllllllllllIllIlIIIIIIIlIlIIl * 0.9f, 0.8f);
                    if (llllllllllllllIllIlIIIIIIIIlllIl > -1) {
                        llllllllllllllIllIlIIIIIIIllIlIl.func_178980_d(-1.0f, 0.0f, 0.0f);
                        for (int llllllllllllllIllIlIIIIIIIIlIlll = 0; llllllllllllllIllIlIIIIIIIIlIlll < 8; ++llllllllllllllIllIlIIIIIIIIlIlll) {
                            llllllllllllllIllIlIIIIIIIllIlIl.addVertexWithUV(llllllllllllllIllIlIIIIIIIIllIIl + llllllllllllllIllIlIIIIIIIIlIlll + 0.0f, llllllllllllllIllIlIIIIIIIlIllll + 0.0f, llllllllllllllIllIlIIIIIIIIllIII + 8.0f, (llllllllllllllIllIlIIIIIIIIllIll + llllllllllllllIllIlIIIIIIIIlIlll + 0.5f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIlIl, (llllllllllllllIllIlIIIIIIIIllIlI + 8.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIIll);
                            llllllllllllllIllIlIIIIIIIllIlIl.addVertexWithUV(llllllllllllllIllIlIIIIIIIIllIIl + llllllllllllllIllIlIIIIIIIIlIlll + 0.0f, llllllllllllllIllIlIIIIIIIlIllll + 4.0f, llllllllllllllIllIlIIIIIIIIllIII + 8.0f, (llllllllllllllIllIlIIIIIIIIllIll + llllllllllllllIllIlIIIIIIIIlIlll + 0.5f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIlIl, (llllllllllllllIllIlIIIIIIIIllIlI + 8.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIIll);
                            llllllllllllllIllIlIIIIIIIllIlIl.addVertexWithUV(llllllllllllllIllIlIIIIIIIIllIIl + llllllllllllllIllIlIIIIIIIIlIlll + 0.0f, llllllllllllllIllIlIIIIIIIlIllll + 4.0f, llllllllllllllIllIlIIIIIIIIllIII + 0.0f, (llllllllllllllIllIlIIIIIIIIllIll + llllllllllllllIllIlIIIIIIIIlIlll + 0.5f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIlIl, (llllllllllllllIllIlIIIIIIIIllIlI + 0.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIIll);
                            llllllllllllllIllIlIIIIIIIllIlIl.addVertexWithUV(llllllllllllllIllIlIIIIIIIIllIIl + llllllllllllllIllIlIIIIIIIIlIlll + 0.0f, llllllllllllllIllIlIIIIIIIlIllll + 0.0f, llllllllllllllIllIlIIIIIIIIllIII + 0.0f, (llllllllllllllIllIlIIIIIIIIllIll + llllllllllllllIllIlIIIIIIIIlIlll + 0.5f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIlIl, (llllllllllllllIllIlIIIIIIIIllIlI + 0.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIIll);
                        }
                    }
                    if (llllllllllllllIllIlIIIIIIIIlllIl <= 1) {
                        llllllllllllllIllIlIIIIIIIllIlIl.func_178980_d(1.0f, 0.0f, 0.0f);
                        for (int llllllllllllllIllIlIIIIIIIIlIllI = 0; llllllllllllllIllIlIIIIIIIIlIllI < 8; ++llllllllllllllIllIlIIIIIIIIlIllI) {
                            llllllllllllllIllIlIIIIIIIllIlIl.addVertexWithUV(llllllllllllllIllIlIIIIIIIIllIIl + llllllllllllllIllIlIIIIIIIIlIllI + 1.0f - 9.765625E-4f, llllllllllllllIllIlIIIIIIIlIllll + 0.0f, llllllllllllllIllIlIIIIIIIIllIII + 8.0f, (llllllllllllllIllIlIIIIIIIIllIll + llllllllllllllIllIlIIIIIIIIlIllI + 0.5f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIlIl, (llllllllllllllIllIlIIIIIIIIllIlI + 8.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIIll);
                            llllllllllllllIllIlIIIIIIIllIlIl.addVertexWithUV(llllllllllllllIllIlIIIIIIIIllIIl + llllllllllllllIllIlIIIIIIIIlIllI + 1.0f - 9.765625E-4f, llllllllllllllIllIlIIIIIIIlIllll + 4.0f, llllllllllllllIllIlIIIIIIIIllIII + 8.0f, (llllllllllllllIllIlIIIIIIIIllIll + llllllllllllllIllIlIIIIIIIIlIllI + 0.5f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIlIl, (llllllllllllllIllIlIIIIIIIIllIlI + 8.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIIll);
                            llllllllllllllIllIlIIIIIIIllIlIl.addVertexWithUV(llllllllllllllIllIlIIIIIIIIllIIl + llllllllllllllIllIlIIIIIIIIlIllI + 1.0f - 9.765625E-4f, llllllllllllllIllIlIIIIIIIlIllll + 4.0f, llllllllllllllIllIlIIIIIIIIllIII + 0.0f, (llllllllllllllIllIlIIIIIIIIllIll + llllllllllllllIllIlIIIIIIIIlIllI + 0.5f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIlIl, (llllllllllllllIllIlIIIIIIIIllIlI + 0.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIIll);
                            llllllllllllllIllIlIIIIIIIllIlIl.addVertexWithUV(llllllllllllllIllIlIIIIIIIIllIIl + llllllllllllllIllIlIIIIIIIIlIllI + 1.0f - 9.765625E-4f, llllllllllllllIllIlIIIIIIIlIllll + 0.0f, llllllllllllllIllIlIIIIIIIIllIII + 0.0f, (llllllllllllllIllIlIIIIIIIIllIll + llllllllllllllIllIlIIIIIIIIlIllI + 0.5f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIlIl, (llllllllllllllIllIlIIIIIIIIllIlI + 0.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIIll);
                        }
                    }
                    llllllllllllllIllIlIIIIIIIllIlIl.func_178960_a(llllllllllllllIllIlIIIIIIIlIlIll * 0.8f, llllllllllllllIllIlIIIIIIIlIlIlI * 0.8f, llllllllllllllIllIlIIIIIIIlIlIIl * 0.8f, 0.8f);
                    if (llllllllllllllIllIlIIIIIIIIlllII > -1) {
                        llllllllllllllIllIlIIIIIIIllIlIl.func_178980_d(0.0f, 0.0f, -1.0f);
                        for (int llllllllllllllIllIlIIIIIIIIlIlIl = 0; llllllllllllllIllIlIIIIIIIIlIlIl < 8; ++llllllllllllllIllIlIIIIIIIIlIlIl) {
                            llllllllllllllIllIlIIIIIIIllIlIl.addVertexWithUV(llllllllllllllIllIlIIIIIIIIllIIl + 0.0f, llllllllllllllIllIlIIIIIIIlIllll + 4.0f, llllllllllllllIllIlIIIIIIIIllIII + llllllllllllllIllIlIIIIIIIIlIlIl + 0.0f, (llllllllllllllIllIlIIIIIIIIllIll + 0.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIlIl, (llllllllllllllIllIlIIIIIIIIllIlI + llllllllllllllIllIlIIIIIIIIlIlIl + 0.5f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIIll);
                            llllllllllllllIllIlIIIIIIIllIlIl.addVertexWithUV(llllllllllllllIllIlIIIIIIIIllIIl + 8.0f, llllllllllllllIllIlIIIIIIIlIllll + 4.0f, llllllllllllllIllIlIIIIIIIIllIII + llllllllllllllIllIlIIIIIIIIlIlIl + 0.0f, (llllllllllllllIllIlIIIIIIIIllIll + 8.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIlIl, (llllllllllllllIllIlIIIIIIIIllIlI + llllllllllllllIllIlIIIIIIIIlIlIl + 0.5f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIIll);
                            llllllllllllllIllIlIIIIIIIllIlIl.addVertexWithUV(llllllllllllllIllIlIIIIIIIIllIIl + 8.0f, llllllllllllllIllIlIIIIIIIlIllll + 0.0f, llllllllllllllIllIlIIIIIIIIllIII + llllllllllllllIllIlIIIIIIIIlIlIl + 0.0f, (llllllllllllllIllIlIIIIIIIIllIll + 8.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIlIl, (llllllllllllllIllIlIIIIIIIIllIlI + llllllllllllllIllIlIIIIIIIIlIlIl + 0.5f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIIll);
                            llllllllllllllIllIlIIIIIIIllIlIl.addVertexWithUV(llllllllllllllIllIlIIIIIIIIllIIl + 0.0f, llllllllllllllIllIlIIIIIIIlIllll + 0.0f, llllllllllllllIllIlIIIIIIIIllIII + llllllllllllllIllIlIIIIIIIIlIlIl + 0.0f, (llllllllllllllIllIlIIIIIIIIllIll + 0.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIlIl, (llllllllllllllIllIlIIIIIIIIllIlI + llllllllllllllIllIlIIIIIIIIlIlIl + 0.5f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIIll);
                        }
                    }
                    if (llllllllllllllIllIlIIIIIIIIlllII <= 1) {
                        llllllllllllllIllIlIIIIIIIllIlIl.func_178980_d(0.0f, 0.0f, 1.0f);
                        for (int llllllllllllllIllIlIIIIIIIIlIlII = 0; llllllllllllllIllIlIIIIIIIIlIlII < 8; ++llllllllllllllIllIlIIIIIIIIlIlII) {
                            llllllllllllllIllIlIIIIIIIllIlIl.addVertexWithUV(llllllllllllllIllIlIIIIIIIIllIIl + 0.0f, llllllllllllllIllIlIIIIIIIlIllll + 4.0f, llllllllllllllIllIlIIIIIIIIllIII + llllllllllllllIllIlIIIIIIIIlIlII + 1.0f - 9.765625E-4f, (llllllllllllllIllIlIIIIIIIIllIll + 0.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIlIl, (llllllllllllllIllIlIIIIIIIIllIlI + llllllllllllllIllIlIIIIIIIIlIlII + 0.5f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIIll);
                            llllllllllllllIllIlIIIIIIIllIlIl.addVertexWithUV(llllllllllllllIllIlIIIIIIIIllIIl + 8.0f, llllllllllllllIllIlIIIIIIIlIllll + 4.0f, llllllllllllllIllIlIIIIIIIIllIII + llllllllllllllIllIlIIIIIIIIlIlII + 1.0f - 9.765625E-4f, (llllllllllllllIllIlIIIIIIIIllIll + 8.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIlIl, (llllllllllllllIllIlIIIIIIIIllIlI + llllllllllllllIllIlIIIIIIIIlIlII + 0.5f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIIll);
                            llllllllllllllIllIlIIIIIIIllIlIl.addVertexWithUV(llllllllllllllIllIlIIIIIIIIllIIl + 8.0f, llllllllllllllIllIlIIIIIIIlIllll + 0.0f, llllllllllllllIllIlIIIIIIIIllIII + llllllllllllllIllIlIIIIIIIIlIlII + 1.0f - 9.765625E-4f, (llllllllllllllIllIlIIIIIIIIllIll + 8.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIlIl, (llllllllllllllIllIlIIIIIIIIllIlI + llllllllllllllIllIlIIIIIIIIlIlII + 0.5f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIIll);
                            llllllllllllllIllIlIIIIIIIllIlIl.addVertexWithUV(llllllllllllllIllIlIIIIIIIIllIIl + 0.0f, llllllllllllllIllIlIIIIIIIlIllll + 0.0f, llllllllllllllIllIlIIIIIIIIllIII + llllllllllllllIllIlIIIIIIIIlIlII + 1.0f - 9.765625E-4f, (llllllllllllllIllIlIIIIIIIIllIll + 0.0f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIlIl, (llllllllllllllIllIlIIIIIIIIllIlI + llllllllllllllIllIlIIIIIIIIlIlII + 0.5f) * 0.00390625f + llllllllllllllIllIlIIIIIIIlIIIll);
                        }
                    }
                    llllllllllllllIllIlIIIIIIIllIllI.draw();
                }
            }
            this.cloudRenderer.endUpdateGlList();
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.disableBlend();
        GlStateManager.enableCull();
    }
    
    public int func_174977_a(final EnumWorldBlockLayer llllllllllllllIllIlIIIIlIlIlIIll, final double llllllllllllllIllIlIIIIlIlIlIIlI, final int llllllllllllllIllIlIIIIlIlIlIIIl, final Entity llllllllllllllIllIlIIIIlIlIlIIII) {
        RenderHelper.disableStandardItemLighting();
        if (llllllllllllllIllIlIIIIlIlIlIIll == EnumWorldBlockLayer.TRANSLUCENT) {
            this.mc.mcProfiler.startSection("translucent_sort");
            final double llllllllllllllIllIlIIIIlIlIIllll = llllllllllllllIllIlIIIIlIlIlIIII.posX - this.prevRenderSortX;
            final double llllllllllllllIllIlIIIIlIlIIlllI = llllllllllllllIllIlIIIIlIlIlIIII.posY - this.prevRenderSortY;
            final double llllllllllllllIllIlIIIIlIlIIllIl = llllllllllllllIllIlIIIIlIlIlIIII.posZ - this.prevRenderSortZ;
            if (llllllllllllllIllIlIIIIlIlIIllll * llllllllllllllIllIlIIIIlIlIIllll + llllllllllllllIllIlIIIIlIlIIlllI * llllllllllllllIllIlIIIIlIlIIlllI + llllllllllllllIllIlIIIIlIlIIllIl * llllllllllllllIllIlIIIIlIlIIllIl > 1.0) {
                this.prevRenderSortX = llllllllllllllIllIlIIIIlIlIlIIII.posX;
                this.prevRenderSortY = llllllllllllllIllIlIIIIlIlIlIIII.posY;
                this.prevRenderSortZ = llllllllllllllIllIlIIIIlIlIlIIII.posZ;
                int llllllllllllllIllIlIIIIlIlIIllII = 0;
                final Iterator llllllllllllllIllIlIIIIlIlIIlIll = this.glRenderLists.iterator();
                this.chunksToResortTransparency.clear();
                while (llllllllllllllIllIlIIIIlIlIIlIll.hasNext()) {
                    final ContainerLocalRenderInformation llllllllllllllIllIlIIIIlIlIIlIlI = llllllllllllllIllIlIIIIlIlIIlIll.next();
                    if (llllllllllllllIllIlIIIIlIlIIlIlI.field_178036_a.field_178590_b.func_178492_d(llllllllllllllIllIlIIIIlIlIlIIll) && llllllllllllllIllIlIIIIlIlIIllII++ < 15) {
                        this.chunksToResortTransparency.add(llllllllllllllIllIlIIIIlIlIIlIlI.field_178036_a);
                    }
                }
            }
            this.mc.mcProfiler.endSection();
        }
        this.mc.mcProfiler.startSection("filterempty");
        int llllllllllllllIllIlIIIIlIlIIlIIl = 0;
        final boolean llllllllllllllIllIlIIIIlIlIIlIII = llllllllllllllIllIlIIIIlIlIlIIll == EnumWorldBlockLayer.TRANSLUCENT;
        final int llllllllllllllIllIlIIIIlIlIIIlll = llllllllllllllIllIlIIIIlIlIIlIII ? (this.glRenderLists.size() - 1) : 0;
        for (int llllllllllllllIllIlIIIIlIlIIIllI = llllllllllllllIllIlIIIIlIlIIlIII ? -1 : this.glRenderLists.size(), llllllllllllllIllIlIIIIlIlIIIlIl = llllllllllllllIllIlIIIIlIlIIlIII ? -1 : 1, llllllllllllllIllIlIIIIlIlIIIlII = llllllllllllllIllIlIIIIlIlIIIlll; llllllllllllllIllIlIIIIlIlIIIlII != llllllllllllllIllIlIIIIlIlIIIllI; llllllllllllllIllIlIIIIlIlIIIlII += llllllllllllllIllIlIIIIlIlIIIlIl) {
            final RenderChunk llllllllllllllIllIlIIIIlIlIIIIll = this.glRenderLists.get(llllllllllllllIllIlIIIIlIlIIIlII).field_178036_a;
            if (!llllllllllllllIllIlIIIIlIlIIIIll.func_178571_g().func_178491_b(llllllllllllllIllIlIIIIlIlIlIIll)) {
                ++llllllllllllllIllIlIIIIlIlIIlIIl;
                this.field_174996_N.func_178002_a(llllllllllllllIllIlIIIIlIlIIIIll, llllllllllllllIllIlIIIIlIlIlIIll);
            }
        }
        if (llllllllllllllIllIlIIIIlIlIIlIIl == 0) {
            this.mc.mcProfiler.endSection();
            return llllllllllllllIllIlIIIIlIlIIlIIl;
        }
        if (Config.isFogOff() && this.mc.entityRenderer.fogStandard) {
            GlStateManager.disableFog();
        }
        this.mc.mcProfiler.endStartSection(String.valueOf(new StringBuilder("render_").append(llllllllllllllIllIlIIIIlIlIlIIll)));
        this.func_174982_a(llllllllllllllIllIlIIIIlIlIlIIll);
        this.mc.mcProfiler.endSection();
        return llllllllllllllIllIlIIIIlIlIIlIIl;
    }
    
    @Override
    public void markBlockForUpdate(final BlockPos llllllllllllllIllIIllllIllllIlIl) {
        final int llllllllllllllIllIIllllIllllIlII = llllllllllllllIllIIllllIllllIlIl.getX();
        final int llllllllllllllIllIIllllIllllIIll = llllllllllllllIllIIllllIllllIlIl.getY();
        final int llllllllllllllIllIIllllIllllIIlI = llllllllllllllIllIIllllIllllIlIl.getZ();
        this.markBlocksForUpdate(llllllllllllllIllIIllllIllllIlII - 1, llllllllllllllIllIIllllIllllIIll - 1, llllllllllllllIllIIllllIllllIIlI - 1, llllllllllllllIllIIllllIllllIlII + 1, llllllllllllllIllIIllllIllllIIll + 1, llllllllllllllIllIIllllIllllIIlI + 1);
    }
    
    public void func_174967_a(final long llllllllllllllIllIIlllllllIlllIl) {
        this.displayListEntitiesDirty |= this.field_174995_M.func_178516_a(llllllllllllllIllIIlllllllIlllIl);
        if (this.chunksToUpdateForced.size() > 0) {
            final Iterator llllllllllllllIllIIllllllllIIlll = this.chunksToUpdateForced.iterator();
            while (llllllllllllllIllIIllllllllIIlll.hasNext()) {
                final RenderChunk llllllllllllllIllIIllllllllIIlIl = llllllllllllllIllIIllllllllIIlll.next();
                if (!this.field_174995_M.func_178507_a(llllllllllllllIllIIllllllllIIlIl)) {
                    break;
                }
                llllllllllllllIllIIllllllllIIlIl.func_178575_a(false);
                llllllllllllllIllIIllllllllIIlll.remove();
                this.field_175009_l.remove(llllllllllllllIllIIllllllllIIlIl);
                this.chunksToResortTransparency.remove(llllllllllllllIllIIllllllllIIlIl);
            }
        }
        if (this.chunksToResortTransparency.size() > 0) {
            final Iterator llllllllllllllIllIIllllllllIIllI = this.chunksToResortTransparency.iterator();
            if (llllllllllllllIllIIllllllllIIllI.hasNext()) {
                final RenderChunk llllllllllllllIllIIllllllllIIlII = llllllllllllllIllIIllllllllIIllI.next();
                if (this.field_174995_M.func_178509_c(llllllllllllllIllIIllllllllIIlII)) {
                    llllllllllllllIllIIllllllllIIllI.remove();
                }
            }
        }
        int llllllllllllllIllIIllllllllIIIll = 0;
        int llllllllllllllIllIIllllllllIIIlI = Config.getUpdatesPerFrame();
        final int llllllllllllllIllIIllllllllIIIIl = llllllllllllllIllIIllllllllIIIlI * 2;
        final Iterator llllllllllllllIllIIllllllllIIIII = this.field_175009_l.iterator();
        while (llllllllllllllIllIIllllllllIIIII.hasNext()) {
            final RenderChunk llllllllllllllIllIIlllllllIlllll = llllllllllllllIllIIllllllllIIIII.next();
            if (!this.field_174995_M.func_178507_a(llllllllllllllIllIIlllllllIlllll)) {
                break;
            }
            llllllllllllllIllIIlllllllIlllll.func_178575_a(false);
            llllllllllllllIllIIllllllllIIIII.remove();
            if (llllllllllllllIllIIlllllllIlllll.func_178571_g().func_178489_a() && llllllllllllllIllIIllllllllIIIlI < llllllllllllllIllIIllllllllIIIIl) {
                ++llllllllllllllIllIIllllllllIIIlI;
            }
            if (++llllllllllllllIllIIllllllllIIIll >= llllllllllllllIllIIllllllllIIIlI) {
                break;
            }
        }
    }
    
    public static void drawOutlinedBoundingBox(final AxisAlignedBB llllllllllllllIllIIlllllIIIlIlII, final int llllllllllllllIllIIlllllIIIlIIll) {
        final Tessellator llllllllllllllIllIIlllllIIIlIllI = Tessellator.getInstance();
        final WorldRenderer llllllllllllllIllIIlllllIIIlIlIl = llllllllllllllIllIIlllllIIIlIllI.getWorldRenderer();
        llllllllllllllIllIIlllllIIIlIlIl.startDrawing(3);
        if (llllllllllllllIllIIlllllIIIlIIll != -1) {
            llllllllllllllIllIIlllllIIIlIlIl.func_178991_c(llllllllllllllIllIIlllllIIIlIIll);
        }
        llllllllllllllIllIIlllllIIIlIlIl.addVertex(llllllllllllllIllIIlllllIIIlIlII.minX, llllllllllllllIllIIlllllIIIlIlII.minY, llllllllllllllIllIIlllllIIIlIlII.minZ);
        llllllllllllllIllIIlllllIIIlIlIl.addVertex(llllllllllllllIllIIlllllIIIlIlII.maxX, llllllllllllllIllIIlllllIIIlIlII.minY, llllllllllllllIllIIlllllIIIlIlII.minZ);
        llllllllllllllIllIIlllllIIIlIlIl.addVertex(llllllllllllllIllIIlllllIIIlIlII.maxX, llllllllllllllIllIIlllllIIIlIlII.minY, llllllllllllllIllIIlllllIIIlIlII.maxZ);
        llllllllllllllIllIIlllllIIIlIlIl.addVertex(llllllllllllllIllIIlllllIIIlIlII.minX, llllllllllllllIllIIlllllIIIlIlII.minY, llllllllllllllIllIIlllllIIIlIlII.maxZ);
        llllllllllllllIllIIlllllIIIlIlIl.addVertex(llllllllllllllIllIIlllllIIIlIlII.minX, llllllllllllllIllIIlllllIIIlIlII.minY, llllllllllllllIllIIlllllIIIlIlII.minZ);
        llllllllllllllIllIIlllllIIIlIllI.draw();
        llllllllllllllIllIIlllllIIIlIlIl.startDrawing(3);
        if (llllllllllllllIllIIlllllIIIlIIll != -1) {
            llllllllllllllIllIIlllllIIIlIlIl.func_178991_c(llllllllllllllIllIIlllllIIIlIIll);
        }
        llllllllllllllIllIIlllllIIIlIlIl.addVertex(llllllllllllllIllIIlllllIIIlIlII.minX, llllllllllllllIllIIlllllIIIlIlII.maxY, llllllllllllllIllIIlllllIIIlIlII.minZ);
        llllllllllllllIllIIlllllIIIlIlIl.addVertex(llllllllllllllIllIIlllllIIIlIlII.maxX, llllllllllllllIllIIlllllIIIlIlII.maxY, llllllllllllllIllIIlllllIIIlIlII.minZ);
        llllllllllllllIllIIlllllIIIlIlIl.addVertex(llllllllllllllIllIIlllllIIIlIlII.maxX, llllllllllllllIllIIlllllIIIlIlII.maxY, llllllllllllllIllIIlllllIIIlIlII.maxZ);
        llllllllllllllIllIIlllllIIIlIlIl.addVertex(llllllllllllllIllIIlllllIIIlIlII.minX, llllllllllllllIllIIlllllIIIlIlII.maxY, llllllllllllllIllIIlllllIIIlIlII.maxZ);
        llllllllllllllIllIIlllllIIIlIlIl.addVertex(llllllllllllllIllIIlllllIIIlIlII.minX, llllllllllllllIllIIlllllIIIlIlII.maxY, llllllllllllllIllIIlllllIIIlIlII.minZ);
        llllllllllllllIllIIlllllIIIlIllI.draw();
        llllllllllllllIllIIlllllIIIlIlIl.startDrawing(1);
        if (llllllllllllllIllIIlllllIIIlIIll != -1) {
            llllllllllllllIllIIlllllIIIlIlIl.func_178991_c(llllllllllllllIllIIlllllIIIlIIll);
        }
        llllllllllllllIllIIlllllIIIlIlIl.addVertex(llllllllllllllIllIIlllllIIIlIlII.minX, llllllllllllllIllIIlllllIIIlIlII.minY, llllllllllllllIllIIlllllIIIlIlII.minZ);
        llllllllllllllIllIIlllllIIIlIlIl.addVertex(llllllllllllllIllIIlllllIIIlIlII.minX, llllllllllllllIllIIlllllIIIlIlII.maxY, llllllllllllllIllIIlllllIIIlIlII.minZ);
        llllllllllllllIllIIlllllIIIlIlIl.addVertex(llllllllllllllIllIIlllllIIIlIlII.maxX, llllllllllllllIllIIlllllIIIlIlII.minY, llllllllllllllIllIIlllllIIIlIlII.minZ);
        llllllllllllllIllIIlllllIIIlIlIl.addVertex(llllllllllllllIllIIlllllIIIlIlII.maxX, llllllllllllllIllIIlllllIIIlIlII.maxY, llllllllllllllIllIIlllllIIIlIlII.minZ);
        llllllllllllllIllIIlllllIIIlIlIl.addVertex(llllllllllllllIllIIlllllIIIlIlII.maxX, llllllllllllllIllIIlllllIIIlIlII.minY, llllllllllllllIllIIlllllIIIlIlII.maxZ);
        llllllllllllllIllIIlllllIIIlIlIl.addVertex(llllllllllllllIllIIlllllIIIlIlII.maxX, llllllllllllllIllIIlllllIIIlIlII.maxY, llllllllllllllIllIIlllllIIIlIlII.maxZ);
        llllllllllllllIllIIlllllIIIlIlIl.addVertex(llllllllllllllIllIIlllllIIIlIlII.minX, llllllllllllllIllIIlllllIIIlIlII.minY, llllllllllllllIllIIlllllIIIlIlII.maxZ);
        llllllllllllllIllIIlllllIIIlIlIl.addVertex(llllllllllllllIllIIlllllIIIlIlII.minX, llllllllllllllIllIIlllllIIIlIlII.maxY, llllllllllllllIllIIlllllIIIlIlII.maxZ);
        llllllllllllllIllIIlllllIIIlIllI.draw();
    }
    
    public void drawSelectionBox(final EntityPlayer llllllllllllllIllIIlllllIIllIIIl, final MovingObjectPosition llllllllllllllIllIIlllllIIllIIII, final int llllllllllllllIllIIlllllIIlIIlII, final float llllllllllllllIllIIlllllIIlIlllI) {
        if (llllllllllllllIllIIlllllIIlIIlII == 0 && llllllllllllllIllIIlllllIIllIIII.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GlStateManager.color(0.0f, 0.0f, 0.0f, 0.4f);
            GL11.glLineWidth(2.0f);
            GlStateManager.func_179090_x();
            if (Config.isShaders()) {
                Shaders.disableTexture2D();
            }
            GlStateManager.depthMask(false);
            final float llllllllllllllIllIIlllllIIlIllIl = 0.002f;
            final BlockPos llllllllllllllIllIIlllllIIlIllII = llllllllllllllIllIIlllllIIllIIII.func_178782_a();
            final Block llllllllllllllIllIIlllllIIlIlIll = this.theWorld.getBlockState(llllllllllllllIllIIlllllIIlIllII).getBlock();
            if (llllllllllllllIllIIlllllIIlIlIll.getMaterial() != Material.air && this.theWorld.getWorldBorder().contains(llllllllllllllIllIIlllllIIlIllII)) {
                llllllllllllllIllIIlllllIIlIlIll.setBlockBoundsBasedOnState(this.theWorld, llllllllllllllIllIIlllllIIlIllII);
                final double llllllllllllllIllIIlllllIIlIlIlI = llllllllllllllIllIIlllllIIllIIIl.lastTickPosX + (llllllllllllllIllIIlllllIIllIIIl.posX - llllllllllllllIllIIlllllIIllIIIl.lastTickPosX) * llllllllllllllIllIIlllllIIlIlllI;
                final double llllllllllllllIllIIlllllIIlIlIIl = llllllllllllllIllIIlllllIIllIIIl.lastTickPosY + (llllllllllllllIllIIlllllIIllIIIl.posY - llllllllllllllIllIIlllllIIllIIIl.lastTickPosY) * llllllllllllllIllIIlllllIIlIlllI;
                final double llllllllllllllIllIIlllllIIlIlIII = llllllllllllllIllIIlllllIIllIIIl.lastTickPosZ + (llllllllllllllIllIIlllllIIllIIIl.posZ - llllllllllllllIllIIlllllIIllIIIl.lastTickPosZ) * llllllllllllllIllIIlllllIIlIlllI;
                drawOutlinedBoundingBox(llllllllllllllIllIIlllllIIlIlIll.getSelectedBoundingBox(this.theWorld, llllllllllllllIllIIlllllIIlIllII).expand(0.0020000000949949026, 0.0020000000949949026, 0.0020000000949949026).offset(-llllllllllllllIllIIlllllIIlIlIlI, -llllllllllllllIllIIlllllIIlIlIIl, -llllllllllllllIllIIlllllIIlIlIII), -1);
            }
            GlStateManager.depthMask(true);
            GlStateManager.func_179098_w();
            if (Config.isShaders()) {
                Shaders.enableTexture2D();
            }
            GlStateManager.disableBlend();
        }
    }
    
    @Override
    public void onEntityRemoved(final Entity llllllllllllllIllIIllllIIIlIIlII) {
        if (Config.isDynamicLights()) {
            DynamicLights.entityRemoved(llllllllllllllIllIIllllIIIlIIlII, this);
        }
    }
    
    private void func_174964_o() {
        final Tessellator llllllllllllllIllIlIIIllIlIlIlII = Tessellator.getInstance();
        final WorldRenderer llllllllllllllIllIlIIIllIlIlIIll = llllllllllllllIllIlIIIllIlIlIlII.getWorldRenderer();
        if (this.field_175011_u != null) {
            this.field_175011_u.func_177362_c();
        }
        if (this.glSkyList2 >= 0) {
            GLAllocation.deleteDisplayLists(this.glSkyList2);
            this.glSkyList2 = -1;
        }
        if (this.field_175005_X) {
            this.field_175011_u = new VertexBuffer(this.field_175014_r);
            this.func_174968_a(llllllllllllllIllIlIIIllIlIlIIll, -16.0f, true);
            llllllllllllllIllIlIIIllIlIlIIll.draw();
            llllllllllllllIllIlIIIllIlIlIIll.reset();
            this.field_175011_u.func_177360_a(llllllllllllllIllIlIIIllIlIlIIll.func_178966_f(), llllllllllllllIllIlIIIllIlIlIIll.func_178976_e());
        }
        else {
            this.glSkyList2 = GLAllocation.generateDisplayLists(1);
            GL11.glNewList(this.glSkyList2, 4864);
            this.func_174968_a(llllllllllllllIllIlIIIllIlIlIIll, -16.0f, true);
            llllllllllllllIllIlIIIllIlIlIlII.draw();
            GL11.glEndList();
        }
    }
    
    public void func_180449_a(final Entity llllllllllllllIllIIllllllIlllIll, final float llllllllllllllIllIIllllllIlllIlI) {
        final Tessellator llllllllllllllIllIIllllllIlllIIl = Tessellator.getInstance();
        final WorldRenderer llllllllllllllIllIIllllllIlllIII = llllllllllllllIllIIllllllIlllIIl.getWorldRenderer();
        final WorldBorder llllllllllllllIllIIllllllIllIlll = this.theWorld.getWorldBorder();
        final double llllllllllllllIllIIllllllIllIllI = this.mc.gameSettings.renderDistanceChunks * 16;
        if (llllllllllllllIllIIllllllIlllIll.posX >= llllllllllllllIllIIllllllIllIlll.maxX() - llllllllllllllIllIIllllllIllIllI || llllllllllllllIllIIllllllIlllIll.posX <= llllllllllllllIllIIllllllIllIlll.minX() + llllllllllllllIllIIllllllIllIllI || llllllllllllllIllIIllllllIlllIll.posZ >= llllllllllllllIllIIllllllIllIlll.maxZ() - llllllllllllllIllIIllllllIllIllI || llllllllllllllIllIIllllllIlllIll.posZ <= llllllllllllllIllIIllllllIllIlll.minZ() + llllllllllllllIllIIllllllIllIllI) {
            double llllllllllllllIllIIllllllIllIlIl = 1.0 - llllllllllllllIllIIllllllIllIlll.getClosestDistance(llllllllllllllIllIIllllllIlllIll) / llllllllllllllIllIIllllllIllIllI;
            llllllllllllllIllIIllllllIllIlIl = Math.pow(llllllllllllllIllIIllllllIllIlIl, 4.0);
            final double llllllllllllllIllIIllllllIllIlII = llllllllllllllIllIIllllllIlllIll.lastTickPosX + (llllllllllllllIllIIllllllIlllIll.posX - llllllllllllllIllIIllllllIlllIll.lastTickPosX) * llllllllllllllIllIIllllllIlllIlI;
            final double llllllllllllllIllIIllllllIllIIll = llllllllllllllIllIIllllllIlllIll.lastTickPosY + (llllllllllllllIllIIllllllIlllIll.posY - llllllllllllllIllIIllllllIlllIll.lastTickPosY) * llllllllllllllIllIIllllllIlllIlI;
            final double llllllllllllllIllIIllllllIllIIlI = llllllllllllllIllIIllllllIlllIll.lastTickPosZ + (llllllllllllllIllIIllllllIlllIll.posZ - llllllllllllllIllIIllllllIlllIll.lastTickPosZ) * llllllllllllllIllIIllllllIlllIlI;
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 1, 1, 0);
            this.renderEngine.bindTexture(RenderGlobal.field_175006_g);
            GlStateManager.depthMask(false);
            GlStateManager.pushMatrix();
            final int llllllllllllllIllIIllllllIllIIIl = llllllllllllllIllIIllllllIllIlll.getStatus().func_177766_a();
            final float llllllllllllllIllIIllllllIllIIII = (llllllllllllllIllIIllllllIllIIIl >> 16 & 0xFF) / 255.0f;
            final float llllllllllllllIllIIllllllIlIllll = (llllllllllllllIllIIllllllIllIIIl >> 8 & 0xFF) / 255.0f;
            final float llllllllllllllIllIIllllllIlIlllI = (llllllllllllllIllIIllllllIllIIIl & 0xFF) / 255.0f;
            GlStateManager.color(llllllllllllllIllIIllllllIllIIII, llllllllllllllIllIIllllllIlIllll, llllllllllllllIllIIllllllIlIlllI, (float)llllllllllllllIllIIllllllIllIlIl);
            GlStateManager.doPolygonOffset(-3.0f, -3.0f);
            GlStateManager.enablePolygonOffset();
            GlStateManager.alphaFunc(516, 0.1f);
            GlStateManager.enableAlpha();
            GlStateManager.disableCull();
            final float llllllllllllllIllIIllllllIlIllIl = Minecraft.getSystemTime() % 3000L / 3000.0f;
            final float llllllllllllllIllIIllllllIlIllII = 0.0f;
            final float llllllllllllllIllIIllllllIlIlIll = 0.0f;
            final float llllllllllllllIllIIllllllIlIlIlI = 128.0f;
            llllllllllllllIllIIllllllIlllIII.startDrawingQuads();
            llllllllllllllIllIIllllllIlllIII.setTranslation(-llllllllllllllIllIIllllllIllIlII, -llllllllllllllIllIIllllllIllIIll, -llllllllllllllIllIIllllllIllIIlI);
            llllllllllllllIllIIllllllIlllIII.markDirty();
            double llllllllllllllIllIIllllllIlIlIIl = Math.max(MathHelper.floor_double(llllllllllllllIllIIllllllIllIIlI - llllllllllllllIllIIllllllIllIllI), llllllllllllllIllIIllllllIllIlll.minZ());
            double llllllllllllllIllIIllllllIlIlIII = Math.min(MathHelper.ceiling_double_int(llllllllllllllIllIIllllllIllIIlI + llllllllllllllIllIIllllllIllIllI), llllllllllllllIllIIllllllIllIlll.maxZ());
            if (llllllllllllllIllIIllllllIllIlII > llllllllllllllIllIIllllllIllIlll.maxX() - llllllllllllllIllIIllllllIllIllI) {
                float llllllllllllllIllIIllllllIlIIlll = 0.0f;
                for (double llllllllllllllIllIIllllllIlIIIll = llllllllllllllIllIIllllllIlIlIIl; llllllllllllllIllIIllllllIlIIIll < llllllllllllllIllIIllllllIlIlIII; ++llllllllllllllIllIIllllllIlIIIll, llllllllllllllIllIIllllllIlIIlll += 0.5f) {
                    final double llllllllllllllIllIIllllllIIlllll = Math.min(1.0, llllllllllllllIllIIllllllIlIlIII - llllllllllllllIllIIllllllIlIIIll);
                    final float llllllllllllllIllIIllllllIIllIll = (float)llllllllllllllIllIIllllllIIlllll * 0.5f;
                    llllllllllllllIllIIllllllIlllIII.addVertexWithUV(llllllllllllllIllIIllllllIllIlll.maxX(), 256.0, llllllllllllllIllIIllllllIlIIIll, llllllllllllllIllIIllllllIlIllIl + llllllllllllllIllIIllllllIlIIlll, llllllllllllllIllIIllllllIlIllIl + 0.0f);
                    llllllllllllllIllIIllllllIlllIII.addVertexWithUV(llllllllllllllIllIIllllllIllIlll.maxX(), 256.0, llllllllllllllIllIIllllllIlIIIll + llllllllllllllIllIIllllllIIlllll, llllllllllllllIllIIllllllIlIllIl + llllllllllllllIllIIllllllIIllIll + llllllllllllllIllIIllllllIlIIlll, llllllllllllllIllIIllllllIlIllIl + 0.0f);
                    llllllllllllllIllIIllllllIlllIII.addVertexWithUV(llllllllllllllIllIIllllllIllIlll.maxX(), 0.0, llllllllllllllIllIIllllllIlIIIll + llllllllllllllIllIIllllllIIlllll, llllllllllllllIllIIllllllIlIllIl + llllllllllllllIllIIllllllIIllIll + llllllllllllllIllIIllllllIlIIlll, llllllllllllllIllIIllllllIlIllIl + 128.0f);
                    llllllllllllllIllIIllllllIlllIII.addVertexWithUV(llllllllllllllIllIIllllllIllIlll.maxX(), 0.0, llllllllllllllIllIIllllllIlIIIll, llllllllllllllIllIIllllllIlIllIl + llllllllllllllIllIIllllllIlIIlll, llllllllllllllIllIIllllllIlIllIl + 128.0f);
                }
            }
            if (llllllllllllllIllIIllllllIllIlII < llllllllllllllIllIIllllllIllIlll.minX() + llllllllllllllIllIIllllllIllIllI) {
                float llllllllllllllIllIIllllllIlIIllI = 0.0f;
                for (double llllllllllllllIllIIllllllIlIIIlI = llllllllllllllIllIIllllllIlIlIIl; llllllllllllllIllIIllllllIlIIIlI < llllllllllllllIllIIllllllIlIlIII; ++llllllllllllllIllIIllllllIlIIIlI, llllllllllllllIllIIllllllIlIIllI += 0.5f) {
                    final double llllllllllllllIllIIllllllIIllllI = Math.min(1.0, llllllllllllllIllIIllllllIlIlIII - llllllllllllllIllIIllllllIlIIIlI);
                    final float llllllllllllllIllIIllllllIIllIlI = (float)llllllllllllllIllIIllllllIIllllI * 0.5f;
                    llllllllllllllIllIIllllllIlllIII.addVertexWithUV(llllllllllllllIllIIllllllIllIlll.minX(), 256.0, llllllllllllllIllIIllllllIlIIIlI, llllllllllllllIllIIllllllIlIllIl + llllllllllllllIllIIllllllIlIIllI, llllllllllllllIllIIllllllIlIllIl + 0.0f);
                    llllllllllllllIllIIllllllIlllIII.addVertexWithUV(llllllllllllllIllIIllllllIllIlll.minX(), 256.0, llllllllllllllIllIIllllllIlIIIlI + llllllllllllllIllIIllllllIIllllI, llllllllllllllIllIIllllllIlIllIl + llllllllllllllIllIIllllllIIllIlI + llllllllllllllIllIIllllllIlIIllI, llllllllllllllIllIIllllllIlIllIl + 0.0f);
                    llllllllllllllIllIIllllllIlllIII.addVertexWithUV(llllllllllllllIllIIllllllIllIlll.minX(), 0.0, llllllllllllllIllIIllllllIlIIIlI + llllllllllllllIllIIllllllIIllllI, llllllllllllllIllIIllllllIlIllIl + llllllllllllllIllIIllllllIIllIlI + llllllllllllllIllIIllllllIlIIllI, llllllllllllllIllIIllllllIlIllIl + 128.0f);
                    llllllllllllllIllIIllllllIlllIII.addVertexWithUV(llllllllllllllIllIIllllllIllIlll.minX(), 0.0, llllllllllllllIllIIllllllIlIIIlI, llllllllllllllIllIIllllllIlIllIl + llllllllllllllIllIIllllllIlIIllI, llllllllllllllIllIIllllllIlIllIl + 128.0f);
                }
            }
            llllllllllllllIllIIllllllIlIlIIl = Math.max(MathHelper.floor_double(llllllllllllllIllIIllllllIllIlII - llllllllllllllIllIIllllllIllIllI), llllllllllllllIllIIllllllIllIlll.minX());
            llllllllllllllIllIIllllllIlIlIII = Math.min(MathHelper.ceiling_double_int(llllllllllllllIllIIllllllIllIlII + llllllllllllllIllIIllllllIllIllI), llllllllllllllIllIIllllllIllIlll.maxX());
            if (llllllllllllllIllIIllllllIllIIlI > llllllllllllllIllIIllllllIllIlll.maxZ() - llllllllllllllIllIIllllllIllIllI) {
                float llllllllllllllIllIIllllllIlIIlIl = 0.0f;
                for (double llllllllllllllIllIIllllllIlIIIIl = llllllllllllllIllIIllllllIlIlIIl; llllllllllllllIllIIllllllIlIIIIl < llllllllllllllIllIIllllllIlIlIII; ++llllllllllllllIllIIllllllIlIIIIl, llllllllllllllIllIIllllllIlIIlIl += 0.5f) {
                    final double llllllllllllllIllIIllllllIIlllIl = Math.min(1.0, llllllllllllllIllIIllllllIlIlIII - llllllllllllllIllIIllllllIlIIIIl);
                    final float llllllllllllllIllIIllllllIIllIIl = (float)llllllllllllllIllIIllllllIIlllIl * 0.5f;
                    llllllllllllllIllIIllllllIlllIII.addVertexWithUV(llllllllllllllIllIIllllllIlIIIIl, 256.0, llllllllllllllIllIIllllllIllIlll.maxZ(), llllllllllllllIllIIllllllIlIllIl + llllllllllllllIllIIllllllIlIIlIl, llllllllllllllIllIIllllllIlIllIl + 0.0f);
                    llllllllllllllIllIIllllllIlllIII.addVertexWithUV(llllllllllllllIllIIllllllIlIIIIl + llllllllllllllIllIIllllllIIlllIl, 256.0, llllllllllllllIllIIllllllIllIlll.maxZ(), llllllllllllllIllIIllllllIlIllIl + llllllllllllllIllIIllllllIIllIIl + llllllllllllllIllIIllllllIlIIlIl, llllllllllllllIllIIllllllIlIllIl + 0.0f);
                    llllllllllllllIllIIllllllIlllIII.addVertexWithUV(llllllllllllllIllIIllllllIlIIIIl + llllllllllllllIllIIllllllIIlllIl, 0.0, llllllllllllllIllIIllllllIllIlll.maxZ(), llllllllllllllIllIIllllllIlIllIl + llllllllllllllIllIIllllllIIllIIl + llllllllllllllIllIIllllllIlIIlIl, llllllllllllllIllIIllllllIlIllIl + 128.0f);
                    llllllllllllllIllIIllllllIlllIII.addVertexWithUV(llllllllllllllIllIIllllllIlIIIIl, 0.0, llllllllllllllIllIIllllllIllIlll.maxZ(), llllllllllllllIllIIllllllIlIllIl + llllllllllllllIllIIllllllIlIIlIl, llllllllllllllIllIIllllllIlIllIl + 128.0f);
                }
            }
            if (llllllllllllllIllIIllllllIllIIlI < llllllllllllllIllIIllllllIllIlll.minZ() + llllllllllllllIllIIllllllIllIllI) {
                float llllllllllllllIllIIllllllIlIIlII = 0.0f;
                for (double llllllllllllllIllIIllllllIlIIIII = llllllllllllllIllIIllllllIlIlIIl; llllllllllllllIllIIllllllIlIIIII < llllllllllllllIllIIllllllIlIlIII; ++llllllllllllllIllIIllllllIlIIIII, llllllllllllllIllIIllllllIlIIlII += 0.5f) {
                    final double llllllllllllllIllIIllllllIIlllII = Math.min(1.0, llllllllllllllIllIIllllllIlIlIII - llllllllllllllIllIIllllllIlIIIII);
                    final float llllllllllllllIllIIllllllIIllIII = (float)llllllllllllllIllIIllllllIIlllII * 0.5f;
                    llllllllllllllIllIIllllllIlllIII.addVertexWithUV(llllllllllllllIllIIllllllIlIIIII, 256.0, llllllllllllllIllIIllllllIllIlll.minZ(), llllllllllllllIllIIllllllIlIllIl + llllllllllllllIllIIllllllIlIIlII, llllllllllllllIllIIllllllIlIllIl + 0.0f);
                    llllllllllllllIllIIllllllIlllIII.addVertexWithUV(llllllllllllllIllIIllllllIlIIIII + llllllllllllllIllIIllllllIIlllII, 256.0, llllllllllllllIllIIllllllIllIlll.minZ(), llllllllllllllIllIIllllllIlIllIl + llllllllllllllIllIIllllllIIllIII + llllllllllllllIllIIllllllIlIIlII, llllllllllllllIllIIllllllIlIllIl + 0.0f);
                    llllllllllllllIllIIllllllIlllIII.addVertexWithUV(llllllllllllllIllIIllllllIlIIIII + llllllllllllllIllIIllllllIIlllII, 0.0, llllllllllllllIllIIllllllIllIlll.minZ(), llllllllllllllIllIIllllllIlIllIl + llllllllllllllIllIIllllllIIllIII + llllllllllllllIllIIllllllIlIIlII, llllllllllllllIllIIllllllIlIllIl + 128.0f);
                    llllllllllllllIllIIllllllIlllIII.addVertexWithUV(llllllllllllllIllIIllllllIlIIIII, 0.0, llllllllllllllIllIIllllllIllIlll.minZ(), llllllllllllllIllIIllllllIlIllIl + llllllllllllllIllIIllllllIlIIlII, llllllllllllllIllIIllllllIlIllIl + 128.0f);
                }
            }
            llllllllllllllIllIIllllllIlllIIl.draw();
            llllllllllllllIllIIllllllIlllIII.setTranslation(0.0, 0.0, 0.0);
            GlStateManager.enableCull();
            GlStateManager.disableAlpha();
            GlStateManager.doPolygonOffset(0.0f, 0.0f);
            GlStateManager.disablePolygonOffset();
            GlStateManager.enableAlpha();
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
            GlStateManager.depthMask(true);
        }
    }
    
    private void func_174971_n() {
        final TextureMap llllllllllllllIllIlIIIllIllIllIl = this.mc.getTextureMapBlocks();
        for (int llllllllllllllIllIlIIIllIllIllII = 0; llllllllllllllIllIlIIIllIllIllII < this.destroyBlockIcons.length; ++llllllllllllllIllIlIIIllIllIllII) {
            this.destroyBlockIcons[llllllllllllllIllIlIIIllIllIllII] = llllllllllllllIllIlIIIllIllIllIl.getAtlasSprite(String.valueOf(new StringBuilder("minecraft:blocks/destroy_stage_").append(llllllllllllllIllIlIIIllIllIllII)));
        }
    }
    
    private EntityFX func_174974_b(final int llllllllllllllIllIIllllIIlIlIIII, final boolean llllllllllllllIllIIllllIIIlllllI, final double llllllllllllllIllIIllllIIIllllIl, final double llllllllllllllIllIIllllIIIllllII, final double llllllllllllllIllIIllllIIlIIllII, final double llllllllllllllIllIIllllIIIlllIlI, final double llllllllllllllIllIIllllIIIlllIIl, final double llllllllllllllIllIIllllIIlIIlIIl, final int... llllllllllllllIllIIllllIIlIIlIII) {
        if (this.mc == null || this.mc.func_175606_aa() == null || this.mc.effectRenderer == null) {
            return null;
        }
        int llllllllllllllIllIIllllIIlIIIlll = this.mc.gameSettings.particleSetting;
        if (llllllllllllllIllIIllllIIlIIIlll == 1 && this.theWorld.rand.nextInt(3) == 0) {
            llllllllllllllIllIIllllIIlIIIlll = 2;
        }
        final double llllllllllllllIllIIllllIIlIIIllI = this.mc.func_175606_aa().posX - llllllllllllllIllIIllllIIIllllIl;
        final double llllllllllllllIllIIllllIIlIIIlIl = this.mc.func_175606_aa().posY - llllllllllllllIllIIllllIIIllllII;
        final double llllllllllllllIllIIllllIIlIIIlII = this.mc.func_175606_aa().posZ - llllllllllllllIllIIllllIIlIIllII;
        if (llllllllllllllIllIIllllIIlIlIIII == EnumParticleTypes.EXPLOSION_HUGE.func_179348_c() && !Config.isAnimatedExplosion()) {
            return null;
        }
        if (llllllllllllllIllIIllllIIlIlIIII == EnumParticleTypes.EXPLOSION_LARGE.func_179348_c() && !Config.isAnimatedExplosion()) {
            return null;
        }
        if (llllllllllllllIllIIllllIIlIlIIII == EnumParticleTypes.EXPLOSION_NORMAL.func_179348_c() && !Config.isAnimatedExplosion()) {
            return null;
        }
        if (llllllllllllllIllIIllllIIlIlIIII == EnumParticleTypes.SUSPENDED.func_179348_c() && !Config.isWaterParticles()) {
            return null;
        }
        if (llllllllllllllIllIIllllIIlIlIIII == EnumParticleTypes.SUSPENDED_DEPTH.func_179348_c() && !Config.isVoidParticles()) {
            return null;
        }
        if (llllllllllllllIllIIllllIIlIlIIII == EnumParticleTypes.SMOKE_NORMAL.func_179348_c() && !Config.isAnimatedSmoke()) {
            return null;
        }
        if (llllllllllllllIllIIllllIIlIlIIII == EnumParticleTypes.SMOKE_LARGE.func_179348_c() && !Config.isAnimatedSmoke()) {
            return null;
        }
        if (llllllllllllllIllIIllllIIlIlIIII == EnumParticleTypes.SPELL_MOB.func_179348_c() && !Config.isPotionParticles()) {
            return null;
        }
        if (llllllllllllllIllIIllllIIlIlIIII == EnumParticleTypes.SPELL_MOB_AMBIENT.func_179348_c() && !Config.isPotionParticles()) {
            return null;
        }
        if (llllllllllllllIllIIllllIIlIlIIII == EnumParticleTypes.SPELL.func_179348_c() && !Config.isPotionParticles()) {
            return null;
        }
        if (llllllllllllllIllIIllllIIlIlIIII == EnumParticleTypes.SPELL_INSTANT.func_179348_c() && !Config.isPotionParticles()) {
            return null;
        }
        if (llllllllllllllIllIIllllIIlIlIIII == EnumParticleTypes.SPELL_WITCH.func_179348_c() && !Config.isPotionParticles()) {
            return null;
        }
        if (llllllllllllllIllIIllllIIlIlIIII == EnumParticleTypes.PORTAL.func_179348_c() && !Config.isAnimatedPortal()) {
            return null;
        }
        if (llllllllllllllIllIIllllIIlIlIIII == EnumParticleTypes.FLAME.func_179348_c() && !Config.isAnimatedFlame()) {
            return null;
        }
        if (llllllllllllllIllIIllllIIlIlIIII == EnumParticleTypes.REDSTONE.func_179348_c() && !Config.isAnimatedRedstone()) {
            return null;
        }
        if (llllllllllllllIllIIllllIIlIlIIII == EnumParticleTypes.DRIP_WATER.func_179348_c() && !Config.isDrippingWaterLava()) {
            return null;
        }
        if (llllllllllllllIllIIllllIIlIlIIII == EnumParticleTypes.DRIP_LAVA.func_179348_c() && !Config.isDrippingWaterLava()) {
            return null;
        }
        if (llllllllllllllIllIIllllIIlIlIIII == EnumParticleTypes.FIREWORKS_SPARK.func_179348_c() && !Config.isFireworkParticles()) {
            return null;
        }
        if (llllllllllllllIllIIllllIIIlllllI) {
            return this.mc.effectRenderer.func_178927_a(llllllllllllllIllIIllllIIlIlIIII, llllllllllllllIllIIllllIIIllllIl, llllllllllllllIllIIllllIIIllllII, llllllllllllllIllIIllllIIlIIllII, llllllllllllllIllIIllllIIIlllIlI, llllllllllllllIllIIllllIIIlllIIl, llllllllllllllIllIIllllIIlIIlIIl, llllllllllllllIllIIllllIIlIIlIII);
        }
        final double llllllllllllllIllIIllllIIlIIIIll = 16.0;
        double llllllllllllllIllIIllllIIlIIIIlI = 256.0;
        if (llllllllllllllIllIIllllIIlIlIIII == EnumParticleTypes.CRIT.func_179348_c()) {
            llllllllllllllIllIIllllIIlIIIIlI = 38416.0;
        }
        if (llllllllllllllIllIIllllIIlIIIllI * llllllllllllllIllIIllllIIlIIIllI + llllllllllllllIllIIllllIIlIIIlIl * llllllllllllllIllIIllllIIlIIIlIl + llllllllllllllIllIIllllIIlIIIlII * llllllllllllllIllIIllllIIlIIIlII > llllllllllllllIllIIllllIIlIIIIlI) {
            return null;
        }
        if (llllllllllllllIllIIllllIIlIIIlll > 1) {
            return null;
        }
        final EntityFX llllllllllllllIllIIllllIIlIIIIIl = this.mc.effectRenderer.func_178927_a(llllllllllllllIllIIllllIIlIlIIII, llllllllllllllIllIIllllIIIllllIl, llllllllllllllIllIIllllIIIllllII, llllllllllllllIllIIllllIIlIIllII, llllllllllllllIllIIllllIIIlllIlI, llllllllllllllIllIIllllIIIlllIIl, llllllllllllllIllIIllllIIlIIlIIl, llllllllllllllIllIIllllIIlIIlIII);
        if (llllllllllllllIllIIllllIIlIlIIII == EnumParticleTypes.WATER_BUBBLE.func_179348_c()) {
            CustomColors.updateWaterFX(llllllllllllllIllIIllllIIlIIIIIl, this.theWorld, llllllllllllllIllIIllllIIIllllIl, llllllllllllllIllIIllllIIIllllII, llllllllllllllIllIIllllIIlIIllII);
        }
        if (llllllllllllllIllIIllllIIlIlIIII == EnumParticleTypes.WATER_SPLASH.func_179348_c()) {
            CustomColors.updateWaterFX(llllllllllllllIllIIllllIIlIIIIIl, this.theWorld, llllllllllllllIllIIllllIIIllllIl, llllllllllllllIllIIllllIIIllllII, llllllllllllllIllIIllllIIlIIllII);
        }
        if (llllllllllllllIllIIllllIIlIlIIII == EnumParticleTypes.WATER_DROP.func_179348_c()) {
            CustomColors.updateWaterFX(llllllllllllllIllIIllllIIlIIIIIl, this.theWorld, llllllllllllllIllIIllllIIIllllIl, llllllllllllllIllIIllllIIIllllII, llllllllllllllIllIIllllIIlIIllII);
        }
        if (llllllllllllllIllIIllllIIlIlIIII == EnumParticleTypes.TOWN_AURA.func_179348_c()) {
            CustomColors.updateMyceliumFX(llllllllllllllIllIIllllIIlIIIIIl);
        }
        if (llllllllllllllIllIIllllIIlIlIIII == EnumParticleTypes.PORTAL.func_179348_c()) {
            CustomColors.updatePortalFX(llllllllllllllIllIIllllIIlIIIIIl);
        }
        if (llllllllllllllIllIIllllIIlIlIIII == EnumParticleTypes.REDSTONE.func_179348_c()) {
            CustomColors.updateReddustFX(llllllllllllllIllIIllllIIlIIIIIl, this.theWorld, llllllllllllllIllIIllllIIIllllIl, llllllllllllllIllIIllllIIIllllII, llllllllllllllIllIIllllIIlIIllII);
        }
        return llllllllllllllIllIIllllIIlIIIIIl;
    }
    
    @Override
    public void markBlockRangeForRenderUpdate(final int llllllllllllllIllIIllllIllIIlllI, final int llllllllllllllIllIIllllIllIlIlII, final int llllllllllllllIllIIllllIllIIllII, final int llllllllllllllIllIIllllIllIIlIll, final int llllllllllllllIllIIllllIllIIlIlI, final int llllllllllllllIllIIllllIllIIlIIl) {
        this.markBlocksForUpdate(llllllllllllllIllIIllllIllIIlllI - 1, llllllllllllllIllIIllllIllIlIlII - 1, llllllllllllllIllIIllllIllIIllII - 1, llllllllllllllIllIIllllIllIIlIll + 1, llllllllllllllIllIIllllIllIIlIlI + 1, llllllllllllllIllIIllllIllIIlIIl + 1);
    }
    
    public String getDebugInfoEntities() {
        return String.valueOf(new StringBuilder("E: ").append(this.countEntitiesRendered).append("/").append(this.countEntitiesTotal).append(", B: ").append(this.countEntitiesHidden).append(", I: ").append(this.countEntitiesTotal - this.countEntitiesHidden - this.countEntitiesRendered).append(", ").append(Config.getVersionDebug()));
    }
    
    protected void func_174986_e() {
        this.field_175009_l.clear();
        this.field_174995_M.func_178514_b();
    }
    
    public void deleteAllDisplayLists() {
    }
    
    @Override
    public void onEntityAdded(final Entity llllllllllllllIllIIllllIIIlIlIlI) {
        RandomMobs.entityLoaded(llllllllllllllIllIIllllIIIlIlIlI, this.theWorld);
        if (Config.isDynamicLights()) {
            DynamicLights.entityAdded(llllllllllllllIllIIllllIIIlIlIlI, this);
        }
    }
    
    public void func_174970_a(final Entity llllllllllllllIllIlIIIlIIIIlIIIl, final double llllllllllllllIllIlIIIlIIIIlIIII, ICamera llllllllllllllIllIlIIIIllllIIIIl, final int llllllllllllllIllIlIIIIllllIIIII, final boolean llllllllllllllIllIlIIIIlllIlllll) {
        if (this.mc.gameSettings.renderDistanceChunks != this.renderDistanceChunks) {
            this.loadRenderers();
        }
        this.theWorld.theProfiler.startSection("camera");
        final double llllllllllllllIllIlIIIlIIIIIllII = llllllllllllllIllIlIIIlIIIIlIIIl.posX - this.field_174992_B;
        final double llllllllllllllIllIlIIIlIIIIIlIll = llllllllllllllIllIlIIIlIIIIlIIIl.posY - this.field_174993_C;
        final double llllllllllllllIllIlIIIlIIIIIlIlI = llllllllllllllIllIlIIIlIIIIlIIIl.posZ - this.field_174987_D;
        if (this.field_174988_E != llllllllllllllIllIlIIIlIIIIlIIIl.chunkCoordX || this.field_174989_F != llllllllllllllIllIlIIIlIIIIlIIIl.chunkCoordY || this.field_174990_G != llllllllllllllIllIlIIIlIIIIlIIIl.chunkCoordZ || llllllllllllllIllIlIIIlIIIIIllII * llllllllllllllIllIlIIIlIIIIIllII + llllllllllllllIllIlIIIlIIIIIlIll * llllllllllllllIllIlIIIlIIIIIlIll + llllllllllllllIllIlIIIlIIIIIlIlI * llllllllllllllIllIlIIIlIIIIIlIlI > 16.0) {
            this.field_174992_B = llllllllllllllIllIlIIIlIIIIlIIIl.posX;
            this.field_174993_C = llllllllllllllIllIlIIIlIIIIlIIIl.posY;
            this.field_174987_D = llllllllllllllIllIlIIIlIIIIlIIIl.posZ;
            this.field_174988_E = llllllllllllllIllIlIIIlIIIIlIIIl.chunkCoordX;
            this.field_174989_F = llllllllllllllIllIlIIIlIIIIlIIIl.chunkCoordY;
            this.field_174990_G = llllllllllllllIllIlIIIlIIIIlIIIl.chunkCoordZ;
            this.field_175008_n.func_178163_a(llllllllllllllIllIlIIIlIIIIlIIIl.posX, llllllllllllllIllIlIIIlIIIIlIIIl.posZ);
        }
        if (Config.isDynamicLights()) {
            DynamicLights.update(this);
        }
        this.theWorld.theProfiler.endStartSection("renderlistcamera");
        final double llllllllllllllIllIlIIIlIIIIIlIIl = llllllllllllllIllIlIIIlIIIIlIIIl.lastTickPosX + (llllllllllllllIllIlIIIlIIIIlIIIl.posX - llllllllllllllIllIlIIIlIIIIlIIIl.lastTickPosX) * llllllllllllllIllIlIIIlIIIIlIIII;
        final double llllllllllllllIllIlIIIlIIIIIlIII = llllllllllllllIllIlIIIlIIIIlIIIl.lastTickPosY + (llllllllllllllIllIlIIIlIIIIlIIIl.posY - llllllllllllllIllIlIIIlIIIIlIIIl.lastTickPosY) * llllllllllllllIllIlIIIlIIIIlIIII;
        final double llllllllllllllIllIlIIIlIIIIIIlll = llllllllllllllIllIlIIIlIIIIlIIIl.lastTickPosZ + (llllllllllllllIllIlIIIlIIIIlIIIl.posZ - llllllllllllllIllIlIIIlIIIIlIIIl.lastTickPosZ) * llllllllllllllIllIlIIIlIIIIlIIII;
        this.field_174996_N.func_178004_a(llllllllllllllIllIlIIIlIIIIIlIIl, llllllllllllllIllIlIIIlIIIIIlIII, llllllllllllllIllIlIIIlIIIIIIlll);
        this.theWorld.theProfiler.endStartSection("cull");
        if (this.field_175001_U != null) {
            final Frustrum llllllllllllllIllIlIIIlIIIIIIllI = new Frustrum(this.field_175001_U);
            llllllllllllllIllIlIIIlIIIIIIllI.setPosition(this.field_175003_W.x, this.field_175003_W.y, this.field_175003_W.z);
            llllllllllllllIllIlIIIIllllIIIIl = llllllllllllllIllIlIIIlIIIIIIllI;
        }
        this.mc.mcProfiler.endStartSection("culling");
        final BlockPos llllllllllllllIllIlIIIlIIIIIIlIl = new BlockPos(llllllllllllllIllIlIIIlIIIIIlIIl, llllllllllllllIllIlIIIlIIIIIlIII + llllllllllllllIllIlIIIlIIIIlIIIl.getEyeHeight(), llllllllllllllIllIlIIIlIIIIIIlll);
        final RenderChunk llllllllllllllIllIlIIIlIIIIIIlII = this.field_175008_n.func_178161_a(llllllllllllllIllIlIIIlIIIIIIlIl);
        final BlockPos llllllllllllllIllIlIIIlIIIIIIIll = new BlockPos(MathHelper.floor_double(llllllllllllllIllIlIIIlIIIIIlIIl) / 16 * 16, MathHelper.floor_double(llllllllllllllIllIlIIIlIIIIIlIII) / 16 * 16, MathHelper.floor_double(llllllllllllllIllIlIIIlIIIIIIlll) / 16 * 16);
        this.displayListEntitiesDirty = (this.displayListEntitiesDirty || !this.field_175009_l.isEmpty() || llllllllllllllIllIlIIIlIIIIlIIIl.posX != this.field_174997_H || llllllllllllllIllIlIIIlIIIIlIIIl.posY != this.field_174998_I || llllllllllllllIllIlIIIlIIIIlIIIl.posZ != this.field_174999_J || llllllllllllllIllIlIIIlIIIIlIIIl.rotationPitch != this.field_175000_K || llllllllllllllIllIlIIIlIIIIlIIIl.rotationYaw != this.field_174994_L);
        this.field_174997_H = llllllllllllllIllIlIIIlIIIIlIIIl.posX;
        this.field_174998_I = llllllllllllllIllIlIIIlIIIIlIIIl.posY;
        this.field_174999_J = llllllllllllllIllIlIIIlIIIIlIIIl.posZ;
        this.field_175000_K = llllllllllllllIllIlIIIlIIIIlIIIl.rotationPitch;
        this.field_174994_L = llllllllllllllIllIlIIIlIIIIlIIIl.rotationYaw;
        final boolean llllllllllllllIllIlIIIlIIIIIIIlI = this.field_175001_U != null;
        Lagometer.timerVisibility.start();
        if (Shaders.isShadowPass) {
            this.glRenderLists = this.renderInfosShadow;
            this.renderInfosEntities = this.renderInfosEntitiesShadow;
            this.renderInfosTileEntities = this.renderInfosTileEntitiesShadow;
            if (!llllllllllllllIllIlIIIlIIIIIIIlI && this.displayListEntitiesDirty) {
                this.glRenderLists.clear();
                this.renderInfosEntities.clear();
                this.renderInfosTileEntities.clear();
                final RenderInfoLazy llllllllllllllIllIlIIIlIIIIIIIIl = new RenderInfoLazy();
                for (int llllllllllllllIllIlIIIlIIIIIIIII = 0; llllllllllllllIllIlIIIlIIIIIIIII < this.field_175008_n.field_178164_f.length; ++llllllllllllllIllIlIIIlIIIIIIIII) {
                    final RenderChunk llllllllllllllIllIlIIIIlllllllll = this.field_175008_n.field_178164_f[llllllllllllllIllIlIIIlIIIIIIIII];
                    llllllllllllllIllIlIIIlIIIIIIIIl.setRenderChunk(llllllllllllllIllIlIIIIlllllllll);
                    if (!llllllllllllllIllIlIIIIlllllllll.field_178590_b.func_178489_a() || llllllllllllllIllIlIIIIlllllllll.func_178569_m()) {
                        this.glRenderLists.add(llllllllllllllIllIlIIIlIIIIIIIIl.getRenderInfo());
                    }
                    final BlockPos llllllllllllllIllIlIIIIllllllllI = llllllllllllllIllIlIIIIlllllllll.func_178568_j();
                    if (ChunkUtils.hasEntities(this.theWorld.getChunkFromBlockCoords(llllllllllllllIllIlIIIIllllllllI))) {
                        this.renderInfosEntities.add(llllllllllllllIllIlIIIlIIIIIIIIl.getRenderInfo());
                    }
                    if (llllllllllllllIllIlIIIIlllllllll.func_178571_g().func_178485_b().size() > 0) {
                        this.renderInfosTileEntities.add(llllllllllllllIllIlIIIlIIIIIIIIl.getRenderInfo());
                    }
                }
            }
        }
        else {
            this.glRenderLists = this.renderInfosNormal;
            this.renderInfosEntities = this.renderInfosEntitiesNormal;
            this.renderInfosTileEntities = this.renderInfosTileEntitiesNormal;
        }
        if (!llllllllllllllIllIlIIIlIIIIIIIlI && this.displayListEntitiesDirty && !Shaders.isShadowPass) {
            this.displayListEntitiesDirty = false;
            this.glRenderLists.clear();
            this.renderInfosEntities.clear();
            this.renderInfosTileEntities.clear();
            this.visibilityDeque.clear();
            final Deque llllllllllllllIllIlIIIIllllllIIl = this.visibilityDeque;
            boolean llllllllllllllIllIlIIIIllllllIII = this.mc.field_175612_E;
            if (llllllllllllllIllIlIIIlIIIIIIlII == null) {
                final int llllllllllllllIllIlIIIIlllllIlIl = (llllllllllllllIllIlIIIlIIIIIIlIl.getY() > 0) ? 248 : 8;
                for (int llllllllllllllIllIlIIIIlllllIlll = -this.renderDistanceChunks; llllllllllllllIllIlIIIIlllllIlll <= this.renderDistanceChunks; ++llllllllllllllIllIlIIIIlllllIlll) {
                    for (int llllllllllllllIllIlIIIIlllllIlII = -this.renderDistanceChunks; llllllllllllllIllIlIIIIlllllIlII <= this.renderDistanceChunks; ++llllllllllllllIllIlIIIIlllllIlII) {
                        final RenderChunk llllllllllllllIllIlIIIIlllllIIll = this.field_175008_n.func_178161_a(new BlockPos((llllllllllllllIllIlIIIIlllllIlll << 4) + 8, llllllllllllllIllIlIIIIlllllIlIl, (llllllllllllllIllIlIIIIlllllIlII << 4) + 8));
                        if (llllllllllllllIllIlIIIIlllllIIll != null && ((ICamera)llllllllllllllIllIlIIIIllllIIIIl).isBoundingBoxInFrustum(llllllllllllllIllIlIIIIlllllIIll.field_178591_c)) {
                            llllllllllllllIllIlIIIIlllllIIll.func_178577_a(llllllllllllllIllIlIIIIllllIIIII);
                            llllllllllllllIllIlIIIIllllllIIl.add(new ContainerLocalRenderInformation(llllllllllllllIllIlIIIIlllllIIll, null, 0, null));
                        }
                    }
                }
            }
            else {
                boolean llllllllllllllIllIlIIIIlllllIIlI = false;
                final ContainerLocalRenderInformation llllllllllllllIllIlIIIIlllllIIIl = new ContainerLocalRenderInformation(llllllllllllllIllIlIIIlIIIIIIlII, null, 0, null);
                final Set llllllllllllllIllIlIIIIlllllIIII = RenderGlobal.SET_ALL_FACINGS;
                if (!llllllllllllllIllIlIIIIlllllIIII.isEmpty() && llllllllllllllIllIlIIIIlllllIIII.size() == 1) {
                    final Vector3f llllllllllllllIllIlIIIIllllIllll = this.func_174962_a(llllllllllllllIllIlIIIlIIIIlIIIl, llllllllllllllIllIlIIIlIIIIlIIII);
                    final EnumFacing llllllllllllllIllIlIIIIllllIlllI = EnumFacing.func_176737_a(llllllllllllllIllIlIIIIllllIllll.x, llllllllllllllIllIlIIIIllllIllll.y, llllllllllllllIllIlIIIIllllIllll.z).getOpposite();
                    llllllllllllllIllIlIIIIlllllIIII.remove(llllllllllllllIllIlIIIIllllIlllI);
                }
                if (llllllllllllllIllIlIIIIlllllIIII.isEmpty()) {
                    llllllllllllllIllIlIIIIlllllIIlI = true;
                }
                if (llllllllllllllIllIlIIIIlllllIIlI && !llllllllllllllIllIlIIIIlllIlllll) {
                    this.glRenderLists.add(llllllllllllllIllIlIIIIlllllIIIl);
                }
                else {
                    if (llllllllllllllIllIlIIIIlllIlllll && this.theWorld.getBlockState(llllllllllllllIllIlIIIlIIIIIIlIl).getBlock().isOpaqueCube()) {
                        llllllllllllllIllIlIIIIllllllIII = false;
                    }
                    llllllllllllllIllIlIIIlIIIIIIlII.func_178577_a(llllllllllllllIllIlIIIIllllIIIII);
                    llllllllllllllIllIlIIIIllllllIIl.add(llllllllllllllIllIlIIIIlllllIIIl);
                }
            }
            final EnumFacing[] llllllllllllllIllIlIIIIllllIllIl = EnumFacing.VALUES;
            final int llllllllllllllIllIlIIIIlllllIllI = llllllllllllllIllIlIIIIllllIllIl.length;
            while (!llllllllllllllIllIlIIIIllllllIIl.isEmpty()) {
                final ContainerLocalRenderInformation llllllllllllllIllIlIIIIlllllllIl = llllllllllllllIllIlIIIIllllllIIl.poll();
                final RenderChunk llllllllllllllIllIlIIIIllllllIll = llllllllllllllIllIlIIIIlllllllIl.field_178036_a;
                final EnumFacing llllllllllllllIllIlIIIIllllIllII = llllllllllllllIllIlIIIIlllllllIl.field_178034_b;
                final BlockPos llllllllllllllIllIlIIIIllllIlIll = llllllllllllllIllIlIIIIllllllIll.func_178568_j();
                if (!llllllllllllllIllIlIIIIllllllIll.field_178590_b.func_178489_a() || llllllllllllllIllIlIIIIllllllIll.func_178569_m()) {
                    this.glRenderLists.add(llllllllllllllIllIlIIIIlllllllIl);
                }
                if (ChunkUtils.hasEntities(this.theWorld.getChunkFromBlockCoords(llllllllllllllIllIlIIIIllllIlIll))) {
                    this.renderInfosEntities.add(llllllllllllllIllIlIIIIlllllllIl);
                }
                if (llllllllllllllIllIlIIIIllllllIll.func_178571_g().func_178485_b().size() > 0) {
                    this.renderInfosTileEntities.add(llllllllllllllIllIlIIIIlllllllIl);
                }
                for (final EnumFacing llllllllllllllIllIlIIIIllllIlIIl : llllllllllllllIllIlIIIIllllIllIl) {
                    if ((!llllllllllllllIllIlIIIIllllllIII || !llllllllllllllIllIlIIIIlllllllIl.field_178035_c.contains(llllllllllllllIllIlIIIIllllIlIIl.getOpposite())) && (!llllllllllllllIllIlIIIIllllllIII || llllllllllllllIllIlIIIIllllIllII == null || llllllllllllllIllIlIIIIllllllIll.func_178571_g().func_178495_a(llllllllllllllIllIlIIIIllllIllII.getOpposite(), llllllllllllllIllIlIIIIllllIlIIl))) {
                        final RenderChunk llllllllllllllIllIlIIIIllllIlIII = this.getRenderChunkOffset(llllllllllllllIllIlIIIlIIIIIIlIl, llllllllllllllIllIlIIIIllllllIll, llllllllllllllIllIlIIIIllllIlIIl);
                        if (llllllllllllllIllIlIIIIllllIlIII != null && llllllllllllllIllIlIIIIllllIlIII.func_178577_a(llllllllllllllIllIlIIIIllllIIIII) && ((ICamera)llllllllllllllIllIlIIIIllllIIIIl).isBoundingBoxInFrustum(llllllllllllllIllIlIIIIllllIlIII.field_178591_c)) {
                            final ContainerLocalRenderInformation llllllllllllllIllIlIIIIllllIIlll = new ContainerLocalRenderInformation(llllllllllllllIllIlIIIIllllIlIII, llllllllllllllIllIlIIIIllllIlIIl, llllllllllllllIllIlIIIIlllllllIl.field_178032_d + 1, null);
                            llllllllllllllIllIlIIIIllllIIlll.field_178035_c.addAll(llllllllllllllIllIlIIIIlllllllIl.field_178035_c);
                            llllllllllllllIllIlIIIIllllIIlll.field_178035_c.add(llllllllllllllIllIlIIIIllllIlIIl);
                            llllllllllllllIllIlIIIIllllllIIl.add(llllllllllllllIllIlIIIIllllIIlll);
                        }
                    }
                }
            }
        }
        if (this.field_175002_T) {
            this.func_174984_a(llllllllllllllIllIlIIIlIIIIIlIIl, llllllllllllllIllIlIIIlIIIIIlIII, llllllllllllllIllIlIIIlIIIIIIlll);
            this.field_175002_T = false;
        }
        Lagometer.timerVisibility.end();
        if (Shaders.isShadowPass) {
            Shaders.mcProfilerEndSection();
        }
        else {
            this.field_174995_M.func_178513_e();
            final Set llllllllllllllIllIlIIIIllllIIllI = this.field_175009_l;
            this.field_175009_l = Sets.newLinkedHashSet();
            final Iterator llllllllllllllIllIlIIIIllllIIlIl = this.glRenderLists.iterator();
            Lagometer.timerChunkUpdate.start();
            while (llllllllllllllIllIlIIIIllllIIlIl.hasNext()) {
                final ContainerLocalRenderInformation llllllllllllllIllIlIIIIlllllllII = llllllllllllllIllIlIIIIllllIIlIl.next();
                final RenderChunk llllllllllllllIllIlIIIIllllllIlI = llllllllllllllIllIlIIIIlllllllII.field_178036_a;
                if (llllllllllllllIllIlIIIIllllllIlI.func_178569_m() || llllllllllllllIllIlIIIIllllIIllI.contains(llllllllllllllIllIlIIIIllllllIlI)) {
                    this.displayListEntitiesDirty = true;
                    if (this.func_174983_a(llllllllllllllIllIlIIIlIIIIIIIll, llllllllllllllIllIlIIIIlllllllII.field_178036_a)) {
                        if (!llllllllllllllIllIlIIIIllllllIlI.isPlayerUpdate()) {
                            this.chunksToUpdateForced.add(llllllllllllllIllIlIIIIllllllIlI);
                        }
                        else {
                            this.mc.mcProfiler.startSection("build near");
                            this.field_174995_M.func_178505_b(llllllllllllllIllIlIIIIllllllIlI);
                            llllllllllllllIllIlIIIIllllllIlI.func_178575_a(false);
                            this.mc.mcProfiler.endSection();
                        }
                    }
                    else {
                        this.field_175009_l.add(llllllllllllllIllIlIIIIllllllIlI);
                    }
                }
            }
            Lagometer.timerChunkUpdate.end();
            this.field_175009_l.addAll(llllllllllllllIllIlIIIIllllIIllI);
            this.mc.mcProfiler.endSection();
        }
    }
    
    public void func_174979_m() {
        this.displayListEntitiesDirty = true;
    }
    
    private void func_174982_a(final EnumWorldBlockLayer llllllllllllllIllIlIIIIlIIlIIlll) {
        this.mc.entityRenderer.func_180436_i();
        if (OpenGlHelper.func_176075_f()) {
            GL11.glEnableClientState(32884);
            OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
            GL11.glEnableClientState(32888);
            OpenGlHelper.setClientActiveTexture(OpenGlHelper.lightmapTexUnit);
            GL11.glEnableClientState(32888);
            OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
            GL11.glEnableClientState(32886);
        }
        if (Config.isShaders()) {
            ShadersRender.preRenderChunkLayer();
        }
        this.field_174996_N.func_178001_a(llllllllllllllIllIlIIIIlIIlIIlll);
        if (Config.isShaders()) {
            ShadersRender.postRenderChunkLayer();
        }
        if (OpenGlHelper.func_176075_f()) {
            final List llllllllllllllIllIlIIIIlIIlIllIl = DefaultVertexFormats.field_176600_a.func_177343_g();
            for (final VertexFormatElement llllllllllllllIllIlIIIIlIIlIlIll : llllllllllllllIllIlIIIIlIIlIllIl) {
                final VertexFormatElement.EnumUseage llllllllllllllIllIlIIIIlIIlIlIlI = llllllllllllllIllIlIIIIlIIlIlIll.func_177375_c();
                final int llllllllllllllIllIlIIIIlIIlIlIIl = llllllllllllllIllIlIIIIlIIlIlIll.func_177369_e();
                switch (SwitchEnumUseage.field_178037_a[llllllllllllllIllIlIIIIlIIlIlIlI.ordinal()]) {
                    default: {
                        continue;
                    }
                    case 1: {
                        GL11.glDisableClientState(32884);
                        continue;
                    }
                    case 2: {
                        OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit + llllllllllllllIllIlIIIIlIIlIlIIl);
                        GL11.glDisableClientState(32888);
                        OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
                        continue;
                    }
                    case 3: {
                        GL11.glDisableClientState(32886);
                        GlStateManager.func_179117_G();
                        continue;
                    }
                }
            }
        }
        this.mc.entityRenderer.func_175072_h();
    }
    
    @Override
    public void func_174961_a(final String llllllllllllllIllIIllllIllIIIIII, final BlockPos llllllllllllllIllIIllllIlIlllIII) {
        final ISound llllllllllllllIllIIllllIlIlllllI = this.mapSoundPositions.get(llllllllllllllIllIIllllIlIlllIII);
        if (llllllllllllllIllIIllllIlIlllllI != null) {
            this.mc.getSoundHandler().stopSound(llllllllllllllIllIIllllIlIlllllI);
            this.mapSoundPositions.remove(llllllllllllllIllIIllllIlIlllIII);
        }
        if (llllllllllllllIllIIllllIllIIIIII != null) {
            final ItemRecord llllllllllllllIllIIllllIlIllllIl = ItemRecord.getRecord(llllllllllllllIllIIllllIllIIIIII);
            if (llllllllllllllIllIIllllIlIllllIl != null) {
                this.mc.ingameGUI.setRecordPlayingMessage(llllllllllllllIllIIllllIlIllllIl.getRecordNameLocal());
            }
            ResourceLocation llllllllllllllIllIIllllIlIllllII = null;
            if (Reflector.ForgeItemRecord_getRecordResource.exists() && llllllllllllllIllIIllllIlIllllIl != null) {
                llllllllllllllIllIIllllIlIllllII = (ResourceLocation)Reflector.call(llllllllllllllIllIIllllIlIllllIl, Reflector.ForgeItemRecord_getRecordResource, llllllllllllllIllIIllllIllIIIIII);
            }
            if (llllllllllllllIllIIllllIlIllllII == null) {
                llllllllllllllIllIIllllIlIllllII = new ResourceLocation(llllllllllllllIllIIllllIllIIIIII);
            }
            final PositionedSoundRecord llllllllllllllIllIIllllIlIlllIll = PositionedSoundRecord.createRecordSoundAtPosition(llllllllllllllIllIIllllIlIllllII, (float)llllllllllllllIllIIllllIlIlllIII.getX(), (float)llllllllllllllIllIIllllIlIlllIII.getY(), (float)llllllllllllllIllIIllllIlIlllIII.getZ());
            this.mapSoundPositions.put(llllllllllllllIllIIllllIlIlllIII, llllllllllllllIllIIllllIlIlllIll);
            this.mc.getSoundHandler().playSound(llllllllllllllIllIIllllIlIlllIll);
        }
    }
    
    public void func_180446_a(final Entity llllllllllllllIllIlIIIlIlIIIlIll, final ICamera llllllllllllllIllIlIIIlIlIIIlIlI, final float llllllllllllllIllIlIIIlIIlIlllII) {
        int llllllllllllllIllIlIIIlIlIIIlIII = 0;
        if (Reflector.MinecraftForgeClient_getRenderPass.exists()) {
            llllllllllllllIllIlIIIlIlIIIlIII = Reflector.callInt(Reflector.MinecraftForgeClient_getRenderPass, new Object[0]);
        }
        if (this.renderEntitiesStartupCounter > 0) {
            if (llllllllllllllIllIlIIIlIlIIIlIII > 0) {
                return;
            }
            --this.renderEntitiesStartupCounter;
        }
        else {
            final double llllllllllllllIllIlIIIlIlIIIIlll = llllllllllllllIllIlIIIlIlIIIlIll.prevPosX + (llllllllllllllIllIlIIIlIlIIIlIll.posX - llllllllllllllIllIlIIIlIlIIIlIll.prevPosX) * llllllllllllllIllIlIIIlIIlIlllII;
            final double llllllllllllllIllIlIIIlIlIIIIllI = llllllllllllllIllIlIIIlIlIIIlIll.prevPosY + (llllllllllllllIllIlIIIlIlIIIlIll.posY - llllllllllllllIllIlIIIlIlIIIlIll.prevPosY) * llllllllllllllIllIlIIIlIIlIlllII;
            final double llllllllllllllIllIlIIIlIlIIIIlIl = llllllllllllllIllIlIIIlIlIIIlIll.prevPosZ + (llllllllllllllIllIlIIIlIlIIIlIll.posZ - llllllllllllllIllIlIIIlIlIIIlIll.prevPosZ) * llllllllllllllIllIlIIIlIIlIlllII;
            this.theWorld.theProfiler.startSection("prepare");
            TileEntityRendererDispatcher.instance.func_178470_a(this.theWorld, this.mc.getTextureManager(), this.mc.fontRendererObj, this.mc.func_175606_aa(), llllllllllllllIllIlIIIlIIlIlllII);
            this.field_175010_j.func_180597_a(this.theWorld, this.mc.fontRendererObj, this.mc.func_175606_aa(), this.mc.pointedEntity, this.mc.gameSettings, llllllllllllllIllIlIIIlIIlIlllII);
            if (llllllllllllllIllIlIIIlIlIIIlIII == 0) {
                this.countEntitiesTotal = 0;
                this.countEntitiesRendered = 0;
                this.countEntitiesHidden = 0;
                this.countTileEntitiesRendered = 0;
            }
            final Entity llllllllllllllIllIlIIIlIlIIIIlII = this.mc.func_175606_aa();
            final double llllllllllllllIllIlIIIlIlIIIIIll = llllllllllllllIllIlIIIlIlIIIIlII.lastTickPosX + (llllllllllllllIllIlIIIlIlIIIIlII.posX - llllllllllllllIllIlIIIlIlIIIIlII.lastTickPosX) * llllllllllllllIllIlIIIlIIlIlllII;
            final double llllllllllllllIllIlIIIlIlIIIIIlI = llllllllllllllIllIlIIIlIlIIIIlII.lastTickPosY + (llllllllllllllIllIlIIIlIlIIIIlII.posY - llllllllllllllIllIlIIIlIlIIIIlII.lastTickPosY) * llllllllllllllIllIlIIIlIIlIlllII;
            final double llllllllllllllIllIlIIIlIlIIIIIIl = llllllllllllllIllIlIIIlIlIIIIlII.lastTickPosZ + (llllllllllllllIllIlIIIlIlIIIIlII.posZ - llllllllllllllIllIlIIIlIlIIIIlII.lastTickPosZ) * llllllllllllllIllIlIIIlIIlIlllII;
            TileEntityRendererDispatcher.staticPlayerX = llllllllllllllIllIlIIIlIlIIIIIll;
            TileEntityRendererDispatcher.staticPlayerY = llllllllllllllIllIlIIIlIlIIIIIlI;
            TileEntityRendererDispatcher.staticPlayerZ = llllllllllllllIllIlIIIlIlIIIIIIl;
            this.field_175010_j.func_178628_a(llllllllllllllIllIlIIIlIlIIIIIll, llllllllllllllIllIlIIIlIlIIIIIlI, llllllllllllllIllIlIIIlIlIIIIIIl);
            this.mc.entityRenderer.func_180436_i();
            this.theWorld.theProfiler.endStartSection("global");
            final List llllllllllllllIllIlIIIlIlIIIIIII = this.theWorld.getLoadedEntityList();
            if (llllllllllllllIllIlIIIlIlIIIlIII == 0) {
                this.countEntitiesTotal = llllllllllllllIllIlIIIlIlIIIIIII.size();
            }
            if (Config.isFogOff() && this.mc.entityRenderer.fogStandard) {
                GlStateManager.disableFog();
            }
            final boolean llllllllllllllIllIlIIIlIIlllllll = Reflector.ForgeEntity_shouldRenderInPass.exists();
            final boolean llllllllllllllIllIlIIIlIIllllllI = Reflector.ForgeTileEntity_shouldRenderInPass.exists();
            for (int llllllllllllllIllIlIIIlIIlllllIl = 0; llllllllllllllIllIlIIIlIIlllllIl < this.theWorld.weatherEffects.size(); ++llllllllllllllIllIlIIIlIIlllllIl) {
                final Entity llllllllllllllIllIlIIIlIIlllllII = this.theWorld.weatherEffects.get(llllllllllllllIllIlIIIlIIlllllIl);
                if (!llllllllllllllIllIlIIIlIIlllllll || Reflector.callBoolean(llllllllllllllIllIlIIIlIIlllllII, Reflector.ForgeEntity_shouldRenderInPass, llllllllllllllIllIlIIIlIlIIIlIII)) {
                    ++this.countEntitiesRendered;
                    if (llllllllllllllIllIlIIIlIIlllllII.isInRangeToRender3d(llllllllllllllIllIlIIIlIlIIIIlll, llllllllllllllIllIlIIIlIlIIIIllI, llllllllllllllIllIlIIIlIlIIIIlIl)) {
                        this.field_175010_j.renderEntitySimple(llllllllllllllIllIlIIIlIIlllllII, llllllllllllllIllIlIIIlIIlIlllII);
                    }
                }
            }
            if (this.func_174985_d()) {
                GlStateManager.depthFunc(519);
                GlStateManager.disableFog();
                this.field_175015_z.framebufferClear();
                this.field_175015_z.bindFramebuffer(false);
                this.theWorld.theProfiler.endStartSection("entityOutlines");
                RenderHelper.disableStandardItemLighting();
                this.field_175010_j.func_178632_c(true);
                for (int llllllllllllllIllIlIIIlIIlllllIl = 0; llllllllllllllIllIlIIIlIIlllllIl < llllllllllllllIllIlIIIlIlIIIIIII.size(); ++llllllllllllllIllIlIIIlIIlllllIl) {
                    final Entity llllllllllllllIllIlIIIlIIllllIll = llllllllllllllIllIlIIIlIlIIIIIII.get(llllllllllllllIllIlIIIlIIlllllIl);
                    if (!llllllllllllllIllIlIIIlIIlllllll || Reflector.callBoolean(llllllllllllllIllIlIIIlIIllllIll, Reflector.ForgeEntity_shouldRenderInPass, llllllllllllllIllIlIIIlIlIIIlIII)) {
                        final boolean llllllllllllllIllIlIIIlIIllllIlI = this.mc.func_175606_aa() instanceof EntityLivingBase && ((EntityLivingBase)this.mc.func_175606_aa()).isPlayerSleeping();
                        final boolean llllllllllllllIllIlIIIlIIllllIII = llllllllllllllIllIlIIIlIIllllIll.isInRangeToRender3d(llllllllllllllIllIlIIIlIlIIIIlll, llllllllllllllIllIlIIIlIlIIIIllI, llllllllllllllIllIlIIIlIlIIIIlIl) && (llllllllllllllIllIlIIIlIIllllIll.ignoreFrustumCheck || llllllllllllllIllIlIIIlIlIIIlIlI.isBoundingBoxInFrustum(llllllllllllllIllIlIIIlIIllllIll.getEntityBoundingBox()) || llllllllllllllIllIlIIIlIIllllIll.riddenByEntity == this.mc.thePlayer) && llllllllllllllIllIlIIIlIIllllIll instanceof EntityPlayer;
                        if ((llllllllllllllIllIlIIIlIIllllIll != this.mc.func_175606_aa() || this.mc.gameSettings.thirdPersonView != 0 || llllllllllllllIllIlIIIlIIllllIlI) && llllllllllllllIllIlIIIlIIllllIII) {
                            this.field_175010_j.renderEntitySimple(llllllllllllllIllIlIIIlIIllllIll, llllllllllllllIllIlIIIlIIlIlllII);
                        }
                    }
                }
                this.field_175010_j.func_178632_c(false);
                RenderHelper.enableStandardItemLighting();
                GlStateManager.depthMask(false);
                this.field_174991_A.loadShaderGroup(llllllllllllllIllIlIIIlIIlIlllII);
                GlStateManager.depthMask(true);
                this.mc.getFramebuffer().bindFramebuffer(false);
                GlStateManager.enableFog();
                GlStateManager.depthFunc(515);
                GlStateManager.enableDepth();
                GlStateManager.enableAlpha();
            }
            this.theWorld.theProfiler.endStartSection("entities");
            final boolean llllllllllllllIllIlIIIlIIllllIIl = Config.isShaders();
            if (llllllllllllllIllIlIIIlIIllllIIl) {
                Shaders.beginEntities();
            }
            Iterator llllllllllllllIllIlIIIlIIlllIlll = this.renderInfosEntities.iterator();
            final boolean llllllllllllllIllIlIIIlIIlllIllI = this.mc.gameSettings.fancyGraphics;
            this.mc.gameSettings.fancyGraphics = Config.isDroppedItemsFancy();
            while (llllllllllllllIllIlIIIlIIlllIlll.hasNext()) {
                final ContainerLocalRenderInformation llllllllllllllIllIlIIIlIIlllIlIl = llllllllllllllIllIlIIIlIIlllIlll.next();
                final Chunk llllllllllllllIllIlIIIlIIlllIIll = this.theWorld.getChunkFromBlockCoords(llllllllllllllIllIlIIIlIIlllIlIl.field_178036_a.func_178568_j());
                for (final Entity llllllllllllllIllIlIIIlIIlllIIIl : llllllllllllllIllIlIIIlIIlllIIll.getEntityLists()[llllllllllllllIllIlIIIlIIlllIlIl.field_178036_a.func_178568_j().getY() / 16]) {
                    if (!llllllllllllllIllIlIIIlIIlllllll || Reflector.callBoolean(llllllllllllllIllIlIIIlIIlllIIIl, Reflector.ForgeEntity_shouldRenderInPass, llllllllllllllIllIlIIIlIlIIIlIII)) {
                        final boolean llllllllllllllIllIlIIIlIIlllIIII = this.field_175010_j.func_178635_a(llllllllllllllIllIlIIIlIIlllIIIl, llllllllllllllIllIlIIIlIlIIIlIlI, llllllllllllllIllIlIIIlIlIIIIlll, llllllllllllllIllIlIIIlIlIIIIllI, llllllllllllllIllIlIIIlIlIIIIlIl) || llllllllllllllIllIlIIIlIIlllIIIl.riddenByEntity == this.mc.thePlayer;
                        if (llllllllllllllIllIlIIIlIIlllIIII) {
                            final boolean llllllllllllllIllIlIIIlIIllIllll = this.mc.func_175606_aa() instanceof EntityLivingBase && ((EntityLivingBase)this.mc.func_175606_aa()).isPlayerSleeping();
                            if (llllllllllllllIllIlIIIlIIlllIIIl == this.mc.func_175606_aa() && this.mc.gameSettings.thirdPersonView == 0 && !llllllllllllllIllIlIIIlIIllIllll) {
                                continue;
                            }
                            if (llllllllllllllIllIlIIIlIIlllIIIl.posY >= 0.0 && llllllllllllllIllIlIIIlIIlllIIIl.posY < 256.0 && !this.theWorld.isBlockLoaded(new BlockPos(llllllllllllllIllIlIIIlIIlllIIIl))) {
                                continue;
                            }
                            ++this.countEntitiesRendered;
                            if (llllllllllllllIllIlIIIlIIlllIIIl.getClass() == EntityItemFrame.class) {
                                llllllllllllllIllIlIIIlIIlllIIIl.renderDistanceWeight = 0.06;
                            }
                            this.renderedEntity = llllllllllllllIllIlIIIlIIlllIIIl;
                            if (llllllllllllllIllIlIIIlIIllllIIl) {
                                Shaders.nextEntity(llllllllllllllIllIlIIIlIIlllIIIl);
                            }
                            this.field_175010_j.renderEntitySimple(llllllllllllllIllIlIIIlIIlllIIIl, llllllllllllllIllIlIIIlIIlIlllII);
                            this.renderedEntity = null;
                        }
                        if (llllllllllllllIllIlIIIlIIlllIIII || !(llllllllllllllIllIlIIIlIIlllIIIl instanceof EntityWitherSkull)) {
                            continue;
                        }
                        if (llllllllllllllIllIlIIIlIIllllIIl) {
                            Shaders.nextEntity(llllllllllllllIllIlIIIlIIlllIIIl);
                        }
                        this.mc.getRenderManager().func_178630_b(llllllllllllllIllIlIIIlIIlllIIIl, llllllllllllllIllIlIIIlIIlIlllII);
                    }
                }
            }
            this.mc.gameSettings.fancyGraphics = llllllllllllllIllIlIIIlIIlllIllI;
            final FontRenderer llllllllllllllIllIlIIIlIIllIlllI = TileEntityRendererDispatcher.instance.getFontRenderer();
            if (llllllllllllllIllIlIIIlIIllllIIl) {
                Shaders.endEntities();
                Shaders.beginBlockEntities();
            }
            this.theWorld.theProfiler.endStartSection("blockentities");
            RenderHelper.enableStandardItemLighting();
            if (Reflector.ForgeTileEntityRendererDispatcher_preDrawBatch.exists()) {
                Reflector.call(TileEntityRendererDispatcher.instance, Reflector.ForgeTileEntityRendererDispatcher_preDrawBatch, new Object[0]);
            }
            llllllllllllllIllIlIIIlIIlllIlll = this.renderInfosTileEntities.iterator();
            while (llllllllllllllIllIlIIIlIIlllIlll.hasNext()) {
                final ContainerLocalRenderInformation llllllllllllllIllIlIIIlIIlllIlII = llllllllllllllIllIlIIIlIIlllIlll.next();
                for (final TileEntity llllllllllllllIllIlIIIlIIllIllIl : llllllllllllllIllIlIIIlIIlllIlII.field_178036_a.func_178571_g().func_178485_b()) {
                    if (llllllllllllllIllIlIIIlIIllllllI) {
                        if (!Reflector.callBoolean(llllllllllllllIllIlIIIlIIllIllIl, Reflector.ForgeTileEntity_shouldRenderInPass, llllllllllllllIllIlIIIlIlIIIlIII)) {
                            continue;
                        }
                        final AxisAlignedBB llllllllllllllIllIlIIIlIIllIlIlI = (AxisAlignedBB)Reflector.call(llllllllllllllIllIlIIIlIIllIllIl, Reflector.ForgeTileEntity_getRenderBoundingBox, new Object[0]);
                        if (llllllllllllllIllIlIIIlIIllIlIlI != null && !llllllllllllllIllIlIIIlIlIIIlIlI.isBoundingBoxInFrustum(llllllllllllllIllIlIIIlIIllIlIlI)) {
                            continue;
                        }
                    }
                    final Class llllllllllllllIllIlIIIlIIllIlIIl = llllllllllllllIllIlIIIlIIllIllIl.getClass();
                    if (llllllllllllllIllIlIIIlIIllIlIIl == TileEntitySign.class && !Config.zoomMode) {
                        final EntityPlayerSP llllllllllllllIllIlIIIlIIllIlIII = this.mc.thePlayer;
                        final double llllllllllllllIllIlIIIlIIllIIlll = llllllllllllllIllIlIIIlIIllIllIl.getDistanceSq(llllllllllllllIllIlIIIlIIllIlIII.posX, llllllllllllllIllIlIIIlIIllIlIII.posY, llllllllllllllIllIlIIIlIIllIlIII.posZ);
                        if (llllllllllllllIllIlIIIlIIllIIlll > 256.0) {
                            llllllllllllllIllIlIIIlIIllIlllI.enabled = false;
                        }
                    }
                    if (llllllllllllllIllIlIIIlIIllllIIl) {
                        Shaders.nextBlockEntity(llllllllllllllIllIlIIIlIIllIllIl);
                    }
                    TileEntityRendererDispatcher.instance.func_180546_a(llllllllllllllIllIlIIIlIIllIllIl, llllllllllllllIllIlIIIlIIlIlllII, -1);
                    ++this.countTileEntitiesRendered;
                    llllllllllllllIllIlIIIlIIllIlllI.enabled = true;
                }
            }
            if (Reflector.ForgeTileEntityRendererDispatcher_drawBatch.exists()) {
                Reflector.call(TileEntityRendererDispatcher.instance, Reflector.ForgeTileEntityRendererDispatcher_drawBatch, llllllllllllllIllIlIIIlIlIIIlIII);
            }
            this.func_180443_s();
            llllllllllllllIllIlIIIlIIlllIlll = this.damagedBlocks.values().iterator();
            while (llllllllllllllIllIlIIIlIIlllIlll.hasNext()) {
                final DestroyBlockProgress llllllllllllllIllIlIIIlIIllIIllI = llllllllllllllIllIlIIIlIIlllIlll.next();
                BlockPos llllllllllllllIllIlIIIlIIllIIlIl = llllllllllllllIllIlIIIlIIllIIllI.func_180246_b();
                TileEntity llllllllllllllIllIlIIIlIIllIllII = this.theWorld.getTileEntity(llllllllllllllIllIlIIIlIIllIIlIl);
                if (llllllllllllllIllIlIIIlIIllIllII instanceof TileEntityChest) {
                    final TileEntityChest llllllllllllllIllIlIIIlIIllIIlII = (TileEntityChest)llllllllllllllIllIlIIIlIIllIllII;
                    if (llllllllllllllIllIlIIIlIIllIIlII.adjacentChestXNeg != null) {
                        llllllllllllllIllIlIIIlIIllIIlIl = llllllllllllllIllIlIIIlIIllIIlIl.offset(EnumFacing.WEST);
                        llllllllllllllIllIlIIIlIIllIllII = this.theWorld.getTileEntity(llllllllllllllIllIlIIIlIIllIIlIl);
                    }
                    else if (llllllllllllllIllIlIIIlIIllIIlII.adjacentChestZNeg != null) {
                        llllllllllllllIllIlIIIlIIllIIlIl = llllllllllllllIllIlIIIlIIllIIlIl.offset(EnumFacing.NORTH);
                        llllllllllllllIllIlIIIlIIllIllII = this.theWorld.getTileEntity(llllllllllllllIllIlIIIlIIllIIlIl);
                    }
                }
                final Block llllllllllllllIllIlIIIlIIllIIIll = this.theWorld.getBlockState(llllllllllllllIllIlIIIlIIllIIlIl).getBlock();
                boolean llllllllllllllIllIlIIIlIIllIIIIl = false;
                if (llllllllllllllIllIlIIIlIIllllllI) {
                    boolean llllllllllllllIllIlIIIlIIllIIIlI = false;
                    if (llllllllllllllIllIlIIIlIIllIllII != null && Reflector.callBoolean(llllllllllllllIllIlIIIlIIllIllII, Reflector.ForgeTileEntity_shouldRenderInPass, llllllllllllllIllIlIIIlIlIIIlIII) && Reflector.callBoolean(llllllllllllllIllIlIIIlIIllIllII, Reflector.ForgeTileEntity_canRenderBreaking, new Object[0])) {
                        final AxisAlignedBB llllllllllllllIllIlIIIlIIllIIIII = (AxisAlignedBB)Reflector.call(llllllllllllllIllIlIIIlIIllIllII, Reflector.ForgeTileEntity_getRenderBoundingBox, new Object[0]);
                        if (llllllllllllllIllIlIIIlIIllIIIII != null) {
                            llllllllllllllIllIlIIIlIIllIIIlI = llllllllllllllIllIlIIIlIlIIIlIlI.isBoundingBoxInFrustum(llllllllllllllIllIlIIIlIIllIIIII);
                        }
                    }
                }
                else {
                    llllllllllllllIllIlIIIlIIllIIIIl = (llllllllllllllIllIlIIIlIIllIllII != null && (llllllllllllllIllIlIIIlIIllIIIll instanceof BlockChest || llllllllllllllIllIlIIIlIIllIIIll instanceof BlockEnderChest || llllllllllllllIllIlIIIlIIllIIIll instanceof BlockSign || llllllllllllllIllIlIIIlIIllIIIll instanceof BlockSkull));
                }
                if (llllllllllllllIllIlIIIlIIllIIIIl) {
                    if (llllllllllllllIllIlIIIlIIllllIIl) {
                        Shaders.nextBlockEntity(llllllllllllllIllIlIIIlIIllIllII);
                    }
                    TileEntityRendererDispatcher.instance.func_180546_a(llllllllllllllIllIlIIIlIIllIllII, llllllllllllllIllIlIIIlIIlIlllII, llllllllllllllIllIlIIIlIIllIIllI.getPartialBlockDamage());
                }
            }
            this.func_174969_t();
            this.mc.entityRenderer.func_175072_h();
            this.mc.mcProfiler.endSection();
        }
    }
    
    public void checkOcclusionQueryResult(final int llllllllllllllIllIlIIIlIlIlIlIlI, final int llllllllllllllIllIlIIIlIlIlIlIIl) {
        if (OpenGlHelper.shadersSupported && this.field_174991_A != null) {
            this.field_174991_A.createBindFramebuffers(llllllllllllllIllIlIIIlIlIlIlIlI, llllllllllllllIllIlIIIlIlIlIlIIl);
        }
    }
    
    static {
        __OBFID = "CL_00000954";
        logger = LogManager.getLogger();
        locationMoonPhasesPng = new ResourceLocation("textures/environment/moon_phases.png");
        locationSunPng = new ResourceLocation("textures/environment/sun.png");
        locationCloudsPng = new ResourceLocation("textures/environment/clouds.png");
        locationEndSkyPng = new ResourceLocation("textures/environment/end_sky.png");
        field_175006_g = new ResourceLocation("textures/misc/forcefield.png");
        SET_ALL_FACINGS = Collections.unmodifiableSet((Set<?>)new HashSet<Object>(Arrays.asList(EnumFacing.VALUES)));
    }
    
    private void func_174969_t() {
        GlStateManager.disableAlpha();
        GlStateManager.doPolygonOffset(0.0f, 0.0f);
        GlStateManager.disablePolygonOffset();
        GlStateManager.enableAlpha();
        GlStateManager.depthMask(true);
        GlStateManager.popMatrix();
        if (Config.isShaders()) {
            ShadersRender.endBlockDamage();
        }
    }
    
    private void func_174984_a(final double llllllllllllllIllIlIIIIllIIIIIII, final double llllllllllllllIllIlIIIIllIIIIlll, final double llllllllllllllIllIlIIIIllIIIIllI) {
        this.field_175001_U = new ClippingHelperImpl();
        ((ClippingHelperImpl)this.field_175001_U).init();
        final Matrix4f llllllllllllllIllIlIIIIllIIIIlIl = new Matrix4f(this.field_175001_U.field_178626_c);
        llllllllllllllIllIlIIIIllIIIIlIl.transpose();
        final Matrix4f llllllllllllllIllIlIIIIllIIIIlII = new Matrix4f(this.field_175001_U.field_178625_b);
        llllllllllllllIllIlIIIIllIIIIlII.transpose();
        final Matrix4f llllllllllllllIllIlIIIIllIIIIIll = new Matrix4f();
        llllllllllllllIllIlIIIIllIIIIIll.mul(llllllllllllllIllIlIIIIllIIIIlII, llllllllllllllIllIlIIIIllIIIIlIl);
        llllllllllllllIllIlIIIIllIIIIIll.invert();
        this.field_175003_W.x = llllllllllllllIllIlIIIIllIIIIIII;
        this.field_175003_W.y = llllllllllllllIllIlIIIIllIIIIlll;
        this.field_175003_W.z = llllllllllllllIllIlIIIIllIIIIllI;
        this.field_175004_V[0] = new Vector4f(-1.0f, -1.0f, -1.0f, 1.0f);
        this.field_175004_V[1] = new Vector4f(1.0f, -1.0f, -1.0f, 1.0f);
        this.field_175004_V[2] = new Vector4f(1.0f, 1.0f, -1.0f, 1.0f);
        this.field_175004_V[3] = new Vector4f(-1.0f, 1.0f, -1.0f, 1.0f);
        this.field_175004_V[4] = new Vector4f(-1.0f, -1.0f, 1.0f, 1.0f);
        this.field_175004_V[5] = new Vector4f(1.0f, -1.0f, 1.0f, 1.0f);
        this.field_175004_V[6] = new Vector4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_175004_V[7] = new Vector4f(-1.0f, 1.0f, 1.0f, 1.0f);
        for (int llllllllllllllIllIlIIIIllIIIIIlI = 0; llllllllllllllIllIlIIIIllIIIIIlI < 8; ++llllllllllllllIllIlIIIIllIIIIIlI) {
            llllllllllllllIllIlIIIIllIIIIIll.transform((Tuple4f)this.field_175004_V[llllllllllllllIllIlIIIIllIIIIIlI]);
            final Vector4f vector4f = this.field_175004_V[llllllllllllllIllIlIIIIllIIIIIlI];
            vector4f.x /= this.field_175004_V[llllllllllllllIllIlIIIIllIIIIIlI].w;
            final Vector4f vector4f2 = this.field_175004_V[llllllllllllllIllIlIIIIllIIIIIlI];
            vector4f2.y /= this.field_175004_V[llllllllllllllIllIlIIIIllIIIIIlI].w;
            final Vector4f vector4f3 = this.field_175004_V[llllllllllllllIllIlIIIIllIIIIIlI];
            vector4f3.z /= this.field_175004_V[llllllllllllllIllIlIIIIllIIIIIlI].w;
            this.field_175004_V[llllllllllllllIllIlIIIIllIIIIIlI].w = 1.0f;
        }
    }
    
    @Override
    public void func_180440_a(final int llllllllllllllIllIIllllIIIIIlIll, final BlockPos llllllllllllllIllIIllllIIIIlIllI, final int llllllllllllllIllIIllllIIIIlIlIl) {
        switch (llllllllllllllIllIIllllIIIIIlIll) {
            case 1013:
            case 1018: {
                if (this.mc.func_175606_aa() == null) {
                    break;
                }
                final double llllllllllllllIllIIllllIIIIlIlII = llllllllllllllIllIIllllIIIIlIllI.getX() - this.mc.func_175606_aa().posX;
                final double llllllllllllllIllIIllllIIIIlIIll = llllllllllllllIllIIllllIIIIlIllI.getY() - this.mc.func_175606_aa().posY;
                final double llllllllllllllIllIIllllIIIIlIIlI = llllllllllllllIllIIllllIIIIlIllI.getZ() - this.mc.func_175606_aa().posZ;
                final double llllllllllllllIllIIllllIIIIlIIIl = Math.sqrt(llllllllllllllIllIIllllIIIIlIlII * llllllllllllllIllIIllllIIIIlIlII + llllllllllllllIllIIllllIIIIlIIll * llllllllllllllIllIIllllIIIIlIIll + llllllllllllllIllIIllllIIIIlIIlI * llllllllllllllIllIIllllIIIIlIIlI);
                double llllllllllllllIllIIllllIIIIlIIII = this.mc.func_175606_aa().posX;
                double llllllllllllllIllIIllllIIIIIllll = this.mc.func_175606_aa().posY;
                double llllllllllllllIllIIllllIIIIIlllI = this.mc.func_175606_aa().posZ;
                if (llllllllllllllIllIIllllIIIIlIIIl > 0.0) {
                    llllllllllllllIllIIllllIIIIlIIII += llllllllllllllIllIIllllIIIIlIlII / llllllllllllllIllIIllllIIIIlIIIl * 2.0;
                    llllllllllllllIllIIllllIIIIIllll += llllllllllllllIllIIllllIIIIlIIll / llllllllllllllIllIIllllIIIIlIIIl * 2.0;
                    llllllllllllllIllIIllllIIIIIlllI += llllllllllllllIllIIllllIIIIlIIlI / llllllllllllllIllIIllllIIIIlIIIl * 2.0;
                }
                if (llllllllllllllIllIIllllIIIIIlIll == 1013) {
                    this.theWorld.playSound(llllllllllllllIllIIllllIIIIlIIII, llllllllllllllIllIIllllIIIIIllll, llllllllllllllIllIIllllIIIIIlllI, "mob.wither.spawn", 1.0f, 1.0f, false);
                    break;
                }
                this.theWorld.playSound(llllllllllllllIllIIllllIIIIlIIII, llllllllllllllIllIIllllIIIIIllll, llllllllllllllIllIIllllIIIIIlllI, "mob.enderdragon.end", 5.0f, 1.0f, false);
                break;
            }
        }
    }
    
    @Override
    public void sendBlockBreakProgress(final int llllllllllllllIllIIlllIllIIlIlIl, final BlockPos llllllllllllllIllIIlllIllIIllIIl, final int llllllllllllllIllIIlllIllIIllIII) {
        if (llllllllllllllIllIIlllIllIIllIII >= 0 && llllllllllllllIllIIlllIllIIllIII < 10) {
            DestroyBlockProgress llllllllllllllIllIIlllIllIIlIlll = this.damagedBlocks.get(llllllllllllllIllIIlllIllIIlIlIl);
            if (llllllllllllllIllIIlllIllIIlIlll == null || llllllllllllllIllIIlllIllIIlIlll.func_180246_b().getX() != llllllllllllllIllIIlllIllIIllIIl.getX() || llllllllllllllIllIIlllIllIIlIlll.func_180246_b().getY() != llllllllllllllIllIIlllIllIIllIIl.getY() || llllllllllllllIllIIlllIllIIlIlll.func_180246_b().getZ() != llllllllllllllIllIIlllIllIIllIIl.getZ()) {
                llllllllllllllIllIIlllIllIIlIlll = new DestroyBlockProgress(llllllllllllllIllIIlllIllIIlIlIl, llllllllllllllIllIIlllIllIIllIIl);
                this.damagedBlocks.put(llllllllllllllIllIIlllIllIIlIlIl, llllllllllllllIllIIlllIllIIlIlll);
            }
            llllllllllllllIllIIlllIllIIlIlll.setPartialBlockDamage(llllllllllllllIllIIlllIllIIllIII);
            llllllllllllllIllIIlllIllIIlIlll.setCloudUpdateTick(this.cloudTickCounter);
        }
        else {
            this.damagedBlocks.remove(llllllllllllllIllIIlllIllIIlIlIl);
        }
    }
    
    public RenderChunk getRenderChunk(final BlockPos llllllllllllllIllIIlllIlIllllIlI) {
        return this.field_175008_n.func_178161_a(llllllllllllllIllIIlllIlIllllIlI);
    }
    
    private void func_174972_a(final EnumParticleTypes llllllllllllllIllIIllllIIllIlIlI, final double llllllllllllllIllIIllllIIlllIIlI, final double llllllllllllllIllIIllllIIlllIIIl, final double llllllllllllllIllIIllllIIlllIIII, final double llllllllllllllIllIIllllIIllIllll, final double llllllllllllllIllIIllllIIllIIlIl, final double llllllllllllllIllIIllllIIllIIlII, final int... llllllllllllllIllIIllllIIllIIIll) {
        this.func_180442_a(llllllllllllllIllIIllllIIllIlIlI.func_179348_c(), llllllllllllllIllIIllllIIllIlIlI.func_179344_e(), llllllllllllllIllIIllllIIlllIIlI, llllllllllllllIllIIllllIIlllIIIl, llllllllllllllIllIIllllIIlllIIII, llllllllllllllIllIIllllIIllIllll, llllllllllllllIllIIllllIIllIIlIl, llllllllllllllIllIIllllIIllIIlII, llllllllllllllIllIIllllIIllIIIll);
    }
    
    static final class SwitchEnumUseage
    {
        static final /* synthetic */ int[] field_178037_a;
        
        static {
            field_178037_a = new int[VertexFormatElement.EnumUseage.values().length];
            try {
                SwitchEnumUseage.field_178037_a[VertexFormatElement.EnumUseage.POSITION.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumUseage.field_178037_a[VertexFormatElement.EnumUseage.UV.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumUseage.field_178037_a[VertexFormatElement.EnumUseage.COLOR.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
        }
    }
    
    public static class ContainerLocalRenderInformation
    {
        final /* synthetic */ EnumFacing field_178034_b;
        final /* synthetic */ Set field_178035_c;
        final /* synthetic */ int field_178032_d;
        final /* synthetic */ RenderChunk field_178036_a;
        
        ContainerLocalRenderInformation(final RenderChunk lllllllllllllllIIIIlIIllIlllIIIl, final EnumFacing lllllllllllllllIIIIlIIllIlllIIII, final int lllllllllllllllIIIIlIIllIllIllll, final Object lllllllllllllllIIIIlIIllIllIlllI) {
            this(lllllllllllllllIIIIlIIllIlllIIIl, lllllllllllllllIIIIlIIllIlllIIII, lllllllllllllllIIIIlIIllIllIllll);
        }
        
        public ContainerLocalRenderInformation(final RenderChunk lllllllllllllllIIIIlIIllIlllllIl, final EnumFacing lllllllllllllllIIIIlIIllIllllIII, final int lllllllllllllllIIIIlIIllIllllIll) {
            this.field_178035_c = EnumSet.noneOf(EnumFacing.class);
            this.field_178036_a = lllllllllllllllIIIIlIIllIlllllIl;
            this.field_178034_b = lllllllllllllllIIIIlIIllIllllIII;
            this.field_178032_d = lllllllllllllllIIIIlIIllIllllIll;
        }
    }
}
