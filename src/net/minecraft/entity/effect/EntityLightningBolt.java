package net.minecraft.entity.effect;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.nbt.*;

public class EntityLightningBolt extends EntityWeatherEffect
{
    private /* synthetic */ int boltLivingTime;
    public /* synthetic */ long boltVertex;
    private /* synthetic */ int lightningState;
    
    @Override
    protected void entityInit() {
    }
    
    public EntityLightningBolt(final World lllllllllllllllIIIIlIIllIllIIIII, final double lllllllllllllllIIIIlIIllIlIlIlll, final double lllllllllllllllIIIIlIIllIlIllllI, final double lllllllllllllllIIIIlIIllIlIlIlIl) {
        super(lllllllllllllllIIIIlIIllIllIIIII);
        this.setLocationAndAngles(lllllllllllllllIIIIlIIllIlIlIlll, lllllllllllllllIIIIlIIllIlIllllI, lllllllllllllllIIIIlIIllIlIlIlIl, 0.0f, 0.0f);
        this.lightningState = 2;
        this.boltVertex = this.rand.nextLong();
        this.boltLivingTime = this.rand.nextInt(3) + 1;
        if (!lllllllllllllllIIIIlIIllIllIIIII.isRemote && lllllllllllllllIIIIlIIllIllIIIII.getGameRules().getGameRuleBooleanValue("doFireTick") && (lllllllllllllllIIIIlIIllIllIIIII.getDifficulty() == EnumDifficulty.NORMAL || lllllllllllllllIIIIlIIllIllIIIII.getDifficulty() == EnumDifficulty.HARD) && lllllllllllllllIIIIlIIllIllIIIII.isAreaLoaded(new BlockPos(this), 10)) {
            final BlockPos lllllllllllllllIIIIlIIllIlIlllII = new BlockPos(this);
            if (lllllllllllllllIIIIlIIllIllIIIII.getBlockState(lllllllllllllllIIIIlIIllIlIlllII).getBlock().getMaterial() == Material.air && Blocks.fire.canPlaceBlockAt(lllllllllllllllIIIIlIIllIllIIIII, lllllllllllllllIIIIlIIllIlIlllII)) {
                lllllllllllllllIIIIlIIllIllIIIII.setBlockState(lllllllllllllllIIIIlIIllIlIlllII, Blocks.fire.getDefaultState());
            }
            for (int lllllllllllllllIIIIlIIllIlIllIll = 0; lllllllllllllllIIIIlIIllIlIllIll < 4; ++lllllllllllllllIIIIlIIllIlIllIll) {
                final BlockPos lllllllllllllllIIIIlIIllIlIllIlI = lllllllllllllllIIIIlIIllIlIlllII.add(this.rand.nextInt(3) - 1, this.rand.nextInt(3) - 1, this.rand.nextInt(3) - 1);
                if (lllllllllllllllIIIIlIIllIllIIIII.getBlockState(lllllllllllllllIIIIlIIllIlIllIlI).getBlock().getMaterial() == Material.air && Blocks.fire.canPlaceBlockAt(lllllllllllllllIIIIlIIllIllIIIII, lllllllllllllllIIIIlIIllIlIllIlI)) {
                    lllllllllllllllIIIIlIIllIllIIIII.setBlockState(lllllllllllllllIIIIlIIllIlIllIlI, Blocks.fire.getDefaultState());
                }
            }
        }
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.lightningState == 2) {
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "ambient.weather.thunder", 10000.0f, 0.8f + this.rand.nextFloat() * 0.2f);
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "random.explode", 2.0f, 0.5f + this.rand.nextFloat() * 0.2f);
        }
        --this.lightningState;
        if (this.lightningState < 0) {
            if (this.boltLivingTime == 0) {
                this.setDead();
            }
            else if (this.lightningState < -this.rand.nextInt(10)) {
                --this.boltLivingTime;
                this.lightningState = 1;
                this.boltVertex = this.rand.nextLong();
                final BlockPos lllllllllllllllIIIIlIIllIlIIlIll = new BlockPos(this);
                if (!this.worldObj.isRemote && this.worldObj.getGameRules().getGameRuleBooleanValue("doFireTick") && this.worldObj.isAreaLoaded(lllllllllllllllIIIIlIIllIlIIlIll, 10) && this.worldObj.getBlockState(lllllllllllllllIIIIlIIllIlIIlIll).getBlock().getMaterial() == Material.air && Blocks.fire.canPlaceBlockAt(this.worldObj, lllllllllllllllIIIIlIIllIlIIlIll)) {
                    this.worldObj.setBlockState(lllllllllllllllIIIIlIIllIlIIlIll, Blocks.fire.getDefaultState());
                }
            }
        }
        if (this.lightningState >= 0) {
            if (this.worldObj.isRemote) {
                this.worldObj.setLastLightningBolt(2);
            }
            else {
                final double lllllllllllllllIIIIlIIllIlIIlIlI = 3.0;
                final List lllllllllllllllIIIIlIIllIlIIlIIl = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, new AxisAlignedBB(this.posX - lllllllllllllllIIIIlIIllIlIIlIlI, this.posY - lllllllllllllllIIIIlIIllIlIIlIlI, this.posZ - lllllllllllllllIIIIlIIllIlIIlIlI, this.posX + lllllllllllllllIIIIlIIllIlIIlIlI, this.posY + 6.0 + lllllllllllllllIIIIlIIllIlIIlIlI, this.posZ + lllllllllllllllIIIIlIIllIlIIlIlI));
                for (int lllllllllllllllIIIIlIIllIlIIlIII = 0; lllllllllllllllIIIIlIIllIlIIlIII < lllllllllllllllIIIIlIIllIlIIlIIl.size(); ++lllllllllllllllIIIIlIIllIlIIlIII) {
                    final Entity lllllllllllllllIIIIlIIllIlIIIlll = lllllllllllllllIIIIlIIllIlIIlIIl.get(lllllllllllllllIIIIlIIllIlIIlIII);
                    lllllllllllllllIIIIlIIllIlIIIlll.onStruckByLightning(this);
                }
            }
        }
    }
    
    static {
        __OBFID = "CL_00001666";
    }
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound lllllllllllllllIIIIlIIllIIllIIll) {
    }
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound lllllllllllllllIIIIlIIllIIlllIII) {
    }
}
