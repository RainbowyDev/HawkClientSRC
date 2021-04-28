package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.*;

public class RenderSquid extends RenderLiving
{
    private static final /* synthetic */ ResourceLocation squidTextures;
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity lllllllllllllllllIIIlllIlIllllll) {
        return this.getEntityTexture((EntitySquid)lllllllllllllllllIIIlllIlIllllll);
    }
    
    @Override
    protected void rotateCorpse(final EntityLivingBase lllllllllllllllllIIIlllIllIIlIll, final float lllllllllllllllllIIIlllIllIIlIlI, final float lllllllllllllllllIIIlllIllIIIlII, final float lllllllllllllllllIIIlllIllIIlIII) {
        this.rotateCorpse((EntitySquid)lllllllllllllllllIIIlllIllIIlIll, lllllllllllllllllIIIlllIllIIlIlI, lllllllllllllllllIIIlllIllIIIlII, lllllllllllllllllIIIlllIllIIlIII);
    }
    
    @Override
    protected float handleRotationFloat(final EntityLivingBase lllllllllllllllllIIIlllIllIlIIll, final float lllllllllllllllllIIIlllIllIlIIlI) {
        return this.handleRotationFloat((EntitySquid)lllllllllllllllllIIIlllIllIlIIll, lllllllllllllllllIIIlllIllIlIIlI);
    }
    
    public RenderSquid(final RenderManager lllllllllllllllllIIIlllIllllIlll, final ModelBase lllllllllllllllllIIIlllIlllllIlI, final float lllllllllllllllllIIIlllIlllllIIl) {
        super(lllllllllllllllllIIIlllIllllIlll, lllllllllllllllllIIIlllIlllllIlI, lllllllllllllllllIIIlllIlllllIIl);
    }
    
    static {
        __OBFID = "CL_00001028";
        squidTextures = new ResourceLocation("textures/entity/squid.png");
    }
    
    protected void rotateCorpse(final EntitySquid lllllllllllllllllIIIlllIlllIIllI, final float lllllllllllllllllIIIlllIlllIlIll, final float lllllllllllllllllIIIlllIlllIlIlI, final float lllllllllllllllllIIIlllIlllIIlII) {
        final float lllllllllllllllllIIIlllIlllIlIII = lllllllllllllllllIIIlllIlllIIllI.prevSquidPitch + (lllllllllllllllllIIIlllIlllIIllI.squidPitch - lllllllllllllllllIIIlllIlllIIllI.prevSquidPitch) * lllllllllllllllllIIIlllIlllIIlII;
        final float lllllllllllllllllIIIlllIlllIIlll = lllllllllllllllllIIIlllIlllIIllI.prevSquidYaw + (lllllllllllllllllIIIlllIlllIIllI.squidYaw - lllllllllllllllllIIIlllIlllIIllI.prevSquidYaw) * lllllllllllllllllIIIlllIlllIIlII;
        GlStateManager.translate(0.0f, 0.5f, 0.0f);
        GlStateManager.rotate(180.0f - lllllllllllllllllIIIlllIlllIlIlI, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(lllllllllllllllllIIIlllIlllIlIII, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(lllllllllllllllllIIIlllIlllIIlll, 0.0f, 1.0f, 0.0f);
        GlStateManager.translate(0.0f, -1.2f, 0.0f);
    }
    
    protected ResourceLocation getEntityTexture(final EntitySquid lllllllllllllllllIIIlllIllllIIll) {
        return RenderSquid.squidTextures;
    }
    
    protected float handleRotationFloat(final EntitySquid lllllllllllllllllIIIlllIllIllllI, final float lllllllllllllllllIIIlllIllIlllIl) {
        return lllllllllllllllllIIIlllIllIllllI.lastTentacleAngle + (lllllllllllllllllIIIlllIllIllllI.tentacleAngle - lllllllllllllllllIIIlllIllIllllI.lastTentacleAngle) * lllllllllllllllllIIIlllIllIlllIl;
    }
}
