package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import net.minecraft.tileentity.*;
import net.minecraft.stats.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.util.*;

public class BlockVine extends Block
{
    public static final /* synthetic */ int field_176276_R;
    public static final /* synthetic */ PropertyBool[] field_176274_P;
    public static final /* synthetic */ int field_176275_S;
    public static final /* synthetic */ PropertyBool field_176278_M;
    public static final /* synthetic */ int field_176272_Q;
    public static final /* synthetic */ PropertyBool field_176277_a;
    public static final /* synthetic */ PropertyBool field_176280_O;
    public static final /* synthetic */ int field_176271_T;
    public static final /* synthetic */ PropertyBool field_176273_b;
    public static final /* synthetic */ PropertyBool field_176279_N;
    
    private boolean func_150093_a(final Block lllllllllllllllllIIlIIIIIIlIlIll) {
        return lllllllllllllllllIIlIIIIIIlIlIll.isFullCube() && lllllllllllllllllIIlIIIIIIlIlIll.blockMaterial.blocksMovement();
    }
    
    @Override
    public IBlockState getActualState(final IBlockState lllllllllllllllllIIlIIIIIllIlIIl, final IBlockAccess lllllllllllllllllIIlIIIIIllIlIII, final BlockPos lllllllllllllllllIIlIIIIIllIlIlI) {
        return lllllllllllllllllIIlIIIIIllIlIIl.withProperty(BlockVine.field_176277_a, lllllllllllllllllIIlIIIIIllIlIII.getBlockState(lllllllllllllllllIIlIIIIIllIlIlI.offsetUp()).getBlock().isSolidFullCube());
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess lllllllllllllllllIIlIIIIIlIIIlll, final BlockPos lllllllllllllllllIIlIIIIIlIlIIIl) {
        final float lllllllllllllllllIIlIIIIIlIlIIII = 0.0625f;
        float lllllllllllllllllIIlIIIIIlIIllll = 1.0f;
        float lllllllllllllllllIIlIIIIIlIIlllI = 1.0f;
        float lllllllllllllllllIIlIIIIIlIIllIl = 1.0f;
        float lllllllllllllllllIIlIIIIIlIIllII = 0.0f;
        float lllllllllllllllllIIlIIIIIlIIlIll = 0.0f;
        float lllllllllllllllllIIlIIIIIlIIlIlI = 0.0f;
        boolean lllllllllllllllllIIlIIIIIlIIlIIl = false;
        if (lllllllllllllllllIIlIIIIIlIIIlll.getBlockState(lllllllllllllllllIIlIIIIIlIlIIIl).getValue(BlockVine.field_176280_O)) {
            lllllllllllllllllIIlIIIIIlIIllII = Math.max(lllllllllllllllllIIlIIIIIlIIllII, 0.0625f);
            lllllllllllllllllIIlIIIIIlIIllll = 0.0f;
            lllllllllllllllllIIlIIIIIlIIlllI = 0.0f;
            lllllllllllllllllIIlIIIIIlIIlIll = 1.0f;
            lllllllllllllllllIIlIIIIIlIIllIl = 0.0f;
            lllllllllllllllllIIlIIIIIlIIlIlI = 1.0f;
            lllllllllllllllllIIlIIIIIlIIlIIl = true;
        }
        if (lllllllllllllllllIIlIIIIIlIIIlll.getBlockState(lllllllllllllllllIIlIIIIIlIlIIIl).getValue(BlockVine.field_176278_M)) {
            lllllllllllllllllIIlIIIIIlIIllll = Math.min(lllllllllllllllllIIlIIIIIlIIllll, 0.9375f);
            lllllllllllllllllIIlIIIIIlIIllII = 1.0f;
            lllllllllllllllllIIlIIIIIlIIlllI = 0.0f;
            lllllllllllllllllIIlIIIIIlIIlIll = 1.0f;
            lllllllllllllllllIIlIIIIIlIIllIl = 0.0f;
            lllllllllllllllllIIlIIIIIlIIlIlI = 1.0f;
            lllllllllllllllllIIlIIIIIlIIlIIl = true;
        }
        if (lllllllllllllllllIIlIIIIIlIIIlll.getBlockState(lllllllllllllllllIIlIIIIIlIlIIIl).getValue(BlockVine.field_176273_b)) {
            lllllllllllllllllIIlIIIIIlIIlIlI = Math.max(lllllllllllllllllIIlIIIIIlIIlIlI, 0.0625f);
            lllllllllllllllllIIlIIIIIlIIllIl = 0.0f;
            lllllllllllllllllIIlIIIIIlIIllll = 0.0f;
            lllllllllllllllllIIlIIIIIlIIllII = 1.0f;
            lllllllllllllllllIIlIIIIIlIIlllI = 0.0f;
            lllllllllllllllllIIlIIIIIlIIlIll = 1.0f;
            lllllllllllllllllIIlIIIIIlIIlIIl = true;
        }
        if (lllllllllllllllllIIlIIIIIlIIIlll.getBlockState(lllllllllllllllllIIlIIIIIlIlIIIl).getValue(BlockVine.field_176279_N)) {
            lllllllllllllllllIIlIIIIIlIIllIl = Math.min(lllllllllllllllllIIlIIIIIlIIllIl, 0.9375f);
            lllllllllllllllllIIlIIIIIlIIlIlI = 1.0f;
            lllllllllllllllllIIlIIIIIlIIllll = 0.0f;
            lllllllllllllllllIIlIIIIIlIIllII = 1.0f;
            lllllllllllllllllIIlIIIIIlIIlllI = 0.0f;
            lllllllllllllllllIIlIIIIIlIIlIll = 1.0f;
            lllllllllllllllllIIlIIIIIlIIlIIl = true;
        }
        if (!lllllllllllllllllIIlIIIIIlIIlIIl && this.func_150093_a(lllllllllllllllllIIlIIIIIlIIIlll.getBlockState(lllllllllllllllllIIlIIIIIlIlIIIl.offsetUp()).getBlock())) {
            lllllllllllllllllIIlIIIIIlIIlllI = Math.min(lllllllllllllllllIIlIIIIIlIIlllI, 0.9375f);
            lllllllllllllllllIIlIIIIIlIIlIll = 1.0f;
            lllllllllllllllllIIlIIIIIlIIllll = 0.0f;
            lllllllllllllllllIIlIIIIIlIIllII = 1.0f;
            lllllllllllllllllIIlIIIIIlIIllIl = 0.0f;
            lllllllllllllllllIIlIIIIIlIIlIlI = 1.0f;
        }
        this.setBlockBounds(lllllllllllllllllIIlIIIIIlIIllll, lllllllllllllllllIIlIIIIIlIIlllI, lllllllllllllllllIIlIIIIIlIIllIl, lllllllllllllllllIIlIIIIIlIIllII, lllllllllllllllllIIlIIIIIlIIlIll, lllllllllllllllllIIlIIIIIlIIlIlI);
    }
    
