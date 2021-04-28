package com.lukflug.panelstudio;

import com.lukflug.panelstudio.settings.*;
import java.awt.*;
import com.lukflug.panelstudio.theme.*;

public class CollapsibleContainer extends FocusableComponent implements Toggleable
{
    protected /* synthetic */ AnimatedToggleable open;
    protected /* synthetic */ boolean scroll;
    protected /* synthetic */ Toggleable toggle;
    protected /* synthetic */ Container container;
    protected /* synthetic */ int childHeight;
    protected /* synthetic */ int scrollPosition;
    protected /* synthetic */ int containerHeight;
    
    protected int getRenderHeight(final int lIIlIIlllIIlIll) {
        this.childHeight = lIIlIIlllIIlIll;
        this.containerHeight = this.getScrollHeight(lIIlIIlllIIlIll);
        this.scroll = (lIIlIIlllIIlIll > this.containerHeight);
        if (this.scrollPosition > lIIlIIlllIIlIll - this.containerHeight) {
            this.scrollPosition = lIIlIIlllIIlIll - this.containerHeight;
        }
        if (this.scrollPosition < 0) {
            this.scrollPosition = 0;
        }
        return (int)(this.containerHeight * this.open.getValue() + this.renderer.getHeight(this.open.getValue() != 0.0) + this.renderer.getBottomBorder());
    }
    
    @Override
    public void handleKey(final Context lIIlIlIIIIIIIlI, final int lIIlIlIIIIIIlIl) {
        if (this.open.getValue() == 1.0) {
            final Context lIIlIlIIIIIIlII = this.getSubContext(lIIlIlIIIIIIIlI, true);
            this.container.handleKey(lIIlIlIIIIIIlII, lIIlIlIIIIIIlIl);
            lIIlIlIIIIIIIlI.setHeight(this.getRenderHeight(lIIlIlIIIIIIlII.getSize().height));
        }
        else {
            super.handleKey(lIIlIlIIIIIIIlI, lIIlIlIIIIIIlIl);
        }
    }
    
    protected Rectangle getClipRect(final Context lIIlIIlllIIIlII, final int lIIlIIlllIIIIll) {
        return new Rectangle(lIIlIIlllIIIlII.getPos().x + this.renderer.getLeftBorder(this.scroll), lIIlIIlllIIIlII.getPos().y + this.renderer.getHeight(this.open.getValue() != 0.0), lIIlIIlllIIIlII.getSize().width - this.renderer.getLeftBorder(this.scroll) - this.renderer.getRightBorder(this.scroll), this.getRenderHeight(lIIlIIlllIIIIll) - this.renderer.getHeight(this.open.getValue() != 0.0) - this.renderer.getBottomBorder());
    }
    
    @Override
    public void enter(final Context lIIlIIllllIIllI) {
        if (this.open.getValue() == 1.0) {
            final Context lIIlIIllllIIlIl = this.getSubContext(lIIlIIllllIIllI, true);
            this.container.enter(lIIlIIllllIIlIl);
            lIIlIIllllIIllI.setHeight(this.getRenderHeight(lIIlIIllllIIlIl.getSize().height));
        }
        else {
            super.enter(lIIlIIllllIIllI);
        }
    }
    
    @Override
    public void exit(final Context lIIlIIlllIllIlI) {
        if (this.open.getValue() == 1.0) {
            final Context lIIlIIlllIlllII = this.getSubContext(lIIlIIlllIllIlI, true);
            this.container.exit(lIIlIIlllIlllII);
            lIIlIIlllIllIlI.setHeight(this.getRenderHeight(lIIlIIlllIlllII.getSize().height));
        }
        else {
            super.exit(lIIlIIlllIllIlI);
        }
    }
    
    @Override
    public boolean isOn() {
        return this.open.isOn();
    }
    
