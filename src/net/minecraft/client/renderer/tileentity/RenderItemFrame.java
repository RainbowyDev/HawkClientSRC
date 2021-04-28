package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.client.resources.model.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.item.*;
import optifine.*;
import shadersmod.client.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.world.storage.*;
import net.minecraft.client.renderer.texture.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.*;

public class RenderItemFrame extends Render
{
    private final /* synthetic */ ModelResourceLocation field_177072_f;
    private final /* synthetic */ ModelResourceLocation field_177073_g;
    private /* synthetic */ RenderItem field_177074_h;
    private static final /* synthetic */ ResourceLocation mapBackgroundTextures;
    private final /* synthetic */ Minecraft field_147917_g;
    
    @Override
    public void doRender(final Entity lllllllllllllllllllIlIlIIlIIIlII, final double lllllllllllllllllllIlIlIIlIIIIll, final double lllllllllllllllllllIlIlIIlIIlIIl, final double lllllllllllllllllllIlIlIIlIIlIII, final float lllllllllllllllllllIlIlIIlIIIIII, final float lllllllllllllllllllIlIlIIlIIIllI) {
        this.doRender((EntityItemFrame)lllllllllllllllllllIlIlIIlIIIlII, lllllllllllllllllllIlIlIIlIIIIll, lllllllllllllllllllIlIlIIlIIlIIl, lllllllllllllllllllIlIlIIlIIlIII, lllllllllllllllllllIlIlIIlIIIIII, lllllllllllllllllllIlIlIIlIIIllI);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity lllllllllllllllllllIlIlIIllIIIll) {
        return this.getEntityTexture((EntityItemFrame)lllllllllllllllllllIlIlIIllIIIll);
    }
    
    @Override
    protected void func_177067_a(final Entity lllllllllllllllllllIlIlIIlIlllII, final double lllllllllllllllllllIlIlIIlIlIllI, final double lllllllllllllllllllIlIlIIlIllIlI, final double lllllllllllllllllllIlIlIIlIlIlII) {
        this.func_147914_a((EntityItemFrame)lllllllllllllllllllIlIlIIlIlllII, lllllllllllllllllllIlIlIIlIlIllI, lllllllllllllllllllIlIlIIlIllIlI, lllllllllllllllllllIlIlIIlIlIlII);
    }
    
