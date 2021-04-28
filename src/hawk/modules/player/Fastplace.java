package hawk.modules.player;

import hawk.modules.*;
import hawk.events.*;
import hawk.events.listeners.*;

public class Fastplace extends Module
{
    @Override
    public void onEvent(final Event lllllllllllllllIIIllllllllIIlIII) {
        if (lllllllllllllllIIIllllllllIIlIII instanceof EventMotion && lllllllllllllllIIIllllllllIIlIII.isPre()) {
            this.mc.rightClickDelayTimer = 0;
        }
    }
    
    public Fastplace() {
        super("Fastplace", 0, Category.PLAYER);
    }
    
    @Override
    public void onDisable() {
        this.mc.rightClickDelayTimer = 6;
    }
}
