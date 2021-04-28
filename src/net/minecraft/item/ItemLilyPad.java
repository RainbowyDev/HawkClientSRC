package net.minecraft.item;

import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.stats.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;

public class ItemLilyPad extends ItemColored
{
    @Override
    public int getColorFromItemStack(final ItemStack llllllllllllllllIlIIIllIIIlIIIlI, final int llllllllllllllllIlIIIllIIIlIIIll) {
        return Blocks.waterlily.getRenderColor(Blocks.waterlily.getStateFromMeta(llllllllllllllllIlIIIllIIIlIIIlI.getMetadata()));
    }
    
    public ItemLilyPad(final Block llllllllllllllllIlIIIllIIIllllll) {
        super(llllllllllllllllIlIIIllIIIllllll, false);
    }
    
    static {
        __OBFID = "CL_00000074";
    }
    
    @Override
    public ItemStack onItemRightClick(final ItemStack llllllllllllllllIlIIIllIIIlIllIl, final World llllllllllllllllIlIIIllIIIlIllII, final EntityPlayer llllllllllllllllIlIIIllIIIlIlIll) {
        final MovingObjectPosition llllllllllllllllIlIIIllIIIllIIlI = this.getMovingObjectPositionFromPlayer(llllllllllllllllIlIIIllIIIlIllII, llllllllllllllllIlIIIllIIIlIlIll, true);
        if (llllllllllllllllIlIIIllIIIllIIlI == null) {
            return llllllllllllllllIlIIIllIIIlIllIl;
        }
        if (llllllllllllllllIlIIIllIIIllIIlI.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            final BlockPos llllllllllllllllIlIIIllIIIllIIIl = llllllllllllllllIlIIIllIIIllIIlI.func_178782_a();
            if (!llllllllllllllllIlIIIllIIIlIllII.isBlockModifiable(llllllllllllllllIlIIIllIIIlIlIll, llllllllllllllllIlIIIllIIIllIIIl)) {
                return llllllllllllllllIlIIIllIIIlIllIl;
            }
            if (!llllllllllllllllIlIIIllIIIlIlIll.func_175151_a(llllllllllllllllIlIIIllIIIllIIIl.offset(llllllllllllllllIlIIIllIIIllIIlI.field_178784_b), llllllllllllllllIlIIIllIIIllIIlI.field_178784_b, llllllllllllllllIlIIIllIIIlIllIl)) {
                return llllllllllllllllIlIIIllIIIlIllIl;
            }
            final BlockPos llllllllllllllllIlIIIllIIIllIIII = llllllllllllllllIlIIIllIIIllIIIl.offsetUp();
            final IBlockState llllllllllllllllIlIIIllIIIlIllll = llllllllllllllllIlIIIllIIIlIllII.getBlockState(llllllllllllllllIlIIIllIIIllIIIl);
            if (llllllllllllllllIlIIIllIIIlIllll.getBlock().getMaterial() == Material.water && (int)llllllllllllllllIlIIIllIIIlIllll.getValue(BlockLiquid.LEVEL) == 0 && llllllllllllllllIlIIIllIIIlIllII.isAirBlock(llllllllllllllllIlIIIllIIIllIIII)) {
                llllllllllllllllIlIIIllIIIlIllII.setBlockState(llllllllllllllllIlIIIllIIIllIIII, Blocks.waterlily.getDefaultState());
                if (!llllllllllllllllIlIIIllIIIlIlIll.capabilities.isCreativeMode) {
                    --llllllllllllllllIlIIIllIIIlIllIl.stackSize;
                }
                llllllllllllllllIlIIIllIIIlIlIll.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
            }
        }
        return llllllllllllllllIlIIIllIIIlIllIl;
    }
}
