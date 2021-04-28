package net.minecraft.entity.monster;

import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class EntityGiantZombie extends EntityMob
{
    static {
        __OBFID = "CL_00001690";
    }
    
    @Override
    public float getEyeHeight() {
        return 10.440001f;
    }
    
    public EntityGiantZombie(final World llllllllllllllIIIIlIlIlIIIlIIIIl) {
        super(llllllllllllllIIIIlIlIlIIIlIIIIl);
        this.setSize(this.width * 6.0f, this.height * 6.0f);
    }
    
    @Override
    public float func_180484_a(final BlockPos llllllllllllllIIIIlIlIlIIIIlIlll) {
        return this.worldObj.getLightBrightness(llllllllllllllIIIIlIlIlIIIIlIlll) - 0.5f;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(50.0);
    }
}
