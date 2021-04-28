package net.minecraft.world.chunk;

public class NibbleArray
{
    private final /* synthetic */ byte[] data;
    
    public void setIndex(final int lllllllllllllllIlIllIIlIlIlIIIIl, final int lllllllllllllllIlIllIIlIlIlIIIII) {
        final int lllllllllllllllIlIllIIlIlIIlllll = this.func_177478_c(lllllllllllllllIlIllIIlIlIlIIIIl);
        if (this.func_177479_b(lllllllllllllllIlIllIIlIlIlIIIIl)) {
            this.data[lllllllllllllllIlIllIIlIlIIlllll] = (byte)((this.data[lllllllllllllllIlIllIIlIlIIlllll] & 0xF0) | (lllllllllllllllIlIllIIlIlIlIIIII & 0xF));
        }
        else {
            this.data[lllllllllllllllIlIllIIlIlIIlllll] = (byte)((this.data[lllllllllllllllIlIllIIlIlIIlllll] & 0xF) | (lllllllllllllllIlIllIIlIlIlIIIII & 0xF) << 4);
        }
    }
    
    public int getFromIndex(final int lllllllllllllllIlIllIIlIlIlIlIII) {
        final int lllllllllllllllIlIllIIlIlIlIlIlI = this.func_177478_c(lllllllllllllllIlIllIIlIlIlIlIII);
        return this.func_177479_b(lllllllllllllllIlIllIIlIlIlIlIII) ? (this.data[lllllllllllllllIlIllIIlIlIlIlIlI] & 0xF) : (this.data[lllllllllllllllIlIllIIlIlIlIlIlI] >> 4 & 0xF);
    }
    
    public NibbleArray(final byte[] lllllllllllllllIlIllIIlIllIlIlIl) {
        this.data = lllllllllllllllIlIllIIlIllIlIlIl;
        if (lllllllllllllllIlIllIIlIllIlIlIl.length != 2048) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("ChunkNibbleArrays should be 2048 bytes not: ").append(lllllllllllllllIlIllIIlIllIlIlIl.length)));
        }
    }
    
    static {
        __OBFID = "CL_00000371";
    }
    
    private boolean func_177479_b(final int lllllllllllllllIlIllIIlIlIIlIlll) {
        return (lllllllllllllllIlIllIIlIlIIlIlll & 0x1) == 0x0;
    }
    
    public void set(final int lllllllllllllllIlIllIIlIlIllllIl, final int lllllllllllllllIlIllIIlIlIllllII, final int lllllllllllllllIlIllIIlIllIIIIII, final int lllllllllllllllIlIllIIlIlIlllIlI) {
        this.setIndex(this.getCoordinateIndex(lllllllllllllllIlIllIIlIlIllllIl, lllllllllllllllIlIllIIlIlIllllII, lllllllllllllllIlIllIIlIllIIIIII), lllllllllllllllIlIllIIlIlIlllIlI);
    }
    
    private int getCoordinateIndex(final int lllllllllllllllIlIllIIlIlIllIIlI, final int lllllllllllllllIlIllIIlIlIllIlII, final int lllllllllllllllIlIllIIlIlIllIIII) {
        return lllllllllllllllIlIllIIlIlIllIlII << 8 | lllllllllllllllIlIllIIlIlIllIIII << 4 | lllllllllllllllIlIllIIlIlIllIIlI;
    }
    
    public int get(final int lllllllllllllllIlIllIIlIllIIllll, final int lllllllllllllllIlIllIIlIllIIlllI, final int lllllllllllllllIlIllIIlIllIIlIIl) {
        return this.getFromIndex(this.getCoordinateIndex(lllllllllllllllIlIllIIlIllIIllll, lllllllllllllllIlIllIIlIllIIlllI, lllllllllllllllIlIllIIlIllIIlIIl));
    }
    
    public NibbleArray() {
        this.data = new byte[2048];
    }
    
    private int func_177478_c(final int lllllllllllllllIlIllIIlIlIIlIlII) {
        return lllllllllllllllIlIllIIlIlIIlIlII >> 1;
    }
    
    public byte[] getData() {
        return this.data;
    }
}
