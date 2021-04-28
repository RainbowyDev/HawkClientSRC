package net.minecraft.entity.ai;

import com.google.common.base.*;
import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import org.apache.logging.log4j.*;

public class EntityAIFindEntityNearest extends EntityAIBase
{
    private final /* synthetic */ Predicate field_179443_c;
    private /* synthetic */ EntityLiving field_179442_b;
    private static final /* synthetic */ Logger field_179444_a;
    private /* synthetic */ EntityLivingBase field_179441_e;
    private /* synthetic */ Class field_179439_f;
    private final /* synthetic */ EntityAINearestAttackableTarget.Sorter field_179440_d;
    
    @Override
    public boolean shouldExecute() {
        final double llllllllllllllllIIIIIIIIIllIIIll = this.func_179438_f();
        final List llllllllllllllllIIIIIIIIIllIIIlI = this.field_179442_b.worldObj.func_175647_a(this.field_179439_f, this.field_179442_b.getEntityBoundingBox().expand(llllllllllllllllIIIIIIIIIllIIIll, 4.0, llllllllllllllllIIIIIIIIIllIIIll), this.field_179443_c);
        Collections.sort((List<Object>)llllllllllllllllIIIIIIIIIllIIIlI, this.field_179440_d);
        if (llllllllllllllllIIIIIIIIIllIIIlI.isEmpty()) {
            return false;
        }
        this.field_179441_e = llllllllllllllllIIIIIIIIIllIIIlI.get(0);
        return true;
    }
    
    @Override
    public void startExecuting() {
        this.field_179442_b.setAttackTarget(this.field_179441_e);
        super.startExecuting();
    }
    
    public EntityAIFindEntityNearest(final EntityLiving llllllllllllllllIIIIIIIIIllIllII, final Class llllllllllllllllIIIIIIIIIllIlIII) {
        this.field_179442_b = llllllllllllllllIIIIIIIIIllIllII;
        this.field_179439_f = llllllllllllllllIIIIIIIIIllIlIII;
        if (llllllllllllllllIIIIIIIIIllIllII instanceof EntityCreature) {
            EntityAIFindEntityNearest.field_179444_a.warn("Use NearestAttackableTargetGoal.class for PathfinerMob mobs!");
        }
        this.field_179443_c = (Predicate)new Predicate() {
            static {
                __OBFID = "CL_00002249";
            }
            
            public boolean apply(final Object llllllllllllllllIIIIlllIlIIIIlII) {
                return this.func_179876_a((EntityLivingBase)llllllllllllllllIIIIlllIlIIIIlII);
            }
            
            public boolean func_179876_a(final EntityLivingBase llllllllllllllllIIIIlllIlIIIlIll) {
                double llllllllllllllllIIIIlllIlIIIllIl = EntityAIFindEntityNearest.this.func_179438_f();
                if (llllllllllllllllIIIIlllIlIIIlIll.isSneaking()) {
                    llllllllllllllllIIIIlllIlIIIllIl *= 0.800000011920929;
                }
                return !llllllllllllllllIIIIlllIlIIIlIll.isInvisible() && llllllllllllllllIIIIlllIlIIIlIll.getDistanceToEntity(EntityAIFindEntityNearest.this.field_179442_b) <= llllllllllllllllIIIIlllIlIIIllIl && EntityAITarget.func_179445_a(EntityAIFindEntityNearest.this.field_179442_b, llllllllllllllllIIIIlllIlIIIlIll, false, true);
            }
        };
        this.field_179440_d = new EntityAINearestAttackableTarget.Sorter(llllllllllllllllIIIIIIIIIllIllII);
    }
    
    @Override
    public boolean continueExecuting() {
        final EntityLivingBase llllllllllllllllIIIIIIIIIlIllIlI = this.field_179442_b.getAttackTarget();
        if (llllllllllllllllIIIIIIIIIlIllIlI == null) {
            return false;
        }
        if (!llllllllllllllllIIIIIIIIIlIllIlI.isEntityAlive()) {
            return false;
        }
        final double llllllllllllllllIIIIIIIIIlIllIIl = this.func_179438_f();
        return this.field_179442_b.getDistanceSqToEntity(llllllllllllllllIIIIIIIIIlIllIlI) <= llllllllllllllllIIIIIIIIIlIllIIl * llllllllllllllllIIIIIIIIIlIllIIl && (!(llllllllllllllllIIIIIIIIIlIllIlI instanceof EntityPlayerMP) || !((EntityPlayerMP)llllllllllllllllIIIIIIIIIlIllIlI).theItemInWorldManager.isCreative());
    }
    
    @Override
    public void resetTask() {
        this.field_179442_b.setAttackTarget(null);
        super.startExecuting();
    }
    
    protected double func_179438_f() {
        final IAttributeInstance llllllllllllllllIIIIIIIIIlIIllII = this.field_179442_b.getEntityAttribute(SharedMonsterAttributes.followRange);
        return (llllllllllllllllIIIIIIIIIlIIllII == null) ? 16.0 : llllllllllllllllIIIIIIIIIlIIllII.getAttributeValue();
    }
    
    static {
        __OBFID = "CL_00002250";
        field_179444_a = LogManager.getLogger();
    }
}
