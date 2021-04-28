package net.minecraft.block;

import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.block.properties.*;
import java.util.*;
import net.minecraft.init.*;

public class BlockStaticLiquid extends BlockLiquid
{
    protected BlockStaticLiquid(final Material llllllllllllllIlllllllIIlIIlIIIl) {
        super(llllllllllllllIlllllllIIlIIlIIIl);
        this.setTickRandomly(false);
        if (llllllllllllllIlllllllIIlIIlIIIl == Material.lava) {
            this.setTickRandomly(true);
        }
    }
    
    protected boolean isSurroundingBlockFlammable(final World llllllllllllllIlllllllIIIlIIllll, final BlockPos llllllllllllllIlllllllIIIlIIlllI) {
        for (final EnumFacing llllllllllllllIlllllllIIIlIIlIlI : EnumFacing.values()) {
            if (this.getCanBlockBurn(llllllllllllllIlllllllIIIlIIllll, llllllllllllllIlllllllIIIlIIlllI.offset(llllllllllllllIlllllllIIIlIIlIlI))) {
                return true;
            }
        }
        return false;
    }
    
    static {
        __OBFID = "CL_00000315";
    }
    
    private void updateLiquid(final World llllllllllllllIlllllllIIIlllIllI, final BlockPos llllllllllllllIlllllllIIIllllIlI, final IBlockState llllllllllllllIlllllllIIIlllIlII) {
        final BlockDynamicLiquid llllllllllllllIlllllllIIIllllIII = BlockLiquid.getDynamicLiquidForMaterial(this.blockMaterial);
        llllllllllllllIlllllllIIIlllIllI.setBlockState(llllllllllllllIlllllllIIIllllIlI, llllllllllllllIlllllllIIIllllIII.getDefaultState().withProperty(BlockStaticLiquid.LEVEL, llllllllllllllIlllllllIIIlllIlII.getValue(BlockStaticLiquid.LEVEL)), 2);
        llllllllllllllIlllllllIIIlllIllI.scheduleUpdate(llllllllllllllIlllllllIIIllllIlI, llllllllllllllIlllllllIIIllllIII, this.tickRate(llllllllllllllIlllllllIIIlllIllI));
    }
    
    @Override
    public void onNeighborBlockChange(final World llllllllllllllIlllllllIIlIIIIlII, final BlockPos llllllllllllllIlllllllIIlIIIIIll, final IBlockState llllllllllllllIlllllllIIlIIIIlll, final Block llllllllllllllIlllllllIIlIIIIllI) {
        if (!this.func_176365_e(llllllllllllllIlllllllIIlIIIIlII, llllllllllllllIlllllllIIlIIIIIll, llllllllllllllIlllllllIIlIIIIlll)) {
            this.updateLiquid(llllllllllllllIlllllllIIlIIIIlII, llllllllllllllIlllllllIIlIIIIIll, llllllllllllllIlllllllIIlIIIIlll);
        }
    }
    
    private boolean getCanBlockBurn(final World llllllllllllllIlllllllIIIIllllIl, final BlockPos llllllllllllllIlllllllIIIIlllllI) {
        return llllllllllllllIlllllllIIIIllllIl.getBlockState(llllllllllllllIlllllllIIIIlllllI).getBlock().getMaterial().getCanBurn();
    }
    
    @Override
    public void updateTick(final World llllllllllllllIlllllllIIIlIllllI, final BlockPos llllllllllllllIlllllllIIIlIlllIl, final IBlockState llllllllllllllIlllllllIIIllIIlll, final Random llllllllllllllIlllllllIIIllIIllI) {
        if (this.blockMaterial == Material.lava && llllllllllllllIlllllllIIIlIllllI.getGameRules().getGameRuleBooleanValue("doFireTick")) {
            final int llllllllllllllIlllllllIIIllIIlIl = llllllllllllllIlllllllIIIllIIllI.nextInt(3);
            if (llllllllllllllIlllllllIIIllIIlIl > 0) {
                BlockPos llllllllllllllIlllllllIIIllIIlII = llllllllllllllIlllllllIIIlIlllIl;
                for (int llllllllllllllIlllllllIIIllIIIll = 0; llllllllllllllIlllllllIIIllIIIll < llllllllllllllIlllllllIIIllIIlIl; ++llllllllllllllIlllllllIIIllIIIll) {
                    llllllllllllllIlllllllIIIllIIlII = llllllllllllllIlllllllIIIllIIlII.add(llllllllllllllIlllllllIIIllIIllI.nextInt(3) - 1, 1, llllllllllllllIlllllllIIIllIIllI.nextInt(3) - 1);
                    final Block llllllllllllllIlllllllIIIllIIIlI = llllllllllllllIlllllllIIIlIllllI.getBlockState(llllllllllllllIlllllllIIIllIIlII).getBlock();
                    if (llllllllllllllIlllllllIIIllIIIlI.blockMaterial == Material.air) {
                        if (this.isSurroundingBlockFlammable(llllllllllllllIlllllllIIIlIllllI, llllllllllllllIlllllllIIIllIIlII)) {
                            llllllllllllllIlllllllIIIlIllllI.setBlockState(llllllllllllllIlllllllIIIllIIlII, Blocks.fire.getDefaultState());
                            return;
                        }
                    }
                    else if (llllllllllllllIlllllllIIIllIIIlI.blockMaterial.blocksMovement()) {
                        return;
                    }
                }
            }
            else {
                for (int llllllllllllllIlllllllIIIllIIIIl = 0; llllllllllllllIlllllllIIIllIIIIl < 3; ++llllllllllllllIlllllllIIIllIIIIl) {
                    final BlockPos llllllllllllllIlllllllIIIllIIIII = llllllllllllllIlllllllIIIlIlllIl.add(llllllllllllllIlllllllIIIllIIllI.nextInt(3) - 1, 0, llllllllllllllIlllllllIIIllIIllI.nextInt(3) - 1);
                    if (llllllllllllllIlllllllIIIlIllllI.isAirBlock(llllllllllllllIlllllllIIIllIIIII.offsetUp()) && this.getCanBlockBurn(llllllllllllllIlllllllIIIlIllllI, llllllllllllllIlllllllIIIllIIIII)) {
                        llllllllllllllIlllllllIIIlIllllI.setBlockState(llllllllllllllIlllllllIIIllIIIII.offsetUp(), Blocks.fire.getDefaultState());
                    }
                }
            }
        }
    }
}
