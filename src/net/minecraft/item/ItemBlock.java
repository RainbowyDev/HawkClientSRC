package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;

public class ItemBlock extends Item
{
    protected final /* synthetic */ Block block;
    
    @Override
    public CreativeTabs getCreativeTab() {
        return this.block.getCreativeTabToDisplayOn();
    }
    
    static {
        __OBFID = "CL_00001772";
    }
    
    @Override
    public boolean onItemUse(final ItemStack lllllllllllllllIlIIlIlIIlIIIllIl, final EntityPlayer lllllllllllllllIlIIlIlIIlIIIllII, final World lllllllllllllllIlIIlIlIIlIIIlIll, BlockPos lllllllllllllllIlIIlIlIIIlllllIl, EnumFacing lllllllllllllllIlIIlIlIIIlllllII, final float lllllllllllllllIlIIlIlIIlIIIlIII, final float lllllllllllllllIlIIlIlIIlIIIIlll, final float lllllllllllllllIlIIlIlIIlIIIIllI) {
        final IBlockState lllllllllllllllIlIIlIlIIlIIIIlIl = lllllllllllllllIlIIlIlIIlIIIlIll.getBlockState((BlockPos)lllllllllllllllIlIIlIlIIIlllllIl);
        final Block lllllllllllllllIlIIlIlIIlIIIIlII = lllllllllllllllIlIIlIlIIlIIIIlIl.getBlock();
        if (lllllllllllllllIlIIlIlIIlIIIIlII == Blocks.snow_layer && (int)lllllllllllllllIlIIlIlIIlIIIIlIl.getValue(BlockSnow.LAYERS_PROP) < 1) {
            lllllllllllllllIlIIlIlIIIlllllII = EnumFacing.UP;
        }
        else if (!lllllllllllllllIlIIlIlIIlIIIIlII.isReplaceable(lllllllllllllllIlIIlIlIIlIIIlIll, (BlockPos)lllllllllllllllIlIIlIlIIIlllllIl)) {
            lllllllllllllllIlIIlIlIIIlllllIl = (Comparable<Boolean>)((BlockPos)lllllllllllllllIlIIlIlIIIlllllIl).offset(lllllllllllllllIlIIlIlIIIlllllII);
        }
        if (lllllllllllllllIlIIlIlIIlIIIllIl.stackSize == 0) {
            return false;
        }
        if (!lllllllllllllllIlIIlIlIIlIIIllII.func_175151_a((BlockPos)lllllllllllllllIlIIlIlIIIlllllIl, lllllllllllllllIlIIlIlIIIlllllII, lllllllllllllllIlIIlIlIIlIIIllIl)) {
            return false;
        }
        if (((Vec3i)lllllllllllllllIlIIlIlIIIlllllIl).getY() == 255 && this.block.getMaterial().isSolid()) {
            return false;
        }
        if (lllllllllllllllIlIIlIlIIlIIIlIll.canBlockBePlaced(this.block, (BlockPos)lllllllllllllllIlIIlIlIIIlllllIl, false, lllllllllllllllIlIIlIlIIIlllllII, null, lllllllllllllllIlIIlIlIIlIIIllIl)) {
            final int lllllllllllllllIlIIlIlIIlIIIIIll = this.getMetadata(lllllllllllllllIlIIlIlIIlIIIllIl.getMetadata());
            IBlockState lllllllllllllllIlIIlIlIIlIIIIIlI = this.block.onBlockPlaced(lllllllllllllllIlIIlIlIIlIIIlIll, (BlockPos)lllllllllllllllIlIIlIlIIIlllllIl, lllllllllllllllIlIIlIlIIIlllllII, lllllllllllllllIlIIlIlIIlIIIlIII, lllllllllllllllIlIIlIlIIlIIIIlll, lllllllllllllllIlIIlIlIIlIIIIllI, lllllllllllllllIlIIlIlIIlIIIIIll, lllllllllllllllIlIIlIlIIlIIIllII);
            if (lllllllllllllllIlIIlIlIIlIIIlIll.setBlockState((BlockPos)lllllllllllllllIlIIlIlIIIlllllIl, lllllllllllllllIlIIlIlIIlIIIIIlI, 3)) {
                lllllllllllllllIlIIlIlIIlIIIIIlI = lllllllllllllllIlIIlIlIIlIIIlIll.getBlockState((BlockPos)lllllllllllllllIlIIlIlIIIlllllIl);
                if (lllllllllllllllIlIIlIlIIlIIIIIlI.getBlock() == this.block) {
                    setTileEntityNBT(lllllllllllllllIlIIlIlIIlIIIlIll, (BlockPos)lllllllllllllllIlIIlIlIIIlllllIl, lllllllllllllllIlIIlIlIIlIIIllIl);
                    this.block.onBlockPlacedBy(lllllllllllllllIlIIlIlIIlIIIlIll, (BlockPos)lllllllllllllllIlIIlIlIIIlllllIl, lllllllllllllllIlIIlIlIIlIIIIIlI, lllllllllllllllIlIIlIlIIlIIIllII, lllllllllllllllIlIIlIlIIlIIIllIl);
                }
                lllllllllllllllIlIIlIlIIlIIIlIll.playSoundEffect(((Vec3i)lllllllllllllllIlIIlIlIIIlllllIl).getX() + 0.5f, ((Vec3i)lllllllllllllllIlIIlIlIIIlllllIl).getY() + 0.5f, ((Vec3i)lllllllllllllllIlIIlIlIIIlllllIl).getZ() + 0.5f, this.block.stepSound.getPlaceSound(), (this.block.stepSound.getVolume() + 1.0f) / 2.0f, this.block.stepSound.getFrequency() * 0.8f);
                --lllllllllllllllIlIIlIlIIlIIIllIl.stackSize;
            }
            return true;
        }
        return false;
    }
    
