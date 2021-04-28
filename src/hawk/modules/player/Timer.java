package hawk.modules.player;

import hawk.modules.*;
import hawk.events.*;
import hawk.events.listeners.*;
import hawk.settings.*;

public class Timer extends Module
{
    public /* synthetic */ NumberSetting Speed;
    
    @Override
    public void onEvent(final Event llllllllllllllIlIllIIIllIIIlIIIl) {
        if (llllllllllllllIlIllIIIllIIIlIIIl instanceof EventMotion && llllllllllllllIlIllIIIllIIIlIIIl.isPre()) {
            this.mc.timer.timerSpeed = (float)this.Speed.getValue();
        }
    }
    
    public Timer() {
        super("Timer", 0, Category.PLAYER);
        this.Speed = new NumberSetting("Speed", 1.0, 0.05, 4.0, 0.05, this);
        this.addSettings(this.Speed);
    }
    
    @Override
    public void onDisable() {
        this.mc.timer.timerSpeed = 1.0f;
    }
}
