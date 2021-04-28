package net.minecraft.item;

import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.*;

public class ItemHoe extends Item
{
    protected /* synthetic */ ToolMaterial theToolMaterial;
    
    protected boolean func_179232_a(final ItemStack llllllllllllllllIllllIIIIlllIIII, final EntityPlayer llllllllllllllllIllllIIIIllIllll, final World llllllllllllllllIllllIIIIlllIIll, final BlockPos llllllllllllllllIllllIIIIlllIIlI, final IBlockState llllllllllllllllIllllIIIIlllIIIl) {
        llllllllllllllllIllllIIIIlllIIll.playSoundEffect(llllllllllllllllIllllIIIIlllIIlI.getX() + 0.5f, llllllllllllllllIllllIIIIlllIIlI.getY() + 0.5f, llllllllllllllllIllllIIIIlllIIlI.getZ() + 0.5f, llllllllllllllllIllllIIIIlllIIIl.getBlock().stepSound.getStepSound(), (llllllllllllllllIllllIIIIlllIIIl.getBlock().stepSound.getVolume() + 1.0f) / 2.0f, llllllllllllllllIllllIIIIlllIIIl.getBlock().stepSound.getFrequency() * 0.8f);
        if (llllllllllllllllIllllIIIIlllIIll.isRemote) {
            return true;
        }
        llllllllllllllllIllllIIIIlllIIll.setBlockState(llllllllllllllllIllllIIIIlllIIlI, llllllllllllllllIllllIIIIlllIIIl);
        llllllllllllllllIllllIIIIlllIIII.damageItem(1, llllllllllllllllIllllIIIIllIllll);
        return true;
    }
    
    @Override
    public boolean isFull3D() {
        return true;
    }
    
    public ItemHoe(final ToolMaterial llllllllllllllllIllllIIIlIIlIlll) {
        this.theToolMaterial = llllllllllllllllIllllIIIlIIlIlll;
        this.maxStackSize = 1;
        this.setMaxDamage(llllllllllllllllIllllIIIlIIlIlll.getMaxUses());
        this.setCreativeTab(CreativeTabs.tabTools);
    }
    
    @Override
    public boolean onItemUse(final ItemStack llllllllllllllllIllllIIIlIIIIIlI, final EntityPlayer llllllllllllllllIllllIIIlIIIIIIl, final World llllllllllllllllIllllIIIlIIIIIII, final BlockPos llllllllllllllllIllllIIIlIIIlIlI, final EnumFacing llllllllllllllllIllllIIIIllllllI, final float llllllllllllllllIllllIIIlIIIlIII, final float llllllllllllllllIllllIIIlIIIIlll, final float llllllllllllllllIllllIIIlIIIIllI) {
        if (!llllllllllllllllIllllIIIlIIIIIIl.func_175151_a(llllllllllllllllIllllIIIlIIIlIlI.offset(llllllllllllllllIllllIIIIllllllI), llllllllllllllllIllllIIIIllllllI, llllllllllllllllIllllIIIlIIIIIlI)) {
            return false;
        }
        final IBlockState llllllllllllllllIllllIIIlIIIIlIl = llllllllllllllllIllllIIIlIIIIIII.getBlockState(llllllllllllllllIllllIIIlIIIlIlI);
        final Block llllllllllllllllIllllIIIlIIIIlII = llllllllllllllllIllllIIIlIIIIlIl.getBlock();
        if (llllllllllllllllIllllIIIIllllllI != EnumFacing.DOWN && llllllllllllllllIllllIIIlIIIIIII.getBlockState(llllllllllllllllIllllIIIlIIIlIlI.offsetUp()).getBlock().getMaterial() == Material.air) {
            if (llllllllllllllllIllllIIIlIIIIlII == Blocks.grass) {
                return this.func_179232_a(llllllllllllllllIllllIIIlIIIIIlI, llllllllllllllllIllllIIIlIIIIIIl, llllllllllllllllIllllIIIlIIIIIII, llllllllllllllllIllllIIIlIIIlIlI, Blocks.farmland.getDefaultState());
            }
            if (llllllllllllllllIllllIIIlIIIIlII == Blocks.dirt) {
                switch (SwitchDirtType.field_179590_a[((BlockDirt.DirtType)llllllllllllllllIllllIIIlIIIIlIl.getValue(BlockDirt.VARIANT)).ordinal()]) {
                    case 1: {
                        return this.func_179232_a(llllllllllllllllIllllIIIlIIIIIlI, llllllllllllllllIllllIIIlIIIIIIl, llllllllllllllllIllllIIIlIIIIIII, llllllllllllllllIllllIIIlIIIlIlI, Blocks.farmland.getDefaultState());
                    }
                    case 2: {
                        return this.func_179232_a(llllllllllllllllIllllIIIlIIIIIlI, llllllllllllllllIllllIIIlIIIIIIl, llllllllllllllllIllllIIIlIIIIIII, llllllllllllllllIllllIIIlIIIlIlI, Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT));
                    }
                }
            }
        }
        return false;
    }
    
    static {
        __OBFID = "CL_00000039";
    }
    
    public String getMaterialName() {
        return this.theToolMaterial.toString();
    }
    
    static final class SwitchDirtType
    {
        static final /* synthetic */ int[] field_179590_a;
        
        static {
            __OBFID = "CL_00002179";
            field_179590_a = new int[BlockDirt.DirtType.values().length];
            try {
                SwitchDirtType.field_179590_a[BlockDirt.DirtType.DIRT.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchDirtType.field_179590_a[BlockDirt.DirtType.COARSE_DIRT.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
        }
    }
}
