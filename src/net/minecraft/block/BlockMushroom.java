package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.block.properties.*;
import java.util.*;

public class BlockMushroom extends BlockBush implements IGrowable
{
    static {
        __OBFID = "CL_00000272";
    }
    
    protected BlockMushroom() {
        final float llllllllllllllIIIIIIIIlIIllIlIll = 0.2f;
        this.setBlockBounds(0.5f - llllllllllllllIIIIIIIIlIIllIlIll, 0.0f, 0.5f - llllllllllllllIIIIIIIIlIIllIlIll, 0.5f + llllllllllllllIIIIIIIIlIIllIlIll, llllllllllllllIIIIIIIIlIIllIlIll * 2.0f, 0.5f + llllllllllllllIIIIIIIIlIIllIlIll);
        this.setTickRandomly(true);
    }
    
    @Override
    public boolean isStillGrowing(final World llllllllllllllIIIIIIIIlIIIIllllI, final BlockPos llllllllllllllIIIIIIIIlIIIIlllIl, final IBlockState llllllllllllllIIIIIIIIlIIIIlllII, final boolean llllllllllllllIIIIIIIIlIIIIllIll) {
        return true;
    }
    
    public boolean func_176485_d(final World llllllllllllllIIIIIIIIlIIIlIIlII, final BlockPos llllllllllllllIIIIIIIIlIIIlIlIIl, final IBlockState llllllllllllllIIIIIIIIlIIIlIlIII, final Random llllllllllllllIIIIIIIIlIIIlIIlll) {
        llllllllllllllIIIIIIIIlIIIlIIlII.setBlockToAir(llllllllllllllIIIIIIIIlIIIlIlIIl);
        WorldGenBigMushroom llllllllllllllIIIIIIIIlIIIlIIllI = null;
        if (this == Blocks.brown_mushroom) {
            llllllllllllllIIIIIIIIlIIIlIIllI = new WorldGenBigMushroom(0);
        }
        else if (this == Blocks.red_mushroom) {
            llllllllllllllIIIIIIIIlIIIlIIllI = new WorldGenBigMushroom(1);
        }
        if (llllllllllllllIIIIIIIIlIIIlIIllI != null && llllllllllllllIIIIIIIIlIIIlIIllI.generate(llllllllllllllIIIIIIIIlIIIlIIlII, llllllllllllllIIIIIIIIlIIIlIIlll, llllllllllllllIIIIIIIIlIIIlIlIIl)) {
            return true;
        }
        llllllllllllllIIIIIIIIlIIIlIIlII.setBlockState(llllllllllllllIIIIIIIIlIIIlIlIIl, llllllllllllllIIIIIIIIlIIIlIlIII, 3);
        return false;
    }
    
    @Override
    public void grow(final World llllllllllllllIIIIIIIIlIIIIIllIl, final Random llllllllllllllIIIIIIIIlIIIIIIlll, final BlockPos llllllllllllllIIIIIIIIlIIIIIlIll, final IBlockState llllllllllllllIIIIIIIIlIIIIIIlIl) {
        this.func_176485_d(llllllllllllllIIIIIIIIlIIIIIllIl, llllllllllllllIIIIIIIIlIIIIIlIll, llllllllllllllIIIIIIIIlIIIIIIlIl, llllllllllllllIIIIIIIIlIIIIIIlll);
    }
    
    @Override
    protected boolean canPlaceBlockOn(final Block llllllllllllllIIIIIIIIlIIIllllll) {
        return llllllllllllllIIIIIIIIlIIIllllll.isFullBlock();
    }
    
    @Override
    public boolean canBlockStay(final World llllllllllllllIIIIIIIIlIIIllIlII, final BlockPos llllllllllllllIIIIIIIIlIIIlllIII, final IBlockState llllllllllllllIIIIIIIIlIIIllIlll) {
        if (llllllllllllllIIIIIIIIlIIIlllIII.getY() >= 0 && llllllllllllllIIIIIIIIlIIIlllIII.getY() < 256) {
            final IBlockState llllllllllllllIIIIIIIIlIIIllIllI = llllllllllllllIIIIIIIIlIIIllIlII.getBlockState(llllllllllllllIIIIIIIIlIIIlllIII.offsetDown());
            return llllllllllllllIIIIIIIIlIIIllIllI.getBlock() == Blocks.mycelium || (llllllllllllllIIIIIIIIlIIIllIllI.getBlock() == Blocks.dirt && llllllllllllllIIIIIIIIlIIIllIllI.getValue(BlockDirt.VARIANT) == BlockDirt.DirtType.PODZOL) || (llllllllllllllIIIIIIIIlIIIllIlII.getLight(llllllllllllllIIIIIIIIlIIIlllIII) < 13 && this.canPlaceBlockOn(llllllllllllllIIIIIIIIlIIIllIllI.getBlock()));
        }
        return false;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllllllIIIIIIIIlIIlIIIlll, final BlockPos llllllllllllllIIIIIIIIlIIlIIIIll) {
        return super.canPlaceBlockAt(llllllllllllllIIIIIIIIlIIlIIIlll, llllllllllllllIIIIIIIIlIIlIIIIll) && this.canBlockStay(llllllllllllllIIIIIIIIlIIlIIIlll, llllllllllllllIIIIIIIIlIIlIIIIll, this.getDefaultState());
    }
    
