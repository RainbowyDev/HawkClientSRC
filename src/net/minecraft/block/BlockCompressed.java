package net.minecraft.block;

import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.block.state.*;

public class BlockCompressed extends Block
{
    private final /* synthetic */ MapColor mapColor;
    
    public BlockCompressed(final MapColor llllllllllllllIIIlllIllIllIllIIl) {
        super(Material.iron);
        this.mapColor = llllllllllllllIIIlllIllIllIllIIl;
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    public MapColor getMapColor(final IBlockState llllllllllllllIIIlllIllIllIlIlII) {
        return this.mapColor;
    }
    
    static {
        __OBFID = "CL_00000268";
    }
}
