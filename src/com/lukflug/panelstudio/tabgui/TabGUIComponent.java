package com.lukflug.panelstudio.tabgui;

import com.lukflug.panelstudio.*;

public interface TabGUIComponent extends Component
{
    boolean select();
    
    boolean isActive();
}
