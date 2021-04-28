package net.minecraft.entity.monster;

import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.pathfinding.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;

public class EntitySnowman extends EntityGolem implements IRangedAttackMob
{
    @Override
    public void attackEntityWithRangedAttack(final EntityLivingBase llllllllllllllIllllIlIIllIIllIII, final float llllllllllllllIllllIlIIllIlIIIII) {
        final EntitySnowball llllllllllllllIllllIlIIllIIlllll = new EntitySnowball(this.worldObj, this);
        final double llllllllllllllIllllIlIIllIIllllI = llllllllllllllIllllIlIIllIIllIII.posY + llllllllllllllIllllIlIIllIIllIII.getEyeHeight() - 1.100000023841858;
        final double llllllllllllllIllllIlIIllIIlllIl = llllllllllllllIllllIlIIllIIllIII.posX - this.posX;
        final double llllllllllllllIllllIlIIllIIlllII = llllllllllllllIllllIlIIllIIllllI - llllllllllllllIllllIlIIllIIlllll.posY;
        final double llllllllllllllIllllIlIIllIIllIll = llllllllllllllIllllIlIIllIIllIII.posZ - this.posZ;
        final float llllllllllllllIllllIlIIllIIllIlI = MathHelper.sqrt_double(llllllllllllllIllllIlIIllIIlllIl * llllllllllllllIllllIlIIllIIlllIl + llllllllllllllIllllIlIIllIIllIll * llllllllllllllIllllIlIIllIIllIll) * 0.2f;
        llllllllllllllIllllIlIIllIIlllll.setThrowableHeading(llllllllllllllIllllIlIIllIIlllIl, llllllllllllllIllllIlIIllIIlllII + llllllllllllllIllllIlIIllIIllIlI, llllllllllllllIllllIlIIllIIllIll, 1.6f, 12.0f);
        this.playSound("random.bow", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
        this.worldObj.spawnEntityInWorld(llllllllllllllIllllIlIIllIIlllll);
    }
    
    @Override
    protected void dropFewItems(final boolean llllllllllllllIllllIlIIllIllIIIl, final int llllllllllllllIllllIlIIllIllIIII) {
        for (int llllllllllllllIllllIlIIllIlIllll = this.rand.nextInt(16), llllllllllllllIllllIlIIllIlIlllI = 0; llllllllllllllIllllIlIIllIlIlllI < llllllllllllllIllllIlIIllIlIllll; ++llllllllllllllIllllIlIIllIlIlllI) {
            this.dropItem(Items.snowball, 1);
        }
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(4.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20000000298023224);
    }
    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (!this.worldObj.isRemote) {
            int llllllllllllllIllllIlIIllIllllll = MathHelper.floor_double(this.posX);
            int llllllllllllllIllllIlIIllIlllllI = MathHelper.floor_double(this.posY);
            int llllllllllllllIllllIlIIllIllllIl = MathHelper.floor_double(this.posZ);
            if (this.isWet()) {
                this.attackEntityFrom(DamageSource.drown, 1.0f);
            }
            if (this.worldObj.getBiomeGenForCoords(new BlockPos(llllllllllllllIllllIlIIllIllllll, 0, llllllllllllllIllllIlIIllIllllIl)).func_180626_a(new BlockPos(llllllllllllllIllllIlIIllIllllll, llllllllllllllIllllIlIIllIlllllI, llllllllllllllIllllIlIIllIllllIl)) > 1.0f) {
                this.attackEntityFrom(DamageSource.onFire, 1.0f);
            }
            for (int llllllllllllllIllllIlIIllIllllII = 0; llllllllllllllIllllIlIIllIllllII < 4; ++llllllllllllllIllllIlIIllIllllII) {
                llllllllllllllIllllIlIIllIllllll = MathHelper.floor_double(this.posX + (llllllllllllllIllllIlIIllIllllII % 2 * 2 - 1) * 0.25f);
                llllllllllllllIllllIlIIllIlllllI = MathHelper.floor_double(this.posY);
                llllllllllllllIllllIlIIllIllllIl = MathHelper.floor_double(this.posZ + (llllllllllllllIllllIlIIllIllllII / 2 % 2 * 2 - 1) * 0.25f);
                if (this.worldObj.getBlockState(new BlockPos(llllllllllllllIllllIlIIllIllllll, llllllllllllllIllllIlIIllIlllllI, llllllllllllllIllllIlIIllIllllIl)).getBlock().getMaterial() == Material.air && this.worldObj.getBiomeGenForCoords(new BlockPos(llllllllllllllIllllIlIIllIllllll, 0, llllllllllllllIllllIlIIllIllllIl)).func_180626_a(new BlockPos(llllllllllllllIllllIlIIllIllllll, llllllllllllllIllllIlIIllIlllllI, llllllllllllllIllllIlIIllIllllIl)) < 0.8f && Blocks.snow_layer.canPlaceBlockAt(this.worldObj, new BlockPos(llllllllllllllIllllIlIIllIllllll, llllllllllllllIllllIlIIllIlllllI, llllllllllllllIllllIlIIllIllllIl))) {
                    this.worldObj.setBlockState(new BlockPos(llllllllllllllIllllIlIIllIllllll, llllllllllllllIllllIlIIllIlllllI, llllllllllllllIllllIlIIllIllllIl), Blocks.snow_layer.getDefaultState());
                }
            }
        }
    }
    
    static {
        __OBFID = "CL_00001650";
    }
    
    @Override
    protected Item getDropItem() {
        return Items.snowball;
    }
    
    public EntitySnowman(final World llllllllllllllIllllIlIIlllIIlIll) {
        super(llllllllllllllIllllIlIIlllIIlIll);
        this.setSize(0.7f, 1.9f);
        ((PathNavigateGround)this.getNavigator()).func_179690_a(true);
        this.tasks.addTask(1, new EntityAIArrowAttack(this, 1.25, 20, 10.0f));
        this.tasks.addTask(2, new EntityAIWander(this, 1.0));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityLiving.class, 10, true, false, IMob.mobSelector));
    }
    
    @Override
    public float getEyeHeight() {
        return 1.7f;
    }
}
