package hawk.modules.movement;

import hawk.modules.*;
import hawk.events.*;
import hawk.events.listeners.*;

public class BasicFly extends Module
{
    @Override
    public void onEvent(final Event lIlllllIlll) {
        if (lIlllllIlll instanceof EventUpdate && lIlllllIlll.isPre()) {
            this.mc.thePlayer.capabilities.isFlying = true;
        }
    }
    
    @Override
    public void onEnable() {
    }
    
    @Override
    public void onDisable() {
        this.mc.thePlayer.capabilities.isFlying = false;
    }
    
    public BasicFly() {
        super("BasicFly", 0, Category.MOVEMENT);
    }
}