    public void doRender(final EntityItemFrame lllllllllllllllllllIlIlIlIllllll, final double lllllllllllllllllllIlIlIllIIllIl, final double lllllllllllllllllllIlIlIllIIllII, final double lllllllllllllllllllIlIlIllIIlIll, final float lllllllllllllllllllIlIlIllIIlIlI, final float lllllllllllllllllllIlIlIllIIlIIl) {
        GlStateManager.pushMatrix();
        final BlockPos lllllllllllllllllllIlIlIllIIlIII = lllllllllllllllllllIlIlIlIllllll.func_174857_n();
        final double lllllllllllllllllllIlIlIllIIIlll = lllllllllllllllllllIlIlIllIIlIII.getX() - lllllllllllllllllllIlIlIlIllllll.posX + lllllllllllllllllllIlIlIllIIllIl;
        final double lllllllllllllllllllIlIlIllIIIllI = lllllllllllllllllllIlIlIllIIlIII.getY() - lllllllllllllllllllIlIlIlIllllll.posY + lllllllllllllllllllIlIlIllIIllII;
        final double lllllllllllllllllllIlIlIllIIIlIl = lllllllllllllllllllIlIlIllIIlIII.getZ() - lllllllllllllllllllIlIlIlIllllll.posZ + lllllllllllllllllllIlIlIllIIlIll;
        GlStateManager.translate(lllllllllllllllllllIlIlIllIIIlll + 0.5, lllllllllllllllllllIlIlIllIIIllI + 0.5, lllllllllllllllllllIlIlIllIIIlIl + 0.5);
        GlStateManager.rotate(180.0f - lllllllllllllllllllIlIlIlIllllll.rotationYaw, 0.0f, 1.0f, 0.0f);
        this.renderManager.renderEngine.bindTexture(TextureMap.locationBlocksTexture);
        final BlockRendererDispatcher lllllllllllllllllllIlIlIllIIIlII = this.field_147917_g.getBlockRendererDispatcher();
        final ModelManager lllllllllllllllllllIlIlIllIIIIll = lllllllllllllllllllIlIlIllIIIlII.func_175023_a().func_178126_b();
        IBakedModel lllllllllllllllllllIlIlIllIIIIIl = null;
        if (lllllllllllllllllllIlIlIlIllllll.getDisplayedItem() != null && lllllllllllllllllllIlIlIlIllllll.getDisplayedItem().getItem() == Items.filled_map) {
            final IBakedModel lllllllllllllllllllIlIlIllIIIIlI = lllllllllllllllllllIlIlIllIIIIll.getModel(this.field_177073_g);
        }
        else {
            lllllllllllllllllllIlIlIllIIIIIl = lllllllllllllllllllIlIlIllIIIIll.getModel(this.field_177072_f);
        }
        GlStateManager.pushMatrix();
        GlStateManager.translate(-0.5f, -0.5f, -0.5f);
        lllllllllllllllllllIlIlIllIIIlII.func_175019_b().func_178262_a(lllllllllllllllllllIlIlIllIIIIIl, 1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.popMatrix();
        GlStateManager.translate(0.0f, 0.0f, 0.4375f);
        this.func_82402_b(lllllllllllllllllllIlIlIlIllllll);
        GlStateManager.popMatrix();
        this.func_147914_a(lllllllllllllllllllIlIlIlIllllll, lllllllllllllllllllIlIlIllIIllIl + lllllllllllllllllllIlIlIlIllllll.field_174860_b.getFrontOffsetX() * 0.3f, lllllllllllllllllllIlIlIllIIllII - 0.25, lllllllllllllllllllIlIlIllIIlIll + lllllllllllllllllllIlIlIlIllllll.field_174860_b.getFrontOffsetZ() * 0.3f);
    }
    
    public RenderItemFrame(final RenderManager lllllllllllllllllllIlIlIllIlllIl, final RenderItem lllllllllllllllllllIlIlIllIlllll) {
        super(lllllllllllllllllllIlIlIllIlllIl);
        this.field_147917_g = Minecraft.getMinecraft();
        this.field_177072_f = new ModelResourceLocation("item_frame", "normal");
        this.field_177073_g = new ModelResourceLocation("item_frame", "map");
        this.field_177074_h = lllllllllllllllllllIlIlIllIlllll;
    }
    
    static {
        __OBFID = "CL_00001002";
        mapBackgroundTextures = new ResourceLocation("textures/map/map_background.png");
    }
    
    private void func_82402_b(final EntityItemFrame lllllllllllllllllllIlIlIlIIllIll) {
        final ItemStack lllllllllllllllllllIlIlIlIlIIllI = lllllllllllllllllllIlIlIlIIllIll.getDisplayedItem();
        if (lllllllllllllllllllIlIlIlIlIIllI != null) {
            final EntityItem lllllllllllllllllllIlIlIlIlIIlIl = new EntityItem(lllllllllllllllllllIlIlIlIIllIll.worldObj, 0.0, 0.0, 0.0, lllllllllllllllllllIlIlIlIlIIllI);
            final Item lllllllllllllllllllIlIlIlIlIIlII = lllllllllllllllllllIlIlIlIlIIlIl.getEntityItem().getItem();
            lllllllllllllllllllIlIlIlIlIIlIl.getEntityItem().stackSize = 1;
            lllllllllllllllllllIlIlIlIlIIlIl.hoverStart = 0.0f;
            GlStateManager.pushMatrix();
            GlStateManager.disableLighting();
            int lllllllllllllllllllIlIlIlIlIIIll = lllllllllllllllllllIlIlIlIIllIll.getRotation();
            if (lllllllllllllllllllIlIlIlIlIIlII instanceof ItemMap) {
                lllllllllllllllllllIlIlIlIlIIIll = lllllllllllllllllllIlIlIlIlIIIll % 4 * 2;
            }
            GlStateManager.rotate(lllllllllllllllllllIlIlIlIlIIIll * 360.0f / 8.0f, 0.0f, 0.0f, 1.0f);
            if (!Reflector.postForgeBusEvent(Reflector.RenderItemInFrameEvent_Constructor, lllllllllllllllllllIlIlIlIIllIll, this)) {
                if (lllllllllllllllllllIlIlIlIlIIlII instanceof ItemMap) {
                    this.renderManager.renderEngine.bindTexture(RenderItemFrame.mapBackgroundTextures);
                    GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
                    final float lllllllllllllllllllIlIlIlIlIIIlI = 0.0078125f;
                    GlStateManager.scale(lllllllllllllllllllIlIlIlIlIIIlI, lllllllllllllllllllIlIlIlIlIIIlI, lllllllllllllllllllIlIlIlIlIIIlI);
                    GlStateManager.translate(-64.0f, -64.0f, 0.0f);
                    final MapData lllllllllllllllllllIlIlIlIlIIIIl = Items.filled_map.getMapData(lllllllllllllllllllIlIlIlIlIIlIl.getEntityItem(), lllllllllllllllllllIlIlIlIIllIll.worldObj);
                    GlStateManager.translate(0.0f, 0.0f, -1.0f);
                    if (lllllllllllllllllllIlIlIlIlIIIIl != null) {
                        this.field_147917_g.entityRenderer.getMapItemRenderer().func_148250_a(lllllllllllllllllllIlIlIlIlIIIIl, true);
                    }
                }
                else {
                    TextureAtlasSprite lllllllllllllllllllIlIlIlIlIIIII = null;
                    if (lllllllllllllllllllIlIlIlIlIIlII == Items.compass) {
                        lllllllllllllllllllIlIlIlIlIIIII = this.field_147917_g.getTextureMapBlocks().getAtlasSprite(TextureCompass.field_176608_l);
                        if (Config.isShaders()) {
                            ShadersTex.bindTextureMapForUpdateAndRender(this.field_147917_g.getTextureManager(), TextureMap.locationBlocksTexture);
                        }
                        else {
                            this.field_147917_g.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
                        }
                        if (lllllllllllllllllllIlIlIlIlIIIII instanceof TextureCompass) {
                            final TextureCompass lllllllllllllllllllIlIlIlIIlllll = (TextureCompass)lllllllllllllllllllIlIlIlIlIIIII;
                            final double lllllllllllllllllllIlIlIlIIllllI = lllllllllllllllllllIlIlIlIIlllll.currentAngle;
                            final double lllllllllllllllllllIlIlIlIIlllIl = lllllllllllllllllllIlIlIlIIlllll.angleDelta;
                            lllllllllllllllllllIlIlIlIIlllll.currentAngle = 0.0;
                            lllllllllllllllllllIlIlIlIIlllll.angleDelta = 0.0;
                            lllllllllllllllllllIlIlIlIIlllll.updateCompass(lllllllllllllllllllIlIlIlIIllIll.worldObj, lllllllllllllllllllIlIlIlIIllIll.posX, lllllllllllllllllllIlIlIlIIllIll.posZ, MathHelper.wrapAngleTo180_float((float)(180 + lllllllllllllllllllIlIlIlIIllIll.field_174860_b.getHorizontalIndex() * 90)), false, true);
                            lllllllllllllllllllIlIlIlIIlllll.currentAngle = lllllllllllllllllllIlIlIlIIllllI;
                            lllllllllllllllllllIlIlIlIIlllll.angleDelta = lllllllllllllllllllIlIlIlIIlllIl;
                        }
                        else {
                            lllllllllllllllllllIlIlIlIlIIIII = null;
                        }
                    }
                    GlStateManager.scale(0.5f, 0.5f, 0.5f);
                    if (!this.field_177074_h.func_175050_a(lllllllllllllllllllIlIlIlIlIIlIl.getEntityItem()) || lllllllllllllllllllIlIlIlIlIIlII instanceof ItemSkull) {
                        GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
                    }
                    GlStateManager.pushAttrib();
                    RenderHelper.enableStandardItemLighting();
                    this.field_177074_h.func_175043_b(lllllllllllllllllllIlIlIlIlIIlIl.getEntityItem());
                    RenderHelper.disableStandardItemLighting();
                    GlStateManager.popAttrib();
                    if (lllllllllllllllllllIlIlIlIlIIIII != null && lllllllllllllllllllIlIlIlIlIIIII.getFrameCount() > 0) {
                        lllllllllllllllllllIlIlIlIlIIIII.updateAnimation();
                    }
                }
            }
            GlStateManager.enableLighting();
            GlStateManager.popMatrix();
        }
        if (Config.isShaders()) {
            ShadersTex.updatingTex = null;
        }
    }
    
    protected void func_147914_a(final EntityItemFrame lllllllllllllllllllIlIlIlIIIIIll, final double lllllllllllllllllllIlIlIlIIIIIlI, final double lllllllllllllllllllIlIlIlIIIIIIl, final double lllllllllllllllllllIlIlIlIIIIIII) {
        if (Minecraft.isGuiEnabled() && lllllllllllllllllllIlIlIlIIIIIll.getDisplayedItem() != null && lllllllllllllllllllIlIlIlIIIIIll.getDisplayedItem().hasDisplayName() && this.renderManager.field_147941_i == lllllllllllllllllllIlIlIlIIIIIll) {
            final float lllllllllllllllllllIlIlIIlllllll = 1.6f;
            final float lllllllllllllllllllIlIlIIllllllI = 0.016666668f * lllllllllllllllllllIlIlIIlllllll;
            final double lllllllllllllllllllIlIlIIlllllIl = lllllllllllllllllllIlIlIlIIIIIll.getDistanceSqToEntity(this.renderManager.livingPlayer);
            final float lllllllllllllllllllIlIlIIlllllII = lllllllllllllllllllIlIlIlIIIIIll.isSneaking() ? 32.0f : 64.0f;
            if (lllllllllllllllllllIlIlIIlllllIl < lllllllllllllllllllIlIlIIlllllII * lllllllllllllllllllIlIlIIlllllII) {
                final String lllllllllllllllllllIlIlIIllllIll = lllllllllllllllllllIlIlIlIIIIIll.getDisplayedItem().getDisplayName();
                if (lllllllllllllllllllIlIlIlIIIIIll.isSneaking()) {
                    final FontRenderer lllllllllllllllllllIlIlIIllllIlI = this.getFontRendererFromRenderManager();
                    GlStateManager.pushMatrix();
                    GlStateManager.translate((float)lllllllllllllllllllIlIlIlIIIIIlI + 0.0f, (float)lllllllllllllllllllIlIlIlIIIIIIl + lllllllllllllllllllIlIlIlIIIIIll.height + 0.5f, (float)lllllllllllllllllllIlIlIlIIIIIII);
                    GL11.glNormal3f(0.0f, 1.0f, 0.0f);
                    GlStateManager.rotate(-this.renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
                    GlStateManager.rotate(this.renderManager.playerViewX, 1.0f, 0.0f, 0.0f);
                    GlStateManager.scale(-lllllllllllllllllllIlIlIIllllllI, -lllllllllllllllllllIlIlIIllllllI, lllllllllllllllllllIlIlIIllllllI);
                    GlStateManager.disableLighting();
                    GlStateManager.translate(0.0f, 0.25f / lllllllllllllllllllIlIlIIllllllI, 0.0f);
                    GlStateManager.depthMask(false);
                    GlStateManager.enableBlend();
                    GlStateManager.blendFunc(770, 771);
                    final Tessellator lllllllllllllllllllIlIlIIllllIIl = Tessellator.getInstance();
                    final WorldRenderer lllllllllllllllllllIlIlIIllllIII = lllllllllllllllllllIlIlIIllllIIl.getWorldRenderer();
                    GlStateManager.func_179090_x();
                    lllllllllllllllllllIlIlIIllllIII.startDrawingQuads();
                    final int lllllllllllllllllllIlIlIIlllIlll = lllllllllllllllllllIlIlIIllllIlI.getStringWidth(lllllllllllllllllllIlIlIIllllIll) / 2;
                    lllllllllllllllllllIlIlIIllllIII.func_178960_a(0.0f, 0.0f, 0.0f, 0.25f);
                    lllllllllllllllllllIlIlIIllllIII.addVertex(-lllllllllllllllllllIlIlIIlllIlll - 1, -1.0, 0.0);
                    lllllllllllllllllllIlIlIIllllIII.addVertex(-lllllllllllllllllllIlIlIIlllIlll - 1, 8.0, 0.0);
                    lllllllllllllllllllIlIlIIllllIII.addVertex(lllllllllllllllllllIlIlIIlllIlll + 1, 8.0, 0.0);
                    lllllllllllllllllllIlIlIIllllIII.addVertex(lllllllllllllllllllIlIlIIlllIlll + 1, -1.0, 0.0);
                    lllllllllllllllllllIlIlIIllllIIl.draw();
                    GlStateManager.func_179098_w();
                    GlStateManager.depthMask(true);
                    lllllllllllllllllllIlIlIIllllIlI.drawString(lllllllllllllllllllIlIlIIllllIll, -lllllllllllllllllllIlIlIIllllIlI.getStringWidth(lllllllllllllllllllIlIlIIllllIll) / 2, 0.0, 553648127);
                    GlStateManager.enableLighting();
                    GlStateManager.disableBlend();
                    GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                    GlStateManager.popMatrix();
                }
                else {
                    this.renderLivingLabel(lllllllllllllllllllIlIlIlIIIIIll, lllllllllllllllllllIlIlIIllllIll, lllllllllllllllllllIlIlIlIIIIIlI, lllllllllllllllllllIlIlIlIIIIIIl, lllllllllllllllllllIlIlIlIIIIIII, 64);
                }
            }
        }
    }
    
    protected ResourceLocation getEntityTexture(final EntityItemFrame lllllllllllllllllllIlIlIlIllIIll) {
        return null;
    }
}
