package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.texture.*;
import java.nio.*;
import net.minecraft.client.model.*;
import org.lwjgl.opengl.*;
import net.minecraft.entity.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.entity.layers.*;
import java.util.*;
import net.minecraft.client.renderer.*;
import com.google.common.collect.*;
import net.minecraft.client.*;
import net.minecraft.client.entity.*;
import net.minecraft.scoreboard.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import optifine.*;
import shadersmod.client.*;
import hawk.events.listeners.*;
import hawk.*;
import hawk.events.*;
import org.apache.logging.log4j.*;

public abstract class RendererLivingEntity extends Render
{
    public static /* synthetic */ float NAME_TAG_RANGE_SNEAK;
    protected /* synthetic */ boolean field_177098_i;
    protected /* synthetic */ List field_177097_h;
    private static final /* synthetic */ Logger logger;
    private static final /* synthetic */ DynamicTexture field_177096_e;
    protected /* synthetic */ FloatBuffer field_177095_g;
    protected /* synthetic */ ModelBase mainModel;
    public static /* synthetic */ float NAME_TAG_RANGE;
    
    protected void func_180565_e() {
        GlStateManager.enableLighting();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.func_179098_w();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.func_179098_w();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
    
    public void passSpecialRender(final EntityLivingBase lllllllllllllllIlIIIIlllllIIIlIl, final double lllllllllllllllIlIIIIllllIllIlll, final double lllllllllllllllIlIIIIlllllIIIIll, final double lllllllllllllllIlIIIIllllIllIlIl) {
        if (!Reflector.RenderLivingEvent_Specials_Pre_Constructor.exists() || !Reflector.postForgeBusEvent(Reflector.RenderLivingEvent_Specials_Pre_Constructor, lllllllllllllllIlIIIIlllllIIIlIl, this, lllllllllllllllIlIIIIllllIllIlll, lllllllllllllllIlIIIIlllllIIIIll, lllllllllllllllIlIIIIllllIllIlIl)) {
            if (this.canRenderName(lllllllllllllllIlIIIIlllllIIIlIl)) {
                final double lllllllllllllllIlIIIIlllllIIIIIl = lllllllllllllllIlIIIIlllllIIIlIl.getDistanceSqToEntity(this.renderManager.livingPlayer);
                final float lllllllllllllllIlIIIIlllllIIIIII = lllllllllllllllIlIIIIlllllIIIlIl.isSneaking() ? RendererLivingEntity.NAME_TAG_RANGE_SNEAK : RendererLivingEntity.NAME_TAG_RANGE;
                if (lllllllllllllllIlIIIIlllllIIIIIl < lllllllllllllllIlIIIIlllllIIIIII * lllllllllllllllIlIIIIlllllIIIIII) {
                    final String lllllllllllllllIlIIIIllllIllllll = lllllllllllllllIlIIIIlllllIIIlIl.getDisplayName().getFormattedText();
                    final float lllllllllllllllIlIIIIllllIlllllI = 0.02666667f;
                    GlStateManager.alphaFunc(516, 0.1f);
                    if (lllllllllllllllIlIIIIlllllIIIlIl.isSneaking()) {
                        final FontRenderer lllllllllllllllIlIIIIllllIllllIl = this.getFontRendererFromRenderManager();
                        GlStateManager.pushMatrix();
                        GlStateManager.translate((float)lllllllllllllllIlIIIIllllIllIlll, (float)lllllllllllllllIlIIIIlllllIIIIll + lllllllllllllllIlIIIIlllllIIIlIl.height + 0.5f - (lllllllllllllllIlIIIIlllllIIIlIl.isChild() ? (lllllllllllllllIlIIIIlllllIIIlIl.height / 2.0f) : 0.0f), (float)lllllllllllllllIlIIIIllllIllIlIl);
                        GL11.glNormal3f(0.0f, 1.0f, 0.0f);
                        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
                        GlStateManager.rotate(this.renderManager.playerViewX, 1.0f, 0.0f, 0.0f);
                        GlStateManager.scale(-0.02666667f, -0.02666667f, 0.02666667f);
                        GlStateManager.translate(0.0f, 9.374999f, 0.0f);
                        GlStateManager.disableLighting();
                        GlStateManager.depthMask(false);
                        GlStateManager.enableBlend();
                        GlStateManager.func_179090_x();
                        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                        final Tessellator lllllllllllllllIlIIIIllllIllllII = Tessellator.getInstance();
                        final WorldRenderer lllllllllllllllIlIIIIllllIlllIll = lllllllllllllllIlIIIIllllIllllII.getWorldRenderer();
                        lllllllllllllllIlIIIIllllIlllIll.startDrawingQuads();
                        final int lllllllllllllllIlIIIIllllIlllIlI = lllllllllllllllIlIIIIllllIllllIl.getStringWidth(lllllllllllllllIlIIIIllllIllllll) / 2;
                        lllllllllllllllIlIIIIllllIlllIll.func_178960_a(0.0f, 0.0f, 0.0f, 0.25f);
                        lllllllllllllllIlIIIIllllIlllIll.addVertex(-lllllllllllllllIlIIIIllllIlllIlI - 1, -1.0, 0.0);
                        lllllllllllllllIlIIIIllllIlllIll.addVertex(-lllllllllllllllIlIIIIllllIlllIlI - 1, 8.0, 0.0);
                        lllllllllllllllIlIIIIllllIlllIll.addVertex(lllllllllllllllIlIIIIllllIlllIlI + 1, 8.0, 0.0);
                        lllllllllllllllIlIIIIllllIlllIll.addVertex(lllllllllllllllIlIIIIllllIlllIlI + 1, -1.0, 0.0);
                        lllllllllllllllIlIIIIllllIllllII.draw();
                        GlStateManager.func_179098_w();
                        GlStateManager.depthMask(true);
                        lllllllllllllllIlIIIIllllIllllIl.drawString(lllllllllllllllIlIIIIllllIllllll, -lllllllllllllllIlIIIIllllIllllIl.getStringWidth(lllllllllllllllIlIIIIllllIllllll) / 2, 0.0, 553648127);
                        GlStateManager.enableLighting();
                        GlStateManager.disableBlend();
                        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                        GlStateManager.popMatrix();
                    }
                    else {
                        this.func_177069_a(lllllllllllllllIlIIIIlllllIIIlIl, lllllllllllllllIlIIIIllllIllIlll, lllllllllllllllIlIIIIlllllIIIIll - (lllllllllllllllIlIIIIlllllIIIlIl.isChild() ? (lllllllllllllllIlIIIIlllllIIIlIl.height / 2.0f) : 0.0), lllllllllllllllIlIIIIllllIllIlIl, lllllllllllllllIlIIIIllllIllllll, 0.02666667f, lllllllllllllllIlIIIIlllllIIIIIl);
                    }
                }
            }
            if (!Reflector.RenderLivingEvent_Specials_Post_Constructor.exists() || !Reflector.postForgeBusEvent(Reflector.RenderLivingEvent_Specials_Post_Constructor, lllllllllllllllIlIIIIlllllIIIlIl, this, lllllllllllllllIlIIIIllllIllIlll, lllllllllllllllIlIIIIlllllIIIIll, lllllllllllllllIlIIIIllllIllIlIl)) {}
        }
    }
    
    protected void renderLivingAt(final EntityLivingBase lllllllllllllllIlIIIlIIIIIlIIllI, final double lllllllllllllllIlIIIlIIIIIlIIIlI, final double lllllllllllllllIlIIIlIIIIIlIIIIl, final double lllllllllllllllIlIIIlIIIIIlIIIll) {
        GlStateManager.translate((float)lllllllllllllllIlIIIlIIIIIlIIIlI, (float)lllllllllllllllIlIIIlIIIIIlIIIIl, (float)lllllllllllllllIlIIIlIIIIIlIIIll);
    }
    
    public void func_177086_a(final boolean lllllllllllllllIlIIIIllllIIlIlIl) {
        this.field_177098_i = lllllllllllllllIlIIIIllllIIlIlIl;
    }
    
    protected boolean func_177088_c(final EntityLivingBase lllllllllllllllIlIIIlIIIlIIIIlII) {
        int lllllllllllllllIlIIIlIIIlIIIIIll = 16777215;
        if (lllllllllllllllIlIIIlIIIlIIIIlII instanceof EntityPlayer) {
            final ScorePlayerTeam lllllllllllllllIlIIIlIIIlIIIIIlI = (ScorePlayerTeam)lllllllllllllllIlIIIlIIIlIIIIlII.getTeam();
            if (lllllllllllllllIlIIIlIIIlIIIIIlI != null) {
                final String lllllllllllllllIlIIIlIIIlIIIIIIl = FontRenderer.getFormatFromString(lllllllllllllllIlIIIlIIIlIIIIIlI.getColorPrefix());
                if (lllllllllllllllIlIIIlIIIlIIIIIIl.length() >= 2) {
                    lllllllllllllllIlIIIlIIIlIIIIIll = this.getFontRendererFromRenderManager().func_175064_b(lllllllllllllllIlIIIlIIIlIIIIIIl.charAt(1));
                }
            }
        }
        final float lllllllllllllllIlIIIlIIIlIIIIIII = (lllllllllllllllIlIIIlIIIlIIIIIll >> 16 & 0xFF) / 255.0f;
        final float lllllllllllllllIlIIIlIIIIlllllll = (lllllllllllllllIlIIIlIIIlIIIIIll >> 8 & 0xFF) / 255.0f;
        final float lllllllllllllllIlIIIlIIIIllllllI = (lllllllllllllllIlIIIlIIIlIIIIIll & 0xFF) / 255.0f;
        GlStateManager.disableLighting();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.color(lllllllllllllllIlIIIlIIIlIIIIIII, lllllllllllllllIlIIIlIIIIlllllll, lllllllllllllllIlIIIlIIIIllllllI, 1.0f);
        GlStateManager.func_179090_x();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.func_179090_x();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        return true;
    }
    
    protected boolean func_177090_c(final EntityLivingBase lllllllllllllllIlIIIlIIIIlIlIlII, final float lllllllllllllllIlIIIlIIIIlIlIIll) {
        return this.func_177092_a(lllllllllllllllIlIIIlIIIIlIlIlII, lllllllllllllllIlIIIlIIIIlIlIIll, true);
    }
    
    protected void func_177093_a(final EntityLivingBase lllllllllllllllIlIIIIlllllllIIll, final float lllllllllllllllIlIIIIllllllIIllI, final float lllllllllllllllIlIIIIlllllllIIIl, final float lllllllllllllllIlIIIIlllllllIIII, final float lllllllllllllllIlIIIIllllllIllll, final float lllllllllllllllIlIIIIllllllIIIlI, final float lllllllllllllllIlIIIIllllllIllIl, final float lllllllllllllllIlIIIIllllllIllII) {
        for (final LayerRenderer lllllllllllllllIlIIIIllllllIlIlI : this.field_177097_h) {
            final boolean lllllllllllllllIlIIIIllllllIlIIl = this.func_177092_a(lllllllllllllllIlIIIIlllllllIIll, lllllllllllllllIlIIIIlllllllIIII, lllllllllllllllIlIIIIllllllIlIlI.shouldCombineTextures());
            lllllllllllllllIlIIIIllllllIlIlI.doRenderLayer(lllllllllllllllIlIIIIlllllllIIll, lllllllllllllllIlIIIIllllllIIllI, lllllllllllllllIlIIIIlllllllIIIl, lllllllllllllllIlIIIIlllllllIIII, lllllllllllllllIlIIIIllllllIllll, lllllllllllllllIlIIIIllllllIIIlI, lllllllllllllllIlIIIIllllllIllIl, lllllllllllllllIlIIIIllllllIllII);
            if (lllllllllllllllIlIIIIllllllIlIIl) {
                this.func_177091_f();
            }
        }
    }
    
    public RendererLivingEntity(final RenderManager lllllllllllllllIlIIIlIIIlllIIIII, final ModelBase lllllllllllllllIlIIIlIIIllIlllll, final float lllllllllllllllIlIIIlIIIlllIIIlI) {
        super(lllllllllllllllIlIIIlIIIlllIIIII);
        this.field_177095_g = GLAllocation.createDirectFloatBuffer(4);
        this.field_177097_h = Lists.newArrayList();
        this.field_177098_i = false;
        this.mainModel = lllllllllllllllIlIIIlIIIllIlllll;
        this.shadowSize = lllllllllllllllIlIIIlIIIlllIIIlI;
    }
    
    public ModelBase getMainModel() {
        return this.mainModel;
    }
    
    @Override
    public void doRender(final Entity lllllllllllllllIlIIIIlllIlllIlll, final double lllllllllllllllIlIIIIlllIllIllll, final double lllllllllllllllIlIIIIlllIllIlllI, final double lllllllllllllllIlIIIIlllIlllIlII, final float lllllllllllllllIlIIIIlllIllIllII, final float lllllllllllllllIlIIIIlllIlllIIlI) {
        this.doRender((EntityLivingBase)lllllllllllllllIlIIIIlllIlllIlll, lllllllllllllllIlIIIIlllIllIllll, lllllllllllllllIlIIIIlllIllIlllI, lllllllllllllllIlIIIIlllIlllIlII, lllllllllllllllIlIIIIlllIllIllII, lllllllllllllllIlIIIIlllIlllIIlI);
    }
    
    protected float getDeathMaxRotation(final EntityLivingBase lllllllllllllllIlIIIIlllllIllIll) {
        return 90.0f;
    }
    
    @Override
    protected boolean func_177070_b(final Entity lllllllllllllllIlIIIIllllIIlIIIl) {
        return this.canRenderName((EntityLivingBase)lllllllllllllllIlIIIIllllIIlIIIl);
    }
    
    public void func_177067_a(final Entity lllllllllllllllIlIIIIllllIIIIIll, final double lllllllllllllllIlIIIIllllIIIIIlI, final double lllllllllllllllIlIIIIllllIIIIIIl, final double lllllllllllllllIlIIIIllllIIIIIII) {
        this.passSpecialRender((EntityLivingBase)lllllllllllllllIlIIIIllllIIIIIll, lllllllllllllllIlIIIIllllIIIIIlI, lllllllllllllllIlIIIIllllIIIIIIl, lllllllllllllllIlIIIIllllIIIIIII);
    }
    
    public boolean addLayer(final LayerRenderer lllllllllllllllIlIIIlIIIllIllIII) {
        return this.field_177097_h.add(lllllllllllllllIlIIIlIIIllIllIII);
    }
    
    protected float getSwingProgress(final EntityLivingBase lllllllllllllllIlIIIlIIIIIIIlIIl, final float lllllllllllllllIlIIIlIIIIIIIlIII) {
        return lllllllllllllllIlIIIlIIIIIIIlIIl.getSwingProgress(lllllllllllllllIlIIIlIIIIIIIlIII);
    }
    
    protected boolean canRenderName(final EntityLivingBase lllllllllllllllIlIIIIllllIlIIlIl) {
        final EntityPlayerSP lllllllllllllllIlIIIIllllIlIIlII = Minecraft.getMinecraft().thePlayer;
        if (lllllllllllllllIlIIIIllllIlIIlIl instanceof EntityPlayer && lllllllllllllllIlIIIIllllIlIIlIl != lllllllllllllllIlIIIIllllIlIIlII) {
            final Team lllllllllllllllIlIIIIllllIlIIIll = lllllllllllllllIlIIIIllllIlIIlIl.getTeam();
            final Team lllllllllllllllIlIIIIllllIlIIIlI = lllllllllllllllIlIIIIllllIlIIlII.getTeam();
            if (lllllllllllllllIlIIIIllllIlIIIll != null) {
                final Team.EnumVisible lllllllllllllllIlIIIIllllIlIIIIl = lllllllllllllllIlIIIIllllIlIIIll.func_178770_i();
                switch (SwitchEnumVisible.field_178679_a[lllllllllllllllIlIIIIllllIlIIIIl.ordinal()]) {
                    case 1: {
                        return true;
                    }
                    case 2: {
                        return false;
                    }
                    case 3: {
                        return lllllllllllllllIlIIIIllllIlIIIlI == null || lllllllllllllllIlIIIIllllIlIIIll.isSameTeam(lllllllllllllllIlIIIIllllIlIIIlI);
                    }
                    case 4: {
                        return lllllllllllllllIlIIIIllllIlIIIlI == null || !lllllllllllllllIlIIIIllllIlIIIll.isSameTeam(lllllllllllllllIlIIIIllllIlIIIlI);
                    }
                    default: {
                        return true;
                    }
                }
            }
        }
        return Minecraft.isGuiEnabled() && lllllllllllllllIlIIIIllllIlIIlIl != this.renderManager.livingPlayer && !lllllllllllllllIlIIIIllllIlIIlIl.isInvisibleToPlayer(lllllllllllllllIlIIIIllllIlIIlII) && lllllllllllllllIlIIIIllllIlIIlIl.riddenByEntity == null;
    }
    
    protected void rotateCorpse(final EntityLivingBase lllllllllllllllIlIIIlIIIIIIlIIlI, final float lllllllllllllllIlIIIlIIIIIIllIII, final float lllllllllllllllIlIIIlIIIIIIlIIIl, final float lllllllllllllllIlIIIlIIIIIIlIllI) {
        GlStateManager.rotate(180.0f - lllllllllllllllIlIIIlIIIIIIlIIIl, 0.0f, 1.0f, 0.0f);
        if (lllllllllllllllIlIIIlIIIIIIlIIlI.deathTime > 0) {
            float lllllllllllllllIlIIIlIIIIIIlIlIl = (lllllllllllllllIlIIIlIIIIIIlIIlI.deathTime + lllllllllllllllIlIIIlIIIIIIlIllI - 1.0f) / 20.0f * 1.6f;
            lllllllllllllllIlIIIlIIIIIIlIlIl = MathHelper.sqrt_float(lllllllllllllllIlIIIlIIIIIIlIlIl);
            if (lllllllllllllllIlIIIlIIIIIIlIlIl > 1.0f) {
                lllllllllllllllIlIIIlIIIIIIlIlIl = 1.0f;
            }
            GlStateManager.rotate(lllllllllllllllIlIIIlIIIIIIlIlIl * this.getDeathMaxRotation(lllllllllllllllIlIIIlIIIIIIlIIlI), 0.0f, 0.0f, 1.0f);
        }
        else {
            final String lllllllllllllllIlIIIlIIIIIIlIlII = EnumChatFormatting.getTextWithoutFormattingCodes(lllllllllllllllIlIIIlIIIIIIlIIlI.getName());
            if (lllllllllllllllIlIIIlIIIIIIlIlII != null && (lllllllllllllllIlIIIlIIIIIIlIlII.equals("Dinnerbone") || lllllllllllllllIlIIIlIIIIIIlIlII.equals("Grumm")) && (!(lllllllllllllllIlIIIlIIIIIIlIIlI instanceof EntityPlayer) || ((EntityPlayer)lllllllllllllllIlIIIlIIIIIIlIIlI).func_175148_a(EnumPlayerModelParts.CAPE))) {
                GlStateManager.translate(0.0f, lllllllllllllllIlIIIlIIIIIIlIIlI.height + 0.1f, 0.0f);
                GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
            }
        }
    }
    
    protected boolean func_177092_a(final EntityLivingBase lllllllllllllllIlIIIlIIIIIllIllI, final float lllllllllllllllIlIIIlIIIIIllIlIl, final boolean lllllllllllllllIlIIIlIIIIlIIIIII) {
        final float lllllllllllllllIlIIIlIIIIIllllll = lllllllllllllllIlIIIlIIIIIllIllI.getBrightness(lllllllllllllllIlIIIlIIIIIllIlIl);
        final int lllllllllllllllIlIIIlIIIIIlllllI = this.getColorMultiplier(lllllllllllllllIlIIIlIIIIIllIllI, lllllllllllllllIlIIIlIIIIIllllll, lllllllllllllllIlIIIlIIIIIllIlIl);
        final boolean lllllllllllllllIlIIIlIIIIIllllIl = (lllllllllllllllIlIIIlIIIIIlllllI >> 24 & 0xFF) > 0;
        final boolean lllllllllllllllIlIIIlIIIIIllllII = lllllllllllllllIlIIIlIIIIIllIllI.hurtTime > 0 || lllllllllllllllIlIIIlIIIIIllIllI.deathTime > 0;
        if (!lllllllllllllllIlIIIlIIIIIllllIl && !lllllllllllllllIlIIIlIIIIIllllII) {
            return false;
        }
        if (!lllllllllllllllIlIIIlIIIIIllllIl && !lllllllllllllllIlIIIlIIIIlIIIIII) {
            return false;
        }
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.func_179098_w();
        GL11.glTexEnvi(8960, 8704, OpenGlHelper.field_176095_s);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176099_x, 8448);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176098_y, OpenGlHelper.defaultTexUnit);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176097_z, OpenGlHelper.field_176093_u);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176081_B, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176082_C, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176077_E, 7681);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176078_F, OpenGlHelper.defaultTexUnit);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176085_I, 770);
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.func_179098_w();
        GL11.glTexEnvi(8960, 8704, OpenGlHelper.field_176095_s);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176099_x, OpenGlHelper.field_176094_t);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176098_y, OpenGlHelper.field_176092_v);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176097_z, OpenGlHelper.field_176091_w);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176080_A, OpenGlHelper.field_176092_v);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176081_B, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176082_C, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176076_D, 770);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176077_E, 7681);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176078_F, OpenGlHelper.field_176091_w);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176085_I, 770);
        this.field_177095_g.position(0);
        if (lllllllllllllllIlIIIlIIIIIllllII) {
            this.field_177095_g.put(1.0f);
            this.field_177095_g.put(0.0f);
            this.field_177095_g.put(0.0f);
            this.field_177095_g.put(0.3f);
            if (Config.isShaders()) {
                Shaders.setEntityColor(1.0f, 0.0f, 0.0f, 0.3f);
            }
        }
        else {
            final float lllllllllllllllIlIIIlIIIIIlllIll = (lllllllllllllllIlIIIlIIIIIlllllI >> 24 & 0xFF) / 255.0f;
            final float lllllllllllllllIlIIIlIIIIIlllIlI = (lllllllllllllllIlIIIlIIIIIlllllI >> 16 & 0xFF) / 255.0f;
            final float lllllllllllllllIlIIIlIIIIIlllIIl = (lllllllllllllllIlIIIlIIIIIlllllI >> 8 & 0xFF) / 255.0f;
            final float lllllllllllllllIlIIIlIIIIIlllIII = (lllllllllllllllIlIIIlIIIIIlllllI & 0xFF) / 255.0f;
            this.field_177095_g.put(lllllllllllllllIlIIIlIIIIIlllIlI);
            this.field_177095_g.put(lllllllllllllllIlIIIlIIIIIlllIIl);
            this.field_177095_g.put(lllllllllllllllIlIIIlIIIIIlllIII);
            this.field_177095_g.put(1.0f - lllllllllllllllIlIIIlIIIIIlllIll);
            if (Config.isShaders()) {
                Shaders.setEntityColor(lllllllllllllllIlIIIlIIIIIlllIlI, lllllllllllllllIlIIIlIIIIIlllIIl, lllllllllllllllIlIIIlIIIIIlllIII, 1.0f - lllllllllllllllIlIIIlIIIIIlllIll);
            }
        }
        this.field_177095_g.flip();
        GL11.glTexEnv(8960, 8705, this.field_177095_g);
        GlStateManager.setActiveTexture(OpenGlHelper.field_176096_r);
        GlStateManager.func_179098_w();
        GlStateManager.func_179144_i(RendererLivingEntity.field_177096_e.getGlTextureId());
        GL11.glTexEnvi(8960, 8704, OpenGlHelper.field_176095_s);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176099_x, 8448);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176098_y, OpenGlHelper.field_176091_w);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176097_z, OpenGlHelper.lightmapTexUnit);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176081_B, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176082_C, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176077_E, 7681);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176078_F, OpenGlHelper.field_176091_w);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176085_I, 770);
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        return true;
    }
    
    protected float interpolateRotation(final float lllllllllllllllIlIIIlIIIllIIlIIl, final float lllllllllllllllIlIIIlIIIllIIIlII, final float lllllllllllllllIlIIIlIIIllIIIlll) {
        float lllllllllllllllIlIIIlIIIllIIIllI;
        for (lllllllllllllllIlIIIlIIIllIIIllI = lllllllllllllllIlIIIlIIIllIIIlII - lllllllllllllllIlIIIlIIIllIIlIIl; lllllllllllllllIlIIIlIIIllIIIllI < -180.0f; lllllllllllllllIlIIIlIIIllIIIllI += 360.0f) {}
        while (lllllllllllllllIlIIIlIIIllIIIllI >= 180.0f) {
            lllllllllllllllIlIIIlIIIllIIIllI -= 360.0f;
        }
        return lllllllllllllllIlIIIlIIIllIIlIIl + lllllllllllllllIlIIIlIIIllIIIlll * lllllllllllllllIlIIIlIIIllIIIllI;
    }
    
    public void doRender(final EntityLivingBase lllllllllllllllIlIIIlIIIlIIllIlI, final double lllllllllllllllIlIIIlIIIlIlIlllI, final double lllllllllllllllIlIIIlIIIlIIllIII, final double lllllllllllllllIlIIIlIIIlIlIllII, final float lllllllllllllllIlIIIlIIIlIlIlIll, final float lllllllllllllllIlIIIlIIIlIIlIlIl) {
        if (!Reflector.RenderLivingEvent_Pre_Constructor.exists() || !Reflector.postForgeBusEvent(Reflector.RenderLivingEvent_Pre_Constructor, lllllllllllllllIlIIIlIIIlIIllIlI, this, lllllllllllllllIlIIIlIIIlIlIlllI, lllllllllllllllIlIIIlIIIlIIllIII, lllllllllllllllIlIIIlIIIlIlIllII)) {
            GlStateManager.pushMatrix();
            GlStateManager.disableCull();
            this.mainModel.swingProgress = this.getSwingProgress(lllllllllllllllIlIIIlIIIlIIllIlI, lllllllllllllllIlIIIlIIIlIIlIlIl);
            this.mainModel.isRiding = lllllllllllllllIlIIIlIIIlIIllIlI.isRiding();
            if (Reflector.ForgeEntity_shouldRiderSit.exists()) {
                this.mainModel.isRiding = (lllllllllllllllIlIIIlIIIlIIllIlI.isRiding() && lllllllllllllllIlIIIlIIIlIIllIlI.ridingEntity != null && Reflector.callBoolean(lllllllllllllllIlIIIlIIIlIIllIlI.ridingEntity, Reflector.ForgeEntity_shouldRiderSit, new Object[0]));
            }
            this.mainModel.isChild = lllllllllllllllIlIIIlIIIlIIllIlI.isChild();
            try {
                float lllllllllllllllIlIIIlIIIlIlIlIIl = this.interpolateRotation(lllllllllllllllIlIIIlIIIlIIllIlI.prevRenderYawOffset, lllllllllllllllIlIIIlIIIlIIllIlI.renderYawOffset, lllllllllllllllIlIIIlIIIlIIlIlIl);
                final float lllllllllllllllIlIIIlIIIlIlIlIII = this.interpolateRotation(lllllllllllllllIlIIIlIIIlIIllIlI.prevRotationYawHead, lllllllllllllllIlIIIlIIIlIIllIlI.rotationYawHead, lllllllllllllllIlIIIlIIIlIIlIlIl);
                float lllllllllllllllIlIIIlIIIlIlIIlll = lllllllllllllllIlIIIlIIIlIlIlIII - lllllllllllllllIlIIIlIIIlIlIlIIl;
                if (this.mainModel.isRiding && lllllllllllllllIlIIIlIIIlIIllIlI.ridingEntity instanceof EntityLivingBase) {
                    final EntityLivingBase lllllllllllllllIlIIIlIIIlIlIIlII = (EntityLivingBase)lllllllllllllllIlIIIlIIIlIIllIlI.ridingEntity;
                    lllllllllllllllIlIIIlIIIlIlIlIIl = this.interpolateRotation(lllllllllllllllIlIIIlIIIlIlIIlII.prevRenderYawOffset, lllllllllllllllIlIIIlIIIlIlIIlII.renderYawOffset, lllllllllllllllIlIIIlIIIlIIlIlIl);
                    lllllllllllllllIlIIIlIIIlIlIIlll = lllllllllllllllIlIIIlIIIlIlIlIII - lllllllllllllllIlIIIlIIIlIlIlIIl;
                    float lllllllllllllllIlIIIlIIIlIlIIllI = MathHelper.wrapAngleTo180_float(lllllllllllllllIlIIIlIIIlIlIIlll);
                    if (lllllllllllllllIlIIIlIIIlIlIIllI < -85.0f) {
                        lllllllllllllllIlIIIlIIIlIlIIllI = -85.0f;
                    }
                    if (lllllllllllllllIlIIIlIIIlIlIIllI >= 85.0f) {
                        lllllllllllllllIlIIIlIIIlIlIIllI = 85.0f;
                    }
                    lllllllllllllllIlIIIlIIIlIlIlIIl = lllllllllllllllIlIIIlIIIlIlIlIII - lllllllllllllllIlIIIlIIIlIlIIllI;
                    if (lllllllllllllllIlIIIlIIIlIlIIllI * lllllllllllllllIlIIIlIIIlIlIIllI > 2500.0f) {
                        lllllllllllllllIlIIIlIIIlIlIlIIl += lllllllllllllllIlIIIlIIIlIlIIllI * 0.2f;
                    }
                }
                float lllllllllllllllIlIIIlIIIlIlIIIll = lllllllllllllllIlIIIlIIIlIIllIlI.prevRotationPitch + (lllllllllllllllIlIIIlIIIlIIllIlI.rotationPitch - lllllllllllllllIlIIIlIIIlIIllIlI.prevRotationPitch) * lllllllllllllllIlIIIlIIIlIIlIlIl;
                this.renderLivingAt(lllllllllllllllIlIIIlIIIlIIllIlI, lllllllllllllllIlIIIlIIIlIlIlllI, lllllllllllllllIlIIIlIIIlIIllIII, lllllllllllllllIlIIIlIIIlIlIllII);
                final float lllllllllllllllIlIIIlIIIlIlIIlIl = this.handleRotationFloat(lllllllllllllllIlIIIlIIIlIIllIlI, lllllllllllllllIlIIIlIIIlIIlIlIl);
                if (lllllllllllllllIlIIIlIIIlIIllIlI.getEntityId() == Minecraft.getMinecraft().thePlayer.getEntityId()) {
                    final EventRenderPlayer lllllllllllllllIlIIIlIIIlIlIIIlI = new EventRenderPlayer(lllllllllllllllIlIIIlIIIlIlIlIIl, lllllllllllllllIlIIIlIIIlIlIIIll, lllllllllllllllIlIIIlIIIlIlIIlll, lllllllllllllllIlIIIlIIIlIIlIlIl);
                    Client.onEvent(lllllllllllllllIlIIIlIIIlIlIIIlI);
                    lllllllllllllllIlIIIlIIIlIlIIIll = lllllllllllllllIlIIIlIIIlIlIIIlI.getPitch();
                    lllllllllllllllIlIIIlIIIlIlIlIIl = lllllllllllllllIlIIIlIIIlIlIIIlI.getYaw();
                    lllllllllllllllIlIIIlIIIlIlIIlll = lllllllllllllllIlIIIlIIIlIlIIIlI.yawChange;
                }
                this.rotateCorpse(lllllllllllllllIlIIIlIIIlIIllIlI, lllllllllllllllIlIIIlIIIlIlIIlIl, lllllllllllllllIlIIIlIIIlIlIlIIl, lllllllllllllllIlIIIlIIIlIIlIlIl);
                GlStateManager.enableRescaleNormal();
                GlStateManager.scale(-1.0f, -1.0f, 1.0f);
                this.preRenderCallback(lllllllllllllllIlIIIlIIIlIIllIlI, lllllllllllllllIlIIIlIIIlIIlIlIl);
                final float lllllllllllllllIlIIIlIIIlIlIIIIl = 0.0625f;
                GlStateManager.translate(0.0f, -1.5078125f, 0.0f);
                float lllllllllllllllIlIIIlIIIlIlIIIII = lllllllllllllllIlIIIlIIIlIIllIlI.prevLimbSwingAmount + (lllllllllllllllIlIIIlIIIlIIllIlI.limbSwingAmount - lllllllllllllllIlIIIlIIIlIIllIlI.prevLimbSwingAmount) * lllllllllllllllIlIIIlIIIlIIlIlIl;
                float lllllllllllllllIlIIIlIIIlIIlllll = lllllllllllllllIlIIIlIIIlIIllIlI.limbSwing - lllllllllllllllIlIIIlIIIlIIllIlI.limbSwingAmount * (1.0f - lllllllllllllllIlIIIlIIIlIIlIlIl);
                if (lllllllllllllllIlIIIlIIIlIIllIlI.isChild()) {
                    lllllllllllllllIlIIIlIIIlIIlllll *= 3.0f;
                }
                if (lllllllllllllllIlIIIlIIIlIlIIIII > 1.0f) {
                    lllllllllllllllIlIIIlIIIlIlIIIII = 1.0f;
                }
                GlStateManager.enableAlpha();
                this.mainModel.setLivingAnimations(lllllllllllllllIlIIIlIIIlIIllIlI, lllllllllllllllIlIIIlIIIlIIlllll, lllllllllllllllIlIIIlIIIlIlIIIII, lllllllllllllllIlIIIlIIIlIIlIlIl);
                this.mainModel.setRotationAngles(lllllllllllllllIlIIIlIIIlIIlllll, lllllllllllllllIlIIIlIIIlIlIIIII, lllllllllllllllIlIIIlIIIlIlIIlIl, lllllllllllllllIlIIIlIIIlIlIIlll, lllllllllllllllIlIIIlIIIlIlIIIll, 0.0625f, lllllllllllllllIlIIIlIIIlIIllIlI);
                if (this.field_177098_i) {
                    final boolean lllllllllllllllIlIIIlIIIlIIllllI = this.func_177088_c(lllllllllllllllIlIIIlIIIlIIllIlI);
                    this.renderModel(lllllllllllllllIlIIIlIIIlIIllIlI, lllllllllllllllIlIIIlIIIlIIlllll, lllllllllllllllIlIIIlIIIlIlIIIII, lllllllllllllllIlIIIlIIIlIlIIlIl, lllllllllllllllIlIIIlIIIlIlIIlll, lllllllllllllllIlIIIlIIIlIlIIIll, 0.0625f);
                    if (lllllllllllllllIlIIIlIIIlIIllllI) {
                        this.func_180565_e();
                    }
                }
                else {
                    final boolean lllllllllllllllIlIIIlIIIlIIlllIl = this.func_177090_c(lllllllllllllllIlIIIlIIIlIIllIlI, lllllllllllllllIlIIIlIIIlIIlIlIl);
                    this.renderModel(lllllllllllllllIlIIIlIIIlIIllIlI, lllllllllllllllIlIIIlIIIlIIlllll, lllllllllllllllIlIIIlIIIlIlIIIII, lllllllllllllllIlIIIlIIIlIlIIlIl, lllllllllllllllIlIIIlIIIlIlIIlll, lllllllllllllllIlIIIlIIIlIlIIIll, 0.0625f);
                    if (lllllllllllllllIlIIIlIIIlIIlllIl) {
                        this.func_177091_f();
                    }
                    GlStateManager.depthMask(true);
                    if (!(lllllllllllllllIlIIIlIIIlIIllIlI instanceof EntityPlayer) || !((EntityPlayer)lllllllllllllllIlIIIlIIIlIIllIlI).func_175149_v()) {
                        this.func_177093_a(lllllllllllllllIlIIIlIIIlIIllIlI, lllllllllllllllIlIIIlIIIlIIlllll, lllllllllllllllIlIIIlIIIlIlIIIII, lllllllllllllllIlIIIlIIIlIIlIlIl, lllllllllllllllIlIIIlIIIlIlIIlIl, lllllllllllllllIlIIIlIIIlIlIIlll, lllllllllllllllIlIIIlIIIlIlIIIll, 0.0625f);
                    }
                }
                GlStateManager.disableRescaleNormal();
            }
            catch (Exception lllllllllllllllIlIIIlIIIlIIlllII) {
                RendererLivingEntity.logger.error("Couldn't render entity", (Throwable)lllllllllllllllIlIIIlIIIlIIlllII);
            }
            GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
            GlStateManager.func_179098_w();
            GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
            GlStateManager.enableCull();
            GlStateManager.popMatrix();
            if (!this.field_177098_i) {
                super.doRender(lllllllllllllllIlIIIlIIIlIIllIlI, lllllllllllllllIlIIIlIIIlIlIlllI, lllllllllllllllIlIIIlIIIlIIllIII, lllllllllllllllIlIIIlIIIlIlIllII, lllllllllllllllIlIIIlIIIlIlIlIll, lllllllllllllllIlIIIlIIIlIIlIlIl);
            }
            if (!Reflector.RenderLivingEvent_Post_Constructor.exists() || !Reflector.postForgeBusEvent(Reflector.RenderLivingEvent_Post_Constructor, lllllllllllllllIlIIIlIIIlIIllIlI, this, lllllllllllllllIlIIIlIIIlIlIlllI, lllllllllllllllIlIIIlIIIlIIllIII, lllllllllllllllIlIIIlIIIlIlIllII)) {}
        }
    }
    
    protected void preRenderCallback(final EntityLivingBase lllllllllllllllIlIIIIlllllIlIlIl, final float lllllllllllllllIlIIIIlllllIlIlII) {
    }
    
    protected void func_177091_f() {
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.func_179098_w();
        GL11.glTexEnvi(8960, 8704, OpenGlHelper.field_176095_s);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176099_x, 8448);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176098_y, OpenGlHelper.defaultTexUnit);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176097_z, OpenGlHelper.field_176093_u);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176081_B, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176082_C, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176077_E, 8448);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176078_F, OpenGlHelper.defaultTexUnit);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176079_G, OpenGlHelper.field_176093_u);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176085_I, 770);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176086_J, 770);
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glTexEnvi(8960, 8704, OpenGlHelper.field_176095_s);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176099_x, 8448);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176081_B, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176082_C, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176098_y, 5890);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176097_z, OpenGlHelper.field_176091_w);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176077_E, 8448);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176085_I, 770);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176078_F, 5890);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.setActiveTexture(OpenGlHelper.field_176096_r);
        GlStateManager.func_179090_x();
        GlStateManager.func_179144_i(0);
        GL11.glTexEnvi(8960, 8704, OpenGlHelper.field_176095_s);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176099_x, 8448);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176081_B, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176082_C, 768);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176098_y, 5890);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176097_z, OpenGlHelper.field_176091_w);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176077_E, 8448);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176085_I, 770);
        GL11.glTexEnvi(8960, OpenGlHelper.field_176078_F, 5890);
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        if (Config.isShaders()) {
            Shaders.setEntityColor(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }
    
    protected int getColorMultiplier(final EntityLivingBase lllllllllllllllIlIIIIlllllIllIIl, final float lllllllllllllllIlIIIIlllllIllIII, final float lllllllllllllllIlIIIIlllllIlIlll) {
        return 0;
    }
    
    protected float handleRotationFloat(final EntityLivingBase lllllllllllllllIlIIIlIIIIIIIIlII, final float lllllllllllllllIlIIIlIIIIIIIIIIl) {
        return lllllllllllllllIlIIIlIIIIIIIIlII.ticksExisted + lllllllllllllllIlIIIlIIIIIIIIIIl;
    }
    
    static {
        __OBFID = "CL_00001012";
        logger = LogManager.getLogger();
        field_177096_e = new DynamicTexture(16, 16);
        RendererLivingEntity.NAME_TAG_RANGE = 64.0f;
        RendererLivingEntity.NAME_TAG_RANGE_SNEAK = 32.0f;
        final int[] lllllllllllllllIlIIIlIIIlllIllIl = RendererLivingEntity.field_177096_e.getTextureData();
        for (int lllllllllllllllIlIIIlIIIlllIllII = 0; lllllllllllllllIlIIIlIIIlllIllII < 256; ++lllllllllllllllIlIIIlIIIlllIllII) {
            lllllllllllllllIlIIIlIIIlllIllIl[lllllllllllllllIlIIIlIIIlllIllII] = -1;
        }
        RendererLivingEntity.field_177096_e.updateDynamicTexture();
    }
    
    public void func_82422_c() {
    }
    
    protected void renderModel(final EntityLivingBase lllllllllllllllIlIIIlIIIIllIlIll, final float lllllllllllllllIlIIIlIIIIllIlIlI, final float lllllllllllllllIlIIIlIIIIlIlllll, final float lllllllllllllllIlIIIlIIIIlIllllI, final float lllllllllllllllIlIIIlIIIIlIlllIl, final float lllllllllllllllIlIIIlIIIIlIlllII, final float lllllllllllllllIlIIIlIIIIlIllIll) {
        final boolean lllllllllllllllIlIIIlIIIIllIIlII = !lllllllllllllllIlIIIlIIIIllIlIll.isInvisible();
        final boolean lllllllllllllllIlIIIlIIIIllIIIll = !lllllllllllllllIlIIIlIIIIllIIlII && !lllllllllllllllIlIIIlIIIIllIlIll.isInvisibleToPlayer(Minecraft.getMinecraft().thePlayer);
        if (lllllllllllllllIlIIIlIIIIllIIlII || lllllllllllllllIlIIIlIIIIllIIIll) {
            if (!this.bindEntityTexture(lllllllllllllllIlIIIlIIIIllIlIll)) {
                return;
            }
            if (lllllllllllllllIlIIIlIIIIllIIIll) {
                GlStateManager.pushMatrix();
                GlStateManager.color(1.0f, 1.0f, 1.0f, 0.15f);
                GlStateManager.depthMask(false);
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(770, 771);
                GlStateManager.alphaFunc(516, 0.003921569f);
            }
            this.mainModel.render(lllllllllllllllIlIIIlIIIIllIlIll, lllllllllllllllIlIIIlIIIIllIlIlI, lllllllllllllllIlIIIlIIIIlIlllll, lllllllllllllllIlIIIlIIIIlIllllI, lllllllllllllllIlIIIlIIIIlIlllIl, lllllllllllllllIlIIIlIIIIlIlllII, lllllllllllllllIlIIIlIIIIlIllIll);
            if (lllllllllllllllIlIIIlIIIIllIIIll) {
                GlStateManager.disableBlend();
                GlStateManager.alphaFunc(516, 0.1f);
                GlStateManager.popMatrix();
                GlStateManager.depthMask(true);
            }
        }
    }
    
    protected boolean func_177089_b(final LayerRenderer lllllllllllllllIlIIIlIIIllIlIIlI) {
        return this.field_177097_h.remove(lllllllllllllllIlIIIlIIIllIlIIlI);
    }
    
    static final class SwitchEnumVisible
    {
        static final /* synthetic */ int[] field_178679_a;
        
        static {
            field_178679_a = new int[Team.EnumVisible.values().length];
            try {
                SwitchEnumVisible.field_178679_a[Team.EnumVisible.ALWAYS.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumVisible.field_178679_a[Team.EnumVisible.NEVER.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumVisible.field_178679_a[Team.EnumVisible.HIDE_FOR_OTHER_TEAMS.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumVisible.field_178679_a[Team.EnumVisible.HIDE_FOR_OWN_TEAM.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
        }
    }
}
