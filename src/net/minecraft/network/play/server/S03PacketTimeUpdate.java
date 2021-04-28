package net.minecraft.network.play.server;

import java.io.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;

public class S03PacketTimeUpdate implements Packet
{
    private /* synthetic */ long field_149368_b;
    private /* synthetic */ long field_149369_a;
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIllIIIlIIllllIIII) throws IOException {
        llllllllllllllIIllIIIlIIllllIIII.writeLong(this.field_149369_a);
        llllllllllllllIIllIIIlIIllllIIII.writeLong(this.field_149368_b);
    }
    
    public long func_149366_c() {
        return this.field_149369_a;
    }
    
    public void processPacket(final INetHandlerPlayClient llllllllllllllIIllIIIlIIlllIlIII) {
        llllllllllllllIIllIIIlIIlllIlIII.handleTimeUpdate(this);
    }
    
    public S03PacketTimeUpdate() {
    }
    
    static {
        __OBFID = "CL_00001337";
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIIllIIIlIIllIlllII) {
        this.processPacket((INetHandlerPlayClient)llllllllllllllIIllIIIlIIllIlllII);
    }
    
    public long func_149365_d() {
        return this.field_149368_b;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIllIIIlIIllllIllI) throws IOException {
        this.field_149369_a = llllllllllllllIIllIIIlIIllllIllI.readLong();
        this.field_149368_b = llllllllllllllIIllIIIlIIllllIllI.readLong();
    }
    
    public S03PacketTimeUpdate(final long llllllllllllllIIllIIIlIlIIIIIIII, final long llllllllllllllIIllIIIlIIlllllIll, final boolean llllllllllllllIIllIIIlIIlllllllI) {
        this.field_149369_a = llllllllllllllIIllIIIlIlIIIIIIII;
        this.field_149368_b = llllllllllllllIIllIIIlIIlllllIll;
        if (!llllllllllllllIIllIIIlIIlllllllI) {
            this.field_149368_b = -this.field_149368_b;
            if (this.field_149368_b == 0L) {
                this.field_149368_b = -1L;
            }
        }
    }
}
