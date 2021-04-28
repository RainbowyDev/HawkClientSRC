package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.material.*;

public abstract class BlockContainer extends Block implements ITileEntityProvider
{
    @Override
    public boolean onBlockEventReceived(final World lllllllllllllllIlIlIlIIlIlllIIIl, final BlockPos lllllllllllllllIlIlIlIIlIllIlIIl, final IBlockState lllllllllllllllIlIlIlIIlIllIlIII, final int lllllllllllllllIlIlIlIIlIllIlllI, final int lllllllllllllllIlIlIlIIlIllIIllI) {
        super.onBlockEventReceived(lllllllllllllllIlIlIlIIlIlllIIIl, lllllllllllllllIlIlIlIIlIllIlIIl, lllllllllllllllIlIlIlIIlIllIlIII, lllllllllllllllIlIlIlIIlIllIlllI, lllllllllllllllIlIlIlIIlIllIIllI);
        final TileEntity lllllllllllllllIlIlIlIIlIllIllII = lllllllllllllllIlIlIlIIlIlllIIIl.getTileEntity(lllllllllllllllIlIlIlIIlIllIlIIl);
        return lllllllllllllllIlIlIlIIlIllIllII != null && lllllllllllllllIlIlIlIIlIllIllII.receiveClientEvent(lllllllllllllllIlIlIlIIlIllIlllI, lllllllllllllllIlIlIlIIlIllIIllI);
    }
    
    protected BlockContainer(final Material lllllllllllllllIlIlIlIIllIIIIlll) {
        super(lllllllllllllllIlIlIlIIllIIIIlll);
        this.isBlockContainer = true;
    }
    
    static {
        __OBFID = "CL_00000193";
    }
    
    @Override
    public void breakBlock(final World lllllllllllllllIlIlIlIIllIIIIIII, final BlockPos lllllllllllllllIlIlIlIIlIlllllll, final IBlockState lllllllllllllllIlIlIlIIlIllllIlI) {
        super.breakBlock(lllllllllllllllIlIlIlIIllIIIIIII, lllllllllllllllIlIlIlIIlIlllllll, lllllllllllllllIlIlIlIIlIllllIlI);
        lllllllllllllllIlIlIlIIllIIIIIII.removeTileEntity(lllllllllllllllIlIlIlIIlIlllllll);
    }
    
    @Override
    public int getRenderType() {
        return -1;
    }
}
