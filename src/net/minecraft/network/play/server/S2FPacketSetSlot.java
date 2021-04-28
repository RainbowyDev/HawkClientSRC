package net.minecraft.network.play.server;

import net.minecraft.item.*;
import java.io.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;

public class S2FPacketSetSlot implements Packet
{
    private /* synthetic */ ItemStack field_149178_c;
    private /* synthetic */ int field_149177_b;
    private /* synthetic */ int field_149179_a;
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIlIlIIIIlllIIIlII) throws IOException {
        lllllllllllllllIlIlIIIIlllIIIlII.writeByte(this.field_149179_a);
        lllllllllllllllIlIlIIIIlllIIIlII.writeShort(this.field_149177_b);
        lllllllllllllllIlIlIIIIlllIIIlII.writeItemStackToBuffer(this.field_149178_c);
    }
    
    public S2FPacketSetSlot(final int lllllllllllllllIlIlIIIIlllIlllll, final int lllllllllllllllIlIlIIIIlllIllllI, final ItemStack lllllllllllllllIlIlIIIIlllIlllIl) {
        this.field_149179_a = lllllllllllllllIlIlIIIIlllIlllll;
        this.field_149177_b = lllllllllllllllIlIlIIIIlllIllllI;
        this.field_149178_c = ((lllllllllllllllIlIlIIIIlllIlllIl == null) ? null : lllllllllllllllIlIlIIIIlllIlllIl.copy());
    }
    
    public int func_149173_d() {
        return this.field_149177_b;
    }
    
    static {
        __OBFID = "CL_00001296";
    }
    
    public ItemStack func_149174_e() {
        return this.field_149178_c;
    }
    
    public void processPacket(final INetHandlerPlayClient lllllllllllllllIlIlIIIIlllIlIlIl) {
        lllllllllllllllIlIlIIIIlllIlIlIl.handleSetSlot(this);
    }
    
    public int func_149175_c() {
        return this.field_149179_a;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIlIlIIIIlllIIlIII) throws IOException {
        this.field_149179_a = lllllllllllllllIlIlIIIIlllIIlIII.readByte();
        this.field_149177_b = lllllllllllllllIlIlIIIIlllIIlIII.readShort();
        this.field_149178_c = lllllllllllllllIlIlIIIIlllIIlIII.readItemStackFromBuffer();
    }
    
    public S2FPacketSetSlot() {
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllIlIlIIIIllIlIllll) {
        this.processPacket((INetHandlerPlayClient)lllllllllllllllIlIlIIIIllIlIllll);
    }
}
