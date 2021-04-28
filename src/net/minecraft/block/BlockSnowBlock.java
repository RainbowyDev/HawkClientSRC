package net.minecraft.block;

import net.minecraft.util.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;

public class BlockSnowBlock extends Block
{
    @Override
    public void updateTick(final World llllllllllllllIllllIlIlIIIIIIlIl, final BlockPos llllllllllllllIllllIlIlIIIIIIIll, final IBlockState llllllllllllllIllllIlIlIIIIIIIIl, final Random llllllllllllllIllllIlIIlllllllll) {
        if (llllllllllllllIllllIlIlIIIIIIlIl.getLightFor(EnumSkyBlock.BLOCK, llllllllllllllIllllIlIlIIIIIIIll) > 11) {
            this.dropBlockAsItem(llllllllllllllIllllIlIlIIIIIIlIl, llllllllllllllIllllIlIlIIIIIIIll, llllllllllllllIllllIlIlIIIIIIlIl.getBlockState(llllllllllllllIllllIlIlIIIIIIIll), 0);
            llllllllllllllIllllIlIlIIIIIIlIl.setBlockToAir(llllllllllllllIllllIlIlIIIIIIIll);
        }
    }
    
    static {
        __OBFID = "CL_00000308";
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIllllIlIlIIIIllIlI, final Random llllllllllllllIllllIlIlIIIIllIIl, final int llllllllllllllIllllIlIlIIIIllIII) {
        return Items.snowball;
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllllIllllIlIlIIIIlIIll) {
        return 4;
    }
    
    protected BlockSnowBlock() {
        super(Material.craftedSnow);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
}
