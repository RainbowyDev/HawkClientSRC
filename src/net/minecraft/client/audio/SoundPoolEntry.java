package net.minecraft.client.audio;

import net.minecraft.util.*;

public class SoundPoolEntry
{
    private /* synthetic */ double field_148655_c;
    private final /* synthetic */ boolean field_148654_b;
    private /* synthetic */ double field_148653_d;
    private final /* synthetic */ ResourceLocation field_148656_a;
    
    public void setVolume(final double lIIIIlIllllllII) {
        this.field_148653_d = lIIIIlIllllllII;
    }
    
    public double getPitch() {
        return this.field_148655_c;
    }
    
    static {
        __OBFID = "CL_00001140";
    }
    
    public SoundPoolEntry(final ResourceLocation lIIIIllIIIllIlI, final double lIIIIllIIIllIIl, final double lIIIIllIIIllIII, final boolean lIIIIllIIIlllII) {
        this.field_148656_a = lIIIIllIIIllIlI;
        this.field_148655_c = lIIIIllIIIllIIl;
        this.field_148653_d = lIIIIllIIIllIII;
        this.field_148654_b = lIIIIllIIIlllII;
    }
    
    public boolean isStreamingSound() {
        return this.field_148654_b;
    }
    
    public void setPitch(final double lIIIIllIIIIIlIl) {
        this.field_148655_c = lIIIIllIIIIIlIl;
    }
    
    public double getVolume() {
        return this.field_148653_d;
    }
    
    public ResourceLocation getSoundPoolEntryLocation() {
        return this.field_148656_a;
    }
    
    public SoundPoolEntry(final SoundPoolEntry lIIIIllIIIlIIIl) {
        this.field_148656_a = lIIIIllIIIlIIIl.field_148656_a;
        this.field_148655_c = lIIIIllIIIlIIIl.field_148655_c;
        this.field_148653_d = lIIIIllIIIlIIIl.field_148653_d;
        this.field_148654_b = lIIIIllIIIlIIIl.field_148654_b;
    }
}
