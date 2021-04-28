package net.minecraft.network.play.server;

import java.io.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;

public class S19PacketEntityStatus implements Packet
{
    private /* synthetic */ int field_149164_a;
    private /* synthetic */ byte field_149163_b;
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIlllIIlIlllIlIIl) throws IOException {
        lllllllllllllllIIlllIIlIlllIlIIl.writeInt(this.field_149164_a);
        lllllllllllllllIIlllIIlIlllIlIIl.writeByte(this.field_149163_b);
    }
    
    public S19PacketEntityStatus(final Entity lllllllllllllllIIlllIIlIllllIlll, final byte lllllllllllllllIIlllIIlIllllIllI) {
        this.field_149164_a = lllllllllllllllIIlllIIlIllllIlll.getEntityId();
        this.field_149163_b = lllllllllllllllIIlllIIlIllllIllI;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIlllIIlIlllIllll) throws IOException {
        this.field_149164_a = lllllllllllllllIIlllIIlIlllIllll.readInt();
        this.field_149163_b = lllllllllllllllIIlllIIlIlllIllll.readByte();
    }
    
    static {
        __OBFID = "CL_00001299";
    }
    
    public S19PacketEntityStatus() {
    }
    
    public Entity func_149161_a(final World lllllllllllllllIIlllIIlIllIllIll) {
        return lllllllllllllllIIlllIIlIllIllIll.getEntityByID(this.field_149164_a);
    }
    
    public void func_180736_a(final INetHandlerPlayClient lllllllllllllllIIlllIIlIlllIIIIl) {
        lllllllllllllllIIlllIIlIlllIIIIl.handleEntityStatus(this);
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllIIlllIIlIllIlIlII) {
        this.func_180736_a((INetHandlerPlayClient)lllllllllllllllIIlllIIlIllIlIlII);
    }
    
    public byte func_149160_c() {
        return this.field_149163_b;
    }
}
