package net.minecraft.entity.projectile;

import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.entity.monster.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.player.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;
import java.util.*;

public class EntityArrow extends Entity implements IProjectile
{
    private /* synthetic */ Block field_145790_g;
    public /* synthetic */ Entity shootingEntity;
    private /* synthetic */ boolean inGround;
    private /* synthetic */ double damage;
    private /* synthetic */ int knockbackStrength;
    private /* synthetic */ int ticksInAir;
    private /* synthetic */ int field_145791_d;
    private /* synthetic */ int ticksInGround;
    public /* synthetic */ int canBePickedUp;
    private /* synthetic */ int field_145792_e;
    private /* synthetic */ int field_145789_f;
    public /* synthetic */ int arrowShake;
    private /* synthetic */ int inData;
    
    @Override
    protected void entityInit() {
        this.dataWatcher.addObject(16, 0);
    }
    
    public EntityArrow(final World lllllllllllllllllIIllIllllIlIIII) {
        super(lllllllllllllllllIIllIllllIlIIII);
        this.field_145791_d = -1;
        this.field_145792_e = -1;
        this.field_145789_f = -1;
        this.damage = 2.0;
        this.renderDistanceWeight = 10.0;
        this.setSize(0.5f, 0.5f);
    }
    
    static {
        __OBFID = "CL_00001715";
    }
    
    public EntityArrow(final World lllllllllllllllllIIllIlllIIIlIlI, final EntityLivingBase lllllllllllllllllIIllIlllIIIllIl, final float lllllllllllllllllIIllIlllIIIllII) {
        super(lllllllllllllllllIIllIlllIIIlIlI);
        this.field_145791_d = -1;
        this.field_145792_e = -1;
        this.field_145789_f = -1;
        this.damage = 2.0;
        this.renderDistanceWeight = 10.0;
        this.shootingEntity = lllllllllllllllllIIllIlllIIIllIl;
        if (lllllllllllllllllIIllIlllIIIllIl instanceof EntityPlayer) {
            this.canBePickedUp = 1;
        }
        this.setSize(0.5f, 0.5f);
        this.setLocationAndAngles(lllllllllllllllllIIllIlllIIIllIl.posX, lllllllllllllllllIIllIlllIIIllIl.posY + lllllllllllllllllIIllIlllIIIllIl.getEyeHeight(), lllllllllllllllllIIllIlllIIIllIl.posZ, lllllllllllllllllIIllIlllIIIllIl.rotationYaw, lllllllllllllllllIIllIlllIIIllIl.rotationPitch);
        this.posX -= MathHelper.cos(this.rotationYaw / 180.0f * 3.1415927f) * 0.16f;
        this.posY -= 0.10000000149011612;
        this.posZ -= MathHelper.sin(this.rotationYaw / 180.0f * 3.1415927f) * 0.16f;
        this.setPosition(this.posX, this.posY, this.posZ);
        this.motionX = -MathHelper.sin(this.rotationYaw / 180.0f * 3.1415927f) * MathHelper.cos(this.rotationPitch / 180.0f * 3.1415927f);
        this.motionZ = MathHelper.cos(this.rotationYaw / 180.0f * 3.1415927f) * MathHelper.cos(this.rotationPitch / 180.0f * 3.1415927f);
        this.motionY = -MathHelper.sin(this.rotationPitch / 180.0f * 3.1415927f);
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, lllllllllllllllllIIllIlllIIIllII * 1.5f, 1.0f);
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    @Override
    public void setVelocity(final double lllllllllllllllllIIllIllIlIIllIl, final double lllllllllllllllllIIllIllIlIlIIIl, final double lllllllllllllllllIIllIllIlIlIIII) {
        this.motionX = lllllllllllllllllIIllIllIlIIllIl;
        this.motionY = lllllllllllllllllIIllIllIlIlIIIl;
        this.motionZ = lllllllllllllllllIIllIllIlIlIIII;
        if (this.prevRotationPitch == 0.0f && this.prevRotationYaw == 0.0f) {
            final float lllllllllllllllllIIllIllIlIIllll = MathHelper.sqrt_double(lllllllllllllllllIIllIllIlIIllIl * lllllllllllllllllIIllIllIlIIllIl + lllllllllllllllllIIllIllIlIlIIII * lllllllllllllllllIIllIllIlIlIIII);
            final float n = (float)(Math.atan2(lllllllllllllllllIIllIllIlIIllIl, lllllllllllllllllIIllIllIlIlIIII) * 180.0 / 3.141592653589793);
            this.rotationYaw = n;
            this.prevRotationYaw = n;
            final float n2 = (float)(Math.atan2(lllllllllllllllllIIllIllIlIlIIIl, lllllllllllllllllIIllIllIlIIllll) * 180.0 / 3.141592653589793);
            this.rotationPitch = n2;
            this.prevRotationPitch = n2;
            this.prevRotationPitch = this.rotationPitch;
            this.prevRotationYaw = this.rotationYaw;
            this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.ticksInGround = 0;
        }
    }
    
