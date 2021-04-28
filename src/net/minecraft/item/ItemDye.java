package net.minecraft.item;

import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;

public class ItemDye extends Item
{
    public static void func_180617_a(final World llllllllllllllIllllllIllIIIIIIlI, final BlockPos llllllllllllllIllllllIllIIIIIIIl, int llllllllllllllIllllllIlIlllllIII) {
        if (llllllllllllllIllllllIlIlllllIII == 0) {
            llllllllllllllIllllllIlIlllllIII = 15;
        }
        final Block llllllllllllllIllllllIlIllllllll = llllllllllllllIllllllIllIIIIIIlI.getBlockState(llllllllllllllIllllllIllIIIIIIIl).getBlock();
        if (llllllllllllllIllllllIlIllllllll.getMaterial() != Material.air) {
            llllllllllllllIllllllIlIllllllll.setBlockBoundsBasedOnState(llllllllllllllIllllllIllIIIIIIlI, llllllllllllllIllllllIllIIIIIIIl);
            for (int llllllllllllllIllllllIlIlllllllI = 0; llllllllllllllIllllllIlIlllllllI < llllllllllllllIllllllIlIlllllIII; ++llllllllllllllIllllllIlIlllllllI) {
                final double llllllllllllllIllllllIlIllllllIl = ItemDye.itemRand.nextGaussian() * 0.02;
                final double llllllllllllllIllllllIlIllllllII = ItemDye.itemRand.nextGaussian() * 0.02;
                final double llllllllllllllIllllllIlIlllllIll = ItemDye.itemRand.nextGaussian() * 0.02;
                llllllllllllllIllllllIllIIIIIIlI.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, llllllllllllllIllllllIllIIIIIIIl.getX() + ItemDye.itemRand.nextFloat(), llllllllllllllIllllllIllIIIIIIIl.getY() + ItemDye.itemRand.nextFloat() * llllllllllllllIllllllIlIllllllll.getBlockBoundsMaxY(), llllllllllllllIllllllIllIIIIIIIl.getZ() + ItemDye.itemRand.nextFloat(), llllllllllllllIllllllIlIllllllIl, llllllllllllllIllllllIlIllllllII, llllllllllllllIllllllIlIlllllIll, new int[0]);
            }
        }
    }
    
    @Override
    public String getUnlocalizedName(final ItemStack llllllllllllllIllllllIllIlIIIIII) {
        final int llllllllllllllIllllllIllIlIIIIlI = llllllllllllllIllllllIllIlIIIIII.getMetadata();
        return String.valueOf(new StringBuilder(String.valueOf(super.getUnlocalizedName())).append(".").append(EnumDyeColor.func_176766_a(llllllllllllllIllllllIllIlIIIIlI).func_176762_d()));
    }
    
    @Override
    public void getSubItems(final Item llllllllllllllIllllllIlIlllIIIII, final CreativeTabs llllllllllllllIllllllIlIllIlllll, final List llllllllllllllIllllllIlIllIllllI) {
        for (int llllllllllllllIllllllIlIllIlllIl = 0; llllllllllllllIllllllIlIllIlllIl < 16; ++llllllllllllllIllllllIlIllIlllIl) {
            llllllllllllllIllllllIlIllIllllI.add(new ItemStack(llllllllllllllIllllllIlIlllIIIII, 1, llllllllllllllIllllllIlIllIlllIl));
        }
    }
    
    @Override
    public boolean itemInteractionForEntity(final ItemStack llllllllllllllIllllllIlIlllIlIII, final EntityPlayer llllllllllllllIllllllIlIlllIllII, final EntityLivingBase llllllllllllllIllllllIlIlllIIlll) {
        if (llllllllllllllIllllllIlIlllIIlll instanceof EntitySheep) {
            final EntitySheep llllllllllllllIllllllIlIlllIlIlI = (EntitySheep)llllllllllllllIllllllIlIlllIIlll;
            final EnumDyeColor llllllllllllllIllllllIlIlllIlIIl = EnumDyeColor.func_176766_a(llllllllllllllIllllllIlIlllIlIII.getMetadata());
            if (!llllllllllllllIllllllIlIlllIlIlI.getSheared() && llllllllllllllIllllllIlIlllIlIlI.func_175509_cj() != llllllllllllllIllllllIlIlllIlIIl) {
                llllllllllllllIllllllIlIlllIlIlI.func_175512_b(llllllllllllllIllllllIlIlllIlIIl);
                --llllllllllllllIllllllIlIlllIlIII.stackSize;
            }
            return true;
        }
        return false;
    }
    
    @Override
    public boolean onItemUse(final ItemStack llllllllllllllIllllllIllIIllIIIl, final EntityPlayer llllllllllllllIllllllIllIIlIIlII, final World llllllllllllllIllllllIllIIlIllll, BlockPos llllllllllllllIllllllIllIIlIlllI, final EnumFacing llllllllllllllIllllllIllIIlIllIl, final float llllllllllllllIllllllIllIIlIIIII, final float llllllllllllllIllllllIllIIIlllll, final float llllllllllllllIllllllIllIIlIlIlI) {
        if (!llllllllllllllIllllllIllIIlIIlII.func_175151_a(llllllllllllllIllllllIllIIlIlllI.offset(llllllllllllllIllllllIllIIlIllIl), llllllllllllllIllllllIllIIlIllIl, llllllllllllllIllllllIllIIllIIIl)) {
            return false;
        }
        final EnumDyeColor llllllllllllllIllllllIllIIlIlIIl = EnumDyeColor.func_176766_a(llllllllllllllIllllllIllIIllIIIl.getMetadata());
        if (llllllllllllllIllllllIllIIlIlIIl == EnumDyeColor.WHITE) {
            if (func_179234_a(llllllllllllllIllllllIllIIllIIIl, llllllllllllllIllllllIllIIlIllll, llllllllllllllIllllllIllIIlIlllI)) {
                if (!llllllllllllllIllllllIllIIlIllll.isRemote) {
                    llllllllllllllIllllllIllIIlIllll.playAuxSFX(2005, llllllllllllllIllllllIllIIlIlllI, 0);
                }
                return true;
            }
        }
        else if (llllllllllllllIllllllIllIIlIlIIl == EnumDyeColor.BROWN) {
            final IBlockState llllllllllllllIllllllIllIIlIlIII = llllllllllllllIllllllIllIIlIllll.getBlockState(llllllllllllllIllllllIllIIlIlllI);
            final Block llllllllllllllIllllllIllIIlIIlll = llllllllllllllIllllllIllIIlIlIII.getBlock();
            if (llllllllllllllIllllllIllIIlIIlll == Blocks.log && llllllllllllllIllllllIllIIlIlIII.getValue(BlockPlanks.VARIANT_PROP) == BlockPlanks.EnumType.JUNGLE) {
                if (llllllllllllllIllllllIllIIlIllIl == EnumFacing.DOWN) {
                    return false;
                }
                if (llllllllllllllIllllllIllIIlIllIl == EnumFacing.UP) {
                    return false;
                }
                llllllllllllllIllllllIllIIlIlllI = llllllllllllllIllllllIllIIlIlllI.offset(llllllllllllllIllllllIllIIlIllIl);
                if (llllllllllllllIllllllIllIIlIllll.isAirBlock(llllllllllllllIllllllIllIIlIlllI)) {
                    final IBlockState llllllllllllllIllllllIllIIlIIllI = Blocks.cocoa.onBlockPlaced(llllllllllllllIllllllIllIIlIllll, llllllllllllllIllllllIllIIlIlllI, llllllllllllllIllllllIllIIlIllIl, llllllllllllllIllllllIllIIlIIIII, llllllllllllllIllllllIllIIIlllll, llllllllllllllIllllllIllIIlIlIlI, 0, llllllllllllllIllllllIllIIlIIlII);
                    llllllllllllllIllllllIllIIlIllll.setBlockState(llllllllllllllIllllllIllIIlIlllI, llllllllllllllIllllllIllIIlIIllI, 2);
                    if (!llllllllllllllIllllllIllIIlIIlII.capabilities.isCreativeMode) {
                        --llllllllllllllIllllllIllIIllIIIl.stackSize;
                    }
                }
                return true;
            }
        }
        return false;
    }
    
    public ItemDye() {
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }
    
    public static boolean func_179234_a(final ItemStack llllllllllllllIllllllIllIIIIllll, final World llllllllllllllIllllllIllIIIIlllI, final BlockPos llllllllllllllIllllllIllIIIIllIl) {
        final IBlockState llllllllllllllIllllllIllIIIlIIIl = llllllllllllllIllllllIllIIIIlllI.getBlockState(llllllllllllllIllllllIllIIIIllIl);
        if (llllllllllllllIllllllIllIIIlIIIl.getBlock() instanceof IGrowable) {
            final IGrowable llllllllllllllIllllllIllIIIlIIII = (IGrowable)llllllllllllllIllllllIllIIIlIIIl.getBlock();
            if (llllllllllllllIllllllIllIIIlIIII.isStillGrowing(llllllllllllllIllllllIllIIIIlllI, llllllllllllllIllllllIllIIIIllIl, llllllllllllllIllllllIllIIIlIIIl, llllllllllllllIllllllIllIIIIlllI.isRemote)) {
                if (!llllllllllllllIllllllIllIIIIlllI.isRemote) {
                    if (llllllllllllllIllllllIllIIIlIIII.canUseBonemeal(llllllllllllllIllllllIllIIIIlllI, llllllllllllllIllllllIllIIIIlllI.rand, llllllllllllllIllllllIllIIIIllIl, llllllllllllllIllllllIllIIIlIIIl)) {
                        llllllllllllllIllllllIllIIIlIIII.grow(llllllllllllllIllllllIllIIIIlllI, llllllllllllllIllllllIllIIIIlllI.rand, llllllllllllllIllllllIllIIIIllIl, llllllllllllllIllllllIllIIIlIIIl);
                    }
                    --llllllllllllllIllllllIllIIIIllll.stackSize;
                }
                return true;
            }
        }
        return false;
    }
    
    static {
        __OBFID = "CL_00000022";
        dyeColors = new int[] { 1973019, 11743532, 3887386, 5320730, 2437522, 8073150, 2651799, 11250603, 4408131, 14188952, 4312372, 14602026, 6719955, 12801229, 15435844, 15790320 };
    }
}
