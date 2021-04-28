package net.minecraft.network.play.server;

import net.minecraft.util.*;
import net.minecraft.world.storage.*;
import java.io.*;
import java.util.*;
import net.minecraft.network.*;
import net.minecraft.network.play.*;

public class S34PacketMaps implements Packet
{
    private /* synthetic */ int field_179736_g;
    private /* synthetic */ Vec4b[] field_179740_c;
    private /* synthetic */ int field_179738_e;
    private /* synthetic */ int mapId;
    private /* synthetic */ int field_179735_f;
    private /* synthetic */ byte[] field_179741_h;
    private /* synthetic */ byte field_179739_b;
    private /* synthetic */ int field_179737_d;
    
    public void func_179734_a(final MapData lllllllllllllllllllIIIIllIllllII) {
        lllllllllllllllllllIIIIllIllllII.scale = this.field_179739_b;
        lllllllllllllllllllIIIIllIllllII.playersVisibleOnMap.clear();
        for (int lllllllllllllllllllIIIIllIlllIll = 0; lllllllllllllllllllIIIIllIlllIll < this.field_179740_c.length; ++lllllllllllllllllllIIIIllIlllIll) {
            final Vec4b lllllllllllllllllllIIIIllIlllIlI = this.field_179740_c[lllllllllllllllllllIIIIllIlllIll];
            lllllllllllllllllllIIIIllIllllII.playersVisibleOnMap.put(String.valueOf(new StringBuilder("icon-").append(lllllllllllllllllllIIIIllIlllIll)), lllllllllllllllllllIIIIllIlllIlI);
        }
        for (int lllllllllllllllllllIIIIllIlllIll = 0; lllllllllllllllllllIIIIllIlllIll < this.field_179735_f; ++lllllllllllllllllllIIIIllIlllIll) {
            for (int lllllllllllllllllllIIIIllIlllIIl = 0; lllllllllllllllllllIIIIllIlllIIl < this.field_179736_g; ++lllllllllllllllllllIIIIllIlllIIl) {
                lllllllllllllllllllIIIIllIllllII.colors[this.field_179737_d + lllllllllllllllllllIIIIllIlllIll + (this.field_179738_e + lllllllllllllllllllIIIIllIlllIIl) * 128] = this.field_179741_h[lllllllllllllllllllIIIIllIlllIll + lllllllllllllllllllIIIIllIlllIIl * this.field_179735_f];
            }
        }
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllllllIIIIllllIIIll) throws IOException {
        this.mapId = lllllllllllllllllllIIIIllllIIIll.readVarIntFromBuffer();
        this.field_179739_b = lllllllllllllllllllIIIIllllIIIll.readByte();
        this.field_179740_c = new Vec4b[lllllllllllllllllllIIIIllllIIIll.readVarIntFromBuffer()];
        for (int lllllllllllllllllllIIIIllllIIIlI = 0; lllllllllllllllllllIIIIllllIIIlI < this.field_179740_c.length; ++lllllllllllllllllllIIIIllllIIIlI) {
            final short lllllllllllllllllllIIIIllllIIIIl = lllllllllllllllllllIIIIllllIIIll.readByte();
            this.field_179740_c[lllllllllllllllllllIIIIllllIIIlI] = new Vec4b((byte)(lllllllllllllllllllIIIIllllIIIIl >> 4 & 0xF), lllllllllllllllllllIIIIllllIIIll.readByte(), lllllllllllllllllllIIIIllllIIIll.readByte(), (byte)(lllllllllllllllllllIIIIllllIIIIl & 0xF));
        }
        this.field_179735_f = lllllllllllllllllllIIIIllllIIIll.readUnsignedByte();
        if (this.field_179735_f > 0) {
            this.field_179736_g = lllllllllllllllllllIIIIllllIIIll.readUnsignedByte();
            this.field_179737_d = lllllllllllllllllllIIIIllllIIIll.readUnsignedByte();
            this.field_179738_e = lllllllllllllllllllIIIIllllIIIll.readUnsignedByte();
            this.field_179741_h = lllllllllllllllllllIIIIllllIIIll.readByteArray();
        }
    }
    
    public int getMapId() {
        return this.mapId;
    }
    
    public S34PacketMaps() {
    }
    
    static {
        __OBFID = "CL_00001311";
    }
    
