package net.minecraft.client.renderer;

import net.minecraft.client.*;
import net.minecraft.client.renderer.texture.*;
import shadersmod.client.*;
import net.minecraft.client.entity.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import hawk.*;
import org.lwjgl.opengl.*;
import net.minecraft.item.*;
import optifine.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.world.storage.*;

public class ItemRenderer
{
    private final /* synthetic */ Minecraft mc;
    private final /* synthetic */ RenderItem itemRenderer;
    private /* synthetic */ float equippedProgress;
    private /* synthetic */ float prevEquippedProgress;
    private static final /* synthetic */ ResourceLocation RES_MAP_BACKGROUND;
    private /* synthetic */ int equippedItemSlot;
    private /* synthetic */ ItemStack itemToRender;
    private static final /* synthetic */ ResourceLocation RES_UNDERWATER_OVERLAY;
    private final /* synthetic */ RenderManager field_178111_g;
    
    private void func_178103_d() {
        GlStateManager.translate(-0.5f, 0.2f, 0.0f);
        GlStateManager.rotate(30.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-80.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(60.0f, 0.0f, 1.0f, 0.0f);
    }
    
    private void func_178108_a(final float llllllllllllllIIlIlIlIlIIllllllI, final TextureAtlasSprite llllllllllllllIIlIlIlIlIIlllllIl) {
        this.mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
        final Tessellator llllllllllllllIIlIlIlIlIIlllllII = Tessellator.getInstance();
        final WorldRenderer llllllllllllllIIlIlIlIlIIllllIll = llllllllllllllIIlIlIlIlIIlllllII.getWorldRenderer();
        final float llllllllllllllIIlIlIlIlIIllllIlI = 0.1f;
        GlStateManager.color(llllllllllllllIIlIlIlIlIIllllIlI, llllllllllllllIIlIlIlIlIIllllIlI, llllllllllllllIIlIlIlIlIIllllIlI, 0.5f);
        GlStateManager.pushMatrix();
        final float llllllllllllllIIlIlIlIlIIllllIIl = -1.0f;
        final float llllllllllllllIIlIlIlIlIIllllIII = 1.0f;
        final float llllllllllllllIIlIlIlIlIIlllIlll = -1.0f;
        final float llllllllllllllIIlIlIlIlIIlllIllI = 1.0f;
        final float llllllllllllllIIlIlIlIlIIlllIlIl = -0.5f;
        final float llllllllllllllIIlIlIlIlIIlllIlII = llllllllllllllIIlIlIlIlIIlllllIl.getMinU();
        final float llllllllllllllIIlIlIlIlIIlllIIll = llllllllllllllIIlIlIlIlIIlllllIl.getMaxU();
        final float llllllllllllllIIlIlIlIlIIlllIIlI = llllllllllllllIIlIlIlIlIIlllllIl.getMinV();
        final float llllllllllllllIIlIlIlIlIIlllIIIl = llllllllllllllIIlIlIlIlIIlllllIl.getMaxV();
        llllllllllllllIIlIlIlIlIIllllIll.startDrawingQuads();
        llllllllllllllIIlIlIlIlIIllllIll.addVertexWithUV(llllllllllllllIIlIlIlIlIIllllIIl, llllllllllllllIIlIlIlIlIIlllIlll, llllllllllllllIIlIlIlIlIIlllIlIl, llllllllllllllIIlIlIlIlIIlllIIll, llllllllllllllIIlIlIlIlIIlllIIIl);
        llllllllllllllIIlIlIlIlIIllllIll.addVertexWithUV(llllllllllllllIIlIlIlIlIIllllIII, llllllllllllllIIlIlIlIlIIlllIlll, llllllllllllllIIlIlIlIlIIlllIlIl, llllllllllllllIIlIlIlIlIIlllIlII, llllllllllllllIIlIlIlIlIIlllIIIl);
        llllllllllllllIIlIlIlIlIIllllIll.addVertexWithUV(llllllllllllllIIlIlIlIlIIllllIII, llllllllllllllIIlIlIlIlIIlllIllI, llllllllllllllIIlIlIlIlIIlllIlIl, llllllllllllllIIlIlIlIlIIlllIlII, llllllllllllllIIlIlIlIlIIlllIIlI);
        llllllllllllllIIlIlIlIlIIllllIll.addVertexWithUV(llllllllllllllIIlIlIlIlIIllllIIl, llllllllllllllIIlIlIlIlIIlllIllI, llllllllllllllIIlIlIlIlIIlllIlIl, llllllllllllllIIlIlIlIlIIlllIIll, llllllllllllllIIlIlIlIlIIlllIIlI);
        llllllllllllllIIlIlIlIlIIlllllII.draw();
        GlStateManager.popMatrix();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    public void updateEquippedItem() {
        this.prevEquippedProgress = this.equippedProgress;
        final EntityPlayerSP llllllllllllllIIlIlIlIlIIIIIIlIl = this.mc.thePlayer;
        final ItemStack llllllllllllllIIlIlIlIlIIIIIIlII = llllllllllllllIIlIlIlIlIIIIIIlIl.inventory.getCurrentItem();
        boolean llllllllllllllIIlIlIlIlIIIIIIIll = false;
        if (this.itemToRender != null && llllllllllllllIIlIlIlIlIIIIIIlII != null) {
            if (!this.itemToRender.getIsItemStackEqual(llllllllllllllIIlIlIlIlIIIIIIlII)) {
                if (Reflector.ForgeItem_shouldCauseReequipAnimation.exists()) {
                    final boolean llllllllllllllIIlIlIlIlIIIIIIIlI = Reflector.callBoolean(this.itemToRender.getItem(), Reflector.ForgeItem_shouldCauseReequipAnimation, this.itemToRender, llllllllllllllIIlIlIlIlIIIIIIlII, this.equippedItemSlot != llllllllllllllIIlIlIlIlIIIIIIlIl.inventory.currentItem);
                    if (!llllllllllllllIIlIlIlIlIIIIIIIlI) {
                        this.itemToRender = llllllllllllllIIlIlIlIlIIIIIIlII;
                        this.equippedItemSlot = llllllllllllllIIlIlIlIlIIIIIIlIl.inventory.currentItem;
                        return;
                    }
                }
                llllllllllllllIIlIlIlIlIIIIIIIll = true;
            }
        }
        else {
            llllllllllllllIIlIlIlIlIIIIIIIll = (this.itemToRender != null || llllllllllllllIIlIlIlIlIIIIIIlII != null);
        }
        final float llllllllllllllIIlIlIlIlIIIIIIIIl = 0.4f;
        final float llllllllllllllIIlIlIlIlIIIIIIIII = llllllllllllllIIlIlIlIlIIIIIIIll ? 0.0f : 1.0f;
        final float llllllllllllllIIlIlIlIIlllllllll = MathHelper.clamp_float(llllllllllllllIIlIlIlIlIIIIIIIII - this.equippedProgress, -llllllllllllllIIlIlIlIlIIIIIIIIl, llllllllllllllIIlIlIlIlIIIIIIIIl);
        this.equippedProgress += llllllllllllllIIlIlIlIIlllllllll;
        if (this.equippedProgress < 0.1f) {
            if (Config.isShaders()) {
                Shaders.itemToRender = llllllllllllllIIlIlIlIlIIIIIIlII;
            }
            this.itemToRender = llllllllllllllIIlIlIlIlIIIIIIlII;
            this.equippedItemSlot = llllllllllllllIIlIlIlIlIIIIIIlIl.inventory.currentItem;
        }
    }
    
    private float func_178100_c(final float llllllllllllllIIlIlIlIlllIlIlIII) {
        float llllllllllllllIIlIlIlIlllIlIlIIl = 1.0f - llllllllllllllIIlIlIlIlllIlIlIII / 45.0f + 0.1f;
        llllllllllllllIIlIlIlIlllIlIlIIl = MathHelper.clamp_float(llllllllllllllIIlIlIlIlllIlIlIIl, 0.0f, 1.0f);
        llllllllllllllIIlIlIlIlllIlIlIIl = -MathHelper.cos(llllllllllllllIIlIlIlIlllIlIlIIl * 3.1415927f) * 0.5f + 0.5f;
        return llllllllllllllIIlIlIlIlllIlIlIIl;
    }
    
    private void func_178102_b(final AbstractClientPlayer llllllllllllllIIlIlIlIlllIIlIlIl) {
        this.mc.getTextureManager().bindTexture(llllllllllllllIIlIlIlIlllIIlIlIl.getLocationSkin());
        final Render llllllllllllllIIlIlIlIlllIIlIlII = this.field_178111_g.getEntityRenderObject(this.mc.thePlayer);
        final RenderPlayer llllllllllllllIIlIlIlIlllIIlIIll = (RenderPlayer)llllllllllllllIIlIlIlIlllIIlIlII;
        if (!llllllllllllllIIlIlIlIlllIIlIlIl.isInvisible()) {
            this.func_180534_a(llllllllllllllIIlIlIlIlllIIlIIll);
            this.func_178106_b(llllllllllllllIIlIlIlIlllIIlIIll);
        }
    }
    
    private void func_178104_a(final AbstractClientPlayer llllllllllllllIIlIlIlIllIIlIlllI, final float llllllllllllllIIlIlIlIllIIlIIllI) {
        final float llllllllllllllIIlIlIlIllIIlIllII = llllllllllllllIIlIlIlIllIIlIlllI.getItemInUseCount() - llllllllllllllIIlIlIlIllIIlIIllI + 1.0f;
        final float llllllllllllllIIlIlIlIllIIlIlIll = llllllllllllllIIlIlIlIllIIlIllII / this.itemToRender.getMaxItemUseDuration();
        float llllllllllllllIIlIlIlIllIIlIlIlI = MathHelper.abs(MathHelper.cos(llllllllllllllIIlIlIlIllIIlIllII / 4.0f * 3.1415927f) * 0.1f);
        if (llllllllllllllIIlIlIlIllIIlIlIll >= 0.8f) {
            llllllllllllllIIlIlIlIllIIlIlIlI = 0.0f;
        }
        GlStateManager.translate(0.0f, llllllllllllllIIlIlIlIllIIlIlIlI, 0.0f);
        final float llllllllllllllIIlIlIlIllIIlIlIIl = 1.0f - (float)Math.pow(llllllllllllllIIlIlIlIllIIlIlIll, 27.0);
        GlStateManager.translate(llllllllllllllIIlIlIlIllIIlIlIIl * 0.6f, llllllllllllllIIlIlIlIllIIlIlIIl * -0.5f, llllllllllllllIIlIlIlIllIIlIlIIl * 0.0f);
        GlStateManager.rotate(llllllllllllllIIlIlIlIllIIlIlIIl * 90.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(llllllllllllllIIlIlIlIllIIlIlIIl * 10.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(llllllllllllllIIlIlIlIllIIlIlIIl * 30.0f, 0.0f, 0.0f, 1.0f);
    }
    
    public void resetEquippedProgress2() {
        this.equippedProgress = 0.0f;
    }
    
    static {
        RES_MAP_BACKGROUND = new ResourceLocation("textures/map/map_background.png");
        RES_UNDERWATER_OVERLAY = new ResourceLocation("textures/misc/underwater.png");
    }
    
    public void renderItem(final EntityLivingBase llllllllllllllIIlIlIlIllllIlllll, final ItemStack llllllllllllllIIlIlIlIllllIllIII, final ItemCameraTransforms.TransformType llllllllllllllIIlIlIlIllllIlllIl) {
        if (llllllllllllllIIlIlIlIllllIllIII != null) {
            final Item llllllllllllllIIlIlIlIllllIlllII = llllllllllllllIIlIlIlIllllIllIII.getItem();
            final Block llllllllllllllIIlIlIlIllllIllIll = Block.getBlockFromItem(llllllllllllllIIlIlIlIllllIlllII);
            GlStateManager.pushMatrix();
            if (this.itemRenderer.func_175050_a(llllllllllllllIIlIlIlIllllIllIII)) {
                GlStateManager.scale(2.0f, 2.0f, 2.0f);
                if (this.func_178107_a(llllllllllllllIIlIlIlIllllIllIll)) {
                    GlStateManager.depthMask(false);
                }
            }
            this.itemRenderer.func_175049_a(llllllllllllllIIlIlIlIllllIllIII, llllllllllllllIIlIlIlIllllIlllll, llllllllllllllIIlIlIlIllllIlllIl);
            if (this.func_178107_a(llllllllllllllIIlIlIlIllllIllIll)) {
                GlStateManager.depthMask(true);
            }
            GlStateManager.popMatrix();
        }
    }
    
    private void func_178101_a(final float llllllllllllllIIlIlIlIllllIIlIll, final float llllllllllllllIIlIlIlIllllIIllII) {
        GlStateManager.pushMatrix();
        GlStateManager.rotate(llllllllllllllIIlIlIlIllllIIlIll, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(llllllllllllllIIlIlIlIllllIIllII, 0.0f, 1.0f, 0.0f);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.popMatrix();
    }
    
    private void func_178098_a(final float llllllllllllllIIlIlIlIlIlllllllI, final AbstractClientPlayer llllllllllllllIIlIlIlIlIllllllIl) {
        GlStateManager.rotate(-18.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.rotate(-12.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-8.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.translate(-0.9f, 0.2f, 0.0f);
        final float llllllllllllllIIlIlIlIlIllllllII = this.itemToRender.getMaxItemUseDuration() - (llllllllllllllIIlIlIlIlIllllllIl.getItemInUseCount() - llllllllllllllIIlIlIlIlIlllllllI + 1.0f);
        float llllllllllllllIIlIlIlIlIlllllIll = llllllllllllllIIlIlIlIlIllllllII / 20.0f;
        llllllllllllllIIlIlIlIlIlllllIll = (llllllllllllllIIlIlIlIlIlllllIll * llllllllllllllIIlIlIlIlIlllllIll + llllllllllllllIIlIlIlIlIlllllIll * 2.0f) / 3.0f;
        if (llllllllllllllIIlIlIlIlIlllllIll > 1.0f) {
            llllllllllllllIIlIlIlIlIlllllIll = 1.0f;
        }
        if (llllllllllllllIIlIlIlIlIlllllIll > 0.1f) {
            final float llllllllllllllIIlIlIlIlIlllllIlI = MathHelper.sin((llllllllllllllIIlIlIlIlIllllllII - 0.1f) * 1.3f);
            final float llllllllllllllIIlIlIlIlIlllllIIl = llllllllllllllIIlIlIlIlIlllllIll - 0.1f;
            final float llllllllllllllIIlIlIlIlIlllllIII = llllllllllllllIIlIlIlIlIlllllIlI * llllllllllllllIIlIlIlIlIlllllIIl;
            GlStateManager.translate(llllllllllllllIIlIlIlIlIlllllIII * 0.0f, llllllllllllllIIlIlIlIlIlllllIII * 0.01f, llllllllllllllIIlIlIlIlIlllllIII * 0.0f);
        }
        GlStateManager.translate(llllllllllllllIIlIlIlIlIlllllIll * 0.0f, llllllllllllllIIlIlIlIlIlllllIll * 0.0f, llllllllllllllIIlIlIlIlIlllllIll * 0.1f);
        GlStateManager.scale(1.0f, 1.0f, 1.0f + llllllllllllllIIlIlIlIlIlllllIll * 0.2f);
    }
    
    public void renderOverlays(final float llllllllllllllIIlIlIlIlIlIlIIIIl) {
        GlStateManager.disableAlpha();
        if (this.mc.thePlayer.isEntityInsideOpaqueBlock()) {
            BlockPos llllllllllllllIIlIlIlIlIlIlIIIII = new BlockPos(this.mc.thePlayer);
            IBlockState llllllllllllllIIlIlIlIlIlIIlllll = this.mc.theWorld.getBlockState(llllllllllllllIIlIlIlIlIlIlIIIII);
            final EntityPlayerSP llllllllllllllIIlIlIlIlIlIIllllI = this.mc.thePlayer;
            for (int llllllllllllllIIlIlIlIlIlIIlllIl = 0; llllllllllllllIIlIlIlIlIlIIlllIl < 8; ++llllllllllllllIIlIlIlIlIlIIlllIl) {
                final double llllllllllllllIIlIlIlIlIlIIlllII = llllllllllllllIIlIlIlIlIlIIllllI.posX + ((llllllllllllllIIlIlIlIlIlIIlllIl >> 0) % 2 - 0.5f) * llllllllllllllIIlIlIlIlIlIIllllI.width * 0.8f;
                final double llllllllllllllIIlIlIlIlIlIIllIll = llllllllllllllIIlIlIlIlIlIIllllI.posY + ((llllllllllllllIIlIlIlIlIlIIlllIl >> 1) % 2 - 0.5f) * 0.1f;
                final double llllllllllllllIIlIlIlIlIlIIllIlI = llllllllllllllIIlIlIlIlIlIIllllI.posZ + ((llllllllllllllIIlIlIlIlIlIIlllIl >> 2) % 2 - 0.5f) * llllllllllllllIIlIlIlIlIlIIllllI.width * 0.8f;
                llllllllllllllIIlIlIlIlIlIlIIIII = new BlockPos(llllllllllllllIIlIlIlIlIlIIlllII, llllllllllllllIIlIlIlIlIlIIllIll + llllllllllllllIIlIlIlIlIlIIllllI.getEyeHeight(), llllllllllllllIIlIlIlIlIlIIllIlI);
                final IBlockState llllllllllllllIIlIlIlIlIlIIllIIl = this.mc.theWorld.getBlockState(llllllllllllllIIlIlIlIlIlIlIIIII);
                if (llllllllllllllIIlIlIlIlIlIIllIIl.getBlock().isVisuallyOpaque()) {
                    llllllllllllllIIlIlIlIlIlIIlllll = llllllllllllllIIlIlIlIlIlIIllIIl;
                }
            }
            if (llllllllllllllIIlIlIlIlIlIIlllll.getBlock().getRenderType() != -1) {
                final Object llllllllllllllIIlIlIlIlIlIIllIII = Reflector.getFieldValue(Reflector.RenderBlockOverlayEvent_OverlayType_BLOCK);
                if (!Reflector.callBoolean(Reflector.ForgeEventFactory_renderBlockOverlay, this.mc.thePlayer, llllllllllllllIIlIlIlIlIlIlIIIIl, llllllllllllllIIlIlIlIlIlIIllIII, llllllllllllllIIlIlIlIlIlIIlllll, llllllllllllllIIlIlIlIlIlIlIIIII)) {
                    this.func_178108_a(llllllllllllllIIlIlIlIlIlIlIIIIl, this.mc.getBlockRendererDispatcher().func_175023_a().func_178122_a(llllllllllllllIIlIlIlIlIlIIlllll));
                }
            }
        }
        if (!this.mc.thePlayer.func_175149_v()) {
            if (this.mc.thePlayer.isInsideOfMaterial(Material.water) && !Reflector.callBoolean(Reflector.ForgeEventFactory_renderWaterOverlay, this.mc.thePlayer, llllllllllllllIIlIlIlIlIlIlIIIIl)) {
                this.renderWaterOverlayTexture(llllllllllllllIIlIlIlIlIlIlIIIIl);
            }
            if (this.mc.thePlayer.isBurning() && !Reflector.callBoolean(Reflector.ForgeEventFactory_renderFireOverlay, this.mc.thePlayer, llllllllllllllIIlIlIlIlIlIlIIIIl)) {
                this.renderFireInFirstPerson(llllllllllllllIIlIlIlIlIlIlIIIIl);
            }
        }
        GlStateManager.enableAlpha();
    }
    
    private void renderFireInFirstPerson(final float llllllllllllllIIlIlIlIlIIIlIlIll) {
        final Tessellator llllllllllllllIIlIlIlIlIIIlIlIlI = Tessellator.getInstance();
        final WorldRenderer llllllllllllllIIlIlIlIlIIIlIlIIl = llllllllllllllIIlIlIlIlIIIlIlIlI.getWorldRenderer();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 0.9f);
        GlStateManager.depthFunc(519);
        GlStateManager.depthMask(false);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        final float llllllllllllllIIlIlIlIlIIIlIlIII = 1.0f;
        for (int llllllllllllllIIlIlIlIlIIIlIIlll = 0; llllllllllllllIIlIlIlIlIIIlIIlll < 2; ++llllllllllllllIIlIlIlIlIIIlIIlll) {
            GlStateManager.pushMatrix();
            final TextureAtlasSprite llllllllllllllIIlIlIlIlIIIlIIllI = this.mc.getTextureMapBlocks().getAtlasSprite("minecraft:blocks/fire_layer_1");
            this.mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
            final float llllllllllllllIIlIlIlIlIIIlIIlIl = llllllllllllllIIlIlIlIlIIIlIIllI.getMinU();
            final float llllllllllllllIIlIlIlIlIIIlIIlII = llllllllllllllIIlIlIlIlIIIlIIllI.getMaxU();
            final float llllllllllllllIIlIlIlIlIIIlIIIll = llllllllllllllIIlIlIlIlIIIlIIllI.getMinV();
            final float llllllllllllllIIlIlIlIlIIIlIIIlI = llllllllllllllIIlIlIlIlIIIlIIllI.getMaxV();
            final float llllllllllllllIIlIlIlIlIIIlIIIIl = (0.0f - llllllllllllllIIlIlIlIlIIIlIlIII) / 2.0f;
            final float llllllllllllllIIlIlIlIlIIIlIIIII = llllllllllllllIIlIlIlIlIIIlIIIIl + llllllllllllllIIlIlIlIlIIIlIlIII;
            final float llllllllllllllIIlIlIlIlIIIIlllll = 0.0f - llllllllllllllIIlIlIlIlIIIlIlIII / 2.0f;
            final float llllllllllllllIIlIlIlIlIIIIllllI = llllllllllllllIIlIlIlIlIIIIlllll + llllllllllllllIIlIlIlIlIIIlIlIII;
            final float llllllllllllllIIlIlIlIlIIIIlllIl = -0.5f;
            GlStateManager.translate(-(llllllllllllllIIlIlIlIlIIIlIIlll * 2 - 1) * 0.24f, -0.3f, 0.0f);
            GlStateManager.rotate((llllllllllllllIIlIlIlIlIIIlIIlll * 2 - 1) * 10.0f, 0.0f, 1.0f, 0.0f);
            llllllllllllllIIlIlIlIlIIIlIlIIl.startDrawingQuads();
            llllllllllllllIIlIlIlIlIIIlIlIIl.addVertexWithUV(llllllllllllllIIlIlIlIlIIIlIIIIl, llllllllllllllIIlIlIlIlIIIIlllll, llllllllllllllIIlIlIlIlIIIIlllIl, llllllllllllllIIlIlIlIlIIIlIIlII, llllllllllllllIIlIlIlIlIIIlIIIlI);
            llllllllllllllIIlIlIlIlIIIlIlIIl.addVertexWithUV(llllllllllllllIIlIlIlIlIIIlIIIII, llllllllllllllIIlIlIlIlIIIIlllll, llllllllllllllIIlIlIlIlIIIIlllIl, llllllllllllllIIlIlIlIlIIIlIIlIl, llllllllllllllIIlIlIlIlIIIlIIIlI);
            llllllllllllllIIlIlIlIlIIIlIlIIl.addVertexWithUV(llllllllllllllIIlIlIlIlIIIlIIIII, llllllllllllllIIlIlIlIlIIIIllllI, llllllllllllllIIlIlIlIlIIIIlllIl, llllllllllllllIIlIlIlIlIIIlIIlIl, llllllllllllllIIlIlIlIlIIIlIIIll);
            llllllllllllllIIlIlIlIlIIIlIlIIl.addVertexWithUV(llllllllllllllIIlIlIlIlIIIlIIIIl, llllllllllllllIIlIlIlIlIIIIllllI, llllllllllllllIIlIlIlIlIIIIlllIl, llllllllllllllIIlIlIlIlIIIlIIlII, llllllllllllllIIlIlIlIlIIIlIIIll);
            llllllllllllllIIlIlIlIlIIIlIlIlI.draw();
            GlStateManager.popMatrix();
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.disableBlend();
        GlStateManager.depthMask(true);
        GlStateManager.depthFunc(515);
    }
    
    private void func_178110_a(final EntityPlayerSP llllllllllllllIIlIlIlIlllIllIlIl, final float llllllllllllllIIlIlIlIlllIllIlII) {
        final float llllllllllllllIIlIlIlIlllIllIIll = llllllllllllllIIlIlIlIlllIllIlIl.prevRenderArmPitch + (llllllllllllllIIlIlIlIlllIllIlIl.renderArmPitch - llllllllllllllIIlIlIlIlllIllIlIl.prevRenderArmPitch) * llllllllllllllIIlIlIlIlllIllIlII;
        final float llllllllllllllIIlIlIlIlllIllIIlI = llllllllllllllIIlIlIlIlllIllIlIl.prevRenderArmYaw + (llllllllllllllIIlIlIlIlllIllIlIl.renderArmYaw - llllllllllllllIIlIlIlIlllIllIlIl.prevRenderArmYaw) * llllllllllllllIIlIlIlIlllIllIlII;
        GlStateManager.rotate((llllllllllllllIIlIlIlIlllIllIlIl.rotationPitch - llllllllllllllIIlIlIlIlllIllIIll) * 0.1f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate((llllllllllllllIIlIlIlIlllIllIlIl.rotationYaw - llllllllllllllIIlIlIlIlllIllIIlI) * 0.1f, 0.0f, 1.0f, 0.0f);
    }
    
    private void monsoon2() {
        GlStateManager.translate(-0.5f, 0.2f, 0.0f);
        GlStateManager.rotate(30.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-80.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(60.0f, 0.0f, 1.0f, 0.0f);
    }
    
    private void func_180534_a(final RenderPlayer llllllllllllllIIlIlIlIlllIlIIIIl) {
        GlStateManager.pushMatrix();
        GlStateManager.rotate(54.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(64.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(-62.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.translate(0.25f, -0.85f, 0.75f);
        llllllllllllllIIlIlIlIlllIlIIIIl.func_177138_b(this.mc.thePlayer);
        GlStateManager.popMatrix();
    }
    
    public void renderItemInFirstPerson(final float llllllllllllllIIlIlIlIlIlIllIlII) {
        final float llllllllllllllIIlIlIlIlIlIllllIl = 1.0f - (this.prevEquippedProgress + (this.equippedProgress - this.prevEquippedProgress) * llllllllllllllIIlIlIlIlIlIllIlII);
        final EntityPlayerSP llllllllllllllIIlIlIlIlIlIllllII = this.mc.thePlayer;
        final float llllllllllllllIIlIlIlIlIlIlllIll = llllllllllllllIIlIlIlIlIlIllllII.getSwingProgress(llllllllllllllIIlIlIlIlIlIllIlII);
        final float llllllllllllllIIlIlIlIlIlIlllIlI = llllllllllllllIIlIlIlIlIlIllllII.prevRotationPitch + (llllllllllllllIIlIlIlIlIlIllllII.rotationPitch - llllllllllllllIIlIlIlIlIlIllllII.prevRotationPitch) * llllllllllllllIIlIlIlIlIlIllIlII;
        final float llllllllllllllIIlIlIlIlIlIlllIIl = llllllllllllllIIlIlIlIlIlIllllII.prevRotationYaw + (llllllllllllllIIlIlIlIlIlIllllII.rotationYaw - llllllllllllllIIlIlIlIlIlIllllII.prevRotationYaw) * llllllllllllllIIlIlIlIlIlIllIlII;
        this.func_178101_a(llllllllllllllIIlIlIlIlIlIlllIlI, llllllllllllllIIlIlIlIlIlIlllIIl);
        this.func_178109_a(llllllllllllllIIlIlIlIlIlIllllII);
        this.func_178110_a(llllllllllllllIIlIlIlIlIlIllllII, llllllllllllllIIlIlIlIlIlIllIlII);
        GlStateManager.enableRescaleNormal();
        GlStateManager.pushMatrix();
        if (this.itemToRender != null) {
            if (this.itemToRender.getItem() instanceof ItemMap) {
                this.func_178097_a(llllllllllllllIIlIlIlIlIlIllllII, llllllllllllllIIlIlIlIlIlIlllIlI, llllllllllllllIIlIlIlIlIlIllllIl, llllllllllllllIIlIlIlIlIlIlllIll);
            }
            else if (llllllllllllllIIlIlIlIlIlIllllII.getItemInUseCount() > 0) {
                final EnumAction llllllllllllllIIlIlIlIlIlIlllIII = this.itemToRender.getItemUseAction();
                switch (SwitchEnumAction.field_178094_a[llllllllllllllIIlIlIlIlIlIlllIII.ordinal()]) {
                    case 1: {
                        this.func_178096_b(llllllllllllllIIlIlIlIlIlIllllIl, 0.0f);
                        break;
                    }
                    case 2:
                    case 3: {
                        this.func_178104_a(llllllllllllllIIlIlIlIlIlIllllII, llllllllllllllIIlIlIlIlIlIllIlII);
                        this.func_178096_b(llllllllllllllIIlIlIlIlIlIllllIl, 0.0f);
                        break;
                    }
                    case 4: {
                        if (Client.animations.animation.is("EZE")) {
                            final float llllllllllllllIIlIlIlIlIlIllIlll = (float)Math.sin(Math.sqrt(llllllllllllllIIlIlIlIlIlIlllIll) * 3.141592653589793);
                            this.func_178096_b(llllllllllllllIIlIlIlIlIlIllllIl, 0.0f);
                            GlStateManager.translate(0.1f, 0.135f, -0.15f);
                            GL11.glRotated((double)(-llllllllllllllIIlIlIlIlIlIllIlll * 40.0f), (double)(llllllllllllllIIlIlIlIlIlIllIlll / 2.0f), 0.0, 9.0);
                            GL11.glRotated((double)(-llllllllllllllIIlIlIlIlIlIllIlll * 40.0f), 0.800000011920929, (double)(llllllllllllllIIlIlIlIlIlIllIlll / 2.0f), 0.0);
                            this.func_178103_d();
                        }
                        if (Client.animations.animation.is("Vanilla")) {
                            this.func_178096_b(llllllllllllllIIlIlIlIlIlIllllIl, 0.0f);
                            this.func_178103_d();
                            break;
                        }
                        if (Client.animations.animation.is("Monsoon")) {
                            this.monsoon(llllllllllllllIIlIlIlIlIlIllllIl, 0.0f);
                            GlStateManager.scale(2.0f, 2.0f, 2.0f);
                            this.func_178103_d();
                            final float llllllllllllllIIlIlIlIlIlIllIllI = MathHelper.sin(MathHelper.sqrt_float(llllllllllllllIIlIlIlIlIlIlllIll) * 3.1415927f);
                            GlStateManager.translate(1.0, -0.8, 1.0);
                            GlStateManager.rotate(-llllllllllllllIIlIlIlIlIlIllIllI * 50.0f / 2.0f, -8.0f, 0.4f, 9.0f);
                            GlStateManager.rotate(-llllllllllllllIIlIlIlIlIlIllIllI * 40.0f, 1.5f, -0.4f, -0.0f);
                        }
                        if (Client.animations.animation.is("Fan")) {
                            this.func_178096_b(llllllllllllllIIlIlIlIlIlIllllIl, 0.0f);
                            this.fan();
                            break;
                        }
                        break;
                    }
                    case 5: {
                        this.func_178096_b(llllllllllllllIIlIlIlIlIlIllllIl, 0.0f);
                        this.func_178098_a(llllllllllllllIIlIlIlIlIlIllIlII, llllllllllllllIIlIlIlIlIlIllllII);
                        break;
                    }
                }
            }
            else {
                this.func_178105_d(llllllllllllllIIlIlIlIlIlIlllIll);
                this.func_178096_b(llllllllllllllIIlIlIlIlIlIllllIl, llllllllllllllIIlIlIlIlIlIlllIll);
            }
            this.renderItem(llllllllllllllIIlIlIlIlIlIllllII, this.itemToRender, ItemCameraTransforms.TransformType.FIRST_PERSON);
        }
        else if (!llllllllllllllIIlIlIlIlIlIllllII.isInvisible()) {
            this.func_178095_a(llllllllllllllIIlIlIlIlIlIllllII, llllllllllllllIIlIlIlIlIlIllllIl, llllllllllllllIIlIlIlIlIlIlllIll);
        }
        GlStateManager.popMatrix();
        GlStateManager.disableRescaleNormal();
        RenderHelper.disableStandardItemLighting();
    }
    
    public void resetEquippedProgress() {
        this.equippedProgress = 0.0f;
    }
    
    private void func_178106_b(final RenderPlayer llllllllllllllIIlIlIlIlllIIlllIl) {
        GlStateManager.pushMatrix();
        GlStateManager.rotate(92.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(45.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(41.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.translate(-0.3f, -1.1f, 0.45f);
        llllllllllllllIIlIlIlIlllIIlllIl.func_177139_c(this.mc.thePlayer);
        GlStateManager.popMatrix();
    }
    
    private void func_178109_a(final AbstractClientPlayer llllllllllllllIIlIlIlIlllIlllllI) {
        int llllllllllllllIIlIlIlIllllIIIIlI = this.mc.theWorld.getCombinedLight(new BlockPos(llllllllllllllIIlIlIlIlllIlllllI.posX, llllllllllllllIIlIlIlIlllIlllllI.posY + llllllllllllllIIlIlIlIlllIlllllI.getEyeHeight(), llllllllllllllIIlIlIlIlllIlllllI.posZ), 0);
        if (Config.isDynamicLights()) {
            llllllllllllllIIlIlIlIllllIIIIlI = DynamicLights.getCombinedLight(this.mc.func_175606_aa(), llllllllllllllIIlIlIlIllllIIIIlI);
        }
        final float llllllllllllllIIlIlIlIllllIIIIIl = (float)(llllllllllllllIIlIlIlIllllIIIIlI & 0xFFFF);
        final float llllllllllllllIIlIlIlIllllIIIIII = (float)(llllllllllllllIIlIlIlIllllIIIIlI >> 16);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, llllllllllllllIIlIlIlIllllIIIIIl, llllllllllllllIIlIlIlIllllIIIIII);
    }
    
    private void renderWaterOverlayTexture(final float llllllllllllllIIlIlIlIlIIlIIIlll) {
        this.mc.getTextureManager().bindTexture(ItemRenderer.RES_UNDERWATER_OVERLAY);
        final Tessellator llllllllllllllIIlIlIlIlIIlIlIIll = Tessellator.getInstance();
        final WorldRenderer llllllllllllllIIlIlIlIlIIlIlIIlI = llllllllllllllIIlIlIlIlIIlIlIIll.getWorldRenderer();
        final float llllllllllllllIIlIlIlIlIIlIlIIIl = this.mc.thePlayer.getBrightness(llllllllllllllIIlIlIlIlIIlIIIlll);
        GlStateManager.color(llllllllllllllIIlIlIlIlIIlIlIIIl, llllllllllllllIIlIlIlIlIIlIlIIIl, llllllllllllllIIlIlIlIlIIlIlIIIl, 0.5f);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.pushMatrix();
        final float llllllllllllllIIlIlIlIlIIlIlIIII = 4.0f;
        final float llllllllllllllIIlIlIlIlIIlIIllll = -1.0f;
        final float llllllllllllllIIlIlIlIlIIlIIlllI = 1.0f;
        final float llllllllllllllIIlIlIlIlIIlIIllIl = -1.0f;
        final float llllllllllllllIIlIlIlIlIIlIIllII = 1.0f;
        final float llllllllllllllIIlIlIlIlIIlIIlIll = -0.5f;
        final float llllllllllllllIIlIlIlIlIIlIIlIlI = -this.mc.thePlayer.rotationYaw / 64.0f;
        final float llllllllllllllIIlIlIlIlIIlIIlIIl = this.mc.thePlayer.rotationPitch / 64.0f;
        llllllllllllllIIlIlIlIlIIlIlIIlI.startDrawingQuads();
        llllllllllllllIIlIlIlIlIIlIlIIlI.addVertexWithUV(llllllllllllllIIlIlIlIlIIlIIllll, llllllllllllllIIlIlIlIlIIlIIllIl, llllllllllllllIIlIlIlIlIIlIIlIll, llllllllllllllIIlIlIlIlIIlIlIIII + llllllllllllllIIlIlIlIlIIlIIlIlI, llllllllllllllIIlIlIlIlIIlIlIIII + llllllllllllllIIlIlIlIlIIlIIlIIl);
        llllllllllllllIIlIlIlIlIIlIlIIlI.addVertexWithUV(llllllllllllllIIlIlIlIlIIlIIlllI, llllllllllllllIIlIlIlIlIIlIIllIl, llllllllllllllIIlIlIlIlIIlIIlIll, 0.0f + llllllllllllllIIlIlIlIlIIlIIlIlI, llllllllllllllIIlIlIlIlIIlIlIIII + llllllllllllllIIlIlIlIlIIlIIlIIl);
        llllllllllllllIIlIlIlIlIIlIlIIlI.addVertexWithUV(llllllllllllllIIlIlIlIlIIlIIlllI, llllllllllllllIIlIlIlIlIIlIIllII, llllllllllllllIIlIlIlIlIIlIIlIll, 0.0f + llllllllllllllIIlIlIlIlIIlIIlIlI, 0.0f + llllllllllllllIIlIlIlIlIIlIIlIIl);
        llllllllllllllIIlIlIlIlIIlIlIIlI.addVertexWithUV(llllllllllllllIIlIlIlIlIIlIIllll, llllllllllllllIIlIlIlIlIIlIIllII, llllllllllllllIIlIlIlIlIIlIIlIll, llllllllllllllIIlIlIlIlIIlIlIIII + llllllllllllllIIlIlIlIlIIlIIlIlI, 0.0f + llllllllllllllIIlIlIlIlIIlIIlIIl);
        llllllllllllllIIlIlIlIlIIlIlIIll.draw();
        GlStateManager.popMatrix();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.disableBlend();
    }
    
    private void func_178105_d(final float llllllllllllllIIlIlIlIllIIlllllI) {
        final float llllllllllllllIIlIlIlIllIIllllIl = -0.4f * MathHelper.sin(MathHelper.sqrt_float(llllllllllllllIIlIlIlIllIIlllllI) * 3.1415927f);
        final float llllllllllllllIIlIlIlIllIIllllII = 0.2f * MathHelper.sin(MathHelper.sqrt_float(llllllllllllllIIlIlIlIllIIlllllI) * 3.1415927f * 2.0f);
        final float llllllllllllllIIlIlIlIllIIlllIll = -0.2f * MathHelper.sin(llllllllllllllIIlIlIlIllIIlllllI * 3.1415927f);
        GlStateManager.translate(llllllllllllllIIlIlIlIllIIllllIl, llllllllllllllIIlIlIlIllIIllllII, llllllllllllllIIlIlIlIllIIlllIll);
    }
    
    private void func_178095_a(final AbstractClientPlayer llllllllllllllIIlIlIlIllIlIIllIl, final float llllllllllllllIIlIlIlIllIlIIllII, final float llllllllllllllIIlIlIlIllIlIlIllI) {
        final float llllllllllllllIIlIlIlIllIlIlIlIl = -0.3f * MathHelper.sin(MathHelper.sqrt_float(llllllllllllllIIlIlIlIllIlIlIllI) * 3.1415927f);
        final float llllllllllllllIIlIlIlIllIlIlIlII = 0.4f * MathHelper.sin(MathHelper.sqrt_float(llllllllllllllIIlIlIlIllIlIlIllI) * 3.1415927f * 2.0f);
        final float llllllllllllllIIlIlIlIllIlIlIIll = -0.4f * MathHelper.sin(llllllllllllllIIlIlIlIllIlIlIllI * 3.1415927f);
        GlStateManager.translate(llllllllllllllIIlIlIlIllIlIlIlIl, llllllllllllllIIlIlIlIllIlIlIlII, llllllllllllllIIlIlIlIllIlIlIIll);
        GlStateManager.translate(0.64000005f, -0.6f, -0.71999997f);
        GlStateManager.translate(0.0f, llllllllllllllIIlIlIlIllIlIIllII * -0.6f, 0.0f);
        GlStateManager.rotate(45.0f, 0.0f, 1.0f, 0.0f);
        final float llllllllllllllIIlIlIlIllIlIlIIlI = MathHelper.sin(llllllllllllllIIlIlIlIllIlIlIllI * llllllllllllllIIlIlIlIllIlIlIllI * 3.1415927f);
        final float llllllllllllllIIlIlIlIllIlIlIIIl = MathHelper.sin(MathHelper.sqrt_float(llllllllllllllIIlIlIlIllIlIlIllI) * 3.1415927f);
        GlStateManager.rotate(llllllllllllllIIlIlIlIllIlIlIIIl * 70.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(llllllllllllllIIlIlIlIllIlIlIIlI * -20.0f, 0.0f, 0.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(llllllllllllllIIlIlIlIllIlIIllIl.getLocationSkin());
        GlStateManager.translate(-1.0f, 3.6f, 3.5f);
        GlStateManager.rotate(120.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.rotate(200.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(-135.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.scale(1.0f, 1.0f, 1.0f);
        GlStateManager.translate(5.6f, 0.0f, 0.0f);
        final Render llllllllllllllIIlIlIlIllIlIlIIII = this.field_178111_g.getEntityRenderObject(this.mc.thePlayer);
        final RenderPlayer llllllllllllllIIlIlIlIllIlIIllll = (RenderPlayer)llllllllllllllIIlIlIlIllIlIlIIII;
        llllllllllllllIIlIlIlIllIlIIllll.func_177138_b(this.mc.thePlayer);
    }
    
    private boolean func_178107_a(final Block llllllllllllllIIlIlIlIllllIlIIlI) {
        return llllllllllllllIIlIlIlIllllIlIIlI != null && llllllllllllllIIlIlIlIllllIlIIlI.getBlockLayer() == EnumWorldBlockLayer.TRANSLUCENT;
    }
    
    private void monsoon(final float llllllllllllllIIlIlIlIllIIIIllll, final float llllllllllllllIIlIlIlIllIIIIlllI) {
        GlStateManager.translate(0.26f, -0.18f, -0.71999997f);
        GlStateManager.translate(0.0f, llllllllllllllIIlIlIlIllIIIIllll * -0.6f, 0.0f);
        GlStateManager.rotate(45.0f, 0.0f, 1.0f, 0.0f);
        final float llllllllllllllIIlIlIlIllIIIIllIl = MathHelper.sin(llllllllllllllIIlIlIlIllIIIIlllI * llllllllllllllIIlIlIlIllIIIIlllI * 3.1415927f);
        final float llllllllllllllIIlIlIlIllIIIIllII = MathHelper.sin(MathHelper.sqrt_float(llllllllllllllIIlIlIlIllIIIIlllI) * 3.1415927f);
        GlStateManager.rotate(llllllllllllllIIlIlIlIllIIIIllIl * -20.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(llllllllllllllIIlIlIlIllIIIIllII * -20.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.rotate(llllllllllllllIIlIlIlIllIIIIllII * -80.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.scale(0.2f, 0.2f, 0.2f);
    }
    
    public ItemRenderer(final Minecraft llllllllllllllIIlIlIlIlllllIIlll) {
        this.equippedItemSlot = -1;
        this.mc = llllllllllllllIIlIlIlIlllllIIlll;
        this.field_178111_g = llllllllllllllIIlIlIlIlllllIIlll.getRenderManager();
        this.itemRenderer = llllllllllllllIIlIlIlIlllllIIlll.getRenderItem();
    }
    
    private void func_178097_a(final AbstractClientPlayer llllllllllllllIIlIlIlIllIlllIIIl, final float llllllllllllllIIlIlIlIllIlllIIII, final float llllllllllllllIIlIlIlIllIllIllll, final float llllllllllllllIIlIlIlIllIlllllII) {
        final float llllllllllllllIIlIlIlIllIllllIll = -0.4f * MathHelper.sin(MathHelper.sqrt_float(llllllllllllllIIlIlIlIllIlllllII) * 3.1415927f);
        final float llllllllllllllIIlIlIlIllIllllIlI = 0.2f * MathHelper.sin(MathHelper.sqrt_float(llllllllllllllIIlIlIlIllIlllllII) * 3.1415927f * 2.0f);
        final float llllllllllllllIIlIlIlIllIllllIIl = -0.2f * MathHelper.sin(llllllllllllllIIlIlIlIllIlllllII * 3.1415927f);
        GlStateManager.translate(llllllllllllllIIlIlIlIllIllllIll, llllllllllllllIIlIlIlIllIllllIlI, llllllllllllllIIlIlIlIllIllllIIl);
        final float llllllllllllllIIlIlIlIllIllllIII = this.func_178100_c(llllllllllllllIIlIlIlIllIlllIIII);
        GlStateManager.translate(0.0f, 0.04f, -0.72f);
        GlStateManager.translate(0.0f, llllllllllllllIIlIlIlIllIllIllll * -1.2f, 0.0f);
        GlStateManager.translate(0.0f, llllllllllllllIIlIlIlIllIllllIII * -0.5f, 0.0f);
        GlStateManager.rotate(90.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(llllllllllllllIIlIlIlIllIllllIII * -85.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.rotate(0.0f, 1.0f, 0.0f, 0.0f);
        this.func_178102_b(llllllllllllllIIlIlIlIllIlllIIIl);
        final float llllllllllllllIIlIlIlIllIlllIlll = MathHelper.sin(llllllllllllllIIlIlIlIllIlllllII * llllllllllllllIIlIlIlIllIlllllII * 3.1415927f);
        final float llllllllllllllIIlIlIlIllIlllIllI = MathHelper.sin(MathHelper.sqrt_float(llllllllllllllIIlIlIlIllIlllllII) * 3.1415927f);
        GlStateManager.rotate(llllllllllllllIIlIlIlIllIlllIlll * -20.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(llllllllllllllIIlIlIlIllIlllIllI * -20.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.rotate(llllllllllllllIIlIlIlIllIlllIllI * -80.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.scale(0.38f, 0.38f, 0.38f);
        GlStateManager.rotate(90.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.rotate(0.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.translate(-1.0f, -1.0f, 0.0f);
        GlStateManager.scale(0.015625f, 0.015625f, 0.015625f);
        this.mc.getTextureManager().bindTexture(ItemRenderer.RES_MAP_BACKGROUND);
        final Tessellator llllllllllllllIIlIlIlIllIlllIlIl = Tessellator.getInstance();
        final WorldRenderer llllllllllllllIIlIlIlIllIlllIlII = llllllllllllllIIlIlIlIllIlllIlIl.getWorldRenderer();
        GL11.glNormal3f(0.0f, 0.0f, -1.0f);
        llllllllllllllIIlIlIlIllIlllIlII.startDrawingQuads();
        llllllllllllllIIlIlIlIllIlllIlII.addVertexWithUV(-7.0, 135.0, 0.0, 0.0, 1.0);
        llllllllllllllIIlIlIlIllIlllIlII.addVertexWithUV(135.0, 135.0, 0.0, 1.0, 1.0);
        llllllllllllllIIlIlIlIllIlllIlII.addVertexWithUV(135.0, -7.0, 0.0, 1.0, 0.0);
        llllllllllllllIIlIlIlIllIlllIlII.addVertexWithUV(-7.0, -7.0, 0.0, 0.0, 0.0);
        llllllllllllllIIlIlIlIllIlllIlIl.draw();
        final MapData llllllllllllllIIlIlIlIllIlllIIll = Items.filled_map.getMapData(this.itemToRender, this.mc.theWorld);
        if (llllllllllllllIIlIlIlIllIlllIIll != null) {
            this.mc.entityRenderer.getMapItemRenderer().func_148250_a(llllllllllllllIIlIlIlIllIlllIIll, false);
        }
    }
    
    private void fan() {
        float llllllllllllllIIlIlIlIlIlllIIIlI = (float)(int)(System.currentTimeMillis() / 1.5 % 360.0);
        llllllllllllllIIlIlIlIlIlllIIIlI = ((llllllllllllllIIlIlIlIlIlllIIIlI > 180.0f) ? (360.0f - llllllllllllllIIlIlIlIlIlllIIIlI) : llllllllllllllIIlIlIlIlIlllIIIlI) * 2.0f;
        llllllllllllllIIlIlIlIlIlllIIIlI /= 180.0f;
        float llllllllllllllIIlIlIlIlIlllIIIIl = (float)(int)(System.currentTimeMillis() / 3.5 % 120.0);
        llllllllllllllIIlIlIlIlIlllIIIIl = ((llllllllllllllIIlIlIlIlIlllIIIIl > 30.0f) ? (120.0f - llllllllllllllIIlIlIlIlIlllIIIIl) : llllllllllllllIIlIlIlIlIlllIIIIl) * 2.0f;
        llllllllllllllIIlIlIlIlIlllIIIIl /= 1.0f;
        float llllllllllllllIIlIlIlIlIlllIIIII = (float)(int)(System.currentTimeMillis() / 3.5 % 110.0);
        llllllllllllllIIlIlIlIlIlllIIIII = ((llllllllllllllIIlIlIlIlIlllIIIII > 30.0f) ? (110.0f - llllllllllllllIIlIlIlIlIlllIIIII) : llllllllllllllIIlIlIlIlIlllIIIII) * 2.0f;
        llllllllllllllIIlIlIlIlIlllIIIII /= 1.0f;
        int llllllllllllllIIlIlIlIlIllIlllll = 0;
        int llllllllllllllIIlIlIlIlIllIllllI = 0;
        final int llllllllllllllIIlIlIlIlIllIlllIl = 0;
        int llllllllllllllIIlIlIlIlIllIlllII = 0;
        float llllllllllllllIIlIlIlIlIllIllIll = 0.0f;
        int llllllllllllllIIlIlIlIlIllIllIlI = 0;
        int llllllllllllllIIlIlIlIlIllIllIIl = 0;
        final float llllllllllllllIIlIlIlIlIllIllIII = 0.0f;
        int llllllllllllllIIlIlIlIlIllIlIlll = 0;
        llllllllllllllIIlIlIlIlIllIlllII = 0;
        llllllllllllllIIlIlIlIlIllIlllll = (int)(System.currentTimeMillis() / 2L % 360L);
        llllllllllllllIIlIlIlIlIllIllllI = 1;
        llllllllllllllIIlIlIlIlIllIllIll = 1.0f;
        llllllllllllllIIlIlIlIlIllIlllII = -59;
        llllllllllllllIIlIlIlIlIllIllIlI = -1;
        llllllllllllllIIlIlIlIlIllIllIIl = 0;
        llllllllllllllIIlIlIlIlIllIlIlll = 3;
        GlStateManager.translate(llllllllllllllIIlIlIlIlIllIllIII, 0.2f, -llllllllllllllIIlIlIlIlIllIllIll);
        GlStateManager.rotate((float)llllllllllllllIIlIlIlIlIllIlllII, (float)llllllllllllllIIlIlIlIlIllIllIlI, (float)llllllllllllllIIlIlIlIlIllIllIIl, (float)llllllllllllllIIlIlIlIlIllIlIlll);
        GlStateManager.rotate((float)(-llllllllllllllIIlIlIlIlIllIlllll), (float)llllllllllllllIIlIlIlIlIllIllllI, (float)llllllllllllllIIlIlIlIlIllIlllIl, 0.0f);
        GlStateManager.rotate(60.0f, 0.0f, 1.0f, 0.0f);
    }
    
    private void func_178096_b(final float llllllllllllllIIlIlIlIllIIIllIII, final float llllllllllllllIIlIlIlIllIIIlIlll) {
        GlStateManager.translate(0.56f, -0.52f, -0.71999997f);
        GlStateManager.translate(0.0f, llllllllllllllIIlIlIlIllIIIllIII * -0.6f, 0.0f);
        GlStateManager.rotate(45.0f, 0.0f, 1.0f, 0.0f);
        final float llllllllllllllIIlIlIlIllIIIllIlI = MathHelper.sin(llllllllllllllIIlIlIlIllIIIlIlll * llllllllllllllIIlIlIlIllIIIlIlll * 3.1415927f);
        final float llllllllllllllIIlIlIlIllIIIllIIl = MathHelper.sin(MathHelper.sqrt_float(llllllllllllllIIlIlIlIllIIIlIlll) * 3.1415927f);
        GlStateManager.rotate(llllllllllllllIIlIlIlIllIIIllIlI * -20.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(llllllllllllllIIlIlIlIllIIIllIIl * -20.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.rotate(llllllllllllllIIlIlIlIllIIIllIIl * -80.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.scale(0.4f, 0.4f, 0.4f);
    }
    
    static final class SwitchEnumAction
    {
        static final /* synthetic */ int[] field_178094_a;
        
        static {
            field_178094_a = new int[EnumAction.values().length];
            try {
                SwitchEnumAction.field_178094_a[EnumAction.NONE.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumAction.field_178094_a[EnumAction.EAT.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumAction.field_178094_a[EnumAction.DRINK.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumAction.field_178094_a[EnumAction.BLOCK.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                SwitchEnumAction.field_178094_a[EnumAction.BOW.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
        }
    }
}
