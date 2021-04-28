package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.block.*;

public class WorldGenMegaPineTree extends WorldGenHugeTrees
{
    private /* synthetic */ boolean field_150542_e;
    
    public WorldGenMegaPineTree(final boolean lllllllllllllllllIIIIlIIlIllIIIl, final boolean lllllllllllllllllIIIIlIIlIllIIll) {
        super(lllllllllllllllllIIIIlIIlIllIIIl, 13, 15, BlockPlanks.EnumType.SPRUCE.func_176839_a(), BlockPlanks.EnumType.SPRUCE.func_176839_a());
        this.field_150542_e = lllllllllllllllllIIIIlIIlIllIIll;
    }
    
    private void func_175933_b(final World lllllllllllllllllIIIIlIIIlIlIIll, final BlockPos lllllllllllllllllIIIIlIIIlIlIlll) {
        for (int lllllllllllllllllIIIIlIIIlIlIllI = -2; lllllllllllllllllIIIIlIIIlIlIllI <= 2; ++lllllllllllllllllIIIIlIIIlIlIllI) {
            for (int lllllllllllllllllIIIIlIIIlIlIlIl = -2; lllllllllllllllllIIIIlIIIlIlIlIl <= 2; ++lllllllllllllllllIIIIlIIIlIlIlIl) {
                if (Math.abs(lllllllllllllllllIIIIlIIIlIlIllI) != 2 || Math.abs(lllllllllllllllllIIIIlIIIlIlIlIl) != 2) {
                    this.func_175934_c(lllllllllllllllllIIIIlIIIlIlIIll, lllllllllllllllllIIIIlIIIlIlIlll.add(lllllllllllllllllIIIIlIIIlIlIllI, 0, lllllllllllllllllIIIIlIIIlIlIlIl));
                }
            }
        }
    }
    
    private void func_150541_c(final World lllllllllllllllllIIIIlIIlIIIIIIl, final int lllllllllllllllllIIIIlIIlIIIIIII, final int lllllllllllllllllIIIIlIIIlllllll, final int lllllllllllllllllIIIIlIIlIIIlIlI, final int lllllllllllllllllIIIIlIIIlllllIl, final Random lllllllllllllllllIIIIlIIlIIIlIII) {
        final int lllllllllllllllllIIIIlIIlIIIIlll = lllllllllllllllllIIIIlIIlIIIlIII.nextInt(5) + (this.field_150542_e ? this.baseHeight : 3);
        int lllllllllllllllllIIIIlIIlIIIIllI = 0;
        for (int lllllllllllllllllIIIIlIIlIIIIlIl = lllllllllllllllllIIIIlIIlIIIlIlI - lllllllllllllllllIIIIlIIlIIIIlll; lllllllllllllllllIIIIlIIlIIIIlIl <= lllllllllllllllllIIIIlIIlIIIlIlI; ++lllllllllllllllllIIIIlIIlIIIIlIl) {
            final int lllllllllllllllllIIIIlIIlIIIIlII = lllllllllllllllllIIIIlIIlIIIlIlI - lllllllllllllllllIIIIlIIlIIIIlIl;
            final int lllllllllllllllllIIIIlIIlIIIIIll = lllllllllllllllllIIIIlIIIlllllIl + MathHelper.floor_float(lllllllllllllllllIIIIlIIlIIIIlII / (float)lllllllllllllllllIIIIlIIlIIIIlll * 3.5f);
            this.func_175925_a(lllllllllllllllllIIIIlIIlIIIIIIl, new BlockPos(lllllllllllllllllIIIIlIIlIIIIIII, lllllllllllllllllIIIIlIIlIIIIlIl, lllllllllllllllllIIIIlIIIlllllll), lllllllllllllllllIIIIlIIlIIIIIll + ((lllllllllllllllllIIIIlIIlIIIIlII > 0 && lllllllllllllllllIIIIlIIlIIIIIll == lllllllllllllllllIIIIlIIlIIIIllI && (lllllllllllllllllIIIIlIIlIIIIlIl & 0x1) == 0x0) ? 1 : 0));
            lllllllllllllllllIIIIlIIlIIIIllI = lllllllllllllllllIIIIlIIlIIIIIll;
        }
    }
    
