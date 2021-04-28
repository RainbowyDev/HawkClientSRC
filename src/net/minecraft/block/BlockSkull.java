package net.minecraft.block;

import com.google.common.base.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.player.*;
import net.minecraft.stats.*;
import net.minecraft.tileentity.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.block.state.pattern.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.nbt.*;

public class BlockSkull extends BlockContainer
{
    private /* synthetic */ BlockPattern field_176421_O;
    public static final /* synthetic */ PropertyDirection field_176418_a;
    private /* synthetic */ BlockPattern field_176420_N;
    public static final /* synthetic */ PropertyBool field_176417_b;
    private static final /* synthetic */ Predicate field_176419_M;
    
    @Override
    public void dropBlockAsItemWithChance(final World llllllllllllllIlIIIIlIlllIIIIlII, final BlockPos llllllllllllllIlIIIIlIlllIIIIIll, final IBlockState llllllllllllllIlIIIIlIlllIIIIIlI, final float llllllllllllllIlIIIIlIlllIIIIIIl, final int llllllllllllllIlIIIIlIlllIIIIIII) {
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIlIIIIlIllIIIIllIl) {
        final byte llllllllllllllIlIIIIlIllIIIIllll = 0;
        int llllllllllllllIlIIIIlIllIIIIlllI = llllllllllllllIlIIIIlIllIIIIllll | ((EnumFacing)llllllllllllllIlIIIIlIllIIIIllIl.getValue(BlockSkull.field_176418_a)).getIndex();
        if (llllllllllllllIlIIIIlIllIIIIllIl.getValue(BlockSkull.field_176417_b)) {
            llllllllllllllIlIIIIlIllIIIIlllI |= 0x8;
        }
        return llllllllllllllIlIIIIlIllIIIIlllI;
    }
    
