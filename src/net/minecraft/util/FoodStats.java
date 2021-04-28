package net.minecraft.util;

import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;

public class FoodStats
{
    private /* synthetic */ float foodSaturationLevel;
    private /* synthetic */ int prevFoodLevel;
    private /* synthetic */ int foodTimer;
    private /* synthetic */ int foodLevel;
    private /* synthetic */ float foodExhaustionLevel;
    
    public void addExhaustion(final float llllIlIIIIllIII) {
        this.foodExhaustionLevel = Math.min(this.foodExhaustionLevel + llllIlIIIIllIII, 40.0f);
    }
    
    public int getPrevFoodLevel() {
        return this.prevFoodLevel;
    }
    
    public void setFoodSaturationLevel(final float llllIlIIIIIlIIl) {
        this.foodSaturationLevel = llllIlIIIIIlIIl;
    }
    
    public void onUpdate(final EntityPlayer llllIlIIIllIlll) {
        final EnumDifficulty llllIlIIIllIllI = llllIlIIIllIlll.worldObj.getDifficulty();
        this.prevFoodLevel = this.foodLevel;
        if (this.foodExhaustionLevel > 4.0f) {
            this.foodExhaustionLevel -= 4.0f;
            if (this.foodSaturationLevel > 0.0f) {
                this.foodSaturationLevel = Math.max(this.foodSaturationLevel - 1.0f, 0.0f);
            }
            else if (llllIlIIIllIllI != EnumDifficulty.PEACEFUL) {
                this.foodLevel = Math.max(this.foodLevel - 1, 0);
            }
        }
        if (llllIlIIIllIlll.worldObj.getGameRules().getGameRuleBooleanValue("naturalRegeneration") && this.foodLevel >= 18 && llllIlIIIllIlll.shouldHeal()) {
            ++this.foodTimer;
            if (this.foodTimer >= 80) {
                llllIlIIIllIlll.heal(1.0f);
                this.addExhaustion(3.0f);
                this.foodTimer = 0;
            }
        }
        else if (this.foodLevel <= 0) {
            ++this.foodTimer;
            if (this.foodTimer >= 80) {
                if (llllIlIIIllIlll.getHealth() > 10.0f || llllIlIIIllIllI == EnumDifficulty.HARD || (llllIlIIIllIlll.getHealth() > 1.0f && llllIlIIIllIllI == EnumDifficulty.NORMAL)) {
                    llllIlIIIllIlll.attackEntityFrom(DamageSource.starve, 1.0f);
                }
                this.foodTimer = 0;
            }
        }
        else {
            this.foodTimer = 0;
        }
    }
    
    public boolean needFood() {
        return this.foodLevel < 20;
    }
    
    public float getSaturationLevel() {
        return this.foodSaturationLevel;
    }
    
    public void addStats(final ItemFood llllIlIIlIIIIII, final ItemStack llllIlIIIllllll) {
        this.addStats(llllIlIIlIIIIII.getHealAmount(llllIlIIIllllll), llllIlIIlIIIIII.getSaturationModifier(llllIlIIIllllll));
    }
    
    public void writeNBT(final NBTTagCompound llllIlIIIlIlIIl) {
        llllIlIIIlIlIIl.setInteger("foodLevel", this.foodLevel);
        llllIlIIIlIlIIl.setInteger("foodTickTimer", this.foodTimer);
        llllIlIIIlIlIIl.setFloat("foodSaturationLevel", this.foodSaturationLevel);
        llllIlIIIlIlIIl.setFloat("foodExhaustionLevel", this.foodExhaustionLevel);
    }
    
    public void setFoodLevel(final int llllIlIIIIlIIIl) {
        this.foodLevel = llllIlIIIIlIIIl;
    }
    
    public FoodStats() {
        this.foodLevel = 20;
        this.foodSaturationLevel = 5.0f;
        this.prevFoodLevel = 20;
    }
    
    public int getFoodLevel() {
        return this.foodLevel;
    }
    
    public void addStats(final int llllIlIIlIIIllI, final float llllIlIIlIIlIII) {
        this.foodLevel = Math.min(llllIlIIlIIIllI + this.foodLevel, 20);
        this.foodSaturationLevel = Math.min(this.foodSaturationLevel + llllIlIIlIIIllI * llllIlIIlIIlIII * 2.0f, (float)this.foodLevel);
    }
    
    static {
        __OBFID = "CL_00001729";
    }
    
    public void readNBT(final NBTTagCompound llllIlIIIlIllIl) {
        if (llllIlIIIlIllIl.hasKey("foodLevel", 99)) {
            this.foodLevel = llllIlIIIlIllIl.getInteger("foodLevel");
            this.foodTimer = llllIlIIIlIllIl.getInteger("foodTickTimer");
            this.foodSaturationLevel = llllIlIIIlIllIl.getFloat("foodSaturationLevel");
            this.foodExhaustionLevel = llllIlIIIlIllIl.getFloat("foodExhaustionLevel");
        }
    }
}
