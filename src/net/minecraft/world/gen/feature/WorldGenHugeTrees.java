package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.block.*;

public abstract class WorldGenHugeTrees extends WorldGenAbstractTree
{
    protected final /* synthetic */ int woodMetadata;
    protected final /* synthetic */ int leavesMetadata;
    protected final /* synthetic */ int baseHeight;
    protected /* synthetic */ int field_150538_d;
    
    protected boolean func_175929_a(final World lllllllllllllllIIlIIIIIlllllIIIl, final Random lllllllllllllllIIlIIIIIlllllIlIl, final BlockPos lllllllllllllllIIlIIIIIlllllIIII, final int lllllllllllllllIIlIIIIIllllIllll) {
        return this.func_175926_c(lllllllllllllllIIlIIIIIlllllIIIl, lllllllllllllllIIlIIIIIlllllIIII, lllllllllllllllIIlIIIIIllllIllll) && this.func_175927_a(lllllllllllllllIIlIIIIIlllllIIII, lllllllllllllllIIlIIIIIlllllIIIl);
    }
    
    protected void func_175925_a(final World lllllllllllllllIIlIIIIIllllIIIlI, final BlockPos lllllllllllllllIIlIIIIIllllIIIIl, final int lllllllllllllllIIlIIIIIllllIIIII) {
        final int lllllllllllllllIIlIIIIIlllIlllll = lllllllllllllllIIlIIIIIllllIIIII * lllllllllllllllIIlIIIIIllllIIIII;
        for (int lllllllllllllllIIlIIIIIlllIllllI = -lllllllllllllllIIlIIIIIllllIIIII; lllllllllllllllIIlIIIIIlllIllllI <= lllllllllllllllIIlIIIIIllllIIIII + 1; ++lllllllllllllllIIlIIIIIlllIllllI) {
            for (int lllllllllllllllIIlIIIIIlllIlllIl = -lllllllllllllllIIlIIIIIllllIIIII; lllllllllllllllIIlIIIIIlllIlllIl <= lllllllllllllllIIlIIIIIllllIIIII + 1; ++lllllllllllllllIIlIIIIIlllIlllIl) {
                final int lllllllllllllllIIlIIIIIlllIlllII = lllllllllllllllIIlIIIIIlllIllllI - 1;
                final int lllllllllllllllIIlIIIIIlllIllIll = lllllllllllllllIIlIIIIIlllIlllIl - 1;
                if (lllllllllllllllIIlIIIIIlllIllllI * lllllllllllllllIIlIIIIIlllIllllI + lllllllllllllllIIlIIIIIlllIlllIl * lllllllllllllllIIlIIIIIlllIlllIl <= lllllllllllllllIIlIIIIIlllIlllll || lllllllllllllllIIlIIIIIlllIlllII * lllllllllllllllIIlIIIIIlllIlllII + lllllllllllllllIIlIIIIIlllIllIll * lllllllllllllllIIlIIIIIlllIllIll <= lllllllllllllllIIlIIIIIlllIlllll || lllllllllllllllIIlIIIIIlllIllllI * lllllllllllllllIIlIIIIIlllIllllI + lllllllllllllllIIlIIIIIlllIllIll * lllllllllllllllIIlIIIIIlllIllIll <= lllllllllllllllIIlIIIIIlllIlllll || lllllllllllllllIIlIIIIIlllIlllII * lllllllllllllllIIlIIIIIlllIlllII + lllllllllllllllIIlIIIIIlllIlllIl * lllllllllllllllIIlIIIIIlllIlllIl <= lllllllllllllllIIlIIIIIlllIlllll) {
                    final BlockPos lllllllllllllllIIlIIIIIlllIllIlI = lllllllllllllllIIlIIIIIllllIIIIl.add(lllllllllllllllIIlIIIIIlllIllllI, 0, lllllllllllllllIIlIIIIIlllIlllIl);
                    final Material lllllllllllllllIIlIIIIIlllIllIIl = lllllllllllllllIIlIIIIIllllIIIlI.getBlockState(lllllllllllllllIIlIIIIIlllIllIlI).getBlock().getMaterial();
                    if (lllllllllllllllIIlIIIIIlllIllIIl == Material.air || lllllllllllllllIIlIIIIIlllIllIIl == Material.leaves) {
                        this.func_175905_a(lllllllllllllllIIlIIIIIllllIIIlI, lllllllllllllllIIlIIIIIlllIllIlI, Blocks.leaves, this.leavesMetadata);
                    }
                }
            }
        }
    }
    