    @Override
    public void onCollideWithPlayer(final EntityPlayer lllllllllllllllllIIllIlIllllIIIl) {
        if (!this.worldObj.isRemote && this.inGround && this.arrowShake <= 0) {
            boolean lllllllllllllllllIIllIlIllllIIII = this.canBePickedUp == 1 || (this.canBePickedUp == 2 && lllllllllllllllllIIllIlIllllIIIl.capabilities.isCreativeMode);
            if (this.canBePickedUp == 1 && !lllllllllllllllllIIllIlIllllIIIl.inventory.addItemStackToInventory(new ItemStack(Items.arrow, 1))) {
                lllllllllllllllllIIllIlIllllIIII = false;
            }
            if (lllllllllllllllllIIllIlIllllIIII) {
                this.playSound("random.pop", 0.2f, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                lllllllllllllllllIIllIlIllllIIIl.onItemPickup(this, 1);
                this.setDead();
            }
        }
    }
    
    public void setKnockbackStrength(final int lllllllllllllllllIIllIlIllIlllIl) {
        this.knockbackStrength = lllllllllllllllllIIllIlIllIlllIl;
    }
    
    @Override
    public void func_180426_a(final double lllllllllllllllllIIllIllIllIIlIl, final double lllllllllllllllllIIllIllIllIIlII, final double lllllllllllllllllIIllIllIllIIIll, final float lllllllllllllllllIIllIllIlIllIlI, final float lllllllllllllllllIIllIllIllIIIIl, final int lllllllllllllllllIIllIllIllIIIII, final boolean lllllllllllllllllIIllIllIlIlllll) {
        this.setPosition(lllllllllllllllllIIllIllIllIIlIl, lllllllllllllllllIIllIllIllIIlII, lllllllllllllllllIIllIllIllIIIll);
        this.setRotation(lllllllllllllllllIIllIllIlIllIlI, lllllllllllllllllIIllIllIllIIIIl);
    }
    
    @Override
    public boolean canAttackWithItem() {
        return false;
    }
    
    public void setDamage(final double lllllllllllllllllIIllIlIlllIlIII) {
        this.damage = lllllllllllllllllIIllIlIlllIlIII;
    }
    
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllllllIIllIlIlllllIII) {
        this.field_145791_d = lllllllllllllllllIIllIlIlllllIII.getShort("xTile");
        this.field_145792_e = lllllllllllllllllIIllIlIlllllIII.getShort("yTile");
        this.field_145789_f = lllllllllllllllllIIllIlIlllllIII.getShort("zTile");
        this.ticksInGround = lllllllllllllllllIIllIlIlllllIII.getShort("life");
        if (lllllllllllllllllIIllIlIlllllIII.hasKey("inTile", 8)) {
            this.field_145790_g = Block.getBlockFromName(lllllllllllllllllIIllIlIlllllIII.getString("inTile"));
        }
        else {
            this.field_145790_g = Block.getBlockById(lllllllllllllllllIIllIlIlllllIII.getByte("inTile") & 0xFF);
        }
        this.inData = (lllllllllllllllllIIllIlIlllllIII.getByte("inData") & 0xFF);
        this.arrowShake = (lllllllllllllllllIIllIlIlllllIII.getByte("shake") & 0xFF);
        this.inGround = (lllllllllllllllllIIllIlIlllllIII.getByte("inGround") == 1);
        if (lllllllllllllllllIIllIlIlllllIII.hasKey("damage", 99)) {
            this.damage = lllllllllllllllllIIllIlIlllllIII.getDouble("damage");
        }
        if (lllllllllllllllllIIllIlIlllllIII.hasKey("pickup", 99)) {
            this.canBePickedUp = lllllllllllllllllIIllIlIlllllIII.getByte("pickup");
        }
        else if (lllllllllllllllllIIllIlIlllllIII.hasKey("player", 99)) {
            this.canBePickedUp = (lllllllllllllllllIIllIlIlllllIII.getBoolean("player") ? 1 : 0);
        }
    }
    
