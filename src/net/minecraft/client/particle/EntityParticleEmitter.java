package net.minecraft.client.particle;

import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.client.renderer.*;

public class EntityParticleEmitter extends EntityFX
{
    private /* synthetic */ int field_174850_ay;
    private /* synthetic */ Entity field_174851_a;
    private /* synthetic */ EnumParticleTypes field_174849_az;
    private /* synthetic */ int field_174852_ax;
    
    public EntityParticleEmitter(final World llllllllllllllIIIIllIlIIIlIllllI, final Entity llllllllllllllIIIIllIlIIIlIlllIl, final EnumParticleTypes llllllllllllllIIIIllIlIIIlIllIII) {
        super(llllllllllllllIIIIllIlIIIlIllllI, llllllllllllllIIIIllIlIIIlIlllIl.posX, llllllllllllllIIIIllIlIIIlIlllIl.getEntityBoundingBox().minY + llllllllllllllIIIIllIlIIIlIlllIl.height / 2.0f, llllllllllllllIIIIllIlIIIlIlllIl.posZ, llllllllllllllIIIIllIlIIIlIlllIl.motionX, llllllllllllllIIIIllIlIIIlIlllIl.motionY, llllllllllllllIIIIllIlIIIlIlllIl.motionZ);
        this.field_174851_a = llllllllllllllIIIIllIlIIIlIlllIl;
        this.field_174850_ay = 3;
        this.field_174849_az = llllllllllllllIIIIllIlIIIlIllIII;
        this.onUpdate();
    }
    
    @Override
    public int getFXLayer() {
        return 3;
    }
    
    @Override
    public void func_180434_a(final WorldRenderer llllllllllllllIIIIllIlIIIlIlIllI, final Entity llllllllllllllIIIIllIlIIIlIlIlIl, final float llllllllllllllIIIIllIlIIIlIlIlII, final float llllllllllllllIIIIllIlIIIlIlIIll, final float llllllllllllllIIIIllIlIIIlIlIIlI, final float llllllllllllllIIIIllIlIIIlIlIIIl, final float llllllllllllllIIIIllIlIIIlIlIIII, final float llllllllllllllIIIIllIlIIIlIIllll) {
    }
    
    @Override
    public void onUpdate() {
        for (int llllllllllllllIIIIllIlIIIlIIIlIl = 0; llllllllllllllIIIIllIlIIIlIIIlIl < 16; ++llllllllllllllIIIIllIlIIIlIIIlIl) {
            final double llllllllllllllIIIIllIlIIIlIIIlII = this.rand.nextFloat() * 2.0f - 1.0f;
            final double llllllllllllllIIIIllIlIIIlIIIIll = this.rand.nextFloat() * 2.0f - 1.0f;
            final double llllllllllllllIIIIllIlIIIlIIIIlI = this.rand.nextFloat() * 2.0f - 1.0f;
            if (llllllllllllllIIIIllIlIIIlIIIlII * llllllllllllllIIIIllIlIIIlIIIlII + llllllllllllllIIIIllIlIIIlIIIIll * llllllllllllllIIIIllIlIIIlIIIIll + llllllllllllllIIIIllIlIIIlIIIIlI * llllllllllllllIIIIllIlIIIlIIIIlI <= 1.0) {
                final double llllllllllllllIIIIllIlIIIlIIIIIl = this.field_174851_a.posX + llllllllllllllIIIIllIlIIIlIIIlII * this.field_174851_a.width / 4.0;
                final double llllllllllllllIIIIllIlIIIlIIIIII = this.field_174851_a.getEntityBoundingBox().minY + this.field_174851_a.height / 2.0f + llllllllllllllIIIIllIlIIIlIIIIll * this.field_174851_a.height / 4.0;
                final double llllllllllllllIIIIllIlIIIIllllll = this.field_174851_a.posZ + llllllllllllllIIIIllIlIIIlIIIIlI * this.field_174851_a.width / 4.0;
                this.worldObj.spawnParticle(this.field_174849_az, false, llllllllllllllIIIIllIlIIIlIIIIIl, llllllllllllllIIIIllIlIIIlIIIIII, llllllllllllllIIIIllIlIIIIllllll, llllllllllllllIIIIllIlIIIlIIIlII, llllllllllllllIIIIllIlIIIlIIIIll + 0.2, llllllllllllllIIIIllIlIIIlIIIIlI, new int[0]);
            }
        }
        ++this.field_174852_ax;
        if (this.field_174852_ax >= this.field_174850_ay) {
            this.setDead();
        }
    }
    
    static {
        __OBFID = "CL_00002574";
    }
}
