package hawk.events.listeners;

import hawk.events.*;
import net.minecraft.network.*;

public class EventSendPacket extends Event<EventSendPacket>
{
    /* synthetic */ Packet packet;
    
    public void setPacket(final Packet lllllllllllllllIlIlIlIIlIIlllIII) {
        this.packet = lllllllllllllllIlIlIlIIlIIlllIII;
    }
    
    public EventSendPacket(final Packet lllllllllllllllIlIlIlIIlIlIIIIIl) {
        this.packet = lllllllllllllllIlIlIlIIlIlIIIIIl;
    }
    
    public Packet getPacket() {
        return this.packet;
    }
}
