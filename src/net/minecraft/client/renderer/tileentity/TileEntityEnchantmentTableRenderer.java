package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.model.*;
import net.minecraft.tileentity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class TileEntityEnchantmentTableRenderer extends TileEntitySpecialRenderer
{
    private static final /* synthetic */ ResourceLocation field_147540_b;
    private /* synthetic */ ModelBook field_147541_c;
    
    @Override
    public void renderTileEntityAt(final TileEntity llllllllllllllIIlllIlIlIlIlIIIll, final double llllllllllllllIIlllIlIlIlIlIlIIl, final double llllllllllllllIIlllIlIlIlIlIIIIl, final double llllllllllllllIIlllIlIlIlIlIIIII, final float llllllllllllllIIlllIlIlIlIIlllll, final int llllllllllllllIIlllIlIlIlIlIIlIl) {
        this.func_180537_a((TileEntityEnchantmentTable)llllllllllllllIIlllIlIlIlIlIIIll, llllllllllllllIIlllIlIlIlIlIlIIl, llllllllllllllIIlllIlIlIlIlIIIIl, llllllllllllllIIlllIlIlIlIlIIIII, llllllllllllllIIlllIlIlIlIIlllll, llllllllllllllIIlllIlIlIlIlIIlIl);
    }
    
    public TileEntityEnchantmentTableRenderer() {
        this.field_147541_c = new ModelBook();
    }
    
    public void func_180537_a(final TileEntityEnchantmentTable llllllllllllllIIlllIlIlIllIIlIlI, final double llllllllllllllIIlllIlIlIlIllllII, final double llllllllllllllIIlllIlIlIlIlllIll, final double llllllllllllllIIlllIlIlIlIlllIlI, final float llllllllllllllIIlllIlIlIllIIIllI, final int llllllllllllllIIlllIlIlIllIIIlIl) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)llllllllllllllIIlllIlIlIlIllllII + 0.5f, (float)llllllllllllllIIlllIlIlIlIlllIll + 0.75f, (float)llllllllllllllIIlllIlIlIlIlllIlI + 0.5f);
        final float llllllllllllllIIlllIlIlIllIIIlII = llllllllllllllIIlllIlIlIllIIlIlI.tickCount + llllllllllllllIIlllIlIlIllIIIllI;
        GlStateManager.translate(0.0f, 0.1f + MathHelper.sin(llllllllllllllIIlllIlIlIllIIIlII * 0.1f) * 0.01f, 0.0f);
        float llllllllllllllIIlllIlIlIllIIIIll;
        for (llllllllllllllIIlllIlIlIllIIIIll = llllllllllllllIIlllIlIlIllIIlIlI.bookRotation - llllllllllllllIIlllIlIlIllIIlIlI.bookRotationPrev; llllllllllllllIIlllIlIlIllIIIIll >= 3.1415927f; llllllllllllllIIlllIlIlIllIIIIll -= 6.2831855f) {}
        while (llllllllllllllIIlllIlIlIllIIIIll < -3.1415927f) {
            llllllllllllllIIlllIlIlIllIIIIll += 6.2831855f;
        }
        final float llllllllllllllIIlllIlIlIllIIIIlI = llllllllllllllIIlllIlIlIllIIlIlI.bookRotationPrev + llllllllllllllIIlllIlIlIllIIIIll * llllllllllllllIIlllIlIlIllIIIllI;
        GlStateManager.rotate(-llllllllllllllIIlllIlIlIllIIIIlI * 180.0f / 3.1415927f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(80.0f, 0.0f, 0.0f, 1.0f);
        this.bindTexture(TileEntityEnchantmentTableRenderer.field_147540_b);
        float llllllllllllllIIlllIlIlIllIIIIIl = llllllllllllllIIlllIlIlIllIIlIlI.pageFlipPrev + (llllllllllllllIIlllIlIlIllIIlIlI.pageFlip - llllllllllllllIIlllIlIlIllIIlIlI.pageFlipPrev) * llllllllllllllIIlllIlIlIllIIIllI + 0.25f;
        float llllllllllllllIIlllIlIlIllIIIIII = llllllllllllllIIlllIlIlIllIIlIlI.pageFlipPrev + (llllllllllllllIIlllIlIlIllIIlIlI.pageFlip - llllllllllllllIIlllIlIlIllIIlIlI.pageFlipPrev) * llllllllllllllIIlllIlIlIllIIIllI + 0.75f;
        llllllllllllllIIlllIlIlIllIIIIIl = (llllllllllllllIIlllIlIlIllIIIIIl - MathHelper.truncateDoubleToInt(llllllllllllllIIlllIlIlIllIIIIIl)) * 1.6f - 0.3f;
        llllllllllllllIIlllIlIlIllIIIIII = (llllllllllllllIIlllIlIlIllIIIIII - MathHelper.truncateDoubleToInt(llllllllllllllIIlllIlIlIllIIIIII)) * 1.6f - 0.3f;
        if (llllllllllllllIIlllIlIlIllIIIIIl < 0.0f) {
            llllllllllllllIIlllIlIlIllIIIIIl = 0.0f;
        }
        if (llllllllllllllIIlllIlIlIllIIIIII < 0.0f) {
            llllllllllllllIIlllIlIlIllIIIIII = 0.0f;
        }
        if (llllllllllllllIIlllIlIlIllIIIIIl > 1.0f) {
            llllllllllllllIIlllIlIlIllIIIIIl = 1.0f;
        }
        if (llllllllllllllIIlllIlIlIllIIIIII > 1.0f) {
            llllllllllllllIIlllIlIlIllIIIIII = 1.0f;
        }
        final float llllllllllllllIIlllIlIlIlIllllll = llllllllllllllIIlllIlIlIllIIlIlI.bookSpreadPrev + (llllllllllllllIIlllIlIlIllIIlIlI.bookSpread - llllllllllllllIIlllIlIlIllIIlIlI.bookSpreadPrev) * llllllllllllllIIlllIlIlIllIIIllI;
        GlStateManager.enableCull();
        this.field_147541_c.render(null, llllllllllllllIIlllIlIlIllIIIlII, llllllllllllllIIlllIlIlIllIIIIIl, llllllllllllllIIlllIlIlIllIIIIII, llllllllllllllIIlllIlIlIlIllllll, 0.0f, 0.0625f);
        GlStateManager.popMatrix();
    }
    
    static {
        __OBFID = "CL_00002470";
        field_147540_b = new ResourceLocation("textures/entity/enchanting_table_book.png");
    }
}
