package net.minecraft.item;

import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.block.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import java.util.*;

public class ItemLead extends Item
{
    @Override
    public boolean onItemUse(final ItemStack llllllllllllllllllIlIIlllIIIIIII, final EntityPlayer llllllllllllllllllIlIIllIlllIlll, final World llllllllllllllllllIlIIllIllllllI, final BlockPos llllllllllllllllllIlIIllIlllllIl, final EnumFacing llllllllllllllllllIlIIllIlllllII, final float llllllllllllllllllIlIIllIllllIll, final float llllllllllllllllllIlIIllIllllIlI, final float llllllllllllllllllIlIIllIllllIIl) {
        final Block llllllllllllllllllIlIIllIllllIII = llllllllllllllllllIlIIllIllllllI.getBlockState(llllllllllllllllllIlIIllIlllllIl).getBlock();
        if (!(llllllllllllllllllIlIIllIllllIII instanceof BlockFence)) {
            return false;
        }
        if (llllllllllllllllllIlIIllIllllllI.isRemote) {
            return true;
        }
        func_180618_a(llllllllllllllllllIlIIllIlllIlll, llllllllllllllllllIlIIllIllllllI, llllllllllllllllllIlIIllIlllllIl);
        return true;
    }
    
    public ItemLead() {
        this.setCreativeTab(CreativeTabs.tabTools);
    }
    
    public static boolean func_180618_a(final EntityPlayer llllllllllllllllllIlIIllIlIllIll, final World llllllllllllllllllIlIIllIllIIllI, final BlockPos llllllllllllllllllIlIIllIlIllIIl) {
        EntityLeashKnot llllllllllllllllllIlIIllIllIIlII = EntityLeashKnot.func_174863_b(llllllllllllllllllIlIIllIllIIllI, llllllllllllllllllIlIIllIlIllIIl);
        boolean llllllllllllllllllIlIIllIllIIIll = false;
        final double llllllllllllllllllIlIIllIllIIIlI = 7.0;
        final int llllllllllllllllllIlIIllIllIIIIl = llllllllllllllllllIlIIllIlIllIIl.getX();
        final int llllllllllllllllllIlIIllIllIIIII = llllllllllllllllllIlIIllIlIllIIl.getY();
        final int llllllllllllllllllIlIIllIlIlllll = llllllllllllllllllIlIIllIlIllIIl.getZ();
        final List llllllllllllllllllIlIIllIlIllllI = llllllllllllllllllIlIIllIllIIllI.getEntitiesWithinAABB(EntityLiving.class, new AxisAlignedBB(llllllllllllllllllIlIIllIllIIIIl - llllllllllllllllllIlIIllIllIIIlI, llllllllllllllllllIlIIllIllIIIII - llllllllllllllllllIlIIllIllIIIlI, llllllllllllllllllIlIIllIlIlllll - llllllllllllllllllIlIIllIllIIIlI, llllllllllllllllllIlIIllIllIIIIl + llllllllllllllllllIlIIllIllIIIlI, llllllllllllllllllIlIIllIllIIIII + llllllllllllllllllIlIIllIllIIIlI, llllllllllllllllllIlIIllIlIlllll + llllllllllllllllllIlIIllIllIIIlI));
        for (final EntityLiving llllllllllllllllllIlIIllIlIlllII : llllllllllllllllllIlIIllIlIllllI) {
            if (llllllllllllllllllIlIIllIlIlllII.getLeashed() && llllllllllllllllllIlIIllIlIlllII.getLeashedToEntity() == llllllllllllllllllIlIIllIlIllIll) {
                if (llllllllllllllllllIlIIllIllIIlII == null) {
                    llllllllllllllllllIlIIllIllIIlII = EntityLeashKnot.func_174862_a(llllllllllllllllllIlIIllIllIIllI, llllllllllllllllllIlIIllIlIllIIl);
                }
                llllllllllllllllllIlIIllIlIlllII.setLeashedToEntity(llllllllllllllllllIlIIllIllIIlII, true);
                llllllllllllllllllIlIIllIllIIIll = true;
            }
        }
        return llllllllllllllllllIlIIllIllIIIll;
    }
    
    static {
        __OBFID = "CL_00000045";
    }
}