    @Override
    public boolean generate(final World lllllllllllllllllIIIIlIIlIlIIIII, final Random lllllllllllllllllIIIIlIIlIIlllll, final BlockPos lllllllllllllllllIIIIlIIlIIllllI) {
        final int lllllllllllllllllIIIIlIIlIlIIlII = this.func_150533_a(lllllllllllllllllIIIIlIIlIIlllll);
        if (!this.func_175929_a(lllllllllllllllllIIIIlIIlIlIIIII, lllllllllllllllllIIIIlIIlIIlllll, lllllllllllllllllIIIIlIIlIIllllI, lllllllllllllllllIIIIlIIlIlIIlII)) {
            return false;
        }
        this.func_150541_c(lllllllllllllllllIIIIlIIlIlIIIII, lllllllllllllllllIIIIlIIlIIllllI.getX(), lllllllllllllllllIIIIlIIlIIllllI.getZ(), lllllllllllllllllIIIIlIIlIIllllI.getY() + lllllllllllllllllIIIIlIIlIlIIlII, 0, lllllllllllllllllIIIIlIIlIIlllll);
        for (int lllllllllllllllllIIIIlIIlIlIIIll = 0; lllllllllllllllllIIIIlIIlIlIIIll < lllllllllllllllllIIIIlIIlIlIIlII; ++lllllllllllllllllIIIIlIIlIlIIIll) {
            Block lllllllllllllllllIIIIlIIlIlIIIlI = lllllllllllllllllIIIIlIIlIlIIIII.getBlockState(lllllllllllllllllIIIIlIIlIIllllI.offsetUp(lllllllllllllllllIIIIlIIlIlIIIll)).getBlock();
            if (lllllllllllllllllIIIIlIIlIlIIIlI.getMaterial() == Material.air || lllllllllllllllllIIIIlIIlIlIIIlI.getMaterial() == Material.leaves) {
                this.func_175905_a(lllllllllllllllllIIIIlIIlIlIIIII, lllllllllllllllllIIIIlIIlIIllllI.offsetUp(lllllllllllllllllIIIIlIIlIlIIIll), Blocks.log, this.woodMetadata);
            }
            if (lllllllllllllllllIIIIlIIlIlIIIll < lllllllllllllllllIIIIlIIlIlIIlII - 1) {
                lllllllllllllllllIIIIlIIlIlIIIlI = lllllllllllllllllIIIIlIIlIlIIIII.getBlockState(lllllllllllllllllIIIIlIIlIIllllI.add(1, lllllllllllllllllIIIIlIIlIlIIIll, 0)).getBlock();
                if (lllllllllllllllllIIIIlIIlIlIIIlI.getMaterial() == Material.air || lllllllllllllllllIIIIlIIlIlIIIlI.getMaterial() == Material.leaves) {
                    this.func_175905_a(lllllllllllllllllIIIIlIIlIlIIIII, lllllllllllllllllIIIIlIIlIIllllI.add(1, lllllllllllllllllIIIIlIIlIlIIIll, 0), Blocks.log, this.woodMetadata);
                }
                lllllllllllllllllIIIIlIIlIlIIIlI = lllllllllllllllllIIIIlIIlIlIIIII.getBlockState(lllllllllllllllllIIIIlIIlIIllllI.add(1, lllllllllllllllllIIIIlIIlIlIIIll, 1)).getBlock();
                if (lllllllllllllllllIIIIlIIlIlIIIlI.getMaterial() == Material.air || lllllllllllllllllIIIIlIIlIlIIIlI.getMaterial() == Material.leaves) {
                    this.func_175905_a(lllllllllllllllllIIIIlIIlIlIIIII, lllllllllllllllllIIIIlIIlIIllllI.add(1, lllllllllllllllllIIIIlIIlIlIIIll, 1), Blocks.log, this.woodMetadata);
                }
                lllllllllllllllllIIIIlIIlIlIIIlI = lllllllllllllllllIIIIlIIlIlIIIII.getBlockState(lllllllllllllllllIIIIlIIlIIllllI.add(0, lllllllllllllllllIIIIlIIlIlIIIll, 1)).getBlock();
                if (lllllllllllllllllIIIIlIIlIlIIIlI.getMaterial() == Material.air || lllllllllllllllllIIIIlIIlIlIIIlI.getMaterial() == Material.leaves) {
                    this.func_175905_a(lllllllllllllllllIIIIlIIlIlIIIII, lllllllllllllllllIIIIlIIlIIllllI.add(0, lllllllllllllllllIIIIlIIlIlIIIll, 1), Blocks.log, this.woodMetadata);
                }
            }
        }
        return true;
    }
    
