package com.lukflug.panelstudio;

import com.lukflug.panelstudio.theme.*;
import java.util.*;
import com.lukflug.panelstudio.settings.*;

public class ClickGUI implements PanelManager
{
    protected /* synthetic */ DescriptionRenderer descriptionRenderer;
    protected /* synthetic */ List<FixedComponent> permanentComponents;
    protected /* synthetic */ List<FixedComponent> components;
    protected /* synthetic */ Interface inter;
    
    public void render() {
        final List<FixedComponent> llllllllllllllIIIIlIIIlllIlIIlII = new ArrayList<FixedComponent>();
        for (final FixedComponent llllllllllllllIIIIlIIIlllIlIIIll : this.components) {
            llllllllllllllIIIIlIIIlllIlIIlII.add(llllllllllllllIIIIlIIIlllIlIIIll);
        }
        Context llllllllllllllIIIIlIIIlllIlIIIlI = null;
        int llllllllllllllIIIIlIIIlllIlIIIIl = 0;
        FixedComponent llllllllllllllIIIIlIIIlllIlIIIII = null;
        for (int llllllllllllllIIIIlIIIlllIIlllll = llllllllllllllIIIIlIIIlllIlIIlII.size() - 1; llllllllllllllIIIIlIIIlllIIlllll >= 0; --llllllllllllllIIIIlIIIlllIIlllll) {
            final FixedComponent llllllllllllllIIIIlIIIlllIIllllI = llllllllllllllIIIIlIIIlllIlIIlII.get(llllllllllllllIIIIlIIIlllIIlllll);
            final Context llllllllllllllIIIIlIIIlllIIlllIl = this.getContext(llllllllllllllIIIIlIIIlllIIllllI, true);
            llllllllllllllIIIIlIIIlllIIllllI.getHeight(llllllllllllllIIIIlIIIlllIIlllIl);
            if (llllllllllllllIIIIlIIIlllIIlllIl.isHovered()) {
                llllllllllllllIIIIlIIIlllIlIIIIl = llllllllllllllIIIIlIIIlllIIlllll;
                break;
            }
        }
        for (int llllllllllllllIIIIlIIIlllIIlllII = 0; llllllllllllllIIIIlIIIlllIIlllII < llllllllllllllIIIIlIIIlllIlIIlII.size(); ++llllllllllllllIIIIlIIIlllIIlllII) {
            final FixedComponent llllllllllllllIIIIlIIIlllIIllIll = llllllllllllllIIIIlIIIlllIlIIlII.get(llllllllllllllIIIIlIIIlllIIlllII);
            final Context llllllllllllllIIIIlIIIlllIIllIlI = this.getContext(llllllllllllllIIIIlIIIlllIIllIll, llllllllllllllIIIIlIIIlllIIlllII >= llllllllllllllIIIIlIIIlllIlIIIIl);
            llllllllllllllIIIIlIIIlllIIllIll.render(llllllllllllllIIIIlIIIlllIIllIlI);
            if (llllllllllllllIIIIlIIIlllIIllIlI.foucsRequested()) {
                llllllllllllllIIIIlIIIlllIlIIIII = llllllllllllllIIIIlIIIlllIIllIll;
            }
            if (llllllllllllllIIIIlIIIlllIIllIlI.isHovered() && llllllllllllllIIIIlIIIlllIIllIlI.getDescription() != null) {
                llllllllllllllIIIIlIIIlllIlIIIlI = llllllllllllllIIIIlIIIlllIIllIlI;
            }
        }
        if (llllllllllllllIIIIlIIIlllIlIIIII != null && this.components.remove(llllllllllllllIIIIlIIIlllIlIIIII)) {
            this.components.add(llllllllllllllIIIIlIIIlllIlIIIII);
        }
        if (llllllllllllllIIIIlIIIlllIlIIIlI != null && this.descriptionRenderer != null) {
            this.descriptionRenderer.renderDescription(llllllllllllllIIIIlIIIlllIlIIIlI);
        }
    }
    
    public ClickGUI(final Interface llllllllllllllIIIIlIIIllllIIIlII, final DescriptionRenderer llllllllllllllIIIIlIIIllllIIIllI) {
        this.components = new ArrayList<FixedComponent>();
        this.permanentComponents = new ArrayList<FixedComponent>();
        this.inter = llllllllllllllIIIIlIIIllllIIIlII;
        this.descriptionRenderer = llllllllllllllIIIIlIIIllllIIIllI;
    }
    
