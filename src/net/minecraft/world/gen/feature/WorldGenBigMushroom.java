package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.block.*;

public class WorldGenBigMushroom extends WorldGenerator
{
    private /* synthetic */ int mushroomType;
    
    public WorldGenBigMushroom() {
        super(false);
        this.mushroomType = -1;
    }
    
    static {
        __OBFID = "CL_00000415";
    }
    
    public WorldGenBigMushroom(final int lllllllllllllllIIlIlllIIllIIIlIl) {
        super(true);
        this.mushroomType = -1;
        this.mushroomType = lllllllllllllllIIlIlllIIllIIIlIl;
    }
    
    @Override
    public boolean generate(final World lllllllllllllllIIlIlllIIlIIllIlI, final Random lllllllllllllllIIlIlllIIlIIllIIl, final BlockPos lllllllllllllllIIlIlllIIlIIllIII) {
        int lllllllllllllllIIlIlllIIlIlIllII = lllllllllllllllIIlIlllIIlIIllIIl.nextInt(2);
        if (this.mushroomType >= 0) {
            lllllllllllllllIIlIlllIIlIlIllII = this.mushroomType;
        }
        final int lllllllllllllllIIlIlllIIlIlIlIll = lllllllllllllllIIlIlllIIlIIllIIl.nextInt(3) + 4;
        boolean lllllllllllllllIIlIlllIIlIlIlIlI = true;
        if (lllllllllllllllIIlIlllIIlIIllIII.getY() < 1 || lllllllllllllllIIlIlllIIlIIllIII.getY() + lllllllllllllllIIlIlllIIlIlIlIll + 1 >= 256) {
            return false;
        }
        for (int lllllllllllllllIIlIlllIIlIlIIlIl = lllllllllllllllIIlIlllIIlIIllIII.getY(); lllllllllllllllIIlIlllIIlIlIIlIl <= lllllllllllllllIIlIlllIIlIIllIII.getY() + 1 + lllllllllllllllIIlIlllIIlIlIlIll; ++lllllllllllllllIIlIlllIIlIlIIlIl) {
            byte lllllllllllllllIIlIlllIIlIlIIlII = 3;
            if (lllllllllllllllIIlIlllIIlIlIIlIl <= lllllllllllllllIIlIlllIIlIIllIII.getY() + 3) {
                lllllllllllllllIIlIlllIIlIlIIlII = 0;
            }
            for (int lllllllllllllllIIlIlllIIlIlIlIIl = lllllllllllllllIIlIlllIIlIIllIII.getX() - lllllllllllllllIIlIlllIIlIlIIlII; lllllllllllllllIIlIlllIIlIlIlIIl <= lllllllllllllllIIlIlllIIlIIllIII.getX() + lllllllllllllllIIlIlllIIlIlIIlII && lllllllllllllllIIlIlllIIlIlIlIlI; ++lllllllllllllllIIlIlllIIlIlIlIIl) {
                for (int lllllllllllllllIIlIlllIIlIlIIlll = lllllllllllllllIIlIlllIIlIIllIII.getZ() - lllllllllllllllIIlIlllIIlIlIIlII; lllllllllllllllIIlIlllIIlIlIIlll <= lllllllllllllllIIlIlllIIlIIllIII.getZ() + lllllllllllllllIIlIlllIIlIlIIlII && lllllllllllllllIIlIlllIIlIlIlIlI; ++lllllllllllllllIIlIlllIIlIlIIlll) {
                    if (lllllllllllllllIIlIlllIIlIlIIlIl >= 0 && lllllllllllllllIIlIlllIIlIlIIlIl < 256) {
                        final Block lllllllllllllllIIlIlllIIlIlIIIll = lllllllllllllllIIlIlllIIlIIllIlI.getBlockState(new BlockPos(lllllllllllllllIIlIlllIIlIlIlIIl, lllllllllllllllIIlIlllIIlIlIIlIl, lllllllllllllllIIlIlllIIlIlIIlll)).getBlock();
                        if (lllllllllllllllIIlIlllIIlIlIIIll.getMaterial() != Material.air && lllllllllllllllIIlIlllIIlIlIIIll.getMaterial() != Material.leaves) {
                            lllllllllllllllIIlIlllIIlIlIlIlI = false;
                        }
                    }
                    else {
                        lllllllllllllllIIlIlllIIlIlIlIlI = false;
                    }
                }
            }
        }
        if (!lllllllllllllllIIlIlllIIlIlIlIlI) {
            return false;
        }
        final Block lllllllllllllllIIlIlllIIlIlIIIlI = lllllllllllllllIIlIlllIIlIIllIlI.getBlockState(lllllllllllllllIIlIlllIIlIIllIII.offsetDown()).getBlock();
        if (lllllllllllllllIIlIlllIIlIlIIIlI != Blocks.dirt && lllllllllllllllIIlIlllIIlIlIIIlI != Blocks.grass && lllllllllllllllIIlIlllIIlIlIIIlI != Blocks.mycelium) {
            return false;
        }
        int lllllllllllllllIIlIlllIIlIlIIIIl = lllllllllllllllIIlIlllIIlIIllIII.getY() + lllllllllllllllIIlIlllIIlIlIlIll;
        if (lllllllllllllllIIlIlllIIlIlIllII == 1) {
            lllllllllllllllIIlIlllIIlIlIIIIl = lllllllllllllllIIlIlllIIlIIllIII.getY() + lllllllllllllllIIlIlllIIlIlIlIll - 3;
        }
        for (int lllllllllllllllIIlIlllIIlIlIlIII = lllllllllllllllIIlIlllIIlIlIIIIl; lllllllllllllllIIlIlllIIlIlIlIII <= lllllllllllllllIIlIlllIIlIIllIII.getY() + lllllllllllllllIIlIlllIIlIlIlIll; ++lllllllllllllllIIlIlllIIlIlIlIII) {
            int lllllllllllllllIIlIlllIIlIlIIllI = 1;
            if (lllllllllllllllIIlIlllIIlIlIlIII < lllllllllllllllIIlIlllIIlIIllIII.getY() + lllllllllllllllIIlIlllIIlIlIlIll) {
                ++lllllllllllllllIIlIlllIIlIlIIllI;
            }
            if (lllllllllllllllIIlIlllIIlIlIllII == 0) {
                lllllllllllllllIIlIlllIIlIlIIllI = 3;
            }
            for (int lllllllllllllllIIlIlllIIlIlIIIII = lllllllllllllllIIlIlllIIlIIllIII.getX() - lllllllllllllllIIlIlllIIlIlIIllI; lllllllllllllllIIlIlllIIlIlIIIII <= lllllllllllllllIIlIlllIIlIIllIII.getX() + lllllllllllllllIIlIlllIIlIlIIllI; ++lllllllllllllllIIlIlllIIlIlIIIII) {
                for (int lllllllllllllllIIlIlllIIlIIlllll = lllllllllllllllIIlIlllIIlIIllIII.getZ() - lllllllllllllllIIlIlllIIlIlIIllI; lllllllllllllllIIlIlllIIlIIlllll <= lllllllllllllllIIlIlllIIlIIllIII.getZ() + lllllllllllllllIIlIlllIIlIlIIllI; ++lllllllllllllllIIlIlllIIlIIlllll) {
                    int lllllllllllllllIIlIlllIIlIIllllI = 5;
                    if (lllllllllllllllIIlIlllIIlIlIIIII == lllllllllllllllIIlIlllIIlIIllIII.getX() - lllllllllllllllIIlIlllIIlIlIIllI) {
                        --lllllllllllllllIIlIlllIIlIIllllI;
                    }
                    if (lllllllllllllllIIlIlllIIlIlIIIII == lllllllllllllllIIlIlllIIlIIllIII.getX() + lllllllllllllllIIlIlllIIlIlIIllI) {
                        ++lllllllllllllllIIlIlllIIlIIllllI;
                    }
                    if (lllllllllllllllIIlIlllIIlIIlllll == lllllllllllllllIIlIlllIIlIIllIII.getZ() - lllllllllllllllIIlIlllIIlIlIIllI) {
                        lllllllllllllllIIlIlllIIlIIllllI -= 3;
                    }
                    if (lllllllllllllllIIlIlllIIlIIlllll == lllllllllllllllIIlIlllIIlIIllIII.getZ() + lllllllllllllllIIlIlllIIlIlIIllI) {
                        lllllllllllllllIIlIlllIIlIIllllI += 3;
                    }
                    if (lllllllllllllllIIlIlllIIlIlIllII == 0 || lllllllllllllllIIlIlllIIlIlIlIII < lllllllllllllllIIlIlllIIlIIllIII.getY() + lllllllllllllllIIlIlllIIlIlIlIll) {
                        if (lllllllllllllllIIlIlllIIlIlIIIII == lllllllllllllllIIlIlllIIlIIllIII.getX() - lllllllllllllllIIlIlllIIlIlIIllI || lllllllllllllllIIlIlllIIlIlIIIII == lllllllllllllllIIlIlllIIlIIllIII.getX() + lllllllllllllllIIlIlllIIlIlIIllI) {
                            if (lllllllllllllllIIlIlllIIlIIlllll == lllllllllllllllIIlIlllIIlIIllIII.getZ() - lllllllllllllllIIlIlllIIlIlIIllI) {
                                continue;
                            }
                            if (lllllllllllllllIIlIlllIIlIIlllll == lllllllllllllllIIlIlllIIlIIllIII.getZ() + lllllllllllllllIIlIlllIIlIlIIllI) {
                                continue;
                            }
                        }
                        if (lllllllllllllllIIlIlllIIlIlIIIII == lllllllllllllllIIlIlllIIlIIllIII.getX() - (lllllllllllllllIIlIlllIIlIlIIllI - 1) && lllllllllllllllIIlIlllIIlIIlllll == lllllllllllllllIIlIlllIIlIIllIII.getZ() - lllllllllllllllIIlIlllIIlIlIIllI) {
                            lllllllllllllllIIlIlllIIlIIllllI = 1;
                        }
                        if (lllllllllllllllIIlIlllIIlIlIIIII == lllllllllllllllIIlIlllIIlIIllIII.getX() - lllllllllllllllIIlIlllIIlIlIIllI && lllllllllllllllIIlIlllIIlIIlllll == lllllllllllllllIIlIlllIIlIIllIII.getZ() - (lllllllllllllllIIlIlllIIlIlIIllI - 1)) {
                            lllllllllllllllIIlIlllIIlIIllllI = 1;
                        }
                        if (lllllllllllllllIIlIlllIIlIlIIIII == lllllllllllllllIIlIlllIIlIIllIII.getX() + (lllllllllllllllIIlIlllIIlIlIIllI - 1) && lllllllllllllllIIlIlllIIlIIlllll == lllllllllllllllIIlIlllIIlIIllIII.getZ() - lllllllllllllllIIlIlllIIlIlIIllI) {
                            lllllllllllllllIIlIlllIIlIIllllI = 3;
                        }
                        if (lllllllllllllllIIlIlllIIlIlIIIII == lllllllllllllllIIlIlllIIlIIllIII.getX() + lllllllllllllllIIlIlllIIlIlIIllI && lllllllllllllllIIlIlllIIlIIlllll == lllllllllllllllIIlIlllIIlIIllIII.getZ() - (lllllllllllllllIIlIlllIIlIlIIllI - 1)) {
                            lllllllllllllllIIlIlllIIlIIllllI = 3;
                        }
                        if (lllllllllllllllIIlIlllIIlIlIIIII == lllllllllllllllIIlIlllIIlIIllIII.getX() - (lllllllllllllllIIlIlllIIlIlIIllI - 1) && lllllllllllllllIIlIlllIIlIIlllll == lllllllllllllllIIlIlllIIlIIllIII.getZ() + lllllllllllllllIIlIlllIIlIlIIllI) {
                            lllllllllllllllIIlIlllIIlIIllllI = 7;
                        }
                        if (lllllllllllllllIIlIlllIIlIlIIIII == lllllllllllllllIIlIlllIIlIIllIII.getX() - lllllllllllllllIIlIlllIIlIlIIllI && lllllllllllllllIIlIlllIIlIIlllll == lllllllllllllllIIlIlllIIlIIllIII.getZ() + (lllllllllllllllIIlIlllIIlIlIIllI - 1)) {
                            lllllllllllllllIIlIlllIIlIIllllI = 7;
                        }
                        if (lllllllllllllllIIlIlllIIlIlIIIII == lllllllllllllllIIlIlllIIlIIllIII.getX() + (lllllllllllllllIIlIlllIIlIlIIllI - 1) && lllllllllllllllIIlIlllIIlIIlllll == lllllllllllllllIIlIlllIIlIIllIII.getZ() + lllllllllllllllIIlIlllIIlIlIIllI) {
                            lllllllllllllllIIlIlllIIlIIllllI = 9;
                        }
                        if (lllllllllllllllIIlIlllIIlIlIIIII == lllllllllllllllIIlIlllIIlIIllIII.getX() + lllllllllllllllIIlIlllIIlIlIIllI && lllllllllllllllIIlIlllIIlIIlllll == lllllllllllllllIIlIlllIIlIIllIII.getZ() + (lllllllllllllllIIlIlllIIlIlIIllI - 1)) {
                            lllllllllllllllIIlIlllIIlIIllllI = 9;
                        }
                    }
                    if (lllllllllllllllIIlIlllIIlIIllllI == 5 && lllllllllllllllIIlIlllIIlIlIlIII < lllllllllllllllIIlIlllIIlIIllIII.getY() + lllllllllllllllIIlIlllIIlIlIlIll) {
                        lllllllllllllllIIlIlllIIlIIllllI = 0;
                    }
                    if (lllllllllllllllIIlIlllIIlIIllllI != 0 || lllllllllllllllIIlIlllIIlIIllIII.getY() >= lllllllllllllllIIlIlllIIlIIllIII.getY() + lllllllllllllllIIlIlllIIlIlIlIll - 1) {
                        final BlockPos lllllllllllllllIIlIlllIIlIIlllIl = new BlockPos(lllllllllllllllIIlIlllIIlIlIIIII, lllllllllllllllIIlIlllIIlIlIlIII, lllllllllllllllIIlIlllIIlIIlllll);
                        if (!lllllllllllllllIIlIlllIIlIIllIlI.getBlockState(lllllllllllllllIIlIlllIIlIIlllIl).getBlock().isFullBlock()) {
                            this.func_175905_a(lllllllllllllllIIlIlllIIlIIllIlI, lllllllllllllllIIlIlllIIlIIlllIl, Block.getBlockById(Block.getIdFromBlock(Blocks.brown_mushroom_block) + lllllllllllllllIIlIlllIIlIlIllII), lllllllllllllllIIlIlllIIlIIllllI);
                        }
                    }
                }
            }
        }
        for (int lllllllllllllllIIlIlllIIlIlIlIII = 0; lllllllllllllllIIlIlllIIlIlIlIII < lllllllllllllllIIlIlllIIlIlIlIll; ++lllllllllllllllIIlIlllIIlIlIlIII) {
            final Block lllllllllllllllIIlIlllIIlIIlllII = lllllllllllllllIIlIlllIIlIIllIlI.getBlockState(lllllllllllllllIIlIlllIIlIIllIII.offsetUp(lllllllllllllllIIlIlllIIlIlIlIII)).getBlock();
            if (!lllllllllllllllIIlIlllIIlIIlllII.isFullBlock()) {
                this.func_175905_a(lllllllllllllllIIlIlllIIlIIllIlI, lllllllllllllllIIlIlllIIlIIllIII.offsetUp(lllllllllllllllIIlIlllIIlIlIlIII), Block.getBlockById(Block.getIdFromBlock(Blocks.brown_mushroom_block) + lllllllllllllllIIlIlllIIlIlIllII), 10);
            }
        }
        return true;
    }
}
