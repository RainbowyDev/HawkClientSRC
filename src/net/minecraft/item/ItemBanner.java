package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.init.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.*;
import net.minecraft.tileentity.*;
import java.util.*;
import net.minecraft.nbt.*;

public class ItemBanner extends ItemBlock
{
    @Override
    public CreativeTabs getCreativeTab() {
        return CreativeTabs.tabDecorations;
    }
    
    private EnumDyeColor func_179225_h(final ItemStack llllllllllllllllllllIlIlIlIIIIIl) {
        final NBTTagCompound llllllllllllllllllllIlIlIlIIIIll = llllllllllllllllllllIlIlIlIIIIIl.getSubCompound("BlockEntityTag", false);
        EnumDyeColor llllllllllllllllllllIlIlIlIIIIlI = null;
        if (llllllllllllllllllllIlIlIlIIIIll != null && llllllllllllllllllllIlIlIlIIIIll.hasKey("Base")) {
            llllllllllllllllllllIlIlIlIIIIlI = EnumDyeColor.func_176766_a(llllllllllllllllllllIlIlIlIIIIll.getInteger("Base"));
        }
        else {
            llllllllllllllllllllIlIlIlIIIIlI = EnumDyeColor.func_176766_a(llllllllllllllllllllIlIlIlIIIIIl.getMetadata());
        }
        return llllllllllllllllllllIlIlIlIIIIlI;
    }
    
    public ItemBanner() {
        super(Blocks.standing_banner);
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
    }
    
