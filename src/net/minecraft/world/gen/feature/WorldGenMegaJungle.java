package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;

public class WorldGenMegaJungle extends WorldGenHugeTrees
{
    @Override
    public boolean generate(final World lllllllllllllllIIlllIlIllIllIlII, final Random lllllllllllllllIIlllIlIllIlIIIIl, final BlockPos lllllllllllllllIIlllIlIllIlIIIII) {
        final int lllllllllllllllIIlllIlIllIllIIIl = this.func_150533_a(lllllllllllllllIIlllIlIllIlIIIIl);
        if (!this.func_175929_a(lllllllllllllllIIlllIlIllIllIlII, lllllllllllllllIIlllIlIllIlIIIIl, lllllllllllllllIIlllIlIllIlIIIII, lllllllllllllllIIlllIlIllIllIIIl)) {
            return false;
        }
        this.func_175930_c(lllllllllllllllIIlllIlIllIllIlII, lllllllllllllllIIlllIlIllIlIIIII.offsetUp(lllllllllllllllIIlllIlIllIllIIIl), 2);
        for (int lllllllllllllllIIlllIlIllIllIIII = lllllllllllllllIIlllIlIllIlIIIII.getY() + lllllllllllllllIIlllIlIllIllIIIl - 2 - lllllllllllllllIIlllIlIllIlIIIIl.nextInt(4); lllllllllllllllIIlllIlIllIllIIII > lllllllllllllllIIlllIlIllIlIIIII.getY() + lllllllllllllllIIlllIlIllIllIIIl / 2; lllllllllllllllIIlllIlIllIllIIII -= 2 + lllllllllllllllIIlllIlIllIlIIIIl.nextInt(4)) {
            final float lllllllllllllllIIlllIlIllIlIllll = lllllllllllllllIIlllIlIllIlIIIIl.nextFloat() * 3.1415927f * 2.0f;
            int lllllllllllllllIIlllIlIllIlIlllI = lllllllllllllllIIlllIlIllIlIIIII.getX() + (int)(0.5f + MathHelper.cos(lllllllllllllllIIlllIlIllIlIllll) * 4.0f);
            int lllllllllllllllIIlllIlIllIlIllIl = lllllllllllllllIIlllIlIllIlIIIII.getZ() + (int)(0.5f + MathHelper.sin(lllllllllllllllIIlllIlIllIlIllll) * 4.0f);
            for (int lllllllllllllllIIlllIlIllIlIllII = 0; lllllllllllllllIIlllIlIllIlIllII < 5; ++lllllllllllllllIIlllIlIllIlIllII) {
                lllllllllllllllIIlllIlIllIlIlllI = lllllllllllllllIIlllIlIllIlIIIII.getX() + (int)(1.5f + MathHelper.cos(lllllllllllllllIIlllIlIllIlIllll) * lllllllllllllllIIlllIlIllIlIllII);
                lllllllllllllllIIlllIlIllIlIllIl = lllllllllllllllIIlllIlIllIlIIIII.getZ() + (int)(1.5f + MathHelper.sin(lllllllllllllllIIlllIlIllIlIllll) * lllllllllllllllIIlllIlIllIlIllII);
                this.func_175905_a(lllllllllllllllIIlllIlIllIllIlII, new BlockPos(lllllllllllllllIIlllIlIllIlIlllI, lllllllllllllllIIlllIlIllIllIIII - 3 + lllllllllllllllIIlllIlIllIlIllII / 2, lllllllllllllllIIlllIlIllIlIllIl), Blocks.log, this.woodMetadata);
            }
            int lllllllllllllllIIlllIlIllIlIllII = 1 + lllllllllllllllIIlllIlIllIlIIIIl.nextInt(2);
            for (int lllllllllllllllIIlllIlIllIlIlIll = lllllllllllllllIIlllIlIllIllIIII, lllllllllllllllIIlllIlIllIlIlIlI = lllllllllllllllIIlllIlIllIllIIII - lllllllllllllllIIlllIlIllIlIllII; lllllllllllllllIIlllIlIllIlIlIlI <= lllllllllllllllIIlllIlIllIlIlIll; ++lllllllllllllllIIlllIlIllIlIlIlI) {
                final int lllllllllllllllIIlllIlIllIlIlIIl = lllllllllllllllIIlllIlIllIlIlIlI - lllllllllllllllIIlllIlIllIlIlIll;
                this.func_175928_b(lllllllllllllllIIlllIlIllIllIlII, new BlockPos(lllllllllllllllIIlllIlIllIlIlllI, lllllllllllllllIIlllIlIllIlIlIlI, lllllllllllllllIIlllIlIllIlIllIl), 1 - lllllllllllllllIIlllIlIllIlIlIIl);
            }
        }
        for (int lllllllllllllllIIlllIlIllIlIlIII = 0; lllllllllllllllIIlllIlIllIlIlIII < lllllllllllllllIIlllIlIllIllIIIl; ++lllllllllllllllIIlllIlIllIlIlIII) {
            final BlockPos lllllllllllllllIIlllIlIllIlIIlll = lllllllllllllllIIlllIlIllIlIIIII.offsetUp(lllllllllllllllIIlllIlIllIlIlIII);
            if (this.func_175931_a(lllllllllllllllIIlllIlIllIllIlII.getBlockState(lllllllllllllllIIlllIlIllIlIIlll).getBlock().getMaterial())) {
                this.func_175905_a(lllllllllllllllIIlllIlIllIllIlII, lllllllllllllllIIlllIlIllIlIIlll, Blocks.log, this.woodMetadata);
                if (lllllllllllllllIIlllIlIllIlIlIII > 0) {
                    this.func_175932_b(lllllllllllllllIIlllIlIllIllIlII, lllllllllllllllIIlllIlIllIlIIIIl, lllllllllllllllIIlllIlIllIlIIlll.offsetWest(), BlockVine.field_176275_S);
                    this.func_175932_b(lllllllllllllllIIlllIlIllIllIlII, lllllllllllllllIIlllIlIllIlIIIIl, lllllllllllllllIIlllIlIllIlIIlll.offsetNorth(), BlockVine.field_176272_Q);
                }
            }
            if (lllllllllllllllIIlllIlIllIlIlIII < lllllllllllllllIIlllIlIllIllIIIl - 1) {
                final BlockPos lllllllllllllllIIlllIlIllIlIIllI = lllllllllllllllIIlllIlIllIlIIlll.offsetEast();
                if (this.func_175931_a(lllllllllllllllIIlllIlIllIllIlII.getBlockState(lllllllllllllllIIlllIlIllIlIIllI).getBlock().getMaterial())) {
                    this.func_175905_a(lllllllllllllllIIlllIlIllIllIlII, lllllllllllllllIIlllIlIllIlIIllI, Blocks.log, this.woodMetadata);
                    if (lllllllllllllllIIlllIlIllIlIlIII > 0) {
                        this.func_175932_b(lllllllllllllllIIlllIlIllIllIlII, lllllllllllllllIIlllIlIllIlIIIIl, lllllllllllllllIIlllIlIllIlIIllI.offsetEast(), BlockVine.field_176271_T);
                        this.func_175932_b(lllllllllllllllIIlllIlIllIllIlII, lllllllllllllllIIlllIlIllIlIIIIl, lllllllllllllllIIlllIlIllIlIIllI.offsetNorth(), BlockVine.field_176272_Q);
                    }
                }
                final BlockPos lllllllllllllllIIlllIlIllIlIIlIl = lllllllllllllllIIlllIlIllIlIIlll.offsetSouth().offsetEast();
                if (this.func_175931_a(lllllllllllllllIIlllIlIllIllIlII.getBlockState(lllllllllllllllIIlllIlIllIlIIlIl).getBlock().getMaterial())) {
                    this.func_175905_a(lllllllllllllllIIlllIlIllIllIlII, lllllllllllllllIIlllIlIllIlIIlIl, Blocks.log, this.woodMetadata);
                    if (lllllllllllllllIIlllIlIllIlIlIII > 0) {
                        this.func_175932_b(lllllllllllllllIIlllIlIllIllIlII, lllllllllllllllIIlllIlIllIlIIIIl, lllllllllllllllIIlllIlIllIlIIlIl.offsetEast(), BlockVine.field_176271_T);
                        this.func_175932_b(lllllllllllllllIIlllIlIllIllIlII, lllllllllllllllIIlllIlIllIlIIIIl, lllllllllllllllIIlllIlIllIlIIlIl.offsetSouth(), BlockVine.field_176276_R);
                    }
                }
                final BlockPos lllllllllllllllIIlllIlIllIlIIlII = lllllllllllllllIIlllIlIllIlIIlll.offsetSouth();
                if (this.func_175931_a(lllllllllllllllIIlllIlIllIllIlII.getBlockState(lllllllllllllllIIlllIlIllIlIIlII).getBlock().getMaterial())) {
                    this.func_175905_a(lllllllllllllllIIlllIlIllIllIlII, lllllllllllllllIIlllIlIllIlIIlII, Blocks.log, this.woodMetadata);
                    if (lllllllllllllllIIlllIlIllIlIlIII > 0) {
                        this.func_175932_b(lllllllllllllllIIlllIlIllIllIlII, lllllllllllllllIIlllIlIllIlIIIIl, lllllllllllllllIIlllIlIllIlIIlII.offsetWest(), BlockVine.field_176275_S);
                        this.func_175932_b(lllllllllllllllIIlllIlIllIllIlII, lllllllllllllllIIlllIlIllIlIIIIl, lllllllllllllllIIlllIlIllIlIIlII.offsetSouth(), BlockVine.field_176276_R);
                    }
                }
            }
        }
        return true;
    }
    
