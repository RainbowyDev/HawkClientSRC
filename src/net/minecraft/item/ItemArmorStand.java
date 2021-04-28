package net.minecraft.item;

import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.nbt.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.util.*;

public class ItemArmorStand extends Item
{
    @Override
    public boolean onItemUse(final ItemStack lllllllllllllllIIllIllIIIIIIlllI, final EntityPlayer lllllllllllllllIIllIllIIIIIIllIl, final World lllllllllllllllIIllIlIllllllIlll, final BlockPos lllllllllllllllIIllIlIllllllIllI, final EnumFacing lllllllllllllllIIllIllIIIIIIlIlI, final float lllllllllllllllIIllIllIIIIIIlIIl, final float lllllllllllllllIIllIllIIIIIIlIII, final float lllllllllllllllIIllIllIIIIIIIlll) {
        if (lllllllllllllllIIllIllIIIIIIlIlI == EnumFacing.DOWN) {
            return false;
        }
        final boolean lllllllllllllllIIllIllIIIIIIIllI = lllllllllllllllIIllIlIllllllIlll.getBlockState(lllllllllllllllIIllIlIllllllIllI).getBlock().isReplaceable(lllllllllllllllIIllIlIllllllIlll, lllllllllllllllIIllIlIllllllIllI);
        final BlockPos lllllllllllllllIIllIllIIIIIIIlIl = lllllllllllllllIIllIllIIIIIIIllI ? lllllllllllllllIIllIlIllllllIllI : lllllllllllllllIIllIlIllllllIllI.offset(lllllllllllllllIIllIllIIIIIIlIlI);
        if (!lllllllllllllllIIllIllIIIIIIllIl.func_175151_a(lllllllllllllllIIllIllIIIIIIIlIl, lllllllllllllllIIllIllIIIIIIlIlI, lllllllllllllllIIllIllIIIIIIlllI)) {
            return false;
        }
        final BlockPos lllllllllllllllIIllIllIIIIIIIlII = lllllllllllllllIIllIllIIIIIIIlIl.offsetUp();
        boolean lllllllllllllllIIllIllIIIIIIIIll = !lllllllllllllllIIllIlIllllllIlll.isAirBlock(lllllllllllllllIIllIllIIIIIIIlIl) && !lllllllllllllllIIllIlIllllllIlll.getBlockState(lllllllllllllllIIllIllIIIIIIIlIl).getBlock().isReplaceable(lllllllllllllllIIllIlIllllllIlll, lllllllllllllllIIllIllIIIIIIIlIl);
        lllllllllllllllIIllIllIIIIIIIIll |= (!lllllllllllllllIIllIlIllllllIlll.isAirBlock(lllllllllllllllIIllIllIIIIIIIlII) && !lllllllllllllllIIllIlIllllllIlll.getBlockState(lllllllllllllllIIllIllIIIIIIIlII).getBlock().isReplaceable(lllllllllllllllIIllIlIllllllIlll, lllllllllllllllIIllIllIIIIIIIlII));
        if (lllllllllllllllIIllIllIIIIIIIIll) {
            return false;
        }
        final double lllllllllllllllIIllIllIIIIIIIIlI = lllllllllllllllIIllIllIIIIIIIlIl.getX();
        final double lllllllllllllllIIllIllIIIIIIIIIl = lllllllllllllllIIllIllIIIIIIIlIl.getY();
        final double lllllllllllllllIIllIllIIIIIIIIII = lllllllllllllllIIllIllIIIIIIIlIl.getZ();
        final List lllllllllllllllIIllIlIllllllllll = lllllllllllllllIIllIlIllllllIlll.getEntitiesWithinAABBExcludingEntity(null, AxisAlignedBB.fromBounds(lllllllllllllllIIllIllIIIIIIIIlI, lllllllllllllllIIllIllIIIIIIIIIl, lllllllllllllllIIllIllIIIIIIIIII, lllllllllllllllIIllIllIIIIIIIIlI + 1.0, lllllllllllllllIIllIllIIIIIIIIIl + 2.0, lllllllllllllllIIllIllIIIIIIIIII + 1.0));
        if (lllllllllllllllIIllIlIllllllllll.size() > 0) {
            return false;
        }
        if (!lllllllllllllllIIllIlIllllllIlll.isRemote) {
            lllllllllllllllIIllIlIllllllIlll.setBlockToAir(lllllllllllllllIIllIllIIIIIIIlIl);
            lllllllllllllllIIllIlIllllllIlll.setBlockToAir(lllllllllllllllIIllIllIIIIIIIlII);
            final EntityArmorStand lllllllllllllllIIllIlIlllllllllI = new EntityArmorStand(lllllllllllllllIIllIlIllllllIlll, lllllllllllllllIIllIllIIIIIIIIlI + 0.5, lllllllllllllllIIllIllIIIIIIIIIl, lllllllllllllllIIllIllIIIIIIIIII + 0.5);
            final float lllllllllllllllIIllIlIllllllllIl = MathHelper.floor_float((MathHelper.wrapAngleTo180_float(lllllllllllllllIIllIllIIIIIIllIl.rotationYaw - 180.0f) + 22.5f) / 45.0f) * 45.0f;
            lllllllllllllllIIllIlIlllllllllI.setLocationAndAngles(lllllllllllllllIIllIllIIIIIIIIlI + 0.5, lllllllllllllllIIllIllIIIIIIIIIl, lllllllllllllllIIllIllIIIIIIIIII + 0.5, lllllllllllllllIIllIlIllllllllIl, 0.0f);
            this.func_179221_a(lllllllllllllllIIllIlIlllllllllI, lllllllllllllllIIllIlIllllllIlll.rand);
            final NBTTagCompound lllllllllllllllIIllIlIllllllllII = lllllllllllllllIIllIllIIIIIIlllI.getTagCompound();
            if (lllllllllllllllIIllIlIllllllllII != null && lllllllllllllllIIllIlIllllllllII.hasKey("EntityTag", 10)) {
                final NBTTagCompound lllllllllllllllIIllIlIlllllllIll = new NBTTagCompound();
                lllllllllllllllIIllIlIlllllllllI.writeToNBTOptional(lllllllllllllllIIllIlIlllllllIll);
                lllllllllllllllIIllIlIlllllllIll.merge(lllllllllllllllIIllIlIllllllllII.getCompoundTag("EntityTag"));
                lllllllllllllllIIllIlIlllllllllI.readFromNBT(lllllllllllllllIIllIlIlllllllIll);
            }
            lllllllllllllllIIllIlIllllllIlll.spawnEntityInWorld(lllllllllllllllIIllIlIlllllllllI);
        }
        --lllllllllllllllIIllIllIIIIIIlllI.stackSize;
        return true;
    }
    
