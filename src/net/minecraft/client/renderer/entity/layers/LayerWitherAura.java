package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.boss.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class LayerWitherAura implements LayerRenderer
{
    private static final /* synthetic */ ResourceLocation field_177217_a;
    private final /* synthetic */ RenderWither field_177215_b;
    private final /* synthetic */ ModelWither field_177216_c;
    
    @Override
    public void doRenderLayer(final EntityLivingBase lllllllllllllllIIIIIIllllIIIlllI, final float lllllllllllllllIIIIIIllllIIIllIl, final float lllllllllllllllIIIIIIllllIIIIIll, final float lllllllllllllllIIIIIIllllIIIlIll, final float lllllllllllllllIIIIIIllllIIIIIIl, final float lllllllllllllllIIIIIIllllIIIlIIl, final float lllllllllllllllIIIIIIlllIlllllll, final float lllllllllllllllIIIIIIllllIIIIlll) {
        this.func_177214_a((EntityWither)lllllllllllllllIIIIIIllllIIIlllI, lllllllllllllllIIIIIIllllIIIllIl, lllllllllllllllIIIIIIllllIIIIIll, lllllllllllllllIIIIIIllllIIIlIll, lllllllllllllllIIIIIIllllIIIIIIl, lllllllllllllllIIIIIIllllIIIlIIl, lllllllllllllllIIIIIIlllIlllllll, lllllllllllllllIIIIIIllllIIIIlll);
    }
    
    public void func_177214_a(final EntityWither lllllllllllllllIIIIIIllllIlIIlIl, final float lllllllllllllllIIIIIIllllIlIIlII, final float lllllllllllllllIIIIIIllllIllIIII, final float lllllllllllllllIIIIIIllllIlIIIlI, final float lllllllllllllllIIIIIIllllIlIIIIl, final float lllllllllllllllIIIIIIllllIlIllIl, final float lllllllllllllllIIIIIIllllIlIllII, final float lllllllllllllllIIIIIIllllIIllllI) {
        if (lllllllllllllllIIIIIIllllIlIIlIl.isArmored()) {
            GlStateManager.depthMask(!lllllllllllllllIIIIIIllllIlIIlIl.isInvisible());
            this.field_177215_b.bindTexture(LayerWitherAura.field_177217_a);
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            final float lllllllllllllllIIIIIIllllIlIlIlI = lllllllllllllllIIIIIIllllIlIIlIl.ticksExisted + lllllllllllllllIIIIIIllllIlIIIlI;
            final float lllllllllllllllIIIIIIllllIlIlIIl = MathHelper.cos(lllllllllllllllIIIIIIllllIlIlIlI * 0.02f) * 3.0f;
            final float lllllllllllllllIIIIIIllllIlIlIII = lllllllllllllllIIIIIIllllIlIlIlI * 0.01f;
            GlStateManager.translate(lllllllllllllllIIIIIIllllIlIlIIl, lllllllllllllllIIIIIIllllIlIlIII, 0.0f);
            GlStateManager.matrixMode(5888);
            GlStateManager.enableBlend();
            final float lllllllllllllllIIIIIIllllIlIIlll = 0.5f;
            GlStateManager.color(lllllllllllllllIIIIIIllllIlIIlll, lllllllllllllllIIIIIIllllIlIIlll, lllllllllllllllIIIIIIllllIlIIlll, 1.0f);
            GlStateManager.disableLighting();
            GlStateManager.blendFunc(1, 1);
            this.field_177216_c.setLivingAnimations(lllllllllllllllIIIIIIllllIlIIlIl, lllllllllllllllIIIIIIllllIlIIlII, lllllllllllllllIIIIIIllllIllIIII, lllllllllllllllIIIIIIllllIlIIIlI);
            this.field_177216_c.setModelAttributes(this.field_177215_b.getMainModel());
            this.field_177216_c.render(lllllllllllllllIIIIIIllllIlIIlIl, lllllllllllllllIIIIIIllllIlIIlII, lllllllllllllllIIIIIIllllIllIIII, lllllllllllllllIIIIIIllllIlIIIIl, lllllllllllllllIIIIIIllllIlIllIl, lllllllllllllllIIIIIIllllIlIllII, lllllllllllllllIIIIIIllllIIllllI);
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            GlStateManager.matrixMode(5888);
            GlStateManager.enableLighting();
            GlStateManager.disableBlend();
        }
    }
    
    static {
        __OBFID = "CL_00002406";
        field_177217_a = new ResourceLocation("textures/entity/wither/wither_armor.png");
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    public LayerWitherAura(final RenderWither lllllllllllllllIIIIIIlllllIIIIll) {
        this.field_177216_c = new ModelWither(0.5f);
        this.field_177215_b = lllllllllllllllIIIIIIlllllIIIIll;
    }
}