    public void setIsCritical(final boolean lllllllllllllllllIIllIlIllIlIlll) {
        final byte lllllllllllllllllIIllIlIllIlIllI = this.dataWatcher.getWatchableObjectByte(16);
        if (lllllllllllllllllIIllIlIllIlIlll) {
            this.dataWatcher.updateObject(16, (byte)(lllllllllllllllllIIllIlIllIlIllI | 0x1));
        }
        else {
            this.dataWatcher.updateObject(16, (byte)(lllllllllllllllllIIllIlIllIlIllI & 0xFFFFFFFE));
        }
    }
    
    public EntityArrow(final World lllllllllllllllllIIllIlllIlIIIIl, final EntityLivingBase lllllllllllllllllIIllIlllIlIIIII, final EntityLivingBase lllllllllllllllllIIllIlllIlIlllI, final float lllllllllllllllllIIllIlllIIllllI, final float lllllllllllllllllIIllIlllIlIllII) {
        super(lllllllllllllllllIIllIlllIlIIIIl);
        this.field_145791_d = -1;
        this.field_145792_e = -1;
        this.field_145789_f = -1;
        this.damage = 2.0;
        this.renderDistanceWeight = 10.0;
        this.shootingEntity = lllllllllllllllllIIllIlllIlIIIII;
        if (lllllllllllllllllIIllIlllIlIIIII instanceof EntityPlayer) {
            this.canBePickedUp = 1;
        }
        this.posY = lllllllllllllllllIIllIlllIlIIIII.posY + lllllllllllllllllIIllIlllIlIIIII.getEyeHeight() - 0.10000000149011612;
        final double lllllllllllllllllIIllIlllIlIlIll = lllllllllllllllllIIllIlllIlIlllI.posX - lllllllllllllllllIIllIlllIlIIIII.posX;
        final double lllllllllllllllllIIllIlllIlIlIlI = lllllllllllllllllIIllIlllIlIlllI.getEntityBoundingBox().minY + lllllllllllllllllIIllIlllIlIlllI.height / 3.0f - this.posY;
        final double lllllllllllllllllIIllIlllIlIlIIl = lllllllllllllllllIIllIlllIlIlllI.posZ - lllllllllllllllllIIllIlllIlIIIII.posZ;
        final double lllllllllllllllllIIllIlllIlIlIII = MathHelper.sqrt_double(lllllllllllllllllIIllIlllIlIlIll * lllllllllllllllllIIllIlllIlIlIll + lllllllllllllllllIIllIlllIlIlIIl * lllllllllllllllllIIllIlllIlIlIIl);
        if (lllllllllllllllllIIllIlllIlIlIII >= 1.0E-7) {
            final float lllllllllllllllllIIllIlllIlIIlll = (float)(Math.atan2(lllllllllllllllllIIllIlllIlIlIIl, lllllllllllllllllIIllIlllIlIlIll) * 180.0 / 3.141592653589793) - 90.0f;
            final float lllllllllllllllllIIllIlllIlIIllI = (float)(-(Math.atan2(lllllllllllllllllIIllIlllIlIlIlI, lllllllllllllllllIIllIlllIlIlIII) * 180.0 / 3.141592653589793));
            final double lllllllllllllllllIIllIlllIlIIlIl = lllllllllllllllllIIllIlllIlIlIll / lllllllllllllllllIIllIlllIlIlIII;
            final double lllllllllllllllllIIllIlllIlIIlII = lllllllllllllllllIIllIlllIlIlIIl / lllllllllllllllllIIllIlllIlIlIII;
            this.setLocationAndAngles(lllllllllllllllllIIllIlllIlIIIII.posX + lllllllllllllllllIIllIlllIlIIlIl, this.posY, lllllllllllllllllIIllIlllIlIIIII.posZ + lllllllllllllllllIIllIlllIlIIlII, lllllllllllllllllIIllIlllIlIIlll, lllllllllllllllllIIllIlllIlIIllI);
            final float lllllllllllllllllIIllIlllIlIIIll = (float)(lllllllllllllllllIIllIlllIlIlIII * 0.20000000298023224);
            this.setThrowableHeading(lllllllllllllllllIIllIlllIlIlIll, lllllllllllllllllIIllIlllIlIlIlI + lllllllllllllllllIIllIlllIlIIIll, lllllllllllllllllIIllIlllIlIlIIl, lllllllllllllllllIIllIlllIIllllI, lllllllllllllllllIIllIlllIlIllII);
        }
    }
    
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllllllIIllIllIIIIIIII) {
        lllllllllllllllllIIllIllIIIIIIII.setShort("xTile", (short)this.field_145791_d);
        lllllllllllllllllIIllIllIIIIIIII.setShort("yTile", (short)this.field_145792_e);
        lllllllllllllllllIIllIllIIIIIIII.setShort("zTile", (short)this.field_145789_f);
        lllllllllllllllllIIllIllIIIIIIII.setShort("life", (short)this.ticksInGround);
        final ResourceLocation lllllllllllllllllIIllIlIllllllll = (ResourceLocation)Block.blockRegistry.getNameForObject(this.field_145790_g);
        lllllllllllllllllIIllIllIIIIIIII.setString("inTile", (lllllllllllllllllIIllIlIllllllll == null) ? "" : lllllllllllllllllIIllIlIllllllll.toString());
        lllllllllllllllllIIllIllIIIIIIII.setByte("inData", (byte)this.inData);
        lllllllllllllllllIIllIllIIIIIIII.setByte("shake", (byte)this.arrowShake);
        lllllllllllllllllIIllIllIIIIIIII.setByte("inGround", (byte)(this.inGround ? 1 : 0));
        lllllllllllllllllIIllIllIIIIIIII.setByte("pickup", (byte)this.canBePickedUp);
        lllllllllllllllllIIllIllIIIIIIII.setDouble("damage", this.damage);
    }
    
    public EntityArrow(final World lllllllllllllllllIIllIllllIIIlII, final double lllllllllllllllllIIllIllllIIlIII, final double lllllllllllllllllIIllIllllIIIIlI, final double lllllllllllllllllIIllIllllIIIIIl) {
        super(lllllllllllllllllIIllIllllIIIlII);
        this.field_145791_d = -1;
        this.field_145792_e = -1;
        this.field_145789_f = -1;
        this.damage = 2.0;
        this.renderDistanceWeight = 10.0;
        this.setSize(0.5f, 0.5f);
        this.setPosition(lllllllllllllllllIIllIllllIIlIII, lllllllllllllllllIIllIllllIIIIlI, lllllllllllllllllIIllIllllIIIIIl);
    }
    
    public double getDamage() {
        return this.damage;
    }
    
    @Override
    public void setThrowableHeading(double lllllllllllllllllIIllIllIlllIIll, double lllllllllllllllllIIllIllIllllIlI, double lllllllllllllllllIIllIllIllllIIl, final float lllllllllllllllllIIllIllIllllIII, final float lllllllllllllllllIIllIllIllIllll) {
        final float lllllllllllllllllIIllIllIlllIllI = MathHelper.sqrt_double(lllllllllllllllllIIllIllIlllIIll * lllllllllllllllllIIllIllIlllIIll + lllllllllllllllllIIllIllIllllIlI * lllllllllllllllllIIllIllIllllIlI + lllllllllllllllllIIllIllIllllIIl * lllllllllllllllllIIllIllIllllIIl);
        lllllllllllllllllIIllIllIlllIIll /= lllllllllllllllllIIllIllIlllIllI;
        lllllllllllllllllIIllIllIllllIlI /= lllllllllllllllllIIllIllIlllIllI;
        lllllllllllllllllIIllIllIllllIIl /= lllllllllllllllllIIllIllIlllIllI;
        lllllllllllllllllIIllIllIlllIIll += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937 * lllllllllllllllllIIllIllIllIllll;
        lllllllllllllllllIIllIllIllllIlI += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937 * lllllllllllllllllIIllIllIllIllll;
        lllllllllllllllllIIllIllIllllIIl += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937 * lllllllllllllllllIIllIllIllIllll;
        lllllllllllllllllIIllIllIlllIIll *= lllllllllllllllllIIllIllIllllIII;
        lllllllllllllllllIIllIllIllllIlI *= lllllllllllllllllIIllIllIllllIII;
        lllllllllllllllllIIllIllIllllIIl *= lllllllllllllllllIIllIllIllllIII;
        this.motionX = lllllllllllllllllIIllIllIlllIIll;
        this.motionY = lllllllllllllllllIIllIllIllllIlI;
        this.motionZ = lllllllllllllllllIIllIllIllllIIl;
        final float lllllllllllllllllIIllIllIlllIlIl = MathHelper.sqrt_double(lllllllllllllllllIIllIllIlllIIll * lllllllllllllllllIIllIllIlllIIll + lllllllllllllllllIIllIllIllllIIl * lllllllllllllllllIIllIllIllllIIl);
        final float n = (float)(Math.atan2(lllllllllllllllllIIllIllIlllIIll, lllllllllllllllllIIllIllIllllIIl) * 180.0 / 3.141592653589793);
        this.rotationYaw = n;
        this.prevRotationYaw = n;
        final float n2 = (float)(Math.atan2(lllllllllllllllllIIllIllIllllIlI, lllllllllllllllllIIllIllIlllIlIl) * 180.0 / 3.141592653589793);
        this.rotationPitch = n2;
        this.prevRotationPitch = n2;
        this.ticksInGround = 0;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.prevRotationPitch == 0.0f && this.prevRotationYaw == 0.0f) {
            final float lllllllllllllllllIIllIllIIllIllI = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            final float n = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0 / 3.141592653589793);
            this.rotationYaw = n;
            this.prevRotationYaw = n;
            final float n2 = (float)(Math.atan2(this.motionY, lllllllllllllllllIIllIllIIllIllI) * 180.0 / 3.141592653589793);
            this.rotationPitch = n2;
            this.prevRotationPitch = n2;
        }
        final BlockPos lllllllllllllllllIIllIllIIllIlIl = new BlockPos(this.field_145791_d, this.field_145792_e, this.field_145789_f);
        IBlockState lllllllllllllllllIIllIllIIllIlII = this.worldObj.getBlockState(lllllllllllllllllIIllIllIIllIlIl);
        final Block lllllllllllllllllIIllIllIIllIIll = lllllllllllllllllIIllIllIIllIlII.getBlock();
        if (lllllllllllllllllIIllIllIIllIIll.getMaterial() != Material.air) {
            lllllllllllllllllIIllIllIIllIIll.setBlockBoundsBasedOnState(this.worldObj, lllllllllllllllllIIllIllIIllIlIl);
            final AxisAlignedBB lllllllllllllllllIIllIllIIllIIlI = lllllllllllllllllIIllIllIIllIIll.getCollisionBoundingBox(this.worldObj, lllllllllllllllllIIllIllIIllIlIl, lllllllllllllllllIIllIllIIllIlII);
            if (lllllllllllllllllIIllIllIIllIIlI != null && lllllllllllllllllIIllIllIIllIIlI.isVecInside(new Vec3(this.posX, this.posY, this.posZ))) {
                this.inGround = true;
            }
        }
        if (this.arrowShake > 0) {
            --this.arrowShake;
        }
        if (this.inGround) {
            final int lllllllllllllllllIIllIllIIllIIIl = lllllllllllllllllIIllIllIIllIIll.getMetaFromState(lllllllllllllllllIIllIllIIllIlII);
            if (lllllllllllllllllIIllIllIIllIIll == this.field_145790_g && lllllllllllllllllIIllIllIIllIIIl == this.inData) {
                ++this.ticksInGround;
                if (this.ticksInGround >= 1200) {
                    this.setDead();
                }
            }
            else {
                this.inGround = false;
                this.motionX *= this.rand.nextFloat() * 0.2f;
                this.motionY *= this.rand.nextFloat() * 0.2f;
                this.motionZ *= this.rand.nextFloat() * 0.2f;
                this.ticksInGround = 0;
                this.ticksInAir = 0;
            }
        }
        else {
            ++this.ticksInAir;
            Vec3 lllllllllllllllllIIllIllIIllIIII = new Vec3(this.posX, this.posY, this.posZ);
            Vec3 lllllllllllllllllIIllIllIIlIllll = new Vec3(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            MovingObjectPosition lllllllllllllllllIIllIllIIlIlllI = this.worldObj.rayTraceBlocks(lllllllllllllllllIIllIllIIllIIII, lllllllllllllllllIIllIllIIlIllll, false, true, false);
            lllllllllllllllllIIllIllIIllIIII = new Vec3(this.posX, this.posY, this.posZ);
            lllllllllllllllllIIllIllIIlIllll = new Vec3(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            if (lllllllllllllllllIIllIllIIlIlllI != null) {
                lllllllllllllllllIIllIllIIlIllll = new Vec3(lllllllllllllllllIIllIllIIlIlllI.hitVec.xCoord, lllllllllllllllllIIllIllIIlIlllI.hitVec.yCoord, lllllllllllllllllIIllIllIIlIlllI.hitVec.zCoord);
            }
            Entity lllllllllllllllllIIllIllIIlIllIl = null;
            final List lllllllllllllllllIIllIllIIlIllII = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0, 1.0, 1.0));
            double lllllllllllllllllIIllIllIIlIlIll = 0.0;
            for (int lllllllllllllllllIIllIllIIlIlIlI = 0; lllllllllllllllllIIllIllIIlIlIlI < lllllllllllllllllIIllIllIIlIllII.size(); ++lllllllllllllllllIIllIllIIlIlIlI) {
                final Entity lllllllllllllllllIIllIllIIlIIlll = lllllllllllllllllIIllIllIIlIllII.get(lllllllllllllllllIIllIllIIlIlIlI);
                if (lllllllllllllllllIIllIllIIlIIlll.canBeCollidedWith() && (lllllllllllllllllIIllIllIIlIIlll != this.shootingEntity || this.ticksInAir >= 5)) {
                    final float lllllllllllllllllIIllIllIIlIlIIl = 0.3f;
                    final AxisAlignedBB lllllllllllllllllIIllIllIIlIIllI = lllllllllllllllllIIllIllIIlIIlll.getEntityBoundingBox().expand(lllllllllllllllllIIllIllIIlIlIIl, lllllllllllllllllIIllIllIIlIlIIl, lllllllllllllllllIIllIllIIlIlIIl);
                    final MovingObjectPosition lllllllllllllllllIIllIllIIlIIlIl = lllllllllllllllllIIllIllIIlIIllI.calculateIntercept(lllllllllllllllllIIllIllIIllIIII, lllllllllllllllllIIllIllIIlIllll);
                    if (lllllllllllllllllIIllIllIIlIIlIl != null) {
                        final double lllllllllllllllllIIllIllIIlIIlII = lllllllllllllllllIIllIllIIllIIII.distanceTo(lllllllllllllllllIIllIllIIlIIlIl.hitVec);
                        if (lllllllllllllllllIIllIllIIlIIlII < lllllllllllllllllIIllIllIIlIlIll || lllllllllllllllllIIllIllIIlIlIll == 0.0) {
                            lllllllllllllllllIIllIllIIlIllIl = lllllllllllllllllIIllIllIIlIIlll;
                            lllllllllllllllllIIllIllIIlIlIll = lllllllllllllllllIIllIllIIlIIlII;
                        }
                    }
                }
            }
            if (lllllllllllllllllIIllIllIIlIllIl != null) {
                lllllllllllllllllIIllIllIIlIlllI = new MovingObjectPosition(lllllllllllllllllIIllIllIIlIllIl);
            }
            if (lllllllllllllllllIIllIllIIlIlllI != null && lllllllllllllllllIIllIllIIlIlllI.entityHit != null && lllllllllllllllllIIllIllIIlIlllI.entityHit instanceof EntityPlayer) {
                final EntityPlayer lllllllllllllllllIIllIllIIlIIIll = (EntityPlayer)lllllllllllllllllIIllIllIIlIlllI.entityHit;
                if (lllllllllllllllllIIllIllIIlIIIll.capabilities.disableDamage || (this.shootingEntity instanceof EntityPlayer && !((EntityPlayer)this.shootingEntity).canAttackPlayer(lllllllllllllllllIIllIllIIlIIIll))) {
                    lllllllllllllllllIIllIllIIlIlllI = null;
                }
            }
            if (lllllllllllllllllIIllIllIIlIlllI != null) {
                if (lllllllllllllllllIIllIllIIlIlllI.entityHit != null) {
                    final float lllllllllllllllllIIllIllIIlIIIlI = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    int lllllllllllllllllIIllIllIIIlllII = MathHelper.ceiling_double_int(lllllllllllllllllIIllIllIIlIIIlI * this.damage);
                    if (this.getIsCritical()) {
                        lllllllllllllllllIIllIllIIIlllII += this.rand.nextInt(lllllllllllllllllIIllIllIIIlllII / 2 + 2);
                    }
                    DamageSource lllllllllllllllllIIllIllIIIllIlI = null;
                    if (this.shootingEntity == null) {
                        final DamageSource lllllllllllllllllIIllIllIIIllIll = DamageSource.causeArrowDamage(this, this);
                    }
                    else {
                        lllllllllllllllllIIllIllIIIllIlI = DamageSource.causeArrowDamage(this, this.shootingEntity);
                    }
                    if (this.isBurning() && !(lllllllllllllllllIIllIllIIlIlllI.entityHit instanceof EntityEnderman)) {
                        lllllllllllllllllIIllIllIIlIlllI.entityHit.setFire(5);
                    }
                    if (lllllllllllllllllIIllIllIIlIlllI.entityHit.attackEntityFrom(lllllllllllllllllIIllIllIIIllIlI, (float)lllllllllllllllllIIllIllIIIlllII)) {
                        if (lllllllllllllllllIIllIllIIlIlllI.entityHit instanceof EntityLivingBase) {
                            final EntityLivingBase lllllllllllllllllIIllIllIIIllIIl = (EntityLivingBase)lllllllllllllllllIIllIllIIlIlllI.entityHit;
                            if (!this.worldObj.isRemote) {
                                lllllllllllllllllIIllIllIIIllIIl.setArrowCountInEntity(lllllllllllllllllIIllIllIIIllIIl.getArrowCountInEntity() + 1);
                            }
                            if (this.knockbackStrength > 0) {
                                final float lllllllllllllllllIIllIllIIIllllI = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
                                if (lllllllllllllllllIIllIllIIIllllI > 0.0f) {
                                    lllllllllllllllllIIllIllIIlIlllI.entityHit.addVelocity(this.motionX * this.knockbackStrength * 0.6000000238418579 / lllllllllllllllllIIllIllIIIllllI, 0.1, this.motionZ * this.knockbackStrength * 0.6000000238418579 / lllllllllllllllllIIllIllIIIllllI);
                                }
                            }
                            if (this.shootingEntity instanceof EntityLivingBase) {
                                EnchantmentHelper.func_151384_a(lllllllllllllllllIIllIllIIIllIIl, this.shootingEntity);
                                EnchantmentHelper.func_151385_b((EntityLivingBase)this.shootingEntity, lllllllllllllllllIIllIllIIIllIIl);
                            }
                            if (this.shootingEntity != null && lllllllllllllllllIIllIllIIlIlllI.entityHit != this.shootingEntity && lllllllllllllllllIIllIllIIlIlllI.entityHit instanceof EntityPlayer && this.shootingEntity instanceof EntityPlayerMP) {
                                ((EntityPlayerMP)this.shootingEntity).playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(6, 0.0f));
                            }
                        }
                        this.playSound("random.bowhit", 1.0f, 1.2f / (this.rand.nextFloat() * 0.2f + 0.9f));
                        if (!(lllllllllllllllllIIllIllIIlIlllI.entityHit instanceof EntityEnderman)) {
                            this.setDead();
                        }
                    }
                    else {
                        this.motionX *= -0.10000000149011612;
                        this.motionY *= -0.10000000149011612;
                        this.motionZ *= -0.10000000149011612;
                        this.rotationYaw += 180.0f;
                        this.prevRotationYaw += 180.0f;
                        this.ticksInAir = 0;
                    }
                }
                else {
                    final BlockPos lllllllllllllllllIIllIllIIIllIII = lllllllllllllllllIIllIllIIlIlllI.func_178782_a();
                    this.field_145791_d = lllllllllllllllllIIllIllIIIllIII.getX();
                    this.field_145792_e = lllllllllllllllllIIllIllIIIllIII.getY();
                    this.field_145789_f = lllllllllllllllllIIllIllIIIllIII.getZ();
                    lllllllllllllllllIIllIllIIllIlII = this.worldObj.getBlockState(lllllllllllllllllIIllIllIIIllIII);
                    this.field_145790_g = lllllllllllllllllIIllIllIIllIlII.getBlock();
                    this.inData = this.field_145790_g.getMetaFromState(lllllllllllllllllIIllIllIIllIlII);
                    this.motionX = (float)(lllllllllllllllllIIllIllIIlIlllI.hitVec.xCoord - this.posX);
                    this.motionY = (float)(lllllllllllllllllIIllIllIIlIlllI.hitVec.yCoord - this.posY);
                    this.motionZ = (float)(lllllllllllllllllIIllIllIIlIlllI.hitVec.zCoord - this.posZ);
                    final float lllllllllllllllllIIllIllIIlIIIII = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    this.posX -= this.motionX / lllllllllllllllllIIllIllIIlIIIII * 0.05000000074505806;
                    this.posY -= this.motionY / lllllllllllllllllIIllIllIIlIIIII * 0.05000000074505806;
                    this.posZ -= this.motionZ / lllllllllllllllllIIllIllIIlIIIII * 0.05000000074505806;
                    this.playSound("random.bowhit", 1.0f, 1.2f / (this.rand.nextFloat() * 0.2f + 0.9f));
                    this.inGround = true;
                    this.arrowShake = 7;
                    this.setIsCritical(false);
                    if (this.field_145790_g.getMaterial() != Material.air) {
                        this.field_145790_g.onEntityCollidedWithBlock(this.worldObj, lllllllllllllllllIIllIllIIIllIII, lllllllllllllllllIIllIllIIllIlII, this);
                    }
                }
            }
            if (this.getIsCritical()) {
                for (int lllllllllllllllllIIllIllIIlIlIlI = 0; lllllllllllllllllIIllIllIIlIlIlI < 4; ++lllllllllllllllllIIllIllIIlIlIlI) {
                    this.worldObj.spawnParticle(EnumParticleTypes.CRIT, this.posX + this.motionX * lllllllllllllllllIIllIllIIlIlIlI / 4.0, this.posY + this.motionY * lllllllllllllllllIIllIllIIlIlIlI / 4.0, this.posZ + this.motionZ * lllllllllllllllllIIllIllIIlIlIlI / 4.0, -this.motionX, -this.motionY + 0.2, -this.motionZ, new int[0]);
                }
            }
            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            final float lllllllllllllllllIIllIllIIlIIIIl = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0 / 3.141592653589793);
            this.rotationPitch = (float)(Math.atan2(this.motionY, lllllllllllllllllIIllIllIIlIIIIl) * 180.0 / 3.141592653589793);
            while (this.rotationPitch - this.prevRotationPitch < -180.0f) {
                this.prevRotationPitch -= 360.0f;
            }
            while (this.rotationPitch - this.prevRotationPitch >= 180.0f) {
                this.prevRotationPitch += 360.0f;
            }
            while (this.rotationYaw - this.prevRotationYaw < -180.0f) {
                this.prevRotationYaw -= 360.0f;
            }
            while (this.rotationYaw - this.prevRotationYaw >= 180.0f) {
                this.prevRotationYaw += 360.0f;
            }
            this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2f;
            this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2f;
            float lllllllllllllllllIIllIllIIIlllll = 0.99f;
            final float lllllllllllllllllIIllIllIIlIlIII = 0.05f;
            if (this.isInWater()) {
                for (int lllllllllllllllllIIllIllIIIlIlll = 0; lllllllllllllllllIIllIllIIIlIlll < 4; ++lllllllllllllllllIIllIllIIIlIlll) {
                    final float lllllllllllllllllIIllIllIIIlllIl = 0.25f;
                    this.worldObj.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX - this.motionX * lllllllllllllllllIIllIllIIIlllIl, this.posY - this.motionY * lllllllllllllllllIIllIllIIIlllIl, this.posZ - this.motionZ * lllllllllllllllllIIllIllIIIlllIl, this.motionX, this.motionY, this.motionZ, new int[0]);
                }
                lllllllllllllllllIIllIllIIIlllll = 0.6f;
            }
            if (this.isWet()) {
                this.extinguish();
            }
            this.motionX *= lllllllllllllllllIIllIllIIIlllll;
            this.motionY *= lllllllllllllllllIIllIllIIIlllll;
            this.motionZ *= lllllllllllllllllIIllIllIIIlllll;
            this.motionY -= lllllllllllllllllIIllIllIIlIlIII;
            this.setPosition(this.posX, this.posY, this.posZ);
            this.doBlockCollisions();
        }
    }
    
    public boolean getIsCritical() {
        final byte lllllllllllllllllIIllIlIllIIllll = this.dataWatcher.getWatchableObjectByte(16);
        return (lllllllllllllllllIIllIlIllIIllll & 0x1) != 0x0;
    }
}
