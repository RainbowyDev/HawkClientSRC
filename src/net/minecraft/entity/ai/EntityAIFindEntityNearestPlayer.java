package net.minecraft.entity.ai;

import com.google.common.base.*;
import java.util.*;
import org.apache.logging.log4j.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.scoreboard.*;

public class EntityAIFindEntityNearestPlayer extends EntityAIBase
{
    private /* synthetic */ EntityLiving field_179434_b;
    private final /* synthetic */ EntityAINearestAttackableTarget.Sorter field_179432_d;
    private /* synthetic */ EntityLivingBase field_179433_e;
    private static final /* synthetic */ Logger field_179436_a;
    private final /* synthetic */ Predicate field_179435_c;
    
    @Override
    public boolean shouldExecute() {
        final double lllIIlllllIIIll = this.func_179431_f();
        final List lllIIlllllIIIlI = this.field_179434_b.worldObj.func_175647_a(EntityPlayer.class, this.field_179434_b.getEntityBoundingBox().expand(lllIIlllllIIIll, 4.0, lllIIlllllIIIll), this.field_179435_c);
        Collections.sort((List<Object>)lllIIlllllIIIlI, this.field_179432_d);
        if (lllIIlllllIIIlI.isEmpty()) {
            return false;
        }
        this.field_179433_e = lllIIlllllIIIlI.get(0);
        return true;
    }
    
    @Override
    public void resetTask() {
        this.field_179434_b.setAttackTarget(null);
        super.startExecuting();
    }
    
    static {
        __OBFID = "CL_00002248";
        field_179436_a = LogManager.getLogger();
    }
    
    protected double func_179431_f() {
        final IAttributeInstance lllIIllllIIIllI = this.field_179434_b.getEntityAttribute(SharedMonsterAttributes.followRange);
        return (lllIIllllIIIllI == null) ? 16.0 : lllIIllllIIIllI.getAttributeValue();
    }
    
    public EntityAIFindEntityNearestPlayer(final EntityLiving lllIIlllllIlIlI) {
        this.field_179434_b = lllIIlllllIlIlI;
        if (lllIIlllllIlIlI instanceof EntityCreature) {
            EntityAIFindEntityNearestPlayer.field_179436_a.warn("Use NearestAttackableTargetGoal.class for PathfinerMob mobs!");
        }
        this.field_179435_c = (Predicate)new Predicate() {
            public boolean func_179880_a(final Entity llllllllllllllIIlllIlIIIllIIIlII) {
                if (!(llllllllllllllIIlllIlIIIllIIIlII instanceof EntityPlayer)) {
                    return false;
                }
                double llllllllllllllIIlllIlIIIllIIIlll = EntityAIFindEntityNearestPlayer.this.func_179431_f();
                if (llllllllllllllIIlllIlIIIllIIIlII.isSneaking()) {
                    llllllllllllllIIlllIlIIIllIIIlll *= 0.800000011920929;
                }
                if (llllllllllllllIIlllIlIIIllIIIlII.isInvisible()) {
                    float llllllllllllllIIlllIlIIIllIIIllI = ((EntityPlayer)llllllllllllllIIlllIlIIIllIIIlII).getArmorVisibility();
                    if (llllllllllllllIIlllIlIIIllIIIllI < 0.1f) {
                        llllllllllllllIIlllIlIIIllIIIllI = 0.1f;
                    }
                    llllllllllllllIIlllIlIIIllIIIlll *= 0.7f * llllllllllllllIIlllIlIIIllIIIllI;
                }
                return llllllllllllllIIlllIlIIIllIIIlII.getDistanceToEntity(EntityAIFindEntityNearestPlayer.this.field_179434_b) <= llllllllllllllIIlllIlIIIllIIIlll && EntityAITarget.func_179445_a(EntityAIFindEntityNearestPlayer.this.field_179434_b, (EntityLivingBase)llllllllllllllIIlllIlIIIllIIIlII, false, true);
            }
            
            public boolean apply(final Object llllllllllllllIIlllIlIIIlIllllII) {
                return this.func_179880_a((Entity)llllllllllllllIIlllIlIIIlIllllII);
            }
            
            static {
                __OBFID = "CL_00002247";
            }
        };
        this.field_179432_d = new EntityAINearestAttackableTarget.Sorter(lllIIlllllIlIlI);
    }
    
    @Override
    public void startExecuting() {
        this.field_179434_b.setAttackTarget(this.field_179433_e);
        super.startExecuting();
    }
    
    @Override
    public boolean continueExecuting() {
        final EntityLivingBase lllIIllllIllIII = this.field_179434_b.getAttackTarget();
        if (lllIIllllIllIII == null) {
            return false;
        }
        if (!lllIIllllIllIII.isEntityAlive()) {
            return false;
        }
        final Team lllIIllllIlIlll = this.field_179434_b.getTeam();
        final Team lllIIllllIlIllI = lllIIllllIllIII.getTeam();
        if (lllIIllllIlIlll != null && lllIIllllIlIllI == lllIIllllIlIlll) {
            return false;
        }
        final double lllIIllllIlIlIl = this.func_179431_f();
        return this.field_179434_b.getDistanceSqToEntity(lllIIllllIllIII) <= lllIIllllIlIlIl * lllIIllllIlIlIl && (!(lllIIllllIllIII instanceof EntityPlayerMP) || !((EntityPlayerMP)lllIIllllIllIII).theItemInWorldManager.isCreative());
    }
}
