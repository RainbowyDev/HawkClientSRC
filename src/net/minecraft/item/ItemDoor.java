package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;

public class ItemDoor extends Item
{
    private /* synthetic */ Block field_179236_a;
    
    public ItemDoor(final Block llllllllllllllIlIlIIlllIIlIlllII) {
        this.field_179236_a = llllllllllllllIlIlIIlllIIlIlllII;
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }
    
    static {
        __OBFID = "CL_00000020";
    }
    
    @Override
    public boolean onItemUse(final ItemStack llllllllllllllIlIlIIlllIIlIlIIlI, final EntityPlayer llllllllllllllIlIlIIlllIIlIIIllI, final World llllllllllllllIlIlIIlllIIlIIIlIl, BlockPos llllllllllllllIlIlIIlllIIlIIIlII, final EnumFacing llllllllllllllIlIlIIlllIIlIIIIll, final float llllllllllllllIlIlIIlllIIlIIllIl, final float llllllllllllllIlIlIIlllIIlIIllII, final float llllllllllllllIlIlIIlllIIlIIlIll) {
        if (llllllllllllllIlIlIIlllIIlIIIIll != EnumFacing.UP) {
            return false;
        }
        final IBlockState llllllllllllllIlIlIIlllIIlIIlIlI = llllllllllllllIlIlIIlllIIlIIIlIl.getBlockState(llllllllllllllIlIlIIlllIIlIIIlII);
        final Block llllllllllllllIlIlIIlllIIlIIlIIl = llllllllllllllIlIlIIlllIIlIIlIlI.getBlock();
        if (!llllllllllllllIlIlIIlllIIlIIlIIl.isReplaceable(llllllllllllllIlIlIIlllIIlIIIlIl, llllllllllllllIlIlIIlllIIlIIIlII)) {
            llllllllllllllIlIlIIlllIIlIIIlII = llllllllllllllIlIlIIlllIIlIIIlII.offset(llllllllllllllIlIlIIlllIIlIIIIll);
        }
        if (!llllllllllllllIlIlIIlllIIlIIIllI.func_175151_a(llllllllllllllIlIlIIlllIIlIIIlII, llllllllllllllIlIlIIlllIIlIIIIll, llllllllllllllIlIlIIlllIIlIlIIlI)) {
            return false;
        }
        if (!this.field_179236_a.canPlaceBlockAt(llllllllllllllIlIlIIlllIIlIIIlIl, llllllllllllllIlIlIIlllIIlIIIlII)) {
            return false;
        }
        func_179235_a(llllllllllllllIlIlIIlllIIlIIIlIl, llllllllllllllIlIlIIlllIIlIIIlII, EnumFacing.fromAngle(llllllllllllllIlIlIIlllIIlIIIllI.rotationYaw), this.field_179236_a);
        --llllllllllllllIlIlIIlllIIlIlIIlI.stackSize;
        return true;
    }
    
