package net.minecraft.client.gui;

import net.minecraft.client.*;
import net.minecraft.client.resources.*;

public class GuiListButton extends GuiButton
{
    private final /* synthetic */ GuiPageButtonList.GuiResponder field_175214_q;
    private /* synthetic */ String field_175215_p;
    private /* synthetic */ boolean field_175216_o;
    
    static {
        __OBFID = "CL_00001953";
    }
    
    @Override
    public boolean mousePressed(final Minecraft llllllllllllllIllllllIIllIlllIII, final int llllllllllllllIllllllIIllIllIlll, final int llllllllllllllIllllllIIllIllIllI) {
        if (super.mousePressed(llllllllllllllIllllllIIllIlllIII, llllllllllllllIllllllIIllIllIlll, llllllllllllllIllllllIIllIllIllI)) {
            this.field_175216_o = !this.field_175216_o;
            this.displayString = this.func_175213_c();
            this.field_175214_q.func_175321_a(this.id, this.field_175216_o);
            return true;
        }
        return false;
    }
    
    private String func_175213_c() {
        return String.valueOf(new StringBuilder(String.valueOf(I18n.format(this.field_175215_p, new Object[0]))).append(": ").append(this.field_175216_o ? I18n.format("gui.yes", new Object[0]) : I18n.format("gui.no", new Object[0])));
    }
    
    public void func_175212_b(final boolean llllllllllllllIllllllIIlllIIIIlI) {
        this.field_175216_o = llllllllllllllIllllllIIlllIIIIlI;
        this.displayString = this.func_175213_c();
        this.field_175214_q.func_175321_a(this.id, llllllllllllllIllllllIIlllIIIIlI);
    }
    
    public GuiListButton(final GuiPageButtonList.GuiResponder llllllllllllllIllllllIIlllIlIIII, final int llllllllllllllIllllllIIlllIIllll, final int llllllllllllllIllllllIIlllIlIlIl, final int llllllllllllllIllllllIIlllIlIlII, final String llllllllllllllIllllllIIlllIIllII, final boolean llllllllllllllIllllllIIlllIlIIlI) {
        super(llllllllllllllIllllllIIlllIIllll, llllllllllllllIllllllIIlllIlIlIl, llllllllllllllIllllllIIlllIlIlII, 150, 20, "");
        this.field_175215_p = llllllllllllllIllllllIIlllIIllII;
        this.field_175216_o = llllllllllllllIllllllIIlllIlIIlI;
        this.displayString = this.func_175213_c();
        this.field_175214_q = llllllllllllllIllllllIIlllIlIIII;
    }
}
