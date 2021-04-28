package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;

public class S13PacketDestroyEntities implements Packet
{
    private /* synthetic */ int[] field_149100_a;
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIIIIlIIlIIIIIllIll) {
        this.processPacket((INetHandlerPlayClient)llllllllllllllIIIIlIIlIIIIIllIll);
    }
    
    public void processPacket(final INetHandlerPlayClient llllllllllllllIIIIlIIlIIIIlIIllI) {
        llllllllllllllIIIIlIIlIIIIlIIllI.handleDestroyEntities(this);
    }
    
    public int[] func_149098_c() {
        return this.field_149100_a;
    }
    
    public S13PacketDestroyEntities() {
    }
    
    public S13PacketDestroyEntities(final int... llllllllllllllIIIIlIIlIIIIlllllI) {
        this.field_149100_a = llllllllllllllIIIIlIIlIIIIlllllI;
    }
    
    static {
        __OBFID = "CL_00001320";
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIIIlIIlIIIIllIlll) throws IOException {
        this.field_149100_a = new int[llllllllllllllIIIIlIIlIIIIllIlll.readVarIntFromBuffer()];
        for (int llllllllllllllIIIIlIIlIIIIllIllI = 0; llllllllllllllIIIIlIIlIIIIllIllI < this.field_149100_a.length; ++llllllllllllllIIIIlIIlIIIIllIllI) {
            this.field_149100_a[llllllllllllllIIIIlIIlIIIIllIllI] = llllllllllllllIIIIlIIlIIIIllIlll.readVarIntFromBuffer();
        }
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIIIlIIlIIIIlIlIll) throws IOException {
        llllllllllllllIIIIlIIlIIIIlIlIll.writeVarIntToBuffer(this.field_149100_a.length);
        for (int llllllllllllllIIIIlIIlIIIIlIllIl = 0; llllllllllllllIIIIlIIlIIIIlIllIl < this.field_149100_a.length; ++llllllllllllllIIIIlIIlIIIIlIllIl) {
            llllllllllllllIIIIlIIlIIIIlIlIll.writeVarIntToBuffer(this.field_149100_a[llllllllllllllIIIIlIIlIIIIlIllIl]);
        }
    }
}