    @Override
    public ItemBlock setUnlocalizedName(final String lllllllllllllllIlIIlIlIIlIIllllI) {
        super.setUnlocalizedName(lllllllllllllllIlIIlIlIIlIIllllI);
        return this;
    }
    
    @Override
    public String getUnlocalizedName(final ItemStack lllllllllllllllIlIIlIlIIIlIIlIlI) {
        return this.block.getUnlocalizedName();
    }
    
    public boolean canPlaceBlockOnSide(final World lllllllllllllllIlIIlIlIIIlIllIII, BlockPos lllllllllllllllIlIIlIlIIIlIlIIII, EnumFacing lllllllllllllllIlIIlIlIIIlIIllll, final EntityPlayer lllllllllllllllIlIIlIlIIIlIlIlIl, final ItemStack lllllllllllllllIlIIlIlIIIlIIlllI) {
        final Block lllllllllllllllIlIIlIlIIIlIlIIll = lllllllllllllllIlIIlIlIIIlIllIII.getBlockState((BlockPos)lllllllllllllllIlIIlIlIIIlIlIIII).getBlock();
        if (lllllllllllllllIlIIlIlIIIlIlIIll == Blocks.snow_layer) {
            lllllllllllllllIlIIlIlIIIlIIllll = EnumFacing.UP;
        }
        else if (!lllllllllllllllIlIIlIlIIIlIlIIll.isReplaceable(lllllllllllllllIlIIlIlIIIlIllIII, (BlockPos)lllllllllllllllIlIIlIlIIIlIlIIII)) {
            lllllllllllllllIlIIlIlIIIlIlIIII = (Comparable<Character>)((BlockPos)lllllllllllllllIlIIlIlIIIlIlIIII).offset((EnumFacing)lllllllllllllllIlIIlIlIIIlIIllll);
        }
        return lllllllllllllllIlIIlIlIIIlIllIII.canBlockBePlaced(this.block, (BlockPos)lllllllllllllllIlIIlIlIIIlIlIIII, false, (EnumFacing)lllllllllllllllIlIIlIlIIIlIIllll, null, lllllllllllllllIlIIlIlIIIlIIlllI);
    }
    
    public Block getBlock() {
        return this.block;
    }
    
    public ItemBlock(final Block lllllllllllllllIlIIlIlIIlIlIIIlI) {
        this.block = lllllllllllllllIlIIlIlIIlIlIIIlI;
    }
    
    @Override
    public void getSubItems(final Item lllllllllllllllIlIIlIlIIIIllllIl, final CreativeTabs lllllllllllllllIlIIlIlIIIIlllIII, final List lllllllllllllllIlIIlIlIIIIllIlll) {
        this.block.getSubBlocks(lllllllllllllllIlIIlIlIIIIllllIl, lllllllllllllllIlIIlIlIIIIlllIII, lllllllllllllllIlIIlIlIIIIllIlll);
    }
    
    public static boolean setTileEntityNBT(final World lllllllllllllllIlIIlIlIIIllIllIl, final BlockPos lllllllllllllllIlIIlIlIIIllIIlIl, final ItemStack lllllllllllllllIlIIlIlIIIllIlIll) {
        if (lllllllllllllllIlIIlIlIIIllIlIll.hasTagCompound() && lllllllllllllllIlIIlIlIIIllIlIll.getTagCompound().hasKey("BlockEntityTag", 10)) {
            final TileEntity lllllllllllllllIlIIlIlIIIllIlIlI = lllllllllllllllIlIIlIlIIIllIllIl.getTileEntity(lllllllllllllllIlIIlIlIIIllIIlIl);
            if (lllllllllllllllIlIIlIlIIIllIlIlI != null) {
                final NBTTagCompound lllllllllllllllIlIIlIlIIIllIlIIl = new NBTTagCompound();
                final NBTTagCompound lllllllllllllllIlIIlIlIIIllIlIII = (NBTTagCompound)lllllllllllllllIlIIlIlIIIllIlIIl.copy();
                lllllllllllllllIlIIlIlIIIllIlIlI.writeToNBT(lllllllllllllllIlIIlIlIIIllIlIIl);
                final NBTTagCompound lllllllllllllllIlIIlIlIIIllIIlll = (NBTTagCompound)lllllllllllllllIlIIlIlIIIllIlIll.getTagCompound().getTag("BlockEntityTag");
                lllllllllllllllIlIIlIlIIIllIlIIl.merge(lllllllllllllllIlIIlIlIIIllIIlll);
                lllllllllllllllIlIIlIlIIIllIlIIl.setInteger("x", lllllllllllllllIlIIlIlIIIllIIlIl.getX());
                lllllllllllllllIlIIlIlIIIllIlIIl.setInteger("y", lllllllllllllllIlIIlIlIIIllIIlIl.getY());
                lllllllllllllllIlIIlIlIIIllIlIIl.setInteger("z", lllllllllllllllIlIIlIlIIIllIIlIl.getZ());
                if (!lllllllllllllllIlIIlIlIIIllIlIIl.equals(lllllllllllllllIlIIlIlIIIllIlIII)) {
                    lllllllllllllllIlIIlIlIIIllIlIlI.readFromNBT(lllllllllllllllIlIIlIlIIIllIlIIl);
                    lllllllllllllllIlIIlIlIIIllIlIlI.markDirty();
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public String getUnlocalizedName() {
        return this.block.getUnlocalizedName();
    }
}
