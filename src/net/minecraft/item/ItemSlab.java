package net.minecraft.item;

import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;

public class ItemSlab extends ItemBlock
{
    private final /* synthetic */ BlockSlab field_179226_c;
    private final /* synthetic */ BlockSlab field_150949_c;
    
    public ItemSlab(final Block lllllllllllllllIllIIllIIllIIIIll, final BlockSlab lllllllllllllllIllIIllIIllIIIIlI, final BlockSlab lllllllllllllllIllIIllIIllIIIlIl) {
        super(lllllllllllllllIllIIllIIllIIIIll);
        this.field_150949_c = lllllllllllllllIllIIllIIllIIIIlI;
        this.field_179226_c = lllllllllllllllIllIIllIIllIIIlIl;
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }
    
    @Override
    public boolean onItemUse(final ItemStack lllllllllllllllIllIIllIIlIlIIllI, final EntityPlayer lllllllllllllllIllIIllIIlIlIIlIl, final World lllllllllllllllIllIIllIIlIIlIlIl, final BlockPos lllllllllllllllIllIIllIIlIlIIIll, final EnumFacing lllllllllllllllIllIIllIIlIIlIIll, final float lllllllllllllllIllIIllIIlIlIIIIl, final float lllllllllllllllIllIIllIIlIlIIIII, final float lllllllllllllllIllIIllIIlIIlllll) {
        if (lllllllllllllllIllIIllIIlIlIIllI.stackSize == 0) {
            return false;
        }
        if (!lllllllllllllllIllIIllIIlIlIIlIl.func_175151_a(lllllllllllllllIllIIllIIlIlIIIll.offset(lllllllllllllllIllIIllIIlIIlIIll), lllllllllllllllIllIIllIIlIIlIIll, lllllllllllllllIllIIllIIlIlIIllI)) {
            return false;
        }
        final Object lllllllllllllllIllIIllIIlIIllllI = this.field_150949_c.func_176553_a(lllllllllllllllIllIIllIIlIlIIllI);
        final IBlockState lllllllllllllllIllIIllIIlIIlllIl = lllllllllllllllIllIIllIIlIIlIlIl.getBlockState(lllllllllllllllIllIIllIIlIlIIIll);
        if (lllllllllllllllIllIIllIIlIIlllIl.getBlock() == this.field_150949_c) {
            final IProperty lllllllllllllllIllIIllIIlIIlllII = this.field_150949_c.func_176551_l();
            final Comparable lllllllllllllllIllIIllIIlIIllIll = lllllllllllllllIllIIllIIlIIlllIl.getValue(lllllllllllllllIllIIllIIlIIlllII);
            final BlockSlab.EnumBlockHalf lllllllllllllllIllIIllIIlIIllIlI = (BlockSlab.EnumBlockHalf)lllllllllllllllIllIIllIIlIIlllIl.getValue(BlockSlab.HALF_PROP);
            if (((lllllllllllllllIllIIllIIlIIlIIll == EnumFacing.UP && lllllllllllllllIllIIllIIlIIllIlI == BlockSlab.EnumBlockHalf.BOTTOM) || (lllllllllllllllIllIIllIIlIIlIIll == EnumFacing.DOWN && lllllllllllllllIllIIllIIlIIllIlI == BlockSlab.EnumBlockHalf.TOP)) && lllllllllllllllIllIIllIIlIIllIll == lllllllllllllllIllIIllIIlIIllllI) {
                final IBlockState lllllllllllllllIllIIllIIlIIllIIl = this.field_179226_c.getDefaultState().withProperty(lllllllllllllllIllIIllIIlIIlllII, lllllllllllllllIllIIllIIlIIllIll);
                if (lllllllllllllllIllIIllIIlIIlIlIl.checkNoEntityCollision(this.field_179226_c.getCollisionBoundingBox(lllllllllllllllIllIIllIIlIIlIlIl, lllllllllllllllIllIIllIIlIlIIIll, lllllllllllllllIllIIllIIlIIllIIl)) && lllllllllllllllIllIIllIIlIIlIlIl.setBlockState(lllllllllllllllIllIIllIIlIlIIIll, lllllllllllllllIllIIllIIlIIllIIl, 3)) {
                    lllllllllllllllIllIIllIIlIIlIlIl.playSoundEffect(lllllllllllllllIllIIllIIlIlIIIll.getX() + 0.5f, lllllllllllllllIllIIllIIlIlIIIll.getY() + 0.5f, lllllllllllllllIllIIllIIlIlIIIll.getZ() + 0.5f, this.field_179226_c.stepSound.getPlaceSound(), (this.field_179226_c.stepSound.getVolume() + 1.0f) / 2.0f, this.field_179226_c.stepSound.getFrequency() * 0.8f);
                    --lllllllllllllllIllIIllIIlIlIIllI.stackSize;
                }
                return true;
            }
        }
        return this.func_180615_a(lllllllllllllllIllIIllIIlIlIIllI, lllllllllllllllIllIIllIIlIIlIlIl, lllllllllllllllIllIIllIIlIlIIIll.offset(lllllllllllllllIllIIllIIlIIlIIll), lllllllllllllllIllIIllIIlIIllllI) || super.onItemUse(lllllllllllllllIllIIllIIlIlIIllI, lllllllllllllllIllIIllIIlIlIIlIl, lllllllllllllllIllIIllIIlIIlIlIl, lllllllllllllllIllIIllIIlIlIIIll, lllllllllllllllIllIIllIIlIIlIIll, lllllllllllllllIllIIllIIlIlIIIIl, lllllllllllllllIllIIllIIlIlIIIII, lllllllllllllllIllIIllIIlIIlllll);
    }
    
