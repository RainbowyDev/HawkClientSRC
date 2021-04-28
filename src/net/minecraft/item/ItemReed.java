package net.minecraft.item;

import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;

public class ItemReed extends Item
{
    private /* synthetic */ Block field_150935_a;
    
    static {
        __OBFID = "CL_00001773";
    }
    
    public ItemReed(final Block llllllllllllllIIlIIllllIlIIllIIl) {
        this.field_150935_a = llllllllllllllIIlIIllllIlIIllIIl;
    }
    
    @Override
    public boolean onItemUse(final ItemStack llllllllllllllIIlIIllllIlIIIlIIl, final EntityPlayer llllllllllllllIIlIIllllIlIIIlIII, final World llllllllllllllIIlIIllllIIllllIll, BlockPos llllllllllllllIIlIIllllIIllllIlI, EnumFacing llllllllllllllIIlIIllllIIllllIIl, final float llllllllllllllIIlIIllllIIllllIII, final float llllllllllllllIIlIIllllIIlllIlll, final float llllllllllllllIIlIIllllIIlllIllI) {
        final IBlockState llllllllllllllIIlIIllllIlIIIIIIl = llllllllllllllIIlIIllllIIllllIll.getBlockState((BlockPos)llllllllllllllIIlIIllllIIllllIlI);
        final Block llllllllllllllIIlIIllllIlIIIIIII = llllllllllllllIIlIIllllIlIIIIIIl.getBlock();
        if (llllllllllllllIIlIIllllIlIIIIIII == Blocks.snow_layer && (int)llllllllllllllIIlIIllllIlIIIIIIl.getValue(BlockSnow.LAYERS_PROP) < 1) {
            llllllllllllllIIlIIllllIIllllIIl = EnumFacing.UP;
        }
        else if (!llllllllllllllIIlIIllllIlIIIIIII.isReplaceable(llllllllllllllIIlIIllllIIllllIll, (BlockPos)llllllllllllllIIlIIllllIIllllIlI)) {
            llllllllllllllIIlIIllllIIllllIlI = (Comparable<Integer>)((BlockPos)llllllllllllllIIlIIllllIIllllIlI).offset(llllllllllllllIIlIIllllIIllllIIl);
        }
        if (!llllllllllllllIIlIIllllIlIIIlIII.func_175151_a((BlockPos)llllllllllllllIIlIIllllIIllllIlI, llllllllllllllIIlIIllllIIllllIIl, llllllllllllllIIlIIllllIlIIIlIIl)) {
            return false;
        }
        if (llllllllllllllIIlIIllllIlIIIlIIl.stackSize == 0) {
            return false;
        }
        if (llllllllllllllIIlIIllllIIllllIll.canBlockBePlaced(this.field_150935_a, (BlockPos)llllllllllllllIIlIIllllIIllllIlI, false, llllllllllllllIIlIIllllIIllllIIl, null, llllllllllllllIIlIIllllIlIIIlIIl)) {
            IBlockState llllllllllllllIIlIIllllIIlllllll = this.field_150935_a.onBlockPlaced(llllllllllllllIIlIIllllIIllllIll, (BlockPos)llllllllllllllIIlIIllllIIllllIlI, llllllllllllllIIlIIllllIIllllIIl, llllllllllllllIIlIIllllIIllllIII, llllllllllllllIIlIIllllIIlllIlll, llllllllllllllIIlIIllllIIlllIllI, 0, llllllllllllllIIlIIllllIlIIIlIII);
            if (llllllllllllllIIlIIllllIIllllIll.setBlockState((BlockPos)llllllllllllllIIlIIllllIIllllIlI, llllllllllllllIIlIIllllIIlllllll, 3)) {
                llllllllllllllIIlIIllllIIlllllll = llllllllllllllIIlIIllllIIllllIll.getBlockState((BlockPos)llllllllllllllIIlIIllllIIllllIlI);
                if (llllllllllllllIIlIIllllIIlllllll.getBlock() == this.field_150935_a) {
                    ItemBlock.setTileEntityNBT(llllllllllllllIIlIIllllIIllllIll, (BlockPos)llllllllllllllIIlIIllllIIllllIlI, llllllllllllllIIlIIllllIlIIIlIIl);
                    llllllllllllllIIlIIllllIIlllllll.getBlock().onBlockPlacedBy(llllllllllllllIIlIIllllIIllllIll, (BlockPos)llllllllllllllIIlIIllllIIllllIlI, llllllllllllllIIlIIllllIIlllllll, llllllllllllllIIlIIllllIlIIIlIII, llllllllllllllIIlIIllllIlIIIlIIl);
                }
                llllllllllllllIIlIIllllIIllllIll.playSoundEffect(((Vec3i)llllllllllllllIIlIIllllIIllllIlI).getX() + 0.5f, ((Vec3i)llllllllllllllIIlIIllllIIllllIlI).getY() + 0.5f, ((Vec3i)llllllllllllllIIlIIllllIIllllIlI).getZ() + 0.5f, this.field_150935_a.stepSound.getPlaceSound(), (this.field_150935_a.stepSound.getVolume() + 1.0f) / 2.0f, this.field_150935_a.stepSound.getFrequency() * 0.8f);
                --llllllllllllllIIlIIllllIlIIIlIIl.stackSize;
                return true;
            }
        }
        return false;
    }
}
