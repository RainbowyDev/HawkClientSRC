package com.lukflug.panelstudio.theme;

import com.lukflug.panelstudio.*;
import java.awt.*;

public interface Renderer
{
    void renderTitle(final Context p0, final String p1, final boolean p2);
    
    void renderBackground(final Context p0, final boolean p1);
    
    int getOffset();
    
    int getBottomBorder();
    
    int getBorder();
    
    Color getFontColor(final boolean p0);
    
    default Color darker(final Color lllllllllllllllIIlIlllllIlIIIIlI) {
        int lllllllllllllllIIlIlllllIlIIIlIl = lllllllllllllllIIlIlllllIlIIIIlI.getRed();
        int lllllllllllllllIIlIlllllIlIIIlII = lllllllllllllllIIlIlllllIlIIIIlI.getGreen();
        int lllllllllllllllIIlIlllllIlIIIIll = lllllllllllllllIIlIlllllIlIIIIlI.getBlue();
        lllllllllllllllIIlIlllllIlIIIlIl -= 64;
        lllllllllllllllIIlIlllllIlIIIlII -= 64;
        lllllllllllllllIIlIlllllIlIIIIll -= 64;
        if (lllllllllllllllIIlIlllllIlIIIlIl < 0) {
            lllllllllllllllIIlIlllllIlIIIlIl = 0;
        }
        if (lllllllllllllllIIlIlllllIlIIIlII < 0) {
            lllllllllllllllIIlIlllllIlIIIlII = 0;
        }
        if (lllllllllllllllIIlIlllllIlIIIIll < 0) {
            lllllllllllllllIIlIlllllIlIIIIll = 0;
        }
        return new Color(lllllllllllllllIIlIlllllIlIIIlIl, lllllllllllllllIIlIlllllIlIIIlII, lllllllllllllllIIlIlllllIlIIIIll, lllllllllllllllIIlIlllllIlIIIIlI.getAlpha());
    }
    
    Color getMainColor(final boolean p0, final boolean p1);
    
    void renderBorder(final Context p0, final boolean p1, final boolean p2, final boolean p3);
    
    void renderRect(final Context p0, final String p1, final boolean p2, final boolean p3, final Rectangle p4, final boolean p5);
    
    void overrideColorScheme(final ColorScheme p0);
    
    int getRightBorder(final boolean p0);
    
    int renderScrollBar(final Context p0, final boolean p1, final boolean p2, final boolean p3, final int p4, final int p5);
    
    int getLeftBorder(final boolean p0);
    
    Color getBackgroundColor(final boolean p0);
    
    default Color brighter(final Color lllllllllllllllIIlIlllllIlIIlllI) {
        int lllllllllllllllIIlIlllllIlIlIIIl = lllllllllllllllIIlIlllllIlIIlllI.getRed();
        int lllllllllllllllIIlIlllllIlIlIIII = lllllllllllllllIIlIlllllIlIIlllI.getGreen();
        int lllllllllllllllIIlIlllllIlIIllll = lllllllllllllllIIlIlllllIlIIlllI.getBlue();
        lllllllllllllllIIlIlllllIlIlIIIl += 64;
        lllllllllllllllIIlIlllllIlIlIIII += 64;
        lllllllllllllllIIlIlllllIlIIllll += 64;
        if (lllllllllllllllIIlIlllllIlIlIIIl > 255) {
            lllllllllllllllIIlIlllllIlIlIIIl = 255;
        }
        if (lllllllllllllllIIlIlllllIlIlIIII > 255) {
            lllllllllllllllIIlIlllllIlIlIIII = 255;
        }
        if (lllllllllllllllIIlIlllllIlIIllll > 255) {
            lllllllllllllllIIlIlllllIlIIllll = 255;
        }
        return new Color(lllllllllllllllIIlIlllllIlIlIIIl, lllllllllllllllIIlIlllllIlIlIIII, lllllllllllllllIIlIlllllIlIIllll, lllllllllllllllIIlIlllllIlIIlllI.getAlpha());
    }
    
    void restoreColorScheme();
    
    int getHeight(final boolean p0);
    
    void renderTitle(final Context p0, final String p1, final boolean p2, final boolean p3, final boolean p4);
    
    ColorScheme getDefaultColorScheme();
    
    void renderTitle(final Context p0, final String p1, final boolean p2, final boolean p3);
}
