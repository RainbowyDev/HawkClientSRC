package net.minecraft.client.renderer.entity.layers;

import net.minecraft.util.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.renderer.*;
import optifine.*;
import shadersmod.client.*;
import net.minecraft.entity.*;

public class LayerEndermanEyes implements LayerRenderer
{
    private static final /* synthetic */ ResourceLocation field_177203_a;
    private final /* synthetic */ RenderEnderman field_177202_b;
    
    @Override
    public void doRenderLayer(final EntityLivingBase llllllllllllllIIIIIIIllIIIlIIlIl, final float llllllllllllllIIIIIIIllIIIllIIIl, final float llllllllllllllIIIIIIIllIIIlIIIIl, final float llllllllllllllIIIIIIIllIIIIlllll, final float llllllllllllllIIIIIIIllIIIIlllIl, final float llllllllllllllIIIIIIIllIIIIlllII, final float llllllllllllllIIIIIIIllIIIlIlIlI, final float llllllllllllllIIIIIIIllIIIIllIlI) {
        this.func_177201_a((EntityEnderman)llllllllllllllIIIIIIIllIIIlIIlIl, llllllllllllllIIIIIIIllIIIllIIIl, llllllllllllllIIIIIIIllIIIlIIIIl, llllllllllllllIIIIIIIllIIIIlllll, llllllllllllllIIIIIIIllIIIIlllIl, llllllllllllllIIIIIIIllIIIIlllII, llllllllllllllIIIIIIIllIIIlIlIlI, llllllllllllllIIIIIIIllIIIIllIlI);
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    public LayerEndermanEyes(final RenderEnderman llllllllllllllIIIIIIIllIlIIIIlII) {
        this.field_177202_b = llllllllllllllIIIIIIIllIlIIIIlII;
    }
    
    static {
        __OBFID = "CL_00002418";
        field_177203_a = new ResourceLocation("textures/entity/enderman/enderman_eyes.png");
    }
    
    public void func_177201_a(final EntityEnderman llllllllllllllIIIIIIIllIIllIIIII, final float llllllllllllllIIIIIIIllIIlIllllI, final float llllllllllllllIIIIIIIllIIllIlllI, final float llllllllllllllIIIIIIIllIIlIllIlI, final float llllllllllllllIIIIIIIllIIllIllII, final float llllllllllllllIIIIIIIllIIlIlIllI, final float llllllllllllllIIIIIIIllIIllIlIlI, final float llllllllllllllIIIIIIIllIIllIlIIl) {
        this.field_177202_b.bindTexture(LayerEndermanEyes.field_177203_a);
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.blendFunc(1, 1);
        GlStateManager.disableLighting();
        if (llllllllllllllIIIIIIIllIIllIIIII.isInvisible()) {
            GlStateManager.depthMask(false);
        }
        else {
            GlStateManager.depthMask(true);
        }
        final char llllllllllllllIIIIIIIllIIllIlIII = '\uf0f0';
        final int llllllllllllllIIIIIIIllIIllIIllI = llllllllllllllIIIIIIIllIIllIlIII % 65536;
        final int llllllllllllllIIIIIIIllIIllIIlII = llllllllllllllIIIIIIIllIIllIlIII / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, llllllllllllllIIIIIIIllIIllIIllI / 1.0f, llllllllllllllIIIIIIIllIIllIIlII / 1.0f);
        GlStateManager.enableLighting();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        if (Config.isShaders()) {
            Shaders.beginSpiderEyes();
        }
        this.field_177202_b.getMainModel().render(llllllllllllllIIIIIIIllIIllIIIII, llllllllllllllIIIIIIIllIIlIllllI, llllllllllllllIIIIIIIllIIllIlllI, llllllllllllllIIIIIIIllIIllIllII, llllllllllllllIIIIIIIllIIlIlIllI, llllllllllllllIIIIIIIllIIllIlIlI, llllllllllllllIIIIIIIllIIllIlIIl);
        this.field_177202_b.func_177105_a(llllllllllllllIIIIIIIllIIllIIIII, llllllllllllllIIIIIIIllIIlIllIlI);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
    }
}
