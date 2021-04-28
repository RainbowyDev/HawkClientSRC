package com.lukflug.panelstudio.tabgui;

import com.lukflug.panelstudio.*;
import java.awt.*;
import java.util.*;

public class TabGUIContainer implements TabGUIComponent
{
    protected /* synthetic */ TabGUIRenderer renderer;
    protected /* synthetic */ Animation selectedAnimation;
    protected /* synthetic */ String title;
    protected /* synthetic */ List<TabGUIComponent> components;
    protected /* synthetic */ int selected;
    protected /* synthetic */ boolean childOpen;
    
    @Override
    public boolean select() {
        return true;
    }
    
    @Override
    public boolean isActive() {
        return false;
    }
    
    @Override
    public void render(final Context llllllllllllllIlIllllIlIlIIIllII) {
        this.getHeight(llllllllllllllIlIllllIlIlIIIllII);
        int llllllllllllllIlIllllIlIlIIIlIll = this.selected * this.renderer.getHeight();
        if (this.selectedAnimation != null) {
            llllllllllllllIlIllllIlIlIIIlIll = (int)(this.selectedAnimation.getValue() * this.renderer.getHeight());
        }
        this.renderer.renderBackground(llllllllllllllIlIllllIlIlIIIllII, llllllllllllllIlIllllIlIlIIIlIll, this.renderer.getHeight());
        for (int llllllllllllllIlIllllIlIlIIIlIlI = 0; llllllllllllllIlIllllIlIlIIIlIlI < this.components.size(); ++llllllllllllllIlIllllIlIlIIIlIlI) {
            final TabGUIComponent llllllllllllllIlIllllIlIlIIIlIIl = this.components.get(llllllllllllllIlIllllIlIlIIIlIlI);
            this.renderer.renderCaption(llllllllllllllIlIllllIlIlIIIllII, llllllllllllllIlIllllIlIlIIIlIIl.getTitle(), llllllllllllllIlIllllIlIlIIIlIlI, this.renderer.getHeight(), llllllllllllllIlIllllIlIlIIIlIIl.isActive());
        }
        if (this.childOpen) {
            this.components.get(this.selected).render(this.getSubContext(llllllllllllllIlIllllIlIlIIIllII));
        }
    }
    
    @Override
    public void getHeight(final Context llllllllllllllIlIllllIlIIllIlIIl) {
        llllllllllllllIlIllllIlIIllIlIIl.setHeight(this.renderer.getHeight() * this.components.size());
    }
    
    @Override
    public void releaseFocus() {
    }
    
    @Override
    public void enter(final Context llllllllllllllIlIllllIlIIllIIIll) {
        this.getHeight(llllllllllllllIlIllllIlIIllIIIll);
    }
    
    protected Context getSubContext(final Context llllllllllllllIlIllllIlIIlIlIlII) {
        final Point llllllllllllllIlIllllIlIIlIlIIll = llllllllllllllIlIllllIlIIlIlIlII.getPos();
        llllllllllllllIlIllllIlIIlIlIIll.translate(llllllllllllllIlIllllIlIIlIlIlII.getSize().width + this.renderer.getBorder(), this.selected * this.renderer.getHeight());
        return new Context(llllllllllllllIlIllllIlIIlIlIlII.getInterface(), llllllllllllllIlIllllIlIIlIlIlII.getSize().width, llllllllllllllIlIllllIlIIlIlIIll, llllllllllllllIlIllllIlIIlIlIlII.hasFocus(), llllllllllllllIlIllllIlIIlIlIlII.onTop());
    }
    
    @Override
    public void exit(final Context llllllllllllllIlIllllIlIIlIllIll) {
        this.getHeight(llllllllllllllIlIllllIlIIlIllIll);
    }
    
    public TabGUIContainer(final String llllllllllllllIlIllllIlIlIIllllI, final TabGUIRenderer llllllllllllllIlIllllIlIlIlIIIIl, final Animation llllllllllllllIlIllllIlIlIlIIIII) {
        this.childOpen = false;
        this.selected = 0;
        this.selectedAnimation = null;
        this.title = llllllllllllllIlIllllIlIlIIllllI;
        this.renderer = llllllllllllllIlIllllIlIlIlIIIIl;
        this.components = new ArrayList<TabGUIComponent>();
        if (llllllllllllllIlIllllIlIlIlIIIII != null) {
            llllllllllllllIlIllllIlIlIlIIIII.initValue(this.selected);
            this.selectedAnimation = llllllllllllllIlIllllIlIlIlIIIII;
        }
    }
    
    @Override
    public void handleKey(final Context llllllllllllllIlIllllIlIIllllIII, final int llllllllllllllIlIllllIlIIlllIlII) {
        this.getHeight(llllllllllllllIlIllllIlIIllllIII);
        if (this.renderer.isEscapeKey(llllllllllllllIlIllllIlIIlllIlII)) {
            this.childOpen = false;
        }
        else if (!this.childOpen) {
            if (this.renderer.isUpKey(llllllllllllllIlIllllIlIIlllIlII)) {
                if (--this.selected < 0) {
                    this.selected = this.components.size() - 1;
                }
                if (this.selectedAnimation != null) {
                    this.selectedAnimation.setValue(this.selected);
                }
            }
            else if (this.renderer.isDownKey(llllllllllllllIlIllllIlIIlllIlII)) {
                if (++this.selected >= this.components.size()) {
                    this.selected = 0;
                }
                if (this.selectedAnimation != null) {
                    this.selectedAnimation.setValue(this.selected);
                }
            }
            else if (this.renderer.isSelectKey(llllllllllllllIlIllllIlIIlllIlII) && this.components.get(this.selected).select()) {
                this.childOpen = true;
            }
        }
        else {
            this.components.get(this.selected).handleKey(this.getSubContext(llllllllllllllIlIllllIlIIllllIII), llllllllllllllIlIllllIlIIlllIlII);
        }
    }
    
    public void addComponent(final TabGUIComponent llllllllllllllIlIllllIlIlIIllIII) {
        this.components.add(llllllllllllllIlIllllIlIlIIllIII);
    }
    
    @Override
    public void handleScroll(final Context llllllllllllllIlIllllIlIIllIllIl, final int llllllllllllllIlIllllIlIIllIllll) {
        this.getHeight(llllllllllllllIlIllllIlIIllIllIl);
    }
    
    @Override
    public void handleButton(final Context llllllllllllllIlIllllIlIIlllllIl, final int llllllllllllllIlIllllIlIIlllllll) {
        this.getHeight(llllllllllllllIlIllllIlIIlllllIl);
    }
    
    @Override
    public String getTitle() {
        return this.title;
    }
}