    @Override
    public void hideComponent(final FixedComponent llllllllllllllIIIIlIIIlllIlIlllI) {
        if (!this.permanentComponents.contains(llllllllllllllIIIIlIIIlllIlIlllI) && this.components.remove(llllllllllllllIIIIlIIIlllIlIlllI)) {
            llllllllllllllIIIIlIIIlllIlIlllI.exit(this.getContext(llllllllllllllIIIIlIIIlllIlIlllI, false));
        }
    }
    
    public void handleScroll(final int llllllllllllllIIIIlIIIlllIIIIIlI) {
        this.doComponentLoop((llllllllllllllIIIIlIIIllIIlIIIlI, llllllllllllllIIIIlIIIllIIlIIIIl) -> llllllllllllllIIIIlIIIllIIlIIIIl.handleScroll(llllllllllllllIIIIlIIIllIIlIIIlI, llllllllllllllIIIIlIIIlllIIIIIlI));
    }
    
    public List<FixedComponent> getComponents() {
        return this.permanentComponents;
    }
    
    public void enter() {
        this.doComponentLoop((llllllllllllllIIIIlIIIllIIIllIll, llllllllllllllIIIIlIIIllIIIllIII) -> llllllllllllllIIIIlIIIllIIIllIII.enter(llllllllllllllIIIIlIIIllIIIllIll));
    }
    
    @Override
    public Toggleable getComponentToggleable(final FixedComponent llllllllllllllIIIIlIIIllIlIIllll) {
        return new Toggleable() {
            @Override
            public boolean isOn() {
                return ClickGUI.this.components.contains(llllllllllllllIIIIlIIIllIlIIllll);
            }
            
            @Override
            public void toggle() {
                if (this.isOn()) {
                    ClickGUI.this.hideComponent(llllllllllllllIIIIlIIIllIlIIllll);
                }
                else {
                    ClickGUI.this.showComponent(llllllllllllllIIIIlIIIllIlIIllll);
                }
            }
        };
    }
    
    public void saveConfig(final ConfigList llllllllllllllIIIIlIIIllIllIllll) {
        llllllllllllllIIIIlIIIllIllIllll.begin(false);
        for (final FixedComponent llllllllllllllIIIIlIIIllIlllIIlI : this.getComponents()) {
            final PanelConfig llllllllllllllIIIIlIIIllIlllIIIl = llllllllllllllIIIIlIIIllIllIllll.addPanel(llllllllllllllIIIIlIIIllIlllIIlI.getTitle());
            if (llllllllllllllIIIIlIIIllIlllIIIl != null) {
                llllllllllllllIIIIlIIIllIlllIIlI.saveConfig(this.inter, llllllllllllllIIIIlIIIllIlllIIIl);
            }
        }
        llllllllllllllIIIIlIIIllIllIllll.end(false);
    }
    
    public void handleButton(final int llllllllllllllIIIIlIIIlllIIIllII) {
        this.doComponentLoop((llllllllllllllIIIIlIIIllIIlIllll, llllllllllllllIIIIlIIIllIIlIlllI) -> llllllllllllllIIIIlIIIllIIlIlllI.handleButton(llllllllllllllIIIIlIIIllIIlIllll, llllllllllllllIIIIlIIIlllIIIllII));
    }
    
