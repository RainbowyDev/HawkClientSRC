package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.block.*;
import net.minecraft.util.*;

public class WorldGenSwamp extends WorldGenAbstractTree
{
    private void func_175922_a(final World lllllllllllllIlllllllIlIllIIIllI, BlockPos lllllllllllllIlllllllIlIllIIIIII, final int lllllllllllllIlllllllIlIlIllllll) {
        this.func_175905_a(lllllllllllllIlllllllIlIllIIIllI, lllllllllllllIlllllllIlIllIIIIII, Blocks.vine, lllllllllllllIlllllllIlIlIllllll);
        int lllllllllllllIlllllllIlIllIIIIll;
        for (lllllllllllllIlllllllIlIllIIIIll = 4, lllllllllllllIlllllllIlIllIIIIII = lllllllllllllIlllllllIlIllIIIIII.offsetDown(); lllllllllllllIlllllllIlIllIIIllI.getBlockState(lllllllllllllIlllllllIlIllIIIIII).getBlock().getMaterial() == Material.air && lllllllllllllIlllllllIlIllIIIIll > 0; lllllllllllllIlllllllIlIllIIIIII = lllllllllllllIlllllllIlIllIIIIII.offsetDown(), --lllllllllllllIlllllllIlIllIIIIll) {
            this.func_175905_a(lllllllllllllIlllllllIlIllIIIllI, lllllllllllllIlllllllIlIllIIIIII, Blocks.vine, lllllllllllllIlllllllIlIlIllllll);
        }
    }
    
    public WorldGenSwamp() {
        super(false);
    }
    
