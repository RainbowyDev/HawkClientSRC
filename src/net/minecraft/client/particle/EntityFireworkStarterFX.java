package net.minecraft.client.particle;

import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;

public class EntityFireworkStarterFX extends EntityFX
{
    private final /* synthetic */ EffectRenderer theEffectRenderer;
    /* synthetic */ boolean twinkle;
    private /* synthetic */ NBTTagList fireworkExplosions;
    private /* synthetic */ int fireworkAge;
    
    private void createParticle(final double llllllllllllllIlIllllllIIlIllllI, final double llllllllllllllIlIllllllIIllIlIlI, final double llllllllllllllIlIllllllIIlIlllII, final double llllllllllllllIlIllllllIIlIllIll, final double llllllllllllllIlIllllllIIllIIlll, final double llllllllllllllIlIllllllIIlIllIIl, final int[] llllllllllllllIlIllllllIIllIIlIl, final int[] llllllllllllllIlIllllllIIllIIlII, final boolean llllllllllllllIlIllllllIIlIlIllI, final boolean llllllllllllllIlIllllllIIlIlIlIl) {
        final EntityFireworkSparkFX llllllllllllllIlIllllllIIllIIIIl = new EntityFireworkSparkFX(this.worldObj, llllllllllllllIlIllllllIIlIllllI, llllllllllllllIlIllllllIIllIlIlI, llllllllllllllIlIllllllIIlIlllII, llllllllllllllIlIllllllIIlIllIll, llllllllllllllIlIllllllIIllIIlll, llllllllllllllIlIllllllIIlIllIIl, this.theEffectRenderer);
        llllllllllllllIlIllllllIIllIIIIl.setAlphaF(0.99f);
        llllllllllllllIlIllllllIIllIIIIl.setTrail(llllllllllllllIlIllllllIIlIlIllI);
        llllllllllllllIlIllllllIIllIIIIl.setTwinkle(llllllllllllllIlIllllllIIlIlIlIl);
        final int llllllllllllllIlIllllllIIllIIIII = this.rand.nextInt(llllllllllllllIlIllllllIIllIIlIl.length);
        llllllllllllllIlIllllllIIllIIIIl.setColour(llllllllllllllIlIllllllIIllIIlIl[llllllllllllllIlIllllllIIllIIIII]);
        if (llllllllllllllIlIllllllIIllIIlII != null && llllllllllllllIlIllllllIIllIIlII.length > 0) {
            llllllllllllllIlIllllllIIllIIIIl.setFadeColour(llllllllllllllIlIllllllIIllIIlII[this.rand.nextInt(llllllllllllllIlIllllllIIllIIlII.length)]);
        }
        this.theEffectRenderer.addEffect(llllllllllllllIlIllllllIIllIIIIl);
    }
    
    private boolean func_92037_i() {
        final Minecraft llllllllllllllIlIllllllIIlllllII = Minecraft.getMinecraft();
        return llllllllllllllIlIllllllIIlllllII == null || llllllllllllllIlIllllllIIlllllII.func_175606_aa() == null || llllllllllllllIlIllllllIIlllllII.func_175606_aa().getDistanceSq(this.posX, this.posY, this.posZ) >= 256.0;
    }
    
    static {
        __OBFID = "CL_00000906";
    }
    
