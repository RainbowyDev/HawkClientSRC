package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.stats.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;
import net.minecraft.creativetab.*;

public class ItemBucket extends Item
{
    private /* synthetic */ Block isFull;
    
    @Override
    public ItemStack onItemRightClick(final ItemStack llllllllllllllIIlIIlIllIlllIIIlI, final World llllllllllllllIIlIIlIllIlllIlIll, final EntityPlayer llllllllllllllIIlIIlIllIlllIIIII) {
        final boolean llllllllllllllIIlIIlIllIlllIlIIl = this.isFull == Blocks.air;
        final MovingObjectPosition llllllllllllllIIlIIlIllIlllIlIII = this.getMovingObjectPositionFromPlayer(llllllllllllllIIlIIlIllIlllIlIll, llllllllllllllIIlIIlIllIlllIIIII, llllllllllllllIIlIIlIllIlllIlIIl);
        if (llllllllllllllIIlIIlIllIlllIlIII == null) {
            return llllllllllllllIIlIIlIllIlllIIIlI;
        }
        if (llllllllllllllIIlIIlIllIlllIlIII.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            final BlockPos llllllllllllllIIlIIlIllIlllIIlll = llllllllllllllIIlIIlIllIlllIlIII.func_178782_a();
            if (!llllllllllllllIIlIIlIllIlllIlIll.isBlockModifiable(llllllllllllllIIlIIlIllIlllIIIII, llllllllllllllIIlIIlIllIlllIIlll)) {
                return llllllllllllllIIlIIlIllIlllIIIlI;
            }
            if (llllllllllllllIIlIIlIllIlllIlIIl) {
                if (!llllllllllllllIIlIIlIllIlllIIIII.func_175151_a(llllllllllllllIIlIIlIllIlllIIlll.offset(llllllllllllllIIlIIlIllIlllIlIII.field_178784_b), llllllllllllllIIlIIlIllIlllIlIII.field_178784_b, llllllllllllllIIlIIlIllIlllIIIlI)) {
                    return llllllllllllllIIlIIlIllIlllIIIlI;
                }
                final IBlockState llllllllllllllIIlIIlIllIlllIIllI = llllllllllllllIIlIIlIllIlllIlIll.getBlockState(llllllllllllllIIlIIlIllIlllIIlll);
                final Material llllllllllllllIIlIIlIllIlllIIlIl = llllllllllllllIIlIIlIllIlllIIllI.getBlock().getMaterial();
                if (llllllllllllllIIlIIlIllIlllIIlIl == Material.water && (int)llllllllllllllIIlIIlIllIlllIIllI.getValue(BlockLiquid.LEVEL) == 0) {
                    llllllllllllllIIlIIlIllIlllIlIll.setBlockToAir(llllllllllllllIIlIIlIllIlllIIlll);
                    llllllllllllllIIlIIlIllIlllIIIII.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
                    return this.func_150910_a(llllllllllllllIIlIIlIllIlllIIIlI, llllllllllllllIIlIIlIllIlllIIIII, Items.water_bucket);
                }
                if (llllllllllllllIIlIIlIllIlllIIlIl == Material.lava && (int)llllllllllllllIIlIIlIllIlllIIllI.getValue(BlockLiquid.LEVEL) == 0) {
                    llllllllllllllIIlIIlIllIlllIlIll.setBlockToAir(llllllllllllllIIlIIlIllIlllIIlll);
                    llllllllllllllIIlIIlIllIlllIIIII.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
                    return this.func_150910_a(llllllllllllllIIlIIlIllIlllIIIlI, llllllllllllllIIlIIlIllIlllIIIII, Items.lava_bucket);
                }
            }
            else {
                if (this.isFull == Blocks.air) {
                    return new ItemStack(Items.bucket);
                }
                final BlockPos llllllllllllllIIlIIlIllIlllIIlII = llllllllllllllIIlIIlIllIlllIIlll.offset(llllllllllllllIIlIIlIllIlllIlIII.field_178784_b);
                if (!llllllllllllllIIlIIlIllIlllIIIII.func_175151_a(llllllllllllllIIlIIlIllIlllIIlII, llllllllllllllIIlIIlIllIlllIlIII.field_178784_b, llllllllllllllIIlIIlIllIlllIIIlI)) {
                    return llllllllllllllIIlIIlIllIlllIIIlI;
                }
                if (this.func_180616_a(llllllllllllllIIlIIlIllIlllIlIll, llllllllllllllIIlIIlIllIlllIIlII) && !llllllllllllllIIlIIlIllIlllIIIII.capabilities.isCreativeMode) {
                    llllllllllllllIIlIIlIllIlllIIIII.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
                    return new ItemStack(Items.bucket);
                }
            }
        }
        return llllllllllllllIIlIIlIllIlllIIIlI;
    }
    
