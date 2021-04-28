package net.minecraft.network.play.server;

import net.minecraft.world.chunk.*;
import net.minecraft.network.play.*;
import com.google.common.collect.*;
import net.minecraft.world.chunk.storage.*;
import java.util.*;
import net.minecraft.network.*;
import java.io.*;

public class S21PacketChunkData implements Packet
{
    private /* synthetic */ boolean field_149279_g;
    private /* synthetic */ int field_149284_a;
    private /* synthetic */ Extracted field_179758_c;
    private /* synthetic */ int field_149282_b;
    
    private static int func_179757_a(final byte[] llllllllllllllllllIIIIIllIIlIlII, final byte[] llllllllllllllllllIIIIIllIIlIllI, final int llllllllllllllllllIIIIIllIIlIIlI) {
        System.arraycopy(llllllllllllllllllIIIIIllIIlIlII, 0, llllllllllllllllllIIIIIllIIlIllI, llllllllllllllllllIIIIIllIIlIIlI, llllllllllllllllllIIIIIllIIlIlII.length);
        return llllllllllllllllllIIIIIllIIlIIlI + llllllllllllllllllIIIIIllIIlIlII.length;
    }
    
    public boolean func_149274_i() {
        return this.field_149279_g;
    }
    
    public S21PacketChunkData() {
    }
    
    public S21PacketChunkData(final Chunk llllllllllllllllllIIIIIllllllIll, final boolean llllllllllllllllllIIIIIlllllIllI, final int llllllllllllllllllIIIIIllllllIIl) {
        this.field_149284_a = llllllllllllllllllIIIIIllllllIll.xPosition;
        this.field_149282_b = llllllllllllllllllIIIIIllllllIll.zPosition;
        this.field_149279_g = llllllllllllllllllIIIIIlllllIllI;
        this.field_179758_c = func_179756_a(llllllllllllllllllIIIIIllllllIll, llllllllllllllllllIIIIIlllllIllI, !llllllllllllllllllIIIIIllllllIll.getWorld().provider.getHasNoSky(), llllllllllllllllllIIIIIllllllIIl);
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllllllIIIIIllIIIIIlI) {
        this.processPacket((INetHandlerPlayClient)llllllllllllllllllIIIIIllIIIIIlI);
    }
    
    public static Extracted func_179756_a(final Chunk llllllllllllllllllIIIIIllIlllIll, final boolean llllllllllllllllllIIIIIllIlllIlI, final boolean llllllllllllllllllIIIIIllIlIIlll, final int llllllllllllllllllIIIIIllIlIIllI) {
        final ExtendedBlockStorage[] llllllllllllllllllIIIIIllIllIlll = llllllllllllllllllIIIIIllIlllIll.getBlockStorageArray();
        final Extracted llllllllllllllllllIIIIIllIllIllI = new Extracted();
        final ArrayList llllllllllllllllllIIIIIllIllIlIl = Lists.newArrayList();
        for (int llllllllllllllllllIIIIIllIllIlII = 0; llllllllllllllllllIIIIIllIllIlII < llllllllllllllllllIIIIIllIllIlll.length; ++llllllllllllllllllIIIIIllIllIlII) {
            final ExtendedBlockStorage llllllllllllllllllIIIIIllIllIIll = llllllllllllllllllIIIIIllIllIlll[llllllllllllllllllIIIIIllIllIlII];
            if (llllllllllllllllllIIIIIllIllIIll != null && (!llllllllllllllllllIIIIIllIlllIlI || !llllllllllllllllllIIIIIllIllIIll.isEmpty()) && (llllllllllllllllllIIIIIllIlIIllI & 1 << llllllllllllllllllIIIIIllIllIlII) != 0x0) {
                final Extracted extracted = llllllllllllllllllIIIIIllIllIllI;
                extracted.field_150280_b |= 1 << llllllllllllllllllIIIIIllIllIlII;
                llllllllllllllllllIIIIIllIllIlIl.add(llllllllllllllllllIIIIIllIllIIll);
            }
        }
        llllllllllllllllllIIIIIllIllIllI.field_150282_a = new byte[func_180737_a(Integer.bitCount(llllllllllllllllllIIIIIllIllIllI.field_150280_b), llllllllllllllllllIIIIIllIlIIlll, llllllllllllllllllIIIIIllIlllIlI)];
        int llllllllllllllllllIIIIIllIllIlII = 0;
        for (final ExtendedBlockStorage llllllllllllllllllIIIIIllIllIIIl : llllllllllllllllllIIIIIllIllIlIl) {
            final char[] llllllllllllllllllIIIIIllIlIllIl;
            final char[] llllllllllllllllllIIIIIllIlIlllI = llllllllllllllllllIIIIIllIlIllIl = llllllllllllllllllIIIIIllIllIIIl.getData();
            for (int llllllllllllllllllIIIIIllIlIllII = llllllllllllllllllIIIIIllIlIlllI.length, llllllllllllllllllIIIIIllIlIlIll = 0; llllllllllllllllllIIIIIllIlIlIll < llllllllllllllllllIIIIIllIlIllII; ++llllllllllllllllllIIIIIllIlIlIll) {
                final char llllllllllllllllllIIIIIllIlIlIlI = llllllllllllllllllIIIIIllIlIllIl[llllllllllllllllllIIIIIllIlIlIll];
                llllllllllllllllllIIIIIllIllIllI.field_150282_a[llllllllllllllllllIIIIIllIllIlII++] = (byte)(llllllllllllllllllIIIIIllIlIlIlI & '\u00ff');
                llllllllllllllllllIIIIIllIllIllI.field_150282_a[llllllllllllllllllIIIIIllIllIlII++] = (byte)(llllllllllllllllllIIIIIllIlIlIlI >> 8 & 0xFF);
            }
        }
        for (final ExtendedBlockStorage llllllllllllllllllIIIIIllIllIIII : llllllllllllllllllIIIIIllIllIlIl) {
            llllllllllllllllllIIIIIllIllIlII = func_179757_a(llllllllllllllllllIIIIIllIllIIII.getBlocklightArray().getData(), llllllllllllllllllIIIIIllIllIllI.field_150282_a, llllllllllllllllllIIIIIllIllIlII);
        }
        if (llllllllllllllllllIIIIIllIlIIlll) {
            for (final ExtendedBlockStorage llllllllllllllllllIIIIIllIlIllll : llllllllllllllllllIIIIIllIllIlIl) {
                llllllllllllllllllIIIIIllIllIlII = func_179757_a(llllllllllllllllllIIIIIllIlIllll.getSkylightArray().getData(), llllllllllllllllllIIIIIllIllIllI.field_150282_a, llllllllllllllllllIIIIIllIllIlII);
            }
        }
        if (llllllllllllllllllIIIIIllIlllIlI) {
            func_179757_a(llllllllllllllllllIIIIIllIlllIll.getBiomeArray(), llllllllllllllllllIIIIIllIllIllI.field_150282_a, llllllllllllllllllIIIIIllIllIlII);
        }
        return llllllllllllllllllIIIIIllIllIllI;
    }
    
