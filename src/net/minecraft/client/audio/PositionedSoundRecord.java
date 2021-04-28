package net.minecraft.client.audio;

import net.minecraft.util.*;

public class PositionedSoundRecord extends PositionedSound
{
    public static PositionedSoundRecord createPositionedSoundRecord(final ResourceLocation llllllllllllllllllIlIIlIllllllIl, final float llllllllllllllllllIlIIlIlllllIlI) {
        return new PositionedSoundRecord(llllllllllllllllllIlIIlIllllllIl, 0.25f, llllllllllllllllllIlIIlIlllllIlI, false, 0, ISound.AttenuationType.NONE, 0.0f, 0.0f, 0.0f);
    }
    
    public static PositionedSoundRecord createRecordSoundAtPosition(final ResourceLocation llllllllllllllllllIlIIlIllllIIlI, final float llllllllllllllllllIlIIlIlllIllIl, final float llllllllllllllllllIlIIlIlllIllII, final float llllllllllllllllllIlIIlIlllIllll) {
        return new PositionedSoundRecord(llllllllllllllllllIlIIlIllllIIlI, 4.0f, 1.0f, false, 0, ISound.AttenuationType.LINEAR, llllllllllllllllllIlIIlIlllIllIl, llllllllllllllllllIlIIlIlllIllII, llllllllllllllllllIlIIlIlllIllll);
    }
    
    private PositionedSoundRecord(final ResourceLocation llllllllllllllllllIlIIlIllIIIIII, final float llllllllllllllllllIlIIlIlIllllll, final float llllllllllllllllllIlIIlIlIlllllI, final boolean llllllllllllllllllIlIIlIlIllllIl, final int llllllllllllllllllIlIIlIlIllllII, final ISound.AttenuationType llllllllllllllllllIlIIlIlIlllIll, final float llllllllllllllllllIlIIlIllIIIlII, final float llllllllllllllllllIlIIlIllIIIIll, final float llllllllllllllllllIlIIlIlIlllIII) {
        super(llllllllllllllllllIlIIlIllIIIIII);
        this.volume = llllllllllllllllllIlIIlIlIllllll;
        this.pitch = llllllllllllllllllIlIIlIlIlllllI;
        this.xPosF = llllllllllllllllllIlIIlIllIIIlII;
        this.yPosF = llllllllllllllllllIlIIlIllIIIIll;
        this.zPosF = llllllllllllllllllIlIIlIlIlllIII;
        this.repeat = llllllllllllllllllIlIIlIlIllllIl;
        this.repeatDelay = llllllllllllllllllIlIIlIlIllllII;
        this.attenuationType = llllllllllllllllllIlIIlIlIlllIll;
    }
    
    static {
        __OBFID = "CL_00001120";
    }
    
    public static PositionedSoundRecord createPositionedSoundRecord(final ResourceLocation llllllllllllllllllIlIIlIllllIlll) {
        return new PositionedSoundRecord(llllllllllllllllllIlIIlIllllIlll, 1.0f, 1.0f, false, 0, ISound.AttenuationType.NONE, 0.0f, 0.0f, 0.0f);
    }
    
    public PositionedSoundRecord(final ResourceLocation llllllllllllllllllIlIIlIlllIIIlI, final float llllllllllllllllllIlIIlIllIllIlI, final float llllllllllllllllllIlIIlIlllIIIII, final float llllllllllllllllllIlIIlIllIllIII, final float llllllllllllllllllIlIIlIllIllllI, final float llllllllllllllllllIlIIlIllIlllIl) {
        this(llllllllllllllllllIlIIlIlllIIIlI, llllllllllllllllllIlIIlIllIllIlI, llllllllllllllllllIlIIlIlllIIIII, false, 0, ISound.AttenuationType.LINEAR, llllllllllllllllllIlIIlIllIllIII, llllllllllllllllllIlIIlIllIllllI, llllllllllllllllllIlIIlIllIlllIl);
    }
}
