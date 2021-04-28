package com.lukflug.panelstudio;

import java.awt.*;

public final class Context
{
    private /* synthetic */ Interface inter;
    private /* synthetic */ boolean focusRequested;
    private /* synthetic */ Point position;
    private /* synthetic */ boolean onTop;
    private /* synthetic */ String description;
    private /* synthetic */ boolean focus;
    private /* synthetic */ Dimension size;
    private /* synthetic */ boolean focusOverride;
    
    public boolean foucsRequested() {
        return this.focusRequested;
    }
    
    public void requestFocus() {
        this.focusRequested = true;
    }
    
    public Rectangle getRect() {
        return new Rectangle(this.position, this.size);
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public boolean onTop() {
        return this.onTop;
    }
    
    public void releaseFocus() {
        this.focusRequested = false;
        this.focusOverride = true;
    }
    
    public boolean focusReleased() {
        return this.focusOverride;
    }
    
    public Interface getInterface() {
        return this.inter;
    }
    
    public void setHeight(final int lllllllllllllllllIlIIIlIlllIIIll) {
        this.size.height = lllllllllllllllllIlIIIlIlllIIIll;
    }
    
    public boolean hasFocus() {
        return this.focus;
    }
    
    public Context(final Context lllllllllllllllllIlIIIllIIIIllIl, final int lllllllllllllllllIlIIIllIIIIIlIl, final int lllllllllllllllllIlIIIllIIIIlIll, final int lllllllllllllllllIlIIIllIIIIlIlI, final boolean lllllllllllllllllIlIIIllIIIIIIlI, final boolean lllllllllllllllllIlIIIllIIIIlIII) {
        this.focusRequested = false;
        this.focusOverride = false;
        this.description = null;
        this.inter = lllllllllllllllllIlIIIllIIIIllIl.getInterface();
        this.size = new Dimension(lllllllllllllllllIlIIIllIIIIllIl.getSize().width - lllllllllllllllllIlIIIllIIIIIlIl - lllllllllllllllllIlIIIllIIIIlIll, 0);
        this.position = new Point(lllllllllllllllllIlIIIllIIIIllIl.getPos());
        this.position.translate(lllllllllllllllllIlIIIllIIIIIlIl, lllllllllllllllllIlIIIllIIIIlIlI);
        this.focus = (lllllllllllllllllIlIIIllIIIIllIl.hasFocus() && lllllllllllllllllIlIIIllIIIIIIlI);
        this.onTop = (lllllllllllllllllIlIIIllIIIIllIl.onTop() && lllllllllllllllllIlIIIllIIIIlIII);
    }
    
    public void setDescription(final String lllllllllllllllllIlIIIlIlIlllllI) {
        this.description = lllllllllllllllllIlIIIlIlIlllllI;
    }
    
    public boolean isClicked() {
        return this.isHovered() && this.inter.getButton(0);
    }
    
    public Point getPos() {
        return new Point(this.position);
    }
    
    public Context(final Interface lllllllllllllllllIlIIIlIlllllIIl, final int lllllllllllllllllIlIIIlIlllllIII, final Point lllllllllllllllllIlIIIlIllllIlll, final boolean lllllllllllllllllIlIIIlIllllIIII, final boolean lllllllllllllllllIlIIIlIllllIlIl) {
        this.focusRequested = false;
        this.focusOverride = false;
        this.description = null;
        this.inter = lllllllllllllllllIlIIIlIlllllIIl;
        this.size = new Dimension(lllllllllllllllllIlIIIlIlllllIII, 0);
        this.position = new Point(lllllllllllllllllIlIIIlIllllIlll);
        this.focus = lllllllllllllllllIlIIIlIllllIIII;
        this.onTop = lllllllllllllllllIlIIIlIllllIlIl;
    }
    
    public boolean isHovered() {
        return new Rectangle(this.position, this.size).contains(this.inter.getMouse()) && this.onTop;
    }
    
    public Dimension getSize() {
        return new Dimension(this.size);
    }
}
