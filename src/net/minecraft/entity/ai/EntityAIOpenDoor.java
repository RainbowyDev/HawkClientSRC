package net.minecraft.entity.ai;

import net.minecraft.entity.*;

public class EntityAIOpenDoor extends EntityAIDoorInteract
{
    /* synthetic */ int closeDoorTemporisation;
    /* synthetic */ boolean closeDoor;
    
    @Override
    public void updateTask() {
        --this.closeDoorTemporisation;
        super.updateTask();
    }
    
    public EntityAIOpenDoor(final EntityLiving lllllllllllllllIIlllIlIlllllIllI, final boolean lllllllllllllllIIlllIlIlllllIIlI) {
        super(lllllllllllllllIIlllIlIlllllIllI);
        this.theEntity = lllllllllllllllIIlllIlIlllllIllI;
        this.closeDoor = lllllllllllllllIIlllIlIlllllIIlI;
    }
    
    static {
        __OBFID = "CL_00001603";
    }
    
    @Override
    public void resetTask() {
        if (this.closeDoor) {
            this.doorBlock.func_176512_a(this.theEntity.worldObj, this.field_179507_b, false);
        }
    }
    
    @Override
    public void startExecuting() {
        this.closeDoorTemporisation = 20;
        this.doorBlock.func_176512_a(this.theEntity.worldObj, this.field_179507_b, true);
    }
    
    @Override
    public boolean continueExecuting() {
        return this.closeDoor && this.closeDoorTemporisation > 0 && super.continueExecuting();
    }
}
