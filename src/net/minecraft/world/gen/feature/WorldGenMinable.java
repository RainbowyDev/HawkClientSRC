package net.minecraft.world.gen.feature;

import com.google.common.base.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.block.state.pattern.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;

public class WorldGenMinable extends WorldGenerator
{
    private final /* synthetic */ int numberOfBlocks;
    private final /* synthetic */ Predicate field_175919_c;
    private final /* synthetic */ IBlockState oreBlock;
    
    public WorldGenMinable(final IBlockState lllllllllllllllIlIIlIIlIIllIlIlI, final int lllllllllllllllIlIIlIIlIIllIlIIl, final Predicate lllllllllllllllIlIIlIIlIIllIlIII) {
        this.oreBlock = lllllllllllllllIlIIlIIlIIllIlIlI;
        this.numberOfBlocks = lllllllllllllllIlIIlIIlIIllIlIIl;
        this.field_175919_c = lllllllllllllllIlIIlIIlIIllIlIII;
    }
    
    static {
        __OBFID = "CL_00000426";
    }
    
    public WorldGenMinable(final IBlockState lllllllllllllllIlIIlIIlIIlllIIIl, final int lllllllllllllllIlIIlIIlIIlllIIll) {
        this(lllllllllllllllIlIIlIIlIIlllIIIl, lllllllllllllllIlIIlIIlIIlllIIll, (Predicate)BlockHelper.forBlock(Blocks.stone));
    }
    
