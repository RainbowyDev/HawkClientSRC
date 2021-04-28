package net.minecraft.network.play.server;

import java.io.*;
import net.minecraft.network.*;
import net.minecraft.network.play.*;

public class S46PacketSetCompressionLevel implements Packet
{
    private /* synthetic */ int field_179761_a;
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlIllIIlIIIllIIIIl) throws IOException {
        this.field_179761_a = llllllllllllllIlIllIIlIIIllIIIIl.readVarIntFromBuffer();
    }
    
    static {
        __OBFID = "CL_00002300";
    }
    
    public int func_179760_a() {
        return this.field_179761_a;
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIlIllIIlIIIlIIllII) {
        this.func_179759_a((INetHandlerPlayClient)llllllllllllllIlIllIIlIIIlIIllII);
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlIllIIlIIIlIllIll) throws IOException {
        llllllllllllllIlIllIIlIIIlIllIll.writeVarIntToBuffer(this.field_179761_a);
    }
    
    public void func_179759_a(final INetHandlerPlayClient llllllllllllllIlIllIIlIIIlIlIlIl) {
        llllllllllllllIlIllIIlIIIlIlIlIl.func_175100_a(this);
    }
}
