package net.minecraft.network.play.client;

import java.io.*;
import net.minecraft.network.*;
import net.minecraft.network.play.*;

public class C09PacketHeldItemChange implements Packet
{
    private /* synthetic */ int slotId;
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIlIlIllIIIIIIlIIl) throws IOException {
        llllllllllllllIIlIlIllIIIIIIlIIl.writeShort(this.slotId);
    }
    
    public int getSlotId() {
        return this.slotId;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIlIlIllIIIIIIllll) throws IOException {
        this.slotId = llllllllllllllIIlIlIllIIIIIIllll.readShort();
    }
    
    public C09PacketHeldItemChange() {
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIIlIlIlIlllllllIlI) {
        this.processPacket((INetHandlerPlayServer)llllllllllllllIIlIlIlIlllllllIlI);
    }
    
    public void processPacket(final INetHandlerPlayServer llllllllllllllIIlIlIllIIIIIIIIll) {
        llllllllllllllIIlIlIllIIIIIIIIll.processHeldItemChange(this);
    }
    
    public C09PacketHeldItemChange(final int llllllllllllllIIlIlIllIIIIIlIlll) {
        this.slotId = llllllllllllllIIlIlIllIIIIIlIlll;
    }
    
    static {
        __OBFID = "CL_00001368";
    }
}
