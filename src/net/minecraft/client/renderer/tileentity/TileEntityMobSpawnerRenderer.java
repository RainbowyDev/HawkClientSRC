package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.tileentity.*;

public class TileEntityMobSpawnerRenderer extends TileEntitySpecialRenderer
{
    public static void func_147517_a(final MobSpawnerBaseLogic lllllllllllllllIlIIIlIllIlIlIlIl, final double lllllllllllllllIlIIIlIllIlIIllIl, final double lllllllllllllllIlIIIlIllIlIIllII, final double lllllllllllllllIlIIIlIllIlIlIIlI, final float lllllllllllllllIlIIIlIllIlIIlIlI) {
        final Entity lllllllllllllllIlIIIlIllIlIlIIII = lllllllllllllllIlIIIlIllIlIlIlIl.func_180612_a(lllllllllllllllIlIIIlIllIlIlIlIl.getSpawnerWorld());
        if (lllllllllllllllIlIIIlIllIlIlIIII != null) {
            final float lllllllllllllllIlIIIlIllIlIIllll = 0.4375f;
            GlStateManager.translate(0.0f, 0.4f, 0.0f);
            GlStateManager.rotate((float)(lllllllllllllllIlIIIlIllIlIlIlIl.func_177223_e() + (lllllllllllllllIlIIIlIllIlIlIlIl.func_177222_d() - lllllllllllllllIlIIIlIllIlIlIlIl.func_177223_e()) * lllllllllllllllIlIIIlIllIlIIlIlI) * 10.0f, 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(-30.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.translate(0.0f, -0.4f, 0.0f);
            GlStateManager.scale(lllllllllllllllIlIIIlIllIlIIllll, lllllllllllllllIlIIIlIllIlIIllll, lllllllllllllllIlIIIlIllIlIIllll);
            lllllllllllllllIlIIIlIllIlIlIIII.setLocationAndAngles(lllllllllllllllIlIIIlIllIlIIllIl, lllllllllllllllIlIIIlIllIlIIllII, lllllllllllllllIlIIIlIllIlIlIIlI, 0.0f, 0.0f);
            Minecraft.getMinecraft().getRenderManager().renderEntityWithPosYaw(lllllllllllllllIlIIIlIllIlIlIIII, 0.0, 0.0, 0.0, 0.0f, lllllllllllllllIlIIIlIllIlIIlIlI);
        }
    }
    
    public void func_180539_a(final TileEntityMobSpawner lllllllllllllllIlIIIlIllIllIIIIl, final double lllllllllllllllIlIIIlIllIllIIIII, final double lllllllllllllllIlIIIlIllIllIIlIl, final double lllllllllllllllIlIIIlIllIllIIlII, final float lllllllllllllllIlIIIlIllIllIIIll, final int lllllllllllllllIlIIIlIllIllIIIlI) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)lllllllllllllllIlIIIlIllIllIIIII + 0.5f, (float)lllllllllllllllIlIIIlIllIllIIlIl, (float)lllllllllllllllIlIIIlIllIllIIlII + 0.5f);
        func_147517_a(lllllllllllllllIlIIIlIllIllIIIIl.getSpawnerBaseLogic(), lllllllllllllllIlIIIlIllIllIIIII, lllllllllllllllIlIIIlIllIllIIlIl, lllllllllllllllIlIIIlIllIllIIlII, lllllllllllllllIlIIIlIllIllIIIll);
        GlStateManager.popMatrix();
    }
    
    static {
        __OBFID = "CL_00000968";
    }
    
    @Override
    public void renderTileEntityAt(final TileEntity lllllllllllllllIlIIIlIllIIlllIII, final double lllllllllllllllIlIIIlIllIIllIlll, final double lllllllllllllllIlIIIlIllIIllllIl, final double lllllllllllllllIlIIIlIllIIllIlIl, final float lllllllllllllllIlIIIlIllIIlllIll, final int lllllllllllllllIlIIIlIllIIllIIll) {
        this.func_180539_a((TileEntityMobSpawner)lllllllllllllllIlIIIlIllIIlllIII, lllllllllllllllIlIIIlIllIIllIlll, lllllllllllllllIlIIIlIllIIllllIl, lllllllllllllllIlIIIlIllIIllIlIl, lllllllllllllllIlIIIlIllIIlllIll, lllllllllllllllIlIIIlIllIIllIIll);
    }
}
