package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.stats.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.block.state.*;
import net.minecraft.tileentity.*;
import net.minecraft.creativetab.*;
import java.util.*;

public class ItemMonsterPlacer extends Item
{
    @Override
    public int getColorFromItemStack(final ItemStack llllllllllllllllIlIIIlllIlIlllll, final int llllllllllllllllIlIIIlllIlIllllI) {
        final EntityList.EntityEggInfo llllllllllllllllIlIIIlllIllIIIII = EntityList.entityEggs.get(llllllllllllllllIlIIIlllIlIlllll.getMetadata());
        return (llllllllllllllllIlIIIlllIllIIIII != null) ? ((llllllllllllllllIlIIIlllIlIllllI == 0) ? llllllllllllllllIlIIIlllIllIIIII.primaryColor : llllllllllllllllIlIIIlllIllIIIII.secondaryColor) : 16777215;
    }
    
    static {
        __OBFID = "CL_00000070";
    }
    
    @Override
    public ItemStack onItemRightClick(final ItemStack llllllllllllllllIlIIIlllIIlIllIl, final World llllllllllllllllIlIIIlllIIlIllII, final EntityPlayer llllllllllllllllIlIIIlllIIllIIlI) {
        if (llllllllllllllllIlIIIlllIIlIllII.isRemote) {
            return llllllllllllllllIlIIIlllIIlIllIl;
        }
        final MovingObjectPosition llllllllllllllllIlIIIlllIIllIIIl = this.getMovingObjectPositionFromPlayer(llllllllllllllllIlIIIlllIIlIllII, llllllllllllllllIlIIIlllIIllIIlI, true);
        if (llllllllllllllllIlIIIlllIIllIIIl == null) {
            return llllllllllllllllIlIIIlllIIlIllIl;
        }
        if (llllllllllllllllIlIIIlllIIllIIIl.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            final BlockPos llllllllllllllllIlIIIlllIIllIIII = llllllllllllllllIlIIIlllIIllIIIl.func_178782_a();
            if (!llllllllllllllllIlIIIlllIIlIllII.isBlockModifiable(llllllllllllllllIlIIIlllIIllIIlI, llllllllllllllllIlIIIlllIIllIIII)) {
                return llllllllllllllllIlIIIlllIIlIllIl;
            }
            if (!llllllllllllllllIlIIIlllIIllIIlI.func_175151_a(llllllllllllllllIlIIIlllIIllIIII, llllllllllllllllIlIIIlllIIllIIIl.field_178784_b, llllllllllllllllIlIIIlllIIlIllIl)) {
                return llllllllllllllllIlIIIlllIIlIllIl;
            }
            if (llllllllllllllllIlIIIlllIIlIllII.getBlockState(llllllllllllllllIlIIIlllIIllIIII).getBlock() instanceof BlockLiquid) {
                final Entity llllllllllllllllIlIIIlllIIlIllll = spawnCreature(llllllllllllllllIlIIIlllIIlIllII, llllllllllllllllIlIIIlllIIlIllIl.getMetadata(), llllllllllllllllIlIIIlllIIllIIII.getX() + 0.5, llllllllllllllllIlIIIlllIIllIIII.getY() + 0.5, llllllllllllllllIlIIIlllIIllIIII.getZ() + 0.5);
                if (llllllllllllllllIlIIIlllIIlIllll != null) {
                    if (llllllllllllllllIlIIIlllIIlIllll instanceof EntityLivingBase && llllllllllllllllIlIIIlllIIlIllIl.hasDisplayName()) {
                        ((EntityLiving)llllllllllllllllIlIIIlllIIlIllll).setCustomNameTag(llllllllllllllllIlIIIlllIIlIllIl.getDisplayName());
                    }
                    if (!llllllllllllllllIlIIIlllIIllIIlI.capabilities.isCreativeMode) {
                        --llllllllllllllllIlIIIlllIIlIllIl.stackSize;
                    }
                    llllllllllllllllIlIIIlllIIllIIlI.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
                }
            }
        }
        return llllllllllllllllIlIIIlllIIlIllIl;
    }
    
