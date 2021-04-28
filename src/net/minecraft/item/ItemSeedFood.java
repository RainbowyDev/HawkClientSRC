package net.minecraft.item;

import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.util.*;

public class ItemSeedFood extends ItemFood
{
    private /* synthetic */ Block soilId;
    private /* synthetic */ Block field_150908_b;
    
    public ItemSeedFood(final int llllllllllllllIlIIlIllllIIIIIIII, final float llllllllllllllIlIIlIlllIllllllll, final Block llllllllllllllIlIIlIlllIlllllIIl, final Block llllllllllllllIlIIlIlllIllllllIl) {
        super(llllllllllllllIlIIlIllllIIIIIIII, llllllllllllllIlIIlIlllIllllllll, false);
        this.field_150908_b = llllllllllllllIlIIlIlllIlllllIIl;
        this.soilId = llllllllllllllIlIIlIlllIllllllIl;
    }
    
    static {
        __OBFID = "CL_00000060";
    }
    
    @Override
    public boolean onItemUse(final ItemStack llllllllllllllIlIIlIlllIlllIIlll, final EntityPlayer llllllllllllllIlIIlIlllIlllIllll, final World llllllllllllllIlIIlIlllIlllIlllI, final BlockPos llllllllllllllIlIIlIlllIlllIllIl, final EnumFacing llllllllllllllIlIIlIlllIlllIllII, final float llllllllllllllIlIIlIlllIlllIlIll, final float llllllllllllllIlIIlIlllIlllIlIlI, final float llllllllllllllIlIIlIlllIlllIlIIl) {
        if (llllllllllllllIlIIlIlllIlllIllII != EnumFacing.UP) {
            return false;
        }
        if (!llllllllllllllIlIIlIlllIlllIllll.func_175151_a(llllllllllllllIlIIlIlllIlllIllIl.offset(llllllllllllllIlIIlIlllIlllIllII), llllllllllllllIlIIlIlllIlllIllII, llllllllllllllIlIIlIlllIlllIIlll)) {
            return false;
        }
        if (llllllllllllllIlIIlIlllIlllIlllI.getBlockState(llllllllllllllIlIIlIlllIlllIllIl).getBlock() == this.soilId && llllllllllllllIlIIlIlllIlllIlllI.isAirBlock(llllllllllllllIlIIlIlllIlllIllIl.offsetUp())) {
            llllllllllllllIlIIlIlllIlllIlllI.setBlockState(llllllllllllllIlIIlIlllIlllIllIl.offsetUp(), this.field_150908_b.getDefaultState());
            --llllllllllllllIlIIlIlllIlllIIlll.stackSize;
            return true;
        }
        return false;
    }
}
