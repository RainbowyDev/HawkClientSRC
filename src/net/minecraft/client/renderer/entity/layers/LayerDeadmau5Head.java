package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class LayerDeadmau5Head implements LayerRenderer
{
    private final /* synthetic */ RenderPlayer field_177208_a;
    
    public void func_177207_a(final AbstractClientPlayer lllllllllllllllIlIIIIIlIIllIIIII, final float lllllllllllllllIlIIIIIlIIlIlllll, final float lllllllllllllllIlIIIIIlIIlIllllI, final float lllllllllllllllIlIIIIIlIIlIlIIlI, final float lllllllllllllllIlIIIIIlIIlIlllII, final float lllllllllllllllIlIIIIIlIIlIllIll, final float lllllllllllllllIlIIIIIlIIlIllIlI, final float lllllllllllllllIlIIIIIlIIlIllIIl) {
        if (lllllllllllllllIlIIIIIlIIllIIIII.getName().equals("deadmau5") && lllllllllllllllIlIIIIIlIIllIIIII.hasSkin() && !lllllllllllllllIlIIIIIlIIllIIIII.isInvisible()) {
            this.field_177208_a.bindTexture(lllllllllllllllIlIIIIIlIIllIIIII.getLocationSkin());
            for (int lllllllllllllllIlIIIIIlIIlIllIII = 0; lllllllllllllllIlIIIIIlIIlIllIII < 2; ++lllllllllllllllIlIIIIIlIIlIllIII) {
                final float lllllllllllllllIlIIIIIlIIlIlIlll = lllllllllllllllIlIIIIIlIIllIIIII.prevRotationYaw + (lllllllllllllllIlIIIIIlIIllIIIII.rotationYaw - lllllllllllllllIlIIIIIlIIllIIIII.prevRotationYaw) * lllllllllllllllIlIIIIIlIIlIlIIlI - (lllllllllllllllIlIIIIIlIIllIIIII.prevRenderYawOffset + (lllllllllllllllIlIIIIIlIIllIIIII.renderYawOffset - lllllllllllllllIlIIIIIlIIllIIIII.prevRenderYawOffset) * lllllllllllllllIlIIIIIlIIlIlIIlI);
                final float lllllllllllllllIlIIIIIlIIlIlIllI = lllllllllllllllIlIIIIIlIIllIIIII.prevRotationPitch + (lllllllllllllllIlIIIIIlIIllIIIII.rotationPitch - lllllllllllllllIlIIIIIlIIllIIIII.prevRotationPitch) * lllllllllllllllIlIIIIIlIIlIlIIlI;
                GlStateManager.pushMatrix();
                GlStateManager.rotate(lllllllllllllllIlIIIIIlIIlIlIlll, 0.0f, 1.0f, 0.0f);
                GlStateManager.rotate(lllllllllllllllIlIIIIIlIIlIlIllI, 1.0f, 0.0f, 0.0f);
                GlStateManager.translate(0.375f * (lllllllllllllllIlIIIIIlIIlIllIII * 2 - 1), 0.0f, 0.0f);
                GlStateManager.translate(0.0f, -0.375f, 0.0f);
                GlStateManager.rotate(-lllllllllllllllIlIIIIIlIIlIlIllI, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(-lllllllllllllllIlIIIIIlIIlIlIlll, 0.0f, 1.0f, 0.0f);
                final float lllllllllllllllIlIIIIIlIIlIlIlIl = 1.3333334f;
                GlStateManager.scale(lllllllllllllllIlIIIIIlIIlIlIlIl, lllllllllllllllIlIIIIIlIIlIlIlIl, lllllllllllllllIlIIIIIlIIlIlIlIl);
                this.field_177208_a.func_177136_g().func_178727_b(0.0625f);
                GlStateManager.popMatrix();
            }
        }
    }
    
    static {
        __OBFID = "CL_00002421";
    }
    
    @Override
    public void doRenderLayer(final EntityLivingBase lllllllllllllllIlIIIIIlIIIlllIIl, final float lllllllllllllllIlIIIIIlIIlIIIIIl, final float lllllllllllllllIlIIIIIlIIlIIIIII, final float lllllllllllllllIlIIIIIlIIIllIllI, final float lllllllllllllllIlIIIIIlIIIllIlIl, final float lllllllllllllllIlIIIIIlIIIllllIl, final float lllllllllllllllIlIIIIIlIIIllIIll, final float lllllllllllllllIlIIIIIlIIIllIIlI) {
        this.func_177207_a((AbstractClientPlayer)lllllllllllllllIlIIIIIlIIIlllIIl, lllllllllllllllIlIIIIIlIIlIIIIIl, lllllllllllllllIlIIIIIlIIlIIIIII, lllllllllllllllIlIIIIIlIIIllIllI, lllllllllllllllIlIIIIIlIIIllIlIl, lllllllllllllllIlIIIIIlIIIllllIl, lllllllllllllllIlIIIIIlIIIllIIll, lllllllllllllllIlIIIIIlIIIllIIlI);
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
    
    public LayerDeadmau5Head(final RenderPlayer lllllllllllllllIlIIIIIlIIllIlIll) {
        this.field_177208_a = lllllllllllllllIlIIIIIlIIllIlIll;
    }
}
