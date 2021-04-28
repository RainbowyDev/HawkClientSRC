package net.minecraft.world.gen.feature;

import net.minecraft.block.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import java.util.*;

public class WorldGenBlockBlob extends WorldGenerator
{
    private final /* synthetic */ int field_150544_b;
    private final /* synthetic */ Block field_150545_a;
    
    @Override
    public boolean generate(final World lllllllllllllllIllIlIlIIIIIllIII, final Random lllllllllllllllIllIlIlIIIIlIIlII, BlockPos lllllllllllllllIllIlIlIIIIIlIllI) {
        while (lllllllllllllllIllIlIlIIIIIlIllI.getY() > 3) {
            if (!lllllllllllllllIllIlIlIIIIIllIII.isAirBlock(lllllllllllllllIllIlIlIIIIIlIllI.offsetDown())) {
                final Block lllllllllllllllIllIlIlIIIIlIIIlI = lllllllllllllllIllIlIlIIIIIllIII.getBlockState(lllllllllllllllIllIlIlIIIIIlIllI.offsetDown()).getBlock();
                if (lllllllllllllllIllIlIlIIIIlIIIlI == Blocks.grass || lllllllllllllllIllIlIlIIIIlIIIlI == Blocks.dirt) {
                    break;
                }
                if (lllllllllllllllIllIlIlIIIIlIIIlI == Blocks.stone) {
                    break;
                }
            }
            lllllllllllllllIllIlIlIIIIIlIllI = lllllllllllllllIllIlIlIIIIIlIllI.offsetDown();
        }
        if (lllllllllllllllIllIlIlIIIIIlIllI.getY() <= 3) {
            return false;
        }
        for (int lllllllllllllllIllIlIlIIIIlIIIIl = this.field_150544_b, lllllllllllllllIllIlIlIIIIlIIIII = 0; lllllllllllllllIllIlIlIIIIlIIIIl >= 0 && lllllllllllllllIllIlIlIIIIlIIIII < 3; ++lllllllllllllllIllIlIlIIIIlIIIII) {
            final int lllllllllllllllIllIlIlIIIIIlllll = lllllllllllllllIllIlIlIIIIlIIIIl + lllllllllllllllIllIlIlIIIIlIIlII.nextInt(2);
            final int lllllllllllllllIllIlIlIIIIIllllI = lllllllllllllllIllIlIlIIIIlIIIIl + lllllllllllllllIllIlIlIIIIlIIlII.nextInt(2);
            final int lllllllllllllllIllIlIlIIIIIlllIl = lllllllllllllllIllIlIlIIIIlIIIIl + lllllllllllllllIllIlIlIIIIlIIlII.nextInt(2);
            final float lllllllllllllllIllIlIlIIIIIlllII = (lllllllllllllllIllIlIlIIIIIlllll + lllllllllllllllIllIlIlIIIIIllllI + lllllllllllllllIllIlIlIIIIIlllIl) * 0.333f + 0.5f;
            for (final BlockPos lllllllllllllllIllIlIlIIIIIllIlI : BlockPos.getAllInBox(lllllllllllllllIllIlIlIIIIIlIllI.add(-lllllllllllllllIllIlIlIIIIIlllll, -lllllllllllllllIllIlIlIIIIIllllI, -lllllllllllllllIllIlIlIIIIIlllIl), lllllllllllllllIllIlIlIIIIIlIllI.add(lllllllllllllllIllIlIlIIIIIlllll, lllllllllllllllIllIlIlIIIIIllllI, lllllllllllllllIllIlIlIIIIIlllIl))) {
                if (lllllllllllllllIllIlIlIIIIIllIlI.distanceSq(lllllllllllllllIllIlIlIIIIIlIllI) <= lllllllllllllllIllIlIlIIIIIlllII * lllllllllllllllIllIlIlIIIIIlllII) {
                    lllllllllllllllIllIlIlIIIIIllIII.setBlockState(lllllllllllllllIllIlIlIIIIIllIlI, this.field_150545_a.getDefaultState(), 4);
                }
            }
            lllllllllllllllIllIlIlIIIIIlIllI = lllllllllllllllIllIlIlIIIIIlIllI.add(-(lllllllllllllllIllIlIlIIIIlIIIIl + 1) + lllllllllllllllIllIlIlIIIIlIIlII.nextInt(2 + lllllllllllllllIllIlIlIIIIlIIIIl * 2), 0 - lllllllllllllllIllIlIlIIIIlIIlII.nextInt(2), -(lllllllllllllllIllIlIlIIIIlIIIIl + 1) + lllllllllllllllIllIlIlIIIIlIIlII.nextInt(2 + lllllllllllllllIllIlIlIIIIlIIIIl * 2));
        }
        return true;
    }
    
    public WorldGenBlockBlob(final Block lllllllllllllllIllIlIlIIIIlllIll, final int lllllllllllllllIllIlIlIIIIlllIlI) {
        super(false);
        this.field_150545_a = lllllllllllllllIllIlIlIIIIlllIll;
        this.field_150544_b = lllllllllllllllIllIlIlIIIIlllIlI;
    }
    
    static {
        __OBFID = "CL_00000402";
    }
}
