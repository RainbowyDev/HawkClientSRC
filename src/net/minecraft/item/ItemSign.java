package net.minecraft.item;

import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.*;
import net.minecraft.tileentity.*;
import net.minecraft.creativetab.*;

public class ItemSign extends Item
{
    @Override
    public boolean onItemUse(final ItemStack llllllllllllllllIIllllIllIlIlIIl, final EntityPlayer llllllllllllllllIIllllIllIlIlIII, final World llllllllllllllllIIllllIllIlIIlll, BlockPos llllllllllllllllIIllllIllIIlllII, final EnumFacing llllllllllllllllIIllllIllIlIIlIl, final float llllllllllllllllIIllllIllIlIIlII, final float llllllllllllllllIIllllIllIlIIIll, final float llllllllllllllllIIllllIllIlIIIlI) {
        if (llllllllllllllllIIllllIllIlIIlIl == EnumFacing.DOWN) {
            return false;
        }
        if (!llllllllllllllllIIllllIllIlIIlll.getBlockState(llllllllllllllllIIllllIllIIlllII).getBlock().getMaterial().isSolid()) {
            return false;
        }
        llllllllllllllllIIllllIllIIlllII = llllllllllllllllIIllllIllIIlllII.offset(llllllllllllllllIIllllIllIlIIlIl);
        if (!llllllllllllllllIIllllIllIlIlIII.func_175151_a(llllllllllllllllIIllllIllIIlllII, llllllllllllllllIIllllIllIlIIlIl, llllllllllllllllIIllllIllIlIlIIl)) {
            return false;
        }
        if (!Blocks.standing_sign.canPlaceBlockAt(llllllllllllllllIIllllIllIlIIlll, llllllllllllllllIIllllIllIIlllII)) {
            return false;
        }
        if (llllllllllllllllIIllllIllIlIIlll.isRemote) {
            return true;
        }
        if (llllllllllllllllIIllllIllIlIIlIl == EnumFacing.UP) {
            final int llllllllllllllllIIllllIllIlIIIIl = MathHelper.floor_double((llllllllllllllllIIllllIllIlIlIII.rotationYaw + 180.0f) * 16.0f / 360.0f + 0.5) & 0xF;
            llllllllllllllllIIllllIllIlIIlll.setBlockState(llllllllllllllllIIllllIllIIlllII, Blocks.standing_sign.getDefaultState().withProperty(BlockStandingSign.ROTATION_PROP, llllllllllllllllIIllllIllIlIIIIl), 3);
        }
        else {
            llllllllllllllllIIllllIllIlIIlll.setBlockState(llllllllllllllllIIllllIllIIlllII, Blocks.wall_sign.getDefaultState().withProperty(BlockWallSign.field_176412_a, llllllllllllllllIIllllIllIlIIlIl), 3);
        }
        --llllllllllllllllIIllllIllIlIlIIl.stackSize;
        final TileEntity llllllllllllllllIIllllIllIlIIIII = llllllllllllllllIIllllIllIlIIlll.getTileEntity(llllllllllllllllIIllllIllIIlllII);
        if (llllllllllllllllIIllllIllIlIIIII instanceof TileEntitySign && !ItemBlock.setTileEntityNBT(llllllllllllllllIIllllIllIlIIlll, llllllllllllllllIIllllIllIIlllII, llllllllllllllllIIllllIllIlIlIIl)) {
            llllllllllllllllIIllllIllIlIlIII.func_175141_a((TileEntitySign)llllllllllllllllIIllllIllIlIIIII);
        }
        return true;
    }
    
    public ItemSign() {
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }
    
    static {
        __OBFID = "CL_00000064";
    }
}
