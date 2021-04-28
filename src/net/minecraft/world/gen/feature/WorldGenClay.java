package net.minecraft.world.gen.feature;

import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;

public class WorldGenClay extends WorldGenerator
{
    private /* synthetic */ int numberOfBlocks;
    private /* synthetic */ Block field_150546_a;
    
    @Override
    public boolean generate(final World llIlIIllIllIlI, final Random llIlIIlllIIllI, final BlockPos llIlIIlllIIlIl) {
        if (llIlIIllIllIlI.getBlockState(llIlIIlllIIlIl).getBlock().getMaterial() != Material.water) {
            return false;
        }
        final int llIlIIlllIIlII = llIlIIlllIIllI.nextInt(this.numberOfBlocks - 2) + 2;
        final byte llIlIIlllIIIll = 1;
        for (int llIlIIlllIIIlI = llIlIIlllIIlIl.getX() - llIlIIlllIIlII; llIlIIlllIIIlI <= llIlIIlllIIlIl.getX() + llIlIIlllIIlII; ++llIlIIlllIIIlI) {
            for (int llIlIIlllIIIIl = llIlIIlllIIlIl.getZ() - llIlIIlllIIlII; llIlIIlllIIIIl <= llIlIIlllIIlIl.getZ() + llIlIIlllIIlII; ++llIlIIlllIIIIl) {
                final int llIlIIlllIIIII = llIlIIlllIIIlI - llIlIIlllIIlIl.getX();
                final int llIlIIllIlllll = llIlIIlllIIIIl - llIlIIlllIIlIl.getZ();
                if (llIlIIlllIIIII * llIlIIlllIIIII + llIlIIllIlllll * llIlIIllIlllll <= llIlIIlllIIlII * llIlIIlllIIlII) {
                    for (int llIlIIllIllllI = llIlIIlllIIlIl.getY() - llIlIIlllIIIll; llIlIIllIllllI <= llIlIIlllIIlIl.getY() + llIlIIlllIIIll; ++llIlIIllIllllI) {
                        final BlockPos llIlIIllIlllIl = new BlockPos(llIlIIlllIIIlI, llIlIIllIllllI, llIlIIlllIIIIl);
                        final Block llIlIIllIlllII = llIlIIllIllIlI.getBlockState(llIlIIllIlllIl).getBlock();
                        if (llIlIIllIlllII == Blocks.dirt || llIlIIllIlllII == Blocks.clay) {
                            llIlIIllIllIlI.setBlockState(llIlIIllIlllIl, this.field_150546_a.getDefaultState(), 2);
                        }
                    }
                }
            }
        }
        return true;
    }
    
    static {
        __OBFID = "CL_00000405";
    }
    
    public WorldGenClay(final int llIlIIllllIllI) {
        this.field_150546_a = Blocks.clay;
        this.numberOfBlocks = llIlIIllllIllI;
    }
}
