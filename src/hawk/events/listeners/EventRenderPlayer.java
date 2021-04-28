package hawk.events.listeners;

import hawk.events.*;

public class EventRenderPlayer extends Event<EventRenderPlayer>
{
    public /* synthetic */ float yaw;
    private /* synthetic */ float partialTicks;
    public /* synthetic */ float pitch;
    public /* synthetic */ float yawChange;
    
    public float getPartialTicks() {
        return this.partialTicks;
    }
    
    public void setYaw(final float lllllllllllllllllllllIIlIlllIlIl) {
        this.yaw = lllllllllllllllllllllIIlIlllIlIl;
    }
    
    public float getYaw() {
        return this.yaw;
    }
    
    public void setPitch(final float lllllllllllllllllllllIIlIllIlIlI) {
        this.pitch = lllllllllllllllllllllIIlIllIlIlI;
    }
    
    public float getPitch() {
        return this.pitch;
    }
    
    public EventRenderPlayer(final float lllllllllllllllllllllIIllIIIIIlI, final float lllllllllllllllllllllIIllIIIIllI, final float lllllllllllllllllllllIIllIIIIIII, final float lllllllllllllllllllllIIlIlllllll) {
        this.yaw = lllllllllllllllllllllIIllIIIIIlI;
        this.pitch = lllllllllllllllllllllIIllIIIIllI;
        this.yawChange = lllllllllllllllllllllIIllIIIIIII;
        this.partialTicks = lllllllllllllllllllllIIlIlllllll;
    }
}
