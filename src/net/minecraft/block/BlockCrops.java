package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;
import net.minecraft.init.*;

public class BlockCrops extends BlockBush implements IGrowable
{
    public static final /* synthetic */ PropertyInteger AGE;
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockCrops.AGE });
    }
    
    @Override
    public boolean canUseBonemeal(final World llIlIIlIlIllIII, final Random llIlIIlIlIlIlll, final BlockPos llIlIIlIlIlIllI, final IBlockState llIlIIlIlIlIlIl) {
        return true;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llIlIIlIllIllll, final Random llIlIIlIllIllIl, final int llIlIIlIllIlIll) {
        return ((int)llIlIIlIllIllll.getValue(BlockCrops.AGE) == 7) ? this.getCrop() : this.getSeed();
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World llIlIIllIIIIIIl, final BlockPos llIlIIllIIIlIll, final IBlockState llIlIIlIlllllll, final float llIlIIllIIIlIIl, final int llIlIIlIlllllIl) {
        super.dropBlockAsItemWithChance(llIlIIllIIIIIIl, llIlIIllIIIlIll, llIlIIlIlllllll, llIlIIllIIIlIIl, 0);
        if (!llIlIIllIIIIIIl.isRemote) {
            final int llIlIIllIIIIlll = (int)llIlIIlIlllllll.getValue(BlockCrops.AGE);
            if (llIlIIllIIIIlll >= 7) {
                for (int llIlIIllIIIIlIl = 3 + llIlIIlIlllllIl, llIlIIllIIIIIll = 0; llIlIIllIIIIIll < llIlIIllIIIIlIl; ++llIlIIllIIIIIll) {
                    if (llIlIIllIIIIIIl.rand.nextInt(15) <= llIlIIllIIIIlll) {
                        Block.spawnAsEntity(llIlIIllIIIIIIl, llIlIIllIIIlIll, new ItemStack(this.getSeed(), 1, 0));
                    }
                }
            }
        }
    }
    
    @Override
    public boolean isStillGrowing(final World llIlIIlIlIllllI, final BlockPos llIlIIlIlIlllIl, final IBlockState llIlIIlIlIllIlI, final boolean llIlIIlIlIllIll) {
        return (int)llIlIIlIlIllIlI.getValue(BlockCrops.AGE) < 7;
    }
    
    protected BlockCrops() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockCrops.AGE, 0));
        this.setTickRandomly(true);
        final float llIlIlIIIIIlllI = 0.5f;
        this.setBlockBounds(0.5f - llIlIlIIIIIlllI, 0.0f, 0.5f - llIlIlIIIIIlllI, 0.5f + llIlIlIIIIIlllI, 0.25f, 0.5f + llIlIlIIIIIlllI);
        this.setCreativeTab(null);
        this.setHardness(0.0f);
        this.setStepSound(BlockCrops.soundTypeGrass);
        this.disableStats();
    }
    
    static {
        __OBFID = "CL_00000222";
        AGE = PropertyInteger.create("age", 0, 7);
    }
    
    @Override
    public void grow(final World llIlIIlIlIIllll, final Random llIlIIlIlIIlllI, final BlockPos llIlIIlIlIIllIl, final IBlockState llIlIIlIlIIlIII) {
        this.growCrops(llIlIIlIlIIllll, llIlIIlIlIIllIl, llIlIIlIlIIlIII);
    }
    
    protected Item getCrop() {
        return Items.wheat;
    }
    
    protected Item getSeed() {
        return Items.wheat_seeds;
    }
    
    @Override
    public void updateTick(final World llIlIIllllllIII, final BlockPos llIlIIllllllllI, final IBlockState llIlIIlllllllIl, final Random llIlIIlllllIlIl) {
        super.updateTick(llIlIIllllllIII, llIlIIllllllllI, llIlIIlllllllIl, llIlIIlllllIlIl);
        if (llIlIIllllllIII.getLightFromNeighbors(llIlIIllllllllI.offsetUp()) >= 9) {
            final int llIlIIllllllIll = (int)llIlIIlllllllIl.getValue(BlockCrops.AGE);
            if (llIlIIllllllIll < 7) {
                final float llIlIIllllllIlI = getGrowthChance(this, llIlIIllllllIII, llIlIIllllllllI);
                if (llIlIIlllllIlIl.nextInt((int)(25.0f / llIlIIllllllIlI) + 1) == 0) {
                    llIlIIllllllIII.setBlockState(llIlIIllllllllI, llIlIIlllllllIl.withProperty(BlockCrops.AGE, llIlIIllllllIll + 1), 2);
                }
            }
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState llIlIIlIIlllllI) {
        return (int)llIlIIlIIlllllI.getValue(BlockCrops.AGE);
    }
    
    public void growCrops(final World llIlIIllllIllIl, final BlockPos llIlIIllllIlIII, final IBlockState llIlIIllllIlIll) {
        int llIlIIllllIlIlI = (int)llIlIIllllIlIll.getValue(BlockCrops.AGE) + MathHelper.getRandomIntegerInRange(llIlIIllllIllIl.rand, 2, 5);
        if (llIlIIllllIlIlI > 7) {
            llIlIIllllIlIlI = 7;
        }
        llIlIIllllIllIl.setBlockState(llIlIIllllIlIII, llIlIIllllIlIll.withProperty(BlockCrops.AGE, llIlIIllllIlIlI), 2);
    }
    
    @Override
    protected boolean canPlaceBlockOn(final Block llIlIlIIIIIlIIl) {
        return llIlIlIIIIIlIIl == Blocks.farmland;
    }
    
    @Override
    public Item getItem(final World llIlIIlIllIIIll, final BlockPos llIlIIlIllIIIlI) {
        return this.getSeed();
    }
    
    @Override
    public boolean canBlockStay(final World llIlIIllIllIIll, final BlockPos llIlIIllIllIlll, final IBlockState llIlIIllIllIllI) {
        return (llIlIIllIllIIll.getLight(llIlIIllIllIlll) >= 8 || llIlIIllIllIIll.isAgainstSky(llIlIIllIllIlll)) && this.canPlaceBlockOn(llIlIIllIllIIll.getBlockState(llIlIIllIllIlll.offsetDown()).getBlock());
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llIlIIlIlIIIIlI) {
        return this.getDefaultState().withProperty(BlockCrops.AGE, llIlIIlIlIIIIlI);
    }
    
    protected static float getGrowthChance(final Block llIlIIlllIIlIIl, final World llIlIIlllIIlIII, final BlockPos llIlIIlllIIIlll) {
        float llIlIIlllIlIllI = 1.0f;
        final BlockPos llIlIIlllIlIlIl = llIlIIlllIIIlll.offsetDown();
        for (int llIlIIlllIlIlII = -1; llIlIIlllIlIlII <= 1; ++llIlIIlllIlIlII) {
            for (int llIlIIlllIlIIll = -1; llIlIIlllIlIIll <= 1; ++llIlIIlllIlIIll) {
                float llIlIIlllIlIIlI = 0.0f;
                final IBlockState llIlIIlllIlIIIl = llIlIIlllIIlIII.getBlockState(llIlIIlllIlIlIl.add(llIlIIlllIlIlII, 0, llIlIIlllIlIIll));
                if (llIlIIlllIlIIIl.getBlock() == Blocks.farmland) {
                    llIlIIlllIlIIlI = 1.0f;
                    if ((int)llIlIIlllIlIIIl.getValue(BlockFarmland.field_176531_a) > 0) {
                        llIlIIlllIlIIlI = 3.0f;
                    }
                }
                if (llIlIIlllIlIlII != 0 || llIlIIlllIlIIll != 0) {
                    llIlIIlllIlIIlI /= 4.0f;
                }
                llIlIIlllIlIllI += llIlIIlllIlIIlI;
            }
        }
        final BlockPos llIlIIlllIlIIII = llIlIIlllIIIlll.offsetNorth();
        final BlockPos llIlIIlllIIllll = llIlIIlllIIIlll.offsetSouth();
        final BlockPos llIlIIlllIIlllI = llIlIIlllIIIlll.offsetWest();
        final BlockPos llIlIIlllIIllIl = llIlIIlllIIIlll.offsetEast();
        final boolean llIlIIlllIIllII = llIlIIlllIIlIIl == llIlIIlllIIlIII.getBlockState(llIlIIlllIIlllI).getBlock() || llIlIIlllIIlIIl == llIlIIlllIIlIII.getBlockState(llIlIIlllIIllIl).getBlock();
        final boolean llIlIIlllIIlIll = llIlIIlllIIlIIl == llIlIIlllIIlIII.getBlockState(llIlIIlllIlIIII).getBlock() || llIlIIlllIIlIIl == llIlIIlllIIlIII.getBlockState(llIlIIlllIIllll).getBlock();
        if (llIlIIlllIIllII && llIlIIlllIIlIll) {
            llIlIIlllIlIllI /= 2.0f;
        }
        else {
            final boolean llIlIIlllIIlIlI = llIlIIlllIIlIIl == llIlIIlllIIlIII.getBlockState(llIlIIlllIIlllI.offsetNorth()).getBlock() || llIlIIlllIIlIIl == llIlIIlllIIlIII.getBlockState(llIlIIlllIIllIl.offsetNorth()).getBlock() || llIlIIlllIIlIIl == llIlIIlllIIlIII.getBlockState(llIlIIlllIIllIl.offsetSouth()).getBlock() || llIlIIlllIIlIIl == llIlIIlllIIlIII.getBlockState(llIlIIlllIIlllI.offsetSouth()).getBlock();
            if (llIlIIlllIIlIlI) {
                llIlIIlllIlIllI /= 2.0f;
            }
        }
        return llIlIIlllIlIllI;
    }
}
