package net.minecraft.block;

import net.minecraft.block.properties.*;
import com.google.common.base.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.tileentity.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;

public class BlockEnderChest extends BlockContainer
{
    public static final /* synthetic */ PropertyDirection field_176437_a;
    
    @Override
    protected boolean canSilkHarvest() {
        return true;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllllIIIlIIllIlIIIll) {
        return ((EnumFacing)lllllllllllllllllIIIlIIllIlIIIll.getValue(BlockEnderChest.field_176437_a)).getIndex();
    }
    
    static {
        __OBFID = "CL_00000238";
        field_176437_a = PropertyDirection.create("facing", (Predicate)EnumFacing.Plane.HORIZONTAL);
    }
    
    protected BlockEnderChest() {
        super(Material.rock);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockEnderChest.field_176437_a, EnumFacing.NORTH));
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setBlockBounds(0.0625f, 0.0f, 0.0625f, 0.9375f, 0.875f, 0.9375f);
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllllllIIIlIIllllllIlI, final BlockPos lllllllllllllllllIIIlIIllllIllll, final IBlockState lllllllllllllllllIIIlIIllllllIII, final EntityPlayer lllllllllllllllllIIIlIIlllllIlll, final EnumFacing lllllllllllllllllIIIlIIlllllIllI, final float lllllllllllllllllIIIlIIlllllIlIl, final float lllllllllllllllllIIIlIIlllllIlII, final float lllllllllllllllllIIIlIIlllllIIll) {
        final InventoryEnderChest lllllllllllllllllIIIlIIlllllIIlI = lllllllllllllllllIIIlIIlllllIlll.getInventoryEnderChest();
        final TileEntity lllllllllllllllllIIIlIIlllllIIIl = lllllllllllllllllIIIlIIllllllIlI.getTileEntity(lllllllllllllllllIIIlIIllllIllll);
        if (lllllllllllllllllIIIlIIlllllIIlI == null || !(lllllllllllllllllIIIlIIlllllIIIl instanceof TileEntityEnderChest)) {
            return true;
        }
        if (lllllllllllllllllIIIlIIllllllIlI.getBlockState(lllllllllllllllllIIIlIIllllIllll.offsetUp()).getBlock().isNormalCube()) {
            return true;
        }
        if (lllllllllllllllllIIIlIIllllllIlI.isRemote) {
            return true;
        }
        lllllllllllllllllIIIlIIlllllIIlI.setChestTileEntity((TileEntityEnderChest)lllllllllllllllllIIIlIIlllllIIIl);
        lllllllllllllllllIIIlIIlllllIlll.displayGUIChest(lllllllllllllllllIIIlIIlllllIIlI);
        return true;
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllllIIIlIIllIlIlllI) {
        EnumFacing lllllllllllllllllIIIlIIllIllIIII = EnumFacing.getFront(lllllllllllllllllIIIlIIllIlIlllI);
        if (lllllllllllllllllIIIlIIllIllIIII.getAxis() == EnumFacing.Axis.Y) {
            lllllllllllllllllIIIlIIllIllIIII = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty(BlockEnderChest.field_176437_a, lllllllllllllllllIIIlIIllIllIIII);
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllllllIIIlIlIIIlIIIIl, final Random lllllllllllllllllIIIlIlIIIlIIIII, final int lllllllllllllllllIIIlIlIIIIlllll) {
        return Item.getItemFromBlock(Blocks.obsidian);
    }
    
    @Override
    public int getRenderType() {
        return 2;
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllllllIIIlIlIIIIllIII, final BlockPos lllllllllllllllllIIIlIlIIIIlIlll, final EnumFacing lllllllllllllllllIIIlIlIIIIlIllI, final float lllllllllllllllllIIIlIlIIIIlIlIl, final float lllllllllllllllllIIIlIlIIIIlIlII, final float lllllllllllllllllIIIlIlIIIIlIIll, final int lllllllllllllllllIIIlIlIIIIlIIlI, final EntityLivingBase lllllllllllllllllIIIlIlIIIIlIIIl) {
        return this.getDefaultState().withProperty(BlockEnderChest.field_176437_a, lllllllllllllllllIIIlIlIIIIlIIIl.func_174811_aO().getOpposite());
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllllllllIIIlIlIIIIlllIl) {
        return 8;
    }
    
    @Override
    public void randomDisplayTick(final World lllllllllllllllllIIIlIIlllIIlIll, final BlockPos lllllllllllllllllIIIlIIlllIIlIlI, final IBlockState lllllllllllllllllIIIlIIlllIllIIl, final Random lllllllllllllllllIIIlIIlllIllIII) {
        for (int lllllllllllllllllIIIlIIlllIlIlll = 0; lllllllllllllllllIIIlIIlllIlIlll < 3; ++lllllllllllllllllIIIlIIlllIlIlll) {
            final int lllllllllllllllllIIIlIIlllIlIllI = lllllllllllllllllIIIlIIlllIllIII.nextInt(2) * 2 - 1;
            final int lllllllllllllllllIIIlIIlllIlIlIl = lllllllllllllllllIIIlIIlllIllIII.nextInt(2) * 2 - 1;
            final double lllllllllllllllllIIIlIIlllIlIlII = lllllllllllllllllIIIlIIlllIIlIlI.getX() + 0.5 + 0.25 * lllllllllllllllllIIIlIIlllIlIllI;
            final double lllllllllllllllllIIIlIIlllIlIIll = lllllllllllllllllIIIlIIlllIIlIlI.getY() + lllllllllllllllllIIIlIIlllIllIII.nextFloat();
            final double lllllllllllllllllIIIlIIlllIlIIlI = lllllllllllllllllIIIlIIlllIIlIlI.getZ() + 0.5 + 0.25 * lllllllllllllllllIIIlIIlllIlIlIl;
            final double lllllllllllllllllIIIlIIlllIlIIIl = lllllllllllllllllIIIlIIlllIllIII.nextFloat() * lllllllllllllllllIIIlIIlllIlIllI;
            final double lllllllllllllllllIIIlIIlllIlIIII = (lllllllllllllllllIIIlIIlllIllIII.nextFloat() - 0.5) * 0.125;
            final double lllllllllllllllllIIIlIIlllIIlllI = lllllllllllllllllIIIlIIlllIllIII.nextFloat() * lllllllllllllllllIIIlIIlllIlIlIl;
            lllllllllllllllllIIIlIIlllIIlIll.spawnParticle(EnumParticleTypes.PORTAL, lllllllllllllllllIIIlIIlllIlIlII, lllllllllllllllllIIIlIIlllIlIIll, lllllllllllllllllIIIlIIlllIlIIlI, lllllllllllllllllIIIlIIlllIlIIIl, lllllllllllllllllIIIlIIlllIlIIII, lllllllllllllllllIIIlIIlllIIlllI, new int[0]);
        }
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockEnderChest.field_176437_a });
    }
    
    @Override
    public void onBlockPlacedBy(final World lllllllllllllllllIIIlIlIIIIIlIIl, final BlockPos lllllllllllllllllIIIlIlIIIIIIIll, final IBlockState lllllllllllllllllIIIlIlIIIIIIIlI, final EntityLivingBase lllllllllllllllllIIIlIlIIIIIIllI, final ItemStack lllllllllllllllllIIIlIlIIIIIIlIl) {
        lllllllllllllllllIIIlIlIIIIIlIIl.setBlockState(lllllllllllllllllIIIlIlIIIIIIIll, lllllllllllllllllIIIlIlIIIIIIIlI.withProperty(BlockEnderChest.field_176437_a, lllllllllllllllllIIIlIlIIIIIIllI.func_174811_aO().getOpposite()), 2);
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllllllllIIIlIIllllIlIlI, final int lllllllllllllllllIIIlIIllllIlIIl) {
        return new TileEntityEnderChest();
    }
}
