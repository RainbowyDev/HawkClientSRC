package net.minecraft.block;

import net.minecraft.block.state.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import java.util.*;
import net.minecraft.creativetab.*;
import com.google.common.collect.*;

public class BlockRedstoneTorch extends BlockTorch
{
    private final /* synthetic */ boolean field_150113_a;
    private static /* synthetic */ Map field_150112_b;
    
    @Override
    public int isProvidingWeakPower(final IBlockAccess lllllllllllllllllIllIIlIIlIIlllI, final BlockPos lllllllllllllllllIllIIlIIlIIllIl, final IBlockState lllllllllllllllllIllIIlIIlIIlIIl, final EnumFacing lllllllllllllllllIllIIlIIlIIlIII) {
        return (this.field_150113_a && lllllllllllllllllIllIIlIIlIIlIIl.getValue(BlockRedstoneTorch.FACING_PROP) != lllllllllllllllllIllIIlIIlIIlIII) ? 15 : 0;
    }
    
    @Override
    public int isProvidingStrongPower(final IBlockAccess lllllllllllllllllIllIIIlllllllII, final BlockPos lllllllllllllllllIllIIlIIIIIIIII, final IBlockState lllllllllllllllllIllIIIllllllIlI, final EnumFacing lllllllllllllllllIllIIIllllllllI) {
        return (lllllllllllllllllIllIIIllllllllI == EnumFacing.DOWN) ? this.isProvidingWeakPower(lllllllllllllllllIllIIIlllllllII, lllllllllllllllllIllIIlIIIIIIIII, lllllllllllllllllIllIIIllllllIlI, lllllllllllllllllIllIIIllllllllI) : 0;
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllllllllIllIIlIIlllIllI, final BlockPos lllllllllllllllllIllIIlIIlllIlIl, final IBlockState lllllllllllllllllIllIIlIIlllIlII) {
        if (this.field_150113_a) {
            for (final EnumFacing lllllllllllllllllIllIIlIIlllIIII : EnumFacing.values()) {
                lllllllllllllllllIllIIlIIlllIllI.notifyNeighborsOfStateChange(lllllllllllllllllIllIIlIIlllIlIl.offset(lllllllllllllllllIllIIlIIlllIIII), this);
            }
        }
    }
    
