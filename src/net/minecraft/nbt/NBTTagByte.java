package net.minecraft.nbt;

import java.io.*;

public class NBTTagByte extends NBTPrimitive
{
    private /* synthetic */ byte data;
    
    @Override
    void read(final DataInput llllllllllllllllIIllIIIIIlIlIIll, final int llllllllllllllllIIllIIIIIlIlIllI, final NBTSizeTracker llllllllllllllllIIllIIIIIlIlIIlI) throws IOException {
        llllllllllllllllIIllIIIIIlIlIIlI.read(8L);
        this.data = llllllllllllllllIIllIIIIIlIlIIll.readByte();
    }
    
    @Override
    public byte getId() {
        return 1;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllllIIllIIIIIlIIIllI) {
        if (super.equals(llllllllllllllllIIllIIIIIlIIIllI)) {
            final NBTTagByte llllllllllllllllIIllIIIIIlIIIlIl = (NBTTagByte)llllllllllllllllIIllIIIIIlIIIllI;
            return this.data == llllllllllllllllIIllIIIIIlIIIlIl.data;
        }
        return false;
    }
    
    @Override
    public byte getByte() {
        return this.data;
    }
    
    @Override
    public NBTBase copy() {
        return new NBTTagByte(this.data);
    }
    
    public NBTTagByte(final byte llllllllllllllllIIllIIIIIllIIIlI) {
        this.data = llllllllllllllllIIllIIIIIllIIIlI;
    }
    
    @Override
    public short getShort() {
        return this.data;
    }
    
    @Override
    public int getInt() {
        return this.data;
    }
    
    @Override
    void write(final DataOutput llllllllllllllllIIllIIIIIlIllllI) throws IOException {
        llllllllllllllllIIllIIIIIlIllllI.writeByte(this.data);
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.data).append("b"));
    }
    
    @Override
    public float getFloat() {
        return this.data;
    }
    
    static {
        __OBFID = "CL_00001214";
    }
    
    @Override
    public long getLong() {
        return this.data;
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ this.data;
    }
    
    @Override
    public double getDouble() {
        return this.data;
    }
    
    NBTTagByte() {
    }
}
