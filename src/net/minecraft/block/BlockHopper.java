package net.minecraft.block;

import net.minecraft.item.*;
import net.minecraft.tileentity.*;
import net.minecraft.world.*;
import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import com.google.common.base.*;
import net.minecraft.block.state.*;
import net.minecraft.inventory.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.entity.*;

public class BlockHopper extends BlockContainer
{
    public static final /* synthetic */ PropertyDirection field_176430_a;
    public static final /* synthetic */ PropertyBool field_176429_b;
    
    @Override
    public void onBlockPlacedBy(final World llllllllllllllIlllIlIIIlIIIIIllI, final BlockPos llllllllllllllIlllIlIIIlIIIIIlIl, final IBlockState llllllllllllllIlllIlIIIIllllllIl, final EntityLivingBase llllllllllllllIlllIlIIIlIIIIIIll, final ItemStack llllllllllllllIlllIlIIIIlllllIll) {
        super.onBlockPlacedBy(llllllllllllllIlllIlIIIlIIIIIllI, llllllllllllllIlllIlIIIlIIIIIlIl, llllllllllllllIlllIlIIIIllllllIl, llllllllllllllIlllIlIIIlIIIIIIll, llllllllllllllIlllIlIIIIlllllIll);
        if (llllllllllllllIlllIlIIIIlllllIll.hasDisplayName()) {
            final TileEntity llllllllllllllIlllIlIIIlIIIIIIIl = llllllllllllllIlllIlIIIlIIIIIllI.getTileEntity(llllllllllllllIlllIlIIIlIIIIIlIl);
            if (llllllllllllllIlllIlIIIlIIIIIIIl instanceof TileEntityHopper) {
                ((TileEntityHopper)llllllllllllllIlllIlIIIlIIIIIIIl).setCustomName(llllllllllllllIlllIlIIIIlllllIll.getDisplayName());
            }
        }
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockAccess llllllllllllllIlllIlIIIIlIlIlllI, final BlockPos llllllllllllllIlllIlIIIIlIlIllIl, final EnumFacing llllllllllllllIlllIlIIIIlIlIllII) {
        return true;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllllIlllIlIIIlIIIlIIII, final int llllllllllllllIlllIlIIIlIIIIllll) {
        return new TileEntityHopper();
    }
    