    private void createBall(final double llllllllllllllIlIllllllIIIlIllll, final int llllllllllllllIlIllllllIIIlIlllI, final int[] llllllllllllllIlIllllllIIIlIllIl, final int[] llllllllllllllIlIllllllIIIlIllII, final boolean llllllllllllllIlIllllllIIIllllII, final boolean llllllllllllllIlIllllllIIIlIlIlI) {
        final double llllllllllllllIlIllllllIIIlllIlI = this.posX;
        final double llllllllllllllIlIllllllIIIlllIIl = this.posY;
        final double llllllllllllllIlIllllllIIIlllIII = this.posZ;
        for (int llllllllllllllIlIllllllIIIllIlll = -llllllllllllllIlIllllllIIIlIlllI; llllllllllllllIlIllllllIIIllIlll <= llllllllllllllIlIllllllIIIlIlllI; ++llllllllllllllIlIllllllIIIllIlll) {
            for (int llllllllllllllIlIllllllIIIllIllI = -llllllllllllllIlIllllllIIIlIlllI; llllllllllllllIlIllllllIIIllIllI <= llllllllllllllIlIllllllIIIlIlllI; ++llllllllllllllIlIllllllIIIllIllI) {
                for (int llllllllllllllIlIllllllIIIllIlIl = -llllllllllllllIlIllllllIIIlIlllI; llllllllllllllIlIllllllIIIllIlIl <= llllllllllllllIlIllllllIIIlIlllI; ++llllllllllllllIlIllllllIIIllIlIl) {
                    final double llllllllllllllIlIllllllIIIllIlII = llllllllllllllIlIllllllIIIllIllI + (this.rand.nextDouble() - this.rand.nextDouble()) * 0.5;
                    final double llllllllllllllIlIllllllIIIllIIll = llllllllllllllIlIllllllIIIllIlll + (this.rand.nextDouble() - this.rand.nextDouble()) * 0.5;
                    final double llllllllllllllIlIllllllIIIllIIlI = llllllllllllllIlIllllllIIIllIlIl + (this.rand.nextDouble() - this.rand.nextDouble()) * 0.5;
                    final double llllllllllllllIlIllllllIIIllIIIl = MathHelper.sqrt_double(llllllllllllllIlIllllllIIIllIlII * llllllllllllllIlIllllllIIIllIlII + llllllllllllllIlIllllllIIIllIIll * llllllllllllllIlIllllllIIIllIIll + llllllllllllllIlIllllllIIIllIIlI * llllllllllllllIlIllllllIIIllIIlI) / llllllllllllllIlIllllllIIIlIllll + this.rand.nextGaussian() * 0.05;
                    this.createParticle(llllllllllllllIlIllllllIIIlllIlI, llllllllllllllIlIllllllIIIlllIIl, llllllllllllllIlIllllllIIIlllIII, llllllllllllllIlIllllllIIIllIlII / llllllllllllllIlIllllllIIIllIIIl, llllllllllllllIlIllllllIIIllIIll / llllllllllllllIlIllllllIIIllIIIl, llllllllllllllIlIllllllIIIllIIlI / llllllllllllllIlIllllllIIIllIIIl, llllllllllllllIlIllllllIIIlIllIl, llllllllllllllIlIllllllIIIlIllII, llllllllllllllIlIllllllIIIllllII, llllllllllllllIlIllllllIIIlIlIlI);
                    if (llllllllllllllIlIllllllIIIllIlll != -llllllllllllllIlIllllllIIIlIlllI && llllllllllllllIlIllllllIIIllIlll != llllllllllllllIlIllllllIIIlIlllI && llllllllllllllIlIllllllIIIllIllI != -llllllllllllllIlIllllllIIIlIlllI && llllllllllllllIlIllllllIIIllIllI != llllllllllllllIlIllllllIIIlIlllI) {
                        llllllllllllllIlIllllllIIIllIlIl += llllllllllllllIlIllllllIIIlIlllI * 2 - 1;
                    }
                }
            }
        }
    }
    
