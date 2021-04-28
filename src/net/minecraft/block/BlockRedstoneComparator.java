package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.item.*;
import com.google.common.base.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;

public class BlockRedstoneComparator extends BlockRedstoneDiode implements ITileEntityProvider
{
    public static final /* synthetic */ PropertyBool field_176464_a;
    public static final /* synthetic */ PropertyEnum field_176463_b;
    
    @Override
    protected IBlockState func_180674_e(final IBlockState llllllllllllllllllIllllllllIlIlI) {
        final Boolean llllllllllllllllllIllllllllIllIl = (Boolean)llllllllllllllllllIllllllllIlIlI.getValue(BlockRedstoneComparator.field_176464_a);
        final Mode llllllllllllllllllIllllllllIllII = (Mode)llllllllllllllllllIllllllllIlIlI.getValue(BlockRedstoneComparator.field_176463_b);
        final EnumFacing llllllllllllllllllIllllllllIlIll = (EnumFacing)llllllllllllllllllIllllllllIlIlI.getValue(BlockRedstoneComparator.AGE);
        return Blocks.powered_comparator.getDefaultState().withProperty(BlockRedstoneComparator.AGE, llllllllllllllllllIllllllllIlIll).withProperty(BlockRedstoneComparator.field_176464_a, llllllllllllllllllIllllllllIllIl).withProperty(BlockRedstoneComparator.field_176463_b, llllllllllllllllllIllllllllIllII);
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllllllIllllllllllIll, final Random llllllllllllllllllIllllllllllIlI, final int llllllllllllllllllIllllllllllIIl) {
        return Items.comparator;
    }
    
    static {
        __OBFID = "CL_00000220";
        field_176464_a = PropertyBool.create("powered");
        field_176463_b = PropertyEnum.create("mode", Mode.class);
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllllllllIlllllIIlIIllI, final BlockPos llllllllllllllllllIlllllIIlIlIIl, final IBlockState llllllllllllllllllIlllllIIlIlIII) {
        super.onBlockAdded(llllllllllllllllllIlllllIIlIIllI, llllllllllllllllllIlllllIIlIlIIl, llllllllllllllllllIlllllIIlIlIII);
        llllllllllllllllllIlllllIIlIIllI.setTileEntity(llllllllllllllllllIlllllIIlIlIIl, this.createNewTileEntity(llllllllllllllllllIlllllIIlIIllI, 0));
    }
    
    @Override
    public void breakBlock(final World llllllllllllllllllIlllllIIIllllI, final BlockPos llllllllllllllllllIlllllIIIllIIl, final IBlockState llllllllllllllllllIlllllIIIlllII) {
        super.breakBlock(llllllllllllllllllIlllllIIIllllI, llllllllllllllllllIlllllIIIllIIl, llllllllllllllllllIlllllIIIlllII);
        llllllllllllllllllIlllllIIIllllI.removeTileEntity(llllllllllllllllllIlllllIIIllIIl);
        this.func_176400_h(llllllllllllllllllIlllllIIIllllI, llllllllllllllllllIlllllIIIllIIl, llllllllllllllllllIlllllIIIlllII);
    }
    
    @Override
    public boolean onBlockEventReceived(final World llllllllllllllllllIlllllIIIIllll, final BlockPos llllllllllllllllllIlllllIIIIIlll, final IBlockState llllllllllllllllllIlllllIIIIIllI, final int llllllllllllllllllIlllllIIIIllII, final int llllllllllllllllllIlllllIIIIlIll) {
        super.onBlockEventReceived(llllllllllllllllllIlllllIIIIllll, llllllllllllllllllIlllllIIIIIlll, llllllllllllllllllIlllllIIIIIllI, llllllllllllllllllIlllllIIIIllII, llllllllllllllllllIlllllIIIIlIll);
        final TileEntity llllllllllllllllllIlllllIIIIlIlI = llllllllllllllllllIlllllIIIIllll.getTileEntity(llllllllllllllllllIlllllIIIIIlll);
        return llllllllllllllllllIlllllIIIIlIlI != null && llllllllllllllllllIlllllIIIIlIlI.receiveClientEvent(llllllllllllllllllIlllllIIIIllII, llllllllllllllllllIlllllIIIIlIll);
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllllllllIlllllIIIIIIIl, final int llllllllllllllllllIlllllIIIIIIII) {
        return new TileEntityComparator();
    }
    
