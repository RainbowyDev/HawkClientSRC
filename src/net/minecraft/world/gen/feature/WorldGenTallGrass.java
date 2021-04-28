package net.minecraft.world.gen.feature;

import net.minecraft.block.state.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;

public class WorldGenTallGrass extends WorldGenerator
{
    private final /* synthetic */ IBlockState field_175907_a;
    
    static {
        __OBFID = "CL_00000437";
    }
    
    @Override
    public boolean generate(final World llllllllllllllIlllIlIlIIIIIllIII, final Random llllllllllllllIlllIlIlIIIIIlllll, BlockPos llllllllllllllIlllIlIlIIIIIlIllI) {
        Block llllllllllllllIlllIlIlIIIIIlllII;
        while (((llllllllllllllIlllIlIlIIIIIlllII = llllllllllllllIlllIlIlIIIIIllIII.getBlockState(llllllllllllllIlllIlIlIIIIIlIllI).getBlock()).getMaterial() == Material.air || llllllllllllllIlllIlIlIIIIIlllII.getMaterial() == Material.leaves) && llllllllllllllIlllIlIlIIIIIlIllI.getY() > 0) {
            llllllllllllllIlllIlIlIIIIIlIllI = llllllllllllllIlllIlIlIIIIIlIllI.offsetDown();
        }
        for (int llllllllllllllIlllIlIlIIIIIllIll = 0; llllllllllllllIlllIlIlIIIIIllIll < 128; ++llllllllllllllIlllIlIlIIIIIllIll) {
            final BlockPos llllllllllllllIlllIlIlIIIIIllIlI = llllllllllllllIlllIlIlIIIIIlIllI.add(llllllllllllllIlllIlIlIIIIIlllll.nextInt(8) - llllllllllllllIlllIlIlIIIIIlllll.nextInt(8), llllllllllllllIlllIlIlIIIIIlllll.nextInt(4) - llllllllllllllIlllIlIlIIIIIlllll.nextInt(4), llllllllllllllIlllIlIlIIIIIlllll.nextInt(8) - llllllllllllllIlllIlIlIIIIIlllll.nextInt(8));
            if (llllllllllllllIlllIlIlIIIIIllIII.isAirBlock(llllllllllllllIlllIlIlIIIIIllIlI) && Blocks.tallgrass.canBlockStay(llllllllllllllIlllIlIlIIIIIllIII, llllllllllllllIlllIlIlIIIIIllIlI, this.field_175907_a)) {
                llllllllllllllIlllIlIlIIIIIllIII.setBlockState(llllllllllllllIlllIlIlIIIIIllIlI, this.field_175907_a, 2);
            }
        }
        return true;
    }
    
    public WorldGenTallGrass(final BlockTallGrass.EnumType llllllllllllllIlllIlIlIIIIlIlIIl) {
        this.field_175907_a = Blocks.tallgrass.getDefaultState().withProperty(BlockTallGrass.field_176497_a, llllllllllllllIlllIlIlIIIIlIlIIl);
    }
}
