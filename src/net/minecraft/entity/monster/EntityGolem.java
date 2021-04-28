package net.minecraft.entity.monster;

import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.world.*;

public abstract class EntityGolem extends EntityCreature implements IAnimals
{
    @Override
    protected String getHurtSound() {
        return "none";
    }
    
    static {
        __OBFID = "CL_00001644";
    }
    
    public EntityGolem(final World llllllllllllllIIlIllIlllIIIllIlI) {
        super(llllllllllllllIIlIllIlllIIIllIlI);
    }
    
    @Override
    protected String getLivingSound() {
        return "none";
    }
    
    @Override
    protected String getDeathSound() {
        return "none";
    }
    
    @Override
    protected boolean canDespawn() {
        return false;
    }
    
    @Override
    public int getTalkInterval() {
        return 120;
    }
    
    @Override
    public void fall(final float llllllllllllllIIlIllIlllIIIllIII, final float llllllllllllllIIlIllIlllIIIlIlll) {
    }
}
