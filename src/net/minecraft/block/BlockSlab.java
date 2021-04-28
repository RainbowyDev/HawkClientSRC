package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.util.*;

public abstract class BlockSlab extends Block
{
    public static final /* synthetic */ PropertyEnum HALF_PROP;
    
    @Override
    public boolean shouldSideBeRendered(final IBlockAccess llllllllllllllIIIIIIIllIIlIIIlIl, final BlockPos llllllllllllllIIIIIIIllIIlIlIIIl, final EnumFacing llllllllllllllIIIIIIIllIIlIIllll) {
        if (this.isDouble()) {
            return super.shouldSideBeRendered(llllllllllllllIIIIIIIllIIlIIIlIl, llllllllllllllIIIIIIIllIIlIlIIIl, llllllllllllllIIIIIIIllIIlIIllll);
        }
        if (llllllllllllllIIIIIIIllIIlIIllll != EnumFacing.UP && llllllllllllllIIIIIIIllIIlIIllll != EnumFacing.DOWN && !super.shouldSideBeRendered(llllllllllllllIIIIIIIllIIlIIIlIl, llllllllllllllIIIIIIIllIIlIlIIIl, llllllllllllllIIIIIIIllIIlIIllll)) {
            return false;
        }
        final BlockPos llllllllllllllIIIIIIIllIIlIIllIl = llllllllllllllIIIIIIIllIIlIlIIIl.offset(llllllllllllllIIIIIIIllIIlIIllll.getOpposite());
        final IBlockState llllllllllllllIIIIIIIllIIlIIlIll = llllllllllllllIIIIIIIllIIlIIIlIl.getBlockState(llllllllllllllIIIIIIIllIIlIlIIIl);
        final IBlockState llllllllllllllIIIIIIIllIIlIIlIlI = llllllllllllllIIIIIIIllIIlIIIlIl.getBlockState(llllllllllllllIIIIIIIllIIlIIllIl);
        final boolean llllllllllllllIIIIIIIllIIlIIlIIl = func_150003_a(llllllllllllllIIIIIIIllIIlIIlIll.getBlock()) && llllllllllllllIIIIIIIllIIlIIlIll.getValue(BlockSlab.HALF_PROP) == EnumBlockHalf.TOP;
        final boolean llllllllllllllIIIIIIIllIIlIIIlll = func_150003_a(llllllllllllllIIIIIIIllIIlIIlIlI.getBlock()) && llllllllllllllIIIIIIIllIIlIIlIlI.getValue(BlockSlab.HALF_PROP) == EnumBlockHalf.TOP;
        return llllllllllllllIIIIIIIllIIlIIIlll ? (llllllllllllllIIIIIIIllIIlIIllll == EnumFacing.DOWN || (llllllllllllllIIIIIIIllIIlIIllll == EnumFacing.UP && super.shouldSideBeRendered(llllllllllllllIIIIIIIllIIlIIIlIl, llllllllllllllIIIIIIIllIIlIlIIIl, llllllllllllllIIIIIIIllIIlIIllll)) || !func_150003_a(llllllllllllllIIIIIIIllIIlIIlIll.getBlock()) || !llllllllllllllIIIIIIIllIIlIIlIIl) : (llllllllllllllIIIIIIIllIIlIIllll == EnumFacing.UP || (llllllllllllllIIIIIIIllIIlIIllll == EnumFacing.DOWN && super.shouldSideBeRendered(llllllllllllllIIIIIIIllIIlIIIlIl, llllllllllllllIIIIIIIllIIlIlIIIl, llllllllllllllIIIIIIIllIIlIIllll)) || !func_150003_a(llllllllllllllIIIIIIIllIIlIIlIll.getBlock()) || llllllllllllllIIIIIIIllIIlIIlIIl);
    }
    
    public abstract Object func_176553_a(final ItemStack p0);
    
    @Override
    protected boolean canSilkHarvest() {
        return false;
    }
    
    public abstract IProperty func_176551_l();
    
