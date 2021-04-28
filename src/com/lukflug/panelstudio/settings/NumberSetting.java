package com.lukflug.panelstudio.settings;

public interface NumberSetting
{
    double getNumber();
    
    void setNumber(final double p0);
    
    double getMinimumValue();
    
    int getPrecision();
    
    double getMaximumValue();
}
