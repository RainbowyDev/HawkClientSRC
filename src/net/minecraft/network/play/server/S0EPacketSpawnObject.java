package net.minecraft.network.play.server;

import java.io.*;
import net.minecraft.entity.*;
import net.minecraft.network.*;
import net.minecraft.network.play.*;
import net.minecraft.util.*;

public class S0EPacketSpawnObject implements Packet
{
    private /* synthetic */ int field_149015_e;
    private /* synthetic */ int field_149016_b;
    private /* synthetic */ int field_149018_a;
    private /* synthetic */ int field_149013_g;
    private /* synthetic */ int field_149021_h;
    private /* synthetic */ int field_149022_i;
    private /* synthetic */ int field_149019_j;
    private /* synthetic */ int field_149012_f;
    private /* synthetic */ int field_149020_k;
    private /* synthetic */ int field_149017_c;
    private /* synthetic */ int field_149014_d;
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIlIlIlllIllIlIlIl) throws IOException {
        lllllllllllllllIlIlIlllIllIlIlIl.writeVarIntToBuffer(this.field_149018_a);
        lllllllllllllllIlIlIlllIllIlIlIl.writeByte(this.field_149019_j);
        lllllllllllllllIlIlIlllIllIlIlIl.writeInt(this.field_149016_b);
        lllllllllllllllIlIlIlllIllIlIlIl.writeInt(this.field_149017_c);
        lllllllllllllllIlIlIlllIllIlIlIl.writeInt(this.field_149014_d);
        lllllllllllllllIlIlIlllIllIlIlIl.writeByte(this.field_149021_h);
        lllllllllllllllIlIlIlllIllIlIlIl.writeByte(this.field_149022_i);
        lllllllllllllllIlIlIlllIllIlIlIl.writeInt(this.field_149020_k);
        if (this.field_149020_k > 0) {
            lllllllllllllllIlIlIlllIllIlIlIl.writeShort(this.field_149015_e);
            lllllllllllllllIlIlIlllIllIlIlIl.writeShort(this.field_149012_f);
            lllllllllllllllIlIlIlllIllIlIlIl.writeShort(this.field_149013_g);
        }
    }
    
    public void func_149003_d(final int lllllllllllllllIlIlIlllIlIIlIllI) {
        this.field_149015_e = lllllllllllllllIlIlIlllIlIIlIllI;
    }
    
    public int func_149001_c() {
        return this.field_149018_a;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIlIlIlllIllIllIll) throws IOException {
        this.field_149018_a = lllllllllllllllIlIlIlllIllIllIll.readVarIntFromBuffer();
        this.field_149019_j = lllllllllllllllIlIlIlllIllIllIll.readByte();
        this.field_149016_b = lllllllllllllllIlIlIlllIllIllIll.readInt();
        this.field_149017_c = lllllllllllllllIlIlIlllIllIllIll.readInt();
        this.field_149014_d = lllllllllllllllIlIlIlllIllIllIll.readInt();
        this.field_149021_h = lllllllllllllllIlIlIlllIllIllIll.readByte();
        this.field_149022_i = lllllllllllllllIlIlIlllIllIllIll.readByte();
        this.field_149020_k = lllllllllllllllIlIlIlllIllIllIll.readInt();
        if (this.field_149020_k > 0) {
            this.field_149015_e = lllllllllllllllIlIlIlllIllIllIll.readShort();
            this.field_149012_f = lllllllllllllllIlIlIlllIllIllIll.readShort();
            this.field_149013_g = lllllllllllllllIlIlIlllIllIllIll.readShort();
        }
    }
    
    public int func_149010_g() {
        return this.field_149015_e;
    }
    
    public void func_148996_a(final int lllllllllllllllIlIlIlllIlIlIIllI) {
        this.field_149016_b = lllllllllllllllIlIlIlllIlIlIIllI;
    }
    
    public int func_149008_j() {
        return this.field_149021_h;
    }
    
    public void func_149002_g(final int lllllllllllllllIlIlIlllIlIIIIIlI) {
        this.field_149020_k = lllllllllllllllIlIlIlllIlIIIIIlI;
    }
    
    public S0EPacketSpawnObject(final Entity lllllllllllllllIlIlIlllIlllllIII, final int lllllllllllllllIlIlIlllIllllIlll) {
        this(lllllllllllllllIlIlIlllIlllllIII, lllllllllllllllIlIlIlllIllllIlll, 0);
    }
    
    public int func_148994_f() {
        return this.field_149014_d;
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllIlIlIlllIIlllllII) {
        this.processPacket((INetHandlerPlayClient)lllllllllllllllIlIlIlllIIlllllII);
    }
    
    public int func_149009_m() {
        return this.field_149020_k;
    }
    
    public int func_148993_l() {
        return this.field_149019_j;
    }
    
    public int func_148998_e() {
        return this.field_149017_c;
    }
    
    public int func_149004_h() {
        return this.field_149012_f;
    }
    
    public void func_149005_c(final int lllllllllllllllIlIlIlllIlIIllIlI) {
        this.field_149014_d = lllllllllllllllIlIlIlllIlIIllIlI;
    }
    
    public int func_149006_k() {
        return this.field_149022_i;
    }
    
    public void func_149007_f(final int lllllllllllllllIlIlIlllIlIIIlIII) {
        this.field_149013_g = lllllllllllllllIlIlIlllIlIIIlIII;
    }
    
    public S0EPacketSpawnObject(final Entity lllllllllllllllIlIlIlllIlllIIlIl, final int lllllllllllllllIlIlIlllIlllIIlII, final int lllllllllllllllIlIlIlllIlllIIIll) {
        this.field_149018_a = lllllllllllllllIlIlIlllIlllIIlIl.getEntityId();
        this.field_149016_b = MathHelper.floor_double(lllllllllllllllIlIlIlllIlllIIlIl.posX * 32.0);
        this.field_149017_c = MathHelper.floor_double(lllllllllllllllIlIlIlllIlllIIlIl.posY * 32.0);
        this.field_149014_d = MathHelper.floor_double(lllllllllllllllIlIlIlllIlllIIlIl.posZ * 32.0);
        this.field_149021_h = MathHelper.floor_float(lllllllllllllllIlIlIlllIlllIIlIl.rotationPitch * 256.0f / 360.0f);
        this.field_149022_i = MathHelper.floor_float(lllllllllllllllIlIlIlllIlllIIlIl.rotationYaw * 256.0f / 360.0f);
        this.field_149019_j = lllllllllllllllIlIlIlllIlllIIlII;
        this.field_149020_k = lllllllllllllllIlIlIlllIlllIIIll;
        if (lllllllllllllllIlIlIlllIlllIIIll > 0) {
            double lllllllllllllllIlIlIlllIlllIlIlI = lllllllllllllllIlIlIlllIlllIIlIl.motionX;
            double lllllllllllllllIlIlIlllIlllIlIIl = lllllllllllllllIlIlIlllIlllIIlIl.motionY;
            double lllllllllllllllIlIlIlllIlllIlIII = lllllllllllllllIlIlIlllIlllIIlIl.motionZ;
            final double lllllllllllllllIlIlIlllIlllIIlll = 3.9;
            if (lllllllllllllllIlIlIlllIlllIlIlI < -lllllllllllllllIlIlIlllIlllIIlll) {
                lllllllllllllllIlIlIlllIlllIlIlI = -lllllllllllllllIlIlIlllIlllIIlll;
            }
            if (lllllllllllllllIlIlIlllIlllIlIIl < -lllllllllllllllIlIlIlllIlllIIlll) {
                lllllllllllllllIlIlIlllIlllIlIIl = -lllllllllllllllIlIlIlllIlllIIlll;
            }
            if (lllllllllllllllIlIlIlllIlllIlIII < -lllllllllllllllIlIlIlllIlllIIlll) {
                lllllllllllllllIlIlIlllIlllIlIII = -lllllllllllllllIlIlIlllIlllIIlll;
            }
            if (lllllllllllllllIlIlIlllIlllIlIlI > lllllllllllllllIlIlIlllIlllIIlll) {
                lllllllllllllllIlIlIlllIlllIlIlI = lllllllllllllllIlIlIlllIlllIIlll;
            }
            if (lllllllllllllllIlIlIlllIlllIlIIl > lllllllllllllllIlIlIlllIlllIIlll) {
                lllllllllllllllIlIlIlllIlllIlIIl = lllllllllllllllIlIlIlllIlllIIlll;
            }
            if (lllllllllllllllIlIlIlllIlllIlIII > lllllllllllllllIlIlIlllIlllIIlll) {
                lllllllllllllllIlIlIlllIlllIlIII = lllllllllllllllIlIlIlllIlllIIlll;
            }
            this.field_149015_e = (int)(lllllllllllllllIlIlIlllIlllIlIlI * 8000.0);
            this.field_149012_f = (int)(lllllllllllllllIlIlIlllIlllIlIIl * 8000.0);
            this.field_149013_g = (int)(lllllllllllllllIlIlIlllIlllIlIII * 8000.0);
        }
    }
    
    public int func_148997_d() {
        return this.field_149016_b;
    }
    
    public void processPacket(final INetHandlerPlayClient lllllllllllllllIlIlIlllIllIIllll) {
        lllllllllllllllIlIlIlllIllIIllll.handleSpawnObject(this);
    }
    
    static {
        __OBFID = "CL_00001276";
    }
    
    public void func_148995_b(final int lllllllllllllllIlIlIlllIlIlIIIII) {
        this.field_149017_c = lllllllllllllllIlIlIlllIlIlIIIII;
    }
    
    public void func_149000_e(final int lllllllllllllllIlIlIlllIlIIlIIII) {
        this.field_149012_f = lllllllllllllllIlIlIlllIlIIlIIII;
    }
    
    public S0EPacketSpawnObject() {
    }
    
    public int func_148999_i() {
        return this.field_149013_g;
    }
}
