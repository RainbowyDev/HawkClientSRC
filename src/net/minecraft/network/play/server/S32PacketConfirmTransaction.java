package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;

public class S32PacketConfirmTransaction implements Packet
{
    private /* synthetic */ int field_148894_a;
    private /* synthetic */ short field_148892_b;
    private /* synthetic */ boolean field_148893_c;
    
    public int func_148889_c() {
        return this.field_148894_a;
    }
    
    static {
        __OBFID = "CL_00001291";
    }
    
    public void func_180730_a(final INetHandlerPlayClient llllllllllllllIIIlIIIllllIlIIIII) {
        llllllllllllllIIIlIIIllllIlIIIII.handleConfirmTransaction(this);
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIIIlIIIllllIIIIlIl) {
        this.func_180730_a((INetHandlerPlayClient)llllllllllllllIIIlIIIllllIIIIlIl);
    }
    
    public S32PacketConfirmTransaction() {
    }
    
    public short func_148890_d() {
        return this.field_148892_b;
    }
    
    public S32PacketConfirmTransaction(final int llllllllllllllIIIlIIIllllIlIlIlI, final short llllllllllllllIIIlIIIllllIlIIlIl, final boolean llllllllllllllIIIlIIIllllIlIlIII) {
        this.field_148894_a = llllllllllllllIIIlIIIllllIlIlIlI;
        this.field_148892_b = llllllllllllllIIIlIIIllllIlIIlIl;
        this.field_148893_c = llllllllllllllIIIlIIIllllIlIlIII;
    }
    
    public boolean func_148888_e() {
        return this.field_148893_c;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIIlIIIllllIIllIII) throws IOException {
        this.field_148894_a = llllllllllllllIIIlIIIllllIIllIII.readUnsignedByte();
        this.field_148892_b = llllllllllllllIIIlIIIllllIIllIII.readShort();
        this.field_148893_c = llllllllllllllIIIlIIIllllIIllIII.readBoolean();
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIIlIIIllllIIlIlII) throws IOException {
        llllllllllllllIIIlIIIllllIIlIlII.writeByte(this.field_148894_a);
        llllllllllllllIIIlIIIllllIIlIlII.writeShort(this.field_148892_b);
        llllllllllllllIIIlIIIllllIIlIlII.writeBoolean(this.field_148893_c);
    }
}
