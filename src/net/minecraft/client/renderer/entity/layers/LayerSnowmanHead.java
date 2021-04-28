package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.block.model.*;

public class LayerSnowmanHead implements LayerRenderer
{
    private final /* synthetic */ RenderSnowMan field_177152_a;
    
    @Override
    public void doRenderLayer(final EntityLivingBase llllllllllllllIIIlllIIlIIIlIIIII, final float llllllllllllllIIIlllIIlIIIIlllll, final float llllllllllllllIIIlllIIlIIIlIIlll, final float llllllllllllllIIIlllIIlIIIlIIllI, final float llllllllllllllIIIlllIIlIIIIlllII, final float llllllllllllllIIIlllIIlIIIIllIll, final float llllllllllllllIIIlllIIlIIIlIIIll, final float llllllllllllllIIIlllIIlIIIIllIIl) {
        this.func_177151_a((EntitySnowman)llllllllllllllIIIlllIIlIIIlIIIII, llllllllllllllIIIlllIIlIIIIlllll, llllllllllllllIIIlllIIlIIIlIIlll, llllllllllllllIIIlllIIlIIIlIIllI, llllllllllllllIIIlllIIlIIIIlllII, llllllllllllllIIIlllIIlIIIIllIll, llllllllllllllIIIlllIIlIIIlIIIll, llllllllllllllIIIlllIIlIIIIllIIl);
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
    
    static {
        __OBFID = "CL_00002411";
    }
    
    public void func_177151_a(final EntitySnowman llllllllllllllIIIlllIIlIIIllIllI, final float llllllllllllllIIIlllIIlIIIllllll, final float llllllllllllllIIIlllIIlIIIlllllI, final float llllllllllllllIIIlllIIlIIIllllIl, final float llllllllllllllIIIlllIIlIIIllllII, final float llllllllllllllIIIlllIIlIIIlllIll, final float llllllllllllllIIIlllIIlIIIlllIlI, final float llllllllllllllIIIlllIIlIIIlllIIl) {
        if (!llllllllllllllIIIlllIIlIIIllIllI.isInvisible()) {
            GlStateManager.pushMatrix();
            this.field_177152_a.func_177123_g().head.postRender(0.0625f);
            final float llllllllllllllIIIlllIIlIIIlllIII = 0.625f;
            GlStateManager.translate(0.0f, -0.34375f, 0.0f);
            GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
            GlStateManager.scale(llllllllllllllIIIlllIIlIIIlllIII, -llllllllllllllIIIlllIIlIIIlllIII, -llllllllllllllIIIlllIIlIIIlllIII);
            Minecraft.getMinecraft().getItemRenderer().renderItem(llllllllllllllIIIlllIIlIIIllIllI, new ItemStack(Blocks.pumpkin, 1), ItemCameraTransforms.TransformType.HEAD);
            GlStateManager.popMatrix();
        }
    }
    
    public LayerSnowmanHead(final RenderSnowMan llllllllllllllIIIlllIIlIIlIIIlIl) {
        this.field_177152_a = llllllllllllllIIIlllIIlIIlIIIlIl;
    }
}
