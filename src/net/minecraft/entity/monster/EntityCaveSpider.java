package net.minecraft.entity.monster;

import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.potion.*;

public class EntityCaveSpider extends EntitySpider
{
    @Override
    public IEntityLivingData func_180482_a(final DifficultyInstance lllIlIIIIIIIllI, final IEntityLivingData lllIlIIIIIIIlIl) {
        return lllIlIIIIIIIlIl;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(12.0);
    }
    
    @Override
    public float getEyeHeight() {
        return 0.45f;
    }
    
    public EntityCaveSpider(final World lllIlIIIIIlIlll) {
        super(lllIlIIIIIlIlll);
        this.setSize(0.7f, 0.5f);
    }
    
    @Override
    public boolean attackEntityAsMob(final Entity lllIlIIIIIIlIlI) {
        if (super.attackEntityAsMob(lllIlIIIIIIlIlI)) {
            if (lllIlIIIIIIlIlI instanceof EntityLivingBase) {
                byte lllIlIIIIIIllII = 0;
                if (this.worldObj.getDifficulty() == EnumDifficulty.NORMAL) {
                    lllIlIIIIIIllII = 7;
                }
                else if (this.worldObj.getDifficulty() == EnumDifficulty.HARD) {
                    lllIlIIIIIIllII = 15;
                }
                if (lllIlIIIIIIllII > 0) {
                    ((EntityLivingBase)lllIlIIIIIIlIlI).addPotionEffect(new PotionEffect(Potion.poison.id, lllIlIIIIIIllII * 20, 0));
                }
            }
            return true;
        }
        return false;
    }
    
    static {
        __OBFID = "CL_00001683";
    }
}