    @Override
    public boolean canUseBonemeal(final World llllllllllllllIIIIIIIIlIIIIllIII, final Random llllllllllllllIIIIIIIIlIIIIlIlll, final BlockPos llllllllllllllIIIIIIIIlIIIIlIllI, final IBlockState llllllllllllllIIIIIIIIlIIIIlIlIl) {
        return llllllllllllllIIIIIIIIlIIIIlIlll.nextFloat() < 0.4;
    }
    
    @Override
    public void updateTick(final World llllllllllllllIIIIIIIIlIIlIlIIll, BlockPos llllllllllllllIIIIIIIIlIIlIlIIlI, final IBlockState llllllllllllllIIIIIIIIlIIlIlllII, final Random llllllllllllllIIIIIIIIlIIlIlIIIl) {
        if (llllllllllllllIIIIIIIIlIIlIlIIIl.nextInt(25) == 0) {
            int llllllllllllllIIIIIIIIlIIlIllIlI = 5;
            final boolean llllllllllllllIIIIIIIIlIIlIllIIl = true;
            for (final BlockPos llllllllllllllIIIIIIIIlIIlIlIlll : BlockPos.getAllInBoxMutable(((BlockPos)llllllllllllllIIIIIIIIlIIlIlIIlI).add(-4, -1, -4), ((BlockPos)llllllllllllllIIIIIIIIlIIlIlIIlI).add(4, 1, 4))) {
                if (llllllllllllllIIIIIIIIlIIlIlIIll.getBlockState(llllllllllllllIIIIIIIIlIIlIlIlll).getBlock() == this && --llllllllllllllIIIIIIIIlIIlIllIlI <= 0) {
                    return;
                }
            }
            BlockPos llllllllllllllIIIIIIIIlIIlIlIllI = ((BlockPos)llllllllllllllIIIIIIIIlIIlIlIIlI).add(llllllllllllllIIIIIIIIlIIlIlIIIl.nextInt(3) - 1, llllllllllllllIIIIIIIIlIIlIlIIIl.nextInt(2) - llllllllllllllIIIIIIIIlIIlIlIIIl.nextInt(2), llllllllllllllIIIIIIIIlIIlIlIIIl.nextInt(3) - 1);
            for (int llllllllllllllIIIIIIIIlIIlIlIlIl = 0; llllllllllllllIIIIIIIIlIIlIlIlIl < 4; ++llllllllllllllIIIIIIIIlIIlIlIlIl) {
                if (llllllllllllllIIIIIIIIlIIlIlIIll.isAirBlock(llllllllllllllIIIIIIIIlIIlIlIllI) && this.canBlockStay(llllllllllllllIIIIIIIIlIIlIlIIll, llllllllllllllIIIIIIIIlIIlIlIllI, this.getDefaultState())) {
                    llllllllllllllIIIIIIIIlIIlIlIIlI = (Comparable<Float>)llllllllllllllIIIIIIIIlIIlIlIllI;
                }
                llllllllllllllIIIIIIIIlIIlIlIllI = ((BlockPos)llllllllllllllIIIIIIIIlIIlIlIIlI).add(llllllllllllllIIIIIIIIlIIlIlIIIl.nextInt(3) - 1, llllllllllllllIIIIIIIIlIIlIlIIIl.nextInt(2) - llllllllllllllIIIIIIIIlIIlIlIIIl.nextInt(2), llllllllllllllIIIIIIIIlIIlIlIIIl.nextInt(3) - 1);
            }
            if (llllllllllllllIIIIIIIIlIIlIlIIll.isAirBlock(llllllllllllllIIIIIIIIlIIlIlIllI) && this.canBlockStay(llllllllllllllIIIIIIIIlIIlIlIIll, llllllllllllllIIIIIIIIlIIlIlIllI, this.getDefaultState())) {
                llllllllllllllIIIIIIIIlIIlIlIIll.setBlockState(llllllllllllllIIIIIIIIlIIlIlIllI, this.getDefaultState(), 2);
            }
        }
    }
}
