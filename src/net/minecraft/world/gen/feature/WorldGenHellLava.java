package net.minecraft.world.gen.feature;

import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;

public class WorldGenHellLava extends WorldGenerator
{
    private final /* synthetic */ boolean field_94524_b;
    private final /* synthetic */ Block field_150553_a;
    
    static {
        __OBFID = "CL_00000414";
    }
    
    public WorldGenHellLava(final Block llllllllllllllIlIIllIlllIllllIIl, final boolean llllllllllllllIlIIllIlllIllllIII) {
        this.field_150553_a = llllllllllllllIlIIllIlllIllllIIl;
        this.field_94524_b = llllllllllllllIlIIllIlllIllllIII;
    }
    
    @Override
    public boolean generate(final World llllllllllllllIlIIllIlllIllIllIl, final Random llllllllllllllIlIIllIlllIllIIllI, final BlockPos llllllllllllllIlIIllIlllIllIIlIl) {
        if (llllllllllllllIlIIllIlllIllIllIl.getBlockState(llllllllllllllIlIIllIlllIllIIlIl.offsetUp()).getBlock() != Blocks.netherrack) {
            return false;
        }
        if (llllllllllllllIlIIllIlllIllIllIl.getBlockState(llllllllllllllIlIIllIlllIllIIlIl).getBlock().getMaterial() != Material.air && llllllllllllllIlIIllIlllIllIllIl.getBlockState(llllllllllllllIlIIllIlllIllIIlIl).getBlock() != Blocks.netherrack) {
            return false;
        }
        int llllllllllllllIlIIllIlllIllIlIlI = 0;
        if (llllllllllllllIlIIllIlllIllIllIl.getBlockState(llllllllllllllIlIIllIlllIllIIlIl.offsetWest()).getBlock() == Blocks.netherrack) {
            ++llllllllllllllIlIIllIlllIllIlIlI;
        }
        if (llllllllllllllIlIIllIlllIllIllIl.getBlockState(llllllllllllllIlIIllIlllIllIIlIl.offsetEast()).getBlock() == Blocks.netherrack) {
            ++llllllllllllllIlIIllIlllIllIlIlI;
        }
        if (llllllllllllllIlIIllIlllIllIllIl.getBlockState(llllllllllllllIlIIllIlllIllIIlIl.offsetNorth()).getBlock() == Blocks.netherrack) {
            ++llllllllllllllIlIIllIlllIllIlIlI;
        }
        if (llllllllllllllIlIIllIlllIllIllIl.getBlockState(llllllllllllllIlIIllIlllIllIIlIl.offsetSouth()).getBlock() == Blocks.netherrack) {
            ++llllllllllllllIlIIllIlllIllIlIlI;
        }
        if (llllllllllllllIlIIllIlllIllIllIl.getBlockState(llllllllllllllIlIIllIlllIllIIlIl.offsetDown()).getBlock() == Blocks.netherrack) {
            ++llllllllllllllIlIIllIlllIllIlIlI;
        }
        int llllllllllllllIlIIllIlllIllIlIIl = 0;
        if (llllllllllllllIlIIllIlllIllIllIl.isAirBlock(llllllllllllllIlIIllIlllIllIIlIl.offsetWest())) {
            ++llllllllllllllIlIIllIlllIllIlIIl;
        }
        if (llllllllllllllIlIIllIlllIllIllIl.isAirBlock(llllllllllllllIlIIllIlllIllIIlIl.offsetEast())) {
            ++llllllllllllllIlIIllIlllIllIlIIl;
        }
        if (llllllllllllllIlIIllIlllIllIllIl.isAirBlock(llllllllllllllIlIIllIlllIllIIlIl.offsetNorth())) {
            ++llllllllllllllIlIIllIlllIllIlIIl;
        }
        if (llllllllllllllIlIIllIlllIllIllIl.isAirBlock(llllllllllllllIlIIllIlllIllIIlIl.offsetSouth())) {
            ++llllllllllllllIlIIllIlllIllIlIIl;
        }
        if (llllllllllllllIlIIllIlllIllIllIl.isAirBlock(llllllllllllllIlIIllIlllIllIIlIl.offsetDown())) {
            ++llllllllllllllIlIIllIlllIllIlIIl;
        }
        if ((!this.field_94524_b && llllllllllllllIlIIllIlllIllIlIlI == 4 && llllllllllllllIlIIllIlllIllIlIIl == 1) || llllllllllllllIlIIllIlllIllIlIlI == 5) {
            llllllllllllllIlIIllIlllIllIllIl.setBlockState(llllllllllllllIlIIllIlllIllIIlIl, this.field_150553_a.getDefaultState(), 2);
            llllllllllllllIlIIllIlllIllIllIl.func_175637_a(this.field_150553_a, llllllllllllllIlIIllIlllIllIIlIl, llllllllllllllIlIIllIlllIllIIllI);
        }
        return true;
    }
}
