package com.lukflug.panelstudio.theme;

import com.lukflug.panelstudio.settings.*;
import java.awt.*;

public class SettingsColorScheme implements ColorScheme
{
    protected final /* synthetic */ ColorSetting outlineColor;
    protected final /* synthetic */ NumberSetting opacity;
    protected final /* synthetic */ ColorSetting fontColor;
    protected final /* synthetic */ ColorSetting inactiveColor;
    protected final /* synthetic */ ColorSetting activeColor;
    protected final /* synthetic */ ColorSetting backgroundColor;
    
    @Override
    public Color getInactiveColor() {
        return this.inactiveColor.getValue();
    }
    
    @Override
    public Color getBackgroundColor() {
        return this.backgroundColor.getValue();
    }
    
    @Override
    public Color getOutlineColor() {
        return this.outlineColor.getValue();
    }
    
    @Override
    public int getOpacity() {
        return (int)this.opacity.getNumber();
    }
    
    @Override
    public Color getFontColor() {
        return this.fontColor.getValue();
    }
    
    public SettingsColorScheme(final ColorSetting llllllllllllllIlIlllIIlIIllllIll, final ColorSetting llllllllllllllIlIlllIIlIIllllIlI, final ColorSetting llllllllllllllIlIlllIIlIIlllIIlI, final ColorSetting llllllllllllllIlIlllIIlIIlllIIIl, final ColorSetting llllllllllllllIlIlllIIlIIlllIlll, final NumberSetting llllllllllllllIlIlllIIlIIllIllll) {
        this.activeColor = llllllllllllllIlIlllIIlIIllllIll;
        this.inactiveColor = llllllllllllllIlIlllIIlIIllllIlI;
        this.backgroundColor = llllllllllllllIlIlllIIlIIlllIIlI;
        this.outlineColor = llllllllllllllIlIlllIIlIIlllIIIl;
        this.fontColor = llllllllllllllIlIlllIIlIIlllIlll;
        this.opacity = llllllllllllllIlIlllIIlIIllIllll;
    }
    
    @Override
    public Color getActiveColor() {
        return this.activeColor.getValue();
    }
}
