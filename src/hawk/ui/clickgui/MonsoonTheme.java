package hawk.ui.clickgui;

import com.lukflug.panelstudio.theme.*;
import com.lukflug.panelstudio.*;
import java.awt.*;
import hawk.util.*;

public class MonsoonTheme implements Theme
{
    protected /* synthetic */ ColorScheme scheme;
    protected final /* synthetic */ boolean gradient;
    protected /* synthetic */ Renderer componentRenderer;
    protected /* synthetic */ Renderer panelRenderer;
    
    @Override
    public Renderer getPanelRenderer() {
        return this.panelRenderer;
    }
    
    @Override
    public Renderer getContainerRenderer() {
        return this.componentRenderer;
    }
    
    public MonsoonTheme(final ColorScheme llllllllllllllIlIIlIllIIllIlIIll, final boolean llllllllllllllIlIIlIllIIllIlIIlI, final int llllllllllllllIlIIlIllIIllIIllIl, final int llllllllllllllIlIIlIllIIllIIllII) {
        this.scheme = llllllllllllllIlIIlIllIIllIlIIll;
        this.gradient = false;
        this.panelRenderer = new ComponentRenderer(true, llllllllllllllIlIIlIllIIllIIllIl, llllllllllllllIlIIlIllIIllIIllII);
        this.componentRenderer = new ComponentRenderer(false, llllllllllllllIlIIlIllIIllIIllIl, llllllllllllllIlIIlIllIIllIIllII);
    }
    
    @Override
    public Renderer getComponentRenderer() {
        return this.componentRenderer;
    }
    
    protected class ComponentRenderer extends RendererBase
    {
        protected final /* synthetic */ boolean panel;
        
        @Override
        public void renderTitle(final Context lllllllllllllllIllIIllIlIIIllIIl, final String lllllllllllllllIllIIllIlIIIllIII, final boolean lllllllllllllllIllIIllIlIIIlIlll, final boolean lllllllllllllllIllIIllIlIIlIIIll, final boolean lllllllllllllllIllIIllIlIIlIIIlI) {
            super.renderTitle(lllllllllllllllIllIIllIlIIIllIIl, lllllllllllllllIllIIllIlIIIllIII, lllllllllllllllIllIIllIlIIIlIlll, lllllllllllllllIllIIllIlIIlIIIll, lllllllllllllllIllIIllIlIIlIIIlI);
            if (!this.panel) {
                final Color lllllllllllllllIllIIllIlIIlIIIIl = this.getFontColor(lllllllllllllllIllIIllIlIIlIIIll);
                Point lllllllllllllllIllIIllIlIIIllIll = null;
                Point lllllllllllllllIllIIllIlIIIlllIl = null;
                Point lllllllllllllllIllIIllIlIIIlllll = null;
                if (lllllllllllllllIllIIllIlIIlIIIlI) {
                    final Point lllllllllllllllIllIIllIlIIIlllII = new Point(lllllllllllllllIllIIllIlIIIllIIl.getPos().x + lllllllllllllllIllIIllIlIIIllIIl.getSize().width - 2, lllllllllllllllIllIIllIlIIIllIIl.getPos().y + lllllllllllllllIllIIllIlIIIllIIl.getSize().height / 4);
                    final Point lllllllllllllllIllIIllIlIIIllllI = new Point(lllllllllllllllIllIIllIlIIIllIIl.getPos().x + lllllllllllllllIllIIllIlIIIllIIl.getSize().width - lllllllllllllllIllIIllIlIIIllIIl.getSize().height / 2, lllllllllllllllIllIIllIlIIIllIIl.getPos().y + lllllllllllllllIllIIllIlIIIllIIl.getSize().height * 3 / 4);
                    final Point lllllllllllllllIllIIllIlIIlIIIII = new Point(lllllllllllllllIllIIllIlIIIllIIl.getPos().x + lllllllllllllllIllIIllIlIIIllIIl.getSize().width - lllllllllllllllIllIIllIlIIIllIIl.getSize().height + 2, lllllllllllllllIllIIllIlIIIllIIl.getPos().y + lllllllllllllllIllIIllIlIIIllIIl.getSize().height / 4);
                }
                else {
                    lllllllllllllllIllIIllIlIIIllIll = new Point(lllllllllllllllIllIIllIlIIIllIIl.getPos().x + lllllllllllllllIllIIllIlIIIllIIl.getSize().width - lllllllllllllllIllIIllIlIIIllIIl.getSize().height * 3 / 4, lllllllllllllllIllIIllIlIIIllIIl.getPos().y + 2);
                    lllllllllllllllIllIIllIlIIIlllIl = new Point(lllllllllllllllIllIIllIlIIIllIIl.getPos().x + lllllllllllllllIllIIllIlIIIllIIl.getSize().width - lllllllllllllllIllIIllIlIIIllIIl.getSize().height / 4, lllllllllllllllIllIIllIlIIIllIIl.getPos().y + lllllllllllllllIllIIllIlIIIllIIl.getSize().height / 2);
                    lllllllllllllllIllIIllIlIIIlllll = new Point(lllllllllllllllIllIIllIlIIIllIIl.getPos().x + lllllllllllllllIllIIllIlIIIllIIl.getSize().width - lllllllllllllllIllIIllIlIIIllIIl.getSize().height * 3 / 4, lllllllllllllllIllIIllIlIIIllIIl.getPos().y + lllllllllllllllIllIIllIlIIIllIIl.getSize().height - 2);
                }
                lllllllllllllllIllIIllIlIIIllIIl.getInterface().fillTriangle(lllllllllllllllIllIIllIlIIIlllll, lllllllllllllllIllIIllIlIIIlllIl, lllllllllllllllIllIIllIlIIIllIll, lllllllllllllllIllIIllIlIIlIIIIl, lllllllllllllllIllIIllIlIIlIIIIl, lllllllllllllllIllIIllIlIIlIIIIl);
            }
        }
        
