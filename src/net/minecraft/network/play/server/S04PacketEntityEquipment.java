package net.minecraft.network.play.server;

import net.minecraft.item.*;
import java.io.*;
import net.minecraft.network.*;
import net.minecraft.network.play.*;

public class S04PacketEntityEquipment implements Packet
{
    private /* synthetic */ int field_149394_a;
    private /* synthetic */ int field_149392_b;
    private /* synthetic */ ItemStack field_149393_c;
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllllIlIllIllIIllllII) throws IOException {
        llllllllllllllllIlIllIllIIllllII.writeVarIntToBuffer(this.field_149394_a);
        llllllllllllllllIlIllIllIIllllII.writeShort(this.field_149392_b);
        llllllllllllllllIlIllIllIIllllII.writeItemStackToBuffer(this.field_149393_c);
    }
    
    static {
        __OBFID = "CL_00001330";
    }
    
    public int func_149388_e() {
        return this.field_149392_b;
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllllIlIllIllIIIlIlll) {
        this.processPacket((INetHandlerPlayClient)llllllllllllllllIlIllIllIIIlIlll);
    }
    
    public ItemStack func_149390_c() {
        return this.field_149393_c;
    }
    
    public S04PacketEntityEquipment() {
    }
    
    public S04PacketEntityEquipment(final int llllllllllllllllIlIllIllIlIllIII, final int llllllllllllllllIlIllIllIlIlIllI, final ItemStack llllllllllllllllIlIllIllIlIllIll) {
        this.field_149394_a = llllllllllllllllIlIllIllIlIllIII;
        this.field_149392_b = llllllllllllllllIlIllIllIlIlIllI;
        this.field_149393_c = ((llllllllllllllllIlIllIllIlIllIll == null) ? null : llllllllllllllllIlIllIllIlIllIll.copy());
    }
    
    public void processPacket(final INetHandlerPlayClient llllllllllllllllIlIllIllIIllIIII) {
        llllllllllllllllIlIllIllIIllIIII.handleEntityEquipment(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllllIlIllIllIlIIIllI) throws IOException {
        this.field_149394_a = llllllllllllllllIlIllIllIlIIIllI.readVarIntFromBuffer();
        this.field_149392_b = llllllllllllllllIlIllIllIlIIIllI.readShort();
        this.field_149393_c = llllllllllllllllIlIllIllIlIIIllI.readItemStackFromBuffer();
    }
    
    public int func_149389_d() {
        return this.field_149394_a;
    }
}