    protected void doComponentLoop(final LoopFunction llllllllllllllIIIIlIIIllIIllllII) {
        final List<FixedComponent> llllllllllllllIIIIlIIIllIlIIIlII = new ArrayList<FixedComponent>();
        for (final FixedComponent llllllllllllllIIIIlIIIllIlIIIIll : this.components) {
            llllllllllllllIIIIlIIIllIlIIIlII.add(llllllllllllllIIIIlIIIllIlIIIIll);
        }
        boolean llllllllllllllIIIIlIIIllIlIIIIlI = true;
        FixedComponent llllllllllllllIIIIlIIIllIlIIIIIl = null;
        for (int llllllllllllllIIIIlIIIllIlIIIIII = llllllllllllllIIIIlIIIllIlIIIlII.size() - 1; llllllllllllllIIIIlIIIllIlIIIIII >= 0; --llllllllllllllIIIIlIIIllIlIIIIII) {
            final FixedComponent llllllllllllllIIIIlIIIllIIllllll = llllllllllllllIIIIlIIIllIlIIIlII.get(llllllllllllllIIIIlIIIllIlIIIIII);
            final Context llllllllllllllIIIIlIIIllIIlllllI = this.getContext(llllllllllllllIIIIlIIIllIIllllll, llllllllllllllIIIIlIIIllIlIIIIlI);
            llllllllllllllIIIIlIIIllIIllllII.loop(llllllllllllllIIIIlIIIllIIlllllI, llllllllllllllIIIIlIIIllIIllllll);
            if (llllllllllllllIIIIlIIIllIIlllllI.isHovered()) {
                llllllllllllllIIIIlIIIllIlIIIIlI = false;
            }
            if (llllllllllllllIIIIlIIIllIIlllllI.foucsRequested()) {
                llllllllllllllIIIIlIIIllIlIIIIIl = llllllllllllllIIIIlIIIllIIllllll;
            }
        }
        if (llllllllllllllIIIIlIIIllIlIIIIIl != null && this.components.remove(llllllllllllllIIIIlIIIllIlIIIIIl)) {
            this.components.add(llllllllllllllIIIIlIIIllIlIIIIIl);
        }
    }
    
    public void addComponent(final FixedComponent llllllllllllllIIIIlIIIlllIllllII) {
        this.components.add(llllllllllllllIIIIlIIIlllIllllII);
        this.permanentComponents.add(llllllllllllllIIIIlIIIlllIllllII);
    }
    
    protected Context getContext(final FixedComponent llllllllllllllIIIIlIIIllIlIlIllI, final boolean llllllllllllllIIIIlIIIllIlIllIII) {
        return new Context(this.inter, llllllllllllllIIIIlIIIllIlIlIllI.getWidth(this.inter), llllllllllllllIIIIlIIIllIlIlIllI.getPosition(this.inter), true, llllllllllllllIIIIlIIIllIlIllIII);
    }
    
    @Override
    public void showComponent(final FixedComponent llllllllllllllIIIIlIIIlllIllIllI) {
        if (!this.components.contains(llllllllllllllIIIIlIIIlllIllIllI)) {
            this.components.add(llllllllllllllIIIIlIIIlllIllIllI);
            llllllllllllllIIIIlIIIlllIllIllI.enter(this.getContext(llllllllllllllIIIIlIIIlllIllIllI, false));
        }
    }
    
    public void loadConfig(final ConfigList llllllllllllllIIIIlIIIllIllIIIIl) {
        llllllllllllllIIIIlIIIllIllIIIIl.begin(true);
        for (final FixedComponent llllllllllllllIIIIlIIIllIllIIlII : this.getComponents()) {
            final PanelConfig llllllllllllllIIIIlIIIllIllIIIll = llllllllllllllIIIIlIIIllIllIIIIl.getPanel(llllllllllllllIIIIlIIIllIllIIlII.getTitle());
            if (llllllllllllllIIIIlIIIllIllIIIll != null) {
                llllllllllllllIIIIlIIIllIllIIlII.loadConfig(this.inter, llllllllllllllIIIIlIIIllIllIIIll);
            }
        }
        llllllllllllllIIIIlIIIllIllIIIIl.end(true);
    }
    
    public void exit() {
        this.doComponentLoop((llllllllllllllIIIIlIIIllIIIlIIll, llllllllllllllIIIIlIIIllIIIlIlII) -> llllllllllllllIIIIlIIIllIIIlIlII.exit(llllllllllllllIIIIlIIIllIIIlIIll));
    }
    
    public void handleKey(final int llllllllllllllIIIIlIIIlllIIIIllI) {
        this.doComponentLoop((llllllllllllllIIIIlIIIllIIlIIlll, llllllllllllllIIIIlIIIllIIlIIllI) -> llllllllllllllIIIIlIIIllIIlIIllI.handleKey(llllllllllllllIIIIlIIIllIIlIIlll, llllllllllllllIIIIlIIIlllIIIIllI));
    }
    
    protected interface LoopFunction
    {
        void loop(final Context p0, final FixedComponent p1);
    }
}