    public CollapsibleContainer(final String lIIlIlIIIlllIII, final String lIIlIlIIIlllllI, final Renderer lIIlIlIIIllllIl, final Toggleable lIIlIlIIIllIlIl, final Animation lIIlIlIIIllIlII, final Toggleable lIIlIlIIIlllIlI) {
        super(lIIlIlIIIlllIII, lIIlIlIIIlllllI, lIIlIlIIIllllIl);
        this.childHeight = 0;
        this.containerHeight = 0;
        this.scroll = false;
        this.scrollPosition = 0;
        this.container = new Container(lIIlIlIIIlllIII, null, lIIlIlIIIllllIl);
        this.open = new AnimatedToggleable(lIIlIlIIIllIlIl, lIIlIlIIIllIlII);
        this.toggle = lIIlIlIIIlllIlI;
    }
    
    @Override
    public void handleScroll(final Context lIIlIIlllllIllI, final int lIIlIIllllllIIl) {
        if (this.open.getValue() == 1.0) {
            final Context lIIlIIllllllIII = this.getSubContext(lIIlIIlllllIllI, true);
            this.container.handleKey(lIIlIIllllllIII, lIIlIIllllllIIl);
            lIIlIIlllllIllI.setHeight(this.getRenderHeight(lIIlIIllllllIII.getSize().height));
            if (lIIlIIllllllIII.isHovered()) {
                this.scrollPosition += lIIlIIllllllIIl;
                if (this.scrollPosition > this.childHeight - this.containerHeight) {
                    this.scrollPosition = this.childHeight - this.containerHeight;
                }
                if (this.scrollPosition < 0) {
                    this.scrollPosition = 0;
                }
            }
        }
        else {
            super.handleKey(lIIlIIlllllIllI, lIIlIIllllllIIl);
        }
    }
    
    protected Context getSubContext(final Context lIIlIIllIllIlIl, final boolean lIIlIIllIllIIIl) {
        return new Context(lIIlIIllIllIlIl, this.renderer.getLeftBorder(this.scroll), this.renderer.getRightBorder(this.scroll), this.getContainerOffset(), this.hasFocus(lIIlIIllIllIlIl), lIIlIIllIllIIIl);
    }
    
    protected boolean isActive() {
        return this.toggle == null || this.toggle.isOn();
    }
    
    @Override
    public void toggle() {
        this.open.toggle();
        if (!this.open.isOn()) {
            this.container.releaseFocus();
        }
    }
    
    @Override
    public void handleButton(final Context lIIlIlIIIIlIllI, final int lIIlIlIIIIIllll) {
        lIIlIlIIIIlIllI.setHeight(this.renderer.getHeight(this.open.getValue() != 0.0));
        if (lIIlIlIIIIlIllI.isClicked() && lIIlIlIIIIIllll == 0) {
            if (this.toggle != null) {
                this.toggle.toggle();
            }
        }
        else if (lIIlIlIIIIlIllI.isHovered() && lIIlIlIIIIIllll == 1 && lIIlIlIIIIlIllI.getInterface().getButton(1)) {
            this.open.toggle();
        }
        if (this.open.getValue() == 1.0) {
            Context lIIlIlIIIIlIlII = this.getSubContext(lIIlIlIIIIlIllI, true);
            this.container.getHeight(lIIlIlIIIIlIlII);
            lIIlIlIIIIlIllI.setHeight(this.getRenderHeight(lIIlIlIIIIlIlII.getSize().height));
            this.updateFocus(lIIlIlIIIIlIllI, lIIlIlIIIIIllll);
            boolean lIIlIlIIIIlIIll = true;
            final Rectangle lIIlIlIIIIlIIlI = this.getClipRect(lIIlIlIIIIlIllI, lIIlIlIIIIlIlII.getSize().height);
            if (lIIlIlIIIIlIIlI != null) {
                lIIlIlIIIIlIIll = lIIlIlIIIIlIIlI.contains(lIIlIlIIIIlIllI.getInterface().getMouse());
            }
            lIIlIlIIIIlIlII = this.getSubContext(lIIlIlIIIIlIllI, lIIlIlIIIIlIIll);
            this.container.handleButton(lIIlIlIIIIlIlII, lIIlIlIIIIIllll);
            lIIlIlIIIIlIllI.setHeight(this.getRenderHeight(lIIlIlIIIIlIlII.getSize().height));
            if (lIIlIlIIIIlIlII.focusReleased()) {
                lIIlIlIIIIlIllI.releaseFocus();
            }
        }
        else {
            super.handleButton(lIIlIlIIIIlIllI, lIIlIlIIIIIllll);
        }
    }
    
