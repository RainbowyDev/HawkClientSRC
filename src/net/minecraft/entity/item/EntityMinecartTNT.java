package net.minecraft.entity.item;

import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.nbt.*;

public class EntityMinecartTNT extends EntityMinecart
{
    private /* synthetic */ int minecartTNTFuse;
    
    static {
        __OBFID = "CL_00001680";
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.minecartTNTFuse > 0) {
            --this.minecartTNTFuse;
            this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY + 0.5, this.posZ, 0.0, 0.0, 0.0, new int[0]);
        }
        else if (this.minecartTNTFuse == 0) {
            this.explodeCart(this.motionX * this.motionX + this.motionZ * this.motionZ);
        }
        if (this.isCollidedHorizontally) {
            final double llllllllllllllllllIIllIlIlIIlIlI = this.motionX * this.motionX + this.motionZ * this.motionZ;
            if (llllllllllllllllllIIllIlIlIIlIlI >= 0.009999999776482582) {
                this.explodeCart(llllllllllllllllllIIllIlIlIIlIlI);
            }
        }
    }
    
    protected void explodeCart(final double llllllllllllllllllIIllIlIIlIlIII) {
        if (!this.worldObj.isRemote) {
            double llllllllllllllllllIIllIlIIlIlIlI = Math.sqrt(llllllllllllllllllIIllIlIIlIlIII);
            if (llllllllllllllllllIIllIlIIlIlIlI > 5.0) {
                llllllllllllllllllIIllIlIIlIlIlI = 5.0;
            }
            this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)(4.0 + this.rand.nextDouble() * 1.5 * llllllllllllllllllIIllIlIIlIlIlI), true);
            this.setDead();
        }
    }
    
    @Override
    public void handleHealthUpdate(final byte llllllllllllllllllIIllIlIIIIlllI) {
        if (llllllllllllllllllIIllIlIIIIlllI == 10) {
            this.ignite();
        }
        else {
            super.handleHealthUpdate(llllllllllllllllllIIllIlIIIIlllI);
        }
    }
    
    public EntityMinecartTNT(final World llllllllllllllllllIIllIlIlIlllll) {
        super(llllllllllllllllllIIllIlIlIlllll);
        this.minecartTNTFuse = -1;
    }
    
    @Override
    public float getExplosionResistance(final Explosion llllllllllllllllllIIllIIllllIlll, final World llllllllllllllllllIIllIIlllllIll, final BlockPos llllllllllllllllllIIllIIllllIlIl, final IBlockState llllllllllllllllllIIllIIllllIlII) {
        return (this.isIgnited() && (BlockRailBase.func_176563_d(llllllllllllllllllIIllIIllllIlII) || BlockRailBase.func_176562_d(llllllllllllllllllIIllIIlllllIll, llllllllllllllllllIIllIIllllIlIl.offsetUp()))) ? 0.0f : super.getExplosionResistance(llllllllllllllllllIIllIIllllIlll, llllllllllllllllllIIllIIlllllIll, llllllllllllllllllIIllIIllllIlIl, llllllllllllllllllIIllIIllllIlII);
    }
    
    @Override
    public void killMinecart(final DamageSource llllllllllllllllllIIllIlIIllIIIl) {
        super.killMinecart(llllllllllllllllllIIllIlIIllIIIl);
        final double llllllllllllllllllIIllIlIIllIIll = this.motionX * this.motionX + this.motionZ * this.motionZ;
        if (!llllllllllllllllllIIllIlIIllIIIl.isExplosion()) {
            this.entityDropItem(new ItemStack(Blocks.tnt, 1), 0.0f);
        }
        if (llllllllllllllllllIIllIlIIllIIIl.isFireDamage() || llllllllllllllllllIIllIlIIllIIIl.isExplosion() || llllllllllllllllllIIllIlIIllIIll >= 0.009999999776482582) {
            this.explodeCart(llllllllllllllllllIIllIlIIllIIll);
        }
    }
    
    public EntityMinecartTNT(final World llllllllllllllllllIIllIlIlIllIII, final double llllllllllllllllllIIllIlIlIlIlll, final double llllllllllllllllllIIllIlIlIlIllI, final double llllllllllllllllllIIllIlIlIlIIII) {
        super(llllllllllllllllllIIllIlIlIllIII, llllllllllllllllllIIllIlIlIlIlll, llllllllllllllllllIIllIlIlIlIllI, llllllllllllllllllIIllIlIlIlIIII);
        this.minecartTNTFuse = -1;
    }
    
    public boolean isIgnited() {
        return this.minecartTNTFuse > -1;
    }
    
    @Override
    public boolean func_174816_a(final Explosion llllllllllllllllllIIllIIlllIIllI, final World llllllllllllllllllIIllIIlllIlIll, final BlockPos llllllllllllllllllIIllIIlllIIlII, final IBlockState llllllllllllllllllIIllIIlllIIIll, final float llllllllllllllllllIIllIIlllIlIII) {
        return (!this.isIgnited() || (!BlockRailBase.func_176563_d(llllllllllllllllllIIllIIlllIIIll) && !BlockRailBase.func_176562_d(llllllllllllllllllIIllIIlllIlIll, llllllllllllllllllIIllIIlllIIlII.offsetUp()))) && super.func_174816_a(llllllllllllllllllIIllIIlllIIllI, llllllllllllllllllIIllIIlllIlIll, llllllllllllllllllIIllIIlllIIlII, llllllllllllllllllIIllIIlllIIIll, llllllllllllllllllIIllIIlllIlIII);
    }
    
    @Override
    public void fall(final float llllllllllllllllllIIllIlIIIlllIl, final float llllllllllllllllllIIllIlIIlIIIII) {
        if (llllllllllllllllllIIllIlIIIlllIl >= 3.0f) {
            final float llllllllllllllllllIIllIlIIIlllll = llllllllllllllllllIIllIlIIIlllIl / 10.0f;
            this.explodeCart(llllllllllllllllllIIllIlIIIlllll * llllllllllllllllllIIllIlIIIlllll);
        }
        super.fall(llllllllllllllllllIIllIlIIIlllIl, llllllllllllllllllIIllIlIIlIIIII);
    }
    
    public int func_94104_d() {
        return this.minecartTNTFuse;
    }
    
    @Override
    public void onActivatorRailPass(final int llllllllllllllllllIIllIlIIIlIlll, final int llllllllllllllllllIIllIlIIIlIllI, final int llllllllllllllllllIIllIlIIIlIlIl, final boolean llllllllllllllllllIIllIlIIIlIIlI) {
        if (llllllllllllllllllIIllIlIIIlIIlI && this.minecartTNTFuse < 0) {
            this.ignite();
        }
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllllllIIllIlIIllllII, final float llllllllllllllllllIIllIlIlIIIIII) {
        final Entity llllllllllllllllllIIllIlIIllllll = llllllllllllllllllIIllIlIIllllII.getSourceOfDamage();
        if (llllllllllllllllllIIllIlIIllllll instanceof EntityArrow) {
            final EntityArrow llllllllllllllllllIIllIlIIlllllI = (EntityArrow)llllllllllllllllllIIllIlIIllllll;
            if (llllllllllllllllllIIllIlIIlllllI.isBurning()) {
                this.explodeCart(llllllllllllllllllIIllIlIIlllllI.motionX * llllllllllllllllllIIllIlIIlllllI.motionX + llllllllllllllllllIIllIlIIlllllI.motionY * llllllllllllllllllIIllIlIIlllllI.motionY + llllllllllllllllllIIllIlIIlllllI.motionZ * llllllllllllllllllIIllIlIIlllllI.motionZ);
            }
        }
        return super.attackEntityFrom(llllllllllllllllllIIllIlIIllllII, llllllllllllllllllIIllIlIlIIIIII);
    }
    
    @Override
    public IBlockState func_180457_u() {
        return Blocks.tnt.getDefaultState();
    }
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound llllllllllllllllllIIllIIllIllIII) {
        super.writeEntityToNBT(llllllllllllllllllIIllIIllIllIII);
        llllllllllllllllllIIllIIllIllIII.setInteger("TNTFuse", this.minecartTNTFuse);
    }
    
    @Override
    public EnumMinecartType func_180456_s() {
        return EnumMinecartType.TNT;
    }
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound llllllllllllllllllIIllIIllIllllI) {
        super.readEntityFromNBT(llllllllllllllllllIIllIIllIllllI);
        if (llllllllllllllllllIIllIIllIllllI.hasKey("TNTFuse", 99)) {
            this.minecartTNTFuse = llllllllllllllllllIIllIIllIllllI.getInteger("TNTFuse");
        }
    }
    
    public void ignite() {
        this.minecartTNTFuse = 80;
        if (!this.worldObj.isRemote) {
            this.worldObj.setEntityState(this, (byte)10);
            if (!this.isSlient()) {
                this.worldObj.playSoundAtEntity(this, "game.tnt.primed", 1.0f, 1.0f);
            }
        }
    }
}
