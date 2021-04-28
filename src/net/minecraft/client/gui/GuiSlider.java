package net.minecraft.client.gui;

import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.resources.*;

public class GuiSlider extends GuiButton
{
    private /* synthetic */ FormatHelper field_175222_u;
    private /* synthetic */ float field_175227_p;
    private /* synthetic */ String field_175226_q;
    private final /* synthetic */ float field_175224_s;
    public /* synthetic */ boolean field_175228_o;
    private final /* synthetic */ float field_175225_r;
    private final /* synthetic */ GuiPageButtonList.GuiResponder field_175223_t;
    
    public float func_175217_d() {
        return this.field_175227_p;
    }
    
    @Override
    public boolean mousePressed(final Minecraft lIIIIIlIllIIlll, final int lIIIIIlIllIlIlI, final int lIIIIIlIllIlIIl) {
        if (super.mousePressed(lIIIIIlIllIIlll, lIIIIIlIllIlIlI, lIIIIIlIllIlIIl)) {
            this.field_175227_p = (lIIIIIlIllIlIlI - (this.xPosition + 4)) / (float)(this.width - 8);
            if (this.field_175227_p < 0.0f) {
                this.field_175227_p = 0.0f;
            }
            if (this.field_175227_p > 1.0f) {
                this.field_175227_p = 1.0f;
            }
            this.displayString = this.func_175221_e();
            this.field_175223_t.func_175320_a(this.id, this.func_175220_c());
            this.field_175228_o = true;
            return true;
        }
        return false;
    }
    
    @Override
    protected void mouseDragged(final Minecraft lIIIIIlIllllIll, final int lIIIIIlIllllIlI, final int lIIIIIlIllllIIl) {
        if (this.visible) {
            if (this.field_175228_o) {
                this.field_175227_p = (lIIIIIlIllllIlI - (this.xPosition + 4)) / (float)(this.width - 8);
                if (this.field_175227_p < 0.0f) {
                    this.field_175227_p = 0.0f;
                }
                if (this.field_175227_p > 1.0f) {
                    this.field_175227_p = 1.0f;
                }
                this.displayString = this.func_175221_e();
                this.field_175223_t.func_175320_a(this.id, this.func_175220_c());
            }
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.drawTexturedModalRect(this.xPosition + (int)(this.field_175227_p * (this.width - 8)), this.yPosition, 0, 66, 4, 20);
            this.drawTexturedModalRect(this.xPosition + (int)(this.field_175227_p * (this.width - 8)) + 4, this.yPosition, 196, 66, 4, 20);
        }
    }
    
    static {
        __OBFID = "CL_00001954";
    }
    
    public GuiSlider(final GuiPageButtonList.GuiResponder lIIIIIllIIllIll, final int lIIIIIllIIllIlI, final int lIIIIIllIIllIIl, final int lIIIIIllIIllIII, final String lIIIIIllIIlIlll, final float lIIIIIllIIlIllI, final float lIIIIIllIIlllll, final float lIIIIIllIIlIlII, final FormatHelper lIIIIIllIIlllIl) {
        super(lIIIIIllIIllIlI, lIIIIIllIIllIIl, lIIIIIllIIllIII, 150, 20, "");
        this.field_175227_p = 1.0f;
        this.field_175226_q = lIIIIIllIIlIlll;
        this.field_175225_r = lIIIIIllIIlIllI;
        this.field_175224_s = lIIIIIllIIlllll;
        this.field_175227_p = (lIIIIIllIIlIlII - lIIIIIllIIlIllI) / (lIIIIIllIIlllll - lIIIIIllIIlIllI);
        this.field_175222_u = lIIIIIllIIlllIl;
        this.field_175223_t = lIIIIIllIIllIll;
        this.displayString = this.func_175221_e();
    }
    
    private String func_175221_e() {
        return (this.field_175222_u == null) ? String.valueOf(new StringBuilder(String.valueOf(I18n.format(this.field_175226_q, new Object[0]))).append(": ").append(this.func_175220_c())) : this.field_175222_u.func_175318_a(this.id, I18n.format(this.field_175226_q, new Object[0]), this.func_175220_c());
    }
    
    public void func_175218_a(final float lIIIIIllIIIlIll, final boolean lIIIIIllIIIIlll) {
        this.field_175227_p = (lIIIIIllIIIlIll - this.field_175225_r) / (this.field_175224_s - this.field_175225_r);
        this.displayString = this.func_175221_e();
        if (lIIIIIllIIIIlll) {
            this.field_175223_t.func_175320_a(this.id, this.func_175220_c());
        }
    }
    
    public void func_175219_a(final float lIIIIIlIlllIIIl) {
        this.field_175227_p = lIIIIIlIlllIIIl;
        this.displayString = this.func_175221_e();
        this.field_175223_t.func_175320_a(this.id, this.func_175220_c());
    }
    
    @Override
    public void mouseReleased(final int lIIIIIlIllIIIlI, final int lIIIIIlIllIIIIl) {
        this.field_175228_o = false;
    }
    
    @Override
    protected int getHoverState(final boolean lIIIIIlIlllllll) {
        return 0;
    }
    
    public float func_175220_c() {
        return this.field_175225_r + (this.field_175224_s - this.field_175225_r) * this.field_175227_p;
    }
    
    public interface FormatHelper
    {
        String func_175318_a(final int p0, final String p1, final float p2);
    }
}
