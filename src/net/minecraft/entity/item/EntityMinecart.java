package net.minecraft.entity.item;

import net.minecraft.block.state.*;
import net.minecraft.entity.ai.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.monster.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.server.*;
import java.util.*;
import com.google.common.collect.*;

public abstract class EntityMinecart extends Entity implements IWorldNameable
{
    private /* synthetic */ double minecartZ;
    private /* synthetic */ double velocityX;
    private /* synthetic */ double velocityZ;
    private /* synthetic */ String entityName;
    private /* synthetic */ int turnProgress;
    private /* synthetic */ double minecartX;
    private /* synthetic */ double velocityY;
    private /* synthetic */ double minecartYaw;
    private /* synthetic */ boolean isInReverse;
    private static final /* synthetic */ int[][][] matrix;
    private /* synthetic */ double minecartY;
    private /* synthetic */ double minecartPitch;
    
    public void func_174899_a(final IBlockState lllllllllllllllIIIIlllllIllllIII) {
        this.getDataWatcher().updateObject(20, Block.getStateId(lllllllllllllllIIIIlllllIllllIII));
        this.setHasDisplayTile(true);
    }
    
    @Override
    public void setCustomNameTag(final String lllllllllllllllIIIIlllllIllIIlIl) {
        this.entityName = lllllllllllllllIIIIlllllIllIIlIl;
    }
    
    @Override
    protected void entityInit() {
        this.dataWatcher.addObject(17, new Integer(0));
        this.dataWatcher.addObject(18, new Integer(1));
        this.dataWatcher.addObject(19, new Float(0.0f));
        this.dataWatcher.addObject(20, new Integer(0));
        this.dataWatcher.addObject(21, new Integer(6));
        this.dataWatcher.addObject(22, 0);
    }
    
    protected void func_180459_n() {
        final double lllllllllllllllIIIlIIIIIlllIIIlI = this.func_174898_m();
        this.motionX = MathHelper.clamp_double(this.motionX, -lllllllllllllllIIIlIIIIIlllIIIlI, lllllllllllllllIIIlIIIIIlllIIIlI);
        this.motionZ = MathHelper.clamp_double(this.motionZ, -lllllllllllllllIIIlIIIIIlllIIIlI, lllllllllllllllIIIlIIIIIlllIIIlI);
        if (this.onGround) {
            this.motionX *= 0.5;
            this.motionY *= 0.5;
            this.motionZ *= 0.5;
        }
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        if (!this.onGround) {
            this.motionX *= 0.949999988079071;
            this.motionY *= 0.949999988079071;
            this.motionZ *= 0.949999988079071;
        }
    }
    
