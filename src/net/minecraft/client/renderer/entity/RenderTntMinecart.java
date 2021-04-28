package net.minecraft.client.renderer.entity;

import net.minecraft.block.state.*;
import net.minecraft.entity.item.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.init.*;
import net.minecraft.client.renderer.*;

public class RenderTntMinecart extends RenderMinecart
{
    static {
        __OBFID = "CL_00001029";
    }
    
    @Override
    protected void func_180560_a(final EntityMinecart llllllllllllllllIlIlIIlIIlIIlIll, final float llllllllllllllllIlIlIIlIIlIIlIlI, final IBlockState llllllllllllllllIlIlIIlIIlIIIlIl) {
        this.func_180561_a((EntityMinecartTNT)llllllllllllllllIlIlIIlIIlIIlIll, llllllllllllllllIlIlIIlIIlIIlIlI, llllllllllllllllIlIlIIlIIlIIIlIl);
    }
    
    protected void func_180561_a(final EntityMinecartTNT llllllllllllllllIlIlIIlIIlIllllI, final float llllllllllllllllIlIlIIlIIlIlIlIl, final IBlockState llllllllllllllllIlIlIIlIIlIlIlII) {
        final int llllllllllllllllIlIlIIlIIlIllIll = llllllllllllllllIlIlIIlIIlIllllI.func_94104_d();
        if (llllllllllllllllIlIlIIlIIlIllIll > -1 && llllllllllllllllIlIlIIlIIlIllIll - llllllllllllllllIlIlIIlIIlIlIlIl + 1.0f < 10.0f) {
            float llllllllllllllllIlIlIIlIIlIllIlI = 1.0f - (llllllllllllllllIlIlIIlIIlIllIll - llllllllllllllllIlIlIIlIIlIlIlIl + 1.0f) / 10.0f;
            llllllllllllllllIlIlIIlIIlIllIlI = MathHelper.clamp_float(llllllllllllllllIlIlIIlIIlIllIlI, 0.0f, 1.0f);
            llllllllllllllllIlIlIIlIIlIllIlI *= llllllllllllllllIlIlIIlIIlIllIlI;
            llllllllllllllllIlIlIIlIIlIllIlI *= llllllllllllllllIlIlIIlIIlIllIlI;
            final float llllllllllllllllIlIlIIlIIlIllIIl = 1.0f + llllllllllllllllIlIlIIlIIlIllIlI * 0.3f;
            GlStateManager.scale(llllllllllllllllIlIlIIlIIlIllIIl, llllllllllllllllIlIlIIlIIlIllIIl, llllllllllllllllIlIlIIlIIlIllIIl);
        }
        super.func_180560_a(llllllllllllllllIlIlIIlIIlIllllI, llllllllllllllllIlIlIIlIIlIlIlIl, llllllllllllllllIlIlIIlIIlIlIlII);
        if (llllllllllllllllIlIlIIlIIlIllIll > -1 && llllllllllllllllIlIlIIlIIlIllIll / 5 % 2 == 0) {
            final BlockRendererDispatcher llllllllllllllllIlIlIIlIIlIllIII = Minecraft.getMinecraft().getBlockRendererDispatcher();
            GlStateManager.func_179090_x();
            GlStateManager.disableLighting();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 772);
            GlStateManager.color(1.0f, 1.0f, 1.0f, (1.0f - (llllllllllllllllIlIlIIlIIlIllIll - llllllllllllllllIlIlIIlIIlIlIlIl + 1.0f) / 100.0f) * 0.8f);
            GlStateManager.pushMatrix();
            llllllllllllllllIlIlIIlIIlIllIII.func_175016_a(Blocks.tnt.getDefaultState(), 1.0f);
            GlStateManager.popMatrix();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.disableBlend();
            GlStateManager.enableLighting();
            GlStateManager.func_179098_w();
        }
    }
    
    public RenderTntMinecart(final RenderManager llllllllllllllllIlIlIIlIIllIIlll) {
        super(llllllllllllllllIlIlIIlIIllIIlll);
    }
}
