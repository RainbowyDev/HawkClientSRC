package net.minecraft.item;

import net.minecraft.creativetab.*;
import java.util.*;

public class ItemCoal extends Item
{
    static {
        __OBFID = "CL_00000002";
    }
    
    public ItemCoal() {
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }
    
    @Override
    public String getUnlocalizedName(final ItemStack llllllllllllllllIllIIlIllllIIIIl) {
        return (llllllllllllllllIllIIlIllllIIIIl.getMetadata() == 1) ? "item.charcoal" : "item.coal";
    }
    
    @Override
    public void getSubItems(final Item llllllllllllllllIllIIlIlllIlllII, final CreativeTabs llllllllllllllllIllIIlIlllIllIll, final List llllllllllllllllIllIIlIlllIllIII) {
        llllllllllllllllIllIIlIlllIllIII.add(new ItemStack(llllllllllllllllIllIIlIlllIlllII, 1, 0));
        llllllllllllllllIllIIlIlllIllIII.add(new ItemStack(llllllllllllllllIllIIlIlllIlllII, 1, 1));
    }
}
