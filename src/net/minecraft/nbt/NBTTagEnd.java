package net.minecraft.nbt;

import java.io.*;

public class NBTTagEnd extends NBTBase
{
    @Override
    void read(final DataInput llllllllllllllllIIIlIlllIlllIlIl, final int llllllllllllllllIIIlIlllIlllIlII, final NBTSizeTracker llllllllllllllllIIIlIlllIlllIIll) throws IOException {
    }
    
    static {
        __OBFID = "CL_00001219";
    }
    
    @Override
    public NBTBase copy() {
        return new NBTTagEnd();
    }
    
    @Override
    public String toString() {
        return "END";
    }
    
    @Override
    public byte getId() {
        return 0;
    }
    
    @Override
    void write(final DataOutput llllllllllllllllIIIlIlllIlllIIIl) throws IOException {
    }
}