    public static void func_179235_a(final World llllllllllllllIlIlIIlllIIIlIIllI, final BlockPos llllllllllllllIlIlIIlllIIIllIIlI, final EnumFacing llllllllllllllIlIlIIlllIIIllIIIl, final Block llllllllllllllIlIlIIlllIIIlIIIll) {
        final BlockPos llllllllllllllIlIlIIlllIIIlIllll = llllllllllllllIlIlIIlllIIIllIIlI.offset(llllllllllllllIlIlIIlllIIIllIIIl.rotateY());
        final BlockPos llllllllllllllIlIlIIlllIIIlIlllI = llllllllllllllIlIlIIlllIIIllIIlI.offset(llllllllllllllIlIlIIlllIIIllIIIl.rotateYCCW());
        final int llllllllllllllIlIlIIlllIIIlIllIl = (llllllllllllllIlIlIIlllIIIlIIllI.getBlockState(llllllllllllllIlIlIIlllIIIlIlllI).getBlock().isNormalCube() + llllllllllllllIlIlIIlllIIIlIIllI.getBlockState(llllllllllllllIlIlIIlllIIIlIlllI.offsetUp()).getBlock().isNormalCube()) ? 1 : 0;
        final int llllllllllllllIlIlIIlllIIIlIllII = (llllllllllllllIlIlIIlllIIIlIIllI.getBlockState(llllllllllllllIlIlIIlllIIIlIllll).getBlock().isNormalCube() + llllllllllllllIlIlIIlllIIIlIIllI.getBlockState(llllllllllllllIlIlIIlllIIIlIllll.offsetUp()).getBlock().isNormalCube()) ? 1 : 0;
        final boolean llllllllllllllIlIlIIlllIIIlIlIll = llllllllllllllIlIlIIlllIIIlIIllI.getBlockState(llllllllllllllIlIlIIlllIIIlIlllI).getBlock() == llllllllllllllIlIlIIlllIIIlIIIll || llllllllllllllIlIlIIlllIIIlIIllI.getBlockState(llllllllllllllIlIlIIlllIIIlIlllI.offsetUp()).getBlock() == llllllllllllllIlIlIIlllIIIlIIIll;
        final boolean llllllllllllllIlIlIIlllIIIlIlIlI = llllllllllllllIlIlIIlllIIIlIIllI.getBlockState(llllllllllllllIlIlIIlllIIIlIllll).getBlock() == llllllllllllllIlIlIIlllIIIlIIIll || llllllllllllllIlIlIIlllIIIlIIllI.getBlockState(llllllllllllllIlIlIIlllIIIlIllll.offsetUp()).getBlock() == llllllllllllllIlIlIIlllIIIlIIIll;
        boolean llllllllllllllIlIlIIlllIIIlIlIIl = false;
        if ((llllllllllllllIlIlIIlllIIIlIlIll && !llllllllllllllIlIlIIlllIIIlIlIlI) || llllllllllllllIlIlIIlllIIIlIllII > llllllllllllllIlIlIIlllIIIlIllIl) {
            llllllllllllllIlIlIIlllIIIlIlIIl = true;
        }
        final BlockPos llllllllllllllIlIlIIlllIIIlIlIII = llllllllllllllIlIlIIlllIIIllIIlI.offsetUp();
        final IBlockState llllllllllllllIlIlIIlllIIIlIIlll = llllllllllllllIlIlIIlllIIIlIIIll.getDefaultState().withProperty(BlockDoor.FACING_PROP, llllllllllllllIlIlIIlllIIIllIIIl).withProperty(BlockDoor.HINGEPOSITION_PROP, llllllllllllllIlIlIIlllIIIlIlIIl ? BlockDoor.EnumHingePosition.RIGHT : BlockDoor.EnumHingePosition.LEFT);
        llllllllllllllIlIlIIlllIIIlIIllI.setBlockState(llllllllllllllIlIlIIlllIIIllIIlI, llllllllllllllIlIlIIlllIIIlIIlll.withProperty(BlockDoor.HALF_PROP, BlockDoor.EnumDoorHalf.LOWER), 2);
        llllllllllllllIlIlIIlllIIIlIIllI.setBlockState(llllllllllllllIlIlIIlllIIIlIlIII, llllllllllllllIlIlIIlllIIIlIIlll.withProperty(BlockDoor.HALF_PROP, BlockDoor.EnumDoorHalf.UPPER), 2);
        llllllllllllllIlIlIIlllIIIlIIllI.notifyNeighborsOfStateChange(llllllllllllllIlIlIIlllIIIllIIlI, llllllllllllllIlIlIIlllIIIlIIIll);
        llllllllllllllIlIlIIlllIIIlIIllI.notifyNeighborsOfStateChange(llllllllllllllIlIlIIlllIIIlIlIII, llllllllllllllIlIlIIlllIIIlIIIll);
    }
}
