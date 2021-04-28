package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;

public class C00PacketKeepAlive implements Packet
{
    private /* synthetic */ int key;
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIllIlIlIlIlIlIIIll) {
        this.processPacket((INetHandlerPlayServer)llllllllllllllIllIlIlIlIlIlIIIll);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIllIlIlIlIlIllIIlI) throws IOException {
        this.key = llllllllllllllIllIlIlIlIlIllIIlI.readVarIntFromBuffer();
    }
    
    public C00PacketKeepAlive() {
    }
    
    public C00PacketKeepAlive(final int llllllllllllllIllIlIlIlIllIIIIII) {
        this.key = llllllllllllllIllIlIlIlIllIIIIII;
    }
    
    public void processPacket(final INetHandlerPlayServer llllllllllllllIllIlIlIlIlIlllIlI) {
        llllllllllllllIllIlIlIlIlIlllIlI.processKeepAlive(this);
    }
    
    public int getKey() {
        return this.key;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIllIlIlIlIlIlIllII) throws IOException {
        llllllllllllllIllIlIlIlIlIlIllII.writeVarIntToBuffer(this.key);
    }
    
    static {
        __OBFID = "CL_00001359";
    }
}
