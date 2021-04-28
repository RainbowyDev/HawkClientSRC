package net.minecraft.world.gen.feature;

import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;

public class WorldGenSand extends WorldGenerator
{
    private /* synthetic */ int radius;
    private /* synthetic */ Block field_150517_a;
    
    @Override
    public boolean generate(final World lllllllllllllllIllIllllIlIlIlIlI, final Random lllllllllllllllIllIllllIlIIlllII, final BlockPos lllllllllllllllIllIllllIlIIllIll) {
        if (lllllllllllllllIllIllllIlIlIlIlI.getBlockState(lllllllllllllllIllIllllIlIIllIll).getBlock().getMaterial() != Material.water) {
            return false;
        }
        final int lllllllllllllllIllIllllIlIlIIlll = lllllllllllllllIllIllllIlIIlllII.nextInt(this.radius - 2) + 2;
        final byte lllllllllllllllIllIllllIlIlIIllI = 2;
        for (int lllllllllllllllIllIllllIlIlIIlIl = lllllllllllllllIllIllllIlIIllIll.getX() - lllllllllllllllIllIllllIlIlIIlll; lllllllllllllllIllIllllIlIlIIlIl <= lllllllllllllllIllIllllIlIIllIll.getX() + lllllllllllllllIllIllllIlIlIIlll; ++lllllllllllllllIllIllllIlIlIIlIl) {
            for (int lllllllllllllllIllIllllIlIlIIlII = lllllllllllllllIllIllllIlIIllIll.getZ() - lllllllllllllllIllIllllIlIlIIlll; lllllllllllllllIllIllllIlIlIIlII <= lllllllllllllllIllIllllIlIIllIll.getZ() + lllllllllllllllIllIllllIlIlIIlll; ++lllllllllllllllIllIllllIlIlIIlII) {
                final int lllllllllllllllIllIllllIlIlIIIll = lllllllllllllllIllIllllIlIlIIlIl - lllllllllllllllIllIllllIlIIllIll.getX();
                final int lllllllllllllllIllIllllIlIlIIIlI = lllllllllllllllIllIllllIlIlIIlII - lllllllllllllllIllIllllIlIIllIll.getZ();
                if (lllllllllllllllIllIllllIlIlIIIll * lllllllllllllllIllIllllIlIlIIIll + lllllllllllllllIllIllllIlIlIIIlI * lllllllllllllllIllIllllIlIlIIIlI <= lllllllllllllllIllIllllIlIlIIlll * lllllllllllllllIllIllllIlIlIIlll) {
                    for (int lllllllllllllllIllIllllIlIlIIIIl = lllllllllllllllIllIllllIlIIllIll.getY() - lllllllllllllllIllIllllIlIlIIllI; lllllllllllllllIllIllllIlIlIIIIl <= lllllllllllllllIllIllllIlIIllIll.getY() + lllllllllllllllIllIllllIlIlIIllI; ++lllllllllllllllIllIllllIlIlIIIIl) {
                        final BlockPos lllllllllllllllIllIllllIlIlIIIII = new BlockPos(lllllllllllllllIllIllllIlIlIIlIl, lllllllllllllllIllIllllIlIlIIIIl, lllllllllllllllIllIllllIlIlIIlII);
                        final Block lllllllllllllllIllIllllIlIIlllll = lllllllllllllllIllIllllIlIlIlIlI.getBlockState(lllllllllllllllIllIllllIlIlIIIII).getBlock();
                        if (lllllllllllllllIllIllllIlIIlllll == Blocks.dirt || lllllllllllllllIllIllllIlIIlllll == Blocks.grass) {
                            lllllllllllllllIllIllllIlIlIlIlI.setBlockState(lllllllllllllllIllIllllIlIlIIIII, this.field_150517_a.getDefaultState(), 2);
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public WorldGenSand(final Block lllllllllllllllIllIllllIlIlllIlI, final int lllllllllllllllIllIllllIlIlllIIl) {
        this.field_150517_a = lllllllllllllllIllIllllIlIlllIlI;
        this.radius = lllllllllllllllIllIllllIlIlllIIl;
    }
    
    static {
        __OBFID = "CL_00000431";
    }
}
