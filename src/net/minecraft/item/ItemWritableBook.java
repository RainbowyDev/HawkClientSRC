package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.stats.*;
import net.minecraft.nbt.*;

public class ItemWritableBook extends Item
{
    static {
        __OBFID = "CL_00000076";
    }
    
    @Override
    public ItemStack onItemRightClick(final ItemStack lllllllllllllllIlIIIIIlllIlllIIl, final World lllllllllllllllIlIIIIIlllIlllIII, final EntityPlayer lllllllllllllllIlIIIIIlllIllIlII) {
        lllllllllllllllIlIIIIIlllIllIlII.displayGUIBook(lllllllllllllllIlIIIIIlllIlllIIl);
        lllllllllllllllIlIIIIIlllIllIlII.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
        return lllllllllllllllIlIIIIIlllIlllIIl;
    }
    
    public static boolean validBookPageTagContents(final NBTTagCompound lllllllllllllllIlIIIIIlllIlIllll) {
        if (lllllllllllllllIlIIIIIlllIlIllll == null) {
            return false;
        }
        if (!lllllllllllllllIlIIIIIlllIlIllll.hasKey("pages", 9)) {
            return false;
        }
        final NBTTagList lllllllllllllllIlIIIIIlllIlIlllI = lllllllllllllllIlIIIIIlllIlIllll.getTagList("pages", 8);
        for (int lllllllllllllllIlIIIIIlllIlIllIl = 0; lllllllllllllllIlIIIIIlllIlIllIl < lllllllllllllllIlIIIIIlllIlIlllI.tagCount(); ++lllllllllllllllIlIIIIIlllIlIllIl) {
            final String lllllllllllllllIlIIIIIlllIlIllII = lllllllllllllllIlIIIIIlllIlIlllI.getStringTagAt(lllllllllllllllIlIIIIIlllIlIllIl);
            if (lllllllllllllllIlIIIIIlllIlIllII == null) {
                return false;
            }
            if (lllllllllllllllIlIIIIIlllIlIllII.length() > 32767) {
                return false;
            }
        }
        return true;
    }
    
    public ItemWritableBook() {
        this.setMaxStackSize(1);
    }
}