    static {
        __OBFID = "CL_00000421";
    }
    
    private void func_175934_c(final World lllllllllllllllllIIIIlIIIlIIlIII, final BlockPos lllllllllllllllllIIIIlIIIlIIIlll) {
        for (int lllllllllllllllllIIIIlIIIlIIIllI = 2; lllllllllllllllllIIIIlIIIlIIIllI >= -3; --lllllllllllllllllIIIIlIIIlIIIllI) {
            final BlockPos lllllllllllllllllIIIIlIIIlIIIlIl = lllllllllllllllllIIIIlIIIlIIIlll.offsetUp(lllllllllllllllllIIIIlIIIlIIIllI);
            final Block lllllllllllllllllIIIIlIIIlIIIlII = lllllllllllllllllIIIIlIIIlIIlIII.getBlockState(lllllllllllllllllIIIIlIIIlIIIlIl).getBlock();
            if (lllllllllllllllllIIIIlIIIlIIIlII == Blocks.grass || lllllllllllllllllIIIIlIIIlIIIlII == Blocks.dirt) {
                this.func_175905_a(lllllllllllllllllIIIIlIIIlIIlIII, lllllllllllllllllIIIIlIIIlIIIlIl, Blocks.dirt, BlockDirt.DirtType.PODZOL.getMetadata());
                break;
            }
            if (lllllllllllllllllIIIIlIIIlIIIlII.getMaterial() != Material.air && lllllllllllllllllIIIIlIIIlIIIllI < 0) {
                break;
            }
        }
    }
    
    @Override
    public void func_180711_a(final World lllllllllllllllllIIIIlIIIllIIlIl, final Random lllllllllllllllllIIIIlIIIllIIlII, final BlockPos lllllllllllllllllIIIIlIIIllIIIll) {
        this.func_175933_b(lllllllllllllllllIIIIlIIIllIIlIl, lllllllllllllllllIIIIlIIIllIIIll.offsetWest().offsetNorth());
        this.func_175933_b(lllllllllllllllllIIIIlIIIllIIlIl, lllllllllllllllllIIIIlIIIllIIIll.offsetEast(2).offsetNorth());
        this.func_175933_b(lllllllllllllllllIIIIlIIIllIIlIl, lllllllllllllllllIIIIlIIIllIIIll.offsetWest().offsetSouth(2));
        this.func_175933_b(lllllllllllllllllIIIIlIIIllIIlIl, lllllllllllllllllIIIIlIIIllIIIll.offsetEast(2).offsetSouth(2));
        for (int lllllllllllllllllIIIIlIIIllIlIlI = 0; lllllllllllllllllIIIIlIIIllIlIlI < 5; ++lllllllllllllllllIIIIlIIIllIlIlI) {
            final int lllllllllllllllllIIIIlIIIllIlIIl = lllllllllllllllllIIIIlIIIllIIlII.nextInt(64);
            final int lllllllllllllllllIIIIlIIIllIlIII = lllllllllllllllllIIIIlIIIllIlIIl % 8;
            final int lllllllllllllllllIIIIlIIIllIIlll = lllllllllllllllllIIIIlIIIllIlIIl / 8;
            if (lllllllllllllllllIIIIlIIIllIlIII == 0 || lllllllllllllllllIIIIlIIIllIlIII == 7 || lllllllllllllllllIIIIlIIIllIIlll == 0 || lllllllllllllllllIIIIlIIIllIIlll == 7) {
                this.func_175933_b(lllllllllllllllllIIIIlIIIllIIlIl, lllllllllllllllllIIIIlIIIllIIIll.add(-3 + lllllllllllllllllIIIIlIIIllIlIII, 0, -3 + lllllllllllllllllIIIIlIIIllIIlll));
            }
        }
    }
}
