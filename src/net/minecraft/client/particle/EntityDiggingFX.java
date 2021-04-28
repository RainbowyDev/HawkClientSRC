package net.minecraft.client.particle;

import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.client.*;

public class EntityDiggingFX extends EntityFX
{
    private /* synthetic */ IBlockState field_174847_a;
    
    public EntityDiggingFX func_174845_l() {
        final Block lIIlIlIlllIIlII = this.field_174847_a.getBlock();
        if (lIIlIlIlllIIlII == Blocks.grass) {
            return this;
        }
        final int lIIlIlIlllIIIll = lIIlIlIlllIIlII.getRenderColor(this.field_174847_a);
        this.particleRed *= (lIIlIlIlllIIIll >> 16 & 0xFF) / 255.0f;
        this.particleGreen *= (lIIlIlIlllIIIll >> 8 & 0xFF) / 255.0f;
        this.particleBlue *= (lIIlIlIlllIIIll & 0xFF) / 255.0f;
        return this;
    }
    
    @Override
    public int getFXLayer() {
        return 1;
    }
    
    static {
        __OBFID = "CL_00000932";
    }
    
    public EntityDiggingFX func_174846_a(final BlockPos lIIlIlIlllIlIlI) {
        if (this.field_174847_a.getBlock() == Blocks.grass) {
            return this;
        }
        final int lIIlIlIlllIllII = this.field_174847_a.getBlock().colorMultiplier(this.worldObj, lIIlIlIlllIlIlI);
        this.particleRed *= (lIIlIlIlllIllII >> 16 & 0xFF) / 255.0f;
        this.particleGreen *= (lIIlIlIlllIllII >> 8 & 0xFF) / 255.0f;
        this.particleBlue *= (lIIlIlIlllIllII & 0xFF) / 255.0f;
        return this;
    }
    
