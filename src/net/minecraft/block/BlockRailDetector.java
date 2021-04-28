package net.minecraft.block;

import com.google.common.base.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.item.*;
import net.minecraft.command.*;
import net.minecraft.inventory.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.*;

public class BlockRailDetector extends BlockRailBase
{
    public static final /* synthetic */ PropertyBool field_176574_M;
    public static final /* synthetic */ PropertyEnum field_176573_b;
    
    static {
        __OBFID = "CL_00000225";
        field_176573_b = PropertyEnum.create("shape", EnumRailDirection.class, (Predicate)new Predicate() {
            public boolean func_180344_a(final EnumRailDirection llIIIIIIIlllIl) {
                return llIIIIIIIlllIl != EnumRailDirection.NORTH_EAST && llIIIIIIIlllIl != EnumRailDirection.NORTH_WEST && llIIIIIIIlllIl != EnumRailDirection.SOUTH_EAST && llIIIIIIIlllIl != EnumRailDirection.SOUTH_WEST;
            }
            
            static {
                __OBFID = "CL_00002126";
            }
            
            public boolean apply(final Object llIIIIIIIllIII) {
                return this.func_180344_a((EnumRailDirection)llIIIIIIIllIII);
            }
        });
        field_176574_M = PropertyBool.create("powered");
    }
    
    private AxisAlignedBB func_176572_a(final BlockPos lIIllIlIIIlllI) {
        final float lIIllIlIIIllll = 0.2f;
        return new AxisAlignedBB(lIIllIlIIIlllI.getX() + 0.2f, lIIllIlIIIlllI.getY(), lIIllIlIIIlllI.getZ() + 0.2f, lIIllIlIIIlllI.getX() + 1 - 0.2f, lIIllIlIIIlllI.getY() + 1 - 0.2f, lIIllIlIIIlllI.getZ() + 1 - 0.2f);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lIIllIlIIIIlll) {
        return this.getDefaultState().withProperty(BlockRailDetector.field_176573_b, EnumRailDirection.func_177016_a(lIIllIlIIIIlll & 0x7)).withProperty(BlockRailDetector.field_176574_M, (lIIllIlIIIIlll & 0x8) > 0);
    }
    
    @Override
    public int getComparatorInputOverride(final World lIIllIlIlIlIIl, final BlockPos lIIllIlIlIlIII) {
        if (lIIllIlIlIlIIl.getBlockState(lIIllIlIlIlIII).getValue(BlockRailDetector.field_176574_M)) {
            final List lIIllIlIlIllII = this.func_176571_a(lIIllIlIlIlIIl, lIIllIlIlIlIII, EntityMinecartCommandBlock.class, new Predicate[0]);
            if (!lIIllIlIlIllII.isEmpty()) {
                return lIIllIlIlIllII.get(0).func_145822_e().getSuccessCount();
            }
            final List lIIllIlIlIlIll = this.func_176571_a(lIIllIlIlIlIIl, lIIllIlIlIlIII, EntityMinecart.class, IEntitySelector.selectInventories);
            if (!lIIllIlIlIlIll.isEmpty()) {
                return Container.calcRedstoneFromInventory(lIIllIlIlIlIll.get(0));
            }
        }
        return 0;
    }
    
    @Override
    public void randomTick(final World lIIllIlllllIII, final BlockPos lIIllIllllIlll, final IBlockState lIIllIllllIllI, final Random lIIllIllllIlIl) {
    }
    