    private void createShaped(final double llllllllllllllIlIlllllIllllIllIl, final double[][] llllllllllllllIlIllllllIIIIIIlIl, final int[] llllllllllllllIlIlllllIllllIlIlI, final int[] llllllllllllllIlIlllllIllllIlIII, final boolean llllllllllllllIlIllllllIIIIIIIlI, final boolean llllllllllllllIlIlllllIllllIIllI, final boolean llllllllllllllIlIllllllIIIIIIIII) {
        final double llllllllllllllIlIlllllIlllllllll = llllllllllllllIlIllllllIIIIIIlIl[0][0];
        final double llllllllllllllIlIlllllIllllllllI = llllllllllllllIlIllllllIIIIIIlIl[0][1];
        this.createParticle(this.posX, this.posY, this.posZ, llllllllllllllIlIlllllIlllllllll * llllllllllllllIlIlllllIllllIllIl, llllllllllllllIlIlllllIllllllllI * llllllllllllllIlIlllllIllllIllIl, 0.0, llllllllllllllIlIlllllIllllIlIlI, llllllllllllllIlIlllllIllllIlIII, llllllllllllllIlIllllllIIIIIIIlI, llllllllllllllIlIlllllIllllIIllI);
        final float llllllllllllllIlIlllllIlllllllIl = this.rand.nextFloat() * 3.1415927f;
        final double llllllllllllllIlIlllllIlllllllII = llllllllllllllIlIllllllIIIIIIIII ? 0.034 : 0.34;
        for (int llllllllllllllIlIlllllIllllllIll = 0; llllllllllllllIlIlllllIllllllIll < 3; ++llllllllllllllIlIlllllIllllllIll) {
            final double llllllllllllllIlIlllllIllllllIlI = llllllllllllllIlIlllllIlllllllIl + llllllllllllllIlIlllllIllllllIll * 3.1415927f * llllllllllllllIlIlllllIlllllllII;
            double llllllllllllllIlIlllllIllllllIIl = llllllllllllllIlIlllllIlllllllll;
            double llllllllllllllIlIlllllIllllllIII = llllllllllllllIlIlllllIllllllllI;
            for (int llllllllllllllIlIlllllIlllllIlll = 1; llllllllllllllIlIlllllIlllllIlll < llllllllllllllIlIllllllIIIIIIlIl.length; ++llllllllllllllIlIlllllIlllllIlll) {
                final double llllllllllllllIlIlllllIlllllIllI = llllllllllllllIlIllllllIIIIIIlIl[llllllllllllllIlIlllllIlllllIlll][0];
                final double llllllllllllllIlIlllllIlllllIlIl = llllllllllllllIlIllllllIIIIIIlIl[llllllllllllllIlIlllllIlllllIlll][1];
                for (double llllllllllllllIlIlllllIlllllIlII = 0.25; llllllllllllllIlIlllllIlllllIlII <= 1.0; llllllllllllllIlIlllllIlllllIlII += 0.25) {
                    double llllllllllllllIlIlllllIlllllIIll = (llllllllllllllIlIlllllIllllllIIl + (llllllllllllllIlIlllllIlllllIllI - llllllllllllllIlIlllllIllllllIIl) * llllllllllllllIlIlllllIlllllIlII) * llllllllllllllIlIlllllIllllIllIl;
                    final double llllllllllllllIlIlllllIlllllIIlI = (llllllllllllllIlIlllllIllllllIII + (llllllllllllllIlIlllllIlllllIlIl - llllllllllllllIlIlllllIllllllIII) * llllllllllllllIlIlllllIlllllIlII) * llllllllllllllIlIlllllIllllIllIl;
                    final double llllllllllllllIlIlllllIlllllIIIl = llllllllllllllIlIlllllIlllllIIll * Math.sin(llllllllllllllIlIlllllIllllllIlI);
                    llllllllllllllIlIlllllIlllllIIll *= Math.cos(llllllllllllllIlIlllllIllllllIlI);
                    for (double llllllllllllllIlIlllllIlllllIIII = -1.0; llllllllllllllIlIlllllIlllllIIII <= 1.0; llllllllllllllIlIlllllIlllllIIII += 2.0) {
                        this.createParticle(this.posX, this.posY, this.posZ, llllllllllllllIlIlllllIlllllIIll * llllllllllllllIlIlllllIlllllIIII, llllllllllllllIlIlllllIlllllIIlI, llllllllllllllIlIlllllIlllllIIIl * llllllllllllllIlIlllllIlllllIIII, llllllllllllllIlIlllllIllllIlIlI, llllllllllllllIlIlllllIllllIlIII, llllllllllllllIlIllllllIIIIIIIlI, llllllllllllllIlIlllllIllllIIllI);
                    }
                }
                llllllllllllllIlIlllllIllllllIIl = llllllllllllllIlIlllllIlllllIllI;
                llllllllllllllIlIlllllIllllllIII = llllllllllllllIlIlllllIlllllIlIl;
            }
        }
    }
    
