package net.minecraft.util;

import net.minecraft.item.*;
import net.minecraft.inventory.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.tileentity.*;

public class WeightedRandomChestContent extends WeightedRandom.Item
{
    private /* synthetic */ int theMaximumChanceToGenerateItem;
    private /* synthetic */ ItemStack theItemId;
    private /* synthetic */ int theMinimumChanceToGenerateItem;
    
    public WeightedRandomChestContent(final net.minecraft.item.Item llllllllllllllIIlIIllllIIlIlIlIl, final int llllllllllllllIIlIIllllIIlIIllII, final int llllllllllllllIIlIIllllIIlIIlIlI, final int llllllllllllllIIlIIllllIIlIIlIIl, final int llllllllllllllIIlIIllllIIlIIlIII) {
        super(llllllllllllllIIlIIllllIIlIIlIII);
        this.theItemId = new ItemStack(llllllllllllllIIlIIllllIIlIlIlIl, 1, llllllllllllllIIlIIllllIIlIIllII);
        this.theMinimumChanceToGenerateItem = llllllllllllllIIlIIllllIIlIIlIlI;
        this.theMaximumChanceToGenerateItem = llllllllllllllIIlIIllllIIlIIlIIl;
    }
    
    public static void generateChestContents(final Random llllllllllllllIIlIIllllIIIIlllIl, final List llllllllllllllIIlIIllllIIIlIIllI, final IInventory llllllllllllllIIlIIllllIIIIllIll, final int llllllllllllllIIlIIllllIIIlIIlII) {
        for (int llllllllllllllIIlIIllllIIIlIIIll = 0; llllllllllllllIIlIIllllIIIlIIIll < llllllllllllllIIlIIllllIIIlIIlII; ++llllllllllllllIIlIIllllIIIlIIIll) {
            final WeightedRandomChestContent llllllllllllllIIlIIllllIIIlIIIlI = (WeightedRandomChestContent)WeightedRandom.getRandomItem(llllllllllllllIIlIIllllIIIIlllIl, llllllllllllllIIlIIllllIIIlIIllI);
            final int llllllllllllllIIlIIllllIIIlIIIIl = llllllllllllllIIlIIllllIIIlIIIlI.theMinimumChanceToGenerateItem + llllllllllllllIIlIIllllIIIIlllIl.nextInt(llllllllllllllIIlIIllllIIIlIIIlI.theMaximumChanceToGenerateItem - llllllllllllllIIlIIllllIIIlIIIlI.theMinimumChanceToGenerateItem + 1);
            if (llllllllllllllIIlIIllllIIIlIIIlI.theItemId.getMaxStackSize() >= llllllllllllllIIlIIllllIIIlIIIIl) {
                final ItemStack llllllllllllllIIlIIllllIIIlIIIII = llllllllllllllIIlIIllllIIIlIIIlI.theItemId.copy();
                llllllllllllllIIlIIllllIIIlIIIII.stackSize = llllllllllllllIIlIIllllIIIlIIIIl;
                llllllllllllllIIlIIllllIIIIllIll.setInventorySlotContents(llllllllllllllIIlIIllllIIIIlllIl.nextInt(llllllllllllllIIlIIllllIIIIllIll.getSizeInventory()), llllllllllllllIIlIIllllIIIlIIIII);
            }
            else {
                for (int llllllllllllllIIlIIllllIIIIlllll = 0; llllllllllllllIIlIIllllIIIIlllll < llllllllllllllIIlIIllllIIIlIIIIl; ++llllllllllllllIIlIIllllIIIIlllll) {
                    final ItemStack llllllllllllllIIlIIllllIIIIllllI = llllllllllllllIIlIIllllIIIlIIIlI.theItemId.copy();
                    llllllllllllllIIlIIllllIIIIllllI.stackSize = 1;
                    llllllllllllllIIlIIllllIIIIllIll.setInventorySlotContents(llllllllllllllIIlIIllllIIIIlllIl.nextInt(llllllllllllllIIlIIllllIIIIllIll.getSizeInventory()), llllllllllllllIIlIIllllIIIIllllI);
                }
            }
        }
    }
    
