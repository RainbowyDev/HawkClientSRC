package net.minecraft.nbt;

import java.util.*;
import java.io.*;

public class NBTTagByteArray extends NBTBase
{
    private /* synthetic */ byte[] data;
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("[").append(this.data.length).append(" bytes]"));
    }
    
    @Override
    void read(final DataInput llllllllllllllIlIIIIIlIllllIlIlI, final int llllllllllllllIlIIIIIlIllllIlllI, final NBTSizeTracker llllllllllllllIlIIIIIlIllllIlIIl) throws IOException {
        final int llllllllllllllIlIIIIIlIllllIllII = llllllllllllllIlIIIIIlIllllIlIlI.readInt();
        llllllllllllllIlIIIIIlIllllIlIIl.read(8 * llllllllllllllIlIIIIIlIllllIllII);
        this.data = new byte[llllllllllllllIlIIIIIlIllllIllII];
        llllllllllllllIlIIIIIlIllllIlIlI.readFully(this.data);
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ Arrays.hashCode(this.data);
    }
    
    public byte[] getByteArray() {
        return this.data;
    }
    
    @Override
    public byte getId() {
        return 7;
    }
    
    NBTTagByteArray() {
    }
    
    public NBTTagByteArray(final byte[] llllllllllllllIlIIIIIlIlllllllIl) {
        this.data = llllllllllllllIlIIIIIlIlllllllIl;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIlIIIIIlIlllIllIlI) {
        return super.equals(llllllllllllllIlIIIIIlIlllIllIlI) && Arrays.equals(this.data, ((NBTTagByteArray)llllllllllllllIlIIIIIlIlllIllIlI).data);
    }
    
    static {
        __OBFID = "CL_00001213";
    }
    
    @Override
    public NBTBase copy() {
        final byte[] llllllllllllllIlIIIIIlIllllIIIII = new byte[this.data.length];
        System.arraycopy(this.data, 0, llllllllllllllIlIIIIIlIllllIIIII, 0, this.data.length);
        return new NBTTagByteArray(llllllllllllllIlIIIIIlIllllIIIII);
    }
    
    @Override
    void write(final DataOutput llllllllllllllIlIIIIIlIlllllIlIl) throws IOException {
        llllllllllllllIlIIIIIlIlllllIlIl.writeInt(this.data.length);
        llllllllllllllIlIIIIIlIlllllIlIl.write(this.data);
    }
}
