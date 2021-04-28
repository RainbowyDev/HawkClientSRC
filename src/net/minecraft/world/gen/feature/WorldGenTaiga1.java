package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;

public class WorldGenTaiga1 extends WorldGenAbstractTree
{
    static {
        __OBFID = "CL_00000427";
    }
    
    @Override
    public boolean generate(final World llllllllllllllllllIIIlIIllllIIIl, final Random llllllllllllllllllIIIlIIllIllIII, final BlockPos llllllllllllllllllIIIlIIllIlIlll) {
        final int llllllllllllllllllIIIlIIlllIlllI = llllllllllllllllllIIIlIIllIllIII.nextInt(5) + 7;
        final int llllllllllllllllllIIIlIIlllIllIl = llllllllllllllllllIIIlIIlllIlllI - llllllllllllllllllIIIlIIllIllIII.nextInt(2) - 3;
        final int llllllllllllllllllIIIlIIlllIllII = llllllllllllllllllIIIlIIlllIlllI - llllllllllllllllllIIIlIIlllIllIl;
        final int llllllllllllllllllIIIlIIlllIlIll = 1 + llllllllllllllllllIIIlIIllIllIII.nextInt(llllllllllllllllllIIIlIIlllIllII + 1);
        boolean llllllllllllllllllIIIlIIlllIlIlI = true;
        if (llllllllllllllllllIIIlIIllIlIlll.getY() < 1 || llllllllllllllllllIIIlIIllIlIlll.getY() + llllllllllllllllllIIIlIIlllIlllI + 1 > 256) {
            return false;
        }
        for (int llllllllllllllllllIIIlIIlllIIIlI = llllllllllllllllllIIIlIIllIlIlll.getY(); llllllllllllllllllIIIlIIlllIIIlI <= llllllllllllllllllIIIlIIllIlIlll.getY() + 1 + llllllllllllllllllIIIlIIlllIlllI && llllllllllllllllllIIIlIIlllIlIlI; ++llllllllllllllllllIIIlIIlllIIIlI) {
            final boolean llllllllllllllllllIIIlIIlllIIIIl = true;
            int llllllllllllllllllIIIlIIlllIIlII = 0;
            if (llllllllllllllllllIIIlIIlllIIIlI - llllllllllllllllllIIIlIIllIlIlll.getY() < llllllllllllllllllIIIlIIlllIllIl) {
                final int llllllllllllllllllIIIlIIlllIIlIl = 0;
            }
            else {
                llllllllllllllllllIIIlIIlllIIlII = llllllllllllllllllIIIlIIlllIlIll;
            }
            for (int llllllllllllllllllIIIlIIlllIlIIl = llllllllllllllllllIIIlIIllIlIlll.getX() - llllllllllllllllllIIIlIIlllIIlII; llllllllllllllllllIIIlIIlllIlIIl <= llllllllllllllllllIIIlIIllIlIlll.getX() + llllllllllllllllllIIIlIIlllIIlII && llllllllllllllllllIIIlIIlllIlIlI; ++llllllllllllllllllIIIlIIlllIlIIl) {
                for (int llllllllllllllllllIIIlIIlllIIlll = llllllllllllllllllIIIlIIllIlIlll.getZ() - llllllllllllllllllIIIlIIlllIIlII; llllllllllllllllllIIIlIIlllIIlll <= llllllllllllllllllIIIlIIllIlIlll.getZ() + llllllllllllllllllIIIlIIlllIIlII && llllllllllllllllllIIIlIIlllIlIlI; ++llllllllllllllllllIIIlIIlllIIlll) {
                    if (llllllllllllllllllIIIlIIlllIIIlI >= 0 && llllllllllllllllllIIIlIIlllIIIlI < 256) {
                        if (!this.func_150523_a(llllllllllllllllllIIIlIIllllIIIl.getBlockState(new BlockPos(llllllllllllllllllIIIlIIlllIlIIl, llllllllllllllllllIIIlIIlllIIIlI, llllllllllllllllllIIIlIIlllIIlll)).getBlock())) {
                            llllllllllllllllllIIIlIIlllIlIlI = false;
                        }
                    }
                    else {
                        llllllllllllllllllIIIlIIlllIlIlI = false;
                    }
                }
            }
        }
        if (!llllllllllllllllllIIIlIIlllIlIlI) {
            return false;
        }
        final Block llllllllllllllllllIIIlIIlllIIIII = llllllllllllllllllIIIlIIllllIIIl.getBlockState(llllllllllllllllllIIIlIIllIlIlll.offsetDown()).getBlock();
        if ((llllllllllllllllllIIIlIIlllIIIII == Blocks.grass || llllllllllllllllllIIIlIIlllIIIII == Blocks.dirt) && llllllllllllllllllIIIlIIllIlIlll.getY() < 256 - llllllllllllllllllIIIlIIlllIlllI - 1) {
            this.func_175921_a(llllllllllllllllllIIIlIIllllIIIl, llllllllllllllllllIIIlIIllIlIlll.offsetDown());
            int llllllllllllllllllIIIlIIlllIIIll = 0;
            for (int llllllllllllllllllIIIlIIlllIlIII = llllllllllllllllllIIIlIIllIlIlll.getY() + llllllllllllllllllIIIlIIlllIlllI; llllllllllllllllllIIIlIIlllIlIII >= llllllllllllllllllIIIlIIllIlIlll.getY() + llllllllllllllllllIIIlIIlllIllIl; --llllllllllllllllllIIIlIIlllIlIII) {
                for (int llllllllllllllllllIIIlIIlllIIllI = llllllllllllllllllIIIlIIllIlIlll.getX() - llllllllllllllllllIIIlIIlllIIIll; llllllllllllllllllIIIlIIlllIIllI <= llllllllllllllllllIIIlIIllIlIlll.getX() + llllllllllllllllllIIIlIIlllIIIll; ++llllllllllllllllllIIIlIIlllIIllI) {
                    final int llllllllllllllllllIIIlIIllIlllll = llllllllllllllllllIIIlIIlllIIllI - llllllllllllllllllIIIlIIllIlIlll.getX();
                    for (int llllllllllllllllllIIIlIIllIllllI = llllllllllllllllllIIIlIIllIlIlll.getZ() - llllllllllllllllllIIIlIIlllIIIll; llllllllllllllllllIIIlIIllIllllI <= llllllllllllllllllIIIlIIllIlIlll.getZ() + llllllllllllllllllIIIlIIlllIIIll; ++llllllllllllllllllIIIlIIllIllllI) {
                        final int llllllllllllllllllIIIlIIllIlllIl = llllllllllllllllllIIIlIIllIllllI - llllllllllllllllllIIIlIIllIlIlll.getZ();
                        if (Math.abs(llllllllllllllllllIIIlIIllIlllll) != llllllllllllllllllIIIlIIlllIIIll || Math.abs(llllllllllllllllllIIIlIIllIlllIl) != llllllllllllllllllIIIlIIlllIIIll || llllllllllllllllllIIIlIIlllIIIll <= 0) {
                            final BlockPos llllllllllllllllllIIIlIIllIlllII = new BlockPos(llllllllllllllllllIIIlIIlllIIllI, llllllllllllllllllIIIlIIlllIlIII, llllllllllllllllllIIIlIIllIllllI);
                            if (!llllllllllllllllllIIIlIIllllIIIl.getBlockState(llllllllllllllllllIIIlIIllIlllII).getBlock().isFullBlock()) {
                                this.func_175905_a(llllllllllllllllllIIIlIIllllIIIl, llllllllllllllllllIIIlIIllIlllII, Blocks.leaves, BlockPlanks.EnumType.SPRUCE.func_176839_a());
                            }
                        }
                    }
                }
                if (llllllllllllllllllIIIlIIlllIIIll >= 1 && llllllllllllllllllIIIlIIlllIlIII == llllllllllllllllllIIIlIIllIlIlll.getY() + llllllllllllllllllIIIlIIlllIllIl + 1) {
                    --llllllllllllllllllIIIlIIlllIIIll;
                }
                else if (llllllllllllllllllIIIlIIlllIIIll < llllllllllllllllllIIIlIIlllIlIll) {
                    ++llllllllllllllllllIIIlIIlllIIIll;
                }
            }
            for (int llllllllllllllllllIIIlIIlllIlIII = 0; llllllllllllllllllIIIlIIlllIlIII < llllllllllllllllllIIIlIIlllIlllI - 1; ++llllllllllllllllllIIIlIIlllIlIII) {
                final Block llllllllllllllllllIIIlIIllIllIll = llllllllllllllllllIIIlIIllllIIIl.getBlockState(llllllllllllllllllIIIlIIllIlIlll.offsetUp(llllllllllllllllllIIIlIIlllIlIII)).getBlock();
                if (llllllllllllllllllIIIlIIllIllIll.getMaterial() == Material.air || llllllllllllllllllIIIlIIllIllIll.getMaterial() == Material.leaves) {
                    this.func_175905_a(llllllllllllllllllIIIlIIllllIIIl, llllllllllllllllllIIIlIIllIlIlll.offsetUp(llllllllllllllllllIIIlIIlllIlIII), Blocks.log, BlockPlanks.EnumType.SPRUCE.func_176839_a());
                }
            }
            return true;
        }
        return false;
    }
    
    public WorldGenTaiga1() {
        super(false);
    }
}
