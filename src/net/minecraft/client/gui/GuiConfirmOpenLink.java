package net.minecraft.client.gui;

import java.io.*;
import net.minecraft.client.resources.*;

public class GuiConfirmOpenLink extends GuiYesNo
{
    private final /* synthetic */ String openLinkWarning;
    private /* synthetic */ boolean showSecurityWarning;
    private final /* synthetic */ String linkText;
    private final /* synthetic */ String copyLinkButtonText;
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIIIIllIIIIlIlIllll) throws IOException {
        if (llllllllllllllIIIIllIIIIlIlIllll.id == 2) {
            this.copyLinkToClipboard();
        }
        this.parentScreen.confirmClicked(llllllllllllllIIIIllIIIIlIlIllll.id == 0, this.parentButtonClickedId);
    }
    
    @Override
    public void initGui() {
        this.buttonList.add(new GuiButton(0, this.width / 2 - 50 - 105, this.height / 6 + 96, 100, 20, this.confirmButtonText));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 50, this.height / 6 + 96, 100, 20, this.copyLinkButtonText));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 50 + 105, this.height / 6 + 96, 100, 20, this.cancelButtonText));
    }
    
    public GuiConfirmOpenLink(final GuiYesNoCallback llllllllllllllIIIIllIIIIlIlllIIl, final String llllllllllllllIIIIllIIIIlIllllIl, final int llllllllllllllIIIIllIIIIlIllllII, final boolean llllllllllllllIIIIllIIIIlIlllIll) {
        super(llllllllllllllIIIIllIIIIlIlllIIl, I18n.format(llllllllllllllIIIIllIIIIlIlllIll ? "chat.link.confirmTrusted" : "chat.link.confirm", new Object[0]), llllllllllllllIIIIllIIIIlIllllIl, llllllllllllllIIIIllIIIIlIllllII);
        this.showSecurityWarning = true;
        this.confirmButtonText = I18n.format(llllllllllllllIIIIllIIIIlIlllIll ? "chat.link.open" : "gui.yes", new Object[0]);
        this.cancelButtonText = I18n.format(llllllllllllllIIIIllIIIIlIlllIll ? "gui.cancel" : "gui.no", new Object[0]);
        this.copyLinkButtonText = I18n.format("chat.copy", new Object[0]);
        this.openLinkWarning = I18n.format("chat.link.warning", new Object[0]);
        this.linkText = llllllllllllllIIIIllIIIIlIllllIl;
    }
    
    static {
        __OBFID = "CL_00000683";
    }
    
    public void copyLinkToClipboard() {
        GuiScreen.setClipboardString(this.linkText);
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIIIIllIIIIlIlIIlII, final int llllllllllllllIIIIllIIIIlIIlllll, final float llllllllllllllIIIIllIIIIlIlIIIlI) {
        super.drawScreen(llllllllllllllIIIIllIIIIlIlIIlII, llllllllllllllIIIIllIIIIlIIlllll, llllllllllllllIIIIllIIIIlIlIIIlI);
        if (this.showSecurityWarning) {
            this.drawCenteredString(this.fontRendererObj, this.openLinkWarning, this.width / 2, 110, 16764108);
        }
    }
    
    public void disableSecurityWarning() {
        this.showSecurityWarning = false;
    }
}
