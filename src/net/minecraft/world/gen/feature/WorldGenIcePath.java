package net.minecraft.world.gen.feature;

import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;

public class WorldGenIcePath extends WorldGenerator
{
    private /* synthetic */ Block field_150555_a;
    private /* synthetic */ int field_150554_b;
    
    static {
        __OBFID = "CL_00000416";
    }
    
    public WorldGenIcePath(final int llllllllllllllllIIIlllIIlIllIIIl) {
        this.field_150555_a = Blocks.packed_ice;
        this.field_150554_b = llllllllllllllllIIIlllIIlIllIIIl;
    }
    
    @Override
    public boolean generate(final World llllllllllllllllIIIlllIIlIlIIIII, final Random llllllllllllllllIIIlllIIlIIlIIlI, BlockPos llllllllllllllllIIIlllIIlIIlIIIl) {
        while (llllllllllllllllIIIlllIIlIlIIIII.isAirBlock(llllllllllllllllIIIlllIIlIIlIIIl) && llllllllllllllllIIIlllIIlIIlIIIl.getY() > 2) {
            llllllllllllllllIIIlllIIlIIlIIIl = llllllllllllllllIIIlllIIlIIlIIIl.offsetDown();
        }
        if (llllllllllllllllIIIlllIIlIlIIIII.getBlockState(llllllllllllllllIIIlllIIlIIlIIIl).getBlock() != Blocks.snow) {
            return false;
        }
        final int llllllllllllllllIIIlllIIlIIlllIl = llllllllllllllllIIIlllIIlIIlIIlI.nextInt(this.field_150554_b - 2) + 2;
        final byte llllllllllllllllIIIlllIIlIIlllII = 1;
        for (int llllllllllllllllIIIlllIIlIIllIll = llllllllllllllllIIIlllIIlIIlIIIl.getX() - llllllllllllllllIIIlllIIlIIlllIl; llllllllllllllllIIIlllIIlIIllIll <= llllllllllllllllIIIlllIIlIIlIIIl.getX() + llllllllllllllllIIIlllIIlIIlllIl; ++llllllllllllllllIIIlllIIlIIllIll) {
            for (int llllllllllllllllIIIlllIIlIIllIlI = llllllllllllllllIIIlllIIlIIlIIIl.getZ() - llllllllllllllllIIIlllIIlIIlllIl; llllllllllllllllIIIlllIIlIIllIlI <= llllllllllllllllIIIlllIIlIIlIIIl.getZ() + llllllllllllllllIIIlllIIlIIlllIl; ++llllllllllllllllIIIlllIIlIIllIlI) {
                final int llllllllllllllllIIIlllIIlIIllIIl = llllllllllllllllIIIlllIIlIIllIll - llllllllllllllllIIIlllIIlIIlIIIl.getX();
                final int llllllllllllllllIIIlllIIlIIllIII = llllllllllllllllIIIlllIIlIIllIlI - llllllllllllllllIIIlllIIlIIlIIIl.getZ();
                if (llllllllllllllllIIIlllIIlIIllIIl * llllllllllllllllIIIlllIIlIIllIIl + llllllllllllllllIIIlllIIlIIllIII * llllllllllllllllIIIlllIIlIIllIII <= llllllllllllllllIIIlllIIlIIlllIl * llllllllllllllllIIIlllIIlIIlllIl) {
                    for (int llllllllllllllllIIIlllIIlIIlIlll = llllllllllllllllIIIlllIIlIIlIIIl.getY() - llllllllllllllllIIIlllIIlIIlllII; llllllllllllllllIIIlllIIlIIlIlll <= llllllllllllllllIIIlllIIlIIlIIIl.getY() + llllllllllllllllIIIlllIIlIIlllII; ++llllllllllllllllIIIlllIIlIIlIlll) {
                        final BlockPos llllllllllllllllIIIlllIIlIIlIllI = new BlockPos(llllllllllllllllIIIlllIIlIIllIll, llllllllllllllllIIIlllIIlIIlIlll, llllllllllllllllIIIlllIIlIIllIlI);
                        final Block llllllllllllllllIIIlllIIlIIlIlIl = llllllllllllllllIIIlllIIlIlIIIII.getBlockState(llllllllllllllllIIIlllIIlIIlIllI).getBlock();
                        if (llllllllllllllllIIIlllIIlIIlIlIl == Blocks.dirt || llllllllllllllllIIIlllIIlIIlIlIl == Blocks.snow || llllllllllllllllIIIlllIIlIIlIlIl == Blocks.ice) {
                            llllllllllllllllIIIlllIIlIlIIIII.setBlockState(llllllllllllllllIIIlllIIlIIlIllI, this.field_150555_a.getDefaultState(), 2);
                        }
                    }
                }
            }
        }
        return true;
    }
}
