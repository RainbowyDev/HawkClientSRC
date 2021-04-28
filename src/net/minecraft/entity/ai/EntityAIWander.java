package net.minecraft.entity.ai;

import net.minecraft.entity.*;
import net.minecraft.util.*;

public class EntityAIWander extends EntityAIBase
{
    private /* synthetic */ double yPosition;
    private /* synthetic */ boolean field_179482_g;
    private /* synthetic */ int field_179481_f;
    private /* synthetic */ double zPosition;
    private /* synthetic */ double speed;
    private /* synthetic */ double xPosition;
    private /* synthetic */ EntityCreature entity;
    
    static {
        __OBFID = "CL_00001608";
    }
    
    public EntityAIWander(final EntityCreature llllllllllllllIIllllllIIIlIIllIl, final double llllllllllllllIIllllllIIIlIIllII, final int llllllllllllllIIllllllIIIlIIlIll) {
        this.entity = llllllllllllllIIllllllIIIlIIllIl;
        this.speed = llllllllllllllIIllllllIIIlIIllII;
        this.field_179481_f = llllllllllllllIIllllllIIIlIIlIll;
        this.setMutexBits(1);
    }
    
    @Override
    public boolean shouldExecute() {
        if (!this.field_179482_g) {
            if (this.entity.getAge() >= 100) {
                return false;
            }
            if (this.entity.getRNG().nextInt(this.field_179481_f) != 0) {
                return false;
            }
        }
        final Vec3 llllllllllllllIIllllllIIIlIIIlll = RandomPositionGenerator.findRandomTarget(this.entity, 10, 7);
        if (llllllllllllllIIllllllIIIlIIIlll == null) {
            return false;
        }
        this.xPosition = llllllllllllllIIllllllIIIlIIIlll.xCoord;
        this.yPosition = llllllllllllllIIllllllIIIlIIIlll.yCoord;
        this.zPosition = llllllllllllllIIllllllIIIlIIIlll.zCoord;
        this.field_179482_g = false;
        return true;
    }
    
    @Override
    public void startExecuting() {
        this.entity.getNavigator().tryMoveToXYZ(this.xPosition, this.yPosition, this.zPosition, this.speed);
    }
    
    @Override
    public boolean continueExecuting() {
        return !this.entity.getNavigator().noPath();
    }
    
    public EntityAIWander(final EntityCreature llllllllllllllIIllllllIIIlIllIII, final double llllllllllllllIIllllllIIIlIlIlll) {
        this(llllllllllllllIIllllllIIIlIllIII, llllllllllllllIIllllllIIIlIlIlll, 120);
    }
    
    public void func_179480_f() {
        this.field_179482_g = true;
    }
    
    public void func_179479_b(final int llllllllllllllIIllllllIIIIlllIII) {
        this.field_179481_f = llllllllllllllIIllllllIIIIlllIII;
    }
}