    public WorldGenHugeTrees(final boolean lllllllllllllllIIlIIIIlIIIlllIIl, final int lllllllllllllllIIlIIIIlIIIlllIII, final int lllllllllllllllIIlIIIIlIIIllIIIl, final int lllllllllllllllIIlIIIIlIIIllIllI, final int lllllllllllllllIIlIIIIlIIIllIlIl) {
        super(lllllllllllllllIIlIIIIlIIIlllIIl);
        this.baseHeight = lllllllllllllllIIlIIIIlIIIlllIII;
        this.field_150538_d = lllllllllllllllIIlIIIIlIIIllIIIl;
        this.woodMetadata = lllllllllllllllIIlIIIIlIIIllIllI;
        this.leavesMetadata = lllllllllllllllIIlIIIIlIIIllIlIl;
    }
    
    static {
        __OBFID = "CL_00000423";
    }
    
    private boolean func_175927_a(final BlockPos lllllllllllllllIIlIIIIIlllllllll, final World lllllllllllllllIIlIIIIIllllllllI) {
        final BlockPos lllllllllllllllIIlIIIIlIIIIIIIlI = lllllllllllllllIIlIIIIIlllllllll.offsetDown();
        final Block lllllllllllllllIIlIIIIlIIIIIIIIl = lllllllllllllllIIlIIIIIllllllllI.getBlockState(lllllllllllllllIIlIIIIlIIIIIIIlI).getBlock();
        if ((lllllllllllllllIIlIIIIlIIIIIIIIl == Blocks.grass || lllllllllllllllIIlIIIIlIIIIIIIIl == Blocks.dirt) && lllllllllllllllIIlIIIIIlllllllll.getY() >= 2) {
            this.func_175921_a(lllllllllllllllIIlIIIIIllllllllI, lllllllllllllllIIlIIIIlIIIIIIIlI);
            this.func_175921_a(lllllllllllllllIIlIIIIIllllllllI, lllllllllllllllIIlIIIIlIIIIIIIlI.offsetEast());
            this.func_175921_a(lllllllllllllllIIlIIIIIllllllllI, lllllllllllllllIIlIIIIlIIIIIIIlI.offsetSouth());
            this.func_175921_a(lllllllllllllllIIlIIIIIllllllllI, lllllllllllllllIIlIIIIlIIIIIIIlI.offsetSouth().offsetEast());
            return true;
        }
        return false;
    }
    
    protected int func_150533_a(final Random lllllllllllllllIIlIIIIlIIIlIIlll) {
        int lllllllllllllllIIlIIIIlIIIlIlIIl = lllllllllllllllIIlIIIIlIIIlIIlll.nextInt(3) + this.baseHeight;
        if (this.field_150538_d > 1) {
            lllllllllllllllIIlIIIIlIIIlIlIIl += lllllllllllllllIIlIIIIlIIIlIIlll.nextInt(this.field_150538_d);
        }
        return lllllllllllllllIIlIIIIlIIIlIlIIl;
    }
    