    public static Entity spawnCreature(final World llllllllllllllllIlIIIlllIIIlllll, final int llllllllllllllllIlIIIlllIIIlIllI, final double llllllllllllllllIlIIIlllIIIlllIl, final double llllllllllllllllIlIIIlllIIIlIlII, final double llllllllllllllllIlIIIlllIIIlIIll) {
        if (!EntityList.entityEggs.containsKey(llllllllllllllllIlIIIlllIIIlIllI)) {
            return null;
        }
        Entity llllllllllllllllIlIIIlllIIIllIlI = null;
        for (int llllllllllllllllIlIIIlllIIIllIIl = 0; llllllllllllllllIlIIIlllIIIllIIl < 1; ++llllllllllllllllIlIIIlllIIIllIIl) {
            llllllllllllllllIlIIIlllIIIllIlI = EntityList.createEntityByID(llllllllllllllllIlIIIlllIIIlIllI, llllllllllllllllIlIIIlllIIIlllll);
            if (llllllllllllllllIlIIIlllIIIllIlI instanceof EntityLivingBase) {
                final EntityLiving llllllllllllllllIlIIIlllIIIllIII = (EntityLiving)llllllllllllllllIlIIIlllIIIllIlI;
                llllllllllllllllIlIIIlllIIIllIlI.setLocationAndAngles(llllllllllllllllIlIIIlllIIIlllIl, llllllllllllllllIlIIIlllIIIlIlII, llllllllllllllllIlIIIlllIIIlIIll, MathHelper.wrapAngleTo180_float(llllllllllllllllIlIIIlllIIIlllll.rand.nextFloat() * 360.0f), 0.0f);
                llllllllllllllllIlIIIlllIIIllIII.rotationYawHead = llllllllllllllllIlIIIlllIIIllIII.rotationYaw;
                llllllllllllllllIlIIIlllIIIllIII.renderYawOffset = llllllllllllllllIlIIIlllIIIllIII.rotationYaw;
                llllllllllllllllIlIIIlllIIIllIII.func_180482_a(llllllllllllllllIlIIIlllIIIlllll.getDifficultyForLocation(new BlockPos(llllllllllllllllIlIIIlllIIIllIII)), null);
                llllllllllllllllIlIIIlllIIIlllll.spawnEntityInWorld(llllllllllllllllIlIIIlllIIIllIlI);
                llllllllllllllllIlIIIlllIIIllIII.playLivingSound();
            }
        }
        return llllllllllllllllIlIIIlllIIIllIlI;
    }
    
