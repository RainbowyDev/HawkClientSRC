package net.minecraft.world.gen.feature;

import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;

public class WorldGenFlowers extends WorldGenerator
{
    private /* synthetic */ IBlockState field_175915_b;
    private /* synthetic */ BlockFlower flower;
    
    public WorldGenFlowers(final BlockFlower llllllllllllllIllIlIlIllIIIIIlll, final BlockFlower.EnumFlowerType llllllllllllllIllIlIlIllIIIIlIll) {
        this.setGeneratedBlock(llllllllllllllIllIlIlIllIIIIIlll, llllllllllllllIllIlIlIllIIIIlIll);
    }
    
    @Override
    public boolean generate(final World llllllllllllllIllIlIlIlIlllIIIlI, final Random llllllllllllllIllIlIlIlIlllIIlll, final BlockPos llllllllllllllIllIlIlIlIlllIIllI) {
        for (int llllllllllllllIllIlIlIlIlllIIlIl = 0; llllllllllllllIllIlIlIlIlllIIlIl < 64; ++llllllllllllllIllIlIlIlIlllIIlIl) {
            final BlockPos llllllllllllllIllIlIlIlIlllIIlII = llllllllllllllIllIlIlIlIlllIIllI.add(llllllllllllllIllIlIlIlIlllIIlll.nextInt(8) - llllllllllllllIllIlIlIlIlllIIlll.nextInt(8), llllllllllllllIllIlIlIlIlllIIlll.nextInt(4) - llllllllllllllIllIlIlIlIlllIIlll.nextInt(4), llllllllllllllIllIlIlIlIlllIIlll.nextInt(8) - llllllllllllllIllIlIlIlIlllIIlll.nextInt(8));
            if (llllllllllllllIllIlIlIlIlllIIIlI.isAirBlock(llllllllllllllIllIlIlIlIlllIIlII) && (!llllllllllllllIllIlIlIlIlllIIIlI.provider.getHasNoSky() || llllllllllllllIllIlIlIlIlllIIlII.getY() < 255) && this.flower.canBlockStay(llllllllllllllIllIlIlIlIlllIIIlI, llllllllllllllIllIlIlIlIlllIIlII, this.field_175915_b)) {
                llllllllllllllIllIlIlIlIlllIIIlI.setBlockState(llllllllllllllIllIlIlIlIlllIIlII, this.field_175915_b, 2);
            }
        }
        return true;
    }
    
    public void setGeneratedBlock(final BlockFlower llllllllllllllIllIlIlIllIIIIIIII, final BlockFlower.EnumFlowerType llllllllllllllIllIlIlIlIllllllll) {
        this.flower = llllllllllllllIllIlIlIllIIIIIIII;
        this.field_175915_b = llllllllllllllIllIlIlIllIIIIIIII.getDefaultState().withProperty(llllllllllllllIllIlIlIllIIIIIIII.func_176494_l(), llllllllllllllIllIlIlIlIllllllll);
    }
    
    static {
        __OBFID = "CL_00000410";
    }
}
