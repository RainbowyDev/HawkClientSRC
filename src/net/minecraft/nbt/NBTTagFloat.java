package net.minecraft.nbt;

import net.minecraft.util.*;
import java.io.*;

public class NBTTagFloat extends NBTPrimitive
{
    private /* synthetic */ float data;
    
    @Override
    public int getInt() {
        return MathHelper.floor_float(this.data);
    }
    
    @Override
    void write(final DataOutput lllllllllllllllIlIIllIIllIIIIllI) throws IOException {
        lllllllllllllllIlIIllIIllIIIIllI.writeFloat(this.data);
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllIlIIllIIlIIlllIlI) {
        if (super.equals(lllllllllllllllIlIIllIIlIIlllIlI)) {
            final NBTTagFloat lllllllllllllllIlIIllIIlIIlllIII = (NBTTagFloat)lllllllllllllllIlIIllIIlIIlllIlI;
            return this.data == lllllllllllllllIlIIllIIlIIlllIII.data;
        }
        return false;
    }
    
    @Override
    public double getDouble() {
        return this.data;
    }
    
    @Override
    public long getLong() {
        return (long)this.data;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.data).append("f"));
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ Float.floatToIntBits(this.data);
    }
    
    public NBTTagFloat(final float lllllllllllllllIlIIllIIllIIlIlII) {
        this.data = lllllllllllllllIlIIllIIllIIlIlII;
    }
    
    NBTTagFloat() {
    }
    
    @Override
    public float getFloat() {
        return this.data;
    }
    
    @Override
    void read(final DataInput lllllllllllllllIlIIllIIlIlllIllI, final int lllllllllllllllIlIIllIIlIlllIlII, final NBTSizeTracker lllllllllllllllIlIIllIIlIllIllII) throws IOException {
        lllllllllllllllIlIIllIIlIllIllII.read(32L);
        this.data = lllllllllllllllIlIIllIIlIlllIllI.readFloat();
    }
    
    @Override
    public NBTBase copy() {
        return new NBTTagFloat(this.data);
    }
    
    @Override
    public byte getId() {
        return 5;
    }
    
    @Override
    public byte getByte() {
        return (byte)(MathHelper.floor_float(this.data) & 0xFF);
    }
    
    @Override
    public short getShort() {
        return (short)(MathHelper.floor_float(this.data) & 0xFFFF);
    }
    
    static {
        __OBFID = "CL_00001220";
    }
}
