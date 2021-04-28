package com.lukflug.panelstudio.hud;

import java.awt.*;
import com.lukflug.panelstudio.*;
import com.lukflug.panelstudio.theme.*;

public class ListComponent extends HUDComponent
{
    protected /* synthetic */ boolean lastRight;
    protected /* synthetic */ boolean lastUp;
    protected /* synthetic */ HUDList list;
    
    @Override
    public int getWidth(final Interface lllllllllllllllIIlIlIlIlIIllIIII) {
        int lllllllllllllllIIlIlIlIlIIlIllll = lllllllllllllllIIlIlIlIlIIllIIII.getFontWidth(this.getTitle());
        for (int lllllllllllllllIIlIlIlIlIIlIlllI = 0; lllllllllllllllIIlIlIlIlIIlIlllI < this.list.getSize(); ++lllllllllllllllIIlIlIlIlIIlIlllI) {
            final String lllllllllllllllIIlIlIlIlIIlIllIl = this.list.getItem(lllllllllllllllIIlIlIlIlIIlIlllI);
            lllllllllllllllIIlIlIlIlIIlIllll = Math.max(lllllllllllllllIIlIlIlIlIIlIllll, lllllllllllllllIIlIlIlIlIIllIIII.getFontWidth(lllllllllllllllIIlIlIlIlIIlIllIl));
        }
        return lllllllllllllllIIlIlIlIlIIlIllll;
    }
    
    @Override
    public void render(final Context lllllllllllllllIIlIlIlIlIlIlIlIl) {
        super.render(lllllllllllllllIIlIlIlIlIlIlIlIl);
        for (int lllllllllllllllIIlIlIlIlIlIllIIl = 0; lllllllllllllllIIlIlIlIlIlIllIIl < this.list.getSize(); ++lllllllllllllllIIlIlIlIlIlIllIIl) {
            final String lllllllllllllllIIlIlIlIlIlIllIII = this.list.getItem(lllllllllllllllIIlIlIlIlIlIllIIl);
            final Point lllllllllllllllIIlIlIlIlIlIlIlll = lllllllllllllllIIlIlIlIlIlIlIlIl.getPos();
            if (this.list.sortUp()) {
                lllllllllllllllIIlIlIlIlIlIlIlll.translate(0, lllllllllllllllIIlIlIlIlIlIlIlIl.getSize().height - (lllllllllllllllIIlIlIlIlIlIllIIl + 1) * lllllllllllllllIIlIlIlIlIlIlIlIl.getInterface().getFontHeight());
            }
            else {
                lllllllllllllllIIlIlIlIlIlIlIlll.translate(0, lllllllllllllllIIlIlIlIlIlIllIIl * lllllllllllllllIIlIlIlIlIlIlIlIl.getInterface().getFontHeight());
            }
            if (this.list.sortRight()) {
                lllllllllllllllIIlIlIlIlIlIlIlll.translate(this.getWidth(lllllllllllllllIIlIlIlIlIlIlIlIl.getInterface()) - lllllllllllllllIIlIlIlIlIlIlIlIl.getInterface().getFontWidth(lllllllllllllllIIlIlIlIlIlIllIII), 0);
            }
            lllllllllllllllIIlIlIlIlIlIlIlIl.getInterface().drawString(lllllllllllllllIIlIlIlIlIlIlIlll, lllllllllllllllIIlIlIlIlIlIllIII, this.list.getItemColor(lllllllllllllllIIlIlIlIlIlIllIIl));
        }
    }
    
    @Override
    public void loadConfig(final Interface lllllllllllllllIIlIlIlIlIIIllIlI, final PanelConfig lllllllllllllllIIlIlIlIlIIIllIIl) {
        super.loadConfig(lllllllllllllllIIlIlIlIlIIIllIlI, lllllllllllllllIIlIlIlIlIIIllIIl);
        this.lastUp = this.list.sortUp();
        this.lastRight = this.list.sortRight();
    }
    
