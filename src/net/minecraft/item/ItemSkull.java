package net.minecraft.item;

import com.mojang.authlib.*;
import net.minecraft.nbt.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.tileentity.*;

public class ItemSkull extends Item
{
    private static final /* synthetic */ String[] skullTypes;
    
    @Override
    public int getMetadata(final int lllllllllllllllIIIIlllIlIlIlllIl) {
        return lllllllllllllllIIIIlllIlIlIlllIl;
    }
    
    static {
        __OBFID = "CL_00000067";
        skullTypes = new String[] { "skeleton", "wither", "zombie", "char", "creeper" };
    }
    
    @Override
    public boolean updateItemStackNBT(final NBTTagCompound lllllllllllllllIIIIlllIlIlIIIIlI) {
        super.updateItemStackNBT(lllllllllllllllIIIIlllIlIlIIIIlI);
        if (lllllllllllllllIIIIlllIlIlIIIIlI.hasKey("SkullOwner", 8) && lllllllllllllllIIIIlllIlIlIIIIlI.getString("SkullOwner").length() > 0) {
            GameProfile lllllllllllllllIIIIlllIlIlIIIlII = new GameProfile((UUID)null, lllllllllllllllIIIIlllIlIlIIIIlI.getString("SkullOwner"));
            lllllllllllllllIIIIlllIlIlIIIlII = TileEntitySkull.updateGameprofile(lllllllllllllllIIIIlllIlIlIIIlII);
            lllllllllllllllIIIIlllIlIlIIIIlI.setTag("SkullOwner", NBTUtil.writeGameProfile(new NBTTagCompound(), lllllllllllllllIIIIlllIlIlIIIlII));
            return true;
        }
        return false;
    }
    
    @Override
    public String getItemStackDisplayName(final ItemStack lllllllllllllllIIIIlllIlIlIIlllI) {
        if (lllllllllllllllIIIIlllIlIlIIlllI.getMetadata() == 3 && lllllllllllllllIIIIlllIlIlIIlllI.hasTagCompound()) {
            if (lllllllllllllllIIIIlllIlIlIIlllI.getTagCompound().hasKey("SkullOwner", 8)) {
                return StatCollector.translateToLocalFormatted("item.skull.player.name", lllllllllllllllIIIIlllIlIlIIlllI.getTagCompound().getString("SkullOwner"));
            }
            if (lllllllllllllllIIIIlllIlIlIIlllI.getTagCompound().hasKey("SkullOwner", 10)) {
                final NBTTagCompound lllllllllllllllIIIIlllIlIlIIllIl = lllllllllllllllIIIIlllIlIlIIlllI.getTagCompound().getCompoundTag("SkullOwner");
                if (lllllllllllllllIIIIlllIlIlIIllIl.hasKey("Name", 8)) {
                    return StatCollector.translateToLocalFormatted("item.skull.player.name", lllllllllllllllIIIIlllIlIlIIllIl.getString("Name"));
                }
            }
        }
        return super.getItemStackDisplayName(lllllllllllllllIIIIlllIlIlIIlllI);
    }
    
    @Override
    public void getSubItems(final Item lllllllllllllllIIIIlllIlIllIIIlI, final CreativeTabs lllllllllllllllIIIIlllIlIllIIlIl, final List lllllllllllllllIIIIlllIlIllIIlII) {
        for (int lllllllllllllllIIIIlllIlIllIIIll = 0; lllllllllllllllIIIIlllIlIllIIIll < ItemSkull.skullTypes.length; ++lllllllllllllllIIIIlllIlIllIIIll) {
            lllllllllllllllIIIIlllIlIllIIlII.add(new ItemStack(lllllllllllllllIIIIlllIlIllIIIlI, 1, lllllllllllllllIIIIlllIlIllIIIll));
        }
    }
    
    @Override
    public String getUnlocalizedName(final ItemStack lllllllllllllllIIIIlllIlIlIlIlII) {
        int lllllllllllllllIIIIlllIlIlIlIllI = lllllllllllllllIIIIlllIlIlIlIlII.getMetadata();
        if (lllllllllllllllIIIIlllIlIlIlIllI < 0 || lllllllllllllllIIIIlllIlIlIlIllI >= ItemSkull.skullTypes.length) {
            lllllllllllllllIIIIlllIlIlIlIllI = 0;
        }
        return String.valueOf(new StringBuilder(String.valueOf(super.getUnlocalizedName())).append(".").append(ItemSkull.skullTypes[lllllllllllllllIIIIlllIlIlIlIllI]));
    }
    
