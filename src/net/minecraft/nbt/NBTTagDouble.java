package net.minecraft.nbt;

import net.minecraft.util.*;
import java.io.*;

public class NBTTagDouble extends NBTPrimitive
{
    private /* synthetic */ double data;
    
    public NBTTagDouble(final double lllllllllllllllIlllIIIIlIIlllIII) {
        this.data = lllllllllllllllIlllIIIIlIIlllIII;
    }
    
    @Override
    public float getFloat() {
        return (float)this.data;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllIlllIIIIlIIIlllII) {
        if (super.equals(lllllllllllllllIlllIIIIlIIIlllII)) {
            final NBTTagDouble lllllllllllllllIlllIIIIlIIIllIll = (NBTTagDouble)lllllllllllllllIlllIIIIlIIIlllII;
            return this.data == lllllllllllllllIlllIIIIlIIIllIll.data;
        }
        return false;
    }
    
    @Override
    void read(final DataInput lllllllllllllllIlllIIIIlIIlIlIIl, final int lllllllllllllllIlllIIIIlIIlIllII, final NBTSizeTracker lllllllllllllllIlllIIIIlIIlIlIll) throws IOException {
        lllllllllllllllIlllIIIIlIIlIlIll.read(64L);
        this.data = lllllllllllllllIlllIIIIlIIlIlIIl.readDouble();
    }
    
    @Override
    public double getDouble() {
        return this.data;
    }
    
    @Override
    public byte getId() {
        return 6;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.data).append("d"));
    }
    
    @Override
    public long getLong() {
        return (long)Math.floor(this.data);
    }
    
    @Override
    public byte getByte() {
        return (byte)(MathHelper.floor_double(this.data) & 0xFF);
    }
    
    @Override
    public short getShort() {
        return (short)(MathHelper.floor_double(this.data) & 0xFFFF);
    }
    
    @Override
    void write(final DataOutput lllllllllllllllIlllIIIIlIIllIIlI) throws IOException {
        lllllllllllllllIlllIIIIlIIllIIlI.writeDouble(this.data);
    }
    
    @Override
    public int hashCode() {
        final long lllllllllllllllIlllIIIIlIIIlIlII = Double.doubleToLongBits(this.data);
        return super.hashCode() ^ (int)(lllllllllllllllIlllIIIIlIIIlIlII ^ lllllllllllllllIlllIIIIlIIIlIlII >>> 32);
    }
    
    @Override
    public int getInt() {
        return MathHelper.floor_double(this.data);
    }
    
    NBTTagDouble() {
    }
    
    @Override
    public NBTBase copy() {
        return new NBTTagDouble(this.data);
    }
    
    static {
        __OBFID = "CL_00001218";
    }
}
