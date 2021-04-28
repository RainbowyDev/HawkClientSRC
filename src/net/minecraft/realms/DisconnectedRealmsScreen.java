package net.minecraft.realms;

import net.minecraft.util.*;
import java.util.*;

public class DisconnectedRealmsScreen extends RealmsScreen
{
    private final /* synthetic */ RealmsScreen parent;
    private /* synthetic */ IChatComponent reason;
    private /* synthetic */ List lines;
    private /* synthetic */ String title;
    
    @Override
    public void keyPressed(final char llllllllllllllllIIllIlIIIIIlIlII, final int llllllllllllllllIIllIlIIIIIlIIIl) {
        if (llllllllllllllllIIllIlIIIIIlIIIl == 1) {
            Realms.setScreen(this.parent);
        }
    }
    
    public DisconnectedRealmsScreen(final RealmsScreen llllllllllllllllIIllIlIIIIlIIIIl, final String llllllllllllllllIIllIlIIIIIlllII, final IChatComponent llllllllllllllllIIllIlIIIIIllIll) {
        this.parent = llllllllllllllllIIllIlIIIIlIIIIl;
        this.title = RealmsScreen.getLocalizedString(llllllllllllllllIIllIlIIIIIlllII);
        this.reason = llllllllllllllllIIllIlIIIIIllIll;
    }
    
    @Override
    public void init() {
        this.buttonsClear();
        this.buttonsAdd(RealmsScreen.newButton(0, this.width() / 2 - 100, this.height() / 4 + 120 + 12, RealmsScreen.getLocalizedString("gui.back")));
        this.lines = this.fontSplit(this.reason.getFormattedText(), this.width() - 50);
    }
    
    @Override
    public void render(final int llllllllllllllllIIllIlIIIIIIIIlI, final int llllllllllllllllIIllIlIIIIIIIIIl, final float llllllllllllllllIIllIlIIIIIIIIII) {
        this.renderBackground();
        this.drawCenteredString(this.title, this.width() / 2, this.height() / 2 - 50, 11184810);
        int llllllllllllllllIIllIIllllllllll = this.height() / 2 - 30;
        if (this.lines != null) {
            for (final String llllllllllllllllIIllIIllllllllIl : this.lines) {
                this.drawCenteredString(llllllllllllllllIIllIIllllllllIl, this.width() / 2, llllllllllllllllIIllIIllllllllll, 16777215);
                llllllllllllllllIIllIIllllllllll += this.fontLineHeight();
            }
        }
        super.render(llllllllllllllllIIllIlIIIIIIIIlI, llllllllllllllllIIllIlIIIIIIIIIl, llllllllllllllllIIllIlIIIIIIIIII);
    }
    
    static {
        __OBFID = "CL_00002145";
    }
    
    @Override
    public void buttonClicked(final RealmsButton llllllllllllllllIIllIlIIIIIIllIl) {
        if (llllllllllllllllIIllIlIIIIIIllIl.id() == 0) {
            Realms.setScreen(this.parent);
        }
    }
}
