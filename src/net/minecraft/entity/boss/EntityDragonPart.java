package net.minecraft.entity.boss;

import net.minecraft.entity.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;

public class EntityDragonPart extends Entity
{
    public final /* synthetic */ String field_146032_b;
    public final /* synthetic */ IEntityMultiPart entityDragonObj;
    
    static {
        __OBFID = "CL_00001657";
    }
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound lIIlllIlIIIIIl) {
    }
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound lIIlllIIllllll) {
    }
    
    public EntityDragonPart(final IEntityMultiPart lIIlllIlIIIlll, final String lIIlllIlIIIllI, final float lIIlllIlIIlIlI, final float lIIlllIlIIIlII) {
        super(lIIlllIlIIIlll.func_82194_d());
        this.setSize(lIIlllIlIIlIlI, lIIlllIlIIIlII);
        this.entityDragonObj = lIIlllIlIIIlll;
        this.field_146032_b = lIIlllIlIIIllI;
    }
    
    @Override
    protected void entityInit() {
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lIIlllIIlllIIl, final float lIIlllIIlllIII) {
        return !this.func_180431_b(lIIlllIIlllIIl) && this.entityDragonObj.attackEntityFromPart(this, lIIlllIIlllIIl, lIIlllIIlllIII);
    }
    
    @Override
    public boolean isEntityEqual(final Entity lIIlllIIlIllll) {
        return this == lIIlllIIlIllll || this.entityDragonObj == lIIlllIIlIllll;
    }
    
    @Override
    public boolean canBeCollidedWith() {
        return true;
    }
}
