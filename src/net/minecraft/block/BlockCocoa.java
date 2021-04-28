package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class BlockCocoa extends BlockDirectional implements IGrowable
{
    public static final /* synthetic */ PropertyInteger field_176501_a;
    
    @Override
    public Item getItem(final World llllllllllllllIIIIlllIIlIIIllIII, final BlockPos llllllllllllllIIIIlllIIlIIIlIlll) {
        return Items.dye;
    }
    
    @Override
    public boolean isStillGrowing(final World llllllllllllllIIIIlllIIlIIIlIIIl, final BlockPos llllllllllllllIIIIlllIIlIIIlIIII, final IBlockState llllllllllllllIIIIlllIIlIIIIllll, final boolean llllllllllllllIIIIlllIIlIIIIlllI) {
        return (int)llllllllllllllIIIIlllIIlIIIIllll.getValue(BlockCocoa.field_176501_a) < 2;
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockCocoa.AGE, BlockCocoa.field_176501_a });
    }
    
    @Override
    public void grow(final World llllllllllllllIIIIlllIIlIIIIIIll, final Random llllllllllllllIIIIlllIIlIIIIIIlI, final BlockPos llllllllllllllIIIIlllIIlIIIIIIIl, final IBlockState llllllllllllllIIIIlllIIIllllllIl) {
        llllllllllllllIIIIlllIIlIIIIIIll.setBlockState(llllllllllllllIIIIlllIIlIIIIIIIl, llllllllllllllIIIIlllIIIllllllIl.withProperty(BlockCocoa.field_176501_a, (int)llllllllllllllIIIIlllIIIllllllIl.getValue(BlockCocoa.field_176501_a) + 1), 2);
    }
    
    @Override
    public int getDamageValue(final World llllllllllllllIIIIlllIIlIIIlIlIl, final BlockPos llllllllllllllIIIIlllIIlIIIlIlII) {
        return EnumDyeColor.BROWN.getDyeColorDamage();
    }
    
    public BlockCocoa() {
        super(Material.plants);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockCocoa.AGE, EnumFacing.NORTH).withProperty(BlockCocoa.field_176501_a, 0));
        this.setTickRandomly(true);
    }
    
    @Override
    public boolean canUseBonemeal(final World llllllllllllllIIIIlllIIlIIIIlIll, final Random llllllllllllllIIIIlllIIlIIIIlIlI, final BlockPos llllllllllllllIIIIlllIIlIIIIlIIl, final IBlockState llllllllllllllIIIIlllIIlIIIIlIII) {
        return true;
    }
    
    @Override
    public AxisAlignedBB getSelectedBoundingBox(final World llllllllllllllIIIIlllIIllIIIIlIl, final BlockPos llllllllllllllIIIIlllIIllIIIIIIl) {
        this.setBlockBoundsBasedOnState(llllllllllllllIIIIlllIIllIIIIlIl, llllllllllllllIIIIlllIIllIIIIIIl);
        return super.getSelectedBoundingBox(llllllllllllllIIIIlllIIllIIIIlIl, llllllllllllllIIIIlllIIllIIIIIIl);
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }
    
    @Override
    public void onBlockPlacedBy(final World llllllllllllllIIIIlllIIlIlIlllll, final BlockPos llllllllllllllIIIIlllIIlIlIllIII, final IBlockState llllllllllllllIIIIlllIIlIlIlIlll, final EntityLivingBase llllllllllllllIIIIlllIIlIlIlIllI, final ItemStack llllllllllllllIIIIlllIIlIlIllIll) {
        final EnumFacing llllllllllllllIIIIlllIIlIlIllIlI = EnumFacing.fromAngle(llllllllllllllIIIIlllIIlIlIlIllI.rotationYaw);
        llllllllllllllIIIIlllIIlIlIlllll.setBlockState(llllllllllllllIIIIlllIIlIlIllIII, llllllllllllllIIIIlllIIlIlIlIlll.withProperty(BlockCocoa.AGE, llllllllllllllIIIIlllIIlIlIllIlI), 2);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIIIIlllIIIllllIllI) {
        return this.getDefaultState().withProperty(BlockCocoa.AGE, EnumFacing.getHorizontal(llllllllllllllIIIIlllIIIllllIllI)).withProperty(BlockCocoa.field_176501_a, (llllllllllllllIIIIlllIIIllllIllI & 0xF) >> 2);
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World llllllllllllllIIIIlllIIllIIlIIII, final BlockPos llllllllllllllIIIIlllIIllIIIlIll, final IBlockState llllllllllllllIIIIlllIIllIIIlllI) {
        this.setBlockBoundsBasedOnState(llllllllllllllIIIIlllIIllIIlIIII, llllllllllllllIIIIlllIIllIIIlIll);
        return super.getCollisionBoundingBox(llllllllllllllIIIIlllIIllIIlIIII, llllllllllllllIIIIlllIIllIIIlIll, llllllllllllllIIIIlllIIllIIIlllI);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIIIIlllIIIlllIlllI) {
        final byte llllllllllllllIIIIlllIIIllllIIII = 0;
        int llllllllllllllIIIIlllIIIlllIllll = llllllllllllllIIIIlllIIIllllIIII | ((EnumFacing)llllllllllllllIIIIlllIIIlllIlllI.getValue(BlockCocoa.AGE)).getHorizontalIndex();
        llllllllllllllIIIIlllIIIlllIllll |= (int)llllllllllllllIIIIlllIIIlllIlllI.getValue(BlockCocoa.field_176501_a) << 2;
        return llllllllllllllIIIIlllIIIlllIllll;
    }
    
    @Override
    public void onNeighborBlockChange(final World llllllllllllllIIIIlllIIlIIllllIl, final BlockPos llllllllllllllIIIIlllIIlIIllllII, final IBlockState llllllllllllllIIIIlllIIlIlIIIIII, final Block llllllllllllllIIIIlllIIlIIllllll) {
        if (!this.canBlockStay(llllllllllllllIIIIlllIIlIIllllIl, llllllllllllllIIIIlllIIlIIllllII, llllllllllllllIIIIlllIIlIlIIIIII)) {
            this.dropBlock(llllllllllllllIIIIlllIIlIIllllIl, llllllllllllllIIIIlllIIlIIllllII, llllllllllllllIIIIlllIIlIlIIIIII);
        }
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllllIIIIlllIIlIlIlIIIl, final BlockPos llllllllllllllIIIIlllIIlIlIlIIII, EnumFacing llllllllllllllIIIIlllIIlIlIIlIII, final float llllllllllllllIIIIlllIIlIlIIlllI, final float llllllllllllllIIIIlllIIlIlIIllIl, final float llllllllllllllIIIIlllIIlIlIIllII, final int llllllllllllllIIIIlllIIlIlIIlIll, final EntityLivingBase llllllllllllllIIIIlllIIlIlIIlIlI) {
        if (!llllllllllllllIIIIlllIIlIlIIlIII.getAxis().isHorizontal()) {
            llllllllllllllIIIIlllIIlIlIIlIII = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty(BlockCocoa.AGE, llllllllllllllIIIIlllIIlIlIIlIII.getOpposite()).withProperty(BlockCocoa.field_176501_a, 0);
    }
    
    @Override
    public void updateTick(final World llllllllllllllIIIIlllIIllIlIlllI, final BlockPos llllllllllllllIIIIlllIIllIlIllIl, final IBlockState llllllllllllllIIIIlllIIllIlIIllI, final Random llllllllllllllIIIIlllIIllIlIlIll) {
        if (!this.canBlockStay(llllllllllllllIIIIlllIIllIlIlllI, llllllllllllllIIIIlllIIllIlIllIl, llllllllllllllIIIIlllIIllIlIIllI)) {
            this.dropBlock(llllllllllllllIIIIlllIIllIlIlllI, llllllllllllllIIIIlllIIllIlIllIl, llllllllllllllIIIIlllIIllIlIIllI);
        }
        else if (llllllllllllllIIIIlllIIllIlIlllI.rand.nextInt(5) == 0) {
            final int llllllllllllllIIIIlllIIllIlIlIlI = (int)llllllllllllllIIIIlllIIllIlIIllI.getValue(BlockCocoa.field_176501_a);
            if (llllllllllllllIIIIlllIIllIlIlIlI < 2) {
                llllllllllllllIIIIlllIIllIlIlllI.setBlockState(llllllllllllllIIIIlllIIllIlIllIl, llllllllllllllIIIIlllIIllIlIIllI.withProperty(BlockCocoa.field_176501_a, llllllllllllllIIIIlllIIllIlIlIlI + 1), 2);
            }
        }
    }
    
    public boolean canBlockStay(final World llllllllllllllIIIIlllIIllIIlllll, BlockPos llllllllllllllIIIIlllIIllIIllIlI, final IBlockState llllllllllllllIIIIlllIIllIIllIIl) {
        llllllllllllllIIIIlllIIllIIllIlI = llllllllllllllIIIIlllIIllIIllIlI.offset((EnumFacing)llllllllllllllIIIIlllIIllIIllIIl.getValue(BlockCocoa.AGE));
        final IBlockState llllllllllllllIIIIlllIIllIIlllII = llllllllllllllIIIIlllIIllIIlllll.getBlockState(llllllllllllllIIIIlllIIllIIllIlI);
        return llllllllllllllIIIIlllIIllIIlllII.getBlock() == Blocks.log && llllllllllllllIIIIlllIIllIIlllII.getValue(BlockPlanks.VARIANT_PROP) == BlockPlanks.EnumType.JUNGLE;
    }
    
    private void dropBlock(final World llllllllllllllIIIIlllIIlIIllIlIl, final BlockPos llllllllllllllIIIIlllIIlIIllIIII, final IBlockState llllllllllllllIIIIlllIIlIIlIllll) {
        llllllllllllllIIIIlllIIlIIllIlIl.setBlockState(llllllllllllllIIIIlllIIlIIllIIII, Blocks.air.getDefaultState(), 3);
        this.dropBlockAsItem(llllllllllllllIIIIlllIIlIIllIlIl, llllllllllllllIIIIlllIIlIIllIIII, llllllllllllllIIIIlllIIlIIlIllll, 0);
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    static {
        __OBFID = "CL_00000216";
        field_176501_a = PropertyInteger.create("age", 0, 2);
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess llllllllllllllIIIIlllIIlIlllIllI, final BlockPos llllllllllllllIIIIlllIIlIllIllII) {
        final IBlockState llllllllllllllIIIIlllIIlIlllIlII = llllllllllllllIIIIlllIIlIlllIllI.getBlockState(llllllllllllllIIIIlllIIlIllIllII);
        final EnumFacing llllllllllllllIIIIlllIIlIlllIIll = (EnumFacing)llllllllllllllIIIIlllIIlIlllIlII.getValue(BlockCocoa.AGE);
        final int llllllllllllllIIIIlllIIlIlllIIlI = (int)llllllllllllllIIIIlllIIlIlllIlII.getValue(BlockCocoa.field_176501_a);
        final int llllllllllllllIIIIlllIIlIlllIIIl = 4 + llllllllllllllIIIIlllIIlIlllIIlI * 2;
        final int llllllllllllllIIIIlllIIlIlllIIII = 5 + llllllllllllllIIIIlllIIlIlllIIlI * 2;
        final float llllllllllllllIIIIlllIIlIllIllll = llllllllllllllIIIIlllIIlIlllIIIl / 2.0f;
        switch (SwitchEnumFacing.FACINGARRAY[llllllllllllllIIIIlllIIlIlllIIll.ordinal()]) {
            case 1: {
                this.setBlockBounds((8.0f - llllllllllllllIIIIlllIIlIllIllll) / 16.0f, (12.0f - llllllllllllllIIIIlllIIlIlllIIII) / 16.0f, (15.0f - llllllllllllllIIIIlllIIlIlllIIIl) / 16.0f, (8.0f + llllllllllllllIIIIlllIIlIllIllll) / 16.0f, 0.75f, 0.9375f);
                break;
            }
            case 2: {
                this.setBlockBounds((8.0f - llllllllllllllIIIIlllIIlIllIllll) / 16.0f, (12.0f - llllllllllllllIIIIlllIIlIlllIIII) / 16.0f, 0.0625f, (8.0f + llllllllllllllIIIIlllIIlIllIllll) / 16.0f, 0.75f, (1.0f + llllllllllllllIIIIlllIIlIlllIIIl) / 16.0f);
                break;
            }
            case 3: {
                this.setBlockBounds(0.0625f, (12.0f - llllllllllllllIIIIlllIIlIlllIIII) / 16.0f, (8.0f - llllllllllllllIIIIlllIIlIllIllll) / 16.0f, (1.0f + llllllllllllllIIIIlllIIlIlllIIIl) / 16.0f, 0.75f, (8.0f + llllllllllllllIIIIlllIIlIllIllll) / 16.0f);
                break;
            }
            case 4: {
                this.setBlockBounds((15.0f - llllllllllllllIIIIlllIIlIlllIIIl) / 16.0f, (12.0f - llllllllllllllIIIIlllIIlIlllIIII) / 16.0f, (8.0f - llllllllllllllIIIIlllIIlIllIllll) / 16.0f, 0.9375f, 0.75f, (8.0f + llllllllllllllIIIIlllIIlIllIllll) / 16.0f);
                break;
            }
        }
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World llllllllllllllIIIIlllIIlIIlIIlll, final BlockPos llllllllllllllIIIIlllIIlIIlIIllI, final IBlockState llllllllllllllIIIIlllIIlIIlIIlIl, final float llllllllllllllIIIIlllIIlIIlIIlII, final int llllllllllllllIIIIlllIIlIIlIIIll) {
        final int llllllllllllllIIIIlllIIlIIlIIIlI = (int)llllllllllllllIIIIlllIIlIIlIIlIl.getValue(BlockCocoa.field_176501_a);
        byte llllllllllllllIIIIlllIIlIIlIIIIl = 1;
        if (llllllllllllllIIIIlllIIlIIlIIIlI >= 2) {
            llllllllllllllIIIIlllIIlIIlIIIIl = 3;
        }
        for (int llllllllllllllIIIIlllIIlIIlIIIII = 0; llllllllllllllIIIIlllIIlIIlIIIII < llllllllllllllIIIIlllIIlIIlIIIIl; ++llllllllllllllIIIIlllIIlIIlIIIII) {
            Block.spawnAsEntity(llllllllllllllIIIIlllIIlIIlIIlll, llllllllllllllIIIIlllIIlIIlIIllI, new ItemStack(Items.dye, 1, EnumDyeColor.BROWN.getDyeColorDamage()));
        }
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] FACINGARRAY;
        
        static {
            __OBFID = "CL_00002130";
            FACINGARRAY = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.FACINGARRAY[EnumFacing.SOUTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.FACINGARRAY[EnumFacing.NORTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.FACINGARRAY[EnumFacing.WEST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumFacing.FACINGARRAY[EnumFacing.EAST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
        }
    }
}
