package net.minecraft.client.gui;

import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;

public class GuiStreamIndicator
{
    private /* synthetic */ float field_152443_c;
    private static final /* synthetic */ ResourceLocation locationStreamIndicator;
    private final /* synthetic */ Minecraft mc;
    private /* synthetic */ int field_152444_d;
    
    private int func_152440_b() {
        return this.mc.getTwitchStream().isPaused() ? 16 : 0;
    }
    
    public GuiStreamIndicator(final Minecraft llllllllllllllllIlllIIllIllIlIII) {
        this.field_152443_c = 1.0f;
        this.field_152444_d = 1;
        this.mc = llllllllllllllllIlllIIllIllIlIII;
    }
    
    private void render(final int llllllllllllllllIlllIIllIIIllIII, final int llllllllllllllllIlllIIllIIIIIIlI, final int llllllllllllllllIlllIIllIIIlIlIl, final int llllllllllllllllIlllIIllIIIIIIII) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 0.65f + 0.35000002f * this.field_152443_c);
        this.mc.getTextureManager().bindTexture(GuiStreamIndicator.locationStreamIndicator);
        final float llllllllllllllllIlllIIllIIIlIIIl = 150.0f;
        final float llllllllllllllllIlllIIllIIIIllll = 0.0f;
        final float llllllllllllllllIlllIIllIIIIllIl = llllllllllllllllIlllIIllIIIlIlIl * 0.015625f;
        final float llllllllllllllllIlllIIllIIIIlIll = 1.0f;
        final float llllllllllllllllIlllIIllIIIIlIIl = (llllllllllllllllIlllIIllIIIlIlIl + 16) * 0.015625f;
        final Tessellator llllllllllllllllIlllIIllIIIIIlll = Tessellator.getInstance();
        final WorldRenderer llllllllllllllllIlllIIllIIIIIlIl = llllllllllllllllIlllIIllIIIIIlll.getWorldRenderer();
        llllllllllllllllIlllIIllIIIIIlIl.startDrawingQuads();
        llllllllllllllllIlllIIllIIIIIlIl.addVertexWithUV(llllllllllllllllIlllIIllIIIllIII - 16 - llllllllllllllllIlllIIllIIIIIIII, llllllllllllllllIlllIIllIIIIIIlI + 16, llllllllllllllllIlllIIllIIIlIIIl, llllllllllllllllIlllIIllIIIIllll, llllllllllllllllIlllIIllIIIIlIIl);
        llllllllllllllllIlllIIllIIIIIlIl.addVertexWithUV(llllllllllllllllIlllIIllIIIllIII - llllllllllllllllIlllIIllIIIIIIII, llllllllllllllllIlllIIllIIIIIIlI + 16, llllllllllllllllIlllIIllIIIlIIIl, llllllllllllllllIlllIIllIIIIlIll, llllllllllllllllIlllIIllIIIIlIIl);
        llllllllllllllllIlllIIllIIIIIlIl.addVertexWithUV(llllllllllllllllIlllIIllIIIllIII - llllllllllllllllIlllIIllIIIIIIII, llllllllllllllllIlllIIllIIIIIIlI + 0, llllllllllllllllIlllIIllIIIlIIIl, llllllllllllllllIlllIIllIIIIlIll, llllllllllllllllIlllIIllIIIIllIl);
        llllllllllllllllIlllIIllIIIIIlIl.addVertexWithUV(llllllllllllllllIlllIIllIIIllIII - 16 - llllllllllllllllIlllIIllIIIIIIII, llllllllllllllllIlllIIllIIIIIIlI + 0, llllllllllllllllIlllIIllIIIlIIIl, llllllllllllllllIlllIIllIIIIllll, llllllllllllllllIlllIIllIIIIllIl);
        llllllllllllllllIlllIIllIIIIIlll.draw();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    private int func_152438_c() {
        return this.mc.getTwitchStream().func_152929_G() ? 48 : 32;
    }
    
    public void render(final int llllllllllllllllIlllIIllIlIIIIII, final int llllllllllllllllIlllIIllIIllIIll) {
        if (this.mc.getTwitchStream().func_152934_n()) {
            GlStateManager.enableBlend();
            final int llllllllllllllllIlllIIllIIlllllI = this.mc.getTwitchStream().func_152920_A();
            if (llllllllllllllllIlllIIllIIlllllI > 0) {
                final String llllllllllllllllIlllIIllIIllllIl = String.valueOf(new StringBuilder().append(llllllllllllllllIlllIIllIIlllllI));
                final int llllllllllllllllIlllIIllIIllllII = this.mc.fontRendererObj.getStringWidth(llllllllllllllllIlllIIllIIllllIl);
                final boolean llllllllllllllllIlllIIllIIlllIll = true;
                final int llllllllllllllllIlllIIllIIlllIlI = llllllllllllllllIlllIIllIlIIIIII - llllllllllllllllIlllIIllIIllllII - 1;
                final int llllllllllllllllIlllIIllIIlllIIl = llllllllllllllllIlllIIllIIllIIll + 20 - 1;
                final int llllllllllllllllIlllIIllIIlllIII = llllllllllllllllIlllIIllIIllIIll + 20 + this.mc.fontRendererObj.FONT_HEIGHT - 1;
                GlStateManager.func_179090_x();
                final Tessellator llllllllllllllllIlllIIllIIllIlll = Tessellator.getInstance();
                final WorldRenderer llllllllllllllllIlllIIllIIllIllI = llllllllllllllllIlllIIllIIllIlll.getWorldRenderer();
                GlStateManager.color(0.0f, 0.0f, 0.0f, (0.65f + 0.35000002f * this.field_152443_c) / 2.0f);
                llllllllllllllllIlllIIllIIllIllI.startDrawingQuads();
                llllllllllllllllIlllIIllIIllIllI.addVertex(llllllllllllllllIlllIIllIIlllIlI, llllllllllllllllIlllIIllIIlllIII, 0.0);
                llllllllllllllllIlllIIllIIllIllI.addVertex(llllllllllllllllIlllIIllIlIIIIII, llllllllllllllllIlllIIllIIlllIII, 0.0);
                llllllllllllllllIlllIIllIIllIllI.addVertex(llllllllllllllllIlllIIllIlIIIIII, llllllllllllllllIlllIIllIIlllIIl, 0.0);
                llllllllllllllllIlllIIllIIllIllI.addVertex(llllllllllllllllIlllIIllIIlllIlI, llllllllllllllllIlllIIllIIlllIIl, 0.0);
                llllllllllllllllIlllIIllIIllIlll.draw();
                GlStateManager.func_179098_w();
                this.mc.fontRendererObj.drawString(llllllllllllllllIlllIIllIIllllIl, llllllllllllllllIlllIIllIlIIIIII - llllllllllllllllIlllIIllIIllllII, llllllllllllllllIlllIIllIIllIIll + 20, 16777215);
            }
            this.render(llllllllllllllllIlllIIllIlIIIIII, llllllllllllllllIlllIIllIIllIIll, this.func_152440_b(), 0);
            this.render(llllllllllllllllIlllIIllIlIIIIII, llllllllllllllllIlllIIllIIllIIll, this.func_152438_c(), 17);
        }
    }
    
    public void func_152439_a() {
        if (this.mc.getTwitchStream().func_152934_n()) {
            this.field_152443_c += 0.025f * this.field_152444_d;
            if (this.field_152443_c < 0.0f) {
                this.field_152444_d *= -1;
                this.field_152443_c = 0.0f;
            }
            else if (this.field_152443_c > 1.0f) {
                this.field_152444_d *= -1;
                this.field_152443_c = 1.0f;
            }
        }
        else {
            this.field_152443_c = 1.0f;
            this.field_152444_d = 1;
        }
    }
    
    static {
        __OBFID = "CL_00001849";
        locationStreamIndicator = new ResourceLocation("textures/gui/stream_indicator.png");
    }
}
