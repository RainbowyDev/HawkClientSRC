package com.lukflug.panelstudio.hud;

import com.lukflug.panelstudio.settings.*;
import com.lukflug.panelstudio.*;
import com.lukflug.panelstudio.theme.*;
import java.util.*;

public class HUDClickGUI extends ClickGUI implements Toggleable
{
    protected /* synthetic */ List<FixedComponent> allComponents;
    protected /* synthetic */ List<FixedComponent> hudComponents;
    protected /* synthetic */ boolean guiOpen;
    
    @Override
    public Toggleable getComponentToggleable(final FixedComponent llllllllllllllIlIIlIlIlIIIIlllll) {
        return new Toggleable() {
            @Override
            public void toggle() {
                if (this.isOn()) {
                    HUDClickGUI.this.hideComponent(llllllllllllllIlIIlIlIlIIIIlllll);
                }
                else {
                    HUDClickGUI.this.showComponent(llllllllllllllIlIIlIlIlIIIIlllll);
                }
            }
            
            @Override
            public boolean isOn() {
                return HUDClickGUI.this.allComponents.contains(llllllllllllllIlIIlIlIlIIIIlllll);
            }
        };
    }
    
    @Override
    public void addComponent(final FixedComponent llllllllllllllIlIIlIlIlIIlIIIIll) {
        this.allComponents.add(llllllllllllllIlIIlIlIlIIlIIIIll);
        this.permanentComponents.add(llllllllllllllIlIIlIlIlIIlIIIIll);
    }
    
    @Override
    public void showComponent(final FixedComponent llllllllllllllIlIIlIlIlIIIllllIl) {
        if (!this.allComponents.contains(llllllllllllllIlIIlIlIlIIIllllIl)) {
            this.allComponents.add(llllllllllllllIlIIlIlIlIIIllllIl);
            if (this.guiOpen) {
                llllllllllllllIlIIlIlIlIIIllllIl.enter(this.getContext(llllllllllllllIlIIlIlIlIIIllllIl, false));
            }
        }
    }
    
    @Override
    public void hideComponent(final FixedComponent llllllllllllllIlIIlIlIlIIIlllIIl) {
        if (!this.permanentComponents.contains(llllllllllllllIlIIlIlIlIIIlllIIl) && this.allComponents.remove(llllllllllllllIlIIlIlIlIIIlllIIl) && this.guiOpen) {
            llllllllllllllIlIIlIlIlIIIlllIIl.exit(this.getContext(llllllllllllllIlIIlIlIlIIIlllIIl, false));
        }
    }
    
    @Override
    public void exit() {
        this.guiOpen = false;
        this.doComponentLoop((llllllllllllllIlIIlIlIlIIIIIlllI, llllllllllllllIlIIlIlIlIIIIlIIII) -> {
            if (!this.hudComponents.contains(llllllllllllllIlIIlIlIlIIIIlIIII)) {
                llllllllllllllIlIIlIlIlIIIIlIIII.exit(llllllllllllllIlIIlIlIlIIIIIlllI);
            }
            return;
        });
        this.components = this.hudComponents;
    }
    
    @Override
    public void enter() {
        this.components = this.allComponents;
        this.guiOpen = true;
        this.doComponentLoop((llllllllllllllIlIIlIlIlIIIIllIlI, llllllllllllllIlIIlIlIlIIIIllIIl) -> {
            if (!this.hudComponents.contains(llllllllllllllIlIIlIlIlIIIIllIIl)) {
                llllllllllllllIlIIlIlIlIIIIllIIl.enter(llllllllllllllIlIIlIlIlIIIIllIlI);
            }
        });
    }
    
    @Override
    public boolean isOn() {
        return this.guiOpen;
    }
    
    public HUDClickGUI(final Interface llllllllllllllIlIIlIlIlIIlIIlIlI, final DescriptionRenderer llllllllllllllIlIIlIlIlIIlIIlIIl) {
        super(llllllllllllllIlIIlIlIlIIlIIlIlI, llllllllllllllIlIIlIlIlIIlIIlIIl);
        this.allComponents = new ArrayList<FixedComponent>();
        this.hudComponents = new ArrayList<FixedComponent>();
        this.guiOpen = false;
        this.components = this.hudComponents;
    }
    
    @Override
    public void toggle() {
        if (!this.guiOpen) {
            this.enter();
        }
        else {
            this.exit();
        }
    }
    
    public void addHUDComponent(final FixedComponent llllllllllllllIlIIlIlIlIIIllIIll) {
        this.hudComponents.add(llllllllllllllIlIIlIlIlIIIllIIll);
        this.allComponents.add(llllllllllllllIlIIlIlIlIIIllIIll);
        this.permanentComponents.add(llllllllllllllIlIIlIlIlIIIllIIll);
    }
}
