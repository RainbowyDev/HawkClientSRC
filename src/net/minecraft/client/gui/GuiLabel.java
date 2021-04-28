package net.minecraft.client.gui;

import java.util.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import com.google.common.collect.*;
import net.minecraft.client.resources.*;

public class GuiLabel extends Gui
{
    private /* synthetic */ int field_146165_q;
    private /* synthetic */ int field_146163_s;
    private /* synthetic */ List field_146173_k;
    public /* synthetic */ int field_146174_h;
    private /* synthetic */ FontRenderer fontRenderer;
    private /* synthetic */ boolean labelBgEnabled;
    public /* synthetic */ boolean visible;
    private /* synthetic */ int field_146169_o;
    protected /* synthetic */ int field_146161_f;
    private /* synthetic */ boolean centered;
    private /* synthetic */ int field_146166_p;
    public /* synthetic */ int field_146162_g;
    public /* synthetic */ int field_175204_i;
    protected /* synthetic */ int field_146167_a;
    private /* synthetic */ int field_146168_n;
    
    protected void drawLabelBackground(final Minecraft llllllllllllllIIIlIIlIIIlIlllIlI, final int llllllllllllllIIIlIIlIIIlIlllIIl, final int llllllllllllllIIIlIIlIIIlIlllIII) {
        if (this.labelBgEnabled) {
            final int llllllllllllllIIIlIIlIIIlIllIlll = this.field_146167_a + this.field_146163_s * 2;
            final int llllllllllllllIIIlIIlIIIlIllIllI = this.field_146161_f + this.field_146163_s * 2;
            final int llllllllllllllIIIlIIlIIIlIllIlIl = this.field_146162_g - this.field_146163_s;
            final int llllllllllllllIIIlIIlIIIlIllIlII = this.field_146174_h - this.field_146163_s;
            Gui.drawRect(llllllllllllllIIIlIIlIIIlIllIlIl, llllllllllllllIIIlIIlIIIlIllIlII, llllllllllllllIIIlIIlIIIlIllIlIl + llllllllllllllIIIlIIlIIIlIllIlll, llllllllllllllIIIlIIlIIIlIllIlII + llllllllllllllIIIlIIlIIIlIllIllI, this.field_146169_o);
            this.drawHorizontalLine(llllllllllllllIIIlIIlIIIlIllIlIl, llllllllllllllIIIlIIlIIIlIllIlIl + llllllllllllllIIIlIIlIIIlIllIlll, llllllllllllllIIIlIIlIIIlIllIlII, this.field_146166_p);
            this.drawHorizontalLine(llllllllllllllIIIlIIlIIIlIllIlIl, llllllllllllllIIIlIIlIIIlIllIlIl + llllllllllllllIIIlIIlIIIlIllIlll, llllllllllllllIIIlIIlIIIlIllIlII + llllllllllllllIIIlIIlIIIlIllIllI, this.field_146165_q);
            this.drawVerticalLine(llllllllllllllIIIlIIlIIIlIllIlIl, llllllllllllllIIIlIIlIIIlIllIlII, llllllllllllllIIIlIIlIIIlIllIlII + llllllllllllllIIIlIIlIIIlIllIllI, this.field_146166_p);
            this.drawVerticalLine(llllllllllllllIIIlIIlIIIlIllIlIl + llllllllllllllIIIlIIlIIIlIllIlll, llllllllllllllIIIlIIlIIIlIllIlII, llllllllllllllIIIlIIlIIIlIllIlII + llllllllllllllIIIlIIlIIIlIllIllI, this.field_146165_q);
        }
    }
    
    public void drawLabel(final Minecraft llllllllllllllIIIlIIlIIIllIIIllI, final int llllllllllllllIIIlIIlIIIllIIIlIl, final int llllllllllllllIIIlIIlIIIllIIlIll) {
        if (this.visible) {
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            this.drawLabelBackground(llllllllllllllIIIlIIlIIIllIIIllI, llllllllllllllIIIlIIlIIIllIIIlIl, llllllllllllllIIIlIIlIIIllIIlIll);
            final int llllllllllllllIIIlIIlIIIllIIlIlI = this.field_146174_h + this.field_146161_f / 2 + this.field_146163_s / 2;
            final int llllllllllllllIIIlIIlIIIllIIlIIl = llllllllllllllIIIlIIlIIIllIIlIlI - this.field_146173_k.size() * 10 / 2;
            for (int llllllllllllllIIIlIIlIIIllIIlIII = 0; llllllllllllllIIIlIIlIIIllIIlIII < this.field_146173_k.size(); ++llllllllllllllIIIlIIlIIIllIIlIII) {
                if (this.centered) {
                    this.drawCenteredString(this.fontRenderer, this.field_146173_k.get(llllllllllllllIIIlIIlIIIllIIlIII), this.field_146162_g + this.field_146167_a / 2, llllllllllllllIIIlIIlIIIllIIlIIl + llllllllllllllIIIlIIlIIIllIIlIII * 10, this.field_146168_n);
                }
                else {
                    this.drawString(this.fontRenderer, this.field_146173_k.get(llllllllllllllIIIlIIlIIIllIIlIII), this.field_146162_g, llllllllllllllIIIlIIlIIIllIIlIIl + llllllllllllllIIIlIIlIIIllIIlIII * 10, this.field_146168_n);
                }
            }
        }
    }
    
    public GuiLabel func_175203_a() {
        this.centered = true;
        return this;
    }
    
    static {
        __OBFID = "CL_00000671";
    }
    
    public GuiLabel(final FontRenderer llllllllllllllIIIlIIlIIIlllIIlIl, final int llllllllllllllIIIlIIlIIIlllIIlII, final int llllllllllllllIIIlIIlIIIlllIlIll, final int llllllllllllllIIIlIIlIIIlllIlIlI, final int llllllllllllllIIIlIIlIIIlllIIIIl, final int llllllllllllllIIIlIIlIIIlllIIIII, final int llllllllllllllIIIlIIlIIIllIlllll) {
        this.field_146167_a = 200;
        this.field_146161_f = 20;
        this.visible = true;
        this.fontRenderer = llllllllllllllIIIlIIlIIIlllIIlIl;
        this.field_175204_i = llllllllllllllIIIlIIlIIIlllIIlII;
        this.field_146162_g = llllllllllllllIIIlIIlIIIlllIlIll;
        this.field_146174_h = llllllllllllllIIIlIIlIIIlllIlIlI;
        this.field_146167_a = llllllllllllllIIIlIIlIIIlllIIIIl;
        this.field_146161_f = llllllllllllllIIIlIIlIIIlllIIIII;
        this.field_146173_k = Lists.newArrayList();
        this.centered = false;
        this.labelBgEnabled = false;
        this.field_146168_n = llllllllllllllIIIlIIlIIIllIlllll;
        this.field_146169_o = -1;
        this.field_146166_p = -1;
        this.field_146165_q = -1;
        this.field_146163_s = 0;
    }
    
    public void func_175202_a(final String llllllllllllllIIIlIIlIIIllIllIIl) {
        this.field_146173_k.add(I18n.format(llllllllllllllIIIlIIlIIIllIllIIl, new Object[0]));
    }
}