    public S34PacketMaps(final int lllllllllllllllllllIIIIlllllIIlI, final byte lllllllllllllllllllIIIIlllllIIIl, final Collection lllllllllllllllllllIIIIllllllIll, final byte[] lllllllllllllllllllIIIIllllIllll, final int lllllllllllllllllllIIIIllllllIIl, final int lllllllllllllllllllIIIIllllIllIl, final int lllllllllllllllllllIIIIlllllIlll, final int lllllllllllllllllllIIIIllllIlIll) {
        this.mapId = lllllllllllllllllllIIIIlllllIIlI;
        this.field_179739_b = lllllllllllllllllllIIIIlllllIIIl;
        this.field_179740_c = lllllllllllllllllllIIIIllllllIll.toArray(new Vec4b[lllllllllllllllllllIIIIllllllIll.size()]);
        this.field_179737_d = lllllllllllllllllllIIIIllllllIIl;
        this.field_179738_e = lllllllllllllllllllIIIIllllIllIl;
        this.field_179735_f = lllllllllllllllllllIIIIlllllIlll;
        this.field_179736_g = lllllllllllllllllllIIIIllllIlIll;
        this.field_179741_h = new byte[lllllllllllllllllllIIIIlllllIlll * lllllllllllllllllllIIIIllllIlIll];
        for (int lllllllllllllllllllIIIIlllllIlIl = 0; lllllllllllllllllllIIIIlllllIlIl < lllllllllllllllllllIIIIlllllIlll; ++lllllllllllllllllllIIIIlllllIlIl) {
            for (int lllllllllllllllllllIIIIlllllIlII = 0; lllllllllllllllllllIIIIlllllIlII < lllllllllllllllllllIIIIllllIlIll; ++lllllllllllllllllllIIIIlllllIlII) {
                this.field_179741_h[lllllllllllllllllllIIIIlllllIlIl + lllllllllllllllllllIIIIlllllIlII * lllllllllllllllllllIIIIlllllIlll] = lllllllllllllllllllIIIIllllIllll[lllllllllllllllllllIIIIllllllIIl + lllllllllllllllllllIIIIlllllIlIl + (lllllllllllllllllllIIIIllllIllIl + lllllllllllllllllllIIIIlllllIlII) * 128];
            }
        }
    }
    
    @Override
    public void processPacket(final INetHandler lllllllllllllllllllIIIIllIlIllll) {
        this.func_180741_a((INetHandlerPlayClient)lllllllllllllllllllIIIIllIlIllll);
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllllllIIIIlllIlIlIl) throws IOException {
        lllllllllllllllllllIIIIlllIlIlIl.writeVarIntToBuffer(this.mapId);
        lllllllllllllllllllIIIIlllIlIlIl.writeByte(this.field_179739_b);
        lllllllllllllllllllIIIIlllIlIlIl.writeVarIntToBuffer(this.field_179740_c.length);
        for (final Vec4b lllllllllllllllllllIIIIlllIlIIIl : this.field_179740_c) {
            lllllllllllllllllllIIIIlllIlIlIl.writeByte((lllllllllllllllllllIIIIlllIlIIIl.func_176110_a() & 0xF) << 4 | (lllllllllllllllllllIIIIlllIlIIIl.func_176111_d() & 0xF));
            lllllllllllllllllllIIIIlllIlIlIl.writeByte(lllllllllllllllllllIIIIlllIlIIIl.func_176112_b());
            lllllllllllllllllllIIIIlllIlIlIl.writeByte(lllllllllllllllllllIIIIlllIlIIIl.func_176113_c());
        }
        lllllllllllllllllllIIIIlllIlIlIl.writeByte(this.field_179735_f);
        if (this.field_179735_f > 0) {
            lllllllllllllllllllIIIIlllIlIlIl.writeByte(this.field_179736_g);
            lllllllllllllllllllIIIIlllIlIlIl.writeByte(this.field_179737_d);
            lllllllllllllllllllIIIIlllIlIlIl.writeByte(this.field_179738_e);
            lllllllllllllllllllIIIIlllIlIlIl.writeByteArray(this.field_179741_h);
        }
    }
    
    public void func_180741_a(final INetHandlerPlayClient lllllllllllllllllllIIIIlllIIIlll) {
        lllllllllllllllllllIIIIlllIIIlll.handleMaps(this);
    }
}
