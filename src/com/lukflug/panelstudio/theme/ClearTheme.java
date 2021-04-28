package com.lukflug.panelstudio.theme;

import com.lukflug.panelstudio.*;
import java.awt.*;

public class ClearTheme implements Theme
{
    protected /* synthetic */ Renderer componentRenderer;
    protected /* synthetic */ ColorScheme scheme;
    protected /* synthetic */ Renderer panelRenderer;
    protected final /* synthetic */ boolean gradient;
    
    public ClearTheme(final ColorScheme llllllllllllllllIIIIlIlIIIIIIllI, final boolean llllllllllllllllIIIIlIlIIIIIIlII, final int llllllllllllllllIIIIlIlIIIIIIIll, final int llllllllllllllllIIIIlIlIIIIIIIlI) {
        this.scheme = llllllllllllllllIIIIlIlIIIIIIllI;
        this.gradient = llllllllllllllllIIIIlIlIIIIIIlII;
        this.panelRenderer = new ComponentRenderer(true, llllllllllllllllIIIIlIlIIIIIIIll, llllllllllllllllIIIIlIlIIIIIIIlI);
        this.componentRenderer = new ComponentRenderer(false, llllllllllllllllIIIIlIlIIIIIIIll, llllllllllllllllIIIIlIlIIIIIIIlI);
    }
    
    @Override
    public Renderer getPanelRenderer() {
        return this.panelRenderer;
    }
    
    @Override
    public Renderer getContainerRenderer() {
        return this.componentRenderer;
    }
    
    @Override
    public Renderer getComponentRenderer() {
        return this.componentRenderer;
    }
    
    protected class ComponentRenderer extends RendererBase
    {
        protected final /* synthetic */ boolean panel;
        
        @Override
        public Color getMainColor(final boolean llllllllllllllllllIIIIlIIIIlIlIl, final boolean llllllllllllllllllIIIIlIIIIlIlII) {
            if (llllllllllllllllllIIIIlIIIIlIlII) {
                return this.getColorScheme().getActiveColor();
            }
            return new Color(0, 0, 0, 0);
        }
        
        @Override
        public void renderBorder(final Context llllllllllllllllllIIIIlIIIIlllII, final boolean llllllllllllllllllIIIIlIIIIllIll, final boolean llllllllllllllllllIIIIlIIIIllIlI, final boolean llllllllllllllllllIIIIlIIIIllIIl) {
        }
        
        @Override
        public void renderBackground(final Context llllllllllllllllllIIIIlIIIlIIlII, final boolean llllllllllllllllllIIIIlIIIIlllll) {
            if (this.panel) {
                final Color llllllllllllllllllIIIIlIIIlIIIlI = this.getBackgroundColor(llllllllllllllllllIIIIlIIIIlllll);
                llllllllllllllllllIIIIlIIIlIIlII.getInterface().fillRect(llllllllllllllllllIIIIlIIIlIIlII.getRect(), llllllllllllllllllIIIIlIIIlIIIlI, llllllllllllllllllIIIIlIIIlIIIlI, llllllllllllllllllIIIIlIIIlIIIlI, llllllllllllllllllIIIIlIIIlIIIlI);
            }
        }
        
