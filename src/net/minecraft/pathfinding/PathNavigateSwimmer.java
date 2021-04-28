package net.minecraft.pathfinding;

import net.minecraft.world.pathfinder.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class PathNavigateSwimmer extends PathNavigate
{
    @Override
    protected PathFinder func_179679_a() {
        return new PathFinder(new SwimNodeProcessor());
    }
    
    public PathNavigateSwimmer(final EntityLiving llIIlIllIIllll, final World llIIlIllIIlllI) {
        super(llIIlIllIIllll, llIIlIllIIlllI);
    }
    
    @Override
    protected void pathFollow() {
        final Vec3 llIIlIlIllllII = this.getEntityPosition();
        final float llIIlIlIlllIll = this.theEntity.width * this.theEntity.width;
        final byte llIIlIlIlllIlI = 6;
        if (llIIlIlIllllII.squareDistanceTo(this.currentPath.getVectorFromIndex(this.theEntity, this.currentPath.getCurrentPathIndex())) < llIIlIlIlllIll) {
            this.currentPath.incrementPathIndex();
        }
        for (int llIIlIlIlllIIl = Math.min(this.currentPath.getCurrentPathIndex() + llIIlIlIlllIlI, this.currentPath.getCurrentPathLength() - 1); llIIlIlIlllIIl > this.currentPath.getCurrentPathIndex(); --llIIlIlIlllIIl) {
            final Vec3 llIIlIlIlllIII = this.currentPath.getVectorFromIndex(this.theEntity, llIIlIlIlllIIl);
            if (llIIlIlIlllIII.squareDistanceTo(llIIlIlIllllII) <= 36.0 && this.isDirectPathBetweenPoints(llIIlIlIllllII, llIIlIlIlllIII, 0, 0, 0)) {
                this.currentPath.setCurrentPathIndex(llIIlIlIlllIIl);
                break;
            }
        }
        this.func_179677_a(llIIlIlIllllII);
    }
    
    @Override
    protected boolean canNavigate() {
        return this.isInLiquid();
    }
    
    @Override
    protected Vec3 getEntityPosition() {
        return new Vec3(this.theEntity.posX, this.theEntity.posY + this.theEntity.height * 0.5, this.theEntity.posZ);
    }
    
    @Override
    protected boolean isDirectPathBetweenPoints(final Vec3 llIIlIlIlIIIlI, final Vec3 llIIlIlIlIlIII, final int llIIlIlIlIIlll, final int llIIlIlIlIIllI, final int llIIlIlIlIIlIl) {
        final MovingObjectPosition llIIlIlIlIIlII = this.worldObj.rayTraceBlocks(llIIlIlIlIIIlI, new Vec3(llIIlIlIlIlIII.xCoord, llIIlIlIlIlIII.yCoord + this.theEntity.height * 0.5, llIIlIlIlIlIII.zCoord), false, true, false);
        return llIIlIlIlIIlII == null || llIIlIlIlIIlII.typeOfHit == MovingObjectPosition.MovingObjectType.MISS;
    }
    
    @Override
    protected void removeSunnyPath() {
        super.removeSunnyPath();
    }
    
    static {
        __OBFID = "CL_00002244";
    }
}
