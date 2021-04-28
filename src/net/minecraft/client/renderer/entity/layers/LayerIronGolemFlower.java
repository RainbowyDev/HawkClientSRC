package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.init.*;
import net.minecraft.client.renderer.*;

public class LayerIronGolemFlower implements LayerRenderer
{
    private final /* synthetic */ RenderIronGolem field_177154_a;
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    static {
        __OBFID = "CL_00002408";
    }
    
    @Override
    public void doRenderLayer(final EntityLivingBase llllllllllllllIlIIlIllIIlIIlIIll, final float llllllllllllllIlIIlIllIIlIIIlIIl, final float llllllllllllllIlIIlIllIIlIIIlIII, final float llllllllllllllIlIIlIllIIlIIIIlll, final float llllllllllllllIlIIlIllIIlIIIllll, final float llllllllllllllIlIIlIllIIlIIIIlIl, final float llllllllllllllIlIIlIllIIlIIIllIl, final float llllllllllllllIlIIlIllIIlIIIllII) {
        this.func_177153_a((EntityIronGolem)llllllllllllllIlIIlIllIIlIIlIIll, llllllllllllllIlIIlIllIIlIIIlIIl, llllllllllllllIlIIlIllIIlIIIlIII, llllllllllllllIlIIlIllIIlIIIIlll, llllllllllllllIlIIlIllIIlIIIllll, llllllllllllllIlIIlIllIIlIIIIlIl, llllllllllllllIlIIlIllIIlIIIllIl, llllllllllllllIlIIlIllIIlIIIllII);
    }
    
    public LayerIronGolemFlower(final RenderIronGolem llllllllllllllIlIIlIllIIlIllllll) {
        this.field_177154_a = llllllllllllllIlIIlIllIIlIllllll;
    }
    
    public void func_177153_a(final EntityIronGolem llllllllllllllIlIIlIllIIlIllIIll, final float llllllllllllllIlIIlIllIIlIllIIlI, final float llllllllllllllIlIIlIllIIlIllIIIl, final float llllllllllllllIlIIlIllIIlIlIIlII, final float llllllllllllllIlIIlIllIIlIlIllll, final float llllllllllllllIlIIlIllIIlIlIlllI, final float llllllllllllllIlIIlIllIIlIlIllIl, final float llllllllllllllIlIIlIllIIlIlIllII) {
        if (llllllllllllllIlIIlIllIIlIllIIll.getHoldRoseTick() != 0) {
            final BlockRendererDispatcher llllllllllllllIlIIlIllIIlIlIlIll = Minecraft.getMinecraft().getBlockRendererDispatcher();
            GlStateManager.enableRescaleNormal();
            GlStateManager.pushMatrix();
            GlStateManager.rotate(5.0f + 180.0f * ((ModelIronGolem)this.field_177154_a.getMainModel()).ironGolemRightArm.rotateAngleX / 3.1415927f, 1.0f, 0.0f, 0.0f);
            GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.translate(-0.9375f, -0.625f, -0.9375f);
            final float llllllllllllllIlIIlIllIIlIlIlIlI = 0.5f;
            GlStateManager.scale(llllllllllllllIlIIlIllIIlIlIlIlI, -llllllllllllllIlIIlIllIIlIlIlIlI, llllllllllllllIlIIlIllIIlIlIlIlI);
            final int llllllllllllllIlIIlIllIIlIlIlIIl = llllllllllllllIlIIlIllIIlIllIIll.getBrightnessForRender(llllllllllllllIlIIlIllIIlIlIIlII);
            final int llllllllllllllIlIIlIllIIlIlIlIII = llllllllllllllIlIIlIllIIlIlIlIIl % 65536;
            final int llllllllllllllIlIIlIllIIlIlIIlll = llllllllllllllIlIIlIllIIlIlIlIIl / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, llllllllllllllIlIIlIllIIlIlIlIII / 1.0f, llllllllllllllIlIIlIllIIlIlIIlll / 1.0f);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.field_177154_a.bindTexture(TextureMap.locationBlocksTexture);
            llllllllllllllIlIIlIllIIlIlIlIll.func_175016_a(Blocks.red_flower.getDefaultState(), 1.0f);
            GlStateManager.popMatrix();
            GlStateManager.disableRescaleNormal();
        }
    }
}
