package net.minecraft.client.particle;

import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;

public class EntityRainFX extends EntityFX
{
    static {
        __OBFID = "CL_00000934";
    }
    
    protected EntityRainFX(final World lllllllllllllllllllllIIlIIllllIl, final double lllllllllllllllllllllIIlIIllllII, final double lllllllllllllllllllllIIlIIllIllI, final double lllllllllllllllllllllIIlIIllIlIl) {
        super(lllllllllllllllllllllIIlIIllllIl, lllllllllllllllllllllIIlIIllllII, lllllllllllllllllllllIIlIIllIllI, lllllllllllllllllllllIIlIIllIlIl, 0.0, 0.0, 0.0);
        this.motionX *= 0.30000001192092896;
        this.motionY = Math.random() * 0.20000000298023224 + 0.10000000149011612;
        this.motionZ *= 0.30000001192092896;
        this.particleRed = 1.0f;
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.setParticleTextureIndex(19 + this.rand.nextInt(4));
        this.setSize(0.01f, 0.01f);
        this.particleGravity = 0.06f;
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2));
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= this.particleGravity;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863;
        this.motionY *= 0.9800000190734863;
        this.motionZ *= 0.9800000190734863;
        if (this.particleMaxAge-- <= 0) {
            this.setDead();
        }
        if (this.onGround) {
            if (Math.random() < 0.5) {
                this.setDead();
            }
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
        final BlockPos lllllllllllllllllllllIIlIIlIllII = new BlockPos(this);
        final IBlockState lllllllllllllllllllllIIlIIlIlIll = this.worldObj.getBlockState(lllllllllllllllllllllIIlIIlIllII);
        final Block lllllllllllllllllllllIIlIIlIlIlI = lllllllllllllllllllllIIlIIlIlIll.getBlock();
        lllllllllllllllllllllIIlIIlIlIlI.setBlockBoundsBasedOnState(this.worldObj, lllllllllllllllllllllIIlIIlIllII);
        final Material lllllllllllllllllllllIIlIIlIlIIl = lllllllllllllllllllllIIlIIlIlIll.getBlock().getMaterial();
        if (lllllllllllllllllllllIIlIIlIlIIl.isLiquid() || lllllllllllllllllllllIIlIIlIlIIl.isSolid()) {
            double lllllllllllllllllllllIIlIIlIlIII = 0.0;
            if (lllllllllllllllllllllIIlIIlIlIll.getBlock() instanceof BlockLiquid) {
                lllllllllllllllllllllIIlIIlIlIII = 1.0f - BlockLiquid.getLiquidHeightPercent((int)lllllllllllllllllllllIIlIIlIlIll.getValue(BlockLiquid.LEVEL));
            }
            else {
                lllllllllllllllllllllIIlIIlIlIII = lllllllllllllllllllllIIlIIlIlIlI.getBlockBoundsMaxY();
            }
            final double lllllllllllllllllllllIIlIIlIIlll = MathHelper.floor_double(this.posY) + lllllllllllllllllllllIIlIIlIlIII;
            if (this.posY < lllllllllllllllllllllIIlIIlIIlll) {
                this.setDead();
            }
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public EntityFX func_178902_a(final int llllllllllllllllIlIllllIIlIIlllI, final World llllllllllllllllIlIllllIIlIIIlIl, final double llllllllllllllllIlIllllIIlIIIlII, final double llllllllllllllllIlIllllIIlIIlIll, final double llllllllllllllllIlIllllIIlIIIIlI, final double llllllllllllllllIlIllllIIlIIlIIl, final double llllllllllllllllIlIllllIIlIIlIII, final double llllllllllllllllIlIllllIIlIIIlll, final int... llllllllllllllllIlIllllIIlIIIllI) {
            return new EntityRainFX(llllllllllllllllIlIllllIIlIIIlIl, llllllllllllllllIlIllllIIlIIIlII, llllllllllllllllIlIllllIIlIIlIll, llllllllllllllllIlIllllIIlIIIIlI);
        }
        
        static {
            __OBFID = "CL_00002572";
        }
    }
}
