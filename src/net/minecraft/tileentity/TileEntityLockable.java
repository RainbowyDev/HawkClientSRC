package net.minecraft.tileentity;

import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.nbt.*;

public abstract class TileEntityLockable extends TileEntity implements IInteractionObject, ILockableContainer
{
    private /* synthetic */ LockCode code;
    
    static {
        __OBFID = "CL_00002040";
    }
    
    @Override
    public void setLockCode(final LockCode llllllllllllllIIIllIllllIIIIllIl) {
        this.code = llllllllllllllIIIllIllllIIIIllIl;
    }
    
    @Override
    public IChatComponent getDisplayName() {
        return this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatComponentTranslation(this.getName(), new Object[0]);
    }
    
    @Override
    public LockCode getLockCode() {
        return this.code;
    }
    
    @Override
    public void writeToNBT(final NBTTagCompound llllllllllllllIIIllIllllIIIlIlll) {
        super.writeToNBT(llllllllllllllIIIllIllllIIIlIlll);
        if (this.code != null) {
            this.code.toNBT(llllllllllllllIIIllIllllIIIlIlll);
        }
    }
    
    public TileEntityLockable() {
        this.code = LockCode.EMPTY_CODE;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllllIIIllIllllIIIlllll) {
        super.readFromNBT(llllllllllllllIIIllIllllIIIlllll);
        this.code = LockCode.fromNBT(llllllllllllllIIIllIllllIIIlllll);
    }
    
    @Override
    public boolean isLocked() {
        return this.code != null && !this.code.isEmpty();
    }
}
