package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;

public class BlockStandingSign extends BlockSign
{
    public static final /* synthetic */ PropertyInteger ROTATION_PROP;
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockStandingSign.ROTATION_PROP });
    }
    
    @Override
    public void onNeighborBlockChange(final World llllllllllllllIIIIIlIlllllIIIllI, final BlockPos llllllllllllllIIIIIlIlllllIIlIlI, final IBlockState llllllllllllllIIIIIlIlllllIIIlII, final Block llllllllllllllIIIIIlIlllllIIlIII) {
        if (!llllllllllllllIIIIIlIlllllIIIllI.getBlockState(llllllllllllllIIIIIlIlllllIIlIlI.offsetDown()).getBlock().getMaterial().isSolid()) {
            this.dropBlockAsItem(llllllllllllllIIIIIlIlllllIIIllI, llllllllllllllIIIIIlIlllllIIlIlI, llllllllllllllIIIIIlIlllllIIIlII, 0);
            llllllllllllllIIIIIlIlllllIIIllI.setBlockToAir(llllllllllllllIIIIIlIlllllIIlIlI);
        }
        super.onNeighborBlockChange(llllllllllllllIIIIIlIlllllIIIllI, llllllllllllllIIIIIlIlllllIIlIlI, llllllllllllllIIIIIlIlllllIIIlII, llllllllllllllIIIIIlIlllllIIlIII);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIIIIIlIllllIlllIlI) {
        return (int)llllllllllllllIIIIIlIllllIlllIlI.getValue(BlockStandingSign.ROTATION_PROP);
    }
    
    public BlockStandingSign() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockStandingSign.ROTATION_PROP, 0));
    }
    
    static {
        __OBFID = "CL_00002060";
        ROTATION_PROP = PropertyInteger.create("rotation", 0, 15);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIIIIIlIllllIllllIl) {
        return this.getDefaultState().withProperty(BlockStandingSign.ROTATION_PROP, llllllllllllllIIIIIlIllllIllllIl);
    }
}
