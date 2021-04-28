package net.minecraft.client.renderer.entity.layers;

import net.minecraft.util.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.boss.*;
import net.minecraft.client.renderer.*;
import optifine.*;
import shadersmod.client.*;
import net.minecraft.entity.*;

public class LayerEnderDragonEyes implements LayerRenderer
{
    private static final /* synthetic */ ResourceLocation TEXTURE;
    private final /* synthetic */ RenderDragon dragonRenderer;
    
    public void func_177210_a(final EntityDragon llllllllllllllllIllIlIIIIIIlIIII, final float llllllllllllllllIllIlIIIIIIllIll, final float llllllllllllllllIllIlIIIIIIIlllI, final float llllllllllllllllIllIlIIIIIIllIIl, final float llllllllllllllllIllIlIIIIIIIllII, final float llllllllllllllllIllIlIIIIIIIlIll, final float llllllllllllllllIllIlIIIIIIIlIlI, final float llllllllllllllllIllIlIIIIIIlIlIl) {
        this.dragonRenderer.bindTexture(LayerEnderDragonEyes.TEXTURE);
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.blendFunc(1, 1);
        GlStateManager.disableLighting();
        GlStateManager.depthFunc(514);
        final char llllllllllllllllIllIlIIIIIIlIlII = '\uf0f0';
        final int llllllllllllllllIllIlIIIIIIlIIll = llllllllllllllllIllIlIIIIIIlIlII % 65536;
        final int llllllllllllllllIllIlIIIIIIlIIlI = llllllllllllllllIllIlIIIIIIlIlII / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, llllllllllllllllIllIlIIIIIIlIIll / 1.0f, llllllllllllllllIllIlIIIIIIlIIlI / 1.0f);
        GlStateManager.enableLighting();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        if (Config.isShaders()) {
            Shaders.beginSpiderEyes();
        }
        this.dragonRenderer.getMainModel().render(llllllllllllllllIllIlIIIIIIlIIII, llllllllllllllllIllIlIIIIIIllIll, llllllllllllllllIllIlIIIIIIIlllI, llllllllllllllllIllIlIIIIIIIllII, llllllllllllllllIllIlIIIIIIIlIll, llllllllllllllllIllIlIIIIIIIlIlI, llllllllllllllllIllIlIIIIIIlIlIl);
        this.dragonRenderer.func_177105_a(llllllllllllllllIllIlIIIIIIlIIII, llllllllllllllllIllIlIIIIIIllIIl);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.depthFunc(515);
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    public LayerEnderDragonEyes(final RenderDragon llllllllllllllllIllIlIIIIIlIlIlI) {
        this.dragonRenderer = llllllllllllllllIllIlIIIIIlIlIlI;
    }
    
    static {
        __OBFID = "CL_00002419";
        TEXTURE = new ResourceLocation("textures/entity/enderdragon/dragon_eyes.png");
    }
    
    @Override
    public void doRenderLayer(final EntityLivingBase llllllllllllllllIllIIlllllllIIIl, final float llllllllllllllllIllIIlllllllIIII, final float llllllllllllllllIllIIllllllllIII, final float llllllllllllllllIllIIllllllIlllI, final float llllllllllllllllIllIIlllllllIllI, final float llllllllllllllllIllIIllllllIllII, final float llllllllllllllllIllIIllllllIlIll, final float llllllllllllllllIllIIlllllllIIll) {
        this.func_177210_a((EntityDragon)llllllllllllllllIllIIlllllllIIIl, llllllllllllllllIllIIlllllllIIII, llllllllllllllllIllIIllllllllIII, llllllllllllllllIllIIllllllIlllI, llllllllllllllllIllIIlllllllIllI, llllllllllllllllIllIIllllllIllII, llllllllllllllllIllIIllllllIlIll, llllllllllllllllIllIIlllllllIIll);
    }
}
