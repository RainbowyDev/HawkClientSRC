package net.minecraft.entity.ai;

import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.command.*;
import com.google.common.base.*;
import java.util.*;

public class EntityAINearestAttackableTarget extends EntityAITarget
{
    protected final /* synthetic */ Class targetClass;
    private final /* synthetic */ int targetChance;
    protected /* synthetic */ Predicate targetEntitySelector;
    protected final /* synthetic */ Sorter theNearestAttackableTargetSorter;
    protected /* synthetic */ EntityLivingBase targetEntity;
    
    static {
        __OBFID = "CL_00001620";
    }
    
    public EntityAINearestAttackableTarget(final EntityCreature llllllllllllllIIIllIlIlIlIlIIlIl, final Class llllllllllllllIIIllIlIlIlIlIIlII, final boolean llllllllllllllIIIllIlIlIlIlIIlll) {
        this(llllllllllllllIIIllIlIlIlIlIIlIl, llllllllllllllIIIllIlIlIlIlIIlII, llllllllllllllIIIllIlIlIlIlIIlll, false);
    }
    
    public EntityAINearestAttackableTarget(final EntityCreature llllllllllllllIIIllIlIlIlIIlllII, final Class llllllllllllllIIIllIlIlIlIIlIllI, final boolean llllllllllllllIIIllIlIlIlIIllIlI, final boolean llllllllllllllIIIllIlIlIlIIlIlII) {
        this(llllllllllllllIIIllIlIlIlIIlllII, llllllllllllllIIIllIlIlIlIIlIllI, 10, llllllllllllllIIIllIlIlIlIIllIlI, llllllllllllllIIIllIlIlIlIIlIlII, null);
    }
    
    public EntityAINearestAttackableTarget(final EntityCreature llllllllllllllIIIllIlIlIlIIIlIll, final Class llllllllllllllIIIllIlIlIlIIIlIlI, final int llllllllllllllIIIllIlIlIlIIIIIlI, final boolean llllllllllllllIIIllIlIlIlIIIIIIl, final boolean llllllllllllllIIIllIlIlIlIIIIIII, final Predicate llllllllllllllIIIllIlIlIIlllllll) {
        super(llllllllllllllIIIllIlIlIlIIIlIll, llllllllllllllIIIllIlIlIlIIIIIIl, llllllllllllllIIIllIlIlIlIIIIIII);
        this.targetClass = llllllllllllllIIIllIlIlIlIIIlIlI;
        this.targetChance = llllllllllllllIIIllIlIlIlIIIIIlI;
        this.theNearestAttackableTargetSorter = new Sorter(llllllllllllllIIIllIlIlIlIIIlIll);
        this.setMutexBits(1);
        this.targetEntitySelector = (Predicate)new Predicate() {
            static {
                __OBFID = "CL_00001621";
            }
            
            public boolean func_179878_a(final EntityLivingBase lllllllllllllllIIlllIlIIllIlIlll) {
                if (llllllllllllllIIIllIlIlIIlllllll != null && !llllllllllllllIIIllIlIlIIlllllll.apply((Object)lllllllllllllllIIlllIlIIllIlIlll)) {
                    return false;
                }
                if (lllllllllllllllIIlllIlIIllIlIlll instanceof EntityPlayer) {
                    double lllllllllllllllIIlllIlIIllIllIlI = EntityAINearestAttackableTarget.this.getTargetDistance();
                    if (lllllllllllllllIIlllIlIIllIlIlll.isSneaking()) {
                        lllllllllllllllIIlllIlIIllIllIlI *= 0.800000011920929;
                    }
                    if (lllllllllllllllIIlllIlIIllIlIlll.isInvisible()) {
                        float lllllllllllllllIIlllIlIIllIllIIl = ((EntityPlayer)lllllllllllllllIIlllIlIIllIlIlll).getArmorVisibility();
                        if (lllllllllllllllIIlllIlIIllIllIIl < 0.1f) {
                            lllllllllllllllIIlllIlIIllIllIIl = 0.1f;
                        }
                        lllllllllllllllIIlllIlIIllIllIlI *= 0.7f * lllllllllllllllIIlllIlIIllIllIIl;
                    }
                    if (lllllllllllllllIIlllIlIIllIlIlll.getDistanceToEntity(EntityAINearestAttackableTarget.this.taskOwner) > lllllllllllllllIIlllIlIIllIllIlI) {
                        return false;
                    }
                }
                return EntityAINearestAttackableTarget.this.isSuitableTarget(lllllllllllllllIIlllIlIIllIlIlll, false);
            }
            
            public boolean apply(final Object lllllllllllllllIIlllIlIIllIlIIIl) {
                return this.func_179878_a((EntityLivingBase)lllllllllllllllIIlllIlIIllIlIIIl);
            }
        };
    }
    
    @Override
    public void startExecuting() {
        this.taskOwner.setAttackTarget(this.targetEntity);
        super.startExecuting();
    }
    
    @Override
    public boolean shouldExecute() {
        if (this.targetChance > 0 && this.taskOwner.getRNG().nextInt(this.targetChance) != 0) {
            return false;
        }
        final double llllllllllllllIIIllIlIlIIllllIlI = this.getTargetDistance();
        final List llllllllllllllIIIllIlIlIIllllIIl = this.taskOwner.worldObj.func_175647_a(this.targetClass, this.taskOwner.getEntityBoundingBox().expand(llllllllllllllIIIllIlIlIIllllIlI, 4.0, llllllllllllllIIIllIlIlIIllllIlI), Predicates.and(this.targetEntitySelector, IEntitySelector.field_180132_d));
        Collections.sort((List<Object>)llllllllllllllIIIllIlIlIIllllIIl, this.theNearestAttackableTargetSorter);
        if (llllllllllllllIIIllIlIlIIllllIIl.isEmpty()) {
            return false;
        }
        this.targetEntity = llllllllllllllIIIllIlIlIIllllIIl.get(0);
        return true;
    }
    
    public static class Sorter implements Comparator
    {
        private final /* synthetic */ Entity theEntity;
        
        static {
            __OBFID = "CL_00001622";
        }
        
        public Sorter(final Entity llllllllllllllIIlllIllllllllIIIl) {
            this.theEntity = llllllllllllllIIlllIllllllllIIIl;
        }
        
        @Override
        public int compare(final Object llllllllllllllIIlllIllllllIllIII, final Object llllllllllllllIIlllIllllllIllIlI) {
            return this.compare((Entity)llllllllllllllIIlllIllllllIllIII, (Entity)llllllllllllllIIlllIllllllIllIlI);
        }
        
        public int compare(final Entity llllllllllllllIIlllIlllllllIlIII, final Entity llllllllllllllIIlllIlllllllIIlll) {
            final double llllllllllllllIIlllIlllllllIIllI = this.theEntity.getDistanceSqToEntity(llllllllllllllIIlllIlllllllIlIII);
            final double llllllllllllllIIlllIlllllllIIlIl = this.theEntity.getDistanceSqToEntity(llllllllllllllIIlllIlllllllIIlll);
            return (llllllllllllllIIlllIlllllllIIllI < llllllllllllllIIlllIlllllllIIlIl) ? -1 : ((llllllllllllllIIlllIlllllllIIllI > llllllllllllllIIlllIlllllllIIlIl) ? 1 : 0);
        }
    }
}
