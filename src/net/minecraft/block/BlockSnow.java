package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.player.*;
import net.minecraft.tileentity.*;
import net.minecraft.stats.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.util.*;

public class BlockSnow extends Block
{
    public static final /* synthetic */ PropertyInteger LAYERS_PROP;
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIlIIIllIllIllllIll) {
        return this.getDefaultState().withProperty(BlockSnow.LAYERS_PROP, (llllllllllllllIlIIIllIllIllllIll & 0x7) + 1);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIlIIIllIllIllIllll) {
        return (int)llllllllllllllIlIIIllIllIllIllll.getValue(BlockSnow.LAYERS_PROP) - 1;
    }
    
    protected BlockSnow() {
        super(Material.snow);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockSnow.LAYERS_PROP, 1));
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setBlockBoundsForItemRender();
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllllIlIIIllIlllIIlIllI) {
        return 0;
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockSnow.LAYERS_PROP });
    }
    
    @Override
    public void harvestBlock(final World llllllllllllllIlIIIllIlllIIlllll, final EntityPlayer llllllllllllllIlIIIllIlllIIllllI, final BlockPos llllllllllllllIlIIIllIlllIlIIIll, final IBlockState llllllllllllllIlIIIllIlllIIlllII, final TileEntity llllllllllllllIlIIIllIlllIlIIIIl) {
        Block.spawnAsEntity(llllllllllllllIlIIIllIlllIIlllll, llllllllllllllIlIIIllIlllIlIIIll, new ItemStack(Items.snowball, (int)llllllllllllllIlIIIllIlllIIlllII.getValue(BlockSnow.LAYERS_PROP) + 1, 0));
        llllllllllllllIlIIIllIlllIIlllll.setBlockToAir(llllllllllllllIlIIIllIlllIlIIIll);
        llllllllllllllIlIIIllIlllIIllllI.triggerAchievement(StatList.mineBlockStatArray[Block.getIdFromBlock(this)]);
    }
    
    private boolean checkAndDropBlock(final World llllllllllllllIlIIIllIlllIlIlllI, final BlockPos llllllllllllllIlIIIllIlllIlIllIl, final IBlockState llllllllllllllIlIIIllIlllIlIllII) {
        if (!this.canPlaceBlockAt(llllllllllllllIlIIIllIlllIlIlllI, llllllllllllllIlIIIllIlllIlIllIl)) {
            this.dropBlockAsItem(llllllllllllllIlIIIllIlllIlIlllI, llllllllllllllIlIIIllIlllIlIllIl, llllllllllllllIlIIIllIlllIlIllII, 0);
            llllllllllllllIlIIIllIlllIlIlllI.setBlockToAir(llllllllllllllIlIIIllIlllIlIllIl);
            return false;
        }
        return true;
    }
    
    @Override
    public boolean isPassable(final IBlockAccess llllllllllllllIlIIIllIllllllllII, final BlockPos llllllllllllllIlIIIllIllllllllIl) {
        return (int)llllllllllllllIlIIIllIllllllllII.getBlockState(llllllllllllllIlIIIllIllllllllIl).getValue(BlockSnow.LAYERS_PROP) < 5;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIlIIIllIlllIIllIlI, final Random llllllllllllllIlIIIllIlllIIllIIl, final int llllllllllllllIlIIIllIlllIIllIII) {
        return Items.snowball;
    }
    
    @Override
    public void setBlockBoundsForItemRender() {
        this.getBoundsForLayers(0);
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllllllIlIIIllIllllIIllIl, final BlockPos llllllllllllllIlIIIllIllllIIIlll) {
        final IBlockState llllllllllllllIlIIIllIllllIIlIll = llllllllllllllIlIIIllIllllIIllIl.getBlockState(llllllllllllllIlIIIllIllllIIIlll.offsetDown());
        final Block llllllllllllllIlIIIllIllllIIlIlI = llllllllllllllIlIIIllIllllIIlIll.getBlock();
        return llllllllllllllIlIIIllIllllIIlIlI != Blocks.ice && llllllllllllllIlIIIllIllllIIlIlI != Blocks.packed_ice && (llllllllllllllIlIIIllIllllIIlIlI.getMaterial() == Material.leaves || (llllllllllllllIlIIIllIllllIIlIlI == this && (int)llllllllllllllIlIIIllIllllIIlIll.getValue(BlockSnow.LAYERS_PROP) == 7) || (llllllllllllllIlIIIllIllllIIlIlI.isOpaqueCube() && llllllllllllllIlIIIllIllllIIlIlI.blockMaterial.blocksMovement()));
    }
    
    @Override
    public void onNeighborBlockChange(final World llllllllllllllIlIIIllIlllIllllll, final BlockPos llllllllllllllIlIIIllIlllIlllIIl, final IBlockState llllllllllllllIlIIIllIlllIllllIl, final Block llllllllllllllIlIIIllIlllIllllII) {
        this.checkAndDropBlock(llllllllllllllIlIIIllIlllIllllll, llllllllllllllIlIIIllIlllIlllIIl, llllllllllllllIlIIIllIlllIllllIl);
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public void updateTick(final World llllllllllllllIlIIIllIlllIIlIIIl, final BlockPos llllllllllllllIlIIIllIlllIIlIIII, final IBlockState llllllllllllllIlIIIllIlllIIIllll, final Random llllllllllllllIlIIIllIlllIIIlllI) {
        if (llllllllllllllIlIIIllIlllIIlIIIl.getLightFor(EnumSkyBlock.BLOCK, llllllllllllllIlIIIllIlllIIlIIII) > 11) {
            this.dropBlockAsItem(llllllllllllllIlIIIllIlllIIlIIIl, llllllllllllllIlIIIllIlllIIlIIII, llllllllllllllIlIIIllIlllIIlIIIl.getBlockState(llllllllllllllIlIIIllIlllIIlIIII), 0);
            llllllllllllllIlIIIllIlllIIlIIIl.setBlockToAir(llllllllllllllIlIIIllIlllIIlIIII);
        }
    }
    
    @Override
    public boolean isReplaceable(final World llllllllllllllIlIIIllIllIlllIlIl, final BlockPos llllllllllllllIlIIIllIllIlllIlII) {
        return (int)llllllllllllllIlIIIllIllIlllIlIl.getBlockState(llllllllllllllIlIIIllIllIlllIlII).getValue(BlockSnow.LAYERS_PROP) == 1;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World llllllllllllllIlIIIllIllllllIlII, final BlockPos llllllllllllllIlIIIllIlllllIlllI, final IBlockState llllllllllllllIlIIIllIllllllIIlI) {
        final int llllllllllllllIlIIIllIllllllIIIl = (int)llllllllllllllIlIIIllIllllllIIlI.getValue(BlockSnow.LAYERS_PROP) - 1;
        final float llllllllllllllIlIIIllIllllllIIII = 0.125f;
        return new AxisAlignedBB(llllllllllllllIlIIIllIlllllIlllI.getX() + this.minX, llllllllllllllIlIIIllIlllllIlllI.getY() + this.minY, llllllllllllllIlIIIllIlllllIlllI.getZ() + this.minZ, llllllllllllllIlIIIllIlllllIlllI.getX() + this.maxX, llllllllllllllIlIIIllIlllllIlllI.getY() + llllllllllllllIlIIIllIllllllIIIl * llllllllllllllIlIIIllIllllllIIII, llllllllllllllIlIIIllIlllllIlllI.getZ() + this.maxZ);
    }
    
    protected void getBoundsForLayers(final int llllllllllllllIlIIIllIllllIlIlII) {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, llllllllllllllIlIIIllIllllIlIlII / 8.0f, 1.0f);
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockAccess llllllllllllllIlIIIllIlllIIIIlIl, final BlockPos llllllllllllllIlIIIllIlllIIIIlII, final EnumFacing llllllllllllllIlIIIllIlllIIIIIll) {
        return llllllllllllllIlIIIllIlllIIIIIll == EnumFacing.UP || super.shouldSideBeRendered(llllllllllllllIlIIIllIlllIIIIlIl, llllllllllllllIlIIIllIlllIIIIlII, llllllllllllllIlIIIllIlllIIIIIll);
    }
    
    static {
        __OBFID = "CL_00000309";
        LAYERS_PROP = PropertyInteger.create("layers", 1, 8);
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess llllllllllllllIlIIIllIllllIlllII, final BlockPos llllllllllllllIlIIIllIllllIlllll) {
        final IBlockState llllllllllllllIlIIIllIllllIllllI = llllllllllllllIlIIIllIllllIlllII.getBlockState(llllllllllllllIlIIIllIllllIlllll);
        this.getBoundsForLayers((int)llllllllllllllIlIIIllIllllIllllI.getValue(BlockSnow.LAYERS_PROP));
    }
}
