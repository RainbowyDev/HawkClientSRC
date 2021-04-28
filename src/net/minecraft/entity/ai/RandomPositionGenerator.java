package net.minecraft.entity.ai;

import net.minecraft.entity.*;
import net.minecraft.util.*;
import java.util.*;

public class RandomPositionGenerator
{
    private static /* synthetic */ Vec3 staticVector;
    
    static {
        __OBFID = "CL_00001629";
        RandomPositionGenerator.staticVector = new Vec3(0.0, 0.0, 0.0);
    }
    
    public static Vec3 findRandomTargetBlockAwayFrom(final EntityCreature llIIlIlllIIII, final int llIIlIllIllll, final int llIIlIlllIIlI, final Vec3 llIIlIlllIIIl) {
        RandomPositionGenerator.staticVector = new Vec3(llIIlIlllIIII.posX, llIIlIlllIIII.posY, llIIlIlllIIII.posZ).subtract(llIIlIlllIIIl);
        return findRandomTargetBlock(llIIlIlllIIII, llIIlIllIllll, llIIlIlllIIlI, RandomPositionGenerator.staticVector);
    }
    
    public static Vec3 findRandomTargetBlockTowards(final EntityCreature llIIllIIIIIII, final int llIIlIlllllll, final int llIIlIllllIlI, final Vec3 llIIlIlllllIl) {
        RandomPositionGenerator.staticVector = llIIlIlllllIl.subtract(llIIllIIIIIII.posX, llIIllIIIIIII.posY, llIIllIIIIIII.posZ);
        return findRandomTargetBlock(llIIllIIIIIII, llIIlIlllllll, llIIlIllllIlI, RandomPositionGenerator.staticVector);
    }
    
    public static Vec3 findRandomTarget(final EntityCreature llIIllIIIIlll, final int llIIllIIIIllI, final int llIIllIIIIlIl) {
        return findRandomTargetBlock(llIIllIIIIlll, llIIllIIIIllI, llIIllIIIIlIl, null);
    }
    
    private static Vec3 findRandomTargetBlock(final EntityCreature llIIlIlIIIllI, final int llIIlIlIllIlI, final int llIIlIlIIIlII, final Vec3 llIIlIlIllIII) {
        final Random llIIlIlIlIlll = llIIlIlIIIllI.getRNG();
        boolean llIIlIlIlIllI = false;
        int llIIlIlIlIlIl = 0;
        int llIIlIlIlIlII = 0;
        int llIIlIlIlIIll = 0;
        float llIIlIlIlIIlI = -99999.0f;
        boolean llIIlIlIlIIII;
        if (llIIlIlIIIllI.hasHome()) {
            final double llIIlIlIIllll = llIIlIlIIIllI.func_180486_cf().distanceSq(MathHelper.floor_double(llIIlIlIIIllI.posX), MathHelper.floor_double(llIIlIlIIIllI.posY), MathHelper.floor_double(llIIlIlIIIllI.posZ)) + 4.0;
            final double llIIlIlIIlllI = llIIlIlIIIllI.getMaximumHomeDistance() + llIIlIlIllIlI;
            final boolean llIIlIlIlIIIl = llIIlIlIIllll < llIIlIlIIlllI * llIIlIlIIlllI;
        }
        else {
            llIIlIlIlIIII = false;
        }
        for (int llIIlIlIIllIl = 0; llIIlIlIIllIl < 10; ++llIIlIlIIllIl) {
            int llIIlIlIIllII = llIIlIlIlIlll.nextInt(2 * llIIlIlIllIlI + 1) - llIIlIlIllIlI;
            int llIIlIlIIlIll = llIIlIlIlIlll.nextInt(2 * llIIlIlIIIlII + 1) - llIIlIlIIIlII;
            int llIIlIlIIlIlI = llIIlIlIlIlll.nextInt(2 * llIIlIlIllIlI + 1) - llIIlIlIllIlI;
            if (llIIlIlIllIII == null || llIIlIlIIllII * llIIlIlIllIII.xCoord + llIIlIlIIlIlI * llIIlIlIllIII.zCoord >= 0.0) {
                if (llIIlIlIIIllI.hasHome() && llIIlIlIllIlI > 1) {
                    final BlockPos llIIlIlIIlIIl = llIIlIlIIIllI.func_180486_cf();
                    if (llIIlIlIIIllI.posX > llIIlIlIIlIIl.getX()) {
                        llIIlIlIIllII -= llIIlIlIlIlll.nextInt(llIIlIlIllIlI / 2);
                    }
                    else {
                        llIIlIlIIllII += llIIlIlIlIlll.nextInt(llIIlIlIllIlI / 2);
                    }
                    if (llIIlIlIIIllI.posZ > llIIlIlIIlIIl.getZ()) {
                        llIIlIlIIlIlI -= llIIlIlIlIlll.nextInt(llIIlIlIllIlI / 2);
                    }
                    else {
                        llIIlIlIIlIlI += llIIlIlIlIlll.nextInt(llIIlIlIllIlI / 2);
                    }
                }
                llIIlIlIIllII += MathHelper.floor_double(llIIlIlIIIllI.posX);
                llIIlIlIIlIll += MathHelper.floor_double(llIIlIlIIIllI.posY);
                llIIlIlIIlIlI += MathHelper.floor_double(llIIlIlIIIllI.posZ);
                final BlockPos llIIlIlIIlIII = new BlockPos(llIIlIlIIllII, llIIlIlIIlIll, llIIlIlIIlIlI);
                if (!llIIlIlIlIIII || llIIlIlIIIllI.func_180485_d(llIIlIlIIlIII)) {
                    final float llIIlIlIIIlll = llIIlIlIIIllI.func_180484_a(llIIlIlIIlIII);
                    if (llIIlIlIIIlll > llIIlIlIlIIlI) {
                        llIIlIlIlIIlI = llIIlIlIIIlll;
                        llIIlIlIlIlIl = llIIlIlIIllII;
                        llIIlIlIlIlII = llIIlIlIIlIll;
                        llIIlIlIlIIll = llIIlIlIIlIlI;
                        llIIlIlIlIllI = true;
                    }
                }
            }
        }
        if (llIIlIlIlIllI) {
            return new Vec3(llIIlIlIlIlIl, llIIlIlIlIlII, llIIlIlIlIIll);
        }
        return null;
    }
}