    @Override
    protected boolean func_176406_l(final IBlockState llllllllllllllllllIlllllllIlIllI) {
        return this.isRepeaterPowered || (boolean)llllllllllllllllllIlllllllIlIllI.getValue(BlockRedstoneComparator.field_176464_a);
    }
    
    @Override
    protected int func_176397_f(final World llllllllllllllllllIllllllIIlIlll, final BlockPos llllllllllllllllllIllllllIIlllll, final IBlockState llllllllllllllllllIllllllIIlIlIl) {
        int llllllllllllllllllIllllllIIlllIl = super.func_176397_f(llllllllllllllllllIllllllIIlIlll, llllllllllllllllllIllllllIIlllll, llllllllllllllllllIllllllIIlIlIl);
        final EnumFacing llllllllllllllllllIllllllIIlllII = (EnumFacing)llllllllllllllllllIllllllIIlIlIl.getValue(BlockRedstoneComparator.AGE);
        BlockPos llllllllllllllllllIllllllIIllIll = llllllllllllllllllIllllllIIlllll.offset(llllllllllllllllllIllllllIIlllII);
        Block llllllllllllllllllIllllllIIllIlI = llllllllllllllllllIllllllIIlIlll.getBlockState(llllllllllllllllllIllllllIIllIll).getBlock();
        if (llllllllllllllllllIllllllIIllIlI.hasComparatorInputOverride()) {
            llllllllllllllllllIllllllIIlllIl = llllllllllllllllllIllllllIIllIlI.getComparatorInputOverride(llllllllllllllllllIllllllIIlIlll, llllllllllllllllllIllllllIIllIll);
        }
        else if (llllllllllllllllllIllllllIIlllIl < 15 && llllllllllllllllllIllllllIIllIlI.isNormalCube()) {
            llllllllllllllllllIllllllIIllIll = llllllllllllllllllIllllllIIllIll.offset(llllllllllllllllllIllllllIIlllII);
            llllllllllllllllllIllllllIIllIlI = llllllllllllllllllIllllllIIlIlll.getBlockState(llllllllllllllllllIllllllIIllIll).getBlock();
            if (llllllllllllllllllIllllllIIllIlI.hasComparatorInputOverride()) {
                llllllllllllllllllIllllllIIlllIl = llllllllllllllllllIllllllIIllIlI.getComparatorInputOverride(llllllllllllllllllIllllllIIlIlll, llllllllllllllllllIllllllIIllIll);
            }
            else if (llllllllllllllllllIllllllIIllIlI.getMaterial() == Material.air) {
                final EntityItemFrame llllllllllllllllllIllllllIIllIIl = this.func_176461_a(llllllllllllllllllIllllllIIlIlll, llllllllllllllllllIllllllIIlllII, llllllllllllllllllIllllllIIllIll);
                if (llllllllllllllllllIllllllIIllIIl != null) {
                    llllllllllllllllllIllllllIIlllIl = llllllllllllllllllIllllllIIllIIl.func_174866_q();
                }
            }
        }
        return llllllllllllllllllIllllllIIlllIl;
    }
    
