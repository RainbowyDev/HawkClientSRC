package com.lukflug.panelstudio.hud;

import com.lukflug.panelstudio.settings.*;
import com.lukflug.panelstudio.*;
import com.lukflug.panelstudio.theme.*;
import java.awt.*;

public class HUDPanel extends DraggableContainer
{
    protected /* synthetic */ FixedComponent component;
    protected /* synthetic */ Toggleable guiOpen;
    
    @Override
    public void handleButton(final Context llllllllllllllIIIllIlIllIIIIIlII, final int llllllllllllllIIIllIlIllIIIIIIll) {
        if (this.guiOpen.isOn()) {
            super.handleButton(llllllllllllllIIIllIlIllIIIIIlII, llllllllllllllIIIllIlIllIIIIIIll);
        }
    }
    
    @Override
    public void setPosition(final Interface llllllllllllllIIIllIlIlIlllIllll, final Point llllllllllllllIIIllIlIlIlllIlIIl) {
        this.component.setPosition(llllllllllllllIIIllIlIlIlllIllll, new Point(llllllllllllllIIIllIlIlIlllIlIIl.x, llllllllllllllIIIllIlIlIlllIlIIl.y + this.renderer.getHeight(this.open.getValue() != 0.0) + this.renderer.getOffset()));
    }
    
    public HUDPanel(final FixedComponent llllllllllllllIIIllIlIllIIIllIII, final Renderer llllllllllllllIIIllIlIllIIIlIIII, final Toggleable llllllllllllllIIIllIlIllIIIIllll, final Animation llllllllllllllIIIllIlIllIIIlIlIl, final Toggleable llllllllllllllIIIllIlIllIIIlIlII, final int llllllllllllllIIIllIlIllIIIIllII) {
        super(llllllllllllllIIIllIlIllIIIllIII.getTitle(), null, new HUDRenderer(llllllllllllllIIIllIlIllIIIlIIII, llllllllllllllIIIllIlIllIIIlIlII, llllllllllllllIIIllIlIllIIIIllII), llllllllllllllIIIllIlIllIIIIllll, llllllllllllllIIIllIlIllIIIlIlIl, null, new Point(0, 0), 0);
        this.addComponent(llllllllllllllIIIllIlIllIIIllIII);
        this.guiOpen = llllllllllllllIIIllIlIllIIIlIlII;
        this.component = llllllllllllllIIIllIlIllIIIllIII;
        this.bodyDrag = true;
    }
    
    @Override
    public Point getPosition(final Interface llllllllllllllIIIllIlIlIllllIllI) {
        this.position = this.component.getPosition(llllllllllllllIIIllIlIlIllllIllI);
        this.position.translate(0, -this.renderer.getHeight(this.open.getValue() != 0.0) - this.renderer.getOffset());
        return super.getPosition(llllllllllllllIIIllIlIlIllllIllI);
    }
    
    @Override
    protected Rectangle getClipRect(final Context llllllllllllllIIIllIlIlIllIlIllI, final int llllllllllllllIIIllIlIlIllIlIlIl) {
        if (this.open.getValue() != 1.0) {
            return super.getClipRect(llllllllllllllIIIllIlIlIllIlIllI, llllllllllllllIIIllIlIlIllIlIlIl);
        }
        return null;
    }
    
    @Override
    public void saveConfig(final Interface llllllllllllllIIIllIlIlIlIllllll, final PanelConfig llllllllllllllIIIllIlIlIllIIIIll) {
        this.component.saveConfig(llllllllllllllIIIllIlIlIlIllllll, llllllllllllllIIIllIlIlIllIIIIll);
        llllllllllllllIIIllIlIlIllIIIIll.saveState(this.open.isOn());
    }
    
    @Override
    public int getWidth(final Interface llllllllllllllIIIllIlIlIllIlllll) {
        return this.component.getWidth(llllllllllllllIIIllIlIlIllIlllll) + this.renderer.getBorder() * 2 + this.renderer.getLeftBorder(this.scroll) + this.renderer.getRightBorder(this.scroll);
    }
    
    @Override
    public void loadConfig(final Interface llllllllllllllIIIllIlIlIlIlllIIl, final PanelConfig llllllllllllllIIIllIlIlIlIllIlIl) {
        this.component.loadConfig(llllllllllllllIIIllIlIlIlIlllIIl, llllllllllllllIIIllIlIlIlIllIlIl);
        if (this.open.isOn() != llllllllllllllIIIllIlIlIlIllIlIl.loadState()) {
            this.open.toggle();
        }
    }
    
    @Override
    public void handleScroll(final Context llllllllllllllIIIllIlIlIlllllIll, final int llllllllllllllIIIllIlIlIlllllIlI) {
        if (this.guiOpen.isOn()) {
            super.handleScroll(llllllllllllllIIIllIlIlIlllllIll, llllllllllllllIIIllIlIlIlllllIlI);
        }
    }
    
    protected static class HUDRenderer extends RendererProxy
    {
        /* synthetic */ Renderer renderer;
        protected /* synthetic */ Toggleable guiOpen;
        protected /* synthetic */ int minBorder;
        
        @Override
        public void renderTitle(final Context llllllllllllllllIlllIllIIIIIIllI, final String llllllllllllllllIlllIlIlllllllll, final boolean llllllllllllllllIlllIlIllllllllI, final boolean llllllllllllllllIlllIllIIIIIIIll, final boolean llllllllllllllllIlllIlIlllllllIl) {
            if (this.guiOpen.isOn()) {
                this.renderer.renderTitle(llllllllllllllllIlllIllIIIIIIllI, llllllllllllllllIlllIlIlllllllll, llllllllllllllllIlllIlIllllllllI, llllllllllllllllIlllIlIlllllllIl);
            }
        }
        
