package net.minecraft.block;

import net.minecraft.tileentity.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import com.google.common.base.*;
import java.util.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;

public class BlockBanner extends BlockContainer
{
    public static final /* synthetic */ PropertyDirection FACING_PROP;
    public static final /* synthetic */ PropertyInteger ROTATION_PROP;
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllllIIlllllllIllIlIIlI, final int llllllllllllllIIlllllllIllIlIIII) {
        return new TileEntityBanner();
    }
    
    @Override
    public AxisAlignedBB getSelectedBoundingBox(final World llllllllllllllIIlllllllIllIlllIl, final BlockPos llllllllllllllIIlllllllIllIlllII) {
        this.setBlockBoundsBasedOnState(llllllllllllllIIlllllllIllIlllIl, llllllllllllllIIlllllllIllIlllII);
        return super.getSelectedBoundingBox(llllllllllllllIIlllllllIllIlllIl, llllllllllllllIIlllllllIllIlllII);
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World llllllllllllllIIlllllllIlIllIIlI, final BlockPos llllllllllllllIIlllllllIlIllIIII, final IBlockState llllllllllllllIIlllllllIlIlIlllI, final float llllllllllllllIIlllllllIlIIllllI, final int llllllllllllllIIlllllllIlIlIlIll) {
        final TileEntity llllllllllllllIIlllllllIlIlIlIIl = llllllllllllllIIlllllllIlIllIIlI.getTileEntity(llllllllllllllIIlllllllIlIllIIII);
        if (llllllllllllllIIlllllllIlIlIlIIl instanceof TileEntityBanner) {
            final ItemStack llllllllllllllIIlllllllIlIlIIlll = new ItemStack(Items.banner, 1, ((TileEntityBanner)llllllllllllllIIlllllllIlIlIlIIl).getBaseColor());
            final NBTTagCompound llllllllllllllIIlllllllIlIlIIlIl = new NBTTagCompound();
            llllllllllllllIIlllllllIlIlIlIIl.writeToNBT(llllllllllllllIIlllllllIlIlIIlIl);
            llllllllllllllIIlllllllIlIlIIlIl.removeTag("x");
            llllllllllllllIIlllllllIlIlIIlIl.removeTag("y");
            llllllllllllllIIlllllllIlIlIIlIl.removeTag("z");
            llllllllllllllIIlllllllIlIlIIlIl.removeTag("id");
            llllllllllllllIIlllllllIlIlIIlll.setTagInfo("BlockEntityTag", llllllllllllllIIlllllllIlIlIIlIl);
            Block.spawnAsEntity(llllllllllllllIIlllllllIlIllIIlI, llllllllllllllIIlllllllIlIllIIII, llllllllllllllIIlllllllIlIlIIlll);
        }
        else {
            super.dropBlockAsItemWithChance(llllllllllllllIIlllllllIlIllIIlI, llllllllllllllIIlllllllIlIllIIII, llllllllllllllIIlllllllIlIlIlllI, llllllllllllllIIlllllllIlIIllllI, llllllllllllllIIlllllllIlIlIlIll);
        }
    }
    
    @Override
    public Item getItem(final World llllllllllllllIIlllllllIllIIIIll, final BlockPos llllllllllllllIIlllllllIllIIIIIl) {
        return Items.banner;
    }
    
    @Override
    public boolean isPassable(final IBlockAccess llllllllllllllIIlllllllIllIllIIl, final BlockPos llllllllllllllIIlllllllIllIllIII) {
        return true;
    }
    
    static {
        __OBFID = "CL_00002143";
        FACING_PROP = PropertyDirection.create("facing", (Predicate)EnumFacing.Plane.HORIZONTAL);
        ROTATION_PROP = PropertyInteger.create("rotation", 0, 15);
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World llllllllllllllIIlllllllIllllIIII, final BlockPos llllllllllllllIIlllllllIlllIllll, final IBlockState llllllllllllllIIlllllllIlllIlllI) {
        return null;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIIlllllllIllIIllII, final Random llllllllllllllIIlllllllIllIIlIlI, final int llllllllllllllIIlllllllIllIIlIII) {
        return Items.banner;
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    protected BlockBanner() {
        super(Material.wood);
        final float llllllllllllllIIlllllllIllllllIl = 0.25f;
        final float llllllllllllllIIlllllllIlllllIll = 1.0f;
        this.setBlockBounds(0.5f - llllllllllllllIIlllllllIllllllIl, 0.0f, 0.5f - llllllllllllllIIlllllllIllllllIl, 0.5f + llllllllllllllIIlllllllIllllllIl, llllllllllllllIIlllllllIlllllIll, 0.5f + llllllllllllllIIlllllllIllllllIl);
    }
    
    @Override
    public void harvestBlock(final World llllllllllllllIIlllllllIlIIIIIll, final EntityPlayer llllllllllllllIIlllllllIIllllIlI, final BlockPos llllllllllllllIIlllllllIlIIIIIIl, final IBlockState llllllllllllllIIlllllllIIllllIII, final TileEntity llllllllllllllIIlllllllIIlllllll) {
        if (llllllllllllllIIlllllllIIlllllll instanceof TileEntityBanner) {
            final ItemStack llllllllllllllIIlllllllIIllllllI = new ItemStack(Items.banner, 1, ((TileEntityBanner)llllllllllllllIIlllllllIIlllllll).getBaseColor());
            final NBTTagCompound llllllllllllllIIlllllllIIlllllIl = new NBTTagCompound();
            llllllllllllllIIlllllllIIlllllll.writeToNBT(llllllllllllllIIlllllllIIlllllIl);
            llllllllllllllIIlllllllIIlllllIl.removeTag("x");
            llllllllllllllIIlllllllIIlllllIl.removeTag("y");
            llllllllllllllIIlllllllIIlllllIl.removeTag("z");
            llllllllllllllIIlllllllIIlllllIl.removeTag("id");
            llllllllllllllIIlllllllIIllllllI.setTagInfo("BlockEntityTag", llllllllllllllIIlllllllIIlllllIl);
            Block.spawnAsEntity(llllllllllllllIIlllllllIlIIIIIll, llllllllllllllIIlllllllIlIIIIIIl, llllllllllllllIIlllllllIIllllllI);
        }
        else {
            super.harvestBlock(llllllllllllllIIlllllllIlIIIIIll, llllllllllllllIIlllllllIIllllIlI, llllllllllllllIIlllllllIlIIIIIIl, llllllllllllllIIlllllllIIllllIII, null);
        }
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] SWITCH_MAP;
        
        static {
            __OBFID = "CL_00002142";
            SWITCH_MAP = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.SWITCH_MAP[EnumFacing.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.SWITCH_MAP[EnumFacing.SOUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.SWITCH_MAP[EnumFacing.WEST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumFacing.SWITCH_MAP[EnumFacing.EAST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
        }
    }
    
    public static class BlockBannerHanging extends BlockBanner
    {
        @Override
        public void setBlockBoundsBasedOnState(final IBlockAccess llllllllllllllIllIIIIllIIllllIII, final BlockPos llllllllllllllIllIIIIllIIlllIlll) {
            final EnumFacing llllllllllllllIllIIIIllIIlllllll = (EnumFacing)llllllllllllllIllIIIIllIIllllIII.getBlockState(llllllllllllllIllIIIIllIIlllIlll).getValue(BlockBannerHanging.FACING_PROP);
            final float llllllllllllllIllIIIIllIIllllllI = 0.0f;
            final float llllllllllllllIllIIIIllIIlllllIl = 0.78125f;
            final float llllllllllllllIllIIIIllIIlllllII = 0.0f;
            final float llllllllllllllIllIIIIllIIllllIll = 1.0f;
            final float llllllllllllllIllIIIIllIIllllIlI = 0.125f;
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            switch (SwitchEnumFacing.SWITCH_MAP[llllllllllllllIllIIIIllIIlllllll.ordinal()]) {
                default: {
                    this.setBlockBounds(llllllllllllllIllIIIIllIIlllllII, llllllllllllllIllIIIIllIIllllllI, 1.0f - llllllllllllllIllIIIIllIIllllIlI, llllllllllllllIllIIIIllIIllllIll, llllllllllllllIllIIIIllIIlllllIl, 1.0f);
                    break;
                }
                case 2: {
                    this.setBlockBounds(llllllllllllllIllIIIIllIIlllllII, llllllllllllllIllIIIIllIIllllllI, 0.0f, llllllllllllllIllIIIIllIIllllIll, llllllllllllllIllIIIIllIIlllllIl, llllllllllllllIllIIIIllIIllllIlI);
                    break;
                }
                case 3: {
                    this.setBlockBounds(1.0f - llllllllllllllIllIIIIllIIllllIlI, llllllllllllllIllIIIIllIIllllllI, llllllllllllllIllIIIIllIIlllllII, 1.0f, llllllllllllllIllIIIIllIIlllllIl, llllllllllllllIllIIIIllIIllllIll);
                    break;
                }
                case 4: {
                    this.setBlockBounds(0.0f, llllllllllllllIllIIIIllIIllllllI, llllllllllllllIllIIIIllIIlllllII, llllllllllllllIllIIIIllIIllllIlI, llllllllllllllIllIIIIllIIlllllIl, llllllllllllllIllIIIIllIIllllIll);
                    break;
                }
            }
        }
        
        @Override
        protected BlockState createBlockState() {
            return new BlockState(this, new IProperty[] { BlockBannerHanging.FACING_PROP });
        }
        
        public BlockBannerHanging() {
            this.setDefaultState(this.blockState.getBaseState().withProperty(BlockBannerHanging.FACING_PROP, EnumFacing.NORTH));
        }
        
        @Override
        public int getMetaFromState(final IBlockState llllllllllllllIllIIIIllIIlIlIIlI) {
            return ((EnumFacing)llllllllllllllIllIIIIllIIlIlIIlI.getValue(BlockBannerHanging.FACING_PROP)).getIndex();
        }
        
        @Override
        public IBlockState getStateFromMeta(final int llllllllllllllIllIIIIllIIlIllIlI) {
            EnumFacing llllllllllllllIllIIIIllIIlIllIIl = EnumFacing.getFront(llllllllllllllIllIIIIllIIlIllIlI);
            if (llllllllllllllIllIIIIllIIlIllIIl.getAxis() == EnumFacing.Axis.Y) {
                llllllllllllllIllIIIIllIIlIllIIl = EnumFacing.NORTH;
            }
            return this.getDefaultState().withProperty(BlockBannerHanging.FACING_PROP, llllllllllllllIllIIIIllIIlIllIIl);
        }
        
        @Override
        public void onNeighborBlockChange(final World llllllllllllllIllIIIIllIIllIlIIl, final BlockPos llllllllllllllIllIIIIllIIllIIIlI, final IBlockState llllllllllllllIllIIIIllIIllIIlll, final Block llllllllllllllIllIIIIllIIllIIllI) {
            final EnumFacing llllllllllllllIllIIIIllIIllIIlIl = (EnumFacing)llllllllllllllIllIIIIllIIllIIlll.getValue(BlockBannerHanging.FACING_PROP);
            if (!llllllllllllllIllIIIIllIIllIlIIl.getBlockState(llllllllllllllIllIIIIllIIllIIIlI.offset(llllllllllllllIllIIIIllIIllIIlIl.getOpposite())).getBlock().getMaterial().isSolid()) {
                this.dropBlockAsItem(llllllllllllllIllIIIIllIIllIlIIl, llllllllllllllIllIIIIllIIllIIIlI, llllllllllllllIllIIIIllIIllIIlll, 0);
                llllllllllllllIllIIIIllIIllIlIIl.setBlockToAir(llllllllllllllIllIIIIllIIllIIIlI);
            }
            super.onNeighborBlockChange(llllllllllllllIllIIIIllIIllIlIIl, llllllllllllllIllIIIIllIIllIIIlI, llllllllllllllIllIIIIllIIllIIlll, llllllllllllllIllIIIIllIIllIIllI);
        }
        
        static {
            __OBFID = "CL_00002140";
        }
    }
    
    public static class BlockBannerStanding extends BlockBanner
    {
        @Override
        public int getMetaFromState(final IBlockState llllllllllllllllIIIIIIlIllllIlll) {
            return (int)llllllllllllllllIIIIIIlIllllIlll.getValue(BlockBannerStanding.ROTATION_PROP);
        }
        
        @Override
        public IBlockState getStateFromMeta(final int llllllllllllllllIIIIIIlIllllllIl) {
            return this.getDefaultState().withProperty(BlockBannerStanding.ROTATION_PROP, llllllllllllllllIIIIIIlIllllllIl);
        }
        
        @Override
        public void onNeighborBlockChange(final World llllllllllllllllIIIIIIllIIIIlIIl, final BlockPos llllllllllllllllIIIIIIllIIIIIIll, final IBlockState llllllllllllllllIIIIIIllIIIIIIlI, final Block llllllllllllllllIIIIIIllIIIIIllI) {
            if (!llllllllllllllllIIIIIIllIIIIlIIl.getBlockState(llllllllllllllllIIIIIIllIIIIIIll.offsetDown()).getBlock().getMaterial().isSolid()) {
                this.dropBlockAsItem(llllllllllllllllIIIIIIllIIIIlIIl, llllllllllllllllIIIIIIllIIIIIIll, llllllllllllllllIIIIIIllIIIIIIlI, 0);
                llllllllllllllllIIIIIIllIIIIlIIl.setBlockToAir(llllllllllllllllIIIIIIllIIIIIIll);
            }
            super.onNeighborBlockChange(llllllllllllllllIIIIIIllIIIIlIIl, llllllllllllllllIIIIIIllIIIIIIll, llllllllllllllllIIIIIIllIIIIIIlI, llllllllllllllllIIIIIIllIIIIIllI);
        }
        
        public BlockBannerStanding() {
            this.setDefaultState(this.blockState.getBaseState().withProperty(BlockBannerStanding.ROTATION_PROP, 0));
        }
        
        static {
            __OBFID = "CL_00002141";
        }
        
        @Override
        protected BlockState createBlockState() {
            return new BlockState(this, new IProperty[] { BlockBannerStanding.ROTATION_PROP });
        }
    }
}