    @Override
    public void onUpdate() {
        if (this.fireworkAge == 0 && this.fireworkExplosions != null) {
            final boolean llllllllllllllIlIllllllIlIlIIIII = this.func_92037_i();
            boolean llllllllllllllIlIllllllIlIIllllI = false;
            if (this.fireworkExplosions.tagCount() >= 3) {
                llllllllllllllIlIllllllIlIIllllI = true;
            }
            else {
                for (int llllllllllllllIlIllllllIlIIlllIl = 0; llllllllllllllIlIllllllIlIIlllIl < this.fireworkExplosions.tagCount(); ++llllllllllllllIlIllllllIlIIlllIl) {
                    final NBTTagCompound llllllllllllllIlIllllllIlIIlllII = this.fireworkExplosions.getCompoundTagAt(llllllllllllllIlIllllllIlIIlllIl);
                    if (llllllllllllllIlIllllllIlIIlllII.getByte("Type") == 1) {
                        llllllllllllllIlIllllllIlIIllllI = true;
                        break;
                    }
                }
            }
            final String llllllllllllllIlIllllllIlIIllIll = String.valueOf(new StringBuilder("fireworks.").append(llllllllllllllIlIllllllIlIIllllI ? "largeBlast" : "blast").append(llllllllllllllIlIllllllIlIlIIIII ? "_far" : ""));
            this.worldObj.playSound(this.posX, this.posY, this.posZ, llllllllllllllIlIllllllIlIIllIll, 20.0f, 0.95f + this.rand.nextFloat() * 0.1f, true);
        }
        if (this.fireworkAge % 2 == 0 && this.fireworkExplosions != null && this.fireworkAge / 2 < this.fireworkExplosions.tagCount()) {
            final int llllllllllllllIlIllllllIlIIllIlI = this.fireworkAge / 2;
            final NBTTagCompound llllllllllllllIlIllllllIlIIllIIl = this.fireworkExplosions.getCompoundTagAt(llllllllllllllIlIllllllIlIIllIlI);
            final byte llllllllllllllIlIllllllIlIIllIII = llllllllllllllIlIllllllIlIIllIIl.getByte("Type");
            final boolean llllllllllllllIlIllllllIlIIlIlll = llllllllllllllIlIllllllIlIIllIIl.getBoolean("Trail");
            final boolean llllllllllllllIlIllllllIlIIlIllI = llllllllllllllIlIllllllIlIIllIIl.getBoolean("Flicker");
            int[] llllllllllllllIlIllllllIlIIlIlIl = llllllllllllllIlIllllllIlIIllIIl.getIntArray("Colors");
            final int[] llllllllllllllIlIllllllIlIIlIlII = llllllllllllllIlIllllllIlIIllIIl.getIntArray("FadeColors");
            if (llllllllllllllIlIllllllIlIIlIlIl.length == 0) {
                llllllllllllllIlIllllllIlIIlIlIl = new int[] { ItemDye.dyeColors[0] };
            }
            if (llllllllllllllIlIllllllIlIIllIII == 1) {
                this.createBall(0.5, 4, llllllllllllllIlIllllllIlIIlIlIl, llllllllllllllIlIllllllIlIIlIlII, llllllllllllllIlIllllllIlIIlIlll, llllllllllllllIlIllllllIlIIlIllI);
            }
            else if (llllllllllllllIlIllllllIlIIllIII == 2) {
                this.createShaped(0.5, new double[][] { { 0.0, 1.0 }, { 0.3455, 0.309 }, { 0.9511, 0.309 }, { 0.3795918367346939, -0.12653061224489795 }, { 0.6122448979591837, -0.8040816326530612 }, { 0.0, -0.35918367346938773 } }, llllllllllllllIlIllllllIlIIlIlIl, llllllllllllllIlIllllllIlIIlIlII, llllllllllllllIlIllllllIlIIlIlll, llllllllllllllIlIllllllIlIIlIllI, false);
            }
            else if (llllllllllllllIlIllllllIlIIllIII == 3) {
                this.createShaped(0.5, new double[][] { { 0.0, 0.2 }, { 0.2, 0.2 }, { 0.2, 0.6 }, { 0.6, 0.6 }, { 0.6, 0.2 }, { 0.2, 0.2 }, { 0.2, 0.0 }, { 0.4, 0.0 }, { 0.4, -0.6 }, { 0.2, -0.6 }, { 0.2, -0.4 }, { 0.0, -0.4 } }, llllllllllllllIlIllllllIlIIlIlIl, llllllllllllllIlIllllllIlIIlIlII, llllllllllllllIlIllllllIlIIlIlll, llllllllllllllIlIllllllIlIIlIllI, true);
            }
            else if (llllllllllllllIlIllllllIlIIllIII == 4) {
                this.createBurst(llllllllllllllIlIllllllIlIIlIlIl, llllllllllllllIlIllllllIlIIlIlII, llllllllllllllIlIllllllIlIIlIlll, llllllllllllllIlIllllllIlIIlIllI);
            }
            else {
                this.createBall(0.25, 2, llllllllllllllIlIllllllIlIIlIlIl, llllllllllllllIlIllllllIlIIlIlII, llllllllllllllIlIllllllIlIIlIlll, llllllllllllllIlIllllllIlIIlIllI);
            }
            final int llllllllllllllIlIllllllIlIIlIIll = llllllllllllllIlIllllllIlIIlIlIl[0];
            final float llllllllllllllIlIllllllIlIIlIIlI = ((llllllllllllllIlIllllllIlIIlIIll & 0xFF0000) >> 16) / 255.0f;
            final float llllllllllllllIlIllllllIlIIlIIIl = ((llllllllllllllIlIllllllIlIIlIIll & 0xFF00) >> 8) / 255.0f;
            final float llllllllllllllIlIllllllIlIIlIIII = ((llllllllllllllIlIllllllIlIIlIIll & 0xFF) >> 0) / 255.0f;
            final EntityFireworkOverlayFX llllllllllllllIlIllllllIlIIIllll = new EntityFireworkOverlayFX(this.worldObj, this.posX, this.posY, this.posZ);
            llllllllllllllIlIllllllIlIIIllll.setRBGColorF(llllllllllllllIlIllllllIlIIlIIlI, llllllllllllllIlIllllllIlIIlIIIl, llllllllllllllIlIllllllIlIIlIIII);
            this.theEffectRenderer.addEffect(llllllllllllllIlIllllllIlIIIllll);
        }
        ++this.fireworkAge;
        if (this.fireworkAge > this.particleMaxAge) {
            if (this.twinkle) {
                final boolean llllllllllllllIlIllllllIlIIlllll = this.func_92037_i();
                final String llllllllllllllIlIllllllIlIIIlllI = String.valueOf(new StringBuilder("fireworks.").append(llllllllllllllIlIllllllIlIIlllll ? "twinkle_far" : "twinkle"));
                this.worldObj.playSound(this.posX, this.posY, this.posZ, llllllllllllllIlIllllllIlIIIlllI, 20.0f, 0.9f + this.rand.nextFloat() * 0.15f, true);
            }
            this.setDead();
        }
    }
    
