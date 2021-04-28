package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.block.state.pattern.*;
import com.google.common.base.*;
import net.minecraft.entity.monster.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.*;
import net.minecraft.block.state.*;

public class BlockPumpkin extends BlockDirectional
{
    private /* synthetic */ BlockPattern field_176394_a;
    private /* synthetic */ BlockPattern field_176393_b;
    private /* synthetic */ BlockPattern field_176395_M;
    private /* synthetic */ BlockPattern field_176396_O;
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllllIIlIIlIllIlIIllII, final BlockPos lllllllllllllllIIlIIlIllIlIIlIll) {
        return lllllllllllllllIIlIIlIllIlIIllII.getBlockState(lllllllllllllllIIlIIlIllIlIIlIll).getBlock().blockMaterial.isReplaceable() && World.doesBlockHaveSolidTopSurface(lllllllllllllllIIlIIlIllIlIIllII, lllllllllllllllIIlIIlIllIlIIlIll.offsetDown());
    }
    
    protected BlockPattern func_176391_l() {
        if (this.field_176393_b == null) {
            this.field_176393_b = FactoryBlockPattern.start().aisle("^", "#", "#").where('^', BlockWorldState.hasState((Predicate)BlockStateHelper.forBlock(Blocks.pumpkin))).where('#', BlockWorldState.hasState((Predicate)BlockStateHelper.forBlock(Blocks.snow))).build();
        }
        return this.field_176393_b;
    }
    
    private void createGolem(final World lllllllllllllllIIlIIlIllIllIlIIl, final BlockPos lllllllllllllllIIlIIlIllIllIlIII) {
        BlockPattern.PatternHelper lllllllllllllllIIlIIlIllIllIIlll;
        if ((lllllllllllllllIIlIIlIllIllIIlll = this.func_176391_l().func_177681_a(lllllllllllllllIIlIIlIllIllIlIIl, lllllllllllllllIIlIIlIllIllIlIII)) != null) {
            for (int lllllllllllllllIIlIIlIllIllIIllI = 0; lllllllllllllllIIlIIlIllIllIIllI < this.func_176391_l().func_177685_b(); ++lllllllllllllllIIlIIlIllIllIIllI) {
                final BlockWorldState lllllllllllllllIIlIIlIllIllIIIlI = lllllllllllllllIIlIIlIllIllIIlll.func_177670_a(0, lllllllllllllllIIlIIlIllIllIIllI, 0);
                lllllllllllllllIIlIIlIllIllIlIIl.setBlockState(lllllllllllllllIIlIIlIllIllIIIlI.getPos(), Blocks.air.getDefaultState(), 2);
            }
            final EntitySnowman lllllllllllllllIIlIIlIllIllIIIIl = new EntitySnowman(lllllllllllllllIIlIIlIllIllIlIIl);
            final BlockPos lllllllllllllllIIlIIlIllIllIIIII = lllllllllllllllIIlIIlIllIllIIlll.func_177670_a(0, 2, 0).getPos();
            lllllllllllllllIIlIIlIllIllIIIIl.setLocationAndAngles(lllllllllllllllIIlIIlIllIllIIIII.getX() + 0.5, lllllllllllllllIIlIIlIllIllIIIII.getY() + 0.05, lllllllllllllllIIlIIlIllIllIIIII.getZ() + 0.5, 0.0f, 0.0f);
            lllllllllllllllIIlIIlIllIllIlIIl.spawnEntityInWorld(lllllllllllllllIIlIIlIllIllIIIIl);
            for (int lllllllllllllllIIlIIlIllIllIIlII = 0; lllllllllllllllIIlIIlIllIllIIlII < 120; ++lllllllllllllllIIlIIlIllIllIIlII) {
                lllllllllllllllIIlIIlIllIllIlIIl.spawnParticle(EnumParticleTypes.SNOW_SHOVEL, lllllllllllllllIIlIIlIllIllIIIII.getX() + lllllllllllllllIIlIIlIllIllIlIIl.rand.nextDouble(), lllllllllllllllIIlIIlIllIllIIIII.getY() + lllllllllllllllIIlIIlIllIllIlIIl.rand.nextDouble() * 2.5, lllllllllllllllIIlIIlIllIllIIIII.getZ() + lllllllllllllllIIlIIlIllIllIlIIl.rand.nextDouble(), 0.0, 0.0, 0.0, new int[0]);
            }
            for (int lllllllllllllllIIlIIlIllIllIIlII = 0; lllllllllllllllIIlIIlIllIllIIlII < this.func_176391_l().func_177685_b(); ++lllllllllllllllIIlIIlIllIllIIlII) {
                final BlockWorldState lllllllllllllllIIlIIlIllIlIlllll = lllllllllllllllIIlIIlIllIllIIlll.func_177670_a(0, lllllllllllllllIIlIIlIllIllIIlII, 0);
                lllllllllllllllIIlIIlIllIllIlIIl.func_175722_b(lllllllllllllllIIlIIlIllIlIlllll.getPos(), Blocks.air);
            }
        }
        else if ((lllllllllllllllIIlIIlIllIllIIlll = this.func_176388_T().func_177681_a(lllllllllllllllIIlIIlIllIllIlIIl, lllllllllllllllIIlIIlIllIllIlIII)) != null) {
            for (int lllllllllllllllIIlIIlIllIllIIlIl = 0; lllllllllllllllIIlIIlIllIllIIlIl < this.func_176388_T().func_177684_c(); ++lllllllllllllllIIlIIlIllIllIIlIl) {
                for (int lllllllllllllllIIlIIlIllIlIllllI = 0; lllllllllllllllIIlIIlIllIlIllllI < this.func_176388_T().func_177685_b(); ++lllllllllllllllIIlIIlIllIlIllllI) {
                    lllllllllllllllIIlIIlIllIllIlIIl.setBlockState(lllllllllllllllIIlIIlIllIllIIlll.func_177670_a(lllllllllllllllIIlIIlIllIllIIlIl, lllllllllllllllIIlIIlIllIlIllllI, 0).getPos(), Blocks.air.getDefaultState(), 2);
                }
            }
            final BlockPos lllllllllllllllIIlIIlIllIlIlllIl = lllllllllllllllIIlIIlIllIllIIlll.func_177670_a(1, 2, 0).getPos();
            final EntityIronGolem lllllllllllllllIIlIIlIllIlIlllII = new EntityIronGolem(lllllllllllllllIIlIIlIllIllIlIIl);
            lllllllllllllllIIlIIlIllIlIlllII.setPlayerCreated(true);
            lllllllllllllllIIlIIlIllIlIlllII.setLocationAndAngles(lllllllllllllllIIlIIlIllIlIlllIl.getX() + 0.5, lllllllllllllllIIlIIlIllIlIlllIl.getY() + 0.05, lllllllllllllllIIlIIlIllIlIlllIl.getZ() + 0.5, 0.0f, 0.0f);
            lllllllllllllllIIlIIlIllIllIlIIl.spawnEntityInWorld(lllllllllllllllIIlIIlIllIlIlllII);
            for (int lllllllllllllllIIlIIlIllIllIIIll = 0; lllllllllllllllIIlIIlIllIllIIIll < 120; ++lllllllllllllllIIlIIlIllIllIIIll) {
                lllllllllllllllIIlIIlIllIllIlIIl.spawnParticle(EnumParticleTypes.SNOWBALL, lllllllllllllllIIlIIlIllIlIlllIl.getX() + lllllllllllllllIIlIIlIllIllIlIIl.rand.nextDouble(), lllllllllllllllIIlIIlIllIlIlllIl.getY() + lllllllllllllllIIlIIlIllIllIlIIl.rand.nextDouble() * 3.9, lllllllllllllllIIlIIlIllIlIlllIl.getZ() + lllllllllllllllIIlIIlIllIllIlIIl.rand.nextDouble(), 0.0, 0.0, 0.0, new int[0]);
            }
            for (int lllllllllllllllIIlIIlIllIllIIIll = 0; lllllllllllllllIIlIIlIllIllIIIll < this.func_176388_T().func_177684_c(); ++lllllllllllllllIIlIIlIllIllIIIll) {
                for (int lllllllllllllllIIlIIlIllIlIllIll = 0; lllllllllllllllIIlIIlIllIlIllIll < this.func_176388_T().func_177685_b(); ++lllllllllllllllIIlIIlIllIlIllIll) {
                    final BlockWorldState lllllllllllllllIIlIIlIllIlIllIlI = lllllllllllllllIIlIIlIllIllIIlll.func_177670_a(lllllllllllllllIIlIIlIllIllIIIll, lllllllllllllllIIlIIlIllIlIllIll, 0);
                    lllllllllllllllIIlIIlIllIllIlIIl.func_175722_b(lllllllllllllllIIlIIlIllIlIllIlI.getPos(), Blocks.air);
                }
            }
        }
    }
    
    protected BlockPumpkin() {
        super(Material.gourd);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockPumpkin.AGE, EnumFacing.NORTH));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    protected BlockPattern func_176392_j() {
        if (this.field_176394_a == null) {
            this.field_176394_a = FactoryBlockPattern.start().aisle(" ", "#", "#").where('#', BlockWorldState.hasState((Predicate)BlockStateHelper.forBlock(Blocks.snow))).build();
        }
        return this.field_176394_a;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIIlIIlIllIIllIIlI) {
        return ((EnumFacing)lllllllllllllllIIlIIlIllIIllIIlI.getValue(BlockPumpkin.AGE)).getHorizontalIndex();
    }
    
    public boolean func_176390_d(final World lllllllllllllllIIlIIlIllIlllIllI, final BlockPos lllllllllllllllIIlIIlIllIllllIII) {
        return this.func_176392_j().func_177681_a(lllllllllllllllIIlIIlIllIlllIllI, lllllllllllllllIIlIIlIllIllllIII) != null || this.func_176389_S().func_177681_a(lllllllllllllllIIlIIlIllIlllIllI, lllllllllllllllIIlIIlIllIllllIII) != null;
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllllllIIlIIlIlllIIIIlII, final BlockPos lllllllllllllllIIlIIlIlllIIIIIll, final IBlockState lllllllllllllllIIlIIlIllIllllllI) {
        super.onBlockAdded(lllllllllllllllIIlIIlIlllIIIIlII, lllllllllllllllIIlIIlIlllIIIIIll, lllllllllllllllIIlIIlIllIllllllI);
        this.createGolem(lllllllllllllllIIlIIlIlllIIIIlII, lllllllllllllllIIlIIlIlllIIIIIll);
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllllIIlIIlIllIlIIIlIl, final BlockPos lllllllllllllllIIlIIlIllIlIIIlII, final EnumFacing lllllllllllllllIIlIIlIllIlIIIIll, final float lllllllllllllllIIlIIlIllIlIIIIlI, final float lllllllllllllllIIlIIlIllIlIIIIIl, final float lllllllllllllllIIlIIlIllIlIIIIII, final int lllllllllllllllIIlIIlIllIIllllll, final EntityLivingBase lllllllllllllllIIlIIlIllIIllllII) {
        return this.getDefaultState().withProperty(BlockPumpkin.AGE, lllllllllllllllIIlIIlIllIIllllII.func_174811_aO().getOpposite());
    }
    
    protected BlockPattern func_176388_T() {
        if (this.field_176396_O == null) {
            this.field_176396_O = FactoryBlockPattern.start().aisle("~^~", "###", "~#~").where('^', BlockWorldState.hasState((Predicate)BlockStateHelper.forBlock(Blocks.pumpkin))).where('#', BlockWorldState.hasState((Predicate)BlockStateHelper.forBlock(Blocks.iron_block))).where('~', BlockWorldState.hasState((Predicate)BlockStateHelper.forBlock(Blocks.air))).build();
        }
        return this.field_176396_O;
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockPumpkin.AGE });
    }
    
    protected BlockPattern func_176389_S() {
        if (this.field_176395_M == null) {
            this.field_176395_M = FactoryBlockPattern.start().aisle("~ ~", "###", "~#~").where('#', BlockWorldState.hasState((Predicate)BlockStateHelper.forBlock(Blocks.iron_block))).where('~', BlockWorldState.hasState((Predicate)BlockStateHelper.forBlock(Blocks.air))).build();
        }
        return this.field_176395_M;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIIlIIlIllIIllIllI) {
        return this.getDefaultState().withProperty(BlockPumpkin.AGE, EnumFacing.getHorizontal(lllllllllllllllIIlIIlIllIIllIllI));
    }
    
    static {
        __OBFID = "CL_00000291";
    }
}
