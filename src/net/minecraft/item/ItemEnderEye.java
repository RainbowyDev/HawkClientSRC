package net.minecraft.item;

import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.stats.*;
import net.minecraft.creativetab.*;

public class ItemEnderEye extends Item
{
    static {
        __OBFID = "CL_00000026";
    }
    
    @Override
    public boolean onItemUse(final ItemStack llllllllllllllIlIIIIIIIlIIllIIll, final EntityPlayer llllllllllllllIlIIIIIIIlIIllIIlI, final World llllllllllllllIlIIIIIIIlIlIlIIll, final BlockPos llllllllllllllIlIIIIIIIlIlIlIIlI, final EnumFacing llllllllllllllIlIIIIIIIlIlIlIIIl, final float llllllllllllllIlIIIIIIIlIlIlIIII, final float llllllllllllllIlIIIIIIIlIlIIllll, final float llllllllllllllIlIIIIIIIlIlIIlllI) {
        final IBlockState llllllllllllllIlIIIIIIIlIlIIllIl = llllllllllllllIlIIIIIIIlIlIlIIll.getBlockState(llllllllllllllIlIIIIIIIlIlIlIIlI);
        if (!llllllllllllllIlIIIIIIIlIIllIIlI.func_175151_a(llllllllllllllIlIIIIIIIlIlIlIIlI.offset(llllllllllllllIlIIIIIIIlIlIlIIIl), llllllllllllllIlIIIIIIIlIlIlIIIl, llllllllllllllIlIIIIIIIlIIllIIll) || llllllllllllllIlIIIIIIIlIlIIllIl.getBlock() != Blocks.end_portal_frame || (boolean)llllllllllllllIlIIIIIIIlIlIIllIl.getValue(BlockEndPortalFrame.field_176507_b)) {
            return false;
        }
        if (llllllllllllllIlIIIIIIIlIlIlIIll.isRemote) {
            return true;
        }
        llllllllllllllIlIIIIIIIlIlIlIIll.setBlockState(llllllllllllllIlIIIIIIIlIlIlIIlI, llllllllllllllIlIIIIIIIlIlIIllIl.withProperty(BlockEndPortalFrame.field_176507_b, true), 2);
        llllllllllllllIlIIIIIIIlIlIlIIll.updateComparatorOutputLevel(llllllllllllllIlIIIIIIIlIlIlIIlI, Blocks.end_portal_frame);
        --llllllllllllllIlIIIIIIIlIIllIIll.stackSize;
        for (int llllllllllllllIlIIIIIIIlIlIIllII = 0; llllllllllllllIlIIIIIIIlIlIIllII < 16; ++llllllllllllllIlIIIIIIIlIlIIllII) {
            final double llllllllllllllIlIIIIIIIlIlIIlIll = llllllllllllllIlIIIIIIIlIlIlIIlI.getX() + (5.0f + ItemEnderEye.itemRand.nextFloat() * 6.0f) / 16.0f;
            final double llllllllllllllIlIIIIIIIlIlIIlIlI = llllllllllllllIlIIIIIIIlIlIlIIlI.getY() + 0.8125f;
            final double llllllllllllllIlIIIIIIIlIlIIlIIl = llllllllllllllIlIIIIIIIlIlIlIIlI.getZ() + (5.0f + ItemEnderEye.itemRand.nextFloat() * 6.0f) / 16.0f;
            final double llllllllllllllIlIIIIIIIlIlIIlIII = 0.0;
            final double llllllllllllllIlIIIIIIIlIlIIIlll = 0.0;
            final double llllllllllllllIlIIIIIIIlIlIIIllI = 0.0;
            llllllllllllllIlIIIIIIIlIlIlIIll.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, llllllllllllllIlIIIIIIIlIlIIlIll, llllllllllllllIlIIIIIIIlIlIIlIlI, llllllllllllllIlIIIIIIIlIlIIlIIl, llllllllllllllIlIIIIIIIlIlIIlIII, llllllllllllllIlIIIIIIIlIlIIIlll, llllllllllllllIlIIIIIIIlIlIIIllI, new int[0]);
        }
        final EnumFacing llllllllllllllIlIIIIIIIlIlIIIlIl = (EnumFacing)llllllllllllllIlIIIIIIIlIlIIllIl.getValue(BlockEndPortalFrame.field_176508_a);
        int llllllllllllllIlIIIIIIIlIlIIIlII = 0;
        int llllllllllllllIlIIIIIIIlIlIIIIll = 0;
        boolean llllllllllllllIlIIIIIIIlIlIIIIlI = false;
        boolean llllllllllllllIlIIIIIIIlIlIIIIIl = true;
        final EnumFacing llllllllllllllIlIIIIIIIlIlIIIIII = llllllllllllllIlIIIIIIIlIlIIIlIl.rotateY();
        for (int llllllllllllllIlIIIIIIIlIIllllll = -2; llllllllllllllIlIIIIIIIlIIllllll <= 2; ++llllllllllllllIlIIIIIIIlIIllllll) {
            final BlockPos llllllllllllllIlIIIIIIIlIIlllllI = llllllllllllllIlIIIIIIIlIlIlIIlI.offset(llllllllllllllIlIIIIIIIlIlIIIIII, llllllllllllllIlIIIIIIIlIIllllll);
            final IBlockState llllllllllllllIlIIIIIIIlIIllllIl = llllllllllllllIlIIIIIIIlIlIlIIll.getBlockState(llllllllllllllIlIIIIIIIlIIlllllI);
            if (llllllllllllllIlIIIIIIIlIIllllIl.getBlock() == Blocks.end_portal_frame) {
                if (!(boolean)llllllllllllllIlIIIIIIIlIIllllIl.getValue(BlockEndPortalFrame.field_176507_b)) {
                    llllllllllllllIlIIIIIIIlIlIIIIIl = false;
                    break;
                }
                llllllllllllllIlIIIIIIIlIlIIIIll = llllllllllllllIlIIIIIIIlIIllllll;
                if (!llllllllllllllIlIIIIIIIlIlIIIIlI) {
                    llllllllllllllIlIIIIIIIlIlIIIlII = llllllllllllllIlIIIIIIIlIIllllll;
                    llllllllllllllIlIIIIIIIlIlIIIIlI = true;
                }
            }
        }
        if (llllllllllllllIlIIIIIIIlIlIIIIIl && llllllllllllllIlIIIIIIIlIlIIIIll == llllllllllllllIlIIIIIIIlIlIIIlII + 2) {
            BlockPos llllllllllllllIlIIIIIIIlIIllllII = llllllllllllllIlIIIIIIIlIlIlIIlI.offset(llllllllllllllIlIIIIIIIlIlIIIlIl, 4);
            for (int llllllllllllllIlIIIIIIIlIIlllIll = llllllllllllllIlIIIIIIIlIlIIIlII; llllllllllllllIlIIIIIIIlIIlllIll <= llllllllllllllIlIIIIIIIlIlIIIIll; ++llllllllllllllIlIIIIIIIlIIlllIll) {
                final BlockPos llllllllllllllIlIIIIIIIlIIlllIlI = llllllllllllllIlIIIIIIIlIIllllII.offset(llllllllllllllIlIIIIIIIlIlIIIIII, llllllllllllllIlIIIIIIIlIIlllIll);
                final IBlockState llllllllllllllIlIIIIIIIlIIlllIIl = llllllllllllllIlIIIIIIIlIlIlIIll.getBlockState(llllllllllllllIlIIIIIIIlIIlllIlI);
                if (llllllllllllllIlIIIIIIIlIIlllIIl.getBlock() != Blocks.end_portal_frame || !(boolean)llllllllllllllIlIIIIIIIlIIlllIIl.getValue(BlockEndPortalFrame.field_176507_b)) {
                    llllllllllllllIlIIIIIIIlIlIIIIIl = false;
                    break;
                }
            }
            for (int llllllllllllllIlIIIIIIIlIIlllIll = llllllllllllllIlIIIIIIIlIlIIIlII - 1; llllllllllllllIlIIIIIIIlIIlllIll <= llllllllllllllIlIIIIIIIlIlIIIIll + 1; llllllllllllllIlIIIIIIIlIIlllIll += 4) {
                llllllllllllllIlIIIIIIIlIIllllII = llllllllllllllIlIIIIIIIlIlIlIIlI.offset(llllllllllllllIlIIIIIIIlIlIIIIII, llllllllllllllIlIIIIIIIlIIlllIll);
                for (int llllllllllllllIlIIIIIIIlIIlllIII = 1; llllllllllllllIlIIIIIIIlIIlllIII <= 3; ++llllllllllllllIlIIIIIIIlIIlllIII) {
                    final BlockPos llllllllllllllIlIIIIIIIlIIllIllI = llllllllllllllIlIIIIIIIlIIllllII.offset(llllllllllllllIlIIIIIIIlIlIIIlIl, llllllllllllllIlIIIIIIIlIIlllIII);
                    final IBlockState llllllllllllllIlIIIIIIIlIIllIlII = llllllllllllllIlIIIIIIIlIlIlIIll.getBlockState(llllllllllllllIlIIIIIIIlIIllIllI);
                    if (llllllllllllllIlIIIIIIIlIIllIlII.getBlock() != Blocks.end_portal_frame || !(boolean)llllllllllllllIlIIIIIIIlIIllIlII.getValue(BlockEndPortalFrame.field_176507_b)) {
                        llllllllllllllIlIIIIIIIlIlIIIIIl = false;
                        break;
                    }
                }
            }
            if (llllllllllllllIlIIIIIIIlIlIIIIIl) {
                for (int llllllllllllllIlIIIIIIIlIIlllIll = llllllllllllllIlIIIIIIIlIlIIIlII; llllllllllllllIlIIIIIIIlIIlllIll <= llllllllllllllIlIIIIIIIlIlIIIIll; ++llllllllllllllIlIIIIIIIlIIlllIll) {
                    llllllllllllllIlIIIIIIIlIIllllII = llllllllllllllIlIIIIIIIlIlIlIIlI.offset(llllllllllllllIlIIIIIIIlIlIIIIII, llllllllllllllIlIIIIIIIlIIlllIll);
                    for (int llllllllllllllIlIIIIIIIlIIllIlll = 1; llllllllllllllIlIIIIIIIlIIllIlll <= 3; ++llllllllllllllIlIIIIIIIlIIllIlll) {
                        final BlockPos llllllllllllllIlIIIIIIIlIIllIlIl = llllllllllllllIlIIIIIIIlIIllllII.offset(llllllllllllllIlIIIIIIIlIlIIIlIl, llllllllllllllIlIIIIIIIlIIllIlll);
                        llllllllllllllIlIIIIIIIlIlIlIIll.setBlockState(llllllllllllllIlIIIIIIIlIIllIlIl, Blocks.end_portal.getDefaultState(), 2);
                    }
                }
            }
        }
        return true;
    }
    
    @Override
    public ItemStack onItemRightClick(final ItemStack llllllllllllllIlIIIIIIIlIIIlIIlI, final World llllllllllllllIlIIIIIIIlIIIllIII, final EntityPlayer llllllllllllllIlIIIIIIIlIIIlIIII) {
        final MovingObjectPosition llllllllllllllIlIIIIIIIlIIIlIllI = this.getMovingObjectPositionFromPlayer(llllllllllllllIlIIIIIIIlIIIllIII, llllllllllllllIlIIIIIIIlIIIlIIII, false);
        if (llllllllllllllIlIIIIIIIlIIIlIllI != null && llllllllllllllIlIIIIIIIlIIIlIllI.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK && llllllllllllllIlIIIIIIIlIIIllIII.getBlockState(llllllllllllllIlIIIIIIIlIIIlIllI.func_178782_a()).getBlock() == Blocks.end_portal_frame) {
            return llllllllllllllIlIIIIIIIlIIIlIIlI;
        }
        if (!llllllllllllllIlIIIIIIIlIIIllIII.isRemote) {
            final BlockPos llllllllllllllIlIIIIIIIlIIIlIlIl = llllllllllllllIlIIIIIIIlIIIllIII.func_180499_a("Stronghold", new BlockPos(llllllllllllllIlIIIIIIIlIIIlIIII));
            if (llllllllllllllIlIIIIIIIlIIIlIlIl != null) {
                final EntityEnderEye llllllllllllllIlIIIIIIIlIIIlIlII = new EntityEnderEye(llllllllllllllIlIIIIIIIlIIIllIII, llllllllllllllIlIIIIIIIlIIIlIIII.posX, llllllllllllllIlIIIIIIIlIIIlIIII.posY, llllllllllllllIlIIIIIIIlIIIlIIII.posZ);
                llllllllllllllIlIIIIIIIlIIIlIlII.func_180465_a(llllllllllllllIlIIIIIIIlIIIlIlIl);
                llllllllllllllIlIIIIIIIlIIIllIII.spawnEntityInWorld(llllllllllllllIlIIIIIIIlIIIlIlII);
                llllllllllllllIlIIIIIIIlIIIllIII.playSoundAtEntity(llllllllllllllIlIIIIIIIlIIIlIIII, "random.bow", 0.5f, 0.4f / (ItemEnderEye.itemRand.nextFloat() * 0.4f + 0.8f));
                llllllllllllllIlIIIIIIIlIIIllIII.playAuxSFXAtEntity(null, 1002, new BlockPos(llllllllllllllIlIIIIIIIlIIIlIIII), 0);
                if (!llllllllllllllIlIIIIIIIlIIIlIIII.capabilities.isCreativeMode) {
                    --llllllllllllllIlIIIIIIIlIIIlIIlI.stackSize;
                }
                llllllllllllllIlIIIIIIIlIIIlIIII.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
            }
        }
        return llllllllllllllIlIIIIIIIlIIIlIIlI;
    }
    
    public ItemEnderEye() {
        this.setCreativeTab(CreativeTabs.tabMisc);
    }
}
