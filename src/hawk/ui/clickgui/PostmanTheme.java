package hawk.ui.clickgui;

import com.lukflug.panelstudio.theme.*;
import com.lukflug.panelstudio.*;
import java.awt.*;
import hawk.util.*;

public class PostmanTheme implements Theme
{
    protected /* synthetic */ Renderer containerRenderer;
    protected /* synthetic */ Renderer panelRenderer;
    protected /* synthetic */ ColorScheme scheme;
    protected /* synthetic */ Renderer componentRenderer;
    
    @Override
    public Renderer getComponentRenderer() {
        return this.componentRenderer;
    }
    
    @Override
    public Renderer getPanelRenderer() {
        return this.panelRenderer;
    }
    
    @Override
    public Renderer getContainerRenderer() {
        return this.containerRenderer;
    }
    
    public PostmanTheme(final ColorScheme llllllllllllllllIlllIIlIIlIllIII, final int llllllllllllllllIlllIIlIIlIlIIll, final int llllllllllllllllIlllIIlIIlIlIllI) {
        this.scheme = llllllllllllllllIlllIIlIIlIllIII;
        this.panelRenderer = new ComponentRenderer(0, llllllllllllllllIlllIIlIIlIlIIll, llllllllllllllllIlllIIlIIlIlIllI);
        this.containerRenderer = new ComponentRenderer(1, llllllllllllllllIlllIIlIIlIlIIll, llllllllllllllllIlllIIlIIlIlIllI);
        this.componentRenderer = new ComponentRenderer(2, llllllllllllllllIlllIIlIIlIlIIll, llllllllllllllllIlllIIlIIlIlIllI);
    }
    
    protected class ComponentRenderer extends RendererBase
    {
        protected final /* synthetic */ int level;
        protected final /* synthetic */ int border;
        
        @Override
        public Color getMainColor(final boolean lllllllllllllllIlIlIIIlIllIIlIIl, final boolean lllllllllllllllIlIlIIIlIllIIlIII) {
            Color lllllllllllllllIlIlIIIlIllIIIllI = null;
            if (lllllllllllllllIlIlIIIlIllIIlIII && this.level > 0) {
                final Color lllllllllllllllIlIlIIIlIllIIIlll = this.getColorScheme().getActiveColor();
            }
            else {
                lllllllllllllllIlIlIIIlIllIIIllI = this.getColorScheme().getBackgroundColor();
            }
            if (!lllllllllllllllIlIlIIIlIllIIlIII && this.level < 2) {
                lllllllllllllllIlIlIIIlIllIIIllI = this.getColorScheme().getInactiveColor();
            }
            if (lllllllllllllllIlIlIIIlIllIIlIII && this.level < 1) {
                lllllllllllllllIlIlIIIlIllIIIllI = this.getColorScheme().getOutlineColor();
            }
            lllllllllllllllIlIlIIIlIllIIIllI = new Color(lllllllllllllllIlIlIIIlIllIIIllI.getRed(), lllllllllllllllIlIlIIIlIllIIIllI.getGreen(), lllllllllllllllIlIlIIIlIllIIIllI.getBlue(), this.getColorScheme().getOpacity());
            return lllllllllllllllIlIlIIIlIllIIIllI;
        }
        
        @Override
        public void renderBackground(final Context lllllllllllllllIlIlIIIlIlllIIIlI, final boolean lllllllllllllllIlIlIIIlIllIlllIl) {
            final Color lllllllllllllllIlIlIIIlIlllIIIII = this.getBackgroundColor(lllllllllllllllIlIlIIIlIllIlllIl);
            lllllllllllllllIlIlIIIlIlllIIIlI.getInterface().fillRect(lllllllllllllllIlIlIIIlIlllIIIlI.getRect(), lllllllllllllllIlIlIIIlIlllIIIII, lllllllllllllllIlIlIIIlIlllIIIII, lllllllllllllllIlIlIIIlIlllIIIII, lllllllllllllllIlIlIIIlIlllIIIII);
        }
        
        @Override
        public Color getBackgroundColor(final boolean lllllllllllllllIlIlIIIlIlIllllll) {
            Color lllllllllllllllIlIlIIIlIlIlllllI = this.getColorScheme().getInactiveColor();
            lllllllllllllllIlIlIIIlIlIlllllI = new Color(lllllllllllllllIlIlIIIlIlIlllllI.getRed(), lllllllllllllllIlIlIIIlIlIlllllI.getGreen(), lllllllllllllllIlIlIIIlIlIlllllI.getBlue(), this.getColorScheme().getOpacity());
            return lllllllllllllllIlIlIIIlIlIlllllI;
        }
        
        @Override
        public ColorScheme getDefaultColorScheme() {
            return PostmanTheme.this.scheme;
        }
        
