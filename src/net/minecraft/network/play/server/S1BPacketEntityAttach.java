package net.minecraft.network.play.server;

import net.minecraft.entity.*;
import java.io.*;
import net.minecraft.network.*;
import net.minecraft.network.play.*;

public class S1BPacketEntityAttach implements Packet
{
    private /* synthetic */ int field_149408_a;
    private /* synthetic */ int field_149406_b;
    private /* synthetic */ int field_149407_c;
    
    public S1BPacketEntityAttach(final int lllllllllllllllIllIIlIIIlIIIIIll, final Entity lllllllllllllllIllIIlIIIlIIIIIlI, final Entity lllllllllllllllIllIIlIIIlIIIIIIl) {
        this.field_149408_a = lllllllllllllllIllIIlIIIlIIIIIll;
        this.field_149406_b = lllllllllllllllIllIIlIIIlIIIIIlI.getEntityId();
        this.field_149407_c = ((lllllllllllllllIllIIlIIIlIIIIIIl != null) ? lllllllllllllllIllIIlIIIlIIIIIIl.getEntityId() : -1);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIllIIlIIIIllllIIl) throws IOException {
        this.field_149406_b = lllllllllllllllIllIIlIIIIllllIIl.readInt();
        this.field_149407_c = lllllllllllllllIllIIlIIIIllllIIl.readInt();
        this.field_149408_a = lllllllllllllllIllIIlIIIIllllIIl.readUnsignedByte();
    }
    
    public int func_149404_c() {
        return this.field_149408_a;
    }
    
    static {
        __OBFID = "CL_00001327";
    }
    
    public S1BPacketEntityAttach() {
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllIllIIlIIIIlIlllII) {
        this.processPacket((INetHandlerPlayClient)lllllllllllllllIllIIlIIIIlIlllII);
    }
    
    public void processPacket(final INetHandlerPlayClient lllllllllllllllIllIIlIIIIllIlIll) {
        lllllllllllllllIllIIlIIIIllIlIll.handleEntityAttach(this);
    }
    
    public int func_149402_e() {
        return this.field_149407_c;
    }
    
    public int func_149403_d() {
        return this.field_149406_b;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIllIIlIIIIlllIIll) throws IOException {
        lllllllllllllllIllIIlIIIIlllIIll.writeInt(this.field_149406_b);
        lllllllllllllllIllIIlIIIIlllIIll.writeInt(this.field_149407_c);
        lllllllllllllllIllIIlIIIIlllIIll.writeByte(this.field_149408_a);
    }
}
