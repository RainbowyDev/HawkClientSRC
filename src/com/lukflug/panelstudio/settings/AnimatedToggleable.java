package com.lukflug.panelstudio.settings;

import com.lukflug.panelstudio.*;

public final class AnimatedToggleable implements Toggleable
{
    private final /* synthetic */ Toggleable toggle;
    private final /* synthetic */ Animation animation;
    
    public AnimatedToggleable(final Toggleable llllIllllIlIIlI, final Animation llllIllllIlIlII) {
        this.toggle = llllIllllIlIIlI;
        this.animation = llllIllllIlIlII;
        if (llllIllllIlIIlI.isOn()) {
            llllIllllIlIlII.initValue(1.0);
        }
        else {
            llllIllllIlIlII.initValue(0.0);
        }
    }
    
    @Override
    public void toggle() {
        this.toggle.toggle();
        if (this.toggle.isOn()) {
            this.animation.setValue(1.0);
        }
        else {
            this.animation.setValue(0.0);
        }
    }
    
    @Override
    public boolean isOn() {
        return this.toggle.isOn();
    }
    
    public double getValue() {
        if (this.animation.getTarget() != (this.toggle.isOn() ? 1 : 0)) {
            if (this.toggle.isOn()) {
                this.animation.setValue(1.0);
            }
            else {
                this.animation.setValue(0.0);
            }
        }
        return this.animation.getValue();
    }
}