    @Override
    public boolean canPlaceBlockOnSide(final World lllllllllllllllllIIlIIIIIIllIlII, final BlockPos lllllllllllllllllIIlIIIIIIllIIll, final EnumFacing lllllllllllllllllIIlIIIIIIlIlllI) {
        switch (SwitchEnumFacing.field_177057_a[lllllllllllllllllIIlIIIIIIlIlllI.ordinal()]) {
            case 1: {
                return this.func_150093_a(lllllllllllllllllIIlIIIIIIllIlII.getBlockState(lllllllllllllllllIIlIIIIIIllIIll.offsetUp()).getBlock());
            }
            case 2:
            case 3:
            case 4:
            case 5: {
                return this.func_150093_a(lllllllllllllllllIIlIIIIIIllIlII.getBlockState(lllllllllllllllllIIlIIIIIIllIIll.offset(lllllllllllllllllIIlIIIIIIlIlllI.getOpposite())).getBlock());
            }
            default: {
                return false;
            }
        }
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllllllIIIlllllIlIllII, final BlockPos lllllllllllllllllIIIlllllIlIlIll, final EnumFacing lllllllllllllllllIIIlllllIlIIIlI, final float lllllllllllllllllIIIlllllIlIlIIl, final float lllllllllllllllllIIIlllllIlIlIII, final float lllllllllllllllllIIIlllllIlIIlll, final int lllllllllllllllllIIIlllllIlIIllI, final EntityLivingBase lllllllllllllllllIIIlllllIlIIlIl) {
        final IBlockState lllllllllllllllllIIIlllllIlIIlII = this.getDefaultState().withProperty(BlockVine.field_176277_a, false).withProperty(BlockVine.field_176273_b, false).withProperty(BlockVine.field_176278_M, false).withProperty(BlockVine.field_176279_N, false).withProperty(BlockVine.field_176280_O, false);
        return lllllllllllllllllIIIlllllIlIIIlI.getAxis().isHorizontal() ? lllllllllllllllllIIIlllllIlIIlII.withProperty(func_176267_a(lllllllllllllllllIIIlllllIlIIIlI.getOpposite()), true) : lllllllllllllllllIIIlllllIlIIlII;
    }
    