    private EntityItemFrame func_176461_a(final World llllllllllllllllllIllllllIIIIlII, final EnumFacing llllllllllllllllllIllllllIIIlIII, final BlockPos llllllllllllllllllIllllllIIIIIlI) {
        final List llllllllllllllllllIllllllIIIIllI = llllllllllllllllllIllllllIIIIlII.func_175647_a(EntityItemFrame.class, new AxisAlignedBB(llllllllllllllllllIllllllIIIIIlI.getX(), llllllllllllllllllIllllllIIIIIlI.getY(), llllllllllllllllllIllllllIIIIIlI.getZ(), llllllllllllllllllIllllllIIIIIlI.getX() + 1, llllllllllllllllllIllllllIIIIIlI.getY() + 1, llllllllllllllllllIllllllIIIIIlI.getZ() + 1), (Predicate)new Predicate() {
            public boolean func_180416_a(final Entity lllllllllllllllIllIllIlIIIlllIII) {
                return lllllllllllllllIllIllIlIIIlllIII != null && lllllllllllllllIllIllIlIIIlllIII.func_174811_aO() == llllllllllllllllllIllllllIIIlIII;
            }
            
            public boolean apply(final Object lllllllllllllllIllIllIlIIIllIIlI) {
                return this.func_180416_a((Entity)lllllllllllllllIllIllIlIIIllIIlI);
            }
            
            static {
                __OBFID = "CL_00002129";
            }
        });
        return (llllllllllllllllllIllllllIIIIllI.size() == 1) ? llllllllllllllllllIllllllIIIIllI.get(0) : null;
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllllllllIllllIlllIlIIl, final BlockPos llllllllllllllllllIllllIlllIlIII, final EnumFacing llllllllllllllllllIllllIlllIIlll, final float llllllllllllllllllIllllIlllIIllI, final float llllllllllllllllllIllllIlllIIlIl, final float llllllllllllllllllIllllIlllIIlII, final int llllllllllllllllllIllllIlllIIIll, final EntityLivingBase llllllllllllllllllIllllIlllIIIII) {
        return this.getDefaultState().withProperty(BlockRedstoneComparator.AGE, llllllllllllllllllIllllIlllIIIII.func_174811_aO().getOpposite()).withProperty(BlockRedstoneComparator.field_176464_a, false).withProperty(BlockRedstoneComparator.field_176463_b, Mode.COMPARE);
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllllllllIlllllIlllIIIl, final BlockPos llllllllllllllllllIlllllIlllIIII, IBlockState llllllllllllllllllIlllllIllIllll, final EntityPlayer llllllllllllllllllIlllllIllIlllI, final EnumFacing llllllllllllllllllIlllllIlllIllI, final float llllllllllllllllllIlllllIlllIlIl, final float llllllllllllllllllIlllllIlllIlII, final float llllllllllllllllllIlllllIlllIIll) {
        if (!llllllllllllllllllIlllllIllIlllI.capabilities.allowEdit) {
            return false;
        }
        llllllllllllllllllIlllllIllIllll = llllllllllllllllllIlllllIllIllll.cycleProperty(BlockRedstoneComparator.field_176463_b);
        llllllllllllllllllIlllllIlllIIIl.playSoundEffect(llllllllllllllllllIlllllIlllIIII.getX() + 0.5, llllllllllllllllllIlllllIlllIIII.getY() + 0.5, llllllllllllllllllIlllllIlllIIII.getZ() + 0.5, "random.click", 0.3f, (llllllllllllllllllIlllllIllIllll.getValue(BlockRedstoneComparator.field_176463_b) == Mode.SUBTRACT) ? 0.55f : 0.5f);
        llllllllllllllllllIlllllIlllIIIl.setBlockState(llllllllllllllllllIlllllIlllIIII, llllllllllllllllllIlllllIllIllll, 2);
        this.func_176462_k(llllllllllllllllllIlllllIlllIIIl, llllllllllllllllllIlllllIlllIIII, llllllllllllllllllIlllllIllIllll);
        return true;
    }
    
