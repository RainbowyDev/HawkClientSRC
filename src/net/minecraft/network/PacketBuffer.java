package net.minecraft.network;

import java.nio.charset.*;
import com.google.common.base.*;
import net.minecraft.nbt.*;
import net.minecraft.item.*;
import java.nio.channels.*;
import java.util.*;
import io.netty.handler.codec.*;
import java.nio.*;
import io.netty.util.*;
import io.netty.buffer.*;
import java.io.*;
import net.minecraft.util.*;

public class PacketBuffer extends ByteBuf
{
    private final /* synthetic */ ByteBuf buf;
    
    public ByteBuf markWriterIndex() {
        return this.buf.markWriterIndex();
    }
    
    public char readChar() {
        return this.buf.readChar();
    }
    
    public void writeByteArray(final byte[] llllllllllllllIIIllIIllIlllIIIIl) {
        this.writeVarIntToBuffer(llllllllllllllIIIllIIllIlllIIIIl.length);
        this.writeBytes(llllllllllllllIIIllIIllIlllIIIIl);
    }
    
    public int writerIndex() {
        return this.buf.writerIndex();
    }
    
    public ByteBuf getBytes(final int llllllllllllllIIIllIIlIIlIllllIl, final ByteBuf llllllllllllllIIIllIIlIIlIllllII, final int llllllllllllllIIIllIIlIIlIlllIll) {
        return this.buf.getBytes(llllllllllllllIIIllIIlIIlIllllIl, llllllllllllllIIIllIIlIIlIllllII, llllllllllllllIIIllIIlIIlIlllIll);
    }
    
    public String toString(final int llllllllllllllIIIllIIIlIIIIllIII, final int llllllllllllllIIIllIIIlIIIIlIIll, final Charset llllllllllllllIIIllIIIlIIIIlIllI) {
        return this.buf.toString(llllllllllllllIIIllIIIlIIIIllIII, llllllllllllllIIIllIIIlIIIIlIIll, llllllllllllllIIIllIIIlIIIIlIllI);
    }
    
    public ByteBuf setFloat(final int llllllllllllllIIIllIIlIIIIlIllII, final float llllllllllllllIIIllIIlIIIIlIlIll) {
        return this.buf.setFloat(llllllllllllllIIIllIIlIIIIlIllII, llllllllllllllIIIllIIlIIIIlIlIll);
    }
    
    public ByteBuf writeBytes(final ByteBuf llllllllllllllIIIllIIIlIlllIllll, final int llllllllllllllIIIllIIIlIllllIIlI, final int llllllllllllllIIIllIIIlIlllIllIl) {
        return this.buf.writeBytes(llllllllllllllIIIllIIIlIlllIllll, llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIlllIllIl);
    }
    
    public int forEachByteDesc(final ByteBufProcessor llllllllllllllIIIllIIIlIlIIIIIII) {
        return this.buf.forEachByteDesc(llllllllllllllIIIllIIIlIlIIIIIII);
    }
    
    public ByteBuf setChar(final int llllllllllllllIIIllIIlIIIIllIlIl, final int llllllllllllllIIIllIIlIIIIllIlII) {
        return this.buf.setChar(llllllllllllllIIIllIIlIIIIllIlIl, llllllllllllllIIIllIIlIIIIllIlII);
    }
    
    public boolean isDirect() {
        return this.buf.isDirect();
    }
    
    public ByteBuf clear() {
        return this.buf.clear();
    }
    
    public int getUnsignedShort(final int llllllllllllllIIIllIIlIlIIIIIIlI) {
        return this.buf.getUnsignedShort(llllllllllllllIIIllIIlIlIIIIIIlI);
    }
    
    public int arrayOffset() {
        return this.buf.arrayOffset();
    }
    
    public ByteBuf capacity(final int llllllllllllllIIIllIIlIllllIlIII) {
        return this.buf.capacity(llllllllllllllIIIllIIlIllllIlIII);
    }
    
    public ByteBuf unwrap() {
        return this.buf.unwrap();
    }
    
    public float readFloat() {
        return this.buf.readFloat();
    }
    
    public ByteBuf setDouble(final int llllllllllllllIIIllIIlIIIIlIIllI, final double llllllllllllllIIIllIIlIIIIlIIIlI) {
        return this.buf.setDouble(llllllllllllllIIIllIIlIIIIlIIllI, llllllllllllllIIIllIIlIIIIlIIIlI);
    }
    
    public ByteBuf getBytes(final int llllllllllllllIIIllIIlIIlIlIIlII, final byte[] llllllllllllllIIIllIIlIIlIlIIIll) {
        return this.buf.getBytes(llllllllllllllIIIllIIlIIlIlIIlII, llllllllllllllIIIllIIlIIlIlIIIll);
    }
    
    public int forEachByte(final int llllllllllllllIIIllIIIlIlIIIlIlI, final int llllllllllllllIIIllIIIlIlIIIIlIl, final ByteBufProcessor llllllllllllllIIIllIIIlIlIIIIlII) {
        return this.buf.forEachByte(llllllllllllllIIIllIIIlIlIIIlIlI, llllllllllllllIIIllIIIlIlIIIIlIl, llllllllllllllIIIllIIIlIlIIIIlII);
    }
    
    public ByteBuf setBytes(final int llllllllllllllIIIllIIlIIIIIIIIIl, final ByteBuf llllllllllllllIIIllIIlIIIIIIIIII, final int llllllllllllllIIIllIIIllllllllll, final int llllllllllllllIIIllIIIlllllllllI) {
        return this.buf.setBytes(llllllllllllllIIIllIIlIIIIIIIIIl, llllllllllllllIIIllIIlIIIIIIIIII, llllllllllllllIIIllIIIllllllllll, llllllllllllllIIIllIIIlllllllllI);
    }
    