    static {
        __OBFID = "CL_00002182";
    }
    
    public ItemArmorStand() {
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }
    
    private void func_179221_a(final EntityArmorStand lllllllllllllllIIllIlIlllllIIIIl, final Random lllllllllllllllIIllIlIllllIllIlI) {
        Rotations lllllllllllllllIIllIlIllllIlllll = lllllllllllllllIIllIlIlllllIIIIl.getHeadRotation();
        float lllllllllllllllIIllIlIllllIllllI = lllllllllllllllIIllIlIllllIllIlI.nextFloat() * 5.0f;
        final float lllllllllllllllIIllIlIllllIlllIl = lllllllllllllllIIllIlIllllIllIlI.nextFloat() * 20.0f - 10.0f;
        Rotations lllllllllllllllIIllIlIllllIlllII = new Rotations(lllllllllllllllIIllIlIllllIlllll.func_179415_b() + lllllllllllllllIIllIlIllllIllllI, lllllllllllllllIIllIlIllllIlllll.func_179416_c() + lllllllllllllllIIllIlIllllIlllIl, lllllllllllllllIIllIlIllllIlllll.func_179413_d());
        lllllllllllllllIIllIlIlllllIIIIl.setHeadRotation(lllllllllllllllIIllIlIllllIlllII);
        lllllllllllllllIIllIlIllllIlllll = lllllllllllllllIIllIlIlllllIIIIl.getBodyRotation();
        lllllllllllllllIIllIlIllllIllllI = lllllllllllllllIIllIlIllllIllIlI.nextFloat() * 10.0f - 5.0f;
        lllllllllllllllIIllIlIllllIlllII = new Rotations(lllllllllllllllIIllIlIllllIlllll.func_179415_b(), lllllllllllllllIIllIlIllllIlllll.func_179416_c() + lllllllllllllllIIllIlIllllIllllI, lllllllllllllllIIllIlIllllIlllll.func_179413_d());
        lllllllllllllllIIllIlIlllllIIIIl.setBodyRotation(lllllllllllllllIIllIlIllllIlllII);
    }
}
