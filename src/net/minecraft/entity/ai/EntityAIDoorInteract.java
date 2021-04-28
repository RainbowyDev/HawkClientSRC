package net.minecraft.entity.ai;

import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.pathfinding.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;

public abstract class EntityAIDoorInteract extends EntityAIBase
{
    /* synthetic */ boolean hasStoppedDoorInteraction;
    protected /* synthetic */ BlockPos field_179507_b;
    protected /* synthetic */ EntityLiving theEntity;
    protected /* synthetic */ BlockDoor doorBlock;
    /* synthetic */ float entityPositionZ;
    /* synthetic */ float entityPositionX;
    
    public EntityAIDoorInteract(final EntityLiving lllllllllllllllIlIlIlIIllllllIll) {
        this.field_179507_b = BlockPos.ORIGIN;
        this.theEntity = lllllllllllllllIlIlIlIIllllllIll;
        if (!(lllllllllllllllIlIlIlIIllllllIll.getNavigator() instanceof PathNavigateGround)) {
            throw new IllegalArgumentException("Unsupported mob type for DoorInteractGoal");
        }
    }
    
    @Override
    public void startExecuting() {
        this.hasStoppedDoorInteraction = false;
        this.entityPositionX = (float)(this.field_179507_b.getX() + 0.5f - this.theEntity.posX);
        this.entityPositionZ = (float)(this.field_179507_b.getZ() + 0.5f - this.theEntity.posZ);
    }
    
    @Override
    public boolean continueExecuting() {
        return !this.hasStoppedDoorInteraction;
    }
    
    @Override
    public void updateTask() {
        final float lllllllllllllllIlIlIlIIlllIllIlI = (float)(this.field_179507_b.getX() + 0.5f - this.theEntity.posX);
        final float lllllllllllllllIlIlIlIIlllIllIII = (float)(this.field_179507_b.getZ() + 0.5f - this.theEntity.posZ);
        final float lllllllllllllllIlIlIlIIlllIlIllI = this.entityPositionX * lllllllllllllllIlIlIlIIlllIllIlI + this.entityPositionZ * lllllllllllllllIlIlIlIIlllIllIII;
        if (lllllllllllllllIlIlIlIIlllIlIllI < 0.0f) {
            this.hasStoppedDoorInteraction = true;
        }
    }
    
    @Override
    public boolean shouldExecute() {
        if (!this.theEntity.isCollidedHorizontally) {
            return false;
        }
        final PathNavigateGround lllllllllllllllIlIlIlIIlllllIIlI = (PathNavigateGround)this.theEntity.getNavigator();
        final PathEntity lllllllllllllllIlIlIlIIlllllIIIl = lllllllllllllllIlIlIlIIlllllIIlI.getPath();
        if (lllllllllllllllIlIlIlIIlllllIIIl != null && !lllllllllllllllIlIlIlIIlllllIIIl.isFinished() && lllllllllllllllIlIlIlIIlllllIIlI.func_179686_g()) {
            for (int lllllllllllllllIlIlIlIIlllllIIII = 0; lllllllllllllllIlIlIlIIlllllIIII < Math.min(lllllllllllllllIlIlIlIIlllllIIIl.getCurrentPathIndex() + 2, lllllllllllllllIlIlIlIIlllllIIIl.getCurrentPathLength()); ++lllllllllllllllIlIlIlIIlllllIIII) {
                final PathPoint lllllllllllllllIlIlIlIIllllIllll = lllllllllllllllIlIlIlIIlllllIIIl.getPathPointFromIndex(lllllllllllllllIlIlIlIIlllllIIII);
                this.field_179507_b = new BlockPos(lllllllllllllllIlIlIlIIllllIllll.xCoord, lllllllllllllllIlIlIlIIllllIllll.yCoord + 1, lllllllllllllllIlIlIlIIllllIllll.zCoord);
                if (this.theEntity.getDistanceSq(this.field_179507_b.getX(), this.theEntity.posY, this.field_179507_b.getZ()) <= 2.25) {
                    this.doorBlock = this.func_179506_a(this.field_179507_b);
                    if (this.doorBlock != null) {
                        return true;
                    }
                }
            }
            this.field_179507_b = new BlockPos(this.theEntity).offsetUp();
            this.doorBlock = this.func_179506_a(this.field_179507_b);
            return this.doorBlock != null;
        }
        return false;
    }
    
    static {
        __OBFID = "CL_00001581";
    }
    
    private BlockDoor func_179506_a(final BlockPos lllllllllllllllIlIlIlIIlllIIllII) {
        final Block lllllllllllllllIlIlIlIIlllIIlIll = this.theEntity.worldObj.getBlockState(lllllllllllllllIlIlIlIIlllIIllII).getBlock();
        return (lllllllllllllllIlIlIlIIlllIIlIll instanceof BlockDoor && lllllllllllllllIlIlIlIIlllIIlIll.getMaterial() == Material.wood) ? ((BlockDoor)lllllllllllllllIlIlIlIIlllIIlIll) : null;
    }
}
