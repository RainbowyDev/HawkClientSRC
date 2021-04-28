package net.minecraft.client.audio;

import net.minecraft.entity.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;

public class MovingSoundMinecartRiding extends MovingSound
{
    private final /* synthetic */ EntityMinecart minecart;
    private final /* synthetic */ EntityPlayer player;
    
    @Override
    public void update() {
        if (!this.minecart.isDead && this.player.isRiding() && this.player.ridingEntity == this.minecart) {
            final float lIlllIlIIIlIII = MathHelper.sqrt_double(this.minecart.motionX * this.minecart.motionX + this.minecart.motionZ * this.minecart.motionZ);
            if (lIlllIlIIIlIII >= 0.01) {
                this.volume = 0.0f + MathHelper.clamp_float(lIlllIlIIIlIII, 0.0f, 1.0f) * 0.75f;
            }
            else {
                this.volume = 0.0f;
            }
        }
        else {
            this.donePlaying = true;
        }
    }
    
    public MovingSoundMinecartRiding(final EntityPlayer lIlllIlIIIllIl, final EntityMinecart lIlllIlIIIllll) {
        super(new ResourceLocation("minecraft:minecart.inside"));
        this.player = lIlllIlIIIllIl;
        this.minecart = lIlllIlIIIllll;
        this.attenuationType = ISound.AttenuationType.NONE;
        this.repeat = true;
        this.repeatDelay = 0;
    }
    
    static {
        __OBFID = "CL_00001119";
    }
}
