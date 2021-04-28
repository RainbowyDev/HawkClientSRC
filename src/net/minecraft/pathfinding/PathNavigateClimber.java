package net.minecraft.pathfinding;

import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.util.*;

public class PathNavigateClimber extends PathNavigateGround
{
    private /* synthetic */ BlockPos field_179696_f;
    
    @Override
    public PathEntity func_179680_a(final BlockPos llllllllllllllIIllIIlIllIlIIlIll) {
        this.field_179696_f = llllllllllllllIIllIIlIllIlIIlIll;
        return super.func_179680_a(llllllllllllllIIllIIlIllIlIIlIll);
    }
    
    @Override
    public boolean tryMoveToEntityLiving(final Entity llllllllllllllIIllIIlIllIIllllIl, final double llllllllllllllIIllIIlIllIIlllIII) {
        final PathEntity llllllllllllllIIllIIlIllIIlllIll = this.getPathToEntityLiving(llllllllllllllIIllIIlIllIIllllIl);
        if (llllllllllllllIIllIIlIllIIlllIll != null) {
            return this.setPath(llllllllllllllIIllIIlIllIIlllIll, llllllllllllllIIllIIlIllIIlllIII);
        }
        this.field_179696_f = new BlockPos(llllllllllllllIIllIIlIllIIllllIl);
        this.speed = llllllllllllllIIllIIlIllIIlllIII;
        return true;
    }
    
    public PathNavigateClimber(final EntityLiving llllllllllllllIIllIIlIllIlIlIIII, final World llllllllllllllIIllIIlIllIlIIllll) {
        super(llllllllllllllIIllIIlIllIlIlIIII, llllllllllllllIIllIIlIllIlIIllll);
    }
    
    static {
        __OBFID = "CL_00002245";
    }
    
    @Override
    public void onUpdateNavigation() {
        if (!this.noPath()) {
            super.onUpdateNavigation();
        }
        else if (this.field_179696_f != null) {
            final double llllllllllllllIIllIIlIllIIllIIll = this.theEntity.width * this.theEntity.width;
            if (this.theEntity.func_174831_c(this.field_179696_f) >= llllllllllllllIIllIIlIllIIllIIll && (this.theEntity.posY <= this.field_179696_f.getY() || this.theEntity.func_174831_c(new BlockPos(this.field_179696_f.getX(), MathHelper.floor_double(this.theEntity.posY), this.field_179696_f.getZ())) >= llllllllllllllIIllIIlIllIIllIIll)) {
                this.theEntity.getMoveHelper().setMoveTo(this.field_179696_f.getX(), this.field_179696_f.getY(), this.field_179696_f.getZ(), this.speed);
            }
            else {
                this.field_179696_f = null;
            }
        }
    }
    
    @Override
    public PathEntity getPathToEntityLiving(final Entity llllllllllllllIIllIIlIllIlIIIIll) {
        this.field_179696_f = new BlockPos(llllllllllllllIIllIIlIllIlIIIIll);
        return super.getPathToEntityLiving(llllllllllllllIIllIIlIllIlIIIIll);
    }
}
