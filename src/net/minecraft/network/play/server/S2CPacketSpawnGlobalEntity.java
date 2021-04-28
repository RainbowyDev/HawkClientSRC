package net.minecraft.network.play.server;

import java.io.*;
import net.minecraft.network.*;
import net.minecraft.network.play.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.entity.effect.*;

public class S2CPacketSpawnGlobalEntity implements Packet
{
    private /* synthetic */ int field_149058_c;
    private /* synthetic */ int field_149059_a;
    private /* synthetic */ int field_149057_b;
    private /* synthetic */ int field_149055_d;
    private /* synthetic */ int field_149056_e;
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIIIllIlIlIllllII) throws IOException {
        this.field_149059_a = lllllllllllllllIIIIllIlIlIllllII.readVarIntFromBuffer();
        this.field_149056_e = lllllllllllllllIIIIllIlIlIllllII.readByte();
        this.field_149057_b = lllllllllllllllIIIIllIlIlIllllII.readInt();
        this.field_149058_c = lllllllllllllllIIIIllIlIlIllllII.readInt();
        this.field_149055_d = lllllllllllllllIIIIllIlIlIllllII.readInt();
    }
    
    public S2CPacketSpawnGlobalEntity() {
    }
    
    public int func_149052_c() {
        return this.field_149059_a;
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllIIIIllIlIlIIllIll) {
        this.func_180720_a((INetHandlerPlayClient)lllllllllllllllIIIIllIlIlIIllIll);
    }
    
    public int func_149049_f() {
        return this.field_149055_d;
    }
    
    public S2CPacketSpawnGlobalEntity(final Entity lllllllllllllllIIIIllIlIllIIIIlI) {
        this.field_149059_a = lllllllllllllllIIIIllIlIllIIIIlI.getEntityId();
        this.field_149057_b = MathHelper.floor_double(lllllllllllllllIIIIllIlIllIIIIlI.posX * 32.0);
        this.field_149058_c = MathHelper.floor_double(lllllllllllllllIIIIllIlIllIIIIlI.posY * 32.0);
        this.field_149055_d = MathHelper.floor_double(lllllllllllllllIIIIllIlIllIIIIlI.posZ * 32.0);
        if (lllllllllllllllIIIIllIlIllIIIIlI instanceof EntityLightningBolt) {
            this.field_149056_e = 1;
        }
    }
    
    static {
        __OBFID = "CL_00001278";
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIIIllIlIlIllIlII) throws IOException {
        lllllllllllllllIIIIllIlIlIllIlII.writeVarIntToBuffer(this.field_149059_a);
        lllllllllllllllIIIIllIlIlIllIlII.writeByte(this.field_149056_e);
        lllllllllllllllIIIIllIlIlIllIlII.writeInt(this.field_149057_b);
        lllllllllllllllIIIIllIlIlIllIlII.writeInt(this.field_149058_c);
        lllllllllllllllIIIIllIlIlIllIlII.writeInt(this.field_149055_d);
    }
    
    public void func_180720_a(final INetHandlerPlayClient lllllllllllllllIIIIllIlIlIlIlllI) {
        lllllllllllllllIIIIllIlIlIlIlllI.handleSpawnGlobalEntity(this);
    }
    
    public int func_149050_e() {
        return this.field_149058_c;
    }
    
    public int func_149051_d() {
        return this.field_149057_b;
    }
    
    public int func_149053_g() {
        return this.field_149056_e;
    }
}