        @Override
        public void renderBackground(final Context lllllllllllllllIllIIllIIlllIlIIl, final boolean lllllllllllllllIllIIllIIlllIlIII) {
            if (this.panel) {
                final Color lllllllllllllllIllIIllIIlllIlIll = this.getBackgroundColor(lllllllllllllllIllIIllIIlllIlIII);
                lllllllllllllllIllIIllIIlllIlIIl.getInterface().fillRect(lllllllllllllllIllIIllIIlllIlIIl.getRect(), lllllllllllllllIllIIllIIlllIlIll, lllllllllllllllIllIIllIIlllIlIll, lllllllllllllllIllIIllIIlllIlIll, lllllllllllllllIllIIllIIlllIlIll);
            }
        }
        
        @Override
        public void renderRect(final Context lllllllllllllllIllIIllIlIIIIIllI, final String lllllllllllllllIllIIllIIlllllIIl, final boolean lllllllllllllllIllIIllIIlllllIII, final boolean lllllllllllllllIllIIllIlIIIIIIll, final Rectangle lllllllllllllllIllIIllIlIIIIIIlI, final boolean lllllllllllllllIllIIllIlIIIIIIIl) {
            if (this.panel || lllllllllllllllIllIIllIlIIIIIIll) {
                final Color lllllllllllllllIllIIllIlIIIIIIII = this.getMainColor(lllllllllllllllIllIIllIIlllllIII, true);
                final Color lllllllllllllllIllIIllIIllllllll = this.getBackgroundColor(lllllllllllllllIllIIllIIlllllIII);
                if (MonsoonTheme.this.gradient && this.panel) {
                    lllllllllllllllIllIIllIlIIIIIllI.getInterface().fillRect(lllllllllllllllIllIIllIlIIIIIIlI, lllllllllllllllIllIIllIlIIIIIIII, lllllllllllllllIllIIllIlIIIIIIII, lllllllllllllllIllIIllIIllllllll, lllllllllllllllIllIIllIIllllllll);
                }
                else {
                    lllllllllllllllIllIIllIlIIIIIllI.getInterface().fillRect(lllllllllllllllIllIIllIlIIIIIIlI, lllllllllllllllIllIIllIlIIIIIIII, lllllllllllllllIllIIllIlIIIIIIII, lllllllllllllllIllIIllIlIIIIIIII, lllllllllllllllIllIIllIlIIIIIIII);
                }
            }
            if (!this.panel && lllllllllllllllIllIIllIlIIIIIIIl) {
                Color lllllllllllllllIllIIllIIllllllIl = null;
                if (lllllllllllllllIllIIllIlIIIIIllI.isHovered()) {
                    final Color lllllllllllllllIllIIllIIlllllllI = new JColor(114, 137, 218, 100);
                }
                else {
                    lllllllllllllllIllIIllIIllllllIl = new Color(255, 255, 255, 0);
                }
                lllllllllllllllIllIIllIlIIIIIllI.getInterface().fillRect(lllllllllllllllIllIIllIlIIIIIllI.getRect(), lllllllllllllllIllIIllIIllllllIl, lllllllllllllllIllIIllIIllllllIl, lllllllllllllllIllIIllIIllllllIl, lllllllllllllllIllIIllIIllllllIl);
            }
            final Point lllllllllllllllIllIIllIIllllllII = new Point(lllllllllllllllIllIIllIlIIIIIIlI.getLocation());
            lllllllllllllllIllIIllIIllllllII.translate(0, this.getOffset());
            lllllllllllllllIllIIllIlIIIIIllI.getInterface().drawString(lllllllllllllllIllIIllIIllllllII, lllllllllllllllIllIIllIIlllllIIl, this.getFontColor(lllllllllllllllIllIIllIIlllllIII));
        }
        