        @Override
        public void renderBorder(final Context lllllllllllllllIlIlIIIlIllIlIIII, final boolean lllllllllllllllIlIlIIIlIllIlIlIl, final boolean lllllllllllllllIlIlIIIlIllIlIlII, final boolean lllllllllllllllIlIlIIIlIllIlIIll) {
            final Color lllllllllllllllIlIlIIIlIllIlIIlI = this.getDefaultColorScheme().getOutlineColor();
            if (this.level == 1 && lllllllllllllllIlIlIIIlIllIlIIll) {
                lllllllllllllllIlIlIIIlIllIlIIII.getInterface().fillRect(new Rectangle(lllllllllllllllIlIlIIIlIllIlIIII.getPos(), new Dimension(1, lllllllllllllllIlIlIIIlIllIlIIII.getSize().height)), lllllllllllllllIlIlIIIlIllIlIIlI, lllllllllllllllIlIlIIIlIllIlIIlI, lllllllllllllllIlIlIIIlIllIlIIlI, lllllllllllllllIlIlIIIlIllIlIIlI);
                lllllllllllllllIlIlIIIlIllIlIIII.getInterface().fillRect(new Rectangle(new Point(lllllllllllllllIlIlIIIlIllIlIIII.getPos().x + lllllllllllllllIlIlIIIlIllIlIIII.getSize().width - 1, lllllllllllllllIlIlIIIlIllIlIIII.getPos().y), new Dimension(1, lllllllllllllllIlIlIIIlIllIlIIII.getSize().height)), lllllllllllllllIlIlIIIlIllIlIIlI, lllllllllllllllIlIlIIIlIllIlIIlI, lllllllllllllllIlIlIIIlIllIlIIlI, lllllllllllllllIlIlIIIlIllIlIIlI);
            }
        }
        
        @Override
        public void renderRect(final Context lllllllllllllllIlIlIIIlIlllllIlI, final String lllllllllllllllIlIlIIIlIlllIlllI, final boolean lllllllllllllllIlIlIIIlIlllIllIl, final boolean lllllllllllllllIlIlIIIlIlllIllII, final Rectangle lllllllllllllllIlIlIIIlIlllIlIll, final boolean lllllllllllllllIlIlIIIlIllllIlIl) {
            final Color lllllllllllllllIlIlIIIlIllllIlII = this.getMainColor(lllllllllllllllIlIlIIIlIlllIllIl, lllllllllllllllIlIlIIIlIlllIllII);
            lllllllllllllllIlIlIIIlIlllllIlI.getInterface().fillRect(lllllllllllllllIlIlIIIlIlllIlIll, lllllllllllllllIlIlIIIlIllllIlII, lllllllllllllllIlIlIIIlIllllIlII, lllllllllllllllIlIlIIIlIllllIlII, lllllllllllllllIlIlIIIlIllllIlII);
            if (lllllllllllllllIlIlIIIlIllllIlIl) {
                Color lllllllllllllllIlIlIIIlIllllIIlI = null;
                if (lllllllllllllllIlIlIIIlIlllllIlI.isHovered()) {
                    final Color lllllllllllllllIlIlIIIlIllllIIll = new JColor(114, 137, 218, 100);
                }
                else {
                    lllllllllllllllIlIlIIIlIllllIIlI = new Color(255, 255, 255, 0);
                }
                lllllllllllllllIlIlIIIlIlllllIlI.getInterface().fillRect(lllllllllllllllIlIlIIIlIlllllIlI.getRect(), lllllllllllllllIlIlIIIlIllllIIlI, lllllllllllllllIlIlIIIlIllllIIlI, lllllllllllllllIlIlIIIlIllllIIlI, lllllllllllllllIlIlIIIlIllllIIlI);
            }
            final Point lllllllllllllllIlIlIIIlIllllIIIl = new Point(lllllllllllllllIlIlIIIlIlllIlIll.getLocation());
            lllllllllllllllIlIlIIIlIllllIIIl.translate(0, this.border);
            lllllllllllllllIlIlIIIlIlllllIlI.getInterface().drawString(lllllllllllllllIlIlIIIlIllllIIIl, lllllllllllllllIlIlIIIlIlllIlllI, this.getFontColor(lllllllllllllllIlIlIIIlIlllIllIl));
        }
        
        public ComponentRenderer(final int lllllllllllllllIlIlIIIllIIIIIlll, final int lllllllllllllllIlIlIIIllIIIIIllI, final int lllllllllllllllIlIlIIIllIIIIlIlI) {
            super(lllllllllllllllIlIlIIIllIIIIIllI + 1, 1, 1, 0, 0);
            this.level = lllllllllllllllIlIlIIIllIIIIIlll;
            this.border = lllllllllllllllIlIlIIIllIIIIlIlI;
        }
    }
}