    public int func_149271_f() {
        return this.field_149282_b;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllllllIIIIIllllIlIIl) throws IOException {
        llllllllllllllllllIIIIIllllIlIIl.writeInt(this.field_149284_a);
        llllllllllllllllllIIIIIllllIlIIl.writeInt(this.field_149282_b);
        llllllllllllllllllIIIIIllllIlIIl.writeBoolean(this.field_149279_g);
        llllllllllllllllllIIIIIllllIlIIl.writeShort((short)(this.field_179758_c.field_150280_b & 0xFFFF));
        llllllllllllllllllIIIIIllllIlIIl.writeByteArray(this.field_179758_c.field_150282_a);
    }
    
    public byte[] func_149272_d() {
        return this.field_179758_c.field_150282_a;
    }
    
    public int func_149276_g() {
        return this.field_179758_c.field_150280_b;
    }
    
    public int func_149273_e() {
        return this.field_149284_a;
    }
    
    public void processPacket(final INetHandlerPlayClient llllllllllllllllllIIIIIllllIIlIl) {
        llllllllllllllllllIIIIIllllIIlIl.handleChunkData(this);
    }
    
    static {
        __OBFID = "CL_00001304";
    }
    
    protected static int func_180737_a(final int llllllllllllllllllIIIIIlllIlIIIl, final boolean llllllllllllllllllIIIIIlllIlIlll, final boolean llllllllllllllllllIIIIIlllIlIllI) {
        final int llllllllllllllllllIIIIIlllIlIlIl = llllllllllllllllllIIIIIlllIlIIIl * 2 * 16 * 16 * 16;
        final int llllllllllllllllllIIIIIlllIlIlII = llllllllllllllllllIIIIIlllIlIIIl * 16 * 16 * 16 / 2;
        final int llllllllllllllllllIIIIIlllIlIIll = llllllllllllllllllIIIIIlllIlIlll ? (llllllllllllllllllIIIIIlllIlIIIl * 16 * 16 * 16 / 2) : 0;
        final int llllllllllllllllllIIIIIlllIlIIlI = llllllllllllllllllIIIIIlllIlIllI ? 256 : 0;
        return llllllllllllllllllIIIIIlllIlIlIl + llllllllllllllllllIIIIIlllIlIlII + llllllllllllllllllIIIIIlllIlIIll + llllllllllllllllllIIIIIlllIlIIlI;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllllllIIIIIllllIllll) throws IOException {
        this.field_149284_a = llllllllllllllllllIIIIIllllIllll.readInt();
        this.field_149282_b = llllllllllllllllllIIIIIllllIllll.readInt();
        this.field_149279_g = llllllllllllllllllIIIIIllllIllll.readBoolean();
        this.field_179758_c = new Extracted();
        this.field_179758_c.field_150280_b = llllllllllllllllllIIIIIllllIllll.readShort();
        this.field_179758_c.field_150282_a = llllllllllllllllllIIIIIllllIllll.readByteArray();
    }
    
    public static class Extracted
    {
        public /* synthetic */ byte[] field_150282_a;
        public /* synthetic */ int field_150280_b;
        
        static {
            __OBFID = "CL_00001305";
        }
    }
}
