package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.init.*;

public class BlockCake extends Block
{
    public static final /* synthetic */ PropertyInteger BITES;
    
    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIlIlllIlllIlllIlIl) {
        return (int)llllllllllllllIlIlllIlllIlllIlIl.getValue(BlockCake.BITES);
    }
    
    @Override
    public void onNeighborBlockChange(final World llllllllllllllIlIlllIllllIIlIllI, final BlockPos llllllllllllllIlIlllIllllIIlIlIl, final IBlockState llllllllllllllIlIlllIllllIIlIlII, final Block llllllllllllllIlIlllIllllIIlIIll) {
        if (!this.canBlockStay(llllllllllllllIlIlllIllllIIlIllI, llllllllllllllIlIlllIllllIIlIlIl)) {
            llllllllllllllIlIlllIllllIIlIllI.setBlockToAir(llllllllllllllIlIlllIllllIIlIlIl);
        }
    }
    
    @Override
    public AxisAlignedBB getSelectedBoundingBox(final World llllllllllllllIlIlllIlllllIlIllI, final BlockPos llllllllllllllIlIlllIlllllIllIII) {
        return this.getCollisionBoundingBox(llllllllllllllIlIlllIlllllIlIllI, llllllllllllllIlIlllIlllllIllIII, llllllllllllllIlIlllIlllllIlIllI.getBlockState(llllllllllllllIlIlllIlllllIllIII));
    }
    
    static {
        __OBFID = "CL_00000211";
        BITES = PropertyInteger.create("bites", 0, 6);
    }
    
    protected BlockCake() {
        super(Material.cake);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockCake.BITES, 0));
        this.setTickRandomly(true);
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIlIlllIllllIIIIlIl, final Random llllllllllllllIlIlllIllllIIIIlII, final int llllllllllllllIlIlllIllllIIIIIll) {
        return null;
    }
    
    @Override
    public void onBlockClicked(final World llllllllllllllIlIlllIllllIllIllI, final BlockPos llllllllllllllIlIlllIllllIlllIIl, final EntityPlayer llllllllllllllIlIlllIllllIllIlII) {
        this.eatCake(llllllllllllllIlIlllIllllIllIllI, llllllllllllllIlIlllIllllIlllIIl, llllllllllllllIlIlllIllllIllIllI.getBlockState(llllllllllllllIlIlllIllllIlllIIl), llllllllllllllIlIlllIllllIllIlII);
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockCake.BITES });
    }
    
    private boolean canBlockStay(final World llllllllllllllIlIlllIllllIIIllII, final BlockPos llllllllllllllIlIlllIllllIIIlIll) {
        return llllllllllllllIlIlllIllllIIIllII.getBlockState(llllllllllllllIlIlllIllllIIIlIll.offsetDown()).getBlock().getMaterial().isSolid();
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public int getComparatorInputOverride(final World llllllllllllllIlIlllIlllIllIllII, final BlockPos llllllllllllllIlIlllIlllIllIllIl) {
        return (7 - (int)llllllllllllllIlIlllIlllIllIllII.getBlockState(llllllllllllllIlIlllIlllIllIllIl).getValue(BlockCake.BITES)) * 2;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIlIlllIlllIllllIll) {
        return this.getDefaultState().withProperty(BlockCake.BITES, llllllllllllllIlIlllIlllIllllIll);
    }
    
    private void eatCake(final World llllllllllllllIlIlllIllllIlIlIII, final BlockPos llllllllllllllIlIlllIllllIlIIlll, final IBlockState llllllllllllllIlIlllIllllIlIIllI, final EntityPlayer llllllllllllllIlIlllIllllIlIIlIl) {
        if (llllllllllllllIlIlllIllllIlIIlIl.canEat(false)) {
            llllllllllllllIlIlllIllllIlIIlIl.getFoodStats().addStats(2, 0.1f);
            final int llllllllllllllIlIlllIllllIlIlIIl = (int)llllllllllllllIlIlllIllllIlIIllI.getValue(BlockCake.BITES);
            if (llllllllllllllIlIlllIllllIlIlIIl < 6) {
                llllllllllllllIlIlllIllllIlIlIII.setBlockState(llllllllllllllIlIlllIllllIlIIlll, llllllllllllllIlIlllIllllIlIIllI.withProperty(BlockCake.BITES, llllllllllllllIlIlllIllllIlIlIIl + 1), 3);
            }
            else {
                llllllllllllllIlIlllIllllIlIlIII.setBlockToAir(llllllllllllllIlIlllIllllIlIIlll);
            }
        }
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess llllllllllllllIlIlllIlllllllllII, final BlockPos llllllllllllllIlIlllIllllllllIll) {
        final float llllllllllllllIlIllllIIIIIIIIIII = 0.0625f;
        final float llllllllllllllIlIlllIlllllllllll = (1 + (int)llllllllllllllIlIlllIlllllllllII.getBlockState(llllllllllllllIlIlllIllllllllIll).getValue(BlockCake.BITES) * 2) / 16.0f;
        final float llllllllllllllIlIlllIllllllllllI = 0.5f;
        this.setBlockBounds(llllllllllllllIlIlllIlllllllllll, 0.0f, llllllllllllllIlIllllIIIIIIIIIII, 1.0f - llllllllllllllIlIllllIIIIIIIIIII, llllllllllllllIlIlllIllllllllllI, 1.0f - llllllllllllllIlIllllIIIIIIIIIII);
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World llllllllllllllIlIlllIllllllIlIII, final BlockPos llllllllllllllIlIlllIllllllIIIlI, final IBlockState llllllllllllllIlIlllIllllllIIllI) {
        final float llllllllllllllIlIlllIllllllIIlIl = 0.0625f;
        final float llllllllllllllIlIlllIllllllIIlII = (1 + (int)llllllllllllllIlIlllIllllllIIllI.getValue(BlockCake.BITES) * 2) / 16.0f;
        final float llllllllllllllIlIlllIllllllIIIll = 0.5f;
        return new AxisAlignedBB(llllllllllllllIlIlllIllllllIIIlI.getX() + llllllllllllllIlIlllIllllllIIlII, llllllllllllllIlIlllIllllllIIIlI.getY(), llllllllllllllIlIlllIllllllIIIlI.getZ() + llllllllllllllIlIlllIllllllIIlIl, llllllllllllllIlIlllIllllllIIIlI.getX() + 1 - llllllllllllllIlIlllIllllllIIlIl, llllllllllllllIlIlllIllllllIIIlI.getY() + llllllllllllllIlIlllIllllllIIIll, llllllllllllllIlIlllIllllllIIIlI.getZ() + 1 - llllllllllllllIlIlllIllllllIIlIl);
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllllIlIlllIlllllIIIIll, final BlockPos llllllllllllllIlIlllIlllllIIlIll, final IBlockState llllllllllllllIlIlllIlllllIIIIIl, final EntityPlayer llllllllllllllIlIlllIlllllIIlIIl, final EnumFacing llllllllllllllIlIlllIlllllIIlIII, final float llllllllllllllIlIlllIlllllIIIlll, final float llllllllllllllIlIlllIlllllIIIllI, final float llllllllllllllIlIlllIlllllIIIlIl) {
        this.eatCake(llllllllllllllIlIlllIlllllIIIIll, llllllllllllllIlIlllIlllllIIlIll, llllllllllllllIlIlllIlllllIIIIIl, llllllllllllllIlIlllIlllllIIlIIl);
        return true;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllllllIlIlllIllllIIlllII, final BlockPos llllllllllllllIlIlllIllllIIllllI) {
        return super.canPlaceBlockAt(llllllllllllllIlIlllIllllIIlllII, llllllllllllllIlIlllIllllIIllllI) && this.canBlockStay(llllllllllllllIlIlllIllllIIlllII, llllllllllllllIlIlllIllllIIllllI);
    }
    
    @Override
    public void setBlockBoundsForItemRender() {
        final float llllllllllllllIlIlllIlllllllIIll = 0.0625f;
        final float llllllllllllllIlIlllIlllllllIIlI = 0.5f;
        this.setBlockBounds(llllllllllllllIlIlllIlllllllIIll, 0.0f, llllllllllllllIlIlllIlllllllIIll, 1.0f - llllllllllllllIlIlllIlllllllIIll, llllllllllllllIlIlllIlllllllIIlI, 1.0f - llllllllllllllIlIlllIlllllllIIll);
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllllIlIlllIllllIIIIlll) {
        return 0;
    }
    
    @Override
    public Item getItem(final World llllllllllllllIlIlllIllllIIIIIIl, final BlockPos llllllllllllllIlIlllIllllIIIIIII) {
        return Items.cake;
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
}
