package net.minecraft.entity.projectile;

import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.nbt.*;

public class EntityPotion extends EntityThrowable
{
    private /* synthetic */ ItemStack potionDamage;
    
    public EntityPotion(final World lllllllllllllllIIIIlIlIlIIIlIIIl, final EntityLivingBase lllllllllllllllIIIIlIlIlIIIlIIII, final ItemStack lllllllllllllllIIIIlIlIlIIIlIIll) {
        super(lllllllllllllllIIIIlIlIlIIIlIIIl, lllllllllllllllIIIIlIlIlIIIlIIII);
        this.potionDamage = lllllllllllllllIIIIlIlIlIIIlIIll;
    }
    
    public EntityPotion(final World lllllllllllllllIIIIlIlIlIIIIIIIl, final double lllllllllllllllIIIIlIlIlIIIIIIII, final double lllllllllllllllIIIIlIlIIllllllll, final double lllllllllllllllIIIIlIlIlIIIIIlII, final int lllllllllllllllIIIIlIlIlIIIIIIll) {
        this(lllllllllllllllIIIIlIlIlIIIIIIIl, lllllllllllllllIIIIlIlIlIIIIIIII, lllllllllllllllIIIIlIlIIllllllll, lllllllllllllllIIIIlIlIlIIIIIlII, new ItemStack(Items.potionitem, 1, lllllllllllllllIIIIlIlIlIIIIIIll));
    }
    
    @Override
    protected float getGravityVelocity() {
        return 0.05f;
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllllIIIIlIlIIlIllIlII) {
        super.readEntityFromNBT(lllllllllllllllIIIIlIlIIlIllIlII);
        if (lllllllllllllllIIIIlIlIIlIllIlII.hasKey("Potion", 10)) {
            this.potionDamage = ItemStack.loadItemStackFromNBT(lllllllllllllllIIIIlIlIIlIllIlII.getCompoundTag("Potion"));
        }
        else {
            this.setPotionDamage(lllllllllllllllIIIIlIlIIlIllIlII.getInteger("potionValue"));
        }
        if (this.potionDamage == null) {
            this.setDead();
        }
    }
    
    public EntityPotion(final World lllllllllllllllIIIIlIlIIllllIlIl, final double lllllllllllllllIIIIlIlIIllllIlII, final double lllllllllllllllIIIIlIlIIlllIllIl, final double lllllllllllllllIIIIlIlIIlllIllII, final ItemStack lllllllllllllllIIIIlIlIIlllIlIll) {
        super(lllllllllllllllIIIIlIlIIllllIlIl, lllllllllllllllIIIIlIlIIllllIlII, lllllllllllllllIIIIlIlIIlllIllIl, lllllllllllllllIIIIlIlIIlllIllII);
        this.potionDamage = lllllllllllllllIIIIlIlIIlllIlIll;
    }
    
    public EntityPotion(final World lllllllllllllllIIIIlIlIlIIlIIIIl, final EntityLivingBase lllllllllllllllIIIIlIlIlIIlIIIII, final int lllllllllllllllIIIIlIlIlIIIlllll) {
        this(lllllllllllllllIIIIlIlIlIIlIIIIl, lllllllllllllllIIIIlIlIlIIlIIIII, new ItemStack(Items.potionitem, 1, lllllllllllllllIIIIlIlIlIIIlllll));
    }
    
