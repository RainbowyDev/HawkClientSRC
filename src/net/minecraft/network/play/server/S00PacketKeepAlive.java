package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;

public class S00PacketKeepAlive implements Packet
{
    private /* synthetic */ int field_149136_a;
    
    @Override
    public void processPacket(final INetHandler llllllllllllllllIIllllIlIlIIIllI) {
        this.processPacket((INetHandlerPlayClient)llllllllllllllllIIllllIlIlIIIllI);
    }
    
    public void processPacket(final INetHandlerPlayClient llllllllllllllllIIllllIlIlIlllIl) {
        llllllllllllllllIIllllIlIlIlllIl.handleKeepAlive(this);
    }
    
    public int func_149134_c() {
        return this.field_149136_a;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllllIIllllIlIlIlIlIl) throws IOException {
        this.field_149136_a = llllllllllllllllIIllllIlIlIlIlIl.readVarIntFromBuffer();
    }
    
    public S00PacketKeepAlive(final int llllllllllllllllIIllllIlIllIIIll) {
        this.field_149136_a = llllllllllllllllIIllllIlIllIIIll;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllllIIllllIlIlIIllll) throws IOException {
        llllllllllllllllIIllllIlIlIIllll.writeVarIntToBuffer(this.field_149136_a);
    }
    
    static {
        __OBFID = "CL_00001303";
    }
    
    public S00PacketKeepAlive() {
    }
}
