package com.lukflug.panelstudio.settings;

import java.awt.*;

public interface ColorSetting
{
    void setValue(final Color p0);
    
    Color getValue();
    
    Color getColor();
    
    boolean getRainbow();
    
    void setRainbow(final boolean p0);
}
