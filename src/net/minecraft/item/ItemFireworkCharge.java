package net.minecraft.item;

import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.util.*;

public class ItemFireworkCharge extends Item
{
    static {
        __OBFID = "CL_00000030";
    }
    
    public static NBTBase func_150903_a(final ItemStack llllllllllllllIlllIIlIIIIllllIll, final String llllllllllllllIlllIIlIIIIlllllIl) {
        if (llllllllllllllIlllIIlIIIIllllIll.hasTagCompound()) {
            final NBTTagCompound llllllllllllllIlllIIlIIIIlllllII = llllllllllllllIlllIIlIIIIllllIll.getTagCompound().getCompoundTag("Explosion");
            if (llllllllllllllIlllIIlIIIIlllllII != null) {
                return llllllllllllllIlllIIlIIIIlllllII.getTag(llllllllllllllIlllIIlIIIIlllllIl);
            }
        }
        return null;
    }
    
    @Override
    public int getColorFromItemStack(final ItemStack llllllllllllllIlllIIlIIIlIIllIlI, final int llllllllllllllIlllIIlIIIlIIIllII) {
        if (llllllllllllllIlllIIlIIIlIIIllII != 1) {
            return super.getColorFromItemStack(llllllllllllllIlllIIlIIIlIIllIlI, llllllllllllllIlllIIlIIIlIIIllII);
        }
        final NBTBase llllllllllllllIlllIIlIIIlIIllIII = func_150903_a(llllllllllllllIlllIIlIIIlIIllIlI, "Colors");
        if (!(llllllllllllllIlllIIlIIIlIIllIII instanceof NBTTagIntArray)) {
            return 9079434;
        }
        final NBTTagIntArray llllllllllllllIlllIIlIIIlIIlIlll = (NBTTagIntArray)llllllllllllllIlllIIlIIIlIIllIII;
        final int[] llllllllllllllIlllIIlIIIlIIlIllI = llllllllllllllIlllIIlIIIlIIlIlll.getIntArray();
        if (llllllllllllllIlllIIlIIIlIIlIllI.length == 1) {
            return llllllllllllllIlllIIlIIIlIIlIllI[0];
        }
        int llllllllllllllIlllIIlIIIlIIlIlIl = 0;
        int llllllllllllllIlllIIlIIIlIIlIlII = 0;
        int llllllllllllllIlllIIlIIIlIIlIIll = 0;
        final int[] llllllllllllllIlllIIlIIIlIIlIIlI = llllllllllllllIlllIIlIIIlIIlIllI;
        for (int llllllllllllllIlllIIlIIIlIIlIIIl = llllllllllllllIlllIIlIIIlIIlIllI.length, llllllllllllllIlllIIlIIIlIIlIIII = 0; llllllllllllllIlllIIlIIIlIIlIIII < llllllllllllllIlllIIlIIIlIIlIIIl; ++llllllllllllllIlllIIlIIIlIIlIIII) {
            final int llllllllllllllIlllIIlIIIlIIIllll = llllllllllllllIlllIIlIIIlIIlIIlI[llllllllllllllIlllIIlIIIlIIlIIII];
            llllllllllllllIlllIIlIIIlIIlIlIl += (llllllllllllllIlllIIlIIIlIIIllll & 0xFF0000) >> 16;
            llllllllllllllIlllIIlIIIlIIlIlII += (llllllllllllllIlllIIlIIIlIIIllll & 0xFF00) >> 8;
            llllllllllllllIlllIIlIIIlIIlIIll += (llllllllllllllIlllIIlIIIlIIIllll & 0xFF) >> 0;
        }
        llllllllllllllIlllIIlIIIlIIlIlIl /= llllllllllllllIlllIIlIIIlIIlIllI.length;
        llllllllllllllIlllIIlIIIlIIlIlII /= llllllllllllllIlllIIlIIIlIIlIllI.length;
        llllllllllllllIlllIIlIIIlIIlIIll /= llllllllllllllIlllIIlIIIlIIlIllI.length;
        return llllllllllllllIlllIIlIIIlIIlIlIl << 16 | llllllllllllllIlllIIlIIIlIIlIlII << 8 | llllllllllllllIlllIIlIIIlIIlIIll;
    }
    