    @Override
    protected boolean func_176404_e(final World llllllllllllllllllIllllllIlIllll, final BlockPos llllllllllllllllllIllllllIllIlII, final IBlockState llllllllllllllllllIllllllIllIIll) {
        final int llllllllllllllllllIllllllIllIIlI = this.func_176397_f(llllllllllllllllllIllllllIlIllll, llllllllllllllllllIllllllIllIlII, llllllllllllllllllIllllllIllIIll);
        if (llllllllllllllllllIllllllIllIIlI >= 15) {
            return true;
        }
        if (llllllllllllllllllIllllllIllIIlI == 0) {
            return false;
        }
        final int llllllllllllllllllIllllllIllIIIl = this.func_176407_c(llllllllllllllllllIllllllIlIllll, llllllllllllllllllIllllllIllIlII, llllllllllllllllllIllllllIllIIll);
        return llllllllllllllllllIllllllIllIIIl == 0 || llllllllllllllllllIllllllIllIIlI >= llllllllllllllllllIllllllIllIIIl;
    }
    
    @Override
    protected void func_176398_g(final World llllllllllllllllllIlllllIllIIlIl, final BlockPos llllllllllllllllllIlllllIllIIlII, final IBlockState llllllllllllllllllIlllllIllIIIll) {
        if (!llllllllllllllllllIlllllIllIIlIl.isBlockTickPending(llllllllllllllllllIlllllIllIIlII, this)) {
            final int llllllllllllllllllIlllllIllIIIlI = this.func_176460_j(llllllllllllllllllIlllllIllIIlIl, llllllllllllllllllIlllllIllIIlII, llllllllllllllllllIlllllIllIIIll);
            final TileEntity llllllllllllllllllIlllllIllIIIIl = llllllllllllllllllIlllllIllIIlIl.getTileEntity(llllllllllllllllllIlllllIllIIlII);
            final int llllllllllllllllllIlllllIllIIIII = (llllllllllllllllllIlllllIllIIIIl instanceof TileEntityComparator) ? ((TileEntityComparator)llllllllllllllllllIlllllIllIIIIl).getOutputSignal() : 0;
            if (llllllllllllllllllIlllllIllIIIlI != llllllllllllllllllIlllllIllIIIII || this.func_176406_l(llllllllllllllllllIlllllIllIIIll) != this.func_176404_e(llllllllllllllllllIlllllIllIIlIl, llllllllllllllllllIlllllIllIIlII, llllllllllllllllllIlllllIllIIIll)) {
                if (this.func_176402_i(llllllllllllllllllIlllllIllIIlIl, llllllllllllllllllIlllllIllIIlII, llllllllllllllllllIlllllIllIIIll)) {
                    llllllllllllllllllIlllllIllIIlIl.func_175654_a(llllllllllllllllllIlllllIllIIlII, this, 2, -1);
                }
                else {
                    llllllllllllllllllIlllllIllIIlIl.func_175654_a(llllllllllllllllllIlllllIllIIlII, this, 2, 0);
                }
            }
        }
    }
    
    @Override
    protected int func_176408_a(final IBlockAccess llllllllllllllllllIlllllllIIlIll, final BlockPos llllllllllllllllllIlllllllIIlllI, final IBlockState llllllllllllllllllIlllllllIIllIl) {
        final TileEntity llllllllllllllllllIlllllllIIllII = llllllllllllllllllIlllllllIIlIll.getTileEntity(llllllllllllllllllIlllllllIIlllI);
        return (llllllllllllllllllIlllllllIIllII instanceof TileEntityComparator) ? ((TileEntityComparator)llllllllllllllllllIlllllllIIllII).getOutputSignal() : 0;
    }
    
    private int func_176460_j(final World llllllllllllllllllIlllllllIIIIll, final BlockPos llllllllllllllllllIllllllIlllllI, final IBlockState llllllllllllllllllIllllllIllllIl) {
        return (llllllllllllllllllIllllllIllllIl.getValue(BlockRedstoneComparator.field_176463_b) == Mode.SUBTRACT) ? Math.max(this.func_176397_f(llllllllllllllllllIlllllllIIIIll, llllllllllllllllllIllllllIlllllI, llllllllllllllllllIllllllIllllIl) - this.func_176407_c(llllllllllllllllllIlllllllIIIIll, llllllllllllllllllIllllllIlllllI, llllllllllllllllllIllllllIllllIl), 0) : this.func_176397_f(llllllllllllllllllIlllllllIIIIll, llllllllllllllllllIllllllIlllllI, llllllllllllllllllIllllllIllllIl);
    }
    
