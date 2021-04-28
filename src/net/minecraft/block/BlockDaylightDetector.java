package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.item.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.tileentity.*;
import java.util.*;
import net.minecraft.block.material.*;

public class BlockDaylightDetector extends BlockContainer
{
    public static final /* synthetic */ PropertyInteger field_176436_a;
    private final /* synthetic */ boolean field_176435_b;
    
    public void func_180677_d(final World llllllllllllllIIIIllllIIIlllIIlI, final BlockPos llllllllllllllIIIIllllIIIlllIIIl) {
        if (!llllllllllllllIIIIllllIIIlllIIlI.provider.getHasNoSky()) {
            final IBlockState llllllllllllllIIIIllllIIIlllIIII = llllllllllllllIIIIllllIIIlllIIlI.getBlockState(llllllllllllllIIIIllllIIIlllIIIl);
            int llllllllllllllIIIIllllIIIllIllll = llllllllllllllIIIIllllIIIlllIIlI.getLightFor(EnumSkyBlock.SKY, llllllllllllllIIIIllllIIIlllIIIl) - llllllllllllllIIIIllllIIIlllIIlI.getSkylightSubtracted();
            float llllllllllllllIIIIllllIIIllIlllI = llllllllllllllIIIIllllIIIlllIIlI.getCelestialAngleRadians(1.0f);
            final float llllllllllllllIIIIllllIIIllIllIl = (llllllllllllllIIIIllllIIIllIlllI < 3.1415927f) ? 0.0f : 6.2831855f;
            llllllllllllllIIIIllllIIIllIlllI += (llllllllllllllIIIIllllIIIllIllIl - llllllllllllllIIIIllllIIIllIlllI) * 0.2f;
            llllllllllllllIIIIllllIIIllIllll = Math.round(llllllllllllllIIIIllllIIIllIllll * MathHelper.cos(llllllllllllllIIIIllllIIIllIlllI));
            llllllllllllllIIIIllllIIIllIllll = MathHelper.clamp_int(llllllllllllllIIIIllllIIIllIllll, 0, 15);
            if (this.field_176435_b) {
                llllllllllllllIIIIllllIIIllIllll = 15 - llllllllllllllIIIIllllIIIllIllll;
            }
            if ((int)llllllllllllllIIIIllllIIIlllIIII.getValue(BlockDaylightDetector.field_176436_a) != llllllllllllllIIIIllllIIIllIllll) {
                llllllllllllllIIIIllllIIIlllIIlI.setBlockState(llllllllllllllIIIIllllIIIlllIIIl, llllllllllllllIIIIllllIIIlllIIII.withProperty(BlockDaylightDetector.field_176436_a, llllllllllllllIIIIllllIIIllIllll), 3);
            }
        }
    }
    