    @Override
    public void randomDisplayTick(final World lllllllllllllllllIllIIIlllIlllII, final BlockPos lllllllllllllllllIllIIIllllIIllI, final IBlockState lllllllllllllllllIllIIIllllIIlIl, final Random lllllllllllllllllIllIIIllllIIlII) {
        if (this.field_150113_a) {
            double lllllllllllllllllIllIIIllllIIIll = lllllllllllllllllIllIIIllllIIllI.getX() + 0.5f + (lllllllllllllllllIllIIIllllIIlII.nextFloat() - 0.5f) * 0.2;
            double lllllllllllllllllIllIIIllllIIIlI = lllllllllllllllllIllIIIllllIIllI.getY() + 0.7f + (lllllllllllllllllIllIIIllllIIlII.nextFloat() - 0.5f) * 0.2;
            double lllllllllllllllllIllIIIllllIIIIl = lllllllllllllllllIllIIIllllIIllI.getZ() + 0.5f + (lllllllllllllllllIllIIIllllIIlII.nextFloat() - 0.5f) * 0.2;
            final EnumFacing lllllllllllllllllIllIIIllllIIIII = (EnumFacing)lllllllllllllllllIllIIIllllIIlIl.getValue(BlockRedstoneTorch.FACING_PROP);
            if (lllllllllllllllllIllIIIllllIIIII.getAxis().isHorizontal()) {
                final EnumFacing lllllllllllllllllIllIIIlllIlllll = lllllllllllllllllIllIIIllllIIIII.getOpposite();
                final double lllllllllllllllllIllIIIlllIllllI = 0.27000001072883606;
                lllllllllllllllllIllIIIllllIIIll += 0.27000001072883606 * lllllllllllllllllIllIIIlllIlllll.getFrontOffsetX();
                lllllllllllllllllIllIIIllllIIIlI += 0.2199999988079071;
                lllllllllllllllllIllIIIllllIIIIl += 0.27000001072883606 * lllllllllllllllllIllIIIlllIlllll.getFrontOffsetZ();
            }
            lllllllllllllllllIllIIIlllIlllII.spawnParticle(EnumParticleTypes.REDSTONE, lllllllllllllllllIllIIIllllIIIll, lllllllllllllllllIllIIIllllIIIlI, lllllllllllllllllIllIIIllllIIIIl, 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    @Override
    public void onNeighborBlockChange(final World lllllllllllllllllIllIIlIIIIIlIlI, final BlockPos lllllllllllllllllIllIIlIIIIIlIIl, final IBlockState lllllllllllllllllIllIIlIIIIIlIII, final Block lllllllllllllllllIllIIlIIIIIllII) {
        if (!this.func_176592_e(lllllllllllllllllIllIIlIIIIIlIlI, lllllllllllllllllIllIIlIIIIIlIIl, lllllllllllllllllIllIIlIIIIIlIII) && this.field_150113_a == this.func_176597_g(lllllllllllllllllIllIIlIIIIIlIlI, lllllllllllllllllIllIIlIIIIIlIIl, lllllllllllllllllIllIIlIIIIIlIII)) {
            lllllllllllllllllIllIIlIIIIIlIlI.scheduleUpdate(lllllllllllllllllIllIIlIIIIIlIIl, this, this.tickRate(lllllllllllllllllIllIIlIIIIIlIlI));
        }
    }
    
    @Override
    public void randomTick(final World lllllllllllllllllIllIIlIIIlllIIl, final BlockPos lllllllllllllllllIllIIlIIIlllIII, final IBlockState lllllllllllllllllIllIIlIIIllIlll, final Random lllllllllllllllllIllIIlIIIllIllI) {
    }
    
    @Override
    public boolean isAssociatedBlock(final Block lllllllllllllllllIllIIIlllIIllIl) {
        return lllllllllllllllllIllIIIlllIIllIl == Blocks.unlit_redstone_torch || lllllllllllllllllIllIIIlllIIllIl == Blocks.redstone_torch;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllllllIllIIIlllllIlll, final Random lllllllllllllllllIllIIIlllllIllI, final int lllllllllllllllllIllIIIlllllIlIl) {
        return Item.getItemFromBlock(Blocks.redstone_torch);
    }
    
    @Override
    public boolean canProvidePower() {
        return true;
    }
    
    private boolean func_176597_g(final World lllllllllllllllllIllIIlIIIlllllI, final BlockPos lllllllllllllllllIllIIlIIlIIIIIl, final IBlockState lllllllllllllllllIllIIlIIIllllII) {
        final EnumFacing lllllllllllllllllIllIIlIIIllllll = ((EnumFacing)lllllllllllllllllIllIIlIIIllllII.getValue(BlockRedstoneTorch.FACING_PROP)).getOpposite();
        return lllllllllllllllllIllIIlIIIlllllI.func_175709_b(lllllllllllllllllIllIIlIIlIIIIIl.offset(lllllllllllllllllIllIIlIIIllllll), lllllllllllllllllIllIIlIIIllllll);
    }
    
    @Override
    public void updateTick(final World lllllllllllllllllIllIIlIIIlIlIIl, final BlockPos lllllllllllllllllIllIIlIIIIlllIl, final IBlockState lllllllllllllllllIllIIlIIIlIIlll, final Random lllllllllllllllllIllIIlIIIIllIll) {
        final boolean lllllllllllllllllIllIIlIIIlIIlIl = this.func_176597_g(lllllllllllllllllIllIIlIIIlIlIIl, lllllllllllllllllIllIIlIIIIlllIl, lllllllllllllllllIllIIlIIIlIIlll);
        final List lllllllllllllllllIllIIlIIIlIIlII = BlockRedstoneTorch.field_150112_b.get(lllllllllllllllllIllIIlIIIlIlIIl);
        while (lllllllllllllllllIllIIlIIIlIIlII != null && !lllllllllllllllllIllIIlIIIlIIlII.isEmpty() && lllllllllllllllllIllIIlIIIlIlIIl.getTotalWorldTime() - lllllllllllllllllIllIIlIIIlIIlII.get(0).field_150844_d > 60L) {
            lllllllllllllllllIllIIlIIIlIIlII.remove(0);
        }
        if (this.field_150113_a) {
            if (lllllllllllllllllIllIIlIIIlIIlIl) {
                lllllllllllllllllIllIIlIIIlIlIIl.setBlockState(lllllllllllllllllIllIIlIIIIlllIl, Blocks.unlit_redstone_torch.getDefaultState().withProperty(BlockRedstoneTorch.FACING_PROP, lllllllllllllllllIllIIlIIIlIIlll.getValue(BlockRedstoneTorch.FACING_PROP)), 3);
                if (this.func_176598_a(lllllllllllllllllIllIIlIIIlIlIIl, lllllllllllllllllIllIIlIIIIlllIl, true)) {
                    lllllllllllllllllIllIIlIIIlIlIIl.playSoundEffect(lllllllllllllllllIllIIlIIIIlllIl.getX() + 0.5f, lllllllllllllllllIllIIlIIIIlllIl.getY() + 0.5f, lllllllllllllllllIllIIlIIIIlllIl.getZ() + 0.5f, "random.fizz", 0.5f, 2.6f + (lllllllllllllllllIllIIlIIIlIlIIl.rand.nextFloat() - lllllllllllllllllIllIIlIIIlIlIIl.rand.nextFloat()) * 0.8f);
                    for (int lllllllllllllllllIllIIlIIIlIIIll = 0; lllllllllllllllllIllIIlIIIlIIIll < 5; ++lllllllllllllllllIllIIlIIIlIIIll) {
                        final double lllllllllllllllllIllIIlIIIlIIIlI = lllllllllllllllllIllIIlIIIIlllIl.getX() + lllllllllllllllllIllIIlIIIIllIll.nextDouble() * 0.6 + 0.2;
                        final double lllllllllllllllllIllIIlIIIlIIIIl = lllllllllllllllllIllIIlIIIIlllIl.getY() + lllllllllllllllllIllIIlIIIIllIll.nextDouble() * 0.6 + 0.2;
                        final double lllllllllllllllllIllIIlIIIlIIIII = lllllllllllllllllIllIIlIIIIlllIl.getZ() + lllllllllllllllllIllIIlIIIIllIll.nextDouble() * 0.6 + 0.2;
                        lllllllllllllllllIllIIlIIIlIlIIl.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, lllllllllllllllllIllIIlIIIlIIIlI, lllllllllllllllllIllIIlIIIlIIIIl, lllllllllllllllllIllIIlIIIlIIIII, 0.0, 0.0, 0.0, new int[0]);
                    }
                    lllllllllllllllllIllIIlIIIlIlIIl.scheduleUpdate(lllllllllllllllllIllIIlIIIIlllIl, lllllllllllllllllIllIIlIIIlIlIIl.getBlockState(lllllllllllllllllIllIIlIIIIlllIl).getBlock(), 160);
                }
            }
        }
        else if (!lllllllllllllllllIllIIlIIIlIIlIl && !this.func_176598_a(lllllllllllllllllIllIIlIIIlIlIIl, lllllllllllllllllIllIIlIIIIlllIl, false)) {
            lllllllllllllllllIllIIlIIIlIlIIl.setBlockState(lllllllllllllllllIllIIlIIIIlllIl, Blocks.redstone_torch.getDefaultState().withProperty(BlockRedstoneTorch.FACING_PROP, lllllllllllllllllIllIIlIIIlIIlll.getValue(BlockRedstoneTorch.FACING_PROP)), 3);
        }
    }
    
    static {
        __OBFID = "CL_00000298";
        BlockRedstoneTorch.field_150112_b = Maps.newHashMap();
    }
    
    protected BlockRedstoneTorch(final boolean lllllllllllllllllIllIIlIlIIIIIIl) {
        this.field_150113_a = lllllllllllllllllIllIIlIlIIIIIIl;
        this.setTickRandomly(true);
        this.setCreativeTab(null);
    }
    
    @Override
    public Item getItem(final World lllllllllllllllllIllIIIlllIlIIIl, final BlockPos lllllllllllllllllIllIIIlllIlIIII) {
        return Item.getItemFromBlock(Blocks.redstone_torch);
    }
    
    @Override
    public int tickRate(final World lllllllllllllllllIllIIlIIlllllll) {
        return 2;
    }
    
    private boolean func_176598_a(final World lllllllllllllllllIllIIlIlIlIIIIl, final BlockPos lllllllllllllllllIllIIlIlIlIIIII, final boolean lllllllllllllllllIllIIlIlIIlIIIl) {
        if (!BlockRedstoneTorch.field_150112_b.containsKey(lllllllllllllllllIllIIlIlIlIIIIl)) {
            BlockRedstoneTorch.field_150112_b.put(lllllllllllllllllIllIIlIlIlIIIIl, Lists.newArrayList());
        }
        final List lllllllllllllllllIllIIlIlIIlllIl = BlockRedstoneTorch.field_150112_b.get(lllllllllllllllllIllIIlIlIlIIIIl);
        if (lllllllllllllllllIllIIlIlIIlIIIl) {
            lllllllllllllllllIllIIlIlIIlllIl.add(new Toggle(lllllllllllllllllIllIIlIlIlIIIII, lllllllllllllllllIllIIlIlIlIIIIl.getTotalWorldTime()));
        }
        int lllllllllllllllllIllIIlIlIIllIll = 0;
        for (int lllllllllllllllllIllIIlIlIIllIIl = 0; lllllllllllllllllIllIIlIlIIllIIl < lllllllllllllllllIllIIlIlIIlllIl.size(); ++lllllllllllllllllIllIIlIlIIllIIl) {
            final Toggle lllllllllllllllllIllIIlIlIIlIlll = lllllllllllllllllIllIIlIlIIlllIl.get(lllllllllllllllllIllIIlIlIIllIIl);
            if (lllllllllllllllllIllIIlIlIIlIlll.field_180111_a.equals(lllllllllllllllllIllIIlIlIlIIIII) && ++lllllllllllllllllIllIIlIlIIllIll >= 8) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void breakBlock(final World lllllllllllllllllIllIIlIIllIIIII, final BlockPos lllllllllllllllllIllIIlIIlIlllll, final IBlockState lllllllllllllllllIllIIlIIlIllllI) {
        if (this.field_150113_a) {
            for (final EnumFacing lllllllllllllllllIllIIlIIlIllIlI : EnumFacing.values()) {
                lllllllllllllllllIllIIlIIllIIIII.notifyNeighborsOfStateChange(lllllllllllllllllIllIIlIIlIlllll.offset(lllllllllllllllllIllIIlIIlIllIlI), this);
            }
        }
    }
    
    static class Toggle
    {
        /* synthetic */ BlockPos field_180111_a;
        /* synthetic */ long field_150844_d;
        
        public Toggle(final BlockPos llllllllllllllIlIlIIlIIIIIIlIIlI, final long llllllllllllllIlIlIIlIIIIIIlIlII) {
            this.field_180111_a = llllllllllllllIlIlIIlIIIIIIlIIlI;
            this.field_150844_d = llllllllllllllIlIlIIlIIIIIIlIlII;
        }
        
        static {
            __OBFID = "CL_00000299";
        }
    }
}
