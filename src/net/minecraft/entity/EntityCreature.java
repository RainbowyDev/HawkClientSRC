package net.minecraft.entity;

import java.util.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.passive.*;
import net.minecraft.pathfinding.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.ai.*;

public abstract class EntityCreature extends EntityLiving
{
    private /* synthetic */ EntityAIBase aiBase;
    private /* synthetic */ float maximumHomeDistance;
    public static final /* synthetic */ UUID field_110179_h;
    private /* synthetic */ BlockPos homePosition;
    private /* synthetic */ boolean field_110180_bt;
    
    public float getMaximumHomeDistance() {
        return this.maximumHomeDistance;
    }
    
    public void func_175449_a(final BlockPos llllllllllllllllIIllIlllllIlIIlI, final int llllllllllllllllIIllIlllllIlIIIl) {
        this.homePosition = llllllllllllllllIIllIlllllIlIIlI;
        this.maximumHomeDistance = (float)llllllllllllllllIIllIlllllIlIIIl;
    }
    
    protected void func_142017_o(final float llllllllllllllllIIllIllllIlIlllI) {
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return super.getCanSpawnHere() && this.func_180484_a(new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ)) >= 0.0f;
    }
    
    @Override
    protected void updateLeashedState() {
        super.updateLeashedState();
        if (this.getLeashed() && this.getLeashedToEntity() != null && this.getLeashedToEntity().worldObj == this.worldObj) {
            final Entity llllllllllllllllIIllIllllIlllIlI = this.getLeashedToEntity();
            this.func_175449_a(new BlockPos((int)llllllllllllllllIIllIllllIlllIlI.posX, (int)llllllllllllllllIIllIllllIlllIlI.posY, (int)llllllllllllllllIIllIllllIlllIlI.posZ), 5);
            final float llllllllllllllllIIllIllllIlllIIl = this.getDistanceToEntity(llllllllllllllllIIllIllllIlllIlI);
            if (this instanceof EntityTameable && ((EntityTameable)this).isSitting()) {
                if (llllllllllllllllIIllIllllIlllIIl > 10.0f) {
                    this.clearLeashed(true, true);
                }
                return;
            }
            if (!this.field_110180_bt) {
                this.tasks.addTask(2, this.aiBase);
                if (this.getNavigator() instanceof PathNavigateGround) {
                    ((PathNavigateGround)this.getNavigator()).func_179690_a(false);
                }
                this.field_110180_bt = true;
            }
            this.func_142017_o(llllllllllllllllIIllIllllIlllIIl);
            if (llllllllllllllllIIllIllllIlllIIl > 4.0f) {
                this.getNavigator().tryMoveToEntityLiving(llllllllllllllllIIllIllllIlllIlI, 1.0);
            }
            if (llllllllllllllllIIllIllllIlllIIl > 6.0f) {
                final double llllllllllllllllIIllIllllIlllIII = (llllllllllllllllIIllIllllIlllIlI.posX - this.posX) / llllllllllllllllIIllIllllIlllIIl;
                final double llllllllllllllllIIllIllllIllIlll = (llllllllllllllllIIllIllllIlllIlI.posY - this.posY) / llllllllllllllllIIllIllllIlllIIl;
                final double llllllllllllllllIIllIllllIllIllI = (llllllllllllllllIIllIllllIlllIlI.posZ - this.posZ) / llllllllllllllllIIllIllllIlllIIl;
                this.motionX += llllllllllllllllIIllIllllIlllIII * Math.abs(llllllllllllllllIIllIllllIlllIII) * 0.4;
                this.motionY += llllllllllllllllIIllIllllIllIlll * Math.abs(llllllllllllllllIIllIllllIllIlll) * 0.4;
                this.motionZ += llllllllllllllllIIllIllllIllIllI * Math.abs(llllllllllllllllIIllIllllIllIllI) * 0.4;
            }
            if (llllllllllllllllIIllIllllIlllIIl > 10.0f) {
                this.clearLeashed(true, true);
            }
        }
        else if (!this.getLeashed() && this.field_110180_bt) {
            this.field_110180_bt = false;
            this.tasks.removeTask(this.aiBase);
            if (this.getNavigator() instanceof PathNavigateGround) {
                ((PathNavigateGround)this.getNavigator()).func_179690_a(true);
            }
            this.detachHome();
        }
    }
    
    public boolean func_180485_d(final BlockPos llllllllllllllllIIllIlllllIlIlll) {
        return this.maximumHomeDistance == -1.0f || this.homePosition.distanceSq(llllllllllllllllIIllIlllllIlIlll) < this.maximumHomeDistance * this.maximumHomeDistance;
    }
    
    public float func_180484_a(final BlockPos llllllllllllllllIIllIllllllIIllI) {
        return 0.0f;
    }
    
    public boolean isWithinHomeDistanceCurrentPosition() {
        return this.func_180485_d(new BlockPos(this));
    }
    
    public BlockPos func_180486_cf() {
        return this.homePosition;
    }
    
    public void detachHome() {
        this.maximumHomeDistance = -1.0f;
    }
    
    public EntityCreature(final World llllllllllllllllIIllIllllllIlIII) {
        super(llllllllllllllllIIllIllllllIlIII);
        this.homePosition = BlockPos.ORIGIN;
        this.maximumHomeDistance = -1.0f;
        this.aiBase = new EntityAIMoveTowardsRestriction(this, 1.0);
    }
    
    static {
        __OBFID = "CL_00001558";
        field_110179_h = UUID.fromString("E199AD21-BA8A-4C53-8D13-6182D5C69D3A");
        field_110181_i = new AttributeModifier(EntityCreature.field_110179_h, "Fleeing speed bonus", 2.0, 2).setSaved(false);
    }
    
    public boolean hasHome() {
        return this.maximumHomeDistance != -1.0f;
    }
    
    public boolean hasPath() {
        return !this.navigator.noPath();
    }
}