    @Override
    public int getFXLayer() {
        return 0;
    }
    
    private void createBurst(final int[] llllllllllllllIlIlllllIlllIIlIll, final int[] llllllllllllllIlIlllllIlllIIlIlI, final boolean llllllllllllllIlIlllllIlllIIlIIl, final boolean llllllllllllllIlIlllllIlllIIlIII) {
        final double llllllllllllllIlIlllllIlllIIIlll = this.rand.nextGaussian() * 0.05;
        final double llllllllllllllIlIlllllIlllIIIllI = this.rand.nextGaussian() * 0.05;
        for (int llllllllllllllIlIlllllIlllIIIlIl = 0; llllllllllllllIlIlllllIlllIIIlIl < 70; ++llllllllllllllIlIlllllIlllIIIlIl) {
            final double llllllllllllllIlIlllllIlllIIIlII = this.motionX * 0.5 + this.rand.nextGaussian() * 0.15 + llllllllllllllIlIlllllIlllIIIlll;
            final double llllllllllllllIlIlllllIlllIIIIll = this.motionZ * 0.5 + this.rand.nextGaussian() * 0.15 + llllllllllllllIlIlllllIlllIIIllI;
            final double llllllllllllllIlIlllllIlllIIIIlI = this.motionY * 0.5 + this.rand.nextDouble() * 0.5;
            this.createParticle(this.posX, this.posY, this.posZ, llllllllllllllIlIlllllIlllIIIlII, llllllllllllllIlIlllllIlllIIIIlI, llllllllllllllIlIlllllIlllIIIIll, llllllllllllllIlIlllllIlllIIlIll, llllllllllllllIlIlllllIlllIIlIlI, llllllllllllllIlIlllllIlllIIlIIl, llllllllllllllIlIlllllIlllIIlIII);
        }
    }
    