        @Override
        public Color getBackgroundColor(final boolean lllllllllllllllIllIIllIIllIlIlll) {
            final Color lllllllllllllllIllIIllIIllIlIllI = this.getColorScheme().getBackgroundColor();
            return new Color(lllllllllllllllIllIIllIIllIlIllI.getRed(), lllllllllllllllIllIIllIIllIlIllI.getGreen(), lllllllllllllllIllIIllIIllIlIllI.getBlue(), this.getColorScheme().getOpacity());
        }
        
        @Override
        public void renderBorder(final Context lllllllllllllllIllIIllIIlllIIlIl, final boolean lllllllllllllllIllIIllIIlllIIlII, final boolean lllllllllllllllIllIIllIIlllIIIll, final boolean lllllllllllllllIllIIllIIlllIIIlI) {
        }
        
        @Override
        public Color getMainColor(final boolean lllllllllllllllIllIIllIIllIllllI, final boolean lllllllllllllllIllIIllIIllIlllIl) {
            if (lllllllllllllllIllIIllIIllIlllIl) {
                return this.getColorScheme().getActiveColor();
            }
            return new Color(0, 0, 0, 0);
        }
        
        @Override
        public ColorScheme getDefaultColorScheme() {
            return MonsoonTheme.this.scheme;
        }
        
        public ComponentRenderer(final boolean lllllllllllllllIllIIllIlIlIlIIlI, final int lllllllllllllllIllIIllIlIlIlIIIl, final int lllllllllllllllIllIIllIlIlIIlIll) {
            super(lllllllllllllllIllIIllIlIlIlIIIl + 2 * lllllllllllllllIllIIllIlIlIIlIll, lllllllllllllllIllIIllIlIlIIlIll, 0, 0, 0);
            this.panel = lllllllllllllllIllIIllIlIlIlIIlI;
        }
        
        @Override
        public void renderTitle(final Context lllllllllllllllIllIIllIlIIlllIII, final String lllllllllllllllIllIIllIlIIllIlll, final boolean lllllllllllllllIllIIllIlIIllllll, final boolean lllllllllllllllIllIIllIlIIllIlIl) {
            if (this.panel) {
                super.renderTitle(lllllllllllllllIllIIllIlIIlllIII, lllllllllllllllIllIIllIlIIllIlll, lllllllllllllllIllIIllIlIIllllll, lllllllllllllllIllIIllIlIIllIlIl);
            }
            else {
                Color lllllllllllllllIllIIllIlIIllllII = null;
                if (lllllllllllllllIllIIllIlIIlllIII.isHovered()) {
                    final Color lllllllllllllllIllIIllIlIIllllIl = new Color(0, 0, 0, 64);
                }
                else {
                    lllllllllllllllIllIIllIlIIllllII = new Color(0, 0, 0, 0);
                }
                lllllllllllllllIllIIllIlIIlllIII.getInterface().fillRect(lllllllllllllllIllIIllIlIIlllIII.getRect(), lllllllllllllllIllIIllIlIIllllII, lllllllllllllllIllIIllIlIIllllII, lllllllllllllllIllIIllIlIIllllII, lllllllllllllllIllIIllIlIIllllII);
                Color lllllllllllllllIllIIllIlIIlllIll = this.getFontColor(lllllllllllllllIllIIllIlIIllllll);
                if (lllllllllllllllIllIIllIlIIllIlIl) {
                    lllllllllllllllIllIIllIlIIlllIll = this.getMainColor(lllllllllllllllIllIIllIlIIllllll, true);
                }
                final Point lllllllllllllllIllIIllIlIIlllIlI = new Point(lllllllllllllllIllIIllIlIIlllIII.getPos());
                lllllllllllllllIllIIllIlIIlllIlI.translate(0, this.getOffset());
                lllllllllllllllIllIIllIlIIlllIII.getInterface().drawString(lllllllllllllllIllIIllIlIIlllIlI, lllllllllllllllIllIIllIlIIllIlll, lllllllllllllllIllIIllIlIIlllIll);
            }
        }
    }
}
