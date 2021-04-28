package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.model.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.tileentity.*;

public class TileEntityEnderChestRenderer extends TileEntitySpecialRenderer
{
    private /* synthetic */ ModelChest field_147521_c;
    private static final /* synthetic */ ResourceLocation field_147520_b;
    
    public void func_180540_a(final TileEntityEnderChest llllllllllllllIllIllIlIIIIlllIll, final double llllllllllllllIllIllIlIIIIlllIlI, final double llllllllllllllIllIllIlIIIIlIllll, final double llllllllllllllIllIllIlIIIIlllIII, final float llllllllllllllIllIllIlIIIIllIlll, final int llllllllllllllIllIllIlIIIIlIllII) {
        int llllllllllllllIllIllIlIIIIllIlIl = 0;
        if (llllllllllllllIllIllIlIIIIlllIll.hasWorldObj()) {
            llllllllllllllIllIllIlIIIIllIlIl = llllllllllllllIllIllIlIIIIlllIll.getBlockMetadata();
        }
        if (llllllllllllllIllIllIlIIIIlIllII >= 0) {
            this.bindTexture(TileEntityEnderChestRenderer.DESTROY_STAGES[llllllllllllllIllIllIlIIIIlIllII]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(4.0f, 4.0f, 1.0f);
            GlStateManager.translate(0.0625f, 0.0625f, 0.0625f);
            GlStateManager.matrixMode(5888);
        }
        else {
            this.bindTexture(TileEntityEnderChestRenderer.field_147520_b);
        }
        GlStateManager.pushMatrix();
        GlStateManager.enableRescaleNormal();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.translate((float)llllllllllllllIllIllIlIIIIlllIlI, (float)llllllllllllllIllIllIlIIIIlIllll + 1.0f, (float)llllllllllllllIllIllIlIIIIlllIII + 1.0f);
        GlStateManager.scale(1.0f, -1.0f, -1.0f);
        GlStateManager.translate(0.5f, 0.5f, 0.5f);
        short llllllllllllllIllIllIlIIIIllIlII = 0;
        if (llllllllllllllIllIllIlIIIIllIlIl == 2) {
            llllllllllllllIllIllIlIIIIllIlII = 180;
        }
        if (llllllllllllllIllIllIlIIIIllIlIl == 3) {
            llllllllllllllIllIllIlIIIIllIlII = 0;
        }
        if (llllllllllllllIllIllIlIIIIllIlIl == 4) {
            llllllllllllllIllIllIlIIIIllIlII = 90;
        }
        if (llllllllllllllIllIllIlIIIIllIlIl == 5) {
            llllllllllllllIllIllIlIIIIllIlII = -90;
        }
        GlStateManager.rotate(llllllllllllllIllIllIlIIIIllIlII, 0.0f, 1.0f, 0.0f);
        GlStateManager.translate(-0.5f, -0.5f, -0.5f);
        float llllllllllllllIllIllIlIIIIllIIll = llllllllllllllIllIllIlIIIIlllIll.prevLidAngle + (llllllllllllllIllIllIlIIIIlllIll.field_145972_a - llllllllllllllIllIllIlIIIIlllIll.prevLidAngle) * llllllllllllllIllIllIlIIIIllIlll;
        llllllllllllllIllIllIlIIIIllIIll = 1.0f - llllllllllllllIllIllIlIIIIllIIll;
        llllllllllllllIllIllIlIIIIllIIll = 1.0f - llllllllllllllIllIllIlIIIIllIIll * llllllllllllllIllIllIlIIIIllIIll * llllllllllllllIllIllIlIIIIllIIll;
        this.field_147521_c.chestLid.rotateAngleX = -(llllllllllllllIllIllIlIIIIllIIll * 3.1415927f / 2.0f);
        this.field_147521_c.renderAll();
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        if (llllllllllllllIllIllIlIIIIlIllII >= 0) {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
    }
    
    @Override
    public void renderTileEntityAt(final TileEntity llllllllllllllIllIllIlIIIIlIIIII, final double llllllllllllllIllIllIlIIIIIlllll, final double llllllllllllllIllIllIlIIIIIllllI, final double llllllllllllllIllIllIlIIIIIlllIl, final float llllllllllllllIllIllIlIIIIIlIlIl, final int llllllllllllllIllIllIlIIIIIlIlII) {
        this.func_180540_a((TileEntityEnderChest)llllllllllllllIllIllIlIIIIlIIIII, llllllllllllllIllIllIlIIIIIlllll, llllllllllllllIllIllIlIIIIIllllI, llllllllllllllIllIllIlIIIIIlllIl, llllllllllllllIllIllIlIIIIIlIlIl, llllllllllllllIllIllIlIIIIIlIlII);
    }
    
    public TileEntityEnderChestRenderer() {
        this.field_147521_c = new ModelChest();
    }
    
    static {
        __OBFID = "CL_00000967";
        field_147520_b = new ResourceLocation("textures/entity/chest/ender.png");
    }
}
