package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import com.google.common.collect.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.block.state.*;

public class BlockSponge extends Block
{
    public static final /* synthetic */ PropertyBool WET_PROP;
    
    @Override
    public int getMetaFromState(final IBlockState lIIIlllllIIlI) {
        return ((boolean)lIIIlllllIIlI.getValue(BlockSponge.WET_PROP)) ? 1 : 0;
    }
    
    @Override
    public void onNeighborBlockChange(final World lIIlIIIllllIl, final BlockPos lIIlIIlIIIIIl, final IBlockState lIIlIIlIIIIII, final Block lIIlIIIlllIlI) {
        this.setWet(lIIlIIIllllIl, lIIlIIlIIIIIl, lIIlIIlIIIIII);
        super.onNeighborBlockChange(lIIlIIIllllIl, lIIlIIlIIIIIl, lIIlIIlIIIIII, lIIlIIIlllIlI);
    }
    
    protected void setWet(final World lIIlIIIllIIII, final BlockPos lIIlIIIllIIll, final IBlockState lIIlIIIlIlllI) {
        if (!(boolean)lIIlIIIlIlllI.getValue(BlockSponge.WET_PROP) && this.absorbWater(lIIlIIIllIIII, lIIlIIIllIIll)) {
            lIIlIIIllIIII.setBlockState(lIIlIIIllIIll, lIIlIIIlIlllI.withProperty(BlockSponge.WET_PROP, true), 2);
            lIIlIIIllIIII.playAuxSFX(2001, lIIlIIIllIIll, Block.getIdFromBlock(Blocks.water));
        }
    }
    
    @Override
    public void randomDisplayTick(final World lIIIllllIIlIl, final BlockPos lIIIlllIlllII, final IBlockState lIIIlllIllIll, final Random lIIIlllIllIlI) {
        if (lIIIlllIllIll.getValue(BlockSponge.WET_PROP)) {
            final EnumFacing lIIIllllIIIIl = EnumFacing.random(lIIIlllIllIlI);
            if (lIIIllllIIIIl != EnumFacing.UP && !World.doesBlockHaveSolidTopSurface(lIIIllllIIlIl, lIIIlllIlllII.offset(lIIIllllIIIIl))) {
                double lIIIllllIIIII = lIIIlllIlllII.getX();
                double lIIIlllIlllll = lIIIlllIlllII.getY();
                double lIIIlllIllllI = lIIIlllIlllII.getZ();
                if (lIIIllllIIIIl == EnumFacing.DOWN) {
                    lIIIlllIlllll -= 0.05;
                    lIIIllllIIIII += lIIIlllIllIlI.nextDouble();
                    lIIIlllIllllI += lIIIlllIllIlI.nextDouble();
                }
                else {
                    lIIIlllIlllll += lIIIlllIllIlI.nextDouble() * 0.8;
                    if (lIIIllllIIIIl.getAxis() == EnumFacing.Axis.X) {
                        lIIIlllIllllI += lIIIlllIllIlI.nextDouble();
                        if (lIIIllllIIIIl == EnumFacing.EAST) {
                            ++lIIIllllIIIII;
                        }
                        else {
                            lIIIllllIIIII += 0.05;
                        }
                    }
                    else {
                        lIIIllllIIIII += lIIIlllIllIlI.nextDouble();
                        if (lIIIllllIIIIl == EnumFacing.SOUTH) {
                            ++lIIIlllIllllI;
                        }
                        else {
                            lIIIlllIllllI += 0.05;
                        }
                    }
                }
                lIIIllllIIlIl.spawnParticle(EnumParticleTypes.DRIP_WATER, lIIIllllIIIII, lIIIlllIlllll, lIIIlllIllllI, 0.0, 0.0, 0.0, new int[0]);
            }
        }
    }
    
    private boolean absorbWater(final World lIIlIIIIlllll, final BlockPos lIIlIIIIllllI) {
        final LinkedList lIIlIIIIlllIl = Lists.newLinkedList();
        final ArrayList lIIlIIIIlllII = Lists.newArrayList();
        lIIlIIIIlllIl.add(new Tuple(lIIlIIIIllllI, 0));
        int lIIlIIIIllIll = 0;
        while (!lIIlIIIIlllIl.isEmpty()) {
            final Tuple lIIlIIIIllIII = lIIlIIIIlllIl.poll();
            final BlockPos lIIlIIIIllIlI = (BlockPos)lIIlIIIIllIII.getFirst();
            final int lIIlIIIIlIlll = (int)lIIlIIIIllIII.getSecond();
            for (final EnumFacing lIIlIIIIlIIll : EnumFacing.values()) {
                final BlockPos lIIlIIIIlIIlI = lIIlIIIIllIlI.offset(lIIlIIIIlIIll);
                if (lIIlIIIIlllll.getBlockState(lIIlIIIIlIIlI).getBlock().getMaterial() == Material.water) {
                    lIIlIIIIlllll.setBlockState(lIIlIIIIlIIlI, Blocks.air.getDefaultState(), 2);
                    lIIlIIIIlllII.add(lIIlIIIIlIIlI);
                    ++lIIlIIIIllIll;
                    if (lIIlIIIIlIlll < 6) {
                        lIIlIIIIlllIl.add(new Tuple(lIIlIIIIlIIlI, lIIlIIIIlIlll + 1));
                    }
                }
            }
            if (lIIlIIIIllIll > 64) {
                break;
            }
        }
        for (final BlockPos lIIlIIIIllIIl : lIIlIIIIlllII) {
            lIIlIIIIlllll.notifyNeighborsOfStateChange(lIIlIIIIllIIl, Blocks.air);
        }
        return lIIlIIIIllIll > 0;
    }
    
    @Override
    public void getSubBlocks(final Item lIIIlllllllIl, final CreativeTabs lIIIlllllllll, final List lIIIlllllllII) {
        lIIIlllllllII.add(new ItemStack(lIIIlllllllIl, 1, 0));
        lIIIlllllllII.add(new ItemStack(lIIIlllllllIl, 1, 1));
    }
    
    static {
        __OBFID = "CL_00000311";
        WET_PROP = PropertyBool.create("wet");
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockSponge.WET_PROP });
    }
    
    protected BlockSponge() {
        super(Material.sponge);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockSponge.WET_PROP, false));
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    public void onBlockAdded(final World lIIlIIlIIllll, final BlockPos lIIlIIlIIlllI, final IBlockState lIIlIIlIIlIIl) {
        this.setWet(lIIlIIlIIllll, lIIlIIlIIlllI, lIIlIIlIIlIIl);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lIIIllllllIII) {
        return this.getDefaultState().withProperty(BlockSponge.WET_PROP, (lIIIllllllIII & 0x1) == 0x1);
    }
    
    @Override
    public int damageDropped(final IBlockState lIIlIIlIlIllI) {
        return ((boolean)lIIlIIlIlIllI.getValue(BlockSponge.WET_PROP)) ? 1 : 0;
    }
}