        @Override
        public void renderTitle(final Context llllllllllllllllllIIIIlIIlIlllIl, final String llllllllllllllllllIIIIlIIlIlllII, final boolean llllllllllllllllllIIIIlIIlIIlllI, final boolean llllllllllllllllllIIIIlIIlIIllIl, final boolean llllllllllllllllllIIIIlIIlIIllII) {
            super.renderTitle(llllllllllllllllllIIIIlIIlIlllIl, llllllllllllllllllIIIIlIIlIlllII, llllllllllllllllllIIIIlIIlIIlllI, llllllllllllllllllIIIIlIIlIIllIl, llllllllllllllllllIIIIlIIlIIllII);
            if (!this.panel) {
                final Color llllllllllllllllllIIIIlIIlIllIII = this.getFontColor(llllllllllllllllllIIIIlIIlIIllIl);
                Point llllllllllllllllllIIIIlIIlIlIIlI = null;
                Point llllllllllllllllllIIIIlIIlIlIlII = null;
                Point llllllllllllllllllIIIIlIIlIlIllI = null;
                if (llllllllllllllllllIIIIlIIlIIllII) {
                    final Point llllllllllllllllllIIIIlIIlIlIIll = new Point(llllllllllllllllllIIIIlIIlIlllIl.getPos().x + llllllllllllllllllIIIIlIIlIlllIl.getSize().width - 2, llllllllllllllllllIIIIlIIlIlllIl.getPos().y + llllllllllllllllllIIIIlIIlIlllIl.getSize().height / 4);
                    final Point llllllllllllllllllIIIIlIIlIlIlIl = new Point(llllllllllllllllllIIIIlIIlIlllIl.getPos().x + llllllllllllllllllIIIIlIIlIlllIl.getSize().width - llllllllllllllllllIIIIlIIlIlllIl.getSize().height / 2, llllllllllllllllllIIIIlIIlIlllIl.getPos().y + llllllllllllllllllIIIIlIIlIlllIl.getSize().height * 3 / 4);
                    final Point llllllllllllllllllIIIIlIIlIlIlll = new Point(llllllllllllllllllIIIIlIIlIlllIl.getPos().x + llllllllllllllllllIIIIlIIlIlllIl.getSize().width - llllllllllllllllllIIIIlIIlIlllIl.getSize().height + 2, llllllllllllllllllIIIIlIIlIlllIl.getPos().y + llllllllllllllllllIIIIlIIlIlllIl.getSize().height / 4);
                }
                else {
                    llllllllllllllllllIIIIlIIlIlIIlI = new Point(llllllllllllllllllIIIIlIIlIlllIl.getPos().x + llllllllllllllllllIIIIlIIlIlllIl.getSize().width - llllllllllllllllllIIIIlIIlIlllIl.getSize().height * 3 / 4, llllllllllllllllllIIIIlIIlIlllIl.getPos().y + 2);
                    llllllllllllllllllIIIIlIIlIlIlII = new Point(llllllllllllllllllIIIIlIIlIlllIl.getPos().x + llllllllllllllllllIIIIlIIlIlllIl.getSize().width - llllllllllllllllllIIIIlIIlIlllIl.getSize().height / 4, llllllllllllllllllIIIIlIIlIlllIl.getPos().y + llllllllllllllllllIIIIlIIlIlllIl.getSize().height / 2);
                    llllllllllllllllllIIIIlIIlIlIllI = new Point(llllllllllllllllllIIIIlIIlIlllIl.getPos().x + llllllllllllllllllIIIIlIIlIlllIl.getSize().width - llllllllllllllllllIIIIlIIlIlllIl.getSize().height * 3 / 4, llllllllllllllllllIIIIlIIlIlllIl.getPos().y + llllllllllllllllllIIIIlIIlIlllIl.getSize().height - 2);
                }
                llllllllllllllllllIIIIlIIlIlllIl.getInterface().fillTriangle(llllllllllllllllllIIIIlIIlIlIllI, llllllllllllllllllIIIIlIIlIlIlII, llllllllllllllllllIIIIlIIlIlIIlI, llllllllllllllllllIIIIlIIlIllIII, llllllllllllllllllIIIIlIIlIllIII, llllllllllllllllllIIIIlIIlIllIII);
            }
        }
        
        @Override
        public ColorScheme getDefaultColorScheme() {
            return ClearTheme.this.scheme;
        }
        
        @Override
        public Color getBackgroundColor(final boolean llllllllllllllllllIIIIlIIIIIlllI) {
            final Color llllllllllllllllllIIIIlIIIIIllIl = this.getColorScheme().getBackgroundColor();
            return new Color(llllllllllllllllllIIIIlIIIIIllIl.getRed(), llllllllllllllllllIIIIlIIIIIllIl.getGreen(), llllllllllllllllllIIIIlIIIIIllIl.getBlue(), this.getColorScheme().getOpacity());
        }
        
        @Override
        public void renderTitle(final Context llllllllllllllllllIIIIlIIllIllll, final String llllllllllllllllllIIIIlIIlllIlll, final boolean llllllllllllllllllIIIIlIIllIllIl, final boolean llllllllllllllllllIIIIlIIllIllII) {
            if (this.panel) {
                super.renderTitle(llllllllllllllllllIIIIlIIllIllll, llllllllllllllllllIIIIlIIlllIlll, llllllllllllllllllIIIIlIIllIllIl, llllllllllllllllllIIIIlIIllIllII);
            }
            else {
                Color llllllllllllllllllIIIIlIIlllIIll = null;
                if (llllllllllllllllllIIIIlIIllIllll.isHovered()) {
                    final Color llllllllllllllllllIIIIlIIlllIlII = new Color(0, 0, 0, 64);
                }
                else {
                    llllllllllllllllllIIIIlIIlllIIll = new Color(0, 0, 0, 0);
                }
                llllllllllllllllllIIIIlIIllIllll.getInterface().fillRect(llllllllllllllllllIIIIlIIllIllll.getRect(), llllllllllllllllllIIIIlIIlllIIll, llllllllllllllllllIIIIlIIlllIIll, llllllllllllllllllIIIIlIIlllIIll, llllllllllllllllllIIIIlIIlllIIll);
                Color llllllllllllllllllIIIIlIIlllIIlI = this.getFontColor(llllllllllllllllllIIIIlIIllIllIl);
                if (llllllllllllllllllIIIIlIIllIllII) {
                    llllllllllllllllllIIIIlIIlllIIlI = this.getMainColor(llllllllllllllllllIIIIlIIllIllIl, true);
                }
                final Point llllllllllllllllllIIIIlIIlllIIIl = new Point(llllllllllllllllllIIIIlIIllIllll.getPos());
                llllllllllllllllllIIIIlIIlllIIIl.translate(0, this.getOffset());
                llllllllllllllllllIIIIlIIllIllll.getInterface().drawString(llllllllllllllllllIIIIlIIlllIIIl, llllllllllllllllllIIIIlIIlllIlll, llllllllllllllllllIIIIlIIlllIIlI);
            }
        }
        
