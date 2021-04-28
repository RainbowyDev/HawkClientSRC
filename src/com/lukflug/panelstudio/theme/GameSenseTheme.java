package com.lukflug.panelstudio.theme;

import com.lukflug.panelstudio.*;
import java.awt.*;

public class GameSenseTheme implements Theme
{
    protected /* synthetic */ Renderer panelRenderer;
    protected /* synthetic */ ColorScheme scheme;
    protected /* synthetic */ Renderer containerRenderer;
    protected /* synthetic */ Renderer componentRenderer;
    
    public GameSenseTheme(final ColorScheme lIlIlIIllllIIl, final int lIlIlIIlllllIl, final int lIlIlIIlllIlll, final int lIlIlIIlllIllI) {
        this.scheme = lIlIlIIllllIIl;
        this.panelRenderer = new ComponentRenderer(0, lIlIlIIlllllIl, lIlIlIIlllIlll, lIlIlIIlllIllI);
        this.containerRenderer = new ComponentRenderer(1, lIlIlIIlllllIl, lIlIlIIlllIlll, lIlIlIIlllIllI);
        this.componentRenderer = new ComponentRenderer(2, lIlIlIIlllllIl, lIlIlIIlllIlll, lIlIlIIlllIllI);
    }
    
    @Override
    public Renderer getPanelRenderer() {
        return this.panelRenderer;
    }
    
    @Override
    public Renderer getContainerRenderer() {
        return this.containerRenderer;
    }
    
    @Override
    public Renderer getComponentRenderer() {
        return this.componentRenderer;
    }
    
    protected class ComponentRenderer extends RendererBase
    {
        protected final /* synthetic */ int level;
        protected final /* synthetic */ int border;
        
        @Override
        public void renderBackground(final Context llllllllllllllIIllIllIllIlIllIll, final boolean llllllllllllllIIllIllIllIlIllIlI) {
        }
        
        @Override
        public Color getBackgroundColor(final boolean llllllllllllllIIllIllIllIIIllIlI) {
            return new Color(0, 0, 0, 0);
        }
        
        @Override
        public void renderBorder(final Context llllllllllllllIIllIllIllIlIlIlII, final boolean llllllllllllllIIllIllIllIlIlIIll, final boolean llllllllllllllIIllIllIllIlIlIIlI, final boolean llllllllllllllIIllIllIllIlIIllIl) {
            final Color llllllllllllllIIllIllIllIlIlIIII = this.getDefaultColorScheme().getOutlineColor();
            if (this.level == 0) {
                llllllllllllllIIllIllIllIlIlIlII.getInterface().fillRect(new Rectangle(llllllllllllllIIllIllIllIlIlIlII.getPos(), new Dimension(llllllllllllllIIllIllIllIlIlIlII.getSize().width, 1)), llllllllllllllIIllIllIllIlIlIIII, llllllllllllllIIllIllIllIlIlIIII, llllllllllllllIIllIllIllIlIlIIII, llllllllllllllIIllIllIllIlIlIIII);
                llllllllllllllIIllIllIllIlIlIlII.getInterface().fillRect(new Rectangle(llllllllllllllIIllIllIllIlIlIlII.getPos(), new Dimension(1, llllllllllllllIIllIllIllIlIlIlII.getSize().height)), llllllllllllllIIllIllIllIlIlIIII, llllllllllllllIIllIllIllIlIlIIII, llllllllllllllIIllIllIllIlIlIIII, llllllllllllllIIllIllIllIlIlIIII);
                llllllllllllllIIllIllIllIlIlIlII.getInterface().fillRect(new Rectangle(new Point(llllllllllllllIIllIllIllIlIlIlII.getPos().x + llllllllllllllIIllIllIllIlIlIlII.getSize().width - 1, llllllllllllllIIllIllIllIlIlIlII.getPos().y), new Dimension(1, llllllllllllllIIllIllIllIlIlIlII.getSize().height)), llllllllllllllIIllIllIllIlIlIIII, llllllllllllllIIllIllIllIlIlIIII, llllllllllllllIIllIllIllIlIlIIII, llllllllllllllIIllIllIllIlIlIIII);
            }
            if (this.level == 0 || llllllllllllllIIllIllIllIlIIllIl) {
                llllllllllllllIIllIllIllIlIlIlII.getInterface().fillRect(new Rectangle(new Point(llllllllllllllIIllIllIllIlIlIlII.getPos().x, llllllllllllllIIllIllIllIlIlIlII.getPos().y + llllllllllllllIIllIllIllIlIlIlII.getSize().height - 1), new Dimension(llllllllllllllIIllIllIllIlIlIlII.getSize().width, 1)), llllllllllllllIIllIllIllIlIlIIII, llllllllllllllIIllIllIllIlIlIIII, llllllllllllllIIllIllIllIlIlIIII, llllllllllllllIIllIllIllIlIlIIII);
                llllllllllllllIIllIllIllIlIlIlII.getInterface().fillRect(new Rectangle(new Point(llllllllllllllIIllIllIllIlIlIlII.getPos().x, llllllllllllllIIllIllIllIlIlIlII.getPos().y + this.getHeight(llllllllllllllIIllIllIllIlIIllIl) - 1), new Dimension(llllllllllllllIIllIllIllIlIlIlII.getSize().width, 1)), llllllllllllllIIllIllIllIlIlIIII, llllllllllllllIIllIllIllIlIlIIII, llllllllllllllIIllIllIllIlIlIIII, llllllllllllllIIllIllIllIlIlIIII);
            }
        }
        
