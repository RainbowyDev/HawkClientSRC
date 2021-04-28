package net.minecraft.network.play.server;

import net.minecraft.util.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;

public class S2APacketParticles implements Packet
{
    private /* synthetic */ float field_149230_f;
    private /* synthetic */ float field_149235_c;
    private /* synthetic */ float field_149233_e;
    private /* synthetic */ float field_149237_h;
    private /* synthetic */ EnumParticleTypes field_179751_a;
    private /* synthetic */ float field_149234_b;
    private /* synthetic */ boolean field_179752_j;
    private /* synthetic */ float field_149231_g;
    private /* synthetic */ int field_149238_i;
    private /* synthetic */ int[] field_179753_k;
    private /* synthetic */ float field_149232_d;
    
    public void func_180740_a(final INetHandlerPlayClient llllllllllllllllIlIlllIIIIllllIl) {
        llllllllllllllllIlIlllIIIIllllIl.handleParticles(this);
    }
    
    public float func_149224_h() {
        return this.field_149230_f;
    }
    
    public boolean func_179750_b() {
        return this.field_179752_j;
    }
    
    public EnumParticleTypes func_179749_a() {
        return this.field_179751_a;
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllllIlIlllIIIIllIlIl) {
        this.func_180740_a((INetHandlerPlayClient)llllllllllllllllIlIlllIIIIllIlIl);
    }
    
    public double func_149226_e() {
        return this.field_149235_c;
    }
    
    public float func_149221_g() {
        return this.field_149233_e;
    }
    
    public int func_149222_k() {
        return this.field_149238_i;
    }
    
    public float func_149227_j() {
        return this.field_149237_h;
    }
    
    public double func_149225_f() {
        return this.field_149232_d;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllllIlIlllIIIlllIIII) throws IOException {
        this.field_179751_a = EnumParticleTypes.func_179342_a(llllllllllllllllIlIlllIIIlllIIII.readInt());
        if (this.field_179751_a == null) {
            this.field_179751_a = EnumParticleTypes.BARRIER;
        }
        this.field_179752_j = llllllllllllllllIlIlllIIIlllIIII.readBoolean();
        this.field_149234_b = llllllllllllllllIlIlllIIIlllIIII.readFloat();
        this.field_149235_c = llllllllllllllllIlIlllIIIlllIIII.readFloat();
        this.field_149232_d = llllllllllllllllIlIlllIIIlllIIII.readFloat();
        this.field_149233_e = llllllllllllllllIlIlllIIIlllIIII.readFloat();
        this.field_149230_f = llllllllllllllllIlIlllIIIlllIIII.readFloat();
        this.field_149231_g = llllllllllllllllIlIlllIIIlllIIII.readFloat();
        this.field_149237_h = llllllllllllllllIlIlllIIIlllIIII.readFloat();
        this.field_149238_i = llllllllllllllllIlIlllIIIlllIIII.readInt();
        final int llllllllllllllllIlIlllIIIlllIIll = this.field_179751_a.func_179345_d();
        this.field_179753_k = new int[llllllllllllllllIlIlllIIIlllIIll];
        for (int llllllllllllllllIlIlllIIIlllIIlI = 0; llllllllllllllllIlIlllIIIlllIIlI < llllllllllllllllIlIlllIIIlllIIll; ++llllllllllllllllIlIlllIIIlllIIlI) {
            this.field_179753_k[llllllllllllllllIlIlllIIIlllIIlI] = llllllllllllllllIlIlllIIIlllIIII.readVarIntFromBuffer();
        }
    }
    
    public float func_149223_i() {
        return this.field_149231_g;
    }
    
    public S2APacketParticles() {
    }
    
    public double func_149220_d() {
        return this.field_149234_b;
    }
    
    public int[] func_179748_k() {
        return this.field_179753_k;
    }
    
    static {
        __OBFID = "CL_00001308";
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllllIlIlllIIIllIlIII) throws IOException {
        llllllllllllllllIlIlllIIIllIlIII.writeInt(this.field_179751_a.func_179348_c());
        llllllllllllllllIlIlllIIIllIlIII.writeBoolean(this.field_179752_j);
        llllllllllllllllIlIlllIIIllIlIII.writeFloat(this.field_149234_b);
        llllllllllllllllIlIlllIIIllIlIII.writeFloat(this.field_149235_c);
        llllllllllllllllIlIlllIIIllIlIII.writeFloat(this.field_149232_d);
        llllllllllllllllIlIlllIIIllIlIII.writeFloat(this.field_149233_e);
        llllllllllllllllIlIlllIIIllIlIII.writeFloat(this.field_149230_f);
        llllllllllllllllIlIlllIIIllIlIII.writeFloat(this.field_149231_g);
        llllllllllllllllIlIlllIIIllIlIII.writeFloat(this.field_149237_h);
        llllllllllllllllIlIlllIIIllIlIII.writeInt(this.field_149238_i);
        for (int llllllllllllllllIlIlllIIIllIIlll = this.field_179751_a.func_179345_d(), llllllllllllllllIlIlllIIIllIIllI = 0; llllllllllllllllIlIlllIIIllIIllI < llllllllllllllllIlIlllIIIllIIlll; ++llllllllllllllllIlIlllIIIllIIllI) {
            llllllllllllllllIlIlllIIIllIlIII.writeVarIntToBuffer(this.field_179753_k[llllllllllllllllIlIlllIIIllIIllI]);
        }
    }
    
    public S2APacketParticles(final EnumParticleTypes llllllllllllllllIlIlllIIlIIIIlII, final boolean llllllllllllllllIlIlllIIlIIIIIll, final float llllllllllllllllIlIlllIIlIIIlllI, final float llllllllllllllllIlIlllIIlIIIllIl, final float llllllllllllllllIlIlllIIlIIIIIII, final float llllllllllllllllIlIlllIIIlllllll, final float llllllllllllllllIlIlllIIIllllllI, final float llllllllllllllllIlIlllIIlIIIlIIl, final float llllllllllllllllIlIlllIIIlllllII, final int llllllllllllllllIlIlllIIlIIIIlll, final int... llllllllllllllllIlIlllIIlIIIIllI) {
        this.field_179751_a = llllllllllllllllIlIlllIIlIIIIlII;
        this.field_179752_j = llllllllllllllllIlIlllIIlIIIIIll;
        this.field_149234_b = llllllllllllllllIlIlllIIlIIIlllI;
        this.field_149235_c = llllllllllllllllIlIlllIIlIIIllIl;
        this.field_149232_d = llllllllllllllllIlIlllIIlIIIIIII;
        this.field_149233_e = llllllllllllllllIlIlllIIIlllllll;
        this.field_149230_f = llllllllllllllllIlIlllIIIllllllI;
        this.field_149231_g = llllllllllllllllIlIlllIIlIIIlIIl;
        this.field_149237_h = llllllllllllllllIlIlllIIIlllllII;
        this.field_149238_i = llllllllllllllllIlIlllIIlIIIIlll;
        this.field_179753_k = llllllllllllllllIlIlllIIlIIIIllI;
    }
}
