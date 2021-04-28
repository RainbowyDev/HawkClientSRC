package net.minecraft.network.play.server;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;

public class S19PacketEntityHeadLook implements Packet
{
    private /* synthetic */ byte field_149383_b;
    private /* synthetic */ int field_149384_a;
    
    public Entity func_149381_a(final World llllllllllllllllIllllIlllIllllll) {
        return llllllllllllllllIllllIlllIllllll.getEntityByID(this.field_149384_a);
    }
    
    public S19PacketEntityHeadLook() {
    }
    
    public byte func_149380_c() {
        return this.field_149383_b;
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllllIllllIlllIllIllI) {
        this.func_180745_a((INetHandlerPlayClient)llllllllllllllllIllllIlllIllIllI);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllllIllllIllllIlIIll) throws IOException {
        this.field_149384_a = llllllllllllllllIllllIllllIlIIll.readVarIntFromBuffer();
        this.field_149383_b = llllllllllllllllIllllIllllIlIIll.readByte();
    }
    
    public S19PacketEntityHeadLook(final Entity llllllllllllllllIllllIllllIllIll, final byte llllllllllllllllIllllIllllIllIlI) {
        this.field_149384_a = llllllllllllllllIllllIllllIllIll.getEntityId();
        this.field_149383_b = llllllllllllllllIllllIllllIllIlI;
    }
    
    static {
        __OBFID = "CL_00001323";
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllllIllllIllllIIlIll) throws IOException {
        llllllllllllllllIllllIllllIIlIll.writeVarIntToBuffer(this.field_149384_a);
        llllllllllllllllIllllIllllIIlIll.writeByte(this.field_149383_b);
    }
    
    public void func_180745_a(final INetHandlerPlayClient llllllllllllllllIllllIllllIIIlll) {
        llllllllllllllllIllllIllllIIIlll.handleEntityHeadLook(this);
    }
}