    public static List func_177629_a(final List llllllllllllllIIlIIlllIlllllIIlI, final WeightedRandomChestContent... llllllllllllllIIlIIlllIlllllIlII) {
        final ArrayList llllllllllllllIIlIIlllIlllllIIll = Lists.newArrayList((Iterable)llllllllllllllIIlIIlllIlllllIIlI);
        Collections.addAll(llllllllllllllIIlIIlllIlllllIIll, llllllllllllllIIlIIlllIlllllIlII);
        return llllllllllllllIIlIIlllIlllllIIll;
    }
    
    public WeightedRandomChestContent(final ItemStack llllllllllllllIIlIIllllIIIllIlII, final int llllllllllllllIIlIIllllIIIllIIll, final int llllllllllllllIIlIIllllIIIllIIlI, final int llllllllllllllIIlIIllllIIIllIIIl) {
        super(llllllllllllllIIlIIllllIIIllIIIl);
        this.theItemId = llllllllllllllIIlIIllllIIIllIlII;
        this.theMinimumChanceToGenerateItem = llllllllllllllIIlIIllllIIIllIIll;
        this.theMaximumChanceToGenerateItem = llllllllllllllIIlIIllllIIIllIIlI;
    }
    
    static {
        __OBFID = "CL_00001505";
    }
    
    public static void func_177631_a(final Random llllllllllllllIIlIIllllIIIIIIIIl, final List llllllllllllllIIlIIllllIIIIIIIII, final TileEntityDispenser llllllllllllllIIlIIllllIIIIIlIIl, final int llllllllllllllIIlIIlllIllllllllI) {
        for (int llllllllllllllIIlIIllllIIIIIIlll = 0; llllllllllllllIIlIIllllIIIIIIlll < llllllllllllllIIlIIlllIllllllllI; ++llllllllllllllIIlIIllllIIIIIIlll) {
            final WeightedRandomChestContent llllllllllllllIIlIIllllIIIIIIllI = (WeightedRandomChestContent)WeightedRandom.getRandomItem(llllllllllllllIIlIIllllIIIIIIIIl, llllllllllllllIIlIIllllIIIIIIIII);
            final int llllllllllllllIIlIIllllIIIIIIlIl = llllllllllllllIIlIIllllIIIIIIllI.theMinimumChanceToGenerateItem + llllllllllllllIIlIIllllIIIIIIIIl.nextInt(llllllllllllllIIlIIllllIIIIIIllI.theMaximumChanceToGenerateItem - llllllllllllllIIlIIllllIIIIIIllI.theMinimumChanceToGenerateItem + 1);
            if (llllllllllllllIIlIIllllIIIIIIllI.theItemId.getMaxStackSize() >= llllllllllllllIIlIIllllIIIIIIlIl) {
                final ItemStack llllllllllllllIIlIIllllIIIIIIlII = llllllllllllllIIlIIllllIIIIIIllI.theItemId.copy();
                llllllllllllllIIlIIllllIIIIIIlII.stackSize = llllllllllllllIIlIIllllIIIIIIlIl;
                llllllllllllllIIlIIllllIIIIIlIIl.setInventorySlotContents(llllllllllllllIIlIIllllIIIIIIIIl.nextInt(llllllllllllllIIlIIllllIIIIIlIIl.getSizeInventory()), llllllllllllllIIlIIllllIIIIIIlII);
            }
            else {
                for (int llllllllllllllIIlIIllllIIIIIIIll = 0; llllllllllllllIIlIIllllIIIIIIIll < llllllllllllllIIlIIllllIIIIIIlIl; ++llllllllllllllIIlIIllllIIIIIIIll) {
                    final ItemStack llllllllllllllIIlIIllllIIIIIIIlI = llllllllllllllIIlIIllllIIIIIIllI.theItemId.copy();
                    llllllllllllllIIlIIllllIIIIIIIlI.stackSize = 1;
                    llllllllllllllIIlIIllllIIIIIlIIl.setInventorySlotContents(llllllllllllllIIlIIllllIIIIIIIIl.nextInt(llllllllllllllIIlIIllllIIIIIlIIl.getSizeInventory()), llllllllllllllIIlIIllllIIIIIIIlI);
                }
            }
        }
    }
}