    @Override
    public void func_180434_a(final WorldRenderer llllllllllllllIlIllllllIlIllIlll, final Entity llllllllllllllIlIllllllIlIllIllI, final float llllllllllllllIlIllllllIlIllIlIl, final float llllllllllllllIlIllllllIlIllIlII, final float llllllllllllllIlIllllllIlIllIIll, final float llllllllllllllIlIllllllIlIllIIlI, final float llllllllllllllIlIllllllIlIllIIIl, final float llllllllllllllIlIllllllIlIllIIII) {
    }
    
    public EntityFireworkStarterFX(final World llllllllllllllIlIllllllIllIIllll, final double llllllllllllllIlIllllllIllIIIIII, final double llllllllllllllIlIllllllIlIllllll, final double llllllllllllllIlIllllllIlIlllllI, final double llllllllllllllIlIllllllIllIIlIll, final double llllllllllllllIlIllllllIllIIlIlI, final double llllllllllllllIlIllllllIllIIlIIl, final EffectRenderer llllllllllllllIlIllllllIlIlllIlI, final NBTTagCompound llllllllllllllIlIllllllIlIlllIIl) {
        super(llllllllllllllIlIllllllIllIIllll, llllllllllllllIlIllllllIllIIIIII, llllllllllllllIlIllllllIlIllllll, llllllllllllllIlIllllllIlIlllllI, 0.0, 0.0, 0.0);
        this.motionX = llllllllllllllIlIllllllIllIIlIll;
        this.motionY = llllllllllllllIlIllllllIllIIlIlI;
        this.motionZ = llllllllllllllIlIllllllIllIIlIIl;
        this.theEffectRenderer = llllllllllllllIlIllllllIlIlllIlI;
        this.particleMaxAge = 8;
        if (llllllllllllllIlIllllllIlIlllIIl != null) {
            this.fireworkExplosions = llllllllllllllIlIllllllIlIlllIIl.getTagList("Explosions", 10);
            if (this.fireworkExplosions.tagCount() == 0) {
                this.fireworkExplosions = null;
            }
            else {
                this.particleMaxAge = this.fireworkExplosions.tagCount() * 2 - 1;
                for (int llllllllllllllIlIllllllIllIIIllI = 0; llllllllllllllIlIllllllIllIIIllI < this.fireworkExplosions.tagCount(); ++llllllllllllllIlIllllllIllIIIllI) {
                    final NBTTagCompound llllllllllllllIlIllllllIllIIIlIl = this.fireworkExplosions.getCompoundTagAt(llllllllllllllIlIllllllIllIIIllI);
                    if (llllllllllllllIlIllllllIllIIIlIl.getBoolean("Flicker")) {
                        this.twinkle = true;
                        this.particleMaxAge += 15;
                        break;
                    }
                }
            }
        }
    }
}
