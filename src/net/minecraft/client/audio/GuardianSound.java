package net.minecraft.client.audio;

import net.minecraft.entity.monster.*;
import net.minecraft.util.*;

public class GuardianSound extends MovingSound
{
    private final /* synthetic */ EntityGuardian guardian;
    
    @Override
    public void update() {
        if (!this.guardian.isDead && this.guardian.func_175474_cn()) {
            this.xPosF = (float)this.guardian.posX;
            this.yPosF = (float)this.guardian.posY;
            this.zPosF = (float)this.guardian.posZ;
            final float llllllllllllllllIllIIIIIlIIIIlll = this.guardian.func_175477_p(0.0f);
            this.volume = 0.0f + 1.0f * llllllllllllllllIllIIIIIlIIIIlll * llllllllllllllllIllIIIIIlIIIIlll;
            this.pitch = 0.7f + 0.5f * llllllllllllllllIllIIIIIlIIIIlll;
        }
        else {
            this.donePlaying = true;
        }
    }
    
    public GuardianSound(final EntityGuardian llllllllllllllllIllIIIIIlIIIllIl) {
        super(new ResourceLocation("minecraft:mob.guardian.attack"));
        this.guardian = llllllllllllllllIllIIIIIlIIIllIl;
        this.attenuationType = ISound.AttenuationType.NONE;
        this.repeat = true;
        this.repeatDelay = 0;
    }
    
    static {
        __OBFID = "CL_00002381";
    }
}
