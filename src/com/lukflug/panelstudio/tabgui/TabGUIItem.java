package com.lukflug.panelstudio.tabgui;

import com.lukflug.panelstudio.settings.*;
import com.lukflug.panelstudio.*;

public class TabGUIItem implements TabGUIComponent
{
    protected /* synthetic */ String title;
    protected /* synthetic */ Toggleable toggle;
    
    @Override
    public boolean isActive() {
        return this.toggle.isOn();
    }
    
    @Override
    public boolean select() {
        this.toggle.toggle();
        return false;
    }
    
    @Override
    public void releaseFocus() {
    }
    
    @Override
    public void enter(final Context llllllllllllllllIllIIlIIIIIIIIIl) {
    }
    
    @Override
    public void handleButton(final Context llllllllllllllllIllIIlIIIIIIllII, final int llllllllllllllllIllIIlIIIIIIlIll) {
    }
    
    @Override
    public void render(final Context llllllllllllllllIllIIlIIIIIIlllI) {
    }
    
    @Override
    public void getHeight(final Context llllllllllllllllIllIIlIIIIIIIIll) {
    }
    
    @Override
    public void handleScroll(final Context llllllllllllllllIllIIlIIIIIIIllI, final int llllllllllllllllIllIIlIIIIIIIlIl) {
    }
    
    @Override
    public void handleKey(final Context llllllllllllllllIllIIlIIIIIIlIIl, final int llllllllllllllllIllIIlIIIIIIlIII) {
    }
    
    public TabGUIItem(final String llllllllllllllllIllIIlIIIIIlIlll, final Toggleable llllllllllllllllIllIIlIIIIIlIIll) {
        this.title = llllllllllllllllIllIIlIIIIIlIlll;
        this.toggle = llllllllllllllllIllIIlIIIIIlIIll;
    }
    
    @Override
    public void exit(final Context llllllllllllllllIllIIIllllllllll) {
    }
    
    @Override
    public String getTitle() {
        return this.title;
    }
}
