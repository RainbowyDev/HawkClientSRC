package net.minecraft.client.renderer.entity;

import net.minecraft.client.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.scoreboard.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.entity.layers.*;

public class RenderPlayer extends RendererLivingEntity
{
    private /* synthetic */ boolean field_177140_a;
    
    public void func_180596_a(final AbstractClientPlayer lllllllllllllllIIlIIIllIIIIlllII, final double lllllllllllllllIIlIIIllIIIlIIIll, final double lllllllllllllllIIlIIIllIIIlIIIlI, final double lllllllllllllllIIlIIIllIIIlIIIIl, final float lllllllllllllllIIlIIIllIIIIllIII, final float lllllllllllllllIIlIIIllIIIIlIlll) {
        if (!lllllllllllllllIIlIIIllIIIIlllII.func_175144_cb() || this.renderManager.livingPlayer == lllllllllllllllIIlIIIllIIIIlllII) {
            double lllllllllllllllIIlIIIllIIIIllllI = lllllllllllllllIIlIIIllIIIlIIIlI;
            if (lllllllllllllllIIlIIIllIIIIlllII.isSneaking() && !(lllllllllllllllIIlIIIllIIIIlllII instanceof EntityPlayerSP)) {
                lllllllllllllllIIlIIIllIIIIllllI = lllllllllllllllIIlIIIllIIIlIIIlI - 0.125;
            }
            this.func_177137_d(lllllllllllllllIIlIIIllIIIIlllII);
            super.doRender(lllllllllllllllIIlIIIllIIIIlllII, lllllllllllllllIIlIIIllIIIlIIIll, lllllllllllllllIIlIIIllIIIIllllI, lllllllllllllllIIlIIIllIIIlIIIIl, lllllllllllllllIIlIIIllIIIIllIII, lllllllllllllllIIlIIIllIIIIlIlll);
        }
    }
    
    @Override
    protected void renderLivingAt(final EntityLivingBase lllllllllllllllIIlIIIlIlIIIllIIl, final double lllllllllllllllIIlIIIlIlIIIllIII, final double lllllllllllllllIIlIIIlIlIIIlllII, final double lllllllllllllllIIlIIIlIlIIIllIll) {
        this.renderLivingAt((AbstractClientPlayer)lllllllllllllllIIlIIIlIlIIIllIIl, lllllllllllllllIIlIIIlIlIIIllIII, lllllllllllllllIIlIIIlIlIIIlllII, lllllllllllllllIIlIIIlIlIIIllIll);
    }
    
    @Override
    public ModelBase getMainModel() {
        return this.func_177136_g();
    }
    
    @Override
    protected void rotateCorpse(final EntityLivingBase lllllllllllllllIIlIIIlIlIIlIllll, final float lllllllllllllllIIlIIIlIlIIlIllIl, final float lllllllllllllllIIlIIIlIlIIllIlIl, final float lllllllllllllllIIlIIIlIlIIlIlIIl) {
        this.func_180595_a((AbstractClientPlayer)lllllllllllllllIIlIIIlIlIIlIllll, lllllllllllllllIIlIIIlIlIIlIllIl, lllllllllllllllIIlIIIlIlIIllIlIl, lllllllllllllllIIlIIIlIlIIlIlIIl);
    }
    
    @Override
    public void doRender(final EntityLivingBase lllllllllllllllIIlIIIlIIlllllllI, final double lllllllllllllllIIlIIIlIlIIIIlIIl, final double lllllllllllllllIIlIIIlIlIIIIIlll, final double lllllllllllllllIIlIIIlIlIIIIIlIl, final float lllllllllllllllIIlIIIlIlIIIIIlII, final float lllllllllllllllIIlIIIlIlIIIIIIlI) {
        this.func_180596_a((AbstractClientPlayer)lllllllllllllllIIlIIIlIIlllllllI, lllllllllllllllIIlIIIlIlIIIIlIIl, lllllllllllllllIIlIIIlIlIIIIIlll, lllllllllllllllIIlIIIlIlIIIIIlIl, lllllllllllllllIIlIIIlIlIIIIIlII, lllllllllllllllIIlIIIlIlIIIIIIlI);
    }
    
    public void func_177139_c(final AbstractClientPlayer lllllllllllllllIIlIIIlIllIIIIIll) {
        final float lllllllllllllllIIlIIIlIllIIIIIlI = 1.0f;
        GlStateManager.color(lllllllllllllllIIlIIIlIllIIIIIlI, lllllllllllllllIIlIIIlIllIIIIIlI, lllllllllllllllIIlIIIlIllIIIIIlI);
        final ModelPlayer lllllllllllllllIIlIIIlIllIIIIIIl = this.func_177136_g();
        this.func_177137_d(lllllllllllllllIIlIIIlIllIIIIIll);
        lllllllllllllllIIlIIIlIllIIIIIIl.isSneak = false;
        lllllllllllllllIIlIIIlIllIIIIIIl.swingProgress = 0.0f;
        lllllllllllllllIIlIIIlIllIIIIIIl.setRotationAngles(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f, lllllllllllllllIIlIIIlIllIIIIIll);
        lllllllllllllllIIlIIIlIllIIIIIIl.func_178726_b();
    }
    
