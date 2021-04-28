package net.minecraft.util;

import net.minecraft.entity.*;

public class MovingObjectPosition
{
    public /* synthetic */ MovingObjectType typeOfHit;
    private /* synthetic */ BlockPos field_178783_e;
    public /* synthetic */ Entity entityHit;
    public /* synthetic */ Vec3 hitVec;
    public /* synthetic */ EnumFacing field_178784_b;
    
    public MovingObjectPosition(final Vec3 llllllllllllllIIIlllIIIlIllllllI, final EnumFacing llllllllllllllIIIlllIIIlIllllIIl, final BlockPos llllllllllllllIIIlllIIIlIlllllII) {
        this(MovingObjectType.BLOCK, llllllllllllllIIIlllIIIlIllllllI, llllllllllllllIIIlllIIIlIllllIIl, llllllllllllllIIIlllIIIlIlllllII);
    }
    
    static {
        __OBFID = "CL_00000610";
    }
    
    public MovingObjectPosition(final Vec3 llllllllllllllIIIlllIIIlIlllIIll, final EnumFacing llllllllllllllIIIlllIIIlIlllIIlI) {
        this(MovingObjectType.BLOCK, llllllllllllllIIIlllIIIlIlllIIll, llllllllllllllIIIlllIIIlIlllIIlI, BlockPos.ORIGIN);
    }
    
    public MovingObjectPosition(final MovingObjectType llllllllllllllIIIlllIIIlIllIIIlI, final Vec3 llllllllllllllIIIlllIIIlIlIlllII, final EnumFacing llllllllllllllIIIlllIIIlIllIIIII, final BlockPos llllllllllllllIIIlllIIIlIlIlllll) {
        this.typeOfHit = llllllllllllllIIIlllIIIlIllIIIlI;
        this.field_178783_e = llllllllllllllIIIlllIIIlIlIlllll;
        this.field_178784_b = llllllllllllllIIIlllIIIlIllIIIII;
        this.hitVec = new Vec3(llllllllllllllIIIlllIIIlIlIlllII.xCoord, llllllllllllllIIIlllIIIlIlIlllII.yCoord, llllllllllllllIIIlllIIIlIlIlllII.zCoord);
    }
    
    public MovingObjectPosition(final Entity llllllllllllllIIIlllIIIlIlIlIIlI, final Vec3 llllllllllllllIIIlllIIIlIlIlIlII) {
        this.typeOfHit = MovingObjectType.ENTITY;
        this.entityHit = llllllllllllllIIIlllIIIlIlIlIIlI;
        this.hitVec = llllllllllllllIIIlllIIIlIlIlIlII;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("HitResult{type=").append(this.typeOfHit).append(", blockpos=").append(this.field_178783_e).append(", f=").append(this.field_178784_b).append(", pos=").append(this.hitVec).append(", entity=").append(this.entityHit).append('}'));
    }
    
    public MovingObjectPosition(final Entity llllllllllllllIIIlllIIIlIllIlIll) {
        this(llllllllllllllIIIlllIIIlIllIlIll, new Vec3(llllllllllllllIIIlllIIIlIllIlIll.posX, llllllllllllllIIIlllIIIlIllIlIll.posY, llllllllllllllIIIlllIIIlIllIlIll.posZ));
    }
    
    public BlockPos func_178782_a() {
        return this.field_178783_e;
    }
    
    public enum MovingObjectType
    {
        MISS("MISS", 0, "MISS", 0), 
        ENTITY("ENTITY", 2, "ENTITY", 2), 
        BLOCK("BLOCK", 1, "BLOCK", 1);
        
        private MovingObjectType(final String llllllllllllllIlllIIllIllllIllll, final int llllllllllllllIlllIIllIllllIlllI, final String llllllllllllllIlllIIllIlllllIIlI, final int llllllllllllllIlllIIllIlllllIIIl) {
        }
        
        static {
            __OBFID = "CL_00000611";
        }
    }
}
