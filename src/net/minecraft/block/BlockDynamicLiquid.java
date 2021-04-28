package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.block.properties.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import java.util.*;

public class BlockDynamicLiquid extends BlockLiquid
{
    /* synthetic */ int field_149815_a;
    
    protected int func_176371_a(final World llllllllllllllIIIlllIlIlIllllIIl, final BlockPos llllllllllllllIIIlllIlIlIllIllIl, final int llllllllllllllIIIlllIlIlIlllIlIl) {
        int llllllllllllllIIIlllIlIlIlllIIll = this.func_176362_e(llllllllllllllIIIlllIlIlIllllIIl, llllllllllllllIIIlllIlIlIllIllIl);
        if (llllllllllllllIIIlllIlIlIlllIIll < 0) {
            return llllllllllllllIIIlllIlIlIlllIlIl;
        }
        if (llllllllllllllIIIlllIlIlIlllIIll == 0) {
            ++this.field_149815_a;
        }
        if (llllllllllllllIIIlllIlIlIlllIIll >= 8) {
            llllllllllllllIIIlllIlIlIlllIIll = 0;
        }
        return (llllllllllllllIIIlllIlIlIlllIlIl >= 0 && llllllllllllllIIIlllIlIlIlllIIll >= llllllllllllllIIIlllIlIlIlllIlIl) ? llllllllllllllIIIlllIlIlIlllIlIl : llllllllllllllIIIlllIlIlIlllIIll;
    }
    
    protected BlockDynamicLiquid(final Material llllllllllllllIIIlllIllIIlIIlIII) {
        super(llllllllllllllIIIlllIllIIlIIlIII);
    }
    
    private void func_180690_f(final World llllllllllllllIIIlllIllIIlIIIIII, final BlockPos llllllllllllllIIIlllIllIIIllllll, final IBlockState llllllllllllllIIIlllIllIIIlllllI) {
        llllllllllllllIIIlllIllIIlIIIIII.setBlockState(llllllllllllllIIIlllIllIIIllllll, BlockLiquid.getStaticLiquidForMaterial(this.blockMaterial).getDefaultState().withProperty(BlockDynamicLiquid.LEVEL, llllllllllllllIIIlllIllIIIlllllI.getValue(BlockDynamicLiquid.LEVEL)), 2);
    }
    
    private void func_176375_a(final World llllllllllllllIIIlllIlIlllIllIll, final BlockPos llllllllllllllIIIlllIlIlllIllIlI, final IBlockState llllllllllllllIIIlllIlIlllIllIIl, final int llllllllllllllIIIlllIlIlllIllIII) {
        if (this.func_176373_h(llllllllllllllIIIlllIlIlllIllIll, llllllllllllllIIIlllIlIlllIllIlI, llllllllllllllIIIlllIlIlllIllIIl)) {
            if (llllllllllllllIIIlllIlIlllIllIIl.getBlock() != Blocks.air) {
                if (this.blockMaterial == Material.lava) {
                    this.func_180688_d(llllllllllllllIIIlllIlIlllIllIll, llllllllllllllIIIlllIlIlllIllIlI);
                }
                else {
                    llllllllllllllIIIlllIlIlllIllIIl.getBlock().dropBlockAsItem(llllllllllllllIIIlllIlIlllIllIll, llllllllllllllIIIlllIlIlllIllIlI, llllllllllllllIIIlllIlIlllIllIIl, 0);
                }
            }
            llllllllllllllIIIlllIlIlllIllIll.setBlockState(llllllllllllllIIIlllIlIlllIllIlI, this.getDefaultState().withProperty(BlockDynamicLiquid.LEVEL, llllllllllllllIIIlllIlIlllIllIII), 3);
        }
    }
    
