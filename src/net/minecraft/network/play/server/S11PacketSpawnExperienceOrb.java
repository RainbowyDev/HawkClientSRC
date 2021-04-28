package net.minecraft.network.play.server;

import java.io.*;
import net.minecraft.network.*;
import net.minecraft.network.play.*;
import net.minecraft.entity.item.*;
import net.minecraft.util.*;

public class S11PacketSpawnExperienceOrb implements Packet
{
    private /* synthetic */ int field_148990_b;
    private /* synthetic */ int field_148989_e;
    private /* synthetic */ int field_148988_d;
    private /* synthetic */ int field_148991_c;
    private /* synthetic */ int field_148992_a;
    
    public int func_148983_e() {
        return this.field_148991_c;
    }
    
    public int func_148982_f() {
        return this.field_148988_d;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllllIlIllllIIIIlIlll) throws IOException {
        this.field_148992_a = llllllllllllllllIlIllllIIIIlIlll.readVarIntFromBuffer();
        this.field_148990_b = llllllllllllllllIlIllllIIIIlIlll.readInt();
        this.field_148991_c = llllllllllllllllIlIllllIIIIlIlll.readInt();
        this.field_148988_d = llllllllllllllllIlIllllIIIIlIlll.readInt();
        this.field_148989_e = llllllllllllllllIlIllllIIIIlIlll.readShort();
    }
    
    public S11PacketSpawnExperienceOrb() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllllIlIllllIIIIlIIIl) throws IOException {
        llllllllllllllllIlIllllIIIIlIIIl.writeVarIntToBuffer(this.field_148992_a);
        llllllllllllllllIlIllllIIIIlIIIl.writeInt(this.field_148990_b);
        llllllllllllllllIlIllllIIIIlIIIl.writeInt(this.field_148991_c);
        llllllllllllllllIlIllllIIIIlIIIl.writeInt(this.field_148988_d);
        llllllllllllllllIlIllllIIIIlIIIl.writeShort(this.field_148989_e);
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllllIlIlllIllllllIII) {
        this.func_180719_a((INetHandlerPlayClient)llllllllllllllllIlIlllIllllllIII);
    }
    
    public S11PacketSpawnExperienceOrb(final EntityXPOrb llllllllllllllllIlIllllIIIIlllll) {
        this.field_148992_a = llllllllllllllllIlIllllIIIIlllll.getEntityId();
        this.field_148990_b = MathHelper.floor_double(llllllllllllllllIlIllllIIIIlllll.posX * 32.0);
        this.field_148991_c = MathHelper.floor_double(llllllllllllllllIlIllllIIIIlllll.posY * 32.0);
        this.field_148988_d = MathHelper.floor_double(llllllllllllllllIlIllllIIIIlllll.posZ * 32.0);
        this.field_148989_e = llllllllllllllllIlIllllIIIIlllll.getXpValue();
    }
    
    public int func_148985_c() {
        return this.field_148992_a;
    }
    
    public int func_148984_d() {
        return this.field_148990_b;
    }
    
    public void func_180719_a(final INetHandlerPlayClient llllllllllllllllIlIllllIIIIIlIll) {
        llllllllllllllllIlIllllIIIIIlIll.handleSpawnExperienceOrb(this);
    }
    
    static {
        __OBFID = "CL_00001277";
    }
    
    public int func_148986_g() {
        return this.field_148989_e;
    }
}