    public ByteBuf readBytes(final byte[] llllllllllllllIIIllIIIllIllIlIII) {
        return this.buf.readBytes(llllllllllllllIIIllIIIllIllIlIII);
    }
    
    public void writeVarIntToBuffer(int llllllllllllllIIIllIIllIlIIlIlIl) {
        while ((llllllllllllllIIIllIIllIlIIlIlIl & 0xFFFFFF80) != 0x0) {
            this.writeByte((llllllllllllllIIIllIIllIlIIlIlIl & 0x7F) | 0x80);
            llllllllllllllIIIllIIllIlIIlIlIl >>>= 7;
        }
        this.writeByte(llllllllllllllIIIllIIllIlIIlIlIl);
    }
    
    public PacketBuffer writeString(final String llllllllllllllIIIllIIlIllllllIlI) {
        final byte[] llllllllllllllIIIllIIlIllllllIIl = llllllllllllllIIIllIIlIllllllIlI.getBytes(Charsets.UTF_8);
        if (llllllllllllllIIIllIIlIllllllIIl.length > 32767) {
            throw new EncoderException(String.valueOf(new StringBuilder("String too big (was ").append(llllllllllllllIIIllIIlIllllllIlI.length()).append(" bytes encoded, max ").append(32767).append(")")));
        }
        this.writeVarIntToBuffer(llllllllllllllIIIllIIlIllllllIIl.length);
        this.writeBytes(llllllllllllllIIIllIIlIllllllIIl);
        return this;
    }
    
    public NBTTagCompound readNBTTagCompoundFromBuffer() throws IOException {
        final int llllllllllllllIIIllIIllIIllIIllI = this.readerIndex();
        final byte llllllllllllllIIIllIIllIIllIIlII = this.readByte();
        if (llllllllllllllIIIllIIllIIllIIlII == 0) {
            return null;
        }
        this.readerIndex(llllllllllllllIIIllIIllIIllIIllI);
        return CompressedStreamTools.func_152456_a((DataInput)new ByteBufInputStream((ByteBuf)this), new NBTSizeTracker(2097152L));
    }
    
    public ByteBuf writeShort(final int llllllllllllllIIIllIIIllIIlIlllI) {
        return this.buf.writeShort(llllllllllllllIIIllIIIllIIlIlllI);
    }
    
    public void writeVarLong(long llllllllllllllIIIllIIllIlIIIlIII) {
        while ((llllllllllllllIIIllIIllIlIIIlIII & 0xFFFFFFFFFFFFFF80L) != 0x0L) {
            this.writeByte((int)(llllllllllllllIIIllIIllIlIIIlIII & 0x7FL) | 0x80);
            llllllllllllllIIIllIIllIlIIIlIII >>>= 7;
        }
        this.writeByte((int)llllllllllllllIIIllIIllIlIIIlIII);
    }
    
    public ByteBuf copy() {
        return this.buf.copy();
    }
    
    public int bytesBefore(final byte llllllllllllllIIIllIIIlIlIlIlIll) {
        return this.buf.bytesBefore(llllllllllllllIIIllIIIlIlIlIlIll);
    }
    
    public ByteBufAllocator alloc() {
        return this.buf.alloc();
    }
    
    public ByteBuf setMedium(final int llllllllllllllIIIllIIlIIIlIlIIII, final int llllllllllllllIIIllIIlIIIlIlIIlI) {
        return this.buf.setMedium(llllllllllllllIIIllIIlIIIlIlIIII, llllllllllllllIIIllIIlIIIlIlIIlI);
    }
    
    public ByteBuf writeBytes(final ByteBuf llllllllllllllIIIllIIIllIIIIIlII) {
        return this.buf.writeBytes(llllllllllllllIIIllIIIllIIIIIlII);
    }
    
    public void writeItemStackToBuffer(final ItemStack llllllllllllllIIIllIIllIIlIIIlll) {
        if (llllllllllllllIIIllIIllIIlIIIlll == null) {
            this.writeShort(-1);
        }
        else {
            this.writeShort(Item.getIdFromItem(llllllllllllllIIIllIIllIIlIIIlll.getItem()));
            this.writeByte(llllllllllllllIIIllIIllIIlIIIlll.stackSize);
            this.writeShort(llllllllllllllIIIllIIllIIlIIIlll.getMetadata());
            NBTTagCompound llllllllllllllIIIllIIllIIlIIlIll = null;
            if (llllllllllllllIIIllIIllIIlIIIlll.getItem().isDamageable() || llllllllllllllIIIllIIllIIlIIIlll.getItem().getShareTag()) {
                llllllllllllllIIIllIIllIIlIIlIll = llllllllllllllIIIllIIllIIlIIIlll.getTagCompound();
            }
            this.writeNBTTagCompoundToBuffer(llllllllllllllIIIllIIllIIlIIlIll);
        }
    }
    
    public ByteBuf writeDouble(final double llllllllllllllIIIllIIIllIIIIlIlI) {
        return this.buf.writeDouble(llllllllllllllIIIllIIIllIIIIlIlI);
    }
    
    public int getInt(final int llllllllllllllIIIllIIlIIllllIIII) {
        return this.buf.getInt(llllllllllllllIIIllIIlIIllllIIII);
    }
    