    protected void func_175928_b(final World lllllllllllllllIIlIIIIIllIlllIlI, final BlockPos lllllllllllllllIIlIIIIIlllIIIIlI, final int lllllllllllllllIIlIIIIIllIlllIII) {
        final int lllllllllllllllIIlIIIIIlllIIIIII = lllllllllllllllIIlIIIIIllIlllIII * lllllllllllllllIIlIIIIIllIlllIII;
        for (int lllllllllllllllIIlIIIIIllIllllll = -lllllllllllllllIIlIIIIIllIlllIII; lllllllllllllllIIlIIIIIllIllllll <= lllllllllllllllIIlIIIIIllIlllIII; ++lllllllllllllllIIlIIIIIllIllllll) {
            for (int lllllllllllllllIIlIIIIIllIlllllI = -lllllllllllllllIIlIIIIIllIlllIII; lllllllllllllllIIlIIIIIllIlllllI <= lllllllllllllllIIlIIIIIllIlllIII; ++lllllllllllllllIIlIIIIIllIlllllI) {
                if (lllllllllllllllIIlIIIIIllIllllll * lllllllllllllllIIlIIIIIllIllllll + lllllllllllllllIIlIIIIIllIlllllI * lllllllllllllllIIlIIIIIllIlllllI <= lllllllllllllllIIlIIIIIlllIIIIII) {
                    final BlockPos lllllllllllllllIIlIIIIIllIllllIl = lllllllllllllllIIlIIIIIlllIIIIlI.add(lllllllllllllllIIlIIIIIllIllllll, 0, lllllllllllllllIIlIIIIIllIlllllI);
                    final Material lllllllllllllllIIlIIIIIllIllllII = lllllllllllllllIIlIIIIIllIlllIlI.getBlockState(lllllllllllllllIIlIIIIIllIllllIl).getBlock().getMaterial();
                    if (lllllllllllllllIIlIIIIIllIllllII == Material.air || lllllllllllllllIIlIIIIIllIllllII == Material.leaves) {
                        this.func_175905_a(lllllllllllllllIIlIIIIIllIlllIlI, lllllllllllllllIIlIIIIIllIllllIl, Blocks.leaves, this.leavesMetadata);
                    }
                }
            }
        }
    }
    
    private boolean func_175926_c(final World lllllllllllllllIIlIIIIlIIIIllIll, final BlockPos lllllllllllllllIIlIIIIlIIIIllIlI, final int lllllllllllllllIIlIIIIlIIIIlIIII) {
        boolean lllllllllllllllIIlIIIIlIIIIllIII = true;
        if (lllllllllllllllIIlIIIIlIIIIllIlI.getY() >= 1 && lllllllllllllllIIlIIIIlIIIIllIlI.getY() + lllllllllllllllIIlIIIIlIIIIlIIII + 1 <= 256) {
            for (int lllllllllllllllIIlIIIIlIIIIlIlll = 0; lllllllllllllllIIlIIIIlIIIIlIlll <= 1 + lllllllllllllllIIlIIIIlIIIIlIIII; ++lllllllllllllllIIlIIIIlIIIIlIlll) {
                byte lllllllllllllllIIlIIIIlIIIIlIllI = 2;
                if (lllllllllllllllIIlIIIIlIIIIlIlll == 0) {
                    lllllllllllllllIIlIIIIlIIIIlIllI = 1;
                }
                else if (lllllllllllllllIIlIIIIlIIIIlIlll >= 1 + lllllllllllllllIIlIIIIlIIIIlIIII - 2) {
                    lllllllllllllllIIlIIIIlIIIIlIllI = 2;
                }
                for (int lllllllllllllllIIlIIIIlIIIIlIlIl = -lllllllllllllllIIlIIIIlIIIIlIllI; lllllllllllllllIIlIIIIlIIIIlIlIl <= lllllllllllllllIIlIIIIlIIIIlIllI && lllllllllllllllIIlIIIIlIIIIllIII; ++lllllllllllllllIIlIIIIlIIIIlIlIl) {
                    for (int lllllllllllllllIIlIIIIlIIIIlIlII = -lllllllllllllllIIlIIIIlIIIIlIllI; lllllllllllllllIIlIIIIlIIIIlIlII <= lllllllllllllllIIlIIIIlIIIIlIllI && lllllllllllllllIIlIIIIlIIIIllIII; ++lllllllllllllllIIlIIIIlIIIIlIlII) {
                        if (lllllllllllllllIIlIIIIlIIIIllIlI.getY() + lllllllllllllllIIlIIIIlIIIIlIlll < 0 || lllllllllllllllIIlIIIIlIIIIllIlI.getY() + lllllllllllllllIIlIIIIlIIIIlIlll >= 256 || !this.func_150523_a(lllllllllllllllIIlIIIIlIIIIllIll.getBlockState(lllllllllllllllIIlIIIIlIIIIllIlI.add(lllllllllllllllIIlIIIIlIIIIlIlIl, lllllllllllllllIIlIIIIlIIIIlIlll, lllllllllllllllIIlIIIIlIIIIlIlII)).getBlock())) {
                            lllllllllllllllIIlIIIIlIIIIllIII = false;
                        }
                    }
                }
            }
            return lllllllllllllllIIlIIIIlIIIIllIII;
        }
        return false;
    }
}
