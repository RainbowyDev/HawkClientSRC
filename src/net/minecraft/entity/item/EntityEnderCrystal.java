package net.minecraft.entity.item;

import net.minecraft.entity.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.init.*;

public class EntityEnderCrystal extends Entity
{
    public /* synthetic */ int innerRotation;
    public /* synthetic */ int health;
    
    static {
        __OBFID = "CL_00001658";
    }
    
    @Override
    public boolean canBeCollidedWith() {
        return true;
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lIllllIIlIlI, final float lIllllIIllII) {
        if (this.func_180431_b(lIllllIIlIlI)) {
            return false;
        }
        if (!this.isDead && !this.worldObj.isRemote) {
            this.health = 0;
            if (this.health <= 0) {
                this.setDead();
                if (!this.worldObj.isRemote) {
                    this.worldObj.createExplosion(null, this.posX, this.posY, this.posZ, 6.0f, true);
                }
            }
        }
        return true;
    }
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound lIllllIlIIlI) {
    }
    
    public EntityEnderCrystal(final World lIlllllIlIIl, final double lIlllllIlIII, final double lIlllllIIlll, final double lIlllllIIllI) {
        this(lIlllllIlIIl);
        this.setPosition(lIlllllIlIII, lIlllllIIlll, lIlllllIIllI);
    }
    
    @Override
    protected void entityInit() {
        this.dataWatcher.addObject(8, this.health);
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        ++this.innerRotation;
        this.dataWatcher.updateObject(8, this.health);
        final int lIllllIlllII = MathHelper.floor_double(this.posX);
        final int lIllllIllIll = MathHelper.floor_double(this.posY);
        final int lIllllIllIlI = MathHelper.floor_double(this.posZ);
        if (this.worldObj.provider instanceof WorldProviderEnd && this.worldObj.getBlockState(new BlockPos(lIllllIlllII, lIllllIllIll, lIllllIllIlI)).getBlock() != Blocks.fire) {
            this.worldObj.setBlockState(new BlockPos(lIllllIlllII, lIllllIllIll, lIllllIllIlI), Blocks.fire.getDefaultState());
        }
    }
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound lIllllIlIlII) {
    }
    
    public EntityEnderCrystal(final World lIllllllIlll) {
        super(lIllllllIlll);
        this.preventEntitySpawning = true;
        this.setSize(2.0f, 2.0f);
        this.health = 5;
        this.innerRotation = this.rand.nextInt(100000);
    }
}