    public ByteBuf writeInt(final int llllllllllllllIIIllIIIllIIlIIIII) {
        return this.buf.writeInt(llllllllllllllIIIllIIIllIIlIIIII);
    }
    
    public double getDouble(final int llllllllllllllIIIllIIlIIllIlIIII) {
        return this.buf.getDouble(llllllllllllllIIIllIIlIIllIlIIII);
    }
    
    public ByteBuf skipBytes(final int llllllllllllllIIIllIIIllIlIIIIII) {
        return this.buf.skipBytes(llllllllllllllIIIllIIIllIlIIIIII);
    }
    
    public ByteBuf readBytes(final int llllllllllllllIIIllIIIlllIIlIIIl) {
        return this.buf.readBytes(llllllllllllllIIIllIIIlllIIlIIIl);
    }
    
    public ByteBuffer[] nioBuffers() {
        return this.buf.nioBuffers();
    }
    
    public int ensureWritable(final int llllllllllllllIIIllIIlIlIIllIIIl, final boolean llllllllllllllIIIllIIlIlIIlIlIIl) {
        return this.buf.ensureWritable(llllllllllllllIIIllIIlIlIIllIIIl, llllllllllllllIIIllIIlIlIIlIlIIl);
    }
    
    public int writeBytes(final ScatteringByteChannel llllllllllllllIIIllIIIlIllIIIlll, final int llllllllllllllIIIllIIIlIllIIIllI) throws IOException {
        return this.buf.writeBytes(llllllllllllllIIIllIIIlIllIIIlll, llllllllllllllIIIllIIIlIllIIIllI);
    }
    
    public ByteBuf setBytes(final int llllllllllllllIIIllIIlIIIIIlIIll, final ByteBuf llllllllllllllIIIllIIlIIIIIIlllI, final int llllllllllllllIIIllIIlIIIIIIllIl) {
        return this.buf.setBytes(llllllllllllllIIIllIIlIIIIIlIIll, llllllllllllllIIIllIIlIIIIIIlllI, llllllllllllllIIIllIIlIIIIIIllIl);
    }
    
    public ByteBuf getBytes(final int llllllllllllllIIIllIIlIIlIIIIIIl, final OutputStream llllllllllllllIIIllIIlIIlIIIIlII, final int llllllllllllllIIIllIIlIIIlllllll) throws IOException {
        return this.buf.getBytes(llllllllllllllIIIllIIlIIlIIIIIIl, llllllllllllllIIIllIIlIIlIIIIlII, llllllllllllllIIIllIIlIIIlllllll);
    }
    
    public int readUnsignedMedium() {
        return this.buf.readUnsignedMedium();
    }
    
    public ByteBuf writerIndex(final int llllllllllllllIIIllIIlIllIlIIIll) {
        return this.buf.writerIndex(llllllllllllllIIIllIIlIllIlIIIll);
    }
    
    public ByteBuf duplicate() {
        return this.buf.duplicate();
    }
    
    public ByteBuf setShort(final int llllllllllllllIIIllIIlIIIlIlllII, final int llllllllllllllIIIllIIlIIIlIllIII) {
        return this.buf.setShort(llllllllllllllIIIllIIlIIIlIlllII, llllllllllllllIIIllIIlIIIlIllIII);
    }
    
    public boolean hasArray() {
        return this.buf.hasArray();
    }
    
    public ByteBuf markReaderIndex() {
        return this.buf.markReaderIndex();
    }
    
    public ByteBuf readSlice(final int llllllllllllllIIIllIIIlllIIIlIll) {
        return this.buf.readSlice(llllllllllllllIIIllIIIlllIIIlIll);
    }
    
    public byte readByte() {
        return this.buf.readByte();
    }
    
    public char getChar(final int llllllllllllllIIIllIIlIIllIllllI) {
        return this.buf.getChar(llllllllllllllIIIllIIlIIllIllllI);
    }
    
    public ByteBuf writeBoolean(final boolean llllllllllllllIIIllIIIllIIlllIII) {
        return this.buf.writeBoolean(llllllllllllllIIIllIIIllIIlllIII);
    }
    
    public int readBytes(final GatheringByteChannel llllllllllllllIIIllIIIllIlIIIlIl, final int llllllllllllllIIIllIIIllIlIIIlll) throws IOException {
        return this.buf.readBytes(llllllllllllllIIIllIIIllIlIIIlIl, llllllllllllllIIIllIIIllIlIIIlll);
    }
    
    public ByteBuf slice(final int llllllllllllllIIIllIIIlIIlIllIll, final int llllllllllllllIIIllIIIlIIlIllIlI) {
        return this.buf.slice(llllllllllllllIIIllIIIlIIlIllIll, llllllllllllllIIIllIIIlIIlIllIlI);
    }
    
    public int maxCapacity() {
        return this.buf.maxCapacity();
    }
    
    public int readVarIntFromBuffer() {
        int llllllllllllllIIIllIIllIlIllIlll = 0;
        int llllllllllllllIIIllIIllIlIllIllI = 0;
        byte llllllllllllllIIIllIIllIlIllIlIl;
        do {
            llllllllllllllIIIllIIllIlIllIlIl = this.readByte();
            llllllllllllllIIIllIIllIlIllIlll |= (llllllllllllllIIIllIIllIlIllIlIl & 0x7F) << llllllllllllllIIIllIIllIlIllIllI++ * 7;
            if (llllllllllllllIIIllIIllIlIllIllI > 5) {
                throw new RuntimeException("VarInt too big");
            }
        } while ((llllllllllllllIIIllIIllIlIllIlIl & 0x80) == 0x80);
        return llllllllllllllIIIllIIllIlIllIlll;
    }
    
