package com.lukflug.panelstudio;

import java.awt.*;

public interface PanelConfig
{
    void saveState(final boolean p0);
    
    void savePositon(final Point p0);
    
    boolean loadState();
    
    Point loadPosition();
}
