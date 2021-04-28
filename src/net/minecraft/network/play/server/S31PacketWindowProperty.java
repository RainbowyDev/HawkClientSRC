package net.minecraft.network.play.server;

import java.io.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;

public class S31PacketWindowProperty implements Packet
{
    private /* synthetic */ int field_149186_a;
    private /* synthetic */ int field_149184_b;
    private /* synthetic */ int field_149185_c;
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllllllllIlIIllIlIIl) throws IOException {
        this.field_149186_a = lllllllllllllllllllllIlIIllIlIIl.readUnsignedByte();
        this.field_149184_b = lllllllllllllllllllllIlIIllIlIIl.readShort();
        this.field_149185_c = lllllllllllllllllllllIlIIllIlIIl.readShort();
    }
    
    public S31PacketWindowProperty() {
    }
    
    public S31PacketWindowProperty(final int lllllllllllllllllllllIlIIlllIlll, final int lllllllllllllllllllllIlIIllllIlI, final int lllllllllllllllllllllIlIIlllIlIl) {
        this.field_149186_a = lllllllllllllllllllllIlIIlllIlll;
        this.field_149184_b = lllllllllllllllllllllIlIIllllIlI;
        this.field_149185_c = lllllllllllllllllllllIlIIlllIlIl;
    }
    
    public int func_149182_c() {
        return this.field_149186_a;
    }
    
    public void func_180733_a(final INetHandlerPlayClient lllllllllllllllllllllIlIIlllIIIl) {
        lllllllllllllllllllllIlIIlllIIIl.handleWindowProperty(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllllllllIlIIllIIIll) throws IOException {
        lllllllllllllllllllllIlIIllIIIll.writeByte(this.field_149186_a);
        lllllllllllllllllllllIlIIllIIIll.writeShort(this.field_149184_b);
        lllllllllllllllllllllIlIIllIIIll.writeShort(this.field_149185_c);
    }
    
    public int func_149181_d() {
        return this.field_149184_b;
    }
    
    static {
        __OBFID = "CL_00001295";
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllllllllIlIIlIlIlII) {
        this.func_180733_a((INetHandlerPlayClient)lllllllllllllllllllllIlIIlIlIlII);
    }
    
    public int func_149180_e() {
        return this.field_149185_c;
    }
}