    public ByteBuf writeZero(final int llllllllllllllIIIllIIIlIlIllllIl) {
        return this.buf.writeZero(llllllllllllllIIIllIIIlIlIllllIl);
    }
    
    public ByteBuf writeBytes(final ByteBuffer llllllllllllllIIIllIIIlIllIlIlll) {
        return this.buf.writeBytes(llllllllllllllIIIllIIIlIllIlIlll);
    }
    
    public Enum readEnumValue(final Class llllllllllllllIIIllIIllIllIIIIll) {
        return ((Enum[])llllllllllllllIIIllIIllIllIIIIll.getEnumConstants())[this.readVarIntFromBuffer()];
    }
    
    public ByteBuf discardReadBytes() {
        return this.buf.discardReadBytes();
    }
    
    public boolean isReadable(final int llllllllllllllIIIllIIlIlIllllIII) {
        return this.buf.isReadable(llllllllllllllIIIllIIlIlIllllIII);
    }
    
    public long readUnsignedInt() {
        return this.buf.readUnsignedInt();
    }
    
    public long memoryAddress() {
        return this.buf.memoryAddress();
    }
    
    public void writeEnumValue(final Enum llllllllllllllIIIllIIllIlIllllll) {
        this.writeVarIntToBuffer(llllllllllllllIIIllIIllIlIllllll.ordinal());
    }
    
    public void writeUuid(final UUID llllllllllllllIIIllIIllIlIlIIIIl) {
        this.writeLong(llllllllllllllIIIllIIllIlIlIIIIl.getMostSignificantBits());
        this.writeLong(llllllllllllllIIIllIIllIlIlIIIIl.getLeastSignificantBits());
    }
    
    public ByteBuf readBytes(final OutputStream llllllllllllllIIIllIIIllIlIIlllI, final int llllllllllllllIIIllIIIllIlIIllIl) throws IOException {
        return this.buf.readBytes(llllllllllllllIIIllIIIllIlIIlllI, llllllllllllllIIIllIIIllIlIIllIl);
    }
    
    public ByteBuf setBytes(final int llllllllllllllIIIllIIlIIIIIllIlI, final ByteBuf llllllllllllllIIIllIIlIIIIIlllII) {
        return this.buf.setBytes(llllllllllllllIIIllIIlIIIIIllIlI, llllllllllllllIIIllIIlIIIIIlllII);
    }
    
    public int getMedium(final int llllllllllllllIIIllIIlIIlllllIlI) {
        return this.buf.getMedium(llllllllllllllIIIllIIlIIlllllIlI);
    }
    
    public boolean release(final int llllllllllllllIIIllIIIIllllIlIll) {
        return this.buf.release(llllllllllllllIIIllIIIIllllIlIll);
    }
    
    public int nioBufferCount() {
        return this.buf.nioBufferCount();
    }
    
    static {
        __OBFID = "CL_00001251";
    }
    
    public ByteBuf writeChar(final int llllllllllllllIIIllIIIllIIIlIlII) {
        return this.buf.writeChar(llllllllllllllIIIllIIIllIIIlIlII);
    }
    
    public ByteBuf readBytes(final byte[] llllllllllllllIIIllIIIllIllIIIlI, final int llllllllllllllIIIllIIIllIlIlllIl, final int llllllllllllllIIIllIIIllIllIIIII) {
        return this.buf.readBytes(llllllllllllllIIIllIIIllIllIIIlI, llllllllllllllIIIllIIIllIlIlllIl, llllllllllllllIIIllIIIllIllIIIII);
    }
    
    public static int getVarIntSize(final int llllllllllllllIIIllIIllIlllIlIlI) {
        for (int llllllllllllllIIIllIIllIlllIlIIl = 1; llllllllllllllIIIllIIllIlllIlIIl < 5; ++llllllllllllllIIIllIIllIlllIlIIl) {
            if ((llllllllllllllIIIllIIllIlllIlIlI & -1 << llllllllllllllIIIllIIllIlllIlIIl * 7) == 0x0) {
                return llllllllllllllIIIllIIllIlllIlIIl;
            }
        }
        return 5;
    }
    
    public String readStringFromBuffer(final int llllllllllllllIIIllIIllIIIIIllII) {
        final int llllllllllllllIIIllIIllIIIIlIIIl = this.readVarIntFromBuffer();
        if (llllllllllllllIIIllIIllIIIIlIIIl > llllllllllllllIIIllIIllIIIIIllII * 4) {
            throw new DecoderException(String.valueOf(new StringBuilder("The received encoded string buffer length is longer than maximum allowed (").append(llllllllllllllIIIllIIllIIIIlIIIl).append(" > ").append(llllllllllllllIIIllIIllIIIIIllII * 4).append(")")));
        }
        if (llllllllllllllIIIllIIllIIIIlIIIl < 0) {
            throw new DecoderException("The received encoded string buffer length is less than zero! Weird string!");
        }
        final String llllllllllllllIIIllIIllIIIIlIIII = new String(this.readBytes(llllllllllllllIIIllIIllIIIIlIIIl).array(), Charsets.UTF_8);
        if (llllllllllllllIIIllIIllIIIIlIIII.length() > llllllllllllllIIIllIIllIIIIIllII) {
            throw new DecoderException(String.valueOf(new StringBuilder("The received string length is longer than maximum allowed (").append(llllllllllllllIIIllIIllIIIIlIIIl).append(" > ").append(llllllllllllllIIIllIIllIIIIIllII).append(")")));
        }
        return llllllllllllllIIIllIIllIIIIlIIII;
    }
    