        public ComponentRenderer(final int llllllllllllllIIllIllIllIlllllIl, final int llllllllllllllIIllIllIlllIIIIIlI, final int llllllllllllllIIllIllIllIllllIll, final int llllllllllllllIIllIllIllIllllIlI) {
            super(llllllllllllllIIllIllIlllIIIIIlI + 2 * llllllllllllllIIllIllIllIllllIll, 0, 0, 0, llllllllllllllIIllIllIllIllllIlI);
            this.level = llllllllllllllIIllIllIllIlllllIl;
            this.border = llllllllllllllIIllIllIllIllllIll;
        }
        
        @Override
        public int renderScrollBar(final Context llllllllllllllIIllIllIllIIllIIIl, final boolean llllllllllllllIIllIllIllIIllllIl, final boolean llllllllllllllIIllIllIllIIllllII, final boolean llllllllllllllIIllIllIllIIlIllll, final int llllllllllllllIIllIllIllIIlllIlI, final int llllllllllllllIIllIllIllIIlIllIl) {
            if (llllllllllllllIIllIllIllIIlIllll) {
                final int llllllllllllllIIllIllIllIIlllIII = llllllllllllllIIllIllIllIIllIIIl.getSize().height - this.getHeight(true);
                final int llllllllllllllIIllIllIllIIllIlll = (int)(llllllllllllllIIllIllIllIIlIllIl / (double)llllllllllllllIIllIllIllIIlllIlI * llllllllllllllIIllIllIllIIlllIII);
                final int llllllllllllllIIllIllIllIIllIllI = (int)((llllllllllllllIIllIllIllIIlIllIl + llllllllllllllIIllIllIllIIlllIII) / (double)llllllllllllllIIllIllIllIIlllIlI * llllllllllllllIIllIllIllIIlllIII);
                final Color llllllllllllllIIllIllIllIIllIlIl = this.getMainColor(llllllllllllllIIllIllIllIIllllIl, false);
                final Color llllllllllllllIIllIllIllIIllIlII = this.getMainColor(llllllllllllllIIllIllIllIIllllIl, true);
                llllllllllllllIIllIllIllIIllIIIl.getInterface().fillRect(new Rectangle(new Point(llllllllllllllIIllIllIllIIllIIIl.getPos().x + llllllllllllllIIllIllIllIIllIIIl.getSize().width - this.getRightBorder(true), llllllllllllllIIllIllIllIIllIIIl.getPos().y + this.getHeight(true)), new Dimension(this.getRightBorder(true), llllllllllllllIIllIllIllIIllIlll)), llllllllllllllIIllIllIllIIllIlIl, llllllllllllllIIllIllIllIIllIlIl, llllllllllllllIIllIllIllIIllIlIl, llllllllllllllIIllIllIllIIllIlIl);
                llllllllllllllIIllIllIllIIllIIIl.getInterface().fillRect(new Rectangle(new Point(llllllllllllllIIllIllIllIIllIIIl.getPos().x + llllllllllllllIIllIllIllIIllIIIl.getSize().width - this.getRightBorder(true), llllllllllllllIIllIllIllIIllIIIl.getPos().y + this.getHeight(true) + llllllllllllllIIllIllIllIIllIlll), new Dimension(this.getRightBorder(true), llllllllllllllIIllIllIllIIllIllI - llllllllllllllIIllIllIllIIllIlll)), llllllllllllllIIllIllIllIIllIlII, llllllllllllllIIllIllIllIIllIlII, llllllllllllllIIllIllIllIIllIlII, llllllllllllllIIllIllIllIIllIlII);
                llllllllllllllIIllIllIllIIllIIIl.getInterface().fillRect(new Rectangle(new Point(llllllllllllllIIllIllIllIIllIIIl.getPos().x + llllllllllllllIIllIllIllIIllIIIl.getSize().width - this.getRightBorder(true), llllllllllllllIIllIllIllIIllIIIl.getPos().y + this.getHeight(true) + llllllllllllllIIllIllIllIIllIllI), new Dimension(this.getRightBorder(true), llllllllllllllIIllIllIllIIllIIIl.getSize().height - this.getHeight(true) - llllllllllllllIIllIllIllIIllIllI)), llllllllllllllIIllIllIllIIllIlIl, llllllllllllllIIllIllIllIIllIlIl, llllllllllllllIIllIllIllIIllIlIl, llllllllllllllIIllIllIllIIllIlIl);
                final Color llllllllllllllIIllIllIllIIllIIll = this.getDefaultColorScheme().getOutlineColor();
                llllllllllllllIIllIllIllIIllIIIl.getInterface().fillRect(new Rectangle(new Point(llllllllllllllIIllIllIllIIllIIIl.getPos().x + llllllllllllllIIllIllIllIIllIIIl.getSize().width - this.getRightBorder(true) - 1, llllllllllllllIIllIllIllIIllIIIl.getPos().y + this.getHeight(true)), new Dimension(1, llllllllllllllIIllIllIllIIllIIIl.getSize().height - this.getHeight(true))), llllllllllllllIIllIllIllIIllIIll, llllllllllllllIIllIllIllIIllIIll, llllllllllllllIIllIllIllIIllIIll, llllllllllllllIIllIllIllIIllIIll);
                if (llllllllllllllIIllIllIllIIllIIIl.isClicked() && llllllllllllllIIllIllIllIIllIIIl.getInterface().getMouse().x >= llllllllllllllIIllIllIllIIllIIIl.getPos().x + llllllllllllllIIllIllIllIIllIIIl.getSize().width - this.getRightBorder(true)) {
                    return (int)((llllllllllllllIIllIllIllIIllIIIl.getInterface().getMouse().y - llllllllllllllIIllIllIllIIllIIIl.getPos().y - this.getHeight(true)) * llllllllllllllIIllIllIllIIlllIlI / (double)llllllllllllllIIllIllIllIIlllIII - llllllllllllllIIllIllIllIIlllIII / 2.0);
                }
            }
            return llllllllllllllIIllIllIllIIlIllIl;
        }
        
