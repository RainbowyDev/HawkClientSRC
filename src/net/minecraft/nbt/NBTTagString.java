package net.minecraft.nbt;

import java.io.*;

public class NBTTagString extends NBTBase
{
    private /* synthetic */ String data;
    
    @Override
    public boolean equals(final Object lllllllllllllllllIIIlllIIlIlIlIl) {
        if (!super.equals(lllllllllllllllllIIIlllIIlIlIlIl)) {
            return false;
        }
        final NBTTagString lllllllllllllllllIIIlllIIlIlIlll = (NBTTagString)lllllllllllllllllIIIlllIIlIlIlIl;
        return (this.data == null && lllllllllllllllllIIIlllIIlIlIlll.data == null) || (this.data != null && this.data.equals(lllllllllllllllllIIIlllIIlIlIlll.data));
    }
    
    @Override
    public byte getId() {
        return 8;
    }
    
    public NBTTagString(final String lllllllllllllllllIIIlllIlIIlIIlI) {
        this.data = lllllllllllllllllIIIlllIlIIlIIlI;
        if (lllllllllllllllllIIIlllIlIIlIIlI == null) {
            throw new IllegalArgumentException("Empty string not allowed");
        }
    }
    
    public NBTTagString() {
        this.data = "";
    }
    
    @Override
    void read(final DataInput lllllllllllllllllIIIlllIIlllIIlI, final int lllllllllllllllllIIIlllIIllllIII, final NBTSizeTracker lllllllllllllllllIIIlllIIlllIIII) throws IOException {
        this.data = lllllllllllllllllIIIlllIIlllIIlI.readUTF();
        lllllllllllllllllIIIlllIIlllIIII.read(16 * this.data.length());
    }
    
    @Override
    void write(final DataOutput lllllllllllllllllIIIlllIlIIIIllI) throws IOException {
        lllllllllllllllllIIIlllIlIIIIllI.writeUTF(this.data);
    }
    
    @Override
    public NBTBase copy() {
        return new NBTTagString(this.data);
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("\"").append(this.data.replace("\"", "\\\"")).append("\""));
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ this.data.hashCode();
    }
    
    @Override
    public boolean hasNoTags() {
        return this.data.isEmpty();
    }
    
    static {
        __OBFID = "CL_00001228";
    }
    
    public String getString() {
        return this.data;
    }
}