    public void func_180679_a(final World llllllllllllllIlIIIIlIllIIlllIIl, final BlockPos llllllllllllllIlIIIIlIllIIlllIII, final TileEntitySkull llllllllllllllIlIIIIlIllIIlIIlIl) {
        if (llllllllllllllIlIIIIlIllIIlIIlIl.getSkullType() == 1 && llllllllllllllIlIIIIlIllIIlllIII.getY() >= 2 && llllllllllllllIlIIIIlIllIIlllIIl.getDifficulty() != EnumDifficulty.PEACEFUL && !llllllllllllllIlIIIIlIllIIlllIIl.isRemote) {
            final BlockPattern llllllllllllllIlIIIIlIllIIllIllI = this.func_176416_l();
            final BlockPattern.PatternHelper llllllllllllllIlIIIIlIllIIllIlIl = llllllllllllllIlIIIIlIllIIllIllI.func_177681_a(llllllllllllllIlIIIIlIllIIlllIIl, llllllllllllllIlIIIIlIllIIlllIII);
            if (llllllllllllllIlIIIIlIllIIllIlIl != null) {
                for (int llllllllllllllIlIIIIlIllIIllIlII = 0; llllllllllllllIlIIIIlIllIIllIlII < 3; ++llllllllllllllIlIIIIlIllIIllIlII) {
                    final BlockWorldState llllllllllllllIlIIIIlIllIIllIIll = llllllllllllllIlIIIIlIllIIllIlIl.func_177670_a(llllllllllllllIlIIIIlIllIIllIlII, 0, 0);
                    llllllllllllllIlIIIIlIllIIlllIIl.setBlockState(llllllllllllllIlIIIIlIllIIllIIll.getPos(), llllllllllllllIlIIIIlIllIIllIIll.func_177509_a().withProperty(BlockSkull.field_176417_b, true), 2);
                }
                for (int llllllllllllllIlIIIIlIllIIllIlII = 0; llllllllllllllIlIIIIlIllIIllIlII < llllllllllllllIlIIIIlIllIIllIllI.func_177684_c(); ++llllllllllllllIlIIIIlIllIIllIlII) {
                    for (int llllllllllllllIlIIIIlIllIIllIIlI = 0; llllllllllllllIlIIIIlIllIIllIIlI < llllllllllllllIlIIIIlIllIIllIllI.func_177685_b(); ++llllllllllllllIlIIIIlIllIIllIIlI) {
                        final BlockWorldState llllllllllllllIlIIIIlIllIIllIIIl = llllllllllllllIlIIIIlIllIIllIlIl.func_177670_a(llllllllllllllIlIIIIlIllIIllIlII, llllllllllllllIlIIIIlIllIIllIIlI, 0);
                        llllllllllllllIlIIIIlIllIIlllIIl.setBlockState(llllllllllllllIlIIIIlIllIIllIIIl.getPos(), Blocks.air.getDefaultState(), 2);
                    }
                }
                final BlockPos llllllllllllllIlIIIIlIllIIllIIII = llllllllllllllIlIIIIlIllIIllIlIl.func_177670_a(1, 0, 0).getPos();
                final EntityWither llllllllllllllIlIIIIlIllIIlIllll = new EntityWither(llllllllllllllIlIIIIlIllIIlllIIl);
                final BlockPos llllllllllllllIlIIIIlIllIIlIlllI = llllllllllllllIlIIIIlIllIIllIlIl.func_177670_a(1, 2, 0).getPos();
                llllllllllllllIlIIIIlIllIIlIllll.setLocationAndAngles(llllllllllllllIlIIIIlIllIIlIlllI.getX() + 0.5, llllllllllllllIlIIIIlIllIIlIlllI.getY() + 0.55, llllllllllllllIlIIIIlIllIIlIlllI.getZ() + 0.5, (llllllllllllllIlIIIIlIllIIllIlIl.func_177669_b().getAxis() == EnumFacing.Axis.X) ? 0.0f : 90.0f, 0.0f);
                llllllllllllllIlIIIIlIllIIlIllll.renderYawOffset = ((llllllllllllllIlIIIIlIllIIllIlIl.func_177669_b().getAxis() == EnumFacing.Axis.X) ? 0.0f : 90.0f);
                llllllllllllllIlIIIIlIllIIlIllll.func_82206_m();
                for (final EntityPlayer llllllllllllllIlIIIIlIllIIlIllII : llllllllllllllIlIIIIlIllIIlllIIl.getEntitiesWithinAABB(EntityPlayer.class, llllllllllllllIlIIIIlIllIIlIllll.getEntityBoundingBox().expand(50.0, 50.0, 50.0))) {
                    llllllllllllllIlIIIIlIllIIlIllII.triggerAchievement(AchievementList.spawnWither);
                }
                llllllllllllllIlIIIIlIllIIlllIIl.spawnEntityInWorld(llllllllllllllIlIIIIlIllIIlIllll);
                for (int llllllllllllllIlIIIIlIllIIlIlIll = 0; llllllllllllllIlIIIIlIllIIlIlIll < 120; ++llllllllllllllIlIIIIlIllIIlIlIll) {
                    llllllllllllllIlIIIIlIllIIlllIIl.spawnParticle(EnumParticleTypes.SNOWBALL, llllllllllllllIlIIIIlIllIIllIIII.getX() + llllllllllllllIlIIIIlIllIIlllIIl.rand.nextDouble(), llllllllllllllIlIIIIlIllIIllIIII.getY() - 2 + llllllllllllllIlIIIIlIllIIlllIIl.rand.nextDouble() * 3.9, llllllllllllllIlIIIIlIllIIllIIII.getZ() + llllllllllllllIlIIIIlIllIIlllIIl.rand.nextDouble(), 0.0, 0.0, 0.0, new int[0]);
                }
                for (int llllllllllllllIlIIIIlIllIIlIlIll = 0; llllllllllllllIlIIIIlIllIIlIlIll < llllllllllllllIlIIIIlIllIIllIllI.func_177684_c(); ++llllllllllllllIlIIIIlIllIIlIlIll) {
                    for (int llllllllllllllIlIIIIlIllIIlIlIlI = 0; llllllllllllllIlIIIIlIllIIlIlIlI < llllllllllllllIlIIIIlIllIIllIllI.func_177685_b(); ++llllllllllllllIlIIIIlIllIIlIlIlI) {
                        final BlockWorldState llllllllllllllIlIIIIlIllIIlIlIIl = llllllllllllllIlIIIIlIllIIllIlIl.func_177670_a(llllllllllllllIlIIIIlIllIIlIlIll, llllllllllllllIlIIIIlIllIIlIlIlI, 0);
                        llllllllllllllIlIIIIlIllIIlllIIl.func_175722_b(llllllllllllllIlIIIIlIllIIlIlIIl.getPos(), Blocks.air);
                    }
                }
            }
        }
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    static {
        __OBFID = "CL_00000307";
        field_176418_a = PropertyDirection.create("facing");
        field_176417_b = PropertyBool.create("nodrop");
        field_176419_M = (Predicate)new Predicate() {
            static {
                __OBFID = "CL_00002065";
            }
            
            public boolean func_177062_a(final BlockWorldState llllllllllllllIIlIIlllIIIllIIIII) {
                return llllllllllllllIIlIIlllIIIllIIIII.func_177509_a().getBlock() == Blocks.skull && llllllllllllllIIlIIlllIIIllIIIII.func_177507_b() instanceof TileEntitySkull && ((TileEntitySkull)llllllllllllllIIlIIlllIIIllIIIII.func_177507_b()).getSkullType() == 1;
            }
            
            public boolean apply(final Object llllllllllllllIIlIIlllIIIlIllIll) {
                return this.func_177062_a((BlockWorldState)llllllllllllllIIlIIlllIIIlIllIll);
            }
        };
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllllIlIIIIlIlllIIlIllI, final int llllllllllllllIlIIIIlIlllIIlIlIl) {
        return new TileEntitySkull();
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIlIIIIlIllIlIlIlll, final Random llllllllllllllIlIIIIlIllIlIlIllI, final int llllllllllllllIlIIIIlIllIlIlIlIl) {
        return Items.skull;
    }
    
    @Override
    public void onBlockHarvested(final World llllllllllllllIlIIIIlIllIllllIIl, final BlockPos llllllllllllllIlIIIIlIllIlllIIll, IBlockState llllllllllllllIlIIIIlIllIlllIIlI, final EntityPlayer llllllllllllllIlIIIIlIllIlllIIIl) {
        if (llllllllllllllIlIIIIlIllIlllIIIl.capabilities.isCreativeMode) {
            llllllllllllllIlIIIIlIllIlllIIlI = ((IBlockState)llllllllllllllIlIIIIlIllIlllIIlI).withProperty(BlockSkull.field_176417_b, true);
            llllllllllllllIlIIIIlIllIllllIIl.setBlockState(llllllllllllllIlIIIIlIllIlllIIll, (IBlockState)llllllllllllllIlIIIIlIllIlllIIlI, 4);
        }
        super.onBlockHarvested(llllllllllllllIlIIIIlIllIllllIIl, llllllllllllllIlIIIIlIllIlllIIll, (IBlockState)llllllllllllllIlIIIIlIllIlllIIlI, llllllllllllllIlIIIIlIllIlllIIIl);
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World llllllllllllllIlIIIIlIlllIlIIlll, final BlockPos llllllllllllllIlIIIIlIlllIlIlIlI, final IBlockState llllllllllllllIlIIIIlIlllIlIIlIl) {
        this.setBlockBoundsBasedOnState(llllllllllllllIlIIIIlIlllIlIIlll, llllllllllllllIlIIIIlIlllIlIlIlI);
        return super.getCollisionBoundingBox(llllllllllllllIlIIIIlIlllIlIIlll, llllllllllllllIlIIIIlIlllIlIlIlI, llllllllllllllIlIIIIlIlllIlIIlIl);
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockSkull.field_176418_a, BlockSkull.field_176417_b });
    }
    
    protected BlockPattern func_176414_j() {
        if (this.field_176420_N == null) {
            this.field_176420_N = FactoryBlockPattern.start().aisle("   ", "###", "~#~").where('#', BlockWorldState.hasState((Predicate)BlockStateHelper.forBlock(Blocks.soul_sand))).where('~', BlockWorldState.hasState((Predicate)BlockStateHelper.forBlock(Blocks.air))).build();
        }
        return this.field_176420_N;
    }
    
    public boolean func_176415_b(final World llllllllllllllIlIIIIlIllIlIIlIll, final BlockPos llllllllllllllIlIIIIlIllIlIIlllI, final ItemStack llllllllllllllIlIIIIlIllIlIIlIIl) {
        return llllllllllllllIlIIIIlIllIlIIlIIl.getMetadata() == 1 && llllllllllllllIlIIIIlIllIlIIlllI.getY() >= 2 && llllllllllllllIlIIIIlIllIlIIlIll.getDifficulty() != EnumDifficulty.PEACEFUL && !llllllllllllllIlIIIIlIllIlIIlIll.isRemote && this.func_176414_j().func_177681_a(llllllllllllllIlIIIIlIllIlIIlIll, llllllllllllllIlIIIIlIllIlIIlllI) != null;
    }
    
    @Override
    public int getDamageValue(final World llllllllllllllIlIIIIlIlllIIIlIII, final BlockPos llllllllllllllIlIIIIlIlllIIIlIll) {
        final TileEntity llllllllllllllIlIIIIlIlllIIIlIlI = llllllllllllllIlIIIIlIlllIIIlIII.getTileEntity(llllllllllllllIlIIIIlIlllIIIlIll);
        return (llllllllllllllIlIIIIlIlllIIIlIlI instanceof TileEntitySkull) ? ((TileEntitySkull)llllllllllllllIlIIIIlIlllIIIlIlI).getSkullType() : super.getDamageValue(llllllllllllllIlIIIIlIlllIIIlIII, llllllllllllllIlIIIIlIlllIIIlIll);
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllllIlIIIIlIlllIlIIIIl, final BlockPos llllllllllllllIlIIIIlIlllIlIIIII, final EnumFacing llllllllllllllIlIIIIlIlllIIlllll, final float llllllllllllllIlIIIIlIlllIIllllI, final float llllllllllllllIlIIIIlIlllIIlllIl, final float llllllllllllllIlIIIIlIlllIIlllII, final int llllllllllllllIlIIIIlIlllIIllIll, final EntityLivingBase llllllllllllllIlIIIIlIlllIIllIlI) {
        return this.getDefaultState().withProperty(BlockSkull.field_176418_a, llllllllllllllIlIIIIlIlllIIllIlI.func_174811_aO()).withProperty(BlockSkull.field_176417_b, false);
    }
    
    protected BlockSkull() {
        super(Material.circuits);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockSkull.field_176418_a, EnumFacing.NORTH).withProperty(BlockSkull.field_176417_b, false));
        this.setBlockBounds(0.25f, 0.0f, 0.25f, 0.75f, 0.5f, 0.75f);
    }
    
    @Override
    public Item getItem(final World llllllllllllllIlIIIIlIlllIIlIIll, final BlockPos llllllllllllllIlIIIIlIlllIIlIIlI) {
        return Items.skull;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIlIIIIlIllIIIlIlIl) {
        return this.getDefaultState().withProperty(BlockSkull.field_176418_a, EnumFacing.getFront(llllllllllllllIlIIIIlIllIIIlIlIl & 0x7)).withProperty(BlockSkull.field_176417_b, (llllllllllllllIlIIIIlIllIIIlIlIl & 0x8) > 0);
    }
    
    protected BlockPattern func_176416_l() {
        if (this.field_176421_O == null) {
            this.field_176421_O = FactoryBlockPattern.start().aisle("^^^", "###", "~#~").where('#', BlockWorldState.hasState((Predicate)BlockStateHelper.forBlock(Blocks.soul_sand))).where('^', BlockSkull.field_176419_M).where('~', BlockWorldState.hasState((Predicate)BlockStateHelper.forBlock(Blocks.air))).build();
        }
        return this.field_176421_O;
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess llllllllllllllIlIIIIlIlllIllIlIl, final BlockPos llllllllllllllIlIIIIlIlllIllIIIl) {
        switch (SwitchEnumFacing.field_177063_a[((EnumFacing)llllllllllllllIlIIIIlIlllIllIlIl.getBlockState(llllllllllllllIlIIIIlIlllIllIIIl).getValue(BlockSkull.field_176418_a)).ordinal()]) {
            default: {
                this.setBlockBounds(0.25f, 0.0f, 0.25f, 0.75f, 0.5f, 0.75f);
                break;
            }
            case 2: {
                this.setBlockBounds(0.25f, 0.25f, 0.5f, 0.75f, 0.75f, 1.0f);
                break;
            }
            case 3: {
                this.setBlockBounds(0.25f, 0.25f, 0.0f, 0.75f, 0.75f, 0.5f);
                break;
            }
            case 4: {
                this.setBlockBounds(0.5f, 0.25f, 0.25f, 1.0f, 0.75f, 0.75f);
                break;
            }
            case 5: {
                this.setBlockBounds(0.0f, 0.25f, 0.25f, 0.5f, 0.75f, 0.75f);
                break;
            }
        }
    }
    
    @Override
    public void breakBlock(final World llllllllllllllIlIIIIlIllIlIlllll, final BlockPos llllllllllllllIlIIIIlIllIlIllllI, final IBlockState llllllllllllllIlIIIIlIllIlIlllIl) {
        if (!llllllllllllllIlIIIIlIllIlIlllll.isRemote) {
            if (!(boolean)llllllllllllllIlIIIIlIllIlIlllIl.getValue(BlockSkull.field_176417_b)) {
                final TileEntity llllllllllllllIlIIIIlIllIllIIlII = llllllllllllllIlIIIIlIllIlIlllll.getTileEntity(llllllllllllllIlIIIIlIllIlIllllI);
                if (llllllllllllllIlIIIIlIllIllIIlII instanceof TileEntitySkull) {
                    final TileEntitySkull llllllllllllllIlIIIIlIllIllIIIll = (TileEntitySkull)llllllllllllllIlIIIIlIllIllIIlII;
                    final ItemStack llllllllllllllIlIIIIlIllIllIIIlI = new ItemStack(Items.skull, 1, this.getDamageValue(llllllllllllllIlIIIIlIllIlIlllll, llllllllllllllIlIIIIlIllIlIllllI));
                    if (llllllllllllllIlIIIIlIllIllIIIll.getSkullType() == 3 && llllllllllllllIlIIIIlIllIllIIIll.getPlayerProfile() != null) {
                        llllllllllllllIlIIIIlIllIllIIIlI.setTagCompound(new NBTTagCompound());
                        final NBTTagCompound llllllllllllllIlIIIIlIllIllIIIIl = new NBTTagCompound();
                        NBTUtil.writeGameProfile(llllllllllllllIlIIIIlIllIllIIIIl, llllllllllllllIlIIIIlIllIllIIIll.getPlayerProfile());
                        llllllllllllllIlIIIIlIllIllIIIlI.getTagCompound().setTag("SkullOwner", llllllllllllllIlIIIIlIllIllIIIIl);
                    }
                    Block.spawnAsEntity(llllllllllllllIlIIIIlIllIlIlllll, llllllllllllllIlIIIIlIllIlIllllI, llllllllllllllIlIIIIlIllIllIIIlI);
                }
            }
            super.breakBlock(llllllllllllllIlIIIIlIllIlIlllll, llllllllllllllIlIIIIlIllIlIllllI, llllllllllllllIlIIIIlIllIlIlllIl);
        }
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] field_177063_a;
        
        static {
            __OBFID = "CL_00002064";
            field_177063_a = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.field_177063_a[EnumFacing.UP.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.field_177063_a[EnumFacing.NORTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.field_177063_a[EnumFacing.SOUTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumFacing.field_177063_a[EnumFacing.WEST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                SwitchEnumFacing.field_177063_a[EnumFacing.EAST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
        }
    }
}