    @Override
    public boolean generate(final World lllllllllllllllIlIIlIIlIIIlIIIlI, final Random lllllllllllllllIlIIlIIlIIlIIIIIl, final BlockPos lllllllllllllllIlIIlIIlIIlIIIIII) {
        final float lllllllllllllllIlIIlIIlIIIllllll = lllllllllllllllIlIIlIIlIIlIIIIIl.nextFloat() * 3.1415927f;
        final double lllllllllllllllIlIIlIIlIIIlllllI = lllllllllllllllIlIIlIIlIIlIIIIII.getX() + 8 + MathHelper.sin(lllllllllllllllIlIIlIIlIIIllllll) * this.numberOfBlocks / 8.0f;
        final double lllllllllllllllIlIIlIIlIIIllllIl = lllllllllllllllIlIIlIIlIIlIIIIII.getX() + 8 - MathHelper.sin(lllllllllllllllIlIIlIIlIIIllllll) * this.numberOfBlocks / 8.0f;
        final double lllllllllllllllIlIIlIIlIIIllllII = lllllllllllllllIlIIlIIlIIlIIIIII.getZ() + 8 + MathHelper.cos(lllllllllllllllIlIIlIIlIIIllllll) * this.numberOfBlocks / 8.0f;
        final double lllllllllllllllIlIIlIIlIIIlllIll = lllllllllllllllIlIIlIIlIIlIIIIII.getZ() + 8 - MathHelper.cos(lllllllllllllllIlIIlIIlIIIllllll) * this.numberOfBlocks / 8.0f;
        final double lllllllllllllllIlIIlIIlIIIlllIlI = lllllllllllllllIlIIlIIlIIlIIIIII.getY() + lllllllllllllllIlIIlIIlIIlIIIIIl.nextInt(3) - 2;
        final double lllllllllllllllIlIIlIIlIIIlllIIl = lllllllllllllllIlIIlIIlIIlIIIIII.getY() + lllllllllllllllIlIIlIIlIIlIIIIIl.nextInt(3) - 2;
        for (int lllllllllllllllIlIIlIIlIIIlllIII = 0; lllllllllllllllIlIIlIIlIIIlllIII < this.numberOfBlocks; ++lllllllllllllllIlIIlIIlIIIlllIII) {
            final float lllllllllllllllIlIIlIIlIIIllIlll = lllllllllllllllIlIIlIIlIIIlllIII / (float)this.numberOfBlocks;
            final double lllllllllllllllIlIIlIIlIIIllIllI = lllllllllllllllIlIIlIIlIIIlllllI + (lllllllllllllllIlIIlIIlIIIllllIl - lllllllllllllllIlIIlIIlIIIlllllI) * lllllllllllllllIlIIlIIlIIIllIlll;
            final double lllllllllllllllIlIIlIIlIIIllIlIl = lllllllllllllllIlIIlIIlIIIlllIlI + (lllllllllllllllIlIIlIIlIIIlllIIl - lllllllllllllllIlIIlIIlIIIlllIlI) * lllllllllllllllIlIIlIIlIIIllIlll;
            final double lllllllllllllllIlIIlIIlIIIllIlII = lllllllllllllllIlIIlIIlIIIllllII + (lllllllllllllllIlIIlIIlIIIlllIll - lllllllllllllllIlIIlIIlIIIllllII) * lllllllllllllllIlIIlIIlIIIllIlll;
            final double lllllllllllllllIlIIlIIlIIIllIIll = lllllllllllllllIlIIlIIlIIlIIIIIl.nextDouble() * this.numberOfBlocks / 16.0;
            final double lllllllllllllllIlIIlIIlIIIllIIlI = (MathHelper.sin(3.1415927f * lllllllllllllllIlIIlIIlIIIllIlll) + 1.0f) * lllllllllllllllIlIIlIIlIIIllIIll + 1.0;
            final double lllllllllllllllIlIIlIIlIIIllIIIl = (MathHelper.sin(3.1415927f * lllllllllllllllIlIIlIIlIIIllIlll) + 1.0f) * lllllllllllllllIlIIlIIlIIIllIIll + 1.0;
            final int lllllllllllllllIlIIlIIlIIIllIIII = MathHelper.floor_double(lllllllllllllllIlIIlIIlIIIllIllI - lllllllllllllllIlIIlIIlIIIllIIlI / 2.0);
            final int lllllllllllllllIlIIlIIlIIIlIllll = MathHelper.floor_double(lllllllllllllllIlIIlIIlIIIllIlIl - lllllllllllllllIlIIlIIlIIIllIIIl / 2.0);
            final int lllllllllllllllIlIIlIIlIIIlIlllI = MathHelper.floor_double(lllllllllllllllIlIIlIIlIIIllIlII - lllllllllllllllIlIIlIIlIIIllIIlI / 2.0);
            final int lllllllllllllllIlIIlIIlIIIlIllIl = MathHelper.floor_double(lllllllllllllllIlIIlIIlIIIllIllI + lllllllllllllllIlIIlIIlIIIllIIlI / 2.0);
            final int lllllllllllllllIlIIlIIlIIIlIllII = MathHelper.floor_double(lllllllllllllllIlIIlIIlIIIllIlIl + lllllllllllllllIlIIlIIlIIIllIIIl / 2.0);
            final int lllllllllllllllIlIIlIIlIIIlIlIll = MathHelper.floor_double(lllllllllllllllIlIIlIIlIIIllIlII + lllllllllllllllIlIIlIIlIIIllIIlI / 2.0);
            for (int lllllllllllllllIlIIlIIlIIIlIlIlI = lllllllllllllllIlIIlIIlIIIllIIII; lllllllllllllllIlIIlIIlIIIlIlIlI <= lllllllllllllllIlIIlIIlIIIlIllIl; ++lllllllllllllllIlIIlIIlIIIlIlIlI) {
                final double lllllllllllllllIlIIlIIlIIIlIlIIl = (lllllllllllllllIlIIlIIlIIIlIlIlI + 0.5 - lllllllllllllllIlIIlIIlIIIllIllI) / (lllllllllllllllIlIIlIIlIIIllIIlI / 2.0);
                if (lllllllllllllllIlIIlIIlIIIlIlIIl * lllllllllllllllIlIIlIIlIIIlIlIIl < 1.0) {
                    for (int lllllllllllllllIlIIlIIlIIIlIlIII = lllllllllllllllIlIIlIIlIIIlIllll; lllllllllllllllIlIIlIIlIIIlIlIII <= lllllllllllllllIlIIlIIlIIIlIllII; ++lllllllllllllllIlIIlIIlIIIlIlIII) {
                        final double lllllllllllllllIlIIlIIlIIIlIIlll = (lllllllllllllllIlIIlIIlIIIlIlIII + 0.5 - lllllllllllllllIlIIlIIlIIIllIlIl) / (lllllllllllllllIlIIlIIlIIIllIIIl / 2.0);
                        if (lllllllllllllllIlIIlIIlIIIlIlIIl * lllllllllllllllIlIIlIIlIIIlIlIIl + lllllllllllllllIlIIlIIlIIIlIIlll * lllllllllllllllIlIIlIIlIIIlIIlll < 1.0) {
                            for (int lllllllllllllllIlIIlIIlIIIlIIllI = lllllllllllllllIlIIlIIlIIIlIlllI; lllllllllllllllIlIIlIIlIIIlIIllI <= lllllllllllllllIlIIlIIlIIIlIlIll; ++lllllllllllllllIlIIlIIlIIIlIIllI) {
                                final double lllllllllllllllIlIIlIIlIIIlIIlIl = (lllllllllllllllIlIIlIIlIIIlIIllI + 0.5 - lllllllllllllllIlIIlIIlIIIllIlII) / (lllllllllllllllIlIIlIIlIIIllIIlI / 2.0);
                                if (lllllllllllllllIlIIlIIlIIIlIlIIl * lllllllllllllllIlIIlIIlIIIlIlIIl + lllllllllllllllIlIIlIIlIIIlIIlll * lllllllllllllllIlIIlIIlIIIlIIlll + lllllllllllllllIlIIlIIlIIIlIIlIl * lllllllllllllllIlIIlIIlIIIlIIlIl < 1.0) {
                                    final BlockPos lllllllllllllllIlIIlIIlIIIlIIlII = new BlockPos(lllllllllllllllIlIIlIIlIIIlIlIlI, lllllllllllllllIlIIlIIlIIIlIlIII, lllllllllllllllIlIIlIIlIIIlIIllI);
                                    if (this.field_175919_c.apply((Object)lllllllllllllllIlIIlIIlIIIlIIIlI.getBlockState(lllllllllllllllIlIIlIIlIIIlIIlII))) {
                                        lllllllllllllllIlIIlIIlIIIlIIIlI.setBlockState(lllllllllllllllIlIIlIIlIIIlIIlII, this.oreBlock, 2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
