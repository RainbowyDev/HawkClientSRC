package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.*;
import net.minecraft.block.material.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.block.state.*;
import net.minecraft.client.renderer.*;

public class LayerHeldBlock implements LayerRenderer
{
    private final /* synthetic */ RenderEnderman field_177174_a;
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    @Override
    public void doRenderLayer(final EntityLivingBase llllllllllllllIIIlIIIIIIlIllIIll, final float llllllllllllllIIIlIIIIIIlIlllIll, final float llllllllllllllIIIlIIIIIIlIllIIIl, final float llllllllllllllIIIlIIIIIIlIllIIII, final float llllllllllllllIIIlIIIIIIlIlIllll, final float llllllllllllllIIIlIIIIIIlIllIlll, final float llllllllllllllIIIlIIIIIIlIllIllI, final float llllllllllllllIIIlIIIIIIlIlIllII) {
        this.func_177173_a((EntityEnderman)llllllllllllllIIIlIIIIIIlIllIIll, llllllllllllllIIIlIIIIIIlIlllIll, llllllllllllllIIIlIIIIIIlIllIIIl, llllllllllllllIIIlIIIIIIlIllIIII, llllllllllllllIIIlIIIIIIlIlIllll, llllllllllllllIIIlIIIIIIlIllIlll, llllllllllllllIIIlIIIIIIlIllIllI, llllllllllllllIIIlIIIIIIlIlIllII);
    }
    
    public LayerHeldBlock(final RenderEnderman llllllllllllllIIIlIIIIIIlllIlIll) {
        this.field_177174_a = llllllllllllllIIIlIIIIIIlllIlIll;
    }
    
    public void func_177173_a(final EntityEnderman llllllllllllllIIIlIIIIIIllIllllI, final float llllllllllllllIIIlIIIIIIllIlllIl, final float llllllllllllllIIIlIIIIIIllIlllII, final float llllllllllllllIIIlIIIIIIllIIlllI, final float llllllllllllllIIIlIIIIIIllIllIlI, final float llllllllllllllIIIlIIIIIIllIllIIl, final float llllllllllllllIIIlIIIIIIllIllIII, final float llllllllllllllIIIlIIIIIIllIlIlll) {
        final IBlockState llllllllllllllIIIlIIIIIIllIlIllI = llllllllllllllIIIlIIIIIIllIllllI.func_175489_ck();
        if (llllllllllllllIIIlIIIIIIllIlIllI.getBlock().getMaterial() != Material.air) {
            final BlockRendererDispatcher llllllllllllllIIIlIIIIIIllIlIlIl = Minecraft.getMinecraft().getBlockRendererDispatcher();
            GlStateManager.enableRescaleNormal();
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, 0.6875f, -0.75f);
            GlStateManager.rotate(20.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.rotate(45.0f, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(0.25f, 0.1875f, 0.25f);
            final float llllllllllllllIIIlIIIIIIllIlIlII = 0.5f;
            GlStateManager.scale(-llllllllllllllIIIlIIIIIIllIlIlII, -llllllllllllllIIIlIIIIIIllIlIlII, llllllllllllllIIIlIIIIIIllIlIlII);
            final int llllllllllllllIIIlIIIIIIllIlIIll = llllllllllllllIIIlIIIIIIllIllllI.getBrightnessForRender(llllllllllllllIIIlIIIIIIllIIlllI);
            final int llllllllllllllIIIlIIIIIIllIlIIlI = llllllllllllllIIIlIIIIIIllIlIIll % 65536;
            final int llllllllllllllIIIlIIIIIIllIlIIIl = llllllllllllllIIIlIIIIIIllIlIIll / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, llllllllllllllIIIlIIIIIIllIlIIlI / 1.0f, llllllllllllllIIIlIIIIIIllIlIIIl / 1.0f);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.field_177174_a.bindTexture(TextureMap.locationBlocksTexture);
            llllllllllllllIIIlIIIIIIllIlIlIl.func_175016_a(llllllllllllllIIIlIIIIIIllIlIllI, 1.0f);
            GlStateManager.popMatrix();
            GlStateManager.disableRescaleNormal();
        }
    }
    
    static {
        __OBFID = "CL_00002424";
    }
}
