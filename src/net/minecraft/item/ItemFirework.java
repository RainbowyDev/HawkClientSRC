package net.minecraft.item;

import net.minecraft.entity.player.*;
import com.google.common.collect.*;
import net.minecraft.nbt.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.*;

public class ItemFirework extends Item
{
    static {
        __OBFID = "CL_00000031";
    }
    
    @Override
    public void addInformation(final ItemStack lllllllllllllllllIlIIlIIllIlllII, final EntityPlayer lllllllllllllllllIlIIlIIlllIIlIl, final List lllllllllllllllllIlIIlIIllIllIll, final boolean lllllllllllllllllIlIIlIIlllIIIll) {
        if (lllllllllllllllllIlIIlIIllIlllII.hasTagCompound()) {
            final NBTTagCompound lllllllllllllllllIlIIlIIlllIIIlI = lllllllllllllllllIlIIlIIllIlllII.getTagCompound().getCompoundTag("Fireworks");
            if (lllllllllllllllllIlIIlIIlllIIIlI != null) {
                if (lllllllllllllllllIlIIlIIlllIIIlI.hasKey("Flight", 99)) {
                    lllllllllllllllllIlIIlIIllIllIll.add(String.valueOf(new StringBuilder(String.valueOf(StatCollector.translateToLocal("item.fireworks.flight"))).append(" ").append(lllllllllllllllllIlIIlIIlllIIIlI.getByte("Flight"))));
                }
                final NBTTagList lllllllllllllllllIlIIlIIlllIIIIl = lllllllllllllllllIlIIlIIlllIIIlI.getTagList("Explosions", 10);
                if (lllllllllllllllllIlIIlIIlllIIIIl != null && lllllllllllllllllIlIIlIIlllIIIIl.tagCount() > 0) {
                    for (int lllllllllllllllllIlIIlIIlllIIIII = 0; lllllllllllllllllIlIIlIIlllIIIII < lllllllllllllllllIlIIlIIlllIIIIl.tagCount(); ++lllllllllllllllllIlIIlIIlllIIIII) {
                        final NBTTagCompound lllllllllllllllllIlIIlIIllIlllll = lllllllllllllllllIlIIlIIlllIIIIl.getCompoundTagAt(lllllllllllllllllIlIIlIIlllIIIII);
                        final ArrayList lllllllllllllllllIlIIlIIllIllllI = Lists.newArrayList();
                        ItemFireworkCharge.func_150902_a(lllllllllllllllllIlIIlIIllIlllll, lllllllllllllllllIlIIlIIllIllllI);
                        if (lllllllllllllllllIlIIlIIllIllllI.size() > 0) {
                            for (int lllllllllllllllllIlIIlIIllIlllIl = 1; lllllllllllllllllIlIIlIIllIlllIl < lllllllllllllllllIlIIlIIllIllllI.size(); ++lllllllllllllllllIlIIlIIllIlllIl) {
                                lllllllllllllllllIlIIlIIllIllllI.set(lllllllllllllllllIlIIlIIllIlllIl, String.valueOf(new StringBuilder("  ").append(lllllllllllllllllIlIIlIIllIllllI.get(lllllllllllllllllIlIIlIIllIlllIl))));
                            }
                            lllllllllllllllllIlIIlIIllIllIll.addAll(lllllllllllllllllIlIIlIIllIllllI);
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public boolean onItemUse(final ItemStack lllllllllllllllllIlIIlIIllllIlll, final EntityPlayer lllllllllllllllllIlIIlIIllllllll, final World lllllllllllllllllIlIIlIIlllllllI, final BlockPos lllllllllllllllllIlIIlIIllllllIl, final EnumFacing lllllllllllllllllIlIIlIIllllllII, final float lllllllllllllllllIlIIlIIlllllIll, final float lllllllllllllllllIlIIlIIllllIIlI, final float lllllllllllllllllIlIIlIIlllllIIl) {
        if (!lllllllllllllllllIlIIlIIlllllllI.isRemote) {
            final EntityFireworkRocket lllllllllllllllllIlIIlIIlllllIII = new EntityFireworkRocket(lllllllllllllllllIlIIlIIlllllllI, lllllllllllllllllIlIIlIIllllllIl.getX() + lllllllllllllllllIlIIlIIlllllIll, lllllllllllllllllIlIIlIIllllllIl.getY() + lllllllllllllllllIlIIlIIllllIIlI, lllllllllllllllllIlIIlIIllllllIl.getZ() + lllllllllllllllllIlIIlIIlllllIIl, lllllllllllllllllIlIIlIIllllIlll);
            lllllllllllllllllIlIIlIIlllllllI.spawnEntityInWorld(lllllllllllllllllIlIIlIIlllllIII);
            if (!lllllllllllllllllIlIIlIIllllllll.capabilities.isCreativeMode) {
                --lllllllllllllllllIlIIlIIllllIlll.stackSize;
            }
            return true;
        }
        return false;
    }
}