    public BlockVine() {
        super(Material.vine);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockVine.field_176277_a, false).withProperty(BlockVine.field_176273_b, false).withProperty(BlockVine.field_176278_M, false).withProperty(BlockVine.field_176279_N, false).withProperty(BlockVine.field_176280_O, false));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }
    
    private static int func_176270_b(final EnumFacing lllllllllllllllllIIIlllllIllIIIl) {
        return 1 << lllllllllllllllllIIIlllllIllIIIl.getHorizontalIndex();
    }
    
    @Override
    public int colorMultiplier(final IBlockAccess lllllllllllllllllIIlIIIIIIIIIlIl, final BlockPos lllllllllllllllllIIlIIIIIIIIIlll, final int lllllllllllllllllIIlIIIIIIIIIllI) {
        return lllllllllllllllllIIlIIIIIIIIIlIl.getBiomeGenForCoords(lllllllllllllllllIIlIIIIIIIIIlll).func_180625_c(lllllllllllllllllIIlIIIIIIIIIlll);
    }
    
    public static int func_176268_d(final IBlockState lllllllllllllllllIIIllllIlIlllII) {
        int lllllllllllllllllIIIllllIlIllIll = 0;
        for (final PropertyBool lllllllllllllllllIIIllllIlIlIlll : BlockVine.field_176274_P) {
            if (lllllllllllllllllIIIllllIlIlllII.getValue(lllllllllllllllllIIIllllIlIlIlll)) {
                ++lllllllllllllllllIIIllllIlIllIll;
            }
        }
        return lllllllllllllllllIIIllllIlIllIll;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllllllIIIlllllIIlllll, final Random lllllllllllllllllIIIlllllIIllllI, final int lllllllllllllllllIIIlllllIIlllIl) {
        return null;
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllllllllIIIlllllIIllIll) {
        return 0;
    }
    
    @Override
    public boolean isReplaceable(final World lllllllllllllllllIIlIIIIIllIIIII, final BlockPos lllllllllllllllllIIlIIIIIlIlllll) {
        return true;
    }
    
    @Override
    public void harvestBlock(final World lllllllllllllllllIIIlllllIIlIIll, final EntityPlayer lllllllllllllllllIIIlllllIIIllII, final BlockPos lllllllllllllllllIIIlllllIIIlIll, final IBlockState lllllllllllllllllIIIlllllIIIlIlI, final TileEntity lllllllllllllllllIIIlllllIIIllll) {
        if (!lllllllllllllllllIIIlllllIIlIIll.isRemote && lllllllllllllllllIIIlllllIIIllII.getCurrentEquippedItem() != null && lllllllllllllllllIIIlllllIIIllII.getCurrentEquippedItem().getItem() == Items.shears) {
            lllllllllllllllllIIIlllllIIIllII.triggerAchievement(StatList.mineBlockStatArray[Block.getIdFromBlock(this)]);
            Block.spawnAsEntity(lllllllllllllllllIIIlllllIIlIIll, lllllllllllllllllIIIlllllIIIlIll, new ItemStack(Blocks.vine, 1, 0));
        }
        else {
            super.harvestBlock(lllllllllllllllllIIIlllllIIlIIll, lllllllllllllllllIIIlllllIIIllII, lllllllllllllllllIIIlllllIIIlIll, lllllllllllllllllIIIlllllIIIlIlI, lllllllllllllllllIIIlllllIIIllll);
        }
    }
    
    public static PropertyBool func_176267_a(final EnumFacing lllllllllllllllllIIIllllIllIIIll) {
        switch (SwitchEnumFacing.field_177057_a[lllllllllllllllllIIIllllIllIIIll.ordinal()]) {
            case 1: {
                return BlockVine.field_176277_a;
            }
            case 2: {
                return BlockVine.field_176273_b;
            }
            case 3: {
                return BlockVine.field_176279_N;
            }
            case 4: {
                return BlockVine.field_176278_M;
            }
            case 5: {
                return BlockVine.field_176280_O;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(lllllllllllllllllIIIllllIllIIIll).append(" is an invalid choice")));
            }
        }
    }
    
    @Override
    public int getRenderColor(final IBlockState lllllllllllllllllIIlIIIIIIIIllII) {
        return ColorizerFoliage.getFoliageColorBasic();
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockVine.field_176277_a, BlockVine.field_176273_b, BlockVine.field_176278_M, BlockVine.field_176279_N, BlockVine.field_176280_O });
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllllIIIllllIlllIIII) {
        return this.getDefaultState().withProperty(BlockVine.field_176273_b, (lllllllllllllllllIIIllllIlllIIII & BlockVine.field_176276_R) > 0).withProperty(BlockVine.field_176278_M, (lllllllllllllllllIIIllllIlllIIII & BlockVine.field_176275_S) > 0).withProperty(BlockVine.field_176279_N, (lllllllllllllllllIIIllllIlllIIII & BlockVine.field_176272_Q) > 0).withProperty(BlockVine.field_176280_O, (lllllllllllllllllIIIllllIlllIIII & BlockVine.field_176271_T) > 0);
    }
    
    @Override
    public void updateTick(final World lllllllllllllllllIIIlllllllIIlII, final BlockPos lllllllllllllllllIIIlllllllIIIll, final IBlockState lllllllllllllllllIIIllllllIIIIIl, final Random lllllllllllllllllIIIllllllIIIIII) {
        if (!lllllllllllllllllIIIlllllllIIlII.isRemote && lllllllllllllllllIIIlllllllIIlII.rand.nextInt(4) == 0) {
            final byte lllllllllllllllllIIIlllllllIIIII = 4;
            int lllllllllllllllllIIIllllllIlllll = 5;
            boolean lllllllllllllllllIIIllllllIllllI = false;
        Label_0115:
            for (int lllllllllllllllllIIIllllllIlllIl = -lllllllllllllllllIIIlllllllIIIII; lllllllllllllllllIIIllllllIlllIl <= lllllllllllllllllIIIlllllllIIIII; ++lllllllllllllllllIIIllllllIlllIl) {
                for (int lllllllllllllllllIIIllllllIlllII = -lllllllllllllllllIIIlllllllIIIII; lllllllllllllllllIIIllllllIlllII <= lllllllllllllllllIIIlllllllIIIII; ++lllllllllllllllllIIIllllllIlllII) {
                    for (int lllllllllllllllllIIIllllllIllIll = -1; lllllllllllllllllIIIllllllIllIll <= 1; ++lllllllllllllllllIIIllllllIllIll) {
                        if (lllllllllllllllllIIIlllllllIIlII.getBlockState(lllllllllllllllllIIIlllllllIIIll.add(lllllllllllllllllIIIllllllIlllIl, lllllllllllllllllIIIllllllIllIll, lllllllllllllllllIIIllllllIlllII)).getBlock() == this && --lllllllllllllllllIIIllllllIlllll <= 0) {
                            lllllllllllllllllIIIllllllIllllI = true;
                            break Label_0115;
                        }
                    }
                }
            }
            final EnumFacing lllllllllllllllllIIIllllllIllIlI = EnumFacing.random(lllllllllllllllllIIIllllllIIIIII);
            if (lllllllllllllllllIIIllllllIllIlI == EnumFacing.UP && lllllllllllllllllIIIlllllllIIIll.getY() < 255 && lllllllllllllllllIIIlllllllIIlII.isAirBlock(lllllllllllllllllIIIlllllllIIIll.offsetUp())) {
                if (!lllllllllllllllllIIIllllllIllllI) {
                    IBlockState lllllllllllllllllIIIllllllIlIlll = lllllllllllllllllIIIllllllIIIIIl;
                    for (final EnumFacing lllllllllllllllllIIIllllllIllIIl : EnumFacing.Plane.HORIZONTAL) {
                        if (lllllllllllllllllIIIllllllIIIIII.nextBoolean() || !this.func_150093_a(lllllllllllllllllIIIlllllllIIlII.getBlockState(lllllllllllllllllIIIlllllllIIIll.offset(lllllllllllllllllIIIllllllIllIIl).offsetUp()).getBlock())) {
                            lllllllllllllllllIIIllllllIlIlll = lllllllllllllllllIIIllllllIlIlll.withProperty(func_176267_a(lllllllllllllllllIIIllllllIllIIl), false);
                        }
                    }
                    if ((boolean)lllllllllllllllllIIIllllllIlIlll.getValue(BlockVine.field_176273_b) || (boolean)lllllllllllllllllIIIllllllIlIlll.getValue(BlockVine.field_176278_M) || (boolean)lllllllllllllllllIIIllllllIlIlll.getValue(BlockVine.field_176279_N) || (boolean)lllllllllllllllllIIIllllllIlIlll.getValue(BlockVine.field_176280_O)) {
                        lllllllllllllllllIIIlllllllIIlII.setBlockState(lllllllllllllllllIIIlllllllIIIll.offsetUp(), lllllllllllllllllIIIllllllIlIlll, 2);
                    }
                }
            }
            else if (lllllllllllllllllIIIllllllIllIlI.getAxis().isHorizontal() && !(boolean)lllllllllllllllllIIIllllllIIIIIl.getValue(func_176267_a(lllllllllllllllllIIIllllllIllIlI))) {
                if (!lllllllllllllllllIIIllllllIllllI) {
                    final BlockPos lllllllllllllllllIIIllllllIlIlIl = lllllllllllllllllIIIlllllllIIIll.offset(lllllllllllllllllIIIllllllIllIlI);
                    final Block lllllllllllllllllIIIllllllIlIIll = lllllllllllllllllIIIlllllllIIlII.getBlockState(lllllllllllllllllIIIllllllIlIlIl).getBlock();
                    if (lllllllllllllllllIIIllllllIlIIll.blockMaterial == Material.air) {
                        final EnumFacing lllllllllllllllllIIIllllllIllIII = lllllllllllllllllIIIllllllIllIlI.rotateY();
                        final EnumFacing lllllllllllllllllIIIllllllIlIIlI = lllllllllllllllllIIIllllllIllIlI.rotateYCCW();
                        final boolean lllllllllllllllllIIIllllllIlIIIl = (boolean)lllllllllllllllllIIIllllllIIIIIl.getValue(func_176267_a(lllllllllllllllllIIIllllllIllIII));
                        final boolean lllllllllllllllllIIIllllllIlIIII = (boolean)lllllllllllllllllIIIllllllIIIIIl.getValue(func_176267_a(lllllllllllllllllIIIllllllIlIIlI));
                        final BlockPos lllllllllllllllllIIIllllllIIllll = lllllllllllllllllIIIllllllIlIlIl.offset(lllllllllllllllllIIIllllllIllIII);
                        final BlockPos lllllllllllllllllIIIllllllIIlllI = lllllllllllllllllIIIllllllIlIlIl.offset(lllllllllllllllllIIIllllllIlIIlI);
                        if (lllllllllllllllllIIIllllllIlIIIl && this.func_150093_a(lllllllllllllllllIIIlllllllIIlII.getBlockState(lllllllllllllllllIIIllllllIIllll).getBlock())) {
                            lllllllllllllllllIIIlllllllIIlII.setBlockState(lllllllllllllllllIIIllllllIlIlIl, this.getDefaultState().withProperty(func_176267_a(lllllllllllllllllIIIllllllIllIII), true), 2);
                        }
                        else if (lllllllllllllllllIIIllllllIlIIII && this.func_150093_a(lllllllllllllllllIIIlllllllIIlII.getBlockState(lllllllllllllllllIIIllllllIIlllI).getBlock())) {
                            lllllllllllllllllIIIlllllllIIlII.setBlockState(lllllllllllllllllIIIllllllIlIlIl, this.getDefaultState().withProperty(func_176267_a(lllllllllllllllllIIIllllllIlIIlI), true), 2);
                        }
                        else if (lllllllllllllllllIIIllllllIlIIIl && lllllllllllllllllIIIlllllllIIlII.isAirBlock(lllllllllllllllllIIIllllllIIllll) && this.func_150093_a(lllllllllllllllllIIIlllllllIIlII.getBlockState(lllllllllllllllllIIIlllllllIIIll.offset(lllllllllllllllllIIIllllllIllIII)).getBlock())) {
                            lllllllllllllllllIIIlllllllIIlII.setBlockState(lllllllllllllllllIIIllllllIIllll, this.getDefaultState().withProperty(func_176267_a(lllllllllllllllllIIIllllllIllIlI.getOpposite()), true), 2);
                        }
                        else if (lllllllllllllllllIIIllllllIlIIII && lllllllllllllllllIIIlllllllIIlII.isAirBlock(lllllllllllllllllIIIllllllIIlllI) && this.func_150093_a(lllllllllllllllllIIIlllllllIIlII.getBlockState(lllllllllllllllllIIIlllllllIIIll.offset(lllllllllllllllllIIIllllllIlIIlI)).getBlock())) {
                            lllllllllllllllllIIIlllllllIIlII.setBlockState(lllllllllllllllllIIIllllllIIlllI, this.getDefaultState().withProperty(func_176267_a(lllllllllllllllllIIIllllllIllIlI.getOpposite()), true), 2);
                        }
                        else if (this.func_150093_a(lllllllllllllllllIIIlllllllIIlII.getBlockState(lllllllllllllllllIIIllllllIlIlIl.offsetUp()).getBlock())) {
                            lllllllllllllllllIIIlllllllIIlII.setBlockState(lllllllllllllllllIIIllllllIlIlIl, this.getDefaultState(), 2);
                        }
                    }
                    else if (lllllllllllllllllIIIllllllIlIIll.blockMaterial.isOpaque() && lllllllllllllllllIIIllllllIlIIll.isFullCube()) {
                        lllllllllllllllllIIIlllllllIIlII.setBlockState(lllllllllllllllllIIIlllllllIIIll, lllllllllllllllllIIIllllllIIIIIl.withProperty(func_176267_a(lllllllllllllllllIIIllllllIllIlI), true), 2);
                    }
                }
            }
            else if (lllllllllllllllllIIIlllllllIIIll.getY() > 1) {
                final BlockPos lllllllllllllllllIIIllllllIlIlII = lllllllllllllllllIIIlllllllIIIll.offsetDown();
                final IBlockState lllllllllllllllllIIIllllllIIllIl = lllllllllllllllllIIIlllllllIIlII.getBlockState(lllllllllllllllllIIIllllllIlIlII);
                final Block lllllllllllllllllIIIllllllIIllII = lllllllllllllllllIIIllllllIIllIl.getBlock();
                if (lllllllllllllllllIIIllllllIIllII.blockMaterial == Material.air) {
                    IBlockState lllllllllllllllllIIIllllllIIlIll = lllllllllllllllllIIIllllllIIIIIl;
                    for (final EnumFacing lllllllllllllllllIIIllllllIIIlll : EnumFacing.Plane.HORIZONTAL) {
                        if (lllllllllllllllllIIIllllllIIIIII.nextBoolean()) {
                            lllllllllllllllllIIIllllllIIlIll = lllllllllllllllllIIIllllllIIlIll.withProperty(func_176267_a(lllllllllllllllllIIIllllllIIIlll), false);
                        }
                    }
                    if ((boolean)lllllllllllllllllIIIllllllIIlIll.getValue(BlockVine.field_176273_b) || (boolean)lllllllllllllllllIIIllllllIIlIll.getValue(BlockVine.field_176278_M) || (boolean)lllllllllllllllllIIIllllllIIlIll.getValue(BlockVine.field_176279_N) || (boolean)lllllllllllllllllIIIllllllIIlIll.getValue(BlockVine.field_176280_O)) {
                        lllllllllllllllllIIIlllllllIIlII.setBlockState(lllllllllllllllllIIIllllllIlIlII, lllllllllllllllllIIIllllllIIlIll, 2);
                    }
                }
                else if (lllllllllllllllllIIIllllllIIllII == this) {
                    IBlockState lllllllllllllllllIIIllllllIIlIlI = lllllllllllllllllIIIllllllIIllIl;
                    for (final EnumFacing lllllllllllllllllIIIllllllIIIllI : EnumFacing.Plane.HORIZONTAL) {
                        final PropertyBool lllllllllllllllllIIIllllllIIIlIl = func_176267_a(lllllllllllllllllIIIllllllIIIllI);
                        if (lllllllllllllllllIIIllllllIIIIII.nextBoolean() || !(boolean)lllllllllllllllllIIIllllllIIIIIl.getValue(lllllllllllllllllIIIllllllIIIlIl)) {
                            lllllllllllllllllIIIllllllIIlIlI = lllllllllllllllllIIIllllllIIlIlI.withProperty(lllllllllllllllllIIIllllllIIIlIl, false);
                        }
                    }
                    if ((boolean)lllllllllllllllllIIIllllllIIlIlI.getValue(BlockVine.field_176273_b) || (boolean)lllllllllllllllllIIIllllllIIlIlI.getValue(BlockVine.field_176278_M) || (boolean)lllllllllllllllllIIIllllllIIlIlI.getValue(BlockVine.field_176279_N) || (boolean)lllllllllllllllllIIIllllllIIlIlI.getValue(BlockVine.field_176280_O)) {
                        lllllllllllllllllIIIlllllllIIlII.setBlockState(lllllllllllllllllIIIllllllIlIlII, lllllllllllllllllIIIllllllIIlIlI, 2);
                    }
                }
            }
        }
    }
    
    @Override
    public void onNeighborBlockChange(final World lllllllllllllllllIIIlllllllllllI, final BlockPos lllllllllllllllllIIIllllllllllIl, final IBlockState lllllllllllllllllIIIllllllllllII, final Block lllllllllllllllllIIIlllllllllIll) {
        if (!lllllllllllllllllIIIlllllllllllI.isRemote && !this.func_176269_e(lllllllllllllllllIIIlllllllllllI, lllllllllllllllllIIIllllllllllIl, lllllllllllllllllIIIllllllllllII)) {
            this.dropBlockAsItem(lllllllllllllllllIIIlllllllllllI, lllllllllllllllllIIIllllllllllIl, lllllllllllllllllIIIllllllllllII, 0);
            lllllllllllllllllIIIlllllllllllI.setBlockToAir(lllllllllllllllllIIIllllllllllIl);
        }
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World lllllllllllllllllIIlIIIIIIllllII, final BlockPos lllllllllllllllllIIlIIIIIIlllIll, final IBlockState lllllllllllllllllIIlIIIIIIlllIlI) {
        return null;
    }
    
    private boolean func_176269_e(final World lllllllllllllllllIIlIIIIIIIlIllI, final BlockPos lllllllllllllllllIIlIIIIIIIlIlIl, IBlockState lllllllllllllllllIIlIIIIIIIlIlII) {
        final IBlockState lllllllllllllllllIIlIIIIIIIlllII = (IBlockState)lllllllllllllllllIIlIIIIIIIlIlII;
        for (final EnumFacing lllllllllllllllllIIlIIIIIIIllIlI : EnumFacing.Plane.HORIZONTAL) {
            final PropertyBool lllllllllllllllllIIlIIIIIIIllIIl = func_176267_a(lllllllllllllllllIIlIIIIIIIllIlI);
            if ((boolean)((IBlockState)lllllllllllllllllIIlIIIIIIIlIlII).getValue(lllllllllllllllllIIlIIIIIIIllIIl) && !this.func_150093_a(lllllllllllllllllIIlIIIIIIIlIllI.getBlockState(lllllllllllllllllIIlIIIIIIIlIlIl.offset(lllllllllllllllllIIlIIIIIIIllIlI)).getBlock())) {
                final IBlockState lllllllllllllllllIIlIIIIIIIllIII = lllllllllllllllllIIlIIIIIIIlIllI.getBlockState(lllllllllllllllllIIlIIIIIIIlIlIl.offsetUp());
                if (lllllllllllllllllIIlIIIIIIIllIII.getBlock() == this && (boolean)lllllllllllllllllIIlIIIIIIIllIII.getValue(lllllllllllllllllIIlIIIIIIIllIIl)) {
                    continue;
                }
                lllllllllllllllllIIlIIIIIIIlIlII = ((IBlockState)lllllllllllllllllIIlIIIIIIIlIlII).withProperty(lllllllllllllllllIIlIIIIIIIllIIl, false);
            }
        }
        if (func_176268_d((IBlockState)lllllllllllllllllIIlIIIIIIIlIlII) == 0) {
            return false;
        }
        if (lllllllllllllllllIIlIIIIIIIlllII != lllllllllllllllllIIlIIIIIIIlIlII) {
            lllllllllllllllllIIlIIIIIIIlIllI.setBlockState(lllllllllllllllllIIlIIIIIIIlIlIl, (IBlockState)lllllllllllllllllIIlIIIIIIIlIlII, 2);
        }
        return true;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllllIIIllllIllIlIlI) {
        int lllllllllllllllllIIIllllIllIlIll = 0;
        if (lllllllllllllllllIIIllllIllIlIlI.getValue(BlockVine.field_176273_b)) {
            lllllllllllllllllIIIllllIllIlIll |= BlockVine.field_176276_R;
        }
        if (lllllllllllllllllIIIllllIllIlIlI.getValue(BlockVine.field_176278_M)) {
            lllllllllllllllllIIIllllIllIlIll |= BlockVine.field_176275_S;
        }
        if (lllllllllllllllllIIIllllIllIlIlI.getValue(BlockVine.field_176279_N)) {
            lllllllllllllllllIIIllllIllIlIll |= BlockVine.field_176272_Q;
        }
        if (lllllllllllllllllIIIllllIllIlIlI.getValue(BlockVine.field_176280_O)) {
            lllllllllllllllllIIIllllIllIlIll |= BlockVine.field_176271_T;
        }
        return lllllllllllllllllIIIllllIllIlIll;
    }
    
    @Override
    public int getBlockColor() {
        return ColorizerFoliage.getFoliageColorBasic();
    }
    
    static {
        __OBFID = "CL_00000330";
        field_176277_a = PropertyBool.create("up");
        field_176273_b = PropertyBool.create("north");
        field_176278_M = PropertyBool.create("east");
        field_176279_N = PropertyBool.create("south");
        field_176280_O = PropertyBool.create("west");
        field_176274_P = new PropertyBool[] { BlockVine.field_176277_a, BlockVine.field_176273_b, BlockVine.field_176279_N, BlockVine.field_176280_O, BlockVine.field_176278_M };
        field_176272_Q = func_176270_b(EnumFacing.SOUTH);
        field_176276_R = func_176270_b(EnumFacing.NORTH);
        field_176275_S = func_176270_b(EnumFacing.EAST);
        field_176271_T = func_176270_b(EnumFacing.WEST);
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public void setBlockBoundsForItemRender() {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] field_177057_a;
        
        static {
            __OBFID = "CL_00002049";
            field_177057_a = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.field_177057_a[EnumFacing.UP.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.field_177057_a[EnumFacing.NORTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.field_177057_a[EnumFacing.SOUTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumFacing.field_177057_a[EnumFacing.EAST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                SwitchEnumFacing.field_177057_a[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
        }
    }
}
