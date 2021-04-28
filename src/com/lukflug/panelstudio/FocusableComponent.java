package com.lukflug.panelstudio;

import com.lukflug.panelstudio.theme.*;

public class FocusableComponent implements Component
{
    protected /* synthetic */ String description;
    protected /* synthetic */ Renderer renderer;
    private /* synthetic */ boolean focus;
    protected /* synthetic */ String title;
    
    @Override
    public void handleButton(final Context lllllllllllllllIIllIIlllIIlIIlII, final int lllllllllllllllIIllIIlllIIlIIIll) {
        lllllllllllllllIIllIIlllIIlIIlII.setHeight(this.renderer.getHeight(false));
        this.updateFocus(lllllllllllllllIIllIIlllIIlIIlII, lllllllllllllllIIllIIlllIIlIIIll);
    }
    
    @Override
    public void exit(final Context lllllllllllllllIIllIIlllIIIIlIlI) {
        lllllllllllllllIIllIIlllIIIIlIlI.setHeight(this.renderer.getHeight(false));
    }
    
    @Override
    public void render(final Context lllllllllllllllIIllIIlllIIllIIll) {
        lllllllllllllllIIllIIlllIIllIIll.setHeight(this.renderer.getHeight(false));
        lllllllllllllllIIllIIlllIIllIIll.setDescription(this.description);
    }
    
    @Override
    public void getHeight(final Context lllllllllllllllIIllIIlllIIIlllIl) {
        lllllllllllllllIIllIIlllIIIlllIl.setHeight(this.renderer.getHeight(false));
    }
    
    public FocusableComponent(final String lllllllllllllllIIllIIlllIlIIIIlI, final String lllllllllllllllIIllIIlllIIllllIl, final Renderer lllllllllllllllIIllIIlllIlIIIIII) {
        this.focus = false;
        this.title = lllllllllllllllIIllIIlllIlIIIIlI;
        this.renderer = lllllllllllllllIIllIIlllIlIIIIII;
        this.description = lllllllllllllllIIllIIlllIIllllIl;
    }
    
    protected void updateFocus(final Context lllllllllllllllIIllIIllIlllllIIl, final int lllllllllllllllIIllIIllIlllllIII) {
        if (lllllllllllllllIIllIIllIlllllIIl.getInterface().getButton(lllllllllllllllIIllIIllIlllllIII)) {
            this.focus = lllllllllllllllIIllIIllIlllllIIl.isHovered();
            this.handleFocus(lllllllllllllllIIllIIllIlllllIIl, this.focus && lllllllllllllllIIllIIllIlllllIIl.hasFocus());
        }
    }
    
    public boolean hasFocus(final Context lllllllllllllllIIllIIlllIIIIIlII) {
        return lllllllllllllllIIllIIlllIIIIIlII.hasFocus() && this.focus;
    }
    
    protected void handleFocus(final Context lllllllllllllllIIllIIllIllllIllI, final boolean lllllllllllllllIIllIIllIllllIlIl) {
    }
    
    @Override
    public String getTitle() {
        return this.title;
    }
    
    @Override
    public void handleScroll(final Context lllllllllllllllIIllIIlllIIIllIIl, final int lllllllllllllllIIllIIlllIIIllIII) {
        lllllllllllllllIIllIIlllIIIllIIl.setHeight(this.renderer.getHeight(false));
    }
    
    @Override
    public void releaseFocus() {
        this.focus = false;
    }
    
    @Override
    public void handleKey(final Context lllllllllllllllIIllIIlllIIlIllII, final int lllllllllllllllIIllIIlllIIlIlllI) {
        lllllllllllllllIIllIIlllIIlIllII.setHeight(this.renderer.getHeight(false));
    }
    
    @Override
    public void enter(final Context lllllllllllllllIIllIIlllIIIlIIlI) {
        lllllllllllllllIIllIIlllIIIlIIlI.setHeight(this.renderer.getHeight(false));
    }
}
