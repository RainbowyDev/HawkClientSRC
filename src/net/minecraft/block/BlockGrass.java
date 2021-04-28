package net.minecraft.block;

import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.world.biome.*;
import java.util.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.item.*;

public class BlockGrass extends Block implements IGrowable
{
    public static final /* synthetic */ PropertyBool SNOWY;
    
    @Override
    public IBlockState getActualState(final IBlockState lllllIIIlllIlII, final IBlockAccess lllllIIIlllIIll, final BlockPos lllllIIIlllIIlI) {
        final Block lllllIIIlllIIIl = lllllIIIlllIIll.getBlockState(lllllIIIlllIIlI.offsetUp()).getBlock();
        return lllllIIIlllIlII.withProperty(BlockGrass.SNOWY, lllllIIIlllIIIl == Blocks.snow || lllllIIIlllIIIl == Blocks.snow_layer);
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockGrass.SNOWY });
    }
    
    @Override
    public int colorMultiplier(final IBlockAccess lllllIIIllIIlII, final BlockPos lllllIIIllIIIII, final int lllllIIIllIIIlI) {
        return BiomeColorHelper.func_180286_a(lllllIIIllIIlII, lllllIIIllIIIII);
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllIIIIIlIIll) {
        return 0;
    }
    
    @Override
    public void grow(final World lllllIIIIlIlIll, final Random lllllIIIIlIlIlI, final BlockPos lllllIIIIIlllIl, final IBlockState lllllIIIIlIlIII) {
        final BlockPos lllllIIIIlIIlll = lllllIIIIIlllIl.offsetUp();
        int lllllIIIIlIIllI = 0;
    Label_0252:
        while (lllllIIIIlIIllI < 128) {
            BlockPos lllllIIIIlIIlIl = lllllIIIIlIIlll;
            while (true) {
                for (int lllllIIIIlIIlII = 0; lllllIIIIlIIlII < lllllIIIIlIIllI / 16; ++lllllIIIIlIIlII) {
                    lllllIIIIlIIlIl = lllllIIIIlIIlIl.add(lllllIIIIlIlIlI.nextInt(3) - 1, (lllllIIIIlIlIlI.nextInt(3) - 1) * lllllIIIIlIlIlI.nextInt(3) / 2, lllllIIIIlIlIlI.nextInt(3) - 1);
                    if (lllllIIIIlIlIll.getBlockState(lllllIIIIlIIlIl.offsetDown()).getBlock() != Blocks.grass || lllllIIIIlIlIll.getBlockState(lllllIIIIlIIlIl).getBlock().isNormalCube()) {
                        ++lllllIIIIlIIllI;
                        continue Label_0252;
                    }
                }
                if (lllllIIIIlIlIll.getBlockState(lllllIIIIlIIlIl).getBlock().blockMaterial != Material.air) {
                    continue;
                }
                if (lllllIIIIlIlIlI.nextInt(8) == 0) {
                    final BlockFlower.EnumFlowerType lllllIIIIlIIIll = lllllIIIIlIlIll.getBiomeGenForCoords(lllllIIIIlIIlIl).pickRandomFlower(lllllIIIIlIlIlI, lllllIIIIlIIlIl);
                    final BlockFlower lllllIIIIlIIIlI = lllllIIIIlIIIll.func_176964_a().func_180346_a();
                    final IBlockState lllllIIIIlIIIIl = lllllIIIIlIIIlI.getDefaultState().withProperty(lllllIIIIlIIIlI.func_176494_l(), lllllIIIIlIIIll);
                    if (lllllIIIIlIIIlI.canBlockStay(lllllIIIIlIlIll, lllllIIIIlIIlIl, lllllIIIIlIIIIl)) {
                        lllllIIIIlIlIll.setBlockState(lllllIIIIlIIlIl, lllllIIIIlIIIIl, 3);
                    }
                    continue;
                }
                else {
                    final IBlockState lllllIIIIlIIIII = Blocks.tallgrass.getDefaultState().withProperty(BlockTallGrass.field_176497_a, BlockTallGrass.EnumType.GRASS);
                    if (Blocks.tallgrass.canBlockStay(lllllIIIIlIlIll, lllllIIIIlIIlIl, lllllIIIIlIIIII)) {
                        lllllIIIIlIlIll.setBlockState(lllllIIIIlIIlIl, lllllIIIIlIIIII, 3);
                    }
                    continue;
                }
                break;
            }
        }
    }
    
    protected BlockGrass() {
        super(Material.grass);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockGrass.SNOWY, false));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    public int getBlockColor() {
        return ColorizerGrass.getGrassColor(0.5, 1.0);
    }
    
    @Override
    public boolean canUseBonemeal(final World lllllIIIIlllIlI, final Random lllllIIIIlllIIl, final BlockPos lllllIIIIlllIII, final IBlockState lllllIIIIllIlll) {
        return true;
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT_MIPPED;
    }
    
    @Override
    public void updateTick(final World lllllIIIlIIllll, final BlockPos lllllIIIlIlIllI, final IBlockState lllllIIIlIlIlIl, final Random lllllIIIlIIllIl) {
        if (!lllllIIIlIIllll.isRemote) {
            if (lllllIIIlIIllll.getLightFromNeighbors(lllllIIIlIlIllI.offsetUp()) < 4 && lllllIIIlIIllll.getBlockState(lllllIIIlIlIllI.offsetUp()).getBlock().getLightOpacity() > 2) {
                lllllIIIlIIllll.setBlockState(lllllIIIlIlIllI, Blocks.dirt.getDefaultState());
            }
            else if (lllllIIIlIIllll.getLightFromNeighbors(lllllIIIlIlIllI.offsetUp()) >= 9) {
                for (int lllllIIIlIlIIll = 0; lllllIIIlIlIIll < 4; ++lllllIIIlIlIIll) {
                    final BlockPos lllllIIIlIlIIlI = lllllIIIlIlIllI.add(lllllIIIlIIllIl.nextInt(3) - 1, lllllIIIlIIllIl.nextInt(5) - 3, lllllIIIlIIllIl.nextInt(3) - 1);
                    final Block lllllIIIlIlIIIl = lllllIIIlIIllll.getBlockState(lllllIIIlIlIIlI.offsetUp()).getBlock();
                    final IBlockState lllllIIIlIlIIII = lllllIIIlIIllll.getBlockState(lllllIIIlIlIIlI);
                    if (lllllIIIlIlIIII.getBlock() == Blocks.dirt && lllllIIIlIlIIII.getValue(BlockDirt.VARIANT) == BlockDirt.DirtType.DIRT && lllllIIIlIIllll.getLightFromNeighbors(lllllIIIlIlIIlI.offsetUp()) >= 4 && lllllIIIlIlIIIl.getLightOpacity() <= 2) {
                        lllllIIIlIIllll.setBlockState(lllllIIIlIlIIlI, Blocks.grass.getDefaultState());
                    }
                }
            }
        }
    }
    
    static {
        __OBFID = "CL_00000251";
        SNOWY = PropertyBool.create("snowy");
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllIIIlIIIlIl, final Random lllllIIIlIIIlII, final int lllllIIIlIIIIll) {
        return Blocks.dirt.getItemDropped(Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT), lllllIIIlIIIlII, lllllIIIlIIIIll);
    }
    
    @Override
    public int getRenderColor(final IBlockState lllllIIIllIlIIl) {
        return this.getBlockColor();
    }
    
    @Override
    public boolean isStillGrowing(final World lllllIIIIllllll, final BlockPos lllllIIIIlllllI, final IBlockState lllllIIIIllllIl, final boolean lllllIIIIllllII) {
        return true;
    }
}
