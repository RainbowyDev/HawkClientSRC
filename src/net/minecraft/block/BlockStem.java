package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.creativetab.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import com.google.common.base.*;

public class BlockStem extends BlockBush implements IGrowable
{
    private final /* synthetic */ Block cropBlock;
    public static final /* synthetic */ PropertyDirection FACING_PROP;
    public static final /* synthetic */ PropertyInteger AGE_PROP;
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIIllllllIIllIIIllI, final Random llllllllllllllIIllllllIIllIIIlIl, final int llllllllllllllIIllllllIIllIIIlII) {
        return null;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIIllllllIIlIIlllIl) {
        return this.getDefaultState().withProperty(BlockStem.AGE_PROP, llllllllllllllIIllllllIIlIIlllIl);
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess llllllllllllllIIllllllIIlllIlIII, final BlockPos llllllllllllllIIllllllIIlllIlIll) {
        this.maxY = ((int)llllllllllllllIIllllllIIlllIlIII.getBlockState(llllllllllllllIIllllllIIlllIlIll).getValue(BlockStem.AGE_PROP) * 2 + 2) / 16.0f;
        final float llllllllllllllIIllllllIIlllIlIlI = 0.125f;
        this.setBlockBounds(0.5f - llllllllllllllIIllllllIIlllIlIlI, 0.0f, 0.5f - llllllllllllllIIllllllIIlllIlIlI, 0.5f + llllllllllllllIIllllllIIlllIlIlI, (float)this.maxY, 0.5f + llllllllllllllIIllllllIIlllIlIlI);
    }
    
    @Override
    public void setBlockBoundsForItemRender() {
        final float llllllllllllllIIllllllIIllllIlII = 0.125f;
        this.setBlockBounds(0.5f - llllllllllllllIIllllllIIllllIlII, 0.0f, 0.5f - llllllllllllllIIllllllIIllllIlII, 0.5f + llllllllllllllIIllllllIIllllIlII, 0.25f, 0.5f + llllllllllllllIIllllllIIllllIlII);
    }
    
    @Override
    public int getRenderColor(final IBlockState llllllllllllllIIllllllIlIIIIIllI) {
        if (llllllllllllllIIllllllIlIIIIIllI.getBlock() != this) {
            return super.getRenderColor(llllllllllllllIIllllllIlIIIIIllI);
        }
        final int llllllllllllllIIllllllIlIIIIlIll = (int)llllllllllllllIIllllllIlIIIIIllI.getValue(BlockStem.AGE_PROP);
        final int llllllllllllllIIllllllIlIIIIlIlI = llllllllllllllIIllllllIlIIIIlIll * 32;
        final int llllllllllllllIIllllllIlIIIIlIIl = 255 - llllllllllllllIIllllllIlIIIIlIll * 8;
        final int llllllllllllllIIllllllIlIIIIlIII = llllllllllllllIIllllllIlIIIIlIll * 4;
        return llllllllllllllIIllllllIlIIIIlIlI << 16 | llllllllllllllIIllllllIlIIIIlIIl << 8 | llllllllllllllIIllllllIlIIIIlIII;
    }
    
    @Override
    public void updateTick(final World llllllllllllllIIllllllIlIIlIlIII, BlockPos llllllllllllllIIllllllIlIIllIIIl, IBlockState llllllllllllllIIllllllIlIIllIIII, final Random llllllllllllllIIllllllIlIIlIIlIl) {
        super.updateTick(llllllllllllllIIllllllIlIIlIlIII, llllllllllllllIIllllllIlIIllIIIl, llllllllllllllIIllllllIlIIllIIII, llllllllllllllIIllllllIlIIlIIlIl);
        if (llllllllllllllIIllllllIlIIlIlIII.getLightFromNeighbors(llllllllllllllIIllllllIlIIllIIIl.offsetUp()) >= 9) {
            final float llllllllllllllIIllllllIlIIlIlllI = BlockCrops.getGrowthChance(this, llllllllllllllIIllllllIlIIlIlIII, llllllllllllllIIllllllIlIIllIIIl);
            if (llllllllllllllIIllllllIlIIlIIlIl.nextInt((int)(25.0f / llllllllllllllIIllllllIlIIlIlllI) + 1) == 0) {
                final int llllllllllllllIIllllllIlIIlIllIl = (int)llllllllllllllIIllllllIlIIllIIII.getValue(BlockStem.AGE_PROP);
                if (llllllllllllllIIllllllIlIIlIllIl < 7) {
                    llllllllllllllIIllllllIlIIllIIII = llllllllllllllIIllllllIlIIllIIII.withProperty(BlockStem.AGE_PROP, llllllllllllllIIllllllIlIIlIllIl + 1);
                    llllllllllllllIIllllllIlIIlIlIII.setBlockState(llllllllllllllIIllllllIlIIllIIIl, llllllllllllllIIllllllIlIIllIIII, 2);
                }
                else {
                    for (final EnumFacing llllllllllllllIIllllllIlIIlIlIll : EnumFacing.Plane.HORIZONTAL) {
                        if (llllllllllllllIIllllllIlIIlIlIII.getBlockState(llllllllllllllIIllllllIlIIllIIIl.offset(llllllllllllllIIllllllIlIIlIlIll)).getBlock() == this.cropBlock) {
                            return;
                        }
                    }
                    llllllllllllllIIllllllIlIIllIIIl = llllllllllllllIIllllllIlIIllIIIl.offset(EnumFacing.Plane.HORIZONTAL.random(llllllllllllllIIllllllIlIIlIIlIl));
                    final Block llllllllllllllIIllllllIlIIlIlIlI = llllllllllllllIIllllllIlIIlIlIII.getBlockState(llllllllllllllIIllllllIlIIllIIIl.offsetDown()).getBlock();
                    if (llllllllllllllIIllllllIlIIlIlIII.getBlockState(llllllllllllllIIllllllIlIIllIIIl).getBlock().blockMaterial == Material.air && (llllllllllllllIIllllllIlIIlIlIlI == Blocks.farmland || llllllllllllllIIllllllIlIIlIlIlI == Blocks.dirt || llllllllllllllIIllllllIlIIlIlIlI == Blocks.grass)) {
                        llllllllllllllIIllllllIlIIlIlIII.setBlockState(llllllllllllllIIllllllIlIIllIIIl, this.cropBlock.getDefaultState());
                    }
                }
            }
        }
    }
    
    @Override
    public Item getItem(final World llllllllllllllIIllllllIIllIIIIII, final BlockPos llllllllllllllIIllllllIIlIllllll) {
        final Item llllllllllllllIIllllllIIlIlllllI = this.getSeedItem();
        return (llllllllllllllIIllllllIIlIlllllI != null) ? llllllllllllllIIllllllIIlIlllllI : null;
    }
    
    @Override
    public int colorMultiplier(final IBlockAccess llllllllllllllIIllllllIIllllllIl, final BlockPos llllllllllllllIIllllllIIllllllII, final int llllllllllllllIIllllllIIlllllIll) {
        return this.getRenderColor(llllllllllllllIIllllllIIllllllIl.getBlockState(llllllllllllllIIllllllIIllllllII));
    }
    
    protected Item getSeedItem() {
        return (this.cropBlock == Blocks.pumpkin) ? Items.pumpkin_seeds : ((this.cropBlock == Blocks.melon_block) ? Items.melon_seeds : null);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIIllllllIIlIIllIIl) {
        return (int)llllllllllllllIIllllllIIlIIllIIl.getValue(BlockStem.AGE_PROP);
    }
    
    protected BlockStem(final Block llllllllllllllIIllllllIlIlIlIlll) {
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockStem.AGE_PROP, 0).withProperty(BlockStem.FACING_PROP, EnumFacing.UP));
        this.cropBlock = llllllllllllllIIllllllIlIlIlIlll;
        this.setTickRandomly(true);
        final float llllllllllllllIIllllllIlIlIlIllI = 0.125f;
        this.setBlockBounds(0.5f - llllllllllllllIIllllllIlIlIlIllI, 0.0f, 0.5f - llllllllllllllIIllllllIlIlIlIllI, 0.5f + llllllllllllllIIllllllIlIlIlIllI, 0.25f, 0.5f + llllllllllllllIIllllllIlIlIlIllI);
        this.setCreativeTab(null);
    }
    
    @Override
    public IBlockState getActualState(IBlockState llllllllllllllIIllllllIlIlIIIlIl, final IBlockAccess llllllllllllllIIllllllIlIlIIIlII, final BlockPos llllllllllllllIIllllllIlIlIIIIll) {
        llllllllllllllIIllllllIlIlIIIlIl = (float)((IBlockState)llllllllllllllIIllllllIlIlIIIlIl).withProperty(BlockStem.FACING_PROP, EnumFacing.UP);
        for (final EnumFacing llllllllllllllIIllllllIlIlIIIlll : EnumFacing.Plane.HORIZONTAL) {
            if (llllllllllllllIIllllllIlIlIIIlII.getBlockState(llllllllllllllIIllllllIlIlIIIIll.offset(llllllllllllllIIllllllIlIlIIIlll)).getBlock() == this.cropBlock) {
                llllllllllllllIIllllllIlIlIIIlIl = (float)((IBlockState)llllllllllllllIIllllllIlIlIIIlIl).withProperty(BlockStem.FACING_PROP, llllllllllllllIIllllllIlIlIIIlll);
                break;
            }
        }
        return (IBlockState)llllllllllllllIIllllllIlIlIIIlIl;
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockStem.AGE_PROP, BlockStem.FACING_PROP });
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World llllllllllllllIIllllllIIllIlIIlI, final BlockPos llllllllllllllIIllllllIIllIlIIIl, final IBlockState llllllllllllllIIllllllIIllIllIIl, final float llllllllllllllIIllllllIIllIIllll, final int llllllllllllllIIllllllIIllIlIlll) {
        super.dropBlockAsItemWithChance(llllllllllllllIIllllllIIllIlIIlI, llllllllllllllIIllllllIIllIlIIIl, llllllllllllllIIllllllIIllIllIIl, llllllllllllllIIllllllIIllIIllll, llllllllllllllIIllllllIIllIlIlll);
        if (!llllllllllllllIIllllllIIllIlIIlI.isRemote) {
            final Item llllllllllllllIIllllllIIllIlIllI = this.getSeedItem();
            if (llllllllllllllIIllllllIIllIlIllI != null) {
                final int llllllllllllllIIllllllIIllIlIlIl = (int)llllllllllllllIIllllllIIllIllIIl.getValue(BlockStem.AGE_PROP);
                for (int llllllllllllllIIllllllIIllIlIlII = 0; llllllllllllllIIllllllIIllIlIlII < 3; ++llllllllllllllIIllllllIIllIlIlII) {
                    if (llllllllllllllIIllllllIIllIlIIlI.rand.nextInt(15) <= llllllllllllllIIllllllIIllIlIlIl) {
                        Block.spawnAsEntity(llllllllllllllIIllllllIIllIlIIlI, llllllllllllllIIllllllIIllIlIIIl, new ItemStack(llllllllllllllIIllllllIIllIlIllI));
                    }
                }
            }
        }
    }
    
    @Override
    public boolean isStillGrowing(final World llllllllllllllIIllllllIIlIlllIIl, final BlockPos llllllllllllllIIllllllIIlIlllIII, final IBlockState llllllllllllllIIllllllIIlIllIlIl, final boolean llllllllllllllIIllllllIIlIllIllI) {
        return (int)llllllllllllllIIllllllIIlIllIlIl.getValue(BlockStem.AGE_PROP) != 7;
    }
    
    public void growStem(final World llllllllllllllIIllllllIlIIIlIlll, final BlockPos llllllllllllllIIllllllIlIIIlIllI, final IBlockState llllllllllllllIIllllllIlIIIlIlIl) {
        final int llllllllllllllIIllllllIlIIIllIII = (int)llllllllllllllIIllllllIlIIIlIlIl.getValue(BlockStem.AGE_PROP) + MathHelper.getRandomIntegerInRange(llllllllllllllIIllllllIlIIIlIlll.rand, 2, 5);
        llllllllllllllIIllllllIlIIIlIlll.setBlockState(llllllllllllllIIllllllIlIIIlIllI, llllllllllllllIIllllllIlIIIlIlIl.withProperty(BlockStem.AGE_PROP, Math.min(7, llllllllllllllIIllllllIlIIIllIII)), 2);
    }
    
    @Override
    public boolean canUseBonemeal(final World llllllllllllllIIllllllIIlIllIIll, final Random llllllllllllllIIllllllIIlIllIIlI, final BlockPos llllllllllllllIIllllllIIlIllIIIl, final IBlockState llllllllllllllIIllllllIIlIllIIII) {
        return true;
    }
    
    @Override
    protected boolean canPlaceBlockOn(final Block llllllllllllllIIllllllIlIIllllIl) {
        return llllllllllllllIIllllllIlIIllllIl == Blocks.farmland;
    }
    
    static {
        __OBFID = "CL_00000316";
        AGE_PROP = PropertyInteger.create("age", 0, 7);
        FACING_PROP = PropertyDirection.create("facing", (Predicate)new Predicate() {
            public boolean apply(final Object llllllllllllllIlIIlIlllIlIlIlIIl) {
                return this.apply((EnumFacing)llllllllllllllIlIIlIlllIlIlIlIIl);
            }
            
            static {
                __OBFID = "CL_00002059";
            }
            
            public boolean apply(final EnumFacing llllllllllllllIlIIlIlllIlIlIllIl) {
                return llllllllllllllIlIIlIlllIlIlIllIl != EnumFacing.DOWN;
            }
        });
    }
    
    @Override
    public void grow(final World llllllllllllllIIllllllIIlIlIlIlI, final Random llllllllllllllIIllllllIIlIlIlIIl, final BlockPos llllllllllllllIIllllllIIlIlIIlII, final IBlockState llllllllllllllIIllllllIIlIlIIIll) {
        this.growStem(llllllllllllllIIllllllIIlIlIlIlI, llllllllllllllIIllllllIIlIlIIlII, llllllllllllllIIllllllIIlIlIIIll);
    }
}
