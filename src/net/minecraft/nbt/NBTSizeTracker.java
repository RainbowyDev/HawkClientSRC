package net.minecraft.nbt;

public class NBTSizeTracker
{
    private /* synthetic */ long read;
    private final /* synthetic */ long max;
    
    static {
        __OBFID = "CL_00001903";
        INFINITE = new NBTSizeTracker() {
            static {
                __OBFID = "CL_00001902";
            }
            
            @Override
            public void read(final long lllllllllllllllIlllIIlIIIlIlIllI) {
            }
        };
    }
    
    public void read(final long llllllllllllllIIlIllIllIllIlllll) {
        this.read += llllllllllllllIIlIllIllIllIlllll / 8L;
        if (this.read > this.max) {
            throw new RuntimeException(String.valueOf(new StringBuilder("Tried to read NBT tag that was too big; tried to allocate: ").append(this.read).append("bytes where max allowed: ").append(this.max)));
        }
    }
    
    public NBTSizeTracker(final long llllllllllllllIIlIllIllIlllIIIll) {
        this.max = llllllllllllllIIlIllIllIlllIIIll;
    }
}
