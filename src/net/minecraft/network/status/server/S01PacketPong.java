package net.minecraft.network.status.server;

import net.minecraft.network.status.*;
import java.io.*;
import net.minecraft.network.*;

public class S01PacketPong implements Packet
{
    private /* synthetic */ long clientTime;
    
    static {
        __OBFID = "CL_00001383";
    }
    
    public void processPacket(final INetHandlerStatusClient llllllllllllllIIIlllllIIlllIIIIl) {
        llllllllllllllIIIlllllIIlllIIIIl.handlePong(this);
    }
    
    public S01PacketPong(final long llllllllllllllIIIlllllIIllllIlIl) {
        this.clientTime = llllllllllllllIIIlllllIIllllIlIl;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIIlllllIIlllIIlll) throws IOException {
        llllllllllllllIIIlllllIIlllIIlll.writeLong(this.clientTime);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIIlllllIIlllIllIl) throws IOException {
        this.clientTime = llllllllllllllIIIlllllIIlllIllIl.readLong();
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIIIlllllIIllIllIll) {
        this.processPacket((INetHandlerStatusClient)llllllllllllllIIIlllllIIllIllIll);
    }
    
    public S01PacketPong() {
    }
}