    @Override
    public void setDead() {
        super.setDead();
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    public static EntityMinecart func_180458_a(final World lllllllllllllllIIIlIIIIllIllIIlI, final double lllllllllllllllIIIlIIIIllIllIIIl, final double lllllllllllllllIIIlIIIIllIllIlll, final double lllllllllllllllIIIlIIIIllIllIllI, final EnumMinecartType lllllllllllllllIIIlIIIIllIllIlII) {
        switch (SwitchEnumMinecartType.field_180037_a[lllllllllllllllIIIlIIIIllIllIlII.ordinal()]) {
            case 1: {
                return new EntityMinecartChest(lllllllllllllllIIIlIIIIllIllIIlI, lllllllllllllllIIIlIIIIllIllIIIl, lllllllllllllllIIIlIIIIllIllIlll, lllllllllllllllIIIlIIIIllIllIllI);
            }
            case 2: {
                return new EntityMinecartFurnace(lllllllllllllllIIIlIIIIllIllIIlI, lllllllllllllllIIIlIIIIllIllIIIl, lllllllllllllllIIIlIIIIllIllIlll, lllllllllllllllIIIlIIIIllIllIllI);
            }
            case 3: {
                return new EntityMinecartTNT(lllllllllllllllIIIlIIIIllIllIIlI, lllllllllllllllIIIlIIIIllIllIIIl, lllllllllllllllIIIlIIIIllIllIlll, lllllllllllllllIIIlIIIIllIllIllI);
            }
            case 4: {
                return new EntityMinecartMobSpawner(lllllllllllllllIIIlIIIIllIllIIlI, lllllllllllllllIIIlIIIIllIllIIIl, lllllllllllllllIIIlIIIIllIllIlll, lllllllllllllllIIIlIIIIllIllIllI);
            }
            case 5: {
                return new EntityMinecartHopper(lllllllllllllllIIIlIIIIllIllIIlI, lllllllllllllllIIIlIIIIllIllIIIl, lllllllllllllllIIIlIIIIllIllIlll, lllllllllllllllIIIlIIIIllIllIllI);
            }
            case 6: {
                return new EntityMinecartCommandBlock(lllllllllllllllIIIlIIIIllIllIIlI, lllllllllllllllIIIlIIIIllIllIIIl, lllllllllllllllIIIlIIIIllIllIlll, lllllllllllllllIIIlIIIIllIllIllI);
            }
            default: {
                return new EntityMinecartEmpty(lllllllllllllllIIIlIIIIllIllIIlI, lllllllllllllllIIIlIIIIllIllIIIl, lllllllllllllllIIIlIIIIllIllIlll, lllllllllllllllIIIlIIIIllIllIllI);
            }
        }
    }
    
    @Override
    public void func_180426_a(final double lllllllllllllllIIIIllllllIlllIlI, final double lllllllllllllllIIIIllllllIlllIIl, final double lllllllllllllllIIIIllllllIllIIII, final float lllllllllllllllIIIIllllllIlIllll, final float lllllllllllllllIIIIllllllIlIlllI, final int lllllllllllllllIIIIllllllIlIllIl, final boolean lllllllllllllllIIIIllllllIllIlII) {
        this.minecartX = lllllllllllllllIIIIllllllIlllIlI;
        this.minecartY = lllllllllllllllIIIIllllllIlllIIl;
        this.minecartZ = lllllllllllllllIIIIllllllIllIIII;
        this.minecartYaw = lllllllllllllllIIIIllllllIlIllll;
        this.minecartPitch = lllllllllllllllIIIIllllllIlIlllI;
        this.turnProgress = lllllllllllllllIIIIllllllIlIllIl + 2;
        this.motionX = this.velocityX;
        this.motionY = this.velocityY;
        this.motionZ = this.velocityZ;
    }
    
    protected void func_180460_a(final BlockPos lllllllllllllllIIIlIIIIIllIIIIlI, final IBlockState lllllllllllllllIIIlIIIIIllIIIIIl) {
        this.fallDistance = 0.0f;
        final Vec3 lllllllllllllllIIIlIIIIIllIIIIII = this.func_70489_a(this.posX, this.posY, this.posZ);
        this.posY = lllllllllllllllIIIlIIIIIllIIIIlI.getY();
        boolean lllllllllllllllIIIlIIIIIlIllllll = false;
        boolean lllllllllllllllIIIlIIIIIlIlllllI = false;
        final BlockRailBase lllllllllllllllIIIlIIIIIlIllllIl = (BlockRailBase)lllllllllllllllIIIlIIIIIllIIIIIl.getBlock();
        if (lllllllllllllllIIIlIIIIIlIllllIl == Blocks.golden_rail) {
            lllllllllllllllIIIlIIIIIlIllllll = (boolean)lllllllllllllllIIIlIIIIIllIIIIIl.getValue(BlockRailPowered.field_176569_M);
            lllllllllllllllIIIlIIIIIlIlllllI = !lllllllllllllllIIIlIIIIIlIllllll;
        }
        final double lllllllllllllllIIIlIIIIIlIllllII = 0.0078125;
        final BlockRailBase.EnumRailDirection lllllllllllllllIIIlIIIIIlIlllIll = (BlockRailBase.EnumRailDirection)lllllllllllllllIIIlIIIIIllIIIIIl.getValue(lllllllllllllllIIIlIIIIIlIllllIl.func_176560_l());
        switch (SwitchEnumMinecartType.field_180036_b[lllllllllllllllIIIlIIIIIlIlllIll.ordinal()]) {
            case 1: {
                this.motionX -= 0.0078125;
                ++this.posY;
                break;
            }
            case 2: {
                this.motionX += 0.0078125;
                ++this.posY;
                break;
            }
            case 3: {
                this.motionZ += 0.0078125;
                ++this.posY;
                break;
            }
            case 4: {
                this.motionZ -= 0.0078125;
                ++this.posY;
                break;
            }
        }
        final int[][] lllllllllllllllIIIlIIIIIlIlllIlI = EntityMinecart.matrix[lllllllllllllllIIIlIIIIIlIlllIll.func_177015_a()];
        double lllllllllllllllIIIlIIIIIlIlllIIl = lllllllllllllllIIIlIIIIIlIlllIlI[1][0] - lllllllllllllllIIIlIIIIIlIlllIlI[0][0];
        double lllllllllllllllIIIlIIIIIlIlllIII = lllllllllllllllIIIlIIIIIlIlllIlI[1][2] - lllllllllllllllIIIlIIIIIlIlllIlI[0][2];
        final double lllllllllllllllIIIlIIIIIlIllIlll = Math.sqrt(lllllllllllllllIIIlIIIIIlIlllIIl * lllllllllllllllIIIlIIIIIlIlllIIl + lllllllllllllllIIIlIIIIIlIlllIII * lllllllllllllllIIIlIIIIIlIlllIII);
        final double lllllllllllllllIIIlIIIIIlIllIllI = this.motionX * lllllllllllllllIIIlIIIIIlIlllIIl + this.motionZ * lllllllllllllllIIIlIIIIIlIlllIII;
        if (lllllllllllllllIIIlIIIIIlIllIllI < 0.0) {
            lllllllllllllllIIIlIIIIIlIlllIIl = -lllllllllllllllIIIlIIIIIlIlllIIl;
            lllllllllllllllIIIlIIIIIlIlllIII = -lllllllllllllllIIIlIIIIIlIlllIII;
        }
        double lllllllllllllllIIIlIIIIIlIllIlIl = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        if (lllllllllllllllIIIlIIIIIlIllIlIl > 2.0) {
            lllllllllllllllIIIlIIIIIlIllIlIl = 2.0;
        }
        this.motionX = lllllllllllllllIIIlIIIIIlIllIlIl * lllllllllllllllIIIlIIIIIlIlllIIl / lllllllllllllllIIIlIIIIIlIllIlll;
        this.motionZ = lllllllllllllllIIIlIIIIIlIllIlIl * lllllllllllllllIIIlIIIIIlIlllIII / lllllllllllllllIIIlIIIIIlIllIlll;
        if (this.riddenByEntity instanceof EntityLivingBase) {
            final double lllllllllllllllIIIlIIIIIlIllIlII = ((EntityLivingBase)this.riddenByEntity).moveForward;
            if (lllllllllllllllIIIlIIIIIlIllIlII > 0.0) {
                final double lllllllllllllllIIIlIIIIIlIllIIIl = -Math.sin(this.riddenByEntity.rotationYaw * 3.1415927f / 180.0f);
                final double lllllllllllllllIIIlIIIIIlIlIllll = Math.cos(this.riddenByEntity.rotationYaw * 3.1415927f / 180.0f);
                final double lllllllllllllllIIIlIIIIIlIlIllIl = this.motionX * this.motionX + this.motionZ * this.motionZ;
                if (lllllllllllllllIIIlIIIIIlIlIllIl < 0.01) {
                    this.motionX += lllllllllllllllIIIlIIIIIlIllIIIl * 0.1;
                    this.motionZ += lllllllllllllllIIIlIIIIIlIlIllll * 0.1;
                    lllllllllllllllIIIlIIIIIlIlllllI = false;
                }
            }
        }
        if (lllllllllllllllIIIlIIIIIlIlllllI) {
            final double lllllllllllllllIIIlIIIIIlIllIIll = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            if (lllllllllllllllIIIlIIIIIlIllIIll < 0.03) {
                this.motionX *= 0.0;
                this.motionY *= 0.0;
                this.motionZ *= 0.0;
            }
            else {
                this.motionX *= 0.5;
                this.motionY *= 0.0;
                this.motionZ *= 0.5;
            }
        }
        double lllllllllllllllIIIlIIIIIlIllIIlI = 0.0;
        final double lllllllllllllllIIIlIIIIIlIllIIII = lllllllllllllllIIIlIIIIIllIIIIlI.getX() + 0.5 + lllllllllllllllIIIlIIIIIlIlllIlI[0][0] * 0.5;
        final double lllllllllllllllIIIlIIIIIlIlIlllI = lllllllllllllllIIIlIIIIIllIIIIlI.getZ() + 0.5 + lllllllllllllllIIIlIIIIIlIlllIlI[0][2] * 0.5;
        final double lllllllllllllllIIIlIIIIIlIlIllII = lllllllllllllllIIIlIIIIIllIIIIlI.getX() + 0.5 + lllllllllllllllIIIlIIIIIlIlllIlI[1][0] * 0.5;
        final double lllllllllllllllIIIlIIIIIlIlIlIll = lllllllllllllllIIIlIIIIIllIIIIlI.getZ() + 0.5 + lllllllllllllllIIIlIIIIIlIlllIlI[1][2] * 0.5;
        lllllllllllllllIIIlIIIIIlIlllIIl = lllllllllllllllIIIlIIIIIlIlIllII - lllllllllllllllIIIlIIIIIlIllIIII;
        lllllllllllllllIIIlIIIIIlIlllIII = lllllllllllllllIIIlIIIIIlIlIlIll - lllllllllllllllIIIlIIIIIlIlIlllI;
        if (lllllllllllllllIIIlIIIIIlIlllIIl == 0.0) {
            this.posX = lllllllllllllllIIIlIIIIIllIIIIlI.getX() + 0.5;
            lllllllllllllllIIIlIIIIIlIllIIlI = this.posZ - lllllllllllllllIIIlIIIIIllIIIIlI.getZ();
        }
        else if (lllllllllllllllIIIlIIIIIlIlllIII == 0.0) {
            this.posZ = lllllllllllllllIIIlIIIIIllIIIIlI.getZ() + 0.5;
            lllllllllllllllIIIlIIIIIlIllIIlI = this.posX - lllllllllllllllIIIlIIIIIllIIIIlI.getX();
        }
        else {
            final double lllllllllllllllIIIlIIIIIlIlIlIlI = this.posX - lllllllllllllllIIIlIIIIIlIllIIII;
            final double lllllllllllllllIIIlIIIIIlIlIlIII = this.posZ - lllllllllllllllIIIlIIIIIlIlIlllI;
            lllllllllllllllIIIlIIIIIlIllIIlI = (lllllllllllllllIIIlIIIIIlIlIlIlI * lllllllllllllllIIIlIIIIIlIlllIIl + lllllllllllllllIIIlIIIIIlIlIlIII * lllllllllllllllIIIlIIIIIlIlllIII) * 2.0;
        }
        this.posX = lllllllllllllllIIIlIIIIIlIllIIII + lllllllllllllllIIIlIIIIIlIlllIIl * lllllllllllllllIIIlIIIIIlIllIIlI;
        this.posZ = lllllllllllllllIIIlIIIIIlIlIlllI + lllllllllllllllIIIlIIIIIlIlllIII * lllllllllllllllIIIlIIIIIlIllIIlI;
        this.setPosition(this.posX, this.posY, this.posZ);
        double lllllllllllllllIIIlIIIIIlIlIlIIl = this.motionX;
        double lllllllllllllllIIIlIIIIIlIlIIlll = this.motionZ;
        if (this.riddenByEntity != null) {
            lllllllllllllllIIIlIIIIIlIlIlIIl *= 0.75;
            lllllllllllllllIIIlIIIIIlIlIIlll *= 0.75;
        }
        final double lllllllllllllllIIIlIIIIIlIlIIllI = this.func_174898_m();
        lllllllllllllllIIIlIIIIIlIlIlIIl = MathHelper.clamp_double(lllllllllllllllIIIlIIIIIlIlIlIIl, -lllllllllllllllIIIlIIIIIlIlIIllI, lllllllllllllllIIIlIIIIIlIlIIllI);
        lllllllllllllllIIIlIIIIIlIlIIlll = MathHelper.clamp_double(lllllllllllllllIIIlIIIIIlIlIIlll, -lllllllllllllllIIIlIIIIIlIlIIllI, lllllllllllllllIIIlIIIIIlIlIIllI);
        this.moveEntity(lllllllllllllllIIIlIIIIIlIlIlIIl, 0.0, lllllllllllllllIIIlIIIIIlIlIIlll);
        if (lllllllllllllllIIIlIIIIIlIlllIlI[0][1] != 0 && MathHelper.floor_double(this.posX) - lllllllllllllllIIIlIIIIIllIIIIlI.getX() == lllllllllllllllIIIlIIIIIlIlllIlI[0][0] && MathHelper.floor_double(this.posZ) - lllllllllllllllIIIlIIIIIllIIIIlI.getZ() == lllllllllllllllIIIlIIIIIlIlllIlI[0][2]) {
            this.setPosition(this.posX, this.posY + lllllllllllllllIIIlIIIIIlIlllIlI[0][1], this.posZ);
        }
        else if (lllllllllllllllIIIlIIIIIlIlllIlI[1][1] != 0 && MathHelper.floor_double(this.posX) - lllllllllllllllIIIlIIIIIllIIIIlI.getX() == lllllllllllllllIIIlIIIIIlIlllIlI[1][0] && MathHelper.floor_double(this.posZ) - lllllllllllllllIIIlIIIIIllIIIIlI.getZ() == lllllllllllllllIIIlIIIIIlIlllIlI[1][2]) {
            this.setPosition(this.posX, this.posY + lllllllllllllllIIIlIIIIIlIlllIlI[1][1], this.posZ);
        }
        this.applyDrag();
        final Vec3 lllllllllllllllIIIlIIIIIlIlIIlIl = this.func_70489_a(this.posX, this.posY, this.posZ);
        if (lllllllllllllllIIIlIIIIIlIlIIlIl != null && lllllllllllllllIIIlIIIIIllIIIIII != null) {
            final double lllllllllllllllIIIlIIIIIlIlIIlII = (lllllllllllllllIIIlIIIIIllIIIIII.yCoord - lllllllllllllllIIIlIIIIIlIlIIlIl.yCoord) * 0.05;
            lllllllllllllllIIIlIIIIIlIllIlIl = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            if (lllllllllllllllIIIlIIIIIlIllIlIl > 0.0) {
                this.motionX = this.motionX / lllllllllllllllIIIlIIIIIlIllIlIl * (lllllllllllllllIIIlIIIIIlIllIlIl + lllllllllllllllIIIlIIIIIlIlIIlII);
                this.motionZ = this.motionZ / lllllllllllllllIIIlIIIIIlIllIlIl * (lllllllllllllllIIIlIIIIIlIllIlIl + lllllllllllllllIIIlIIIIIlIlIIlII);
            }
            this.setPosition(this.posX, lllllllllllllllIIIlIIIIIlIlIIlIl.yCoord, this.posZ);
        }
        final int lllllllllllllllIIIlIIIIIlIlIIIll = MathHelper.floor_double(this.posX);
        final int lllllllllllllllIIIlIIIIIlIlIIIlI = MathHelper.floor_double(this.posZ);
        if (lllllllllllllllIIIlIIIIIlIlIIIll != lllllllllllllllIIIlIIIIIllIIIIlI.getX() || lllllllllllllllIIIlIIIIIlIlIIIlI != lllllllllllllllIIIlIIIIIllIIIIlI.getZ()) {
            lllllllllllllllIIIlIIIIIlIllIlIl = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.motionX = lllllllllllllllIIIlIIIIIlIllIlIl * (lllllllllllllllIIIlIIIIIlIlIIIll - lllllllllllllllIIIlIIIIIllIIIIlI.getX());
            this.motionZ = lllllllllllllllIIIlIIIIIlIllIlIl * (lllllllllllllllIIIlIIIIIlIlIIIlI - lllllllllllllllIIIlIIIIIllIIIIlI.getZ());
        }
        if (lllllllllllllllIIIlIIIIIlIllllll) {
            final double lllllllllllllllIIIlIIIIIlIlIIIIl = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            if (lllllllllllllllIIIlIIIIIlIlIIIIl > 0.01) {
                final double lllllllllllllllIIIlIIIIIlIlIIIII = 0.06;
                this.motionX += this.motionX / lllllllllllllllIIIlIIIIIlIlIIIIl * lllllllllllllllIIIlIIIIIlIlIIIII;
                this.motionZ += this.motionZ / lllllllllllllllIIIlIIIIIlIlIIIIl * lllllllllllllllIIIlIIIIIlIlIIIII;
            }
            else if (lllllllllllllllIIIlIIIIIlIlllIll == BlockRailBase.EnumRailDirection.EAST_WEST) {
                if (this.worldObj.getBlockState(lllllllllllllllIIIlIIIIIllIIIIlI.offsetWest()).getBlock().isNormalCube()) {
                    this.motionX = 0.02;
                }
                else if (this.worldObj.getBlockState(lllllllllllllllIIIlIIIIIllIIIIlI.offsetEast()).getBlock().isNormalCube()) {
                    this.motionX = -0.02;
                }
            }
            else if (lllllllllllllllIIIlIIIIIlIlllIll == BlockRailBase.EnumRailDirection.NORTH_SOUTH) {
                if (this.worldObj.getBlockState(lllllllllllllllIIIlIIIIIllIIIIlI.offsetNorth()).getBlock().isNormalCube()) {
                    this.motionZ = 0.02;
                }
                else if (this.worldObj.getBlockState(lllllllllllllllIIIlIIIIIllIIIIlI.offsetSouth()).getBlock().isNormalCube()) {
                    this.motionZ = -0.02;
                }
            }
        }
    }
    
    public int getDisplayTileOffset() {
        return this.hasDisplayTile() ? this.getDataWatcher().getWatchableObjectInt(21) : this.getDefaultDisplayTileOffset();
    }
    
    @Override
    public void applyEntityCollision(final Entity lllllllllllllllIIIIlllllllIIlllI) {
        if (!this.worldObj.isRemote && !lllllllllllllllIIIIlllllllIIlllI.noClip && !this.noClip && lllllllllllllllIIIIlllllllIIlllI != this.riddenByEntity) {
            if (lllllllllllllllIIIIlllllllIIlllI instanceof EntityLivingBase && !(lllllllllllllllIIIIlllllllIIlllI instanceof EntityPlayer) && !(lllllllllllllllIIIIlllllllIIlllI instanceof EntityIronGolem) && this.func_180456_s() == EnumMinecartType.RIDEABLE && this.motionX * this.motionX + this.motionZ * this.motionZ > 0.01 && this.riddenByEntity == null && lllllllllllllllIIIIlllllllIIlllI.ridingEntity == null) {
                lllllllllllllllIIIIlllllllIIlllI.mountEntity(this);
            }
            double lllllllllllllllIIIIlllllllIllIlI = lllllllllllllllIIIIlllllllIIlllI.posX - this.posX;
            double lllllllllllllllIIIIlllllllIllIIl = lllllllllllllllIIIIlllllllIIlllI.posZ - this.posZ;
            double lllllllllllllllIIIIlllllllIllIII = lllllllllllllllIIIIlllllllIllIlI * lllllllllllllllIIIIlllllllIllIlI + lllllllllllllllIIIIlllllllIllIIl * lllllllllllllllIIIIlllllllIllIIl;
            if (lllllllllllllllIIIIlllllllIllIII >= 9.999999747378752E-5) {
                lllllllllllllllIIIIlllllllIllIII = MathHelper.sqrt_double(lllllllllllllllIIIIlllllllIllIII);
                lllllllllllllllIIIIlllllllIllIlI /= lllllllllllllllIIIIlllllllIllIII;
                lllllllllllllllIIIIlllllllIllIIl /= lllllllllllllllIIIIlllllllIllIII;
                double lllllllllllllllIIIIlllllllIlIlll = 1.0 / lllllllllllllllIIIIlllllllIllIII;
                if (lllllllllllllllIIIIlllllllIlIlll > 1.0) {
                    lllllllllllllllIIIIlllllllIlIlll = 1.0;
                }
                lllllllllllllllIIIIlllllllIllIlI *= lllllllllllllllIIIIlllllllIlIlll;
                lllllllllllllllIIIIlllllllIllIIl *= lllllllllllllllIIIIlllllllIlIlll;
                lllllllllllllllIIIIlllllllIllIlI *= 0.10000000149011612;
                lllllllllllllllIIIIlllllllIllIIl *= 0.10000000149011612;
                lllllllllllllllIIIIlllllllIllIlI *= 1.0f - this.entityCollisionReduction;
                lllllllllllllllIIIIlllllllIllIIl *= 1.0f - this.entityCollisionReduction;
                lllllllllllllllIIIIlllllllIllIlI *= 0.5;
                lllllllllllllllIIIIlllllllIllIIl *= 0.5;
                if (lllllllllllllllIIIIlllllllIIlllI instanceof EntityMinecart) {
                    final double lllllllllllllllIIIIlllllllIlIllI = lllllllllllllllIIIIlllllllIIlllI.posX - this.posX;
                    final double lllllllllllllllIIIIlllllllIlIlIl = lllllllllllllllIIIIlllllllIIlllI.posZ - this.posZ;
                    final Vec3 lllllllllllllllIIIIlllllllIlIlII = new Vec3(lllllllllllllllIIIIlllllllIlIllI, 0.0, lllllllllllllllIIIIlllllllIlIlIl).normalize();
                    final Vec3 lllllllllllllllIIIIlllllllIlIIll = new Vec3(MathHelper.cos(this.rotationYaw * 3.1415927f / 180.0f), 0.0, MathHelper.sin(this.rotationYaw * 3.1415927f / 180.0f)).normalize();
                    final double lllllllllllllllIIIIlllllllIlIIlI = Math.abs(lllllllllllllllIIIIlllllllIlIlII.dotProduct(lllllllllllllllIIIIlllllllIlIIll));
                    if (lllllllllllllllIIIIlllllllIlIIlI < 0.800000011920929) {
                        return;
                    }
                    double lllllllllllllllIIIIlllllllIlIIIl = lllllllllllllllIIIIlllllllIIlllI.motionX + this.motionX;
                    double lllllllllllllllIIIIlllllllIlIIII = lllllllllllllllIIIIlllllllIIlllI.motionZ + this.motionZ;
                    if (((EntityMinecart)lllllllllllllllIIIIlllllllIIlllI).func_180456_s() == EnumMinecartType.FURNACE && this.func_180456_s() != EnumMinecartType.FURNACE) {
                        this.motionX *= 0.20000000298023224;
                        this.motionZ *= 0.20000000298023224;
                        this.addVelocity(lllllllllllllllIIIIlllllllIIlllI.motionX - lllllllllllllllIIIIlllllllIllIlI, 0.0, lllllllllllllllIIIIlllllllIIlllI.motionZ - lllllllllllllllIIIIlllllllIllIIl);
                        lllllllllllllllIIIIlllllllIIlllI.motionX *= 0.949999988079071;
                        lllllllllllllllIIIIlllllllIIlllI.motionZ *= 0.949999988079071;
                    }
                    else if (((EntityMinecart)lllllllllllllllIIIIlllllllIIlllI).func_180456_s() != EnumMinecartType.FURNACE && this.func_180456_s() == EnumMinecartType.FURNACE) {
                        lllllllllllllllIIIIlllllllIIlllI.motionX *= 0.20000000298023224;
                        lllllllllllllllIIIIlllllllIIlllI.motionZ *= 0.20000000298023224;
                        lllllllllllllllIIIIlllllllIIlllI.addVelocity(this.motionX + lllllllllllllllIIIIlllllllIllIlI, 0.0, this.motionZ + lllllllllllllllIIIIlllllllIllIIl);
                        this.motionX *= 0.949999988079071;
                        this.motionZ *= 0.949999988079071;
                    }
                    else {
                        lllllllllllllllIIIIlllllllIlIIIl /= 2.0;
                        lllllllllllllllIIIIlllllllIlIIII /= 2.0;
                        this.motionX *= 0.20000000298023224;
                        this.motionZ *= 0.20000000298023224;
                        this.addVelocity(lllllllllllllllIIIIlllllllIlIIIl - lllllllllllllllIIIIlllllllIllIlI, 0.0, lllllllllllllllIIIIlllllllIlIIII - lllllllllllllllIIIIlllllllIllIIl);
                        lllllllllllllllIIIIlllllllIIlllI.motionX *= 0.20000000298023224;
                        lllllllllllllllIIIIlllllllIIlllI.motionZ *= 0.20000000298023224;
                        lllllllllllllllIIIIlllllllIIlllI.addVelocity(lllllllllllllllIIIIlllllllIlIIIl + lllllllllllllllIIIIlllllllIllIlI, 0.0, lllllllllllllllIIIIlllllllIlIIII + lllllllllllllllIIIIlllllllIllIIl);
                    }
                }
                else {
                    this.addVelocity(-lllllllllllllllIIIIlllllllIllIlI, 0.0, -lllllllllllllllIIIIlllllllIllIIl);
                    lllllllllllllllIIIIlllllllIIlllI.addVelocity(lllllllllllllllIIIIlllllllIllIlI / 4.0, 0.0, lllllllllllllllIIIIlllllllIllIIl / 4.0);
                }
            }
        }
    }
    
    public EntityMinecart(final World lllllllllllllllIIIlIIIIllIIIIIIl, final double lllllllllllllllIIIlIIIIlIllllIIl, final double lllllllllllllllIIIlIIIIlIllllIII, final double lllllllllllllllIIIlIIIIlIlllllII) {
        this(lllllllllllllllIIIlIIIIllIIIIIIl);
        this.setPosition(lllllllllllllllIIIlIIIIlIllllIIl, lllllllllllllllIIIlIIIIlIllllIII, lllllllllllllllIIIlIIIIlIlllllII);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.prevPosX = lllllllllllllllIIIlIIIIlIllllIIl;
        this.prevPosY = lllllllllllllllIIIlIIIIlIllllIII;
        this.prevPosZ = lllllllllllllllIIIlIIIIlIlllllII;
    }
    
    public void onActivatorRailPass(final int lllllllllllllllIIIlIIIIIlllIlIIl, final int lllllllllllllllIIIlIIIIIlllIlIII, final int lllllllllllllllIIIlIIIIIlllIIlll, final boolean lllllllllllllllIIIlIIIIIlllIIllI) {
    }
    
    @Override
    public boolean hasCustomName() {
        return this.entityName != null;
    }
    
    public void setHasDisplayTile(final boolean lllllllllllllllIIIIlllllIllIlIll) {
        this.getDataWatcher().updateObject(22, (byte)(byte)(lllllllllllllllIIIIlllllIllIlIll ? 1 : 0));
    }
    
    public Vec3 func_70489_a(double lllllllllllllllIIIlIIIIIIIIlIlll, double lllllllllllllllIIIlIIIIIIIIlIlIl, double lllllllllllllllIIIlIIIIIIIlIlIll) {
        final int lllllllllllllllIIIlIIIIIIIlIlIlI = MathHelper.floor_double(lllllllllllllllIIIlIIIIIIIIlIlll);
        int lllllllllllllllIIIlIIIIIIIlIlIIl = MathHelper.floor_double(lllllllllllllllIIIlIIIIIIIIlIlIl);
        final int lllllllllllllllIIIlIIIIIIIlIlIII = MathHelper.floor_double(lllllllllllllllIIIlIIIIIIIlIlIll);
        if (BlockRailBase.func_176562_d(this.worldObj, new BlockPos(lllllllllllllllIIIlIIIIIIIlIlIlI, lllllllllllllllIIIlIIIIIIIlIlIIl - 1, lllllllllllllllIIIlIIIIIIIlIlIII))) {
            --lllllllllllllllIIIlIIIIIIIlIlIIl;
        }
        final IBlockState lllllllllllllllIIIlIIIIIIIlIIlll = this.worldObj.getBlockState(new BlockPos(lllllllllllllllIIIlIIIIIIIlIlIlI, lllllllllllllllIIIlIIIIIIIlIlIIl, lllllllllllllllIIIlIIIIIIIlIlIII));
        if (BlockRailBase.func_176563_d(lllllllllllllllIIIlIIIIIIIlIIlll)) {
            final BlockRailBase.EnumRailDirection lllllllllllllllIIIlIIIIIIIlIIllI = (BlockRailBase.EnumRailDirection)lllllllllllllllIIIlIIIIIIIlIIlll.getValue(((BlockRailBase)lllllllllllllllIIIlIIIIIIIlIIlll.getBlock()).func_176560_l());
            final int[][] lllllllllllllllIIIlIIIIIIIlIIlIl = EntityMinecart.matrix[lllllllllllllllIIIlIIIIIIIlIIllI.func_177015_a()];
            double lllllllllllllllIIIlIIIIIIIlIIlII = 0.0;
            final double lllllllllllllllIIIlIIIIIIIlIIIll = lllllllllllllllIIIlIIIIIIIlIlIlI + 0.5 + lllllllllllllllIIIlIIIIIIIlIIlIl[0][0] * 0.5;
            final double lllllllllllllllIIIlIIIIIIIlIIIlI = lllllllllllllllIIIlIIIIIIIlIlIIl + 0.0625 + lllllllllllllllIIIlIIIIIIIlIIlIl[0][1] * 0.5;
            final double lllllllllllllllIIIlIIIIIIIlIIIIl = lllllllllllllllIIIlIIIIIIIlIlIII + 0.5 + lllllllllllllllIIIlIIIIIIIlIIlIl[0][2] * 0.5;
            final double lllllllllllllllIIIlIIIIIIIlIIIII = lllllllllllllllIIIlIIIIIIIlIlIlI + 0.5 + lllllllllllllllIIIlIIIIIIIlIIlIl[1][0] * 0.5;
            final double lllllllllllllllIIIlIIIIIIIIlllll = lllllllllllllllIIIlIIIIIIIlIlIIl + 0.0625 + lllllllllllllllIIIlIIIIIIIlIIlIl[1][1] * 0.5;
            final double lllllllllllllllIIIlIIIIIIIIllllI = lllllllllllllllIIIlIIIIIIIlIlIII + 0.5 + lllllllllllllllIIIlIIIIIIIlIIlIl[1][2] * 0.5;
            final double lllllllllllllllIIIlIIIIIIIIlllIl = lllllllllllllllIIIlIIIIIIIlIIIII - lllllllllllllllIIIlIIIIIIIlIIIll;
            final double lllllllllllllllIIIlIIIIIIIIlllII = (lllllllllllllllIIIlIIIIIIIIlllll - lllllllllllllllIIIlIIIIIIIlIIIlI) * 2.0;
            final double lllllllllllllllIIIlIIIIIIIIllIll = lllllllllllllllIIIlIIIIIIIIllllI - lllllllllllllllIIIlIIIIIIIlIIIIl;
            if (lllllllllllllllIIIlIIIIIIIIlllIl == 0.0) {
                lllllllllllllllIIIlIIIIIIIIlIlll = lllllllllllllllIIIlIIIIIIIlIlIlI + 0.5;
                lllllllllllllllIIIlIIIIIIIlIIlII = lllllllllllllllIIIlIIIIIIIlIlIll - lllllllllllllllIIIlIIIIIIIlIlIII;
            }
            else if (lllllllllllllllIIIlIIIIIIIIllIll == 0.0) {
                lllllllllllllllIIIlIIIIIIIlIlIll = lllllllllllllllIIIlIIIIIIIlIlIII + 0.5;
                lllllllllllllllIIIlIIIIIIIlIIlII = lllllllllllllllIIIlIIIIIIIIlIlll - lllllllllllllllIIIlIIIIIIIlIlIlI;
            }
            else {
                final double lllllllllllllllIIIlIIIIIIIIllIlI = lllllllllllllllIIIlIIIIIIIIlIlll - lllllllllllllllIIIlIIIIIIIlIIIll;
                final double lllllllllllllllIIIlIIIIIIIIllIIl = lllllllllllllllIIIlIIIIIIIlIlIll - lllllllllllllllIIIlIIIIIIIlIIIIl;
                lllllllllllllllIIIlIIIIIIIlIIlII = (lllllllllllllllIIIlIIIIIIIIllIlI * lllllllllllllllIIIlIIIIIIIIlllIl + lllllllllllllllIIIlIIIIIIIIllIIl * lllllllllllllllIIIlIIIIIIIIllIll) * 2.0;
            }
            lllllllllllllllIIIlIIIIIIIIlIlll = lllllllllllllllIIIlIIIIIIIlIIIll + lllllllllllllllIIIlIIIIIIIIlllIl * lllllllllllllllIIIlIIIIIIIlIIlII;
            lllllllllllllllIIIlIIIIIIIIlIlIl = lllllllllllllllIIIlIIIIIIIlIIIlI + lllllllllllllllIIIlIIIIIIIIlllII * lllllllllllllllIIIlIIIIIIIlIIlII;
            lllllllllllllllIIIlIIIIIIIlIlIll = lllllllllllllllIIIlIIIIIIIlIIIIl + lllllllllllllllIIIlIIIIIIIIllIll * lllllllllllllllIIIlIIIIIIIlIIlII;
            if (lllllllllllllllIIIlIIIIIIIIlllII < 0.0) {
                ++lllllllllllllllIIIlIIIIIIIIlIlIl;
            }
            if (lllllllllllllllIIIlIIIIIIIIlllII > 0.0) {
                lllllllllllllllIIIlIIIIIIIIlIlIl += 0.5;
            }
            return new Vec3(lllllllllllllllIIIlIIIIIIIIlIlll, lllllllllllllllIIIlIIIIIIIIlIlIl, lllllllllllllllIIIlIIIIIIIlIlIll);
        }
        return null;
    }
    
    @Override
    public AxisAlignedBB getCollisionBox(final Entity lllllllllllllllIIIlIIIIllIIlIlII) {
        return lllllllllllllllIIIlIIIIllIIlIlII.canBePushed() ? lllllllllllllllIIIlIIIIllIIlIlII.getEntityBoundingBox() : null;
    }
    
    public IBlockState func_174897_t() {
        return this.hasDisplayTile() ? Block.getStateById(this.getDataWatcher().getWatchableObjectInt(20)) : this.func_180457_u();
    }
    
    @Override
    public void setVelocity(final double lllllllllllllllIIIIllllllIlIIIll, final double lllllllllllllllIIIIllllllIlIIllI, final double lllllllllllllllIIIIllllllIlIIlIl) {
        this.motionX = lllllllllllllllIIIIllllllIlIIIll;
        this.velocityX = lllllllllllllllIIIIllllllIlIIIll;
        this.motionY = lllllllllllllllIIIIllllllIlIIllI;
        this.velocityY = lllllllllllllllIIIIllllllIlIIllI;
        this.motionZ = lllllllllllllllIIIIllllllIlIIlIl;
        this.velocityZ = lllllllllllllllIIIIllllllIlIIlIl;
    }
    
    @Override
    public IChatComponent getDisplayName() {
        if (this.hasCustomName()) {
            final ChatComponentText lllllllllllllllIIIIlllllIlIlIllI = new ChatComponentText(this.entityName);
            lllllllllllllllIIIIlllllIlIlIllI.getChatStyle().setChatHoverEvent(this.func_174823_aP());
            lllllllllllllllIIIIlllllIlIlIllI.getChatStyle().setInsertion(this.getUniqueID().toString());
            return lllllllllllllllIIIIlllllIlIlIllI;
        }
        final ChatComponentTranslation lllllllllllllllIIIIlllllIlIlIlIl = new ChatComponentTranslation(this.getName(), new Object[0]);
        lllllllllllllllIIIIlllllIlIlIlIl.getChatStyle().setChatHoverEvent(this.func_174823_aP());
        lllllllllllllllIIIIlllllIlIlIlIl.getChatStyle().setInsertion(this.getUniqueID().toString());
        return lllllllllllllllIIIIlllllIlIlIlIl;
    }
    
    public void setDisplayTileOffset(final int lllllllllllllllIIIIlllllIlllIIlI) {
        this.getDataWatcher().updateObject(21, lllllllllllllllIIIIlllllIlllIIlI);
        this.setHasDisplayTile(true);
    }
    
    @Override
    public void performHurtAnimation() {
        this.setRollingDirection(-this.getRollingDirection());
        this.setRollingAmplitude(10);
        this.setDamage(this.getDamage() + this.getDamage() * 10.0f);
    }
    
    public int getRollingDirection() {
        return this.dataWatcher.getWatchableObjectInt(18);
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllllIIIlIIIIlIlIllIIl, final float lllllllllllllllIIIlIIIIlIlIlIlll) {
        if (this.worldObj.isRemote || this.isDead) {
            return true;
        }
        if (this.func_180431_b(lllllllllllllllIIIlIIIIlIlIllIIl)) {
            return false;
        }
        this.setRollingDirection(-this.getRollingDirection());
        this.setRollingAmplitude(10);
        this.setBeenAttacked();
        this.setDamage(this.getDamage() + lllllllllllllllIIIlIIIIlIlIlIlll * 10.0f);
        final boolean lllllllllllllllIIIlIIIIlIlIlIlIl = lllllllllllllllIIIlIIIIlIlIllIIl.getEntity() instanceof EntityPlayer && ((EntityPlayer)lllllllllllllllIIIlIIIIlIlIllIIl.getEntity()).capabilities.isCreativeMode;
        if (lllllllllllllllIIIlIIIIlIlIlIlIl || this.getDamage() > 40.0f) {
            if (this.riddenByEntity != null) {
                this.riddenByEntity.mountEntity(null);
            }
            if (lllllllllllllllIIIlIIIIlIlIlIlIl && !this.hasCustomName()) {
                this.setDead();
            }
            else {
                this.killMinecart(lllllllllllllllIIIlIIIIlIlIllIIl);
            }
        }
        return true;
    }
    
    public boolean hasDisplayTile() {
        return this.getDataWatcher().getWatchableObjectByte(22) == 1;
    }
    
    public void setRollingAmplitude(final int lllllllllllllllIIIIllllllIIlIIlI) {
        this.dataWatcher.updateObject(17, lllllllllllllllIIIIllllllIIlIIlI);
    }
    
    @Override
    public boolean canBeCollidedWith() {
        return !this.isDead;
    }
    
    public EntityMinecart(final World lllllllllllllllIIIlIIIIlllIIlIII) {
        super(lllllllllllllllIIIlIIIIlllIIlIII);
        this.preventEntitySpawning = true;
        this.setSize(0.98f, 0.7f);
    }
    
    public Vec3 func_70495_a(double lllllllllllllllIIIlIIIIIIlIlIIIl, double lllllllllllllllIIIlIIIIIIlIlIIII, double lllllllllllllllIIIlIIIIIIlIlllIl, final double lllllllllllllllIIIlIIIIIIlIlllII) {
        final int lllllllllllllllIIIlIIIIIIlIllIll = MathHelper.floor_double(lllllllllllllllIIIlIIIIIIlIlIIIl);
        int lllllllllllllllIIIlIIIIIIlIllIlI = MathHelper.floor_double(lllllllllllllllIIIlIIIIIIlIlIIII);
        final int lllllllllllllllIIIlIIIIIIlIllIIl = MathHelper.floor_double(lllllllllllllllIIIlIIIIIIlIlllIl);
        if (BlockRailBase.func_176562_d(this.worldObj, new BlockPos(lllllllllllllllIIIlIIIIIIlIllIll, lllllllllllllllIIIlIIIIIIlIllIlI - 1, lllllllllllllllIIIlIIIIIIlIllIIl))) {
            --lllllllllllllllIIIlIIIIIIlIllIlI;
        }
        final IBlockState lllllllllllllllIIIlIIIIIIlIllIII = this.worldObj.getBlockState(new BlockPos(lllllllllllllllIIIlIIIIIIlIllIll, lllllllllllllllIIIlIIIIIIlIllIlI, lllllllllllllllIIIlIIIIIIlIllIIl));
        if (BlockRailBase.func_176563_d(lllllllllllllllIIIlIIIIIIlIllIII)) {
            final BlockRailBase.EnumRailDirection lllllllllllllllIIIlIIIIIIlIlIlll = (BlockRailBase.EnumRailDirection)lllllllllllllllIIIlIIIIIIlIllIII.getValue(((BlockRailBase)lllllllllllllllIIIlIIIIIIlIllIII.getBlock()).func_176560_l());
            lllllllllllllllIIIlIIIIIIlIlIIII = lllllllllllllllIIIlIIIIIIlIllIlI;
            if (lllllllllllllllIIIlIIIIIIlIlIlll.func_177018_c()) {
                lllllllllllllllIIIlIIIIIIlIlIIII = lllllllllllllllIIIlIIIIIIlIllIlI + 1;
            }
            final int[][] lllllllllllllllIIIlIIIIIIlIlIllI = EntityMinecart.matrix[lllllllllllllllIIIlIIIIIIlIlIlll.func_177015_a()];
            double lllllllllllllllIIIlIIIIIIlIlIlIl = lllllllllllllllIIIlIIIIIIlIlIllI[1][0] - lllllllllllllllIIIlIIIIIIlIlIllI[0][0];
            double lllllllllllllllIIIlIIIIIIlIlIlII = lllllllllllllllIIIlIIIIIIlIlIllI[1][2] - lllllllllllllllIIIlIIIIIIlIlIllI[0][2];
            final double lllllllllllllllIIIlIIIIIIlIlIIll = Math.sqrt(lllllllllllllllIIIlIIIIIIlIlIlIl * lllllllllllllllIIIlIIIIIIlIlIlIl + lllllllllllllllIIIlIIIIIIlIlIlII * lllllllllllllllIIIlIIIIIIlIlIlII);
            lllllllllllllllIIIlIIIIIIlIlIlIl /= lllllllllllllllIIIlIIIIIIlIlIIll;
            lllllllllllllllIIIlIIIIIIlIlIlII /= lllllllllllllllIIIlIIIIIIlIlIIll;
            lllllllllllllllIIIlIIIIIIlIlIIIl += lllllllllllllllIIIlIIIIIIlIlIlIl * lllllllllllllllIIIlIIIIIIlIlllII;
            lllllllllllllllIIIlIIIIIIlIlllIl += lllllllllllllllIIIlIIIIIIlIlIlII * lllllllllllllllIIIlIIIIIIlIlllII;
            if (lllllllllllllllIIIlIIIIIIlIlIllI[0][1] != 0 && MathHelper.floor_double(lllllllllllllllIIIlIIIIIIlIlIIIl) - lllllllllllllllIIIlIIIIIIlIllIll == lllllllllllllllIIIlIIIIIIlIlIllI[0][0] && MathHelper.floor_double(lllllllllllllllIIIlIIIIIIlIlllIl) - lllllllllllllllIIIlIIIIIIlIllIIl == lllllllllllllllIIIlIIIIIIlIlIllI[0][2]) {
                lllllllllllllllIIIlIIIIIIlIlIIII += lllllllllllllllIIIlIIIIIIlIlIllI[0][1];
            }
            else if (lllllllllllllllIIIlIIIIIIlIlIllI[1][1] != 0 && MathHelper.floor_double(lllllllllllllllIIIlIIIIIIlIlIIIl) - lllllllllllllllIIIlIIIIIIlIllIll == lllllllllllllllIIIlIIIIIIlIlIllI[1][0] && MathHelper.floor_double(lllllllllllllllIIIlIIIIIIlIlllIl) - lllllllllllllllIIIlIIIIIIlIllIIl == lllllllllllllllIIIlIIIIIIlIlIllI[1][2]) {
                lllllllllllllllIIIlIIIIIIlIlIIII += lllllllllllllllIIIlIIIIIIlIlIllI[1][1];
            }
            return this.func_70489_a(lllllllllllllllIIIlIIIIIIlIlIIIl, lllllllllllllllIIIlIIIIIIlIlIIII, lllllllllllllllIIIlIIIIIIlIlllIl);
        }
        return null;
    }
    
    @Override
    public double getMountedYOffset() {
        return this.height * 0.5 - 0.20000000298023224;
    }
    
    public void setDamage(final float lllllllllllllllIIIIllllllIIlllIl) {
        this.dataWatcher.updateObject(19, lllllllllllllllIIIIllllllIIlllIl);
    }
    
    @Override
    public void setPosition(final double lllllllllllllllIIIlIIIIIIlllIIll, final double lllllllllllllllIIIlIIIIIIllllIII, final double lllllllllllllllIIIlIIIIIIlllIIIl) {
        this.posX = lllllllllllllllIIIlIIIIIIlllIIll;
        this.posY = lllllllllllllllIIIlIIIIIIllllIII;
        this.posZ = lllllllllllllllIIIlIIIIIIlllIIIl;
        final float lllllllllllllllIIIlIIIIIIlllIllI = this.width / 2.0f;
        final float lllllllllllllllIIIlIIIIIIlllIlIl = this.height;
        this.func_174826_a(new AxisAlignedBB(lllllllllllllllIIIlIIIIIIlllIIll - lllllllllllllllIIIlIIIIIIlllIllI, lllllllllllllllIIIlIIIIIIllllIII, lllllllllllllllIIIlIIIIIIlllIIIl - lllllllllllllllIIIlIIIIIIlllIllI, lllllllllllllllIIIlIIIIIIlllIIll + lllllllllllllllIIIlIIIIIIlllIllI, lllllllllllllllIIIlIIIIIIllllIII + lllllllllllllllIIIlIIIIIIlllIlIl, lllllllllllllllIIIlIIIIIIlllIIIl + lllllllllllllllIIIlIIIIIIlllIllI));
    }
    
    @Override
    public String getName() {
        return (this.entityName != null) ? this.entityName : super.getName();
    }
    
    public void setRollingDirection(final int lllllllllllllllIIIIllllllIIIlIIl) {
        this.dataWatcher.updateObject(18, lllllllllllllllIIIIllllllIIIlIIl);
    }
    
    public IBlockState func_180457_u() {
        return Blocks.air.getDefaultState();
    }
    
    public int getDefaultDisplayTileOffset() {
        return 6;
    }
    
    protected void applyDrag() {
        if (this.riddenByEntity != null) {
            this.motionX *= 0.996999979019165;
            this.motionY *= 0.0;
            this.motionZ *= 0.996999979019165;
        }
        else {
            this.motionX *= 0.9599999785423279;
            this.motionY *= 0.0;
            this.motionZ *= 0.9599999785423279;
        }
    }
    
    @Override
    public boolean canBePushed() {
        return true;
    }
    
    public int getRollingAmplitude() {
        return this.dataWatcher.getWatchableObjectInt(17);
    }
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound lllllllllllllllIIIIlllllllllllIl) {
        if (lllllllllllllllIIIIlllllllllllIl.getBoolean("CustomDisplayTile")) {
            final int lllllllllllllllIIIIlllllllllllII = lllllllllllllllIIIIlllllllllllIl.getInteger("DisplayData");
            if (lllllllllllllllIIIIlllllllllllIl.hasKey("DisplayTile", 8)) {
                final Block lllllllllllllllIIIIllllllllllIll = Block.getBlockFromName(lllllllllllllllIIIIlllllllllllIl.getString("DisplayTile"));
                if (lllllllllllllllIIIIllllllllllIll == null) {
                    this.func_174899_a(Blocks.air.getDefaultState());
                }
                else {
                    this.func_174899_a(lllllllllllllllIIIIllllllllllIll.getStateFromMeta(lllllllllllllllIIIIlllllllllllII));
                }
            }
            else {
                final Block lllllllllllllllIIIIllllllllllIlI = Block.getBlockById(lllllllllllllllIIIIlllllllllllIl.getInteger("DisplayTile"));
                if (lllllllllllllllIIIIllllllllllIlI == null) {
                    this.func_174899_a(Blocks.air.getDefaultState());
                }
                else {
                    this.func_174899_a(lllllllllllllllIIIIllllllllllIlI.getStateFromMeta(lllllllllllllllIIIIlllllllllllII));
                }
            }
            this.setDisplayTileOffset(lllllllllllllllIIIIlllllllllllIl.getInteger("DisplayOffset"));
        }
        if (lllllllllllllllIIIIlllllllllllIl.hasKey("CustomName", 8) && lllllllllllllllIIIIlllllllllllIl.getString("CustomName").length() > 0) {
            this.entityName = lllllllllllllllIIIIlllllllllllIl.getString("CustomName");
        }
    }
    
