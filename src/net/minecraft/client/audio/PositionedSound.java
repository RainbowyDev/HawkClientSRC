package net.minecraft.client.audio;

import net.minecraft.util.*;

public abstract class PositionedSound implements ISound
{
    protected /* synthetic */ float pitch;
    protected /* synthetic */ boolean repeat;
    protected /* synthetic */ int repeatDelay;
    protected /* synthetic */ float zPosF;
    protected /* synthetic */ float xPosF;
    protected /* synthetic */ AttenuationType attenuationType;
    protected /* synthetic */ float yPosF;
    protected /* synthetic */ float volume;
    protected final /* synthetic */ ResourceLocation positionedSoundLocation;
    
    @Override
    public int getRepeatDelay() {
        return this.repeatDelay;
    }
    
    @Override
    public float getVolume() {
        return this.volume;
    }
    
    @Override
    public float getPitch() {
        return this.pitch;
    }
    
    @Override
    public ResourceLocation getSoundLocation() {
        return this.positionedSoundLocation;
    }
    
    @Override
    public float getZPosF() {
        return this.zPosF;
    }
    
    @Override
    public boolean canRepeat() {
        return this.repeat;
    }
    
    protected PositionedSound(final ResourceLocation lllllllllllllllIlIIIlIIlllllIIIl) {
        this.volume = 1.0f;
        this.pitch = 1.0f;
        this.repeat = false;
        this.repeatDelay = 0;
        this.attenuationType = AttenuationType.LINEAR;
        this.positionedSoundLocation = lllllllllllllllIlIIIlIIlllllIIIl;
    }
    
    @Override
    public float getYPosF() {
        return this.yPosF;
    }
    
    @Override
    public AttenuationType getAttenuationType() {
        return this.attenuationType;
    }
    
    @Override
    public float getXPosF() {
        return this.xPosF;
    }
    
    static {
        __OBFID = "CL_00001116";
    }
}
