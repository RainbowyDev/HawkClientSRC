package net.minecraft.client.particle;

import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;

public class EntityHugeExplodeFX extends EntityFX
{
    private /* synthetic */ int timeSinceStart;
    private /* synthetic */ int maximumTime;
    
    @Override
    public int getFXLayer() {
        return 1;
    }
    
    @Override
    public void onUpdate() {
        for (int llIlllllIIIIIll = 0; llIlllllIIIIIll < 6; ++llIlllllIIIIIll) {
            final double llIlllllIIIIIlI = this.posX + (this.rand.nextDouble() - this.rand.nextDouble()) * 4.0;
            final double llIlllllIIIIIIl = this.posY + (this.rand.nextDouble() - this.rand.nextDouble()) * 4.0;
            final double llIlllllIIIIIII = this.posZ + (this.rand.nextDouble() - this.rand.nextDouble()) * 4.0;
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, llIlllllIIIIIlI, llIlllllIIIIIIl, llIlllllIIIIIII, this.timeSinceStart / (float)this.maximumTime, 0.0, 0.0, new int[0]);
        }
        ++this.timeSinceStart;
        if (this.timeSinceStart == this.maximumTime) {
            this.setDead();
        }
    }
    
    @Override
    public void func_180434_a(final WorldRenderer llIlllllIIlIIIl, final Entity llIlllllIIlIIII, final float llIlllllIIIllll, final float llIlllllIIIlllI, final float llIlllllIIIllIl, final float llIlllllIIIllII, final float llIlllllIIIlIll, final float llIlllllIIIlIlI) {
    }
    
    protected EntityHugeExplodeFX(final World llIlllllIIllllI, final double llIlllllIIlllIl, final double llIlllllIIlIlII, final double llIlllllIIlIIll, final double llIlllllIIllIlI, final double llIlllllIIllIIl, final double llIlllllIIllIII) {
        super(llIlllllIIllllI, llIlllllIIlllIl, llIlllllIIlIlII, llIlllllIIlIIll, 0.0, 0.0, 0.0);
        this.maximumTime = 8;
    }
    
    static {
        __OBFID = "CL_00000911";
    }
    
    public static class Factory implements IParticleFactory
    {
        static {
            __OBFID = "CL_00002597";
        }
        
        @Override
        public EntityFX func_178902_a(final int llllllllllllllIlIllIlIIlIlIIIIlI, final World llllllllllllllIlIllIlIIlIIlllIIl, final double llllllllllllllIlIllIlIIlIlIIIIII, final double llllllllllllllIlIllIlIIlIIllllll, final double llllllllllllllIlIllIlIIlIIllIllI, final double llllllllllllllIlIllIlIIlIIllllIl, final double llllllllllllllIlIllIlIIlIIllIlII, final double llllllllllllllIlIllIlIIlIIlllIll, final int... llllllllllllllIlIllIlIIlIIlllIlI) {
            return new EntityHugeExplodeFX(llllllllllllllIlIllIlIIlIIlllIIl, llllllllllllllIlIllIlIIlIlIIIIII, llllllllllllllIlIllIlIIlIIllllll, llllllllllllllIlIllIlIIlIIllIllI, llllllllllllllIlIllIlIIlIIllllIl, llllllllllllllIlIllIlIIlIIllIlII, llllllllllllllIlIllIlIIlIIlllIll);
        }
    }
}
