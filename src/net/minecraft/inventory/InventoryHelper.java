package net.minecraft.inventory;

import java.util.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.entity.item.*;
import net.minecraft.nbt.*;

public class InventoryHelper
{
    private static final /* synthetic */ Random field_180177_a;
    
    public static void dropInventoryItems(final World llllllllllllllIIllIIlIIlllIIlIIl, final BlockPos llllllllllllllIIllIIlIIlllIIlIII, final IInventory llllllllllllllIIllIIlIIlllIIIlll) {
        func_180174_a(llllllllllllllIIllIIlIIlllIIlIIl, llllllllllllllIIllIIlIIlllIIlIII.getX(), llllllllllllllIIllIIlIIlllIIlIII.getY(), llllllllllllllIIllIIlIIlllIIlIII.getZ(), llllllllllllllIIllIIlIIlllIIIlll);
    }
    
    static {
        __OBFID = "CL_00002262";
        field_180177_a = new Random();
    }
    
    public static void func_180176_a(final World llllllllllllllIIllIIlIIlllIIIIII, final Entity llllllllllllllIIllIIlIIllIllllll, final IInventory llllllllllllllIIllIIlIIllIlllllI) {
        func_180174_a(llllllllllllllIIllIIlIIlllIIIIII, llllllllllllllIIllIIlIIllIllllll.posX, llllllllllllllIIllIIlIIllIllllll.posY, llllllllllllllIIllIIlIIllIllllll.posZ, llllllllllllllIIllIIlIIllIlllllI);
    }
    
    private static void func_180174_a(final World llllllllllllllIIllIIlIIllIlIllll, final double llllllllllllllIIllIIlIIllIllIlIl, final double llllllllllllllIIllIIlIIllIllIlII, final double llllllllllllllIIllIIlIIllIlIllII, final IInventory llllllllllllllIIllIIlIIllIlIlIll) {
        for (int llllllllllllllIIllIIlIIllIllIIIl = 0; llllllllllllllIIllIIlIIllIllIIIl < llllllllllllllIIllIIlIIllIlIlIll.getSizeInventory(); ++llllllllllllllIIllIIlIIllIllIIIl) {
            final ItemStack llllllllllllllIIllIIlIIllIllIIII = llllllllllllllIIllIIlIIllIlIlIll.getStackInSlot(llllllllllllllIIllIIlIIllIllIIIl);
            if (llllllllllllllIIllIIlIIllIllIIII != null) {
                func_180173_a(llllllllllllllIIllIIlIIllIlIllll, llllllllllllllIIllIIlIIllIllIlIl, llllllllllllllIIllIIlIIllIllIlII, llllllllllllllIIllIIlIIllIlIllII, llllllllllllllIIllIIlIIllIllIIII);
            }
        }
    }
    
    private static void func_180173_a(final World llllllllllllllIIllIIlIIllIIlllIl, final double llllllllllllllIIllIIlIIllIIlIIIl, final double llllllllllllllIIllIIlIIllIIlIIII, final double llllllllllllllIIllIIlIIllIIllIlI, final ItemStack llllllllllllllIIllIIlIIllIIllIIl) {
        final float llllllllllllllIIllIIlIIllIIllIII = InventoryHelper.field_180177_a.nextFloat() * 0.8f + 0.1f;
        final float llllllllllllllIIllIIlIIllIIlIlll = InventoryHelper.field_180177_a.nextFloat() * 0.8f + 0.1f;
        final float llllllllllllllIIllIIlIIllIIlIllI = InventoryHelper.field_180177_a.nextFloat() * 0.8f + 0.1f;
        while (llllllllllllllIIllIIlIIllIIllIIl.stackSize > 0) {
            int llllllllllllllIIllIIlIIllIIlIlIl = InventoryHelper.field_180177_a.nextInt(21) + 10;
            if (llllllllllllllIIllIIlIIllIIlIlIl > llllllllllllllIIllIIlIIllIIllIIl.stackSize) {
                llllllllllllllIIllIIlIIllIIlIlIl = llllllllllllllIIllIIlIIllIIllIIl.stackSize;
            }
            llllllllllllllIIllIIlIIllIIllIIl.stackSize -= llllllllllllllIIllIIlIIllIIlIlIl;
            final EntityItem llllllllllllllIIllIIlIIllIIlIlII = new EntityItem(llllllllllllllIIllIIlIIllIIlllIl, llllllllllllllIIllIIlIIllIIlIIIl + llllllllllllllIIllIIlIIllIIllIII, llllllllllllllIIllIIlIIllIIlIIII + llllllllllllllIIllIIlIIllIIlIlll, llllllllllllllIIllIIlIIllIIllIlI + llllllllllllllIIllIIlIIllIIlIllI, new ItemStack(llllllllllllllIIllIIlIIllIIllIIl.getItem(), llllllllllllllIIllIIlIIllIIlIlIl, llllllllllllllIIllIIlIIllIIllIIl.getMetadata()));
            if (llllllllllllllIIllIIlIIllIIllIIl.hasTagCompound()) {
                llllllllllllllIIllIIlIIllIIlIlII.getEntityItem().setTagCompound((NBTTagCompound)llllllllllllllIIllIIlIIllIIllIIl.getTagCompound().copy());
            }
            final float llllllllllllllIIllIIlIIllIIlIIll = 0.05f;
            llllllllllllllIIllIIlIIllIIlIlII.motionX = InventoryHelper.field_180177_a.nextGaussian() * llllllllllllllIIllIIlIIllIIlIIll;
            llllllllllllllIIllIIlIIllIIlIlII.motionY = InventoryHelper.field_180177_a.nextGaussian() * llllllllllllllIIllIIlIIllIIlIIll + 0.20000000298023224;
            llllllllllllllIIllIIlIIllIIlIlII.motionZ = InventoryHelper.field_180177_a.nextGaussian() * llllllllllllllIIllIIlIIllIIlIIll;
            llllllllllllllIIllIIlIIllIIlllIl.spawnEntityInWorld(llllllllllllllIIllIIlIIllIIlIlII);
        }
    }
}
