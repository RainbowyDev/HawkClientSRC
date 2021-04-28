package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.entity.item.*;
import net.minecraft.stats.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.creativetab.*;

public class ItemBoat extends Item
{
    @Override
    public ItemStack onItemRightClick(final ItemStack lllllllllllllllIIllIIIIlIllIlIII, final World lllllllllllllllIIllIIIIllIIlIIll, final EntityPlayer lllllllllllllllIIllIIIIllIIlIIIl) {
        final float lllllllllllllllIIllIIIIllIIIllll = 1.0f;
        final float lllllllllllllllIIllIIIIllIIIlllI = lllllllllllllllIIllIIIIllIIlIIIl.prevRotationPitch + (lllllllllllllllIIllIIIIllIIlIIIl.rotationPitch - lllllllllllllllIIllIIIIllIIlIIIl.prevRotationPitch) * lllllllllllllllIIllIIIIllIIIllll;
        final float lllllllllllllllIIllIIIIllIIIllIl = lllllllllllllllIIllIIIIllIIlIIIl.prevRotationYaw + (lllllllllllllllIIllIIIIllIIlIIIl.rotationYaw - lllllllllllllllIIllIIIIllIIlIIIl.prevRotationYaw) * lllllllllllllllIIllIIIIllIIIllll;
        final double lllllllllllllllIIllIIIIllIIIlIll = lllllllllllllllIIllIIIIllIIlIIIl.prevPosX + (lllllllllllllllIIllIIIIllIIlIIIl.posX - lllllllllllllllIIllIIIIllIIlIIIl.prevPosX) * lllllllllllllllIIllIIIIllIIIllll;
        final double lllllllllllllllIIllIIIIllIIIlIIl = lllllllllllllllIIllIIIIllIIlIIIl.prevPosY + (lllllllllllllllIIllIIIIllIIlIIIl.posY - lllllllllllllllIIllIIIIllIIlIIIl.prevPosY) * lllllllllllllllIIllIIIIllIIIllll + lllllllllllllllIIllIIIIllIIlIIIl.getEyeHeight();
        final double lllllllllllllllIIllIIIIllIIIlIII = lllllllllllllllIIllIIIIllIIlIIIl.prevPosZ + (lllllllllllllllIIllIIIIllIIlIIIl.posZ - lllllllllllllllIIllIIIIllIIlIIIl.prevPosZ) * lllllllllllllllIIllIIIIllIIIllll;
        final Vec3 lllllllllllllllIIllIIIIllIIIIlll = new Vec3(lllllllllllllllIIllIIIIllIIIlIll, lllllllllllllllIIllIIIIllIIIlIIl, lllllllllllllllIIllIIIIllIIIlIII);
        final float lllllllllllllllIIllIIIIllIIIIlIl = MathHelper.cos(-lllllllllllllllIIllIIIIllIIIllIl * 0.017453292f - 3.1415927f);
        final float lllllllllllllllIIllIIIIllIIIIIll = MathHelper.sin(-lllllllllllllllIIllIIIIllIIIllIl * 0.017453292f - 3.1415927f);
        final float lllllllllllllllIIllIIIIllIIIIIIl = -MathHelper.cos(-lllllllllllllllIIllIIIIllIIIlllI * 0.017453292f);
        final float lllllllllllllllIIllIIIIlIlllllll = MathHelper.sin(-lllllllllllllllIIllIIIIllIIIlllI * 0.017453292f);
        final float lllllllllllllllIIllIIIIlIllllllI = lllllllllllllllIIllIIIIllIIIIIll * lllllllllllllllIIllIIIIllIIIIIIl;
        final float lllllllllllllllIIllIIIIlIlllllIl = lllllllllllllllIIllIIIIllIIIIlIl * lllllllllllllllIIllIIIIllIIIIIIl;
        final double lllllllllllllllIIllIIIIlIllllIll = 5.0;
        final Vec3 lllllllllllllllIIllIIIIlIllllIIl = lllllllllllllllIIllIIIIllIIIIlll.addVector(lllllllllllllllIIllIIIIlIllllllI * lllllllllllllllIIllIIIIlIllllIll, lllllllllllllllIIllIIIIlIlllllll * lllllllllllllllIIllIIIIlIllllIll, lllllllllllllllIIllIIIIlIlllllIl * lllllllllllllllIIllIIIIlIllllIll);
        final MovingObjectPosition lllllllllllllllIIllIIIIlIllllIII = lllllllllllllllIIllIIIIllIIlIIll.rayTraceBlocks(lllllllllllllllIIllIIIIllIIIIlll, lllllllllllllllIIllIIIIlIllllIIl, true);
        if (lllllllllllllllIIllIIIIlIllllIII == null) {
            return lllllllllllllllIIllIIIIlIllIlIII;
        }
        final Vec3 lllllllllllllllIIllIIIIlIlllIlll = lllllllllllllllIIllIIIIllIIlIIIl.getLook(lllllllllllllllIIllIIIIllIIIllll);
        boolean lllllllllllllllIIllIIIIlIlllIllI = false;
        final float lllllllllllllllIIllIIIIlIlllIlII = 1.0f;
        final List lllllllllllllllIIllIIIIlIlllIIll = lllllllllllllllIIllIIIIllIIlIIll.getEntitiesWithinAABBExcludingEntity(lllllllllllllllIIllIIIIllIIlIIIl, lllllllllllllllIIllIIIIllIIlIIIl.getEntityBoundingBox().addCoord(lllllllllllllllIIllIIIIlIlllIlll.xCoord * lllllllllllllllIIllIIIIlIllllIll, lllllllllllllllIIllIIIIlIlllIlll.yCoord * lllllllllllllllIIllIIIIlIllllIll, lllllllllllllllIIllIIIIlIlllIlll.zCoord * lllllllllllllllIIllIIIIlIllllIll).expand(lllllllllllllllIIllIIIIlIlllIlII, lllllllllllllllIIllIIIIlIlllIlII, lllllllllllllllIIllIIIIlIlllIlII));
        for (int lllllllllllllllIIllIIIIlIlllIIlI = 0; lllllllllllllllIIllIIIIlIlllIIlI < lllllllllllllllIIllIIIIlIlllIIll.size(); ++lllllllllllllllIIllIIIIlIlllIIlI) {
            final Entity lllllllllllllllIIllIIIIlIlllIIII = lllllllllllllllIIllIIIIlIlllIIll.get(lllllllllllllllIIllIIIIlIlllIIlI);
            if (lllllllllllllllIIllIIIIlIlllIIII.canBeCollidedWith()) {
                final float lllllllllllllllIIllIIIIlIllIlllI = lllllllllllllllIIllIIIIlIlllIIII.getCollisionBorderSize();
                final AxisAlignedBB lllllllllllllllIIllIIIIlIllIllIl = lllllllllllllllIIllIIIIlIlllIIII.getEntityBoundingBox().expand(lllllllllllllllIIllIIIIlIllIlllI, lllllllllllllllIIllIIIIlIllIlllI, lllllllllllllllIIllIIIIlIllIlllI);
                if (lllllllllllllllIIllIIIIlIllIllIl.isVecInside(lllllllllllllllIIllIIIIllIIIIlll)) {
                    lllllllllllllllIIllIIIIlIlllIllI = true;
                }
            }
        }
        if (lllllllllllllllIIllIIIIlIlllIllI) {
            return lllllllllllllllIIllIIIIlIllIlIII;
        }
        if (lllllllllllllllIIllIIIIlIllllIII.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            BlockPos lllllllllllllllIIllIIIIlIllIllII = lllllllllllllllIIllIIIIlIllllIII.func_178782_a();
            if (lllllllllllllllIIllIIIIllIIlIIll.getBlockState(lllllllllllllllIIllIIIIlIllIllII).getBlock() == Blocks.snow_layer) {
                lllllllllllllllIIllIIIIlIllIllII = lllllllllllllllIIllIIIIlIllIllII.offsetDown();
            }
            final EntityBoat lllllllllllllllIIllIIIIlIllIlIll = new EntityBoat(lllllllllllllllIIllIIIIllIIlIIll, lllllllllllllllIIllIIIIlIllIllII.getX() + 0.5f, lllllllllllllllIIllIIIIlIllIllII.getY() + 1.0f, lllllllllllllllIIllIIIIlIllIllII.getZ() + 0.5f);
            lllllllllllllllIIllIIIIlIllIlIll.rotationYaw = (float)(((MathHelper.floor_double(lllllllllllllllIIllIIIIllIIlIIIl.rotationYaw * 4.0f / 360.0f + 0.5) & 0x3) - 1) * 90);
            if (!lllllllllllllllIIllIIIIllIIlIIll.getCollidingBoundingBoxes(lllllllllllllllIIllIIIIlIllIlIll, lllllllllllllllIIllIIIIlIllIlIll.getEntityBoundingBox().expand(-0.1, -0.1, -0.1)).isEmpty()) {
                return lllllllllllllllIIllIIIIlIllIlIII;
            }
            if (!lllllllllllllllIIllIIIIllIIlIIll.isRemote) {
                lllllllllllllllIIllIIIIllIIlIIll.spawnEntityInWorld(lllllllllllllllIIllIIIIlIllIlIll);
            }
            if (!lllllllllllllllIIllIIIIllIIlIIIl.capabilities.isCreativeMode) {
                --lllllllllllllllIIllIIIIlIllIlIII.stackSize;
            }
            lllllllllllllllIIllIIIIllIIlIIIl.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
        }
        return lllllllllllllllIIllIIIIlIllIlIII;
    }
    
    public ItemBoat() {
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabTransport);
    }
    
    static {
        __OBFID = "CL_00001774";
    }
}