    @Override
    protected int func_176403_d(final IBlockState llllllllllllllllllIlllllllllIlII) {
        return 2;
    }
    
    @Override
    public Item getItem(final World llllllllllllllllllIlllllllllIlll, final BlockPos llllllllllllllllllIlllllllllIllI) {
        return Items.comparator;
    }
    
    public BlockRedstoneComparator(final boolean llllllllllllllllllIlllllllllllIl) {
        super(llllllllllllllllllIlllllllllllIl);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockRedstoneComparator.AGE, EnumFacing.NORTH).withProperty(BlockRedstoneComparator.field_176464_a, false).withProperty(BlockRedstoneComparator.field_176463_b, Mode.COMPARE));
        this.isBlockContainer = true;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllllllIllllIllllllII) {
        return this.getDefaultState().withProperty(BlockRedstoneComparator.AGE, EnumFacing.getHorizontal(llllllllllllllllllIllllIllllllII)).withProperty(BlockRedstoneComparator.field_176464_a, (llllllllllllllllllIllllIllllllII & 0x8) > 0).withProperty(BlockRedstoneComparator.field_176463_b, ((llllllllllllllllllIllllIllllllII & 0x4) > 0) ? Mode.SUBTRACT : Mode.COMPARE);
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockRedstoneComparator.AGE, BlockRedstoneComparator.field_176463_b, BlockRedstoneComparator.field_176464_a });
    }
    
    @Override
    public void updateTick(final World llllllllllllllllllIlllllIIllIIlI, final BlockPos llllllllllllllllllIlllllIIllIllI, final IBlockState llllllllllllllllllIlllllIIllIlIl, final Random llllllllllllllllllIlllllIIllIlII) {
        if (this.isRepeaterPowered) {
            llllllllllllllllllIlllllIIllIIlI.setBlockState(llllllllllllllllllIlllllIIllIllI, this.func_180675_k(llllllllllllllllllIlllllIIllIlIl).withProperty(BlockRedstoneComparator.field_176464_a, true), 4);
        }
        this.func_176462_k(llllllllllllllllllIlllllIIllIIlI, llllllllllllllllllIlllllIIllIllI, llllllllllllllllllIlllllIIllIlIl);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllllllIllllIllllIIlI) {
        final byte llllllllllllllllllIllllIllllIlII = 0;
        int llllllllllllllllllIllllIllllIIll = llllllllllllllllllIllllIllllIlII | ((EnumFacing)llllllllllllllllllIllllIllllIIlI.getValue(BlockRedstoneComparator.AGE)).getHorizontalIndex();
        if (llllllllllllllllllIllllIllllIIlI.getValue(BlockRedstoneComparator.field_176464_a)) {
            llllllllllllllllllIllllIllllIIll |= 0x8;
        }
        if (llllllllllllllllllIllllIllllIIlI.getValue(BlockRedstoneComparator.field_176463_b) == Mode.SUBTRACT) {
            llllllllllllllllllIllllIllllIIll |= 0x4;
        }
        return llllllllllllllllllIllllIllllIIll;
    }
    
    private void func_176462_k(final World llllllllllllllllllIlllllIlIIlllI, final BlockPos llllllllllllllllllIlllllIlIIIIll, final IBlockState llllllllllllllllllIlllllIlIIllII) {
        final int llllllllllllllllllIlllllIlIIlIll = this.func_176460_j(llllllllllllllllllIlllllIlIIlllI, llllllllllllllllllIlllllIlIIIIll, llllllllllllllllllIlllllIlIIllII);
        final TileEntity llllllllllllllllllIlllllIlIIlIlI = llllllllllllllllllIlllllIlIIlllI.getTileEntity(llllllllllllllllllIlllllIlIIIIll);
        int llllllllllllllllllIlllllIlIIlIIl = 0;
        if (llllllllllllllllllIlllllIlIIlIlI instanceof TileEntityComparator) {
            final TileEntityComparator llllllllllllllllllIlllllIlIIlIII = (TileEntityComparator)llllllllllllllllllIlllllIlIIlIlI;
            llllllllllllllllllIlllllIlIIlIIl = llllllllllllllllllIlllllIlIIlIII.getOutputSignal();
            llllllllllllllllllIlllllIlIIlIII.setOutputSignal(llllllllllllllllllIlllllIlIIlIll);
        }
        if (llllllllllllllllllIlllllIlIIlIIl != llllllllllllllllllIlllllIlIIlIll || llllllllllllllllllIlllllIlIIllII.getValue(BlockRedstoneComparator.field_176463_b) == Mode.COMPARE) {
            final boolean llllllllllllllllllIlllllIlIIIlll = this.func_176404_e(llllllllllllllllllIlllllIlIIlllI, llllllllllllllllllIlllllIlIIIIll, llllllllllllllllllIlllllIlIIllII);
            final boolean llllllllllllllllllIlllllIlIIIllI = this.func_176406_l(llllllllllllllllllIlllllIlIIllII);
            if (llllllllllllllllllIlllllIlIIIllI && !llllllllllllllllllIlllllIlIIIlll) {
                llllllllllllllllllIlllllIlIIlllI.setBlockState(llllllllllllllllllIlllllIlIIIIll, llllllllllllllllllIlllllIlIIllII.withProperty(BlockRedstoneComparator.field_176464_a, false), 2);
            }
            else if (!llllllllllllllllllIlllllIlIIIllI && llllllllllllllllllIlllllIlIIIlll) {
                llllllllllllllllllIlllllIlIIlllI.setBlockState(llllllllllllllllllIlllllIlIIIIll, llllllllllllllllllIlllllIlIIllII.withProperty(BlockRedstoneComparator.field_176464_a, true), 2);
            }
            this.func_176400_h(llllllllllllllllllIlllllIlIIlllI, llllllllllllllllllIlllllIlIIIIll, llllllllllllllllllIlllllIlIIllII);
        }
    }
    
    @Override
    protected IBlockState func_180675_k(final IBlockState llllllllllllllllllIlllllllIlllIl) {
        final Boolean llllllllllllllllllIllllllllIIIII = (Boolean)llllllllllllllllllIlllllllIlllIl.getValue(BlockRedstoneComparator.field_176464_a);
        final Mode llllllllllllllllllIlllllllIlllll = (Mode)llllllllllllllllllIlllllllIlllIl.getValue(BlockRedstoneComparator.field_176463_b);
        final EnumFacing llllllllllllllllllIlllllllIllllI = (EnumFacing)llllllllllllllllllIlllllllIlllIl.getValue(BlockRedstoneComparator.AGE);
        return Blocks.unpowered_comparator.getDefaultState().withProperty(BlockRedstoneComparator.AGE, llllllllllllllllllIlllllllIllllI).withProperty(BlockRedstoneComparator.field_176464_a, llllllllllllllllllIllllllllIIIII).withProperty(BlockRedstoneComparator.field_176463_b, llllllllllllllllllIlllllllIlllll);
    }
    
    public enum Mode implements IStringSerializable
    {
        SUBTRACT("SUBTRACT", 1, "SUBTRACT", 1, "subtract");
        
        private final /* synthetic */ String field_177041_c;
        
        COMPARE("COMPARE", 0, "COMPARE", 0, "compare");
        
        @Override
        public String getName() {
            return this.field_177041_c;
        }
        
        static {
            __OBFID = "CL_00002128";
        }
        
        private Mode(final String lIllIIlIIlI, final int lIllIIlIIIl, final String lIllIIlIllI, final int lIllIIlIlIl, final String lIllIIlIIII) {
            this.field_177041_c = lIllIIlIIII;
        }
        
        @Override
        public String toString() {
            return this.field_177041_c;
        }
    }
}
