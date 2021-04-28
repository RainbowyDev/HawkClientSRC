package com.lukflug.panelstudio.theme;

import com.lukflug.panelstudio.*;
import java.awt.*;

public abstract class RendererBase implements Renderer
{
    protected final /* synthetic */ int right;
    protected final /* synthetic */ int offset;
    protected final /* synthetic */ int height;
    protected /* synthetic */ ColorScheme scheme;
    protected final /* synthetic */ int border;
    protected final /* synthetic */ int left;
    
    @Override
    public void renderTitle(final Context lllllllllllllllIlIlIlIlllIIIllll, final String lllllllllllllllIlIlIlIlllIIlIlII, final boolean lllllllllllllllIlIlIlIlllIIIllIl, final boolean lllllllllllllllIlIlIlIlllIIlIIlI, final boolean lllllllllllllllIlIlIlIlllIIlIIIl) {
        this.renderTitle(lllllllllllllllIlIlIlIlllIIIllll, lllllllllllllllIlIlIlIlllIIlIlII, lllllllllllllllIlIlIlIlllIIIllIl, lllllllllllllllIlIlIlIlllIIlIIlI);
    }
    
    @Override
    public int getRightBorder(final boolean lllllllllllllllIlIlIlIlllIlllIIl) {
        if (lllllllllllllllIlIlIlIlllIlllIIl) {
            return this.right;
        }
        return 0;
    }
    
    @Override
    public void renderTitle(final Context lllllllllllllllIlIlIlIlllIlIIlII, final String lllllllllllllllIlIlIlIlllIlIIIll, final boolean lllllllllllllllIlIlIlIlllIlIIIlI, final boolean lllllllllllllllIlIlIlIlllIIlllII) {
        this.renderRect(lllllllllllllllIlIlIlIlllIlIIlII, lllllllllllllllIlIlIlIlllIlIIIll, lllllllllllllllIlIlIlIlllIlIIIlI, lllllllllllllllIlIlIlIlllIIlllII, lllllllllllllllIlIlIlIlllIlIIlII.getRect(), true);
    }
    
    @Override
    public int getLeftBorder(final boolean lllllllllllllllIlIlIlIlllIllllll) {
        if (lllllllllllllllIlIlIlIlllIllllll) {
            return this.left;
        }
        return 0;
    }
    
    @Override
    public void restoreColorScheme() {
        this.scheme = null;
    }
    
    @Override
    public void renderTitle(final Context lllllllllllllllIlIlIlIlllIllIIIl, final String lllllllllllllllIlIlIlIlllIlIllII, final boolean lllllllllllllllIlIlIlIlllIlIllll) {
        this.renderTitle(lllllllllllllllIlIlIlIlllIllIIIl, lllllllllllllllIlIlIlIlllIlIllII, lllllllllllllllIlIlIlIlllIlIllll, false);
    }
    
    @Override
    public Color getFontColor(final boolean lllllllllllllllIlIlIlIlllIIIIIII) {
        return this.getColorScheme().getFontColor();
    }
    
    protected ColorScheme getColorScheme() {
        if (this.scheme == null) {
            return this.getDefaultColorScheme();
        }
        return this.scheme;
    }
    
    @Override
    public int getBottomBorder() {
        return 0;
    }
    
    @Override
    public int getBorder() {
        return this.border;
    }
    
    @Override
    public int getOffset() {
        return this.offset;
    }
    
    @Override
    public int renderScrollBar(final Context lllllllllllllllIlIlIlIlllIIIlIIl, final boolean lllllllllllllllIlIlIlIlllIIIlIII, final boolean lllllllllllllllIlIlIlIlllIIIIlll, final boolean lllllllllllllllIlIlIlIlllIIIIllI, final int lllllllllllllllIlIlIlIlllIIIIlIl, final int lllllllllllllllIlIlIlIlllIIIIIll) {
        return lllllllllllllllIlIlIlIlllIIIIIll;
    }
    
    @Override
    public int getHeight(final boolean lllllllllllllllIlIlIlIllllIIlIll) {
        return this.height;
    }
    
    public RendererBase(final int lllllllllllllllIlIlIlIllllIlIIlI, final int lllllllllllllllIlIlIlIllllIlIlll, final int lllllllllllllllIlIlIlIllllIlIllI, final int lllllllllllllllIlIlIlIllllIlIlIl, final int lllllllllllllllIlIlIlIllllIIlllI) {
        this.scheme = null;
        this.height = lllllllllllllllIlIlIlIllllIlIIlI;
        this.offset = lllllllllllllllIlIlIlIllllIlIlll;
        this.border = lllllllllllllllIlIlIlIllllIlIllI;
        this.left = lllllllllllllllIlIlIlIllllIlIlIl;
        this.right = lllllllllllllllIlIlIlIllllIIlllI;
    }
    
    @Override
    public void overrideColorScheme(final ColorScheme lllllllllllllllIlIlIlIllIllllIIl) {
        this.scheme = lllllllllllllllIlIlIlIllIllllIIl;
    }
}
