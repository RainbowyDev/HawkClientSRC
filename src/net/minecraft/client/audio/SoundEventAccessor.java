package net.minecraft.client.audio;

public class SoundEventAccessor implements ISoundEventAccessor
{
    private final /* synthetic */ SoundPoolEntry entry;
    private final /* synthetic */ int weight;
    
    @Override
    public SoundPoolEntry cloneEntry() {
        return new SoundPoolEntry(this.entry);
    }
    
    static {
        __OBFID = "CL_00001153";
    }
    
    SoundEventAccessor(final SoundPoolEntry llllllllllllllIIIIIIlIIIllIIllIl, final int llllllllllllllIIIIIIlIIIllIIllII) {
        this.entry = llllllllllllllIIIIIIlIIIllIIllIl;
        this.weight = llllllllllllllIIIIIIlIIIllIIllII;
    }
    
    @Override
    public int getWeight() {
        return this.weight;
    }
    
    public Object cloneEntry1() {
        return this.cloneEntry();
    }
}
