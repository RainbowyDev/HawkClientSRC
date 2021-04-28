package net.minecraft.world.chunk.storage;

public class NibbleArrayReader
{
    private final /* synthetic */ int depthBitsPlusFour;
    public final /* synthetic */ byte[] data;
    private final /* synthetic */ int depthBits;
    
    public NibbleArrayReader(final byte[] llllllllllllllIIIlIIlIIllIlllllI, final int llllllllllllllIIIlIIlIIllIllllIl) {
        this.data = llllllllllllllIIIlIIlIIllIlllllI;
        this.depthBits = llllllllllllllIIIlIIlIIllIllllIl;
        this.depthBitsPlusFour = llllllllllllllIIIlIIlIIllIllllIl + 4;
    }
    
    static {
        __OBFID = "CL_00000376";
    }
    
    public int get(final int llllllllllllllIIIlIIlIIllIlIlIlI, final int llllllllllllllIIIlIIlIIllIllIIII, final int llllllllllllllIIIlIIlIIllIlIllll) {
        final int llllllllllllllIIIlIIlIIllIlIlllI = llllllllllllllIIIlIIlIIllIlIlIlI << this.depthBitsPlusFour | llllllllllllllIIIlIIlIIllIlIllll << this.depthBits | llllllllllllllIIIlIIlIIllIllIIII;
        final int llllllllllllllIIIlIIlIIllIlIllIl = llllllllllllllIIIlIIlIIllIlIlllI >> 1;
        final int llllllllllllllIIIlIIlIIllIlIllII = llllllllllllllIIIlIIlIIllIlIlllI & 0x1;
        return (llllllllllllllIIIlIIlIIllIlIllII == 0) ? (this.data[llllllllllllllIIIlIIlIIllIlIllIl] & 0xF) : (this.data[llllllllllllllIIIlIIlIIllIlIllIl] >> 4 & 0xF);
    }
}
