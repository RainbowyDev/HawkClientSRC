package net.minecraft.block;

import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class BlockClay extends Block
{
    public BlockClay() {
        super(Material.clay);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllllIlIllllIlIIIlllIlI) {
        return 4;
    }
    
    static {
        __OBFID = "CL_00000215";
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIlIllllIlIIIlllllI, final Random llllllllllllllIlIllllIlIIIllllIl, final int llllllllllllllIlIllllIlIIIllllII) {
        return Items.clay_ball;
    }
}