    public BlockHopper() {
        super(Material.iron);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockHopper.field_176430_a, EnumFacing.DOWN).withProperty(BlockHopper.field_176429_b, true));
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllllIlllIlIIIIlllIlIII, final BlockPos llllllllllllllIlllIlIIIIllIllllI, final IBlockState llllllllllllllIlllIlIIIIlllIIllI, final EntityPlayer llllllllllllllIlllIlIIIIllIlllIl, final EnumFacing llllllllllllllIlllIlIIIIlllIIlII, final float llllllllllllllIlllIlIIIIlllIIIll, final float llllllllllllllIlllIlIIIIlllIIIlI, final float llllllllllllllIlllIlIIIIlllIIIIl) {
        if (llllllllllllllIlllIlIIIIlllIlIII.isRemote) {
            return true;
        }
        final TileEntity llllllllllllllIlllIlIIIIlllIIIII = llllllllllllllIlllIlIIIIlllIlIII.getTileEntity(llllllllllllllIlllIlIIIIllIllllI);
        if (llllllllllllllIlllIlIIIIlllIIIII instanceof TileEntityHopper) {
            llllllllllllllIlllIlIIIIllIlllIl.displayGUIChest((IInventory)llllllllllllllIlllIlIIIIlllIIIII);
        }
        return true;
    }
    
    @Override
    public void breakBlock(final World llllllllllllllIlllIlIIIIlIllIllI, final BlockPos llllllllllllllIlllIlIIIIlIlllIlI, final IBlockState llllllllllllllIlllIlIIIIlIlllIIl) {
        final TileEntity llllllllllllllIlllIlIIIIlIlllIII = llllllllllllllIlllIlIIIIlIllIllI.getTileEntity(llllllllllllllIlllIlIIIIlIlllIlI);
        if (llllllllllllllIlllIlIIIIlIlllIII instanceof TileEntityHopper) {
            InventoryHelper.dropInventoryItems(llllllllllllllIlllIlIIIIlIllIllI, llllllllllllllIlllIlIIIIlIlllIlI, (IInventory)llllllllllllllIlllIlIIIIlIlllIII);
            llllllllllllllIlllIlIIIIlIllIllI.updateComparatorOutputLevel(llllllllllllllIlllIlIIIIlIlllIlI, this);
        }
        super.breakBlock(llllllllllllllIlllIlIIIIlIllIllI, llllllllllllllIlllIlIIIIlIlllIlI, llllllllllllllIlllIlIIIIlIlllIIl);
    }
    
    public static boolean getActiveStateFromMetadata(final int llllllllllllllIlllIlIIIIlIlIIllI) {
        return (llllllllllllllIlllIlIIIIlIlIIllI & 0x8) != 0x8;
    }
    
    static {
        __OBFID = "CL_00000257";
        field_176430_a = PropertyDirection.create("facing", (Predicate)new Predicate() {
            public boolean apply(final Object llllllllllllllllllIIlllIIIlllIlI) {
                return this.func_180180_a((EnumFacing)llllllllllllllllllIIlllIIIlllIlI);
            }
            
            public boolean func_180180_a(final EnumFacing llllllllllllllllllIIlllIIIllllll) {
                return llllllllllllllllllIIlllIIIllllll != EnumFacing.UP;
            }
            
            static {
                __OBFID = "CL_00002106";
            }
        });
        field_176429_b = PropertyBool.create("enabled");
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT_MIPPED;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIlllIlIIIIlIIlIIlI) {
        final byte llllllllllllllIlllIlIIIIlIIlIIIl = 0;
        int llllllllllllllIlllIlIIIIlIIlIIII = llllllllllllllIlllIlIIIIlIIlIIIl | ((EnumFacing)llllllllllllllIlllIlIIIIlIIlIIlI.getValue(BlockHopper.field_176430_a)).getIndex();
        if (!(boolean)llllllllllllllIlllIlIIIIlIIlIIlI.getValue(BlockHopper.field_176429_b)) {
            llllllllllllllIlllIlIIIIlIIlIIII |= 0x8;
        }
        return llllllllllllllIlllIlIIIIlIIlIIII;
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockHopper.field_176430_a, BlockHopper.field_176429_b });
    }
    
    private void func_176427_e(final World llllllllllllllIlllIlIIIIllIIIlIl, final BlockPos llllllllllllllIlllIlIIIIllIIlIII, final IBlockState llllllllllllllIlllIlIIIIllIIIIll) {
        final boolean llllllllllllllIlllIlIIIIllIIIllI = !llllllllllllllIlllIlIIIIllIIIlIl.isBlockPowered(llllllllllllllIlllIlIIIIllIIlIII);
        if (llllllllllllllIlllIlIIIIllIIIllI != (boolean)llllllllllllllIlllIlIIIIllIIIIll.getValue(BlockHopper.field_176429_b)) {
            llllllllllllllIlllIlIIIIllIIIlIl.setBlockState(llllllllllllllIlllIlIIIIllIIlIII, llllllllllllllIlllIlIIIIllIIIIll.withProperty(BlockHopper.field_176429_b, llllllllllllllIlllIlIIIIllIIIllI), 4);
        }
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIlllIlIIIIlIIllIIl) {
        return this.getDefaultState().withProperty(BlockHopper.field_176430_a, func_176428_b(llllllllllllllIlllIlIIIIlIIllIIl)).withProperty(BlockHopper.field_176429_b, getActiveStateFromMetadata(llllllllllllllIlllIlIIIIlIIllIIl));
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess llllllllllllllIlllIlIIIlIIllllII, final BlockPos llllllllllllllIlllIlIIIlIIlllIll) {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
    
    @Override
    public int getRenderType() {
        return 3;
    }
    
    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }
    
    public static EnumFacing func_176428_b(final int llllllllllllllIlllIlIIIIlIlIlIIl) {
        return EnumFacing.getFront(llllllllllllllIlllIlIIIIlIlIlIIl & 0x7);
    }
    
    @Override
    public void onNeighborBlockChange(final World llllllllllllllIlllIlIIIIllIlIllI, final BlockPos llllllllllllllIlllIlIIIIllIlIIII, final IBlockState llllllllllllllIlllIlIIIIllIIllll, final Block llllllllllllllIlllIlIIIIllIlIIll) {
        this.func_176427_e(llllllllllllllIlllIlIIIIllIlIllI, llllllllllllllIlllIlIIIIllIlIIII, llllllllllllllIlllIlIIIIllIIllll);
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllllIlllIlIIIlIIIlllIl, final BlockPos llllllllllllllIlllIlIIIlIIIlllII, final EnumFacing llllllllllllllIlllIlIIIlIIIllIll, final float llllllllllllllIlllIlIIIlIIIllIlI, final float llllllllllllllIlllIlIIIlIIIllIIl, final float llllllllllllllIlllIlIIIlIIIllIII, final int llllllllllllllIlllIlIIIlIIIlIlll, final EntityLivingBase llllllllllllllIlllIlIIIlIIIlIllI) {
        EnumFacing llllllllllllllIlllIlIIIlIIIlIlIl = llllllllllllllIlllIlIIIlIIIllIll.getOpposite();
        if (llllllllllllllIlllIlIIIlIIIlIlIl == EnumFacing.UP) {
            llllllllllllllIlllIlIIIlIIIlIlIl = EnumFacing.DOWN;
        }
        return this.getDefaultState().withProperty(BlockHopper.field_176430_a, llllllllllllllIlllIlIIIlIIIlIlIl).withProperty(BlockHopper.field_176429_b, true);
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public int getComparatorInputOverride(final World llllllllllllllIlllIlIIIIlIIlllll, final BlockPos llllllllllllllIlllIlIIIIlIlIIIII) {
        return Container.calcRedstoneFromInventory(llllllllllllllIlllIlIIIIlIIlllll.getTileEntity(llllllllllllllIlllIlIIIIlIlIIIII));
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllllIlllIlIIIIllllIlII, final BlockPos llllllllllllllIlllIlIIIIllllIIll, final IBlockState llllllllllllllIlllIlIIIIlllIlllI) {
        this.func_176427_e(llllllllllllllIlllIlIIIIllllIlII, llllllllllllllIlllIlIIIIllllIIll, llllllllllllllIlllIlIIIIlllIlllI);
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public void addCollisionBoxesToList(final World llllllllllllllIlllIlIIIlIIlIlIII, final BlockPos llllllllllllllIlllIlIIIlIIlIIlll, final IBlockState llllllllllllllIlllIlIIIlIIlIlllI, final AxisAlignedBB llllllllllllllIlllIlIIIlIIlIIlIl, final List llllllllllllllIlllIlIIIlIIlIIlII, final Entity llllllllllllllIlllIlIIIlIIlIlIll) {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.625f, 1.0f);
        super.addCollisionBoxesToList(llllllllllllllIlllIlIIIlIIlIlIII, llllllllllllllIlllIlIIIlIIlIIlll, llllllllllllllIlllIlIIIlIIlIlllI, llllllllllllllIlllIlIIIlIIlIIlIl, llllllllllllllIlllIlIIIlIIlIIlII, llllllllllllllIlllIlIIIlIIlIlIll);
        final float llllllllllllllIlllIlIIIlIIlIlIlI = 0.125f;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, llllllllllllllIlllIlIIIlIIlIlIlI, 1.0f, 1.0f);
        super.addCollisionBoxesToList(llllllllllllllIlllIlIIIlIIlIlIII, llllllllllllllIlllIlIIIlIIlIIlll, llllllllllllllIlllIlIIIlIIlIlllI, llllllllllllllIlllIlIIIlIIlIIlIl, llllllllllllllIlllIlIIIlIIlIIlII, llllllllllllllIlllIlIIIlIIlIlIll);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, llllllllllllllIlllIlIIIlIIlIlIlI);
        super.addCollisionBoxesToList(llllllllllllllIlllIlIIIlIIlIlIII, llllllllllllllIlllIlIIIlIIlIIlll, llllllllllllllIlllIlIIIlIIlIlllI, llllllllllllllIlllIlIIIlIIlIIlIl, llllllllllllllIlllIlIIIlIIlIIlII, llllllllllllllIlllIlIIIlIIlIlIll);
        this.setBlockBounds(1.0f - llllllllllllllIlllIlIIIlIIlIlIlI, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        super.addCollisionBoxesToList(llllllllllllllIlllIlIIIlIIlIlIII, llllllllllllllIlllIlIIIlIIlIIlll, llllllllllllllIlllIlIIIlIIlIlllI, llllllllllllllIlllIlIIIlIIlIIlIl, llllllllllllllIlllIlIIIlIIlIIlII, llllllllllllllIlllIlIIIlIIlIlIll);
        this.setBlockBounds(0.0f, 0.0f, 1.0f - llllllllllllllIlllIlIIIlIIlIlIlI, 1.0f, 1.0f, 1.0f);
        super.addCollisionBoxesToList(llllllllllllllIlllIlIIIlIIlIlIII, llllllllllllllIlllIlIIIlIIlIIlll, llllllllllllllIlllIlIIIlIIlIlllI, llllllllllllllIlllIlIIIlIIlIIlIl, llllllllllllllIlllIlIIIlIIlIIlII, llllllllllllllIlllIlIIIlIIlIlIll);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
}
