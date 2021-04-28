package net.minecraft.block;

import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class BlockGravel extends BlockFalling
{
    static {
        __OBFID = "CL_00000252";
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllllIlllIIIIllllIIIlI, final Random lllllllllllllllIlllIIIIlllIllIll, int lllllllllllllllIlllIIIIlllIllIlI) {
        if (lllllllllllllllIlllIIIIlllIllIlI > 3) {
            lllllllllllllllIlllIIIIlllIllIlI = 3;
        }
        return (lllllllllllllllIlllIIIIlllIllIll.nextInt(10 - lllllllllllllllIlllIIIIlllIllIlI * 3) == 0) ? Items.flint : Item.getItemFromBlock(this);
    }
}
