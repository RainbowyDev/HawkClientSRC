package net.minecraft.block;

import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.util.*;

public class BlockMycelium extends Block
{
    public static final /* synthetic */ PropertyBool SNOWY_PROP;
    
    @Override
    public IBlockState getActualState(final IBlockState llllllllllllllIlIlIIllIIlIIlIIIl, final IBlockAccess llllllllllllllIlIlIIllIIlIIlIlII, final BlockPos llllllllllllllIlIlIIllIIlIIlIIll) {
        final Block llllllllllllllIlIlIIllIIlIIlIIlI = llllllllllllllIlIlIIllIIlIIlIlII.getBlockState(llllllllllllllIlIlIIllIIlIIlIIll.offsetUp()).getBlock();
        return llllllllllllllIlIlIIllIIlIIlIIIl.withProperty(BlockMycelium.SNOWY_PROP, llllllllllllllIlIlIIllIIlIIlIIlI == Blocks.snow || llllllllllllllIlIlIIllIIlIIlIIlI == Blocks.snow_layer);
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIlIlIIllIIIllIIIlI, final Random llllllllllllllIlIlIIllIIIlIlllll, final int llllllllllllllIlIlIIllIIIlIllllI) {
        return Blocks.dirt.getItemDropped(Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT), llllllllllllllIlIlIIllIIIlIlllll, llllllllllllllIlIlIIllIIIlIllllI);
    }
    
    protected BlockMycelium() {
        super(Material.grass);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockMycelium.SNOWY_PROP, false));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockMycelium.SNOWY_PROP });
    }
    
    @Override
    public void randomDisplayTick(final World llllllllllllllIlIlIIllIIIllIlllI, final BlockPos llllllllllllllIlIlIIllIIIllIllIl, final IBlockState llllllllllllllIlIlIIllIIIllIllII, final Random llllllllllllllIlIlIIllIIIllIlIll) {
        super.randomDisplayTick(llllllllllllllIlIlIIllIIIllIlllI, llllllllllllllIlIlIIllIIIllIllIl, llllllllllllllIlIlIIllIIIllIllII, llllllllllllllIlIlIIllIIIllIlIll);
        if (llllllllllllllIlIlIIllIIIllIlIll.nextInt(10) == 0) {
            llllllllllllllIlIlIIllIIIllIlllI.spawnParticle(EnumParticleTypes.TOWN_AURA, llllllllllllllIlIlIIllIIIllIllIl.getX() + llllllllllllllIlIlIIllIIIllIlIll.nextFloat(), llllllllllllllIlIlIIllIIIllIllIl.getY() + 1.1f, llllllllllllllIlIlIIllIIIllIllIl.getZ() + llllllllllllllIlIlIIllIIIllIlIll.nextFloat(), 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    @Override
    public void updateTick(final World llllllllllllllIlIlIIllIIlIIIIlII, final BlockPos llllllllllllllIlIlIIllIIlIIIIIll, final IBlockState llllllllllllllIlIlIIllIIlIIIIIlI, final Random llllllllllllllIlIlIIllIIIllllIIl) {
        if (!llllllllllllllIlIlIIllIIlIIIIlII.isRemote) {
            if (llllllllllllllIlIlIIllIIlIIIIlII.getLightFromNeighbors(llllllllllllllIlIlIIllIIlIIIIIll.offsetUp()) < 4 && llllllllllllllIlIlIIllIIlIIIIlII.getBlockState(llllllllllllllIlIlIIllIIlIIIIIll.offsetUp()).getBlock().getLightOpacity() > 2) {
                llllllllllllllIlIlIIllIIlIIIIlII.setBlockState(llllllllllllllIlIlIIllIIlIIIIIll, Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT));
            }
            else if (llllllllllllllIlIlIIllIIlIIIIlII.getLightFromNeighbors(llllllllllllllIlIlIIllIIlIIIIIll.offsetUp()) >= 9) {
                for (int llllllllllllllIlIlIIllIIlIIIIIII = 0; llllllllllllllIlIlIIllIIlIIIIIII < 4; ++llllllllllllllIlIlIIllIIlIIIIIII) {
                    final BlockPos llllllllllllllIlIlIIllIIIlllllll = llllllllllllllIlIlIIllIIlIIIIIll.add(llllllllllllllIlIlIIllIIIllllIIl.nextInt(3) - 1, llllllllllllllIlIlIIllIIIllllIIl.nextInt(5) - 3, llllllllllllllIlIlIIllIIIllllIIl.nextInt(3) - 1);
                    final IBlockState llllllllllllllIlIlIIllIIIllllllI = llllllllllllllIlIlIIllIIlIIIIlII.getBlockState(llllllllllllllIlIlIIllIIIlllllll);
                    final Block llllllllllllllIlIlIIllIIIlllllIl = llllllllllllllIlIlIIllIIlIIIIlII.getBlockState(llllllllllllllIlIlIIllIIIlllllll.offsetUp()).getBlock();
                    if (llllllllllllllIlIlIIllIIIllllllI.getBlock() == Blocks.dirt && llllllllllllllIlIlIIllIIIllllllI.getValue(BlockDirt.VARIANT) == BlockDirt.DirtType.DIRT && llllllllllllllIlIlIIllIIlIIIIlII.getLightFromNeighbors(llllllllllllllIlIlIIllIIIlllllll.offsetUp()) >= 4 && llllllllllllllIlIlIIllIIIlllllIl.getLightOpacity() <= 2) {
                        llllllllllllllIlIlIIllIIlIIIIlII.setBlockState(llllllllllllllIlIlIIllIIIlllllll, this.getDefaultState());
                    }
                }
            }
        }
    }
    
    static {
        __OBFID = "CL_00000273";
        SNOWY_PROP = PropertyBool.create("snowy");
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIlIlIIllIIIlIlllII) {
        return 0;
    }
}
