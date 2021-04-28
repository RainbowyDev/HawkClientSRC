package hawk.settings;

import com.lukflug.panelstudio.settings.*;
import hawk.modules.*;
import java.util.*;

public class ModeSetting extends Setting implements EnumSetting
{
    public /* synthetic */ int index;
    public /* synthetic */ Module parent;
    public /* synthetic */ List<String> modes;
    
    public String getMode() {
        return this.modes.get(this.index);
    }
    
    public void setMode(final String lllllllllllllllllIlIIIIlIlIIIIll) {
        this.index = this.modes.indexOf(lllllllllllllllllIlIIIIlIlIIIIll);
    }
    
    public void cycle() {
        if (this.index < this.modes.size() - 1) {
            ++this.index;
        }
        else {
            this.index = 0;
        }
    }
    
    @Override
    public void increment() {
        if (this.index < this.modes.size() - 1) {
            ++this.index;
        }
        else {
            this.index = 0;
        }
    }
    
    public ModeSetting(final String lllllllllllllllllIlIIIIlIllIllIl, final Module lllllllllllllllllIlIIIIlIllIllII, final String lllllllllllllllllIlIIIIlIllIlIll, final String... lllllllllllllllllIlIIIIlIllIlIlI) {
        this.name = lllllllllllllllllIlIIIIlIllIllIl;
        this.modes = Arrays.asList(lllllllllllllllllIlIIIIlIllIlIlI);
        this.index = this.modes.indexOf(lllllllllllllllllIlIIIIlIllIlIll);
        this.parent = lllllllllllllllllIlIIIIlIllIllII;
    }
    
    public boolean is(final String lllllllllllllllllIlIIIIlIlIlIlIl) {
        return this.index == this.modes.indexOf(lllllllllllllllllIlIIIIlIlIlIlIl);
    }
    
    @Override
    public String getValueName() {
        return this.modes.get(this.index);
    }
}
