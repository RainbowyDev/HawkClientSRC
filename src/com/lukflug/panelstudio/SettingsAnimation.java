package com.lukflug.panelstudio;

import com.lukflug.panelstudio.settings.*;

public class SettingsAnimation extends Animation
{
    protected final /* synthetic */ NumberSetting speed;
    
    @Override
    protected int getSpeed() {
        return (int)this.speed.getNumber();
    }
    
    public SettingsAnimation(final NumberSetting llllllllllllllIllllIIllIIlIlllII) {
        this.speed = llllllllllllllIllllIIllIIlIlllII;
    }
}
