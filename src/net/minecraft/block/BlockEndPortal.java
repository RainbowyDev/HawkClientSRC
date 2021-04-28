package net.minecraft.block;

import net.minecraft.block.state.*;
import net.minecraft.tileentity.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;
import java.util.*;

public class BlockEndPortal extends BlockContainer
{
    @Override
    public void randomDisplayTick(final World llllllllllllllllIIIlIllIlIlIIlII, final BlockPos llllllllllllllllIIIlIllIlIlIIIll, final IBlockState llllllllllllllllIIIlIllIlIlIIIlI, final Random llllllllllllllllIIIlIllIlIIllIII) {
        final double llllllllllllllllIIIlIllIlIlIIIII = llllllllllllllllIIIlIllIlIlIIIll.getX() + llllllllllllllllIIIlIllIlIIllIII.nextFloat();
        final double llllllllllllllllIIIlIllIlIIlllll = llllllllllllllllIIIlIllIlIlIIIll.getY() + 0.8f;
        final double llllllllllllllllIIIlIllIlIIllllI = llllllllllllllllIIIlIllIlIlIIIll.getZ() + llllllllllllllllIIIlIllIlIIllIII.nextFloat();
        final double llllllllllllllllIIIlIllIlIIlllIl = 0.0;
        final double llllllllllllllllIIIlIllIlIIlllII = 0.0;
        final double llllllllllllllllIIIlIllIlIIllIll = 0.0;
        llllllllllllllllIIIlIllIlIlIIlII.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, llllllllllllllllIIIlIllIlIlIIIII, llllllllllllllllIIIlIllIlIIlllll, llllllllllllllllIIIlIllIlIIllllI, llllllllllllllllIIIlIllIlIIlllIl, llllllllllllllllIIIlIllIlIIlllII, llllllllllllllllIIIlIllIlIIllIll, new int[0]);
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public MapColor getMapColor(final IBlockState llllllllllllllllIIIlIllIlIIIllIl) {
        return MapColor.obsidianColor;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllllllIIIlIllIllIllIII, final int llllllllllllllllIIIlIllIllIlIlll) {
        return new TileEntityEndPortal();
    }
    
    @Override
    public Item getItem(final World llllllllllllllllIIIlIllIlIIlIIII, final BlockPos llllllllllllllllIIIlIllIlIIIllll) {
        return null;
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockAccess llllllllllllllllIIIlIllIllIIlIIl, final BlockPos llllllllllllllllIIIlIllIllIIIlII, final EnumFacing llllllllllllllllIIIlIllIllIIIlll) {
        return llllllllllllllllIIIlIllIllIIIlll == EnumFacing.DOWN && super.shouldSideBeRendered(llllllllllllllllIIIlIllIllIIlIIl, llllllllllllllllIIIlIllIllIIIlII, llllllllllllllllIIIlIllIllIIIlll);
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllllllIIIlIllIlIlllIII) {
        return 0;
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World llllllllllllllllIIIlIllIlIllIIII, final BlockPos llllllllllllllllIIIlIllIlIllIIll, final IBlockState llllllllllllllllIIIlIllIlIllIIlI, final Entity llllllllllllllllIIIlIllIlIllIIIl) {
        if (llllllllllllllllIIIlIllIlIllIIIl.ridingEntity == null && llllllllllllllllIIIlIllIlIllIIIl.riddenByEntity == null && !llllllllllllllllIIIlIllIlIllIIII.isRemote) {
            llllllllllllllllIIIlIllIlIllIIIl.travelToDimension(1);
        }
    }
    
    protected BlockEndPortal(final Material llllllllllllllllIIIlIllIllIllIlI) {
        super(llllllllllllllllIIIlIllIllIllIlI);
        this.setLightLevel(1.0f);
    }
    
    static {
        __OBFID = "CL_00000236";
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess llllllllllllllllIIIlIllIllIlIIll, final BlockPos llllllllllllllllIIIlIllIllIlIIlI) {
        final float llllllllllllllllIIIlIllIllIlIIIl = 0.0625f;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, llllllllllllllllIIIlIllIllIlIIIl, 1.0f);
    }
    
    @Override
    public void addCollisionBoxesToList(final World llllllllllllllllIIIlIllIllIIIIIl, final BlockPos llllllllllllllllIIIlIllIllIIIIII, final IBlockState llllllllllllllllIIIlIllIlIllllll, final AxisAlignedBB llllllllllllllllIIIlIllIlIlllllI, final List llllllllllllllllIIIlIllIlIllllIl, final Entity llllllllllllllllIIIlIllIlIllllII) {
    }
}