    @Override
    public void updateTick(final World llllllllllllllIIIlllIllIIIlIIlII, final BlockPos llllllllllllllIIIlllIllIIIlIIIlI, IBlockState llllllllllllllIIIlllIllIIIIIIIll, final Random llllllllllllllIIIlllIllIIIIIIIlI) {
        int llllllllllllllIIIlllIllIIIIlllII = (int)llllllllllllllIIIlllIllIIIIIIIll.getValue(BlockDynamicLiquid.LEVEL);
        byte llllllllllllllIIIlllIllIIIIllIlI = 1;
        if (this.blockMaterial == Material.lava && !llllllllllllllIIIlllIllIIIlIIlII.provider.func_177500_n()) {
            llllllllllllllIIIlllIllIIIIllIlI = 2;
        }
        int llllllllllllllIIIlllIllIIIIllIII = this.tickRate(llllllllllllllIIIlllIllIIIlIIlII);
        if (llllllllllllllIIIlllIllIIIIlllII > 0) {
            int llllllllllllllIIIlllIllIIIIlIIlI = -100;
            this.field_149815_a = 0;
            for (final EnumFacing llllllllllllllIIIlllIllIIIIlIIII : EnumFacing.Plane.HORIZONTAL) {
                llllllllllllllIIIlllIllIIIIlIIlI = this.func_176371_a(llllllllllllllIIIlllIllIIIlIIlII, llllllllllllllIIIlllIllIIIlIIIlI.offset(llllllllllllllIIIlllIllIIIIlIIII), llllllllllllllIIIlllIllIIIIlIIlI);
            }
            int llllllllllllllIIIlllIllIIIIIllIl = llllllllllllllIIIlllIllIIIIlIIlI + llllllllllllllIIIlllIllIIIIllIlI;
            if (llllllllllllllIIIlllIllIIIIIllIl >= 8 || llllllllllllllIIIlllIllIIIIlIIlI < 0) {
                llllllllllllllIIIlllIllIIIIIllIl = -1;
            }
            if (this.func_176362_e(llllllllllllllIIIlllIllIIIlIIlII, llllllllllllllIIIlllIllIIIlIIIlI.offsetUp()) >= 0) {
                final int llllllllllllllIIIlllIllIIIIlIllI = this.func_176362_e(llllllllllllllIIIlllIllIIIlIIlII, llllllllllllllIIIlllIllIIIlIIIlI.offsetUp());
                if (llllllllllllllIIIlllIllIIIIlIllI >= 8) {
                    llllllllllllllIIIlllIllIIIIIllIl = llllllllllllllIIIlllIllIIIIlIllI;
                }
                else {
                    llllllllllllllIIIlllIllIIIIIllIl = llllllllllllllIIIlllIllIIIIlIllI + 8;
                }
            }
            if (this.field_149815_a >= 2 && this.blockMaterial == Material.water) {
                final IBlockState llllllllllllllIIIlllIllIIIIIllII = llllllllllllllIIIlllIllIIIlIIlII.getBlockState(llllllllllllllIIIlllIllIIIlIIIlI.offsetDown());
                if (llllllllllllllIIIlllIllIIIIIllII.getBlock().getMaterial().isSolid()) {
                    llllllllllllllIIIlllIllIIIIIllIl = 0;
                }
                else if (llllllllllllllIIIlllIllIIIIIllII.getBlock().getMaterial() == this.blockMaterial && (int)llllllllllllllIIIlllIllIIIIIllII.getValue(BlockDynamicLiquid.LEVEL) == 0) {
                    llllllllllllllIIIlllIllIIIIIllIl = 0;
                }
            }
            if (this.blockMaterial == Material.lava && llllllllllllllIIIlllIllIIIIlllII < 8 && llllllllllllllIIIlllIllIIIIIllIl < 8 && llllllllllllllIIIlllIllIIIIIllIl > llllllllllllllIIIlllIllIIIIlllII && llllllllllllllIIIlllIllIIIIIIIlI.nextInt(4) != 0) {
                llllllllllllllIIIlllIllIIIIllIII *= 4;
            }
            if (llllllllllllllIIIlllIllIIIIIllIl == llllllllllllllIIIlllIllIIIIlllII) {
                this.func_180690_f(llllllllllllllIIIlllIllIIIlIIlII, llllllllllllllIIIlllIllIIIlIIIlI, llllllllllllllIIIlllIllIIIIIIIll);
            }
            else if ((llllllllllllllIIIlllIllIIIIlllII = llllllllllllllIIIlllIllIIIIIllIl) < 0) {
                llllllllllllllIIIlllIllIIIlIIlII.setBlockToAir(llllllllllllllIIIlllIllIIIlIIIlI);
            }
            else {
                llllllllllllllIIIlllIllIIIIIIIll = llllllllllllllIIIlllIllIIIIIIIll.withProperty(BlockDynamicLiquid.LEVEL, llllllllllllllIIIlllIllIIIIIllIl);
                llllllllllllllIIIlllIllIIIlIIlII.setBlockState(llllllllllllllIIIlllIllIIIlIIIlI, llllllllllllllIIIlllIllIIIIIIIll, 2);
                llllllllllllllIIIlllIllIIIlIIlII.scheduleUpdate(llllllllllllllIIIlllIllIIIlIIIlI, this, llllllllllllllIIIlllIllIIIIllIII);
                llllllllllllllIIIlllIllIIIlIIlII.notifyNeighborsOfStateChange(llllllllllllllIIIlllIllIIIlIIIlI, this);
            }
        }
        else {
            this.func_180690_f(llllllllllllllIIIlllIllIIIlIIlII, llllllllllllllIIIlllIllIIIlIIIlI, llllllllllllllIIIlllIllIIIIIIIll);
        }
        final IBlockState llllllllllllllIIIlllIllIIIIIlIll = llllllllllllllIIIlllIllIIIlIIlII.getBlockState(llllllllllllllIIIlllIllIIIlIIIlI.offsetDown());
        if (this.func_176373_h(llllllllllllllIIIlllIllIIIlIIlII, llllllllllllllIIIlllIllIIIlIIIlI.offsetDown(), llllllllllllllIIIlllIllIIIIIlIll)) {
            if (this.blockMaterial == Material.lava && llllllllllllllIIIlllIllIIIlIIlII.getBlockState(llllllllllllllIIIlllIllIIIlIIIlI.offsetDown()).getBlock().getMaterial() == Material.water) {
                llllllllllllllIIIlllIllIIIlIIlII.setBlockState(llllllllllllllIIIlllIllIIIlIIIlI.offsetDown(), Blocks.stone.getDefaultState());
                this.func_180688_d(llllllllllllllIIIlllIllIIIlIIlII, llllllllllllllIIIlllIllIIIlIIIlI.offsetDown());
                return;
            }
            if (llllllllllllllIIIlllIllIIIIlllII >= 8) {
                this.func_176375_a(llllllllllllllIIIlllIllIIIlIIlII, llllllllllllllIIIlllIllIIIlIIIlI.offsetDown(), llllllllllllllIIIlllIllIIIIIlIll, llllllllllllllIIIlllIllIIIIlllII);
            }
            else {
                this.func_176375_a(llllllllllllllIIIlllIllIIIlIIlII, llllllllllllllIIIlllIllIIIlIIIlI.offsetDown(), llllllllllllllIIIlllIllIIIIIlIll, llllllllllllllIIIlllIllIIIIlllII + 8);
            }
        }
        else if (llllllllllllllIIIlllIllIIIIlllII >= 0 && (llllllllllllllIIIlllIllIIIIlllII == 0 || this.func_176372_g(llllllllllllllIIIlllIllIIIlIIlII, llllllllllllllIIIlllIllIIIlIIIlI.offsetDown(), llllllllllllllIIIlllIllIIIIIlIll))) {
            final Set llllllllllllllIIIlllIllIIIIIlIlI = this.func_176376_e(llllllllllllllIIIlllIllIIIlIIlII, llllllllllllllIIIlllIllIIIlIIIlI);
            int llllllllllllllIIIlllIllIIIIlIlII = llllllllllllllIIIlllIllIIIIlllII + llllllllllllllIIIlllIllIIIIllIlI;
            if (llllllllllllllIIIlllIllIIIIlllII >= 8) {
                llllllllllllllIIIlllIllIIIIlIlII = 1;
            }
            if (llllllllllllllIIIlllIllIIIIlIlII >= 8) {
                return;
            }
            for (final EnumFacing llllllllllllllIIIlllIllIIIIIlIII : llllllllllllllIIIlllIllIIIIIlIlI) {
                this.func_176375_a(llllllllllllllIIIlllIllIIIlIIlII, llllllllllllllIIIlllIllIIIlIIIlI.offset(llllllllllllllIIIlllIllIIIIIlIII), llllllllllllllIIIlllIllIIIlIIlII.getBlockState(llllllllllllllIIIlllIllIIIlIIIlI.offset(llllllllllllllIIIlllIllIIIIIlIII)), llllllllllllllIIIlllIllIIIIlIlII);
            }
        }
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllllIIIlllIlIlIIllllll, final BlockPos llllllllllllllIIIlllIlIlIlIIIlII, final IBlockState llllllllllllllIIIlllIlIlIIlllIll) {
        if (!this.func_176365_e(llllllllllllllIIIlllIlIlIIllllll, llllllllllllllIIIlllIlIlIlIIIlII, llllllllllllllIIIlllIlIlIIlllIll)) {
            llllllllllllllIIIlllIlIlIIllllll.scheduleUpdate(llllllllllllllIIIlllIlIlIlIIIlII, this, this.tickRate(llllllllllllllIIIlllIlIlIIllllll));
        }
    }
    