    public ByteBuf copy(final int llllllllllllllIIIllIIIlIIllIIlll, final int llllllllllllllIIIllIIIlIIllIIllI) {
        return this.buf.copy(llllllllllllllIIIllIIIlIIllIIlll, llllllllllllllIIIllIIIlIIllIIllI);
    }
    
    public boolean equals(final Object llllllllllllllIIIllIIIlIIIIIlIIl) {
        return this.buf.equals(llllllllllllllIIIllIIIlIIIIIlIIl);
    }
    
    public int forEachByte(final ByteBufProcessor llllllllllllllIIIllIIIlIlIIlIIII) {
        return this.buf.forEachByte(llllllllllllllIIIllIIIlIlIIlIIII);
    }
    
    public ByteBuf setInt(final int llllllllllllllIIIllIIlIIIlIIIlll, final int llllllllllllllIIIllIIlIIIlIIlIIl) {
        return this.buf.setInt(llllllllllllllIIIllIIlIIIlIIIlll, llllllllllllllIIIllIIlIIIlIIlIIl);
    }
    
    public ByteOrder order() {
        return this.buf.order();
    }
    
    public boolean isReadable() {
        return this.buf.isReadable();
    }
    
    public ByteBuf writeBytes(final ByteBuf llllllllllllllIIIllIIIlIlllllIlI, final int llllllllllllllIIIllIIIlIllllllII) {
        return this.buf.writeBytes(llllllllllllllIIIllIIIlIlllllIlI, llllllllllllllIIIllIIIlIllllllII);
    }
    
    public PacketBuffer(final ByteBuf llllllllllllllIIIllIIllIlllIllll) {
        this.buf = llllllllllllllIIIllIIllIlllIllll;
    }
    
    public ByteBuf setBytes(final int llllllllllllllIIIllIIIlllllIlIIl, final byte[] llllllllllllllIIIllIIIlllllIllIl, final int llllllllllllllIIIllIIIlllllIIlll, final int llllllllllllllIIIllIIIlllllIIllI) {
        return this.buf.setBytes(llllllllllllllIIIllIIIlllllIlIIl, llllllllllllllIIIllIIIlllllIllIl, llllllllllllllIIIllIIIlllllIIlll, llllllllllllllIIIllIIIlllllIIllI);
    }
    
    public ByteBuf setLong(final int llllllllllllllIIIllIIlIIIlIIIIIl, final long llllllllllllllIIIllIIlIIIlIIIIII) {
        return this.buf.setLong(llllllllllllllIIIllIIlIIIlIIIIIl, llllllllllllllIIIllIIlIIIlIIIIII);
    }
    
    public ByteBuf readBytes(final ByteBuf llllllllllllllIIIllIIIllIllllIll, final int llllllllllllllIIIllIIIllIlllllIl) {
        return this.buf.readBytes(llllllllllllllIIIllIIIllIllllIll, llllllllllllllIIIllIIIllIlllllIl);
    }
    
    public ByteBuf resetReaderIndex() {
        return this.buf.resetReaderIndex();
    }
    
    public int bytesBefore(final int llllllllllllllIIIllIIIlIlIIlllII, final int llllllllllllllIIIllIIIlIlIIlIlll, final byte llllllllllllllIIIllIIIlIlIIllIlI) {
        return this.buf.bytesBefore(llllllllllllllIIIllIIIlIlIIlllII, llllllllllllllIIIllIIIlIlIIlIlll, llllllllllllllIIIllIIIlIlIIllIlI);
    }
    
    public int maxWritableBytes() {
        return this.buf.maxWritableBytes();
    }
    
    public ByteBuf getBytes(final int llllllllllllllIIIllIIlIIllIIlIll, final ByteBuf llllllllllllllIIIllIIlIIllIIIlll) {
        return this.buf.getBytes(llllllllllllllIIIllIIlIIllIIlIll, llllllllllllllIIIllIIlIIllIIIlll);
    }
    
    public void writeNBTTagCompoundToBuffer(final NBTTagCompound llllllllllllllIIIllIIllIIllllIlI) {
        if (llllllllllllllIIIllIIllIIllllIlI == null) {
            this.writeByte(0);
        }
        else {
            try {
                CompressedStreamTools.write(llllllllllllllIIIllIIllIIllllIlI, (DataOutput)new ByteBufOutputStream((ByteBuf)this));
            }
            catch (IOException llllllllllllllIIIllIIllIIllllIII) {
                throw new EncoderException((Throwable)llllllllllllllIIIllIIllIIllllIII);
            }
        }
    }
    
    public ByteBuf getBytes(final int llllllllllllllIIIllIIlIIlIllIlII, final ByteBuf llllllllllllllIIIllIIlIIlIllIIll, final int llllllllllllllIIIllIIlIIlIlIllIl, final int llllllllllllllIIIllIIlIIlIlIllII) {
        return this.buf.getBytes(llllllllllllllIIIllIIlIIlIllIlII, llllllllllllllIIIllIIlIIlIllIIll, llllllllllllllIIIllIIlIIlIlIllIl, llllllllllllllIIIllIIlIIlIlIllII);
    }
    
    public boolean getBoolean(final int llllllllllllllIIIllIIlIlIIIlllll) {
        return this.buf.getBoolean(llllllllllllllIIIllIIlIlIIIlllll);
    }
    
