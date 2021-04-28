package com.lukflug.panelstudio.theme;

import com.lukflug.panelstudio.*;
import java.awt.*;

public class MouseDescription implements DescriptionRenderer
{
    protected /* synthetic */ Point offset;
    
    public MouseDescription(final Point llllllllllllllIIlIIIlIlIlIIlllll) {
        this.offset = llllllllllllllIIlIIIlIlIlIIlllll;
    }
    
    @Override
    public void renderDescription(final Context llllllllllllllIIlIIIlIlIlIIlIIIl) {
        if (llllllllllllllIIlIIIlIlIlIIlIIIl.getDescription() != null) {
            final Point llllllllllllllIIlIIIlIlIlIIlIllI = llllllllllllllIIlIIIlIlIlIIlIIIl.getInterface().getMouse();
            llllllllllllllIIlIIIlIlIlIIlIllI.translate(this.offset.x, this.offset.y);
            final Rectangle llllllllllllllIIlIIIlIlIlIIlIlIl = new Rectangle(llllllllllllllIIlIIIlIlIlIIlIllI, new Dimension(llllllllllllllIIlIIIlIlIlIIlIIIl.getInterface().getFontWidth(llllllllllllllIIlIIIlIlIlIIlIIIl.getDescription()), llllllllllllllIIlIIIlIlIlIIlIIIl.getInterface().getFontHeight()));
            final Color llllllllllllllIIlIIIlIlIlIIlIlII = new Color(0, 0, 0);
            llllllllllllllIIlIIIlIlIlIIlIIIl.getInterface().fillRect(llllllllllllllIIlIIIlIlIlIIlIlIl, llllllllllllllIIlIIIlIlIlIIlIlII, llllllllllllllIIlIIIlIlIlIIlIlII, llllllllllllllIIlIIIlIlIlIIlIlII, llllllllllllllIIlIIIlIlIlIIlIlII);
            final Color llllllllllllllIIlIIIlIlIlIIlIIll = new Color(255, 255, 255);
            llllllllllllllIIlIIIlIlIlIIlIIIl.getInterface().drawRect(llllllllllllllIIlIIIlIlIlIIlIlIl, llllllllllllllIIlIIIlIlIlIIlIIll, llllllllllllllIIlIIIlIlIlIIlIIll, llllllllllllllIIlIIIlIlIlIIlIIll, llllllllllllllIIlIIIlIlIlIIlIIll);
            llllllllllllllIIlIIIlIlIlIIlIIIl.getInterface().drawString(llllllllllllllIIlIIIlIlIlIIlIllI, llllllllllllllIIlIIIlIlIlIIlIIIl.getDescription(), llllllllllllllIIlIIIlIlIlIIlIIll);
        }
    }
}
