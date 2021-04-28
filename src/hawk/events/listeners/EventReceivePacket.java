package hawk.events.listeners;

import hawk.events.*;
import net.minecraft.network.*;

public class EventReceivePacket extends Event<EventReceivePacket>
{
    /* synthetic */ Packet packet;
    
    public Packet getPacket() {
        return this.packet;
    }
    
    public EventReceivePacket(final Packet llllllllllllllIIIIIllllIIlllIlll) {
        this.packet = llllllllllllllIIIIIllllIIlllIlll;
    }
    
    public void setPacket(final Packet llllllllllllllIIIIIllllIIllIlllI) {
        this.packet = llllllllllllllIIIIIllllIIllIlllI;
    }
}
