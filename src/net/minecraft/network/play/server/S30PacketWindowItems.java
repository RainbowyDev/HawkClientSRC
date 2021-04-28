package net.minecraft.network.play.server;

import net.minecraft.item.*;
import net.minecraft.network.play.*;
import java.util.*;
import net.minecraft.network.*;
import java.io.*;

public class S30PacketWindowItems implements Packet
{
    private /* synthetic */ ItemStack[] field_148913_b;
    private /* synthetic */ int field_148914_a;
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllIllIIIIIlllIIlIII) {
        this.func_180732_a((INetHandlerPlayClient)lllllllllllllllIllIIIIIlllIIlIII);
    }
    
    public int func_148911_c() {
        return this.field_148914_a;
    }
    
    public void func_180732_a(final INetHandlerPlayClient lllllllllllllllIllIIIIIlllIlIlII) {
        lllllllllllllllIllIIIIIlllIlIlII.handleWindowItems(this);
    }
    
    public S30PacketWindowItems() {
    }
    
    public ItemStack[] func_148910_d() {
        return this.field_148913_b;
    }
    
    public S30PacketWindowItems(final int lllllllllllllllIllIIIIIllllllllI, final List lllllllllllllllIllIIIIIlllllllIl) {
        this.field_148914_a = lllllllllllllllIllIIIIIllllllllI;
        this.field_148913_b = new ItemStack[lllllllllllllllIllIIIIIlllllllIl.size()];
        for (int lllllllllllllllIllIIIIIlllllllII = 0; lllllllllllllllIllIIIIIlllllllII < this.field_148913_b.length; ++lllllllllllllllIllIIIIIlllllllII) {
            final ItemStack lllllllllllllllIllIIIIIllllllIll = lllllllllllllllIllIIIIIlllllllIl.get(lllllllllllllllIllIIIIIlllllllII);
            this.field_148913_b[lllllllllllllllIllIIIIIlllllllII] = ((lllllllllllllllIllIIIIIllllllIll == null) ? null : lllllllllllllllIllIIIIIllllllIll.copy());
        }
    }
    
    static {
        __OBFID = "CL_00001294";
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIllIIIIIlllllIIII) throws IOException {
        this.field_148914_a = lllllllllllllllIllIIIIIlllllIIII.readUnsignedByte();
        final short lllllllllllllllIllIIIIIllllIllll = lllllllllllllllIllIIIIIlllllIIII.readShort();
        this.field_148913_b = new ItemStack[lllllllllllllllIllIIIIIllllIllll];
        for (int lllllllllllllllIllIIIIIllllIlllI = 0; lllllllllllllllIllIIIIIllllIlllI < lllllllllllllllIllIIIIIllllIllll; ++lllllllllllllllIllIIIIIllllIlllI) {
            this.field_148913_b[lllllllllllllllIllIIIIIllllIlllI] = lllllllllllllllIllIIIIIlllllIIII.readItemStackFromBuffer();
        }
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIllIIIIIllllIIIlI) throws IOException {
        lllllllllllllllIllIIIIIllllIIIlI.writeByte(this.field_148914_a);
        lllllllllllllllIllIIIIIllllIIIlI.writeShort(this.field_148913_b.length);
        for (final ItemStack lllllllllllllllIllIIIIIlllIllllI : this.field_148913_b) {
            lllllllllllllllIllIIIIIllllIIIlI.writeItemStackToBuffer(lllllllllllllllIllIIIIIlllIllllI);
        }
    }
}
