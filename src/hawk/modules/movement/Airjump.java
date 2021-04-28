package hawk.modules.movement;

import hawk.modules.*;
import hawk.events.*;
import hawk.events.listeners.*;

public class Airjump extends Module
{
    @Override
    public void onEvent(final Event llllllllllllllIllllIIlIlIlIlllIl) {
        if (llllllllllllllIllllIIlIlIlIlllIl instanceof EventUpdate && llllllllllllllIllllIIlIlIlIlllIl.isPre()) {
            this.mc.thePlayer.onGround = true;
        }
    }
    
    public Airjump() {
        super("Airjump", 0, Category.MOVEMENT);
    }
}
