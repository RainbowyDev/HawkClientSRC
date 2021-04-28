package hawk.util;

import net.minecraft.client.*;
import net.minecraft.item.*;

public class ArmorUtils
{
    public static boolean isBetterArmor(final int lllllllllllllllIlIlIIIlIlIIlIIIl, final int[] lllllllllllllllIlIlIIIlIlIIlllII) {
        if (Minecraft.getMinecraft().thePlayer.inventory.armorInventory[lllllllllllllllIlIlIIIlIlIIlIIIl] != null) {
            int lllllllllllllllIlIlIIIlIlIIllIll = 0;
            int lllllllllllllllIlIlIIIlIlIIllIlI = 0;
            int lllllllllllllllIlIlIIIlIlIIllIIl = -1;
            int lllllllllllllllIlIlIIIlIlIIllIII = -1;
            int[] lllllllllllllllIlIlIIIlIlIIlIlll = lllllllllllllllIlIlIIIlIlIIlllII;
            for (int lllllllllllllllIlIlIIIlIlIIlIllI = lllllllllllllllIlIlIIIlIlIIlllII.length, lllllllllllllllIlIlIIIlIlIIlIlIl = 0; lllllllllllllllIlIlIIIlIlIIlIlIl < lllllllllllllllIlIlIIIlIlIIlIllI; ++lllllllllllllllIlIlIIIlIlIIlIlIl) {
                final int lllllllllllllllIlIlIIIlIlIIlIlII = lllllllllllllllIlIlIIIlIlIIlIlll[lllllllllllllllIlIlIIIlIlIIlIlIl];
                if (Item.getIdFromItem(Minecraft.getMinecraft().thePlayer.inventory.armorInventory[lllllllllllllllIlIlIIIlIlIIlIIIl].getItem()) == lllllllllllllllIlIlIIIlIlIIlIlII) {
                    lllllllllllllllIlIlIIIlIlIIllIIl = lllllllllllllllIlIlIIIlIlIIllIll;
                    break;
                }
                ++lllllllllllllllIlIlIIIlIlIIllIll;
            }
            lllllllllllllllIlIlIIIlIlIIlIlll = lllllllllllllllIlIlIIIlIlIIlllII;
            for (int lllllllllllllllIlIlIIIlIlIIlIllI = lllllllllllllllIlIlIIIlIlIIlllII.length, lllllllllllllllIlIlIIIlIlIIlIIll = 0; lllllllllllllllIlIlIIIlIlIIlIIll < lllllllllllllllIlIlIIIlIlIIlIllI; ++lllllllllllllllIlIlIIIlIlIIlIIll) {
                final int lllllllllllllllIlIlIIIlIlIIlIIlI = lllllllllllllllIlIlIIIlIlIIlIlll[lllllllllllllllIlIlIIIlIlIIlIIll];
                if (getItem(lllllllllllllllIlIlIIIlIlIIlIIlI) != -1) {
                    lllllllllllllllIlIlIIIlIlIIllIII = lllllllllllllllIlIlIIIlIlIIllIlI;
                    break;
                }
                ++lllllllllllllllIlIlIIIlIlIIllIlI;
            }
            if (lllllllllllllllIlIlIIIlIlIIllIII > -1) {
                return lllllllllllllllIlIlIIIlIlIIllIII < lllllllllllllllIlIlIIIlIlIIllIIl;
            }
        }
        return false;
    }
    
    public static int getItem(final int lllllllllllllllIlIlIIIlIlIIIIIIl) {
        for (int lllllllllllllllIlIlIIIlIlIIIIIll = 9; lllllllllllllllIlIlIIIlIlIIIIIll < 45; ++lllllllllllllllIlIlIIIlIlIIIIIll) {
            final ItemStack lllllllllllllllIlIlIIIlIlIIIIIlI = Minecraft.getMinecraft().thePlayer.inventoryContainer.getSlot(lllllllllllllllIlIlIIIlIlIIIIIll).getStack();
            if (lllllllllllllllIlIlIIIlIlIIIIIlI != null && Item.getIdFromItem(lllllllllllllllIlIlIIIlIlIIIIIlI.getItem()) == lllllllllllllllIlIlIIIlIlIIIIIIl) {
                return lllllllllllllllIlIlIIIlIlIIIIIll;
            }
        }
        return -1;
    }
}
