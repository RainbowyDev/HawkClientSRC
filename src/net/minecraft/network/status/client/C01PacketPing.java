package net.minecraft.network.status.client;

import net.minecraft.network.status.*;
import java.io.*;
import net.minecraft.network.*;

public class C01PacketPing implements Packet
{
    private /* synthetic */ long clientTime;
    
    public long getClientTime() {
        return this.clientTime;
    }
    
    public void func_180774_a(final INetHandlerStatusServer llllllllllllllIIIIIIIIIllIlIlIlI) {
        llllllllllllllIIIIIIIIIllIlIlIlI.processPing(this);
    }
    
    public C01PacketPing() {
    }
    
    static {
        __OBFID = "CL_00001392";
    }
    
    public C01PacketPing(final long llllllllllllllIIIIIIIIIllIlllIlI) {
        this.clientTime = llllllllllllllIIIIIIIIIllIlllIlI;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIIIIIIIIllIlIlllI) throws IOException {
        llllllllllllllIIIIIIIIIllIlIlllI.writeLong(this.clientTime);
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIIIIIIIIIllIIlllll) {
        this.func_180774_a((INetHandlerStatusServer)llllllllllllllIIIIIIIIIllIIlllll);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIIIIIIIIllIllIllI) throws IOException {
        this.clientTime = llllllllllllllIIIIIIIIIllIllIllI.readLong();
    }
}
