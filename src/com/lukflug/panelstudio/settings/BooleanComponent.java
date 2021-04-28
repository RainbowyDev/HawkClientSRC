package com.lukflug.panelstudio.settings;

import com.lukflug.panelstudio.theme.*;
import com.lukflug.panelstudio.*;

public class BooleanComponent extends FocusableComponent
{
    protected /* synthetic */ Toggleable setting;
    
    public BooleanComponent(final String llllIlIIlllII, final String llllIlIIllIll, final Renderer llllIlIIlllll, final Toggleable llllIlIIllllI) {
        super(llllIlIIlllII, llllIlIIllIll, llllIlIIlllll);
        this.setting = llllIlIIllllI;
    }
    
    @Override
    public void render(final Context llllIlIIlIIll) {
        super.render(llllIlIIlIIll);
        this.renderer.renderTitle(llllIlIIlIIll, this.title, this.hasFocus(llllIlIIlIIll), this.setting.isOn());
    }
    
    @Override
    public void handleButton(final Context llllIlIIIlllI, final int llllIlIIIlIlI) {
        super.handleButton(llllIlIIIlllI, llllIlIIIlIlI);
        if (llllIlIIIlIlI == 0 && llllIlIIIlllI.isClicked()) {
            this.setting.toggle();
        }
    }
}
