package net.minecraft.world.gen.feature;

import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;

public class WorldGenLiquids extends WorldGenerator
{
    private /* synthetic */ Block field_150521_a;
    
    @Override
    public boolean generate(final World llllllllllllllllIlIIlllIIllIllIl, final Random llllllllllllllllIlIIlllIIllIllII, final BlockPos llllllllllllllllIlIIlllIIllIIlIl) {
        if (llllllllllllllllIlIIlllIIllIllIl.getBlockState(llllllllllllllllIlIIlllIIllIIlIl.offsetUp()).getBlock() != Blocks.stone) {
            return false;
        }
        if (llllllllllllllllIlIIlllIIllIllIl.getBlockState(llllllllllllllllIlIIlllIIllIIlIl.offsetDown()).getBlock() != Blocks.stone) {
            return false;
        }
        if (llllllllllllllllIlIIlllIIllIllIl.getBlockState(llllllllllllllllIlIIlllIIllIIlIl).getBlock().getMaterial() != Material.air && llllllllllllllllIlIIlllIIllIllIl.getBlockState(llllllllllllllllIlIIlllIIllIIlIl).getBlock() != Blocks.stone) {
            return false;
        }
        int llllllllllllllllIlIIlllIIllIlIlI = 0;
        if (llllllllllllllllIlIIlllIIllIllIl.getBlockState(llllllllllllllllIlIIlllIIllIIlIl.offsetWest()).getBlock() == Blocks.stone) {
            ++llllllllllllllllIlIIlllIIllIlIlI;
        }
        if (llllllllllllllllIlIIlllIIllIllIl.getBlockState(llllllllllllllllIlIIlllIIllIIlIl.offsetEast()).getBlock() == Blocks.stone) {
            ++llllllllllllllllIlIIlllIIllIlIlI;
        }
        if (llllllllllllllllIlIIlllIIllIllIl.getBlockState(llllllllllllllllIlIIlllIIllIIlIl.offsetNorth()).getBlock() == Blocks.stone) {
            ++llllllllllllllllIlIIlllIIllIlIlI;
        }
        if (llllllllllllllllIlIIlllIIllIllIl.getBlockState(llllllllllllllllIlIIlllIIllIIlIl.offsetSouth()).getBlock() == Blocks.stone) {
            ++llllllllllllllllIlIIlllIIllIlIlI;
        }
        int llllllllllllllllIlIIlllIIllIlIIl = 0;
        if (llllllllllllllllIlIIlllIIllIllIl.isAirBlock(llllllllllllllllIlIIlllIIllIIlIl.offsetWest())) {
            ++llllllllllllllllIlIIlllIIllIlIIl;
        }
        if (llllllllllllllllIlIIlllIIllIllIl.isAirBlock(llllllllllllllllIlIIlllIIllIIlIl.offsetEast())) {
            ++llllllllllllllllIlIIlllIIllIlIIl;
        }
        if (llllllllllllllllIlIIlllIIllIllIl.isAirBlock(llllllllllllllllIlIIlllIIllIIlIl.offsetNorth())) {
            ++llllllllllllllllIlIIlllIIllIlIIl;
        }
        if (llllllllllllllllIlIIlllIIllIllIl.isAirBlock(llllllllllllllllIlIIlllIIllIIlIl.offsetSouth())) {
            ++llllllllllllllllIlIIlllIIllIlIIl;
        }
        if (llllllllllllllllIlIIlllIIllIlIlI == 3 && llllllllllllllllIlIIlllIIllIlIIl == 1) {
            llllllllllllllllIlIIlllIIllIllIl.setBlockState(llllllllllllllllIlIIlllIIllIIlIl, this.field_150521_a.getDefaultState(), 2);
            llllllllllllllllIlIIlllIIllIllIl.func_175637_a(this.field_150521_a, llllllllllllllllIlIIlllIIllIIlIl, llllllllllllllllIlIIlllIIllIllII);
        }
        return true;
    }
    
    public WorldGenLiquids(final Block llllllllllllllllIlIIlllIIlllIlIl) {
        this.field_150521_a = llllllllllllllllIlIIlllIIlllIlIl;
    }
    
    static {
        __OBFID = "CL_00000434";
    }
}
