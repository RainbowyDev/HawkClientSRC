package net.minecraft.nbt;

import java.io.*;

public abstract class NBTBase
{
    @Override
    public abstract String toString();
    
    protected static NBTBase createNewByType(final byte llIllllllIllll) {
        switch (llIllllllIllll) {
            case 0: {
                return new NBTTagEnd();
            }
            case 1: {
                return new NBTTagByte();
            }
            case 2: {
                return new NBTTagShort();
            }
            case 3: {
                return new NBTTagInt();
            }
            case 4: {
                return new NBTTagLong();
            }
            case 5: {
                return new NBTTagFloat();
            }
            case 6: {
                return new NBTTagDouble();
            }
            case 7: {
                return new NBTTagByteArray();
            }
            case 8: {
                return new NBTTagString();
            }
            case 9: {
                return new NBTTagList();
            }
            case 10: {
                return new NBTTagCompound();
            }
            case 11: {
                return new NBTTagIntArray();
            }
            default: {
                return null;
            }
        }
    }
    
    public abstract NBTBase copy();
    
    abstract void write(final DataOutput p0) throws IOException;
    
    abstract void read(final DataInput p0, final int p1, final NBTSizeTracker p2) throws IOException;
    
    protected String getString() {
        return this.toString();
    }
    
    @Override
    public boolean equals(final Object llIllllllIlIIl) {
        if (!(llIllllllIlIIl instanceof NBTBase)) {
            return false;
        }
        final NBTBase llIllllllIlIII = (NBTBase)llIllllllIlIIl;
        return this.getId() == llIllllllIlIII.getId();
    }
    
    public boolean hasNoTags() {
        return false;
    }
    
    static {
        __OBFID = "CL_00001229";
        NBT_TYPES = new String[] { "END", "BYTE", "SHORT", "INT", "LONG", "FLOAT", "DOUBLE", "BYTE[]", "STRING", "LIST", "COMPOUND", "INT[]" };
    }
    
    public abstract byte getId();
    
    @Override
    public int hashCode() {
        return this.getId();
    }
    
    public abstract static class NBTPrimitive extends NBTBase
    {
        public abstract short getShort();
        
        public abstract byte getByte();
        
        public abstract float getFloat();
        
        public abstract double getDouble();
        
        static {
            __OBFID = "CL_00001230";
        }
        
        public abstract int getInt();
        
        public abstract long getLong();
    }
}
