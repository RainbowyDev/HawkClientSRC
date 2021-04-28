package net.minecraft.block;

import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.*;
import net.minecraft.creativetab.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;

public class BlockFence extends Block
{
    public static final /* synthetic */ PropertyBool EAST;
    public static final /* synthetic */ PropertyBool WEST;
    public static final /* synthetic */ PropertyBool SOUTH;
    public static final /* synthetic */ PropertyBool NORTH;
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public void addCollisionBoxesToList(final World lllllllllllllllllllIIlIlllIIIIIl, final BlockPos lllllllllllllllllllIIlIlllIIIIII, final IBlockState lllllllllllllllllllIIlIlllIIlllI, final AxisAlignedBB lllllllllllllllllllIIlIlllIIllIl, final List lllllllllllllllllllIIlIlllIIllII, final Entity lllllllllllllllllllIIlIllIllllII) {
        final boolean lllllllllllllllllllIIlIlllIIlIlI = this.func_176524_e(lllllllllllllllllllIIlIlllIIIIIl, lllllllllllllllllllIIlIlllIIIIII.offsetNorth());
        final boolean lllllllllllllllllllIIlIlllIIlIIl = this.func_176524_e(lllllllllllllllllllIIlIlllIIIIIl, lllllllllllllllllllIIlIlllIIIIII.offsetSouth());
        final boolean lllllllllllllllllllIIlIlllIIlIII = this.func_176524_e(lllllllllllllllllllIIlIlllIIIIIl, lllllllllllllllllllIIlIlllIIIIII.offsetWest());
        final boolean lllllllllllllllllllIIlIlllIIIlll = this.func_176524_e(lllllllllllllllllllIIlIlllIIIIIl, lllllllllllllllllllIIlIlllIIIIII.offsetEast());
        float lllllllllllllllllllIIlIlllIIIllI = 0.375f;
        float lllllllllllllllllllIIlIlllIIIlIl = 0.625f;
        float lllllllllllllllllllIIlIlllIIIlII = 0.375f;
        float lllllllllllllllllllIIlIlllIIIIll = 0.625f;
        if (lllllllllllllllllllIIlIlllIIlIlI) {
            lllllllllllllllllllIIlIlllIIIlII = 0.0f;
        }
        if (lllllllllllllllllllIIlIlllIIlIIl) {
            lllllllllllllllllllIIlIlllIIIIll = 1.0f;
        }
        if (lllllllllllllllllllIIlIlllIIlIlI || lllllllllllllllllllIIlIlllIIlIIl) {
            this.setBlockBounds(lllllllllllllllllllIIlIlllIIIllI, 0.0f, lllllllllllllllllllIIlIlllIIIlII, lllllllllllllllllllIIlIlllIIIlIl, 1.5f, lllllllllllllllllllIIlIlllIIIIll);
            super.addCollisionBoxesToList(lllllllllllllllllllIIlIlllIIIIIl, lllllllllllllllllllIIlIlllIIIIII, lllllllllllllllllllIIlIlllIIlllI, lllllllllllllllllllIIlIlllIIllIl, lllllllllllllllllllIIlIlllIIllII, lllllllllllllllllllIIlIllIllllII);
        }
        lllllllllllllllllllIIlIlllIIIlII = 0.375f;
        lllllllllllllllllllIIlIlllIIIIll = 0.625f;
        if (lllllllllllllllllllIIlIlllIIlIII) {
            lllllllllllllllllllIIlIlllIIIllI = 0.0f;
        }
        if (lllllllllllllllllllIIlIlllIIIlll) {
            lllllllllllllllllllIIlIlllIIIlIl = 1.0f;
        }
        if (lllllllllllllllllllIIlIlllIIlIII || lllllllllllllllllllIIlIlllIIIlll || (!lllllllllllllllllllIIlIlllIIlIlI && !lllllllllllllllllllIIlIlllIIlIIl)) {
            this.setBlockBounds(lllllllllllllllllllIIlIlllIIIllI, 0.0f, lllllllllllllllllllIIlIlllIIIlII, lllllllllllllllllllIIlIlllIIIlIl, 1.5f, lllllllllllllllllllIIlIlllIIIIll);
            super.addCollisionBoxesToList(lllllllllllllllllllIIlIlllIIIIIl, lllllllllllllllllllIIlIlllIIIIII, lllllllllllllllllllIIlIlllIIlllI, lllllllllllllllllllIIlIlllIIllIl, lllllllllllllllllllIIlIlllIIllII, lllllllllllllllllllIIlIllIllllII);
        }
        if (lllllllllllllllllllIIlIlllIIlIlI) {
            lllllllllllllllllllIIlIlllIIIlII = 0.0f;
        }
        if (lllllllllllllllllllIIlIlllIIlIIl) {
            lllllllllllllllllllIIlIlllIIIIll = 1.0f;
        }
        this.setBlockBounds(lllllllllllllllllllIIlIlllIIIllI, 0.0f, lllllllllllllllllllIIlIlllIIIlII, lllllllllllllllllllIIlIlllIIIlIl, 1.0f, lllllllllllllllllllIIlIlllIIIIll);
    }
    