    @Override
    public void render(final Context lIIlIlIIIlIIIIl) {
        this.getHeight(lIIlIlIIIlIIIIl);
        this.renderer.renderBackground(lIIlIlIIIlIIIIl, this.hasFocus(lIIlIlIIIlIIIIl));
        super.render(lIIlIlIIIlIIIIl);
        this.renderer.renderTitle(lIIlIlIIIlIIIIl, this.title, this.hasFocus(lIIlIlIIIlIIIIl), this.isActive(), this.open.getValue() != 0.0);
        if (this.open.getValue() != 0.0) {
            Context lIIlIlIIIlIIlIl = this.getSubContext(lIIlIlIIIlIIIIl, this.open.getValue() == 1.0);
            this.container.getHeight(lIIlIlIIIlIIlIl);
            final Rectangle lIIlIlIIIlIIlII = this.getClipRect(lIIlIlIIIlIIIIl, lIIlIlIIIlIIlIl.getSize().height);
            boolean lIIlIlIIIlIIIll = this.open.getValue() == 1.0;
            if (lIIlIlIIIlIIlII != null) {
                lIIlIlIIIlIIIll = lIIlIlIIIlIIlII.contains(lIIlIlIIIlIIIIl.getInterface().getMouse());
                lIIlIlIIIlIIIIl.getInterface().window(lIIlIlIIIlIIlII);
            }
            lIIlIlIIIlIIlIl = this.getSubContext(lIIlIlIIIlIIIIl, lIIlIlIIIlIIIll);
            this.container.render(lIIlIlIIIlIIlIl);
            if (lIIlIlIIIlIIlII != null) {
                lIIlIlIIIlIIIIl.getInterface().restore();
            }
            if (lIIlIlIIIlIIlIl.isHovered()) {
                lIIlIlIIIlIIIIl.setDescription(lIIlIlIIIlIIlIl.getDescription());
            }
            lIIlIlIIIlIIIIl.setHeight(this.getRenderHeight(lIIlIlIIIlIIlIl.getSize().height));
            this.scrollPosition = this.renderer.renderScrollBar(lIIlIlIIIlIIIIl, this.hasFocus(lIIlIlIIIlIIIIl), this.isActive(), this.scroll, this.childHeight, this.scrollPosition);
            if (this.scrollPosition > this.childHeight - this.containerHeight) {
                this.scrollPosition = this.childHeight - this.containerHeight;
            }
            if (this.scrollPosition < 0) {
                this.scrollPosition = 0;
            }
        }
        this.renderer.renderBorder(lIIlIlIIIlIIIIl, this.hasFocus(lIIlIlIIIlIIIIl), this.isActive(), this.open.getValue() != 0.0);
    }
    
    protected int getContainerOffset() {
        if (this.scrollPosition > this.childHeight - this.containerHeight) {
            this.scrollPosition = this.childHeight - this.containerHeight;
        }
        if (this.scrollPosition < 0) {
            this.scrollPosition = 0;
        }
        return (int)(this.renderer.getHeight(this.open.getValue() != 0.0) - this.scrollPosition - (1.0 - this.open.getValue()) * this.containerHeight);
    }
    
    @Override
    public void getHeight(final Context lIIlIIllllIllll) {
        if (this.open.getValue() != 0.0) {
            final Context lIIlIIllllIlllI = this.getSubContext(lIIlIIllllIllll, true);
            this.container.getHeight(lIIlIIllllIlllI);
            lIIlIIllllIllll.setHeight(this.getRenderHeight(lIIlIIllllIlllI.getSize().height));
        }
        else {
            super.getHeight(lIIlIIllllIllll);
        }
    }
    
    public void addComponent(final Component lIIlIlIIIlIllIl) {
        this.container.addComponent(lIIlIlIIIlIllIl);
    }
    
    protected int getScrollHeight(final int lIIlIIlllIlIIII) {
        return lIIlIIlllIlIIII;
    }
}
