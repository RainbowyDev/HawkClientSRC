package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.creativetab.*;
import net.minecraft.init.*;
import net.minecraft.item.*;

public class BlockNetherWart extends BlockBush
{
    public static final /* synthetic */ PropertyInteger AGE_PROP;
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockNetherWart.AGE_PROP });
    }
    
    @Override
    public Item getItemDropped(final IBlockState llIlIIIlIlIllI, final Random llIlIIIlIlIlIl, final int llIlIIIlIlIIll) {
        return null;
    }
    
    @Override
    public Item getItem(final World llIlIIIlIIlIll, final BlockPos llIlIIIlIIlIlI) {
        return Items.nether_wart;
    }
    
    protected BlockNetherWart() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockNetherWart.AGE_PROP, 0));
        this.setTickRandomly(true);
        final float llIlIIlIIlllll = 0.5f;
        this.setBlockBounds(0.5f - llIlIIlIIlllll, 0.0f, 0.5f - llIlIIlIIlllll, 0.5f + llIlIIlIIlllll, 0.25f, 0.5f + llIlIIlIIlllll);
        this.setCreativeTab(null);
    }
    
    @Override
    public int quantityDropped(final Random llIlIIIlIIllll) {
        return 0;
    }
    
    @Override
    protected boolean canPlaceBlockOn(final Block llIlIIlIIllIlI) {
        return llIlIIlIIllIlI == Blocks.soul_sand;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llIlIIIIlllIII) {
        return (int)llIlIIIIlllIII.getValue(BlockNetherWart.AGE_PROP);
    }
    
    @Override
    public boolean canBlockStay(final World llIlIIlIIlIlII, final BlockPos llIlIIlIIIllll, final IBlockState llIlIIlIIlIIlI) {
        return this.canPlaceBlockOn(llIlIIlIIlIlII.getBlockState(llIlIIlIIIllll.offsetDown()).getBlock());
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llIlIIIlIIIIll) {
        return this.getDefaultState().withProperty(BlockNetherWart.AGE_PROP, llIlIIIlIIIIll);
    }
    
    @Override
    public void updateTick(final World llIlIIlIIIIlll, final BlockPos llIlIIlIIIIllI, IBlockState llIlIIIlllllll, final Random llIlIIlIIIIlII) {
        final int llIlIIlIIIIIll = (int)((IBlockState)llIlIIIlllllll).getValue(BlockNetherWart.AGE_PROP);
        if (llIlIIlIIIIIll < 3 && llIlIIlIIIIlII.nextInt(10) == 0) {
            llIlIIIlllllll = ((IBlockState)llIlIIIlllllll).withProperty(BlockNetherWart.AGE_PROP, llIlIIlIIIIIll + 1);
            llIlIIlIIIIlll.setBlockState(llIlIIlIIIIllI, (IBlockState)llIlIIIlllllll, 2);
        }
        super.updateTick(llIlIIlIIIIlll, llIlIIlIIIIllI, (IBlockState)llIlIIIlllllll, llIlIIlIIIIlII);
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World llIlIIIllIIIII, final BlockPos llIlIIIlIlllll, final IBlockState llIlIIIllIlIlI, final float llIlIIIllIlIII, final int llIlIIIlIlllIl) {
        if (!llIlIIIllIIIII.isRemote) {
            int llIlIIIllIIlII = 1;
            if ((int)llIlIIIllIlIlI.getValue(BlockNetherWart.AGE_PROP) >= 3) {
                llIlIIIllIIlII = 2 + llIlIIIllIIIII.rand.nextInt(3);
                if (llIlIIIlIlllIl > 0) {
                    llIlIIIllIIlII += llIlIIIllIIIII.rand.nextInt(llIlIIIlIlllIl + 1);
                }
            }
            for (int llIlIIIllIIIlI = 0; llIlIIIllIIIlI < llIlIIIllIIlII; ++llIlIIIllIIIlI) {
                Block.spawnAsEntity(llIlIIIllIIIII, llIlIIIlIlllll, new ItemStack(Items.nether_wart));
            }
        }
    }
    
    static {
        __OBFID = "CL_00000274";
        AGE_PROP = PropertyInteger.create("age", 0, 3);
    }
}
