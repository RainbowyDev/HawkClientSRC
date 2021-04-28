package com.lukflug.panelstudio;

import com.lukflug.panelstudio.settings.*;

public interface PanelManager
{
    void showComponent(final FixedComponent p0);
    
    void hideComponent(final FixedComponent p0);
    
    Toggleable getComponentToggleable(final FixedComponent p0);
}
