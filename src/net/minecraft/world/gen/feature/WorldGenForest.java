package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;

public class WorldGenForest extends WorldGenAbstractTree
{
    private /* synthetic */ boolean field_150531_a;
    
    public WorldGenForest(final boolean lllllllllllllllIIllIlIllIIIIlIlI, final boolean lllllllllllllllIIllIlIllIIIIIllI) {
        super(lllllllllllllllIIllIlIllIIIIlIlI);
        this.field_150531_a = lllllllllllllllIIllIlIllIIIIIllI;
    }
    
    static {
        __OBFID = "CL_00000401";
    }
    
    @Override
    public boolean generate(final World lllllllllllllllIIllIlIlIllIlllll, final Random lllllllllllllllIIllIlIlIllIllllI, final BlockPos lllllllllllllllIIllIlIlIllIlllIl) {
        int lllllllllllllllIIllIlIlIllllIIIl = lllllllllllllllIIllIlIlIllIllllI.nextInt(3) + 5;
        if (this.field_150531_a) {
            lllllllllllllllIIllIlIlIllllIIIl += lllllllllllllllIIllIlIlIllIllllI.nextInt(7);
        }
        boolean lllllllllllllllIIllIlIlIllllIIII = true;
        if (lllllllllllllllIIllIlIlIllIlllIl.getY() < 1 || lllllllllllllllIIllIlIlIllIlllIl.getY() + lllllllllllllllIIllIlIlIllllIIIl + 1 > 256) {
            return false;
        }
        for (int lllllllllllllllIIllIlIlIlllIlIll = lllllllllllllllIIllIlIlIllIlllIl.getY(); lllllllllllllllIIllIlIlIlllIlIll <= lllllllllllllllIIllIlIlIllIlllIl.getY() + 1 + lllllllllllllllIIllIlIlIllllIIIl; ++lllllllllllllllIIllIlIlIlllIlIll) {
            byte lllllllllllllllIIllIlIlIlllIlIlI = 1;
            if (lllllllllllllllIIllIlIlIlllIlIll == lllllllllllllllIIllIlIlIllIlllIl.getY()) {
                lllllllllllllllIIllIlIlIlllIlIlI = 0;
            }
            if (lllllllllllllllIIllIlIlIlllIlIll >= lllllllllllllllIIllIlIlIllIlllIl.getY() + 1 + lllllllllllllllIIllIlIlIllllIIIl - 2) {
                lllllllllllllllIIllIlIlIlllIlIlI = 2;
            }
            for (int lllllllllllllllIIllIlIlIlllIllll = lllllllllllllllIIllIlIlIllIlllIl.getX() - lllllllllllllllIIllIlIlIlllIlIlI; lllllllllllllllIIllIlIlIlllIllll <= lllllllllllllllIIllIlIlIllIlllIl.getX() + lllllllllllllllIIllIlIlIlllIlIlI && lllllllllllllllIIllIlIlIllllIIII; ++lllllllllllllllIIllIlIlIlllIllll) {
                for (int lllllllllllllllIIllIlIlIlllIllIl = lllllllllllllllIIllIlIlIllIlllIl.getZ() - lllllllllllllllIIllIlIlIlllIlIlI; lllllllllllllllIIllIlIlIlllIllIl <= lllllllllllllllIIllIlIlIllIlllIl.getZ() + lllllllllllllllIIllIlIlIlllIlIlI && lllllllllllllllIIllIlIlIllllIIII; ++lllllllllllllllIIllIlIlIlllIllIl) {
                    if (lllllllllllllllIIllIlIlIlllIlIll >= 0 && lllllllllllllllIIllIlIlIlllIlIll < 256) {
                        if (!this.func_150523_a(lllllllllllllllIIllIlIlIllIlllll.getBlockState(new BlockPos(lllllllllllllllIIllIlIlIlllIllll, lllllllllllllllIIllIlIlIlllIlIll, lllllllllllllllIIllIlIlIlllIllIl)).getBlock())) {
                            lllllllllllllllIIllIlIlIllllIIII = false;
                        }
                    }
                    else {
                        lllllllllllllllIIllIlIlIllllIIII = false;
                    }
                }
            }
        }
        if (!lllllllllllllllIIllIlIlIllllIIII) {
            return false;
        }
        final Block lllllllllllllllIIllIlIlIlllIlIIl = lllllllllllllllIIllIlIlIllIlllll.getBlockState(lllllllllllllllIIllIlIlIllIlllIl.offsetDown()).getBlock();
        if ((lllllllllllllllIIllIlIlIlllIlIIl == Blocks.grass || lllllllllllllllIIllIlIlIlllIlIIl == Blocks.dirt || lllllllllllllllIIllIlIlIlllIlIIl == Blocks.farmland) && lllllllllllllllIIllIlIlIllIlllIl.getY() < 256 - lllllllllllllllIIllIlIlIllllIIIl - 1) {
            this.func_175921_a(lllllllllllllllIIllIlIlIllIlllll, lllllllllllllllIIllIlIlIllIlllIl.offsetDown());
            for (int lllllllllllllllIIllIlIlIlllIlIII = lllllllllllllllIIllIlIlIllIlllIl.getY() - 3 + lllllllllllllllIIllIlIlIllllIIIl; lllllllllllllllIIllIlIlIlllIlIII <= lllllllllllllllIIllIlIlIllIlllIl.getY() + lllllllllllllllIIllIlIlIllllIIIl; ++lllllllllllllllIIllIlIlIlllIlIII) {
                final int lllllllllllllllIIllIlIlIlllIlllI = lllllllllllllllIIllIlIlIlllIlIII - (lllllllllllllllIIllIlIlIllIlllIl.getY() + lllllllllllllllIIllIlIlIllllIIIl);
                for (int lllllllllllllllIIllIlIlIlllIllII = 1 - lllllllllllllllIIllIlIlIlllIlllI / 2, lllllllllllllllIIllIlIlIlllIIlll = lllllllllllllllIIllIlIlIllIlllIl.getX() - lllllllllllllllIIllIlIlIlllIllII; lllllllllllllllIIllIlIlIlllIIlll <= lllllllllllllllIIllIlIlIllIlllIl.getX() + lllllllllllllllIIllIlIlIlllIllII; ++lllllllllllllllIIllIlIlIlllIIlll) {
                    final int lllllllllllllllIIllIlIlIlllIIllI = lllllllllllllllIIllIlIlIlllIIlll - lllllllllllllllIIllIlIlIllIlllIl.getX();
                    for (int lllllllllllllllIIllIlIlIlllIIlIl = lllllllllllllllIIllIlIlIllIlllIl.getZ() - lllllllllllllllIIllIlIlIlllIllII; lllllllllllllllIIllIlIlIlllIIlIl <= lllllllllllllllIIllIlIlIllIlllIl.getZ() + lllllllllllllllIIllIlIlIlllIllII; ++lllllllllllllllIIllIlIlIlllIIlIl) {
                        final int lllllllllllllllIIllIlIlIlllIIlII = lllllllllllllllIIllIlIlIlllIIlIl - lllllllllllllllIIllIlIlIllIlllIl.getZ();
                        if (Math.abs(lllllllllllllllIIllIlIlIlllIIllI) != lllllllllllllllIIllIlIlIlllIllII || Math.abs(lllllllllllllllIIllIlIlIlllIIlII) != lllllllllllllllIIllIlIlIlllIllII || (lllllllllllllllIIllIlIlIllIllllI.nextInt(2) != 0 && lllllllllllllllIIllIlIlIlllIlllI != 0)) {
                            final BlockPos lllllllllllllllIIllIlIlIlllIIIll = new BlockPos(lllllllllllllllIIllIlIlIlllIIlll, lllllllllllllllIIllIlIlIlllIlIII, lllllllllllllllIIllIlIlIlllIIlIl);
                            final Block lllllllllllllllIIllIlIlIlllIIIlI = lllllllllllllllIIllIlIlIllIlllll.getBlockState(lllllllllllllllIIllIlIlIlllIIIll).getBlock();
                            if (lllllllllllllllIIllIlIlIlllIIIlI.getMaterial() == Material.air || lllllllllllllllIIllIlIlIlllIIIlI.getMaterial() == Material.leaves) {
                                this.func_175905_a(lllllllllllllllIIllIlIlIllIlllll, lllllllllllllllIIllIlIlIlllIIIll, Blocks.leaves, BlockPlanks.EnumType.BIRCH.func_176839_a());
                            }
                        }
                    }
                }
            }
            for (int lllllllllllllllIIllIlIlIlllIlIII = 0; lllllllllllllllIIllIlIlIlllIlIII < lllllllllllllllIIllIlIlIllllIIIl; ++lllllllllllllllIIllIlIlIlllIlIII) {
                final Block lllllllllllllllIIllIlIlIlllIIIIl = lllllllllllllllIIllIlIlIllIlllll.getBlockState(lllllllllllllllIIllIlIlIllIlllIl.offsetUp(lllllllllllllllIIllIlIlIlllIlIII)).getBlock();
                if (lllllllllllllllIIllIlIlIlllIIIIl.getMaterial() == Material.air || lllllllllllllllIIllIlIlIlllIIIIl.getMaterial() == Material.leaves) {
                    this.func_175905_a(lllllllllllllllIIllIlIlIllIlllll, lllllllllllllllIIllIlIlIllIlllIl.offsetUp(lllllllllllllllIIllIlIlIlllIlIII), Blocks.log, BlockPlanks.EnumType.BIRCH.func_176839_a());
                }
            }
            return true;
        }
        return false;
    }
}