    public void func_177138_b(final AbstractClientPlayer lllllllllllllllIIlIIIlIllIIlllll) {
        final float lllllllllllllllIIlIIIlIllIIlllIl = 1.0f;
        GlStateManager.color(lllllllllllllllIIlIIIlIllIIlllIl, lllllllllllllllIIlIIIlIllIIlllIl, lllllllllllllllIIlIIIlIllIIlllIl);
        final ModelPlayer lllllllllllllllIIlIIIlIllIIllIll = this.func_177136_g();
        this.func_177137_d(lllllllllllllllIIlIIIlIllIIlllll);
        lllllllllllllllIIlIIIlIllIIllIll.swingProgress = 0.0f;
        lllllllllllllllIIlIIIlIllIIllIll.isSneak = false;
        lllllllllllllllIIlIIIlIllIIllIll.setRotationAngles(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f, lllllllllllllllIIlIIIlIllIIlllll);
        lllllllllllllllIIlIIIlIllIIllIll.func_178725_a();
    }
    
    public RenderPlayer(final RenderManager lllllllllllllllIIlIIIllIIlIIIIlI) {
        this(lllllllllllllllIIlIIIllIIlIIIIlI, false);
    }
    
    @Override
    public void doRender(final Entity lllllllllllllllIIlIIIlIIlIlIIlIl, final double lllllllllllllllIIlIIIlIIlIlIIIll, final double lllllllllllllllIIlIIIlIIlIlIllll, final double lllllllllllllllIIlIIIlIIlIIlllll, final float lllllllllllllllIIlIIIlIIlIlIlIll, final float lllllllllllllllIIlIIIlIIlIIllIll) {
        this.func_180596_a((AbstractClientPlayer)lllllllllllllllIIlIIIlIIlIlIIlIl, lllllllllllllllIIlIIIlIIlIlIIIll, lllllllllllllllIIlIIIlIIlIlIllll, lllllllllllllllIIlIIIlIIlIIlllll, lllllllllllllllIIlIIIlIIlIlIlIll, lllllllllllllllIIlIIIlIIlIIllIll);
    }
    
    private void func_177137_d(final AbstractClientPlayer lllllllllllllllIIlIIIllIIIIIlIlI) {
        final ModelPlayer lllllllllllllllIIlIIIllIIIIIlllI = this.func_177136_g();
        if (lllllllllllllllIIlIIIllIIIIIlIlI.func_175149_v()) {
            lllllllllllllllIIlIIIllIIIIIlllI.func_178719_a(false);
            lllllllllllllllIIlIIIllIIIIIlllI.bipedHead.showModel = true;
            lllllllllllllllIIlIIIllIIIIIlllI.bipedHeadwear.showModel = true;
        }
        else {
            final ItemStack lllllllllllllllIIlIIIllIIIIIllIl = lllllllllllllllIIlIIIllIIIIIlIlI.inventory.getCurrentItem();
            lllllllllllllllIIlIIIllIIIIIlllI.func_178719_a(true);
            lllllllllllllllIIlIIIllIIIIIlllI.bipedHeadwear.showModel = lllllllllllllllIIlIIIllIIIIIlIlI.func_175148_a(EnumPlayerModelParts.HAT);
            lllllllllllllllIIlIIIllIIIIIlllI.field_178730_v.showModel = lllllllllllllllIIlIIIllIIIIIlIlI.func_175148_a(EnumPlayerModelParts.JACKET);
            lllllllllllllllIIlIIIllIIIIIlllI.field_178733_c.showModel = lllllllllllllllIIlIIIllIIIIIlIlI.func_175148_a(EnumPlayerModelParts.LEFT_PANTS_LEG);
            lllllllllllllllIIlIIIllIIIIIlllI.field_178731_d.showModel = lllllllllllllllIIlIIIllIIIIIlIlI.func_175148_a(EnumPlayerModelParts.RIGHT_PANTS_LEG);
            lllllllllllllllIIlIIIllIIIIIlllI.field_178734_a.showModel = lllllllllllllllIIlIIIllIIIIIlIlI.func_175148_a(EnumPlayerModelParts.LEFT_SLEEVE);
            lllllllllllllllIIlIIIllIIIIIlllI.field_178732_b.showModel = lllllllllllllllIIlIIIllIIIIIlIlI.func_175148_a(EnumPlayerModelParts.RIGHT_SLEEVE);
            lllllllllllllllIIlIIIllIIIIIlllI.heldItemLeft = 0;
            lllllllllllllllIIlIIIllIIIIIlllI.aimedBow = false;
            lllllllllllllllIIlIIIllIIIIIlllI.isSneak = lllllllllllllllIIlIIIllIIIIIlIlI.isSneaking();
            if (lllllllllllllllIIlIIIllIIIIIllIl == null) {
                lllllllllllllllIIlIIIllIIIIIlllI.heldItemRight = 0;
            }
            else {
                lllllllllllllllIIlIIIllIIIIIlllI.heldItemRight = 1;
                if (lllllllllllllllIIlIIIllIIIIIlIlI.getItemInUseCount() > 0) {
                    final EnumAction lllllllllllllllIIlIIIllIIIIIllII = lllllllllllllllIIlIIIllIIIIIllIl.getItemUseAction();
                    if (lllllllllllllllIIlIIIllIIIIIllII == EnumAction.BLOCK) {
                        lllllllllllllllIIlIIIllIIIIIlllI.heldItemRight = 3;
                    }
                    else if (lllllllllllllllIIlIIIllIIIIIllII == EnumAction.BOW) {
                        lllllllllllllllIIlIIIllIIIIIlllI.aimedBow = true;
                    }
                }
            }
        }
    }
    
