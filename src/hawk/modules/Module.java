package hawk.modules;

import com.lukflug.panelstudio.settings.*;
import net.minecraft.client.*;
import hawk.settings.*;
import hawk.events.*;
import java.util.*;

public class Module implements Toggleable
{
    public /* synthetic */ String displayname;
    public /* synthetic */ Minecraft mc;
    public /* synthetic */ boolean toggled;
    public /* synthetic */ String name;
    public /* synthetic */ Category category;
    public /* synthetic */ KeyBindSetting keyCode;
    public /* synthetic */ List<Setting> settings;
    
    public void onDisable() {
    }
    
    public void addSettings(final Setting... lllllllllllllllIllllIlIIllIllIII) {
        this.settings.addAll(Arrays.asList(lllllllllllllllIllllIlIIllIllIII));
    }
    
    public int getKey() {
        return this.keyCode.code;
    }
    
    public void onEvent(final Event lllllllllllllllIllllIlIIlIllIIll) {
    }
    
    public String getDisplayname() {
        return this.displayname;
    }
    
    public void setEnabled(final boolean lllllllllllllllIllllIlIIllIIlllI) {
        this.toggled = lllllllllllllllIllllIlIIllIIlllI;
    }
    
    @Override
    public void toggle() {
        this.toggled = !this.toggled;
        if (this.toggled) {
            this.onEnable();
        }
        else {
            this.onDisable();
        }
    }
    
    public Module(final String lllllllllllllllIllllIlIIlllIIlII, final int lllllllllllllllIllllIlIIllIlllll, final Category lllllllllllllllIllllIlIIlllIIIlI) {
        this.keyCode = new KeyBindSetting(0, this);
        this.mc = Minecraft.getMinecraft();
        this.settings = new ArrayList<Setting>();
        this.name = lllllllllllllllIllllIlIIlllIIlII;
        this.keyCode.code = lllllllllllllllIllllIlIIllIlllll;
        this.category = lllllllllllllllIllllIlIIlllIIIlI;
        this.addSettings(this.keyCode);
        this.setDisplayname(lllllllllllllllIllllIlIIlllIIlII);
    }
    
    public boolean isEnabled() {
        return this.toggled;
    }
    
    public void setKey(final int lllllllllllllllIllllIlIIlIlllIII) {
        this.keyCode.code = lllllllllllllllIllllIlIIlIlllIII;
    }
    
    @Override
    public boolean isOn() {
        return this.toggled;
    }
    
    public void onEnable() {
    }
    
    public void setDisplayname(final String lllllllllllllllIllllIlIIllllIIlI) {
        this.displayname = lllllllllllllllIllllIlIIllllIIlI;
    }
    
    public enum Category
    {
        COMBAT("COMBAT", 0, "Combat", 130), 
        PLAYER("PLAYER", 2, "Player", 390), 
        RENDER("RENDER", 3, "Render", 520);
        
        public /* synthetic */ int pos;
        public /* synthetic */ String name;
        
        MOVEMENT("MOVEMENT", 1, "Movement", 260);
        
        private Category(final String llllllllllllllIIlIIlllIIIIlIlIIl, final int llllllllllllllIIlIIlllIIIIlIlIII, final String llllllllllllllIIlIIlllIIIIlIIlll, final int llllllllllllllIIlIIlllIIIIlIlIll) {
            this.name = llllllllllllllIIlIIlllIIIIlIIlll;
            this.pos = llllllllllllllIIlIIlllIIIIlIlIll;
        }
    }
}
