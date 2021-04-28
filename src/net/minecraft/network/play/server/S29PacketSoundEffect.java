package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;
import org.apache.commons.lang3.*;
import net.minecraft.util.*;

public class S29PacketSoundEffect implements Packet
{
    private /* synthetic */ int field_149217_b;
    private /* synthetic */ int field_149215_d;
    private /* synthetic */ String field_149219_a;
    private /* synthetic */ int field_149218_c;
    private /* synthetic */ float field_149216_e;
    private /* synthetic */ int field_149214_f;
    
    public float func_149209_h() {
        return this.field_149214_f / 63.0f;
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllIlIlIlIIIIIIIlIIl) {
        this.processPacket((INetHandlerPlayClient)lllllllllllllllIlIlIlIIIIIIIlIIl);
    }
    
    public String func_149212_c() {
        return this.field_149219_a;
    }
    
    public double func_149210_f() {
        return this.field_149215_d / 8.0f;
    }
    
    static {
        __OBFID = "CL_00001309";
    }
    
    public float func_149208_g() {
        return this.field_149216_e;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIlIlIlIIIIIlIIlll) throws IOException {
        lllllllllllllllIlIlIlIIIIIlIIlll.writeString(this.field_149219_a);
        lllllllllllllllIlIlIlIIIIIlIIlll.writeInt(this.field_149217_b);
        lllllllllllllllIlIlIlIIIIIlIIlll.writeInt(this.field_149218_c);
        lllllllllllllllIlIlIlIIIIIlIIlll.writeInt(this.field_149215_d);
        lllllllllllllllIlIlIlIIIIIlIIlll.writeFloat(this.field_149216_e);
        lllllllllllllllIlIlIlIIIIIlIIlll.writeByte(this.field_149214_f);
    }
    
    public void processPacket(final INetHandlerPlayClient lllllllllllllllIlIlIlIIIIIIIllll) {
        lllllllllllllllIlIlIlIIIIIIIllll.handleSoundEffect(this);
    }
    
    public S29PacketSoundEffect() {
        this.field_149218_c = Integer.MAX_VALUE;
    }
    
    public S29PacketSoundEffect(final String lllllllllllllllIlIlIlIIIIIlllIII, final double lllllllllllllllIlIlIlIIIIIlllllI, final double lllllllllllllllIlIlIlIIIIIllIllI, final double lllllllllllllllIlIlIlIIIIIllllII, final float lllllllllllllllIlIlIlIIIIIlllIll, float lllllllllllllllIlIlIlIIIIIlllIlI) {
        this.field_149218_c = Integer.MAX_VALUE;
        Validate.notNull((Object)lllllllllllllllIlIlIlIIIIIlllIII, "name", new Object[0]);
        this.field_149219_a = lllllllllllllllIlIlIlIIIIIlllIII;
        this.field_149217_b = (int)(lllllllllllllllIlIlIlIIIIIlllllI * 8.0);
        this.field_149218_c = (int)(lllllllllllllllIlIlIlIIIIIllIllI * 8.0);
        this.field_149215_d = (int)(lllllllllllllllIlIlIlIIIIIllllII * 8.0);
        this.field_149216_e = lllllllllllllllIlIlIlIIIIIlllIll;
        this.field_149214_f = (int)(lllllllllllllllIlIlIlIIIIIlllIlI * 63.0f);
        lllllllllllllllIlIlIlIIIIIlllIlI = MathHelper.clamp_float(lllllllllllllllIlIlIlIIIIIlllIlI, 0.0f, 255.0f);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIlIlIlIIIIIlIllll) throws IOException {
        this.field_149219_a = lllllllllllllllIlIlIlIIIIIlIllll.readStringFromBuffer(256);
        this.field_149217_b = lllllllllllllllIlIlIlIIIIIlIllll.readInt();
        this.field_149218_c = lllllllllllllllIlIlIlIIIIIlIllll.readInt();
        this.field_149215_d = lllllllllllllllIlIlIlIIIIIlIllll.readInt();
        this.field_149216_e = lllllllllllllllIlIlIlIIIIIlIllll.readFloat();
        this.field_149214_f = lllllllllllllllIlIlIlIIIIIlIllll.readUnsignedByte();
    }
    
    public double func_149207_d() {
        return this.field_149217_b / 8.0f;
    }
    
    public double func_149211_e() {
        return this.field_149218_c / 8.0f;
    }
}
