package com.lukflug.panelstudio.theme;

import com.lukflug.panelstudio.*;
import java.awt.*;

public class FixedDescription implements DescriptionRenderer
{
    protected /* synthetic */ Point pos;
    
    public FixedDescription(final Point lllllllllllllllIIllIIllIlllIllll) {
        this.pos = lllllllllllllllIIllIIllIlllIllll;
    }
    
    @Override
    public void renderDescription(final Context lllllllllllllllIIllIIllIlllIIIIl) {
        if (lllllllllllllllIIllIIllIlllIIIIl.getDescription() != null) {
            final Rectangle lllllllllllllllIIllIIllIlllIIlIl = new Rectangle(this.pos, new Dimension(lllllllllllllllIIllIIllIlllIIIIl.getInterface().getFontWidth(lllllllllllllllIIllIIllIlllIIIIl.getDescription()), lllllllllllllllIIllIIllIlllIIIIl.getInterface().getFontHeight()));
            final Color lllllllllllllllIIllIIllIlllIIlII = new Color(0, 0, 0);
            lllllllllllllllIIllIIllIlllIIIIl.getInterface().fillRect(lllllllllllllllIIllIIllIlllIIlIl, lllllllllllllllIIllIIllIlllIIlII, lllllllllllllllIIllIIllIlllIIlII, lllllllllllllllIIllIIllIlllIIlII, lllllllllllllllIIllIIllIlllIIlII);
            final Color lllllllllllllllIIllIIllIlllIIIll = new Color(255, 255, 255);
            lllllllllllllllIIllIIllIlllIIIIl.getInterface().drawRect(lllllllllllllllIIllIIllIlllIIlIl, lllllllllllllllIIllIIllIlllIIIll, lllllllllllllllIIllIIllIlllIIIll, lllllllllllllllIIllIIllIlllIIIll, lllllllllllllllIIllIIllIlllIIIll);
            lllllllllllllllIIllIIllIlllIIIIl.getInterface().drawString(this.pos, lllllllllllllllIIllIIllIlllIIIIl.getDescription(), lllllllllllllllIIllIIllIlllIIIll);
        }
    }
}
