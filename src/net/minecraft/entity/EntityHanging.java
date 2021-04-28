package net.minecraft.entity;

import net.minecraft.world.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import java.util.*;
import org.apache.commons.lang3.*;

public abstract class EntityHanging extends Entity
{
    protected /* synthetic */ BlockPos field_174861_a;
    private /* synthetic */ int tickCounter1;
    public /* synthetic */ EnumFacing field_174860_b;
    
    public EntityHanging(final World llllllllllllllIIIIlIIIlIllllIIII) {
        super(llllllllllllllIIIIlIIIlIllllIIII);
        this.setSize(0.5f, 0.5f);
    }
    
    @Override
    public boolean canBeCollidedWith() {
        return true;
    }
    
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllIIIIlIIIlIIlIlllll) {
        this.field_174861_a = new BlockPos(llllllllllllllIIIIlIIIlIIlIlllll.getInteger("TileX"), llllllllllllllIIIIlIIIlIIlIlllll.getInteger("TileY"), llllllllllllllIIIIlIIIlIIlIlllll.getInteger("TileZ"));
        EnumFacing llllllllllllllIIIIlIIIlIIllIIIIl = null;
        if (llllllllllllllIIIIlIIIlIIlIlllll.hasKey("Direction", 99)) {
            final EnumFacing llllllllllllllIIIIlIIIlIIllIIIll = EnumFacing.getHorizontal(llllllllllllllIIIIlIIIlIIlIlllll.getByte("Direction"));
            this.field_174861_a = this.field_174861_a.offset(llllllllllllllIIIIlIIIlIIllIIIll);
        }
        else if (llllllllllllllIIIIlIIIlIIlIlllll.hasKey("Facing", 99)) {
            final EnumFacing llllllllllllllIIIIlIIIlIIllIIIlI = EnumFacing.getHorizontal(llllllllllllllIIIIlIIIlIIlIlllll.getByte("Facing"));
        }
        else {
            llllllllllllllIIIIlIIIlIIllIIIIl = EnumFacing.getHorizontal(llllllllllllllIIIIlIIIlIIlIlllll.getByte("Dir"));
        }
        this.func_174859_a(llllllllllllllIIIIlIIIlIIllIIIIl);
    }
    
    @Override
    protected boolean shouldSetPosAfterLoading() {
        return false;
    }
    
    @Override
    public void addVelocity(final double llllllllllllllIIIIlIIIlIIlllIlIl, final double llllllllllllllIIIIlIIIlIIlllIlII, final double llllllllllllllIIIIlIIIlIIllIllll) {
        if (!this.worldObj.isRemote && !this.isDead && llllllllllllllIIIIlIIIlIIlllIlIl * llllllllllllllIIIIlIIIlIIlllIlIl + llllllllllllllIIIIlIIIlIIlllIlII * llllllllllllllIIIIlIIIlIIlllIlII + llllllllllllllIIIIlIIIlIIllIllll * llllllllllllllIIIIlIIIlIIllIllll > 0.0) {
            this.setDead();
            this.onBroken(null);
        }
    }
    
    @Override
    public boolean hitByEntity(final Entity llllllllllllllIIIIlIIIlIlIIlIIll) {
        return llllllllllllllIIIIlIIIlIlIIlIIll instanceof EntityPlayer && this.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)llllllllllllllIIIIlIIIlIlIIlIIll), 0.0f);
    }
    
    static {
        __OBFID = "CL_00001546";
    }
    
    public BlockPos func_174857_n() {
        return this.field_174861_a;
    }
    
    private void func_174856_o() {
        if (this.field_174860_b != null) {
            double llllllllllllllIIIIlIIIlIllIlIIIl = this.field_174861_a.getX() + 0.5;
            double llllllllllllllIIIIlIIIlIllIlIIII = this.field_174861_a.getY() + 0.5;
            double llllllllllllllIIIIlIIIlIllIIllll = this.field_174861_a.getZ() + 0.5;
            final double llllllllllllllIIIIlIIIlIllIIlllI = 0.46875;
            final double llllllllllllllIIIIlIIIlIllIIllIl = this.func_174858_a(this.getWidthPixels());
            final double llllllllllllllIIIIlIIIlIllIIllII = this.func_174858_a(this.getHeightPixels());
            llllllllllllllIIIIlIIIlIllIlIIIl -= this.field_174860_b.getFrontOffsetX() * 0.46875;
            llllllllllllllIIIIlIIIlIllIIllll -= this.field_174860_b.getFrontOffsetZ() * 0.46875;
            llllllllllllllIIIIlIIIlIllIlIIII += llllllllllllllIIIIlIIIlIllIIllII;
            final EnumFacing llllllllllllllIIIIlIIIlIllIIlIll = this.field_174860_b.rotateYCCW();
            llllllllllllllIIIIlIIIlIllIlIIIl += llllllllllllllIIIIlIIIlIllIIllIl * llllllllllllllIIIIlIIIlIllIIlIll.getFrontOffsetX();
            llllllllllllllIIIIlIIIlIllIIllll += llllllllllllllIIIIlIIIlIllIIllIl * llllllllllllllIIIIlIIIlIllIIlIll.getFrontOffsetZ();
            this.posX = llllllllllllllIIIIlIIIlIllIlIIIl;
            this.posY = llllllllllllllIIIIlIIIlIllIlIIII;
            this.posZ = llllllllllllllIIIIlIIIlIllIIllll;
            double llllllllllllllIIIIlIIIlIllIIlIlI = this.getWidthPixels();
            double llllllllllllllIIIIlIIIlIllIIlIIl = this.getHeightPixels();
            double llllllllllllllIIIIlIIIlIllIIlIII = this.getWidthPixels();
            if (this.field_174860_b.getAxis() == EnumFacing.Axis.Z) {
                llllllllllllllIIIIlIIIlIllIIlIII = 1.0;
            }
            else {
                llllllllllllllIIIIlIIIlIllIIlIlI = 1.0;
            }
            llllllllllllllIIIIlIIIlIllIIlIlI /= 32.0;
            llllllllllllllIIIIlIIIlIllIIlIIl /= 32.0;
            llllllllllllllIIIIlIIIlIllIIlIII /= 32.0;
            this.func_174826_a(new AxisAlignedBB(llllllllllllllIIIIlIIIlIllIlIIIl - llllllllllllllIIIIlIIIlIllIIlIlI, llllllllllllllIIIIlIIIlIllIlIIII - llllllllllllllIIIIlIIIlIllIIlIIl, llllllllllllllIIIIlIIIlIllIIllll - llllllllllllllIIIIlIIIlIllIIlIII, llllllllllllllIIIIlIIIlIllIlIIIl + llllllllllllllIIIIlIIIlIllIIlIlI, llllllllllllllIIIIlIIIlIllIlIIII + llllllllllllllIIIIlIIIlIllIIlIIl, llllllllllllllIIIIlIIIlIllIIllll + llllllllllllllIIIIlIIIlIllIIlIII));
        }
    }
    
    public abstract int getWidthPixels();
    
    public abstract void onBroken(final Entity p0);
    
    public EntityHanging(final World llllllllllllllIIIIlIIIlIlllIlIIl, final BlockPos llllllllllllllIIIIlIIIlIlllIlIII) {
        this(llllllllllllllIIIIlIIIlIlllIlIIl);
        this.field_174861_a = llllllllllllllIIIIlIIIlIlllIlIII;
    }
    
    public boolean onValidSurface() {
        if (!this.worldObj.getCollidingBoundingBoxes(this, this.getEntityBoundingBox()).isEmpty()) {
            return false;
        }
        final int llllllllllllllIIIIlIIIlIlIlIlIll = Math.max(1, this.getWidthPixels() / 16);
        final int llllllllllllllIIIIlIIIlIlIlIlIlI = Math.max(1, this.getHeightPixels() / 16);
        final BlockPos llllllllllllllIIIIlIIIlIlIlIlIIl = this.field_174861_a.offset(this.field_174860_b.getOpposite());
        final EnumFacing llllllllllllllIIIIlIIIlIlIlIlIII = this.field_174860_b.rotateYCCW();
        for (int llllllllllllllIIIIlIIIlIlIlIIlll = 0; llllllllllllllIIIIlIIIlIlIlIIlll < llllllllllllllIIIIlIIIlIlIlIlIll; ++llllllllllllllIIIIlIIIlIlIlIIlll) {
            for (int llllllllllllllIIIIlIIIlIlIlIIllI = 0; llllllllllllllIIIIlIIIlIlIlIIllI < llllllllllllllIIIIlIIIlIlIlIlIlI; ++llllllllllllllIIIIlIIIlIlIlIIllI) {
                final BlockPos llllllllllllllIIIIlIIIlIlIlIIlIl = llllllllllllllIIIIlIIIlIlIlIlIIl.offset(llllllllllllllIIIIlIIIlIlIlIlIII, llllllllllllllIIIIlIIIlIlIlIIlll).offsetUp(llllllllllllllIIIIlIIIlIlIlIIllI);
                final Block llllllllllllllIIIIlIIIlIlIlIIlII = this.worldObj.getBlockState(llllllllllllllIIIIlIIIlIlIlIIlIl).getBlock();
                if (!llllllllllllllIIIIlIIIlIlIlIIlII.getMaterial().isSolid() && !BlockRedstoneDiode.isRedstoneRepeaterBlockID(llllllllllllllIIIIlIIIlIlIlIIlII)) {
                    return false;
                }
            }
        }
        final List llllllllllllllIIIIlIIIlIlIlIIIll = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox());
        for (final Entity llllllllllllllIIIIlIIIlIlIlIIIIl : llllllllllllllIIIIlIIIlIlIlIIIll) {
            if (llllllllllllllIIIIlIIIlIlIlIIIIl instanceof EntityHanging) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void setPosition(final double llllllllllllllIIIIlIIIlIIlIlIIIl, final double llllllllllllllIIIIlIIIlIIlIlIIII, final double llllllllllllllIIIIlIIIlIIlIIllll) {
        this.posX = llllllllllllllIIIIlIIIlIIlIlIIIl;
        this.posY = llllllllllllllIIIIlIIIlIIlIlIIII;
        this.posZ = llllllllllllllIIIIlIIIlIIlIIllll;
        final BlockPos llllllllllllllIIIIlIIIlIIlIlIIll = this.field_174861_a;
        this.field_174861_a = new BlockPos(llllllllllllllIIIIlIIIlIIlIlIIIl, llllllllllllllIIIIlIIIlIIlIlIIII, llllllllllllllIIIIlIIIlIIlIIllll);
        if (!this.field_174861_a.equals(llllllllllllllIIIIlIIIlIIlIlIIll)) {
            this.func_174856_o();
            this.isAirBorne = true;
        }
    }
    
    public abstract int getHeightPixels();
    
    @Override
    public void moveEntity(final double llllllllllllllIIIIlIIIlIIlllllIl, final double llllllllllllllIIIIlIIIlIIlllllII, final double llllllllllllllIIIIlIIIlIIllllIll) {
        if (!this.worldObj.isRemote && !this.isDead && llllllllllllllIIIIlIIIlIIlllllIl * llllllllllllllIIIIlIIIlIIlllllIl + llllllllllllllIIIIlIIIlIIlllllII * llllllllllllllIIIIlIIIlIIlllllII + llllllllllllllIIIIlIIIlIIllllIll * llllllllllllllIIIIlIIIlIIllllIll > 0.0) {
            this.setDead();
            this.onBroken(null);
        }
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllIIIIlIIIlIlIIIIlll, final float llllllllllllllIIIIlIIIlIlIIIlIIl) {
        if (this.func_180431_b(llllllllllllllIIIIlIIIlIlIIIIlll)) {
            return false;
        }
        if (!this.isDead && !this.worldObj.isRemote) {
            this.setDead();
            this.setBeenAttacked();
            this.onBroken(llllllllllllllIIIIlIIIlIlIIIIlll.getEntity());
        }
        return true;
    }
    
    private double func_174858_a(final int llllllllllllllIIIIlIIIlIlIlllIlI) {
        return (llllllllllllllIIIIlIIIlIlIlllIlI % 32 == 0) ? 0.5 : 0.0;
    }
    
    protected void func_174859_a(final EnumFacing llllllllllllllIIIIlIIIlIlllIIIII) {
        Validate.notNull((Object)llllllllllllllIIIIlIIIlIlllIIIII);
        Validate.isTrue(llllllllllllllIIIIlIIIlIlllIIIII.getAxis().isHorizontal());
        this.field_174860_b = llllllllllllllIIIIlIIIlIlllIIIII;
        final float n = (float)(this.field_174860_b.getHorizontalIndex() * 90);
        this.rotationYaw = n;
        this.prevRotationYaw = n;
        this.func_174856_o();
    }
    
    @Override
    public EnumFacing func_174811_aO() {
        return this.field_174860_b;
    }
    
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllIIIIlIIIlIIllIlIIl) {
        llllllllllllllIIIIlIIIlIIllIlIIl.setByte("Facing", (byte)this.field_174860_b.getHorizontalIndex());
        llllllllllllllIIIIlIIIlIIllIlIIl.setInteger("TileX", this.func_174857_n().getX());
        llllllllllllllIIIIlIIIlIIllIlIIl.setInteger("TileY", this.func_174857_n().getY());
        llllllllllllllIIIIlIIIlIIllIlIIl.setInteger("TileZ", this.func_174857_n().getZ());
    }
    
    @Override
    protected void entityInit() {
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.tickCounter1++ == 100 && !this.worldObj.isRemote) {
            this.tickCounter1 = 0;
            if (!this.isDead && !this.onValidSurface()) {
                this.setDead();
                this.onBroken(null);
            }
        }
    }
}
