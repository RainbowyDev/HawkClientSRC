package net.minecraft.item;

import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.item.*;

public class ItemHangingEntity extends Item
{
    private final /* synthetic */ Class hangingEntityClass;
    
    static {
        __OBFID = "CL_00000038";
    }
    
    @Override
    public boolean onItemUse(final ItemStack llllllllllllllllIlllIlIllIIIIllI, final EntityPlayer llllllllllllllllIlllIlIllIIIIlIl, final World llllllllllllllllIlllIlIllIIIIlII, final BlockPos llllllllllllllllIlllIlIllIIIlllI, final EnumFacing llllllllllllllllIlllIlIllIIIllIl, final float llllllllllllllllIlllIlIllIIIllII, final float llllllllllllllllIlllIlIllIIIlIll, final float llllllllllllllllIlllIlIllIIIlIlI) {
        if (llllllllllllllllIlllIlIllIIIllIl == EnumFacing.DOWN) {
            return false;
        }
        if (llllllllllllllllIlllIlIllIIIllIl == EnumFacing.UP) {
            return false;
        }
        final BlockPos llllllllllllllllIlllIlIllIIIlIIl = llllllllllllllllIlllIlIllIIIlllI.offset(llllllllllllllllIlllIlIllIIIllIl);
        if (!llllllllllllllllIlllIlIllIIIIlIl.func_175151_a(llllllllllllllllIlllIlIllIIIlIIl, llllllllllllllllIlllIlIllIIIllIl, llllllllllllllllIlllIlIllIIIIllI)) {
            return false;
        }
        final EntityHanging llllllllllllllllIlllIlIllIIIlIII = this.func_179233_a(llllllllllllllllIlllIlIllIIIIlII, llllllllllllllllIlllIlIllIIIlIIl, llllllllllllllllIlllIlIllIIIllIl);
        if (llllllllllllllllIlllIlIllIIIlIII != null && llllllllllllllllIlllIlIllIIIlIII.onValidSurface()) {
            if (!llllllllllllllllIlllIlIllIIIIlII.isRemote) {
                llllllllllllllllIlllIlIllIIIIlII.spawnEntityInWorld(llllllllllllllllIlllIlIllIIIlIII);
            }
            --llllllllllllllllIlllIlIllIIIIllI.stackSize;
        }
        return true;
    }
    
    public ItemHangingEntity(final Class llllllllllllllllIlllIlIllIIlllIl) {
        this.hangingEntityClass = llllllllllllllllIlllIlIllIIlllIl;
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }
    
    private EntityHanging func_179233_a(final World llllllllllllllllIlllIlIlIlllIllI, final BlockPos llllllllllllllllIlllIlIlIllllIIl, final EnumFacing llllllllllllllllIlllIlIlIllllIII) {
        return (this.hangingEntityClass == EntityPainting.class) ? new EntityPainting(llllllllllllllllIlllIlIlIlllIllI, llllllllllllllllIlllIlIlIllllIIl, llllllllllllllllIlllIlIlIllllIII) : ((this.hangingEntityClass == EntityItemFrame.class) ? new EntityItemFrame(llllllllllllllllIlllIlIlIlllIllI, llllllllllllllllIlllIlIlIllllIIl, llllllllllllllllIlllIlIlIllllIII) : null);
    }
}
