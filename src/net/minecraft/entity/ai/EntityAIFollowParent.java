package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import java.util.*;

public class EntityAIFollowParent extends EntityAIBase
{
    private /* synthetic */ int field_75345_d;
    /* synthetic */ double field_75347_c;
    /* synthetic */ EntityAnimal childAnimal;
    /* synthetic */ EntityAnimal parentAnimal;
    
    @Override
    public void resetTask() {
        this.parentAnimal = null;
    }
    
    public EntityAIFollowParent(final EntityAnimal llllllllllllllIlIlIIlIIlIIIIllll, final double llllllllllllllIlIlIIlIIlIIIIlIll) {
        this.childAnimal = llllllllllllllIlIlIIlIIlIIIIllll;
        this.field_75347_c = llllllllllllllIlIlIIlIIlIIIIlIll;
    }
    
    @Override
    public void updateTask() {
        final int field_75345_d = this.field_75345_d - 1;
        this.field_75345_d = field_75345_d;
        if (field_75345_d <= 0) {
            this.field_75345_d = 10;
            this.childAnimal.getNavigator().tryMoveToEntityLiving(this.parentAnimal, this.field_75347_c);
        }
    }
    
    @Override
    public boolean continueExecuting() {
        if (this.childAnimal.getGrowingAge() >= 0) {
            return false;
        }
        if (!this.parentAnimal.isEntityAlive()) {
            return false;
        }
        final double llllllllllllllIlIlIIlIIIllllIIlI = this.childAnimal.getDistanceSqToEntity(this.parentAnimal);
        return llllllllllllllIlIlIIlIIIllllIIlI >= 9.0 && llllllllllllllIlIlIIlIIIllllIIlI <= 256.0;
    }
    
    static {
        __OBFID = "CL_00001586";
    }
    
    @Override
    public boolean shouldExecute() {
        if (this.childAnimal.getGrowingAge() >= 0) {
            return false;
        }
        final List llllllllllllllIlIlIIlIIlIIIIIIlI = this.childAnimal.worldObj.getEntitiesWithinAABB(this.childAnimal.getClass(), this.childAnimal.getEntityBoundingBox().expand(8.0, 4.0, 8.0));
        EntityAnimal llllllllllllllIlIlIIlIIlIIIIIIIl = null;
        double llllllllllllllIlIlIIlIIlIIIIIIII = Double.MAX_VALUE;
        for (final EntityAnimal llllllllllllllIlIlIIlIIIlllllllI : llllllllllllllIlIlIIlIIlIIIIIIlI) {
            if (llllllllllllllIlIlIIlIIIlllllllI.getGrowingAge() >= 0) {
                final double llllllllllllllIlIlIIlIIIllllllIl = this.childAnimal.getDistanceSqToEntity(llllllllllllllIlIlIIlIIIlllllllI);
                if (llllllllllllllIlIlIIlIIIllllllIl > llllllllllllllIlIlIIlIIlIIIIIIII) {
                    continue;
                }
                llllllllllllllIlIlIIlIIlIIIIIIII = llllllllllllllIlIlIIlIIIllllllIl;
                llllllllllllllIlIlIIlIIlIIIIIIIl = llllllllllllllIlIlIIlIIIlllllllI;
            }
        }
        if (llllllllllllllIlIlIIlIIlIIIIIIIl == null) {
            return false;
        }
        if (llllllllllllllIlIlIIlIIlIIIIIIII < 9.0) {
            return false;
        }
        this.parentAnimal = llllllllllllllIlIlIIlIIlIIIIIIIl;
        return true;
    }
    
    @Override
    public void startExecuting() {
        this.field_75345_d = 0;
    }
}