    private boolean func_176372_g(final World llllllllllllllIIIlllIlIllIIIlIlI, final BlockPos llllllllllllllIIIlllIlIllIIIllIl, final IBlockState llllllllllllllIIIlllIlIllIIIllII) {
        final Block llllllllllllllIIIlllIlIllIIIlIll = llllllllllllllIIIlllIlIllIIIlIlI.getBlockState(llllllllllllllIIIlllIlIllIIIllIl).getBlock();
        return llllllllllllllIIIlllIlIllIIIlIll instanceof BlockDoor || llllllllllllllIIIlllIlIllIIIlIll == Blocks.standing_sign || llllllllllllllIIIlllIlIllIIIlIll == Blocks.ladder || llllllllllllllIIIlllIlIllIIIlIll == Blocks.reeds || llllllllllllllIIIlllIlIllIIIlIll.blockMaterial == Material.portal || llllllllllllllIIIlllIlIllIIIlIll.blockMaterial.blocksMovement();
    }
    
    private boolean func_176373_h(final World llllllllllllllIIIlllIlIlIlIlIIIl, final BlockPos llllllllllllllIIIlllIlIlIlIIllll, final IBlockState llllllllllllllIIIlllIlIlIlIIllIl) {
        final Material llllllllllllllIIIlllIlIlIlIlIlIl = llllllllllllllIIIlllIlIlIlIIllIl.getBlock().getMaterial();
        return llllllllllllllIIIlllIlIlIlIlIlIl != this.blockMaterial && llllllllllllllIIIlllIlIlIlIlIlIl != Material.lava && !this.func_176372_g(llllllllllllllIIIlllIlIlIlIlIIIl, llllllllllllllIIIlllIlIlIlIIllll, llllllllllllllIIIlllIlIlIlIIllIl);
    }
    