    @Override
    public void addInformation(final ItemStack llllllllllllllIlllIIlIIIIllIllll, final EntityPlayer llllllllllllllIlllIIlIIIIlllIIll, final List llllllllllllllIlllIIlIIIIlllIIlI, final boolean llllllllllllllIlllIIlIIIIlllIIIl) {
        if (llllllllllllllIlllIIlIIIIllIllll.hasTagCompound()) {
            final NBTTagCompound llllllllllllllIlllIIlIIIIlllIIII = llllllllllllllIlllIIlIIIIllIllll.getTagCompound().getCompoundTag("Explosion");
            if (llllllllllllllIlllIIlIIIIlllIIII != null) {
                func_150902_a(llllllllllllllIlllIIlIIIIlllIIII, llllllllllllllIlllIIlIIIIlllIIlI);
            }
        }
    }
    
    public static void func_150902_a(final NBTTagCompound llllllllllllllIlllIIlIIIIlIlllll, final List llllllllllllllIlllIIlIIIIlIIIlll) {
        final byte llllllllllllllIlllIIlIIIIlIlllIl = llllllllllllllIlllIIlIIIIlIlllll.getByte("Type");
        if (llllllllllllllIlllIIlIIIIlIlllIl >= 0 && llllllllllllllIlllIIlIIIIlIlllIl <= 4) {
            llllllllllllllIlllIIlIIIIlIIIlll.add(StatCollector.translateToLocal(String.valueOf(new StringBuilder("item.fireworksCharge.type.").append(llllllllllllllIlllIIlIIIIlIlllIl))).trim());
        }
        else {
            llllllllllllllIlllIIlIIIIlIIIlll.add(StatCollector.translateToLocal("item.fireworksCharge.type").trim());
        }
        final int[] llllllllllllllIlllIIlIIIIlIlllII = llllllllllllllIlllIIlIIIIlIlllll.getIntArray("Colors");
        if (llllllllllllllIlllIIlIIIIlIlllII.length > 0) {
            boolean llllllllllllllIlllIIlIIIIlIlIlll = true;
            String llllllllllllllIlllIIlIIIIlIlIllI = "";
            final int[] llllllllllllllIlllIIlIIIIlIlIlIl = llllllllllllllIlllIIlIIIIlIlllII;
            for (int llllllllllllllIlllIIlIIIIlIlIlII = llllllllllllllIlllIIlIIIIlIlllII.length, llllllllllllllIlllIIlIIIIlIllIll = 0; llllllllllllllIlllIIlIIIIlIllIll < llllllllllllllIlllIIlIIIIlIlIlII; ++llllllllllllllIlllIIlIIIIlIllIll) {
                final int llllllllllllllIlllIIlIIIIlIllIIl = llllllllllllllIlllIIlIIIIlIlIlIl[llllllllllllllIlllIIlIIIIlIllIll];
                if (!llllllllllllllIlllIIlIIIIlIlIlll) {
                    llllllllllllllIlllIIlIIIIlIlIllI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlllIIlIIIIlIlIllI)).append(", "));
                }
                llllllllllllllIlllIIlIIIIlIlIlll = false;
                boolean llllllllllllllIlllIIlIIIIlIlIIll = false;
                for (int llllllllllllllIlllIIlIIIIlIlIIlI = 0; llllllllllllllIlllIIlIIIIlIlIIlI < ItemDye.dyeColors.length; ++llllllllllllllIlllIIlIIIIlIlIIlI) {
                    if (llllllllllllllIlllIIlIIIIlIllIIl == ItemDye.dyeColors[llllllllllllllIlllIIlIIIIlIlIIlI]) {
                        llllllllllllllIlllIIlIIIIlIlIIll = true;
                        llllllllllllllIlllIIlIIIIlIlIllI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlllIIlIIIIlIlIllI)).append(StatCollector.translateToLocal(String.valueOf(new StringBuilder("item.fireworksCharge.").append(EnumDyeColor.func_176766_a(llllllllllllllIlllIIlIIIIlIlIIlI).func_176762_d())))));
                        break;
                    }
                }
                if (!llllllllllllllIlllIIlIIIIlIlIIll) {
                    llllllllllllllIlllIIlIIIIlIlIllI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlllIIlIIIIlIlIllI)).append(StatCollector.translateToLocal("item.fireworksCharge.customColor")));
                }
            }
            llllllllllllllIlllIIlIIIIlIIIlll.add(llllllllllllllIlllIIlIIIIlIlIllI);
        }
        final int[] llllllllllllllIlllIIlIIIIlIlIIIl = llllllllllllllIlllIIlIIIIlIlllll.getIntArray("FadeColors");
        if (llllllllllllllIlllIIlIIIIlIlIIIl.length > 0) {
            boolean llllllllllllllIlllIIlIIIIlIlIIII = true;
            String llllllllllllllIlllIIlIIIIlIIlllI = String.valueOf(new StringBuilder(String.valueOf(StatCollector.translateToLocal("item.fireworksCharge.fadeTo"))).append(" "));
            final int[] llllllllllllllIlllIIlIIIIlIIllIl = llllllllllllllIlllIIlIIIIlIlIIIl;
            for (int llllllllllllllIlllIIlIIIIlIllIlI = llllllllllllllIlllIIlIIIIlIlIIIl.length, llllllllllllllIlllIIlIIIIlIllIII = 0; llllllllllllllIlllIIlIIIIlIllIII < llllllllllllllIlllIIlIIIIlIllIlI; ++llllllllllllllIlllIIlIIIIlIllIII) {
                final int llllllllllllllIlllIIlIIIIlIIllII = llllllllllllllIlllIIlIIIIlIIllIl[llllllllllllllIlllIIlIIIIlIllIII];
                if (!llllllllllllllIlllIIlIIIIlIlIIII) {
                    llllllllllllllIlllIIlIIIIlIIlllI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlllIIlIIIIlIIlllI)).append(", "));
                }
                llllllllllllllIlllIIlIIIIlIlIIII = false;
                boolean llllllllllllllIlllIIlIIIIlIIlIll = false;
                for (int llllllllllllllIlllIIlIIIIlIIlIlI = 0; llllllllllllllIlllIIlIIIIlIIlIlI < 16; ++llllllllllllllIlllIIlIIIIlIIlIlI) {
                    if (llllllllllllllIlllIIlIIIIlIIllII == ItemDye.dyeColors[llllllllllllllIlllIIlIIIIlIIlIlI]) {
                        llllllllllllllIlllIIlIIIIlIIlIll = true;
                        llllllllllllllIlllIIlIIIIlIIlllI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlllIIlIIIIlIIlllI)).append(StatCollector.translateToLocal(String.valueOf(new StringBuilder("item.fireworksCharge.").append(EnumDyeColor.func_176766_a(llllllllllllllIlllIIlIIIIlIIlIlI).func_176762_d())))));
                        break;
                    }
                }
                if (!llllllllllllllIlllIIlIIIIlIIlIll) {
                    llllllllllllllIlllIIlIIIIlIIlllI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlllIIlIIIIlIIlllI)).append(StatCollector.translateToLocal("item.fireworksCharge.customColor")));
                }
            }
            llllllllllllllIlllIIlIIIIlIIIlll.add(llllllllllllllIlllIIlIIIIlIIlllI);
        }
        final boolean llllllllllllllIlllIIlIIIIlIIllll = llllllllllllllIlllIIlIIIIlIlllll.getBoolean("Trail");
        if (llllllllllllllIlllIIlIIIIlIIllll) {
            llllllllllllllIlllIIlIIIIlIIIlll.add(StatCollector.translateToLocal("item.fireworksCharge.trail"));
        }
        final boolean llllllllllllllIlllIIlIIIIlIIlIIl = llllllllllllllIlllIIlIIIIlIlllll.getBoolean("Flicker");
        if (llllllllllllllIlllIIlIIIIlIIlIIl) {
            llllllllllllllIlllIIlIIIIlIIIlll.add(StatCollector.translateToLocal("item.fireworksCharge.flicker"));
        }
    }
}