    @Override
    public String getItemStackDisplayName(final ItemStack llllllllllllllllllllIlIllIIIlIll) {
        String llllllllllllllllllllIlIllIIIlIlI = "item.banner.";
        final EnumDyeColor llllllllllllllllllllIlIllIIIlIIl = this.func_179225_h(llllllllllllllllllllIlIllIIIlIll);
        llllllllllllllllllllIlIllIIIlIlI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllllIlIllIIIlIlI)).append(llllllllllllllllllllIlIllIIIlIIl.func_176762_d()).append(".name"));
        return StatCollector.translateToLocal(llllllllllllllllllllIlIllIIIlIlI);
    }
    
    @Override
    public int getColorFromItemStack(final ItemStack llllllllllllllllllllIlIlIllIIlII, final int llllllllllllllllllllIlIlIllIIIll) {
        if (llllllllllllllllllllIlIlIllIIIll == 0) {
            return 16777215;
        }
        final EnumDyeColor llllllllllllllllllllIlIlIllIIIlI = this.func_179225_h(llllllllllllllllllllIlIlIllIIlII);
        return llllllllllllllllllllIlIlIllIIIlI.func_176768_e().colorValue;
    }
    
    @Override
    public boolean onItemUse(final ItemStack llllllllllllllllllllIlIllIlIIIII, final EntityPlayer llllllllllllllllllllIlIllIIlllll, final World llllllllllllllllllllIlIllIIllllI, BlockPos llllllllllllllllllllIlIllIIlIIll, final EnumFacing llllllllllllllllllllIlIllIIlIIlI, final float llllllllllllllllllllIlIllIIllIll, final float llllllllllllllllllllIlIllIIllIlI, final float llllllllllllllllllllIlIllIIllIIl) {
        if (llllllllllllllllllllIlIllIIlIIlI == EnumFacing.DOWN) {
            return false;
        }
        if (!llllllllllllllllllllIlIllIIllllI.getBlockState(llllllllllllllllllllIlIllIIlIIll).getBlock().getMaterial().isSolid()) {
            return false;
        }
        llllllllllllllllllllIlIllIIlIIll = llllllllllllllllllllIlIllIIlIIll.offset(llllllllllllllllllllIlIllIIlIIlI);
        if (!llllllllllllllllllllIlIllIIlllll.func_175151_a(llllllllllllllllllllIlIllIIlIIll, llllllllllllllllllllIlIllIIlIIlI, llllllllllllllllllllIlIllIlIIIII)) {
            return false;
        }
        if (!Blocks.standing_banner.canPlaceBlockAt(llllllllllllllllllllIlIllIIllllI, llllllllllllllllllllIlIllIIlIIll)) {
            return false;
        }
        if (llllllllllllllllllllIlIllIIllllI.isRemote) {
            return true;
        }
        if (llllllllllllllllllllIlIllIIlIIlI == EnumFacing.UP) {
            final int llllllllllllllllllllIlIllIIllIII = MathHelper.floor_double((llllllllllllllllllllIlIllIIlllll.rotationYaw + 180.0f) * 16.0f / 360.0f + 0.5) & 0xF;
            llllllllllllllllllllIlIllIIllllI.setBlockState(llllllllllllllllllllIlIllIIlIIll, Blocks.standing_banner.getDefaultState().withProperty(BlockStandingSign.ROTATION_PROP, llllllllllllllllllllIlIllIIllIII), 3);
        }
        else {
            llllllllllllllllllllIlIllIIllllI.setBlockState(llllllllllllllllllllIlIllIIlIIll, Blocks.wall_banner.getDefaultState().withProperty(BlockWallSign.field_176412_a, llllllllllllllllllllIlIllIIlIIlI), 3);
        }
        --llllllllllllllllllllIlIllIlIIIII.stackSize;
        final TileEntity llllllllllllllllllllIlIllIIlIlll = llllllllllllllllllllIlIllIIllllI.getTileEntity(llllllllllllllllllllIlIllIIlIIll);
        if (llllllllllllllllllllIlIllIIlIlll instanceof TileEntityBanner) {
            ((TileEntityBanner)llllllllllllllllllllIlIllIIlIlll).setItemValues(llllllllllllllllllllIlIllIlIIIII);
        }
        return true;
    }
    
    @Override
    public void getSubItems(final Item llllllllllllllllllllIlIlIlIlIllI, final CreativeTabs llllllllllllllllllllIlIlIlIlIlIl, final List llllllllllllllllllllIlIlIlIlIlII) {
        for (final EnumDyeColor llllllllllllllllllllIlIlIlIlIIII : EnumDyeColor.values()) {
            llllllllllllllllllllIlIlIlIlIlII.add(new ItemStack(llllllllllllllllllllIlIlIlIlIllI, 1, llllllllllllllllllllIlIlIlIlIIII.getDyeColorDamage()));
        }
    }
    
    static {
        __OBFID = "CL_00002181";
    }
    
    @Override
    public void addInformation(final ItemStack llllllllllllllllllllIlIlIlllIIIl, final EntityPlayer llllllllllllllllllllIlIlIllllIlI, final List llllllllllllllllllllIlIlIlllIIII, final boolean llllllllllllllllllllIlIlIllllIII) {
        final NBTTagCompound llllllllllllllllllllIlIlIlllIlll = llllllllllllllllllllIlIlIlllIIIl.getSubCompound("BlockEntityTag", false);
        if (llllllllllllllllllllIlIlIlllIlll != null && llllllllllllllllllllIlIlIlllIlll.hasKey("Patterns")) {
            final NBTTagList llllllllllllllllllllIlIlIlllIllI = llllllllllllllllllllIlIlIlllIlll.getTagList("Patterns", 10);
            for (int llllllllllllllllllllIlIlIlllIlIl = 0; llllllllllllllllllllIlIlIlllIlIl < llllllllllllllllllllIlIlIlllIllI.tagCount() && llllllllllllllllllllIlIlIlllIlIl < 6; ++llllllllllllllllllllIlIlIlllIlIl) {
                final NBTTagCompound llllllllllllllllllllIlIlIlllIlII = llllllllllllllllllllIlIlIlllIllI.getCompoundTagAt(llllllllllllllllllllIlIlIlllIlIl);
                final EnumDyeColor llllllllllllllllllllIlIlIlllIIll = EnumDyeColor.func_176766_a(llllllllllllllllllllIlIlIlllIlII.getInteger("Color"));
                final TileEntityBanner.EnumBannerPattern llllllllllllllllllllIlIlIlllIIlI = TileEntityBanner.EnumBannerPattern.func_177268_a(llllllllllllllllllllIlIlIlllIlII.getString("Pattern"));
                if (llllllllllllllllllllIlIlIlllIIlI != null) {
                    llllllllllllllllllllIlIlIlllIIII.add(StatCollector.translateToLocal(String.valueOf(new StringBuilder("item.banner.").append(llllllllllllllllllllIlIlIlllIIlI.func_177271_a()).append(".").append(llllllllllllllllllllIlIlIlllIIll.func_176762_d()))));
                }
            }
        }
    }
}
