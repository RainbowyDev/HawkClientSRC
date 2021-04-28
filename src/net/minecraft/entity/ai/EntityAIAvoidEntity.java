package net.minecraft.entity.ai;

import net.minecraft.entity.*;
import net.minecraft.pathfinding.*;
import net.minecraft.command.*;
import com.google.common.base.*;
import net.minecraft.util.*;
import java.util.*;

public class EntityAIAvoidEntity extends EntityAIBase
{
    private /* synthetic */ float field_179508_f;
    public final /* synthetic */ Predicate field_179509_a;
    private /* synthetic */ Predicate field_179510_i;
    private /* synthetic */ double farSpeed;
    protected /* synthetic */ EntityCreature theEntity;
    protected /* synthetic */ Entity closestLivingEntity;
    private /* synthetic */ PathEntity entityPathEntity;
    private /* synthetic */ PathNavigate entityPathNavigate;
    private /* synthetic */ double nearSpeed;
    
    @Override
    public void startExecuting() {
        this.entityPathNavigate.setPath(this.entityPathEntity, this.farSpeed);
    }
    
    @Override
    public void resetTask() {
        this.closestLivingEntity = null;
    }
    
    public EntityAIAvoidEntity(final EntityCreature lllllllllllllllIlIllIIIllIlIllII, final Predicate lllllllllllllllIlIllIIIllIlIIlIl, final float lllllllllllllllIlIllIIIllIlIIlII, final double lllllllllllllllIlIllIIIllIlIIIll, final double lllllllllllllllIlIllIIIllIlIIIlI) {
        this.field_179509_a = (Predicate)new Predicate() {
            public boolean func_180419_a(final Entity llllllllllllllIlIlllllllIlIIlIll) {
                return llllllllllllllIlIlllllllIlIIlIll.isEntityAlive() && EntityAIAvoidEntity.this.theEntity.getEntitySenses().canSee(llllllllllllllIlIlllllllIlIIlIll);
            }
            
            static {
                __OBFID = "CL_00001575";
            }
            
            public boolean apply(final Object llllllllllllllIlIlllllllIlIIIIll) {
                return this.func_180419_a((Entity)llllllllllllllIlIlllllllIlIIIIll);
            }
        };
        this.theEntity = lllllllllllllllIlIllIIIllIlIllII;
        this.field_179510_i = lllllllllllllllIlIllIIIllIlIIlIl;
        this.field_179508_f = lllllllllllllllIlIllIIIllIlIIlII;
        this.farSpeed = lllllllllllllllIlIllIIIllIlIIIll;
        this.nearSpeed = lllllllllllllllIlIllIIIllIlIIIlI;
        this.entityPathNavigate = lllllllllllllllIlIllIIIllIlIllII.getNavigator();
        this.setMutexBits(1);
    }
    
    static {
        __OBFID = "CL_00001574";
    }
    
    @Override
    public void updateTask() {
        if (this.theEntity.getDistanceSqToEntity(this.closestLivingEntity) < 49.0) {
            this.theEntity.getNavigator().setSpeed(this.nearSpeed);
        }
        else {
            this.theEntity.getNavigator().setSpeed(this.farSpeed);
        }
    }
    
    @Override
    public boolean shouldExecute() {
        final List lllllllllllllllIlIllIIIllIIlllIl = this.theEntity.worldObj.func_175674_a(this.theEntity, this.theEntity.getEntityBoundingBox().expand(this.field_179508_f, 3.0, this.field_179508_f), Predicates.and(new Predicate[] { IEntitySelector.field_180132_d, this.field_179509_a, this.field_179510_i }));
        if (lllllllllllllllIlIllIIIllIIlllIl.isEmpty()) {
            return false;
        }
        this.closestLivingEntity = lllllllllllllllIlIllIIIllIIlllIl.get(0);
        final Vec3 lllllllllllllllIlIllIIIllIIlllII = RandomPositionGenerator.findRandomTargetBlockAwayFrom(this.theEntity, 16, 7, new Vec3(this.closestLivingEntity.posX, this.closestLivingEntity.posY, this.closestLivingEntity.posZ));
        if (lllllllllllllllIlIllIIIllIIlllII == null) {
            return false;
        }
        if (this.closestLivingEntity.getDistanceSq(lllllllllllllllIlIllIIIllIIlllII.xCoord, lllllllllllllllIlIllIIIllIIlllII.yCoord, lllllllllllllllIlIllIIIllIIlllII.zCoord) < this.closestLivingEntity.getDistanceSqToEntity(this.theEntity)) {
            return false;
        }
        this.entityPathEntity = this.entityPathNavigate.getPathToXYZ(lllllllllllllllIlIllIIIllIIlllII.xCoord, lllllllllllllllIlIllIIIllIIlllII.yCoord, lllllllllllllllIlIllIIIllIIlllII.zCoord);
        return this.entityPathEntity != null && this.entityPathEntity.isDestinationSame(lllllllllllllllIlIllIIIllIIlllII);
    }
    
    @Override
    public boolean continueExecuting() {
        return !this.entityPathNavigate.noPath();
    }
}
