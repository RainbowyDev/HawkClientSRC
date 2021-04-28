package com.lukflug.panelstudio;

public interface ConfigList
{
    void end(final boolean p0);
    
    void begin(final boolean p0);
    
    PanelConfig getPanel(final String p0);
    
    PanelConfig addPanel(final String p0);
}
