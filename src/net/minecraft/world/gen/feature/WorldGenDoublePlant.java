package net.minecraft.world.gen.feature;

import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.init.*;

public class WorldGenDoublePlant extends WorldGenerator
{
    private /* synthetic */ BlockDoublePlant.EnumPlantType field_150549_a;
    
    public void func_180710_a(final BlockDoublePlant.EnumPlantType llllllllllllllIIIllIlIIIllIlllll) {
        this.field_150549_a = llllllllllllllIIIllIlIIIllIlllll;
    }
    
    static {
        __OBFID = "CL_00000408";
    }
    
    @Override
    public boolean generate(final World llllllllllllllIIIllIlIIIllIlIlII, final Random llllllllllllllIIIllIlIIIllIlIIll, final BlockPos llllllllllllllIIIllIlIIIllIlIIlI) {
        boolean llllllllllllllIIIllIlIIIllIlIIIl = false;
        for (int llllllllllllllIIIllIlIIIllIlIIII = 0; llllllllllllllIIIllIlIIIllIlIIII < 64; ++llllllllllllllIIIllIlIIIllIlIIII) {
            final BlockPos llllllllllllllIIIllIlIIIllIIllll = llllllllllllllIIIllIlIIIllIlIIlI.add(llllllllllllllIIIllIlIIIllIlIIll.nextInt(8) - llllllllllllllIIIllIlIIIllIlIIll.nextInt(8), llllllllllllllIIIllIlIIIllIlIIll.nextInt(4) - llllllllllllllIIIllIlIIIllIlIIll.nextInt(4), llllllllllllllIIIllIlIIIllIlIIll.nextInt(8) - llllllllllllllIIIllIlIIIllIlIIll.nextInt(8));
            if (llllllllllllllIIIllIlIIIllIlIlII.isAirBlock(llllllllllllllIIIllIlIIIllIIllll) && (!llllllllllllllIIIllIlIIIllIlIlII.provider.getHasNoSky() || llllllllllllllIIIllIlIIIllIIllll.getY() < 254) && Blocks.double_plant.canPlaceBlockAt(llllllllllllllIIIllIlIIIllIlIlII, llllllllllllllIIIllIlIIIllIIllll)) {
                Blocks.double_plant.func_176491_a(llllllllllllllIIIllIlIIIllIlIlII, llllllllllllllIIIllIlIIIllIIllll, this.field_150549_a, 2);
                llllllllllllllIIIllIlIIIllIlIIIl = true;
            }
        }
        return llllllllllllllIIIllIlIIIllIlIIIl;
    }
}
