package net.minecraft.entity;

import net.minecraft.world.*;
import net.minecraft.block.*;
import net.minecraft.nbt.*;
import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class EntityLeashKnot extends EntityHanging
{
    public static EntityLeashKnot func_174862_a(final World lllllllllllllllIlIlIIlIlIlllIIII, final BlockPos lllllllllllllllIlIlIIlIlIllIllII) {
        final EntityLeashKnot lllllllllllllllIlIlIIlIlIllIlllI = new EntityLeashKnot(lllllllllllllllIlIlIIlIlIlllIIII, lllllllllllllllIlIlIIlIlIllIllII);
        lllllllllllllllIlIlIIlIlIllIlllI.forceSpawn = true;
        lllllllllllllllIlIlIIlIlIlllIIII.spawnEntityInWorld(lllllllllllllllIlIlIIlIlIllIlllI);
        return lllllllllllllllIlIlIIlIlIllIlllI;
    }
    
    @Override
    public boolean onValidSurface() {
        return this.worldObj.getBlockState(this.field_174861_a).getBlock() instanceof BlockFence;
    }
    
    public EntityLeashKnot(final World lllllllllllllllIlIlIIlIllIlllIll) {
        super(lllllllllllllllIlIlIIlIllIlllIll);
    }
    
    @Override
    public boolean writeToNBTOptional(final NBTTagCompound lllllllllllllllIlIlIIlIllIIlIlll) {
        return false;
    }
    
    static {
        __OBFID = "CL_00001548";
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllllIlIlIIlIllIIlIIll) {
    }
    
    public EntityLeashKnot(final World lllllllllllllllIlIlIIlIllIlIlIll, final BlockPos lllllllllllllllIlIlIIlIllIlIlIlI) {
        super(lllllllllllllllIlIlIIlIllIlIlIll, lllllllllllllllIlIlIIlIllIlIlIlI);
        this.setPosition(lllllllllllllllIlIlIIlIllIlIlIlI.getX() + 0.5, lllllllllllllllIlIlIIlIllIlIlIlI.getY() + 0.5, lllllllllllllllIlIlIIlIllIlIlIlI.getZ() + 0.5);
        final float lllllllllllllllIlIlIIlIllIlIllll = 0.125f;
        final float lllllllllllllllIlIlIIlIllIlIlllI = 0.1875f;
        final float lllllllllllllllIlIlIIlIllIlIllIl = 0.25f;
        this.func_174826_a(new AxisAlignedBB(this.posX - 0.1875, this.posY - 0.25 + 0.125, this.posZ - 0.1875, this.posX + 0.1875, this.posY + 0.25 + 0.125, this.posZ + 0.1875));
    }
    
    @Override
    public boolean isInRangeToRenderDist(final double lllllllllllllllIlIlIIlIllIIlllII) {
        return lllllllllllllllIlIlIIlIllIIlllII < 1024.0;
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
    }
    
    @Override
    public void onBroken(final Entity lllllllllllllllIlIlIIlIllIIllIIl) {
    }
    
    @Override
    public float getEyeHeight() {
        return -0.0625f;
    }
    
    @Override
    public int getHeightPixels() {
        return 9;
    }
    
    public static EntityLeashKnot func_174863_b(final World lllllllllllllllIlIlIIlIlIlIllIlI, final BlockPos lllllllllllllllIlIlIIlIlIllIIIIl) {
        final int lllllllllllllllIlIlIIlIlIllIIIII = lllllllllllllllIlIlIIlIlIllIIIIl.getX();
        final int lllllllllllllllIlIlIIlIlIlIlllll = lllllllllllllllIlIlIIlIlIllIIIIl.getY();
        final int lllllllllllllllIlIlIIlIlIlIllllI = lllllllllllllllIlIlIIlIlIllIIIIl.getZ();
        final List lllllllllllllllIlIlIIlIlIlIlllIl = lllllllllllllllIlIlIIlIlIlIllIlI.getEntitiesWithinAABB(EntityLeashKnot.class, new AxisAlignedBB(lllllllllllllllIlIlIIlIlIllIIIII - 1.0, lllllllllllllllIlIlIIlIlIlIlllll - 1.0, lllllllllllllllIlIlIIlIlIlIllllI - 1.0, lllllllllllllllIlIlIIlIlIllIIIII + 1.0, lllllllllllllllIlIlIIlIlIlIlllll + 1.0, lllllllllllllllIlIlIIlIlIlIllllI + 1.0));
        for (final EntityLeashKnot lllllllllllllllIlIlIIlIlIlIllIll : lllllllllllllllIlIlIIlIlIlIlllIl) {
            if (lllllllllllllllIlIlIIlIlIlIllIll.func_174857_n().equals(lllllllllllllllIlIlIIlIlIllIIIIl)) {
                return lllllllllllllllIlIlIIlIlIlIllIll;
            }
        }
        return null;
    }
    
    @Override
    public boolean interactFirst(final EntityPlayer lllllllllllllllIlIlIIlIlIlllllIl) {
        final ItemStack lllllllllllllllIlIlIIlIllIIIlIII = lllllllllllllllIlIlIIlIlIlllllIl.getHeldItem();
        boolean lllllllllllllllIlIlIIlIllIIIIlll = false;
        if (lllllllllllllllIlIlIIlIllIIIlIII != null && lllllllllllllllIlIlIIlIllIIIlIII.getItem() == Items.lead && !this.worldObj.isRemote) {
            final double lllllllllllllllIlIlIIlIllIIIIllI = 7.0;
            final List lllllllllllllllIlIlIIlIllIIIIlII = this.worldObj.getEntitiesWithinAABB(EntityLiving.class, new AxisAlignedBB(this.posX - lllllllllllllllIlIlIIlIllIIIIllI, this.posY - lllllllllllllllIlIlIIlIllIIIIllI, this.posZ - lllllllllllllllIlIlIIlIllIIIIllI, this.posX + lllllllllllllllIlIlIIlIllIIIIllI, this.posY + lllllllllllllllIlIlIIlIllIIIIllI, this.posZ + lllllllllllllllIlIlIIlIllIIIIllI));
            for (final EntityLiving lllllllllllllllIlIlIIlIllIIIIIII : lllllllllllllllIlIlIIlIllIIIIlII) {
                if (lllllllllllllllIlIlIIlIllIIIIIII.getLeashed() && lllllllllllllllIlIlIIlIllIIIIIII.getLeashedToEntity() == lllllllllllllllIlIlIIlIlIlllllIl) {
                    lllllllllllllllIlIlIIlIllIIIIIII.setLeashedToEntity(this, true);
                    lllllllllllllllIlIlIIlIllIIIIlll = true;
                }
            }
        }
        if (!this.worldObj.isRemote && !lllllllllllllllIlIlIIlIllIIIIlll) {
            this.setDead();
            if (lllllllllllllllIlIlIIlIlIlllllIl.capabilities.isCreativeMode) {
                final double lllllllllllllllIlIlIIlIllIIIIlIl = 7.0;
                final List lllllllllllllllIlIlIIlIllIIIIIll = this.worldObj.getEntitiesWithinAABB(EntityLiving.class, new AxisAlignedBB(this.posX - lllllllllllllllIlIlIIlIllIIIIlIl, this.posY - lllllllllllllllIlIlIIlIllIIIIlIl, this.posZ - lllllllllllllllIlIlIIlIllIIIIlIl, this.posX + lllllllllllllllIlIlIIlIllIIIIlIl, this.posY + lllllllllllllllIlIlIIlIllIIIIlIl, this.posZ + lllllllllllllllIlIlIIlIllIIIIlIl));
                for (final EntityLiving lllllllllllllllIlIlIIlIlIlllllll : lllllllllllllllIlIlIIlIllIIIIIll) {
                    if (lllllllllllllllIlIlIIlIlIlllllll.getLeashed() && lllllllllllllllIlIlIIlIlIlllllll.getLeashedToEntity() == this) {
                        lllllllllllllllIlIlIIlIlIlllllll.clearLeashed(true, false);
                    }
                }
            }
        }
        return true;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllllIlIlIIlIllIIlIlIl) {
    }
    
    @Override
    public int getWidthPixels() {
        return 9;
    }
    
    public void func_174859_a(final EnumFacing lllllllllllllllIlIlIIlIllIlIIIlI) {
    }
}
