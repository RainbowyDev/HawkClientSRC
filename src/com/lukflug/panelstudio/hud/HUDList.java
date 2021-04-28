package com.lukflug.panelstudio.hud;

import java.awt.*;

public interface HUDList
{
    boolean sortUp();
    
    String getItem(final int p0);
    
    int getSize();
    
    boolean sortRight();
    
    Color getItemColor(final int p0);
}
