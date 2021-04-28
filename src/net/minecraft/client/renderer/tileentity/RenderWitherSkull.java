package net.minecraft.client.renderer.tileentity;

import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;

public class RenderWitherSkull extends Render
{
    private static final /* synthetic */ ResourceLocation invulnerableWitherTextures;
    private static final /* synthetic */ ResourceLocation witherTextures;
    private final /* synthetic */ ModelSkeletonHead skeletonHeadModel;
    
    protected ResourceLocation func_180564_a(final EntityWitherSkull lllllllllllllllIlIIlllIIlllIlllI) {
        return lllllllllllllllIlIIlllIIlllIlllI.isInvulnerable() ? RenderWitherSkull.invulnerableWitherTextures : RenderWitherSkull.witherTextures;
    }
    
    private float func_82400_a(final float lllllllllllllllIlIIlllIlIIlIIIll, final float lllllllllllllllIlIIlllIlIIlIIIlI, final float lllllllllllllllIlIIlllIlIIIlllIl) {
        float lllllllllllllllIlIIlllIlIIlIIIII;
        for (lllllllllllllllIlIIlllIlIIlIIIII = lllllllllllllllIlIIlllIlIIlIIIlI - lllllllllllllllIlIIlllIlIIlIIIll; lllllllllllllllIlIIlllIlIIlIIIII < -180.0f; lllllllllllllllIlIIlllIlIIlIIIII += 360.0f) {}
        while (lllllllllllllllIlIIlllIlIIlIIIII >= 180.0f) {
            lllllllllllllllIlIIlllIlIIlIIIII -= 360.0f;
        }
        return lllllllllllllllIlIIlllIlIIlIIIll + lllllllllllllllIlIIlllIlIIIlllIl * lllllllllllllllIlIIlllIlIIlIIIII;
    }
    
    static {
        __OBFID = "CL_00001035";
        invulnerableWitherTextures = new ResourceLocation("textures/entity/wither/wither_invulnerable.png");
        witherTextures = new ResourceLocation("textures/entity/wither/wither.png");
    }
    
    public RenderWitherSkull(final RenderManager lllllllllllllllIlIIlllIlIIlIlIll) {
        super(lllllllllllllllIlIIlllIlIIlIlIll);
        this.skeletonHeadModel = new ModelSkeletonHead();
    }
    
    @Override
    public void doRender(final Entity lllllllllllllllIlIIlllIIllIlIlII, final double lllllllllllllllIlIIlllIIllIlIIlI, final double lllllllllllllllIlIIlllIIllIlIIII, final double lllllllllllllllIlIIlllIIllIIlllI, final float lllllllllllllllIlIIlllIIlIlllllI, final float lllllllllllllllIlIIlllIIlIllllII) {
        this.doRender((EntityWitherSkull)lllllllllllllllIlIIlllIIllIlIlII, lllllllllllllllIlIIlllIIllIlIIlI, lllllllllllllllIlIIlllIIllIlIIII, lllllllllllllllIlIIlllIIllIIlllI, lllllllllllllllIlIIlllIIlIlllllI, lllllllllllllllIlIIlllIIlIllllII);
    }
    
    public void doRender(final EntityWitherSkull lllllllllllllllIlIIlllIlIIIlIIII, final double lllllllllllllllIlIIlllIlIIIIllll, final double lllllllllllllllIlIIlllIlIIIIIIlI, final double lllllllllllllllIlIIlllIlIIIIllIl, final float lllllllllllllllIlIIlllIlIIIIllII, final float lllllllllllllllIlIIlllIIllllllII) {
        GlStateManager.pushMatrix();
        GlStateManager.disableCull();
        final float lllllllllllllllIlIIlllIlIIIIlIlI = this.func_82400_a(lllllllllllllllIlIIlllIlIIIlIIII.prevRotationYaw, lllllllllllllllIlIIlllIlIIIlIIII.rotationYaw, lllllllllllllllIlIIlllIIllllllII);
        final float lllllllllllllllIlIIlllIlIIIIlIIl = lllllllllllllllIlIIlllIlIIIlIIII.prevRotationPitch + (lllllllllllllllIlIIlllIlIIIlIIII.rotationPitch - lllllllllllllllIlIIlllIlIIIlIIII.prevRotationPitch) * lllllllllllllllIlIIlllIIllllllII;
        GlStateManager.translate((float)lllllllllllllllIlIIlllIlIIIIllll, (float)lllllllllllllllIlIIlllIlIIIIIIlI, (float)lllllllllllllllIlIIlllIlIIIIllIl);
        final float lllllllllllllllIlIIlllIlIIIIlIII = 0.0625f;
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(-1.0f, -1.0f, 1.0f);
        GlStateManager.enableAlpha();
        this.bindEntityTexture(lllllllllllllllIlIIlllIlIIIlIIII);
        this.skeletonHeadModel.render(lllllllllllllllIlIIlllIlIIIlIIII, 0.0f, 0.0f, 0.0f, lllllllllllllllIlIIlllIlIIIIlIlI, lllllllllllllllIlIIlllIlIIIIlIIl, lllllllllllllllIlIIlllIlIIIIlIII);
        GlStateManager.popMatrix();
        super.doRender(lllllllllllllllIlIIlllIlIIIlIIII, lllllllllllllllIlIIlllIlIIIIllll, lllllllllllllllIlIIlllIlIIIIIIlI, lllllllllllllllIlIIlllIlIIIIllIl, lllllllllllllllIlIIlllIlIIIIllII, lllllllllllllllIlIIlllIIllllllII);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity lllllllllllllllIlIIlllIIlllIIlll) {
        return this.func_180564_a((EntityWitherSkull)lllllllllllllllIlIIlllIIlllIIlll);
    }
}
