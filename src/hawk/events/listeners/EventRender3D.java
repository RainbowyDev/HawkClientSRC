package hawk.events.listeners;

import hawk.events.*;

public class EventRender3D extends Event<EventRender3D>
{
    private /* synthetic */ float partialTicks;
    
    public void setPartialTicks(final float lllllllllllllllIllIIIllIllIIIIlI) {
        this.partialTicks = lllllllllllllllIllIIIllIllIIIIlI;
    }
    
    public float getPartialTicks() {
        return this.partialTicks;
    }
    
    public EventRender3D(final float lllllllllllllllIllIIIllIllIIlIll) {
        this.partialTicks = lllllllllllllllIllIIIllIllIIlIll;
    }
}