    @Override
    public void func_180434_a(final WorldRenderer lIIlIlIlIllllII, final Entity lIIlIlIllIIllII, final float lIIlIlIllIIlIll, final float lIIlIlIllIIlIlI, final float lIIlIlIlIlllIIl, final float lIIlIlIllIIlIII, final float lIIlIlIlIllIlll, final float lIIlIlIlIllIllI) {
        float lIIlIlIllIIIlIl = (this.particleTextureIndexX + this.particleTextureJitterX / 4.0f) / 16.0f;
        float lIIlIlIllIIIlII = lIIlIlIllIIIlIl + 0.015609375f;
        float lIIlIlIllIIIIll = (this.particleTextureIndexY + this.particleTextureJitterY / 4.0f) / 16.0f;
        float lIIlIlIllIIIIlI = lIIlIlIllIIIIll + 0.015609375f;
        final float lIIlIlIllIIIIIl = 0.1f * this.particleScale;
        if (this.particleIcon != null) {
            lIIlIlIllIIIlIl = this.particleIcon.getInterpolatedU(this.particleTextureJitterX / 4.0f * 16.0f);
            lIIlIlIllIIIlII = this.particleIcon.getInterpolatedU((this.particleTextureJitterX + 1.0f) / 4.0f * 16.0f);
            lIIlIlIllIIIIll = this.particleIcon.getInterpolatedV(this.particleTextureJitterY / 4.0f * 16.0f);
            lIIlIlIllIIIIlI = this.particleIcon.getInterpolatedV((this.particleTextureJitterY + 1.0f) / 4.0f * 16.0f);
        }
        final float lIIlIlIllIIIIII = (float)(this.prevPosX + (this.posX - this.prevPosX) * lIIlIlIllIIlIll - EntityDiggingFX.interpPosX);
        final float lIIlIlIlIllllll = (float)(this.prevPosY + (this.posY - this.prevPosY) * lIIlIlIllIIlIll - EntityDiggingFX.interpPosY);
        final float lIIlIlIlIlllllI = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * lIIlIlIllIIlIll - EntityDiggingFX.interpPosZ);
        lIIlIlIlIllllII.func_178986_b(this.particleRed, this.particleGreen, this.particleBlue);
        lIIlIlIlIllllII.addVertexWithUV(lIIlIlIllIIIIII - lIIlIlIllIIlIlI * lIIlIlIllIIIIIl - lIIlIlIlIllIlll * lIIlIlIllIIIIIl, lIIlIlIlIllllll - lIIlIlIlIlllIIl * lIIlIlIllIIIIIl, lIIlIlIlIlllllI - lIIlIlIllIIlIII * lIIlIlIllIIIIIl - lIIlIlIlIllIllI * lIIlIlIllIIIIIl, lIIlIlIllIIIlIl, lIIlIlIllIIIIlI);
        lIIlIlIlIllllII.addVertexWithUV(lIIlIlIllIIIIII - lIIlIlIllIIlIlI * lIIlIlIllIIIIIl + lIIlIlIlIllIlll * lIIlIlIllIIIIIl, lIIlIlIlIllllll + lIIlIlIlIlllIIl * lIIlIlIllIIIIIl, lIIlIlIlIlllllI - lIIlIlIllIIlIII * lIIlIlIllIIIIIl + lIIlIlIlIllIllI * lIIlIlIllIIIIIl, lIIlIlIllIIIlIl, lIIlIlIllIIIIll);
        lIIlIlIlIllllII.addVertexWithUV(lIIlIlIllIIIIII + lIIlIlIllIIlIlI * lIIlIlIllIIIIIl + lIIlIlIlIllIlll * lIIlIlIllIIIIIl, lIIlIlIlIllllll + lIIlIlIlIlllIIl * lIIlIlIllIIIIIl, lIIlIlIlIlllllI + lIIlIlIllIIlIII * lIIlIlIllIIIIIl + lIIlIlIlIllIllI * lIIlIlIllIIIIIl, lIIlIlIllIIIlII, lIIlIlIllIIIIll);
        lIIlIlIlIllllII.addVertexWithUV(lIIlIlIllIIIIII + lIIlIlIllIIlIlI * lIIlIlIllIIIIIl - lIIlIlIlIllIlll * lIIlIlIllIIIIIl, lIIlIlIlIllllll - lIIlIlIlIlllIIl * lIIlIlIllIIIIIl, lIIlIlIlIlllllI + lIIlIlIllIIlIII * lIIlIlIllIIIIIl - lIIlIlIlIllIllI * lIIlIlIllIIIIIl, lIIlIlIllIIIlII, lIIlIlIllIIIIlI);
    }
    
    protected EntityDiggingFX(final World lIIlIlIlllllIIl, final double lIIlIllIIIIIIIl, final double lIIlIllIIIIIIII, final double lIIlIlIllllllll, final double lIIlIlIllllIlIl, final double lIIlIlIllllIlII, final double lIIlIlIllllllII, final IBlockState lIIlIlIlllllIll) {
        super(lIIlIlIlllllIIl, lIIlIllIIIIIIIl, lIIlIllIIIIIIII, lIIlIlIllllllll, lIIlIlIllllIlIl, lIIlIlIllllIlII, lIIlIlIllllllII);
        this.field_174847_a = lIIlIlIlllllIll;
        this.func_180435_a(Minecraft.getMinecraft().getBlockRendererDispatcher().func_175023_a().func_178122_a(lIIlIlIlllllIll));
        this.particleGravity = lIIlIlIlllllIll.getBlock().blockParticleGravity;
        final float particleRed = 0.6f;
        this.particleBlue = particleRed;
        this.particleGreen = particleRed;
        this.particleRed = particleRed;
        this.particleScale /= 2.0f;
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public EntityFX func_178902_a(final int lllllllllllllllllIllIIllllIlIllI, final World lllllllllllllllllIllIIllllIlIlIl, final double lllllllllllllllllIllIIllllIlIlII, final double lllllllllllllllllIllIIllllIIlIll, final double lllllllllllllllllIllIIllllIIlIlI, final double lllllllllllllllllIllIIllllIIlIIl, final double lllllllllllllllllIllIIllllIlIIII, final double lllllllllllllllllIllIIllllIIllll, final int... lllllllllllllllllIllIIllllIIIllI) {
            return new EntityDiggingFX(lllllllllllllllllIllIIllllIlIlIl, lllllllllllllllllIllIIllllIlIlII, lllllllllllllllllIllIIllllIIlIll, lllllllllllllllllIllIIllllIIlIlI, lllllllllllllllllIllIIllllIIlIIl, lllllllllllllllllIllIIllllIlIIII, lllllllllllllllllIllIIllllIIllll, Block.getStateById(lllllllllllllllllIllIIllllIIIllI[0])).func_174845_l();
        }
        
        static {
            __OBFID = "CL_00002575";
        }
    }
}
