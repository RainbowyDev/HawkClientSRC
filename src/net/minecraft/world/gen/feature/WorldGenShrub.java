package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.block.*;

public class WorldGenShrub extends WorldGenTrees
{
    private /* synthetic */ int field_150528_a;
    private /* synthetic */ int field_150527_b;
    
    public WorldGenShrub(final int llllllllllllllIllllIIllIlIllIIIl, final int llllllllllllllIllllIIllIlIllIIll) {
        super(false);
        this.field_150527_b = llllllllllllllIllllIIllIlIllIIIl;
        this.field_150528_a = llllllllllllllIllllIIllIlIllIIll;
    }
    
    static {
        __OBFID = "CL_00000411";
    }
    
    @Override
    public boolean generate(final World llllllllllllllIllllIIllIlIIlIIIl, final Random llllllllllllllIllllIIllIlIIlllll, BlockPos llllllllllllllIllllIIllIlIIIllll) {
        Block llllllllllllllIllllIIllIlIIlllII;
        while (((llllllllllllllIllllIIllIlIIlllII = llllllllllllllIllllIIllIlIIlIIIl.getBlockState(llllllllllllllIllllIIllIlIIIllll).getBlock()).getMaterial() == Material.air || llllllllllllllIllllIIllIlIIlllII.getMaterial() == Material.leaves) && llllllllllllllIllllIIllIlIIIllll.getY() > 0) {
            llllllllllllllIllllIIllIlIIIllll = llllllllllllllIllllIIllIlIIIllll.offsetDown();
        }
        final Block llllllllllllllIllllIIllIlIIllIll = llllllllllllllIllllIIllIlIIlIIIl.getBlockState(llllllllllllllIllllIIllIlIIIllll).getBlock();
        if (llllllllllllllIllllIIllIlIIllIll == Blocks.dirt || llllllllllllllIllllIIllIlIIllIll == Blocks.grass) {
            llllllllllllllIllllIIllIlIIIllll = llllllllllllllIllllIIllIlIIIllll.offsetUp();
            this.func_175905_a(llllllllllllllIllllIIllIlIIlIIIl, llllllllllllllIllllIIllIlIIIllll, Blocks.log, this.field_150527_b);
            for (int llllllllllllllIllllIIllIlIIllIlI = llllllllllllllIllllIIllIlIIIllll.getY(); llllllllllllllIllllIIllIlIIllIlI <= llllllllllllllIllllIIllIlIIIllll.getY() + 2; ++llllllllllllllIllllIIllIlIIllIlI) {
                final int llllllllllllllIllllIIllIlIIllIIl = llllllllllllllIllllIIllIlIIllIlI - llllllllllllllIllllIIllIlIIIllll.getY();
                for (int llllllllllllllIllllIIllIlIIllIII = 2 - llllllllllllllIllllIIllIlIIllIIl, llllllllllllllIllllIIllIlIIlIlll = llllllllllllllIllllIIllIlIIIllll.getX() - llllllllllllllIllllIIllIlIIllIII; llllllllllllllIllllIIllIlIIlIlll <= llllllllllllllIllllIIllIlIIIllll.getX() + llllllllllllllIllllIIllIlIIllIII; ++llllllllllllllIllllIIllIlIIlIlll) {
                    final int llllllllllllllIllllIIllIlIIlIllI = llllllllllllllIllllIIllIlIIlIlll - llllllllllllllIllllIIllIlIIIllll.getX();
                    for (int llllllllllllllIllllIIllIlIIlIlIl = llllllllllllllIllllIIllIlIIIllll.getZ() - llllllllllllllIllllIIllIlIIllIII; llllllllllllllIllllIIllIlIIlIlIl <= llllllllllllllIllllIIllIlIIIllll.getZ() + llllllllllllllIllllIIllIlIIllIII; ++llllllllllllllIllllIIllIlIIlIlIl) {
                        final int llllllllllllllIllllIIllIlIIlIlII = llllllllllllllIllllIIllIlIIlIlIl - llllllllllllllIllllIIllIlIIIllll.getZ();
                        if (Math.abs(llllllllllllllIllllIIllIlIIlIllI) != llllllllllllllIllllIIllIlIIllIII || Math.abs(llllllllllllllIllllIIllIlIIlIlII) != llllllllllllllIllllIIllIlIIllIII || llllllllllllllIllllIIllIlIIlllll.nextInt(2) != 0) {
                            final BlockPos llllllllllllllIllllIIllIlIIlIIll = new BlockPos(llllllllllllllIllllIIllIlIIlIlll, llllllllllllllIllllIIllIlIIllIlI, llllllllllllllIllllIIllIlIIlIlIl);
                            if (!llllllllllllllIllllIIllIlIIlIIIl.getBlockState(llllllllllllllIllllIIllIlIIlIIll).getBlock().isFullBlock()) {
                                this.func_175905_a(llllllllllllllIllllIIllIlIIlIIIl, llllllllllllllIllllIIllIlIIlIIll, Blocks.leaves, this.field_150528_a);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