    public ByteBuf readBytes(final ByteBuf llllllllllllllIIIllIIIllIlllIIII, final int llllllllllllllIIIllIIIllIllIllll, final int llllllllllllllIIIllIIIllIllIlllI) {
        return this.buf.readBytes(llllllllllllllIIIllIIIllIlllIIII, llllllllllllllIIIllIIIllIllIllll, llllllllllllllIIIllIIIllIllIlllI);
    }
    
    public ByteBuf ensureWritable(final int llllllllllllllIIIllIIlIlIIlllIIl) {
        return this.buf.ensureWritable(llllllllllllllIIIllIIlIlIIlllIIl);
    }
    
    public int setBytes(final int llllllllllllllIIIllIIIllllIlIlll, final InputStream llllllllllllllIIIllIIIllllIlIllI, final int llllllllllllllIIIllIIIllllIlIIIl) throws IOException {
        return this.buf.setBytes(llllllllllllllIIIllIIIllllIlIlll, llllllllllllllIIIllIIIllllIlIllI, llllllllllllllIIIllIIIllllIlIIIl);
    }
    
    public ByteBuf slice() {
        return this.buf.slice();
    }
    
    public ByteBuf writeMedium(final int llllllllllllllIIIllIIIllIIlIlIII) {
        return this.buf.writeMedium(llllllllllllllIIIllIIIllIIlIlIII);
    }
    
    public byte getByte(final int llllllllllllllIIIllIIlIlIIIllIIl) {
        return this.buf.getByte(llllllllllllllIIIllIIlIlIIIllIIl);
    }
    
    public ByteBuf setBytes(final int llllllllllllllIIIllIIIlllllIIIIl, final ByteBuffer llllllllllllllIIIllIIIllllIlllIl) {
        return this.buf.setBytes(llllllllllllllIIIllIIIlllllIIIIl, llllllllllllllIIIllIIIllllIlllIl);
    }
    
    public ByteBuf writeBytes(final byte[] llllllllllllllIIIllIIIlIlllIlIIl) {
        return this.buf.writeBytes(llllllllllllllIIIllIIIlIlllIlIIl);
    }
    
    public ByteBuf writeFloat(final float llllllllllllllIIIllIIIllIIIlIIII) {
        return this.buf.writeFloat(llllllllllllllIIIllIIIllIIIlIIII);
    }
    
    public ByteBuffer nioBuffer() {
        return this.buf.nioBuffer();
    }
    
    public short getUnsignedByte(final int llllllllllllllIIIllIIlIlIIIIllll) {
        return this.buf.getUnsignedByte(llllllllllllllIIIllIIlIlIIIIllll);
    }
    
    public ByteBuf setBytes(final int llllllllllllllIIIllIIIllllllIllI, final byte[] llllllllllllllIIIllIIIlllllllIII) {
        return this.buf.setBytes(llllllllllllllIIIllIIIllllllIllI, llllllllllllllIIIllIIIlllllllIII);
    }
    
    public int hashCode() {
        return this.buf.hashCode();
    }
    
    public int readUnsignedShort() {
        return this.buf.readUnsignedShort();
    }
    
    public ByteBuf order(final ByteOrder llllllllllllllIIIllIIlIlllIIlIIl) {
        return this.buf.order(llllllllllllllIIIllIIlIlllIIlIIl);
    }
    
    public ByteBuf readerIndex(final int llllllllllllllIIIllIIlIllIlIlllI) {
        return this.buf.readerIndex(llllllllllllllIIIllIIlIllIlIlllI);
    }
    
    public int readableBytes() {
        return this.buf.readableBytes();
    }
    
    public int bytesBefore(final int llllllllllllllIIIllIIIlIlIlIIIll, final byte llllllllllllllIIIllIIIlIlIlIIlIl) {
        return this.buf.bytesBefore(llllllllllllllIIIllIIIlIlIlIIIll, llllllllllllllIIIllIIIlIlIlIIlIl);
    }
    
    public String toString() {
        return this.buf.toString();
    }
    
    public ByteBuf setIndex(final int llllllllllllllIIIllIIlIllIIllIll, final int llllllllllllllIIIllIIlIllIIllIlI) {
        return this.buf.setIndex(llllllllllllllIIIllIIlIllIIllIll, llllllllllllllIIIllIIlIllIIllIlI);
    }
    
    public boolean hasMemoryAddress() {
        return this.buf.hasMemoryAddress();
    }
    
    public ByteBuf retain(final int llllllllllllllIIIllIIIIllllllIlI) {
        return this.buf.retain(llllllllllllllIIIllIIIIllllllIlI);
    }
    
    public ByteBuf writeByte(final int llllllllllllllIIIllIIIllIIllIIlI) {
        return this.buf.writeByte(llllllllllllllIIIllIIIllIIllIIlI);
    }
    
    public long readVarLong() {
        long llllllllllllllIIIllIIllIlIlIlIll = 0L;
        int llllllllllllllIIIllIIllIlIlIlIlI = 0;
        byte llllllllllllllIIIllIIllIlIlIlIIl;
        do {
            llllllllllllllIIIllIIllIlIlIlIIl = this.readByte();
            llllllllllllllIIIllIIllIlIlIlIll |= (long)(llllllllllllllIIIllIIllIlIlIlIIl & 0x7F) << llllllllllllllIIIllIIllIlIlIlIlI++ * 7;
            if (llllllllllllllIIIllIIllIlIlIlIlI > 10) {
                throw new RuntimeException("VarLong too big");
            }
        } while ((llllllllllllllIIIllIIllIlIlIlIIl & 0x80) == 0x80);
        return llllllllllllllIIIllIIllIlIlIlIll;
    }
    
