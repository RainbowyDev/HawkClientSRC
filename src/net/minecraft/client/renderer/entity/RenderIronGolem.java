package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;

public class RenderIronGolem extends RenderLiving
{
    private static final /* synthetic */ ResourceLocation ironGolemTextures;
    
    protected ResourceLocation getEntityTexture(final EntityIronGolem lIlIIIlIIlllIlI) {
        return RenderIronGolem.ironGolemTextures;
    }
    
    public RenderIronGolem(final RenderManager lIlIIIlIIllllII) {
        super(lIlIIIlIIllllII, new ModelIronGolem(), 0.5f);
        this.addLayer(new LayerIronGolemFlower(this));
    }
    
    static {
        __OBFID = "CL_00001031";
        ironGolemTextures = new ResourceLocation("textures/entity/iron_golem.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity lIlIIIlIIIIllIl) {
        return this.getEntityTexture((EntityIronGolem)lIlIIIlIIIIllIl);
    }
    
    @Override
    protected void rotateCorpse(final EntityLivingBase lIlIIIlIIIllIll, final float lIlIIIlIIIlIlIl, final float lIlIIIlIIIlIlII, final float lIlIIIlIIIllIII) {
        this.func_180588_a((EntityIronGolem)lIlIIIlIIIllIll, lIlIIIlIIIlIlIl, lIlIIIlIIIlIlII, lIlIIIlIIIllIII);
    }
    
    protected void func_180588_a(final EntityIronGolem lIlIIIlIIllIIII, final float lIlIIIlIIlIIlll, final float lIlIIIlIIlIIllI, final float lIlIIIlIIlIIlIl) {
        super.rotateCorpse(lIlIIIlIIllIIII, lIlIIIlIIlIIlll, lIlIIIlIIlIIllI, lIlIIIlIIlIIlIl);
        if (lIlIIIlIIllIIII.limbSwingAmount >= 0.01) {
            final float lIlIIIlIIlIllII = 13.0f;
            final float lIlIIIlIIlIlIll = lIlIIIlIIllIIII.limbSwing - lIlIIIlIIllIIII.limbSwingAmount * (1.0f - lIlIIIlIIlIIlIl) + 6.0f;
            final float lIlIIIlIIlIlIlI = (Math.abs(lIlIIIlIIlIlIll % lIlIIIlIIlIllII - lIlIIIlIIlIllII * 0.5f) - lIlIIIlIIlIllII * 0.25f) / (lIlIIIlIIlIllII * 0.25f);
            GlStateManager.rotate(6.5f * lIlIIIlIIlIlIlI, 0.0f, 0.0f, 1.0f);
        }
    }
}