    public float getDamage() {
        return this.dataWatcher.getWatchableObjectFloat(19);
    }
    
    static {
        __OBFID = "CL_00001670";
        matrix = new int[][][] { { { 0, 0, -1 }, { 0, 0, 1 } }, { { -1, 0, 0 }, { 1, 0, 0 } }, { { -1, -1, 0 }, { 1, 0, 0 } }, { { -1, 0, 0 }, { 1, -1, 0 } }, { { 0, 0, -1 }, { 0, -1, 1 } }, { { 0, -1, -1 }, { 0, 0, 1 } }, { { 0, 0, 1 }, { 1, 0, 0 } }, { { 0, 0, 1 }, { -1, 0, 0 } }, { { 0, 0, -1 }, { -1, 0, 0 } }, { { 0, 0, -1 }, { 1, 0, 0 } } };
    }
    
    @Override
    public String getCustomNameTag() {
        return this.entityName;
    }
    
    public abstract EnumMinecartType func_180456_s();
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound lllllllllllllllIIIIlllllllllIIII) {
        if (this.hasDisplayTile()) {
            lllllllllllllllIIIIlllllllllIIII.setBoolean("CustomDisplayTile", true);
            final IBlockState lllllllllllllllIIIIllllllllIllll = this.func_174897_t();
            final ResourceLocation lllllllllllllllIIIIllllllllIlllI = (ResourceLocation)Block.blockRegistry.getNameForObject(lllllllllllllllIIIIllllllllIllll.getBlock());
            lllllllllllllllIIIIlllllllllIIII.setString("DisplayTile", (lllllllllllllllIIIIllllllllIlllI == null) ? "" : lllllllllllllllIIIIllllllllIlllI.toString());
            lllllllllllllllIIIIlllllllllIIII.setInteger("DisplayData", lllllllllllllllIIIIllllllllIllll.getBlock().getMetaFromState(lllllllllllllllIIIIllllllllIllll));
            lllllllllllllllIIIIlllllllllIIII.setInteger("DisplayOffset", this.getDisplayTileOffset());
        }
        if (this.entityName != null && this.entityName.length() > 0) {
            lllllllllllllllIIIIlllllllllIIII.setString("CustomName", this.entityName);
        }
    }
    
    public void killMinecart(final DamageSource lllllllllllllllIIIlIIIIlIlIIIlll) {
        this.setDead();
        final ItemStack lllllllllllllllIIIlIIIIlIlIIIllI = new ItemStack(Items.minecart, 1);
        if (this.entityName != null) {
            lllllllllllllllIIIlIIIIlIlIIIllI.setStackDisplayName(this.entityName);
        }
        this.entityDropItem(lllllllllllllllIIIlIIIIlIlIIIllI, 0.0f);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox() {
        return null;
    }
    
    protected double func_174898_m() {
        return 0.4;
    }
    
    @Override
    public void onUpdate() {
        if (this.getRollingAmplitude() > 0) {
            this.setRollingAmplitude(this.getRollingAmplitude() - 1);
        }
        if (this.getDamage() > 0.0f) {
            this.setDamage(this.getDamage() - 1.0f);
        }
        if (this.posY < -64.0) {
            this.kill();
        }
        if (!this.worldObj.isRemote && this.worldObj instanceof WorldServer) {
            this.worldObj.theProfiler.startSection("portal");
            final MinecraftServer lllllllllllllllIIIlIIIIlIIIIIllI = ((WorldServer)this.worldObj).func_73046_m();
            final int lllllllllllllllIIIlIIIIlIIIIlIII = this.getMaxInPortalTime();
            if (this.inPortal) {
                if (lllllllllllllllIIIlIIIIlIIIIIllI.getAllowNether()) {
                    if (this.ridingEntity == null && this.portalCounter++ >= lllllllllllllllIIIlIIIIlIIIIlIII) {
                        this.portalCounter = lllllllllllllllIIIlIIIIlIIIIlIII;
                        this.timeUntilPortal = this.getPortalCooldown();
                        byte lllllllllllllllIIIlIIIIlIIIIIlII = 0;
                        if (this.worldObj.provider.getDimensionId() == -1) {
                            final byte lllllllllllllllIIIlIIIIlIIIIIlIl = 0;
                        }
                        else {
                            lllllllllllllllIIIlIIIIlIIIIIlII = -1;
                        }
                        this.travelToDimension(lllllllllllllllIIIlIIIIlIIIIIlII);
                    }
                    this.inPortal = false;
                }
            }
            else {
                if (this.portalCounter > 0) {
                    this.portalCounter -= 4;
                }
                if (this.portalCounter < 0) {
                    this.portalCounter = 0;
                }
            }
            if (this.timeUntilPortal > 0) {
                --this.timeUntilPortal;
            }
            this.worldObj.theProfiler.endSection();
        }
        if (this.worldObj.isRemote) {
            if (this.turnProgress > 0) {
                final double lllllllllllllllIIIlIIIIlIIIIIIll = this.posX + (this.minecartX - this.posX) / this.turnProgress;
                final double lllllllllllllllIIIlIIIIlIIIIIIlI = this.posY + (this.minecartY - this.posY) / this.turnProgress;
                final double lllllllllllllllIIIlIIIIlIIIIIIIl = this.posZ + (this.minecartZ - this.posZ) / this.turnProgress;
                final double lllllllllllllllIIIlIIIIlIIIIIIII = MathHelper.wrapAngleTo180_double(this.minecartYaw - this.rotationYaw);
                this.rotationYaw += (float)(lllllllllllllllIIIlIIIIlIIIIIIII / this.turnProgress);
                this.rotationPitch += (float)((this.minecartPitch - this.rotationPitch) / this.turnProgress);
                --this.turnProgress;
                this.setPosition(lllllllllllllllIIIlIIIIlIIIIIIll, lllllllllllllllIIIlIIIIlIIIIIIlI, lllllllllllllllIIIlIIIIlIIIIIIIl);
                this.setRotation(this.rotationYaw, this.rotationPitch);
            }
            else {
                this.setPosition(this.posX, this.posY, this.posZ);
                this.setRotation(this.rotationYaw, this.rotationPitch);
            }
        }
        else {
            this.prevPosX = this.posX;
            this.prevPosY = this.posY;
            this.prevPosZ = this.posZ;
            this.motionY -= 0.03999999910593033;
            final int lllllllllllllllIIIlIIIIIllllllll = MathHelper.floor_double(this.posX);
            int lllllllllllllllIIIlIIIIlIIIIIlll = MathHelper.floor_double(this.posY);
            final int lllllllllllllllIIIlIIIIIlllllllI = MathHelper.floor_double(this.posZ);
            if (BlockRailBase.func_176562_d(this.worldObj, new BlockPos(lllllllllllllllIIIlIIIIIllllllll, lllllllllllllllIIIlIIIIlIIIIIlll - 1, lllllllllllllllIIIlIIIIIlllllllI))) {
                --lllllllllllllllIIIlIIIIlIIIIIlll;
            }
            final BlockPos lllllllllllllllIIIlIIIIIllllllIl = new BlockPos(lllllllllllllllIIIlIIIIIllllllll, lllllllllllllllIIIlIIIIlIIIIIlll, lllllllllllllllIIIlIIIIIlllllllI);
            final IBlockState lllllllllllllllIIIlIIIIIllllllII = this.worldObj.getBlockState(lllllllllllllllIIIlIIIIIllllllIl);
            if (BlockRailBase.func_176563_d(lllllllllllllllIIIlIIIIIllllllII)) {
                this.func_180460_a(lllllllllllllllIIIlIIIIIllllllIl, lllllllllllllllIIIlIIIIIllllllII);
                if (lllllllllllllllIIIlIIIIIllllllII.getBlock() == Blocks.activator_rail) {
                    this.onActivatorRailPass(lllllllllllllllIIIlIIIIIllllllll, lllllllllllllllIIIlIIIIlIIIIIlll, lllllllllllllllIIIlIIIIIlllllllI, (boolean)lllllllllllllllIIIlIIIIIllllllII.getValue(BlockRailPowered.field_176569_M));
                }
            }
            else {
                this.func_180459_n();
            }
            this.doBlockCollisions();
            this.rotationPitch = 0.0f;
            final double lllllllllllllllIIIlIIIIIlllllIll = this.prevPosX - this.posX;
            final double lllllllllllllllIIIlIIIIIlllllIlI = this.prevPosZ - this.posZ;
            if (lllllllllllllllIIIlIIIIIlllllIll * lllllllllllllllIIIlIIIIIlllllIll + lllllllllllllllIIIlIIIIIlllllIlI * lllllllllllllllIIIlIIIIIlllllIlI > 0.001) {
                this.rotationYaw = (float)(Math.atan2(lllllllllllllllIIIlIIIIIlllllIlI, lllllllllllllllIIIlIIIIIlllllIll) * 180.0 / 3.141592653589793);
                if (this.isInReverse) {
                    this.rotationYaw += 180.0f;
                }
            }
            final double lllllllllllllllIIIlIIIIIlllllIIl = MathHelper.wrapAngleTo180_float(this.rotationYaw - this.prevRotationYaw);
            if (lllllllllllllllIIIlIIIIIlllllIIl < -170.0 || lllllllllllllllIIIlIIIIIlllllIIl >= 170.0) {
                this.rotationYaw += 180.0f;
                this.isInReverse = !this.isInReverse;
            }
            this.setRotation(this.rotationYaw, this.rotationPitch);
            for (final Entity lllllllllllllllIIIlIIIIIllllIlll : this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().expand(0.20000000298023224, 0.0, 0.20000000298023224))) {
                if (lllllllllllllllIIIlIIIIIllllIlll != this.riddenByEntity && lllllllllllllllIIIlIIIIIllllIlll.canBePushed() && lllllllllllllllIIIlIIIIIllllIlll instanceof EntityMinecart) {
                    lllllllllllllllIIIlIIIIIllllIlll.applyEntityCollision(this);
                }
            }
            if (this.riddenByEntity != null && this.riddenByEntity.isDead) {
                if (this.riddenByEntity.ridingEntity == this) {
                    this.riddenByEntity.ridingEntity = null;
                }
                this.riddenByEntity = null;
            }
            this.handleWaterMovement();
        }
    }
    
    static final class SwitchEnumMinecartType
    {
        static final /* synthetic */ int[] field_180037_a;
        static final /* synthetic */ int[] field_180036_b;
        
        static {
            __OBFID = "CL_00002227";
            field_180036_b = new int[BlockRailBase.EnumRailDirection.values().length];
            try {
                SwitchEnumMinecartType.field_180036_b[BlockRailBase.EnumRailDirection.ASCENDING_EAST.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumMinecartType.field_180036_b[BlockRailBase.EnumRailDirection.ASCENDING_WEST.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumMinecartType.field_180036_b[BlockRailBase.EnumRailDirection.ASCENDING_NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumMinecartType.field_180036_b[BlockRailBase.EnumRailDirection.ASCENDING_SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            field_180037_a = new int[EnumMinecartType.values().length];
            try {
                SwitchEnumMinecartType.field_180037_a[EnumMinecartType.CHEST.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                SwitchEnumMinecartType.field_180037_a[EnumMinecartType.FURNACE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            try {
                SwitchEnumMinecartType.field_180037_a[EnumMinecartType.TNT.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError7) {}
            try {
                SwitchEnumMinecartType.field_180037_a[EnumMinecartType.SPAWNER.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError8) {}
            try {
                SwitchEnumMinecartType.field_180037_a[EnumMinecartType.HOPPER.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError9) {}
            try {
                SwitchEnumMinecartType.field_180037_a[EnumMinecartType.COMMAND_BLOCK.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError10) {}
        }
    }
    
    public enum EnumMinecartType
    {
        private static final /* synthetic */ Map field_180051_h;
        private final /* synthetic */ String field_180049_j;
        
        TNT("TNT", 3, "TNT", 3, 3, "MinecartTNT"), 
        RIDEABLE("RIDEABLE", 0, "RIDEABLE", 0, 0, "MinecartRideable"), 
        COMMAND_BLOCK("COMMAND_BLOCK", 6, "COMMAND_BLOCK", 6, 6, "MinecartCommandBlock"), 
        HOPPER("HOPPER", 5, "HOPPER", 5, 5, "MinecartHopper"), 
        CHEST("CHEST", 1, "CHEST", 1, 1, "MinecartChest");
        
        private final /* synthetic */ int field_180052_i;
        
        FURNACE("FURNACE", 2, "FURNACE", 2, 2, "MinecartFurnace"), 
        SPAWNER("SPAWNER", 4, "SPAWNER", 4, 4, "MinecartSpawner");
        
        public static EnumMinecartType func_180038_a(final int llllllllllllllllIIllllIIIlIIIlII) {
            final EnumMinecartType llllllllllllllllIIllllIIIlIIIlIl = EnumMinecartType.field_180051_h.get(llllllllllllllllIIllllIIIlIIIlII);
            return (llllllllllllllllIIllllIIIlIIIlIl == null) ? EnumMinecartType.RIDEABLE : llllllllllllllllIIllllIIIlIIIlIl;
        }
        
        private EnumMinecartType(final String llllllllllllllllIIllllIIIlIlIIlI, final int llllllllllllllllIIllllIIIlIlIIIl, final String llllllllllllllllIIllllIIIlIlIlll, final int llllllllllllllllIIllllIIIlIlIllI, final int llllllllllllllllIIllllIIIlIlIlIl, final String llllllllllllllllIIllllIIIlIIllll) {
            this.field_180052_i = llllllllllllllllIIllllIIIlIlIlIl;
            this.field_180049_j = llllllllllllllllIIllllIIIlIIllll;
        }
        
        static {
            __OBFID = "CL_00002226";
            field_180051_h = Maps.newHashMap();
            for (final EnumMinecartType llllllllllllllllIIllllIIIllIIIlI : values()) {
                EnumMinecartType.field_180051_h.put(llllllllllllllllIIllllIIIllIIIlI.func_180039_a(), llllllllllllllllIIllllIIIllIIIlI);
            }
        }
        
        public int func_180039_a() {
            return this.field_180052_i;
        }
        
        public String func_180040_b() {
            return this.field_180049_j;
        }
    }
}
