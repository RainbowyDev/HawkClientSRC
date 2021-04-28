package net.minecraft.client.renderer;

import net.minecraft.block.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.item.*;

public class ChestRenderer
{
    static {
        __OBFID = "CL_00002530";
    }
    
    public void func_178175_a(final Block lIllIlIllII, final float lIllIlIlIIl) {
        GlStateManager.color(lIllIlIlIIl, lIllIlIlIIl, lIllIlIlIIl, 1.0f);
        GlStateManager.rotate(90.0f, 0.0f, 1.0f, 0.0f);
        TileEntityRendererChestHelper.instance.renderByItem(new ItemStack(lIllIlIllII));
    }
}