    @Override
    protected void func_177069_a(final Entity lllllllllllllllIIlIIIlIIllIlIlll, final double lllllllllllllllIIlIIIlIIllIlIlIl, final double lllllllllllllllIIlIIIlIIllIIIlll, final double lllllllllllllllIIlIIIlIIllIIIllI, final String lllllllllllllllIIlIIIlIIllIIIlIl, final float lllllllllllllllIIlIIIlIIllIIIlII, final double lllllllllllllllIIlIIIlIIllIIIIll) {
        this.renderOffsetLivingLabel((AbstractClientPlayer)lllllllllllllllIIlIIIlIIllIlIlll, lllllllllllllllIIlIIIlIIllIlIlIl, lllllllllllllllIIlIIIlIIllIIIlll, lllllllllllllllIIlIIIlIIllIIIllI, lllllllllllllllIIlIIIlIIllIIIlIl, lllllllllllllllIIlIIIlIIllIIIlII, lllllllllllllllIIlIIIlIIllIIIIll);
    }
    
    protected void renderOffsetLivingLabel(final AbstractClientPlayer lllllllllllllllIIlIIIlIlllIlllII, final double lllllllllllllllIIlIIIlIlllIIIlII, double lllllllllllllllIIlIIIlIlllIIIIlI, final double lllllllllllllllIIlIIIlIlllIIIIII, final String lllllllllllllllIIlIIIlIllIlllllI, final float lllllllllllllllIIlIIIlIllIllllII, final double lllllllllllllllIIlIIIlIlllIlIIII) {
        if (lllllllllllllllIIlIIIlIlllIlIIII < 100.0) {
            final Scoreboard lllllllllllllllIIlIIIlIlllIIlllI = lllllllllllllllIIlIIIlIlllIlllII.getWorldScoreboard();
            final ScoreObjective lllllllllllllllIIlIIIlIlllIIllII = lllllllllllllllIIlIIIlIlllIIlllI.getObjectiveInDisplaySlot(2);
            if (lllllllllllllllIIlIIIlIlllIIllII != null) {
                final Score lllllllllllllllIIlIIIlIlllIIlIlI = lllllllllllllllIIlIIIlIlllIIlllI.getValueFromObjective(lllllllllllllllIIlIIIlIlllIlllII.getName(), lllllllllllllllIIlIIIlIlllIIllII);
                this.renderLivingLabel(lllllllllllllllIIlIIIlIlllIlllII, String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIlIIIlIlllIIlIlI.getScorePoints())).append(" ").append(lllllllllllllllIIlIIIlIlllIIllII.getDisplayName())), lllllllllllllllIIlIIIlIlllIIIlII, lllllllllllllllIIlIIIlIlllIIIIlI, lllllllllllllllIIlIIIlIlllIIIIII, 64);
                lllllllllllllllIIlIIIlIlllIIIIlI += this.getFontRendererFromRenderManager().FONT_HEIGHT * 1.15f * lllllllllllllllIIlIIIlIllIllllII;
            }
        }
        super.func_177069_a(lllllllllllllllIIlIIIlIlllIlllII, lllllllllllllllIIlIIIlIlllIIIlII, lllllllllllllllIIlIIIlIlllIIIIlI, lllllllllllllllIIlIIIlIlllIIIIII, lllllllllllllllIIlIIIlIllIlllllI, lllllllllllllllIIlIIIlIllIllllII, lllllllllllllllIIlIIIlIlllIlIIII);
    }
    
    protected ResourceLocation func_180594_a(final AbstractClientPlayer lllllllllllllllIIlIIIllIIIIIIIll) {
        return lllllllllllllllIIlIIIllIIIIIIIll.getLocationSkin();
    }
    
    public ModelPlayer func_177136_g() {
        return (ModelPlayer)super.getMainModel();
    }
    
    public RenderPlayer(final RenderManager lllllllllllllllIIlIIIllIIIllIlIl, final boolean lllllllllllllllIIlIIIllIIIllIlII) {
        super(lllllllllllllllIIlIIIllIIIllIlIl, new ModelPlayer(0.0f, lllllllllllllllIIlIIIllIIIllIlII), 0.5f);
        this.field_177140_a = lllllllllllllllIIlIIIllIIIllIlII;
        this.addLayer(new LayerBipedArmor(this));
        this.addLayer(new LayerHeldItem(this));
        this.addLayer(new LayerArrow(this));
        this.addLayer(new LayerDeadmau5Head(this));
        this.addLayer(new LayerCape(this));
        this.addLayer(new LayerCustomHead(this.func_177136_g().bipedHead));
    }
    
    static {
        __OBFID = "CL_00001020";
    }
    
    @Override
    protected void preRenderCallback(final EntityLivingBase lllllllllllllllIIlIIIlIlIlIIllII, final float lllllllllllllllIIlIIIlIlIlIlIIII) {
        this.preRenderCallback((AbstractClientPlayer)lllllllllllllllIIlIIIlIlIlIIllII, lllllllllllllllIIlIIIlIlIlIlIIII);
    }
    
    protected void func_180595_a(final AbstractClientPlayer lllllllllllllllIIlIIIlIlIllIIlll, final float lllllllllllllllIIlIIIlIlIllIIIII, final float lllllllllllllllIIlIIIlIlIllIIlIl, final float lllllllllllllllIIlIIIlIlIllIIlII) {
        if (lllllllllllllllIIlIIIlIlIllIIlll.isEntityAlive() && lllllllllllllllIIlIIIlIlIllIIlll.isPlayerSleeping()) {
            GlStateManager.rotate(lllllllllllllllIIlIIIlIlIllIIlll.getBedOrientationInDegrees(), 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(this.getDeathMaxRotation(lllllllllllllllIIlIIIlIlIllIIlll), 0.0f, 0.0f, 1.0f);
            GlStateManager.rotate(270.0f, 0.0f, 1.0f, 0.0f);
        }
        else {
            super.rotateCorpse(lllllllllllllllIIlIIIlIlIllIIlll, lllllllllllllllIIlIIIlIlIllIIIII, lllllllllllllllIIlIIIlIlIllIIlIl, lllllllllllllllIIlIIIlIlIllIIlII);
        }
    }
    
    @Override
    public void func_82422_c() {
        GlStateManager.translate(0.0f, 0.1875f, 0.0f);
    }
    
    protected void preRenderCallback(final AbstractClientPlayer lllllllllllllllIIlIIIlIlllllllll, final float lllllllllllllllIIlIIIlIllllllllI) {
        final float lllllllllllllllIIlIIIlIlllllllIl = 0.9375f;
        GlStateManager.scale(lllllllllllllllIIlIIIlIlllllllIl, lllllllllllllllIIlIIIlIlllllllIl, lllllllllllllllIIlIIIlIlllllllIl);
    }
    
    protected void renderLivingAt(final AbstractClientPlayer lllllllllllllllIIlIIIlIlIlllIllI, final double lllllllllllllllIIlIIIlIlIlllIIII, final double lllllllllllllllIIlIIIlIlIllIllll, final double lllllllllllllllIIlIIIlIlIllIlllI) {
        if (lllllllllllllllIIlIIIlIlIlllIllI.isEntityAlive() && lllllllllllllllIIlIIIlIlIlllIllI.isPlayerSleeping()) {
            super.renderLivingAt(lllllllllllllllIIlIIIlIlIlllIllI, lllllllllllllllIIlIIIlIlIlllIIII + lllllllllllllllIIlIIIlIlIlllIllI.field_71079_bU, lllllllllllllllIIlIIIlIlIllIllll + lllllllllllllllIIlIIIlIlIlllIllI.field_71082_cx, lllllllllllllllIIlIIIlIlIllIlllI + lllllllllllllllIIlIIIlIlIlllIllI.field_71089_bV);
        }
        else {
            super.renderLivingAt(lllllllllllllllIIlIIIlIlIlllIllI, lllllllllllllllIIlIIIlIlIlllIIII, lllllllllllllllIIlIIIlIlIllIllll, lllllllllllllllIIlIIIlIlIllIlllI);
        }
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity lllllllllllllllIIlIIIlIIlllIlIII) {
        return this.func_180594_a((AbstractClientPlayer)lllllllllllllllIIlIIIlIIlllIlIII);
    }
}
