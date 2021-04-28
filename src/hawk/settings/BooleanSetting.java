package hawk.settings;

import com.lukflug.panelstudio.settings.*;
import hawk.modules.*;

public class BooleanSetting extends Setting implements Toggleable
{
    public /* synthetic */ boolean enabled;
    public /* synthetic */ Module parent;
    
    public BooleanSetting(final String lllllllllllllllIIlllIIllIlIllIlI, final boolean lllllllllllllllIIlllIIllIlIlIlIl, final Module lllllllllllllllIIlllIIllIlIlIlII) {
        this.name = lllllllllllllllIIlllIIllIlIllIlI;
        this.enabled = lllllllllllllllIIlllIIllIlIlIlIl;
        this.parent = lllllllllllllllIIlllIIllIlIlIlII;
    }
    
    public boolean isEnabled() {
        return this.enabled;
    }
    
    @Override
    public void toggle() {
        this.enabled = !this.enabled;
    }
    
    public void setEnabled(final boolean lllllllllllllllIIlllIIllIlIIllIl) {
        this.enabled = lllllllllllllllIIlllIIllIlIIllIl;
    }
    
    @Override
    public boolean isOn() {
        return this.enabled;
    }
}
