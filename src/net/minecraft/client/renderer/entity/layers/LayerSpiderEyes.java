package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.renderer.*;
import optifine.*;
import shadersmod.client.*;
import net.minecraft.entity.*;

public class LayerSpiderEyes implements LayerRenderer
{
    private final /* synthetic */ RenderSpider field_177149_b;
    private static final /* synthetic */ ResourceLocation field_177150_a;
    
    static {
        __OBFID = "CL_00002410";
        field_177150_a = new ResourceLocation("textures/entity/spider_eyes.png");
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    public LayerSpiderEyes(final RenderSpider llllllllllllllllIIllIlllIllllllI) {
        this.field_177149_b = llllllllllllllllIIllIlllIllllllI;
    }
    
    public void func_177148_a(final EntitySpider llllllllllllllllIIllIlllIllIIIlI, final float llllllllllllllllIIllIlllIllIIIIl, final float llllllllllllllllIIllIlllIllIllIl, final float llllllllllllllllIIllIlllIlIlllll, final float llllllllllllllllIIllIlllIlIllllI, final float llllllllllllllllIIllIlllIllIlIlI, final float llllllllllllllllIIllIlllIlIlllII, final float llllllllllllllllIIllIlllIlIllIll) {
        this.field_177149_b.bindTexture(LayerSpiderEyes.field_177150_a);
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.blendFunc(1, 1);
        if (llllllllllllllllIIllIlllIllIIIlI.isInvisible()) {
            GlStateManager.depthMask(false);
        }
        else {
            GlStateManager.depthMask(true);
        }
        final char llllllllllllllllIIllIlllIllIIlll = '\uf0f0';
        int llllllllllllllllIIllIlllIllIIllI = llllllllllllllllIIllIlllIllIIlll % 65536;
        int llllllllllllllllIIllIlllIllIIlIl = llllllllllllllllIIllIlllIllIIlll / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, llllllllllllllllIIllIlllIllIIllI / 1.0f, llllllllllllllllIIllIlllIllIIlIl / 1.0f);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        if (Config.isShaders()) {
            Shaders.beginSpiderEyes();
        }
        this.field_177149_b.getMainModel().render(llllllllllllllllIIllIlllIllIIIlI, llllllllllllllllIIllIlllIllIIIIl, llllllllllllllllIIllIlllIllIllIl, llllllllllllllllIIllIlllIlIllllI, llllllllllllllllIIllIlllIllIlIlI, llllllllllllllllIIllIlllIlIlllII, llllllllllllllllIIllIlllIlIllIll);
        final int llllllllllllllllIIllIlllIllIIlII = llllllllllllllllIIllIlllIllIIIlI.getBrightnessForRender(llllllllllllllllIIllIlllIlIlllll);
        llllllllllllllllIIllIlllIllIIllI = llllllllllllllllIIllIlllIllIIlII % 65536;
        llllllllllllllllIIllIlllIllIIlIl = llllllllllllllllIIllIlllIllIIlII / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, llllllllllllllllIIllIlllIllIIllI / 1.0f, llllllllllllllllIIllIlllIllIIlIl / 1.0f);
        this.field_177149_b.func_177105_a(llllllllllllllllIIllIlllIllIIIlI, llllllllllllllllIIllIlllIlIlllll);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
    }
    
    @Override
    public void doRenderLayer(final EntityLivingBase llllllllllllllllIIllIlllIlIIlIll, final float llllllllllllllllIIllIlllIlIIlIlI, final float llllllllllllllllIIllIlllIlIIIIII, final float llllllllllllllllIIllIlllIlIIlIII, final float llllllllllllllllIIllIlllIlIIIlll, final float llllllllllllllllIIllIlllIlIIIllI, final float llllllllllllllllIIllIlllIIllllII, final float llllllllllllllllIIllIlllIlIIIlII) {
        this.func_177148_a((EntitySpider)llllllllllllllllIIllIlllIlIIlIll, llllllllllllllllIIllIlllIlIIlIlI, llllllllllllllllIIllIlllIlIIIIII, llllllllllllllllIIllIlllIlIIlIII, llllllllllllllllIIllIlllIlIIIlll, llllllllllllllllIIllIlllIlIIIllI, llllllllllllllllIIllIlllIIllllII, llllllllllllllllIIllIlllIlIIIlII);
    }
}
