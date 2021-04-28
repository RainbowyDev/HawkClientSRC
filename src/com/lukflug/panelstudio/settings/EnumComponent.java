package com.lukflug.panelstudio.settings;

import com.lukflug.panelstudio.theme.*;
import com.lukflug.panelstudio.*;

public class EnumComponent extends FocusableComponent
{
    protected /* synthetic */ EnumSetting setting;
    
    public EnumComponent(final String llllllllllllllIIllIIlIIlIIllllll, final String llllllllllllllIIllIIlIIlIIlllllI, final Renderer llllllllllllllIIllIIlIIlIIllllIl, final EnumSetting llllllllllllllIIllIIlIIlIIllllII) {
        super(llllllllllllllIIllIIlIIlIIllllll, llllllllllllllIIllIIlIIlIIlllllI, llllllllllllllIIllIIlIIlIIllllIl);
        this.setting = llllllllllllllIIllIIlIIlIIllllII;
    }
    
    @Override
    public void handleButton(final Context llllllllllllllIIllIIlIIlIIlIlllI, final int llllllllllllllIIllIIlIIlIIlIllIl) {
        super.handleButton(llllllllllllllIIllIIlIIlIIlIlllI, llllllllllllllIIllIIlIIlIIlIllIl);
        if (llllllllllllllIIllIIlIIlIIlIllIl == 0 && llllllllllllllIIllIIlIIlIIlIlllI.isClicked()) {
            this.setting.increment();
        }
    }
    
    @Override
    public void render(final Context llllllllllllllIIllIIlIIlIIlllIII) {
        super.render(llllllllllllllIIllIIlIIlIIlllIII);
        this.renderer.renderTitle(llllllllllllllIIllIIlIIlIIlllIII, String.valueOf(new StringBuilder(String.valueOf(this.title)).append(": §7").append(this.setting.getValueName())), this.hasFocus(llllllllllllllIIllIIlIIlIIlllIII));
    }
}
