package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;

public class WorldGenGlowStone2 extends WorldGenerator
{
    static {
        __OBFID = "CL_00000413";
    }
    
    @Override
    public boolean generate(final World llllllllllllllIllIlIlIllIlIIIIII, final Random llllllllllllllIllIlIlIllIlIIlIIl, final BlockPos llllllllllllllIllIlIlIllIIlllllI) {
        if (!llllllllllllllIllIlIlIllIlIIIIII.isAirBlock(llllllllllllllIllIlIlIllIIlllllI)) {
            return false;
        }
        if (llllllllllllllIllIlIlIllIlIIIIII.getBlockState(llllllllllllllIllIlIlIllIIlllllI.offsetUp()).getBlock() != Blocks.netherrack) {
            return false;
        }
        llllllllllllllIllIlIlIllIlIIIIII.setBlockState(llllllllllllllIllIlIlIllIIlllllI, Blocks.glowstone.getDefaultState(), 2);
        for (int llllllllllllllIllIlIlIllIlIIIlll = 0; llllllllllllllIllIlIlIllIlIIIlll < 1500; ++llllllllllllllIllIlIlIllIlIIIlll) {
            final BlockPos llllllllllllllIllIlIlIllIlIIIllI = llllllllllllllIllIlIlIllIIlllllI.add(llllllllllllllIllIlIlIllIlIIlIIl.nextInt(8) - llllllllllllllIllIlIlIllIlIIlIIl.nextInt(8), llllllllllllllIllIlIlIllIlIIlIIl.nextInt(12), llllllllllllllIllIlIlIllIlIIlIIl.nextInt(8) - llllllllllllllIllIlIlIllIlIIlIIl.nextInt(8));
            if (llllllllllllllIllIlIlIllIlIIIIII.getBlockState(llllllllllllllIllIlIlIllIlIIIllI).getBlock().getMaterial() == Material.air) {
                int llllllllllllllIllIlIlIllIlIIIlIl = 0;
                for (final EnumFacing llllllllllllllIllIlIlIllIlIIIIIl : EnumFacing.values()) {
                    if (llllllllllllllIllIlIlIllIlIIIIII.getBlockState(llllllllllllllIllIlIlIllIlIIIllI.offset(llllllllllllllIllIlIlIllIlIIIIIl)).getBlock() == Blocks.glowstone) {
                        ++llllllllllllllIllIlIlIllIlIIIlIl;
                    }
                    if (llllllllllllllIllIlIlIllIlIIIlIl > 1) {
                        break;
                    }
                }
                if (llllllllllllllIllIlIlIllIlIIIlIl == 1) {
                    llllllllllllllIllIlIlIllIlIIIIII.setBlockState(llllllllllllllIllIlIlIllIlIIIllI, Blocks.glowstone.getDefaultState(), 2);
                }
            }
        }
        return true;
    }
}
