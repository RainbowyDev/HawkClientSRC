package net.minecraft.client.resources.data;

public class AnimationFrame
{
    private final /* synthetic */ int frameTime;
    private final /* synthetic */ int frameIndex;
    
    public AnimationFrame(final int lllllllllllllllllllIllIIIIllIIll, final int lllllllllllllllllllIllIIIIllIIlI) {
        this.frameIndex = lllllllllllllllllllIllIIIIllIIll;
        this.frameTime = lllllllllllllllllllIllIIIIllIIlI;
    }
    
    public int getFrameIndex() {
        return this.frameIndex;
    }
    
    public int getFrameTime() {
        return this.frameTime;
    }
    
    public AnimationFrame(final int lllllllllllllllllllIllIIIIlllIII) {
        this(lllllllllllllllllllIllIIIIlllIII, -1);
    }
    
    public boolean hasNoTime() {
        return this.frameTime == -1;
    }
    
    static {
        __OBFID = "CL_00001104";
    }
}
