package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;

public class WorldGenIceSpike extends WorldGenerator
{
    static {
        __OBFID = "CL_00000417";
    }
    
    @Override
    public boolean generate(final World llllllllllllllllIllIlllIIIllIIII, final Random llllllllllllllllIllIlllIIlIIIIlI, BlockPos llllllllllllllllIllIlllIIIlIlllI) {
        while (llllllllllllllllIllIlllIIIllIIII.isAirBlock(llllllllllllllllIllIlllIIIlIlllI) && llllllllllllllllIllIlllIIIlIlllI.getY() > 2) {
            llllllllllllllllIllIlllIIIlIlllI = llllllllllllllllIllIlllIIIlIlllI.offsetDown();
        }
        if (llllllllllllllllIllIlllIIIllIIII.getBlockState(llllllllllllllllIllIlllIIIlIlllI).getBlock() != Blocks.snow) {
            return false;
        }
        llllllllllllllllIllIlllIIIlIlllI = llllllllllllllllIllIlllIIIlIlllI.offsetUp(llllllllllllllllIllIlllIIlIIIIlI.nextInt(4));
        final int llllllllllllllllIllIlllIIlIIIIII = llllllllllllllllIllIlllIIlIIIIlI.nextInt(4) + 7;
        final int llllllllllllllllIllIlllIIIllllll = llllllllllllllllIllIlllIIlIIIIII / 4 + llllllllllllllllIllIlllIIlIIIIlI.nextInt(2);
        if (llllllllllllllllIllIlllIIIllllll > 1 && llllllllllllllllIllIlllIIlIIIIlI.nextInt(60) == 0) {
            llllllllllllllllIllIlllIIIlIlllI = llllllllllllllllIllIlllIIIlIlllI.offsetUp(10 + llllllllllllllllIllIlllIIlIIIIlI.nextInt(30));
        }
        for (int llllllllllllllllIllIlllIIIlllllI = 0; llllllllllllllllIllIlllIIIlllllI < llllllllllllllllIllIlllIIlIIIIII; ++llllllllllllllllIllIlllIIIlllllI) {
            final float llllllllllllllllIllIlllIIIlllIll = (1.0f - llllllllllllllllIllIlllIIIlllllI / (float)llllllllllllllllIllIlllIIlIIIIII) * llllllllllllllllIllIlllIIIllllll;
            for (int llllllllllllllllIllIlllIIIllllIl = MathHelper.ceiling_float_int(llllllllllllllllIllIlllIIIlllIll), llllllllllllllllIllIlllIIIlllIlI = -llllllllllllllllIllIlllIIIllllIl; llllllllllllllllIllIlllIIIlllIlI <= llllllllllllllllIllIlllIIIllllIl; ++llllllllllllllllIllIlllIIIlllIlI) {
                final float llllllllllllllllIllIlllIIIlllIIl = MathHelper.abs_int(llllllllllllllllIllIlllIIIlllIlI) - 0.25f;
                for (int llllllllllllllllIllIlllIIIlllIII = -llllllllllllllllIllIlllIIIllllIl; llllllllllllllllIllIlllIIIlllIII <= llllllllllllllllIllIlllIIIllllIl; ++llllllllllllllllIllIlllIIIlllIII) {
                    final float llllllllllllllllIllIlllIIIllIlll = MathHelper.abs_int(llllllllllllllllIllIlllIIIlllIII) - 0.25f;
                    if (((llllllllllllllllIllIlllIIIlllIlI == 0 && llllllllllllllllIllIlllIIIlllIII == 0) || llllllllllllllllIllIlllIIIlllIIl * llllllllllllllllIllIlllIIIlllIIl + llllllllllllllllIllIlllIIIllIlll * llllllllllllllllIllIlllIIIllIlll <= llllllllllllllllIllIlllIIIlllIll * llllllllllllllllIllIlllIIIlllIll) && ((llllllllllllllllIllIlllIIIlllIlI != -llllllllllllllllIllIlllIIIllllIl && llllllllllllllllIllIlllIIIlllIlI != llllllllllllllllIllIlllIIIllllIl && llllllllllllllllIllIlllIIIlllIII != -llllllllllllllllIllIlllIIIllllIl && llllllllllllllllIllIlllIIIlllIII != llllllllllllllllIllIlllIIIllllIl) || llllllllllllllllIllIlllIIlIIIIlI.nextFloat() <= 0.75f)) {
                        Block llllllllllllllllIllIlllIIIllIllI = llllllllllllllllIllIlllIIIllIIII.getBlockState(llllllllllllllllIllIlllIIIlIlllI.add(llllllllllllllllIllIlllIIIlllIlI, llllllllllllllllIllIlllIIIlllllI, llllllllllllllllIllIlllIIIlllIII)).getBlock();
                        if (llllllllllllllllIllIlllIIIllIllI.getMaterial() == Material.air || llllllllllllllllIllIlllIIIllIllI == Blocks.dirt || llllllllllllllllIllIlllIIIllIllI == Blocks.snow || llllllllllllllllIllIlllIIIllIllI == Blocks.ice) {
                            this.func_175906_a(llllllllllllllllIllIlllIIIllIIII, llllllllllllllllIllIlllIIIlIlllI.add(llllllllllllllllIllIlllIIIlllIlI, llllllllllllllllIllIlllIIIlllllI, llllllllllllllllIllIlllIIIlllIII), Blocks.packed_ice);
                        }
                        if (llllllllllllllllIllIlllIIIlllllI != 0 && llllllllllllllllIllIlllIIIllllIl > 1) {
                            llllllllllllllllIllIlllIIIllIllI = llllllllllllllllIllIlllIIIllIIII.getBlockState(llllllllllllllllIllIlllIIIlIlllI.add(llllllllllllllllIllIlllIIIlllIlI, -llllllllllllllllIllIlllIIIlllllI, llllllllllllllllIllIlllIIIlllIII)).getBlock();
                            if (llllllllllllllllIllIlllIIIllIllI.getMaterial() == Material.air || llllllllllllllllIllIlllIIIllIllI == Blocks.dirt || llllllllllllllllIllIlllIIIllIllI == Blocks.snow || llllllllllllllllIllIlllIIIllIllI == Blocks.ice) {
                                this.func_175906_a(llllllllllllllllIllIlllIIIllIIII, llllllllllllllllIllIlllIIIlIlllI.add(llllllllllllllllIllIlllIIIlllIlI, -llllllllllllllllIllIlllIIIlllllI, llllllllllllllllIllIlllIIIlllIII), Blocks.packed_ice);
                            }
                        }
                    }
                }
            }
        }
        int llllllllllllllllIllIlllIIIlllllI = llllllllllllllllIllIlllIIIllllll - 1;
        if (llllllllllllllllIllIlllIIIlllllI < 0) {
            llllllllllllllllIllIlllIIIlllllI = 0;
        }
        else if (llllllllllllllllIllIlllIIIlllllI > 1) {
            llllllllllllllllIllIlllIIIlllllI = 1;
        }
        for (int llllllllllllllllIllIlllIIIllIlIl = -llllllllllllllllIllIlllIIIlllllI; llllllllllllllllIllIlllIIIllIlIl <= llllllllllllllllIllIlllIIIlllllI; ++llllllllllllllllIllIlllIIIllIlIl) {
            for (int llllllllllllllllIllIlllIIIllllII = -llllllllllllllllIllIlllIIIlllllI; llllllllllllllllIllIlllIIIllllII <= llllllllllllllllIllIlllIIIlllllI; ++llllllllllllllllIllIlllIIIllllII) {
                BlockPos llllllllllllllllIllIlllIIIllIlII = llllllllllllllllIllIlllIIIlIlllI.add(llllllllllllllllIllIlllIIIllIlIl, -1, llllllllllllllllIllIlllIIIllllII);
                int llllllllllllllllIllIlllIIIllIIll = 50;
                if (Math.abs(llllllllllllllllIllIlllIIIllIlIl) == 1 && Math.abs(llllllllllllllllIllIlllIIIllllII) == 1) {
                    llllllllllllllllIllIlllIIIllIIll = llllllllllllllllIllIlllIIlIIIIlI.nextInt(5);
                }
                while (llllllllllllllllIllIlllIIIllIlII.getY() > 50) {
                    final Block llllllllllllllllIllIlllIIIllIIlI = llllllllllllllllIllIlllIIIllIIII.getBlockState(llllllllllllllllIllIlllIIIllIlII).getBlock();
                    if (llllllllllllllllIllIlllIIIllIIlI.getMaterial() != Material.air && llllllllllllllllIllIlllIIIllIIlI != Blocks.dirt && llllllllllllllllIllIlllIIIllIIlI != Blocks.snow && llllllllllllllllIllIlllIIIllIIlI != Blocks.ice && llllllllllllllllIllIlllIIIllIIlI != Blocks.packed_ice) {
                        break;
                    }
                    this.func_175906_a(llllllllllllllllIllIlllIIIllIIII, llllllllllllllllIllIlllIIIllIlII, Blocks.packed_ice);
                    llllllllllllllllIllIlllIIIllIlII = llllllllllllllllIllIlllIIIllIlII.offsetDown();
                    if (--llllllllllllllllIllIlllIIIllIIll > 0) {
                        continue;
                    }
                    llllllllllllllllIllIlllIIIllIlII = llllllllllllllllIllIlllIIIllIlII.offsetDown(llllllllllllllllIllIlllIIlIIIIlI.nextInt(5) + 1);
                    llllllllllllllllIllIlllIIIllIIll = llllllllllllllllIllIlllIIlIIIIlI.nextInt(5);
                }
            }
        }
        return true;
    }
}
