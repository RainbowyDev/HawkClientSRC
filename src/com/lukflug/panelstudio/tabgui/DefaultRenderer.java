package com.lukflug.panelstudio.tabgui;

import com.lukflug.panelstudio.theme.*;
import com.lukflug.panelstudio.*;
import java.awt.*;

public class DefaultRenderer implements TabGUIRenderer
{
    protected /* synthetic */ ColorScheme scheme;
    protected /* synthetic */ int border;
    protected /* synthetic */ int right;
    protected /* synthetic */ int height;
    protected /* synthetic */ int enter;
    protected /* synthetic */ int up;
    protected /* synthetic */ int down;
    protected /* synthetic */ int left;
    
    @Override
    public boolean isUpKey(final int lllllllllllllllIIlIlIIIlIIlIIlll) {
        return lllllllllllllllIIlIlIIIlIIlIIlll == this.up;
    }
    
    @Override
    public boolean isEscapeKey(final int lllllllllllllllIIlIlIIIlIIIlIlIl) {
        return lllllllllllllllIIlIlIIIlIIIlIlIl == this.left;
    }
    
    @Override
    public boolean isDownKey(final int lllllllllllllllIIlIlIIIlIIlIIIIl) {
        return lllllllllllllllIIlIlIIIlIIlIIIIl == this.down;
    }
    
    @Override
    public void renderBackground(final Context lllllllllllllllIIlIlIIIlIlIlIIII, final int lllllllllllllllIIlIlIIIlIlIIllll, final int lllllllllllllllIIlIlIIIlIlIlIlll) {
        Color lllllllllllllllIIlIlIIIlIlIlIllI = this.scheme.getBackgroundColor();
        lllllllllllllllIIlIlIIIlIlIlIllI = new Color(lllllllllllllllIIlIlIIIlIlIlIllI.getRed(), lllllllllllllllIIlIlIIIlIlIlIllI.getGreen(), lllllllllllllllIIlIlIIIlIlIlIllI.getBlue(), this.scheme.getOpacity());
        final Color lllllllllllllllIIlIlIIIlIlIlIlIl = this.scheme.getOutlineColor();
        final Color lllllllllllllllIIlIlIIIlIlIlIlII = this.scheme.getActiveColor();
        lllllllllllllllIIlIlIIIlIlIlIIII.getInterface().fillRect(lllllllllllllllIIlIlIIIlIlIlIIII.getRect(), lllllllllllllllIIlIlIIIlIlIlIllI, lllllllllllllllIIlIlIIIlIlIlIllI, lllllllllllllllIIlIlIIIlIlIlIllI, lllllllllllllllIIlIlIIIlIlIlIllI);
        lllllllllllllllIIlIlIIIlIlIlIIII.getInterface().drawRect(lllllllllllllllIIlIlIIIlIlIlIIII.getRect(), lllllllllllllllIIlIlIIIlIlIlIlIl, lllllllllllllllIIlIlIIIlIlIlIlIl, lllllllllllllllIIlIlIIIlIlIlIlIl, lllllllllllllllIIlIlIIIlIlIlIlIl);
        final Point lllllllllllllllIIlIlIIIlIlIlIIll = lllllllllllllllIIlIlIIIlIlIlIIII.getPos();
        lllllllllllllllIIlIlIIIlIlIlIIll.translate(0, lllllllllllllllIIlIlIIIlIlIIllll);
        final Rectangle lllllllllllllllIIlIlIIIlIlIlIIlI = new Rectangle(lllllllllllllllIIlIlIIIlIlIlIIll, new Dimension(lllllllllllllllIIlIlIIIlIlIlIIII.getSize().width, lllllllllllllllIIlIlIIIlIlIlIlll));
        lllllllllllllllIIlIlIIIlIlIlIIII.getInterface().fillRect(lllllllllllllllIIlIlIIIlIlIlIIlI, lllllllllllllllIIlIlIIIlIlIlIlII, lllllllllllllllIIlIlIIIlIlIlIlII, lllllllllllllllIIlIlIIIlIlIlIlII, lllllllllllllllIIlIlIIIlIlIlIlII);
        lllllllllllllllIIlIlIIIlIlIlIIII.getInterface().drawRect(lllllllllllllllIIlIlIIIlIlIlIIlI, lllllllllllllllIIlIlIIIlIlIlIlIl, lllllllllllllllIIlIlIIIlIlIlIlIl, lllllllllllllllIIlIlIIIlIlIlIlIl, lllllllllllllllIIlIlIIIlIlIlIlIl);
    }
    
    @Override
    public int getHeight() {
        return this.height;
    }
    
    @Override
    public boolean isSelectKey(final int lllllllllllllllIIlIlIIIlIIIllIll) {
        return lllllllllllllllIIlIlIIIlIIIllIll == this.right || lllllllllllllllIIlIlIIIlIIIllIll == this.enter;
    }
    
    @Override
    public void renderCaption(final Context lllllllllllllllIIlIlIIIlIIllllll, final String lllllllllllllllIIlIlIIIlIIllIlIl, final int lllllllllllllllIIlIlIIIlIIllIlII, final int lllllllllllllllIIlIlIIIlIIllIIll, final boolean lllllllllllllllIIlIlIIIlIIllIIlI) {
        Color lllllllllllllllIIlIlIIIlIIlllIIl = null;
        if (lllllllllllllllIIlIlIIIlIIllIIlI) {
            final Color lllllllllllllllIIlIlIIIlIIlllIlI = this.scheme.getActiveColor();
        }
        else {
            lllllllllllllllIIlIlIIIlIIlllIIl = this.scheme.getFontColor();
        }
        final Point lllllllllllllllIIlIlIIIlIIlllIII = lllllllllllllllIIlIlIIIlIIllllll.getPos();
        lllllllllllllllIIlIlIIIlIIlllIII.translate(0, lllllllllllllllIIlIlIIIlIIllIlII * lllllllllllllllIIlIlIIIlIIllIIll);
        lllllllllllllllIIlIlIIIlIIllllll.getInterface().drawString(lllllllllllllllIIlIlIIIlIIlllIII, lllllllllllllllIIlIlIIIlIIllIlIl, lllllllllllllllIIlIlIIIlIIlllIIl);
    }
    
    public DefaultRenderer(final ColorScheme lllllllllllllllIIlIlIIIlIlllIIIl, final int lllllllllllllllIIlIlIIIlIllllIIl, final int lllllllllllllllIIlIlIIIlIllllIII, final int lllllllllllllllIIlIlIIIlIlllIlll, final int lllllllllllllllIIlIlIIIlIlllIllI, final int lllllllllllllllIIlIlIIIlIllIllII, final int lllllllllllllllIIlIlIIIlIllIlIll, final int lllllllllllllllIIlIlIIIlIllIlIlI) {
        this.scheme = lllllllllllllllIIlIlIIIlIlllIIIl;
        this.border = lllllllllllllllIIlIlIIIlIllllIII;
        this.height = lllllllllllllllIIlIlIIIlIllllIIl;
        this.up = lllllllllllllllIIlIlIIIlIlllIlll;
        this.down = lllllllllllllllIIlIlIIIlIlllIllI;
        this.left = lllllllllllllllIIlIlIIIlIllIllII;
        this.right = lllllllllllllllIIlIlIIIlIllIlIll;
        this.enter = lllllllllllllllIIlIlIIIlIllIlIlI;
    }
    
    @Override
    public ColorScheme getColorScheme() {
        return this.scheme;
    }
    
    @Override
    public int getBorder() {
        return this.border;
    }
}
