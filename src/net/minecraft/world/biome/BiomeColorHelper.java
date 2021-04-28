package net.minecraft.world.biome;

import net.minecraft.world.*;
import net.minecraft.util.*;
import java.util.*;

public class BiomeColorHelper
{
    private static final /* synthetic */ ColorResolver field_180291_a;
    private static final /* synthetic */ ColorResolver field_180289_b;
    private static final /* synthetic */ ColorResolver field_180290_c;
    
    private static int func_180285_a(final IBlockAccess lIlIIIllllIIllI, final BlockPos lIlIIIllllIlllI, final ColorResolver lIlIIIllllIllIl) {
        int lIlIIIllllIllII = 0;
        int lIlIIIllllIlIll = 0;
        int lIlIIIllllIlIlI = 0;
        for (final BlockPos.MutableBlockPos lIlIIIllllIIlll : BlockPos.getAllInBoxMutable(lIlIIIllllIlllI.add(-1, 0, -1), lIlIIIllllIlllI.add(1, 0, 1))) {
            final int lIlIIIllllIlIIl = lIlIIIllllIllIl.func_180283_a(lIlIIIllllIIllI.getBiomeGenForCoords(lIlIIIllllIIlll), lIlIIIllllIIlll);
            lIlIIIllllIllII += (lIlIIIllllIlIIl & 0xFF0000) >> 16;
            lIlIIIllllIlIll += (lIlIIIllllIlIIl & 0xFF00) >> 8;
            lIlIIIllllIlIlI += (lIlIIIllllIlIIl & 0xFF);
        }
        return (lIlIIIllllIllII / 9 & 0xFF) << 16 | (lIlIIIllllIlIll / 9 & 0xFF) << 8 | (lIlIIIllllIlIlI / 9 & 0xFF);
    }
    
    public static int func_180287_b(final IBlockAccess lIlIIIlllIlIIll, final BlockPos lIlIIIlllIlIIlI) {
        return func_180285_a(lIlIIIlllIlIIll, lIlIIIlllIlIIlI, BiomeColorHelper.field_180289_b);
    }
    
    public static int func_180288_c(final IBlockAccess lIlIIIlllIIllIl, final BlockPos lIlIIIlllIIlllI) {
        return func_180285_a(lIlIIIlllIIllIl, lIlIIIlllIIlllI, BiomeColorHelper.field_180290_c);
    }
    
    public static int func_180286_a(final IBlockAccess lIlIIIlllIllIIl, final BlockPos lIlIIIlllIllIII) {
        return func_180285_a(lIlIIIlllIllIIl, lIlIIIlllIllIII, BiomeColorHelper.field_180291_a);
    }
    
    static {
        __OBFID = "CL_00002149";
        field_180291_a = new ColorResolver() {
            @Override
            public int func_180283_a(final BiomeGenBase lllllllllllllllllIlIIlIIlIIlIlll, final BlockPos lllllllllllllllllIlIIlIIlIIllIII) {
                return lllllllllllllllllIlIIlIIlIIlIlll.func_180627_b(lllllllllllllllllIlIIlIIlIIllIII);
            }
            
            static {
                __OBFID = "CL_00002148";
            }
        };
        field_180289_b = new ColorResolver() {
            static {
                __OBFID = "CL_00002147";
            }
            
            @Override
            public int func_180283_a(final BiomeGenBase lllllllllllllllIIIIIlIlllIllIllI, final BlockPos lllllllllllllllIIIIIlIlllIllIlIl) {
                return lllllllllllllllIIIIIlIlllIllIllI.func_180625_c(lllllllllllllllIIIIIlIlllIllIlIl);
            }
        };
        field_180290_c = new ColorResolver() {
            @Override
            public int func_180283_a(final BiomeGenBase lllllllllllllllllIIIlllIlIIlllIl, final BlockPos lllllllllllllllllIIIlllIlIIlllII) {
                return lllllllllllllllllIIIlllIlIIlllIl.waterColorMultiplier;
            }
            
            static {
                __OBFID = "CL_00002146";
            }
        };
    }
    
    interface ColorResolver
    {
        int func_180283_a(final BiomeGenBase p0, final BlockPos p1);
    }
}