    @Override
    public boolean onItemUse(final ItemStack lllllllllllllllIIIIlllIlIlllIlll, final EntityPlayer lllllllllllllllIIIIlllIllIIIIllI, final World lllllllllllllllIIIIlllIlIlllIlIl, BlockPos lllllllllllllllIIIIlllIlIlllIlII, final EnumFacing lllllllllllllllIIIIlllIllIIIIIll, final float lllllllllllllllIIIIlllIllIIIIIlI, final float lllllllllllllllIIIIlllIllIIIIIIl, final float lllllllllllllllIIIIlllIllIIIIIII) {
        if (lllllllllllllllIIIIlllIllIIIIIll == EnumFacing.DOWN) {
            return false;
        }
        final IBlockState lllllllllllllllIIIIlllIlIlllllll = lllllllllllllllIIIIlllIlIlllIlIl.getBlockState((BlockPos)lllllllllllllllIIIIlllIlIlllIlII);
        final Block lllllllllllllllIIIIlllIlIllllllI = lllllllllllllllIIIIlllIlIlllllll.getBlock();
        final boolean lllllllllllllllIIIIlllIlIlllllIl = lllllllllllllllIIIIlllIlIllllllI.isReplaceable(lllllllllllllllIIIIlllIlIlllIlIl, (BlockPos)lllllllllllllllIIIIlllIlIlllIlII);
        if (!lllllllllllllllIIIIlllIlIlllllIl) {
            if (!lllllllllllllllIIIIlllIlIlllIlIl.getBlockState((BlockPos)lllllllllllllllIIIIlllIlIlllIlII).getBlock().getMaterial().isSolid()) {
                return false;
            }
            lllllllllllllllIIIIlllIlIlllIlII = (Comparable<Double>)((BlockPos)lllllllllllllllIIIIlllIlIlllIlII).offset(lllllllllllllllIIIIlllIllIIIIIll);
        }
        if (!lllllllllllllllIIIIlllIllIIIIllI.func_175151_a((BlockPos)lllllllllllllllIIIIlllIlIlllIlII, lllllllllllllllIIIIlllIllIIIIIll, lllllllllllllllIIIIlllIlIlllIlll)) {
            return false;
        }
        if (!Blocks.skull.canPlaceBlockAt(lllllllllllllllIIIIlllIlIlllIlIl, (BlockPos)lllllllllllllllIIIIlllIlIlllIlII)) {
            return false;
        }
        if (!lllllllllllllllIIIIlllIlIlllIlIl.isRemote) {
            lllllllllllllllIIIIlllIlIlllIlIl.setBlockState((BlockPos)lllllllllllllllIIIIlllIlIlllIlII, Blocks.skull.getDefaultState().withProperty(BlockSkull.field_176418_a, lllllllllllllllIIIIlllIllIIIIIll), 3);
            int lllllllllllllllIIIIlllIlIlllllII = 0;
            if (lllllllllllllllIIIIlllIllIIIIIll == EnumFacing.UP) {
                lllllllllllllllIIIIlllIlIlllllII = (MathHelper.floor_double(lllllllllllllllIIIIlllIllIIIIllI.rotationYaw * 16.0f / 360.0f + 0.5) & 0xF);
            }
            final TileEntity lllllllllllllllIIIIlllIlIllllIll = lllllllllllllllIIIIlllIlIlllIlIl.getTileEntity((BlockPos)lllllllllllllllIIIIlllIlIlllIlII);
            if (lllllllllllllllIIIIlllIlIllllIll instanceof TileEntitySkull) {
                final TileEntitySkull lllllllllllllllIIIIlllIlIllllIlI = (TileEntitySkull)lllllllllllllllIIIIlllIlIllllIll;
                if (lllllllllllllllIIIIlllIlIlllIlll.getMetadata() == 3) {
                    GameProfile lllllllllllllllIIIIlllIlIllllIIl = null;
                    if (lllllllllllllllIIIIlllIlIlllIlll.hasTagCompound()) {
                        final NBTTagCompound lllllllllllllllIIIIlllIlIllllIII = lllllllllllllllIIIIlllIlIlllIlll.getTagCompound();
                        if (lllllllllllllllIIIIlllIlIllllIII.hasKey("SkullOwner", 10)) {
                            lllllllllllllllIIIIlllIlIllllIIl = NBTUtil.readGameProfileFromNBT(lllllllllllllllIIIIlllIlIllllIII.getCompoundTag("SkullOwner"));
                        }
                        else if (lllllllllllllllIIIIlllIlIllllIII.hasKey("SkullOwner", 8) && lllllllllllllllIIIIlllIlIllllIII.getString("SkullOwner").length() > 0) {
                            lllllllllllllllIIIIlllIlIllllIIl = new GameProfile((UUID)null, lllllllllllllllIIIIlllIlIllllIII.getString("SkullOwner"));
                        }
                    }
                    lllllllllllllllIIIIlllIlIllllIlI.setPlayerProfile(lllllllllllllllIIIIlllIlIllllIIl);
                }
                else {
                    lllllllllllllllIIIIlllIlIllllIlI.setType(lllllllllllllllIIIIlllIlIlllIlll.getMetadata());
                }
                lllllllllllllllIIIIlllIlIllllIlI.setSkullRotation(lllllllllllllllIIIIlllIlIlllllII);
                Blocks.skull.func_180679_a(lllllllllllllllIIIIlllIlIlllIlIl, (BlockPos)lllllllllllllllIIIIlllIlIlllIlII, lllllllllllllllIIIIlllIlIllllIlI);
            }
            --lllllllllllllllIIIIlllIlIlllIlll.stackSize;
        }
        return true;
    }
    
    public ItemSkull() {
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }
}
