package com.lukflug.panelstudio.tabgui;

import com.lukflug.panelstudio.theme.*;
import com.lukflug.panelstudio.*;

public interface TabGUIRenderer
{
    boolean isEscapeKey(final int p0);
    
    ColorScheme getColorScheme();
    
    int getHeight();
    
    int getBorder();
    
    boolean isSelectKey(final int p0);
    
    boolean isDownKey(final int p0);
    
    void renderBackground(final Context p0, final int p1, final int p2);
    
    void renderCaption(final Context p0, final String p1, final int p2, final int p3, final boolean p4);
    
    boolean isUpKey(final int p0);
}
