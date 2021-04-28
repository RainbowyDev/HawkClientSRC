package com.lukflug.panelstudio;

import com.lukflug.panelstudio.settings.*;
import com.lukflug.panelstudio.theme.*;

public class TransientComponent extends FocusableComponent
{
    protected /* synthetic */ FixedComponent component;
    protected /* synthetic */ PanelManager manager;
    protected /* synthetic */ Toggleable toggle;
    
    public TransientComponent(final String llllllllllllllIllIllllIIlllIllII, final String llllllllllllllIllIllllIIllllIIlI, final Renderer llllllllllllllIllIllllIIlllIlIlI, final Toggleable llllllllllllllIllIllllIIlllIlIIl, final FixedComponent llllllllllllllIllIllllIIlllIlIII, final PanelManager llllllllllllllIllIllllIIlllIIlll) {
        super(llllllllllllllIllIllllIIlllIllII, llllllllllllllIllIllllIIllllIIlI, llllllllllllllIllIllllIIlllIlIlI);
        this.toggle = llllllllllllllIllIllllIIlllIlIIl;
        this.component = llllllllllllllIllIllllIIlllIlIII;
        this.manager = llllllllllllllIllIllllIIlllIIlll;
    }
    
    @Override
    public void handleButton(final Context llllllllllllllIllIllllIIllIllIIl, final int llllllllllllllIllIllllIIllIllIII) {
        super.handleButton(llllllllllllllIllIllllIIllIllIIl, llllllllllllllIllIllllIIllIllIII);
        if (llllllllllllllIllIllllIIllIllIII == 0 && llllllllllllllIllIllllIIllIllIIl.isClicked()) {
            this.toggle.toggle();
        }
        else if (llllllllllllllIllIllllIIllIllIIl.isHovered() && llllllllllllllIllIllllIIllIllIII == 1 && llllllllllllllIllIllllIIllIllIIl.getInterface().getButton(1)) {
            this.manager.getComponentToggleable(this.component).toggle();
            llllllllllllllIllIllllIIllIllIIl.releaseFocus();
        }
    }
    
    @Override
    public void render(final Context llllllllllllllIllIllllIIlllIIIIl) {
        super.render(llllllllllllllIllIllllIIlllIIIIl);
        this.renderer.renderTitle(llllllllllllllIllIllllIIlllIIIIl, this.title, this.hasFocus(llllllllllllllIllIllllIIlllIIIIl), this.toggle.isOn(), this.manager.getComponentToggleable(this.component).isOn());
    }
}
