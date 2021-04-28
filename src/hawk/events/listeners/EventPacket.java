package hawk.events.listeners;

import hawk.events.*;
import net.minecraft.network.*;

public class EventPacket<T> extends Event<EventPacket>
{
    public /* synthetic */ boolean cancelled;
    public static /* synthetic */ Packet packet;
    
    public static Packet getPacket() {
        return EventPacket.packet;
    }
    
    @Override
    public void setCancelled(final boolean llllllllllllllIIIllIlIIIllllIIII) {
        this.cancelled = llllllllllllllIIIllIlIIIllllIIII;
    }
    
    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }
    
    public EventPacket(final Packet llllllllllllllIIIllIlIIIlllIllII) {
        EventPacket.packet = llllllllllllllIIIllIlIIIlllIllII;
    }
    
    public void setPacket(final Packet llllllllllllllIIIllIlIIIlllIIllI) {
        EventPacket.packet = llllllllllllllIIIllIlIIIlllIIllI;
    }
}
