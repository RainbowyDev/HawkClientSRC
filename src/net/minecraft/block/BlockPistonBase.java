package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.tileentity.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.block.state.*;

public class BlockPistonBase extends Block
{
    public static final /* synthetic */ PropertyBool EXTENDED;
    public static final /* synthetic */ PropertyDirection FACING;
    private final /* synthetic */ boolean isSticky;
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIllllIIlIlllIIIIl) {
        final byte lllllllllllllllIllllIIlIlllIIIII = 0;
        int lllllllllllllllIllllIIlIllIlllll = lllllllllllllllIllllIIlIlllIIIII | ((EnumFacing)lllllllllllllllIllllIIlIlllIIIIl.getValue(BlockPistonBase.FACING)).getIndex();
        if (lllllllllllllllIllllIIlIlllIIIIl.getValue(BlockPistonBase.EXTENDED)) {
            lllllllllllllllIllllIIlIllIlllll |= 0x8;
        }
        return lllllllllllllllIllllIIlIllIlllll;
    }
    
    @Override
    public boolean onBlockEventReceived(final World lllllllllllllllIllllIIlllIIIlIIl, final BlockPos lllllllllllllllIllllIIlllIIlIllI, final IBlockState lllllllllllllllIllllIIlllIIIIlll, final int lllllllllllllllIllllIIlllIIIIllI, final int lllllllllllllllIllllIIlllIIlIIll) {
        final EnumFacing lllllllllllllllIllllIIlllIIlIIlI = (EnumFacing)lllllllllllllllIllllIIlllIIIIlll.getValue(BlockPistonBase.FACING);
        if (!lllllllllllllllIllllIIlllIIIlIIl.isRemote) {
            final boolean lllllllllllllllIllllIIlllIIlIIIl = this.func_176318_b(lllllllllllllllIllllIIlllIIIlIIl, lllllllllllllllIllllIIlllIIlIllI, lllllllllllllllIllllIIlllIIlIIlI);
            if (lllllllllllllllIllllIIlllIIlIIIl && lllllllllllllllIllllIIlllIIIIllI == 1) {
                lllllllllllllllIllllIIlllIIIlIIl.setBlockState(lllllllllllllllIllllIIlllIIlIllI, lllllllllllllllIllllIIlllIIIIlll.withProperty(BlockPistonBase.EXTENDED, true), 2);
                return false;
            }
            if (!lllllllllllllllIllllIIlllIIlIIIl && lllllllllllllllIllllIIlllIIIIllI == 0) {
                return false;
            }
        }
        if (lllllllllllllllIllllIIlllIIIIllI == 0) {
            if (!this.func_176319_a(lllllllllllllllIllllIIlllIIIlIIl, lllllllllllllllIllllIIlllIIlIllI, lllllllllllllllIllllIIlllIIlIIlI, true)) {
                return false;
            }
            lllllllllllllllIllllIIlllIIIlIIl.setBlockState(lllllllllllllllIllllIIlllIIlIllI, lllllllllllllllIllllIIlllIIIIlll.withProperty(BlockPistonBase.EXTENDED, true), 2);
            lllllllllllllllIllllIIlllIIIlIIl.playSoundEffect(lllllllllllllllIllllIIlllIIlIllI.getX() + 0.5, lllllllllllllllIllllIIlllIIlIllI.getY() + 0.5, lllllllllllllllIllllIIlllIIlIllI.getZ() + 0.5, "tile.piston.out", 0.5f, lllllllllllllllIllllIIlllIIIlIIl.rand.nextFloat() * 0.25f + 0.6f);
        }
        else if (lllllllllllllllIllllIIlllIIIIllI == 1) {
            final TileEntity lllllllllllllllIllllIIlllIIlIIII = lllllllllllllllIllllIIlllIIIlIIl.getTileEntity(lllllllllllllllIllllIIlllIIlIllI.offset(lllllllllllllllIllllIIlllIIlIIlI));
            if (lllllllllllllllIllllIIlllIIlIIII instanceof TileEntityPiston) {
                ((TileEntityPiston)lllllllllllllllIllllIIlllIIlIIII).clearPistonTileEntity();
            }
            lllllllllllllllIllllIIlllIIIlIIl.setBlockState(lllllllllllllllIllllIIlllIIlIllI, Blocks.piston_extension.getDefaultState().withProperty(BlockPistonMoving.field_176426_a, lllllllllllllllIllllIIlllIIlIIlI).withProperty(BlockPistonMoving.field_176425_b, this.isSticky ? BlockPistonExtension.EnumPistonType.STICKY : BlockPistonExtension.EnumPistonType.DEFAULT), 3);
            lllllllllllllllIllllIIlllIIIlIIl.setTileEntity(lllllllllllllllIllllIIlllIIlIllI, BlockPistonMoving.func_176423_a(this.getStateFromMeta(lllllllllllllllIllllIIlllIIlIIll), lllllllllllllllIllllIIlllIIlIIlI, false, true));
            if (this.isSticky) {
                final BlockPos lllllllllllllllIllllIIlllIIIllll = lllllllllllllllIllllIIlllIIlIllI.add(lllllllllllllllIllllIIlllIIlIIlI.getFrontOffsetX() * 2, lllllllllllllllIllllIIlllIIlIIlI.getFrontOffsetY() * 2, lllllllllllllllIllllIIlllIIlIIlI.getFrontOffsetZ() * 2);
                final Block lllllllllllllllIllllIIlllIIIlllI = lllllllllllllllIllllIIlllIIIlIIl.getBlockState(lllllllllllllllIllllIIlllIIIllll).getBlock();
                boolean lllllllllllllllIllllIIlllIIIllIl = false;
                if (lllllllllllllllIllllIIlllIIIlllI == Blocks.piston_extension) {
                    final TileEntity lllllllllllllllIllllIIlllIIIllII = lllllllllllllllIllllIIlllIIIlIIl.getTileEntity(lllllllllllllllIllllIIlllIIIllll);
                    if (lllllllllllllllIllllIIlllIIIllII instanceof TileEntityPiston) {
                        final TileEntityPiston lllllllllllllllIllllIIlllIIIlIll = (TileEntityPiston)lllllllllllllllIllllIIlllIIIllII;
                        if (lllllllllllllllIllllIIlllIIIlIll.func_174930_e() == lllllllllllllllIllllIIlllIIlIIlI && lllllllllllllllIllllIIlllIIIlIll.isExtending()) {
                            lllllllllllllllIllllIIlllIIIlIll.clearPistonTileEntity();
                            lllllllllllllllIllllIIlllIIIllIl = true;
                        }
                    }
                }
                if (!lllllllllllllllIllllIIlllIIIllIl && lllllllllllllllIllllIIlllIIIlllI.getMaterial() != Material.air && func_180696_a(lllllllllllllllIllllIIlllIIIlllI, lllllllllllllllIllllIIlllIIIlIIl, lllllllllllllllIllllIIlllIIIllll, lllllllllllllllIllllIIlllIIlIIlI.getOpposite(), false) && (lllllllllllllllIllllIIlllIIIlllI.getMobilityFlag() == 0 || lllllllllllllllIllllIIlllIIIlllI == Blocks.piston || lllllllllllllllIllllIIlllIIIlllI == Blocks.sticky_piston)) {
                    this.func_176319_a(lllllllllllllllIllllIIlllIIIlIIl, lllllllllllllllIllllIIlllIIlIllI, lllllllllllllllIllllIIlllIIlIIlI, false);
                }
            }
            else {
                lllllllllllllllIllllIIlllIIIlIIl.setBlockToAir(lllllllllllllllIllllIIlllIIlIllI.offset(lllllllllllllllIllllIIlllIIlIIlI));
            }
            lllllllllllllllIllllIIlllIIIlIIl.playSoundEffect(lllllllllllllllIllllIIlllIIlIllI.getX() + 0.5, lllllllllllllllIllllIIlllIIlIllI.getY() + 0.5, lllllllllllllllIllllIIlllIIlIllI.getZ() + 0.5, "tile.piston.in", 0.5f, lllllllllllllllIllllIIlllIIIlIIl.rand.nextFloat() * 0.15f + 0.6f);
        }
        return true;
    }
    
    @Override
    public void onNeighborBlockChange(final World lllllllllllllllIllllIIllllllllII, final BlockPos lllllllllllllllIllllIIlllllllIll, final IBlockState lllllllllllllllIllllIIlllllllIlI, final Block lllllllllllllllIllllIIlllllllIIl) {
        if (!lllllllllllllllIllllIIllllllllII.isRemote) {
            this.func_176316_e(lllllllllllllllIllllIIllllllllII, lllllllllllllllIllllIIlllllllIll, lllllllllllllllIllllIIlllllllIlI);
        }
    }
    
    static {
        __OBFID = "CL_00000366";
        FACING = PropertyDirection.create("facing");
        EXTENDED = PropertyBool.create("extended");
    }
    
    public BlockPistonBase(final boolean lllllllllllllllIllllIlIIIIlIlIII) {
        super(Material.piston);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockPistonBase.FACING, EnumFacing.NORTH).withProperty(BlockPistonBase.EXTENDED, false));
        this.isSticky = lllllllllllllllIllllIlIIIIlIlIII;
        this.setStepSound(BlockPistonBase.soundTypePiston);
        this.setHardness(0.5f);
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIllllIIlIlllIIllI) {
        return this.getDefaultState().withProperty(BlockPistonBase.FACING, func_176317_b(lllllllllllllllIllllIIlIlllIIllI)).withProperty(BlockPistonBase.EXTENDED, (lllllllllllllllIllllIIlIlllIIllI & 0x8) > 0);
    }
    
    @Override
    public void addCollisionBoxesToList(final World lllllllllllllllIllllIIllIllIIIII, final BlockPos lllllllllllllllIllllIIllIlIlllll, final IBlockState lllllllllllllllIllllIIllIlIllllI, final AxisAlignedBB lllllllllllllllIllllIIllIlIlllIl, final List lllllllllllllllIllllIIllIlIlIlIl, final Entity lllllllllllllllIllllIIllIlIllIll) {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        super.addCollisionBoxesToList(lllllllllllllllIllllIIllIllIIIII, lllllllllllllllIllllIIllIlIlllll, lllllllllllllllIllllIIllIlIllllI, lllllllllllllllIllllIIllIlIlllIl, lllllllllllllllIllllIIllIlIlIlIl, lllllllllllllllIllllIIllIlIllIll);
    }
    
    private boolean func_176318_b(final World lllllllllllllllIllllIIlllIlIllll, final BlockPos lllllllllllllllIllllIIlllIlIlllI, final EnumFacing lllllllllllllllIllllIIlllIlIllIl) {
        for (final EnumFacing lllllllllllllllIllllIIlllIllIlII : EnumFacing.values()) {
            if (lllllllllllllllIllllIIlllIllIlII != lllllllllllllllIllllIIlllIlIllIl && lllllllllllllllIllllIIlllIlIllll.func_175709_b(lllllllllllllllIllllIIlllIlIlllI.offset(lllllllllllllllIllllIIlllIllIlII), lllllllllllllllIllllIIlllIllIlII)) {
                return true;
            }
        }
        if (lllllllllllllllIllllIIlllIlIllll.func_175709_b(lllllllllllllllIllllIIlllIlIlllI, EnumFacing.NORTH)) {
            return true;
        }
        final BlockPos lllllllllllllllIllllIIlllIllIIll = lllllllllllllllIllllIIlllIlIlllI.offsetUp();
        for (final EnumFacing lllllllllllllllIllllIIlllIllIIII : EnumFacing.values()) {
            if (lllllllllllllllIllllIIlllIllIIII != EnumFacing.DOWN && lllllllllllllllIllllIIlllIlIllll.func_175709_b(lllllllllllllllIllllIIlllIllIIll.offset(lllllllllllllllIllllIIlllIllIIII), lllllllllllllllIllllIIlllIllIIII)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean func_180696_a(final Block lllllllllllllllIllllIIllIIlIllII, final World lllllllllllllllIllllIIllIIlIlIll, final BlockPos lllllllllllllllIllllIIllIIlIlIlI, final EnumFacing lllllllllllllllIllllIIllIIlIlIIl, final boolean lllllllllllllllIllllIIllIIlIlIII) {
        if (lllllllllllllllIllllIIllIIlIllII == Blocks.obsidian) {
            return false;
        }
        if (!lllllllllllllllIllllIIllIIlIlIll.getWorldBorder().contains(lllllllllllllllIllllIIllIIlIlIlI)) {
            return false;
        }
        if (lllllllllllllllIllllIIllIIlIlIlI.getY() < 0 || (lllllllllllllllIllllIIllIIlIlIIl == EnumFacing.DOWN && lllllllllllllllIllllIIllIIlIlIlI.getY() == 0)) {
            return false;
        }
        if (lllllllllllllllIllllIIllIIlIlIlI.getY() <= lllllllllllllllIllllIIllIIlIlIll.getHeight() - 1 && (lllllllllllllllIllllIIllIIlIlIIl != EnumFacing.UP || lllllllllllllllIllllIIllIIlIlIlI.getY() != lllllllllllllllIllllIIllIIlIlIll.getHeight() - 1)) {
            if (lllllllllllllllIllllIIllIIlIllII != Blocks.piston && lllllllllllllllIllllIIllIIlIllII != Blocks.sticky_piston) {
                if (lllllllllllllllIllllIIllIIlIllII.getBlockHardness(lllllllllllllllIllllIIllIIlIlIll, lllllllllllllllIllllIIllIIlIlIlI) == -1.0f) {
                    return false;
                }
                if (lllllllllllllllIllllIIllIIlIllII.getMobilityFlag() == 2) {
                    return false;
                }
                if (lllllllllllllllIllllIIllIIlIllII.getMobilityFlag() == 1) {
                    return lllllllllllllllIllllIIllIIlIlIII;
                }
            }
            else if (lllllllllllllllIllllIIllIIlIlIll.getBlockState(lllllllllllllllIllllIIllIIlIlIlI).getValue(BlockPistonBase.EXTENDED)) {
                return false;
            }
            return !(lllllllllllllllIllllIIllIIlIllII instanceof ITileEntityProvider);
        }
        return false;
    }
    
    public static EnumFacing func_180695_a(final World lllllllllllllllIllllIIllIIllllIl, final BlockPos lllllllllllllllIllllIIllIIlllIIl, final EntityLivingBase lllllllllllllllIllllIIllIIlllIII) {
        if (MathHelper.abs((float)lllllllllllllllIllllIIllIIlllIII.posX - lllllllllllllllIllllIIllIIlllIIl.getX()) < 2.0f && MathHelper.abs((float)lllllllllllllllIllllIIllIIlllIII.posZ - lllllllllllllllIllllIIllIIlllIIl.getZ()) < 2.0f) {
            final double lllllllllllllllIllllIIllIIlllIlI = lllllllllllllllIllllIIllIIlllIII.posY + lllllllllllllllIllllIIllIIlllIII.getEyeHeight();
            if (lllllllllllllllIllllIIllIIlllIlI - lllllllllllllllIllllIIllIIlllIIl.getY() > 2.0) {
                return EnumFacing.UP;
            }
            if (lllllllllllllllIllllIIllIIlllIIl.getY() - lllllllllllllllIllllIIllIIlllIlI > 0.0) {
                return EnumFacing.DOWN;
            }
        }
        return lllllllllllllllIllllIIllIIlllIII.func_174811_aO().getOpposite();
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess lllllllllllllllIllllIIllIlllIllI, final BlockPos lllllllllllllllIllllIIllIlllIlIl) {
        final IBlockState lllllllllllllllIllllIIllIlllIlII = lllllllllllllllIllllIIllIlllIllI.getBlockState(lllllllllllllllIllllIIllIlllIlIl);
        if (lllllllllllllllIllllIIllIlllIlII.getBlock() == this && (boolean)lllllllllllllllIllllIIllIlllIlII.getValue(BlockPistonBase.EXTENDED)) {
            final float lllllllllllllllIllllIIllIlllIIll = 0.25f;
            final EnumFacing lllllllllllllllIllllIIllIlllIIlI = (EnumFacing)lllllllllllllllIllllIIllIlllIlII.getValue(BlockPistonBase.FACING);
            if (lllllllllllllllIllllIIllIlllIIlI != null) {
                switch (SwitchEnumFacing.field_177243_a[lllllllllllllllIllllIIllIlllIIlI.ordinal()]) {
                    case 1: {
                        this.setBlockBounds(0.0f, 0.25f, 0.0f, 1.0f, 1.0f, 1.0f);
                        break;
                    }
                    case 2: {
                        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.75f, 1.0f);
                        break;
                    }
                    case 3: {
                        this.setBlockBounds(0.0f, 0.0f, 0.25f, 1.0f, 1.0f, 1.0f);
                        break;
                    }
                    case 4: {
                        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.75f);
                        break;
                    }
                    case 5: {
                        this.setBlockBounds(0.25f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                        break;
                    }
                    case 6: {
                        this.setBlockBounds(0.0f, 0.0f, 0.0f, 0.75f, 1.0f, 1.0f);
                        break;
                    }
                }
            }
        }
        else {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
    }
    
    @Override
    public void setBlockBoundsForItemRender() {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllllllIllllIIlllllIllll, final BlockPos lllllllllllllllIllllIIlllllIlIlI, final IBlockState lllllllllllllllIllllIIlllllIlIIl) {
        if (!lllllllllllllllIllllIIlllllIllll.isRemote && lllllllllllllllIllllIIlllllIllll.getTileEntity(lllllllllllllllIllllIIlllllIlIlI) == null) {
            this.func_176316_e(lllllllllllllllIllllIIlllllIllll, lllllllllllllllIllllIIlllllIlIlI, lllllllllllllllIllllIIlllllIlIIl);
        }
    }
    
    @Override
    public IBlockState getStateForEntityRender(final IBlockState lllllllllllllllIllllIIlIlllIllIl) {
        return this.getDefaultState().withProperty(BlockPistonBase.FACING, EnumFacing.UP);
    }
    
    private boolean func_176319_a(final World lllllllllllllllIllllIIlIllllllll, final BlockPos lllllllllllllllIllllIIllIIIlIlII, final EnumFacing lllllllllllllllIllllIIlIllllllIl, final boolean lllllllllllllllIllllIIllIIIlIIlI) {
        if (!lllllllllllllllIllllIIllIIIlIIlI) {
            lllllllllllllllIllllIIlIllllllll.setBlockToAir(lllllllllllllllIllllIIllIIIlIlII.offset(lllllllllllllllIllllIIlIllllllIl));
        }
        final BlockPistonStructureHelper lllllllllllllllIllllIIllIIIlIIIl = new BlockPistonStructureHelper(lllllllllllllllIllllIIlIllllllll, lllllllllllllllIllllIIllIIIlIlII, lllllllllllllllIllllIIlIllllllIl, lllllllllllllllIllllIIllIIIlIIlI);
        final List lllllllllllllllIllllIIllIIIlIIII = lllllllllllllllIllllIIllIIIlIIIl.func_177254_c();
        final List lllllllllllllllIllllIIllIIIIllll = lllllllllllllllIllllIIllIIIlIIIl.func_177252_d();
        if (!lllllllllllllllIllllIIllIIIlIIIl.func_177253_a()) {
            return false;
        }
        int lllllllllllllllIllllIIllIIIIlllI = lllllllllllllllIllllIIllIIIlIIII.size() + lllllllllllllllIllllIIllIIIIllll.size();
        final Block[] lllllllllllllllIllllIIllIIIIllIl = new Block[lllllllllllllllIllllIIllIIIIlllI];
        final EnumFacing lllllllllllllllIllllIIllIIIIllII = lllllllllllllllIllllIIllIIIlIIlI ? lllllllllllllllIllllIIlIllllllIl : lllllllllllllllIllllIIlIllllllIl.getOpposite();
        for (int lllllllllllllllIllllIIllIIIIlIll = lllllllllllllllIllllIIllIIIIllll.size() - 1; lllllllllllllllIllllIIllIIIIlIll >= 0; --lllllllllllllllIllllIIllIIIIlIll) {
            final BlockPos lllllllllllllllIllllIIllIIIIlIlI = lllllllllllllllIllllIIllIIIIllll.get(lllllllllllllllIllllIIllIIIIlIll);
            final Block lllllllllllllllIllllIIllIIIIlIII = lllllllllllllllIllllIIlIllllllll.getBlockState(lllllllllllllllIllllIIllIIIIlIlI).getBlock();
            lllllllllllllllIllllIIllIIIIlIII.dropBlockAsItem(lllllllllllllllIllllIIlIllllllll, lllllllllllllllIllllIIllIIIIlIlI, lllllllllllllllIllllIIlIllllllll.getBlockState(lllllllllllllllIllllIIllIIIIlIlI), 0);
            lllllllllllllllIllllIIlIllllllll.setBlockToAir(lllllllllllllllIllllIIllIIIIlIlI);
            --lllllllllllllllIllllIIllIIIIlllI;
            lllllllllllllllIllllIIllIIIIllIl[lllllllllllllllIllllIIllIIIIlllI] = lllllllllllllllIllllIIllIIIIlIII;
        }
        for (int lllllllllllllllIllllIIllIIIIlIll = lllllllllllllllIllllIIllIIIlIIII.size() - 1; lllllllllllllllIllllIIllIIIIlIll >= 0; --lllllllllllllllIllllIIllIIIIlIll) {
            BlockPos lllllllllllllllIllllIIllIIIIlIIl = lllllllllllllllIllllIIllIIIlIIII.get(lllllllllllllllIllllIIllIIIIlIll);
            final IBlockState lllllllllllllllIllllIIllIIIIIlll = lllllllllllllllIllllIIlIllllllll.getBlockState(lllllllllllllllIllllIIllIIIIlIIl);
            final Block lllllllllllllllIllllIIllIIIIIlIl = lllllllllllllllIllllIIllIIIIIlll.getBlock();
            lllllllllllllllIllllIIllIIIIIlIl.getMetaFromState(lllllllllllllllIllllIIllIIIIIlll);
            lllllllllllllllIllllIIlIllllllll.setBlockToAir(lllllllllllllllIllllIIllIIIIlIIl);
            lllllllllllllllIllllIIllIIIIlIIl = lllllllllllllllIllllIIllIIIIlIIl.offset(lllllllllllllllIllllIIllIIIIllII);
            lllllllllllllllIllllIIlIllllllll.setBlockState(lllllllllllllllIllllIIllIIIIlIIl, Blocks.piston_extension.getDefaultState().withProperty(BlockPistonBase.FACING, lllllllllllllllIllllIIlIllllllIl), 4);
            lllllllllllllllIllllIIlIllllllll.setTileEntity(lllllllllllllllIllllIIllIIIIlIIl, BlockPistonMoving.func_176423_a(lllllllllllllllIllllIIllIIIIIlll, lllllllllllllllIllllIIlIllllllIl, lllllllllllllllIllllIIllIIIlIIlI, false));
            --lllllllllllllllIllllIIllIIIIlllI;
            lllllllllllllllIllllIIllIIIIllIl[lllllllllllllllIllllIIllIIIIlllI] = lllllllllllllllIllllIIllIIIIIlIl;
        }
        final BlockPos lllllllllllllllIllllIIllIIIIIlII = lllllllllllllllIllllIIllIIIlIlII.offset(lllllllllllllllIllllIIlIllllllIl);
        if (lllllllllllllllIllllIIllIIIlIIlI) {
            final BlockPistonExtension.EnumPistonType lllllllllllllllIllllIIllIIIIIIll = this.isSticky ? BlockPistonExtension.EnumPistonType.STICKY : BlockPistonExtension.EnumPistonType.DEFAULT;
            final IBlockState lllllllllllllllIllllIIllIIIIIllI = Blocks.piston_head.getDefaultState().withProperty(BlockPistonExtension.field_176326_a, lllllllllllllllIllllIIlIllllllIl).withProperty(BlockPistonExtension.field_176325_b, lllllllllllllllIllllIIllIIIIIIll);
            final IBlockState lllllllllllllllIllllIIllIIIIIIlI = Blocks.piston_extension.getDefaultState().withProperty(BlockPistonMoving.field_176426_a, lllllllllllllllIllllIIlIllllllIl).withProperty(BlockPistonMoving.field_176425_b, this.isSticky ? BlockPistonExtension.EnumPistonType.STICKY : BlockPistonExtension.EnumPistonType.DEFAULT);
            lllllllllllllllIllllIIlIllllllll.setBlockState(lllllllllllllllIllllIIllIIIIIlII, lllllllllllllllIllllIIllIIIIIIlI, 4);
            lllllllllllllllIllllIIlIllllllll.setTileEntity(lllllllllllllllIllllIIllIIIIIlII, BlockPistonMoving.func_176423_a(lllllllllllllllIllllIIllIIIIIllI, lllllllllllllllIllllIIlIllllllIl, true, false));
        }
        for (int lllllllllllllllIllllIIllIIIIIIIl = lllllllllllllllIllllIIllIIIIllll.size() - 1; lllllllllllllllIllllIIllIIIIIIIl >= 0; --lllllllllllllllIllllIIllIIIIIIIl) {
            lllllllllllllllIllllIIlIllllllll.notifyNeighborsOfStateChange(lllllllllllllllIllllIIllIIIIllll.get(lllllllllllllllIllllIIllIIIIIIIl), lllllllllllllllIllllIIllIIIIllIl[lllllllllllllllIllllIIllIIIIlllI++]);
        }
        for (int lllllllllllllllIllllIIllIIIIIIIl = lllllllllllllllIllllIIllIIIlIIII.size() - 1; lllllllllllllllIllllIIllIIIIIIIl >= 0; --lllllllllllllllIllllIIllIIIIIIIl) {
            lllllllllllllllIllllIIlIllllllll.notifyNeighborsOfStateChange(lllllllllllllllIllllIIllIIIlIIII.get(lllllllllllllllIllllIIllIIIIIIIl), lllllllllllllllIllllIIllIIIIllIl[lllllllllllllllIllllIIllIIIIlllI++]);
        }
        if (lllllllllllllllIllllIIllIIIlIIlI) {
            lllllllllllllllIllllIIlIllllllll.notifyNeighborsOfStateChange(lllllllllllllllIllllIIllIIIIIlII, Blocks.piston_head);
            lllllllllllllllIllllIIlIllllllll.notifyNeighborsOfStateChange(lllllllllllllllIllllIIllIIIlIlII, this);
        }
        return true;
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllllIllllIIlllllIIIll, final BlockPos lllllllllllllllIllllIIlllllIIIlI, final EnumFacing lllllllllllllllIllllIIlllllIIIIl, final float lllllllllllllllIllllIIlllllIIIII, final float lllllllllllllllIllllIIllllIlllll, final float lllllllllllllllIllllIIllllIllllI, final int lllllllllllllllIllllIIllllIlllIl, final EntityLivingBase lllllllllllllllIllllIIllllIlllII) {
        return this.getDefaultState().withProperty(BlockPistonBase.FACING, func_180695_a(lllllllllllllllIllllIIlllllIIIll, lllllllllllllllIllllIIlllllIIIlI, lllllllllllllllIllllIIllllIlllII)).withProperty(BlockPistonBase.EXTENDED, false);
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    private void func_176316_e(final World lllllllllllllllIllllIIllllIlIIII, final BlockPos lllllllllllllllIllllIIllllIIlIIl, final IBlockState lllllllllllllllIllllIIllllIIlIII) {
        final EnumFacing lllllllllllllllIllllIIllllIIllIl = (EnumFacing)lllllllllllllllIllllIIllllIIlIII.getValue(BlockPistonBase.FACING);
        final boolean lllllllllllllllIllllIIllllIIllII = this.func_176318_b(lllllllllllllllIllllIIllllIlIIII, lllllllllllllllIllllIIllllIIlIIl, lllllllllllllllIllllIIllllIIllIl);
        if (lllllllllllllllIllllIIllllIIllII && !(boolean)lllllllllllllllIllllIIllllIIlIII.getValue(BlockPistonBase.EXTENDED)) {
            if (new BlockPistonStructureHelper(lllllllllllllllIllllIIllllIlIIII, lllllllllllllllIllllIIllllIIlIIl, lllllllllllllllIllllIIllllIIllIl, true).func_177253_a()) {
                lllllllllllllllIllllIIllllIlIIII.addBlockEvent(lllllllllllllllIllllIIllllIIlIIl, this, 0, lllllllllllllllIllllIIllllIIllIl.getIndex());
            }
        }
        else if (!lllllllllllllllIllllIIllllIIllII && (boolean)lllllllllllllllIllllIIllllIIlIII.getValue(BlockPistonBase.EXTENDED)) {
            lllllllllllllllIllllIIllllIlIIII.setBlockState(lllllllllllllllIllllIIllllIIlIIl, lllllllllllllllIllllIIllllIIlIII.withProperty(BlockPistonBase.EXTENDED, false), 2);
            lllllllllllllllIllllIIllllIlIIII.addBlockEvent(lllllllllllllllIllllIIllllIIlIIl, this, 1, lllllllllllllllIllllIIllllIIllIl.getIndex());
        }
    }
    
    public static EnumFacing func_176317_b(final int lllllllllllllllIllllIIllIlIIIlII) {
        final int lllllllllllllllIllllIIllIlIIIIll = lllllllllllllllIllllIIllIlIIIlII & 0x7;
        return (lllllllllllllllIllllIIllIlIIIIll > 5) ? null : EnumFacing.getFront(lllllllllllllllIllllIIllIlIIIIll);
    }
    
    @Override
    public void onBlockPlacedBy(final World lllllllllllllllIllllIlIIIIIlIllI, final BlockPos lllllllllllllllIllllIlIIIIIIllIl, final IBlockState lllllllllllllllIllllIlIIIIIlIlII, final EntityLivingBase lllllllllllllllIllllIlIIIIIIlIlI, final ItemStack lllllllllllllllIllllIlIIIIIlIIlI) {
        lllllllllllllllIllllIlIIIIIlIllI.setBlockState(lllllllllllllllIllllIlIIIIIIllIl, lllllllllllllllIllllIlIIIIIlIlII.withProperty(BlockPistonBase.FACING, func_180695_a(lllllllllllllllIllllIlIIIIIlIllI, lllllllllllllllIllllIlIIIIIIllIl, lllllllllllllllIllllIlIIIIIIlIlI)), 2);
        if (!lllllllllllllllIllllIlIIIIIlIllI.isRemote) {
            this.func_176316_e(lllllllllllllllIllllIlIIIIIlIllI, lllllllllllllllIllllIlIIIIIIllIl, lllllllllllllllIllllIlIIIIIlIlII);
        }
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockPistonBase.FACING, BlockPistonBase.EXTENDED });
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World lllllllllllllllIllllIIllIlIIlllI, final BlockPos lllllllllllllllIllllIIllIlIIlIIl, final IBlockState lllllllllllllllIllllIIllIlIIlIII) {
        this.setBlockBoundsBasedOnState(lllllllllllllllIllllIIllIlIIlllI, lllllllllllllllIllllIIllIlIIlIIl);
        return super.getCollisionBoundingBox(lllllllllllllllIllllIIllIlIIlllI, lllllllllllllllIllllIIllIlIIlIIl, lllllllllllllllIllllIIllIlIIlIII);
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] field_177243_a;
        
        static {
            __OBFID = "CL_00002037";
            field_177243_a = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.field_177243_a[EnumFacing.DOWN.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.field_177243_a[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.field_177243_a[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumFacing.field_177243_a[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                SwitchEnumFacing.field_177243_a[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                SwitchEnumFacing.field_177243_a[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
        }
    }
}
