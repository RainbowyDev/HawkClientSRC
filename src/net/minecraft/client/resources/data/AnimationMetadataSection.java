package net.minecraft.client.resources.data;

import com.google.common.collect.*;
import java.util.*;

public class AnimationMetadataSection implements IMetadataSection
{
    private final /* synthetic */ List animationFrames;
    private final /* synthetic */ int frameHeight;
    private final /* synthetic */ boolean field_177220_e;
    private final /* synthetic */ int frameWidth;
    private final /* synthetic */ int frameTime;
    
    private AnimationFrame getAnimationFrame(final int llllllllllllllllIlIllIllIIIlllIl) {
        return this.animationFrames.get(llllllllllllllllIlIllIllIIIlllIl);
    }
    
    public int getFrameHeight() {
        return this.frameHeight;
    }
    
    public boolean frameHasTime(final int llllllllllllllllIlIllIllIIIIIIII) {
        return !this.animationFrames.get(llllllllllllllllIlIllIllIIIIIIII).hasNoTime();
    }
    
    public boolean func_177219_e() {
        return this.field_177220_e;
    }
    
    public Set getFrameIndexSet() {
        final HashSet llllllllllllllllIlIllIlIlllIllIl = Sets.newHashSet();
        for (final AnimationFrame llllllllllllllllIlIllIlIlllIlIll : this.animationFrames) {
            llllllllllllllllIlIllIlIlllIllIl.add(llllllllllllllllIlIllIlIlllIlIll.getFrameIndex());
        }
        return llllllllllllllllIlIllIlIlllIllIl;
    }
    
    static {
        __OBFID = "CL_00001106";
    }
    
    public AnimationMetadataSection(final List llllllllllllllllIlIllIllIlIIIlII, final int llllllllllllllllIlIllIllIlIIIIll, final int llllllllllllllllIlIllIllIlIIlIll, final int llllllllllllllllIlIllIllIlIIIIIl, final boolean llllllllllllllllIlIllIllIIllllll) {
        this.animationFrames = llllllllllllllllIlIllIllIlIIIlII;
        this.frameWidth = llllllllllllllllIlIllIllIlIIIIll;
        this.frameHeight = llllllllllllllllIlIllIllIlIIlIll;
        this.frameTime = llllllllllllllllIlIllIllIlIIIIIl;
        this.field_177220_e = llllllllllllllllIlIllIllIIllllll;
    }
    
    public int getFrameWidth() {
        return this.frameWidth;
    }
    
    public int getFrameTimeSingle(final int llllllllllllllllIlIllIllIIIIllIl) {
        final AnimationFrame llllllllllllllllIlIllIllIIIIllll = this.getAnimationFrame(llllllllllllllllIlIllIllIIIIllIl);
        return llllllllllllllllIlIllIllIIIIllll.hasNoTime() ? this.frameTime : llllllllllllllllIlIllIllIIIIllll.getFrameTime();
    }
    
    public int getFrameCount() {
        return this.animationFrames.size();
    }
    
    public int getFrameIndex(final int llllllllllllllllIlIllIlIllllIlll) {
        return this.animationFrames.get(llllllllllllllllIlIllIlIllllIlll).getFrameIndex();
    }
    
    public int getFrameTime() {
        return this.frameTime;
    }
}
