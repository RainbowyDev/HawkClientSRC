package net.minecraft.client.particle;

import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;

public class EntityDropParticleFX extends EntityFX
{
    private /* synthetic */ int bobTimer;
    private /* synthetic */ Material materialType;
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.materialType == Material.water) {
            this.particleRed = 0.2f;
            this.particleGreen = 0.3f;
            this.particleBlue = 1.0f;
        }
        else {
            this.particleRed = 1.0f;
            this.particleGreen = 16.0f / (40 - this.bobTimer + 16);
            this.particleBlue = 4.0f / (40 - this.bobTimer + 8);
        }
        this.motionY -= this.particleGravity;
        if (this.bobTimer-- > 0) {
            this.motionX *= 0.02;
            this.motionY *= 0.02;
            this.motionZ *= 0.02;
            this.setParticleTextureIndex(113);
        }
        else {
            this.setParticleTextureIndex(112);
        }
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863;
        this.motionY *= 0.9800000190734863;
        this.motionZ *= 0.9800000190734863;
        if (this.particleMaxAge-- <= 0) {
            this.setDead();
        }
        if (this.onGround) {
            if (this.materialType == Material.water) {
                this.setDead();
                this.worldObj.spawnParticle(EnumParticleTypes.WATER_SPLASH, this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0, new int[0]);
            }
            else {
                this.setParticleTextureIndex(114);
            }
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
        final BlockPos llllllllllllllIIIIIIlIlIllllIIIl = new BlockPos(this);
        final IBlockState llllllllllllllIIIIIIlIlIllllIIII = this.worldObj.getBlockState(llllllllllllllIIIIIIlIlIllllIIIl);
        final Material llllllllllllllIIIIIIlIlIlllIllll = llllllllllllllIIIIIIlIlIllllIIII.getBlock().getMaterial();
        if (llllllllllllllIIIIIIlIlIlllIllll.isLiquid() || llllllllllllllIIIIIIlIlIlllIllll.isSolid()) {
            double llllllllllllllIIIIIIlIlIlllIlllI = 0.0;
            if (llllllllllllllIIIIIIlIlIllllIIII.getBlock() instanceof BlockLiquid) {
                llllllllllllllIIIIIIlIlIlllIlllI = BlockLiquid.getLiquidHeightPercent((int)llllllllllllllIIIIIIlIlIllllIIII.getValue(BlockLiquid.LEVEL));
            }
            final double llllllllllllllIIIIIIlIlIlllIllIl = MathHelper.floor_double(this.posY) + 1 - llllllllllllllIIIIIIlIlIlllIlllI;
            if (this.posY < llllllllllllllIIIIIIlIlIlllIllIl) {
                this.setDead();
            }
        }
    }
    
    static {
        __OBFID = "CL_00000901";
    }
    
    protected EntityDropParticleFX(final World llllllllllllllIIIIIIlIllIIIIllll, final double llllllllllllllIIIIIIlIllIIIIlllI, final double llllllllllllllIIIIIIlIllIIIIllIl, final double llllllllllllllIIIIIIlIllIIIIllII, final Material llllllllllllllIIIIIIlIllIIIIlIll) {
        super(llllllllllllllIIIIIIlIllIIIIllll, llllllllllllllIIIIIIlIllIIIIlllI, llllllllllllllIIIIIIlIllIIIIllIl, llllllllllllllIIIIIIlIllIIIIllII, 0.0, 0.0, 0.0);
        final double motionX = 0.0;
        this.motionZ = motionX;
        this.motionY = motionX;
        this.motionX = motionX;
        if (llllllllllllllIIIIIIlIllIIIIlIll == Material.water) {
            this.particleRed = 0.0f;
            this.particleGreen = 0.0f;
            this.particleBlue = 1.0f;
        }
        else {
            this.particleRed = 1.0f;
            this.particleGreen = 0.0f;
            this.particleBlue = 0.0f;
        }
        this.setParticleTextureIndex(113);
        this.setSize(0.01f, 0.01f);
        this.particleGravity = 0.06f;
        this.materialType = llllllllllllllIIIIIIlIllIIIIlIll;
        this.bobTimer = 40;
        this.particleMaxAge = (int)(64.0 / (Math.random() * 0.8 + 0.2));
        final double motionX2 = 0.0;
        this.motionZ = motionX2;
        this.motionY = motionX2;
        this.motionX = motionX2;
    }
    
    @Override
    public int getBrightnessForRender(final float llllllllllllllIIIIIIlIllIIIIIIIl) {
        return (this.materialType == Material.water) ? super.getBrightnessForRender(llllllllllllllIIIIIIlIllIIIIIIIl) : 257;
    }
    
    @Override
    public float getBrightness(final float llllllllllllllIIIIIIlIlIlllllIIl) {
        return (this.materialType == Material.water) ? super.getBrightness(llllllllllllllIIIIIIlIlIlllllIIl) : 1.0f;
    }
    
    public static class WaterFactory implements IParticleFactory
    {
        static {
            __OBFID = "CL_00002606";
        }
        
        @Override
        public EntityFX func_178902_a(final int llllllllllllllIllIIlIlllIIIlIlII, final World llllllllllllllIllIIlIlllIIIlIIll, final double llllllllllllllIllIIlIlllIIIlIIlI, final double llllllllllllllIllIIlIlllIIIIlIIl, final double llllllllllllllIllIIlIlllIIIlIIII, final double llllllllllllllIllIIlIlllIIIIllll, final double llllllllllllllIllIIlIlllIIIIlllI, final double llllllllllllllIllIIlIlllIIIIllIl, final int... llllllllllllllIllIIlIlllIIIIllII) {
            return new EntityDropParticleFX(llllllllllllllIllIIlIlllIIIlIIll, llllllllllllllIllIIlIlllIIIlIIlI, llllllllllllllIllIIlIlllIIIIlIIl, llllllllllllllIllIIlIlllIIIlIIII, Material.water);
        }
    }
    
    public static class LavaFactory implements IParticleFactory
    {
        static {
            __OBFID = "CL_00002607";
        }
        
        @Override
        public EntityFX func_178902_a(final int llllllllllllllIIllIllIlIIlIIIIIl, final World llllllllllllllIIllIllIlIIIlllIII, final double llllllllllllllIIllIllIlIIIllIlll, final double llllllllllllllIIllIllIlIIIllIllI, final double llllllllllllllIIllIllIlIIIllIlIl, final double llllllllllllllIIllIllIlIIIllllII, final double llllllllllllllIIllIllIlIIIlllIll, final double llllllllllllllIIllIllIlIIIlllIlI, final int... llllllllllllllIIllIllIlIIIlllIIl) {
            return new EntityDropParticleFX(llllllllllllllIIllIllIlIIIlllIII, llllllllllllllIIllIllIlIIIllIlll, llllllllllllllIIllIllIlIIIllIllI, llllllllllllllIIllIllIlIIIllIlIl, Material.lava);
        }
    }
}
