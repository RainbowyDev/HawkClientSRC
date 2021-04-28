package net.minecraft.network.play.server;

import java.io.*;
import net.minecraft.network.*;
import net.minecraft.network.play.*;
import java.util.*;

public class S08PacketPlayerPosLook implements Packet
{
    private /* synthetic */ float field_148936_d;
    private /* synthetic */ float field_148937_e;
    private /* synthetic */ double field_148938_b;
    private /* synthetic */ double field_148940_a;
    private /* synthetic */ Set field_179835_f;
    private /* synthetic */ double field_148939_c;
    
    static {
        __OBFID = "CL_00001273";
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIIIlIIllllIIIIll) throws IOException {
        this.field_148940_a = lllllllllllllllIIIIlIIllllIIIIll.readDouble();
        this.field_148938_b = lllllllllllllllIIIIlIIllllIIIIll.readDouble();
        this.field_148939_c = lllllllllllllllIIIIlIIllllIIIIll.readDouble();
        this.field_148936_d = lllllllllllllllIIIIlIIllllIIIIll.readFloat();
        this.field_148937_e = lllllllllllllllIIIIlIIllllIIIIll.readFloat();
        this.field_179835_f = EnumFlags.func_180053_a(lllllllllllllllIIIIlIIllllIIIIll.readUnsignedByte());
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIIIlIIlllIllllll) throws IOException {
        lllllllllllllllIIIIlIIlllIllllll.writeDouble(this.field_148940_a);
        lllllllllllllllIIIIlIIlllIllllll.writeDouble(this.field_148938_b);
        lllllllllllllllIIIIlIIlllIllllll.writeDouble(this.field_148939_c);
        lllllllllllllllIIIIlIIlllIllllll.writeFloat(this.field_148936_d);
        lllllllllllllllIIIIlIIlllIllllll.writeFloat(this.field_148937_e);
        lllllllllllllllIIIIlIIlllIllllll.writeByte(EnumFlags.func_180056_a(this.field_179835_f));
    }
    
    public float func_148930_g() {
        return this.field_148937_e;
    }
    
    public double func_148928_d() {
        return this.field_148938_b;
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllIIIIlIIlllIIlllll) {
        this.func_180718_a((INetHandlerPlayClient)lllllllllllllllIIIIlIIlllIIlllll);
    }
    
    public S08PacketPlayerPosLook() {
    }
    
    public double func_148932_c() {
        return this.field_148940_a;
    }
    
    public double func_148933_e() {
        return this.field_148939_c;
    }
    
    public void func_180718_a(final INetHandlerPlayClient lllllllllllllllIIIIlIIlllIllIlll) {
        lllllllllllllllIIIIlIIlllIllIlll.handlePlayerPosLook(this);
    }
    
    public S08PacketPlayerPosLook(final double lllllllllllllllIIIIlIIllllIIlllI, final double lllllllllllllllIIIIlIIllllIIllIl, final double lllllllllllllllIIIIlIIllllIIllII, final float lllllllllllllllIIIIlIIllllIIlIll, final float lllllllllllllllIIIIlIIllllIlIIIl, final Set lllllllllllllllIIIIlIIllllIIlIIl) {
        this.field_148940_a = lllllllllllllllIIIIlIIllllIIlllI;
        this.field_148938_b = lllllllllllllllIIIIlIIllllIIllIl;
        this.field_148939_c = lllllllllllllllIIIIlIIllllIIllII;
        this.field_148936_d = lllllllllllllllIIIIlIIllllIIlIll;
        this.field_148937_e = lllllllllllllllIIIIlIIllllIlIIIl;
        this.field_179835_f = lllllllllllllllIIIIlIIllllIIlIIl;
    }
    
    public Set func_179834_f() {
        return this.field_179835_f;
    }
    
    public float func_148931_f() {
        return this.field_148936_d;
    }
    
    public enum EnumFlags
    {
        X("X", 0, "X", 0, 0), 
        Y("Y", 1, "Y", 1, 1);
        
        private /* synthetic */ int field_180058_f;
        
        X_ROT("X_ROT", 4, "X_ROT", 4, 4), 
        Y_ROT("Y_ROT", 3, "Y_ROT", 3, 3), 
        Z("Z", 2, "Z", 2, 2);
        
        private int func_180055_a() {
            return 1 << this.field_180058_f;
        }
        
        public static Set func_180053_a(final int llIIIlIlllIlII) {
            final EnumSet llIIIlIllllIIl = EnumSet.noneOf(EnumFlags.class);
            for (final EnumFlags llIIIlIlllIlIl : values()) {
                if (llIIIlIlllIlIl.func_180054_b(llIIIlIlllIlII)) {
                    llIIIlIllllIIl.add(llIIIlIlllIlIl);
                }
            }
            return llIIIlIllllIIl;
        }
        
        public static int func_180056_a(final Set llIIIlIllIIllI) {
            int llIIIlIllIlIIl = 0;
            for (final EnumFlags llIIIlIllIlIII : llIIIlIllIIllI) {
                llIIIlIllIlIIl |= llIIIlIllIlIII.func_180055_a();
            }
            return llIIIlIllIlIIl;
        }
        
        static {
            __OBFID = "CL_00002304";
        }
        
        private EnumFlags(final String llIIIllIIIllII, final int llIIIllIIIlIll, final String llIIIllIIlIIII, final int llIIIllIIIllll, final int llIIIllIIIlIlI) {
            this.field_180058_f = llIIIllIIIlIlI;
        }
        
        private boolean func_180054_b(final int llIIIllIIIIIIl) {
            return (llIIIllIIIIIIl & this.func_180055_a()) == this.func_180055_a();
        }
    }
}
