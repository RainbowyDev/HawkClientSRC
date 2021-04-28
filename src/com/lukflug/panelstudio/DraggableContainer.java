package com.lukflug.panelstudio;

import java.awt.*;
import com.lukflug.panelstudio.theme.*;
import com.lukflug.panelstudio.settings.*;

public class DraggableContainer extends CollapsibleContainer implements FixedComponent
{
    protected /* synthetic */ Point attachPoint;
    protected /* synthetic */ boolean bodyDrag;
    protected /* synthetic */ boolean dragging;
    protected /* synthetic */ Point position;
    protected /* synthetic */ int width;
    
    @Override
    public void setPosition(final Interface llllllllllllllllllIIIIIIllIIllIl, final Point llllllllllllllllllIIIIIIllIIllII) {
        this.position = new Point(llllllllllllllllllIIIIIIllIIllII);
    }
    
    @Override
    public void saveConfig(final Interface llllllllllllllllllIIIIIIlIlllIll, final PanelConfig llllllllllllllllllIIIIIIlIlllIlI) {
        llllllllllllllllllIIIIIIlIlllIlI.savePositon(this.position);
        llllllllllllllllllIIIIIIlIlllIlI.saveState(this.open.isOn());
    }
    
    @Override
    public Point getPosition(final Interface llllllllllllllllllIIIIIIllIlIIlI) {
        if (this.dragging) {
            final Point llllllllllllllllllIIIIIIllIlIlII = new Point(this.position);
            llllllllllllllllllIIIIIIllIlIlII.translate(llllllllllllllllllIIIIIIllIlIIlI.getMouse().x - this.attachPoint.x, llllllllllllllllllIIIIIIllIlIIlI.getMouse().y - this.attachPoint.y);
            return llllllllllllllllllIIIIIIllIlIlII;
        }
        return this.position;
    }
    
    public DraggableContainer(final String llllllllllllllllllIIIIIIllllIIII, final String llllllllllllllllllIIIIIIlllIllll, final Renderer llllllllllllllllllIIIIIIlllIlllI, final Toggleable llllllllllllllllllIIIIIIlllIllIl, final Animation llllllllllllllllllIIIIIIllllIlIl, final Toggleable llllllllllllllllllIIIIIIlllIlIll, final Point llllllllllllllllllIIIIIIllllIIll, final int llllllllllllllllllIIIIIIllllIIlI) {
        super(llllllllllllllllllIIIIIIllllIIII, llllllllllllllllllIIIIIIlllIllll, llllllllllllllllllIIIIIIlllIlllI, llllllllllllllllllIIIIIIlllIllIl, llllllllllllllllllIIIIIIllllIlIl, llllllllllllllllllIIIIIIlllIlIll);
        this.dragging = false;
        this.bodyDrag = false;
        this.position = llllllllllllllllllIIIIIIllllIIll;
        this.width = llllllllllllllllllIIIIIIllllIIlI;
    }
    
    @Override
    protected void handleFocus(final Context llllllllllllllllllIIIIIIllIIIIII, final boolean llllllllllllllllllIIIIIIlIllllll) {
        if (llllllllllllllllllIIIIIIlIllllll) {
            llllllllllllllllllIIIIIIllIIIIII.requestFocus();
        }
    }
    
    @Override
    public void loadConfig(final Interface llllllllllllllllllIIIIIIlIllIIll, final PanelConfig llllllllllllllllllIIIIIIlIlIllll) {
        final Point llllllllllllllllllIIIIIIlIllIIIl = llllllllllllllllllIIIIIIlIlIllll.loadPosition();
        if (llllllllllllllllllIIIIIIlIllIIIl != null) {
            this.position = llllllllllllllllllIIIIIIlIllIIIl;
        }
        if (this.open.isOn() != llllllllllllllllllIIIIIIlIlIllll.loadState()) {
            this.open.toggle();
        }
    }
    
    @Override
    public void handleButton(final Context llllllllllllllllllIIIIIIllIlllIl, final int llllllllllllllllllIIIIIIlllIIIIl) {
        if (this.bodyDrag) {
            super.handleButton(llllllllllllllllllIIIIIIllIlllIl, llllllllllllllllllIIIIIIlllIIIIl);
        }
        else {
            llllllllllllllllllIIIIIIllIlllIl.setHeight(this.renderer.getHeight(this.open.getValue() != 0.0));
        }
        if (llllllllllllllllllIIIIIIllIlllIl.isClicked() && llllllllllllllllllIIIIIIlllIIIIl == 0) {
            this.dragging = true;
            this.attachPoint = llllllllllllllllllIIIIIIllIlllIl.getInterface().getMouse();
        }
        else if (!llllllllllllllllllIIIIIIllIlllIl.getInterface().getButton(0) && this.dragging) {
            final Point llllllllllllllllllIIIIIIlllIIIII = llllllllllllllllllIIIIIIllIlllIl.getInterface().getMouse();
            this.dragging = false;
            final Point llllllllllllllllllIIIIIIllIlllll = this.getPosition(llllllllllllllllllIIIIIIllIlllIl.getInterface());
            llllllllllllllllllIIIIIIllIlllll.translate(llllllllllllllllllIIIIIIlllIIIII.x - this.attachPoint.x, llllllllllllllllllIIIIIIlllIIIII.y - this.attachPoint.y);
            this.setPosition(llllllllllllllllllIIIIIIllIlllIl.getInterface(), llllllllllllllllllIIIIIIllIlllll);
        }
        if (!this.bodyDrag) {
            super.handleButton(llllllllllllllllllIIIIIIllIlllIl, llllllllllllllllllIIIIIIlllIIIIl);
        }
    }
    
    @Override
    public int getWidth(final Interface llllllllllllllllllIIIIIIllIIIlll) {
        return this.width;
    }
}