        @Override
        public void renderRect(final Context llllllllllllllllllIIIIlIIIllIIIl, final String llllllllllllllllllIIIIlIIIllIIII, final boolean llllllllllllllllllIIIIlIIIlllIll, final boolean llllllllllllllllllIIIIlIIIlllIlI, final Rectangle llllllllllllllllllIIIIlIIIlllIIl, final boolean llllllllllllllllllIIIIlIIIlIllII) {
            if (this.panel || llllllllllllllllllIIIIlIIIlllIlI) {
                final Color llllllllllllllllllIIIIlIIIllIlll = this.getMainColor(llllllllllllllllllIIIIlIIIlllIll, true);
                final Color llllllllllllllllllIIIIlIIIllIllI = this.getBackgroundColor(llllllllllllllllllIIIIlIIIlllIll);
                if (ClearTheme.this.gradient && this.panel) {
                    llllllllllllllllllIIIIlIIIllIIIl.getInterface().fillRect(llllllllllllllllllIIIIlIIIlllIIl, llllllllllllllllllIIIIlIIIllIlll, llllllllllllllllllIIIIlIIIllIlll, llllllllllllllllllIIIIlIIIllIllI, llllllllllllllllllIIIIlIIIllIllI);
                }
                else {
                    llllllllllllllllllIIIIlIIIllIIIl.getInterface().fillRect(llllllllllllllllllIIIIlIIIlllIIl, llllllllllllllllllIIIIlIIIllIlll, llllllllllllllllllIIIIlIIIllIlll, llllllllllllllllllIIIIlIIIllIlll, llllllllllllllllllIIIIlIIIllIlll);
                }
            }
            if (!this.panel && llllllllllllllllllIIIIlIIIlIllII) {
                Color llllllllllllllllllIIIIlIIIllIlII = null;
                if (llllllllllllllllllIIIIlIIIllIIIl.isHovered()) {
                    final Color llllllllllllllllllIIIIlIIIllIlIl = new Color(0, 0, 0, 64);
                }
                else {
                    llllllllllllllllllIIIIlIIIllIlII = new Color(0, 0, 0, 0);
                }
                llllllllllllllllllIIIIlIIIllIIIl.getInterface().fillRect(llllllllllllllllllIIIIlIIIllIIIl.getRect(), llllllllllllllllllIIIIlIIIllIlII, llllllllllllllllllIIIIlIIIllIlII, llllllllllllllllllIIIIlIIIllIlII, llllllllllllllllllIIIIlIIIllIlII);
            }
            final Point llllllllllllllllllIIIIlIIIllIIll = new Point(llllllllllllllllllIIIIlIIIlllIIl.getLocation());
            llllllllllllllllllIIIIlIIIllIIll.translate(0, this.getOffset());
            llllllllllllllllllIIIIlIIIllIIIl.getInterface().drawString(llllllllllllllllllIIIIlIIIllIIll, llllllllllllllllllIIIIlIIIllIIII, this.getFontColor(llllllllllllllllllIIIIlIIIlllIll));
        }
        
        public ComponentRenderer(final boolean llllllllllllllllllIIIIlIlIIIlIIl, final int llllllllllllllllllIIIIlIlIIIlIII, final int llllllllllllllllllIIIIlIlIIIIIlI) {
            super(llllllllllllllllllIIIIlIlIIIlIII + 2 * llllllllllllllllllIIIIlIlIIIIIlI, llllllllllllllllllIIIIlIlIIIIIlI, 0, 0, 0);
            this.panel = llllllllllllllllllIIIIlIlIIIlIIl;
        }
    }
}
