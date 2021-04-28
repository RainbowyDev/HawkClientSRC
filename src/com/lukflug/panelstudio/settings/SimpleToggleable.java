package com.lukflug.panelstudio.settings;

public class SimpleToggleable implements Toggleable
{
    private /* synthetic */ boolean value;
    
    @Override
    public boolean isOn() {
        return this.value;
    }
    
    public SimpleToggleable(final boolean llllllllllllllIlIIIllIllIIIlllII) {
        this.value = llllllllllllllIlIIIllIllIIIlllII;
    }
    
    @Override
    public void toggle() {
        this.value = !this.value;
    }
}
