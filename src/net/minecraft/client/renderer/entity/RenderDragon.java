package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.boss.*;

public class RenderDragon extends RenderLiving
{
    private static final /* synthetic */ ResourceLocation enderDragonExplodingTextures;
    private static final /* synthetic */ ResourceLocation enderDragonCrystalBeamTextures;
    private static final /* synthetic */ ResourceLocation enderDragonTextures;
    protected /* synthetic */ ModelDragon modelDragon;
    
    public RenderDragon(final RenderManager llllllllllllllIllIlIllIlIIIIlIII) {
        super(llllllllllllllIllIlIllIlIIIIlIII, new ModelDragon(0.0f), 0.5f);
        this.modelDragon = (ModelDragon)this.mainModel;
        this.addLayer(new LayerEnderDragonEyes(this));
        this.addLayer(new LayerEnderDragonDeath());
    }
    
    static {
        __OBFID = "CL_00000988";
        enderDragonCrystalBeamTextures = new ResourceLocation("textures/entity/endercrystal/endercrystal_beam.png");
        enderDragonExplodingTextures = new ResourceLocation("textures/entity/enderdragon/dragon_exploding.png");
        enderDragonTextures = new ResourceLocation("textures/entity/enderdragon/dragon.png");
    }
    
    @Override
    public void doRender(final Entity llllllllllllllIllIlIllIIIIIllIIl, final double llllllllllllllIllIlIllIIIIIlllll, final double llllllllllllllIllIlIllIIIIIllllI, final double llllllllllllllIllIlIllIIIIIlIllI, final float llllllllllllllIllIlIllIIIIIlllII, final float llllllllllllllIllIlIllIIIIIlIlII) {
        this.doRender((EntityDragon)llllllllllllllIllIlIllIIIIIllIIl, llllllllllllllIllIlIllIIIIIlllll, llllllllllllllIllIlIllIIIIIllllI, llllllllllllllIllIlIllIIIIIlIllI, llllllllllllllIllIlIllIIIIIlllII, llllllllllllllIllIlIllIIIIIlIlII);
    }
    
    @Override
    public void doRender(final EntityLivingBase llllllllllllllIllIlIllIIIIllIlII, final double llllllllllllllIllIlIllIIIIlllIlI, final double llllllllllllllIllIlIllIIIIlllIIl, final double llllllllllllllIllIlIllIIIIlllIII, final float llllllllllllllIllIlIllIIIIllIIII, final float llllllllllllllIllIlIllIIIIllIllI) {
        this.doRender((EntityDragon)llllllllllllllIllIlIllIIIIllIlII, llllllllllllllIllIlIllIIIIlllIlI, llllllllllllllIllIlIllIIIIlllIIl, llllllllllllllIllIlIllIIIIlllIII, llllllllllllllIllIlIllIIIIllIIII, llllllllllllllIllIlIllIIIIllIllI);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllllIllIlIllIIIIlIlIll) {
        return this.getEntityTexture((EntityDragon)llllllllllllllIllIlIllIIIIlIlIll);
    }
    
    @Override
    protected void renderModel(final EntityLivingBase llllllllllllllIllIlIllIIIlIlIIlI, final float llllllllllllllIllIlIllIIIlIlIIIl, final float llllllllllllllIllIlIllIIIlIIlIII, final float llllllllllllllIllIlIllIIIlIIllll, final float llllllllllllllIllIlIllIIIlIIlllI, final float llllllllllllllIllIlIllIIIlIIllIl, final float llllllllllllllIllIlIllIIIlIIllII) {
        this.renderModel((EntityDragon)llllllllllllllIllIlIllIIIlIlIIlI, llllllllllllllIllIlIllIIIlIlIIIl, llllllllllllllIllIlIllIIIlIIlIII, llllllllllllllIllIlIllIIIlIIllll, llllllllllllllIllIlIllIIIlIIlllI, llllllllllllllIllIlIllIIIlIIllIl, llllllllllllllIllIlIllIIIlIIllII);
    }
    
    protected ResourceLocation getEntityTexture(final EntityDragon llllllllllllllIllIlIllIIlIIIIIII) {
        return RenderDragon.enderDragonTextures;
    }
    
