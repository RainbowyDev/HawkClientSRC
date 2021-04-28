package net.minecraft.nbt;

import java.io.*;

public class NBTTagLong extends NBTPrimitive
{
    private /* synthetic */ long data;
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.data).append("L"));
    }
    
    @Override
    void write(final DataOutput lIllllllllIIIII) throws IOException {
        lIllllllllIIIII.writeLong(this.data);
    }
    
    @Override
    public double getDouble() {
        return (double)this.data;
    }
    
    @Override
    void read(final DataInput lIlllllllIlIlIl, final int lIlllllllIllIII, final NBTSizeTracker lIlllllllIlIlII) throws IOException {
        lIlllllllIlIlII.read(64L);
        this.data = lIlllllllIlIlIl.readLong();
    }
    
    static {
        __OBFID = "CL_00001225";
    }
    
    @Override
    public float getFloat() {
        return (float)this.data;
    }
    
    public NBTTagLong(final long lIllllllllIIlII) {
        this.data = lIllllllllIIlII;
    }
    
    @Override
    public int getInt() {
        return (int)(this.data & -1L);
    }
    
    @Override
    public boolean equals(final Object lIlllllllIIIlIl) {
        if (super.equals(lIlllllllIIIlIl)) {
            final NBTTagLong lIlllllllIIIlll = (NBTTagLong)lIlllllllIIIlIl;
            return this.data == lIlllllllIIIlll.data;
        }
        return false;
    }
    
    @Override
    public byte getByte() {
        return (byte)(this.data & 0xFFL);
    }
    
    NBTTagLong() {
    }
    
    @Override
    public NBTBase copy() {
        return new NBTTagLong(this.data);
    }
    
    @Override
    public byte getId() {
        return 4;
    }
    
    @Override
    public short getShort() {
        return (short)(this.data & 0xFFFFL);
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ (int)(this.data ^ this.data >>> 32);
    }
    
    @Override
    public long getLong() {
        return this.data;
    }
}
