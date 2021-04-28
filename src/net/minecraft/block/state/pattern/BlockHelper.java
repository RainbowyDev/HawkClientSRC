package net.minecraft.block.state.pattern;

import com.google.common.base.*;
import net.minecraft.block.*;
import net.minecraft.block.state.*;

public class BlockHelper implements Predicate
{
    private final /* synthetic */ Block block;
    
    static {
        __OBFID = "CL_00002020";
    }
    
    public static BlockHelper forBlock(final Block llllllllllllllIllIlIIIlllIIlllII) {
        return new BlockHelper(llllllllllllllIllIlIIIlllIIlllII);
    }
    
    public boolean apply(final Object llllllllllllllIllIlIIIlllIIIllll) {
        return this.isBlockEqualTo((IBlockState)llllllllllllllIllIlIIIlllIIIllll);
    }
    
    public boolean isBlockEqualTo(final IBlockState llllllllllllllIllIlIIIlllIIlIlll) {
        return llllllllllllllIllIlIIIlllIIlIlll != null && llllllllllllllIllIlIIIlllIIlIlll.getBlock() == this.block;
    }
    
    private BlockHelper(final Block llllllllllllllIllIlIIIlllIlIIIII) {
        this.block = llllllllllllllIllIlIIIlllIlIIIII;
    }
}
