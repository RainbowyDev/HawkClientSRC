package net.minecraft.nbt;

import java.io.*;

public class NBTTagInt extends NBTPrimitive
{
    private /* synthetic */ int data;
    
    @Override
    void read(final DataInput llllllllllllllllIIllIlIllIlllIlI, final int llllllllllllllllIIllIlIllIllllIl, final NBTSizeTracker llllllllllllllllIIllIlIllIlllIIl) throws IOException {
        llllllllllllllllIIllIlIllIlllIIl.read(32L);
        this.data = llllllllllllllllIIllIlIllIlllIlI.readInt();
    }
    
    @Override
    public byte getByte() {
        return (byte)(this.data & 0xFF);
    }
    
    @Override
    void write(final DataOutput llllllllllllllllIIllIlIlllIIIlIl) throws IOException {
        llllllllllllllllIIllIlIlllIIIlIl.writeInt(this.data);
    }
    
    @Override
    public float getFloat() {
        return (float)this.data;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.data));
    }
    
    NBTTagInt() {
    }
    
    public NBTTagInt(final int llllllllllllllllIIllIlIlllIIlIll) {
        this.data = llllllllllllllllIIllIlIlllIIlIll;
    }
    
    @Override
    public double getDouble() {
        return this.data;
    }
    
    @Override
    public byte getId() {
        return 3;
    }
    
    static {
        __OBFID = "CL_00001223";
    }
    
    @Override
    public int getInt() {
        return this.data;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllllIIllIlIllIlIllIl) {
        if (super.equals(llllllllllllllllIIllIlIllIlIllIl)) {
            final NBTTagInt llllllllllllllllIIllIlIllIlIllII = (NBTTagInt)llllllllllllllllIIllIlIllIlIllIl;
            return this.data == llllllllllllllllIIllIlIllIlIllII.data;
        }
        return false;
    }
    
    @Override
    public NBTBase copy() {
        return new NBTTagInt(this.data);
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ this.data;
    }
    
    @Override
    public long getLong() {
        return this.data;
    }
    
    @Override
    public short getShort() {
        return (short)(this.data & 0xFFFF);
    }
}