    public ListComponent(final String lllllllllllllllIIlIlIlIlIllIlIIl, final Renderer lllllllllllllllIIlIlIlIlIllIIIll, final Point lllllllllllllllIIlIlIlIlIllIIlll, final HUDList lllllllllllllllIIlIlIlIlIllIIllI) {
        super(lllllllllllllllIIlIlIlIlIllIlIIl, lllllllllllllllIIlIlIlIlIllIIIll, lllllllllllllllIIlIlIlIlIllIIlll);
        this.lastUp = false;
        this.lastRight = false;
        this.list = lllllllllllllllIIlIlIlIlIllIIllI;
    }
    
    @Override
    public Point getPosition(final Interface lllllllllllllllIIlIlIlIlIlIIlIII) {
        final int lllllllllllllllIIlIlIlIlIlIIlIll = this.getWidth(lllllllllllllllIIlIlIlIlIlIIlIII);
        final int lllllllllllllllIIlIlIlIlIlIIlIlI = this.renderer.getHeight(false) + (this.list.getSize() - 1) * lllllllllllllllIIlIlIlIlIlIIlIII.getFontHeight();
        if (this.lastUp != this.list.sortUp()) {
            if (this.list.sortUp()) {
                this.position.translate(0, lllllllllllllllIIlIlIlIlIlIIlIlI);
            }
            else {
                this.position.translate(0, -lllllllllllllllIIlIlIlIlIlIIlIlI);
            }
            this.lastUp = this.list.sortUp();
        }
        if (this.lastRight != this.list.sortRight()) {
            if (this.list.sortRight()) {
                this.position.translate(lllllllllllllllIIlIlIlIlIlIIlIll, 0);
            }
            else {
                this.position.translate(-lllllllllllllllIIlIlIlIlIlIIlIll, 0);
            }
            this.lastRight = this.list.sortRight();
        }
        if (this.list.sortUp()) {
            if (this.list.sortRight()) {
                return new Point(this.position.x - lllllllllllllllIIlIlIlIlIlIIlIll, this.position.y - lllllllllllllllIIlIlIlIlIlIIlIlI);
            }
            return new Point(this.position.x, this.position.y - lllllllllllllllIIlIlIlIlIlIIlIlI);
        }
        else {
            if (this.list.sortRight()) {
                return new Point(new Point(this.position.x - lllllllllllllllIIlIlIlIlIlIIlIll, this.position.y));
            }
            return new Point(this.position);
        }
    }
    
    @Override
    public void setPosition(final Interface lllllllllllllllIIlIlIlIlIIllllll, final Point lllllllllllllllIIlIlIlIlIIlllllI) {
        final int lllllllllllllllIIlIlIlIlIIllllIl = this.getWidth(lllllllllllllllIIlIlIlIlIIllllll);
        final int lllllllllllllllIIlIlIlIlIIllllII = this.renderer.getHeight(false) + (this.list.getSize() - 1) * lllllllllllllllIIlIlIlIlIIllllll.getFontHeight();
        if (this.list.sortUp()) {
            if (this.list.sortRight()) {
                this.position = new Point(lllllllllllllllIIlIlIlIlIIlllllI.x + lllllllllllllllIIlIlIlIlIIllllIl, lllllllllllllllIIlIlIlIlIIlllllI.y + lllllllllllllllIIlIlIlIlIIllllII);
            }
            else {
                this.position = new Point(lllllllllllllllIIlIlIlIlIIlllllI.x, lllllllllllllllIIlIlIlIlIIlllllI.y + lllllllllllllllIIlIlIlIlIIllllII);
            }
        }
        else if (this.list.sortRight()) {
            this.position = new Point(lllllllllllllllIIlIlIlIlIIlllllI.x + lllllllllllllllIIlIlIlIlIIllllIl, lllllllllllllllIIlIlIlIlIIlllllI.y);
        }
        else {
            this.position = new Point(lllllllllllllllIIlIlIlIlIIlllllI);
        }
    }
    
    @Override
    public void getHeight(final Context lllllllllllllllIIlIlIlIlIIlIIlII) {
        lllllllllllllllIIlIlIlIlIIlIIlII.setHeight(this.renderer.getHeight(false) + (this.list.getSize() - 1) * lllllllllllllllIIlIlIlIlIIlIIlII.getInterface().getFontHeight());
    }
}