    @Override
    public void addCollisionBoxesToList(final World llllllllllllllIIIIIIIllIlIlllIII, final BlockPos llllllllllllllIIIIIIIllIlIllIlll, final IBlockState llllllllllllllIIIIIIIllIlIllIllI, final AxisAlignedBB llllllllllllllIIIIIIIllIlIllIlIl, final List llllllllllllllIIIIIIIllIlIllIlII, final Entity llllllllllllllIIIIIIIllIlIlIllII) {
        this.setBlockBoundsBasedOnState(llllllllllllllIIIIIIIllIlIlllIII, llllllllllllllIIIIIIIllIlIllIlll);
        super.addCollisionBoxesToList(llllllllllllllIIIIIIIllIlIlllIII, llllllllllllllIIIIIIIllIlIllIlll, llllllllllllllIIIIIIIllIlIllIllI, llllllllllllllIIIIIIIllIlIllIlIl, llllllllllllllIIIIIIIllIlIllIlII, llllllllllllllIIIIIIIllIlIlIllII);
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllllIIIIIIIllIlIIlllIl, final BlockPos llllllllllllllIIIIIIIllIlIIlIIlI, final EnumFacing llllllllllllllIIIIIIIllIlIIllIll, final float llllllllllllllIIIIIIIllIlIIllIlI, final float llllllllllllllIIIIIIIllIlIIIllll, final float llllllllllllllIIIIIIIllIlIIllIII, final int llllllllllllllIIIIIIIllIlIIIllIl, final EntityLivingBase llllllllllllllIIIIIIIllIlIIlIllI) {
        final IBlockState llllllllllllllIIIIIIIllIlIIlIlIl = super.onBlockPlaced(llllllllllllllIIIIIIIllIlIIlllIl, llllllllllllllIIIIIIIllIlIIlIIlI, llllllllllllllIIIIIIIllIlIIllIll, llllllllllllllIIIIIIIllIlIIllIlI, llllllllllllllIIIIIIIllIlIIIllll, llllllllllllllIIIIIIIllIlIIllIII, llllllllllllllIIIIIIIllIlIIIllIl, llllllllllllllIIIIIIIllIlIIlIllI).withProperty(BlockSlab.HALF_PROP, EnumBlockHalf.BOTTOM);
        return this.isDouble() ? llllllllllllllIIIIIIIllIlIIlIlIl : ((llllllllllllllIIIIIIIllIlIIllIll != EnumFacing.DOWN && (llllllllllllllIIIIIIIllIlIIllIll == EnumFacing.UP || llllllllllllllIIIIIIIllIlIIIllll <= 0.5)) ? llllllllllllllIIIIIIIllIlIIlIlIl : llllllllllllllIIIIIIIllIlIIlIlIl.withProperty(BlockSlab.HALF_PROP, EnumBlockHalf.TOP));
    }
    
    public BlockSlab(final Material llllllllllllllIIIIIIIllIllIlIIIl) {
        super(llllllllllllllIIIIIIIllIllIlIIIl);
        if (this.isDouble()) {
            this.fullBlock = true;
        }
        else {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
        }
        this.setLightOpacity(255);
    }
    
    @Override
    public void setBlockBoundsForItemRender() {
        if (this.isDouble()) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
        else {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
        }
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess llllllllllllllIIIIIIIllIllIIlIlI, final BlockPos llllllllllllllIIIIIIIllIllIIIlIl) {
        if (this.isDouble()) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
        else {
            final IBlockState llllllllllllllIIIIIIIllIllIIlIII = llllllllllllllIIIIIIIllIllIIlIlI.getBlockState(llllllllllllllIIIIIIIllIllIIIlIl);
            if (llllllllllllllIIIIIIIllIllIIlIII.getBlock() == this) {
                if (llllllllllllllIIIIIIIllIllIIlIII.getValue(BlockSlab.HALF_PROP) == EnumBlockHalf.TOP) {
                    this.setBlockBounds(0.0f, 0.5f, 0.0f, 1.0f, 1.0f, 1.0f);
                }
                else {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
                }
            }
        }
    }
    
    protected static boolean func_150003_a(final Block llllllllllllllIIIIIIIllIIIllIIlI) {
        return llllllllllllllIIIIIIIllIIIllIIlI == Blocks.stone_slab || llllllllllllllIIIIIIIllIIIllIIlI == Blocks.wooden_slab || llllllllllllllIIIIIIIllIIIllIIlI == Blocks.stone_slab2;
    }
    
    @Override
    public boolean isOpaqueCube() {
        return this.isDouble();
    }
    
    public abstract String getFullSlabName(final int p0);
    
    @Override
    public boolean isFullCube() {
        return this.isDouble();
    }
    
    public abstract boolean isDouble();
    
    @Override
    public int quantityDropped(final Random llllllllllllllIIIIIIIllIlIIIIlIl) {
        return this.isDouble() ? 2 : 1;
    }
    
    @Override
    public int getDamageValue(final World llllllllllllllIIIIIIIllIIIlIIIII, final BlockPos llllllllllllllIIIIIIIllIIIlIIlII) {
        return super.getDamageValue(llllllllllllllIIIIIIIllIIIlIIIII, llllllllllllllIIIIIIIllIIIlIIlII) & 0x7;
    }
    
    static {
        __OBFID = "CL_00000253";
        HALF_PROP = PropertyEnum.create("half", EnumBlockHalf.class);
    }
    
    public enum EnumBlockHalf implements IStringSerializable
    {
        TOP("TOP", 0, "TOP", 0, "top"), 
        BOTTOM("BOTTOM", 1, "BOTTOM", 1, "bottom");
        
        private final /* synthetic */ String halfName;
        
        static {
            __OBFID = "CL_00002109";
        }
        
        @Override
        public String getName() {
            return this.halfName;
        }
        
        @Override
        public String toString() {
            return this.halfName;
        }
        
        private EnumBlockHalf(final String lllllllllllllllIlIIIllIlIIlIIlll, final int lllllllllllllllIlIIIllIlIIlIIllI, final String lllllllllllllllIlIIIllIlIIlIlIll, final int lllllllllllllllIlIIIllIlIIlIlIlI, final String lllllllllllllllIlIIIllIlIIlIIlIl) {
            this.halfName = lllllllllllllllIlIIIllIlIIlIIlIl;
        }
    }
}