    @Override
    public boolean isPassable(final IBlockAccess lllllllllllllllllllIIlIllIIIllll, final BlockPos lllllllllllllllllllIIlIllIIIlllI) {
        return false;
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess lllllllllllllllllllIIlIllIlIIlll, final BlockPos lllllllllllllllllllIIlIllIlIIllI) {
        final boolean lllllllllllllllllllIIlIllIlIIlIl = this.func_176524_e(lllllllllllllllllllIIlIllIlIIlll, lllllllllllllllllllIIlIllIlIIllI.offsetNorth());
        final boolean lllllllllllllllllllIIlIllIlIIlII = this.func_176524_e(lllllllllllllllllllIIlIllIlIIlll, lllllllllllllllllllIIlIllIlIIllI.offsetSouth());
        final boolean lllllllllllllllllllIIlIllIlIIIll = this.func_176524_e(lllllllllllllllllllIIlIllIlIIlll, lllllllllllllllllllIIlIllIlIIllI.offsetWest());
        final boolean lllllllllllllllllllIIlIllIlIIIlI = this.func_176524_e(lllllllllllllllllllIIlIllIlIIlll, lllllllllllllllllllIIlIllIlIIllI.offsetEast());
        float lllllllllllllllllllIIlIllIlIIIIl = 0.375f;
        float lllllllllllllllllllIIlIllIlIIIII = 0.625f;
        float lllllllllllllllllllIIlIllIIlllll = 0.375f;
        float lllllllllllllllllllIIlIllIIllllI = 0.625f;
        if (lllllllllllllllllllIIlIllIlIIlIl) {
            lllllllllllllllllllIIlIllIIlllll = 0.0f;
        }
        if (lllllllllllllllllllIIlIllIlIIlII) {
            lllllllllllllllllllIIlIllIIllllI = 1.0f;
        }
        if (lllllllllllllllllllIIlIllIlIIIll) {
            lllllllllllllllllllIIlIllIlIIIIl = 0.0f;
        }
        if (lllllllllllllllllllIIlIllIlIIIlI) {
            lllllllllllllllllllIIlIllIlIIIII = 1.0f;
        }
        this.setBlockBounds(lllllllllllllllllllIIlIllIlIIIIl, 0.0f, lllllllllllllllllllIIlIllIIlllll, lllllllllllllllllllIIlIllIlIIIII, 1.0f, lllllllllllllllllllIIlIllIIllllI);
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    public boolean func_176524_e(final IBlockAccess lllllllllllllllllllIIlIllIIIIlII, final BlockPos lllllllllllllllllllIIlIllIIIIIll) {
        final Block lllllllllllllllllllIIlIllIIIIllI = lllllllllllllllllllIIlIllIIIIlII.getBlockState(lllllllllllllllllllIIlIllIIIIIll).getBlock();
        return lllllllllllllllllllIIlIllIIIIllI != Blocks.barrier && ((lllllllllllllllllllIIlIllIIIIllI instanceof BlockFence && lllllllllllllllllllIIlIllIIIIllI.blockMaterial == this.blockMaterial) || lllllllllllllllllllIIlIllIIIIllI instanceof BlockFenceGate || (lllllllllllllllllllIIlIllIIIIllI.blockMaterial.isOpaque() && lllllllllllllllllllIIlIllIIIIllI.isFullCube() && lllllllllllllllllllIIlIllIIIIllI.blockMaterial != Material.gourd));
    }
    
    @Override
    public IBlockState getActualState(final IBlockState lllllllllllllllllllIIlIlIllIIlll, final IBlockAccess lllllllllllllllllllIIlIlIllIIllI, final BlockPos lllllllllllllllllllIIlIlIllIIlIl) {
        return lllllllllllllllllllIIlIlIllIIlll.withProperty(BlockFence.NORTH, this.func_176524_e(lllllllllllllllllllIIlIlIllIIllI, lllllllllllllllllllIIlIlIllIIlIl.offsetNorth())).withProperty(BlockFence.EAST, this.func_176524_e(lllllllllllllllllllIIlIlIllIIllI, lllllllllllllllllllIIlIlIllIIlIl.offsetEast())).withProperty(BlockFence.SOUTH, this.func_176524_e(lllllllllllllllllllIIlIlIllIIllI, lllllllllllllllllllIIlIlIllIIlIl.offsetSouth())).withProperty(BlockFence.WEST, this.func_176524_e(lllllllllllllllllllIIlIlIllIIllI, lllllllllllllllllllIIlIlIllIIlIl.offsetWest()));
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockAccess lllllllllllllllllllIIlIllIIIIIII, final BlockPos lllllllllllllllllllIIlIlIlllllll, final EnumFacing lllllllllllllllllllIIlIlIllllllI) {
        return true;
    }
    
    static {
        __OBFID = "CL_00000242";
        NORTH = PropertyBool.create("north");
        EAST = PropertyBool.create("east");
        SOUTH = PropertyBool.create("south");
        WEST = PropertyBool.create("west");
    }
    
    public BlockFence(final Material lllllllllllllllllllIIlIllllIIIIl) {
        super(lllllllllllllllllllIIlIllllIIIIl);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockFence.NORTH, false).withProperty(BlockFence.EAST, false).withProperty(BlockFence.SOUTH, false).withProperty(BlockFence.WEST, false));
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllllllIIlIlIllIllIl) {
        return 0;
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockFence.NORTH, BlockFence.EAST, BlockFence.WEST, BlockFence.SOUTH });
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllllllllIIlIlIlllIIIl, final BlockPos lllllllllllllllllllIIlIlIllllIII, final IBlockState lllllllllllllllllllIIlIlIlllIlll, final EntityPlayer lllllllllllllllllllIIlIlIllIllll, final EnumFacing lllllllllllllllllllIIlIlIlllIlIl, final float lllllllllllllllllllIIlIlIlllIlII, final float lllllllllllllllllllIIlIlIlllIIll, final float lllllllllllllllllllIIlIlIlllIIlI) {
        return lllllllllllllllllllIIlIlIlllIIIl.isRemote || ItemLead.func_180618_a(lllllllllllllllllllIIlIlIllIllll, lllllllllllllllllllIIlIlIlllIIIl, lllllllllllllllllllIIlIlIllllIII);
    }
}
