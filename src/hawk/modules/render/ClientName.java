package hawk.modules.render;

import hawk.modules.*;
import hawk.settings.*;
import hawk.util.*;
import hawk.events.*;

public class ClientName extends Module
{
    public /* synthetic */ ModeSetting Name;
    public /* synthetic */ Timer timer;
    
    public ClientName() {
        super("HeadRotations", 0, Category.RENDER);
        this.timer = new Timer();
        this.Name = new ModeSetting("Hawk", this, "Hawk", new String[] { "Sigma", "Lunar" });
    }
    
    @Override
    public void onEnable() {
    }
    
    @Override
    public void onDisable() {
    }
    
    @Override
    public void onEvent(final Event llllllllllllllllIlIllIIIIIIlllIl) {
    }
}