    @Override
    protected void onImpact(final MovingObjectPosition lllllllllllllllIIIIlIlIIllIIIIll) {
        if (!this.worldObj.isRemote) {
            final List lllllllllllllllIIIIlIlIIllIIllll = Items.potionitem.getEffects(this.potionDamage);
            if (lllllllllllllllIIIIlIlIIllIIllll != null && !lllllllllllllllIIIIlIlIIllIIllll.isEmpty()) {
                final AxisAlignedBB lllllllllllllllIIIIlIlIIllIIlllI = this.getEntityBoundingBox().expand(4.0, 2.0, 4.0);
                final List lllllllllllllllIIIIlIlIIllIIllIl = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, lllllllllllllllIIIIlIlIIllIIlllI);
                if (!lllllllllllllllIIIIlIlIIllIIllIl.isEmpty()) {
                    for (final EntityLivingBase lllllllllllllllIIIIlIlIIllIIlIll : lllllllllllllllIIIIlIlIIllIIllIl) {
                        final double lllllllllllllllIIIIlIlIIllIIlIlI = this.getDistanceSqToEntity(lllllllllllllllIIIIlIlIIllIIlIll);
                        if (lllllllllllllllIIIIlIlIIllIIlIlI < 16.0) {
                            double lllllllllllllllIIIIlIlIIllIIlIIl = 1.0 - Math.sqrt(lllllllllllllllIIIIlIlIIllIIlIlI) / 4.0;
                            if (lllllllllllllllIIIIlIlIIllIIlIll == lllllllllllllllIIIIlIlIIllIIIIll.entityHit) {
                                lllllllllllllllIIIIlIlIIllIIlIIl = 1.0;
                            }
                            for (final PotionEffect lllllllllllllllIIIIlIlIIllIIIlll : lllllllllllllllIIIIlIlIIllIIllll) {
                                final int lllllllllllllllIIIIlIlIIllIIIllI = lllllllllllllllIIIIlIlIIllIIIlll.getPotionID();
                                if (Potion.potionTypes[lllllllllllllllIIIIlIlIIllIIIllI].isInstant()) {
                                    Potion.potionTypes[lllllllllllllllIIIIlIlIIllIIIllI].func_180793_a(this, this.getThrower(), lllllllllllllllIIIIlIlIIllIIlIll, lllllllllllllllIIIIlIlIIllIIIlll.getAmplifier(), lllllllllllllllIIIIlIlIIllIIlIIl);
                                }
                                else {
                                    final int lllllllllllllllIIIIlIlIIllIIIlIl = (int)(lllllllllllllllIIIIlIlIIllIIlIIl * lllllllllllllllIIIIlIlIIllIIIlll.getDuration() + 0.5);
                                    if (lllllllllllllllIIIIlIlIIllIIIlIl <= 20) {
                                        continue;
                                    }
                                    lllllllllllllllIIIIlIlIIllIIlIll.addPotionEffect(new PotionEffect(lllllllllllllllIIIIlIlIIllIIIllI, lllllllllllllllIIIIlIlIIllIIIlIl, lllllllllllllllIIIIlIlIIllIIIlll.getAmplifier()));
                                }
                            }
                        }
                    }
                }
            }
            this.worldObj.playAuxSFX(2002, new BlockPos(this), this.getPotionDamage());
            this.setDead();
        }
    }
    
    public EntityPotion(final World lllllllllllllllIIIIlIlIlIIlIlIIl) {
        super(lllllllllllllllIIIIlIlIlIIlIlIIl);
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllllIIIIlIlIIlIlIllII) {
        super.writeEntityToNBT(lllllllllllllllIIIIlIlIIlIlIllII);
        if (this.potionDamage != null) {
            lllllllllllllllIIIIlIlIIlIlIllII.setTag("Potion", this.potionDamage.writeToNBT(new NBTTagCompound()));
        }
    }
    
    @Override
    protected float func_70183_g() {
        return -20.0f;
    }
    
    static {
        __OBFID = "CL_00001727";
    }
    
    public int getPotionDamage() {
        if (this.potionDamage == null) {
            this.potionDamage = new ItemStack(Items.potionitem, 1, 0);
        }
        return this.potionDamage.getMetadata();
    }
    
    @Override
    protected float func_70182_d() {
        return 0.5f;
    }
    
    public void setPotionDamage(final int lllllllllllllllIIIIlIlIIlllIIIlI) {
        if (this.potionDamage == null) {
            this.potionDamage = new ItemStack(Items.potionitem, 1, 0);
        }
        this.potionDamage.setItemDamage(lllllllllllllllIIIIlIlIIlllIIIlI);
    }
}
