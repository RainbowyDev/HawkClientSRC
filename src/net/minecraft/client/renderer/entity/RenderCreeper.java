package net.minecraft.client.renderer.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;

public class RenderCreeper extends RenderLiving
{
    private static final /* synthetic */ ResourceLocation creeperTextures;
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity lllllllllllllllIIIIIllllllIlIIIl) {
        return this.getEntityTexture((EntityCreeper)lllllllllllllllIIIIIllllllIlIIIl);
    }
    
    static {
        __OBFID = "CL_00000985";
        creeperTextures = new ResourceLocation("textures/entity/creeper/creeper.png");
    }
    
    public RenderCreeper(final RenderManager lllllllllllllllIIIIlIIIIIIIIllll) {
        super(lllllllllllllllIIIIlIIIIIIIIllll, new ModelCreeper(), 0.5f);
        this.addLayer(new LayerCreeperCharge(this));
    }
    
    protected int func_180571_a(final EntityCreeper lllllllllllllllIIIIIllllllllIIIl, final float lllllllllllllllIIIIIllllllllIlIl, final float lllllllllllllllIIIIIllllllllIlII) {
        final float lllllllllllllllIIIIIllllllllIIll = lllllllllllllllIIIIIllllllllIIIl.getCreeperFlashIntensity(lllllllllllllllIIIIIllllllllIlII);
        if ((int)(lllllllllllllllIIIIIllllllllIIll * 10.0f) % 2 == 0) {
            return 0;
        }
        int lllllllllllllllIIIIIllllllllIIlI = (int)(lllllllllllllllIIIIIllllllllIIll * 0.2f * 255.0f);
        lllllllllllllllIIIIIllllllllIIlI = MathHelper.clamp_int(lllllllllllllllIIIIIllllllllIIlI, 0, 255);
        return lllllllllllllllIIIIIllllllllIIlI << 24 | 0xFFFFFF;
    }
    
    @Override
    protected int getColorMultiplier(final EntityLivingBase lllllllllllllllIIIIIllllllIllIIl, final float lllllllllllllllIIIIIllllllIllIII, final float lllllllllllllllIIIIIllllllIlIlll) {
        return this.func_180571_a((EntityCreeper)lllllllllllllllIIIIIllllllIllIIl, lllllllllllllllIIIIIllllllIllIII, lllllllllllllllIIIIIllllllIlIlll);
    }
    
    @Override
    protected void preRenderCallback(final EntityLivingBase lllllllllllllllIIIIIlllllllIIlll, final float lllllllllllllllIIIIIlllllllIIllI) {
        this.func_180570_a((EntityCreeper)lllllllllllllllIIIIIlllllllIIlll, lllllllllllllllIIIIIlllllllIIllI);
    }
    
    protected ResourceLocation getEntityTexture(final EntityCreeper lllllllllllllllIIIIIlllllllIllII) {
        return RenderCreeper.creeperTextures;
    }
    
    protected void func_180570_a(final EntityCreeper lllllllllllllllIIIIlIIIIIIIIIIIl, final float lllllllllllllllIIIIlIIIIIIIIIllI) {
        float lllllllllllllllIIIIlIIIIIIIIIlIl = lllllllllllllllIIIIlIIIIIIIIIIIl.getCreeperFlashIntensity(lllllllllllllllIIIIlIIIIIIIIIllI);
        final float lllllllllllllllIIIIlIIIIIIIIIlII = 1.0f + MathHelper.sin(lllllllllllllllIIIIlIIIIIIIIIlIl * 100.0f) * lllllllllllllllIIIIlIIIIIIIIIlIl * 0.01f;
        lllllllllllllllIIIIlIIIIIIIIIlIl = MathHelper.clamp_float(lllllllllllllllIIIIlIIIIIIIIIlIl, 0.0f, 1.0f);
        lllllllllllllllIIIIlIIIIIIIIIlIl *= lllllllllllllllIIIIlIIIIIIIIIlIl;
        lllllllllllllllIIIIlIIIIIIIIIlIl *= lllllllllllllllIIIIlIIIIIIIIIlIl;
        final float lllllllllllllllIIIIlIIIIIIIIIIll = (1.0f + lllllllllllllllIIIIlIIIIIIIIIlIl * 0.4f) * lllllllllllllllIIIIlIIIIIIIIIlII;
        final float lllllllllllllllIIIIlIIIIIIIIIIlI = (1.0f + lllllllllllllllIIIIlIIIIIIIIIlIl * 0.1f) / lllllllllllllllIIIIlIIIIIIIIIlII;
        GlStateManager.scale(lllllllllllllllIIIIlIIIIIIIIIIll, lllllllllllllllIIIIlIIIIIIIIIIlI, lllllllllllllllIIIIlIIIIIIIIIIll);
    }
}
