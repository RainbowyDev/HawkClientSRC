package net.minecraft.entity.projectile;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.item.*;

public class EntityEgg extends EntityThrowable
{
    public EntityEgg(final World llllllllllllllIlIllllIllIllIllll, final double llllllllllllllIlIllllIllIlllIIll, final double llllllllllllllIlIllllIllIlllIIlI, final double llllllllllllllIlIllllIllIlllIIIl) {
        super(llllllllllllllIlIllllIllIllIllll, llllllllllllllIlIllllIllIlllIIll, llllllllllllllIlIllllIllIlllIIlI, llllllllllllllIlIllllIllIlllIIIl);
    }
    
    static {
        __OBFID = "CL_00001724";
    }
    
    public EntityEgg(final World llllllllllllllIlIllllIllIlllllII, final EntityLivingBase llllllllllllllIlIllllIllIllllIll) {
        super(llllllllllllllIlIllllIllIlllllII, llllllllllllllIlIllllIllIllllIll);
    }
    
    @Override
    protected void onImpact(final MovingObjectPosition llllllllllllllIlIllllIllIlIllllI) {
        if (llllllllllllllIlIllllIllIlIllllI.entityHit != null) {
            llllllllllllllIlIllllIllIlIllllI.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0f);
        }
        if (!this.worldObj.isRemote && this.rand.nextInt(8) == 0) {
            byte llllllllllllllIlIllllIllIllIIlII = 1;
            if (this.rand.nextInt(32) == 0) {
                llllllllllllllIlIllllIllIllIIlII = 4;
            }
            for (int llllllllllllllIlIllllIllIllIIIll = 0; llllllllllllllIlIllllIllIllIIIll < llllllllllllllIlIllllIllIllIIlII; ++llllllllllllllIlIllllIllIllIIIll) {
                final EntityChicken llllllllllllllIlIllllIllIllIIIlI = new EntityChicken(this.worldObj);
                llllllllllllllIlIllllIllIllIIIlI.setGrowingAge(-24000);
                llllllllllllllIlIllllIllIllIIIlI.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                this.worldObj.spawnEntityInWorld(llllllllllllllIlIllllIllIllIIIlI);
            }
        }
        final double llllllllllllllIlIllllIllIllIIIIl = 0.08;
        for (int llllllllllllllIlIllllIllIllIIIII = 0; llllllllllllllIlIllllIllIllIIIII < 8; ++llllllllllllllIlIllllIllIllIIIII) {
            this.worldObj.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX, this.posY, this.posZ, (this.rand.nextFloat() - 0.5) * 0.08, (this.rand.nextFloat() - 0.5) * 0.08, (this.rand.nextFloat() - 0.5) * 0.08, Item.getIdFromItem(Items.egg));
        }
        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }
    
    public EntityEgg(final World llllllllllllllIlIllllIlllIIIIllI) {
        super(llllllllllllllIlIllllIlllIIIIllI);
    }
}
