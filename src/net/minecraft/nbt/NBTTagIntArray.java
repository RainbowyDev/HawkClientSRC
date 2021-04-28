package net.minecraft.nbt;

import java.util.*;
import java.io.*;

public class NBTTagIntArray extends NBTBase
{
    private /* synthetic */ int[] intArray;
    
    @Override
    public String toString() {
        String llllllllllllllIIIIlIlIllIllIlllI = "[";
        for (final int llllllllllllllIIIIlIlIllIllIlIlI : this.intArray) {
            llllllllllllllIIIIlIlIllIllIlllI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIlIlIllIllIlllI)).append(llllllllllllllIIIIlIlIllIllIlIlI).append(","));
        }
        return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIlIlIllIllIlllI)).append("]"));
    }
    
    public NBTTagIntArray(final int[] llllllllllllllIIIIlIlIlllIIlIIlI) {
        this.intArray = llllllllllllllIIIIlIlIlllIIlIIlI;
    }
    
    @Override
    void write(final DataOutput llllllllllllllIIIIlIlIlllIIIlIII) throws IOException {
        llllllllllllllIIIIlIlIlllIIIlIII.writeInt(this.intArray.length);
        for (int llllllllllllllIIIIlIlIlllIIIlIlI = 0; llllllllllllllIIIIlIlIlllIIIlIlI < this.intArray.length; ++llllllllllllllIIIIlIlIlllIIIlIlI) {
            llllllllllllllIIIIlIlIlllIIIlIII.writeInt(this.intArray[llllllllllllllIIIIlIlIlllIIIlIlI]);
        }
    }
    
    @Override
    public byte getId() {
        return 11;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIIIIlIlIllIlIllIlI) {
        return super.equals(llllllllllllllIIIIlIlIllIlIllIlI) && Arrays.equals(this.intArray, ((NBTTagIntArray)llllllllllllllIIIIlIlIllIlIllIlI).intArray);
    }
    
    static {
        __OBFID = "CL_00001221";
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ Arrays.hashCode(this.intArray);
    }
    
    @Override
    void read(final DataInput llllllllllllllIIIIlIlIlllIIIIIII, final int llllllllllllllIIIIlIlIllIlllllll, final NBTSizeTracker llllllllllllllIIIIlIlIllIllllllI) throws IOException {
        final int llllllllllllllIIIIlIlIllIlllllIl = llllllllllllllIIIIlIlIlllIIIIIII.readInt();
        llllllllllllllIIIIlIlIllIllllllI.read(32 * llllllllllllllIIIIlIlIllIlllllIl);
        this.intArray = new int[llllllllllllllIIIIlIlIllIlllllIl];
        for (int llllllllllllllIIIIlIlIllIlllllII = 0; llllllllllllllIIIIlIlIllIlllllII < llllllllllllllIIIIlIlIllIlllllIl; ++llllllllllllllIIIIlIlIllIlllllII) {
            this.intArray[llllllllllllllIIIIlIlIllIlllllII] = llllllllllllllIIIIlIlIlllIIIIIII.readInt();
        }
    }
    
    public int[] getIntArray() {
        return this.intArray;
    }
    
    @Override
    public NBTBase copy() {
        final int[] llllllllllllllIIIIlIlIllIllIIIII = new int[this.intArray.length];
        System.arraycopy(this.intArray, 0, llllllllllllllIIIIlIlIllIllIIIII, 0, this.intArray.length);
        return new NBTTagIntArray(llllllllllllllIIIIlIlIllIllIIIII);
    }
    
    NBTTagIntArray() {
    }
}