    public int writeBytes(final InputStream llllllllllllllIIIllIIIlIllIIllIl, final int llllllllllllllIIIllIIIlIllIIllII) throws IOException {
        return this.buf.writeBytes(llllllllllllllIIIllIIIlIllIIllIl, llllllllllllllIIIllIIIlIllIIllII);
    }
    
    public short getShort(final int llllllllllllllIIIllIIlIlIIIIlIlI) {
        return this.buf.getShort(llllllllllllllIIIllIIlIlIIIIlIlI);
    }
    
    public int getUnsignedMedium(final int llllllllllllllIIIllIIlIIllllIlII) {
        return this.buf.getUnsignedMedium(llllllllllllllIIIllIIlIIllllIlII);
    }
    
    public boolean isWritable() {
        return this.buf.isWritable();
    }
    
    public boolean isWritable(final int llllllllllllllIIIllIIlIlIllIIlIl) {
        return this.buf.isWritable(llllllllllllllIIIllIIlIlIllIIlIl);
    }
    
    public int getBytes(final int llllllllllllllIIIllIIlIIIllllIIl, final GatheringByteChannel llllllllllllllIIIllIIlIIIlllIlII, final int llllllllllllllIIIllIIlIIIlllIlll) throws IOException {
        return this.buf.getBytes(llllllllllllllIIIllIIlIIIllllIIl, llllllllllllllIIIllIIlIIIlllIlII, llllllllllllllIIIllIIlIIIlllIlll);
    }
    
    public ItemStack readItemStackFromBuffer() throws IOException {
        ItemStack llllllllllllllIIIllIIllIIIllIIll = null;
        final short llllllllllllllIIIllIIllIIIllIIlI = this.readShort();
        if (llllllllllllllIIIllIIllIIIllIIlI >= 0) {
            final byte llllllllllllllIIIllIIllIIIllIIIl = this.readByte();
            final short llllllllllllllIIIllIIllIIIllIIII = this.readShort();
            llllllllllllllIIIllIIllIIIllIIll = new ItemStack(Item.getItemById(llllllllllllllIIIllIIllIIIllIIlI), llllllllllllllIIIllIIllIIIllIIIl, llllllllllllllIIIllIIllIIIllIIII);
            llllllllllllllIIIllIIllIIIllIIll.setTagCompound(this.readNBTTagCompoundFromBuffer());
        }
        return llllllllllllllIIIllIIllIIIllIIll;
    }
    
    public int forEachByteDesc(final int llllllllllllllIIIllIIIlIIllllIII, final int llllllllllllllIIIllIIIlIIlllIlll, final ByteBufProcessor llllllllllllllIIIllIIIlIIlllIllI) {
        return this.buf.forEachByteDesc(llllllllllllllIIIllIIIlIIllllIII, llllllllllllllIIIllIIIlIIlllIlll, llllllllllllllIIIllIIIlIIlllIllI);
    }
    
    public int readMedium() {
        return this.buf.readMedium();
    }
    
    public ByteBuf setBoolean(final int llllllllllllllIIIllIIlIIIllIlllI, final boolean llllllllllllllIIIllIIlIIIllIllIl) {
        return this.buf.setBoolean(llllllllllllllIIIllIIlIIIllIlllI, llllllllllllllIIIllIIlIIIllIllIl);
    }
    
    public byte[] array() {
        return this.buf.array();
    }
    
    public ByteBuf getBytes(final int llllllllllllllIIIllIIlIIlIIlllII, final byte[] llllllllllllllIIIllIIlIIlIIlIllI, final int llllllllllllllIIIllIIlIIlIIllIlI, final int llllllllllllllIIIllIIlIIlIIllIIl) {
        return this.buf.getBytes(llllllllllllllIIIllIIlIIlIIlllII, llllllllllllllIIIllIIlIIlIIlIllI, llllllllllllllIIIllIIlIIlIIllIlI, llllllllllllllIIIllIIlIIlIIllIIl);
    }
    
    public int capacity() {
        return this.buf.capacity();
    }
    
    public ByteBuffer nioBuffer(final int llllllllllllllIIIllIIIlIIlIIllII, final int llllllllllllllIIIllIIIlIIlIIlIll) {
        return this.buf.nioBuffer(llllllllllllllIIIllIIIlIIlIIllII, llllllllllllllIIIllIIIlIIlIIlIll);
    }
    
    public short readUnsignedByte() {
        return this.buf.readUnsignedByte();
    }
    
    public double readDouble() {
        return this.buf.readDouble();
    }
    
    public void writeBlockPos(final BlockPos llllllllllllllIIIllIIllIllIlIIlI) {
        this.writeLong(llllllllllllllIIIllIIllIllIlIIlI.toLong());
    }
    
    public String toString(final Charset llllllllllllllIIIllIIIlIIIIllllI) {
        return this.buf.toString(llllllllllllllIIIllIIIlIIIIllllI);
    }
    
    public ByteBuffer internalNioBuffer(final int llllllllllllllIIIllIIIlIIlIIIIII, final int llllllllllllllIIIllIIIlIIIllllll) {
        return this.buf.internalNioBuffer(llllllllllllllIIIllIIIlIIlIIIIII, llllllllllllllIIIllIIIlIIIllllll);
    }
    
    public int readInt() {
        return this.buf.readInt();
    }
    
    public ByteBuf readBytes(final ByteBuffer llllllllllllllIIIllIIIllIlIllIII) {
        return this.buf.readBytes(llllllllllllllIIIllIIIllIlIllIII);
    }
    
