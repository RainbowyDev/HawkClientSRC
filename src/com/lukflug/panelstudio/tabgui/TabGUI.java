package com.lukflug.panelstudio.tabgui;

import java.awt.*;
import com.lukflug.panelstudio.*;

public class TabGUI extends TabGUIContainer implements FixedComponent
{
    protected /* synthetic */ Point position;
    protected /* synthetic */ int width;
    
    @Override
    public void saveConfig(final Interface llllllllllllllllIlllllIIlIIIIllI, final PanelConfig llllllllllllllllIlllllIIlIIIIlIl) {
        llllllllllllllllIlllllIIlIIIIlIl.savePositon(this.position);
    }
    
    @Override
    public int getWidth(final Interface llllllllllllllllIlllllIIlIIIlIll) {
        return this.width;
    }
    
    @Override
    public void loadConfig(final Interface llllllllllllllllIlllllIIIllllllI, final PanelConfig llllllllllllllllIlllllIIIllllIlI) {
        final Point llllllllllllllllIlllllIIIlllllII = llllllllllllllllIlllllIIIllllIlI.loadPosition();
        if (llllllllllllllllIlllllIIIlllllII != null) {
            this.position = llllllllllllllllIlllllIIIlllllII;
        }
    }
    
    public TabGUI(final String llllllllllllllllIlllllIIlIIlllIl, final TabGUIRenderer llllllllllllllllIlllllIIlIlIIIlI, final Animation llllllllllllllllIlllllIIlIlIIIIl, final Point llllllllllllllllIlllllIIlIIllIlI, final int llllllllllllllllIlllllIIlIIlllll) {
        super(llllllllllllllllIlllllIIlIIlllIl, llllllllllllllllIlllllIIlIlIIIlI, llllllllllllllllIlllllIIlIlIIIIl);
        this.position = llllllllllllllllIlllllIIlIIllIlI;
        this.width = llllllllllllllllIlllllIIlIIlllll;
    }
    
    @Override
    public void setPosition(final Interface llllllllllllllllIlllllIIlIIlIIIl, final Point llllllllllllllllIlllllIIlIIlIIII) {
        this.position = llllllllllllllllIlllllIIlIIlIIII;
    }
    
    @Override
    public Point getPosition(final Interface llllllllllllllllIlllllIIlIIlIllI) {
        return new Point(this.position);
    }
}
