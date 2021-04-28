package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.inventory.*;
import net.minecraft.util.*;

public class BlockBrewingStand extends BlockContainer
{
    public static final /* synthetic */ PropertyBool[] BOTTLE_PROPS;
    private final /* synthetic */ Random rand;
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllllIllIllIIlIIlIlIIIl, final int llllllllllllllIllIllIIlIIlIlIIII) {
        return new TileEntityBrewingStand();
    }
    
    @Override
    public Item getItem(final World llllllllllllllIllIllIIIlllIlIlll, final BlockPos llllllllllllllIllIllIIIlllIlIllI) {
        return Items.brewing_stand;
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockBrewingStand.BOTTLE_PROPS[0], BlockBrewingStand.BOTTLE_PROPS[1], BlockBrewingStand.BOTTLE_PROPS[2] });
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIllIllIIIllIlIlIll) {
        int llllllllllllllIllIllIIIllIlIllll = 0;
        for (int llllllllllllllIllIllIIIllIlIllIl = 0; llllllllllllllIllIllIIIllIlIllIl < 3; ++llllllllllllllIllIllIIIllIlIllIl) {
            if (llllllllllllllIllIllIIIllIlIlIll.getValue(BlockBrewingStand.BOTTLE_PROPS[llllllllllllllIllIllIIIllIlIllIl])) {
                llllllllllllllIllIllIIIllIlIllll |= 1 << llllllllllllllIllIllIIIllIlIllIl;
            }
        }
        return llllllllllllllIllIllIIIllIlIllll;
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }
    
    @Override
    public void onBlockPlacedBy(final World llllllllllllllIllIllIIlIIIIlllll, final BlockPos llllllllllllllIllIllIIlIIIIlIllI, final IBlockState llllllllllllllIllIllIIlIIIIlllII, final EntityLivingBase llllllllllllllIllIllIIlIIIIllIll, final ItemStack llllllllllllllIllIllIIlIIIIlIlII) {
        if (llllllllllllllIllIllIIlIIIIlIlII.hasDisplayName()) {
            final TileEntity llllllllllllllIllIllIIlIIIIllIII = llllllllllllllIllIllIIlIIIIlllll.getTileEntity(llllllllllllllIllIllIIlIIIIlIllI);
            if (llllllllllllllIllIllIIlIIIIllIII instanceof TileEntityBrewingStand) {
                ((TileEntityBrewingStand)llllllllllllllIllIllIIlIIIIllIII).func_145937_a(llllllllllllllIllIllIIlIIIIlIlII.getDisplayName());
            }
        }
    }
    
    static {
        __OBFID = "CL_00000207";
        BOTTLE_PROPS = new PropertyBool[] { PropertyBool.create("has_bottle_0"), PropertyBool.create("has_bottle_1"), PropertyBool.create("has_bottle_2") };
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIllIllIIIlllIIIIll) {
        IBlockState llllllllllllllIllIllIIIlllIIIllI = this.getDefaultState();
        for (int llllllllllllllIllIllIIIlllIIIlIl = 0; llllllllllllllIllIllIIIlllIIIlIl < 3; ++llllllllllllllIllIllIIIlllIIIlIl) {
            llllllllllllllIllIllIIIlllIIIllI = llllllllllllllIllIllIIIlllIIIllI.withProperty(BlockBrewingStand.BOTTLE_PROPS[llllllllllllllIllIllIIIlllIIIlIl], (llllllllllllllIllIllIIIlllIIIIll & 1 << llllllllllllllIllIllIIIlllIIIlIl) > 0);
        }
        return llllllllllllllIllIllIIIlllIIIllI;
    }
    
    public BlockBrewingStand() {
        super(Material.iron);
        this.rand = new Random();
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockBrewingStand.BOTTLE_PROPS[0], false).withProperty(BlockBrewingStand.BOTTLE_PROPS[1], false).withProperty(BlockBrewingStand.BOTTLE_PROPS[2], false));
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllllIllIllIIlIIIllIIIl, final BlockPos llllllllllllllIllIllIIlIIIlIIlll, final IBlockState llllllllllllllIllIllIIlIIIlIllll, final EntityPlayer llllllllllllllIllIllIIlIIIlIIllI, final EnumFacing llllllllllllllIllIllIIlIIIlIllIl, final float llllllllllllllIllIllIIlIIIlIllII, final float llllllllllllllIllIllIIlIIIlIlIll, final float llllllllllllllIllIllIIlIIIlIlIlI) {
        if (llllllllllllllIllIllIIlIIIllIIIl.isRemote) {
            return true;
        }
        final TileEntity llllllllllllllIllIllIIlIIIlIlIIl = llllllllllllllIllIllIIlIIIllIIIl.getTileEntity(llllllllllllllIllIllIIlIIIlIIlll);
        if (llllllllllllllIllIllIIlIIIlIlIIl instanceof TileEntityBrewingStand) {
            llllllllllllllIllIllIIlIIIlIIllI.displayGUIChest((IInventory)llllllllllllllIllIllIIlIIIlIlIIl);
        }
        return true;
    }
    
    @Override
    public int getComparatorInputOverride(final World llllllllllllllIllIllIIIlllIlIIIl, final BlockPos llllllllllllllIllIllIIIlllIlIIII) {
        return Container.calcRedstoneFromInventory(llllllllllllllIllIllIIIlllIlIIIl.getTileEntity(llllllllllllllIllIllIIIlllIlIIII));
    }
    
    @Override
    public void addCollisionBoxesToList(final World llllllllllllllIllIllIIlIIlIIIllI, final BlockPos llllllllllllllIllIllIIlIIlIIIlIl, final IBlockState llllllllllllllIllIllIIlIIIllllIl, final AxisAlignedBB llllllllllllllIllIllIIlIIIllllII, final List llllllllllllllIllIllIIlIIlIIIIlI, final Entity llllllllllllllIllIllIIlIIIlllIlI) {
        this.setBlockBounds(0.4375f, 0.0f, 0.4375f, 0.5625f, 0.875f, 0.5625f);
        super.addCollisionBoxesToList(llllllllllllllIllIllIIlIIlIIIllI, llllllllllllllIllIllIIlIIlIIIlIl, llllllllllllllIllIllIIlIIIllllIl, llllllllllllllIllIllIIlIIIllllII, llllllllllllllIllIllIIlIIlIIIIlI, llllllllllllllIllIllIIlIIIlllIlI);
        this.setBlockBoundsForItemRender();
        super.addCollisionBoxesToList(llllllllllllllIllIllIIlIIlIIIllI, llllllllllllllIllIllIIlIIlIIIlIl, llllllllllllllIllIllIIlIIIllllIl, llllllllllllllIllIllIIlIIIllllII, llllllllllllllIllIllIIlIIlIIIIlI, llllllllllllllIllIllIIlIIIlllIlI);
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIllIllIIIlllIllIll, final Random llllllllllllllIllIllIIIlllIllIlI, final int llllllllllllllIllIllIIIlllIllIIl) {
        return Items.brewing_stand;
    }
    
    @Override
    public void breakBlock(final World llllllllllllllIllIllIIIllllIIIII, final BlockPos llllllllllllllIllIllIIIlllIlllll, final IBlockState llllllllllllllIllIllIIIlllIllllI) {
        final TileEntity llllllllllllllIllIllIIIllllIIIlI = llllllllllllllIllIllIIIllllIIIII.getTileEntity(llllllllllllllIllIllIIIlllIlllll);
        if (llllllllllllllIllIllIIIllllIIIlI instanceof TileEntityBrewingStand) {
            InventoryHelper.dropInventoryItems(llllllllllllllIllIllIIIllllIIIII, llllllllllllllIllIllIIIlllIlllll, (IInventory)llllllllllllllIllIllIIIllllIIIlI);
        }
        super.breakBlock(llllllllllllllIllIllIIIllllIIIII, llllllllllllllIllIllIIIlllIlllll, llllllllllllllIllIllIIIlllIllllI);
    }
    
    @Override
    public int getRenderType() {
        return 3;
    }
    
    @Override
    public void randomDisplayTick(final World llllllllllllllIllIllIIIllllllIll, final BlockPos llllllllllllllIllIllIIIllllllIIl, final IBlockState llllllllllllllIllIllIIIlllllIlll, final Random llllllllllllllIllIllIIIlllllIlIl) {
        final double llllllllllllllIllIllIIIlllllIlII = llllllllllllllIllIllIIIllllllIIl.getX() + 0.4f + llllllllllllllIllIllIIIlllllIlIl.nextFloat() * 0.2f;
        final double llllllllllllllIllIllIIIlllllIIll = llllllllllllllIllIllIIIllllllIIl.getY() + 0.7f + llllllllllllllIllIllIIIlllllIlIl.nextFloat() * 0.3f;
        final double llllllllllllllIllIllIIIlllllIIlI = llllllllllllllIllIllIIIllllllIIl.getZ() + 0.4f + llllllllllllllIllIllIIIlllllIlIl.nextFloat() * 0.2f;
        llllllllllllllIllIllIIIllllllIll.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, llllllllllllllIllIllIIIlllllIlII, llllllllllllllIllIllIIIlllllIIll, llllllllllllllIllIllIIIlllllIIlI, 0.0, 0.0, 0.0, new int[0]);
    }
    
    @Override
    public void setBlockBoundsForItemRender() {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
    }
}
