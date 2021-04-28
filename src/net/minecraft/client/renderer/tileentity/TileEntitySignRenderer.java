package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.model.*;
import net.minecraft.client.renderer.*;
import net.minecraft.init.*;
import org.lwjgl.opengl.*;
import optifine.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import net.minecraft.client.gui.*;
import java.util.*;
import net.minecraft.tileentity.*;

public class TileEntitySignRenderer extends TileEntitySpecialRenderer
{
    private static final /* synthetic */ ResourceLocation field_147513_b;
    private final /* synthetic */ ModelSign model;
    
    static {
        field_147513_b = new ResourceLocation("textures/entity/sign.png");
    }
    
    public void func_180541_a(final TileEntitySign lIlllllIlIllll, final double lIlllllIlIlllI, final double lIlllllIlIllIl, final double lIlllllIllllll, final float lIlllllIlllllI, final int lIlllllIllllIl) {
        final Block lIlllllIllllII = lIlllllIlIllll.getBlockType();
        GlStateManager.pushMatrix();
        final float lIlllllIlllIll = 0.6666667f;
        if (lIlllllIllllII == Blocks.standing_sign) {
            GlStateManager.translate((float)lIlllllIlIlllI + 0.5f, (float)lIlllllIlIllIl + 0.75f * lIlllllIlllIll, (float)lIlllllIllllll + 0.5f);
            final float lIlllllIlllIII = lIlllllIlIllll.getBlockMetadata() * 360 / 16.0f;
            GlStateManager.rotate(-lIlllllIlllIII, 0.0f, 1.0f, 0.0f);
            this.model.signStick.showModel = true;
        }
        else {
            final int lIlllllIllIlll = lIlllllIlIllll.getBlockMetadata();
            float lIlllllIlllIlI = 0.0f;
            if (lIlllllIllIlll == 2) {
                lIlllllIlllIlI = 180.0f;
            }
            if (lIlllllIllIlll == 4) {
                lIlllllIlllIlI = 90.0f;
            }
            if (lIlllllIllIlll == 5) {
                lIlllllIlllIlI = -90.0f;
            }
            GlStateManager.translate((float)lIlllllIlIlllI + 0.5f, (float)lIlllllIlIllIl + 0.75f * lIlllllIlllIll, (float)lIlllllIllllll + 0.5f);
            GlStateManager.rotate(-lIlllllIlllIlI, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(0.0f, -0.3125f, -0.4375f);
            this.model.signStick.showModel = false;
        }
        if (lIlllllIllllIl >= 0) {
            this.bindTexture(TileEntitySignRenderer.DESTROY_STAGES[lIlllllIllllIl]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(4.0f, 2.0f, 1.0f);
            GlStateManager.translate(0.0625f, 0.0625f, 0.0625f);
            GlStateManager.matrixMode(5888);
        }
        else {
            this.bindTexture(TileEntitySignRenderer.field_147513_b);
        }
        GlStateManager.enableRescaleNormal();
        GlStateManager.pushMatrix();
        GlStateManager.scale(lIlllllIlllIll, -lIlllllIlllIll, -lIlllllIlllIll);
        this.model.renderSign();
        GlStateManager.popMatrix();
        final FontRenderer lIlllllIllIllI = this.getFontRenderer();
        final float lIlllllIlllIIl = 0.015625f * lIlllllIlllIll;
        GlStateManager.translate(0.0f, 0.5f * lIlllllIlllIll, 0.07f * lIlllllIlllIll);
        GlStateManager.scale(lIlllllIlllIIl, -lIlllllIlllIIl, lIlllllIlllIIl);
        GL11.glNormal3f(0.0f, 0.0f, -1.0f * lIlllllIlllIIl);
        GlStateManager.depthMask(false);
        int lIlllllIllIlIl = 0;
        if (Config.isCustomColors()) {
            lIlllllIllIlIl = CustomColors.getSignTextColor(lIlllllIllIlIl);
        }
        if (lIlllllIllllIl < 0) {
            for (int lIlllllIllIlII = 0; lIlllllIllIlII < lIlllllIlIllll.signText.length; ++lIlllllIllIlII) {
                if (lIlllllIlIllll.signText[lIlllllIllIlII] != null) {
                    final IChatComponent lIlllllIllIIll = lIlllllIlIllll.signText[lIlllllIllIlII];
                    final List lIlllllIllIIlI = GuiUtilRenderComponents.func_178908_a(lIlllllIllIIll, 90, lIlllllIllIllI, false, true);
                    String lIlllllIllIIIl = (lIlllllIllIIlI != null && lIlllllIllIIlI.size() > 0) ? lIlllllIllIIlI.get(0).getFormattedText() : "";
                    if (lIlllllIllIlII == lIlllllIlIllll.lineBeingEdited) {
                        lIlllllIllIIIl = String.valueOf(new StringBuilder("> ").append(lIlllllIllIIIl).append(" <"));
                        lIlllllIllIllI.drawString(lIlllllIllIIIl, -lIlllllIllIllI.getStringWidth(lIlllllIllIIIl) / 2, lIlllllIllIlII * 10 - lIlllllIlIllll.signText.length * 5, lIlllllIllIlIl);
                    }
                    else {
                        lIlllllIllIllI.drawString(lIlllllIllIIIl, -lIlllllIllIllI.getStringWidth(lIlllllIllIIIl) / 2, lIlllllIllIlII * 10 - lIlllllIlIllll.signText.length * 5, lIlllllIllIlIl);
                    }
                }
            }
        }
        GlStateManager.depthMask(true);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.popMatrix();
        if (lIlllllIllllIl >= 0) {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
    }
    
    public TileEntitySignRenderer() {
        this.model = new ModelSign();
    }
    
    @Override
    public void renderTileEntityAt(final TileEntity lIlllllIIlIIlI, final double lIlllllIIlIIIl, final double lIlllllIIlIlll, final double lIlllllIIlIllI, final float lIlllllIIlIlIl, final int lIlllllIIlIlII) {
        this.func_180541_a((TileEntitySign)lIlllllIIlIIlI, lIlllllIIlIIIl, lIlllllIIlIlll, lIlllllIIlIllI, lIlllllIIlIlIl, lIlllllIIlIlII);
    }
}
