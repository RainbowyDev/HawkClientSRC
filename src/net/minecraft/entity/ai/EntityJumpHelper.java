package net.minecraft.entity.ai;

import net.minecraft.entity.*;

public class EntityJumpHelper
{
    private /* synthetic */ EntityLiving entity;
    protected /* synthetic */ boolean isJumping;
    
    public void setJumping() {
        this.isJumping = true;
    }
    
    static {
        __OBFID = "CL_00001571";
    }
    
    public void doJump() {
        this.entity.setJumping(this.isJumping);
        this.isJumping = false;
    }
    
    public EntityJumpHelper(final EntityLiving lIIIlllllIlIll) {
        this.entity = lIIIlllllIlIll;
    }
}
