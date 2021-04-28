package net.minecraft.network.play.server;

import java.util.*;
import java.io.*;
import net.minecraft.network.*;
import net.minecraft.network.play.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class S0FPacketSpawnMob implements Packet
{
    private /* synthetic */ int field_149036_f;
    private /* synthetic */ byte field_149045_j;
    private /* synthetic */ byte field_149046_k;
    private /* synthetic */ int field_149040_b;
    private /* synthetic */ DataWatcher field_149043_l;
    private /* synthetic */ int field_149038_d;
    private /* synthetic */ int field_149037_g;
    private /* synthetic */ byte field_149048_i;
    private /* synthetic */ List field_149044_m;
    private /* synthetic */ int field_149039_e;
    private /* synthetic */ int field_149041_c;
    private /* synthetic */ int field_149047_h;
    private /* synthetic */ int field_149042_a;
    
    public int func_149029_h() {
        return this.field_149039_e;
    }
    
    public int func_149026_i() {
        return this.field_149036_f;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllllIlllIIIIIlIIIIl) throws IOException {
        this.field_149042_a = lllllllllllllllllIlllIIIIIlIIIIl.readVarIntFromBuffer();
        this.field_149040_b = (lllllllllllllllllIlllIIIIIlIIIIl.readByte() & 0xFF);
        this.field_149041_c = lllllllllllllllllIlllIIIIIlIIIIl.readInt();
        this.field_149038_d = lllllllllllllllllIlllIIIIIlIIIIl.readInt();
        this.field_149039_e = lllllllllllllllllIlllIIIIIlIIIIl.readInt();
        this.field_149048_i = lllllllllllllllllIlllIIIIIlIIIIl.readByte();
        this.field_149045_j = lllllllllllllllllIlllIIIIIlIIIIl.readByte();
        this.field_149046_k = lllllllllllllllllIlllIIIIIlIIIIl.readByte();
        this.field_149036_f = lllllllllllllllllIlllIIIIIlIIIIl.readShort();
        this.field_149037_g = lllllllllllllllllIlllIIIIIlIIIIl.readShort();
        this.field_149047_h = lllllllllllllllllIlllIIIIIlIIIIl.readShort();
        this.field_149044_m = DataWatcher.readWatchedListFromPacketBuffer(lllllllllllllllllIlllIIIIIlIIIIl);
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllllIllIllllllIlIll) {
        this.func_180721_a((INetHandlerPlayClient)lllllllllllllllllIllIllllllIlIll);
    }
    
    public void func_180721_a(final INetHandlerPlayClient lllllllllllllllllIlllIIIIIIlIlIl) {
        lllllllllllllllllIlllIIIIIIlIlIl.handleSpawnMob(this);
    }
    
    public byte func_149028_l() {
        return this.field_149048_i;
    }
    
    static {
        __OBFID = "CL_00001279";
    }
    
    public byte func_149032_n() {
        return this.field_149046_k;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllllIlllIIIIIIllIIl) throws IOException {
        lllllllllllllllllIlllIIIIIIllIIl.writeVarIntToBuffer(this.field_149042_a);
        lllllllllllllllllIlllIIIIIIllIIl.writeByte(this.field_149040_b & 0xFF);
        lllllllllllllllllIlllIIIIIIllIIl.writeInt(this.field_149041_c);
        lllllllllllllllllIlllIIIIIIllIIl.writeInt(this.field_149038_d);
        lllllllllllllllllIlllIIIIIIllIIl.writeInt(this.field_149039_e);
        lllllllllllllllllIlllIIIIIIllIIl.writeByte(this.field_149048_i);
        lllllllllllllllllIlllIIIIIIllIIl.writeByte(this.field_149045_j);
        lllllllllllllllllIlllIIIIIIllIIl.writeByte(this.field_149046_k);
        lllllllllllllllllIlllIIIIIIllIIl.writeShort(this.field_149036_f);
        lllllllllllllllllIlllIIIIIIllIIl.writeShort(this.field_149037_g);
        lllllllllllllllllIlllIIIIIIllIIl.writeShort(this.field_149047_h);
        this.field_149043_l.writeTo(lllllllllllllllllIlllIIIIIIllIIl);
    }
    
    public int func_149034_g() {
        return this.field_149038_d;
    }
    
    public byte func_149030_m() {
        return this.field_149045_j;
    }
    
    public int func_149033_j() {
        return this.field_149037_g;
    }
    
    public int func_149031_k() {
        return this.field_149047_h;
    }
    
    public S0FPacketSpawnMob() {
    }
    
    public int func_149025_e() {
        return this.field_149040_b;
    }
    
    public List func_149027_c() {
        if (this.field_149044_m == null) {
            this.field_149044_m = this.field_149043_l.getAllWatched();
        }
        return this.field_149044_m;
    }
    
    public int func_149024_d() {
        return this.field_149042_a;
    }
    
    public S0FPacketSpawnMob(final EntityLivingBase lllllllllllllllllIlllIIIIIlIllll) {
        this.field_149042_a = lllllllllllllllllIlllIIIIIlIllll.getEntityId();
        this.field_149040_b = (byte)EntityList.getEntityID(lllllllllllllllllIlllIIIIIlIllll);
        this.field_149041_c = MathHelper.floor_double(lllllllllllllllllIlllIIIIIlIllll.posX * 32.0);
        this.field_149038_d = MathHelper.floor_double(lllllllllllllllllIlllIIIIIlIllll.posY * 32.0);
        this.field_149039_e = MathHelper.floor_double(lllllllllllllllllIlllIIIIIlIllll.posZ * 32.0);
        this.field_149048_i = (byte)(lllllllllllllllllIlllIIIIIlIllll.rotationYaw * 256.0f / 360.0f);
        this.field_149045_j = (byte)(lllllllllllllllllIlllIIIIIlIllll.rotationPitch * 256.0f / 360.0f);
        this.field_149046_k = (byte)(lllllllllllllllllIlllIIIIIlIllll.rotationYawHead * 256.0f / 360.0f);
        final double lllllllllllllllllIlllIIIIIlIlllI = 3.9;
        double lllllllllllllllllIlllIIIIIlIllIl = lllllllllllllllllIlllIIIIIlIllll.motionX;
        double lllllllllllllllllIlllIIIIIlIllII = lllllllllllllllllIlllIIIIIlIllll.motionY;
        double lllllllllllllllllIlllIIIIIlIlIll = lllllllllllllllllIlllIIIIIlIllll.motionZ;
        if (lllllllllllllllllIlllIIIIIlIllIl < -lllllllllllllllllIlllIIIIIlIlllI) {
            lllllllllllllllllIlllIIIIIlIllIl = -lllllllllllllllllIlllIIIIIlIlllI;
        }
        if (lllllllllllllllllIlllIIIIIlIllII < -lllllllllllllllllIlllIIIIIlIlllI) {
            lllllllllllllllllIlllIIIIIlIllII = -lllllllllllllllllIlllIIIIIlIlllI;
        }
        if (lllllllllllllllllIlllIIIIIlIlIll < -lllllllllllllllllIlllIIIIIlIlllI) {
            lllllllllllllllllIlllIIIIIlIlIll = -lllllllllllllllllIlllIIIIIlIlllI;
        }
        if (lllllllllllllllllIlllIIIIIlIllIl > lllllllllllllllllIlllIIIIIlIlllI) {
            lllllllllllllllllIlllIIIIIlIllIl = lllllllllllllllllIlllIIIIIlIlllI;
        }
        if (lllllllllllllllllIlllIIIIIlIllII > lllllllllllllllllIlllIIIIIlIlllI) {
            lllllllllllllllllIlllIIIIIlIllII = lllllllllllllllllIlllIIIIIlIlllI;
        }
        if (lllllllllllllllllIlllIIIIIlIlIll > lllllllllllllllllIlllIIIIIlIlllI) {
            lllllllllllllllllIlllIIIIIlIlIll = lllllllllllllllllIlllIIIIIlIlllI;
        }
        this.field_149036_f = (int)(lllllllllllllllllIlllIIIIIlIllIl * 8000.0);
        this.field_149037_g = (int)(lllllllllllllllllIlllIIIIIlIllII * 8000.0);
        this.field_149047_h = (int)(lllllllllllllllllIlllIIIIIlIlIll * 8000.0);
        this.field_149043_l = lllllllllllllllllIlllIIIIIlIllll.getDataWatcher();
    }
    
    public int func_149023_f() {
        return this.field_149041_c;
    }
}
