package hawk.settings;

import com.lukflug.panelstudio.settings.*;
import hawk.modules.*;
import org.lwjgl.input.*;

public class KeyBindSetting extends Setting implements KeybindSetting
{
    public /* synthetic */ int code;
    public /* synthetic */ Module parent;
    
    public int getKeyCode() {
        return this.code;
    }
    
    public void setKeyCode(final int lllllllllllllllIIllIlllllIIIllll) {
        this.code = lllllllllllllllIIllIlllllIIIllll;
    }
    
    @Override
    public String getKeyName() {
        return Keyboard.getKeyName(this.code);
    }
    
    public KeyBindSetting(final int lllllllllllllllIIllIlllllIIllIIl, final Module lllllllllllllllIIllIlllllIIllIll) {
        this.name = "Keybind";
        this.code = lllllllllllllllIIllIlllllIIllIIl;
        this.parent = lllllllllllllllIIllIlllllIIllIll;
    }
    
    @Override
    public int getKey() {
        return this.code;
    }
    
    @Override
    public void setKey(final int lllllllllllllllIIllIlllllIIIIllI) {
        this.code = lllllllllllllllIIllIlllllIIIIllI;
    }
}
