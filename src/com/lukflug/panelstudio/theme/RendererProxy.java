package com.lukflug.panelstudio.theme;

import com.lukflug.panelstudio.*;
import java.awt.*;

public abstract class RendererProxy implements Renderer
{
    @Override
    public void renderBorder(final Context llllllllllllllIIlIllIIIIIIlIIlll, final boolean llllllllllllllIIlIllIIIIIIlIIllI, final boolean llllllllllllllIIlIllIIIIIIlIlIlI, final boolean llllllllllllllIIlIllIIIIIIlIIlII) {
        this.getRenderer().renderBorder(llllllllllllllIIlIllIIIIIIlIIlll, llllllllllllllIIlIllIIIIIIlIIllI, llllllllllllllIIlIllIIIIIIlIlIlI, llllllllllllllIIlIllIIIIIIlIIlII);
    }
    
    @Override
    public int getBottomBorder() {
        return this.getRenderer().getBottomBorder();
    }
    
    @Override
    public Color getMainColor(final boolean llllllllllllllIIlIllIIIIIIIIIlll, final boolean llllllllllllllIIlIllIIIIIIIIIllI) {
        return this.getRenderer().getMainColor(llllllllllllllIIlIllIIIIIIIIIlll, llllllllllllllIIlIllIIIIIIIIIllI);
    }
    
    @Override
    public int getBorder() {
        return this.getRenderer().getBorder();
    }
    
    @Override
    public Color getFontColor(final boolean llllllllllllllIIlIlIlllllllllIlI) {
        return this.getRenderer().getFontColor(llllllllllllllIIlIlIlllllllllIlI);
    }
    
    @Override
    public Color getBackgroundColor(final boolean llllllllllllllIIlIllIIIIIIIIIIlI) {
        return this.getRenderer().getBackgroundColor(llllllllllllllIIlIllIIIIIIIIIIlI);
    }
    
    @Override
    public void renderTitle(final Context llllllllllllllIIlIllIIIIIllIlIll, final String llllllllllllllIIlIllIIIIIllIIlIl, final boolean llllllllllllllIIlIllIIIIIllIlIIl, final boolean llllllllllllllIIlIllIIIIIllIlIII) {
        this.getRenderer().renderTitle(llllllllllllllIIlIllIIIIIllIlIll, llllllllllllllIIlIllIIIIIllIIlIl, llllllllllllllIIlIllIIIIIllIlIIl, llllllllllllllIIlIllIIIIIllIlIII);
    }
    
    @Override
    public void renderRect(final Context llllllllllllllIIlIllIIIIIlIIlIII, final String llllllllllllllIIlIllIIIIIlIIIIII, final boolean llllllllllllllIIlIllIIIIIIllllll, final boolean llllllllllllllIIlIllIIIIIlIIIlIl, final Rectangle llllllllllllllIIlIllIIIIIlIIIlII, final boolean llllllllllllllIIlIllIIIIIlIIIIll) {
        this.getRenderer().renderRect(llllllllllllllIIlIllIIIIIlIIlIII, llllllllllllllIIlIllIIIIIlIIIIII, llllllllllllllIIlIllIIIIIIllllll, llllllllllllllIIlIllIIIIIlIIIlIl, llllllllllllllIIlIllIIIIIlIIIlII, llllllllllllllIIlIllIIIIIlIIIIll);
    }
    
    @Override
    public int getHeight(final boolean llllllllllllllIIlIllIIIIlIlIllII) {
        return this.getRenderer().getHeight(llllllllllllllIIlIllIIIIlIlIllII);
    }
    
    @Override
    public ColorScheme getDefaultColorScheme() {
        return this.getRenderer().getDefaultColorScheme();
    }
    
    @Override
    public void renderTitle(final Context llllllllllllllIIlIllIIIIIlllIlII, final String llllllllllllllIIlIllIIIIIlllIlll, final boolean llllllllllllllIIlIllIIIIIlllIIlI) {
        this.getRenderer().renderTitle(llllllllllllllIIlIllIIIIIlllIlII, llllllllllllllIIlIllIIIIIlllIlll, llllllllllllllIIlIllIIIIIlllIIlI);
    }
    
    protected abstract Renderer getRenderer();
    
    @Override
    public void restoreColorScheme() {
        this.getRenderer().restoreColorScheme();
    }
    
    @Override
    public int getOffset() {
        return this.getRenderer().getOffset();
    }
    
    @Override
    public int getLeftBorder(final boolean llllllllllllllIIlIllIIIIlIIIlIIl) {
        return this.getRenderer().getLeftBorder(llllllllllllllIIlIllIIIIlIIIlIIl);
    }
    
    @Override
    public void overrideColorScheme(final ColorScheme llllllllllllllIIlIlIllllllllIIIl) {
        this.getRenderer().overrideColorScheme(llllllllllllllIIlIlIllllllllIIIl);
    }
    
    @Override
    public void renderTitle(final Context llllllllllllllIIlIllIIIIIlIlIlIl, final String llllllllllllllIIlIllIIIIIlIllIlI, final boolean llllllllllllllIIlIllIIIIIlIlIIll, final boolean llllllllllllllIIlIllIIIIIlIllIII, final boolean llllllllllllllIIlIllIIIIIlIlIlll) {
        this.getRenderer().renderTitle(llllllllllllllIIlIllIIIIIlIlIlIl, llllllllllllllIIlIllIIIIIlIllIlI, llllllllllllllIIlIllIIIIIlIlIIll, llllllllllllllIIlIllIIIIIlIllIII, llllllllllllllIIlIllIIIIIlIlIlll);
    }
    
    @Override
    public int getRightBorder(final boolean llllllllllllllIIlIllIIIIlIIIIIIl) {
        return this.getRenderer().getRightBorder(llllllllllllllIIlIllIIIIlIIIIIIl);
    }
    
    @Override
    public int renderScrollBar(final Context llllllllllllllIIlIllIIIIIIIlIlII, final boolean llllllllllllllIIlIllIIIIIIIllIlI, final boolean llllllllllllllIIlIllIIIIIIIlIIlI, final boolean llllllllllllllIIlIllIIIIIIIlIIIl, final int llllllllllllllIIlIllIIIIIIIlIIII, final int llllllllllllllIIlIllIIIIIIIlIllI) {
        return this.getRenderer().renderScrollBar(llllllllllllllIIlIllIIIIIIIlIlII, llllllllllllllIIlIllIIIIIIIllIlI, llllllllllllllIIlIllIIIIIIIlIIlI, llllllllllllllIIlIllIIIIIIIlIIIl, llllllllllllllIIlIllIIIIIIIlIIII, llllllllllllllIIlIllIIIIIIIlIllI);
    }
    
    @Override
    public void renderBackground(final Context llllllllllllllIIlIllIIIIIIllIlII, final boolean llllllllllllllIIlIllIIIIIIllIIll) {
        this.getRenderer().renderBackground(llllllllllllllIIlIllIIIIIIllIlII, llllllllllllllIIlIllIIIIIIllIIll);
    }
}
