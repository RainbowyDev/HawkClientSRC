package com.lukflug.panelstudio.settings;

import com.lukflug.panelstudio.*;
import com.lukflug.panelstudio.theme.*;

public class KeybindComponent extends FocusableComponent
{
    protected /* synthetic */ KeybindSetting keybind;
    
    @Override
    public void exit(final Context llIIlIIIIIIIllI) {
        super.exit(llIIlIIIIIIIllI);
        if (this.hasFocus(llIIlIIIIIIIllI)) {
            this.keybind.setKey(0);
            this.releaseFocus();
        }
    }
    
    @Override
    public void handleKey(final Context llIIlIIIIIIlllI, final int llIIlIIIIIIllIl) {
        super.handleKey(llIIlIIIIIIlllI, llIIlIIIIIIllIl);
        if (this.hasFocus(llIIlIIIIIIlllI)) {
            this.keybind.setKey(llIIlIIIIIIllIl);
            this.releaseFocus();
        }
    }
    
    @Override
    public void render(final Context llIIlIIIIlIIIll) {
        super.render(llIIlIIIIlIIIll);
        String llIIlIIIIlIIIlI = String.valueOf(new StringBuilder(String.valueOf(this.title)).append(this.keybind.getKeyName()));
        if (this.hasFocus(llIIlIIIIlIIIll)) {
            llIIlIIIIlIIIlI = String.valueOf(new StringBuilder(String.valueOf(this.title)).append("..."));
        }
        this.renderer.renderTitle(llIIlIIIIlIIIll, llIIlIIIIlIIIlI, this.hasFocus(llIIlIIIIlIIIll));
    }
    
    @Override
    public void handleButton(final Context llIIlIIIIIllIIl, final int llIIlIIIIIlIlII) {
        super.handleButton(llIIlIIIIIllIIl, llIIlIIIIIlIlII);
        llIIlIIIIIllIIl.setHeight(this.renderer.getHeight(false));
        final boolean llIIlIIIIIlIlll = this.hasFocus(llIIlIIIIIllIIl);
        super.handleButton(llIIlIIIIIllIIl, llIIlIIIIIlIlII);
        if (llIIlIIIIIlIlll && !this.hasFocus(llIIlIIIIIllIIl)) {
            this.keybind.setKey(0);
        }
    }
    
    public KeybindComponent(final Renderer llIIlIIIIlIllII, final KeybindSetting llIIlIIIIlIlIll) {
        super("Keybind: §7", null, llIIlIIIIlIllII);
        this.keybind = llIIlIIIIlIlIll;
    }
}