    static {
        __OBFID = "CL_00000234";
    }
    
    private int func_176374_a(final World llllllllllllllIIIlllIlIlllIIIllI, final BlockPos llllllllllllllIIIlllIlIllIlllIlI, final int llllllllllllllIIIlllIlIlllIIIlII, final EnumFacing llllllllllllllIIIlllIlIlllIIIIll) {
        int llllllllllllllIIIlllIlIlllIIIIlI = 1000;
        for (final EnumFacing llllllllllllllIIIlllIlIlllIIIIII : EnumFacing.Plane.HORIZONTAL) {
            if (llllllllllllllIIIlllIlIlllIIIIII != llllllllllllllIIIlllIlIlllIIIIll) {
                final BlockPos llllllllllllllIIIlllIlIllIllllll = llllllllllllllIIIlllIlIllIlllIlI.offset(llllllllllllllIIIlllIlIlllIIIIII);
                final IBlockState llllllllllllllIIIlllIlIllIlllllI = llllllllllllllIIIlllIlIlllIIIllI.getBlockState(llllllllllllllIIIlllIlIllIllllll);
                if (this.func_176372_g(llllllllllllllIIIlllIlIlllIIIllI, llllllllllllllIIIlllIlIllIllllll, llllllllllllllIIIlllIlIllIlllllI) || (llllllllllllllIIIlllIlIllIlllllI.getBlock().getMaterial() == this.blockMaterial && (int)llllllllllllllIIIlllIlIllIlllllI.getValue(BlockDynamicLiquid.LEVEL) <= 0)) {
                    continue;
                }
                if (!this.func_176372_g(llllllllllllllIIIlllIlIlllIIIllI, llllllllllllllIIIlllIlIllIllllll.offsetDown(), llllllllllllllIIIlllIlIllIlllllI)) {
                    return llllllllllllllIIIlllIlIlllIIIlII;
                }
                if (llllllllllllllIIIlllIlIlllIIIlII >= 4) {
                    continue;
                }
                final int llllllllllllllIIIlllIlIllIllllIl = this.func_176374_a(llllllllllllllIIIlllIlIlllIIIllI, llllllllllllllIIIlllIlIllIllllll, llllllllllllllIIIlllIlIlllIIIlII + 1, llllllllllllllIIIlllIlIlllIIIIII.getOpposite());
                if (llllllllllllllIIIlllIlIllIllllIl >= llllllllllllllIIIlllIlIlllIIIIlI) {
                    continue;
                }
                llllllllllllllIIIlllIlIlllIIIIlI = llllllllllllllIIIlllIlIllIllllIl;
            }
        }
        return llllllllllllllIIIlllIlIlllIIIIlI;
    }
    