        @Override
        public ColorScheme getDefaultColorScheme() {
            return GameSenseTheme.this.scheme;
        }
        
        @Override
        public Color getMainColor(final boolean llllllllllllllIIllIllIllIIlIIIlI, final boolean llllllllllllllIIllIllIllIIlIIIIl) {
            Color llllllllllllllIIllIllIllIIIlllll = null;
            if (llllllllllllllIIllIllIllIIlIIIIl) {
                final Color llllllllllllllIIllIllIllIIlIIIII = this.getColorScheme().getActiveColor();
            }
            else {
                llllllllllllllIIllIllIllIIIlllll = this.getColorScheme().getBackgroundColor();
            }
            if (!llllllllllllllIIllIllIllIIlIIIIl && this.level < 2) {
                llllllllllllllIIllIllIllIIIlllll = this.getColorScheme().getInactiveColor();
            }
            llllllllllllllIIllIllIllIIIlllll = new Color(llllllllllllllIIllIllIllIIIlllll.getRed(), llllllllllllllIIllIllIllIIIlllll.getGreen(), llllllllllllllIIllIllIllIIIlllll.getBlue(), this.getColorScheme().getOpacity());
            return llllllllllllllIIllIllIllIIIlllll;
        }
        
        @Override
        public void renderRect(final Context llllllllllllllIIllIllIllIllIIlII, final String llllllllllllllIIllIllIllIllIlllI, final boolean llllllllllllllIIllIllIllIllIIIlI, final boolean llllllllllllllIIllIllIllIllIIIIl, final Rectangle llllllllllllllIIllIllIllIllIIIII, final boolean llllllllllllllIIllIllIllIlIlllll) {
            final Color llllllllllllllIIllIllIllIllIlIIl = this.getMainColor(llllllllllllllIIllIllIllIllIIIlI, llllllllllllllIIllIllIllIllIIIIl);
            llllllllllllllIIllIllIllIllIIlII.getInterface().fillRect(llllllllllllllIIllIllIllIllIIIII, llllllllllllllIIllIllIllIllIlIIl, llllllllllllllIIllIllIllIllIlIIl, llllllllllllllIIllIllIllIllIlIIl, llllllllllllllIIllIllIllIllIlIIl);
            if (llllllllllllllIIllIllIllIlIlllll) {
                Color llllllllllllllIIllIllIllIllIIlll = null;
                if (llllllllllllllIIllIllIllIllIIlII.isHovered()) {
                    final Color llllllllllllllIIllIllIllIllIlIII = new Color(255, 255, 255, 64);
                }
                else {
                    llllllllllllllIIllIllIllIllIIlll = new Color(255, 255, 255, 0);
                }
                llllllllllllllIIllIllIllIllIIlII.getInterface().fillRect(llllllllllllllIIllIllIllIllIIlII.getRect(), llllllllllllllIIllIllIllIllIIlll, llllllllllllllIIllIllIllIllIIlll, llllllllllllllIIllIllIllIllIIlll, llllllllllllllIIllIllIllIllIIlll);
            }
            final Point llllllllllllllIIllIllIllIllIIllI = new Point(llllllllllllllIIllIllIllIllIIIII.getLocation());
            llllllllllllllIIllIllIllIllIIllI.translate(0, this.border);
            llllllllllllllIIllIllIllIllIIlII.getInterface().drawString(llllllllllllllIIllIllIllIllIIllI, llllllllllllllIIllIllIllIllIlllI, this.getFontColor(llllllllllllllIIllIllIllIllIIIlI));
        }
    }
}
