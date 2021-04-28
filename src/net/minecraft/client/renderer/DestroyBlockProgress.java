package net.minecraft.client.renderer;

import net.minecraft.util.*;

public class DestroyBlockProgress
{
    private /* synthetic */ int partialBlockProgress;
    private final /* synthetic */ int miningPlayerEntId;
    private /* synthetic */ int createdAtCloudUpdateTick;
    private final /* synthetic */ BlockPos field_180247_b;
    
    public int getCreationCloudUpdateTick() {
        return this.createdAtCloudUpdateTick;
    }
    
    public void setPartialBlockDamage(int llllllllllllllIIIlIIIIIIIllllIlI) {
        if (llllllllllllllIIIlIIIIIIIllllIlI > 10) {
            llllllllllllllIIIlIIIIIIIllllIlI = 10;
        }
        this.partialBlockProgress = llllllllllllllIIIlIIIIIIIllllIlI;
    }
    
    public void setCloudUpdateTick(final int llllllllllllllIIIlIIIIIIIlllIIll) {
        this.createdAtCloudUpdateTick = llllllllllllllIIIlIIIIIIIlllIIll;
    }
    
    public DestroyBlockProgress(final int llllllllllllllIIIlIIIIIIlIIIIlII, final BlockPos llllllllllllllIIIlIIIIIIlIIIIllI) {
        this.miningPlayerEntId = llllllllllllllIIIlIIIIIIlIIIIlII;
        this.field_180247_b = llllllllllllllIIIlIIIIIIlIIIIllI;
    }
    
    static {
        __OBFID = "CL_00001427";
    }
    
    public BlockPos func_180246_b() {
        return this.field_180247_b;
    }
    
    public int getPartialBlockDamage() {
        return this.partialBlockProgress;
    }
}
