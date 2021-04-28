package net.minecraft.item;

import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;

public class ItemSnow extends ItemBlock
{
    @Override
    public boolean onItemUse(final ItemStack llllllllllllllIlIlIllIIlllllIIll, final EntityPlayer llllllllllllllIlIlIllIIllllIIlIl, final World llllllllllllllIlIlIllIIllllIIlII, BlockPos llllllllllllllIlIlIllIIllllIIIll, final EnumFacing llllllllllllllIlIlIllIIllllIIIlI, final float llllllllllllllIlIlIllIIllllIlllI, final float llllllllllllllIlIlIllIIllllIllIl, final float llllllllllllllIlIlIllIIllllIllII) {
        if (llllllllllllllIlIlIllIIlllllIIll.stackSize == 0) {
            return false;
        }
        if (!llllllllllllllIlIlIllIIllllIIlIl.func_175151_a(llllllllllllllIlIlIllIIllllIIIll, llllllllllllllIlIlIllIIllllIIIlI, llllllllllllllIlIlIllIIlllllIIll)) {
            return false;
        }
        IBlockState llllllllllllllIlIlIllIIllllIlIll = llllllllllllllIlIlIllIIllllIIlII.getBlockState(llllllllllllllIlIlIllIIllllIIIll);
        Block llllllllllllllIlIlIllIIllllIlIlI = llllllllllllllIlIlIllIIllllIlIll.getBlock();
        if (llllllllllllllIlIlIllIIllllIlIlI != this.block && llllllllllllllIlIlIllIIllllIIIlI != EnumFacing.UP) {
            llllllllllllllIlIlIllIIllllIIIll = llllllllllllllIlIlIllIIllllIIIll.offset(llllllllllllllIlIlIllIIllllIIIlI);
            llllllllllllllIlIlIllIIllllIlIll = llllllllllllllIlIlIllIIllllIIlII.getBlockState(llllllllllllllIlIlIllIIllllIIIll);
            llllllllllllllIlIlIllIIllllIlIlI = llllllllllllllIlIlIllIIllllIlIll.getBlock();
        }
        if (llllllllllllllIlIlIllIIllllIlIlI == this.block) {
            final int llllllllllllllIlIlIllIIllllIlIIl = (int)llllllllllllllIlIlIllIIllllIlIll.getValue(BlockSnow.LAYERS_PROP);
            if (llllllllllllllIlIlIllIIllllIlIIl <= 7) {
                final IBlockState llllllllllllllIlIlIllIIllllIlIII = llllllllllllllIlIlIllIIllllIlIll.withProperty(BlockSnow.LAYERS_PROP, llllllllllllllIlIlIllIIllllIlIIl + 1);
                if (llllllllllllllIlIlIllIIllllIIlII.checkNoEntityCollision(this.block.getCollisionBoundingBox(llllllllllllllIlIlIllIIllllIIlII, llllllllllllllIlIlIllIIllllIIIll, llllllllllllllIlIlIllIIllllIlIII)) && llllllllllllllIlIlIllIIllllIIlII.setBlockState(llllllllllllllIlIlIllIIllllIIIll, llllllllllllllIlIlIllIIllllIlIII, 2)) {
                    llllllllllllllIlIlIllIIllllIIlII.playSoundEffect(llllllllllllllIlIlIllIIllllIIIll.getX() + 0.5f, llllllllllllllIlIlIllIIllllIIIll.getY() + 0.5f, llllllllllllllIlIlIllIIllllIIIll.getZ() + 0.5f, this.block.stepSound.getPlaceSound(), (this.block.stepSound.getVolume() + 1.0f) / 2.0f, this.block.stepSound.getFrequency() * 0.8f);
                    --llllllllllllllIlIlIllIIlllllIIll.stackSize;
                    return true;
                }
            }
        }
        return super.onItemUse(llllllllllllllIlIlIllIIlllllIIll, llllllllllllllIlIlIllIIllllIIlIl, llllllllllllllIlIlIllIIllllIIlII, llllllllllllllIlIlIllIIllllIIIll, llllllllllllllIlIlIllIIllllIIIlI, llllllllllllllIlIlIllIIllllIlllI, llllllllllllllIlIlIllIIllllIllIl, llllllllllllllIlIlIllIIllllIllII);
    }
    
    static {
        __OBFID = "CL_00000068";
    }
    
    public ItemSnow(final Block llllllllllllllIlIlIllIlIIIIIIIlI) {
        super(llllllllllllllIlIlIllIlIIIIIIIlI);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }
    
    @Override
    public int getMetadata(final int llllllllllllllIlIlIllIIlllIlIlll) {
        return llllllllllllllIlIlIllIIlllIlIlll;
    }
}
