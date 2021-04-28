package com.lukflug.panelstudio.hud;

import com.lukflug.panelstudio.theme.*;
import java.awt.*;
import com.lukflug.panelstudio.*;

public abstract class HUDComponent implements FixedComponent
{
    protected /* synthetic */ String title;
    protected /* synthetic */ Renderer renderer;
    protected /* synthetic */ Point position;
    
    @Override
    public void setPosition(final Interface llllllllllllllllIlllllIIllIIIIIl, final Point llllllllllllllllIlllllIIlIlllllI) {
        this.position = llllllllllllllllIlllllIIlIlllllI;
    }
    
    @Override
    public void enter(final Context llllllllllllllllIlllllIIllIlIIII) {
        this.getHeight(llllllllllllllllIlllllIIllIlIIII);
    }
    
    @Override
    public void handleScroll(final Context llllllllllllllllIlllllIIllIlIllI, final int llllllllllllllllIlllllIIllIllIII) {
        this.getHeight(llllllllllllllllIlllllIIllIlIllI);
    }
    
    @Override
    public String getTitle() {
        return this.title;
    }
    
    @Override
    public void render(final Context llllllllllllllllIlllllIIlllIllIl) {
        this.getHeight(llllllllllllllllIlllllIIlllIllIl);
    }
    
    public HUDComponent(final String llllllllllllllllIlllllIIllllIllI, final Renderer llllllllllllllllIlllllIIlllllIIl, final Point llllllllllllllllIlllllIIllllIlII) {
        this.title = llllllllllllllllIlllllIIllllIllI;
        this.renderer = llllllllllllllllIlllllIIlllllIIl;
        this.position = llllllllllllllllIlllllIIllllIlII;
    }
    
    @Override
    public void exit(final Context llllllllllllllllIlllllIIllIIlIlI) {
        this.getHeight(llllllllllllllllIlllllIIllIIlIlI);
    }
    
    @Override
    public void releaseFocus() {
    }
    
    @Override
    public void saveConfig(final Interface llllllllllllllllIlllllIIlIlllIlI, final PanelConfig llllllllllllllllIlllllIIlIllIlll) {
        llllllllllllllllIlllllIIlIllIlll.savePositon(this.position);
    }
    
    @Override
    public void handleKey(final Context llllllllllllllllIlllllIIlllIIIII, final int llllllllllllllllIlllllIIllIlllll) {
        this.getHeight(llllllllllllllllIlllllIIlllIIIII);
    }
    
    @Override
    public Point getPosition(final Interface llllllllllllllllIlllllIIllIIIllI) {
        return new Point(this.position);
    }
    
    @Override
    public void loadConfig(final Interface llllllllllllllllIlllllIIlIllIIlI, final PanelConfig llllllllllllllllIlllllIIlIllIIIl) {
        final Point llllllllllllllllIlllllIIlIllIIII = llllllllllllllllIlllllIIlIllIIIl.loadPosition();
        if (llllllllllllllllIlllllIIlIllIIII != null) {
            this.position = llllllllllllllllIlllllIIlIllIIII;
        }
    }
    
    @Override
    public void handleButton(final Context llllllllllllllllIlllllIIlllIIlll, final int llllllllllllllllIlllllIIlllIIllI) {
        this.getHeight(llllllllllllllllIlllllIIlllIIlll);
    }
}
