package net.minecraft.world.gen;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;

public class GeneratorBushFeature extends WorldGenerator
{
    private /* synthetic */ BlockBush field_175908_a;
    
    static {
        __OBFID = "CL_00002000";
    }
    
    public GeneratorBushFeature(final BlockBush lllllllllllllllIIlIlIIIlllllllll) {
        this.field_175908_a = lllllllllllllllIIlIlIIIlllllllll;
    }
    
    @Override
    public boolean generate(final World lllllllllllllllIIlIlIIIlllllIlll, final Random lllllllllllllllIIlIlIIIlllllIllI, final BlockPos lllllllllllllllIIlIlIIIllllIllll) {
        for (int lllllllllllllllIIlIlIIIlllllIlII = 0; lllllllllllllllIIlIlIIIlllllIlII < 64; ++lllllllllllllllIIlIlIIIlllllIlII) {
            final BlockPos lllllllllllllllIIlIlIIIlllllIIll = lllllllllllllllIIlIlIIIllllIllll.add(lllllllllllllllIIlIlIIIlllllIllI.nextInt(8) - lllllllllllllllIIlIlIIIlllllIllI.nextInt(8), lllllllllllllllIIlIlIIIlllllIllI.nextInt(4) - lllllllllllllllIIlIlIIIlllllIllI.nextInt(4), lllllllllllllllIIlIlIIIlllllIllI.nextInt(8) - lllllllllllllllIIlIlIIIlllllIllI.nextInt(8));
            if (lllllllllllllllIIlIlIIIlllllIlll.isAirBlock(lllllllllllllllIIlIlIIIlllllIIll) && (!lllllllllllllllIIlIlIIIlllllIlll.provider.getHasNoSky() || lllllllllllllllIIlIlIIIlllllIIll.getY() < 255) && this.field_175908_a.canBlockStay(lllllllllllllllIIlIlIIIlllllIlll, lllllllllllllllIIlIlIIIlllllIIll, this.field_175908_a.getDefaultState())) {
                lllllllllllllllIIlIlIIIlllllIlll.setBlockState(lllllllllllllllIIlIlIIIlllllIIll, this.field_175908_a.getDefaultState(), 2);
            }
        }
        return true;
    }
}
