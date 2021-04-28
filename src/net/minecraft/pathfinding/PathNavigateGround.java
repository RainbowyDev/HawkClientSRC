package net.minecraft.pathfinding;

import net.minecraft.block.material.*;
import net.minecraft.block.*;
import java.util.*;
import net.minecraft.world.pathfinder.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;

public class PathNavigateGround extends PathNavigate
{
    protected /* synthetic */ WalkNodeProcessor field_179695_a;
    private /* synthetic */ boolean field_179694_f;
    
    public void func_179685_e(final boolean llllllllllllllIllllllllIllIIllII) {
        this.field_179694_f = llllllllllllllIllllllllIllIIllII;
    }
    
    private boolean func_179683_a(final int llllllllllllllIlllllllllIIlIlllI, final int llllllllllllllIlllllllllIIlIllIl, final int llllllllllllllIlllllllllIIlIllII, final int llllllllllllllIlllllllllIIllllIl, final int llllllllllllllIlllllllllIIllllII, final int llllllllllllllIlllllllllIIlIlIIl, final Vec3 llllllllllllllIlllllllllIIlIlIII, final double llllllllllllllIlllllllllIIlIIlll, final double llllllllllllllIlllllllllIIlIIllI) {
        final int llllllllllllllIlllllllllIIllIlll = llllllllllllllIlllllllllIIlIlllI - llllllllllllllIlllllllllIIllllIl / 2;
        final int llllllllllllllIlllllllllIIllIllI = llllllllllllllIlllllllllIIlIllII - llllllllllllllIlllllllllIIlIlIIl / 2;
        if (!this.func_179692_b(llllllllllllllIlllllllllIIllIlll, llllllllllllllIlllllllllIIlIllIl, llllllllllllllIlllllllllIIllIllI, llllllllllllllIlllllllllIIllllIl, llllllllllllllIlllllllllIIllllII, llllllllllllllIlllllllllIIlIlIIl, llllllllllllllIlllllllllIIlIlIII, llllllllllllllIlllllllllIIlIIlll, llllllllllllllIlllllllllIIlIIllI)) {
            return false;
        }
        for (int llllllllllllllIlllllllllIIllIlIl = llllllllllllllIlllllllllIIllIlll; llllllllllllllIlllllllllIIllIlIl < llllllllllllllIlllllllllIIllIlll + llllllllllllllIlllllllllIIllllIl; ++llllllllllllllIlllllllllIIllIlIl) {
            for (int llllllllllllllIlllllllllIIllIlII = llllllllllllllIlllllllllIIllIllI; llllllllllllllIlllllllllIIllIlII < llllllllllllllIlllllllllIIllIllI + llllllllllllllIlllllllllIIlIlIIl; ++llllllllllllllIlllllllllIIllIlII) {
                final double llllllllllllllIlllllllllIIllIIll = llllllllllllllIlllllllllIIllIlIl + 0.5 - llllllllllllllIlllllllllIIlIlIII.xCoord;
                final double llllllllllllllIlllllllllIIllIIlI = llllllllllllllIlllllllllIIllIlII + 0.5 - llllllllllllllIlllllllllIIlIlIII.zCoord;
                if (llllllllllllllIlllllllllIIllIIll * llllllllllllllIlllllllllIIlIIlll + llllllllllllllIlllllllllIIllIIlI * llllllllllllllIlllllllllIIlIIllI >= 0.0) {
                    final Block llllllllllllllIlllllllllIIllIIIl = this.worldObj.getBlockState(new BlockPos(llllllllllllllIlllllllllIIllIlIl, llllllllllllllIlllllllllIIlIllIl - 1, llllllllllllllIlllllllllIIllIlII)).getBlock();
                    final Material llllllllllllllIlllllllllIIllIIII = llllllllllllllIlllllllllIIllIIIl.getMaterial();
                    if (llllllllllllllIlllllllllIIllIIII == Material.air) {
                        return false;
                    }
                    if (llllllllllllllIlllllllllIIllIIII == Material.water && !this.theEntity.isInWater()) {
                        return false;
                    }
                    if (llllllllllllllIlllllllllIIllIIII == Material.lava) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    static {
        __OBFID = "CL_00002246";
    }
    
    private boolean func_179692_b(final int llllllllllllllIlllllllllIIIIllIl, final int llllllllllllllIlllllllllIIIIllII, final int llllllllllllllIllllllllIllllllII, final int llllllllllllllIlllllllllIIIIlIlI, final int llllllllllllllIllllllllIlllllIlI, final int llllllllllllllIllllllllIlllllIIl, final Vec3 llllllllllllllIlllllllllIIIIIlll, final double llllllllllllllIlllllllllIIIIIllI, final double llllllllllllllIlllllllllIIIIIlIl) {
        for (final BlockPos llllllllllllllIlllllllllIIIIIIll : BlockPos.getAllInBox(new BlockPos(llllllllllllllIlllllllllIIIIllIl, llllllllllllllIlllllllllIIIIllII, llllllllllllllIllllllllIllllllII), new BlockPos(llllllllllllllIlllllllllIIIIllIl + llllllllllllllIlllllllllIIIIlIlI - 1, llllllllllllllIlllllllllIIIIllII + llllllllllllllIllllllllIlllllIlI - 1, llllllllllllllIllllllllIllllllII + llllllllllllllIllllllllIlllllIIl - 1))) {
            final double llllllllllllllIlllllllllIIIIIIlI = llllllllllllllIlllllllllIIIIIIll.getX() + 0.5 - llllllllllllllIlllllllllIIIIIlll.xCoord;
            final double llllllllllllllIlllllllllIIIIIIIl = llllllllllllllIlllllllllIIIIIIll.getZ() + 0.5 - llllllllllllllIlllllllllIIIIIlll.zCoord;
            if (llllllllllllllIlllllllllIIIIIIlI * llllllllllllllIlllllllllIIIIIllI + llllllllllllllIlllllllllIIIIIIIl * llllllllllllllIlllllllllIIIIIlIl >= 0.0) {
                final Block llllllllllllllIlllllllllIIIIIIII = this.worldObj.getBlockState(llllllllllllllIlllllllllIIIIIIll).getBlock();
                if (!llllllllllllllIlllllllllIIIIIIII.isPassable(this.worldObj, llllllllllllllIlllllllllIIIIIIll)) {
                    return false;
                }
                continue;
            }
        }
        return true;
    }
    
    @Override
    protected Vec3 getEntityPosition() {
        return new Vec3(this.theEntity.posX, this.func_179687_p(), this.theEntity.posZ);
    }
    
    @Override
    protected PathFinder func_179679_a() {
        this.field_179695_a = new WalkNodeProcessor();
        this.field_179695_a.func_176175_a(true);
        return new PathFinder(this.field_179695_a);
    }
    
    public void func_179691_c(final boolean llllllllllllllIllllllllIllIllllI) {
        this.field_179695_a.func_176175_a(llllllllllllllIllllllllIllIllllI);
    }
    
    public boolean func_179686_g() {
        return this.field_179695_a.func_176179_b();
    }
    
    public void func_179690_a(final boolean llllllllllllllIllllllllIlllIlIll) {
        this.field_179695_a.func_176176_c(llllllllllllllIllllllllIlllIlIll);
    }
    
    public PathNavigateGround(final EntityLiving llllllllllllllIllllllllllIlllIII, final World llllllllllllllIllllllllllIllIlll) {
        super(llllllllllllllIllllllllllIlllIII, llllllllllllllIllllllllllIllIlll);
    }
    
    @Override
    protected boolean isDirectPathBetweenPoints(final Vec3 llllllllllllllIlllllllllIllllllI, final Vec3 llllllllllllllIlllllllllIlllllIl, int llllllllllllllIlllllllllIllIIllI, final int llllllllllllllIlllllllllIllllIll, int llllllllllllllIlllllllllIllllIlI) {
        int llllllllllllllIlllllllllIllllIIl = MathHelper.floor_double(llllllllllllllIlllllllllIllllllI.xCoord);
        int llllllllllllllIlllllllllIllllIII = MathHelper.floor_double(llllllllllllllIlllllllllIllllllI.zCoord);
        double llllllllllllllIlllllllllIlllIlll = llllllllllllllIlllllllllIlllllIl.xCoord - llllllllllllllIlllllllllIllllllI.xCoord;
        double llllllllllllllIlllllllllIlllIllI = llllllllllllllIlllllllllIlllllIl.zCoord - llllllllllllllIlllllllllIllllllI.zCoord;
        final double llllllllllllllIlllllllllIlllIlIl = llllllllllllllIlllllllllIlllIlll * llllllllllllllIlllllllllIlllIlll + llllllllllllllIlllllllllIlllIllI * llllllllllllllIlllllllllIlllIllI;
        if (llllllllllllllIlllllllllIlllIlIl < 1.0E-8) {
            return false;
        }
        final double llllllllllllllIlllllllllIlllIlII = 1.0 / Math.sqrt(llllllllllllllIlllllllllIlllIlIl);
        llllllllllllllIlllllllllIlllIlll *= llllllllllllllIlllllllllIlllIlII;
        llllllllllllllIlllllllllIlllIllI *= llllllllllllllIlllllllllIlllIlII;
        llllllllllllllIlllllllllIllIIllI += 2;
        llllllllllllllIlllllllllIllllIlI += 2;
        if (!this.func_179683_a(llllllllllllllIlllllllllIllllIIl, (int)llllllllllllllIlllllllllIllllllI.yCoord, llllllllllllllIlllllllllIllllIII, llllllllllllllIlllllllllIllIIllI, llllllllllllllIlllllllllIllllIll, llllllllllllllIlllllllllIllllIlI, llllllllllllllIlllllllllIllllllI, llllllllllllllIlllllllllIlllIlll, llllllllllllllIlllllllllIlllIllI)) {
            return false;
        }
        llllllllllllllIlllllllllIllIIllI -= 2;
        llllllllllllllIlllllllllIllllIlI -= 2;
        final double llllllllllllllIlllllllllIlllIIll = 1.0 / Math.abs(llllllllllllllIlllllllllIlllIlll);
        final double llllllllllllllIlllllllllIlllIIlI = 1.0 / Math.abs(llllllllllllllIlllllllllIlllIllI);
        double llllllllllllllIlllllllllIlllIIIl = llllllllllllllIlllllllllIllllIIl * 1 - llllllllllllllIlllllllllIllllllI.xCoord;
        double llllllllllllllIlllllllllIlllIIII = llllllllllllllIlllllllllIllllIII * 1 - llllllllllllllIlllllllllIllllllI.zCoord;
        if (llllllllllllllIlllllllllIlllIlll >= 0.0) {
            ++llllllllllllllIlllllllllIlllIIIl;
        }
        if (llllllllllllllIlllllllllIlllIllI >= 0.0) {
            ++llllllllllllllIlllllllllIlllIIII;
        }
        llllllllllllllIlllllllllIlllIIIl /= llllllllllllllIlllllllllIlllIlll;
        llllllllllllllIlllllllllIlllIIII /= llllllllllllllIlllllllllIlllIllI;
        final int llllllllllllllIlllllllllIllIllll = (llllllllllllllIlllllllllIlllIlll < 0.0) ? -1 : 1;
        final int llllllllllllllIlllllllllIllIlllI = (llllllllllllllIlllllllllIlllIllI < 0.0) ? -1 : 1;
        final int llllllllllllllIlllllllllIllIllIl = MathHelper.floor_double(llllllllllllllIlllllllllIlllllIl.xCoord);
        final int llllllllllllllIlllllllllIllIllII = MathHelper.floor_double(llllllllllllllIlllllllllIlllllIl.zCoord);
        int llllllllllllllIlllllllllIllIlIll = llllllllllllllIlllllllllIllIllIl - llllllllllllllIlllllllllIllllIIl;
        int llllllllllllllIlllllllllIllIlIlI = llllllllllllllIlllllllllIllIllII - llllllllllllllIlllllllllIllllIII;
        while (llllllllllllllIlllllllllIllIlIll * llllllllllllllIlllllllllIllIllll > 0 || llllllllllllllIlllllllllIllIlIlI * llllllllllllllIlllllllllIllIlllI > 0) {
            if (llllllllllllllIlllllllllIlllIIIl < llllllllllllllIlllllllllIlllIIII) {
                llllllllllllllIlllllllllIlllIIIl += llllllllllllllIlllllllllIlllIIll;
                llllllllllllllIlllllllllIllllIIl += llllllllllllllIlllllllllIllIllll;
                llllllllllllllIlllllllllIllIlIll = llllllllllllllIlllllllllIllIllIl - llllllllllllllIlllllllllIllllIIl;
            }
            else {
                llllllllllllllIlllllllllIlllIIII += llllllllllllllIlllllllllIlllIIlI;
                llllllllllllllIlllllllllIllllIII += llllllllllllllIlllllllllIllIlllI;
                llllllllllllllIlllllllllIllIlIlI = llllllllllllllIlllllllllIllIllII - llllllllllllllIlllllllllIllllIII;
            }
            if (!this.func_179683_a(llllllllllllllIlllllllllIllllIIl, (int)llllllllllllllIlllllllllIllllllI.yCoord, llllllllllllllIlllllllllIllllIII, llllllllllllllIlllllllllIllIIllI, llllllllllllllIlllllllllIllllIll, llllllllllllllIlllllllllIllllIlI, llllllllllllllIlllllllllIllllllI, llllllllllllllIlllllllllIlllIlll, llllllllllllllIlllllllllIlllIllI)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    protected void removeSunnyPath() {
        super.removeSunnyPath();
        if (this.field_179694_f) {
            if (this.worldObj.isAgainstSky(new BlockPos(MathHelper.floor_double(this.theEntity.posX), (int)(this.theEntity.getEntityBoundingBox().minY + 0.5), MathHelper.floor_double(this.theEntity.posZ)))) {
                return;
            }
            for (int llllllllllllllIllllllllllIIllIlI = 0; llllllllllllllIllllllllllIIllIlI < this.currentPath.getCurrentPathLength(); ++llllllllllllllIllllllllllIIllIlI) {
                final PathPoint llllllllllllllIllllllllllIIllIIl = this.currentPath.getPathPointFromIndex(llllllllllllllIllllllllllIIllIlI);
                if (this.worldObj.isAgainstSky(new BlockPos(llllllllllllllIllllllllllIIllIIl.xCoord, llllllllllllllIllllllllllIIllIIl.yCoord, llllllllllllllIllllllllllIIllIIl.zCoord))) {
                    this.currentPath.setCurrentPathLength(llllllllllllllIllllllllllIIllIlI - 1);
                    return;
                }
            }
        }
    }
    
    private int func_179687_p() {
        if (this.theEntity.isInWater() && this.func_179684_h()) {
            int llllllllllllllIllllllllllIlIIlIl = (int)this.theEntity.getEntityBoundingBox().minY;
            Block llllllllllllllIllllllllllIlIIlII = this.worldObj.getBlockState(new BlockPos(MathHelper.floor_double(this.theEntity.posX), llllllllllllllIllllllllllIlIIlIl, MathHelper.floor_double(this.theEntity.posZ))).getBlock();
            int llllllllllllllIllllllllllIlIIIll = 0;
            while (llllllllllllllIllllllllllIlIIlII == Blocks.flowing_water || llllllllllllllIllllllllllIlIIlII == Blocks.water) {
                ++llllllllllllllIllllllllllIlIIlIl;
                llllllllllllllIllllllllllIlIIlII = this.worldObj.getBlockState(new BlockPos(MathHelper.floor_double(this.theEntity.posX), llllllllllllllIllllllllllIlIIlIl, MathHelper.floor_double(this.theEntity.posZ))).getBlock();
                if (++llllllllllllllIllllllllllIlIIIll > 16) {
                    return (int)this.theEntity.getEntityBoundingBox().minY;
                }
            }
            return llllllllllllllIllllllllllIlIIlIl;
        }
        return (int)(this.theEntity.getEntityBoundingBox().minY + 0.5);
    }
    
    public void func_179693_d(final boolean llllllllllllllIllllllllIllIlIlIl) {
        this.field_179695_a.func_176178_d(llllllllllllllIllllllllIllIlIlIl);
    }
    
    public void func_179688_b(final boolean llllllllllllllIllllllllIlllIIIlI) {
        this.field_179695_a.func_176172_b(llllllllllllllIllllllllIlllIIIlI);
    }
    
    public boolean func_179684_h() {
        return this.field_179695_a.func_176174_d();
    }
    
    @Override
    protected boolean canNavigate() {
        return this.theEntity.onGround || (this.func_179684_h() && this.isInLiquid()) || (this.theEntity.isRiding() && this.theEntity instanceof EntityZombie && this.theEntity.ridingEntity instanceof EntityChicken);
    }
    
    public boolean func_179689_e() {
        return this.field_179695_a.func_176173_e();
    }
}
