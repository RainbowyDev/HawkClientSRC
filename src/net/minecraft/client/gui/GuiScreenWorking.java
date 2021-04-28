package net.minecraft.client.gui;

import net.minecraft.util.*;

public class GuiScreenWorking extends GuiScreen implements IProgressUpdate
{
    private /* synthetic */ int field_146590_g;
    private /* synthetic */ boolean field_146592_h;
    private /* synthetic */ String field_146589_f;
    private /* synthetic */ String field_146591_a;
    
    public GuiScreenWorking() {
        this.field_146591_a = "";
        this.field_146589_f = "";
    }
    
    @Override
    public void setDoneWorking() {
        this.field_146592_h = true;
    }
    
    @Override
    public void displaySavingString(final String lllllllllllllllllllIIIIIIlIllllI) {
        this.resetProgressAndMessage(lllllllllllllllllllIIIIIIlIllllI);
    }
    
    @Override
    public void resetProgressAndMessage(final String lllllllllllllllllllIIIIIIlIllIII) {
        this.field_146591_a = lllllllllllllllllllIIIIIIlIllIII;
        this.displayLoadingString("Working...");
    }
    
    @Override
    public void displayLoadingString(final String lllllllllllllllllllIIIIIIlIlIIlI) {
        this.field_146589_f = lllllllllllllllllllIIIIIIlIlIIlI;
        this.setLoadingProgress(0);
    }
    
    static {
        __OBFID = "CL_00000707";
    }
    
    @Override
    public void setLoadingProgress(final int lllllllllllllllllllIIIIIIlIIlIlI) {
        this.field_146590_g = lllllllllllllllllllIIIIIIlIIlIlI;
    }
    
    @Override
    public void drawScreen(final int lllllllllllllllllllIIIIIIIllllIl, final int lllllllllllllllllllIIIIIIlIIIIII, final float lllllllllllllllllllIIIIIIIlllIll) {
        if (this.field_146592_h) {
            this.mc.displayGuiScreen(null);
        }
        else {
            this.drawDefaultBackground();
            this.drawCenteredString(this.fontRendererObj, this.field_146591_a, this.width / 2, 70, 16777215);
            this.drawCenteredString(this.fontRendererObj, String.valueOf(new StringBuilder(String.valueOf(this.field_146589_f)).append(" ").append(this.field_146590_g).append("%")), this.width / 2, 90, 16777215);
            super.drawScreen(lllllllllllllllllllIIIIIIIllllIl, lllllllllllllllllllIIIIIIlIIIIII, lllllllllllllllllllIIIIIIIlllIll);
        }
    }
}