    static {
        __OBFID = "CL_00000071";
    }
    
    @Override
    public String getUnlocalizedName(final ItemStack lllllllllllllllIllIIllIIlIllIlll) {
        return this.field_150949_c.getFullSlabName(lllllllllllllllIllIIllIIlIllIlll.getMetadata());
    }
    
    @Override
    public boolean canPlaceBlockOnSide(final World lllllllllllllllIllIIllIIIlllllIl, BlockPos lllllllllllllllIllIIllIIIlllIIII, final EnumFacing lllllllllllllllIllIIllIIIllllIll, final EntityPlayer lllllllllllllllIllIIllIIIllllIlI, final ItemStack lllllllllllllllIllIIllIIIllIllIl) {
        final BlockPos lllllllllllllllIllIIllIIIllllIII = lllllllllllllllIllIIllIIIlllIIII;
        final IProperty lllllllllllllllIllIIllIIIlllIlll = this.field_150949_c.func_176551_l();
        final Object lllllllllllllllIllIIllIIIlllIllI = this.field_150949_c.func_176553_a(lllllllllllllllIllIIllIIIllIllIl);
        final IBlockState lllllllllllllllIllIIllIIIlllIlIl = lllllllllllllllIllIIllIIIlllllIl.getBlockState(lllllllllllllllIllIIllIIIlllIIII);
        if (lllllllllllllllIllIIllIIIlllIlIl.getBlock() == this.field_150949_c) {
            final boolean lllllllllllllllIllIIllIIIlllIlII = lllllllllllllllIllIIllIIIlllIlIl.getValue(BlockSlab.HALF_PROP) == BlockSlab.EnumBlockHalf.TOP;
            if (((lllllllllllllllIllIIllIIIllllIll == EnumFacing.UP && !lllllllllllllllIllIIllIIIlllIlII) || (lllllllllllllllIllIIllIIIllllIll == EnumFacing.DOWN && lllllllllllllllIllIIllIIIlllIlII)) && lllllllllllllllIllIIllIIIlllIllI == lllllllllllllllIllIIllIIIlllIlIl.getValue(lllllllllllllllIllIIllIIIlllIlll)) {
                return true;
            }
        }
        lllllllllllllllIllIIllIIIlllIIII = lllllllllllllllIllIIllIIIlllIIII.offset(lllllllllllllllIllIIllIIIllllIll);
        final IBlockState lllllllllllllllIllIIllIIIlllIIll = lllllllllllllllIllIIllIIIlllllIl.getBlockState(lllllllllllllllIllIIllIIIlllIIII);
        return (lllllllllllllllIllIIllIIIlllIIll.getBlock() == this.field_150949_c && lllllllllllllllIllIIllIIIlllIllI == lllllllllllllllIllIIllIIIlllIIll.getValue(lllllllllllllllIllIIllIIIlllIlll)) || super.canPlaceBlockOnSide(lllllllllllllllIllIIllIIIlllllIl, lllllllllllllllIllIIllIIIllllIII, lllllllllllllllIllIIllIIIllllIll, lllllllllllllllIllIIllIIIllllIlI, lllllllllllllllIllIIllIIIllIllIl);
    }
    
    @Override
    public int getMetadata(final int lllllllllllllllIllIIllIIlIlllllI) {
        return lllllllllllllllIllIIllIIlIlllllI;
    }
    
    private boolean func_180615_a(final ItemStack lllllllllllllllIllIIllIIIlIllllI, final World lllllllllllllllIllIIllIIIlIlllIl, final BlockPos lllllllllllllllIllIIllIIIlIlIlII, final Object lllllllllllllllIllIIllIIIlIlIIll) {
        final IBlockState lllllllllllllllIllIIllIIIlIllIlI = lllllllllllllllIllIIllIIIlIlllIl.getBlockState(lllllllllllllllIllIIllIIIlIlIlII);
        if (lllllllllllllllIllIIllIIIlIllIlI.getBlock() == this.field_150949_c) {
            final Comparable lllllllllllllllIllIIllIIIlIllIIl = lllllllllllllllIllIIllIIIlIllIlI.getValue(this.field_150949_c.func_176551_l());
            if (lllllllllllllllIllIIllIIIlIllIIl == lllllllllllllllIllIIllIIIlIlIIll) {
                final IBlockState lllllllllllllllIllIIllIIIlIllIII = this.field_179226_c.getDefaultState().withProperty(this.field_150949_c.func_176551_l(), lllllllllllllllIllIIllIIIlIllIIl);
                if (lllllllllllllllIllIIllIIIlIlllIl.checkNoEntityCollision(this.field_179226_c.getCollisionBoundingBox(lllllllllllllllIllIIllIIIlIlllIl, lllllllllllllllIllIIllIIIlIlIlII, lllllllllllllllIllIIllIIIlIllIII)) && lllllllllllllllIllIIllIIIlIlllIl.setBlockState(lllllllllllllllIllIIllIIIlIlIlII, lllllllllllllllIllIIllIIIlIllIII, 3)) {
                    lllllllllllllllIllIIllIIIlIlllIl.playSoundEffect(lllllllllllllllIllIIllIIIlIlIlII.getX() + 0.5f, lllllllllllllllIllIIllIIIlIlIlII.getY() + 0.5f, lllllllllllllllIllIIllIIIlIlIlII.getZ() + 0.5f, this.field_179226_c.stepSound.getPlaceSound(), (this.field_179226_c.stepSound.getVolume() + 1.0f) / 2.0f, this.field_179226_c.stepSound.getFrequency() * 0.8f);
                    --lllllllllllllllIllIIllIIIlIllllI.stackSize;
                }
                return true;
            }
        }
        return false;
    }
}
