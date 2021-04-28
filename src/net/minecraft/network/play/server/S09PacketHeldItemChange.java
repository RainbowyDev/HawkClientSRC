package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;

public class S09PacketHeldItemChange implements Packet
{
    private /* synthetic */ int field_149387_a;
    
    static {
        __OBFID = "CL_00001324";
    }
    
    @Override
    public void processPacket(final INetHandler llIIllllIIllIIl) {
        this.func_180746_a((INetHandlerPlayClient)llIIllllIIllIIl);
    }
    
    public void func_180746_a(final INetHandlerPlayClient llIIllllIlIIIII) {
        llIIllllIlIIIII.handleHeldItemChange(this);
    }
    
    public S09PacketHeldItemChange(final int llIIllllIllIIlI) {
        this.field_149387_a = llIIllllIllIIlI;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llIIllllIlIIllI) throws IOException {
        llIIllllIlIIllI.writeByte(this.field_149387_a);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llIIllllIlIlllI) throws IOException {
        this.field_149387_a = llIIllllIlIlllI.readByte();
    }
    
    public S09PacketHeldItemChange() {
    }
    
    public int func_149385_c() {
        return this.field_149387_a;
    }
}