    public ByteBuf writeBytes(final byte[] llllllllllllllIIIllIIIlIlllIIIIl, final int llllllllllllllIIIllIIIlIllIlllII, final int llllllllllllllIIIllIIIlIllIllIll) {
        return this.buf.writeBytes(llllllllllllllIIIllIIIlIlllIIIIl, llllllllllllllIIIllIIIlIllIlllII, llllllllllllllIIIllIIIlIllIllIll);
    }
    
    public ByteBuf setByte(final int llllllllllllllIIIllIIlIIIllIIIlI, final int llllllllllllllIIIllIIlIIIllIIIIl) {
        return this.buf.setByte(llllllllllllllIIIllIIlIIIllIIIlI, llllllllllllllIIIllIIlIIIllIIIIl);
    }
    
    public int setBytes(final int llllllllllllllIIIllIIIllllIIIlll, final ScatteringByteChannel llllllllllllllIIIllIIIllllIIlIlI, final int llllllllllllllIIIllIIIllllIIlIIl) throws IOException {
        return this.buf.setBytes(llllllllllllllIIIllIIIllllIIIlll, llllllllllllllIIIllIIIllllIIlIlI, llllllllllllllIIIllIIIllllIIlIIl);
    }
    
    public int compareTo(final ByteBuf llllllllllllllIIIllIIIlIIIIIIlIl) {
        return this.buf.compareTo(llllllllllllllIIIllIIIlIIIIIIlIl);
    }
    
    public long getLong(final int llllllllllllllIIIllIIlIIlllIIlII) {
        return this.buf.getLong(llllllllllllllIIIllIIlIIlllIIlII);
    }
    
    public ByteBuffer[] nioBuffers(final int llllllllllllllIIIllIIIlIIIllIlII, final int llllllllllllllIIIllIIIlIIIllIIll) {
        return this.buf.nioBuffers(llllllllllllllIIIllIIIlIIIllIlII, llllllllllllllIIIllIIIlIIIllIIll);
    }
    
    public ByteBuf setZero(final int llllllllllllllIIIllIIIlllIllllIl, final int llllllllllllllIIIllIIIlllIllllll) {
        return this.buf.setZero(llllllllllllllIIIllIIIlllIllllIl, llllllllllllllIIIllIIIlllIllllll);
    }
    
    public int indexOf(final int llllllllllllllIIIllIIIlIlIllIIll, final int llllllllllllllIIIllIIIlIlIllIIlI, final byte llllllllllllllIIIllIIIlIlIllIIIl) {
        return this.buf.indexOf(llllllllllllllIIIllIIIlIlIllIIll, llllllllllllllIIIllIIIlIlIllIIlI, llllllllllllllIIIllIIIlIlIllIIIl);
    }
    
    public long readLong() {
        return this.buf.readLong();
    }
    
    public UUID readUuid() {
        return new UUID(this.readLong(), this.readLong());
    }
    
    public boolean release() {
        return this.buf.release();
    }
    
    public short readShort() {
        return this.buf.readShort();
    }
    
    public byte[] readByteArray() {
        final byte[] llllllllllllllIIIllIIllIllIlllIl = new byte[this.readVarIntFromBuffer()];
        this.readBytes(llllllllllllllIIIllIIllIllIlllIl);
        return llllllllllllllIIIllIIllIllIlllIl;
    }
    
    public int readerIndex() {
        return this.buf.readerIndex();
    }
    
    public boolean readBoolean() {
        return this.buf.readBoolean();
    }
    
    public BlockPos readBlockPos() {
        return BlockPos.fromLong(this.readLong());
    }
    
    public IChatComponent readChatComponent() {
        return IChatComponent.Serializer.jsonToComponent(this.readStringFromBuffer(32767));
    }
    
    public int refCnt() {
        return this.buf.refCnt();
    }
    
    public ByteBuf getBytes(final int llllllllllllllIIIllIIlIIlIIIllII, final ByteBuffer llllllllllllllIIIllIIlIIlIIIlIll) {
        return this.buf.getBytes(llllllllllllllIIIllIIlIIlIIIllII, llllllllllllllIIIllIIlIIlIIIlIll);
    }
    
    public void writeChatComponent(final IChatComponent llllllllllllllIIIllIIllIllIIlIIl) {
        this.writeString(IChatComponent.Serializer.componentToJson(llllllllllllllIIIllIIllIllIIlIIl));
    }
    
    public ByteBuf resetWriterIndex() {
        return this.buf.resetWriterIndex();
    }
    
    public float getFloat(final int llllllllllllllIIIllIIlIIllIlIllI) {
        return this.buf.getFloat(llllllllllllllIIIllIIlIIllIlIllI);
    }
    
    public long getUnsignedInt(final int llllllllllllllIIIllIIlIIlllIlIII) {
        return this.buf.getUnsignedInt(llllllllllllllIIIllIIlIIlllIlIII);
    }
    
    public int writableBytes() {
        return this.buf.writableBytes();
    }
    
    public ByteBuf discardSomeReadBytes() {
        return this.buf.discardSomeReadBytes();
    }
    
    public ByteBuf retain() {
        return this.buf.retain();
    }
    
    public ByteBuf writeLong(final long llllllllllllllIIIllIIIllIIIllIlI) {
        return this.buf.writeLong(llllllllllllllIIIllIIIllIIIllIlI);
    }
    
    public ByteBuf readBytes(final ByteBuf llllllllllllllIIIllIIIlllIIIIIll) {
        return this.buf.readBytes(llllllllllllllIIIllIIIlllIIIIIll);
    }
}