    public boolean func_180616_a(final World llllllllllllllIIlIIlIllIllIIIllI, final BlockPos llllllllllllllIIlIIlIllIlIllllII) {
        if (this.isFull == Blocks.air) {
            return false;
        }
        final Material llllllllllllllIIlIIlIllIllIIIlII = llllllllllllllIIlIIlIllIllIIIllI.getBlockState(llllllllllllllIIlIIlIllIlIllllII).getBlock().getMaterial();
        final boolean llllllllllllllIIlIIlIllIllIIIIll = !llllllllllllllIIlIIlIllIllIIIlII.isSolid();
        if (!llllllllllllllIIlIIlIllIllIIIllI.isAirBlock(llllllllllllllIIlIIlIllIlIllllII) && !llllllllllllllIIlIIlIllIllIIIIll) {
            return false;
        }
        if (llllllllllllllIIlIIlIllIllIIIllI.provider.func_177500_n() && this.isFull == Blocks.flowing_water) {
            final int llllllllllllllIIlIIlIllIllIIIIlI = llllllllllllllIIlIIlIllIlIllllII.getX();
            final int llllllllllllllIIlIIlIllIllIIIIIl = llllllllllllllIIlIIlIllIlIllllII.getY();
            final int llllllllllllllIIlIIlIllIllIIIIII = llllllllllllllIIlIIlIllIlIllllII.getZ();
            llllllllllllllIIlIIlIllIllIIIllI.playSoundEffect(llllllllllllllIIlIIlIllIllIIIIlI + 0.5f, llllllllllllllIIlIIlIllIllIIIIIl + 0.5f, llllllllllllllIIlIIlIllIllIIIIII + 0.5f, "random.fizz", 0.5f, 2.6f + (llllllllllllllIIlIIlIllIllIIIllI.rand.nextFloat() - llllllllllllllIIlIIlIllIllIIIllI.rand.nextFloat()) * 0.8f);
            for (int llllllllllllllIIlIIlIllIlIllllll = 0; llllllllllllllIIlIIlIllIlIllllll < 8; ++llllllllllllllIIlIIlIllIlIllllll) {
                llllllllllllllIIlIIlIllIllIIIllI.spawnParticle(EnumParticleTypes.SMOKE_LARGE, llllllllllllllIIlIIlIllIllIIIIlI + Math.random(), llllllllllllllIIlIIlIllIllIIIIIl + Math.random(), llllllllllllllIIlIIlIllIllIIIIII + Math.random(), 0.0, 0.0, 0.0, new int[0]);
            }
        }
        else {
            if (!llllllllllllllIIlIIlIllIllIIIllI.isRemote && llllllllllllllIIlIIlIllIllIIIIll && !llllllllllllllIIlIIlIllIllIIIlII.isLiquid()) {
                llllllllllllllIIlIIlIllIllIIIllI.destroyBlock(llllllllllllllIIlIIlIllIlIllllII, true);
            }
            llllllllllllllIIlIIlIllIllIIIllI.setBlockState(llllllllllllllIIlIIlIllIlIllllII, this.isFull.getDefaultState(), 3);
        }
        return true;
    }
    
    static {
        __OBFID = "CL_00000000";
    }
    
    private ItemStack func_150910_a(final ItemStack llllllllllllllIIlIIlIllIllIlIllI, final EntityPlayer llllllllllllllIIlIIlIllIllIlIIlI, final Item llllllllllllllIIlIIlIllIllIlIIIl) {
        if (llllllllllllllIIlIIlIllIllIlIIlI.capabilities.isCreativeMode) {
            return llllllllllllllIIlIIlIllIllIlIllI;
        }
        if (--llllllllllllllIIlIIlIllIllIlIllI.stackSize <= 0) {
            return new ItemStack(llllllllllllllIIlIIlIllIllIlIIIl);
        }
        if (!llllllllllllllIIlIIlIllIllIlIIlI.inventory.addItemStackToInventory(new ItemStack(llllllllllllllIIlIIlIllIllIlIIIl))) {
            llllllllllllllIIlIIlIllIllIlIIlI.dropPlayerItemWithRandomChoice(new ItemStack(llllllllllllllIIlIIlIllIllIlIIIl, 1, 0), false);
        }
        return llllllllllllllIIlIIlIllIllIlIllI;
    }
    
    public ItemBucket(final Block llllllllllllllIIlIIlIllIlllllIIl) {
        this.maxStackSize = 1;
        this.isFull = llllllllllllllIIlIIlIllIlllllIIl;
        this.setCreativeTab(CreativeTabs.tabMisc);
    }
}
