package net.minecraft.client.audio;

import net.minecraft.util.*;

public abstract class MovingSound extends PositionedSound implements ITickableSound
{
    protected /* synthetic */ boolean donePlaying;
    
    protected MovingSound(final ResourceLocation lllllllllllllllllllIlIllllIlIlll) {
        super(lllllllllllllllllllIlIllllIlIlll);
        this.donePlaying = false;
    }
    
    @Override
    public boolean isDonePlaying() {
        return this.donePlaying;
    }
    
    static {
        __OBFID = "CL_00001117";
    }
}
