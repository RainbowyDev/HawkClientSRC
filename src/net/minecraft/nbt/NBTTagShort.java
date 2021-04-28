package net.minecraft.nbt;

import java.io.*;

public class NBTTagShort extends NBTPrimitive
{
    private /* synthetic */ short data;
    
    @Override
    public float getFloat() {
        return this.data;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.data).append("s"));
    }
    
    @Override
    public byte getByte() {
        return (byte)(this.data & 0xFF);
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ this.data;
    }
    
    @Override
    void write(final DataOutput llllllllllllllllIIIllIIllIIlIIll) throws IOException {
        llllllllllllllllIIIllIIllIIlIIll.writeShort(this.data);
    }
    
    @Override
    public boolean equals(final Object llllllllllllllllIIIllIIlIllllIII) {
        if (super.equals(llllllllllllllllIIIllIIlIllllIII)) {
            final NBTTagShort llllllllllllllllIIIllIIlIllllIlI = (NBTTagShort)llllllllllllllllIIIllIIlIllllIII;
            return this.data == llllllllllllllllIIIllIIlIllllIlI.data;
        }
        return false;
    }
    
    public NBTTagShort(final short llllllllllllllllIIIllIIllIIllIIl) {
        this.data = llllllllllllllllIIIllIIllIIllIIl;
    }
    
    @Override
    public double getDouble() {
        return this.data;
    }
    
    @Override
    public byte getId() {
        return 2;
    }
    
    public NBTTagShort() {
    }
    
    @Override
    public NBTBase copy() {
        return new NBTTagShort(this.data);
    }
    
    @Override
    void read(final DataInput llllllllllllllllIIIllIIllIIIllII, final int llllllllllllllllIIIllIIllIIIlIll, final NBTSizeTracker llllllllllllllllIIIllIIllIIIIlll) throws IOException {
        llllllllllllllllIIIllIIllIIIIlll.read(16L);
        this.data = llllllllllllllllIIIllIIllIIIllII.readShort();
    }
    
    @Override
    public long getLong() {
        return this.data;
    }
    
    @Override
    public short getShort() {
        return this.data;
    }
    
    static {
        __OBFID = "CL_00001227";
    }
    
    @Override
    public int getInt() {
        return this.data;
    }
}
