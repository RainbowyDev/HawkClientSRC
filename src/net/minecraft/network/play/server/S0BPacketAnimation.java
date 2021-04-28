package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;
import net.minecraft.entity.*;

public class S0BPacketAnimation implements Packet
{
    private /* synthetic */ int type;
    private /* synthetic */ int entityId;
    
    public int func_148977_d() {
        return this.type;
    }
    
    static {
        __OBFID = "CL_00001282";
    }
    
    public void func_180723_a(final INetHandlerPlayClient lllllllllllllllIlIlIlIIIlIllIIlI) {
        lllllllllllllllIlIlIlIIIlIllIIlI.handleAnimation(this);
    }
    
    public S0BPacketAnimation() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIlIlIlIIIlIllllII) throws IOException {
        this.entityId = lllllllllllllllIlIlIlIIIlIllllII.readVarIntFromBuffer();
        this.type = lllllllllllllllIlIlIlIIIlIllllII.readUnsignedByte();
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllIlIlIlIIIlIlIIllI) {
        this.func_180723_a((INetHandlerPlayClient)lllllllllllllllIlIlIlIIIlIlIIllI);
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIlIlIlIIIlIllIllI) throws IOException {
        lllllllllllllllIlIlIlIIIlIllIllI.writeVarIntToBuffer(this.entityId);
        lllllllllllllllIlIlIlIIIlIllIllI.writeByte(this.type);
    }
    
    public int func_148978_c() {
        return this.entityId;
    }
    
    public S0BPacketAnimation(final Entity lllllllllllllllIlIlIlIIIllIIIllI, final int lllllllllllllllIlIlIlIIIllIIIIlI) {
        this.entityId = lllllllllllllllIlIlIlIIIllIIIllI.getEntityId();
        this.type = lllllllllllllllIlIlIlIIIllIIIIlI;
    }
}
