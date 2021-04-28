package net.minecraft.client.gui;

import com.google.common.collect.*;
import java.util.*;
import net.minecraft.client.resources.*;
import java.io.*;

public class GuiYesNo extends GuiScreen
{
    protected /* synthetic */ String confirmButtonText;
    private final /* synthetic */ List field_175298_s;
    private /* synthetic */ int ticksUntilEnable;
    private /* synthetic */ String messageLine2;
    protected /* synthetic */ String messageLine1;
    protected /* synthetic */ String cancelButtonText;
    protected /* synthetic */ int parentButtonClickedId;
    protected /* synthetic */ GuiYesNoCallback parentScreen;
    
    public void setButtonDelay(final int lllllllllllllllIIIIIlIIIIIlIlIIl) {
        this.ticksUntilEnable = lllllllllllllllIIIIIlIIIIIlIlIIl;
        for (final GuiButton lllllllllllllllIIIIIlIIIIIlIlIII : this.buttonList) {
            lllllllllllllllIIIIIlIIIIIlIlIII.enabled = false;
        }
    }
    
    public GuiYesNo(final GuiYesNoCallback lllllllllllllllIIIIIlIIIlIIIIlll, final String lllllllllllllllIIIIIlIIIlIIIIllI, final String lllllllllllllllIIIIIlIIIIllllllI, final String lllllllllllllllIIIIIlIIIIlllllIl, final String lllllllllllllllIIIIIlIIIIlllllII, final int lllllllllllllllIIIIIlIIIIllllIll) {
        this.field_175298_s = Lists.newArrayList();
        this.parentScreen = lllllllllllllllIIIIIlIIIlIIIIlll;
        this.messageLine1 = lllllllllllllllIIIIIlIIIlIIIIllI;
        this.messageLine2 = lllllllllllllllIIIIIlIIIIllllllI;
        this.confirmButtonText = lllllllllllllllIIIIIlIIIIlllllIl;
        this.cancelButtonText = lllllllllllllllIIIIIlIIIIlllllII;
        this.parentButtonClickedId = lllllllllllllllIIIIIlIIIIllllIll;
    }
    
    @Override
    public void initGui() {
        this.buttonList.add(new GuiOptionButton(0, this.width / 2 - 155, this.height / 6 + 96, this.confirmButtonText));
        this.buttonList.add(new GuiOptionButton(1, this.width / 2 - 155 + 160, this.height / 6 + 96, this.cancelButtonText));
        this.field_175298_s.clear();
        this.field_175298_s.addAll(this.fontRendererObj.listFormattedStringToWidth(this.messageLine2, this.width - 50));
    }
    
    public GuiYesNo(final GuiYesNoCallback lllllllllllllllIIIIIlIIIlIlIIlIl, final String lllllllllllllllIIIIIlIIIlIlIlIlI, final String lllllllllllllllIIIIIlIIIlIlIIIIl, final int lllllllllllllllIIIIIlIIIlIlIIlll) {
        this.field_175298_s = Lists.newArrayList();
        this.parentScreen = lllllllllllllllIIIIIlIIIlIlIIlIl;
        this.messageLine1 = lllllllllllllllIIIIIlIIIlIlIlIlI;
        this.messageLine2 = lllllllllllllllIIIIIlIIIlIlIIIIl;
        this.parentButtonClickedId = lllllllllllllllIIIIIlIIIlIlIIlll;
        this.confirmButtonText = I18n.format("gui.yes", new Object[0]);
        this.cancelButtonText = I18n.format("gui.no", new Object[0]);
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        final int ticksUntilEnable = this.ticksUntilEnable - 1;
        this.ticksUntilEnable = ticksUntilEnable;
        if (ticksUntilEnable == 0) {
            for (final GuiButton lllllllllllllllIIIIIlIIIIIIllllI : this.buttonList) {
                lllllllllllllllIIIIIlIIIIIIllllI.enabled = true;
            }
        }
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllllIIIIIlIIIIllIIIIl) throws IOException {
        this.parentScreen.confirmClicked(lllllllllllllllIIIIIlIIIIllIIIIl.id == 0, this.parentButtonClickedId);
    }
    
    @Override
    public void drawScreen(final int lllllllllllllllIIIIIlIIIIlIIlIIl, final int lllllllllllllllIIIIIlIIIIIllllIl, final float lllllllllllllllIIIIIlIIIIlIIIlIl) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.messageLine1, this.width / 2, 70, 16777215);
        int lllllllllllllllIIIIIlIIIIlIIIIll = 90;
        for (final String lllllllllllllllIIIIIlIIIIlIIIIII : this.field_175298_s) {
            this.drawCenteredString(this.fontRendererObj, lllllllllllllllIIIIIlIIIIlIIIIII, this.width / 2, lllllllllllllllIIIIIlIIIIlIIIIll, 16777215);
            lllllllllllllllIIIIIlIIIIlIIIIll += this.fontRendererObj.FONT_HEIGHT;
        }
        super.drawScreen(lllllllllllllllIIIIIlIIIIlIIlIIl, lllllllllllllllIIIIIlIIIIIllllIl, lllllllllllllllIIIIIlIIIIlIIIlIl);
    }
    
    static {
        __OBFID = "CL_00000684";
    }
}