    @Override
    public String getItemStackDisplayName(final ItemStack llllllllllllllllIlIIIlllIllIllIl) {
        String llllllllllllllllIlIIIlllIllIllII = String.valueOf(new StringBuilder().append(StatCollector.translateToLocal(String.valueOf(new StringBuilder(String.valueOf(this.getUnlocalizedName())).append(".name"))))).trim();
        final String llllllllllllllllIlIIIlllIllIlIll = EntityList.getStringFromID(llllllllllllllllIlIIIlllIllIllIl.getMetadata());
        if (llllllllllllllllIlIIIlllIllIlIll != null) {
            llllllllllllllllIlIIIlllIllIllII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIlIIIlllIllIllII)).append(" ").append(StatCollector.translateToLocal(String.valueOf(new StringBuilder("entity.").append(llllllllllllllllIlIIIlllIllIlIll).append(".name")))));
        }
        return llllllllllllllllIlIIIlllIllIllII;
    }
    
    @Override
    public boolean onItemUse(final ItemStack llllllllllllllllIlIIIlllIlIlIIlI, final EntityPlayer llllllllllllllllIlIIIlllIlIIIlII, final World llllllllllllllllIlIIIlllIlIIIIll, BlockPos llllllllllllllllIlIIIlllIlIIIIlI, final EnumFacing llllllllllllllllIlIIIlllIlIIIIIl, final float llllllllllllllllIlIIIlllIlIIllIl, final float llllllllllllllllIlIIIlllIlIIllII, final float llllllllllllllllIlIIIlllIlIIlIll) {
        if (llllllllllllllllIlIIIlllIlIIIIll.isRemote) {
            return true;
        }
        if (!llllllllllllllllIlIIIlllIlIIIlII.func_175151_a(llllllllllllllllIlIIIlllIlIIIIlI.offset(llllllllllllllllIlIIIlllIlIIIIIl), llllllllllllllllIlIIIlllIlIIIIIl, llllllllllllllllIlIIIlllIlIlIIlI)) {
            return false;
        }
        final IBlockState llllllllllllllllIlIIIlllIlIIlIlI = llllllllllllllllIlIIIlllIlIIIIll.getBlockState(llllllllllllllllIlIIIlllIlIIIIlI);
        if (llllllllllllllllIlIIIlllIlIIlIlI.getBlock() == Blocks.mob_spawner) {
            final TileEntity llllllllllllllllIlIIIlllIlIIlIIl = llllllllllllllllIlIIIlllIlIIIIll.getTileEntity(llllllllllllllllIlIIIlllIlIIIIlI);
            if (llllllllllllllllIlIIIlllIlIIlIIl instanceof TileEntityMobSpawner) {
                final MobSpawnerBaseLogic llllllllllllllllIlIIIlllIlIIlIII = ((TileEntityMobSpawner)llllllllllllllllIlIIIlllIlIIlIIl).getSpawnerBaseLogic();
                llllllllllllllllIlIIIlllIlIIlIII.setEntityName(EntityList.getStringFromID(llllllllllllllllIlIIIlllIlIlIIlI.getMetadata()));
                llllllllllllllllIlIIIlllIlIIlIIl.markDirty();
                llllllllllllllllIlIIIlllIlIIIIll.markBlockForUpdate(llllllllllllllllIlIIIlllIlIIIIlI);
                if (!llllllllllllllllIlIIIlllIlIIIlII.capabilities.isCreativeMode) {
                    --llllllllllllllllIlIIIlllIlIlIIlI.stackSize;
                }
                return true;
            }
        }
        llllllllllllllllIlIIIlllIlIIIIlI = llllllllllllllllIlIIIlllIlIIIIlI.offset(llllllllllllllllIlIIIlllIlIIIIIl);
        double llllllllllllllllIlIIIlllIlIIIlll = 0.0;
        if (llllllllllllllllIlIIIlllIlIIIIIl == EnumFacing.UP && llllllllllllllllIlIIIlllIlIIlIlI instanceof BlockFence) {
            llllllllllllllllIlIIIlllIlIIIlll = 0.5;
        }
        final Entity llllllllllllllllIlIIIlllIlIIIllI = spawnCreature(llllllllllllllllIlIIIlllIlIIIIll, llllllllllllllllIlIIIlllIlIlIIlI.getMetadata(), llllllllllllllllIlIIIlllIlIIIIlI.getX() + 0.5, llllllllllllllllIlIIIlllIlIIIIlI.getY() + llllllllllllllllIlIIIlllIlIIIlll, llllllllllllllllIlIIIlllIlIIIIlI.getZ() + 0.5);
        if (llllllllllllllllIlIIIlllIlIIIllI != null) {
            if (llllllllllllllllIlIIIlllIlIIIllI instanceof EntityLivingBase && llllllllllllllllIlIIIlllIlIlIIlI.hasDisplayName()) {
                llllllllllllllllIlIIIlllIlIIIllI.setCustomNameTag(llllllllllllllllIlIIIlllIlIlIIlI.getDisplayName());
            }
            if (!llllllllllllllllIlIIIlllIlIIIlII.capabilities.isCreativeMode) {
                --llllllllllllllllIlIIIlllIlIlIIlI.stackSize;
            }
        }
        return true;
    }
    
    public ItemMonsterPlacer() {
        this.setHasSubtypes(true);
        this.setCreativeTab(CreativeTabs.tabMisc);
    }
    
    @Override
    public void getSubItems(final Item llllllllllllllllIlIIIlllIIIIIlIl, final CreativeTabs llllllllllllllllIlIIIlllIIIIlIIl, final List llllllllllllllllIlIIIlllIIIIIlII) {
        for (final EntityList.EntityEggInfo llllllllllllllllIlIIIlllIIIIIllI : EntityList.entityEggs.values()) {
            llllllllllllllllIlIIIlllIIIIIlII.add(new ItemStack(llllllllllllllllIlIIIlllIIIIIlIl, 1, llllllllllllllllIlIIIlllIIIIIllI.spawnedID));
        }
    }
}
