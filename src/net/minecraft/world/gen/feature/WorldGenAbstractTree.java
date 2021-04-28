package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;

public abstract class WorldGenAbstractTree extends WorldGenerator
{
    protected void func_175921_a(final World llllllllllllllIIIIllIlIlIlIllIIl, final BlockPos llllllllllllllIIIIllIlIlIlIllIll) {
        if (llllllllllllllIIIIllIlIlIlIllIIl.getBlockState(llllllllllllllIIIIllIlIlIlIllIll).getBlock() != Blocks.dirt) {
            this.func_175903_a(llllllllllllllIIIIllIlIlIlIllIIl, llllllllllllllIIIIllIlIlIlIllIll, Blocks.dirt.getDefaultState());
        }
    }
    
    public WorldGenAbstractTree(final boolean llllllllllllllIIIIllIlIlIllIlIIl) {
        super(llllllllllllllIIIIllIlIlIllIlIIl);
    }
    
    public void func_180711_a(final World llllllllllllllIIIIllIlIlIllIIIll, final Random llllllllllllllIIIIllIlIlIllIIIlI, final BlockPos llllllllllllllIIIIllIlIlIllIIIIl) {
    }
    
    static {
        __OBFID = "CL_00000399";
    }
    
    protected boolean func_150523_a(final Block llllllllllllllIIIIllIlIlIllIIlIl) {
        return llllllllllllllIIIIllIlIlIllIIlIl.getMaterial() == Material.air || llllllllllllllIIIIllIlIlIllIIlIl.getMaterial() == Material.leaves || llllllllllllllIIIIllIlIlIllIIlIl == Blocks.grass || llllllllllllllIIIIllIlIlIllIIlIl == Blocks.dirt || llllllllllllllIIIIllIlIlIllIIlIl == Blocks.log || llllllllllllllIIIIllIlIlIllIIlIl == Blocks.log2 || llllllllllllllIIIIllIlIlIllIIlIl == Blocks.sapling || llllllllllllllIIIIllIlIlIllIIlIl == Blocks.vine;
    }
}
