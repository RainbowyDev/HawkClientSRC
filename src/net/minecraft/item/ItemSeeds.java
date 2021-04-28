package net.minecraft.item;

import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.creativetab.*;

public class ItemSeeds extends Item
{
    private /* synthetic */ Block soilBlockID;
    private /* synthetic */ Block field_150925_a;
    
    static {
        __OBFID = "CL_00000061";
    }
    
    @Override
    public boolean onItemUse(final ItemStack llllllllllllllllIlIlIlllIIllllIl, final EntityPlayer llllllllllllllllIlIlIlllIIllllII, final World llllllllllllllllIlIlIlllIIlllIll, final BlockPos llllllllllllllllIlIlIlllIIlllIlI, final EnumFacing llllllllllllllllIlIlIlllIIlllIIl, final float llllllllllllllllIlIlIlllIlIIIIIl, final float llllllllllllllllIlIlIlllIlIIIIII, final float llllllllllllllllIlIlIlllIIllllll) {
        if (llllllllllllllllIlIlIlllIIlllIIl != EnumFacing.UP) {
            return false;
        }
        if (!llllllllllllllllIlIlIlllIIllllII.func_175151_a(llllllllllllllllIlIlIlllIIlllIlI.offset(llllllllllllllllIlIlIlllIIlllIIl), llllllllllllllllIlIlIlllIIlllIIl, llllllllllllllllIlIlIlllIIllllIl)) {
            return false;
        }
        if (llllllllllllllllIlIlIlllIIlllIll.getBlockState(llllllllllllllllIlIlIlllIIlllIlI).getBlock() == this.soilBlockID && llllllllllllllllIlIlIlllIIlllIll.isAirBlock(llllllllllllllllIlIlIlllIIlllIlI.offsetUp())) {
            llllllllllllllllIlIlIlllIIlllIll.setBlockState(llllllllllllllllIlIlIlllIIlllIlI.offsetUp(), this.field_150925_a.getDefaultState());
            --llllllllllllllllIlIlIlllIIllllIl.stackSize;
            return true;
        }
        return false;
    }
    
    public ItemSeeds(final Block llllllllllllllllIlIlIlllIlIIllll, final Block llllllllllllllllIlIlIlllIlIIlllI) {
        this.field_150925_a = llllllllllllllllIlIlIlllIlIIllll;
        this.soilBlockID = llllllllllllllllIlIlIlllIlIIlllI;
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }
}