    private boolean func_175931_a(final Material lllllllllllllllIIlllIlIllIIlIIll) {
        return lllllllllllllllIIlllIlIllIIlIIll == Material.air || lllllllllllllllIIlllIlIllIIlIIll == Material.leaves;
    }
    
    public WorldGenMegaJungle(final boolean lllllllllllllllIIlllIlIlllIIllIl, final int lllllllllllllllIIlllIlIlllIIIllI, final int lllllllllllllllIIlllIlIlllIIIlIl, final int lllllllllllllllIIlllIlIlllIIlIlI, final int lllllllllllllllIIlllIlIlllIIIIll) {
        super(lllllllllllllllIIlllIlIlllIIllIl, lllllllllllllllIIlllIlIlllIIIllI, lllllllllllllllIIlllIlIlllIIIlIl, lllllllllllllllIIlllIlIlllIIlIlI, lllllllllllllllIIlllIlIlllIIIIll);
    }
    
    private void func_175930_c(final World lllllllllllllllIIlllIlIlIlllIllI, final BlockPos lllllllllllllllIIlllIlIlIllllIll, final int lllllllllllllllIIlllIlIlIllllIlI) {
        final byte lllllllllllllllIIlllIlIlIllllIIl = 2;
        for (int lllllllllllllllIIlllIlIlIllllIII = -lllllllllllllllIIlllIlIlIllllIIl; lllllllllllllllIIlllIlIlIllllIII <= 0; ++lllllllllllllllIIlllIlIlIllllIII) {
            this.func_175925_a(lllllllllllllllIIlllIlIlIlllIllI, lllllllllllllllIIlllIlIlIllllIll.offsetUp(lllllllllllllllIIlllIlIlIllllIII), lllllllllllllllIIlllIlIlIllllIlI + 1 - lllllllllllllllIIlllIlIlIllllIII);
        }
    }
    
    private void func_175932_b(final World lllllllllllllllIIlllIlIllIIIllII, final Random lllllllllllllllIIlllIlIllIIIlIll, final BlockPos lllllllllllllllIIlllIlIllIIIIlIl, final int lllllllllllllllIIlllIlIllIIIIlII) {
        if (lllllllllllllllIIlllIlIllIIIlIll.nextInt(3) > 0 && lllllllllllllllIIlllIlIllIIIllII.isAirBlock(lllllllllllllllIIlllIlIllIIIIlIl)) {
            this.func_175905_a(lllllllllllllllIIlllIlIllIIIllII, lllllllllllllllIIlllIlIllIIIIlIl, Blocks.vine, lllllllllllllllIIlllIlIllIIIIlII);
        }
    }
    
    static {
        __OBFID = "CL_00000420";
    }
}
