package net.minecraft.network.play.client;

import java.io.*;
import net.minecraft.network.*;
import net.minecraft.network.play.*;

public class C0FPacketConfirmTransaction implements Packet
{
    private /* synthetic */ short uid;
    private /* synthetic */ int id;
    private /* synthetic */ boolean accepted;
    
    public int getId() {
        return this.id;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllllIlIlllllllIlIIlI) throws IOException {
        this.id = llllllllllllllllIlIlllllllIlIIlI.readByte();
        this.uid = llllllllllllllllIlIlllllllIlIIlI.readShort();
        this.accepted = (llllllllllllllllIlIlllllllIlIIlI.readByte() != 0);
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllllIlIlllllllIIlIIl) throws IOException {
        llllllllllllllllIlIlllllllIIlIIl.writeByte(this.id);
        llllllllllllllllIlIlllllllIIlIIl.writeShort(this.uid);
        llllllllllllllllIlIlllllllIIlIIl.writeByte(this.accepted ? 1 : 0);
    }
    
    public C0FPacketConfirmTransaction(final int llllllllllllllllIlIllllllllIIlII, final short llllllllllllllllIlIllllllllIIIll, final boolean llllllllllllllllIlIllllllllIIllI) {
        this.id = llllllllllllllllIlIllllllllIIlII;
        this.uid = llllllllllllllllIlIllllllllIIIll;
        this.accepted = llllllllllllllllIlIllllllllIIllI;
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllllIlIllllllIlllIIl) {
        this.processPacket((INetHandlerPlayServer)llllllllllllllllIlIllllllIlllIIl);
    }
    
    public C0FPacketConfirmTransaction() {
    }
    
    public short getUid() {
        return this.uid;
    }
    
    static {
        __OBFID = "CL_00001351";
    }
    
    public void processPacket(final INetHandlerPlayServer llllllllllllllllIlIlllllllIllllI) {
        llllllllllllllllIlIlllllllIllllI.processConfirmTransaction(this);
    }
}
