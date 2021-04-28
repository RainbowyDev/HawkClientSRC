package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class S18PacketEntityTeleport implements Packet
{
    private /* synthetic */ byte field_149455_e;
    private /* synthetic */ int field_149458_a;
    private /* synthetic */ int field_149457_c;
    private /* synthetic */ int field_149456_b;
    private /* synthetic */ boolean field_179698_g;
    private /* synthetic */ byte field_149453_f;
    private /* synthetic */ int field_149454_d;
    
    public byte func_149447_h() {
        return this.field_149453_f;
    }
    
    public S18PacketEntityTeleport(final int lllllllllllllllllIIllllllIlIlllI, final int lllllllllllllllllIIllllllIlIllIl, final int lllllllllllllllllIIllllllIlIllII, final int lllllllllllllllllIIllllllIlIlIll, final byte lllllllllllllllllIIllllllIlIIIlI, final byte lllllllllllllllllIIllllllIlIIIIl, final boolean lllllllllllllllllIIllllllIlIIIII) {
        this.field_149458_a = lllllllllllllllllIIllllllIlIlllI;
        this.field_149456_b = lllllllllllllllllIIllllllIlIllIl;
        this.field_149457_c = lllllllllllllllllIIllllllIlIllII;
        this.field_149454_d = lllllllllllllllllIIllllllIlIlIll;
        this.field_149455_e = lllllllllllllllllIIllllllIlIIIlI;
        this.field_149453_f = lllllllllllllllllIIllllllIlIIIIl;
        this.field_179698_g = lllllllllllllllllIIllllllIlIIIII;
    }
    
    public int func_149451_c() {
        return this.field_149458_a;
    }
    
    public boolean func_179697_g() {
        return this.field_179698_g;
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllllIIlllllIlllIlIl) {
        this.processPacket((INetHandlerPlayClient)lllllllllllllllllIIlllllIlllIlIl);
    }
    
    public void processPacket(final INetHandlerPlayClient lllllllllllllllllIIllllllIIIlllI) {
        lllllllllllllllllIIllllllIIIlllI.handleEntityTeleport(this);
    }
    
    public int func_149448_e() {
        return this.field_149457_c;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllllIIllllllIIlllII) throws IOException {
        this.field_149458_a = lllllllllllllllllIIllllllIIlllII.readVarIntFromBuffer();
        this.field_149456_b = lllllllllllllllllIIllllllIIlllII.readInt();
        this.field_149457_c = lllllllllllllllllIIllllllIIlllII.readInt();
        this.field_149454_d = lllllllllllllllllIIllllllIIlllII.readInt();
        this.field_149455_e = lllllllllllllllllIIllllllIIlllII.readByte();
        this.field_149453_f = lllllllllllllllllIIllllllIIlllII.readByte();
        this.field_179698_g = lllllllllllllllllIIllllllIIlllII.readBoolean();
    }
    
    static {
        __OBFID = "CL_00001340";
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllllIIllllllIIlIlII) throws IOException {
        lllllllllllllllllIIllllllIIlIlII.writeVarIntToBuffer(this.field_149458_a);
        lllllllllllllllllIIllllllIIlIlII.writeInt(this.field_149456_b);
        lllllllllllllllllIIllllllIIlIlII.writeInt(this.field_149457_c);
        lllllllllllllllllIIllllllIIlIlII.writeInt(this.field_149454_d);
        lllllllllllllllllIIllllllIIlIlII.writeByte(this.field_149455_e);
        lllllllllllllllllIIllllllIIlIlII.writeByte(this.field_149453_f);
        lllllllllllllllllIIllllllIIlIlII.writeBoolean(this.field_179698_g);
    }
    
    public S18PacketEntityTeleport(final Entity lllllllllllllllllIIllllllIlllIlI) {
        this.field_149458_a = lllllllllllllllllIIllllllIlllIlI.getEntityId();
        this.field_149456_b = MathHelper.floor_double(lllllllllllllllllIIllllllIlllIlI.posX * 32.0);
        this.field_149457_c = MathHelper.floor_double(lllllllllllllllllIIllllllIlllIlI.posY * 32.0);
        this.field_149454_d = MathHelper.floor_double(lllllllllllllllllIIllllllIlllIlI.posZ * 32.0);
        this.field_149455_e = (byte)(lllllllllllllllllIIllllllIlllIlI.rotationYaw * 256.0f / 360.0f);
        this.field_149453_f = (byte)(lllllllllllllllllIIllllllIlllIlI.rotationPitch * 256.0f / 360.0f);
        this.field_179698_g = lllllllllllllllllIIllllllIlllIlI.onGround;
    }
    
    public S18PacketEntityTeleport() {
    }
    
    public int func_149449_d() {
        return this.field_149456_b;
    }
    
    public byte func_149450_g() {
        return this.field_149455_e;
    }
    
    public int func_149446_f() {
        return this.field_149454_d;
    }
}
