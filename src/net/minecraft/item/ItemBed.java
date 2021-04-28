package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;

public class ItemBed extends Item
{
    public ItemBed() {
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }
    
    static {
        __OBFID = "CL_00001771";
    }
    
    @Override
    public boolean onItemUse(final ItemStack lllllllllllllllIIIlIllIIlllllllI, final EntityPlayer lllllllllllllllIIIlIllIIllllllIl, final World lllllllllllllllIIIlIllIIllllllII, BlockPos lllllllllllllllIIIlIllIIlllIIlll, final EnumFacing lllllllllllllllIIIlIllIIlllllIlI, final float lllllllllllllllIIIlIllIIlllllIIl, final float lllllllllllllllIIIlIllIIlllllIII, final float lllllllllllllllIIIlIllIIllllIlll) {
        if (lllllllllllllllIIIlIllIIllllllII.isRemote) {
            return true;
        }
        if (lllllllllllllllIIIlIllIIlllllIlI != EnumFacing.UP) {
            return false;
        }
        final IBlockState lllllllllllllllIIIlIllIIllllIllI = lllllllllllllllIIIlIllIIllllllII.getBlockState((BlockPos)lllllllllllllllIIIlIllIIlllIIlll);
        final Block lllllllllllllllIIIlIllIIllllIlIl = lllllllllllllllIIIlIllIIllllIllI.getBlock();
        final boolean lllllllllllllllIIIlIllIIllllIlII = lllllllllllllllIIIlIllIIllllIlIl.isReplaceable(lllllllllllllllIIIlIllIIllllllII, (BlockPos)lllllllllllllllIIIlIllIIlllIIlll);
        if (!lllllllllllllllIIIlIllIIllllIlII) {
            lllllllllllllllIIIlIllIIlllIIlll = (Comparable<Integer>)((BlockPos)lllllllllllllllIIIlIllIIlllIIlll).offsetUp();
        }
        final int lllllllllllllllIIIlIllIIllllIIll = MathHelper.floor_double(lllllllllllllllIIIlIllIIllllllIl.rotationYaw * 4.0f / 360.0f + 0.5) & 0x3;
        final EnumFacing lllllllllllllllIIIlIllIIllllIIlI = EnumFacing.getHorizontal(lllllllllllllllIIIlIllIIllllIIll);
        final BlockPos lllllllllllllllIIIlIllIIllllIIIl = ((BlockPos)lllllllllllllllIIIlIllIIlllIIlll).offset(lllllllllllllllIIIlIllIIllllIIlI);
        final boolean lllllllllllllllIIIlIllIIllllIIII = lllllllllllllllIIIlIllIIllllIlIl.isReplaceable(lllllllllllllllIIIlIllIIllllllII, lllllllllllllllIIIlIllIIllllIIIl);
        final boolean lllllllllllllllIIIlIllIIlllIllll = lllllllllllllllIIIlIllIIllllllII.isAirBlock((BlockPos)lllllllllllllllIIIlIllIIlllIIlll) || lllllllllllllllIIIlIllIIllllIlII;
        final boolean lllllllllllllllIIIlIllIIlllIlllI = lllllllllllllllIIIlIllIIllllllII.isAirBlock(lllllllllllllllIIIlIllIIllllIIIl) || lllllllllllllllIIIlIllIIllllIIII;
        if (!lllllllllllllllIIIlIllIIllllllIl.func_175151_a((BlockPos)lllllllllllllllIIIlIllIIlllIIlll, lllllllllllllllIIIlIllIIlllllIlI, lllllllllllllllIIIlIllIIlllllllI) || !lllllllllllllllIIIlIllIIllllllIl.func_175151_a(lllllllllllllllIIIlIllIIllllIIIl, lllllllllllllllIIIlIllIIlllllIlI, lllllllllllllllIIIlIllIIlllllllI)) {
            return false;
        }
        if (lllllllllllllllIIIlIllIIlllIllll && lllllllllllllllIIIlIllIIlllIlllI && World.doesBlockHaveSolidTopSurface(lllllllllllllllIIIlIllIIllllllII, ((BlockPos)lllllllllllllllIIIlIllIIlllIIlll).offsetDown()) && World.doesBlockHaveSolidTopSurface(lllllllllllllllIIIlIllIIllllllII, lllllllllllllllIIIlIllIIllllIIIl.offsetDown())) {
            final int lllllllllllllllIIIlIllIIlllIllIl = lllllllllllllllIIIlIllIIllllIIlI.getHorizontalIndex();
            final IBlockState lllllllllllllllIIIlIllIIlllIllII = Blocks.bed.getDefaultState().withProperty(BlockBed.OCCUPIED_PROP, false).withProperty(BlockBed.AGE, lllllllllllllllIIIlIllIIllllIIlI).withProperty(BlockBed.PART_PROP, BlockBed.EnumPartType.FOOT);
            if (lllllllllllllllIIIlIllIIllllllII.setBlockState((BlockPos)lllllllllllllllIIIlIllIIlllIIlll, lllllllllllllllIIIlIllIIlllIllII, 3)) {
                final IBlockState lllllllllllllllIIIlIllIIlllIlIll = lllllllllllllllIIIlIllIIlllIllII.withProperty(BlockBed.PART_PROP, BlockBed.EnumPartType.HEAD);
                lllllllllllllllIIIlIllIIllllllII.setBlockState(lllllllllllllllIIIlIllIIllllIIIl, lllllllllllllllIIIlIllIIlllIlIll, 3);
            }
            --lllllllllllllllIIIlIllIIlllllllI.stackSize;
            return true;
        }
        return false;
    }
}