    @Override
    public boolean generate(final World lllllllllllllIlllllllIlIlllllIlI, final Random lllllllllllllIlllllllIlIllIllIll, BlockPos lllllllllllllIlllllllIlIllIllIlI) {
        final int lllllllllllllIlllllllIlIllllIlll = lllllllllllllIlllllllIlIllIllIll.nextInt(4) + 5;
        while (lllllllllllllIlllllllIlIlllllIlI.getBlockState(((BlockPos)lllllllllllllIlllllllIlIllIllIlI).offsetDown()).getBlock().getMaterial() == Material.water) {
            lllllllllllllIlllllllIlIllIllIlI = (Comparable<Double>)((BlockPos)lllllllllllllIlllllllIlIllIllIlI).offsetDown();
        }
        boolean lllllllllllllIlllllllIlIllllIllI = true;
        if (((Vec3i)lllllllllllllIlllllllIlIllIllIlI).getY() < 1 || ((Vec3i)lllllllllllllIlllllllIlIllIllIlI).getY() + lllllllllllllIlllllllIlIllllIlll + 1 > 256) {
            return false;
        }
        for (int lllllllllllllIlllllllIlIlllIllll = ((Vec3i)lllllllllllllIlllllllIlIllIllIlI).getY(); lllllllllllllIlllllllIlIlllIllll <= ((Vec3i)lllllllllllllIlllllllIlIllIllIlI).getY() + 1 + lllllllllllllIlllllllIlIllllIlll; ++lllllllllllllIlllllllIlIlllIllll) {
            byte lllllllllllllIlllllllIlIlllIlllI = 1;
            if (lllllllllllllIlllllllIlIlllIllll == ((Vec3i)lllllllllllllIlllllllIlIllIllIlI).getY()) {
                lllllllllllllIlllllllIlIlllIlllI = 0;
            }
            if (lllllllllllllIlllllllIlIlllIllll >= ((Vec3i)lllllllllllllIlllllllIlIllIllIlI).getY() + 1 + lllllllllllllIlllllllIlIllllIlll - 2) {
                lllllllllllllIlllllllIlIlllIlllI = 3;
            }
            for (int lllllllllllllIlllllllIlIllllIlIl = ((Vec3i)lllllllllllllIlllllllIlIllIllIlI).getX() - lllllllllllllIlllllllIlIlllIlllI; lllllllllllllIlllllllIlIllllIlIl <= ((Vec3i)lllllllllllllIlllllllIlIllIllIlI).getX() + lllllllllllllIlllllllIlIlllIlllI && lllllllllllllIlllllllIlIllllIllI; ++lllllllllllllIlllllllIlIllllIlIl) {
                for (int lllllllllllllIlllllllIlIllllIIlI = ((Vec3i)lllllllllllllIlllllllIlIllIllIlI).getZ() - lllllllllllllIlllllllIlIlllIlllI; lllllllllllllIlllllllIlIllllIIlI <= ((Vec3i)lllllllllllllIlllllllIlIllIllIlI).getZ() + lllllllllllllIlllllllIlIlllIlllI && lllllllllllllIlllllllIlIllllIllI; ++lllllllllllllIlllllllIlIllllIIlI) {
                    if (lllllllllllllIlllllllIlIlllIllll >= 0 && lllllllllllllIlllllllIlIlllIllll < 256) {
                        final Block lllllllllllllIlllllllIlIlllIllIl = lllllllllllllIlllllllIlIlllllIlI.getBlockState(new BlockPos(lllllllllllllIlllllllIlIllllIlIl, lllllllllllllIlllllllIlIlllIllll, lllllllllllllIlllllllIlIllllIIlI)).getBlock();
                        if (lllllllllllllIlllllllIlIlllIllIl.getMaterial() != Material.air && lllllllllllllIlllllllIlIlllIllIl.getMaterial() != Material.leaves) {
                            if (lllllllllllllIlllllllIlIlllIllIl != Blocks.water && lllllllllllllIlllllllIlIlllIllIl != Blocks.flowing_water) {
                                lllllllllllllIlllllllIlIllllIllI = false;
                            }
                            else if (lllllllllllllIlllllllIlIlllIllll > ((Vec3i)lllllllllllllIlllllllIlIllIllIlI).getY()) {
                                lllllllllllllIlllllllIlIllllIllI = false;
                            }
                        }
                    }
                    else {
                        lllllllllllllIlllllllIlIllllIllI = false;
                    }
                }
            }
        }
        if (!lllllllllllllIlllllllIlIllllIllI) {
            return false;
        }
        final Block lllllllllllllIlllllllIlIlllIllII = lllllllllllllIlllllllIlIlllllIlI.getBlockState(((BlockPos)lllllllllllllIlllllllIlIllIllIlI).offsetDown()).getBlock();
        if ((lllllllllllllIlllllllIlIlllIllII == Blocks.grass || lllllllllllllIlllllllIlIlllIllII == Blocks.dirt) && ((Vec3i)lllllllllllllIlllllllIlIllIllIlI).getY() < 256 - lllllllllllllIlllllllIlIllllIlll - 1) {
            this.func_175921_a(lllllllllllllIlllllllIlIlllllIlI, ((BlockPos)lllllllllllllIlllllllIlIllIllIlI).offsetDown());
            for (int lllllllllllllIlllllllIlIlllIIlll = ((Vec3i)lllllllllllllIlllllllIlIllIllIlI).getY() - 3 + lllllllllllllIlllllllIlIllllIlll; lllllllllllllIlllllllIlIlllIIlll <= ((Vec3i)lllllllllllllIlllllllIlIllIllIlI).getY() + lllllllllllllIlllllllIlIllllIlll; ++lllllllllllllIlllllllIlIlllIIlll) {
                final int lllllllllllllIlllllllIlIllllIlII = lllllllllllllIlllllllIlIlllIIlll - (((Vec3i)lllllllllllllIlllllllIlIllIllIlI).getY() + lllllllllllllIlllllllIlIllllIlll);
                for (int lllllllllllllIlllllllIlIllllIIIl = 2 - lllllllllllllIlllllllIlIllllIlII / 2, lllllllllllllIlllllllIlIlllIIllI = ((Vec3i)lllllllllllllIlllllllIlIllIllIlI).getX() - lllllllllllllIlllllllIlIllllIIIl; lllllllllllllIlllllllIlIlllIIllI <= ((Vec3i)lllllllllllllIlllllllIlIllIllIlI).getX() + lllllllllllllIlllllllIlIllllIIIl; ++lllllllllllllIlllllllIlIlllIIllI) {
                    final int lllllllllllllIlllllllIlIlllIlIll = lllllllllllllIlllllllIlIlllIIllI - ((Vec3i)lllllllllllllIlllllllIlIllIllIlI).getX();
                    for (int lllllllllllllIlllllllIlIlllIIlII = ((Vec3i)lllllllllllllIlllllllIlIllIllIlI).getZ() - lllllllllllllIlllllllIlIllllIIIl; lllllllllllllIlllllllIlIlllIIlII <= ((Vec3i)lllllllllllllIlllllllIlIllIllIlI).getZ() + lllllllllllllIlllllllIlIllllIIIl; ++lllllllllllllIlllllllIlIlllIIlII) {
                        final int lllllllllllllIlllllllIlIlllIIIll = lllllllllllllIlllllllIlIlllIIlII - ((Vec3i)lllllllllllllIlllllllIlIllIllIlI).getZ();
                        if (Math.abs(lllllllllllllIlllllllIlIlllIlIll) != lllllllllllllIlllllllIlIllllIIIl || Math.abs(lllllllllllllIlllllllIlIlllIIIll) != lllllllllllllIlllllllIlIllllIIIl || (lllllllllllllIlllllllIlIllIllIll.nextInt(2) != 0 && lllllllllllllIlllllllIlIllllIlII != 0)) {
                            final BlockPos lllllllllllllIlllllllIlIlllIlIIl = new BlockPos(lllllllllllllIlllllllIlIlllIIllI, lllllllllllllIlllllllIlIlllIIlll, lllllllllllllIlllllllIlIlllIIlII);
                            if (!lllllllllllllIlllllllIlIlllllIlI.getBlockState(lllllllllllllIlllllllIlIlllIlIIl).getBlock().isFullBlock()) {
                                this.func_175906_a(lllllllllllllIlllllllIlIlllllIlI, lllllllllllllIlllllllIlIlllIlIIl, Blocks.leaves);
                            }
                        }
                    }
                }
            }
            for (int lllllllllllllIlllllllIlIlllIIlll = 0; lllllllllllllIlllllllIlIlllIIlll < lllllllllllllIlllllllIlIllllIlll; ++lllllllllllllIlllllllIlIlllIIlll) {
                final Block lllllllllllllIlllllllIlIlllIIIlI = lllllllllllllIlllllllIlIlllllIlI.getBlockState(((BlockPos)lllllllllllllIlllllllIlIllIllIlI).offsetUp(lllllllllllllIlllllllIlIlllIIlll)).getBlock();
                if (lllllllllllllIlllllllIlIlllIIIlI.getMaterial() == Material.air || lllllllllllllIlllllllIlIlllIIIlI.getMaterial() == Material.leaves || lllllllllllllIlllllllIlIlllIIIlI == Blocks.flowing_water || lllllllllllllIlllllllIlIlllIIIlI == Blocks.water) {
                    this.func_175906_a(lllllllllllllIlllllllIlIlllllIlI, ((BlockPos)lllllllllllllIlllllllIlIllIllIlI).offsetUp(lllllllllllllIlllllllIlIlllIIlll), Blocks.log);
                }
            }
            for (int lllllllllllllIlllllllIlIlllIIlll = ((Vec3i)lllllllllllllIlllllllIlIllIllIlI).getY() - 3 + lllllllllllllIlllllllIlIllllIlll; lllllllllllllIlllllllIlIlllIIlll <= ((Vec3i)lllllllllllllIlllllllIlIllIllIlI).getY() + lllllllllllllIlllllllIlIllllIlll; ++lllllllllllllIlllllllIlIlllIIlll) {
                final int lllllllllllllIlllllllIlIllllIIll = lllllllllllllIlllllllIlIlllIIlll - (((Vec3i)lllllllllllllIlllllllIlIllIllIlI).getY() + lllllllllllllIlllllllIlIllllIlll);
                for (int lllllllllllllIlllllllIlIllllIIII = 2 - lllllllllllllIlllllllIlIllllIIll / 2, lllllllllllllIlllllllIlIlllIIlIl = ((Vec3i)lllllllllllllIlllllllIlIllIllIlI).getX() - lllllllllllllIlllllllIlIllllIIII; lllllllllllllIlllllllIlIlllIIlIl <= ((Vec3i)lllllllllllllIlllllllIlIllIllIlI).getX() + lllllllllllllIlllllllIlIllllIIII; ++lllllllllllllIlllllllIlIlllIIlIl) {
                    for (int lllllllllllllIlllllllIlIlllIlIlI = ((Vec3i)lllllllllllllIlllllllIlIllIllIlI).getZ() - lllllllllllllIlllllllIlIllllIIII; lllllllllllllIlllllllIlIlllIlIlI <= ((Vec3i)lllllllllllllIlllllllIlIllIllIlI).getZ() + lllllllllllllIlllllllIlIllllIIII; ++lllllllllllllIlllllllIlIlllIlIlI) {
                        final BlockPos lllllllllllllIlllllllIlIlllIIIIl = new BlockPos(lllllllllllllIlllllllIlIlllIIlIl, lllllllllllllIlllllllIlIlllIIlll, lllllllllllllIlllllllIlIlllIlIlI);
                        if (lllllllllllllIlllllllIlIlllllIlI.getBlockState(lllllllllllllIlllllllIlIlllIIIIl).getBlock().getMaterial() == Material.leaves) {
                            final BlockPos lllllllllllllIlllllllIlIlllIIIII = lllllllllllllIlllllllIlIlllIIIIl.offsetWest();
                            final BlockPos lllllllllllllIlllllllIlIlllIlIII = lllllllllllllIlllllllIlIlllIIIIl.offsetEast();
                            final BlockPos lllllllllllllIlllllllIlIllIlllll = lllllllllllllIlllllllIlIlllIIIIl.offsetNorth();
                            final BlockPos lllllllllllllIlllllllIlIllIllllI = lllllllllllllIlllllllIlIlllIIIIl.offsetSouth();
                            if (lllllllllllllIlllllllIlIllIllIll.nextInt(4) == 0 && lllllllllllllIlllllllIlIlllllIlI.getBlockState(lllllllllllllIlllllllIlIlllIIIII).getBlock().getMaterial() == Material.air) {
                                this.func_175922_a(lllllllllllllIlllllllIlIlllllIlI, lllllllllllllIlllllllIlIlllIIIII, BlockVine.field_176275_S);
                            }
                            if (lllllllllllllIlllllllIlIllIllIll.nextInt(4) == 0 && lllllllllllllIlllllllIlIlllllIlI.getBlockState(lllllllllllllIlllllllIlIlllIlIII).getBlock().getMaterial() == Material.air) {
                                this.func_175922_a(lllllllllllllIlllllllIlIlllllIlI, lllllllllllllIlllllllIlIlllIlIII, BlockVine.field_176271_T);
                            }
                            if (lllllllllllllIlllllllIlIllIllIll.nextInt(4) == 0 && lllllllllllllIlllllllIlIlllllIlI.getBlockState(lllllllllllllIlllllllIlIllIlllll).getBlock().getMaterial() == Material.air) {
                                this.func_175922_a(lllllllllllllIlllllllIlIlllllIlI, lllllllllllllIlllllllIlIllIlllll, BlockVine.field_176272_Q);
                            }
                            if (lllllllllllllIlllllllIlIllIllIll.nextInt(4) == 0 && lllllllllllllIlllllllIlIlllllIlI.getBlockState(lllllllllllllIlllllllIlIllIllllI).getBlock().getMaterial() == Material.air) {
                                this.func_175922_a(lllllllllllllIlllllllIlIlllllIlI, lllllllllllllIlllllllIlIllIllllI, BlockVine.field_176276_R);
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    static {
        __OBFID = "CL_00000436";
    }
}
