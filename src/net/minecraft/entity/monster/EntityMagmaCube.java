package net.minecraft.entity.monster;

import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.init.*;

public class EntityMagmaCube extends EntitySlime
{
    @Override
    protected EnumParticleTypes func_180487_n() {
        return EnumParticleTypes.FLAME;
    }
    
    @Override
    protected void alterSquishAmount() {
        this.squishAmount *= 0.9f;
    }
    
    @Override
    protected int getAttackStrength() {
        return super.getAttackStrength() + 2;
    }
    
    @Override
    protected void dropFewItems(final boolean llllllllllllllllIIlIIIlIlllIllII, final int llllllllllllllllIIlIIIlIlllIIllI) {
        final Item llllllllllllllllIIlIIIlIlllIlIlI = this.getDropItem();
        if (llllllllllllllllIIlIIIlIlllIlIlI != null && this.getSlimeSize() > 1) {
            int llllllllllllllllIIlIIIlIlllIlIIl = this.rand.nextInt(4) - 2;
            if (llllllllllllllllIIlIIIlIlllIIllI > 0) {
                llllllllllllllllIIlIIIlIlllIlIIl += this.rand.nextInt(llllllllllllllllIIlIIIlIlllIIllI + 1);
            }
            for (int llllllllllllllllIIlIIIlIlllIlIII = 0; llllllllllllllllIIlIIIlIlllIlIII < llllllllllllllllIIlIIIlIlllIlIIl; ++llllllllllllllllIIlIIIlIlllIlIII) {
                this.dropItem(llllllllllllllllIIlIIIlIlllIlIlI, 1);
            }
        }
    }
    
    @Override
    public void fall(final float llllllllllllllllIIlIIIlIllIlIlII, final float llllllllllllllllIIlIIIlIllIlIIll) {
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return this.worldObj.getDifficulty() != EnumDifficulty.PEACEFUL;
    }
    
    @Override
    protected boolean makesSoundOnLand() {
        return true;
    }
    
    @Override
    protected EntitySlime createInstance() {
        return new EntityMagmaCube(this.worldObj);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20000000298023224);
    }
    
    @Override
    public int getBrightnessForRender(final float llllllllllllllllIIlIIIlIlllllIlI) {
        return 15728880;
    }
    
    @Override
    public boolean isBurning() {
        return false;
    }
    
    @Override
    public float getBrightness(final float llllllllllllllllIIlIIIlIlllllIII) {
        return 1.0f;
    }
    
    @Override
    protected String getJumpSound() {
        return (this.getSlimeSize() > 1) ? "mob.magmacube.big" : "mob.magmacube.small";
    }
    
    @Override
    protected void func_180466_bG() {
        this.motionY = 0.22f + this.getSlimeSize() * 0.05f;
        this.isAirBorne = true;
    }
    
    @Override
    protected void jump() {
        this.motionY = 0.42f + this.getSlimeSize() * 0.1f;
        this.isAirBorne = true;
    }
    
    @Override
    public boolean handleLavaMovement() {
        return this.worldObj.checkNoEntityCollision(this.getEntityBoundingBox(), this) && this.worldObj.getCollidingBoundingBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.worldObj.isAnyLiquid(this.getEntityBoundingBox());
    }
    
    @Override
    public int getTotalArmorValue() {
        return this.getSlimeSize() * 3;
    }
    
    @Override
    protected boolean canDamagePlayer() {
        return true;
    }
    
    public EntityMagmaCube(final World llllllllllllllllIIlIIIllIIIIlIlI) {
        super(llllllllllllllllIIlIIIllIIIIlIlI);
        this.isImmuneToFire = true;
    }
    
    @Override
    protected int getJumpDelay() {
        return super.getJumpDelay() * 4;
    }
    
    static {
        __OBFID = "CL_00001691";
    }
    
    @Override
    protected Item getDropItem() {
        return Items.magma_cream;
    }
}