    private Set func_176376_e(final World llllllllllllllIIIlllIlIllIIllIll, final BlockPos llllllllllllllIIIlllIlIllIlIIlIl) {
        int llllllllllllllIIIlllIlIllIlIIlII = 1000;
        final EnumSet llllllllllllllIIIlllIlIllIlIIIll = EnumSet.noneOf(EnumFacing.class);
        for (final EnumFacing llllllllllllllIIIlllIlIllIlIIIIl : EnumFacing.Plane.HORIZONTAL) {
            final BlockPos llllllllllllllIIIlllIlIllIlIIIII = llllllllllllllIIIlllIlIllIlIIlIl.offset(llllllllllllllIIIlllIlIllIlIIIIl);
            final IBlockState llllllllllllllIIIlllIlIllIIlllll = llllllllllllllIIIlllIlIllIIllIll.getBlockState(llllllllllllllIIIlllIlIllIlIIIII);
            if (!this.func_176372_g(llllllllllllllIIIlllIlIllIIllIll, llllllllllllllIIIlllIlIllIlIIIII, llllllllllllllIIIlllIlIllIIlllll) && (llllllllllllllIIIlllIlIllIIlllll.getBlock().getMaterial() != this.blockMaterial || (int)llllllllllllllIIIlllIlIllIIlllll.getValue(BlockDynamicLiquid.LEVEL) > 0)) {
                int llllllllllllllIIIlllIlIllIIlllIl = 0;
                if (this.func_176372_g(llllllllllllllIIIlllIlIllIIllIll, llllllllllllllIIIlllIlIllIlIIIII.offsetDown(), llllllllllllllIIIlllIlIllIIllIll.getBlockState(llllllllllllllIIIlllIlIllIlIIIII.offsetDown()))) {
                    final int llllllllllllllIIIlllIlIllIIllllI = this.func_176374_a(llllllllllllllIIIlllIlIllIIllIll, llllllllllllllIIIlllIlIllIlIIIII, 1, llllllllllllllIIIlllIlIllIlIIIIl.getOpposite());
                }
                else {
                    llllllllllllllIIIlllIlIllIIlllIl = 0;
                }
                if (llllllllllllllIIIlllIlIllIIlllIl < llllllllllllllIIIlllIlIllIlIIlII) {
                    llllllllllllllIIIlllIlIllIlIIIll.clear();
                }
                if (llllllllllllllIIIlllIlIllIIlllIl > llllllllllllllIIIlllIlIllIlIIlII) {
                    continue;
                }
                llllllllllllllIIIlllIlIllIlIIIll.add(llllllllllllllIIIlllIlIllIlIIIIl);
                llllllllllllllIIIlllIlIllIlIIlII = llllllllllllllIIIlllIlIllIIlllIl;
            }
        }
        return llllllllllllllIIIlllIlIllIlIIIll;
    }
}
