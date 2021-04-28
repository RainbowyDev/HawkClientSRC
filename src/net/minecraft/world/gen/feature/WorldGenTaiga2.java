package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.block.*;

public class WorldGenTaiga2 extends WorldGenAbstractTree
{
    @Override
    public boolean generate(final World llllllllllllllllIIIIIllllIIIIIIl, final Random llllllllllllllllIIIIIlllIllIIIll, final BlockPos llllllllllllllllIIIIIlllIlllllll) {
        final int llllllllllllllllIIIIIlllIllllllI = llllllllllllllllIIIIIlllIllIIIll.nextInt(4) + 6;
        final int llllllllllllllllIIIIIlllIlllllIl = 1 + llllllllllllllllIIIIIlllIllIIIll.nextInt(2);
        final int llllllllllllllllIIIIIlllIlllllII = llllllllllllllllIIIIIlllIllllllI - llllllllllllllllIIIIIlllIlllllIl;
        final int llllllllllllllllIIIIIlllIllllIll = 2 + llllllllllllllllIIIIIlllIllIIIll.nextInt(2);
        boolean llllllllllllllllIIIIIlllIllllIlI = true;
        if (llllllllllllllllIIIIIlllIlllllll.getY() < 1 || llllllllllllllllIIIIIlllIlllllll.getY() + llllllllllllllllIIIIIlllIllllllI + 1 > 256) {
            return false;
        }
        for (int llllllllllllllllIIIIIlllIlllIlII = llllllllllllllllIIIIIlllIlllllll.getY(); llllllllllllllllIIIIIlllIlllIlII <= llllllllllllllllIIIIIlllIlllllll.getY() + 1 + llllllllllllllllIIIIIlllIllllllI && llllllllllllllllIIIIIlllIllllIlI; ++llllllllllllllllIIIIIlllIlllIlII) {
            final boolean llllllllllllllllIIIIIlllIlllIIll = true;
            int llllllllllllllllIIIIIlllIlllIllI = 0;
            if (llllllllllllllllIIIIIlllIlllIlII - llllllllllllllllIIIIIlllIlllllll.getY() < llllllllllllllllIIIIIlllIlllllIl) {
                final int llllllllllllllllIIIIIlllIlllIlll = 0;
            }
            else {
                llllllllllllllllIIIIIlllIlllIllI = llllllllllllllllIIIIIlllIllllIll;
            }
            for (int llllllllllllllllIIIIIlllIllllIIl = llllllllllllllllIIIIIlllIlllllll.getX() - llllllllllllllllIIIIIlllIlllIllI; llllllllllllllllIIIIIlllIllllIIl <= llllllllllllllllIIIIIlllIlllllll.getX() + llllllllllllllllIIIIIlllIlllIllI && llllllllllllllllIIIIIlllIllllIlI; ++llllllllllllllllIIIIIlllIllllIIl) {
                for (int llllllllllllllllIIIIIlllIlllIIlI = llllllllllllllllIIIIIlllIlllllll.getZ() - llllllllllllllllIIIIIlllIlllIllI; llllllllllllllllIIIIIlllIlllIIlI <= llllllllllllllllIIIIIlllIlllllll.getZ() + llllllllllllllllIIIIIlllIlllIllI && llllllllllllllllIIIIIlllIllllIlI; ++llllllllllllllllIIIIIlllIlllIIlI) {
                    if (llllllllllllllllIIIIIlllIlllIlII >= 0 && llllllllllllllllIIIIIlllIlllIlII < 256) {
                        final Block llllllllllllllllIIIIIlllIlllIIIl = llllllllllllllllIIIIIllllIIIIIIl.getBlockState(new BlockPos(llllllllllllllllIIIIIlllIllllIIl, llllllllllllllllIIIIIlllIlllIlII, llllllllllllllllIIIIIlllIlllIIlI)).getBlock();
                        if (llllllllllllllllIIIIIlllIlllIIIl.getMaterial() != Material.air && llllllllllllllllIIIIIlllIlllIIIl.getMaterial() != Material.leaves) {
                            llllllllllllllllIIIIIlllIllllIlI = false;
                        }
                    }
                    else {
                        llllllllllllllllIIIIIlllIllllIlI = false;
                    }
                }
            }
        }
        if (!llllllllllllllllIIIIIlllIllllIlI) {
            return false;
        }
        final Block llllllllllllllllIIIIIlllIlllIIII = llllllllllllllllIIIIIllllIIIIIIl.getBlockState(llllllllllllllllIIIIIlllIlllllll.offsetDown()).getBlock();
        if ((llllllllllllllllIIIIIlllIlllIIII == Blocks.grass || llllllllllllllllIIIIIlllIlllIIII == Blocks.dirt || llllllllllllllllIIIIIlllIlllIIII == Blocks.farmland) && llllllllllllllllIIIIIlllIlllllll.getY() < 256 - llllllllllllllllIIIIIlllIllllllI - 1) {
            this.func_175921_a(llllllllllllllllIIIIIllllIIIIIIl, llllllllllllllllIIIIIlllIlllllll.offsetDown());
            int llllllllllllllllIIIIIlllIlllIlIl = llllllllllllllllIIIIIlllIllIIIll.nextInt(2);
            int llllllllllllllllIIIIIlllIllllIII = 1;
            byte llllllllllllllllIIIIIlllIllIllll = 0;
            for (int llllllllllllllllIIIIIlllIllIllII = 0; llllllllllllllllIIIIIlllIllIllII <= llllllllllllllllIIIIIlllIlllllII; ++llllllllllllllllIIIIIlllIllIllII) {
                final int llllllllllllllllIIIIIlllIllIlllI = llllllllllllllllIIIIIlllIlllllll.getY() + llllllllllllllllIIIIIlllIllllllI - llllllllllllllllIIIIIlllIllIllII;
                for (int llllllllllllllllIIIIIlllIllIlIll = llllllllllllllllIIIIIlllIlllllll.getX() - llllllllllllllllIIIIIlllIlllIlIl; llllllllllllllllIIIIIlllIllIlIll <= llllllllllllllllIIIIIlllIlllllll.getX() + llllllllllllllllIIIIIlllIlllIlIl; ++llllllllllllllllIIIIIlllIllIlIll) {
                    final int llllllllllllllllIIIIIlllIllIlIlI = llllllllllllllllIIIIIlllIllIlIll - llllllllllllllllIIIIIlllIlllllll.getX();
                    for (int llllllllllllllllIIIIIlllIllIlIIl = llllllllllllllllIIIIIlllIlllllll.getZ() - llllllllllllllllIIIIIlllIlllIlIl; llllllllllllllllIIIIIlllIllIlIIl <= llllllllllllllllIIIIIlllIlllllll.getZ() + llllllllllllllllIIIIIlllIlllIlIl; ++llllllllllllllllIIIIIlllIllIlIIl) {
                        final int llllllllllllllllIIIIIlllIllIlIII = llllllllllllllllIIIIIlllIllIlIIl - llllllllllllllllIIIIIlllIlllllll.getZ();
                        if (Math.abs(llllllllllllllllIIIIIlllIllIlIlI) != llllllllllllllllIIIIIlllIlllIlIl || Math.abs(llllllllllllllllIIIIIlllIllIlIII) != llllllllllllllllIIIIIlllIlllIlIl || llllllllllllllllIIIIIlllIlllIlIl <= 0) {
                            final BlockPos llllllllllllllllIIIIIlllIllIIlll = new BlockPos(llllllllllllllllIIIIIlllIllIlIll, llllllllllllllllIIIIIlllIllIlllI, llllllllllllllllIIIIIlllIllIlIIl);
                            if (!llllllllllllllllIIIIIllllIIIIIIl.getBlockState(llllllllllllllllIIIIIlllIllIIlll).getBlock().isFullBlock()) {
                                this.func_175905_a(llllllllllllllllIIIIIllllIIIIIIl, llllllllllllllllIIIIIlllIllIIlll, Blocks.leaves, BlockPlanks.EnumType.SPRUCE.func_176839_a());
                            }
                        }
                    }
                }
                if (llllllllllllllllIIIIIlllIlllIlIl >= llllllllllllllllIIIIIlllIllllIII) {
                    llllllllllllllllIIIIIlllIlllIlIl = llllllllllllllllIIIIIlllIllIllll;
                    llllllllllllllllIIIIIlllIllIllll = 1;
                    if (++llllllllllllllllIIIIIlllIllllIII > llllllllllllllllIIIIIlllIllllIll) {
                        llllllllllllllllIIIIIlllIllllIII = llllllllllllllllIIIIIlllIllllIll;
                    }
                }
                else {
                    ++llllllllllllllllIIIIIlllIlllIlIl;
                }
            }
            for (int llllllllllllllllIIIIIlllIllIllII = llllllllllllllllIIIIIlllIllIIIll.nextInt(3), llllllllllllllllIIIIIlllIllIllIl = 0; llllllllllllllllIIIIIlllIllIllIl < llllllllllllllllIIIIIlllIllllllI - llllllllllllllllIIIIIlllIllIllII; ++llllllllllllllllIIIIIlllIllIllIl) {
                final Block llllllllllllllllIIIIIlllIllIIllI = llllllllllllllllIIIIIllllIIIIIIl.getBlockState(llllllllllllllllIIIIIlllIlllllll.offsetUp(llllllllllllllllIIIIIlllIllIllIl)).getBlock();
                if (llllllllllllllllIIIIIlllIllIIllI.getMaterial() == Material.air || llllllllllllllllIIIIIlllIllIIllI.getMaterial() == Material.leaves) {
                    this.func_175905_a(llllllllllllllllIIIIIllllIIIIIIl, llllllllllllllllIIIIIlllIlllllll.offsetUp(llllllllllllllllIIIIIlllIllIllIl), Blocks.log, BlockPlanks.EnumType.SPRUCE.func_176839_a());
                }
            }
            return true;
        }
        return false;
    }
    
    public WorldGenTaiga2(final boolean llllllllllllllllIIIIIllllIIlIlll) {
        super(llllllllllllllllIIIIIllllIIlIlll);
    }
    
    static {
        __OBFID = "CL_00000435";
    }
}