    @Override
    public void getSubBlocks(final Item llllllllllllllIIIIllllIIIIlIlIlI, final CreativeTabs llllllllllllllIIIIllllIIIIlIlIIl, final List llllllllllllllIIIIllllIIIIlIIlII) {
        if (!this.field_176435_b) {
            super.getSubBlocks(llllllllllllllIIIIllllIIIIlIlIlI, llllllllllllllIIIIllllIIIIlIlIIl, llllllllllllllIIIIllllIIIIlIIlII);
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIIIIllllIIIIllIlII) {
        return (int)llllllllllllllIIIIllllIIIIllIlII.getValue(BlockDaylightDetector.field_176436_a);
    }
    
    @Override
    public boolean canProvidePower() {
        return true;
    }
    
    @Override
    public int getRenderType() {
        return 3;
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllllIIIIllllIIIlIllIll, final BlockPos llllllllllllllIIIIllllIIIlIllIlI, final IBlockState llllllllllllllIIIIllllIIIlIlIIII, final EntityPlayer llllllllllllllIIIIllllIIIlIIllll, final EnumFacing llllllllllllllIIIIllllIIIlIIlllI, final float llllllllllllllIIIIllllIIIlIIllIl, final float llllllllllllllIIIIllllIIIlIIllII, final float llllllllllllllIIIIllllIIIlIlIlII) {
        if (!llllllllllllllIIIIllllIIIlIIllll.func_175142_cm()) {
            return super.onBlockActivated(llllllllllllllIIIIllllIIIlIllIll, llllllllllllllIIIIllllIIIlIllIlI, llllllllllllllIIIIllllIIIlIlIIII, llllllllllllllIIIIllllIIIlIIllll, llllllllllllllIIIIllllIIIlIIlllI, llllllllllllllIIIIllllIIIlIIllIl, llllllllllllllIIIIllllIIIlIIllII, llllllllllllllIIIIllllIIIlIlIlII);
        }
        if (llllllllllllllIIIIllllIIIlIllIll.isRemote) {
            return true;
        }
        if (this.field_176435_b) {
            llllllllllllllIIIIllllIIIlIllIll.setBlockState(llllllllllllllIIIIllllIIIlIllIlI, Blocks.daylight_detector.getDefaultState().withProperty(BlockDaylightDetector.field_176436_a, llllllllllllllIIIIllllIIIlIlIIII.getValue(BlockDaylightDetector.field_176436_a)), 4);
            Blocks.daylight_detector.func_180677_d(llllllllllllllIIIIllllIIIlIllIll, llllllllllllllIIIIllllIIIlIllIlI);
        }
        else {
            llllllllllllllIIIIllllIIIlIllIll.setBlockState(llllllllllllllIIIIllllIIIlIllIlI, Blocks.daylight_detector_inverted.getDefaultState().withProperty(BlockDaylightDetector.field_176436_a, llllllllllllllIIIIllllIIIlIlIIII.getValue(BlockDaylightDetector.field_176436_a)), 4);
            Blocks.daylight_detector_inverted.func_180677_d(llllllllllllllIIIIllllIIIlIllIll, llllllllllllllIIIIllllIIIlIllIlI);
        }
        return true;
    }
    
    @Override
    public int isProvidingWeakPower(final IBlockAccess llllllllllllllIIIIllllIIIlllllll, final BlockPos llllllllllllllIIIIllllIIIllllllI, final IBlockState llllllllllllllIIIIllllIIIllllIll, final EnumFacing llllllllllllllIIIIllllIIIlllllII) {
        return (int)llllllllllllllIIIIllllIIIllllIll.getValue(BlockDaylightDetector.field_176436_a);
    }
    
    static {
        __OBFID = "CL_00000223";
        field_176436_a = PropertyInteger.create("power", 0, 15);
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockDaylightDetector.field_176436_a });
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIIIIllllIIIIlllIIl) {
        return this.getDefaultState().withProperty(BlockDaylightDetector.field_176436_a, llllllllllllllIIIIllllIIIIlllIIl);
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllllIIIIllllIIIIlllllI, final int llllllllllllllIIIIllllIIIIllllIl) {
        return new TileEntityDaylightDetector();
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public Item getItem(final World llllllllllllllIIIIllllIIIlIIIlIl, final BlockPos llllllllllllllIIIIllllIIIlIIIlII) {
        return Item.getItemFromBlock(Blocks.daylight_detector);
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIIIIllllIIIlIIlIIl, final Random llllllllllllllIIIIllllIIIlIIlIII, final int llllllllllllllIIIIllllIIIlIIIlll) {
        return Item.getItemFromBlock(Blocks.daylight_detector);
    }
    
    public BlockDaylightDetector(final boolean llllllllllllllIIIIllllIIlIIIIlll) {
        super(Material.wood);
        this.field_176435_b = llllllllllllllIIIIllllIIlIIIIlll;
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockDaylightDetector.field_176436_a, 0));
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.375f, 1.0f);
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setHardness(0.2f);
        this.setStepSound(BlockDaylightDetector.soundTypeWood);
        this.setUnlocalizedName("daylightDetector");
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess llllllllllllllIIIIllllIIlIIIIlII, final BlockPos llllllllllllllIIIIllllIIlIIIIIll) {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.375f, 1.0f);
    }
}
