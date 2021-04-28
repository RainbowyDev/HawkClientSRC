package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.block.*;

public class WorldGenSavannaTree extends WorldGenAbstractTree
{
    private void func_175924_b(final World llllllllllllllllllllIIllIIlIlllI, final BlockPos llllllllllllllllllllIIllIIlIlIIl) {
        final Material llllllllllllllllllllIIllIIlIllII = llllllllllllllllllllIIllIIlIlllI.getBlockState(llllllllllllllllllllIIllIIlIlIIl).getBlock().getMaterial();
        if (llllllllllllllllllllIIllIIlIllII == Material.air || llllllllllllllllllllIIllIIlIllII == Material.leaves) {
            this.func_175905_a(llllllllllllllllllllIIllIIlIlllI, llllllllllllllllllllIIllIIlIlIIl, Blocks.leaves2, 0);
        }
    }
    
    static {
        __OBFID = "CL_00000432";
    }
    
    public WorldGenSavannaTree(final boolean llllllllllllllllllllIIlllIIIIIll) {
        super(llllllllllllllllllllIIlllIIIIIll);
    }
    
    @Override
    public boolean generate(final World llllllllllllllllllllIIllIlIIIlll, final Random llllllllllllllllllllIIllIllIlIIl, final BlockPos llllllllllllllllllllIIllIllIlIII) {
        final int llllllllllllllllllllIIllIllIIlll = llllllllllllllllllllIIllIllIlIIl.nextInt(3) + llllllllllllllllllllIIllIllIlIIl.nextInt(3) + 5;
        boolean llllllllllllllllllllIIllIllIIllI = true;
        if (llllllllllllllllllllIIllIllIlIII.getY() < 1 || llllllllllllllllllllIIllIllIlIII.getY() + llllllllllllllllllllIIllIllIIlll + 1 > 256) {
            return false;
        }
        for (int llllllllllllllllllllIIllIllIIIIl = llllllllllllllllllllIIllIllIlIII.getY(); llllllllllllllllllllIIllIllIIIIl <= llllllllllllllllllllIIllIllIlIII.getY() + 1 + llllllllllllllllllllIIllIllIIlll; ++llllllllllllllllllllIIllIllIIIIl) {
            byte llllllllllllllllllllIIllIllIIIII = 1;
            if (llllllllllllllllllllIIllIllIIIIl == llllllllllllllllllllIIllIllIlIII.getY()) {
                llllllllllllllllllllIIllIllIIIII = 0;
            }
            if (llllllllllllllllllllIIllIllIIIIl >= llllllllllllllllllllIIllIllIlIII.getY() + 1 + llllllllllllllllllllIIllIllIIlll - 2) {
                llllllllllllllllllllIIllIllIIIII = 2;
            }
            for (int llllllllllllllllllllIIllIllIIlIl = llllllllllllllllllllIIllIllIlIII.getX() - llllllllllllllllllllIIllIllIIIII; llllllllllllllllllllIIllIllIIlIl <= llllllllllllllllllllIIllIllIlIII.getX() + llllllllllllllllllllIIllIllIIIII && llllllllllllllllllllIIllIllIIllI; ++llllllllllllllllllllIIllIllIIlIl) {
                for (int llllllllllllllllllllIIllIllIIIll = llllllllllllllllllllIIllIllIlIII.getZ() - llllllllllllllllllllIIllIllIIIII; llllllllllllllllllllIIllIllIIIll <= llllllllllllllllllllIIllIllIlIII.getZ() + llllllllllllllllllllIIllIllIIIII && llllllllllllllllllllIIllIllIIllI; ++llllllllllllllllllllIIllIllIIIll) {
                    if (llllllllllllllllllllIIllIllIIIIl >= 0 && llllllllllllllllllllIIllIllIIIIl < 256) {
                        if (!this.func_150523_a(llllllllllllllllllllIIllIlIIIlll.getBlockState(new BlockPos(llllllllllllllllllllIIllIllIIlIl, llllllllllllllllllllIIllIllIIIIl, llllllllllllllllllllIIllIllIIIll)).getBlock())) {
                            llllllllllllllllllllIIllIllIIllI = false;
                        }
                    }
                    else {
                        llllllllllllllllllllIIllIllIIllI = false;
                    }
                }
            }
        }
        if (!llllllllllllllllllllIIllIllIIllI) {
            return false;
        }
        final Block llllllllllllllllllllIIllIlIlllll = llllllllllllllllllllIIllIlIIIlll.getBlockState(llllllllllllllllllllIIllIllIlIII.offsetDown()).getBlock();
        if ((llllllllllllllllllllIIllIlIlllll == Blocks.grass || llllllllllllllllllllIIllIlIlllll == Blocks.dirt) && llllllllllllllllllllIIllIllIlIII.getY() < 256 - llllllllllllllllllllIIllIllIIlll - 1) {
            this.func_175921_a(llllllllllllllllllllIIllIlIIIlll, llllllllllllllllllllIIllIllIlIII.offsetDown());
            final EnumFacing llllllllllllllllllllIIllIlIllllI = EnumFacing.Plane.HORIZONTAL.random(llllllllllllllllllllIIllIllIlIIl);
            final int llllllllllllllllllllIIllIllIIlII = llllllllllllllllllllIIllIllIIlll - llllllllllllllllllllIIllIllIlIIl.nextInt(4) - 1;
            int llllllllllllllllllllIIllIllIIIlI = 3 - llllllllllllllllllllIIllIllIlIIl.nextInt(3);
            int llllllllllllllllllllIIllIlIlllIl = llllllllllllllllllllIIllIllIlIII.getX();
            int llllllllllllllllllllIIllIlIlllII = llllllllllllllllllllIIllIllIlIII.getZ();
            int llllllllllllllllllllIIllIlIllIll = 0;
            for (int llllllllllllllllllllIIllIlIllIII = 0; llllllllllllllllllllIIllIlIllIII < llllllllllllllllllllIIllIllIIlll; ++llllllllllllllllllllIIllIlIllIII) {
                final int llllllllllllllllllllIIllIlIllIlI = llllllllllllllllllllIIllIllIlIII.getY() + llllllllllllllllllllIIllIlIllIII;
                if (llllllllllllllllllllIIllIlIllIII >= llllllllllllllllllllIIllIllIIlII && llllllllllllllllllllIIllIllIIIlI > 0) {
                    llllllllllllllllllllIIllIlIlllIl += llllllllllllllllllllIIllIlIllllI.getFrontOffsetX();
                    llllllllllllllllllllIIllIlIlllII += llllllllllllllllllllIIllIlIllllI.getFrontOffsetZ();
                    --llllllllllllllllllllIIllIllIIIlI;
                }
                final BlockPos llllllllllllllllllllIIllIlIlIlll = new BlockPos(llllllllllllllllllllIIllIlIlllIl, llllllllllllllllllllIIllIlIllIlI, llllllllllllllllllllIIllIlIlllII);
                final Material llllllllllllllllllllIIllIlIlIllI = llllllllllllllllllllIIllIlIIIlll.getBlockState(llllllllllllllllllllIIllIlIlIlll).getBlock().getMaterial();
                if (llllllllllllllllllllIIllIlIlIllI == Material.air || llllllllllllllllllllIIllIlIlIllI == Material.leaves) {
                    this.func_175905_a(llllllllllllllllllllIIllIlIIIlll, llllllllllllllllllllIIllIlIlIlll, Blocks.log2, BlockPlanks.EnumType.ACACIA.func_176839_a() - 4);
                    llllllllllllllllllllIIllIlIllIll = llllllllllllllllllllIIllIlIllIlI;
                }
            }
            BlockPos llllllllllllllllllllIIllIlIlIlIl = new BlockPos(llllllllllllllllllllIIllIlIlllIl, llllllllllllllllllllIIllIlIllIll, llllllllllllllllllllIIllIlIlllII);
            for (int llllllllllllllllllllIIllIlIllIIl = -3; llllllllllllllllllllIIllIlIllIIl <= 3; ++llllllllllllllllllllIIllIlIllIIl) {
                for (int llllllllllllllllllllIIllIlIlIlII = -3; llllllllllllllllllllIIllIlIlIlII <= 3; ++llllllllllllllllllllIIllIlIlIlII) {
                    if (Math.abs(llllllllllllllllllllIIllIlIllIIl) != 3 || Math.abs(llllllllllllllllllllIIllIlIlIlII) != 3) {
                        this.func_175924_b(llllllllllllllllllllIIllIlIIIlll, llllllllllllllllllllIIllIlIlIlIl.add(llllllllllllllllllllIIllIlIllIIl, 0, llllllllllllllllllllIIllIlIlIlII));
                    }
                }
            }
            llllllllllllllllllllIIllIlIlIlIl = llllllllllllllllllllIIllIlIlIlIl.offsetUp();
            for (int llllllllllllllllllllIIllIlIllIIl = -1; llllllllllllllllllllIIllIlIllIIl <= 1; ++llllllllllllllllllllIIllIlIllIIl) {
                for (int llllllllllllllllllllIIllIlIlIIll = -1; llllllllllllllllllllIIllIlIlIIll <= 1; ++llllllllllllllllllllIIllIlIlIIll) {
                    this.func_175924_b(llllllllllllllllllllIIllIlIIIlll, llllllllllllllllllllIIllIlIlIlIl.add(llllllllllllllllllllIIllIlIllIIl, 0, llllllllllllllllllllIIllIlIlIIll));
                }
            }
            this.func_175924_b(llllllllllllllllllllIIllIlIIIlll, llllllllllllllllllllIIllIlIlIlIl.offsetEast(2));
            this.func_175924_b(llllllllllllllllllllIIllIlIIIlll, llllllllllllllllllllIIllIlIlIlIl.offsetWest(2));
            this.func_175924_b(llllllllllllllllllllIIllIlIIIlll, llllllllllllllllllllIIllIlIlIlIl.offsetSouth(2));
            this.func_175924_b(llllllllllllllllllllIIllIlIIIlll, llllllllllllllllllllIIllIlIlIlIl.offsetNorth(2));
            llllllllllllllllllllIIllIlIlllIl = llllllllllllllllllllIIllIllIlIII.getX();
            llllllllllllllllllllIIllIlIlllII = llllllllllllllllllllIIllIllIlIII.getZ();
            final EnumFacing llllllllllllllllllllIIllIlIlIIIl = EnumFacing.Plane.HORIZONTAL.random(llllllllllllllllllllIIllIllIlIIl);
            if (llllllllllllllllllllIIllIlIlIIIl != llllllllllllllllllllIIllIlIllllI) {
                final int llllllllllllllllllllIIllIlIllIIl = llllllllllllllllllllIIllIllIIlII - llllllllllllllllllllIIllIllIlIIl.nextInt(2) - 1;
                int llllllllllllllllllllIIllIlIlIIlI = 1 + llllllllllllllllllllIIllIllIlIIl.nextInt(3);
                llllllllllllllllllllIIllIlIllIll = 0;
                for (int llllllllllllllllllllIIllIlIIlllI = llllllllllllllllllllIIllIlIllIIl; llllllllllllllllllllIIllIlIIlllI < llllllllllllllllllllIIllIllIIlll && llllllllllllllllllllIIllIlIlIIlI > 0; ++llllllllllllllllllllIIllIlIIlllI, --llllllllllllllllllllIIllIlIlIIlI) {
                    if (llllllllllllllllllllIIllIlIIlllI >= 1) {
                        final int llllllllllllllllllllIIllIlIlIIII = llllllllllllllllllllIIllIllIlIII.getY() + llllllllllllllllllllIIllIlIIlllI;
                        llllllllllllllllllllIIllIlIlllIl += llllllllllllllllllllIIllIlIlIIIl.getFrontOffsetX();
                        llllllllllllllllllllIIllIlIlllII += llllllllllllllllllllIIllIlIlIIIl.getFrontOffsetZ();
                        final BlockPos llllllllllllllllllllIIllIlIIllIl = new BlockPos(llllllllllllllllllllIIllIlIlllIl, llllllllllllllllllllIIllIlIlIIII, llllllllllllllllllllIIllIlIlllII);
                        final Material llllllllllllllllllllIIllIlIIllII = llllllllllllllllllllIIllIlIIIlll.getBlockState(llllllllllllllllllllIIllIlIIllIl).getBlock().getMaterial();
                        if (llllllllllllllllllllIIllIlIIllII == Material.air || llllllllllllllllllllIIllIlIIllII == Material.leaves) {
                            this.func_175905_a(llllllllllllllllllllIIllIlIIIlll, llllllllllllllllllllIIllIlIIllIl, Blocks.log2, BlockPlanks.EnumType.ACACIA.func_176839_a() - 4);
                            llllllllllllllllllllIIllIlIllIll = llllllllllllllllllllIIllIlIlIIII;
                        }
                    }
                }
                if (llllllllllllllllllllIIllIlIllIll > 0) {
                    BlockPos llllllllllllllllllllIIllIlIIlIll = new BlockPos(llllllllllllllllllllIIllIlIlllIl, llllllllllllllllllllIIllIlIllIll, llllllllllllllllllllIIllIlIlllII);
                    for (int llllllllllllllllllllIIllIlIIllll = -2; llllllllllllllllllllIIllIlIIllll <= 2; ++llllllllllllllllllllIIllIlIIllll) {
                        for (int llllllllllllllllllllIIllIlIIlIlI = -2; llllllllllllllllllllIIllIlIIlIlI <= 2; ++llllllllllllllllllllIIllIlIIlIlI) {
                            if (Math.abs(llllllllllllllllllllIIllIlIIllll) != 2 || Math.abs(llllllllllllllllllllIIllIlIIlIlI) != 2) {
                                this.func_175924_b(llllllllllllllllllllIIllIlIIIlll, llllllllllllllllllllIIllIlIIlIll.add(llllllllllllllllllllIIllIlIIllll, 0, llllllllllllllllllllIIllIlIIlIlI));
                            }
                        }
                    }
                    llllllllllllllllllllIIllIlIIlIll = llllllllllllllllllllIIllIlIIlIll.offsetUp();
                    for (int llllllllllllllllllllIIllIlIIllll = -1; llllllllllllllllllllIIllIlIIllll <= 1; ++llllllllllllllllllllIIllIlIIllll) {
                        for (int llllllllllllllllllllIIllIlIIlIIl = -1; llllllllllllllllllllIIllIlIIlIIl <= 1; ++llllllllllllllllllllIIllIlIIlIIl) {
                            this.func_175924_b(llllllllllllllllllllIIllIlIIIlll, llllllllllllllllllllIIllIlIIlIll.add(llllllllllllllllllllIIllIlIIllll, 0, llllllllllllllllllllIIllIlIIlIIl));
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
}
