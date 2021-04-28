package hawk.modules.render;

import hawk.modules.*;
import hawk.util.*;
import hawk.events.*;
import hawk.events.listeners.*;

public class HeadRotations extends Module
{
    public /* synthetic */ Timer timer;
    
    @Override
    public void onDisable() {
    }
    
    @Override
    public void onEvent(final Event lllllllllllllllIIIIIIlIIIIIIllIl) {
        if (lllllllllllllllIIIIIIlIIIIIIllIl instanceof EventMotion && lllllllllllllllIIIIIIlIIIIIIllIl.isPre()) {
            this.mc.thePlayer.rotationYawHead = ((EventMotion)lllllllllllllllIIIIIIlIIIIIIllIl).getYaw();
            this.mc.thePlayer.renderYawOffset = ((EventMotion)lllllllllllllllIIIIIIlIIIIIIllIl).getYaw();
        }
        if (lllllllllllllllIIIIIIlIIIIIIllIl instanceof EventRenderPlayer && lllllllllllllllIIIIIIlIIIIIIllIl.isPre()) {
            ((EventRenderPlayer)lllllllllllllllIIIIIIlIIIIIIllIl).setPitch(0.0f);
        }
    }
    
    public HeadRotations() {
        super("HeadRotations", 0, Category.RENDER);
        this.timer = new Timer();
    }
    
    @Override
    public void onEnable() {
    }
}
