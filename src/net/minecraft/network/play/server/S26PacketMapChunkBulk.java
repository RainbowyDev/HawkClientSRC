package net.minecraft.network.play.server;

import java.util.*;
import net.minecraft.world.chunk.*;
import java.io.*;
import net.minecraft.network.play.*;
import net.minecraft.network.*;

public class S26PacketMapChunkBulk implements Packet
{
    private /* synthetic */ int[] field_149264_b;
    private /* synthetic */ int[] field_149266_a;
    private /* synthetic */ S21PacketChunkData.Extracted[] field_179755_c;
    private /* synthetic */ boolean field_149267_h;
    
    static {
        __OBFID = "CL_00001306";
    }
    
    public S26PacketMapChunkBulk(final List llllllllllllllIlIllIIIllllIlllIl) {
        final int llllllllllllllIlIllIIIllllIlllII = llllllllllllllIlIllIIIllllIlllIl.size();
        this.field_149266_a = new int[llllllllllllllIlIllIIIllllIlllII];
        this.field_149264_b = new int[llllllllllllllIlIllIIIllllIlllII];
        this.field_179755_c = new S21PacketChunkData.Extracted[llllllllllllllIlIllIIIllllIlllII];
        this.field_149267_h = !llllllllllllllIlIllIIIllllIlllIl.get(0).getWorld().provider.getHasNoSky();
        for (int llllllllllllllIlIllIIIllllIllIll = 0; llllllllllllllIlIllIIIllllIllIll < llllllllllllllIlIllIIIllllIlllII; ++llllllllllllllIlIllIIIllllIllIll) {
            final Chunk llllllllllllllIlIllIIIllllIllIlI = llllllllllllllIlIllIIIllllIlllIl.get(llllllllllllllIlIllIIIllllIllIll);
            final S21PacketChunkData.Extracted llllllllllllllIlIllIIIllllIllIIl = S21PacketChunkData.func_179756_a(llllllllllllllIlIllIIIllllIllIlI, true, this.field_149267_h, 65535);
            this.field_149266_a[llllllllllllllIlIllIIIllllIllIll] = llllllllllllllIlIllIIIllllIllIlI.xPosition;
            this.field_149264_b[llllllllllllllIlIllIIIllllIllIll] = llllllllllllllIlIllIIIllllIllIlI.zPosition;
            this.field_179755_c[llllllllllllllIlIllIIIllllIllIll] = llllllllllllllIlIllIIIllllIllIIl;
        }
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlIllIIIllllIIIIlI) throws IOException {
        llllllllllllllIlIllIIIllllIIIIlI.writeBoolean(this.field_149267_h);
        llllllllllllllIlIllIIIllllIIIIlI.writeVarIntToBuffer(this.field_179755_c.length);
        for (int llllllllllllllIlIllIIIllllIIIIIl = 0; llllllllllllllIlIllIIIllllIIIIIl < this.field_149266_a.length; ++llllllllllllllIlIllIIIllllIIIIIl) {
            llllllllllllllIlIllIIIllllIIIIlI.writeInt(this.field_149266_a[llllllllllllllIlIllIIIllllIIIIIl]);
            llllllllllllllIlIllIIIllllIIIIlI.writeInt(this.field_149264_b[llllllllllllllIlIllIIIllllIIIIIl]);
            llllllllllllllIlIllIIIllllIIIIlI.writeShort((short)(this.field_179755_c[llllllllllllllIlIllIIIllllIIIIIl].field_150280_b & 0xFFFF));
        }
        for (int llllllllllllllIlIllIIIllllIIIIIl = 0; llllllllllllllIlIllIIIllllIIIIIl < this.field_149266_a.length; ++llllllllllllllIlIllIIIllllIIIIIl) {
            llllllllllllllIlIllIIIllllIIIIlI.writeBytes(this.field_179755_c[llllllllllllllIlIllIIIllllIIIIIl].field_150282_a);
        }
    }
    
    public int func_149255_a(final int llllllllllllllIlIllIIIlllIllIIlI) {
        return this.field_149266_a[llllllllllllllIlIllIIIlllIllIIlI];
    }
    
    public void func_180738_a(final INetHandlerPlayClient llllllllllllllIlIllIIIlllIlllIlI) {
        llllllllllllllIlIllIIIlllIlllIlI.handleMapChunkBulk(this);
    }
    
    public S26PacketMapChunkBulk() {
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIlIllIIIlllIIlIlll) {
        this.func_180738_a((INetHandlerPlayClient)llllllllllllllIlIllIIIlllIIlIlll);
    }
    
    public int func_179754_d(final int llllllllllllllIlIllIIIlllIIlllIl) {
        return this.field_179755_c[llllllllllllllIlIllIIIlllIIlllIl].field_150280_b;
    }
    
    public int func_149254_d() {
        return this.field_149266_a.length;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlIllIIIllllIIllIl) throws IOException {
        this.field_149267_h = llllllllllllllIlIllIIIllllIIllIl.readBoolean();
        final int llllllllllllllIlIllIIIllllIIllII = llllllllllllllIlIllIIIllllIIllIl.readVarIntFromBuffer();
        this.field_149266_a = new int[llllllllllllllIlIllIIIllllIIllII];
        this.field_149264_b = new int[llllllllllllllIlIllIIIllllIIllII];
        this.field_179755_c = new S21PacketChunkData.Extracted[llllllllllllllIlIllIIIllllIIllII];
        for (int llllllllllllllIlIllIIIllllIIlIll = 0; llllllllllllllIlIllIIIllllIIlIll < llllllllllllllIlIllIIIllllIIllII; ++llllllllllllllIlIllIIIllllIIlIll) {
            this.field_149266_a[llllllllllllllIlIllIIIllllIIlIll] = llllllllllllllIlIllIIIllllIIllIl.readInt();
            this.field_149264_b[llllllllllllllIlIllIIIllllIIlIll] = llllllllllllllIlIllIIIllllIIllIl.readInt();
            this.field_179755_c[llllllllllllllIlIllIIIllllIIlIll] = new S21PacketChunkData.Extracted();
            this.field_179755_c[llllllllllllllIlIllIIIllllIIlIll].field_150280_b = (llllllllllllllIlIllIIIllllIIllIl.readShort() & 0xFFFF);
            this.field_179755_c[llllllllllllllIlIllIIIllllIIlIll].field_150282_a = new byte[S21PacketChunkData.func_180737_a(Integer.bitCount(this.field_179755_c[llllllllllllllIlIllIIIllllIIlIll].field_150280_b), this.field_149267_h, true)];
        }
        for (int llllllllllllllIlIllIIIllllIIlIll = 0; llllllllllllllIlIllIIIllllIIlIll < llllllllllllllIlIllIIIllllIIllII; ++llllllllllllllIlIllIIIllllIIlIll) {
            llllllllllllllIlIllIIIllllIIllIl.readBytes(this.field_179755_c[llllllllllllllIlIllIIIllllIIlIll].field_150282_a);
        }
    }
    
    public byte[] func_149256_c(final int llllllllllllllIlIllIIIlllIlIIIll) {
        return this.field_179755_c[llllllllllllllIlIllIIIlllIlIIIll].field_150282_a;
    }
    
    public int func_149253_b(final int llllllllllllllIlIllIIIlllIlIllII) {
        return this.field_149264_b[llllllllllllllIlIllIIIlllIlIllII];
    }
}
