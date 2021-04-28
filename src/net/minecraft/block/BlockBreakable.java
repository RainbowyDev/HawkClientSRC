package net.minecraft.block;

import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;

public class BlockBreakable extends Block
{
    private /* synthetic */ boolean ignoreSimilarity;
    
    protected BlockBreakable(final Material llllllllllllllIllllIllIlIlIlIIII, final boolean llllllllllllllIllllIllIlIlIIllII) {
        super(llllllllllllllIllllIllIlIlIlIIII);
        this.ignoreSimilarity = llllllllllllllIllllIllIlIlIIllII;
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockAccess llllllllllllllIllllIllIlIlIIIIll, final BlockPos llllllllllllllIllllIllIlIIllllII, final EnumFacing llllllllllllllIllllIllIlIlIIIIIl) {
        final IBlockState llllllllllllllIllllIllIlIlIIIIII = llllllllllllllIllllIllIlIlIIIIll.getBlockState(llllllllllllllIllllIllIlIIllllII);
        final Block llllllllllllllIllllIllIlIIllllll = llllllllllllllIllllIllIlIlIIIIII.getBlock();
        if (this == Blocks.glass || this == Blocks.stained_glass) {
            if (llllllllllllllIllllIllIlIlIIIIll.getBlockState(llllllllllllllIllllIllIlIIllllII.offset(llllllllllllllIllllIllIlIlIIIIIl.getOpposite())) != llllllllllllllIllllIllIlIlIIIIII) {
                return true;
            }
            if (llllllllllllllIllllIllIlIIllllll == this) {
                return false;
            }
        }
        return (this.ignoreSimilarity || llllllllllllllIllllIllIlIIllllll != this) && super.shouldSideBeRendered(llllllllllllllIllllIllIlIlIIIIll, llllllllllllllIllllIllIlIIllllII, llllllllllllllIllllIllIlIlIIIIIl);
    }
    
    static {
        __OBFID = "CL_00000254";
    }
}
