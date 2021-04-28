package net.minecraft.potion;

import net.minecraft.entity.*;
import net.minecraft.nbt.*;
import org.apache.logging.log4j.*;

public class PotionEffect
{
    private /* synthetic */ boolean isSplashPotion;
    private /* synthetic */ int amplifier;
    private /* synthetic */ boolean isPotionDurationMax;
    private /* synthetic */ boolean showParticles;
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ int potionID;
    private /* synthetic */ int duration;
    private /* synthetic */ boolean isAmbient;
    
    @Override
    public String toString() {
        String llllllllllllllIllIIlIllIlIIIIlII = "";
        if (this.getAmplifier() > 0) {
            llllllllllllllIllIIlIllIlIIIIlII = String.valueOf(new StringBuilder(String.valueOf(this.getEffectName())).append(" x ").append(this.getAmplifier() + 1).append(", Duration: ").append(this.getDuration()));
        }
        else {
            llllllllllllllIllIIlIllIlIIIIlII = String.valueOf(new StringBuilder(String.valueOf(this.getEffectName())).append(", Duration: ").append(this.getDuration()));
        }
        if (this.isSplashPotion) {
            llllllllllllllIllIIlIllIlIIIIlII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIIlIllIlIIIIlII)).append(", Splash: true"));
        }
        if (!this.showParticles) {
            llllllllllllllIllIIlIllIlIIIIlII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIIlIllIlIIIIlII)).append(", Particles: false"));
        }
        return Potion.potionTypes[this.potionID].isUsable() ? String.valueOf(new StringBuilder("(").append(llllllllllllllIllIIlIllIlIIIIlII).append(")")) : llllllllllllllIllIIlIllIlIIIIlII;
    }
    
    public PotionEffect(final int llllllllllllllIllIIlIllIllIlIllI, final int llllllllllllllIllIIlIllIllIlIlIl, final int llllllllllllllIllIIlIllIllIlIlII) {
        this(llllllllllllllIllIIlIllIllIlIllI, llllllllllllllIllIIlIllIllIlIlIl, llllllllllllllIllIIlIllIllIlIlII, false, true);
    }
    
    @Override
    public int hashCode() {
        return this.potionID;
    }
    
    public void performEffect(final EntityLivingBase llllllllllllllIllIIlIllIlIIIlllI) {
        if (this.duration > 0) {
            Potion.potionTypes[this.potionID].performEffect(llllllllllllllIllIIlIllIlIIIlllI, this.amplifier);
        }
    }
    
    public PotionEffect(final PotionEffect llllllllllllllIllIIlIllIlIlllIlI) {
        this.potionID = llllllllllllllIllIIlIllIlIlllIlI.potionID;
        this.duration = llllllllllllllIllIIlIllIlIlllIlI.duration;
        this.amplifier = llllllllllllllIllIIlIllIlIlllIlI.amplifier;
        this.isAmbient = llllllllllllllIllIIlIllIlIlllIlI.isAmbient;
        this.showParticles = llllllllllllllIllIIlIllIlIlllIlI.showParticles;
    }
    
    public int getDuration() {
        return this.duration;
    }
    
    public static PotionEffect readCustomPotionEffectFromNBT(final NBTTagCompound llllllllllllllIllIIlIllIIllIIllI) {
        final byte llllllllllllllIllIIlIllIIllIlIll = llllllllllllllIllIIlIllIIllIIllI.getByte("Id");
        if (llllllllllllllIllIIlIllIIllIlIll >= 0 && llllllllllllllIllIIlIllIIllIlIll < Potion.potionTypes.length && Potion.potionTypes[llllllllllllllIllIIlIllIIllIlIll] != null) {
            final byte llllllllllllllIllIIlIllIIllIlIlI = llllllllllllllIllIIlIllIIllIIllI.getByte("Amplifier");
            final int llllllllllllllIllIIlIllIIllIlIIl = llllllllllllllIllIIlIllIIllIIllI.getInteger("Duration");
            final boolean llllllllllllllIllIIlIllIIllIlIII = llllllllllllllIllIIlIllIIllIIllI.getBoolean("Ambient");
            boolean llllllllllllllIllIIlIllIIllIIlll = true;
            if (llllllllllllllIllIIlIllIIllIIllI.hasKey("ShowParticles", 1)) {
                llllllllllllllIllIIlIllIIllIIlll = llllllllllllllIllIIlIllIIllIIllI.getBoolean("ShowParticles");
            }
            return new PotionEffect(llllllllllllllIllIIlIllIIllIlIll, llllllllllllllIllIIlIllIIllIlIIl, llllllllllllllIllIIlIllIIllIlIlI, llllllllllllllIllIIlIllIIllIlIII, llllllllllllllIllIIlIllIIllIIlll);
        }
        return null;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIllIIlIllIIlllllIl) {
        if (!(llllllllllllllIllIIlIllIIlllllIl instanceof PotionEffect)) {
            return false;
        }
        final PotionEffect llllllllllllllIllIIlIllIIlllllII = (PotionEffect)llllllllllllllIllIIlIllIIlllllIl;
        return this.potionID == llllllllllllllIllIIlIllIIlllllII.potionID && this.amplifier == llllllllllllllIllIIlIllIIlllllII.amplifier && this.duration == llllllllllllllIllIIlIllIIlllllII.duration && this.isSplashPotion == llllllllllllllIllIIlIllIIlllllII.isSplashPotion && this.isAmbient == llllllllllllllIllIIlIllIIlllllII.isAmbient;
    }
    
    public int getPotionID() {
        return this.potionID;
    }
    
    static {
        __OBFID = "CL_00001529";
        LOGGER = LogManager.getLogger();
    }
    
    public void setPotionDurationMax(final boolean llllllllllllllIllIIlIllIIlIlllIl) {
        this.isPotionDurationMax = llllllllllllllIllIIlIllIIlIlllIl;
    }
    
    public PotionEffect(final int llllllllllllllIllIIlIllIllIlllIl, final int llllllllllllllIllIIlIllIllIlllII) {
        this(llllllllllllllIllIIlIllIllIlllIl, llllllllllllllIllIIlIllIllIlllII, 0);
    }
    
    public void combine(final PotionEffect llllllllllllllIllIIlIllIlIllIlII) {
        if (this.potionID != llllllllllllllIllIIlIllIlIllIlII.potionID) {
            PotionEffect.LOGGER.warn("This method should only be called for matching effects!");
        }
        if (llllllllllllllIllIIlIllIlIllIlII.amplifier > this.amplifier) {
            this.amplifier = llllllllllllllIllIIlIllIlIllIlII.amplifier;
            this.duration = llllllllllllllIllIIlIllIlIllIlII.duration;
        }
        else if (llllllllllllllIllIIlIllIlIllIlII.amplifier == this.amplifier && this.duration < llllllllllllllIllIIlIllIlIllIlII.duration) {
            this.duration = llllllllllllllIllIIlIllIlIllIlII.duration;
        }
        else if (!llllllllllllllIllIIlIllIlIllIlII.isAmbient && this.isAmbient) {
            this.isAmbient = llllllllllllllIllIIlIllIlIllIlII.isAmbient;
        }
        this.showParticles = llllllllllllllIllIIlIllIlIllIlII.showParticles;
    }
    
    public boolean getIsPotionDurationMax() {
        return this.isPotionDurationMax;
    }
    
    private int deincrementDuration() {
        final int duration = this.duration - 1;
        this.duration = duration;
        return duration;
    }
    
    public String getEffectName() {
        return Potion.potionTypes[this.potionID].getName();
    }
    
    public NBTTagCompound writeCustomPotionEffectToNBT(final NBTTagCompound llllllllllllllIllIIlIllIIlllIlIl) {
        llllllllllllllIllIIlIllIIlllIlIl.setByte("Id", (byte)this.getPotionID());
        llllllllllllllIllIIlIllIIlllIlIl.setByte("Amplifier", (byte)this.getAmplifier());
        llllllllllllllIllIIlIllIIlllIlIl.setInteger("Duration", this.getDuration());
        llllllllllllllIllIIlIllIIlllIlIl.setBoolean("Ambient", this.getIsAmbient());
        llllllllllllllIllIIlIllIIlllIlIl.setBoolean("ShowParticles", this.func_180154_f());
        return llllllllllllllIllIIlIllIIlllIlIl;
    }
    
    public int getAmplifier() {
        return this.amplifier;
    }
    
    public boolean getIsAmbient() {
        return this.isAmbient;
    }
    
    public boolean func_180154_f() {
        return this.showParticles;
    }
    
    public PotionEffect(final int llllllllllllllIllIIlIllIllIIlIII, final int llllllllllllllIllIIlIllIllIIIlll, final int llllllllllllllIllIIlIllIllIIIIII, final boolean llllllllllllllIllIIlIllIllIIIlIl, final boolean llllllllllllllIllIIlIllIllIIIlII) {
        this.potionID = llllllllllllllIllIIlIllIllIIlIII;
        this.duration = llllllllllllllIllIIlIllIllIIIlll;
        this.amplifier = llllllllllllllIllIIlIllIllIIIIII;
        this.isAmbient = llllllllllllllIllIIlIllIllIIIlIl;
        this.showParticles = llllllllllllllIllIIlIllIllIIIlII;
    }
    
    public boolean onUpdate(final EntityLivingBase llllllllllllllIllIIlIllIlIIlIlll) {
        if (this.duration > 0) {
            if (Potion.potionTypes[this.potionID].isReady(this.duration, this.amplifier)) {
                this.performEffect(llllllllllllllIllIIlIllIlIIlIlll);
            }
            this.deincrementDuration();
        }
        return this.duration > 0;
    }
    
    public void setSplashPotion(final boolean llllllllllllllIllIIlIllIlIlIIIll) {
        this.isSplashPotion = llllllllllllllIllIIlIllIlIlIIIll;
    }
}
