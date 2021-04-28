package net.minecraft.entity.item;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;

public class EntityMinecartEmpty extends EntityMinecart
{
    static {
        __OBFID = "CL_00001677";
    }
    
    public EntityMinecartEmpty(final World lllllllllllllIllllllllIlIIIllllI) {
        super(lllllllllllllIllllllllIlIIIllllI);
    }
    
    @Override
    public void onActivatorRailPass(final int lllllllllllllIllllllllIlIIIIIIll, final int lllllllllllllIllllllllIlIIIIIIlI, final int lllllllllllllIllllllllIlIIIIIIIl, final boolean lllllllllllllIllllllllIlIIIIIIII) {
        if (lllllllllllllIllllllllIlIIIIIIII) {
            if (this.riddenByEntity != null) {
                this.riddenByEntity.mountEntity(null);
            }
            if (this.getRollingAmplitude() == 0) {
                this.setRollingDirection(-this.getRollingDirection());
                this.setRollingAmplitude(10);
                this.setDamage(50.0f);
                this.setBeenAttacked();
            }
        }
    }
    
    public EntityMinecartEmpty(final World lllllllllllllIllllllllIlIIIlIlIl, final double lllllllllllllIllllllllIlIIIlIlII, final double lllllllllllllIllllllllIlIIIlIIll, final double lllllllllllllIllllllllIlIIIlIIlI) {
        super(lllllllllllllIllllllllIlIIIlIlIl, lllllllllllllIllllllllIlIIIlIlII, lllllllllllllIllllllllIlIIIlIIll, lllllllllllllIllllllllIlIIIlIIlI);
    }
    
    @Override
    public boolean interactFirst(final EntityPlayer lllllllllllllIllllllllIlIIIIIlll) {
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != lllllllllllllIllllllllIlIIIIIlll) {
            return true;
        }
        if (this.riddenByEntity != null && this.riddenByEntity != lllllllllllllIllllllllIlIIIIIlll) {
            return false;
        }
        if (!this.worldObj.isRemote) {
            lllllllllllllIllllllllIlIIIIIlll.mountEntity(this);
        }
        return true;
    }
    
    @Override
    public EnumMinecartType func_180456_s() {
        return EnumMinecartType.RIDEABLE;
    }
}
