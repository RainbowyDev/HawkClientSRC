package net.minecraft.entity.ai;

import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import java.util.*;

public class EntityAIFleeSun extends EntityAIBase
{
    private /* synthetic */ double shelterZ;
    private /* synthetic */ double shelterY;
    private /* synthetic */ double movementSpeed;
    private /* synthetic */ EntityCreature theCreature;
    private /* synthetic */ World theWorld;
    private /* synthetic */ double shelterX;
    
    @Override
    public boolean shouldExecute() {
        if (!this.theWorld.isDaytime()) {
            return false;
        }
        if (!this.theCreature.isBurning()) {
            return false;
        }
        if (!this.theWorld.isAgainstSky(new BlockPos(this.theCreature.posX, this.theCreature.getEntityBoundingBox().minY, this.theCreature.posZ))) {
            return false;
        }
        final Vec3 llllllllllllllIIlIIlIIIlIIllIIll = this.findPossibleShelter();
        if (llllllllllllllIIlIIlIIIlIIllIIll == null) {
            return false;
        }
        this.shelterX = llllllllllllllIIlIIlIIIlIIllIIll.xCoord;
        this.shelterY = llllllllllllllIIlIIlIIIlIIllIIll.yCoord;
        this.shelterZ = llllllllllllllIIlIIlIIIlIIllIIll.zCoord;
        return true;
    }
    
    private Vec3 findPossibleShelter() {
        final Random llllllllllllllIIlIIlIIIlIIlIIlII = this.theCreature.getRNG();
        final BlockPos llllllllllllllIIlIIlIIIlIIlIIIll = new BlockPos(this.theCreature.posX, this.theCreature.getEntityBoundingBox().minY, this.theCreature.posZ);
        for (int llllllllllllllIIlIIlIIIlIIlIIIlI = 0; llllllllllllllIIlIIlIIIlIIlIIIlI < 10; ++llllllllllllllIIlIIlIIIlIIlIIIlI) {
            final BlockPos llllllllllllllIIlIIlIIIlIIlIIIIl = llllllllllllllIIlIIlIIIlIIlIIIll.add(llllllllllllllIIlIIlIIIlIIlIIlII.nextInt(20) - 10, llllllllllllllIIlIIlIIIlIIlIIlII.nextInt(6) - 3, llllllllllllllIIlIIlIIIlIIlIIlII.nextInt(20) - 10);
            if (!this.theWorld.isAgainstSky(llllllllllllllIIlIIlIIIlIIlIIIIl) && this.theCreature.func_180484_a(llllllllllllllIIlIIlIIIlIIlIIIIl) < 0.0f) {
                return new Vec3(llllllllllllllIIlIIlIIIlIIlIIIIl.getX(), llllllllllllllIIlIIlIIIlIIlIIIIl.getY(), llllllllllllllIIlIIlIIIlIIlIIIIl.getZ());
            }
        }
        return null;
    }
    
    @Override
    public boolean continueExecuting() {
        return !this.theCreature.getNavigator().noPath();
    }
    
    @Override
    public void startExecuting() {
        this.theCreature.getNavigator().tryMoveToXYZ(this.shelterX, this.shelterY, this.shelterZ, this.movementSpeed);
    }
    
    static {
        __OBFID = "CL_00001583";
    }
    
    public EntityAIFleeSun(final EntityCreature llllllllllllllIIlIIlIIIlIIlllIII, final double llllllllllllllIIlIIlIIIlIIllIlll) {
        this.theCreature = llllllllllllllIIlIIlIIIlIIlllIII;
        this.movementSpeed = llllllllllllllIIlIIlIIIlIIllIlll;
        this.theWorld = llllllllllllllIIlIIlIIIlIIlllIII.worldObj;
        this.setMutexBits(1);
    }
}