        @Override
        public void renderBorder(final Context llllllllllllllllIlllIlIlllIllIII, final boolean llllllllllllllllIlllIlIlllIlIIlI, final boolean llllllllllllllllIlllIlIlllIlIIIl, final boolean llllllllllllllllIlllIlIlllIlIIII) {
            if (this.guiOpen.isOn()) {
                this.renderer.renderBorder(llllllllllllllllIlllIlIlllIllIII, llllllllllllllllIlllIlIlllIlIIlI, llllllllllllllllIlllIlIlllIlIIIl, llllllllllllllllIlllIlIlllIlIIII);
            }
        }
        
        @Override
        public void renderTitle(final Context llllllllllllllllIlllIllIIIIlIlIl, final String llllllllllllllllIlllIllIIIIlIlII, final boolean llllllllllllllllIlllIllIIIIIlllI, final boolean llllllllllllllllIlllIllIIIIIllIl) {
            if (this.guiOpen.isOn()) {
                this.renderer.renderTitle(llllllllllllllllIlllIllIIIIlIlIl, llllllllllllllllIlllIllIIIIlIlII, llllllllllllllllIlllIllIIIIIlllI, llllllllllllllllIlllIllIIIIIllIl);
            }
        }
        
        @Override
        public Color getMainColor(final boolean llllllllllllllllIlllIlIllIllIIll, final boolean llllllllllllllllIlllIlIllIllIlIl) {
            if (this.guiOpen.isOn()) {
                return this.renderer.getMainColor(llllllllllllllllIlllIlIllIllIIll, llllllllllllllllIlllIlIllIllIlIl);
            }
            return new Color(0, 0, 0, 0);
        }
        
        @Override
        public int renderScrollBar(final Context llllllllllllllllIlllIlIlllIIIlll, final boolean llllllllllllllllIlllIlIlllIIIllI, final boolean llllllllllllllllIlllIlIllIlllllI, final boolean llllllllllllllllIlllIlIllIllllIl, final int llllllllllllllllIlllIlIlllIIIIll, final int llllllllllllllllIlllIlIllIlllIll) {
            if (this.guiOpen.isOn()) {
                return this.renderer.renderScrollBar(llllllllllllllllIlllIlIlllIIIlll, llllllllllllllllIlllIlIlllIIIllI, llllllllllllllllIlllIlIllIlllllI, llllllllllllllllIlllIlIllIllllIl, llllllllllllllllIlllIlIlllIIIIll, llllllllllllllllIlllIlIllIlllIll);
            }
            return llllllllllllllllIlllIlIllIlllIll;
        }
        
        @Override
        public void renderBackground(final Context llllllllllllllllIlllIlIllllIIIII, final boolean llllllllllllllllIlllIlIlllIlllll) {
            if (this.guiOpen.isOn()) {
                this.renderer.renderBackground(llllllllllllllllIlllIlIllllIIIII, llllllllllllllllIlllIlIlllIlllll);
            }
        }
        
        @Override
        public void renderRect(final Context llllllllllllllllIlllIlIllllIllIl, final String llllllllllllllllIlllIlIlllllIIll, final boolean llllllllllllllllIlllIlIlllllIIlI, final boolean llllllllllllllllIlllIlIlllllIIIl, final Rectangle llllllllllllllllIlllIlIllllIlIIl, final boolean llllllllllllllllIlllIlIllllIllll) {
            if (this.guiOpen.isOn()) {
                this.renderer.renderRect(llllllllllllllllIlllIlIllllIllIl, llllllllllllllllIlllIlIlllllIIll, llllllllllllllllIlllIlIlllllIIlI, llllllllllllllllIlllIlIlllllIIIl, llllllllllllllllIlllIlIllllIlIIl, llllllllllllllllIlllIlIllllIllll);
            }
        }
        
        @Override
        public Color getBackgroundColor(final boolean llllllllllllllllIlllIlIllIlIllII) {
            if (this.guiOpen.isOn()) {
                return this.renderer.getBackgroundColor(llllllllllllllllIlllIlIllIlIllII);
            }
            return new Color(0, 0, 0, 0);
        }
        
        @Override
        public int getBorder() {
            return Math.max(this.renderer.getBorder(), this.minBorder);
        }
        
        @Override
        public int getOffset() {
            return Math.max(this.renderer.getOffset(), this.minBorder);
        }
        
        @Override
        public Color getFontColor(final boolean llllllllllllllllIlllIlIllIlIlIII) {
            if (this.guiOpen.isOn()) {
                return this.renderer.getFontColor(llllllllllllllllIlllIlIllIlIlIII);
            }
            return new Color(0, 0, 0, 0);
        }
        
        @Override
        public void renderTitle(final Context llllllllllllllllIlllIllIIIlIIIlI, final String llllllllllllllllIlllIllIIIIlllIl, final boolean llllllllllllllllIlllIllIIIIlllII) {
            if (this.guiOpen.isOn()) {
                this.renderer.renderTitle(llllllllllllllllIlllIllIIIlIIIlI, llllllllllllllllIlllIllIIIIlllIl, llllllllllllllllIlllIllIIIIlllII);
            }
        }
        
        public HUDRenderer(final Renderer llllllllllllllllIlllIllIIIllIlII, final Toggleable llllllllllllllllIlllIllIIIlIllll, final int llllllllllllllllIlllIllIIIllIIlI) {
            this.renderer = llllllllllllllllIlllIllIIIllIlII;
            this.guiOpen = llllllllllllllllIlllIllIIIlIllll;
            this.minBorder = llllllllllllllllIlllIllIIIllIIlI;
        }
        
        @Override
        protected Renderer getRenderer() {
            return this.renderer;
        }
    }
}
