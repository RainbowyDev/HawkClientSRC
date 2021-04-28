package net.minecraft.client.renderer.entity;

import net.minecraft.entity.item.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.client.model.*;

public class RenderBoat extends Render
{
    private static final /* synthetic */ ResourceLocation boatTextures;
    protected /* synthetic */ ModelBase modelBoat;
    
    protected ResourceLocation func_180553_a(final EntityBoat lllllllllllllllIIIIlIlIllIIlIIlI) {
        return RenderBoat.boatTextures;
    }
    
    public void func_180552_a(final EntityBoat lllllllllllllllIIIIlIlIllIlIIllI, final double lllllllllllllllIIIIlIlIllIlIIlIl, final double lllllllllllllllIIIIlIlIllIIllIlI, final double lllllllllllllllIIIIlIlIllIlIIIll, final float lllllllllllllllIIIIlIlIllIlIIIlI, final float lllllllllllllllIIIIlIlIllIIlIlll) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)lllllllllllllllIIIIlIlIllIlIIlIl, (float)lllllllllllllllIIIIlIlIllIIllIlI + 0.25f, (float)lllllllllllllllIIIIlIlIllIlIIIll);
        GlStateManager.rotate(180.0f - lllllllllllllllIIIIlIlIllIlIIIlI, 0.0f, 1.0f, 0.0f);
        final float lllllllllllllllIIIIlIlIllIlIIIII = lllllllllllllllIIIIlIlIllIlIIllI.getTimeSinceHit() - lllllllllllllllIIIIlIlIllIIlIlll;
        float lllllllllllllllIIIIlIlIllIIlllll = lllllllllllllllIIIIlIlIllIlIIllI.getDamageTaken() - lllllllllllllllIIIIlIlIllIIlIlll;
        if (lllllllllllllllIIIIlIlIllIIlllll < 0.0f) {
            lllllllllllllllIIIIlIlIllIIlllll = 0.0f;
        }
        if (lllllllllllllllIIIIlIlIllIlIIIII > 0.0f) {
            GlStateManager.rotate(MathHelper.sin(lllllllllllllllIIIIlIlIllIlIIIII) * lllllllllllllllIIIIlIlIllIlIIIII * lllllllllllllllIIIIlIlIllIIlllll / 10.0f * lllllllllllllllIIIIlIlIllIlIIllI.getForwardDirection(), 1.0f, 0.0f, 0.0f);
        }
        final float lllllllllllllllIIIIlIlIllIIllllI = 0.75f;
        GlStateManager.scale(lllllllllllllllIIIIlIlIllIIllllI, lllllllllllllllIIIIlIlIllIIllllI, lllllllllllllllIIIIlIlIllIIllllI);
        GlStateManager.scale(1.0f / lllllllllllllllIIIIlIlIllIIllllI, 1.0f / lllllllllllllllIIIIlIlIllIIllllI, 1.0f / lllllllllllllllIIIIlIlIllIIllllI);
        this.bindEntityTexture(lllllllllllllllIIIIlIlIllIlIIllI);
        GlStateManager.scale(-1.0f, -1.0f, 1.0f);
        this.modelBoat.render(lllllllllllllllIIIIlIlIllIlIIllI, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GlStateManager.popMatrix();
        super.doRender(lllllllllllllllIIIIlIlIllIlIIllI, lllllllllllllllIIIIlIlIllIlIIlIl, lllllllllllllllIIIIlIlIllIIllIlI, lllllllllllllllIIIIlIlIllIlIIIll, lllllllllllllllIIIIlIlIllIlIIIlI, lllllllllllllllIIIIlIlIllIIlIlll);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity lllllllllllllllIIIIlIlIllIIIlllI) {
        return this.func_180553_a((EntityBoat)lllllllllllllllIIIIlIlIllIIIlllI);
    }
    
    public RenderBoat(final RenderManager lllllllllllllllIIIIlIlIllIllIIlI) {
        super(lllllllllllllllIIIIlIlIllIllIIlI);
        this.modelBoat = new ModelBoat();
        this.shadowSize = 0.5f;
    }
    
    @Override
    public void doRender(final Entity lllllllllllllllIIIIlIlIlIlllllII, final double lllllllllllllllIIIIlIlIllIIIIIlI, final double lllllllllllllllIIIIlIlIlIllllIlI, final double lllllllllllllllIIIIlIlIlIllllIIl, final float lllllllllllllllIIIIlIlIlIllllIII, final float lllllllllllllllIIIIlIlIlIllllllI) {
        this.func_180552_a((EntityBoat)lllllllllllllllIIIIlIlIlIlllllII, lllllllllllllllIIIIlIlIllIIIIIlI, lllllllllllllllIIIIlIlIlIllllIlI, lllllllllllllllIIIIlIlIlIllllIIl, lllllllllllllllIIIIlIlIlIllllIII, lllllllllllllllIIIIlIlIlIllllllI);
    }
    
    static {
        __OBFID = "CL_00000981";
        boatTextures = new ResourceLocation("textures/entity/boat.png");
    }
}