    public BlockRailDetector() {
        super(true);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockRailDetector.field_176574_M, false).withProperty(BlockRailDetector.field_176573_b, EnumRailDirection.NORTH_SOUTH));
        this.setTickRandomly(true);
    }
    
    private void func_176570_e(final World lIIllIllIIllll, final BlockPos lIIllIllIIlllI, final IBlockState lIIllIllIIllIl) {
        final boolean lIIllIllIIllII = (boolean)lIIllIllIIllIl.getValue(BlockRailDetector.field_176574_M);
        boolean lIIllIllIIlIll = false;
        final List lIIllIllIIlIlI = this.func_176571_a(lIIllIllIIllll, lIIllIllIIlllI, EntityMinecart.class, new Predicate[0]);
        if (!lIIllIllIIlIlI.isEmpty()) {
            lIIllIllIIlIll = true;
        }
        if (lIIllIllIIlIll && !lIIllIllIIllII) {
            lIIllIllIIllll.setBlockState(lIIllIllIIlllI, lIIllIllIIllIl.withProperty(BlockRailDetector.field_176574_M, true), 3);
            lIIllIllIIllll.notifyNeighborsOfStateChange(lIIllIllIIlllI, this);
            lIIllIllIIllll.notifyNeighborsOfStateChange(lIIllIllIIlllI.offsetDown(), this);
            lIIllIllIIllll.markBlockRangeForRenderUpdate(lIIllIllIIlllI, lIIllIllIIlllI);
        }
        if (!lIIllIllIIlIll && lIIllIllIIllII) {
            lIIllIllIIllll.setBlockState(lIIllIllIIlllI, lIIllIllIIllIl.withProperty(BlockRailDetector.field_176574_M, false), 3);
            lIIllIllIIllll.notifyNeighborsOfStateChange(lIIllIllIIlllI, this);
            lIIllIllIIllll.notifyNeighborsOfStateChange(lIIllIllIIlllI.offsetDown(), this);
            lIIllIllIIllll.markBlockRangeForRenderUpdate(lIIllIllIIlllI, lIIllIllIIlllI);
        }
        if (lIIllIllIIlIll) {
            lIIllIllIIllll.scheduleUpdate(lIIllIllIIlllI, this, this.tickRate(lIIllIllIIllll));
        }
        lIIllIllIIllll.updateComparatorOutputLevel(lIIllIllIIlllI, this);
    }
    
    @Override
    public int tickRate(final World lIIlllIIIIlIII) {
        return 20;
    }
    
    @Override
    public void updateTick(final World lIIllIlllIllll, final BlockPos lIIllIlllIlIIl, final IBlockState lIIllIlllIllIl, final Random lIIllIlllIllII) {
        if (!lIIllIlllIllll.isRemote && (boolean)lIIllIlllIllIl.getValue(BlockRailDetector.field_176574_M)) {
            this.func_176570_e(lIIllIlllIllll, lIIllIlllIlIIl, lIIllIlllIllIl);
        }
    }
    
    @Override
    public void onBlockAdded(final World lIIllIlIllllIl, final BlockPos lIIllIlIllllII, final IBlockState lIIllIlIlllIll) {
        super.onBlockAdded(lIIllIlIllllIl, lIIllIlIllllII, lIIllIlIlllIll);
        this.func_176570_e(lIIllIlIllllIl, lIIllIlIllllII, lIIllIlIlllIll);
    }
    
    @Override
    public boolean canProvidePower() {
        return true;
    }
    
    @Override
    public int isProvidingWeakPower(final IBlockAccess lIIllIlllIIlIl, final BlockPos lIIllIlllIIlII, final IBlockState lIIllIlllIIIIl, final EnumFacing lIIllIlllIIIlI) {
        return lIIllIlllIIIIl.getValue(BlockRailDetector.field_176574_M) ? 15 : 0;
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockRailDetector.field_176573_b, BlockRailDetector.field_176574_M });
    }
    
    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World lIIlllIIIIIIIl, final BlockPos lIIlllIIIIIIII, final IBlockState lIIllIlllllIlI, final Entity lIIllIlllllllI) {
        if (!lIIlllIIIIIIIl.isRemote && !(boolean)lIIllIlllllIlI.getValue(BlockRailDetector.field_176574_M)) {
            this.func_176570_e(lIIlllIIIIIIIl, lIIlllIIIIIIII, lIIllIlllllIlI);
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState lIIllIIlllllll) {
        final byte lIIllIlIIIIIIl = 0;
        int lIIllIlIIIIIII = lIIllIlIIIIIIl | ((EnumRailDirection)lIIllIIlllllll.getValue(BlockRailDetector.field_176573_b)).func_177015_a();
        if (lIIllIIlllllll.getValue(BlockRailDetector.field_176574_M)) {
            lIIllIlIIIIIII |= 0x8;
        }
        return lIIllIlIIIIIII;
    }
    
    @Override
    public int isProvidingStrongPower(final IBlockAccess lIIllIllIlllIl, final BlockPos lIIllIllIlllII, final IBlockState lIIllIllIllIIl, final EnumFacing lIIllIllIllIlI) {
        return lIIllIllIllIIl.getValue(BlockRailDetector.field_176574_M) ? ((lIIllIllIllIlI == EnumFacing.UP) ? 15 : 0) : 0;
    }
    
    @Override
    public IProperty func_176560_l() {
        return BlockRailDetector.field_176573_b;
    }
    
    protected List func_176571_a(final World lIIllIlIIllllI, final BlockPos lIIllIlIIlllIl, final Class lIIllIlIIlllII, final Predicate... lIIllIlIIllIll) {
        final AxisAlignedBB lIIllIlIIllIlI = this.func_176572_a(lIIllIlIIlllIl);
        return (lIIllIlIIllIll.length != 1) ? lIIllIlIIllllI.getEntitiesWithinAABB(lIIllIlIIlllII, lIIllIlIIllIlI) : lIIllIlIIllllI.func_175647_a(lIIllIlIIlllII, lIIllIlIIllIlI, lIIllIlIIllIll[0]);
    }
}
