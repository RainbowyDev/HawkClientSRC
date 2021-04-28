package net.minecraft.block;

import net.minecraft.block.state.*;
import net.minecraft.entity.player.*;
import net.minecraft.tileentity.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;

public class BlockSign extends BlockContainer
{
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllllllIllIIlIlIllIIIIl, final BlockPos llllllllllllllllIllIIlIlIlIlIlll, final IBlockState llllllllllllllllIllIIlIlIlIlllll, final EntityPlayer llllllllllllllllIllIIlIlIlIlIllI, final EnumFacing llllllllllllllllIllIIlIlIlIlllIl, final float llllllllllllllllIllIIlIlIlIlllII, final float llllllllllllllllIllIIlIlIlIllIll, final float llllllllllllllllIllIIlIlIlIllIlI) {
        if (llllllllllllllllIllIIlIlIllIIIIl.isRemote) {
            return true;
        }
        final TileEntity llllllllllllllllIllIIlIlIlIllIIl = llllllllllllllllIllIIlIlIllIIIIl.getTileEntity(llllllllllllllllIllIIlIlIlIlIlll);
        return llllllllllllllllIllIIlIlIlIllIIl instanceof TileEntitySign && ((TileEntitySign)llllllllllllllllIllIIlIlIlIllIIl).func_174882_b(llllllllllllllllIllIIlIlIlIlIllI);
    }
    
    @Override
    public boolean isPassable(final IBlockAccess llllllllllllllllIllIIlIlIlllIIll, final BlockPos llllllllllllllllIllIIlIlIlllIIlI) {
        return true;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllllIllIIlIlIllIllII, final Random llllllllllllllllIllIIlIlIllIlIll, final int llllllllllllllllIllIIlIlIllIlIlI) {
        return Items.sign;
    }
    
    @Override
    public AxisAlignedBB getSelectedBoundingBox(final World llllllllllllllllIllIIlIlIlllIlll, final BlockPos llllllllllllllllIllIIlIlIlllIllI) {
        this.setBlockBoundsBasedOnState(llllllllllllllllIllIIlIlIlllIlll, llllllllllllllllIllIIlIlIlllIllI);
        return super.getSelectedBoundingBox(llllllllllllllllIllIIlIlIlllIlll, llllllllllllllllIllIIlIlIlllIllI);
    }
    
    protected BlockSign() {
        super(Material.wood);
        final float llllllllllllllllIllIIlIllIIIIlll = 0.25f;
        final float llllllllllllllllIllIIlIllIIIIllI = 1.0f;
        this.setBlockBounds(0.5f - llllllllllllllllIllIIlIllIIIIlll, 0.0f, 0.5f - llllllllllllllllIllIIlIllIIIIlll, 0.5f + llllllllllllllllIllIIlIllIIIIlll, llllllllllllllllIllIIlIllIIIIllI, 0.5f + llllllllllllllllIllIIlIllIIIIlll);
    }
    
    static {
        __OBFID = "CL_00000306";
    }
    
    @Override
    public Item getItem(final World llllllllllllllllIllIIlIlIllIlIII, final BlockPos llllllllllllllllIllIIlIlIllIIlll) {
        return Items.sign;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World llllllllllllllllIllIIlIllIIIIIIl, final BlockPos llllllllllllllllIllIIlIllIIIIIII, final IBlockState llllllllllllllllIllIIlIlIlllllll) {
        return null;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllllllIllIIlIlIllIllll, final int llllllllllllllllIllIIlIlIllIlllI) {
        return new TileEntitySign();
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
}