    protected void func_180575_a(final EntityDragon llllllllllllllIllIlIllIIlllllIII, final float llllllllllllllIllIlIllIIllllllll, final float llllllllllllllIllIlIllIIlllllllI, final float llllllllllllllIllIlIllIIllllIlll) {
        final float llllllllllllllIllIlIllIIllllllII = (float)llllllllllllllIllIlIllIIlllllIII.getMovementOffsets(7, llllllllllllllIllIlIllIIllllIlll)[0];
        final float llllllllllllllIllIlIllIIlllllIll = (float)(llllllllllllllIllIlIllIIlllllIII.getMovementOffsets(5, llllllllllllllIllIlIllIIllllIlll)[1] - llllllllllllllIllIlIllIIlllllIII.getMovementOffsets(10, llllllllllllllIllIlIllIIllllIlll)[1]);
        GlStateManager.rotate(-llllllllllllllIllIlIllIIllllllII, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(llllllllllllllIllIlIllIIlllllIll * 10.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.translate(0.0f, 0.0f, 1.0f);
        if (llllllllllllllIllIlIllIIlllllIII.deathTime > 0) {
            float llllllllllllllIllIlIllIIlllllIlI = (llllllllllllllIllIlIllIIlllllIII.deathTime + llllllllllllllIllIlIllIIllllIlll - 1.0f) / 20.0f * 1.6f;
            llllllllllllllIllIlIllIIlllllIlI = MathHelper.sqrt_float(llllllllllllllIllIlIllIIlllllIlI);
            if (llllllllllllllIllIlIllIIlllllIlI > 1.0f) {
                llllllllllllllIllIlIllIIlllllIlI = 1.0f;
            }
            GlStateManager.rotate(llllllllllllllIllIlIllIIlllllIlI * this.getDeathMaxRotation(llllllllllllllIllIlIllIIlllllIII), 0.0f, 0.0f, 1.0f);
        }
    }
    
    @Override
    public void doRender(final EntityLiving llllllllllllllIllIlIllIIIlllIIII, final double llllllllllllllIllIlIllIIIllIllll, final double llllllllllllllIllIlIllIIIllIlllI, final double llllllllllllllIllIlIllIIIlllIlII, final float llllllllllllllIllIlIllIIIlllIIll, final float llllllllllllllIllIlIllIIIlllIIlI) {
        this.doRender((EntityDragon)llllllllllllllIllIlIllIIIlllIIII, llllllllllllllIllIlIllIIIllIllll, llllllllllllllIllIlIllIIIllIlllI, llllllllllllllIllIlIllIIIlllIlII, llllllllllllllIllIlIllIIIlllIIll, llllllllllllllIllIlIllIIIlllIIlI);
    }
    
    protected void func_180574_a(final EntityDragon llllllllllllllIllIlIllIIlIlIllII, final double llllllllllllllIllIlIllIIlIlIlIll, final double llllllllllllllIllIlIllIIlIlIlIlI, final double llllllllllllllIllIlIllIIlIIlIIll, final float llllllllllllllIllIlIllIIlIlIlIII) {
        final float llllllllllllllIllIlIllIIlIlIIlll = llllllllllllllIllIlIllIIlIlIllII.healingEnderCrystal.innerRotation + llllllllllllllIllIlIllIIlIlIlIII;
        float llllllllllllllIllIlIllIIlIlIIllI = MathHelper.sin(llllllllllllllIllIlIllIIlIlIIlll * 0.2f) / 2.0f + 0.5f;
        llllllllllllllIllIlIllIIlIlIIllI = (llllllllllllllIllIlIllIIlIlIIllI * llllllllllllllIllIlIllIIlIlIIllI + llllllllllllllIllIlIllIIlIlIIllI) * 0.2f;
        final float llllllllllllllIllIlIllIIlIlIIlIl = (float)(llllllllllllllIllIlIllIIlIlIllII.healingEnderCrystal.posX - llllllllllllllIllIlIllIIlIlIllII.posX - (llllllllllllllIllIlIllIIlIlIllII.prevPosX - llllllllllllllIllIlIllIIlIlIllII.posX) * (1.0f - llllllllllllllIllIlIllIIlIlIlIII));
        final float llllllllllllllIllIlIllIIlIlIIlII = (float)(llllllllllllllIllIlIllIIlIlIIllI + llllllllllllllIllIlIllIIlIlIllII.healingEnderCrystal.posY - 1.0 - llllllllllllllIllIlIllIIlIlIllII.posY - (llllllllllllllIllIlIllIIlIlIllII.prevPosY - llllllllllllllIllIlIllIIlIlIllII.posY) * (1.0f - llllllllllllllIllIlIllIIlIlIlIII));
        final float llllllllllllllIllIlIllIIlIlIIIll = (float)(llllllllllllllIllIlIllIIlIlIllII.healingEnderCrystal.posZ - llllllllllllllIllIlIllIIlIlIllII.posZ - (llllllllllllllIllIlIllIIlIlIllII.prevPosZ - llllllllllllllIllIlIllIIlIlIllII.posZ) * (1.0f - llllllllllllllIllIlIllIIlIlIlIII));
        final float llllllllllllllIllIlIllIIlIlIIIlI = MathHelper.sqrt_float(llllllllllllllIllIlIllIIlIlIIlIl * llllllllllllllIllIlIllIIlIlIIlIl + llllllllllllllIllIlIllIIlIlIIIll * llllllllllllllIllIlIllIIlIlIIIll);
        final float llllllllllllllIllIlIllIIlIlIIIIl = MathHelper.sqrt_float(llllllllllllllIllIlIllIIlIlIIlIl * llllllllllllllIllIlIllIIlIlIIlIl + llllllllllllllIllIlIllIIlIlIIlII * llllllllllllllIllIlIllIIlIlIIlII + llllllllllllllIllIlIllIIlIlIIIll * llllllllllllllIllIlIllIIlIlIIIll);
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)llllllllllllllIllIlIllIIlIlIlIll, (float)llllllllllllllIllIlIllIIlIlIlIlI + 2.0f, (float)llllllllllllllIllIlIllIIlIIlIIll);
        GlStateManager.rotate((float)(-Math.atan2(llllllllllllllIllIlIllIIlIlIIIll, llllllllllllllIllIlIllIIlIlIIlIl)) * 180.0f / 3.1415927f - 90.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate((float)(-Math.atan2(llllllllllllllIllIlIllIIlIlIIIlI, llllllllllllllIllIlIllIIlIlIIlII)) * 180.0f / 3.1415927f - 90.0f, 1.0f, 0.0f, 0.0f);
        final Tessellator llllllllllllllIllIlIllIIlIlIIIII = Tessellator.getInstance();
        final WorldRenderer llllllllllllllIllIlIllIIlIIlllll = llllllllllllllIllIlIllIIlIlIIIII.getWorldRenderer();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableCull();
        this.bindTexture(RenderDragon.enderDragonCrystalBeamTextures);
        GlStateManager.shadeModel(7425);
        final float llllllllllllllIllIlIllIIlIIllllI = 0.0f - (llllllllllllllIllIlIllIIlIlIllII.ticksExisted + llllllllllllllIllIlIllIIlIlIlIII) * 0.01f;
        final float llllllllllllllIllIlIllIIlIIlllIl = MathHelper.sqrt_float(llllllllllllllIllIlIllIIlIlIIlIl * llllllllllllllIllIlIllIIlIlIIlIl + llllllllllllllIllIlIllIIlIlIIlII * llllllllllllllIllIlIllIIlIlIIlII + llllllllllllllIllIlIllIIlIlIIIll * llllllllllllllIllIlIllIIlIlIIIll) / 32.0f - (llllllllllllllIllIlIllIIlIlIllII.ticksExisted + llllllllllllllIllIlIllIIlIlIlIII) * 0.01f;
        llllllllllllllIllIlIllIIlIIlllll.startDrawing(5);
        final byte llllllllllllllIllIlIllIIlIIlllII = 8;
        for (int llllllllllllllIllIlIllIIlIIllIll = 0; llllllllllllllIllIlIllIIlIIllIll <= llllllllllllllIllIlIllIIlIIlllII; ++llllllllllllllIllIlIllIIlIIllIll) {
            final float llllllllllllllIllIlIllIIlIIllIlI = MathHelper.sin(llllllllllllllIllIlIllIIlIIllIll % llllllllllllllIllIlIllIIlIIlllII * 3.1415927f * 2.0f / llllllllllllllIllIlIllIIlIIlllII) * 0.75f;
            final float llllllllllllllIllIlIllIIlIIllIIl = MathHelper.cos(llllllllllllllIllIlIllIIlIIllIll % llllllllllllllIllIlIllIIlIIlllII * 3.1415927f * 2.0f / llllllllllllllIllIlIllIIlIIlllII) * 0.75f;
            final float llllllllllllllIllIlIllIIlIIllIII = llllllllllllllIllIlIllIIlIIllIll % llllllllllllllIllIlIllIIlIIlllII * 1.0f / llllllllllllllIllIlIllIIlIIlllII;
            llllllllllllllIllIlIllIIlIIlllll.func_178991_c(0);
            llllllllllllllIllIlIllIIlIIlllll.addVertexWithUV(llllllllllllllIllIlIllIIlIIllIlI * 0.2f, llllllllllllllIllIlIllIIlIIllIIl * 0.2f, 0.0, llllllllllllllIllIlIllIIlIIllIII, llllllllllllllIllIlIllIIlIIlllIl);
            llllllllllllllIllIlIllIIlIIlllll.func_178991_c(16777215);
            llllllllllllllIllIlIllIIlIIlllll.addVertexWithUV(llllllllllllllIllIlIllIIlIIllIlI, llllllllllllllIllIlIllIIlIIllIIl, llllllllllllllIllIlIllIIlIlIIIIl, llllllllllllllIllIlIllIIlIIllIII, llllllllllllllIllIlIllIIlIIllllI);
        }
        llllllllllllllIllIlIllIIlIlIIIII.draw();
        GlStateManager.enableCull();
        GlStateManager.shadeModel(7424);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.popMatrix();
    }
    
    @Override
    protected void rotateCorpse(final EntityLivingBase llllllllllllllIllIlIllIIIllIIlII, final float llllllllllllllIllIlIllIIIlIllllI, final float llllllllllllllIllIlIllIIIlIlllIl, final float llllllllllllllIllIlIllIIIllIIIIl) {
        this.func_180575_a((EntityDragon)llllllllllllllIllIlIllIIIllIIlII, llllllllllllllIllIlIllIIIlIllllI, llllllllllllllIllIlIllIIIlIlllIl, llllllllllllllIllIlIllIIIllIIIIl);
    }
    
    public void doRender(final EntityDragon llllllllllllllIllIlIllIIllIIlIIl, final double llllllllllllllIllIlIllIIllIIllll, final double llllllllllllllIllIlIllIIllIIIlll, final double llllllllllllllIllIlIllIIllIIllIl, final float llllllllllllllIllIlIllIIllIIIlIl, final float llllllllllllllIllIlIllIIllIIIlII) {
        BossStatus.setBossStatus(llllllllllllllIllIlIllIIllIIlIIl, false);
        super.doRender(llllllllllllllIllIlIllIIllIIlIIl, llllllllllllllIllIlIllIIllIIllll, llllllllllllllIllIlIllIIllIIIlll, llllllllllllllIllIlIllIIllIIllIl, llllllllllllllIllIlIllIIllIIIlIl, llllllllllllllIllIlIllIIllIIIlII);
        if (llllllllllllllIllIlIllIIllIIlIIl.healingEnderCrystal != null) {
            this.func_180574_a(llllllllllllllIllIlIllIIllIIlIIl, llllllllllllllIllIlIllIIllIIllll, llllllllllllllIllIlIllIIllIIIlll, llllllllllllllIllIlIllIIllIIllIl, llllllllllllllIllIlIllIIllIIIlII);
        }
    }
    
    protected void renderModel(final EntityDragon llllllllllllllIllIlIllIIlllIlIIl, final float llllllllllllllIllIlIllIIlllIlIII, final float llllllllllllllIllIlIllIIllIllllI, final float llllllllllllllIllIlIllIIllIlllIl, final float llllllllllllllIllIlIllIIllIlllII, final float llllllllllllllIllIlIllIIlllIIlII, final float llllllllllllllIllIlIllIIlllIIIll) {
        if (llllllllllllllIllIlIllIIlllIlIIl.deathTicks > 0) {
            final float llllllllllllllIllIlIllIIlllIIIlI = llllllllllllllIllIlIllIIlllIlIIl.deathTicks / 200.0f;
            GlStateManager.depthFunc(515);
            GlStateManager.enableAlpha();
            GlStateManager.alphaFunc(516, llllllllllllllIllIlIllIIlllIIIlI);
            this.bindTexture(RenderDragon.enderDragonExplodingTextures);
            this.mainModel.render(llllllllllllllIllIlIllIIlllIlIIl, llllllllllllllIllIlIllIIlllIlIII, llllllllllllllIllIlIllIIllIllllI, llllllllllllllIllIlIllIIllIlllIl, llllllllllllllIllIlIllIIllIlllII, llllllllllllllIllIlIllIIlllIIlII, llllllllllllllIllIlIllIIlllIIIll);
            GlStateManager.alphaFunc(516, 0.1f);
            GlStateManager.depthFunc(514);
        }
        this.bindEntityTexture(llllllllllllllIllIlIllIIlllIlIIl);
        this.mainModel.render(llllllllllllllIllIlIllIIlllIlIIl, llllllllllllllIllIlIllIIlllIlIII, llllllllllllllIllIlIllIIllIllllI, llllllllllllllIllIlIllIIllIlllIl, llllllllllllllIllIlIllIIllIlllII, llllllllllllllIllIlIllIIlllIIlII, llllllllllllllIllIlIllIIlllIIIll);
        if (llllllllllllllIllIlIllIIlllIlIIl.hurtTime > 0) {
            GlStateManager.depthFunc(514);
            GlStateManager.func_179090_x();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 771);
            GlStateManager.color(1.0f, 0.0f, 0.0f, 0.5f);
            this.mainModel.render(llllllllllllllIllIlIllIIlllIlIIl, llllllllllllllIllIlIllIIlllIlIII, llllllllllllllIllIlIllIIllIllllI, llllllllllllllIllIlIllIIllIlllIl, llllllllllllllIllIlIllIIllIlllII, llllllllllllllIllIlIllIIlllIIlII, llllllllllllllIllIlIllIIlllIIIll);
            GlStateManager.func_179098_w();
            GlStateManager.disableBlend();
            GlStateManager.depthFunc(515);
        }
    }
}
