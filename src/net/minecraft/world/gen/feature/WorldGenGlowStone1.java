package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;

public class WorldGenGlowStone1 extends WorldGenerator
{
    static {
        __OBFID = "CL_00000419";
    }
    
    @Override
    public boolean generate(final World lIlIIllIIIIIlIl, final Random lIlIIllIIIIIlII, final BlockPos lIlIIllIIIIIIll) {
        if (!lIlIIllIIIIIlIl.isAirBlock(lIlIIllIIIIIIll)) {
            return false;
        }
        if (lIlIIllIIIIIlIl.getBlockState(lIlIIllIIIIIIll.offsetUp()).getBlock() != Blocks.netherrack) {
            return false;
        }
        lIlIIllIIIIIlIl.setBlockState(lIlIIllIIIIIIll, Blocks.glowstone.getDefaultState(), 2);
        for (int lIlIIllIIIIllII = 0; lIlIIllIIIIllII < 1500; ++lIlIIllIIIIllII) {
            final BlockPos lIlIIllIIIIlIll = lIlIIllIIIIIIll.add(lIlIIllIIIIIlII.nextInt(8) - lIlIIllIIIIIlII.nextInt(8), -lIlIIllIIIIIlII.nextInt(12), lIlIIllIIIIIlII.nextInt(8) - lIlIIllIIIIIlII.nextInt(8));
            if (lIlIIllIIIIIlIl.getBlockState(lIlIIllIIIIlIll).getBlock().getMaterial() == Material.air) {
                int lIlIIllIIIIlIlI = 0;
                for (final EnumFacing lIlIIllIIIIIllI : EnumFacing.values()) {
                    if (lIlIIllIIIIIlIl.getBlockState(lIlIIllIIIIlIll.offset(lIlIIllIIIIIllI)).getBlock() == Blocks.glowstone) {
                        ++lIlIIllIIIIlIlI;
                    }
                    if (lIlIIllIIIIlIlI > 1) {
                        break;
                    }
                }
                if (lIlIIllIIIIlIlI == 1) {
                    lIlIIllIIIIIlIl.setBlockState(lIlIIllIIIIlIll, Blocks.glowstone.getDefaultState(), 2);
                }
            }
        }
        return true;
    }
}
