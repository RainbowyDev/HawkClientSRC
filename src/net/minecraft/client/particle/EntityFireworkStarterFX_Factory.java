package net.minecraft.client.particle;

import net.minecraft.world.*;
import net.minecraft.client.*;

public class EntityFireworkStarterFX_Factory implements IParticleFactory
{
    static {
        __OBFID = "CL_00002603";
    }
    
    @Override
    public EntityFX func_178902_a(final int llllllllllllllllIIllIlIIIlIIIlIl, final World llllllllllllllllIIllIlIIIlIIIlII, final double llllllllllllllllIIllIlIIIIlllIIl, final double llllllllllllllllIIllIlIIIlIIIIlI, final double llllllllllllllllIIllIlIIIIllIlll, final double llllllllllllllllIIllIlIIIIllIllI, final double llllllllllllllllIIllIlIIIIllIlIl, final double llllllllllllllllIIllIlIIIIllIlII, final int... llllllllllllllllIIllIlIIIIllllIl) {
        final EntityFireworkSparkFX llllllllllllllllIIllIlIIIIllllII = new EntityFireworkSparkFX(llllllllllllllllIIllIlIIIlIIIlII, llllllllllllllllIIllIlIIIIlllIIl, llllllllllllllllIIllIlIIIlIIIIlI, llllllllllllllllIIllIlIIIIllIlll, llllllllllllllllIIllIlIIIIllIllI, llllllllllllllllIIllIlIIIIllIlIl, llllllllllllllllIIllIlIIIIllIlII, Minecraft.getMinecraft().effectRenderer);
        llllllllllllllllIIllIlIIIIllllII.setAlphaF(0.99f);
        return llllllllllllllllIIllIlIIIIllllII;
    }
}
