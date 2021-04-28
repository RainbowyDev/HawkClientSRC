package net.minecraft.item;

import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;

public class ItemShears extends Item
{
    @Override
    public boolean canHarvestBlock(final Block lllllllllllllllllllIIlIIIlIllIIl) {
        return lllllllllllllllllllIIlIIIlIllIIl == Blocks.web || lllllllllllllllllllIIlIIIlIllIIl == Blocks.redstone_wire || lllllllllllllllllllIIlIIIlIllIIl == Blocks.tripwire;
    }
    
    @Override
    public boolean onBlockDestroyed(final ItemStack lllllllllllllllllllIIlIIIllIIllI, final World lllllllllllllllllllIIlIIIlIlllll, final Block lllllllllllllllllllIIlIIIlIllllI, final BlockPos lllllllllllllllllllIIlIIIlIlllIl, final EntityLivingBase lllllllllllllllllllIIlIIIlIlllII) {
        if (lllllllllllllllllllIIlIIIlIllllI.getMaterial() != Material.leaves && lllllllllllllllllllIIlIIIlIllllI != Blocks.web && lllllllllllllllllllIIlIIIlIllllI != Blocks.tallgrass && lllllllllllllllllllIIlIIIlIllllI != Blocks.vine && lllllllllllllllllllIIlIIIlIllllI != Blocks.tripwire && lllllllllllllllllllIIlIIIlIllllI != Blocks.wool) {
            return super.onBlockDestroyed(lllllllllllllllllllIIlIIIllIIllI, lllllllllllllllllllIIlIIIlIlllll, lllllllllllllllllllIIlIIIlIllllI, lllllllllllllllllllIIlIIIlIlllIl, lllllllllllllllllllIIlIIIlIlllII);
        }
        lllllllllllllllllllIIlIIIllIIllI.damageItem(1, lllllllllllllllllllIIlIIIlIlllII);
        return true;
    }
    
    @Override
    public float getStrVsBlock(final ItemStack lllllllllllllllllllIIlIIIlIlIIII, final Block lllllllllllllllllllIIlIIIlIlIIlI) {
        return (lllllllllllllllllllIIlIIIlIlIIlI != Blocks.web && lllllllllllllllllllIIlIIIlIlIIlI.getMaterial() != Material.leaves) ? ((lllllllllllllllllllIIlIIIlIlIIlI == Blocks.wool) ? 5.0f : super.getStrVsBlock(lllllllllllllllllllIIlIIIlIlIIII, lllllllllllllllllllIIlIIIlIlIIlI)) : 15.0f;
    }
    
    static {
        __OBFID = "CL_00000062";
    }
    
    public ItemShears() {
        this.setMaxStackSize(1);
        this.setMaxDamage(238);
        this.setCreativeTab(CreativeTabs.tabTools);
    }
}
